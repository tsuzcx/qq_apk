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
  String a;
  String b;
  int c;
  int d;
  int e;
  float f;
  boolean g;
  boolean h;
  double i;
  double j;
  int k;
  int l;
  String m;
  int n;
  boolean o;
  Bitmap p;
  
  public GenerateThumbTask(@NonNull Bitmap paramBitmap, @NonNull String paramString, int paramInt1, int paramInt2, int paramInt3, float paramFloat, double paramDouble1, double paramDouble2, int paramInt4)
  {
    this.a = paramString;
    this.e = paramInt3;
    this.f = paramFloat;
    this.i = paramDouble1;
    this.j = paramDouble2;
    this.k = paramInt1;
    this.l = paramInt2;
    this.n = paramInt4;
    this.p = paramBitmap;
  }
  
  private void a()
  {
    this.c = 320;
    this.d = ((int)(this.c / this.f));
    int i1 = this.d;
    if (i1 % 2 > 0) {
      this.d = (i1 - 1);
    }
    i1 = this.k;
    if (i1 > 0) {
      this.c = i1;
    }
    i1 = this.l;
    if (i1 > 0) {
      this.d = i1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlowSendTask():mFileDir:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mThumbWidth: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mThumbHeight:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mThumbOK:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mShowLastFrameThumb:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mExistThumbPath:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mExistThumbOk:");
    localStringBuilder.append(this.o);
    SLog.b("Q.qqstory.publish.edit.GenerateThumbTask", localStringBuilder.toString());
  }
  
  private int b()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      String str = this.a;
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
      ImageUtil.a(this.a, this.i, this.j);
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      label57:
      boolean bool;
      break label57;
    }
    localObject = this.a;
    if (localObject != null) {
      bool = new File((String)localObject).exists();
    } else {
      bool = false;
    }
    StoryReportor.b("video_edit", "update_LBS_exif_failed", 0, 0, new String[] { this.a, String.valueOf(bool) });
    if (!new File(this.a).exists())
    {
      SLog.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb, coverFile not exists, vf dir = %s, mThumbPath = %s", new Object[] { this.b, this.a });
      return 1;
    }
    return 0;
    SLog.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. bitmap = null or path = null.");
    return 1;
  }
  
  public Integer a(Void... paramVarArgs)
  {
    a();
    return Integer.valueOf(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbTask
 * JD-Core Version:    0.7.0.1
 */