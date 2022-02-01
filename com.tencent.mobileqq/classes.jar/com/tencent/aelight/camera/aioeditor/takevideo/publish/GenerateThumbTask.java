package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;

public class GenerateThumbTask
{
  double jdField_a_of_type_Double;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  double jdField_b_of_type_Double;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  int f;
  
  public GenerateThumbTask(@NonNull Bitmap paramBitmap, @NonNull String paramString, int paramInt1, int paramInt2, int paramInt3, float paramFloat, double paramDouble1, double paramDouble2, int paramInt4)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt4;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        if (!BitmapUtils.a((Bitmap)localObject, str))
        {
          SLog.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. compress thumb bitmap to file error.");
          return 1;
        }
      }
    }
    try
    {
      ImageUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      label57:
      boolean bool;
      break label57;
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null) {
      bool = new File((String)localObject).exists();
    } else {
      bool = false;
    }
    StoryReportor.b("video_edit", "update_LBS_exif_failed", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(bool) });
    if (!new File(this.jdField_a_of_type_JavaLangString).exists())
    {
      SLog.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb, coverFile not exists, vf dir = %s, mThumbPath = %s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString });
      return 1;
    }
    return 0;
    SLog.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. bitmap = null or path = null.");
    return 1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 320;
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int / this.jdField_a_of_type_Float));
    int i = this.jdField_b_of_type_Int;
    if (i % 2 > 0) {
      this.jdField_b_of_type_Int = (i - 1);
    }
    i = this.d;
    if (i > 0) {
      this.jdField_a_of_type_Int = i;
    }
    i = this.e;
    if (i > 0) {
      this.jdField_b_of_type_Int = i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlowSendTask():mFileDir:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mThumbWidth: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mThumbHeight:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mThumbOK:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", mShowLastFrameThumb:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mExistThumbPath:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", mExistThumbOk:");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    SLog.b("Q.qqstory.publish.edit.GenerateThumbTask", localStringBuilder.toString());
  }
  
  public Integer a(Void... paramVarArgs)
  {
    a();
    return Integer.valueOf(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbTask
 * JD-Core Version:    0.7.0.1
 */