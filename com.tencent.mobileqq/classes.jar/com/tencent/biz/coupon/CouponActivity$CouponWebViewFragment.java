package com.tencent.biz.coupon;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import axqw;
import bcbv;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.protofile.coupon.CouponProto.MarkBusinessFavourUpdateReq;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mxh;
import org.json.JSONException;
import org.json.JSONObject;

public class CouponActivity$CouponWebViewFragment
  extends WebViewFragment
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = false;
  
  private void i()
  {
    NewIntent localNewIntent = new NewIntent(super.getActivity(), mxh.class);
    localNewIntent.putExtra("cmd", "CouponSvr.coup_markBizupdate");
    localNewIntent.putExtra("data", new CouponProto.MarkBusinessFavourUpdateReq().toByteArray());
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("source"))
    {
      this.jdField_a_of_type_Bcbv.a.setVisibility(8);
      this.jdField_a_of_type_Bcbv.c.setVisibility(0);
      this.jdField_a_of_type_Bcbv.c.setText(2131696390);
      this.jdField_a_of_type_Bcbv.c.setOnClickListener(this);
      return i;
    }
    this.jdField_a_of_type_AndroidContentIntent.removeExtra("source");
    this.jdField_a_of_type_Bcbv.a.setVisibility(8);
    this.jdField_a_of_type_Bcbv.c.setVisibility(8);
    return i;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("source")) {
      return "PA MyCoupon";
    }
    return "PA Coupon";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
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
  
  public void a(Intent paramIntent, String paramString)
  {
    super.a(this.jdField_a_of_type_AndroidContentIntent, this.h);
    if (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("source"))
    {
      this.jdField_a_of_type_Bcbv.a.setVisibility(8);
      this.jdField_a_of_type_Bcbv.c.setVisibility(0);
      this.jdField_a_of_type_Bcbv.c.setText(2131696390);
      this.jdField_a_of_type_Bcbv.c.setClickable(false);
      return;
    }
    this.jdField_a_of_type_Bcbv.a.setVisibility(8);
    this.jdField_a_of_type_Bcbv.c.setVisibility(8);
  }
  
  public boolean a(Bundle paramBundle)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("url");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("from", 10);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("webStyle", "noBottomBar");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("title", super.getResources().getString(2131696393));
      this.jdField_a_of_type_Boolean = true;
      super.a(paramBundle);
      if (this.jdField_a_of_type_Boolean)
      {
        paramBundle = new StringBuffer();
        try
        {
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("jsonParams");
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
      this.jdField_a_of_type_AndroidContentIntent.putExtra("url", paramBundle);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("from", this.jdField_a_of_type_Int & 0x1C | 0x10);
      i();
      axqw.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "coupon.activity.show", 0, 0, "", "", "", "");
      return true;
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("title");
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_Bcbv.c)
    {
      if ((this.jdField_a_of_type_Int & 0x4) != 0)
      {
        paramView = new Intent();
        paramView.putExtra("isNeedFinish", true);
        paramView.putExtra("toPage", 1);
        super.getActivity().setResult(-1, paramView);
        super.getActivity().finish();
        return;
      }
      paramView = new Intent(super.getActivity(), CouponActivity.class);
      paramView.putExtra("url", "http://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
      paramView.putExtra("source", "2");
      paramView.putExtra("from", this.jdField_a_of_type_Int & 0xC | 0x5);
      super.getActivity().startActivityForResult(paramView, 100);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.coupon.CouponActivity.CouponWebViewFragment
 * JD-Core Version:    0.7.0.1
 */