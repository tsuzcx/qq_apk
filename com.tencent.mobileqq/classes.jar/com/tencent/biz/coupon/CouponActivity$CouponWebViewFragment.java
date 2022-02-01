package com.tencent.biz.coupon;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.protofile.coupon.CouponProto.MarkBusinessFavourUpdateReq;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class CouponActivity$CouponWebViewFragment
  extends WebViewFragment
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = false;
  
  private void a()
  {
    NewIntent localNewIntent = new NewIntent(super.getQBaseActivity(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", "CouponSvr.coup_markBizupdate");
    localNewIntent.putExtra("data", new CouponProto.MarkBusinessFavourUpdateReq().toByteArray());
    if (getAppRuntime() == null) {
      this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    getAppRuntime().startServlet(localNewIntent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      paramInt1 = paramIntent.getExtras().getInt("toPage");
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && ((this.jdField_a_of_type_Int & paramInt1) == 0))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("toPage", paramInt1);
      super.getQBaseActivity().setResult(-1, paramIntent);
      super.getQBaseActivity().finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = this.intent.getExtras().getString("url");
    this.jdField_a_of_type_Int = this.intent.getIntExtra("from", 10);
    this.intent.putExtra("webStyle", "noBottomBar");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.intent.putExtra("title", super.getResources().getString(2131696091));
      this.jdField_a_of_type_Boolean = true;
    }
    else
    {
      this.intent.removeExtra("title");
    }
    super.doOnCreate(paramBundle);
    if (this.jdField_a_of_type_Boolean) {
      paramBundle = new StringBuffer();
    }
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("&");
          localStringBuilder.append(str);
          localStringBuilder.append("=");
          localStringBuilder.append(localObject2.toString());
          paramBundle.append(localStringBuilder.toString());
        }
      }
    }
    catch (JSONException localJSONException)
    {
      label220:
      break label220;
    }
    if ((this.jdField_a_of_type_Int & 0x5) == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(CouponActivity.a);
      ((StringBuilder)localObject1).append("&stype=2");
      ((StringBuilder)localObject1).append(paramBundle.toString());
      paramBundle = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(CouponActivity.a);
      ((StringBuilder)localObject1).append(paramBundle.toString());
      paramBundle = ((StringBuilder)localObject1).toString();
    }
    this.intent.putExtra("url", paramBundle);
    this.intent.putExtra("from", this.jdField_a_of_type_Int & 0x1C | 0x10);
    a();
    ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "coupon.activity.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new CouponActivity.CouponWebViewFragment.1(this, this.webViewSurface);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == getSwiftTitleUI().c)
    {
      Intent localIntent;
      if ((this.jdField_a_of_type_Int & 0x4) != 0)
      {
        localIntent = new Intent();
        localIntent.putExtra("isNeedFinish", true);
        localIntent.putExtra("toPage", 1);
        super.getQBaseActivity().setResult(-1, localIntent);
        super.getQBaseActivity().finish();
      }
      else
      {
        localIntent = new Intent(super.getQBaseActivity(), CouponActivity.class);
        localIntent.putExtra("url", "https://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
        localIntent.putExtra("source", "2");
        localIntent.putExtra("from", this.jdField_a_of_type_Int & 0xC | 0x5);
        super.getQBaseActivity().startActivityForResult(localIntent, 100);
      }
    }
    else
    {
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.coupon.CouponActivity.CouponWebViewFragment
 * JD-Core Version:    0.7.0.1
 */