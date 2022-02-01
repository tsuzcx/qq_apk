package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureComboMusic;
import java.util.ArrayList;

public class CaptureComboManager$CaptureRecord
{
  int jdField_a_of_type_Int;
  public long a;
  public ComboSet a;
  public FilterSet a;
  CaptureComboMusic jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureComboMusic;
  ArrayList<CaptureComboBase> jdField_a_of_type_JavaUtilArrayList;
  public long b;
  
  public CaptureComboManager$CaptureRecord(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    VideoFilterTools.a().b(null, null, this.jdField_a_of_type_Int);
    VideoFilterTools.a().a(null, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataFilterSet = null;
  }
  
  public void a(Activity paramActivity)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboSet;
    if ((localObject != null) && (((ComboSet)localObject).jdField_a_of_type_Int == 3))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboSet.b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboSet.a(paramActivity, this.jdField_a_of_type_Int);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataFilterSet;
    if (localObject != null)
    {
      ((FilterSet)localObject).b(paramActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataFilterSet.a(paramActivity, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(ComboSet paramComboSet)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboSet = paramComboSet;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(FilterSet paramFilterSet)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataFilterSet = paramFilterSet;
    this.b = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataFilterSet == null) || (this.b <= this.jdField_a_of_type_Long);
  }
  
  public void b(Activity paramActivity)
  {
    VideoFilterTools.a().a(this.jdField_a_of_type_Int);
    VideoFilterTools.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    Object localObject = VideoFilterTools.a().a;
    int i = this.jdField_a_of_type_Int;
    localObject = localObject[i];
    if (localObject != null) {
      ((ComboSet)localObject).a(paramActivity, i);
    }
    VideoFilterTools.a().a(null, paramActivity, this.jdField_a_of_type_Int);
    VideoFilterTools.a().b(null, paramActivity, this.jdField_a_of_type_Int);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboSet = null;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataFilterSet = null;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureComboMusic = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord
 * JD-Core Version:    0.7.0.1
 */