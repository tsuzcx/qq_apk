package com.tencent.mobileqq.armap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.qphone.base.util.QLog;

public class ARMapOpenCardDialog
  extends Dialog
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  Activity jdField_a_of_type_AndroidAppActivity;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ItemInfo jdField_a_of_type_ComTencentMobileqqArmapItemInfo = null;
  SanHuaView jdField_a_of_type_ComTencentMobileqqPortalSanHuaView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ARMapOpenCardDialog(Context paramContext)
  {
    this(paramContext, true);
  }
  
  public ARMapOpenCardDialog(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 2131624515);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    setContentView(2130970203);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369603));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369604));
    findViewById(2131369607).setOnClickListener(this);
    findViewById(2131369606).setOnClickListener(this);
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131369601);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    int j = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView = new SanHuaView(paramContext, i / 2, j / 2);
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView.a(100);
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView.a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void b(ItemInfo paramItemInfo)
  {
    if (paramItemInfo == null) {}
    do
    {
      return;
      String str = "获得" + paramItemInfo.a + "一张";
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    } while (TextUtils.isEmpty(paramItemInfo.b));
    try
    {
      paramItemInfo = URLDrawable.getDrawable(NearbyImgDownloader.a(paramItemInfo.b), null);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramItemInfo);
      return;
    }
    catch (Exception paramItemInfo)
    {
      paramItemInfo.printStackTrace();
    }
  }
  
  public void a(ItemInfo paramItemInfo)
  {
    if (paramItemInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo = paramItemInfo;
      b(paramItemInfo);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ARMapOpenCardDialog", 2, "setItemInfo is null");
      }
      dismiss();
    } while (this.jdField_a_of_type_AndroidAppActivity == null);
    this.jdField_a_of_type_AndroidAppActivity.finish();
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
        localActivity = this.jdField_a_of_type_AndroidAppActivity;
      } while (localActivity.isFinishing());
      dismiss();
    } while (!this.jdField_a_of_type_Boolean);
    localActivity.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      onBackPressed();
      return;
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        dismiss();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo.c)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ARMapOpenCardDialog", 2, "mItemInfo : " + this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo);
        }
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo.c);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapOpenCardDialog
 * JD-Core Version:    0.7.0.1
 */