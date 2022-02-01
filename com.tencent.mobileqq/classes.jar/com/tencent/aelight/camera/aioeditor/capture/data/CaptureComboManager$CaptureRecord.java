package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureComboMusic;
import java.util.ArrayList;

public class CaptureComboManager$CaptureRecord
{
  public ComboSet a;
  public long b;
  public FilterSet c;
  public long d;
  CaptureComboMusic e;
  ArrayList<CaptureComboBase> f;
  int g;
  
  public CaptureComboManager$CaptureRecord(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ComboSet)localObject).b == 3))
    {
      this.a.c(paramActivity, this.g);
      this.a.a(paramActivity, this.g);
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((FilterSet)localObject).c(paramActivity, this.g);
      this.c.a(paramActivity, this.g);
    }
  }
  
  public void a(ComboSet paramComboSet)
  {
    this.a = paramComboSet;
    this.b = System.currentTimeMillis();
  }
  
  public void a(FilterSet paramFilterSet)
  {
    this.c = paramFilterSet;
    this.d = System.currentTimeMillis();
  }
  
  public boolean a()
  {
    return (this.c == null) || (this.d <= this.b);
  }
  
  public void b()
  {
    VideoFilterTools.a().b(null, null, this.g);
    VideoFilterTools.a().a(null, this.g);
    this.c = null;
  }
  
  public void b(Activity paramActivity)
  {
    VideoFilterTools.a().d(this.g);
    VideoFilterTools.a().a(null, paramActivity, this.g);
    Object localObject = VideoFilterTools.a().e;
    int i = this.g;
    localObject = localObject[i];
    if (localObject != null) {
      ((ComboSet)localObject).b(paramActivity, i);
    }
    VideoFilterTools.a().a(null, paramActivity, this.g);
    VideoFilterTools.a().b(null, paramActivity, this.g);
  }
  
  public void c(Activity paramActivity)
  {
    b(paramActivity);
    this.a = null;
    this.c = null;
    this.e = null;
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord
 * JD-Core Version:    0.7.0.1
 */