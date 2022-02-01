package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class ComboProviderGridAdapter$LockAnimationDrawable
  extends DetectableAnimationDrawable
{
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow = null;
  QIMFilterCategoryItem jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem = null;
  ImageView b = null;
  
  public ComboProviderGridAdapter$LockAnimationDrawable(AnimationDrawable paramAnimationDrawable, ImageView paramImageView1, PopupWindow paramPopupWindow, ImageView paramImageView2, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    super(paramAnimationDrawable);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = paramPopupWindow;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView1;
    this.b = paramImageView2;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem = paramQIMFilterCategoryItem;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    Object localObject = (CaptureComboManager)QIMManager.a(5);
    ((CaptureComboManager)localObject).a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    SharedPreUtils.m(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, false);
    VideoFilterTools.a().a(3, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", 0);
    ((CaptureComboManager)localObject).a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem, (Activity)this.b.getContext(), localBundle);
    this.b.setVisibility(8);
    localObject = ((CaptureComboManager)localObject).a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem);
    ComboProviderGridAdapter.a(this.b, (CaptureComboBase)localObject, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderGridAdapter.LockAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */