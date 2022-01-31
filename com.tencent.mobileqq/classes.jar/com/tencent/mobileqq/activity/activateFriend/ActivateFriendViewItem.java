package com.tencent.mobileqq.activity.activateFriend;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActivateFriendViewItem
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public boolean a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ActivateFriendViewItem(Context paramContext)
  {
    this(paramContext, true, true);
  }
  
  public ActivateFriendViewItem(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext, paramBoolean1, paramBoolean2);
  }
  
  private void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    LayoutInflater.from(paramContext).inflate(2131560599, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367679));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371564));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370647));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363259));
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setHorizontallyScrolling(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setHorizontallyScrolling(false);
    }
    if (!paramBoolean1)
    {
      paramContext = findViewById(2131367417).getBackground();
      if ((paramContext != null) && ((paramContext instanceof GradientDrawable))) {
        ((GradientDrawable)paramContext).setColor(-1);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8))
    {
      paramAccessibilityNodeInfo.setCheckable(true);
      paramAccessibilityNodeInfo.setChecked(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void setBirthday(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843924);
    }
    for (;;)
    {
      String str2 = "" + this.jdField_a_of_type_AndroidWidgetTextView.getText();
      String str1 = str2;
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        str1 = str2 + this.jdField_b_of_type_AndroidWidgetTextView.getText();
      }
      setContentDescription(str1);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843926);
    }
  }
  
  public void setHead(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
  
  public void setIndex(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setNickName(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendViewItem
 * JD-Core Version:    0.7.0.1
 */