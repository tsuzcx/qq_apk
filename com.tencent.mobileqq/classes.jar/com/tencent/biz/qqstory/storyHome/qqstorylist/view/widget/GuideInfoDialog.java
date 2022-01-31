package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.utils.UIUtils;
import obq;
import obr;
import obs;
import obt;

public class GuideInfoDialog
  extends Dialog
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  public GuideInfoDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public GuideInfoDialog a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public GuideInfoDialog a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public GuideInfoDialog b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public GuideInfoDialog b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public GuideInfoDialog c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public GuideInfoDialog d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130970742);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371789));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369738));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371661));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131371663));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369739));
    ((RelativeLayout)findViewById(2131371660)).setOnClickListener(new obq(this));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString, UIUtils.a(getContext(), 307.0F), UIUtils.a(getContext(), 155.0F), new RoundedTransformation(UIUtils.a(getContext(), 4.0F), 0, 0.504886F, null, null));
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label268;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!TextUtils.isEmpty(this.d)) {
        break label338;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label202:
      if (!TextUtils.isEmpty(this.c)) {
        break label396;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new obt(this));
      return;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label268:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangString) > UIUtils.a(getContext(), 280.0F)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(3);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      }
      label338:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.d);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break label202;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new obr(this));
      break label202;
      label396:
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setTag(this.c);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      } else {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new obs(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog
 * JD-Core Version:    0.7.0.1
 */