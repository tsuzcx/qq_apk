package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgDBHelper.NotifyMsgRecord;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class QQWalletTransMsgItemBuilder
  extends BaseBubbleBuilder
{
  public static final String a;
  private static int t;
  private static int u;
  private static int v;
  private View.OnClickListener a;
  protected NotifyMsgObserver a;
  protected HashMap<String, SparseArray<WeakReference<QQWalletTransMsgItemBuilder.QWalletTransMsgHolder>>> a;
  protected float b;
  final String b;
  protected final int c;
  long jdField_c_of_type_Long;
  final String jdField_c_of_type_JavaLangString = "pfa";
  protected final int d;
  protected String d;
  protected final int e = 2131375393;
  protected final int f = 2131375400;
  protected final int g = 2131375392;
  protected final int h = 2131375391;
  protected final int i = 2131375395;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQWalletTransMsgItemBuilder.class.getSimpleName();
  }
  
  public QQWalletTransMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = 2131375376;
    this.jdField_d_of_type_Int = 2131375405;
    this.jdField_b_of_type_JavaLangString = "pay";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QQWalletTransMsgItemBuilder.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgObserver = new QQWalletTransMsgItemBuilder.2(this);
    this.jdField_d_of_type_JavaLangString = paramContext.getString(2131717133);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.k = ((int)(42.0F * this.jdField_b_of_type_Float + 0.5F));
    this.l = ((int)(21.0F * this.jdField_b_of_type_Float + 0.5F));
    this.m = ((int)(15.0F * this.jdField_b_of_type_Float + 0.5F));
    this.n = ((int)(10.0F * this.jdField_b_of_type_Float + 0.5F));
    this.o = ((int)(9.0F * this.jdField_b_of_type_Float + 0.5F));
    this.p = ((int)(6.5F * this.jdField_b_of_type_Float + 0.5F));
    this.q = ((int)(4.0F * this.jdField_b_of_type_Float + 0.5F));
    this.r = ((int)(this.jdField_b_of_type_Float * 1.0F + 0.5F));
    this.j = (this.n * 23);
    this.s = ((int)(7.0F * this.jdField_b_of_type_Float + 0.5F));
    t = this.r * 2;
    u = this.r * 2;
    v = this.s;
  }
  
  private RelativeLayout a(QQWalletTransMsgItemBuilder.QWalletTransMsgHolder paramQWalletTransMsgHolder, Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.j, this.m * 5));
    localQQWalletTransferBubbleView.setId(2131375376);
    ImageView localImageView = new ImageView(paramContext);
    Object localObject1 = new RelativeLayout.LayoutParams(this.k, this.k);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setId(2131375405);
    localQQWalletTransferBubbleView.addView(localImageView);
    Object localObject2 = new LinearLayout(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131375405);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.p;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject1).setTextSize(24.0F);
    ((TextView)localObject1).setId(2131375393);
    ((LinearLayout)localObject2).addView((View)localObject1);
    TextView localTextView = new TextView(paramContext);
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).topMargin = this.r;
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localTextView.setSingleLine();
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextSize(13.0F);
    localTextView.setId(2131375400);
    ((LinearLayout)localObject2).addView(localTextView);
    localQQWalletTransferBubbleView.addView((View)localObject2);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localObject2 = new QQWalletTransferBubbleView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(this.j, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131375376);
    ((QQWalletTransferBubbleView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((QQWalletTransferBubbleView)localObject2).setBackgroundResource(2130847612);
    ((QQWalletTransferBubbleView)localObject2).setId(2131375392);
    paramContext = new TextView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = this.m;
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = this.m;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131375391);
    ((QQWalletTransferBubbleView)localObject2).addView(paramContext);
    localRelativeLayout.addView((View)localObject2);
    paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    paramQWalletTransMsgHolder.jdField_b_of_type_AndroidWidgetTextView = localTextView;
    paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    paramQWalletTransMsgHolder.c = paramContext;
    paramQWalletTransMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView = ((QQWalletTransferBubbleView)localObject2);
    paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView = localQQWalletTransferBubbleView;
    return localRelativeLayout;
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.n;
    localLayoutParams.bottomMargin = this.p;
    localLayoutParams.leftMargin = (this.k + this.q);
    localLayoutParams.rightMargin = (this.k + this.q);
    localLayoutParams.addRule(3, 2131364634);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130844888);
    paramContext.setPadding(this.o, this.q, this.o, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.q, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131375395);
    return paramContext;
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (paramString == null)) {
      return;
    }
    paramTextView.setTextSize(24.0F);
    TextPaint localTextPaint = paramTextView.getPaint();
    float f1;
    if (localTextPaint != null)
    {
      f1 = localTextPaint.measureText(paramString);
      if (this.j <= BaseChatItemLayout.e) {
        break label73;
      }
      if (f1 > BaseChatItemLayout.e - this.n * 9) {
        paramTextView.setTextSize(14.0F);
      }
    }
    for (;;)
    {
      paramTextView.setText(paramString);
      return;
      label73:
      if (f1 > this.n * 14) {
        paramTextView.setTextSize(14.0F);
      }
    }
  }
  
  private void a(QQWalletTransMsgItemBuilder.QWalletTransMsgHolder paramQWalletTransMsgHolder, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, boolean paramBoolean, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramMessageForQQWalletMsg.messageType == 16) {}
    for (int i1 = 1;; i1 = 0)
    {
      a(paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView, paramQQWalletBaseMsgElem.title);
      paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramQQWalletBaseMsgElem.titleColor);
      paramQWalletTransMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramQQWalletBaseMsgElem.subTitle);
      paramQWalletTransMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramQQWalletBaseMsgElem.subtitleColor);
      paramQWalletTransMsgHolder.c.setText(paramQQWalletBaseMsgElem.content);
      if (i1 != 0)
      {
        Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(a(paramQQWalletBaseMsgElem.icon));
        if (!TextUtils.isEmpty(paramQQWalletBaseMsgElem.iconUrl)) {
          localObject = URLDrawableHelper.getDrawable(paramQQWalletBaseMsgElem.iconUrl, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, this.k), (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, this.k), null, null);
        }
        paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().waitAppRuntime(null), false, null))
      {
        paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleNightBackground(2130847611, Color.parseColor("#FF19BAFF"), paramBoolean);
        paramQWalletTransMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130847612, Color.parseColor("#A4A5A8"), paramBoolean);
        paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#B2B2B2"));
        paramQWalletTransMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#B2B2B2"));
        paramQWalletTransMsgHolder.c.setTextColor(Color.parseColor("#5D616B"));
      }
      for (;;)
      {
        paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramQQWalletBaseMsgElem.title + paramQQWalletBaseMsgElem.subTitle + this.jdField_d_of_type_JavaLangString);
        paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
        if (i1 != 0) {
          a(paramQWalletTransMsgHolder, paramMessageForQQWalletMsg, paramQQWalletBaseMsgElem);
        }
        return;
        if (SimpleUIUtil.a())
        {
          paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130847611, Color.parseColor("#FF19BAFF"), paramBoolean);
          paramQWalletTransMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130847612, Color.parseColor("#FFECEDF2"), paramBoolean);
          paramQWalletTransMsgHolder.c.setTextColor(Color.parseColor("#FF878B99"));
        }
        else
        {
          paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130847611, paramQQWalletBaseMsgElem.background, paramBoolean);
          if (paramQQWalletBaseMsgElem.contentBgColor != 0) {
            paramQWalletTransMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView.setBubbleBackground(2130847612, paramQQWalletBaseMsgElem.contentBgColor, paramBoolean);
          }
          if (paramQQWalletBaseMsgElem.contentColor != 0) {
            paramQWalletTransMsgHolder.c.setTextColor(paramQQWalletBaseMsgElem.contentColor);
          }
        }
      }
    }
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    paramString2 = paramString1.split("\\?");
    paramString3 = paramString2[0];
    if (TextUtils.isEmpty(paramString3)) {
      return false;
    }
    if (paramString2.length > 1) {
      paramString2 = paramMessageForQQWalletMsg.parseUrlParams(paramString2[1]);
    }
    while (paramString3.equals("pay"))
    {
      paramString1 = (String)paramString2.get("payData");
      paramString2 = (String)paramString2.get("reqCode");
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
      {
        return false;
        paramString2 = new HashMap();
      }
      else
      {
        paramMessageForQQWalletMsg = new Bundle();
        paramMessageForQQWalletMsg.putString("json", paramString1);
        paramMessageForQQWalletMsg.putString("callbackSn", "0");
        paramString1 = new Intent(paramContext, PayBridgeActivity.class);
        paramString1.putExtras(paramMessageForQQWalletMsg);
        paramString1.putExtra("pay_requestcode", Integer.valueOf(paramString2).intValue());
      }
    }
    label595:
    for (;;)
    {
      try
      {
        paramContext.startActivity(paramString1);
        return true;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramContext.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to startActivity : " + paramString3, paramContext);
        return false;
      }
      if (paramString3.equals("pfa"))
      {
        paramSessionInfo = (String)paramString2.get("data");
        paramMessageForQQWalletMsg = (String)paramString2.get("tokenid");
        if ((TextUtils.isEmpty(paramMessageForQQWalletMsg)) || (TextUtils.isEmpty(paramSessionInfo))) {
          return false;
        }
        paramString2 = new JSONObject();
        try
        {
          paramString2.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramString2.put("viewTag", "payByFriendConfirm");
          paramString2.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#paymsg");
          paramString2.put("comeForm", 2);
          paramSessionInfo = new JSONObject();
          paramSessionInfo.put("pfa_req", paramString1);
          paramSessionInfo.put("token_id", paramMessageForQQWalletMsg);
          paramString2.put("extra_data", paramSessionInfo);
          paramMessageForQQWalletMsg = new Bundle();
          paramMessageForQQWalletMsg.putString("json", paramString2.toString());
          paramMessageForQQWalletMsg.putString("callbackSn", "0");
          paramString1 = new Intent(paramContext, PayBridgeActivity.class);
          paramString1.putExtras(paramMessageForQQWalletMsg);
          paramString1.putExtra("pay_requestcode", 5);
        }
        catch (Exception paramString1)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          paramString1.printStackTrace();
          continue;
        }
      }
      else
      {
        try
        {
          paramString1 = QQWalletTransMsgItemBuilder.class.getClassLoader();
          if (paramString1 == null) {
            return false;
          }
          paramString1 = paramString1.loadClass(paramString3);
        }
        catch (Exception paramString1)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          paramString1.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletTransMsgItemBuilder failed to find Class : " + paramString3, paramString1);
          paramString1 = null;
          continue;
          paramString1 = new Intent(paramContext, paramString1);
          paramString2 = paramString2.entrySet().iterator();
          if (!paramString2.hasNext()) {
            break label595;
          }
        }
        if (paramString1 == null) {
          return false;
        }
        paramMessageForQQWalletMsg = (Map.Entry)paramString2.next();
        paramString1.putExtra((String)paramMessageForQQWalletMsg.getKey(), (String)paramMessageForQQWalletMsg.getValue());
      }
    }
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2130847610;
    case 1: 
      return 2130847613;
    case 3: 
      return 2130847614;
    case 4: 
      return 2130847597;
    case 5: 
      return 2130847596;
    }
    return 2130847595;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    QQWalletTransMsgItemBuilder.QWalletTransMsgHolder localQWalletTransMsgHolder = (QQWalletTransMsgItemBuilder.QWalletTransMsgHolder)paramViewHolder;
    paramViewHolder = null;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;
    }
    if ((paramViewHolder == null) || (paramViewHolder.mQQWalletTransferMsg == null)) {
      return null;
    }
    if ((localQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || ((localQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (localQWalletTransMsgHolder.jdField_a_of_type_Long != paramChatMessage.uniseq)))
    {
      localQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = a(localQWalletTransMsgHolder, this.jdField_a_of_type_AndroidContentContext);
      paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
    }
    localQWalletTransMsgHolder.jdField_a_of_type_Long = paramChatMessage.uniseq;
    paramView = paramViewHolder.mQQWalletTransferMsg.elem;
    if (paramView == null) {
      return localQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    boolean bool;
    if (!paramChatMessage.isSend())
    {
      bool = true;
      a(localQWalletTransMsgHolder, paramViewHolder, paramView, bool, paramOnLongClickAndTouchListener);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + paramViewHolder.mQQWalletTransferMsg.templateId, "", "", "");
      paramChatMessage = (TextView)paramBaseChatItemLayout.findViewById(2131375395);
      if (paramChatMessage != null)
      {
        if ((paramView == null) || (TextUtils.isEmpty(paramView.blackStripe))) {
          break label346;
        }
        paramChatMessage.setText(paramView.blackStripe);
        paramChatMessage.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramViewHolder.messageType == 16)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgObserver);
        if (!TextUtils.isEmpty(paramViewHolder.mQQWalletTransferMsg.listId))
        {
          paramView = (SparseArray)this.jdField_a_of_type_JavaUtilHashMap.get(paramViewHolder.mQQWalletTransferMsg.listId);
          paramChatMessage = paramView;
          if (paramView == null)
          {
            paramChatMessage = new SparseArray();
            this.jdField_a_of_type_JavaUtilHashMap.put(paramViewHolder.mQQWalletTransferMsg.listId, paramChatMessage);
          }
          paramChatMessage.put((int)paramViewHolder.uniseq, new WeakReference(localQWalletTransMsgHolder));
        }
      }
      return localQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
      bool = false;
      break;
      label346:
      paramChatMessage.setVisibility(8);
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new QQWalletTransMsgItemBuilder.QWalletTransMsgHolder(this);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    Object localObject = null;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      localObject = (MessageForQQWalletMsg)paramChatMessage;
    }
    if ((localObject == null) || (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null)) {
      return paramChatMessage.msg;
    }
    localObject = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (MessageRecordInfo.a(paramChatMessage.issend))
      {
        localStringBuilder.append("发出");
        if ((((QQWalletBaseMsgElem)localObject).content == null) || (!((QQWalletBaseMsgElem)localObject).content.contains("QQ转账"))) {
          break label125;
        }
        localStringBuilder.append("QQ转账").append(((QQWalletBaseMsgElem)localObject).title).append("按钮");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append("发来");
        break;
        label125:
        localStringBuilder.append("QQ转账").append(((QQWalletBaseMsgElem)localObject).title).append(((QQWalletBaseMsgElem)localObject).content).append("按钮");
      }
    }
    return paramChatMessage.msg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgObserver);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(u, v, t, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(t, v, u, paramView.getResources().getDimensionPixelSize(2131296402));
      return;
    }
    paramView.setPadding(t, v, u, 0);
  }
  
  protected void a(QQWalletTransMsgItemBuilder.QWalletTransMsgHolder paramQWalletTransMsgHolder, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletBaseMsgElem paramQQWalletBaseMsgElem)
  {
    int i2;
    boolean bool;
    if (paramMessageForQQWalletMsg.messageType == 16)
    {
      String str = paramQQWalletBaseMsgElem.title;
      i2 = -12727643;
      if ((paramMessageForQQWalletMsg.isSend()) || (paramQQWalletBaseMsgElem.isInAAPayer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()))) {
        break label132;
      }
      paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131717126);
      i1 = 2130847588;
      a(paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView, paramQQWalletBaseMsgElem);
      if ((i1 != 0) && (paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        paramQQWalletBaseMsgElem = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i1);
        paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramQQWalletBaseMsgElem);
      }
      if (paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView != null)
      {
        paramQWalletTransMsgHolder = paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqActivityQwalletQQWalletTransferBubbleView;
        if (paramMessageForQQWalletMsg.isSend()) {
          break label337;
        }
        bool = true;
        label120:
        paramQWalletTransMsgHolder.setBubbleBackground(2130847611, i2, bool);
      }
    }
    return;
    label132:
    paramQQWalletBaseMsgElem = NotifyMsgManager.a(1, paramMessageForQQWalletMsg.mQQWalletTransferMsg.listId, paramMessageForQQWalletMsg);
    if (paramQQWalletBaseMsgElem != null) {}
    for (int i1 = paramQQWalletBaseMsgElem.a("state", -1);; i1 = -1)
    {
      if (i1 == -1)
      {
        paramQQWalletBaseMsgElem = paramMessageForQQWalletMsg.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramQQWalletBaseMsgElem)) {}
      }
      for (;;)
      {
        try
        {
          int i3 = Integer.valueOf(paramQQWalletBaseMsgElem).intValue();
          i1 = i3;
          if (i1 != 1) {
            break label236;
          }
          paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131717132);
          i1 = 2130847589;
          i2 = -7676215;
        }
        catch (Exception paramQQWalletBaseMsgElem)
        {
          if (QLog.isColorLevel()) {
            paramQQWalletBaseMsgElem.printStackTrace();
          }
        }
      }
      label236:
      if (i1 == 2)
      {
        paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131717127);
        i1 = 2130847586;
        i2 = -7676215;
        break;
      }
      if (i1 == 3)
      {
        paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131717129);
        i1 = 2130847586;
        i2 = -7676215;
        break;
      }
      if (paramMessageForQQWalletMsg.isSend())
      {
        paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131717130);
        i1 = 2130847587;
        break;
      }
      paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131717128);
      i1 = 2130847587;
      break;
      label337:
      bool = false;
      break label120;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletTransMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */