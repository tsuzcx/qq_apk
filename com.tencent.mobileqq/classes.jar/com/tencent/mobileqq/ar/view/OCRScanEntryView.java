package com.tencent.mobileqq.ar.view;

import akxi;
import akyn;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apdh;
import awqx;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import mqq.os.MqqHandler;

public class OCRScanEntryView
  extends ScanEntryProviderView
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnimationQIMCircleProgress jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress;
  private volatile boolean jdField_a_of_type_Boolean;
  private TextView b;
  
  public OCRScanEntryView(Context paramContext, akyn paramakyn)
  {
    super(paramContext, paramakyn);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.e("AREngine_OCRScanEntryView", 1, "handleTakePhotoBtnClick, is in recognize! filePath: " + paramString);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (apdh.a(paramString))
    {
      OCRResultActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramString, 6);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    ThreadManager.getFileThreadHandler().post(new OCRScanEntryView.1(this));
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495070, null, false));
      paramBundle = new FrameLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramBundle);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305332);
      akxi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305330));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305324));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305323));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305326));
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setBackgroundResource(2130843544);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterView();
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setOnClickListener(this);
    }
  }
  
  public void a(String paramString)
  {
    if (!apdh.a(paramString))
    {
      QLog.d("AREngine_OCRScanEntryView", 1, String.format("doDealGalleryPicFile path: %s is not exist", new Object[] { paramString }));
      return;
    }
    b(paramString);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131305330: 
      awqx.b(null, "dc00898", "", "", "0X8009C80", "0X8009C80", 0, 0, "", "0", "0", "");
      b(null);
      return;
    case 2131305324: 
      l();
      return;
    }
    m();
    awqx.b(null, "dc00898", "", "", "0X8009C86", "0X8009C86", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.OCRScanEntryView
 * JD-Core Version:    0.7.0.1
 */