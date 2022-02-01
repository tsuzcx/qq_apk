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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.mobileqq.qwallet.transaction.NotifyMsgObserver;
import com.tencent.mobileqq.qwallet.widget.QQWalletTransferBubbleView;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  public static final String a = "QQWalletTransMsgItemBuilder";
  private static int t;
  private static int u;
  private static int v;
  protected final int a;
  private View.OnClickListener a;
  protected NotifyMsgObserver a;
  protected HashMap<String, SparseArray<WeakReference<QQWalletTransMsgItemBuilder.QWalletTransMsgHolder>>> a;
  protected float b;
  final String b;
  long jdField_c_of_type_Long;
  final String jdField_c_of_type_JavaLangString = "pfa";
  protected final int d;
  protected String d;
  protected final int e;
  protected final int f = 2131374913;
  protected final int g = 2131374902;
  protected final int h = 2131374901;
  protected final int i = 2131374904;
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
  
  public QQWalletTransMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Int = 2131374889;
    this.jdField_d_of_type_Int = 2131374916;
    this.jdField_e_of_type_Int = 2131374903;
    this.jdField_b_of_type_JavaLangString = "pay";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QQWalletTransMsgItemBuilder.1(this);
    this.jdField_a_of_type_ComTencentMobileqqQwalletTransactionNotifyMsgObserver = new QQWalletTransMsgItemBuilder.2(this);
    this.jdField_d_of_type_JavaLangString = paramContext.getString(2131716792);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    float f1 = this.jdField_b_of_type_Float;
    this.k = ((int)(42.0F * f1 + 0.5F));
    this.l = ((int)(21.0F * f1 + 0.5F));
    this.m = ((int)(15.0F * f1 + 0.5F));
    this.n = ((int)(10.0F * f1 + 0.5F));
    this.o = ((int)(9.0F * f1 + 0.5F));
    this.p = ((int)(6.5F * f1 + 0.5F));
    this.q = ((int)(4.0F * f1 + 0.5F));
    this.r = ((int)(1.0F * f1 + 0.5F));
    this.j = (this.n * 23);
    this.s = ((int)(f1 * 7.0F + 0.5F));
    int i1 = this.r;
    t = i1 * 2;
    u = i1 * 2;
    v = this.s;
  }
  
  private RelativeLayout a(QQWalletTransMsgItemBuilder.QWalletTransMsgHolder paramQWalletTransMsgHolder, Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.j, this.m * 5));
    localQQWalletTransferBubbleView.setId(2131374889);
    ImageView localImageView = new ImageView(paramContext);
    int i1 = this.k;
    Object localObject1 = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setId(2131374916);
    localQQWalletTransferBubbleView.addView(localImageView);
    Object localObject2 = new LinearLayout(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131374916);
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
    ((TextView)localObject1).setId(2131374903);
    ((LinearLayout)localObject2).addView((View)localObject1);
    TextView localTextView = new TextView(paramContext);
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).topMargin = this.r;
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localTextView.setSingleLine();
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextSize(13.0F);
    localTextView.setId(2131374913);
    ((LinearLayout)localObject2).addView(localTextView);
    localQQWalletTransferBubbleView.addView((View)localObject2);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localObject2 = new QQWalletTransferBubbleView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(this.j, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131374889);
    ((QQWalletTransferBubbleView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((QQWalletTransferBubbleView)localObject2).setBackgroundResource(2130847480);
    ((QQWalletTransferBubbleView)localObject2).setId(2131374902);
    paramContext = new TextView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    i1 = this.l;
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = i1;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = i1;
    i1 = this.m;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = i1;
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = i1;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131374901);
    ((QQWalletTransferBubbleView)localObject2).addView(paramContext);
    localRelativeLayout.addView((View)localObject2);
    paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    paramQWalletTransMsgHolder.jdField_b_of_type_AndroidWidgetTextView = localTextView;
    paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    paramQWalletTransMsgHolder.c = paramContext;
    paramQWalletTransMsgHolder.jdField_a_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView = ((QQWalletTransferBubbleView)localObject2);
    paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView = localQQWalletTransferBubbleView;
    return localRelativeLayout;
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.n;
    localLayoutParams.bottomMargin = this.p;
    int i1 = this.k;
    int i2 = this.q;
    localLayoutParams.leftMargin = (i1 + i2);
    localLayoutParams.rightMargin = (i1 + i2);
    localLayoutParams.addRule(3, 2131364521);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130844764);
    i1 = this.o;
    paramContext.setPadding(i1, this.q, i1, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.q, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131374904);
    return paramContext;
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (paramTextView != null)
    {
      if (paramString == null) {
        return;
      }
      paramTextView.setTextSize(24.0F);
      TextPaint localTextPaint = paramTextView.getPaint();
      if (localTextPaint != null)
      {
        float f1 = localTextPaint.measureText(paramString);
        if (this.j > BaseChatItemLayout.jdField_e_of_type_Int)
        {
          if (f1 > BaseChatItemLayout.jdField_e_of_type_Int - this.n * 9) {
            paramTextView.setTextSize(14.0F);
          }
        }
        else if (f1 > this.n * 14) {
          paramTextView.setTextSize(14.0F);
        }
      }
      paramTextView.setText(paramString);
    }
  }
  
  private void a(QQWalletTransMsgItemBuilder.QWalletTransMsgHolder paramQWalletTransMsgHolder, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, boolean paramBoolean, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int i1;
    if (paramMessageForQQWalletMsg.messageType == 16) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    a(paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView, paramQQWalletBaseMsgElem.jdField_a_of_type_JavaLangString);
    paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramQQWalletBaseMsgElem.jdField_c_of_type_Int);
    paramQWalletTransMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramQQWalletBaseMsgElem.jdField_b_of_type_JavaLangString);
    paramQWalletTransMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramQQWalletBaseMsgElem.jdField_d_of_type_Int);
    paramQWalletTransMsgHolder.c.setText(paramQQWalletBaseMsgElem.jdField_c_of_type_JavaLangString);
    if (i1 != 0)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(a(paramQQWalletBaseMsgElem.jdField_b_of_type_Int));
      if (!TextUtils.isEmpty(paramQQWalletBaseMsgElem.j)) {
        localObject = URLDrawableHelper.getDrawable(paramQQWalletBaseMsgElem.j, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, this.k), (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, this.k), null, null);
      }
      paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().waitAppRuntime(null), false, null))
    {
      paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView.setBubbleNightBackground(2130847479, Color.parseColor("#FF19BAFF"), paramBoolean);
      paramQWalletTransMsgHolder.jdField_a_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView.setBubbleBackground(2130847480, Color.parseColor("#A4A5A8"), paramBoolean);
      paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#B2B2B2"));
      paramQWalletTransMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#B2B2B2"));
      paramQWalletTransMsgHolder.c.setTextColor(Color.parseColor("#5D616B"));
    }
    else if (SimpleUIUtil.a())
    {
      paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView.setBubbleBackground(2130847479, Color.parseColor("#FF19BAFF"), paramBoolean);
      paramQWalletTransMsgHolder.jdField_a_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView.setBubbleBackground(2130847480, Color.parseColor("#FFECEDF2"), paramBoolean);
      paramQWalletTransMsgHolder.c.setTextColor(Color.parseColor("#FF878B99"));
    }
    else
    {
      paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView.setBubbleBackground(2130847479, paramQQWalletBaseMsgElem.jdField_a_of_type_Int, paramBoolean);
      if (paramQQWalletBaseMsgElem.f != 0) {
        paramQWalletTransMsgHolder.jdField_a_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView.setBubbleBackground(2130847480, paramQQWalletBaseMsgElem.f, paramBoolean);
      }
      if (paramQQWalletBaseMsgElem.jdField_e_of_type_Int != 0) {
        paramQWalletTransMsgHolder.c.setTextColor(paramQQWalletBaseMsgElem.jdField_e_of_type_Int);
      }
    }
    Object localObject = paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQWalletBaseMsgElem.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramQQWalletBaseMsgElem.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
    paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
    if (i1 != 0) {
      a(paramQWalletTransMsgHolder, paramMessageForQQWalletMsg, paramQQWalletBaseMsgElem);
    }
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString2 = paramString1.split("\\?");
      paramSessionInfo = paramString2[0];
      if (TextUtils.isEmpty(paramSessionInfo)) {
        return false;
      }
      if (paramString2.length > 1) {
        paramString2 = paramMessageForQQWalletMsg.parseUrlParams(paramString2[1]);
      } else {
        paramString2 = new HashMap();
      }
      if (paramSessionInfo.equals("pay"))
      {
        paramString1 = (String)paramString2.get("payData");
        paramString2 = (String)paramString2.get("reqCode");
        if (!TextUtils.isEmpty(paramString2))
        {
          if (TextUtils.isEmpty(paramString1)) {
            return false;
          }
          paramString3 = new Bundle();
          paramString3.putString("json", paramString1);
          paramString3.putString("callbackSn", "0");
          paramString1 = new Intent(paramContext, PayBridgeActivity.class);
          paramString1.putExtras(paramString3);
          paramString1.putExtra("pay_requestcode", Integer.valueOf(paramString2).intValue());
        }
        else
        {
          return false;
        }
      }
      else if (paramSessionInfo.equals("pfa"))
      {
        paramMessageForQQWalletMsg = (String)paramString2.get("data");
        paramString3 = (String)paramString2.get("tokenid");
        if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramMessageForQQWalletMsg)))
        {
          paramString2 = new JSONObject();
          try
          {
            paramString2.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            paramString2.put("viewTag", "payByFriendConfirm");
            paramString2.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#paymsg");
            paramString2.put("comeForm", 2);
            paramMessageForQQWalletMsg = new JSONObject();
            paramMessageForQQWalletMsg.put("pfa_req", paramString1);
            paramMessageForQQWalletMsg.put("token_id", paramString3);
            paramString2.put("extra_data", paramMessageForQQWalletMsg);
          }
          catch (Exception paramString1)
          {
            if (QLog.isDevelopLevel()) {
              paramString1.printStackTrace();
            }
          }
          paramString3 = new Bundle();
          paramString3.putString("json", paramString2.toString());
          paramString3.putString("callbackSn", "0");
          paramString1 = new Intent(paramContext, PayBridgeActivity.class);
          paramString1.putExtras(paramString3);
          paramString1.putExtra("pay_requestcode", 5);
        }
        else
        {
          return false;
        }
      }
      else
      {
        paramString3 = null;
        try
        {
          paramString1 = QQWalletTransMsgItemBuilder.class.getClassLoader();
          if (paramString1 == null) {
            return false;
          }
          paramString1 = paramString1.loadClass(paramSessionInfo);
        }
        catch (Exception paramMessageForQQWalletMsg)
        {
          if (QLog.isDevelopLevel()) {
            paramMessageForQQWalletMsg.printStackTrace();
          }
          paramString1 = paramString3;
          if (QLog.isColorLevel())
          {
            paramString1 = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("QQWalletTransMsgItemBuilder failed to find Class : ");
            localStringBuilder.append(paramSessionInfo);
            QLog.d(paramString1, 2, localStringBuilder.toString(), paramMessageForQQWalletMsg);
            paramString1 = paramString3;
          }
        }
        if (paramString1 == null) {
          return false;
        }
        paramString3 = new Intent(paramContext, paramString1);
        paramString2 = paramString2.entrySet().iterator();
        for (;;)
        {
          paramString1 = paramString3;
          if (!paramString2.hasNext()) {
            break;
          }
          paramString1 = (Map.Entry)paramString2.next();
          paramString3.putExtra((String)paramString1.getKey(), (String)paramString1.getValue());
        }
      }
      try
      {
        paramContext.startActivity(paramString1);
        return true;
      }
      catch (Exception paramContext)
      {
        if (QLog.isDevelopLevel()) {
          paramContext.printStackTrace();
        }
        if (QLog.isColorLevel())
        {
          paramString1 = jdField_a_of_type_JavaLangString;
          paramString2 = new StringBuilder();
          paramString2.append("QQWalletMsgItemBuilder failed to startActivity : ");
          paramString2.append(paramSessionInfo);
          QLog.d(paramString1, 2, paramString2.toString(), paramContext);
        }
        return false;
      }
    }
    return false;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return 2130847478;
            }
            return 2130847462;
          }
          return 2130847463;
        }
        return 2130847464;
      }
      return 2130847482;
    }
    return 2130847481;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    QQWalletTransMsgItemBuilder.QWalletTransMsgHolder localQWalletTransMsgHolder = (QQWalletTransMsgItemBuilder.QWalletTransMsgHolder)paramViewHolder;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      paramViewHolder = (MessageForQQWalletMsg)paramChatMessage;
    } else {
      paramViewHolder = null;
    }
    if (paramViewHolder != null)
    {
      if (paramViewHolder.mQQWalletTransferMsg == null) {
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
      a(localQWalletTransMsgHolder, paramViewHolder, paramView, paramChatMessage.isSend() ^ true, paramOnLongClickAndTouchListener);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramOnLongClickAndTouchListener = new StringBuilder();
      paramOnLongClickAndTouchListener.append("");
      paramOnLongClickAndTouchListener.append(paramViewHolder.mQQWalletTransferMsg.templateId);
      ReportController.b(paramChatMessage, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, paramOnLongClickAndTouchListener.toString(), "", "", "");
      paramChatMessage = (TextView)paramBaseChatItemLayout.findViewById(2131374904);
      if (paramChatMessage != null) {
        if ((paramView != null) && (!TextUtils.isEmpty(paramView.jdField_e_of_type_JavaLangString)))
        {
          paramChatMessage.setText(paramView.jdField_e_of_type_JavaLangString);
          paramChatMessage.setVisibility(0);
        }
        else
        {
          paramChatMessage.setVisibility(8);
        }
      }
      if (paramViewHolder.messageType == 16)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqQwalletTransactionNotifyMsgObserver);
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
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QQWalletTransMsgItemBuilder.QWalletTransMsgHolder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    Object localObject;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      localObject = (MessageForQQWalletMsg)paramChatMessage;
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg != null))
    {
      localObject = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (MessageRecordInfo.a(paramChatMessage.issend)) {
          localStringBuilder.append("发出");
        } else {
          localStringBuilder.append("发来");
        }
        if ((((QQWalletBaseMsgElem)localObject).jdField_c_of_type_JavaLangString != null) && (((QQWalletBaseMsgElem)localObject).jdField_c_of_type_JavaLangString.contains("QQ转账")))
        {
          localStringBuilder.append("QQ转账");
          localStringBuilder.append(((QQWalletBaseMsgElem)localObject).jdField_a_of_type_JavaLangString);
          localStringBuilder.append("按钮");
        }
        else
        {
          localStringBuilder.append("QQ转账");
          localStringBuilder.append(((QQWalletBaseMsgElem)localObject).jdField_a_of_type_JavaLangString);
          localStringBuilder.append(((QQWalletBaseMsgElem)localObject).jdField_c_of_type_JavaLangString);
          localStringBuilder.append("按钮");
        }
        return localStringBuilder.toString();
      }
      return paramChatMessage.msg;
    }
    return paramChatMessage.msg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqQwalletTransactionNotifyMsgObserver);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    super.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(u, v, t, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(t, v, u, paramView.getResources().getDimensionPixelSize(2131296381));
      return;
    }
    paramView.setPadding(t, v, u, 0);
  }
  
  protected void a(QQWalletTransMsgItemBuilder.QWalletTransMsgHolder paramQWalletTransMsgHolder, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletBaseMsgElem paramQQWalletBaseMsgElem)
  {
    if (paramMessageForQQWalletMsg.messageType == 16)
    {
      String str = paramQQWalletBaseMsgElem.jdField_a_of_type_JavaLangString;
      int i2 = -12727643;
      boolean bool = paramMessageForQQWalletMsg.isSend();
      int i3 = 2130847454;
      int i1;
      if ((!bool) && (!paramQQWalletBaseMsgElem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())))
      {
        paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131716785);
        i1 = 2130847455;
      }
      else
      {
        paramQQWalletBaseMsgElem = (INotifyMsgApi)QRoute.api(INotifyMsgApi.class);
        int i4 = paramQQWalletBaseMsgElem.getAAPayState(paramMessageForQQWalletMsg.mQQWalletTransferMsg.listId, paramMessageForQQWalletMsg);
        i1 = i4;
        if (i4 == -1)
        {
          paramQQWalletBaseMsgElem = paramQQWalletBaseMsgElem.getAAPayState(paramMessageForQQWalletMsg);
          i1 = i4;
          if (!TextUtils.isEmpty(paramQQWalletBaseMsgElem)) {
            try
            {
              i1 = Integer.valueOf(paramQQWalletBaseMsgElem).intValue();
            }
            catch (Exception paramQQWalletBaseMsgElem)
            {
              i1 = i4;
              if (QLog.isColorLevel())
              {
                paramQQWalletBaseMsgElem.printStackTrace();
                i1 = i4;
              }
            }
          }
        }
        if (i1 == 1)
        {
          i1 = 2130847456;
          paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131716791);
          i2 = -7676215;
        }
        else
        {
          if (i1 == 2) {}
          for (paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131716786);; paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131716788))
          {
            i2 = -7676215;
            i1 = 2130847453;
            break label269;
            if (i1 != 3) {
              break;
            }
          }
          if (paramMessageForQQWalletMsg.isSend())
          {
            paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131716789);
            i1 = i3;
          }
          else
          {
            paramQQWalletBaseMsgElem = BaseApplicationImpl.getContext().getString(2131716787);
            i1 = i3;
          }
        }
      }
      label269:
      a(paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetTextView, paramQQWalletBaseMsgElem);
      if ((i1 != 0) && (paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        paramQQWalletBaseMsgElem = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i1);
        paramQWalletTransMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramQQWalletBaseMsgElem);
      }
      if (paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView != null) {
        paramQWalletTransMsgHolder.jdField_b_of_type_ComTencentMobileqqQwalletWidgetQQWalletTransferBubbleView.setBubbleBackground(2130847479, i2, paramMessageForQQWalletMsg.isSend() ^ true);
      }
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletTransMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */