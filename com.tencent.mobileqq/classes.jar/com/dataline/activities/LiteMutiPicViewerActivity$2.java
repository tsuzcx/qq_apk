package com.dataline.activities;

import com.tencent.mobileqq.app.DataLineObserver;

class LiteMutiPicViewerActivity$2
  extends DataLineObserver
{
  LiteMutiPicViewerActivity$2(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity) {}
  
  public void a(long paramLong)
  {
    this.a.runOnUiThread(new LiteMutiPicViewerActivity.2.6(this));
  }
  
  public void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new LiteMutiPicViewerActivity.2.5(this));
  }
  
  public void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new LiteMutiPicViewerActivity.2.1(this));
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new LiteMutiPicViewerActivity.2.4(this));
  }
  
  public void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    this.a.runOnUiThread(new LiteMutiPicViewerActivity.2.2(this));
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    this.a.runOnUiThread(new LiteMutiPicViewerActivity.2.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity.2
 * JD-Core Version:    0.7.0.1
 */