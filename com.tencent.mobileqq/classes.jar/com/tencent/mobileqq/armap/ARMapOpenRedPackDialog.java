package com.tencent.mobileqq.armap;

import aauy;
import aauz;
import aava;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ARMapOpenRedPackDialog
  extends Dialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private SanHuaView jdField_a_of_type_ComTencentMobileqqPortalSanHuaView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public ARMapOpenRedPackDialog(Context paramContext, AppInterface paramAppInterface)
  {
    this(paramContext, paramAppInterface, true);
  }
  
  public ARMapOpenRedPackDialog(Context paramContext, AppInterface paramAppInterface, boolean paramBoolean)
  {
    super(paramContext, 2131624515);
    setContentView(2130970205);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369615));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369616));
    findViewById(2131369494).setOnClickListener(this);
    findViewById(2131369495).setOnClickListener(this);
    findViewById(2131369618).setOnClickListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
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
      localJSONObject3.put("amount", this.e);
      localJSONObject3.put("channel", this.jdField_a_of_type_Int);
      localJSONObject3.put("mch_icon", this.jdField_b_of_type_JavaLangString);
      localJSONObject3.put("mch_top_img", this.c);
      if (this.jdField_a_of_type_Int == 4) {
        localJSONObject3.put("banner", this.c);
      }
      localJSONObject3.put("wishing", this.d);
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
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363194));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363196));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new aava(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(800L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new aauy(this));
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView = new SanHuaView(this.jdField_a_of_type_AndroidContentContext, i / 2, j / 2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView.a(100);
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().postDelayed(new aauz(this), 500L);
  }
  
  private void c()
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, "当前网络不可用", 1).a();
      return;
    }
    Object localObject = a();
    Bundle localBundle = new Bundle();
    localBundle.putString("json", ((JSONObject)localObject).toString());
    localBundle.putString("callbackSn", "0");
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PayBridgeActivity.class);
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("pay_requestcode", 5);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, ItemInfo paramItemInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = String.valueOf(paramItemInfo.e);
    this.f = paramItemInfo.g;
    if (paramItemInfo.b == 6) {}
    for (this.jdField_a_of_type_Int = 4;; this.jdField_a_of_type_Int = 2)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        paramString1 = BitmapManager.a(this.jdField_b_of_type_JavaLangString);
        if (paramString1 != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a(paramString1, paramString1.getWidth(), paramString1.getHeight()));
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      }
      a();
      b();
      return;
    }
  }
  
  public void onBackPressed()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 2000L) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
        localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      } while (localActivity.isFinishing());
      dismiss();
    } while (!this.jdField_a_of_type_Boolean);
    localActivity.finish();
  }
  
  public void onClick(View paramView)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        onBackPressed();
        return;
        ReportController.b(null, "dc01440", "", "", "0X800784E", "0X800784E", 0, 0, "", "", "", "");
        c();
      } while (localActivity.isFinishing());
      dismiss();
    } while (!this.jdField_a_of_type_Boolean);
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapOpenRedPackDialog
 * JD-Core Version:    0.7.0.1
 */