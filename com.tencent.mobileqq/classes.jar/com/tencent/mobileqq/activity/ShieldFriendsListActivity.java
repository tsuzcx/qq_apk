package com.tencent.mobileqq.activity;

import acbv;
import acbw;
import acbx;
import ajxj;
import ajya;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import baxy;
import baxz;
import bbdv;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;

public class ShieldFriendsListActivity
  extends IphoneTitleBarActivity
  implements baxz
{
  private acbx jdField_a_of_type_Acbx;
  ajxj jdField_a_of_type_Ajxj = new acbv(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private baxy jdField_a_of_type_Baxy;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  private void a()
  {
    ThreadManager.excute(new ShieldFriendsListActivity.1(this), 16, null, true);
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localObject != null)
      {
        localObject = (acbw)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((acbw)localObject).jdField_a_of_type_JavaLangString).longValue()))
        {
          if (((acbw)localObject).jdField_a_of_type_ComTencentWidgetSwitch.isChecked() != paramBoolean)
          {
            ((acbw)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
            ((acbw)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
            ((acbw)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(((acbw)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
          }
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Acbx.getCount() <= 0)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561113);
    super.setTitle(2131699449);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131369306));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366310));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699450);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167033));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
    this.jdField_a_of_type_Baxy = new baxy(this, this.app);
    this.jdField_a_of_type_Baxy.a(this);
    this.jdField_a_of_type_Acbx = new acbx(this, this.jdField_a_of_type_Baxy, this.app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acbx);
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    paramBundle.topMargin = ((int)bbdv.a(this, 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_Ajxj);
    if (AppSetting.d) {
      this.leftView.setContentDescription(ajya.a(2131714006));
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    removeObserver(this.jdField_a_of_type_Ajxj);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldFriendsListActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (acbw)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((acbw)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((acbw)localObject).jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShieldFriendsListActivity
 * JD-Core Version:    0.7.0.1
 */