package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.sign.AIOSignViewHolder;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder.OnClickListener;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

public class RichStatItemBuilder
  extends AbstractChatItemBuilder
  implements IIconListener, ISignViewHolder.OnClickListener, ITopic.OnTopicClickListener
{
  public static long a;
  private static RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  protected Handler a;
  AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = null;
  RichStatItemBuilder.WeakHolder jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$WeakHolder = new RichStatItemBuilder.WeakHolder(null);
  SignatureManager jdField_a_of_type_ComTencentMobileqqAppSignatureManager;
  MessageForRichState jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = null;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  HashSet<RichStatItemBuilder.Holder> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  long b;
  long c;
  
  public RichStatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$WeakHolder.a = new WeakReference(this);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = null;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)paramQQAppInterface.getManager(QQManagerFactory.SIGNATURE_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 1);
    }
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$WeakHolder);
    }
  }
  
  private void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(MessageForRichState paramMessageForRichState)
  {
    if (jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId = paramMessageForRichState.feedId;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId = paramMessageForRichState.tplId;
    RichStatus localRichStatus = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    int i;
    if (TextUtils.isEmpty(paramMessageForRichState.actionId)) {
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId;
    } else {
      i = Integer.parseInt(paramMessageForRichState.actionId);
    }
    localRichStatus.actionId = i;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = paramMessageForRichState.actionText;
    localRichStatus = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (TextUtils.isEmpty(paramMessageForRichState.dataId)) {
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId;
    } else {
      i = Integer.parseInt(paramMessageForRichState.dataId);
    }
    localRichStatus.dataId = i;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = paramMessageForRichState.dataText;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramMessageForRichState.locText;
    localRichStatus = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (TextUtils.isEmpty(paramMessageForRichState.locPos)) {
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationPosition;
    } else {
      i = Integer.parseInt(paramMessageForRichState.locPos);
    }
    localRichStatus.locationPosition = i;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time = paramMessageForRichState.time;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId = paramMessageForRichState.fontId;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType = paramMessageForRichState.fontType;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = null;
    if ((paramMessageForRichState.plainText != null) && (paramMessageForRichState.plainText.length() > 0))
    {
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = new ArrayList(paramMessageForRichState.plainText.length());
      i = 0;
      while (i < paramMessageForRichState.plainText.length())
      {
        jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add(paramMessageForRichState.plainText.optString(i));
        i += 1;
      }
    }
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicFromJson(paramMessageForRichState.topics);
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicPosFromJson(paramMessageForRichState.topicsPos);
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicFragmentActivity.class);
    localIntent.putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("key_open_via", "history-liaotian");
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_clk_his", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "1", "", "");
    VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "signature_aio", "click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  private void c()
  {
    if (System.currentTimeMillis() - this.b > 2000L)
    {
      this.b = System.currentTimeMillis();
      ReportController.b(null, "dc00898", "", "", "0X800A4EB", "0X800A4EB", 0, 0, "0", "0", "", "");
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = ((MessageForRichState)paramMessageRecord);
    jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramLinearLayout = (RichStatItemBuilder.Holder)paramViewHolder;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOSignViewHolder", 2, "convertView is null, create SignatureView.");
      }
      paramMessageRecord = new BoxShadowLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder = new ViewGroup.MarginLayoutParams(-1, -2);
      int i = AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewHolder.leftMargin = i;
      paramViewHolder.rightMargin = i;
      paramMessageRecord.setLayoutParams(paramViewHolder);
      paramLinearLayout.a = new AIOSignViewHolder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin);
      paramLinearLayout.a.a(this);
      paramLinearLayout.a.a(this);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState);
    paramLinearLayout.a.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramLinearLayout.a.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin;
    paramLinearLayout.a.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.istroop;
    paramLinearLayout.a.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedId;
    paramLinearLayout.a.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.tplId;
    paramLinearLayout.a.d = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.count;
    paramLinearLayout.a.f = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.zanFlag;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != null) {
      paramLinearLayout.a.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a.getDefaultColor();
    }
    paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.ver;
    if ((paramViewHolder != null) && (paramViewHolder.equals("1.0")))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time > 0L) {
        paramViewHolder = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time * 1000L);
      } else {
        paramViewHolder = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      } else {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      paramView = TogetherUtils.a(20, paramView);
      paramOnLongClickAndTouchListener = new StringBuilder();
      paramOnLongClickAndTouchListener.append(paramView);
      paramOnLongClickAndTouchListener.append(HardCodeUtil.a(2131713371));
      paramOnLongClickAndTouchListener = paramOnLongClickAndTouchListener.toString();
      paramLinearLayout.a.jdField_a_of_type_JavaLangString = paramOnLongClickAndTouchListener;
      if (e)
      {
        paramOnLongClickAndTouchListener = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText();
        if (paramLinearLayout.b == null) {
          paramLinearLayout.b = new StringBuilder();
        } else if (paramLinearLayout.b.length() > 0) {
          paramLinearLayout.b.delete(0, paramLinearLayout.b.length());
        }
        paramLinearLayout.b.append(paramView);
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time > 0L)
        {
          paramView = paramLinearLayout.b;
          paramView.append("于");
          paramView.append(paramViewHolder);
        }
        paramViewHolder = paramLinearLayout.b;
        paramViewHolder.append("更新了签名，内容是：");
        paramViewHolder.append(paramOnLongClickAndTouchListener);
        paramMessageRecord.setContentDescription(paramLinearLayout.b.toString());
      }
    }
    paramLinearLayout.a.a(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time);
    ThreadManager.post(new RichStatItemBuilder.1(this), 8, null, true);
    c();
    return paramMessageRecord;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    RichStatItemBuilder.Holder localHolder = new RichStatItemBuilder.Holder();
    this.jdField_a_of_type_JavaUtilHashSet.add(localHolder);
    return localHolder;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatItemBuilder", 2, "RichStatItemBuilder destroy");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      RichStatItemBuilder.Holder localHolder = (RichStatItemBuilder.Holder)((Iterator)localObject).next();
      if (localHolder.a != null) {
        localHolder.a.k();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if (localObject != null) {
      ((StatusManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$WeakHolder);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(View paramView, int paramInt, ISignViewHolder paramISignViewHolder)
  {
    QLog.d("ChatItemBuilder", 1, new Object[] { "onClick viewType=", paramView });
    if (paramInt == 3)
    {
      b();
      paramInt = 2;
    }
    else if (paramInt == 4)
    {
      a(paramISignViewHolder);
      paramInt = 3;
    }
    else
    {
      b();
      paramInt = 1;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A98E", "0X800A98E", paramInt, 0, "0", "0", "", "");
  }
  
  public void a(ISignViewHolder paramISignViewHolder)
  {
    if (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId))
    {
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131692183), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
        return;
      }
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.c) < 200L)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131690871), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
        return;
      }
      this.c = l;
    }
    for (;;)
    {
      try
      {
        paramISignViewHolder = (AIOSignViewHolder)paramISignViewHolder;
        i = paramISignViewHolder.d;
        int k = paramISignViewHolder.f;
        int j = 1;
        if (k == 0)
        {
          paramISignViewHolder.f = 1;
          i += 1;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_on", 0, 0, "", "", "", "");
        }
        else
        {
          paramISignViewHolder.f = 0;
          i -= 1;
          if (i <= 0) {
            break label307;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_off", 0, 0, "", "", "", "");
          j = 0;
        }
        paramISignViewHolder.d = i;
        paramISignViewHolder.j();
        ((SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramISignViewHolder.jdField_b_of_type_JavaLangString, 255, j);
        return;
      }
      catch (Exception paramISignViewHolder)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 2, paramISignViewHolder.getMessage(), paramISignViewHolder);
        }
      }
      return;
      label307:
      int i = 0;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    QLog.d("ChatItemBuilder", 1, new Object[] { "onClick topic=", paramITopic });
    paramITopic = paramITopic.getData();
    if ((paramITopic instanceof Pair))
    {
      paramITopic = (Pair)paramITopic;
      if (QLog.isColorLevel()) {
        QLog.i("ChatItemBuilder", 2, String.format("aio onTopicClick [%d,%s]", new Object[] { paramITopic.first, paramITopic.second }));
      }
      TopicUtil.a(this.jdField_a_of_type_AndroidContentContext, TopicUtil.a(((Integer)paramITopic.first).intValue(), (String)paramITopic.second), -1);
    }
  }
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder
 * JD-Core Version:    0.7.0.1
 */