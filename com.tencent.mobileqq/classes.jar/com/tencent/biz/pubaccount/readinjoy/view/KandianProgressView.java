package com.tencent.biz.pubaccount.readinjoy.view;

import aekt;
import alpo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import java.io.File;
import rpy;
import rpz;

public class KandianProgressView
  extends LinearLayout
{
  public Bundle a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new rpy(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public String a;
  public rpz a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView d;
  TextView e;
  
  public KandianProgressView(Context paramContext, Bundle paramBundle, rpz paramrpz)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131560202, this);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("mTaskID");
    this.jdField_a_of_type_Rpz = paramrpz;
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("arg_video_cover");
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    b();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(0);
      c(8);
      return;
    }
    b(8);
    c(0);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365979));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376053));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375692));
    this.d = ((TextView)findViewById(2131365095));
    this.e = ((TextView)findViewById(2131371251));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372321));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364883));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375684));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365080));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    setCoverImg();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(paramInt);
    this.e.setVisibility(paramInt);
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.d.setVisibility(paramInt);
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    this.e.setText(alpo.a(2131706317) + paramInt + "%");
    a(true);
  }
  
  protected void a(String paramString)
  {
    int j = 1;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      int i = aekt.a(100.0F, getResources());
      int k = aekt.a(100.0F, getResources());
      float f1 = ((BitmapFactory.Options)localObject).outWidth / i;
      float f2 = ((BitmapFactory.Options)localObject).outHeight / k;
      i = j;
      if (f1 >= 1.0F)
      {
        i = j;
        if (f2 >= 1.0F) {
          i = (int)Math.floor(Math.min(f1, f2));
        }
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      try
      {
        localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        paramString = ReadInJoyBaseDeliverActivity.a(ReadInJoyBaseDeliverActivity.a(paramString), (Bitmap)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void setCoverImg()
  {
    a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void setViewInformation(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("mTaskID");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("arg_video_cover");
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    setCoverImg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView
 * JD-Core Version:    0.7.0.1
 */