package com.tencent.biz.coupon;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bcef;
import bgtw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.protofile.coupon.CouponProto.MarkBusinessFavourUpdateReq;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import nma;
import org.json.JSONException;
import org.json.JSONObject;

public class CouponActivity$CouponWebViewFragment
  extends WebViewFragment
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = false;
  
  private void a()
  {
    NewIntent localNewIntent = new NewIntent(super.getActivity(), nma.class);
    localNewIntent.putExtra("cmd", "CouponSvr.coup_markBizupdate");
    localNewIntent.putExtra("data", new CouponProto.MarkBusinessFavourUpdateReq().toByteArray());
    if (this.mApp == null) {
      this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    this.mApp.startServlet(localNewIntent);
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if (!this.intent.hasExtra("source"))
    {
      this.mSwiftTitleUI.rightViewImg.setVisibility(8);
      this.mSwiftTitleUI.rightViewText.setVisibility(0);
      this.mSwiftTitleUI.rightViewText.setText(2131695573);
      this.mSwiftTitleUI.rightViewText.setOnClickListener(this);
      return i;
    }
    this.intent.removeExtra("source");
    this.mSwiftTitleUI.rightViewImg.setVisibility(8);
    this.mSwiftTitleUI.rightViewText.setVisibility(8);
    return i;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (paramIntent != null)
    {
      paramInt1 = paramInt2;
      if (paramIntent.getExtras() != null) {
        paramInt1 = paramIntent.getExtras().getInt("toPage");
      }
    }
    if ((paramInt1 != 0) && ((this.jdField_a_of_type_Int & paramInt1) == 0))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("toPage", paramInt1);
      super.getActivity().setResult(-1, paramIntent);
      super.getActivity().finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = this.intent.getExtras().getString("url");
    this.jdField_a_of_type_Int = this.intent.getIntExtra("from", 10);
    this.intent.putExtra("webStyle", "noBottomBar");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.intent.putExtra("title", super.getResources().getString(2131695576));
      this.jdField_a_of_type_Boolean = true;
      super.doOnCreate(paramBundle);
      if (this.jdField_a_of_type_Boolean)
      {
        paramBundle = new StringBuffer();
        try
        {
          localObject1 = this.intent.getStringExtra("jsonParams");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            Iterator localIterator = ((JSONObject)localObject1).keys();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              Object localObject2 = ((JSONObject)localObject1).get(str);
              paramBundle.append("&" + str + "=" + localObject2.toString());
            }
          }
          if ((this.jdField_a_of_type_Int & 0x5) != 0) {}
        }
        catch (JSONException localJSONException) {}
      }
    }
    for (paramBundle = CouponActivity.a + "&stype=2" + paramBundle.toString();; paramBundle = CouponActivity.a + paramBundle.toString())
    {
      this.intent.putExtra("url", paramBundle);
      this.intent.putExtra("from", this.jdField_a_of_type_Int & 0x1C | 0x10);
      a();
      bcef.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "coupon.activity.show", 0, 0, "", "", "", "");
      return true;
      this.intent.removeExtra("title");
      break;
    }
  }
  
  public String getUAMark()
  {
    if (this.intent.hasExtra("source")) {
      return "PA MyCoupon";
    }
    return "PA Coupon";
  }
  
  public void initTitleBar(Intent paramIntent, String paramString)
  {
    super.initTitleBar(this.intent, this.mUrl);
    if (!this.intent.hasExtra("source"))
    {
      this.mSwiftTitleUI.rightViewImg.setVisibility(8);
      this.mSwiftTitleUI.rightViewText.setVisibility(0);
      this.mSwiftTitleUI.rightViewText.setText(2131695573);
      this.mSwiftTitleUI.rightViewText.setClickable(false);
      return;
    }
    this.mSwiftTitleUI.rightViewImg.setVisibility(8);
    this.mSwiftTitleUI.rightViewText.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (paramView == this.mSwiftTitleUI.rightViewText) {
      if ((this.jdField_a_of_type_Int & 0x4) != 0)
      {
        localIntent = new Intent();
        localIntent.putExtra("isNeedFinish", true);
        localIntent.putExtra("toPage", 1);
        super.getActivity().setResult(-1, localIntent);
        super.getActivity().finish();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent = new Intent(super.getActivity(), CouponActivity.class);
      localIntent.putExtra("url", "https://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
      localIntent.putExtra("source", "2");
      localIntent.putExtra("from", this.jdField_a_of_type_Int & 0xC | 0x5);
      super.getActivity().startActivityForResult(localIntent, 100);
      continue;
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.coupon.CouponActivity.CouponWebViewFragment
 * JD-Core Version:    0.7.0.1
 */