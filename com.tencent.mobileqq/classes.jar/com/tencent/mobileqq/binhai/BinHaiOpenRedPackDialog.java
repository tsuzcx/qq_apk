package com.tencent.mobileqq.binhai;

import abkt;
import abku;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class BinHaiOpenRedPackDialog
  extends Dialog
  implements View.OnClickListener
{
  public int a;
  protected Activity a;
  public Animation a;
  ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  protected AppInterface a;
  protected BinHaiOpenRedPackDialog.Listener a;
  protected SanHuaView a;
  protected String a;
  ImageView b;
  public RelativeLayout b;
  protected String b;
  ImageView c;
  protected RelativeLayout c;
  protected String c;
  ImageView d;
  protected String d;
  ImageView e;
  protected String e;
  protected String f;
  String g = null;
  public String h;
  
  public BinHaiOpenRedPackDialog(Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramActivity, BinHaiMsgDialog.a());
    setContentView(2130970195);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362840));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369495));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369503));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369501));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369497));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369496));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369498));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369504));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369507));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    findViewById(2131369499).setOnClickListener(this);
    findViewById(2131369500).setOnClickListener(this);
    findViewById(2131369502).setOnClickListener(this);
    findViewById(2131369505).setOnClickListener(this);
    findViewById(2131369506).setOnClickListener(this);
    findViewById(2131369509).setOnClickListener(this);
    findViewById(2131369493).setOnClickListener(this);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      findViewById(2131369491).setPadding(0, ImmersiveUtils.a(paramActivity), 0, 0);
    }
    if (BinHaiMsgDialog.a())
    {
      findViewById(2131362840).setBackgroundColor(0);
      findViewById(2131369491).setVisibility(8);
    }
  }
  
  private String a()
  {
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    }
    return "";
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject3.put("amount", this.jdField_e_of_type_JavaLangString);
      localJSONObject3.put("channel", this.jdField_a_of_type_Int);
      localJSONObject3.put("mch_icon", this.jdField_b_of_type_JavaLangString);
      localJSONObject3.put("mch_top_img", this.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 4) {
        localJSONObject3.put("banner", this.jdField_c_of_type_JavaLangString);
      }
      localJSONObject3.put("wishing", this.jdField_d_of_type_JavaLangString);
      localJSONObject3.put("send_name", this.jdField_a_of_type_JavaLangString);
      if (this.f != null) {
        localJSONObject2.put("listid", this.f);
      }
      localJSONObject2.put("detailinfo", localJSONObject3);
      localJSONObject2.put("channel", this.jdField_a_of_type_Int);
      localJSONObject2.put("name", this.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("skey", a());
      localJSONObject2.put("skey_type", 2);
      localJSONObject2.put("groupid", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      localJSONObject2.put("grouptype", "0");
      localJSONObject1.put("extra_data", localJSONObject2);
      localJSONObject1.put("come_from", 2);
      localJSONObject1.put("viewTag", "graphb");
      localJSONObject1.put("userId", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      localJSONObject1.put("sendernickname", this.jdField_a_of_type_JavaLangString);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new BinHaiOpenRedPackDialog.MyOvershotInterpolator(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(800L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new abkt(this));
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView = new SanHuaView(this.jdField_a_of_type_AndroidAppActivity, i / 2, j / 2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView.a(100);
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().postDelayed(new abku(this), 500L);
  }
  
  protected void a()
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "当前网络不可用", 1).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener.a(this, this.f, this.h);
      }
      JSONObject localJSONObject = a();
      PayBridgeActivity.tenpay(this.jdField_a_of_type_AndroidAppActivity, localJSONObject.toString(), 5, "0");
    } while (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener == null);
    this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener.b(this, this.f, this.h);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    if (paramBitmap1 != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
    }
    if ((paramBitmap2 != null) && (paramBitmap3 != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap2);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap3);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a(BinHaiOpenRedPackDialog.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener = paramListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, ItemInfo paramItemInfo, int paramInt, String paramString5, String paramString6)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = String.valueOf(paramItemInfo.e);
    this.f = paramItemInfo.g;
    this.jdField_a_of_type_Int = 2;
    this.g = paramString5;
    this.h = paramString6;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("恭喜你获得" + paramInt + "个红包");
    b();
    c();
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0;
  }
  
  public void onBackPressed()
  {
    if (a()) {
      super.onBackPressed();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener != null) {
      this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener.a(this);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener == null);
        this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener.d(this);
        return;
        a();
        return;
        if (!TextUtils.isEmpty(this.g))
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
          paramView.putExtra("url", this.g);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener == null);
      this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener.b(this);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener == null);
    this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiOpenRedPackDialog$Listener.c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.binhai.BinHaiOpenRedPackDialog
 * JD-Core Version:    0.7.0.1
 */