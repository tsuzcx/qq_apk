package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
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
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.audio.AudioSettingManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
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
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.helper.PttSttHelper;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.SelectableComponent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.sonic.SonicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.SliceSttManager;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.stt.SttManager.ISttListener;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.PlayModeUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.QVipConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.QfavMicroPhoneDialog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class PttItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, BaseChatItemLayout.MiniAioShieldItemTouchListener, CustomizeStrategyFactory.OnCustomizeListener, FileTransferManager.Callback, MediaPlayerManager.Callback, PttAudioWaveView.SeekProgressListener, SttManager.ISttListener
{
  protected SpannableString a;
  protected TextView a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected SliceSttManager a;
  protected Map<Long, String> a;
  Set<PttItemBuilder.Holder> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected SpannableString b;
  
  public PttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager = ((SliceSttManager)paramQQAppInterface.getManager(QQManagerFactory.STT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static int a(Context paramContext, int paramInt1, float paramFloat, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt1 = Math.min(60, Math.max(1, paramInt1));
    if (paramInt1 == 1)
    {
      paramInt1 = 25;
      int i = 0;
      if (paramBoolean1) {
        i = 16;
      }
      int j = i;
      if (paramBoolean2) {
        j = i + 38;
      }
      i = paramInt1;
      if (j != 0)
      {
        i = paramInt1;
        if (paramInt1 > 170 - j) {
          i = 170 - j;
        }
      }
      paramInt1 = i;
      if (i % 5 != 0) {
        paramInt1 = i / 5 * 5;
      }
      paramInt1 = AIOUtils.a(paramInt1, paramContext.getResources());
      if (paramFloat <= 0.0F) {
        break label196;
      }
      paramInt1 = Math.max(paramInt1 + AIOUtils.a(paramInt2, paramContext.getResources()) + AIOUtils.a(paramInt3, paramContext.getResources()), (int)paramFloat);
      paramInt3 = BaseChatItemLayout.f - BaseChatItemLayout.j - BaseChatItemLayout.k - 32;
      if (paramInt1 <= paramInt3) {
        break label209;
      }
      paramInt1 = paramInt3;
    }
    label196:
    label209:
    for (;;)
    {
      return paramInt1 - AIOUtils.a(paramInt2 - 40, paramContext.getResources());
      paramInt1 = 15 + (int)(PttAudioWaveView.a(paramInt1, 60, 1.5F) * 125.0F);
      break;
      return paramInt1 + AIOUtils.a(paramInt3, paramContext.getResources());
    }
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
      i = BaseChatItemLayout.f - BaseChatItemLayout.j - BaseChatItemLayout.k - 32;
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
  
  private int a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool2;
    Resources localResources;
    int i;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramHolder, paramMessageForPtt);
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      switch (paramInt)
      {
      default: 
        return 0;
      }
    }
    return 7;
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, localResources), BaseChatItemLayout.m, AIOUtils.a(10.0F, localResources), BaseChatItemLayout.n);
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    a(paramHolder, bool2, bool1, paramMessageForPtt.isSend());
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    return 1;
    ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(40.0F, localResources), BaseChatItemLayout.m, AIOUtils.a(40.0F, localResources), BaseChatItemLayout.n);
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    }
    if (paramInt == 999)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      return 0;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
    return 0;
    return b(paramHolder, paramMessageForPtt, paramInt, paramBoolean, paramString);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    int j = 1005;
    if (paramMessageForPtt == null) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "parsePttStatus  fileSize " + paramMessageForPtt.fileSize + " url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
    }
    int i;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.SDCARD_ROOT)))
      {
        if (paramMessageForPtt.fileSize > 0L) {
          i = 1003;
        }
        for (;;)
        {
          return i;
          i = j;
          if (paramMessageForPtt.fileSize != -1L)
          {
            if (paramMessageForPtt.fileSize != -2L) {
              break;
            }
            if (a(paramMessageForPtt))
            {
              i = 999;
            }
            else
            {
              paramMessageForPtt.fileSize = -1L;
              i = j;
            }
          }
        }
        if (paramMessageForPtt.fileSize == -3L)
        {
          boolean bool = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).containsProcessor(paramMessageForPtt.frienduin, paramMessageForPtt.uniseq);
          i = TransFileControllerBusHelper.findProcessorFileStatus(paramQQAppInterface, paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "parsePttStatus transStatus  " + i + ", hasTransProc " + bool);
          }
          if ((!bool) || (i == 1005))
          {
            paramMessageForPtt.fileSize = -1L;
            i = 1005;
          }
        }
      }
    }
    for (;;)
    {
      break;
      if (i == 7000)
      {
        i = 999;
        continue;
        j = TransFileControllerBusHelper.findProcessorFileStatus(paramQQAppInterface, paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
        i = j;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PttItemBuilder", 2, "parsePttStatus status  " + j);
        i = j;
        break;
        i = 1004;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "handlePttItem recieve friendUin " + paramMessageForPtt.frienduin + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
        }
        if (paramMessageForPtt != null)
        {
          j = PTTPreDownloader.a(paramQQAppInterface, paramMessageForPtt);
          i = j;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + j + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
          i = j;
          break;
        }
        i = 0;
        break;
      }
      i = 1001;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 120;
    paramQQAppInterface = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.common, paramString);
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
  
  public static int a(MessageForPtt paramMessageForPtt, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = (SttManager)paramQQAppInterface.getManager(QQManagerFactory.STT_MANAGER);; paramQQAppInterface = null)
    {
      int i = 0;
      if ((paramInt == 2003) || (paramInt == 1003))
      {
        if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (paramQQAppInterface != null) && (paramQQAppInterface.a(paramMessageForPtt))) {
          paramInt = 5;
        }
        do
        {
          do
          {
            return paramInt;
            paramInt = i;
          } while (paramMessageForPtt.sttAbility != 3);
          paramInt = i;
        } while (!paramMessageForPtt.expandStt);
        return 6;
      }
      if ((paramInt == 1005) || (paramInt == 1004)) {
        return 1;
      }
      return 4;
    }
  }
  
  private CharSequence a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    String str = paramMessageForPtt.sttText;
    Object localObject;
    if (paramInt == 5)
    {
      localObject = a();
      if ((localObject != null) && (paramMessageForPtt.getSttResult().a())) {
        localObject = ((PttSttHelper)localObject).a(paramMessageForPtt);
      }
    }
    do
    {
      return localObject;
      return (CharSequence)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    if (paramMessageForPtt.sttAbility == 3) {
      return "";
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131719547);
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
  
  private String a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    if ((paramInt == 1001) || (paramInt == 1002) || (paramInt == 1005) || (paramInt == 1004) || (paramInt == 2003) || (paramInt == 1003))
    {
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
      }
      return paramMessageForPtt.timeStr;
    }
    return "";
  }
  
  private String a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    Object localObject = paramMessageForPtt.sttText;
    if (paramInt == 5)
    {
      localObject = a();
      if ((localObject != null) && (paramMessageForPtt.getSttResult().a())) {
        paramMessageForPtt = ((PttSttHelper)localObject).a(paramMessageForPtt);
      }
    }
    do
    {
      return paramMessageForPtt;
      return (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramMessageForPtt.uniseq));
      paramMessageForPtt = (MessageForPtt)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return this.jdField_a_of_type_AndroidContentContext.getString(2131719547);
  }
  
  private void a(int paramInt, PttItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt);
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt);
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setThemeColor(paramInt);
    }
  }
  
  private void a(View paramView, ColorFilter paramColorFilter)
  {
    Object localObject = (PttItemBuilder.Holder)paramView.getTag();
    if (localObject != null)
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (paramView.vipBubbleID == 0L))
      {
        localObject = ((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getBackground();
        if ((localObject != null) && (paramView.vipBubbleID == 0L))
        {
          ((Drawable)localObject).setColorFilter(paramColorFilter);
          ((Drawable)localObject).invalidateSelf();
        }
      }
    }
  }
  
  public static void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt1, boolean paramBoolean1, String paramString1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, int paramInt2, String paramString2)
  {
    Object localObject1 = null;
    if (paramQQAppInterface != null) {
      localObject1 = paramQQAppInterface.getApp().getApplicationContext();
    }
    if (localObject1 == null) {}
    boolean bool1;
    Object localObject2;
    do
    {
      return;
      boolean bool2 = VoiceRedPacketHelper.a(paramMessageForPtt);
      if (paramMessageForPtt.voiceChangeFlag == 0) {
        break;
      }
      bool1 = true;
      localObject2 = ((Context)localObject1).getResources();
      i = AIOUtils.a(1.5F, (Resources)localObject2);
      j = AIOUtils.a(9.0F, (Resources)localObject2);
      float f = 0.0F;
      if (paramInt1 == 2)
      {
        localObject2 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          localObject2 = ((Context)localObject1).getString(2131719547);
        }
        paramString2 = new TextView((Context)localObject1);
        paramString2.setTextSize(0, paramInt2);
        f = paramString2.getPaint().measureText((String)localObject2);
      }
      paramInt2 = j + 44 + (int)AIOUtils.a((int)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(paramString1), ((Context)localObject1).getResources());
      paramInt1 = paramInt2;
      if (bool1) {
        paramInt1 = paramInt2 + 16;
      }
      paramInt2 = paramInt1;
      if (bool2) {
        paramInt2 = paramInt1 + 38;
      }
      paramInt1 = a((Context)localObject1, paramMessageForPtt.voiceLength, f, paramInt2, i, bool1, bool2);
      localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = paramInt1;
      paramString1 = VoicePrintUtils.a(paramQQAppInterface, paramBoolean1, bool1, paramInt1 + j, paramHolder);
      paramString2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
      paramString2.width = (paramString1[0] + paramString1[1] + paramString1[2]);
      paramString2.height = VoicePrintUtils.a(paramQQAppInterface, paramBoolean1, paramHolder);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + paramString2.width + ", flagTimeContainer.getLeft()=" + paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
      }
      if ((!paramBoolean1) || (paramString2.height <= 0)) {
        break label516;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      localObject1 = paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramQQAppInterface, 7);
    } while ((((BubbleInfo.CommonAttrs)((Pair)localObject1).first).a == null) || (((BubbleInfo.CommonAttrs)((Pair)localObject1).first).a.length <= 0));
    paramQQAppInterface = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
    localObject1 = (BubbleInfo.CommonAttrs)((Pair)localObject1).first;
    paramInt1 = paramString1[0];
    paramInt2 = paramString2.height;
    int i = paramString1[1];
    int j = paramString1[2];
    if (!paramMessageForPtt.isSend()) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramQQAppInterface.setBitmap((BubbleInfo.CommonAttrs)localObject1, paramInt1, paramInt2, i, j, paramBoolean1);
      if (!paramBoolean2) {
        break label507;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
      return;
      bool1 = false;
      break;
    }
    label507:
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
    return;
    label516:
    if (paramMessageForPtt.voiceLength > 0) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramMessageForPtt.waveformArray, ((RelativeLayout.LayoutParams)localObject2).width - AIOUtils.a(i, ((Context)localObject1).getResources()), paramMessageForPtt.voiceLength);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695173, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    if (!FileUtil.b(paramMessageForPtt.getLocalFilePath()))
    {
      a(paramHolder, paramMessageForPtt, false, true);
      a(paramHolder, paramMessageForPtt, 5003, false);
      return;
    }
    PttAudioWaveView localPttAudioWaveView = (PttAudioWaveView)paramView.findViewById(2131374563);
    float f;
    int i;
    if (localPttAudioWaveView != null)
    {
      f = paramMessageForPtt.playProgress;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "onClick, onPlayProgress progress = " + f);
      }
      if (f == 1.0F)
      {
        localPttAudioWaveView.setProgress(0.0F);
        paramMessageForPtt.playProgress = 0.0F;
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "onClick, onPlayProgress offset = " + i);
      }
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramHolder.jdField_b_of_type_Int);
      ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 1, 0, "", "", "", "");
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView), i)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695172, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
      i = (int)(paramMessageForPtt.voiceLength * 1000.0F * f);
      continue;
      i = 0;
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      if ((this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager.a(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(-16777216, 0.5F));
      }
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    if (!paramBoolean) {
      a(-16777216, paramHolder);
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int j = AIOUtils.a(9.0F, localResources);
    int n = AIOUtils.a(1.5F, localResources);
    int k = AIOUtils.a(12.0F, localResources);
    int m = AIOUtils.a(10.0F, localResources);
    try
    {
      i = localResources.getDrawable(2130844955).getIntrinsicHeight();
      int i1 = AIOUtils.a(1.0F, localResources);
      int i2 = AIOUtils.a(1.5F, localResources);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setPadding(0, 0, n, 0);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setPadding(0, 0, i2, 0);
      Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams();
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(AIOUtils.a(2.0F, localResources) + j, 0, 0, 0);
        if (paramInt1 == 2)
        {
          if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            break label1238;
          }
          ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localImageView.setImageDrawable(new ColorDrawable(838860800));
          RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i1);
          localImageView.setLayoutParams(localLayoutParams1);
          localImageView.setId(2131374580);
          ETTextView localETTextView = new ETTextView(this.jdField_a_of_type_AndroidContentContext);
          if (!paramMessageForPtt.isSend()) {
            break label1190;
          }
          localObject1 = localResources.getColorStateList(2131167056);
          if (localObject1 != null)
          {
            localETTextView.setTextColor((ColorStateList)localObject1);
            if ((paramInt2 == 5) && (paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_b_of_type_Int != 0)) {
              localETTextView.setTextColor(PttAudioWaveView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_b_of_type_Int, 0.5F));
            }
          }
          localETTextView.setId(2131374579);
          localETTextView.setMaxWidth(BaseChatItemLayout.f);
          localObject4 = new RelativeLayout.LayoutParams(-2, -2);
          localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          ((RelativeLayout)localObject1).setId(2131374576);
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
          localProgressBar.setId(2131374577);
          localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setIndeterminate(true);
          localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839545));
          ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(13.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(16.0F, localResources);
          localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = new TextView(BaseApplicationImpl.getContext());
          RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          ((TextView)localObject3).setLayoutParams(localLayoutParams2);
          ((TextView)localObject3).setText(2131719545);
          ((TextView)localObject3).setTextSize(AIOUtils.a(4.0F, localResources));
          ((TextView)localObject3).setIncludeFontPadding(false);
          localLayoutParams2.addRule(5, 2131374579);
          localLayoutParams2.addRule(8, 2131374573);
          if ((paramInt2 != 5) && (paramInt2 != 6)) {
            break label1203;
          }
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.a(25.0F, localResources);
          if (paramInt2 == 5)
          {
            localProgressBar.setVisibility(0);
            ((TextView)localObject3).setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            localProgressBar.setVisibility(8);
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setText(2131719543);
          }
          localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((RelativeLayout)localObject1).addView(localProgressBar);
          ((RelativeLayout)localObject1).addView(localETTextView);
          localObject4 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject4).setId(2131374573);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          ((ImageView)localObject4).setLayoutParams(localLayoutParams2);
          ((ImageView)localObject4).setImageResource(2130844955);
          ((ImageView)localObject4).setScaleType(ImageView.ScaleType.FIT_END);
          ((ImageView)localObject4).setOnClickListener(this);
          localLayoutParams1.addRule(3, 2131374560);
          localLayoutParams1.addRule(14);
          localLayoutParams2.addRule(3, 2131374580);
          localLayoutParams2.addRule(14);
          localLayoutParams2.addRule(6, 2131374576);
          localLayoutParams2.addRule(8, 2131374576);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(3, 2131374580);
          ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams1);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject1);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject4);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject3);
          paramHolder.e = localImageView;
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = localETTextView;
          paramHolder.f = ((ImageView)localObject4);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          if ((paramInt2 != 5) && (paramInt2 != 6)) {
            break label1421;
          }
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, AIOUtils.a(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b(paramMessageForPtt);
          localObject1 = (RelativeLayout.LayoutParams)paramHolder.e.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374560);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374560);
          localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374560);
          ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131374560);
          paramInt1 = AIOUtils.a(22.0F, localResources);
          paramHolder.e.setPadding(j, 0, j, 0);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(j, BaseChatItemLayout.m, j, paramInt1 + i);
          paramHolder.f.setPadding(0, 0, 0, k);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(j, 0, 0, m);
          paramMessageForPtt = a(paramMessageForPtt, paramInt2);
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramMessageForPtt);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject4;
        ProgressBar localProgressBar;
        Object localObject3;
        int i = AIOUtils.a(24.0F, localResources);
        QLog.e("PttItemBuilder", 1, "", localException);
        continue;
        localException.width = AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPadding(AIOUtils.a(2.0F, localResources) + j, 0, j, 0);
        continue;
        label1190:
        Object localObject2 = localResources.getColorStateList(2131167052);
        continue;
        label1203:
        ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.a(0.0F, localResources);
        localProgressBar.setVisibility(8);
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(2131719545);
        continue;
        label1238:
        paramHolder.e.setVisibility(0);
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
        paramHolder.f.setVisibility(0);
        localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
        if ((paramInt2 == 5) || (paramInt2 == 6))
        {
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(25.0F, localResources);
          if (paramInt2 == 5)
          {
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if (paramInt2 == 6)
          {
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(0.0F, localResources);
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131719543);
          }
        }
        for (;;)
        {
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(0.0F, localResources);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131719545);
        }
        label1421:
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      }
    }
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean, View paramView, ChatMessage paramChatMessage)
  {
    paramView = paramView.getResources();
    if (paramChatMessage.isSend())
    {
      paramView = paramView.getColorStateList(2131167056);
      if ((paramHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
      }
      if ((paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramView != null))
      {
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramView);
        if ((this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager.a(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
          paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(paramView.getDefaultColor(), 0.5F));
        }
      }
      if ((paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) && (paramView != null)) {
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramView);
      }
      if (!paramBoolean)
      {
        if (paramChatMessage.isSend()) {
          break label164;
        }
        a(Color.parseColor("#424448"), paramHolder);
      }
    }
    label164:
    while (paramView == null)
    {
      return;
      paramView = paramView.getColorStateList(2131167052);
      break;
    }
    a(paramView.getDefaultColor(), paramHolder);
  }
  
  private void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean, BubbleInfo paramBubbleInfo)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager.a(paramMessageForPtt)) && (!paramMessageForPtt.getSttResult().a())) {
        paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(PttAudioWaveView.a(paramBubbleInfo.jdField_b_of_type_Int, 0.5F));
      }
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
    }
    if (!paramBoolean) {
      a(paramBubbleInfo.jdField_b_of_type_Int, paramHolder);
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    float f = SonicHelper.a;
    Object localObject1 = "0X8009DE4";
    if (paramInt == 2131378364)
    {
      f = SonicHelper.b;
      localObject1 = "0X8009E7D";
    }
    label564:
    label581:
    label584:
    label586:
    for (;;)
    {
      if (paramMessageForPtt.isReady())
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
          break label91;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695173, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      }
      for (;;)
      {
        return;
        if (paramInt != 2131378361) {
          break label586;
        }
        f = SonicHelper.c;
        localObject1 = "0X8009DE3";
        break;
        label91:
        boolean bool1 = AudioSettingManager.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        Object localObject2 = PlayModeUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k, bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i, f);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i = PlayModeUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k, bool1, bool2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, (CharSequence)localObject2, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b() == 0)
        {
          paramInt = 1;
          ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, paramInt, 0, "", "", "", "");
          if (c(paramMessageForPtt)) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          }
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "getMenuItem oriSpeed:" + paramMessageForPtt.playSpeedPos + ", newSpeed:" + f);
          }
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
          if (paramInt < 0) {
            break label581;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt - i);
          PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)AIOUtils.a((View)localObject2);
          if ((localObject2 == null) || (localHolder == null)) {
            break label581;
          }
          localObject1 = (MessageForPtt)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localHolder.jdField_b_of_type_Int);
          if (localObject1 != null) {
            ((MessageForPtt)localObject1).playSpeedPos = f;
          }
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          localHolder.a(true);
          localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374563);
          if ((localObject2 == null) || (localObject1 == null)) {
            break label581;
          }
          f = ((MessageForPtt)localObject1).playProgress;
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "onMenuItemClicked, progress = " + f);
          }
          if (f != 1.0F) {
            break label564;
          }
          ((PttAudioWaveView)localObject2).setProgress(0.0F);
          paramInt = 0;
        }
        for (;;)
        {
          if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForPtt, paramInt)) {
            break label584;
          }
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695172, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
          return;
          paramInt = 2;
          break;
          paramInt = (int)(((MessageForPtt)localObject1).voiceLength * 1000.0F * f);
          continue;
          paramInt = 0;
        }
      }
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    if (c(paramMessageForPtt)) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    PttInfoCollector.reportLongPressPtt(2);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu)
  {
    paramQQCustomMenu.a(2131365448, this.jdField_a_of_type_AndroidContentContext.getString(2131719546), 2130839052);
    paramQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131690033), 2130839059);
    paramQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
    paramQQCustomMenu.a(2131378579, this.jdField_a_of_type_AndroidContentContext.getString(2131719542), 2130844955);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, MessageForPtt paramMessageForPtt)
  {
    if (b())
    {
      boolean bool1 = SonicHelper.a(paramMessageForPtt.playSpeedPos, SonicHelper.a);
      boolean bool2 = SonicHelper.a(paramMessageForPtt.playSpeedPos, SonicHelper.c);
      if (!bool1) {
        paramQQCustomMenu.a(2131378363, this.jdField_a_of_type_AndroidContentContext.getString(2131694935), 2130839056);
      }
      if (!bool2) {
        paramQQCustomMenu.a(2131378361, this.jdField_a_of_type_AndroidContentContext.getString(2131694930), 2130839056);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "getMenuItem speed:" + paramMessageForPtt.playSpeedPos);
      }
    }
  }
  
  private boolean a(int paramInt, MessageForPtt paramMessageForPtt)
  {
    return ((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt);
  }
  
  private boolean a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      ((RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).width = i;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(4);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject), BaseChatItemLayout.m, AIOUtils.a(10.0F, (Resources)localObject), BaseChatItemLayout.n);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      return false;
    }
    String str;
    if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt"))
    {
      if (paramMessageForPtt.longPttVipFlag != 1) {
        break label343;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
        localObject = ((Resources)localObject).getDrawable(2130840551);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new OffsetableImageSpan((Drawable)localObject, 1).setOffset(0.05F);
        this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
      if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        str = HttpUtil.getNetWorkTypeByStr();
        if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label460;
        }
      }
    }
    label460:
    for (paramHolder = "svip";; paramHolder = "vip")
    {
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "LongVoice", "TailView", "0", 1, 0, 0, str, "", paramHolder);
      if ((paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) && (paramMessageForPtt.autoToText != 2)) {
        paramMessageForPtt.sttAbility = 0;
      }
      return true;
      label343:
      if (paramMessageForPtt.longPttVipFlag != 2) {
        break;
      }
      if (this.jdField_b_of_type_AndroidTextSpannableString == null)
      {
        this.jdField_b_of_type_AndroidTextSpannableString = new SpannableString(HardCodeUtil.a(2131708703));
        localObject = ((Resources)localObject).getDrawable(2130840550);
        ((Drawable)localObject).setBounds(0, -5, ((Drawable)localObject).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject).getIntrinsicHeight() * 4 / 5);
        localObject = new OffsetableImageSpan((Drawable)localObject, 1).setOffset(0.05F);
        this.jdField_b_of_type_AndroidTextSpannableString.setSpan(localObject, 0, 3, 17);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_b_of_type_AndroidTextSpannableString, this);
      break;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = MediaPlayerManager.a(paramQQAppInterface).a();
    return (paramQQAppInterface == paramChatMessage) || (((paramQQAppInterface instanceof MessageForPtt)) && (paramQQAppInterface.frienduin != null) && (paramQQAppInterface.frienduin.equals(paramChatMessage.frienduin)) && (paramQQAppInterface.uniseq == paramChatMessage.uniseq));
  }
  
  protected static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private boolean a(QQCustomMenu paramQQCustomMenu, MessageForPtt paramMessageForPtt)
  {
    if (ConfessMsgUtil.a(paramMessageForPtt)) {
      return true;
    }
    if (!paramMessageForPtt.isReady())
    {
      ChatActivityFacade.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return true;
    }
    if (QQRecorder.a(paramMessageForPtt) <= 0)
    {
      ChatActivityFacade.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return true;
    }
    return false;
  }
  
  private int b(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool2 = VoiceRedPacketHelper.a(paramMessageForPtt);
    if (paramMessageForPtt.voiceChangeFlag != 0) {}
    boolean bool3;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramHolder, paramMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "showPttItem builder, voiceLength:" + paramMessageForPtt.voiceLength);
      }
      if (a(paramHolder, paramMessageForPtt)) {
        break;
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "showPttItem, msgText = " + paramString + ", message.voiceLength" + paramMessageForPtt.voiceLength);
    }
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    a(paramHolder, bool3, bool1, paramMessageForPtt.isSend());
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    String str;
    if (paramMessageForPtt.isSend()) {
      if (paramMessageForPtt.mRobotFlag == 1)
      {
        str = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
        if (!TextUtils.isEmpty(str)) {
          break label322;
        }
      }
    }
    for (;;)
    {
      if (((paramInt == 2003) || (paramInt == 1003)) && (!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true);
      }
      int i = b(paramMessageForPtt, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramInt = a(paramMessageForPtt, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(paramHolder, paramMessageForPtt, bool2, i, paramInt);
      str = a(paramMessageForPtt, paramInt);
      a(paramHolder, paramMessageForPtt, i, bool3, paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int, str);
      return paramInt;
      label322:
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      continue;
      str = ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
      if (!TextUtils.isEmpty(str)) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, str, null);
      }
    }
  }
  
  public static int b(MessageForPtt paramMessageForPtt, int paramInt, QQAppInterface paramQQAppInterface)
  {
    SttManager localSttManager = null;
    if (paramQQAppInterface != null) {
      localSttManager = (SttManager)paramQQAppInterface.getManager(QQManagerFactory.STT_MANAGER);
    }
    if ((paramInt == 2003) || (paramInt == 1003))
    {
      if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt)) {
        return 2;
      }
      if (((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)) && (localSttManager != null) && (localSttManager.a(paramMessageForPtt))) {
        return 2;
      }
      if ((paramMessageForPtt.sttAbility == 3) && (paramMessageForPtt.expandStt)) {
        return 2;
      }
    }
    return 1;
  }
  
  private String b(int paramInt, MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramInt != 1001) && (paramInt != 1002) && (paramInt != 1005) && (paramInt != 1004) && (paramInt != 2003))
    {
      localObject1 = localObject2;
      if (paramInt != 1003) {}
    }
    else
    {
      if (paramMessageForPtt.voiceLength <= a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
        break label82;
      }
      localObject1 = localObject2;
      if (paramMessageForPtt.longPttVipFlag == 1) {
        localObject1 = "QQ会员专享长语音";
      }
    }
    label82:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (paramMessageForPtt.longPttVipFlag != 2);
    return HardCodeUtil.a(2131708701);
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if (QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", false)) {
      if (QLog.isColorLevel()) {
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt msg have showed ,so click ptt msg not add msg");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = QVipAutoPttProcessor.c();
          localObject2 = (PttAutoChangeBean)QConfigManager.a().a(442);
          if ((localObject2 != null) && (((PttAutoChangeBean)localObject2).a())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is close ,so click ptt msg not add msg");
        return;
        if (((QVipAutoPttConfig)localObject1).jdField_a_of_type_Int == 3) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but stage=" + ((QVipAutoPttConfig)localObject1).jdField_a_of_type_Int + ",so click ptt msg not add msg");
      return;
      if (!PttSlideStateHelper.c) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("vip_ptt.PttItemBuilder", 1, "ptt auto to txt is open but switch is open ,so click ptt msg not add msg");
    return;
    Object localObject2 = HardCodeUtil.a(2131708702);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 41);
    ((Bundle)localObject1).putString("textColor", "#40A0FF");
    localObject2 = new UniteGrayTipParam(paramChatMessage.frienduin, paramChatMessage.selfuin, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 655392, ((MessageForPtt)paramChatMessage).time);
    ((UniteGrayTipParam)localObject2).a(15, 19, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      ((MessageForUniteGrayTip)localObject1).shmsgseq = paramChatMessage.shmsgseq;
    }
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject2);
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    localObject1 = "businessinfo_ptt_auto_change_guide_has_show_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramChatMessage.edit().putBoolean((String)localObject1, true).commit();
    PttSlideStateHelper.d = true;
    QVipConfigManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_open_svip_gray_msg", true);
    QLog.e("vip_ptt.PttItemBuilder", 1, "stage 3 add gray msg seccess");
  }
  
  private void b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager.b(paramMessageForPtt, paramInt);
  }
  
  private void b(MessageForPtt paramMessageForPtt, ChatMessage paramChatMessage)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      paramMessageForPtt = a();
      if (paramMessageForPtt != null) {
        paramMessageForPtt.b();
      }
    }
    Object localObject;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.delmsg", 2, "autochange pos is:" + i);
          }
        } while (i < 0);
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
      } while (localObject == null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X8009DF7", "0X8009DF7", 0, 0, "", "", "", "");
      localObject = (PttItemBuilder.Holder)((View)localObject).getTag();
      PttInfoCollector.reportLongPressPtt(5);
      if ((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3))
      {
        if ((paramMessageForPtt.sttAbility == 3) && (!paramMessageForPtt.expandStt)) {
          paramMessageForPtt.expandStt = true;
        }
        b(paramChatMessage);
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramChatMessage.uniseq), "");
        b(paramMessageForPtt, 1);
        this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager.a(this);
        a((PttItemBuilder.Holder)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
        return;
      }
    } while ((paramMessageForPtt.sttAbility != 2) || (paramMessageForPtt.expandStt));
    paramMessageForPtt.expandStt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    a((PttItemBuilder.Holder)localObject, paramMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt), c(paramMessageForPtt));
    a((BaseBubbleBuilder.ViewHolder)localObject, ((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramMessageForPtt, ((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
  }
  
  private void c(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void d(MessageForPtt paramMessageForPtt)
  {
    int i = QQRecorder.a(paramMessageForPtt);
    if (i <= 0) {
      return;
    }
    QfavMicroPhoneDialog localQfavMicroPhoneDialog = new QfavMicroPhoneDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt.voiceType, new PttItemBuilder.1(this, paramMessageForPtt));
    Object localObject;
    if (paramMessageForPtt.isSend())
    {
      localObject = paramMessageForPtt.selfuin;
      Drawable localDrawable = null;
      if (AnonymousChatHelper.a(paramMessageForPtt)) {
        localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843891);
      }
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, (String)localObject);
      localObject = localBitmap;
      if (localBitmap == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramMessageForPtt.frienduin);
      }
      if (!localQfavMicroPhoneDialog.a(paramMessageForPtt.getLocalFilePath(), i, (Bitmap)localObject, localDrawable)) {
        break label150;
      }
      localQfavMicroPhoneDialog.show();
    }
    for (;;)
    {
      PttInfoCollector.reportLongPressPtt(1);
      return;
      localObject = paramMessageForPtt.senderuin;
      break;
      label150:
      QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692260, 1);
    }
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  private void e(MessageForPtt paramMessageForPtt)
  {
    if (TextUtils.isEmpty(paramMessageForPtt.sttText)) {
      paramMessageForPtt = this.jdField_a_of_type_AndroidContentContext.getString(2131719547);
    }
    for (;;)
    {
      PttInfoCollector.reportLongPressPtt(3);
      try
      {
        if (Build.VERSION.SDK_INT < 11) {
          ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramMessageForPtt);
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
          return;
          paramMessageForPtt = paramMessageForPtt.sttText;
          break;
          ((android.content.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", paramMessageForPtt));
        }
        return;
      }
      catch (Exception paramMessageForPtt) {}
    }
  }
  
  private void f(MessageForPtt paramMessageForPtt)
  {
    PttInfoCollector.reportLongPressPtt(4);
    if ((paramMessageForPtt.sttText != null) && (paramMessageForPtt.sttText.length() > 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", -1);
      localBundle.putString("forward_text", paramMessageForPtt.sttText);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramMessageForPtt = new Intent();
      paramMessageForPtt.putExtras(localBundle);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131708708), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
  }
  
  private void g(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.sttAbility != 2) || (!paramMessageForPtt.expandStt)) {}
    do
    {
      int i;
      do
      {
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.delmsg", 2, "autochange pos is:" + i);
        }
      } while (i < 0);
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
    } while (paramMessageForPtt == null);
    ((PttItemBuilder.Holder)paramMessageForPtt.getTag()).jdField_a_of_type_ComEtrumpMixlayoutETTextView.performClick();
  }
  
  private void h(MessageForPtt paramMessageForPtt)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k)
    {
      i = 9;
      PttInfoCollector.reportLongPressPtt(i);
      if (paramMessageForPtt.isReady())
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
          break label70;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695173, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      }
    }
    label526:
    label529:
    for (;;)
    {
      return;
      i = 10;
      break;
      label70:
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      boolean bool1;
      label115:
      float f;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k)
      {
        bool1 = true;
        ((QQAppInterface)localObject1).setLoudSpeakerState(bool1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k) {
          break label497;
        }
        bool1 = true;
        ((BaseChatPie)localObject1).k = bool1;
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k) {
            break label503;
          }
          bool1 = true;
          label174:
          ((NavBarAIO)localObject1).a(bool1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        bool1 = AudioSettingManager.a(BaseApplicationImpl.getContext());
        boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k, bool1, bool2);
        if (c(paramMessageForPtt)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramMessageForPtt) + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        if (i < 0) {
          break label526;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - j);
        PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)AIOUtils.a((View)localObject2);
        if ((localObject2 == null) || (localHolder == null)) {
          break label526;
        }
        localObject1 = (MessageForPtt)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localHolder.jdField_b_of_type_Int);
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        localHolder.a(true);
        localObject2 = (PttAudioWaveView)((View)localObject2).findViewById(2131374563);
        if ((localObject2 == null) || (localObject1 == null)) {
          break label526;
        }
        f = ((MessageForPtt)localObject1).playProgress;
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "onMenuItemClicked, progress = " + f);
        }
        if (f != 1.0F) {
          break label509;
        }
        ((PttAudioWaveView)localObject2).setProgress(0.0F);
        i = 0;
      }
      for (;;)
      {
        if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageForPtt, i)) {
          break label529;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695172, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
        return;
        bool1 = false;
        break;
        label497:
        bool1 = false;
        break label115;
        label503:
        bool1 = false;
        break label174;
        label509:
        i = (int)(((MessageForPtt)localObject1).voiceLength * 1000.0F * f);
        continue;
        i = 0;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = b(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (AppSetting.d) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (AIOUtils.a(paramView) != null) {
      return this;
    }
    return null;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new PttItemBuilder.Holder();
  }
  
  @Nullable
  protected PttSttHelper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return null;
    }
    return (PttSttHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(82);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131708698);
    }
    return HardCodeUtil.a(2131708699);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager.a(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((PttItemBuilder.Holder)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilSet = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  @TargetApi(11)
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForPtt))) {
      return;
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    if (2131366625 == paramInt)
    {
      d(localMessageForPtt);
      return;
    }
    if (paramInt == 2131365636)
    {
      a(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371997)
    {
      PttInfoCollector.reportLongPressPtt(6);
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    if (paramInt == 2131365448)
    {
      e(localMessageForPtt);
      return;
    }
    if (paramInt == 2131367398)
    {
      f(localMessageForPtt);
      return;
    }
    if (paramInt == 2131378579)
    {
      g(localMessageForPtt);
      return;
    }
    if (paramInt == 2131378580)
    {
      b(localMessageForPtt, paramChatMessage);
      return;
    }
    if (paramInt == 2131371954)
    {
      if (c(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    if (paramInt == 2131373257)
    {
      h(localMessageForPtt);
      return;
    }
    if ((paramInt == 2131378363) || (paramInt == 2131378364) || (paramInt == 2131378361))
    {
      a(localMessageForPtt, paramInt);
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
      paramView = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMainTitle(2131690019);
      paramView.addButton(2131690018);
      paramView.addCancelButton(2131690800);
      paramView.setOnButtonClickListener(new PttItemBuilder.3(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131694521, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131718861, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
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
      if ((((MessageForPtt)localObject).voiceChangeFlag != 0) || (((MessageForPtt)localObject).sendFromvoiceChangePanelFlag)) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.fileType != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      do
      {
        return;
      } while (!(AIOUtils.a(paramView) instanceof MessageForPtt));
      localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramFileMsg.uniseq));
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramFileMsg.isStreamMode)
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
      if ((paramFileMsg.status == 1005) || (paramFileMsg.status == 1004))
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
    for (;;)
    {
      try
      {
        View localView;
        Object localObject;
        if ((paramView instanceof PttAudioWaveView))
        {
          localView = (View)paramView.getParent().getParent().getParent();
          localObject = (PttItemBuilder.Holder)localView.getTag();
          if (localObject == null) {
            break label196;
          }
          localObject = ((PttItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
          paramView = AIOUtils.a((View)paramView.getParent().getParent().getParent());
          if ((paramView == null) || (!(paramView instanceof MessageForPtt))) {
            break label196;
          }
          if (paramBoolean)
          {
            if (((MessageForPtt)paramView).playProgress <= 0.0F) {
              break label196;
            }
            ((PttAudioWaveView)localObject).setCanSupportSlide(true);
            break label196;
            a(localView, paramView);
          }
        }
        else
        {
          localView = (View)paramView.getParent().getParent();
          continue;
        }
        if (!c(paramView)) {
          break label196;
        }
        ((PttAudioWaveView)localObject).setCanSupportSlide(false);
      }
      catch (Exception paramView)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.d("PttItemBuilder", 2, "longClicked:" + paramView.toString());
      return;
      label196:
      while (!paramBoolean)
      {
        paramView = jdField_a_of_type_AndroidGraphicsColorFilter;
        break;
      }
      paramView = null;
    }
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    paramViewHolder = (PttItemBuilder.Holder)paramViewHolder;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramViewHolder, localMessageForPtt);
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a())) {
      a(paramViewHolder, localMessageForPtt, bool, paramView, paramChatMessage);
    }
    label214:
    for (;;)
    {
      return;
      if (paramBubbleInfo.jdField_b_of_type_Int == 0) {
        a(paramViewHolder, localMessageForPtt, bool);
      }
      for (;;)
      {
        if ((!paramBubbleInfo.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) != 1)) {
          break label214;
        }
        float f2 = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.d);
        if (bool) {
          break;
        }
        a(-1, paramViewHolder);
        return;
        a(paramViewHolder, localMessageForPtt, bool, paramBubbleInfo);
      }
    }
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "onStartSeek ");
    }
    paramPttAudioWaveView = (PttItemBuilder.Holder)AIOUtils.a(paramPttAudioWaveView);
    if (paramPttAudioWaveView != null)
    {
      MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localMediaPlayerManager.a(localMediaPlayerManager.a(), paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    paramPttAudioWaveView = (PttItemBuilder.Holder)AIOUtils.a(paramPttAudioWaveView);
    MessageForPtt localMessageForPtt;
    if (paramPttAudioWaveView != null)
    {
      localMessageForPtt = (MessageForPtt)paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (localMessageForPtt != null) {
        localMessageForPtt.playProgress = paramFloat;
      }
      if ((paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView == null) || (paramPttAudioWaveView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.b())) {
        break label50;
      }
    }
    label50:
    while (localMessageForPtt == null) {
      return;
    }
    int i = (int)(localMessageForPtt.voiceLength * 1000.0F * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "onSeekProgressUpdate, offset = " + i);
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localMessageForPtt, i);
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false);
    Object localObject = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, -1);
    if (paramHolder.c != null)
    {
      paramHolder.c.setVisibility(8);
      paramHolder.c.setOnClickListener(null);
      paramHolder.d.setVisibility(8);
    }
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.c()) && (paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a()))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b();
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.d();
    }
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(null);
      paramHolder.e.setVisibility(8);
      paramHolder.f.setVisibility(8);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    boolean bool1 = a(paramMessageForPtt, paramHolder);
    boolean bool2 = a(paramInt, paramMessageForPtt);
    localObject = a(paramInt, paramMessageForPtt);
    int i = a(paramHolder, paramMessageForPtt, paramInt, paramBoolean, (String)localObject);
    String str = b(paramInt, paramMessageForPtt);
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
    }
    switch (i)
    {
    default: 
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      }
      if (bool1)
      {
        paramMessageForPtt = (QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
        if (paramMessageForPtt != null)
        {
          paramMessageForPtt = paramMessageForPtt.a("voice_pwd", HardCodeUtil.a(2131708704), new String[] { "lowTipStr" });
          label469:
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
        }
      }
      else if (AppSetting.d)
      {
        paramMessageForPtt = HardCodeUtil.a(2131708695);
        if (!bool2) {
          break label701;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + HardCodeUtil.a(2131708700) + HardCodeUtil.a(2131708696));
      }
      break;
    }
    for (;;)
    {
      if (paramHolder.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        paramHolder.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject);
        if (str != null) {
          paramHolder.jdField_a_of_type_JavaLangStringBuilder.append(" ").append(str);
        }
      }
      return;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ImageView localImageView = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = HardCodeUtil.a(2131708705);; paramMessageForPtt = HardCodeUtil.a(2131708697))
      {
        localImageView.setContentDescription(paramMessageForPtt);
        break;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839549, null);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
      break;
      paramMessageForPtt = HardCodeUtil.a(2131708704);
      break label469;
      label701:
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject + HardCodeUtil.a(2131708709));
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      if (paramBoolean1) {
        i = 2;
      }
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().a();; j = 0)
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, i, j, paramBoolean2);
      return;
      i = 1;
      break;
      i = 5;
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (paramBoolean3)
      {
        localObject = ((Resources)localObject).getDrawable(2130847421);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        }
      }
      do
      {
        return;
        localObject = ((Resources)localObject).getDrawable(2130847419);
      } while (localObject == null);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      return;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void a(MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramMessageForPtt.uniseq));
    ThreadManager.excute(new PttItemBuilder.4(this, paramMessageForPtt.getSttResult().b() + "", paramMessageForPtt.getSttResult().c() + ""), 16, null, false);
    PttSttHelper localPttSttHelper = a();
    if (localPttSttHelper != null) {
      localPttSttHelper.b(paramMessageForPtt);
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramMessageForPtt.uniseq));
    if (paramMessageForPtt.getSttResult().a())
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      }
      PttSttHelper localPttSttHelper = a();
      if (localPttSttHelper != null) {
        localPttSttHelper.a(paramMessageForPtt);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
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
        for (i = 2130847417;; i = 2130847420)
        {
          paramMessageForPtt.setImageResource(i);
          return;
        }
      }
      paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130850389;; i = 2130850390)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    if (d(paramMessageForPtt))
    {
      paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {}
      for (i = 2130847411;; i = 2130847418)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    paramMessageForPtt = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 2130850383;; i = 2130850382)
    {
      paramMessageForPtt.setImageResource(i);
      return;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PttItemBuilder.Holder paramHolder)
  {
    for (;;)
    {
      try
      {
        Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        if ((paramBoolean1) && (!paramBoolean2))
        {
          if (paramMessageForPtt.isSend())
          {
            if (!d(paramMessageForPtt)) {
              break label140;
            }
            if (paramBoolean3)
            {
              i = 2130772276;
              paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
              paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForPtt);
              paramMessageForPtt.start();
            }
          }
          else
          {
            if (!d(paramMessageForPtt)) {
              break label169;
            }
            if (!paramBoolean3) {
              break label161;
            }
            i = 2130772274;
            continue;
          }
        }
        else
        {
          a(paramMessageForPtt, paramBoolean3, paramHolder);
          return;
        }
      }
      catch (Throwable paramMessageForPtt)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PttItemBuilder", 2, "when handlePttFlagOnAnim throw a exception " + paramMessageForPtt);
        }
        return;
      }
      int i = 2130772275;
      continue;
      label140:
      if (paramBoolean3)
      {
        i = 2130772118;
      }
      else
      {
        i = 2130772117;
        continue;
        label161:
        i = 2130772273;
        continue;
        label169:
        if (paramBoolean3) {
          i = 2130772366;
        } else {
          i = 2130772365;
        }
      }
    }
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
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
        {
          paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(paramFloat);
          if ((paramChatMessage instanceof MessageForPtt)) {
            ((MessageForPtt)paramChatMessage).playProgress = paramFloat;
          }
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView), false);
        if (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null)
        {
          if (paramBoolean)
          {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
            paramView.playProgress = 0.0F;
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
            paramXListView.a(false);
          }
          if ((!paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.d) && (paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null)) {
            paramXListView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
          }
        }
      }
    }
    c();
    if ((paramBoolean) && ((paramChatMessage instanceof MessageForPtt))) {
      ((MessageForPtt)paramChatMessage).playSpeedPos = SonicHelper.a;
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof PttItemBuilder.Holder;
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, BaseBubbleBuilder.ViewHolder paramViewHolder, MessageForPtt paramMessageForPtt)
  {
    return VoicePrintUtils.a(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramViewHolder, paramMessageForPtt);
  }
  
  protected boolean a(MessageForPtt paramMessageForPtt, PttItemBuilder.Holder paramHolder)
  {
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = true;
    Object localObject;
    if (VoiceRedPacketHelper.a(paramMessageForPtt)) {
      if (CustomizeStrategyFactory.a().a())
      {
        localObject = (QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
        if (localObject != null)
        {
          i = ((QWalletConfigManager)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
          if (i != 1) {
            break label361;
          }
          String str = paramMessageForPtt.getExtInfoFromExtStr("voice_score_id");
          if (TextUtils.isEmpty(str)) {
            break label213;
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
            break label398;
          }
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramMessageForPtt.icon);
        }
      }
    }
    label393:
    label398:
    for (int i = 1;; i = 0)
    {
      bool1 = false;
      for (;;)
      {
        label188:
        paramMessageForPtt = paramHolder.jdField_b_of_type_AndroidWidgetImageView;
        if (i != 0)
        {
          i = j;
          label200:
          paramMessageForPtt.setVisibility(i);
        }
        label213:
        label361:
        do
        {
          for (;;)
          {
            return bool1;
            i = 1;
            break;
            try
            {
              i = Integer.parseInt(paramMessageForPtt.getExtInfoFromExtStr("voice_low_tips_tag"));
              if (i == 1)
              {
                bool1 = true;
                if (bool1) {
                  break label393;
                }
                if (localObject != null) {
                  break label331;
                }
                i = 5;
                int k = QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "voice_low_tips_count", 0);
                if (k >= i) {
                  break label393;
                }
                paramMessageForPtt.saveExtInfoToExtStr("voice_low_tips_tag", "1");
                ThreadManager.post(new PttItemBuilder.2(this, paramMessageForPtt), 10, null, false);
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
                continue;
                i = ((QWalletConfigManager)localObject).a("voice_pwd", 5, new String[] { "lowTipsLimit" });
              }
            }
          }
          CustomizeStrategyFactory.a().b(true);
          i = 0;
          bool1 = false;
          break label188;
          i = 8;
          break label200;
        } while (paramHolder.jdField_b_of_type_AndroidWidgetImageView == null);
        label331:
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return false;
        i = 0;
      }
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (!(paramView instanceof PttItemBuilder.Holder))) {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
      }
      do
      {
        return false;
        paramView = (PttItemBuilder.Holder)paramView;
      } while (paramAudioPlayerBase == null);
      paramAudioPlayerBase.a(paramXListView.playSpeedPos);
      paramAudioPlayerBase.a(paramXListView.time);
      paramAudioPlayerBase.b(14);
      paramAudioPlayerBase.c(paramXListView.isSendFromLocal());
      if (paramAudioPlayerBase.b(paramXListView.getLocalFilePath(), paramInt2))
      {
        c(paramXListView);
        if (paramView != null)
        {
          paramAudioPlayerBase = a();
          if (paramAudioPlayerBase != null) {
            paramAudioPlayerBase.e(paramXListView);
          }
          a(paramView, paramXListView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
            paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
          }
          paramView.a(true);
          a(paramXListView, paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
        }
        PttInfoCollector.reportPttPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView.istroop, paramXListView.issend);
        if (!paramXListView.isSendFromLocal())
        {
          if (paramXListView.istroop != 0) {
            break label281;
          }
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      paramXListView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramChatMessage.getPttStreamFlag() == 10001) {}
      for (boolean bool = true;; bool = false)
      {
        PttInfoCollector.reportPTTPV(paramXListView, paramInt1, bool, 1);
        return true;
        label281:
        if (paramXListView.istroop == 1)
        {
          paramInt1 = 3;
          break;
        }
        if (paramXListView.istroop != 3000) {
          break label389;
        }
        paramInt1 = 2;
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
      label389:
      paramInt1 = 4;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return a(new QQCustomMenu(), (MessageForPtt)AIOUtils.a(paramView), paramView instanceof SelectableComponent);
  }
  
  protected QQCustomMenuItem[] a(QQCustomMenu paramQQCustomMenu, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.expandStt))
    {
      a(paramQQCustomMenu);
      return paramQQCustomMenu.a();
    }
    if (a(paramQQCustomMenu, paramMessageForPtt)) {
      return paramQQCustomMenu.a();
    }
    if (c(paramMessageForPtt)) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    }
    Object localObject;
    int i;
    if (!DeviceInfoUtil.h())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k))
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694931);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k)) {
          break label453;
        }
        i = 2130839056;
        label119:
        paramQQCustomMenu.a(2131373257, (String)localObject, i);
      }
    }
    else
    {
      if (((paramMessageForPtt.extraflag != 32768) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt) == 1003) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramMessageForPtt))) || (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramMessageForPtt, new Bundle());
      }
      a(paramQQCustomMenu, paramMessageForPtt);
      if (paramMessageForPtt.voiceChangeFlag != 1)
      {
        if ((paramMessageForPtt.sttAbility != 1) && (paramMessageForPtt.sttAbility != 3)) {
          break label461;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager.a(paramMessageForPtt)) && ((!paramMessageForPtt.isSend()) || (paramMessageForPtt.fileSize > 0L)) && (!VoiceRedPacketHelper.a(paramMessageForPtt))) {
          paramQQCustomMenu.a(2131378580, this.jdField_a_of_type_AndroidContentContext.getString(2131719548), 2130839049);
        }
      }
    }
    for (;;)
    {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramMessageForPtt, null);
      paramQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691326));
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramMessageForPtt, new Bundle());
      paramQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isSearch", false);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380949, paramMessageForPtt, (Bundle)localObject);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramMessageForPtt, null);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return paramQQCustomMenu.a();
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131694933);
      break;
      label453:
      i = 2130839060;
      break label119;
      label461:
      if ((paramMessageForPtt.sttAbility == 2) && (!paramMessageForPtt.expandStt) && (!VoiceRedPacketHelper.a(paramMessageForPtt))) {
        paramQQCustomMenu.a(2131378580, this.jdField_a_of_type_AndroidContentContext.getString(2131719548), 2130839049);
      }
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "1", "", "", "");
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PttItemBuilder.Holder)paramViewHolder;
    this.jdField_a_of_type_JavaUtilSet.add(paramBaseChatItemLayout);
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramViewHolder = a();
    if (paramViewHolder != null) {
      paramViewHolder.a(paramBaseChatItemLayout, localMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    }
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131374557);
      paramView = new PttAudioPlayView(this.jdField_a_of_type_AndroidContentContext, 12);
      paramView.setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167052).getDefaultColor());
      paramView.setId(2131374562);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).height = AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new PttAudioChangeView(this.jdField_a_of_type_AndroidContentContext, 2130838332, 8);
      ((PttAudioChangeView)localObject1).setThemeColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167052).getDefaultColor());
      ((PttAudioChangeView)localObject1).setId(2131374568);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).width = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).height = AIOUtils.a(19.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioChangeView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new PttAudioWaveView(this.jdField_a_of_type_AndroidContentContext);
      ((PttAudioWaveView)localObject2).setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167052).getDefaultColor());
      ((PttAudioWaveView)localObject2).setId(2131374563);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = AIOUtils.a(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((PttAudioWaveView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setId(2131374564);
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167052));
      VoicePrintUtils.VoicePrintView localVoicePrintView = new VoicePrintUtils.VoicePrintView(this.jdField_a_of_type_AndroidContentContext);
      localVoicePrintView.setId(2131374565);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131374567);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      localVoicePrintView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).width = AIOUtils.a(47.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject4).height = AIOUtils.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = new SyncParentPressedRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject4).setId(2131374560);
      ((RelativeLayout)localObject4).addView((View)localObject2);
      ((RelativeLayout)localObject4).addView(paramView);
      ((RelativeLayout)localObject4).addView((View)localObject1);
      ((RelativeLayout)localObject4).addView((View)localObject3);
      ((RelativeLayout)localObject4).addView(localVoicePrintView);
      ((RelativeLayout)localObject4).addView(localImageView);
      paramViewHolder.addView((View)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramViewHolder;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView = ((PttAudioChangeView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView = localVoicePrintView;
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView = localImageView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
    }
    if (paramOnLongClickAndTouchListener != null) {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
    }
    int i;
    boolean bool;
    if (localMessageForPtt.voiceChangeFlag != 0)
    {
      i = 1;
      bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBaseChatItemLayout, localMessageForPtt);
      if (!bool) {
        break label1092;
      }
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      if (!paramChatMessage.isSend()) {
        break label1379;
      }
      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (!bool) {
        break label1298;
      }
      paramView.addRule(1, 2131374565);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, 2131374567);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt);
      i = j;
      if (j == -1)
      {
        a(paramBaseChatItemLayout, localMessageForPtt, false, true);
        i = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      if (((localMessageForPtt.istroop == 1) || (localMessageForPtt.istroop == 3000)) && (i == 2003) && (this.jdField_a_of_type_ComTencentMobileqqSttSliceSttManager.b(localMessageForPtt)))
      {
        b(localMessageForPtt, 2);
        ReportController.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
      PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localMessageForPtt);
      PttInfoCollector.reportPttItemBuilderType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramChatMessage);
      return paramViewHolder;
      i = 0;
      break;
      label1092:
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
      if (i != 0) {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(0);
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnTouchListener(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnLongClickListener(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
        if ((!c(paramChatMessage)) && (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.d)) {
          break label1228;
        }
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        paramBaseChatItemLayout.a(true);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        break;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.setVisibility(8);
      }
      label1228:
      if (((MessageForPtt)paramChatMessage).playProgress > 0.0F)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
        paramBaseChatItemLayout.a(true);
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(localMessageForPtt.playProgress);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
        break;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
        paramBaseChatItemLayout.a(false);
      }
      label1298:
      paramView.addRule(1, 2131374563);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374568);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374567);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374562);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      continue;
      label1379:
      if (bool)
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374564);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374565);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams()).addRule(1, -1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374563);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams()).addRule(1, 2131374568);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioChangeView.getLayoutParams()).addRule(1, 2131374567);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374562);
        ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.getLayoutParams()).addRule(1, -1);
      }
    }
  }
  
  public void b(MessageForPtt paramMessageForPtt)
  {
    PttSttHelper localPttSttHelper = a();
    if (localPttSttHelper != null) {
      localPttSttHelper.c(paramMessageForPtt);
    }
  }
  
  protected boolean b()
  {
    return SonicHelper.a();
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected boolean c(ChatMessage paramChatMessage)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void d()
  {
    PttInfoCollector.reportLongPressPtt(7);
    super.d();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    int i = paramView.getId();
    if ((AppSetting.d) && (i == 2131363508)) {
      paramView.findViewById(2131374560).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      Object localObject2 = (MessageForPtt)((PttItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((i == 2131374560) || (i == 2131374563))
      {
        if (localObject2 != null)
        {
          if (c((ChatMessage)localObject2))
          {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            ReportController.b(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 2, 0, "", "", "", "");
          }
          for (;;)
          {
            if (((MessageForPtt)localObject2).istroop == 1008) {
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
            }
            if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
            break;
            if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
              a((PttItemBuilder.Holder)localObject1, (MessageForPtt)localObject2, paramView);
            }
          }
        }
      }
      else if ((i == 2131374579) || (i == 2131374573))
      {
        if ((localObject2 != null) && (((MessageForPtt)localObject2).expandStt))
        {
          ((MessageForPtt)localObject2).expandStt = false;
          ((MessageForPtt)localObject2).serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
          a((PttItemBuilder.Holder)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
          ReportController.b(null, "dc00898", "", "", "0X8009DF8", "0X8009DF8", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
        }
      }
      else if (i == 2131364663)
      {
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          String str = HttpUtil.getNetWorkTypeByStr();
          if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
          for (localObject1 = "svip";; localObject1 = "vip")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject2, "LongVoice", "TailClick", "0", 1, 0, 0, str, "", (String)localObject1);
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((Intent)localObject1).putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            break;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "chat_item_tail_message onclick nullpoint");
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
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