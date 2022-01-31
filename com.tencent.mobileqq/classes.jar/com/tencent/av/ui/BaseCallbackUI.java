package com.tencent.av.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import jqi;

public class BaseCallbackUI
{
  public int a;
  public Handler a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private TextView b;
  
  public BaseCallbackUI()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public BaseCallbackUI(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramActivity.findViewById(2131365840));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramActivity.findViewById(2131365850));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramActivity.findViewById(2131365849));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131365847));
    this.b = ((TextView)paramActivity.findViewById(2131365848));
    if (paramInt == 1001)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramActivity.getResources().getString(2131438346));
    }
    for (;;)
    {
      paramActivity = new AlphaAnimation(0.1F, 1.0F);
      paramActivity.setDuration(1000L);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(paramActivity);
      this.b.startAnimation(paramActivity);
      b();
      this.jdField_a_of_type_JavaLangRunnable = new jqi(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
      return;
      if (paramInt == 1002)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramActivity.getResources().getString(2131438351));
      }
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt].setEnabled(true);
    if (paramInt == 4)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setEnabled(false);
      this.jdField_a_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_Int = (paramInt + 1);
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[this.jdField_a_of_type_Int].setEnabled(false);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[5];
    int i = 0;
    while (i < 5)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setEnabled(true);
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[this.jdField_a_of_type_Int].setEnabled(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.BaseCallbackUI
 * JD-Core Version:    0.7.0.1
 */