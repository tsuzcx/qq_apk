package com.tencent.mobileqq.activity.aio.qwallet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.widget.EllipseTextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.HbItemClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.ThemeRedPkgConfig;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import vvn;
import vvo;
import vvp;

public class QQWalletHbItemUtils
{
  public static final String a;
  public static Map a;
  protected int a;
  public long a;
  private View.OnClickListener a;
  public BaseChatPie a;
  public SessionInfo a;
  public TroopUnAccalimedRedPacketList.HbItemClickListener a;
  public QQAppInterface a;
  protected int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new vvo(this);
  final String jdField_b_of_type_JavaLangString = "pay";
  protected int c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new vvp(this);
  final String jdField_c_of_type_JavaLangString = "red";
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQWalletHbItemUtils.class.getSimpleName();
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public QQWalletHbItemUtils(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vvn(this);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(15.0F * f1 + 0.5F));
    this.jdField_b_of_type_Int = ((int)(10.0F * f1 + 0.5F));
    this.g = ((int)(8.0F * f1 + 0.5F));
    this.f = ((int)(23.0F * f1 + 0.5F));
    this.h = ((int)(40.0F * f1 + 0.5F));
    this.i = ((int)(90.0F * f1 + 0.5F));
    this.j = ((int)(17.0F * f1 + 0.5F));
    this.jdField_c_of_type_Int = ((int)(138.0F * f1 + 0.5F));
    this.d = ((int)(115.0F * f1 + 0.5F));
    this.e = ((int)(11.0F * f1 + 0.5F));
    this.k = ((int)(160.0F * f1 + 0.5F));
    this.l = ((int)(f1 * 240.0F + 0.5F));
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    paramString1 = paramString1.split("\\?");
    CharSequence localCharSequence = paramString1[0];
    if (TextUtils.isEmpty(localCharSequence)) {
      return false;
    }
    if (paramString1.length > 1) {
      paramString1 = paramMessageForQQWalletMsg.parseUrlParams(paramString1[1]);
    }
    while (localCharSequence.equals("pay"))
    {
      paramString2 = (String)paramString1.get("payData");
      paramString3 = (String)paramString1.get("reqCode");
      if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString2)))
      {
        return false;
        paramString1 = new HashMap();
      }
      else
      {
        paramMessageForQQWalletMsg = new Bundle();
        paramMessageForQQWalletMsg.putString("json", paramString2);
        paramMessageForQQWalletMsg.putString("callbackSn", "0");
        paramString1 = new Intent(paramContext, PayBridgeActivity.class);
        paramString1.putExtras(paramMessageForQQWalletMsg);
        paramString1.putExtra("pay_requestcode", Integer.valueOf(paramString3).intValue());
      }
    }
    label826:
    for (;;)
    {
      try
      {
        paramContext.startActivity(paramString1);
        return true;
      }
      catch (Exception paramContext)
      {
        String str;
        Object localObject;
        int m;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramContext.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to startActivity : " + localCharSequence, paramContext);
        return false;
      }
      if (localCharSequence.equals("red"))
      {
        str = (String)paramString1.get("id");
        if (TextUtils.isEmpty(str)) {
          return false;
        }
        paramString1 = null;
        if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.themeId > 1)
        {
          paramString1 = ((RedPacketManager)RedPacketManager.getInstance()).getThemeRedPkgConfById(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.themeId);
          if (paramString1 != null) {
            paramString1 = paramString1.jdField_b_of_type_JavaLangString;
          }
        }
        else
        {
          localObject = QWalletRedPkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo, paramMessageForQQWalletMsg);
          m = ((Bundle)localObject).getInt("groupType");
          localObject = ((Bundle)localObject).getString("name");
          paramString2 = QWalletRedPkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForQQWalletMsg, paramSessionInfo, m, (String)localObject, str, paramString2, paramString3, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", paramString1);
          paramSessionInfo = (IndividualRedPacketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(130);
          if ((paramSessionInfo == null) || (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid <= 0)) {}
        }
      }
      try
      {
        paramString3 = paramString2.getJSONObject("extra_data");
        paramSessionInfo = paramSessionInfo.a(String.valueOf(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid), paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeName);
        if (QLog.isColorLevel()) {
          QLog.d("vipBgImage", 2, paramSessionInfo);
        }
        paramString3.put("vipBgImage", paramSessionInfo);
      }
      catch (Exception paramString3)
      {
        continue;
        paramString1 = paramString2;
      }
      paramString3 = new Bundle();
      paramString3.putString("json", paramString2.toString());
      paramString3.putString("callbackSn", "0");
      if (paramString1 != null) {
        paramString3.putString("cftImageUrl", paramString1);
      }
      paramString1 = str;
      if (str != null)
      {
        paramString1 = str;
        if (str.length() > 4) {
          paramString1 = "****" + str.substring(4);
        }
      }
      paramString3.putLong("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "graphb", "open", "groupType=" + m + "&msgType=" + paramMessageForQQWalletMsg.messageType + "&redId=" + paramString1, 0, null));
      paramString1 = new Intent(paramContext, PayBridgeActivity.class);
      paramString1.putExtras(paramString3);
      paramString1.putExtra("pay_requestcode", 5);
      continue;
      paramString1 = "http://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.themeId + "_bg";
      continue;
      try
      {
        paramString2 = QQWalletMsgItemBuilder.class.getClassLoader();
        if (paramString2 == null) {
          return false;
        }
        paramString2 = paramString2.loadClass(localCharSequence);
      }
      catch (Exception paramString2)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramString2.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to find Class : " + localCharSequence, paramString2);
        paramString2 = null;
        continue;
        paramString2 = new Intent(paramContext, paramString2);
        paramString1 = paramString1.entrySet().iterator();
        if (!paramString1.hasNext()) {
          break label826;
        }
      }
      if (paramString2 == null) {
        return false;
      }
      paramString3 = (Map.Entry)paramString1.next();
      paramString2.putExtra((String)paramString3.getKey(), (String)paramString3.getValue());
    }
  }
  
  public RelativeLayout a(QWalletMsgHolder paramQWalletMsgHolder, Context paramContext)
  {
    if ((paramQWalletMsgHolder == null) || (paramContext == null)) {
      return null;
    }
    RelativeLayout localRelativeLayout = b(paramQWalletMsgHolder, paramContext);
    paramContext = a(paramContext);
    localRelativeLayout.addView(paramContext);
    paramQWalletMsgHolder.jdField_b_of_type_AndroidWidgetTextView = paramContext;
    return localRelativeLayout;
  }
  
  public TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, this.f);
    localLayoutParams.topMargin = this.g;
    localLayoutParams.bottomMargin = this.jdField_a_of_type_Int;
    localLayoutParams.addRule(3, 2131372398);
    localLayoutParams.addRule(5, 2131372398);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setMaxWidth(this.k);
    paramContext.setTextColor(-8947849);
    paramContext.setBackgroundResource(2130844103);
    paramContext.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setSingleLine();
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131372395);
    return paramContext;
  }
  
  public void a(RelativeLayout paramRelativeLayout, String paramString)
  {
    if (paramRelativeLayout == null) {
      return;
    }
    paramRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    paramRelativeLayout.setContentDescription(paramString);
  }
  
  public void a(TroopUnAccalimedRedPacketList.HbItemClickListener paramHbItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList$HbItemClickListener = paramHbItemClickListener;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, RelativeLayout paramRelativeLayout, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (paramRelativeLayout == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    paramQQAppInterface = (MessageForQQWalletMsg)paramRelativeLayout.getTag();
    if (paramQQAppInterface == null) {
      return false;
    }
    jdField_a_of_type_JavaUtilMap.put(paramQQAppInterface.mQQWalletRedPacketMsg.redPacketId, paramQQAppInterface);
    int m = paramInt1;
    if (paramInt1 == 4)
    {
      m = paramInt1;
      if (paramInt2 > 0) {
        m = 0;
      }
    }
    if (m == 1)
    {
      paramRelativeLayout.setContentDescription("口令:" + paramQQAppInterface.mQQWalletRedPacketMsg.elem.title + ",点击领取口令");
      paramRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      return true;
      if (m == 2)
      {
        paramRelativeLayout.setContentDescription("语音口令:" + paramQQAppInterface.mQQWalletRedPacketMsg.elem.title + ",点击录制口令");
        paramRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        paramRelativeLayout.setContentDescription(paramQQAppInterface.mQQWalletRedPacketMsg.elem.title + paramString);
        paramRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      }
    }
  }
  
  public RelativeLayout b(QWalletMsgHolder paramQWalletMsgHolder, Context paramContext)
  {
    if ((paramQWalletMsgHolder == null) || (paramContext == null)) {
      return null;
    }
    RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
    localRelativeLayout1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localRelativeLayout1.setId(2131372387);
    paramQWalletMsgHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout1;
    RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
    Object localObject1 = new RelativeLayout.LayoutParams(this.k, this.l);
    localRelativeLayout2.setId(2131372398);
    localRelativeLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramQWalletMsgHolder.c = localRelativeLayout2;
    localObject1 = new RelativeLayout(paramContext);
    Object localObject2 = new RelativeLayout.LayoutParams(this.k, this.l);
    ((RelativeLayout)localObject1).setBackgroundResource(2130844181);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setVisibility(8);
    paramQWalletMsgHolder.d = ((RelativeLayout)localObject1);
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setId(2131372510);
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.topMargin = this.h;
    localLayoutParams1.addRule(10);
    localLayoutParams1.addRule(14);
    ((LinearLayout)localObject2).setLayoutParams(localLayoutParams1);
    ((LinearLayout)localObject2).setVisibility(8);
    paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject2);
    RelativeLayout localRelativeLayout3 = new RelativeLayout(paramContext);
    localRelativeLayout3.setId(2131372385);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.addRule(10);
    localLayoutParams2.addRule(14);
    localLayoutParams2.topMargin = this.i;
    localLayoutParams2.leftMargin = this.j;
    localLayoutParams2.rightMargin = this.j;
    localRelativeLayout3.setLayoutParams(localLayoutParams2);
    Object localObject3 = new EllipseTextView(paramContext);
    Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(13);
    ((TextView)localObject3).setTextSize(18.0F);
    ((TextView)localObject3).setTextColor(Color.parseColor("#FBD49D"));
    ((TextView)localObject3).setLineSpacing(0.0F, 1.1F);
    ((TextView)localObject3).setId(2131372390);
    ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((TextView)localObject3).setGravity(17);
    localRelativeLayout3.addView((View)localObject3);
    paramQWalletMsgHolder.e = localRelativeLayout3;
    paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
    localObject4 = new ImageView(paramContext);
    ((ImageView)localObject4).setId(2131372397);
    ((ImageView)localObject4).setVisibility(8);
    ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(this.jdField_c_of_type_Int, this.d);
    localLayoutParams3.setMargins(this.e, 0, this.e, 0);
    localLayoutParams3.addRule(12);
    paramQWalletMsgHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
    localObject3 = new AnimationView(paramContext);
    ((AnimationView)localObject3).setPlayer(new ScrollPlayer((AnimationView)localObject3));
    ((AnimationView)localObject3).setId(2131372391);
    ((AnimationView)localObject3).setVisibility(8);
    ((AnimationView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(this.k, this.l);
    localLayoutParams4.addRule(14);
    localLayoutParams4.addRule(12);
    paramQWalletMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)localObject3);
    localRelativeLayout2.addView((View)localObject4, localLayoutParams3);
    localRelativeLayout2.addView((View)localObject3, localLayoutParams4);
    localRelativeLayout2.addView(localRelativeLayout3, localLayoutParams2);
    localRelativeLayout2.addView((View)localObject2, localLayoutParams1);
    localRelativeLayout1.addView(localRelativeLayout2);
    localRelativeLayout1.addView((View)localObject1);
    paramContext = new AnimationView(paramContext);
    paramContext.setPlayer(new ScrollPlayer((AnimationView)localObject3));
    paramContext.setId(2131372483);
    paramContext.setVisibility(8);
    paramQWalletMsgHolder.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView = paramContext;
    return localRelativeLayout1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils
 * JD-Core Version:    0.7.0.1
 */