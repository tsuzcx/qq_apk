package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class GenerateThumbArgs
{
  public final WeakReference<Activity> a;
  public final int b;
  public final int c;
  public final String d;
  public final float e;
  public final boolean f;
  public final int g;
  public final double h;
  public final double i;
  public final String j;
  public final boolean k;
  
  public GenerateThumbArgs(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, float paramFloat, boolean paramBoolean1, int paramInt3, double paramDouble1, double paramDouble2, String paramString2, boolean paramBoolean2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = new WeakReference(paramActivity);
    this.d = paramString1;
    this.e = paramFloat;
    this.f = paramBoolean1;
    this.g = paramInt3;
    this.h = paramDouble1;
    this.i = paramDouble2;
    this.j = paramString2;
    this.k = paramBoolean2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GenerateThumbArgs{mFileDir='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRatioWH=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mShowLastFrameThumb=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mOrientation=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mLatitude=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mLongitude=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mExistsThumbPath=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mThumbOk=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbArgs
 * JD-Core Version:    0.7.0.1
 */