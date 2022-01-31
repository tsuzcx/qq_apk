package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.StatFs;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.stt.SttManager.ISttListener;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.QfavMicroPhoneDialog;
import java.io.File;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import vdf;
import vdg;
import vdh;

public class PttItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, CustomizeStrategyFactory.OnCustomizeListener, FileTransferManager.Callback, MediaPlayerManager.Callback, SttManager.ISttListener
{
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SttManager jdField_a_of_type_ComTencentMobileqqSttSttManager;
  private SpannableString b;
  
  public PttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager = ((SttManager)paramQQAppInterface.getManager(16));
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public static int a(Context paramContext, int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    int i = Math.min(60, Math.max(1, paramInt1));
    int j;
    float f1;
    if (i > 40)
    {
      i += 40;
      j = AIOUtils.a(i + 20, paramContext.getResources());
      if ((paramString == null) || (paramPaint == null)) {
        break label173;
      }
      i = BaseChatItemLayout.e - BaseChatItemLayout.i - BaseChatItemLayout.j - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= i) {
        break label176;
      }
      f1 = i;
    }
    label173:
    label176:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int k = AIOUtils.a(f2, paramContext.getResources());
        paramInt2 = j + k;
        paramInt1 = paramInt2;
        if (paramInt2 > i) {
          paramInt1 = i;
        }
        return Math.max(paramInt1, (int)f1) - k;
        i *= 2;
        break;
      }
      if (paramInt1 > 9) {}
      for (paramInt1 = 34;; paramInt1 = 30)
      {
        f2 = paramInt1;
        break;
      }
      return j;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    int j = 999;
    int k = 1005;
    if (paramMessageForPtt == null) {
      return 0;
    }
    int i;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.aI))) {
        if (paramMessageForPtt.fileSize > 0L) {
          i = 1003;
        }
      }
    }
    for (;;)
    {
      return i;
      i = k;
      if (paramMessageForPtt.fileSize != -1L) {
        if (paramMessageForPtt.fileSize == -2L)
        {
          if (a(paramMessageForPtt))
          {
            i = 999;
          }
          else
          {
            paramMessageForPtt.fileSize = -1L;
            i = k;
          }
        }
        else
        {
          if (paramMessageForPtt.fileSize == -3L)
          {
            k = paramQQAppInterface.a().b(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
            if ((k == 1005) || (k == -1))
            {
              paramMessageForPtt.fileSize = -1L;
              i = 1005;
            }
            for (;;)
            {
              break;
              i = j;
              if (k != 7000) {
                i = 1001;
              }
            }
          }
          i = paramQQAppInterface.a().b(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
          continue;
          i = 1004;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "handlePttItem recieve friendUin " + paramMessageForPtt.frienduin + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
          }
          if (paramMessageForPtt != null)
          {
            j = PTTPreDownloader.a(paramQQAppInterface, paramMessageForPtt);
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + j + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
              i = j;
            }
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 120;
    paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "key = " + paramString + ", time = " + paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {}
    do
    {
      do
      {
        do
        {
          try
          {
            i = Integer.valueOf(paramQQAppInterface).intValue();
            if (i > 0) {
              return i;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PttItemBuilder", 2, paramQQAppInterface.toString());
            }
          }
          i = j;
        } while ("ConvertText_MaxPtt".equals(paramString));
        i = j;
      } while ("Normal_MaxPtt".equals(paramString));
      if ("VIP_MaxPtt".equals(paramString)) {
        return 180;
      }
      int i = j;
    } while (!"SVIP_MaxPtt".equals(paramString));
    return 300;
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    int i = paramInt / 60;
    if (i > 0) {
      str = i + "'";
    }
    return str + paramInt % 60 + "\"";
  }
  
  private void a(PttItemBuilder.Holder paramHolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130843927);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      do
      {
        return;
        localObject = ((Resources)localObject).getDrawable(2130843925);
      } while (localObject == null);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      return;
    }
    paramHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  public static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = b(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (AppSetting.jdField_b_of_type_Boolean) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PttItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出语音按钮";
    }
    return "发来语音按钮";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
  }
  
  @TargetApi(11)
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForPtt))) {}
    MessageForPtt localMessageForPtt;
    label173:
    label329:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localMessageForPtt = (MessageForPtt)paramChatMessage;
            if (2131366776 != paramInt) {
              break;
            }
            paramInt = QQRecorder.a(localMessageForPtt);
          } while (paramInt <= 0);
          QfavMicroPhoneDialog localQfavMicroPhoneDialog = new QfavMicroPhoneDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt.voiceType, new vdf(this, localMessageForPtt));
          if (localMessageForPtt.isSend())
          {
            paramChatMessage = localMessageForPtt.selfuin;
            paramContext = null;
            if (AnonymousChatHelper.a(localMessageForPtt)) {
              paramContext = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841252);
            }
            Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramChatMessage);
            paramChatMessage = localBitmap;
            if (localBitmap == null) {
              paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, localMessageForPtt.frienduin);
            }
            if (!localQfavMicroPhoneDialog.a(localMessageForPtt.getLocalFilePath(), paramInt, paramChatMessage, paramContext)) {
              break label173;
            }
            localQfavMicroPhoneDialog.show();
          }
          for (;;)
          {
            PttInfoCollector.a(1);
            return;
            paramChatMessage = localMessageForPtt.senderuin;
            break;
            QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131431580, 1);
          }
          if (paramInt == 2131375567)
          {
            ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
            PttInfoCollector.a(2);
            return;
          }
          if (paramInt == 2131375577)
          {
            PttInfoCollector.a(6);
            super.c(paramChatMessage);
            return;
          }
          if (paramInt == 2131375573)
          {
            if (TextUtils.isEmpty(localMessageForPtt.sttText))
            {
              paramContext = this.jdField_a_of_type_AndroidContentContext.getString(2131433790);
              PttInfoCollector.a(3);
            }
            for (;;)
            {
              try
              {
                if (Build.VERSION.SDK_INT >= 11) {
                  break label329;
                }
                ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
                return;
              }
              catch (Exception paramContext)
              {
                return;
              }
              paramContext = localMessageForPtt.sttText;
              break;
              ((android.content.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", paramContext));
            }
          }
          if (paramInt == 2131363517)
          {
            PttInfoCollector.a(4);
            if ((localMessageForPtt.sttText != null) && (localMessageForPtt.sttText.length() > 0))
            {
              paramContext = new Bundle();
              paramContext.putInt("forward_type", -1);
              paramContext.putString("forward_text", localMessageForPtt.sttText);
              paramChatMessage = new Intent();
              paramChatMessage.putExtras(paramContext);
              ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
              return;
            }
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, "语音消息无文本内容", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
            return;
          }
          if (paramInt != 2131375574) {
            break;
          }
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(localMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.delmsg", 2, "pos is:" + paramInt);
          }
        } while (paramInt < 0);
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt - i);
      } while (paramContext == null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
      paramContext = (PttItemBuilder.Holder)paramContext.getTag();
      PttInfoCollector.a(5);
      if (localMessageForPtt.sttAbility == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(localMessageForPtt);
        this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(this);
        a(paramContext, localMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt), c(localMessageForPtt));
        return;
      }
    } while ((localMessageForPtt.sttAbility != 2) || (localMessageForPtt.expandStt));
    localMessageForPtt.expandStt = true;
    localMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
    a(paramContext, localMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt), c(localMessageForPtt));
    a(paramContext, paramContext.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForPtt, paramContext.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
    return;
    if (paramInt == 2131361906)
    {
      if (c(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(2131433636);
      paramView.b(2131433635);
      paramView.c(2131433015);
      paramView.a(new vdh(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131433439, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131433440, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
      return;
    }
    a(paramView, localMessageForPtt, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("PTTItem->onErrorIconClick", 2, "fileStatus:2001|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
    }
    a(paramView, localMessageForPtt, 2001, false);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return;
        paramView = (PttItemBuilder.Holder)((View)paramView.getParent().getParent()).getTag();
      } while (paramView == null);
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    Object localObject = (MessageForPtt)paramChatMessage;
    if (paramInt == 889) {
      paramInt = 1;
    }
    for (;;)
    {
      if ((paramInt != 0) && (paramView != null))
      {
        localObject = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
        paramView = (BaseChatItemLayout)paramView;
        b(paramChatMessage, (BaseBubbleBuilder.ViewHolder)localObject, ((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_AndroidViewView, paramView, null);
      }
      return;
      super.a(paramView, paramChatMessage, paramInt);
      if (((MessageForPtt)localObject).voiceChangeFlag != 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.jdField_b_of_type_Int != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramFileMsg.jdField_b_of_type_Long));
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramFileMsg.jdField_b_of_type_Boolean)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          b();
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + paramInt2 + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, paramInt2, c(localMessageForPtt));
      return;
      if ((paramFileMsg.d == 1005) || (paramFileMsg.d == 1004))
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        paramInt2 = paramInt1;
      }
      else if (localMessageForPtt.fileSize == -2L)
      {
        paramInt2 = 999;
      }
      else if (localMessageForPtt.fileSize == -3L)
      {
        paramInt2 = 1001;
      }
      else if (localMessageForPtt.fileSize == -1L)
      {
        paramInt2 = 1005;
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2005)
        {
          localMessageForPtt.fileSize = -4L;
          paramInt2 = paramInt1;
        }
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = (PttItemBuilder.Holder)((View)paramView.getParent().getParent()).getTag();
    Drawable localDrawable;
    if (paramView != null)
    {
      localDrawable = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
      if (localDrawable != null) {
        if (!paramBoolean) {
          break label54;
        }
      }
    }
    label54:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramViewHolder = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramViewHolder.getColorStateList(2131494230);
        if ((localHolder.jdField_c_of_type_AndroidWidgetTextView != null) && (paramViewHolder != null)) {
          localHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
        if ((localHolder.jdField_d_of_type_AndroidWidgetTextView != null) && (paramViewHolder != null)) {
          localHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
      }
    }
    for (;;)
    {
      return;
      paramViewHolder = paramViewHolder.getColorStateList(2131494227);
      break;
      if (paramBubbleInfo.jdField_b_of_type_Int == 0)
      {
        localHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (localHolder.jdField_d_of_type_AndroidWidgetTextView != null) {
          localHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        }
      }
      while ((paramBubbleInfo.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHolder.jdField_c_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) == 1))
      {
        float f2 = localHolder.jdField_c_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        localHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
        localHolder.jdField_c_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.d);
        return;
        localHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        if (localHolder.jdField_d_of_type_AndroidWidgetTextView != null) {
          localHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    int m = 0;
    int i = 0;
    int i1 = 0;
    String str = "";
    localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    if (paramHolder.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
      paramHolder.e.setVisibility(8);
    }
    if (paramHolder.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramHolder.f.setVisibility(8);
      paramHolder.g.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    Object localObject5 = this.jdField_a_of_type_AndroidContentContext.getResources();
    boolean bool2 = a(paramMessageForPtt, paramHolder);
    boolean bool1;
    boolean bool3;
    int n;
    int k;
    int j;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      bool1 = true;
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramHolder, paramMessageForPtt);
      n = 0;
      k = 0;
      j = 0;
      switch (paramInt)
      {
      default: 
        localObject3 = str;
        k = i1;
        i = k;
        paramInt = j;
        localObject1 = localObject2;
        localObject2 = localObject3;
        label451:
        j = i;
        if (paramMessageForPtt.sttAbility == 1)
        {
          j = i;
          if (this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(paramMessageForPtt)) {
            j = 4;
          }
        }
        switch (j)
        {
        case 2: 
        case 3: 
        default: 
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView != null) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          }
          label542:
          if (bool2)
          {
            paramMessageForPtt = (QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(244);
            if (paramMessageForPtt == null) {
              break label3020;
            }
            paramMessageForPtt = paramMessageForPtt.a("voice_pwd", "低版本无语音评级", new String[] { "lowTipStr" });
            label586:
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
          }
          if (AppSetting.jdField_b_of_type_Boolean)
          {
            if (paramInt == 0) {
              break label3027;
            }
            paramHolder.jdField_a_of_type_AndroidViewViewGroup.setContentDescription("语音" + (String)localObject2 + "秒,未播放");
            label640:
            if (paramHolder.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              paramHolder.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject2);
              if (localObject1 != null) {
                paramHolder.jdField_a_of_type_JavaLangStringBuilder.append(" ").append((String)localObject1);
              }
            }
          }
          break;
        }
        break;
      }
    }
    do
    {
      return;
      bool1 = false;
      break;
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject5), BaseChatItemLayout.l, AIOUtils.a(10.0F, (Resources)localObject5), BaseChatItemLayout.m);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(paramHolder, bool3, bool1, paramMessageForPtt.isSend());
      i = 1;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      a(paramMessageForPtt, bool1, paramHolder);
      localObject2 = "";
      paramInt = n;
      break label451;
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(40.0F, (Resources)localObject5), BaseChatItemLayout.l, AIOUtils.a(40.0F, (Resources)localObject5), BaseChatItemLayout.m);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
      localObject2 = "";
      paramInt = n;
      i = m;
      break label451;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength > 0) {
        break label1029;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "get a amr file length = 0 return now");
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject5), BaseChatItemLayout.l, AIOUtils.a(10.0F, (Resources)localObject5), BaseChatItemLayout.m);
    } while (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label1029:
    localObject1 = localObject3;
    if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt"))
    {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject5).getDrawable(2130839645);
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
        localObject1 = "QQ会员专享长语音";
      }
    }
    else
    {
      label1154:
      if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
        paramMessageForPtt.sttAbility = 0;
      }
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
      }
      str = paramMessageForPtt.timeStr;
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      a(paramHolder, bool3, bool1, paramMessageForPtt.isSend());
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      a(paramMessageForPtt, paramBoolean, bool3, bool1, paramHolder);
      if (!paramMessageForPtt.isSend()) {
        break label1923;
      }
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        localObject2 = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1909;
        }
      }
      label1311:
      if ((paramInt != 2003) && (paramInt != 1003)) {
        break label1968;
      }
      if ((paramMessageForPtt.isSend()) || (paramMessageForPtt.isReadPtt)) {
        break label3070;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
    }
    label1377:
    label1909:
    label3070:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt)) {
        j = 2;
      }
      for (;;)
      {
        k = AIOUtils.a(9.0F, (Resources)localObject5);
        m = AIOUtils.a(12.0F, (Resources)localObject5);
        n = ((Resources)localObject5).getDrawable(2130842205).getIntrinsicHeight();
        i1 = AIOUtils.a(1.0F, (Resources)localObject5);
        Object localObject4;
        if (j == 1)
        {
          m = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, null, null, 0);
          if (paramMessageForPtt.isSend())
          {
            paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
            localObject2 = paramHolder.jdField_c_of_type_AndroidWidgetTextView;
            n = BaseChatItemLayout.l;
            if (bool3)
            {
              j = k;
              ((TextView)localObject2).setPadding(0, n, j, BaseChatItemLayout.m);
              localObject4 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, k + m, paramHolder);
              localObject2 = localObject1;
              j = paramInt;
              k = i;
              localObject3 = str;
              if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null) {
                break;
              }
              localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject2).width = (localObject4[0] + localObject4[1] + localObject4[2]);
              ((RelativeLayout.LayoutParams)localObject2).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, paramHolder);
              if (QLog.isColorLevel()) {
                QLog.d("PttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject2).width + ", flagTimeContainer.getLeft()=" + paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLeft());
              }
              if ((!bool3) || (((RelativeLayout.LayoutParams)localObject2).height <= 0)) {
                break label2895;
              }
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
              localObject5 = paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
              if ((((BubbleInfo.CommonAttrs)((Pair)localObject5).first).a != null) && (((BubbleInfo.CommonAttrs)((Pair)localObject5).first).a.length > 0))
              {
                localObject3 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
                localObject5 = (BubbleInfo.CommonAttrs)((Pair)localObject5).first;
                j = localObject4[0];
                k = ((RelativeLayout.LayoutParams)localObject2).height;
                m = localObject4[1];
                n = localObject4[2];
                if (paramMessageForPtt.isSend()) {
                  break label2878;
                }
                bool1 = true;
                ((VoicePrintUtils.VoicePrintView)localObject3).setBitmap((BubbleInfo.CommonAttrs)localObject5, j, k, m, n, bool1);
                if (!paramBoolean) {
                  break label2884;
                }
                paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = str;
          break;
          localObject1 = localObject3;
          if (paramMessageForPtt.longPttVipFlag != 2) {
            break label1154;
          }
          if (this.b == null)
          {
            this.b = new SpannableString("[v] 超级会员专享长语音");
            localObject1 = ((Resources)localObject5).getDrawable(2130839644);
            ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
            localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
            this.b.setSpan(localObject1, 0, 3, 17);
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
          localObject1 = "超级会员专享长语音";
          break label1154;
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
          break label1311;
          localObject2 = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1311;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject2, null);
          break label1311;
          if ((paramInt == 1005) || (paramInt == 1004))
          {
            i = 1;
            j = 1;
            paramInt = k;
            break label1377;
          }
          i = 4;
          j = 1;
          paramInt = k;
          break label1377;
          j = BaseChatItemLayout.q;
          break label1479;
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
          localObject2 = paramHolder.jdField_c_of_type_AndroidWidgetTextView;
          if (bool3) {}
          for (j = k;; j = BaseChatItemLayout.q)
          {
            ((TextView)localObject2).setPadding(j, BaseChatItemLayout.l, 0, BaseChatItemLayout.m);
            break;
          }
          if (paramHolder.jdField_d_of_type_AndroidWidgetTextView == null)
          {
            localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject3).setImageDrawable(new ColorDrawable(838860800));
            localObject4 = new RelativeLayout.LayoutParams(-1, i1);
            ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            ((ImageView)localObject3).setId(2131362006);
            TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
            if (paramMessageForPtt.isSend())
            {
              localObject2 = ((Resources)localObject5).getColorStateList(2131494230);
              if (localObject2 != null) {
                localTextView.setTextColor((ColorStateList)localObject2);
              }
              localTextView.setId(2131362005);
              localObject2 = new RelativeLayout.LayoutParams(-2, -2);
              localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
              RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
              localImageView.setLayoutParams(localLayoutParams);
              localImageView.setImageResource(2130842205);
              localImageView.setScaleType(ImageView.ScaleType.FIT_END);
              ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131362002);
              ((RelativeLayout.LayoutParams)localObject4).addRule(14);
              ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131362006);
              localLayoutParams.addRule(3, 2131362006);
              localLayoutParams.addRule(14);
              localLayoutParams.addRule(6, 2131362005);
              localLayoutParams.addRule(8, 2131362005);
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localTextView);
              paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
              paramHolder.f = ((ImageView)localObject3);
              paramHolder.jdField_d_of_type_AndroidWidgetTextView = localTextView;
              paramHolder.g = localImageView;
              paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
              paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
              paramHolder.jdField_d_of_type_AndroidWidgetTextView.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
              localObject3 = paramMessageForPtt.sttText;
              localObject2 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433790);
              }
              if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
                this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
              }
              this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
              j = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, (String)localObject2, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0);
              localObject4 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, j + k, paramHolder);
              paramHolder.jdField_d_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
              j = n + AIOUtils.a(22.0F, (Resources)localObject5);
              if (!paramMessageForPtt.isSend()) {
                break label2743;
              }
              localObject2 = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131362002);
              ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131362002);
              localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131362002);
              ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131362002);
              paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
              paramHolder.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.l, BaseChatItemLayout.q, BaseChatItemLayout.m);
              paramHolder.f.setPadding(k, 0, k, 0);
              paramHolder.jdField_d_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.l, k, j);
              paramHolder.g.setPadding(0, 0, 0, m);
            }
          }
          for (;;)
          {
            localObject3 = paramMessageForPtt.sttText;
            localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433790);
            }
            paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            break;
            localObject2 = ((Resources)localObject5).getColorStateList(2131494227);
            break label2158;
            paramHolder.f.setVisibility(0);
            paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            paramHolder.g.setVisibility(0);
            break label2353;
            localObject2 = (RelativeLayout.LayoutParams)paramHolder.f.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131362002);
            ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131362002);
            localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131362002);
            ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131362002);
            paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
            paramHolder.jdField_c_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.q, BaseChatItemLayout.l, 0, BaseChatItemLayout.m);
            paramHolder.f.setPadding(k, 0, k, 0);
            paramHolder.jdField_d_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.l, k, j);
            paramHolder.g.setPadding(0, 0, 0, m);
          }
          bool1 = false;
          break label1760;
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
        localObject2 = localObject1;
        j = paramInt;
        k = i;
        localObject3 = str;
        break;
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        localObject3 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView;
        if (paramMessageForPtt.isSendFromLocal()) {}
        for (paramMessageForPtt = "重新发送语音消息";; paramMessageForPtt = "重新拉取语音消息")
        {
          ((ImageView)localObject3).setContentDescription(paramMessageForPtt);
          break;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130838600, null);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.getDrawable()).start();
        break label542;
        paramMessageForPtt = "低版本无语音评级";
        break label586;
        paramHolder.jdField_a_of_type_AndroidViewViewGroup.setContentDescription("语音" + (String)localObject2 + "秒");
        break label640;
        j = 1;
      }
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      if (paramBoolean1) {
        i = 2;
      }
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;; j = 0)
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, i, j, paramBoolean2);
      return;
      i = 1;
      break;
      i = 5;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, PttItemBuilder.Holder paramHolder)
  {
    this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramMessageForPtt.isSend())
    {
      if (d(paramMessageForPtt))
      {
        paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
        if (paramBoolean) {}
        for (i = 2130843923;; i = 2130843926)
        {
          paramMessageForPtt.setImageResource(i);
          return;
        }
      }
      paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130845771;; i = 2130845772)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    if (d(paramMessageForPtt))
    {
      paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130843917;; i = 2130843924)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 2130845765;; i = 2130845764)
    {
      paramMessageForPtt.setImageResource(i);
      return;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PttItemBuilder.Holder paramHolder)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if ((paramBoolean1) && (!paramBoolean2))
    {
      int i;
      if (paramMessageForPtt.isSend()) {
        if (d(paramMessageForPtt)) {
          if (paramBoolean3) {
            i = 2131034352;
          }
        }
      }
      for (;;)
      {
        paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForPtt);
        paramMessageForPtt.start();
        return;
        i = 2131034351;
        continue;
        if (paramBoolean3)
        {
          i = 2131034207;
        }
        else
        {
          i = 2131034206;
          continue;
          if (d(paramMessageForPtt))
          {
            if (paramBoolean3) {
              i = 2131034350;
            } else {
              i = 2131034349;
            }
          }
          else if (paramBoolean3) {
            i = 2131034417;
          } else {
            i = 2131034416;
          }
        }
      }
    }
    a(paramMessageForPtt, paramBoolean3, paramHolder);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        Message localMessage = new Message();
        localMessage.what = 78;
        localMessage.arg1 = 889;
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramMessageRecord.uniseq);
        localMessage.setData(localBundle);
        localMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView), false);
        c();
      }
    }
  }
  
  public void a(boolean paramBoolean, MessageForPtt paramMessageForPtt)
  {
    if (!paramBoolean) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "转文字失败，请稍候重试", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, BaseBubbleBuilder.ViewHolder paramViewHolder, MessageForPtt paramMessageForPtt)
  {
    return VoicePrintUtils.a(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseAdapter, paramViewHolder, paramMessageForPtt);
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt, PttItemBuilder.Holder paramHolder)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    int j = 0;
    label69:
    Object localObject;
    if (paramMessageForPtt.voiceRedPacketFlag != 0)
    {
      paramHolder.b.setVisibility(0);
      if (d(paramMessageForPtt))
      {
        paramHolder.b.setImageResource(2130844147);
        if (!paramMessageForPtt.isSend()) {
          break label294;
        }
        paramHolder.b.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, 0, 0);
        if (!CustomizeStrategyFactory.a().a()) {
          break label453;
        }
        localObject = (QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(244);
        if (localObject == null) {
          break label317;
        }
        i = ((QWalletConfigManager)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
        label118:
        if (i != 1) {
          break label460;
        }
        String str = paramMessageForPtt.getExtInfoFromExtStr("voice_score_id");
        if (TextUtils.isEmpty(str)) {
          break label322;
        }
        localObject = new CustomizeStrategyFactory.RedPacketInfo();
        ((CustomizeStrategyFactory.RedPacketInfo)localObject).a = paramMessageForPtt;
        ((CustomizeStrategyFactory.RedPacketInfo)localObject).type = 6;
        ((CustomizeStrategyFactory.RedPacketInfo)localObject).templateId = str;
        paramMessageForPtt = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (CustomizeStrategyFactory.RedPacketInfo)localObject, this);
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "redPacketInfo.icon = " + paramMessageForPtt.icon);
        }
        if (paramMessageForPtt.icon == null) {
          break label513;
        }
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramMessageForPtt.icon);
      }
    }
    label513:
    for (int i = 1;; i = 0)
    {
      bool1 = false;
      for (;;)
      {
        label241:
        paramMessageForPtt = paramHolder.jdField_c_of_type_AndroidWidgetImageView;
        if (i != 0)
        {
          i = j;
          label253:
          paramMessageForPtt.setVisibility(i);
        }
        label294:
        label317:
        label322:
        label453:
        label460:
        do
        {
          for (;;)
          {
            return bool1;
            if (paramMessageForPtt.isSend())
            {
              paramHolder.b.setImageResource(2130844148);
              break;
            }
            paramHolder.b.setImageResource(2130844146);
            break;
            paramHolder.b.setPadding(0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
            break label69;
            i = 1;
            break label118;
            try
            {
              i = Integer.parseInt(paramMessageForPtt.getExtInfoFromExtStr("voice_low_tips_tag"));
              if (i == 1)
              {
                bool1 = true;
                if (bool1) {
                  break label508;
                }
                i = ((QWalletConfigManager)localObject).a("voice_pwd", 5, new String[] { "lowTipsLimit" });
                int k = QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", 0);
                if (k >= i) {
                  break label508;
                }
                paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
                ThreadManager.post(new vdg(this, paramMessageForPtt), 10, null, false);
                QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", k + 1);
                i = 0;
                bool1 = bool2;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                i = 0;
                continue;
                bool1 = false;
              }
            }
          }
          CustomizeStrategyFactory.a().b(true);
          i = 0;
          bool1 = false;
          break label241;
          i = 8;
          break label253;
          if (paramHolder.b != null) {
            paramHolder.b.setVisibility(8);
          }
        } while (paramHolder.jdField_c_of_type_AndroidWidgetImageView == null);
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        return false;
        label508:
        i = 0;
      }
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (!(paramView instanceof PttItemBuilder.Holder)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
        return false;
      }
      paramView = (PttItemBuilder.Holder)paramView;
      if (paramAudioPlayer.a(paramXListView.getLocalFilePath()))
      {
        a(paramXListView);
        if (paramView != null)
        {
          a(paramView, paramXListView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, paramXListView, paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo, 0);
        }
        PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView.istroop, paramXListView.issend);
        if (!paramXListView.isSendFromLocal())
        {
          if (paramXListView.istroop != 0) {
            break label193;
          }
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      paramXListView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramChatMessage.getPttStreamFlag() == 10001) {}
      for (boolean bool = true;; bool = false)
      {
        PttInfoCollector.a(paramXListView, paramInt, bool, 1);
        return true;
        label193:
        if (paramXListView.istroop == 1)
        {
          paramInt = 3;
          break;
        }
        if (paramXListView.istroop != 3000) {
          break label301;
        }
        paramInt = 2;
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "play failed player return false " + paramXListView.getLocalFilePath());
      return false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "play failed not ready " + paramXListView.getLocalFilePath());
      return false;
      label301:
      paramInt = 4;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (MessageForPtt)AIOUtils.a(paramView);
    if (ConfessMsgUtil.a(paramView)) {
      return localQQCustomMenu.a();
    }
    if (!paramView.isReady())
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
    }
    if (QQRecorder.a(paramView) <= 0)
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
    }
    if (paramView.voiceChangeFlag != 1)
    {
      if (paramView.sttAbility != 1) {
        break label308;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(paramView)) && ((!paramView.isSend()) || (paramView.fileSize > 0L)) && (paramView.voiceRedPacketFlag == 0)) {
        localQQCustomMenu.a(2131375574, this.jdField_a_of_type_AndroidContentContext.getString(2131438105), 2130838304);
      }
    }
    for (;;)
    {
      a(paramView, localQQCustomMenu);
      localQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433025));
      localQQCustomMenu.a(2131366776, this.jdField_a_of_type_AndroidContentContext.getString(2131431563), 2130838312);
      if (((paramView.extraflag != 32768) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView) == 1003) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) || (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
      label308:
      if (paramView.sttAbility == 2) {
        if (paramView.expandStt)
        {
          localQQCustomMenu.a(2131375573, this.jdField_a_of_type_AndroidContentContext.getString(2131433719), 2130838307);
          localQQCustomMenu.a(2131363517, this.jdField_a_of_type_AndroidContentContext.getString(2131433720), 2130838313);
        }
        else if (paramView.voiceRedPacketFlag == 0)
        {
          localQQCustomMenu.a(2131375574, this.jdField_a_of_type_AndroidContentContext.getString(2131438105), 2130838304);
        }
      }
    }
  }
  
  public View b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PttItemBuilder.Holder)paramViewHolder;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131361998);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131362000);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131361999);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494227));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.jdField_a_of_type_AndroidContentContext);
      localVoicePrintView.setId(2131362001);
      ImageView localImageView1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView1.setId(2131362008);
      ImageView localImageView2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView2.setId(2131362009);
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(47.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new SyncParentPressedRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131362002);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      ((RelativeLayout)localObject).addView(localVoicePrintView);
      ((RelativeLayout)localObject).addView(localImageView1);
      ((RelativeLayout)localObject).addView(localImageView2);
      paramViewHolder.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramViewHolder;
      paramBaseChatItemLayout.jdField_c_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
      paramBaseChatItemLayout.b = localImageView1;
      paramBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView = localImageView2;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    }
    if (paramOnLongClickAndTouchListener != null) {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBaseChatItemLayout, localMessageForPtt))
    {
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      if (!paramChatMessage.isSend()) {
        break label767;
      }
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131361999);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131362001);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131362009);
      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.addRule(1, 2131362008);
      paramView.setMargins(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt);
      int i = j;
      if (j == -1)
      {
        a(paramBaseChatItemLayout, localMessageForPtt, false, true);
        i = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
      PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localMessageForPtt);
      PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramChatMessage);
      return paramViewHolder;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label767:
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams()).addRule(1, 2131362009);
      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.addRule(1, 2131362001);
      paramView.setMargins(0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131361999);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131362000);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public boolean c(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public void d()
  {
    PttInfoCollector.a(7);
    super.d();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.m = true;
    int i = paramView.getId();
    if ((AppSetting.jdField_b_of_type_Boolean) && (i == 2131361996)) {
      paramView.findViewById(2131362002).performClick();
    }
    PttItemBuilder.Holder localHolder;
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      localHolder = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      localMessageForPtt = (MessageForPtt)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (i == 2131362002)
      {
        if (c(localMessageForPtt)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
        for (;;)
        {
          if (localMessageForPtt.istroop == 1008) {
            PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", localMessageForPtt.timeStr, "", false);
          }
          if (localMessageForPtt.voiceChangeFlag != 1) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + localMessageForPtt.istroop, "", "", "");
          return;
          if ((localMessageForPtt != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (localMessageForPtt.isReady())) {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131433788, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
            } else if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131433789, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
            }
          }
        }
      }
      if (i != 2131362005) {
        break;
      }
    } while (!localMessageForPtt.expandStt);
    localMessageForPtt.expandStt = false;
    localMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
    a(localHolder, localMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt), c(localMessageForPtt));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
    return;
    if (i == 2131361878)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramView.putExtra("url", "http://m.vip.qq.com/freedom/freedom_longvoice.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    super.onClick(paramView);
  }
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
    } while (paramRedPacketInfo.icon == null);
    a(paramRedPacketInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder
 * JD-Core Version:    0.7.0.1
 */