package com.tencent.mobileqq.activity.photo.album;

import agqs;
import agrw;
import agrx;
import agrz;
import agso;
import agsq;
import agss;
import aguq;
import amkf;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anoz;
import axqy;
import bbbx;
import bcuc;
import bfqu;
import bkvi;
import blcj;
import blck;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.HorizontalListView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import lze;

public class NewPhotoPreviewActivity
  extends PeakActivity
  implements CompoundButton.OnCheckedChangeListener, bfqu
{
  float a;
  public int a;
  public agqs a;
  public agrw a;
  public agrx a;
  public agso a;
  public agsq a;
  public SurfaceView a;
  public View a;
  public Button a;
  public CheckBox a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public DragGallery a;
  public NumberCheckBox a;
  public BubblePopupWindow a;
  public DragView a;
  public HorizontalListView a;
  public boolean a;
  float b;
  public int b;
  public View b;
  public Button b;
  public CheckBox b;
  public RelativeLayout b;
  public TextView b;
  public View c;
  public RelativeLayout c;
  public TextView c;
  public TextView d;
  public TextView e;
  
  public NewPhotoPreviewActivity()
  {
    this.jdField_a_of_type_Float = 13.0F;
    this.jdField_b_of_type_Float = 9.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Agrw = new agrw(this);
  }
  
  public void F()
  {
    Object localObject = this.jdField_a_of_type_Agrw.a(a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = a((String)localObject);
      if (localObject != null)
      {
        if (((LocalMediaInfo)localObject).mMediaType != 0) {
          break label77;
        }
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        axqy.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 4, 0, "", "", "", "");
      }
      this.jdField_a_of_type_Agsq.a(true);
      return;
      label77:
      if (((LocalMediaInfo)localObject).mMediaType == 1) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void G()
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      Drawable localDrawable = this.jdField_c_of_type_AndroidWidgetRelativeLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(255);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_Agsq.a())
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    }
  }
  
  public void H() {}
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getSelectedItemPosition();
  }
  
  public int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (b(paramString) == null)) {
      return -1;
    }
    return bbbx.a(b(paramString));
  }
  
  public Drawable a(String paramString, int paramInt1, int paramInt2, LocalMediaInfo paramLocalMediaInfo)
  {
    anoz localanoz = new anoz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localanoz, localanoz);
        localURLDrawable.setTag(paramLocalMediaInfo);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception paramLocalMediaInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoPreviewActivity", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, paramLocalMediaInfo);
        }
      }
    }
    return localanoz;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = b(paramString);
    paramString = localLocalMediaInfo;
    if (localLocalMediaInfo == null)
    {
      paramString = new LocalMediaInfo();
      paramString.mMediaType = 0;
    }
    return paramString;
  }
  
  public String a()
  {
    return getResources().getString(2131695100, new Object[] { Integer.valueOf(this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.jdField_a_of_type_Int) });
  }
  
  public URL a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    String str = paramFile.getPath();
    if ((!TextUtils.isEmpty(str)) && (a(str) == 1)) {
      return bbbx.a(str, "VIDEO");
    }
    try
    {
      paramFile = paramFile.toURI().toURL();
      return paramFile;
    }
    catch (MalformedURLException paramFile) {}
    return null;
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getFirstVisiblePosition();
      if (i < this.jdField_a_of_type_Agso.jdField_a_of_type_JavaUtilArrayList.size()) {
        localArrayList.add(this.jdField_a_of_type_Agso.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Agso.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      Drawable localDrawable = this.jdField_c_of_type_AndroidWidgetRelativeLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, -1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(paramInt);
      return;
    }
    paramInt = this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString) + 1;
    if (paramInt <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      return;
    }
    if (paramInt >= 100) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(this.jdField_b_of_type_Float);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(paramInt);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(this.jdField_a_of_type_Float);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public LocalMediaInfo b(String paramString)
  {
    if (this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap != null) {}
    for (LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.get(paramString);; localLocalMediaInfo = null)
    {
      if ((localLocalMediaInfo == null) && (this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.b != null)) {
        localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.b.get(paramString);
      }
      for (;;)
      {
        Object localObject;
        if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
        {
          localObject = new blck();
          blcj.a(paramString, (blck)localObject);
          localLocalMediaInfo.mediaWidth = localObject.a[0];
          localLocalMediaInfo.mediaHeight = localObject.a[1];
          localLocalMediaInfo.rotation = localObject.a[2];
          localObject = this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.b;
          if (localObject == null) {
            break label196;
          }
        }
        label196:
        for (paramString = (LocalMediaInfo)((HashMap)localObject).get(paramString);; paramString = null)
        {
          if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
          {
            paramString.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramString.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramString.rotation = localLocalMediaInfo.rotation;
          }
          return localLocalMediaInfo;
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Agso.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      AIOLongShotHelper.a(this, paramIntent);
    }
    while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      return;
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoPreviewActivity", 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    this.jdField_a_of_type_Agsq.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.a(false))) {
      return;
    }
    this.jdField_a_of_type_Agsq.a(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    for (;;)
    {
      if ((!this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) && (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      return;
      this.jdField_a_of_type_Agsq.a(paramCompoundButton, paramBoolean);
      continue;
      this.jdField_a_of_type_Agsq.jdField_a_of_type_Agss.b(paramBoolean);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Agsq = aguq.a(getIntent().getIntExtra("enter_from", 0), this);
    this.jdField_a_of_type_Agso = this.jdField_a_of_type_Agsq.jdField_a_of_type_Agso;
    bkvi.a(this);
    this.jdField_a_of_type_Agsq.a(getIntent());
    if (this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_Agsq.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString = this.q;
    }
    if (bkvi.c()) {
      bkvi.b(this);
    }
    super.onCreate(paramBundle);
    super.setContentView(2131559385);
    this.jdField_a_of_type_Agsq.c();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    QQLiveImage.onBackground(this);
    super.onDestroy();
    this.jdField_a_of_type_Agsq.e();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_a_of_type_Agsq.a(paramIntent);
    this.jdField_a_of_type_Agsq.c();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Agqs != null) {
      this.jdField_a_of_type_Agqs.i();
    }
    lze.a(BaseApplicationImpl.getContext(), false);
    bcuc.a(BaseApplicationImpl.getContext(), true);
    amkf.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Agsq.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */