package com.tencent.mobileqq.activity;

import adtd;
import adte;
import adtf;
import alox;
import alpo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bcws;
import bcwt;
import bdcq;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;

public class ShieldFriendsListActivity
  extends IphoneTitleBarActivity
  implements bcwt
{
  private adtf jdField_a_of_type_Adtf;
  alox jdField_a_of_type_Alox = new adtd(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcws jdField_a_of_type_Bcws;
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
        localObject = (adte)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((adte)localObject).jdField_a_of_type_JavaLangString).longValue()))
        {
          if (((adte)localObject).jdField_a_of_type_ComTencentWidgetSwitch.isChecked() != paramBoolean)
          {
            ((adte)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
            ((adte)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
            ((adte)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(((adte)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
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
    if (this.jdField_a_of_type_Adtf.getCount() <= 0)
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
    setContentView(2131561300);
    super.setTitle(2131699801);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131369541));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366404));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699802);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167084));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
    this.jdField_a_of_type_Bcws = new bcws(this, this.app);
    this.jdField_a_of_type_Bcws.a(this);
    this.jdField_a_of_type_Adtf = new adtf(this, this.jdField_a_of_type_Bcws, this.app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Adtf);
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    paramBundle.topMargin = ((int)bdcq.a(this, 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_Alox);
    if (AppSetting.c) {
      this.leftView.setContentDescription(alpo.a(2131714378));
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
    removeObserver(this.jdField_a_of_type_Alox);
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
          localObject = (adte)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((adte)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((adte)localObject).jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShieldFriendsListActivity
 * JD-Core Version:    0.7.0.1
 */