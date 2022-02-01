package com.tencent.avgame.floatwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mxy;
import myi;
import nhs;

public class CommonGameFloatWindowLayout
  extends FloatWindowBaseLayout
  implements View.OnClickListener
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  mxy jdField_a_of_type_Mxy;
  
  public CommonGameFloatWindowLayout(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void f()
  {
    this.b = ((int)getResources().getDimension(2131296561));
    this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131296562));
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558710, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369230));
    Bitmap localBitmap = nhs.a("avgame_float_waiting@2x.png");
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.b;
    setOnClickListener(this);
  }
  
  public int a(myi parammyi)
  {
    return parammyi.jdField_a_of_type_Int - this.jdField_a_of_type_Int / 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Bitmap localBitmap = nhs.a("avgame_float_waiting@2x.png");
      if (localBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  public boolean a(myi parammyi)
  {
    boolean bool = true;
    if (parammyi == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowBaseLayout", 2, "updateFloatWindow isForeground: " + parammyi.jdField_a_of_type_Boolean);
    }
    if (parammyi.jdField_a_of_type_Boolean) {
      if (a()) {}
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (b()) {
        bool = false;
      }
    }
  }
  
  public int b(myi parammyi)
  {
    return parammyi.b - this.b / 2;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Bitmap localBitmap = nhs.a("avgame_float_playing@2x.png");
      if (localBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Bitmap localBitmap = nhs.a("avgame_float_you_play@2x.png");
      if (localBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Mxy != null) {
      this.jdField_a_of_type_Mxy.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnFloatWindowClickListener(mxy parammxy)
  {
    this.jdField_a_of_type_Mxy = parammxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.CommonGameFloatWindowLayout
 * JD-Core Version:    0.7.0.1
 */