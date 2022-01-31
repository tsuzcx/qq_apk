package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.LightReplyMsgRich2;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.lightReply.ImageExplodeLayout;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import ved;
import veh;
import vei;
import vek;
import vem;
import ven;
import veo;
import vep;
import ver;
import ves;

public class ReplyTextItemBuilder
  extends TextItemBuilder
{
  protected static Drawable a;
  public static float b;
  protected View.OnClickListener a;
  private ListView a;
  protected ves a;
  protected int b;
  protected int c = 80;
  private View.OnClickListener d;
  
  static
  {
    jdField_b_of_type_Float = 0.5625F;
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
  }
  
  public ReplyTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Ves = new ves(null);
    this.jdField_b_of_type_Int = 165;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ved(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new vem(this);
    this.jdField_b_of_type_Int = AIOUtils.a(82.0F, paramContext.getResources());
    this.c = AIOUtils.a(41.0F, paramContext.getResources());
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView;
    }
  }
  
  private View a(View paramView, Context paramContext, ver paramver, MessageForReplyText paramMessageForReplyText, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramver.jdField_e_of_type_Int = 0;
    paramView = this.jdField_a_of_type_Ves.a(0);
    if (paramView == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      Object localObject = a(paramContext);
      paramver.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
      paramver.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131368536));
      paramver.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131362754));
      paramver.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131366642));
      paramver.jdField_b_of_type_AndroidViewView = ((ViewGroup)localObject).findViewById(2131365554);
      ((ViewGroup)localObject).setId(2131361860);
      paramView.addView(paramver.jdField_a_of_type_AndroidViewViewGroup);
      paramView.setPadding(0, 0, 0, 0);
      localObject = new ETTextView(paramContext);
      ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131494227));
      ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131494224));
      ((ETTextView)localObject).setEditableFactory(QQTextBuilder.a);
      ((ETTextView)localObject).setSpannableFactory(QQText.a);
      ((ETTextView)localObject).setMaxWidth(BaseChatItemLayout.jdField_d_of_type_Int);
      ((ETTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      int j = BaseChatItemLayout.n;
      int i = BaseChatItemLayout.o;
      if (paramMessageForReplyText.isSend())
      {
        j = BaseChatItemLayout.o;
        i = BaseChatItemLayout.n;
      }
      ((ETTextView)localObject).setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
      ((ETTextView)localObject).setId(2131363575);
      paramver.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localObject);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(5.0F, paramContext.getResources());
      paramView.addView(paramver.jdField_e_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramver.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368536));
      paramver.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362754));
      paramver.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131366642));
      paramver.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365554);
      paramver.jdField_e_of_type_AndroidWidgetTextView = ((ETTextView)paramView.findViewById(2131363575));
      paramver.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131361860));
      if (!TextUtils.isEmpty(paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_ctrl_info")))
      {
        paramContext = ((ETTextView)paramver.jdField_e_of_type_AndroidWidgetTextView).a();
        if (paramContext != null) {
          paramContext.a = (paramMessageForReplyText.uniseq + 1L);
        }
      }
      ((ETTextView)paramver.jdField_e_of_type_AndroidWidgetTextView).setFont(0, paramMessageForReplyText.uniseq);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramMessageForReplyText.senderuin)) && (paramMessageForReplyText.mSourceMsgInfo.mLocalAtInfoDone == 0))
      {
        paramMessageForReplyText.mSourceMsgInfo.mLocalAtInfoDone = 1;
        if ((paramMessageForReplyText.atInfoList != null) && (paramMessageForReplyText.atInfoList.size() > 0))
        {
          paramContext = (MessageForText.AtTroopMemberInfo)paramMessageForReplyText.atInfoList.remove(0);
          if (paramMessageForReplyText.msg.length() > paramContext.textLen + 1)
          {
            paramMessageForReplyText.msg = paramMessageForReplyText.msg.substring(paramContext.textLen + 1);
            paramMessageForReplyText.sb = new QQText(paramMessageForReplyText.msg, 13, 32, paramMessageForReplyText);
          }
        }
      }
      paramver.jdField_e_of_type_AndroidWidgetTextView.setText(paramMessageForReplyText.sb);
      super.a(paramver.jdField_e_of_type_AndroidWidgetTextView, paramMessageForReplyText);
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramver.jdField_a_of_type_AndroidViewViewGroup, paramMessageForReplyText.mSourceMsgInfo, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText.uniseq);
      paramver.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramver.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramver.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if ((paramver.jdField_e_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
        ((AnimationTextView)paramver.jdField_e_of_type_AndroidWidgetTextView).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      }
      if ((paramver.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
        paramver.jdField_a_of_type_ComEtrumpMixlayoutETTextView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      }
      return paramView;
    }
  }
  
  public static final RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2130969948, null);
    Object localObject = (TextView)localRelativeLayout.findViewById(2131368536);
    ((TextView)localObject).setTextSize(1, 40.0F);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131494227));
    ImmersiveUtils.a((View)localObject, 0.5F);
    ((TextView)localObject).setPadding(BaseChatItemLayout.n, BaseChatItemLayout.l, 0, 0);
    localObject = (TextView)localRelativeLayout.findViewById(2131362754);
    ((TextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131494227));
    ImmersiveUtils.a((View)localObject, 0.5F);
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setEditableFactory(QQTextBuilder.a);
    ((TextView)localObject).setSpannableFactory(QQText.a);
    ((TextView)localObject).setMaxWidth(BaseChatItemLayout.jdField_d_of_type_Int);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((TextView)localObject).getLayoutParams());
    localLayoutParams.addRule(1, 2131368536);
    localLayoutParams.leftMargin = AIOUtils.a(5.0F, paramContext.getResources());
    localLayoutParams.topMargin = AIOUtils.a(10.0F, paramContext.getResources());
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    ((TextView)localObject).setPadding(0, BaseChatItemLayout.l, BaseChatItemLayout.o, 0);
    localObject = (ETTextView)localRelativeLayout.findViewById(2131366642);
    ((ETTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131494227));
    ((ETTextView)localObject).setLinkTextColor(paramContext.getResources().getColorStateList(2131494224));
    ((ETTextView)localObject).setTextSize(1, 14.0F);
    ((ETTextView)localObject).setEditableFactory(QQTextBuilder.a);
    ((ETTextView)localObject).setSpannableFactory(QQText.a);
    ((ETTextView)localObject).setMaxWidth(BaseChatItemLayout.jdField_d_of_type_Int);
    ((ETTextView)localObject).setLineSpacing(AIOUtils.a(2.0F, paramContext.getResources()), 1.0F);
    ((ETTextView)localObject).setPadding(0, 0, BaseChatItemLayout.o, BaseChatItemLayout.m);
    localObject = localRelativeLayout.findViewById(2131365554);
    ((View)localObject).setBackgroundColor(paramContext.getResources().getColorStateList(2131494227).getDefaultColor());
    ImmersiveUtils.a((View)localObject, 0.5F);
    return localRelativeLayout;
  }
  
  public static final MessageForPic a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt)
  {
    paramMessageForMixedMsg = paramMessageForMixedMsg.msgElemList;
    int i = 0;
    while (i < paramMessageForMixedMsg.size())
    {
      Object localObject = (MessageRecord)paramMessageForMixedMsg.get(i);
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if (((MessageForPic)localObject).subMsgId == paramInt) {
          return localObject;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt);
    int i = paramQQAppInterface.size();
    paramInt = 0;
    while (paramInt < i)
    {
      paramString = (ChatMessage)paramQQAppInterface.get(paramInt);
      if (paramString.shmsgseq == paramLong)
      {
        if (!paramString.mIsParsed) {
          paramString.parse();
        }
        return paramString;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public static final void a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString, int paramInt, long paramLong)
  {
    String str2 = TimeFormatterUtils.a(paramContext, 3, paramSourceMsgInfo.mSourceMsgTime * 1000L).toString();
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131362754);
    String str1;
    if (!TextUtils.isEmpty(paramSourceMsgInfo.mAnonymousNickName)) {
      str1 = paramSourceMsgInfo.mAnonymousNickName;
    }
    while (paramSourceMsgInfo.mSourceSummaryFlag == 1)
    {
      paramContext = paramSourceMsgInfo.mSourceMsgText;
      if (!TextUtils.isEmpty(str1)) {
        localTextView.setText(str1 + " " + str2);
      }
      paramViewGroup = (ETTextView)paramViewGroup.findViewById(2131366642);
      paramQQAppInterface = paramContext;
      if (paramContext == null) {
        paramQQAppInterface = "";
      }
      paramViewGroup.setText(new QQText(paramQQAppInterface, 7));
      return;
      if (paramSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
      {
        paramContext = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgSeq);
        if (paramContext != null)
        {
          paramContext = TroopBusinessUtil.a(paramContext);
          if (paramContext != null) {
            paramSourceMsgInfo.mAnonymousNickName = paramContext.c;
          }
        }
        str1 = "";
      }
      else
      {
        ThreadManager.post(new vep(paramQQAppInterface, paramInt, paramString, paramSourceMsgInfo, localTextView, str2), 8, null, true);
        str1 = "";
      }
    }
    paramContext = a(paramQQAppInterface, paramString, paramInt, paramSourceMsgInfo.mSourceMsgSeq);
    if ((paramContext instanceof MessageForFile))
    {
      if (((MessageForFile)paramContext).fileName == null) {
        break label308;
      }
      paramContext = ((MessageForFile)paramContext).getSummaryMsg();
      paramSourceMsgInfo.mSourceMsgText = paramContext;
      paramSourceMsgInfo.mSourceSummaryFlag = 1;
    }
    for (;;)
    {
      if (paramContext == null)
      {
        paramContext = paramSourceMsgInfo.mSourceMsgText;
        break;
        if (paramContext == null) {
          break label308;
        }
        paramContext = ((ChatMessage)paramContext).getSummaryMsg();
        paramSourceMsgInfo.mSourceMsgText = paramContext;
        paramSourceMsgInfo.mSourceSummaryFlag = 1;
        continue;
      }
      break;
      label308:
      paramContext = null;
    }
  }
  
  private static void a(URLDrawable paramURLDrawable)
  {
    if ((AbsDownloader.a(paramURLDrawable.getURL().toString())) && (paramURLDrawable.getStatus() != 1)) {}
    try
    {
      paramURLDrawable.startDownload();
      return;
    }
    catch (OutOfMemoryError paramURLDrawable) {}
  }
  
  private View b(View paramView, Context paramContext, ver paramver, MessageForReplyText paramMessageForReplyText, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramver.jdField_e_of_type_Int = 1;
    paramView = this.jdField_a_of_type_Ves.a(paramMessageForReplyText.mSourceMsgInfo.mType);
    paramContext = paramView;
    if (paramView == null) {
      paramContext = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969950, null);
    }
    paramver.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext);
    int i = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    if (paramMessageForReplyText.isSend())
    {
      i = BaseChatItemLayout.o;
      j = BaseChatItemLayout.n;
      paramver.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext.findViewById(2131365569));
      paramver.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131364477));
      paramver.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363525));
      paramver.d = ((TextView)paramContext.findViewById(2131363057));
      paramver.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131366884));
      paramver.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.a(148.0F, paramContext.getResources()));
      paramver.d.setMaxWidth(AIOUtils.a(148.0F, paramContext.getResources()));
      paramver.jdField_e_of_type_AndroidWidgetTextView.setEditableFactory(QQTextBuilder.a);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setSpannableFactory(QQText.a);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(BaseChatItemLayout.jdField_d_of_type_Int);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramver.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramver.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramver.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramver.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramver.jdField_c_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramver.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramver.d.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramver.d.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramver.d.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramver.jdField_c_of_type_AndroidViewViewGroup.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramver.jdField_c_of_type_AndroidViewViewGroup.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramver.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramver.jdField_e_of_type_AndroidWidgetTextView.setPadding(i, 0, j, BaseChatItemLayout.m);
      paramver.jdField_b_of_type_AndroidViewViewGroup.setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramMessageForReplyText.mSourceMsgInfo.mRichMsg);
        Object localObject1 = ((JSONObject)localObject2).optString("cover");
        paramView = ((JSONObject)localObject2).optString("title");
        paramOnLongClickAndTouchListener = ((JSONObject)localObject2).optString("summary");
        localObject2 = ((JSONObject)localObject2).optString("jump");
        paramver.jdField_c_of_type_AndroidViewViewGroup.setTag(localObject2);
        paramver.jdField_e_of_type_AndroidWidgetTextView.setTag(localObject2);
        paramver.d.setTag(localObject2);
        paramver.jdField_c_of_type_AndroidWidgetTextView.setTag(localObject2);
        paramver.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
        if (HttpUtil.a((String)localObject1))
        {
          i = AIOUtils.a(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          j = AIOUtils.a(52.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = j;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = paramMessageForReplyText;
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          paramver.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
        if ((paramver.jdField_e_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
          ((AnimationTextView)paramver.jdField_e_of_type_AndroidWidgetTextView).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
        }
        localObject1 = new Rect();
        j = AIOUtils.a(148.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (TextUtils.isEmpty(paramView)) {
          break label1212;
        }
        paramver.jdField_c_of_type_AndroidWidgetTextView.getPaint().getTextBounds(paramView, 0, paramView.length(), (Rect)localObject1);
        if (((Rect)localObject1).width() > j)
        {
          paramver.jdField_c_of_type_AndroidWidgetTextView.setLines(2);
          i = 2;
          if (!TextUtils.isEmpty(paramOnLongClickAndTouchListener))
          {
            paramver.d.getPaint().getTextBounds(paramOnLongClickAndTouchListener, 0, paramOnLongClickAndTouchListener.length(), (Rect)localObject1);
            if (((Rect)localObject1).width() <= j) {
              break label1040;
            }
            if (i == 2) {
              paramver.d.setLines(1);
            }
          }
          else
          {
            if (!TextUtils.isEmpty(paramView)) {
              break label1051;
            }
            paramver.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (!TextUtils.isEmpty(paramOnLongClickAndTouchListener)) {
              break label1070;
            }
            paramver.d.setVisibility(8);
            if (TextUtils.isEmpty(paramMessageForReplyText.mSourceMsgInfo.mAnonymousNickName)) {
              break label1090;
            }
            paramView = paramMessageForReplyText.mSourceMsgInfo.mAnonymousNickName;
            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramMessageForReplyText.senderuin)) && (paramMessageForReplyText.mSourceMsgInfo.mLocalAtInfoDone == 0))
            {
              paramMessageForReplyText.mSourceMsgInfo.mLocalAtInfoDone = 1;
              if ((paramMessageForReplyText.atInfoList != null) && (paramMessageForReplyText.atInfoList.size() > 0))
              {
                paramOnLongClickAndTouchListener = (MessageForText.AtTroopMemberInfo)paramMessageForReplyText.atInfoList.remove(0);
                if (paramMessageForReplyText.msg.length() > paramOnLongClickAndTouchListener.textLen + 1)
                {
                  paramMessageForReplyText.msg = paramMessageForReplyText.msg.substring(paramOnLongClickAndTouchListener.textLen + 1);
                  paramMessageForReplyText.sb = new QQText(paramMessageForReplyText.msg, 13, 32, paramMessageForReplyText);
                }
              }
            }
            paramver.jdField_e_of_type_AndroidWidgetTextView.setText(new QQText("回复" + paramView + ":" + paramMessageForReplyText.msg, 13));
            return paramContext;
          }
        }
        else
        {
          paramver.jdField_c_of_type_AndroidWidgetTextView.setLines(1);
          i = 1;
          continue;
        }
        paramver.d.setLines(2);
        continue;
        QLog.e("ChatItemBuilder", 2, paramView.getMessage());
      }
      catch (JSONException paramView)
      {
        if (!QLog.isColorLevel()) {
          break label1210;
        }
      }
      return paramContext;
      label1040:
      paramver.d.setLines(1);
      continue;
      label1051:
      paramver.jdField_c_of_type_AndroidWidgetTextView.setText(paramView);
      paramver.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      continue;
      label1070:
      paramver.d.setText(paramOnLongClickAndTouchListener);
      paramver.d.setVisibility(0);
      continue;
      label1090:
      if (paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
      {
        paramView = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
        if (paramView != null)
        {
          paramView = TroopBusinessUtil.a(paramView);
          if (paramView != null) {
            paramMessageForReplyText.mSourceMsgInfo.mAnonymousNickName = paramView.c;
          }
        }
      }
      else
      {
        paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.istroop, paramMessageForReplyText.frienduin, paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin + "");
        continue;
        break;
        return paramContext;
        i = 0;
        continue;
      }
      label1210:
      label1212:
      paramView = "";
    }
  }
  
  private View c(View paramView, Context paramContext, ver paramver, MessageForReplyText paramMessageForReplyText, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramver.jdField_e_of_type_Int = 2;
    paramContext = this.jdField_a_of_type_Ves.a(2);
    if (paramContext == null)
    {
      paramContext = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969949, null);
      paramView = (BubbleImageView)paramContext.findViewById(2131368538);
      paramView.setAdjustViewBounds(false);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setShowEdge(false);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
      paramView = (BubbleImageView)paramContext.findViewById(2131368539);
      paramView.setAdjustViewBounds(false);
      paramView.setRadius(15.0F);
      paramView.d(false);
      paramView.setShowEdge(false);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramver.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
      paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramContext.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramContext.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    for (;;)
    {
      paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramContext.findViewById(2131368538));
      paramver.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramContext.findViewById(2131368539));
      paramver.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131368537));
      paramver.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(paramMessageForReplyText);
      paramver.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$LightReplyMsgRich2 = new MessageForReplyText.LightReplyMsgRich2(paramMessageForReplyText.mSourceMsgInfo.mRichMsg2);
      int i = paramver.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$LightReplyMsgRich2.msgType;
      paramOnLongClickAndTouchListener = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
      if ((i == 0) && ((paramOnLongClickAndTouchListener instanceof MessageForPic))) {
        paramView = paramOnLongClickAndTouchListener;
      }
      while (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ChatItemBuilder", 2, "picMsg == null, sourcemsgseq:" + paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
        }
        a(paramver, paramMessageForReplyText, paramver.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$LightReplyMsgRich2.subMsgId);
        return paramContext;
        if ((i == 1) && ((paramOnLongClickAndTouchListener instanceof MessageForMixedMsg)))
        {
          if ((MessageForMixedMsg)paramOnLongClickAndTouchListener == null)
          {
            if (!QLog.isColorLevel()) {
              break label457;
            }
            QLog.e("ChatItemBuilder", 2, "mixedMsg == null, sourcemsgseq:" + paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
            paramView = null;
          }
          for (;;)
          {
            break;
            paramOnLongClickAndTouchListener = (MessageRecord)((MessageForMixedMsg)paramOnLongClickAndTouchListener).msgElemList.get(paramver.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$LightReplyMsgRich2.subMsgId);
            paramView = paramOnLongClickAndTouchListener;
            if (!(paramOnLongClickAndTouchListener instanceof MessageForPic)) {
              label457:
              paramView = null;
            }
          }
        }
        if (i == 2)
        {
          paramView = paramOnLongClickAndTouchListener;
          if ((paramOnLongClickAndTouchListener instanceof MessageForTroopFile)) {}
        }
        else
        {
          paramView = null;
        }
      }
      a(paramver, paramMessageForReplyText, paramView);
      return paramContext;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (localMessageForReplyText.mSourceMsgInfo == null) {
      return super.a(paramChatMessage);
    }
    switch (localMessageForReplyText.mSourceMsgInfo.mType)
    {
    default: 
      return super.a(paramChatMessage);
    }
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForReplyText)paramChatMessage;
    if (paramView != null)
    {
      localver = (ver)paramView.getTag();
      this.jdField_a_of_type_Ves.a(localver.jdField_e_of_type_Int, paramView);
    }
    ver localver = (ver)paramViewHolder;
    if (paramBaseChatItemLayout.mSourceMsgInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "text.mSourceMsgInfo为null, text:" + paramBaseChatItemLayout.toString());
      }
      paramViewHolder = this.jdField_a_of_type_Ves.a(0);
      if (paramViewHolder != null) {
        break label561;
      }
      paramViewHolder = new LinearLayout(localContext);
      paramViewHolder.setOrientation(1);
      paramView = new ETTextView(localContext);
      paramView.setTextColor(localContext.getResources().getColorStateList(2131494227));
      paramView.setLinkTextColor(localContext.getResources().getColorStateList(2131494224));
      paramView.setEditableFactory(QQTextBuilder.a);
      paramView.setSpannableFactory(QQText.a);
      paramView.setMaxWidth(BaseChatItemLayout.jdField_d_of_type_Int);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      int j = BaseChatItemLayout.n;
      int i = BaseChatItemLayout.o;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.o;
        i = BaseChatItemLayout.n;
      }
      paramView.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
      paramView.setId(2131363575);
      localver.jdField_e_of_type_AndroidWidgetTextView = paramView;
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = AIOUtils.a(5.0F, localContext.getResources());
      paramViewHolder.addView(localver.jdField_e_of_type_AndroidWidgetTextView, paramView);
    }
    label561:
    for (;;)
    {
      ((ETTextView)localver.jdField_e_of_type_AndroidWidgetTextView).setFont(0, paramChatMessage.uniseq);
      localver.jdField_e_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      localver.jdField_e_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.sb);
      super.a(localver.jdField_e_of_type_AndroidWidgetTextView, paramChatMessage);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localver.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      localver.jdField_e_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramChatMessage = paramViewHolder;
      if ((localver.jdField_e_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        ((AnimationTextView)localver.jdField_e_of_type_AndroidWidgetTextView).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
        paramChatMessage = paramViewHolder;
      }
      for (;;)
      {
        if (paramChatMessage != null)
        {
          paramChatMessage.setTag(localver);
          if ((paramBaseChatItemLayout.mSourceMsgInfo == null) || (paramBaseChatItemLayout.mSourceMsgInfo.mType != 1)) {
            break;
          }
          paramChatMessage.setPadding(5, 5, 5, 5);
        }
        return paramChatMessage;
        switch (paramBaseChatItemLayout.mSourceMsgInfo.mType)
        {
        default: 
          paramChatMessage = a(paramView, localContext, localver, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
          break;
        case 1: 
          if (!TextUtils.isEmpty(paramBaseChatItemLayout.mSourceMsgInfo.mRichMsg))
          {
            paramChatMessage = b(paramView, localContext, localver, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
          }
          else
          {
            paramBaseChatItemLayout.mSourceMsgInfo.mType = 0;
            paramChatMessage = a(paramView, localContext, localver, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
          }
          break;
        case 2: 
          paramChatMessage = c(paramView, localContext, localver, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
        }
      }
      paramChatMessage.setPadding(0, 0, 0, 0);
      return paramChatMessage;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ver(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ves.a();
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    }
    do
    {
      do
      {
        return;
        Bundle localBundle = new Bundle();
        localBundle.putInt("forward_type", -1);
        paramContext = (MessageForReplyText)paramChatMessage;
        if (paramContext.sb != null) {}
        for (paramContext = paramContext.sb.toString();; paramContext = paramContext.msg)
        {
          localBundle.putString("forward_text", paramContext);
          paramContext = new Intent();
          paramContext.putExtras(localBundle);
          ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          return;
        }
        if (((MessageForReplyText)paramChatMessage).mSourceMsgInfo.mType != 1) {
          break;
        }
      } while ((c()) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
      paramContext = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (paramContext != null)
      {
        paramContext.a().b(paramChatMessage, 1);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatItemBuilder", 2, "getChatFragment == null in reply");
    return;
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForReplyText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433635);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433636);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ven(this, paramView), new veo(this)).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (ver)paramView.getTag();
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramChatMessage;
    if (localMessageForReplyText.mSourceMsgInfo == null) {}
    label169:
    do
    {
      do
      {
        return;
        switch (localMessageForReplyText.mSourceMsgInfo.mType)
        {
        case 2: 
        default: 
          if (!paramChatMessage.isSend()) {
            break;
          }
          paramView.jdField_a_of_type_AndroidWidgetTextView.setPadding(g, jdField_d_of_type_Int, 0, 0);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, jdField_d_of_type_Int, f, 0);
          paramView.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(0, 0, f, 0);
          paramView.jdField_e_of_type_AndroidWidgetTextView.setPadding(g, 0, f, jdField_e_of_type_Int);
          return;
        case 1: 
          if (!paramChatMessage.isSend()) {
            break label169;
          }
          paramView.jdField_e_of_type_AndroidWidgetTextView.setPadding(g, 0, f, jdField_e_of_type_Int);
        }
      } while (paramView.jdField_b_of_type_AndroidViewViewGroup == null);
      paramView.jdField_b_of_type_AndroidViewViewGroup.setPadding(g, jdField_d_of_type_Int, f, 0);
      return;
      paramView.jdField_e_of_type_AndroidWidgetTextView.setPadding(f, 0, g, jdField_e_of_type_Int);
    } while (paramView.jdField_b_of_type_AndroidViewViewGroup == null);
    paramView.jdField_b_of_type_AndroidViewViewGroup.setPadding(f, jdField_d_of_type_Int, g, 0);
    return;
    paramView.jdField_a_of_type_AndroidWidgetTextView.setPadding(f, jdField_d_of_type_Int, 0, 0);
    paramView.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, jdField_d_of_type_Int, g, 0);
    paramView.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(0, 0, g, 0);
    paramView.jdField_e_of_type_AndroidWidgetTextView.setPadding(f, 0, g, jdField_e_of_type_Int);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    ver localver = (ver)paramViewHolder;
    paramViewHolder = (MessageForReplyText)paramChatMessage;
    if (paramViewHolder.mSourceMsgInfo == null) {
      return;
    }
    switch (paramViewHolder.mSourceMsgInfo.mType)
    {
    default: 
      if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a())) {
        break label538;
      }
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131494230);
        localver.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        localver.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        localver.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        localver.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
        localver.jdField_b_of_type_AndroidViewView.setBackgroundColor(paramViewHolder.getDefaultColor());
        if (!paramChatMessage.isSend()) {
          break label527;
        }
      }
      break;
    }
    label527:
    for (paramViewHolder = paramView.getColorStateList(2131494229);; paramViewHolder = paramView.getColorStateList(2131494228))
    {
      localver.jdField_e_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
      localver.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
      ImmersiveUtils.a(localver.jdField_a_of_type_AndroidWidgetTextView, 0.5F);
      ImmersiveUtils.a(localver.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      ImmersiveUtils.a(localver.jdField_b_of_type_AndroidViewView, 0.5F);
      return;
      if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramViewHolder = paramView.getColorStateList(2131494230);
          localver.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
          if (!paramChatMessage.isSend()) {
            break label312;
          }
        }
        label312:
        for (paramViewHolder = paramView.getColorStateList(2131494229);; paramViewHolder = paramView.getColorStateList(2131494228))
        {
          localver.jdField_e_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
          ImmersiveUtils.a(localver.jdField_a_of_type_AndroidWidgetTextView, 0.5F);
          ImmersiveUtils.a(localver.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
          ImmersiveUtils.a(localver.jdField_b_of_type_AndroidViewView, 0.5F);
          return;
          paramViewHolder = paramView.getColorStateList(2131494227);
          break;
        }
      }
      if (paramBubbleInfo.jdField_b_of_type_Int == 0)
      {
        localver.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (paramBubbleInfo.c != 0) {
          break label501;
        }
        paramViewHolder = paramView.getResources().getColorStateList(2131494228);
        localver.jdField_e_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
      }
      for (;;)
      {
        label370:
        if ((!paramBubbleInfo.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localver.jdField_e_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localver.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) != 1)) {
          break label672;
        }
        paramViewHolder = (ETTextView)localver.jdField_e_of_type_AndroidWidgetTextView;
        float f2 = paramViewHolder.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramViewHolder.setTextColor(-1);
        paramViewHolder.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.jdField_d_of_type_Int);
        return;
        localver.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        break;
        label501:
        localver.jdField_e_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
      }
      paramViewHolder = paramView.getColorStateList(2131494227);
      break;
    }
    label538:
    if (paramBubbleInfo.jdField_b_of_type_Int == 0)
    {
      localver.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localver.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localver.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localver.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localver.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
      label601:
      if (paramBubbleInfo.c != 0) {
        break label742;
      }
      paramViewHolder = paramView.getResources().getColorStateList(2131494228);
      localver.jdField_e_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
      localver.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
    }
    for (;;)
    {
      ImmersiveUtils.a(localver.jdField_a_of_type_AndroidWidgetTextView, 0.5F);
      ImmersiveUtils.a(localver.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      ImmersiveUtils.a(localver.jdField_b_of_type_AndroidViewView, 0.5F);
      break label370;
      label672:
      break;
      localver.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localver.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localver.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localver.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localver.jdField_b_of_type_AndroidViewView.setBackgroundColor(paramBubbleInfo.jdField_b_of_type_Int);
      break label601;
      label742:
      localver.jdField_e_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
      localver.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.c);
    }
  }
  
  public void a(MessageForReplyText paramMessageForReplyText, MessageRecord paramMessageRecord, View paramView)
  {
    boolean bool;
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity))
    {
      bool = true;
      if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {
        break label65;
      }
      paramMessageForReplyText = (MessageForUniteGrayTip)paramMessageRecord;
      if ((paramMessageForReplyText.tipParam != null) && (paramMessageForReplyText.tipParam.jdField_b_of_type_Int == 1)) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "图片已过期或被删除", 0).a();
      }
    }
    label65:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if ((paramMessageRecord instanceof MessageForPic))
        {
          paramMessageForReplyText = (MessageForPic)paramMessageRecord;
          PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, paramMessageForReplyText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool);
          return;
        }
        if (!(paramMessageRecord instanceof MessageForMixedMsg)) {
          break label155;
        }
        paramMessageForReplyText = new MessageForReplyText.LightReplyMsgRich2(paramMessageForReplyText.mSourceMsgInfo.mRichMsg2);
        paramMessageForReplyText = a((MessageForMixedMsg)paramMessageRecord, paramMessageForReplyText.subMsgId);
      } while (paramMessageForReplyText == null);
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, paramMessageForReplyText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool);
      return;
    } while (!(paramMessageRecord instanceof MessageForTroopFile));
    label155:
    paramMessageForReplyText = (MessageForTroopFile)paramMessageRecord;
    PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, paramMessageForReplyText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool);
  }
  
  protected void a(ver paramver, MessageForReplyText paramMessageForReplyText, int paramInt)
  {
    ThreadManager.post(new vek(this, paramMessageForReplyText, paramInt, paramver), 8, null, true);
  }
  
  public void a(ver paramver, MessageForReplyText paramMessageForReplyText, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "startAnimate replymessage:" + paramMessageForReplyText.toString());
    }
    ImageExplodeLayout localImageExplodeLayout = new ImageExplodeLayout(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_b_of_type_Int * 7.0F / 3.0F), (int)(this.jdField_b_of_type_Int * 4.0F / 3.0F));
    localLayoutParams.addRule(12);
    int[] arrayOfInt = new int[2];
    paramver.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.getLocationOnScreen(arrayOfInt);
    localLayoutParams.leftMargin = (arrayOfInt[0] - this.jdField_b_of_type_Int * 2 / 3 - AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localImageExplodeLayout.setLayoutParams(localLayoutParams);
    paramver.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(localImageExplodeLayout);
    localImageExplodeLayout.setDrawble(paramURLDrawable, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    paramMessageForReplyText.setAnimationPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(ver paramver, MessageForReplyText paramMessageForReplyText, MessageRecord paramMessageRecord)
  {
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramver.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag();
    if ((localMessageForReplyText == null) || (localMessageForReplyText.shmsgseq != paramMessageForReplyText.shmsgseq)) {}
    label79:
    label355:
    do
    {
      return;
      Object localObject1;
      if (paramMessageRecord == null)
      {
        paramMessageForReplyText = TroopFileItemBuilder.a(2, 200, 200);
        paramMessageRecord = (LinearLayout.LayoutParams)paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
        paramMessageRecord.width = 200;
        paramMessageRecord.height = 200;
        paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramMessageForReplyText);
        paramMessageForReplyText = (RelativeLayout.LayoutParams)paramver.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
        paramMessageRecord = (LinearLayout.LayoutParams)paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
        localObject1 = (RelativeLayout.LayoutParams)paramver.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        if (!a(localMessageForReplyText)) {
          break label841;
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (this.jdField_b_of_type_Int / 2);
        paramMessageForReplyText.leftMargin = 0;
      }
      for (;;)
      {
        if (paramver.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$LightReplyMsgRich2 != null) {
          break label902;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "renderingPicCommentUI, mLightReplyMsgRich2 = " + paramver.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$LightReplyMsgRich2);
        return;
        int j;
        int i;
        if ((paramMessageRecord instanceof MessageForPic))
        {
          paramMessageForReplyText = (MessageForPic)paramMessageRecord;
          paramMessageRecord = new int[2];
          tmp199_198 = paramMessageRecord;
          tmp199_198[0] = 0;
          tmp203_199 = tmp199_198;
          tmp203_199[1] = 0;
          tmp203_199;
          PicItemBuilder.a(paramMessageForReplyText);
          localObject1 = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramMessageForReplyText, paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramMessageRecord);
          paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(2131361894, paramMessageForReplyText);
          Object localObject2;
          int k;
          int m;
          if ((paramMessageRecord[0] > 0) && (paramMessageRecord[1] > 0))
          {
            localObject2 = (LinearLayout.LayoutParams)paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
            boolean bool = PeakUtils.a(paramMessageForReplyText.imageType);
            j = URLDrawableHelper.a(bool);
            i = URLDrawableHelper.b(bool);
            if (paramMessageRecord[0] > j)
            {
              k = j;
              if (paramMessageRecord[1] <= j) {
                break label554;
              }
              k = k * 75 / 100;
              m = j * 75 / 100;
              j = k;
              if (k < i) {
                j = i;
              }
              ((LinearLayout.LayoutParams)localObject2).width = j;
              if (m >= i) {
                break label562;
              }
              ((LinearLayout.LayoutParams)localObject2).height = i;
            }
          }
          else
          {
            paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(((URLDrawable)localObject1).mutate());
            localObject2 = ((URLDrawable)localObject1).getURL().getProtocol();
            URL localURL = URLDrawableHelper.a(paramMessageForReplyText, 65537);
            AbsDownloader.d(localURL.toString());
            if (!PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, PeakUtils.a(paramMessageForReplyText.imageType), ((String)localObject2).equals("chatthumb"), paramMessageRecord[0], paramMessageRecord[1], localURL)) {
              break label569;
            }
            ((URLDrawable)localObject1).setWatermarkDrawable(PicItemBuilder.a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((URLDrawable)localObject1).setWatermarkVisibility(0);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "getPicCommentBubbleView,set picmsg, picDrawable " + localObject1 + ",picMsg = " + paramMessageForReplyText);
            }
            a((URLDrawable)localObject1);
            if (paramMessageForReplyText.isSendFromLocal()) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForReplyText, 2);
            break;
            k = paramMessageRecord[0];
            break label298;
            j = paramMessageRecord[1];
            break label306;
            i = m;
            break label355;
            ((URLDrawable)localObject1).setWatermarkVisibility(4);
          }
        }
        if ((paramMessageRecord instanceof MessageForTroopFile))
        {
          paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
          paramMessageRecord.doParse();
          paramMessageForReplyText = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
          if ((TextUtils.isEmpty(paramMessageForReplyText.d)) || (!FileUtils.a(paramMessageForReplyText.d)))
          {
            if (paramMessageForReplyText.jdField_b_of_type_Boolean)
            {
              paramMessageForReplyText = TroopFileItemBuilder.a(2, 200, 200);
              paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramMessageForReplyText);
              break label79;
            }
            paramMessageRecord = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(localMessageForReplyText.frienduin));
            paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(TroopFileItemBuilder.a(1, 200, 200));
            if (paramMessageForReplyText.a != null)
            {
              paramMessageRecord.a(paramMessageForReplyText.a, 383);
              break label79;
            }
            paramMessageRecord.a(paramMessageForReplyText.jdField_e_of_type_JavaLangString, paramMessageForReplyText.g, paramMessageForReplyText.jdField_e_of_type_Int, 383);
            break label79;
          }
          paramMessageForReplyText = TroopFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForReplyText, paramMessageRecord);
          if (paramMessageForReplyText == null) {
            break label79;
          }
          i = paramMessageForReplyText.getIntrinsicHeight() * 75 / 100;
          j = paramMessageForReplyText.getIntrinsicWidth() * 75 / 100;
          paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramMessageForReplyText.mutate());
          if ((i <= 0) || (j <= 0)) {
            break label79;
          }
          paramMessageForReplyText = (LinearLayout.LayoutParams)paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
          paramMessageForReplyText.width = j;
          paramMessageForReplyText.height = i;
          break label79;
        }
        paramMessageForReplyText = TroopFileItemBuilder.a(2, 200, 200);
        paramver.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramMessageForReplyText);
        break label79;
        if (paramMessageRecord.width < this.jdField_b_of_type_Int / 2)
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = (this.jdField_b_of_type_Int / 2 - paramMessageRecord.width);
          paramMessageForReplyText.leftMargin = 0;
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
          paramMessageForReplyText.leftMargin = (paramMessageRecord.width - this.jdField_b_of_type_Int / 2);
        }
      }
      paramMessageForReplyText = (LightReplyEmojs)LightReplyMenuManager.a().a.get(paramver.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$LightReplyMsgRich2.emotionId);
      if ((paramMessageForReplyText == null) || (TextUtils.isEmpty(paramMessageForReplyText.bigUrl))) {
        break label1070;
      }
      PicItemBuilder.e();
      paramMessageForReplyText = URLDrawableHelper.a(paramMessageForReplyText.bigUrl, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable, true, 0.0F);
      if (paramMessageForReplyText != null) {
        paramver.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramMessageForReplyText.mutate());
      }
      if (paramMessageForReplyText.getStatus() != 1) {
        break;
      }
    } while ((localMessageForReplyText.mIsPlayedPicCommentAnimate) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) || (!a(localMessageForReplyText.uniseq)));
    label298:
    label306:
    label569:
    label841:
    ThreadManager.getUIHandler().post(new veh(this, paramver, localMessageForReplyText, paramMessageForReplyText));
    label554:
    label562:
    return;
    label902:
    paramMessageForReplyText.setDownloadListener(new vei(this, localMessageForReplyText, paramver, paramMessageForReplyText));
    if (paramMessageForReplyText.getStatus() == 2)
    {
      paramMessageForReplyText.restartDownload();
      return;
    }
    paramMessageForReplyText.startDownload();
    return;
    label1070:
    paramver.jdField_b_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130841441);
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      int j = AIOUtils.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      int i = j;
      if (j < m) {
        i = j + n;
      }
      if ((i > m) && (k > 0)) {}
      View localView;
      do
      {
        return true;
        localView = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, i);
        if (localView == null) {
          return false;
        }
      } while (localView.getHeight() > AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */