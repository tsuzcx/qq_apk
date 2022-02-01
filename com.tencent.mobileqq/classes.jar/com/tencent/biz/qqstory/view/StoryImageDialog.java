package com.tencent.biz.qqstory.view;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class StoryImageDialog
  extends ReportDialog
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561627);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374487));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374529));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374528));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131374533));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131374534));
    ((RelativeLayout)findViewById(2131374486)).setOnClickListener(new StoryImageDialog.1(this));
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangString) > UIUtils.a(getContext(), 280.0F)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(3);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.c))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.c);
      paramBundle = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (paramBundle != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramBundle);
      } else {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new StoryImageDialog.2(this));
      }
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setTag(this.jdField_b_of_type_JavaLangString);
      paramBundle = this.jdField_b_of_type_AndroidViewView$OnClickListener;
      if (paramBundle != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(paramBundle);
      } else {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new StoryImageDialog.3(this));
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new StoryImageDialog.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.StoryImageDialog
 * JD-Core Version:    0.7.0.1
 */