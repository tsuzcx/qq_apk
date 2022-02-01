package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tts.TtsListener;

class TextPreviewActivity$10
  implements TtsListener
{
  TextPreviewActivity$10(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new TextPreviewActivity.10.2(this));
  }
  
  public void a(String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new TextPreviewActivity.10.1(this));
  }
  
  public void b()
  {
    ThreadManagerV2.getUIHandlerV2().post(new TextPreviewActivity.10.3(this));
  }
  
  public void b(String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new TextPreviewActivity.10.4(this));
  }
  
  public void c()
  {
    ThreadManagerV2.getUIHandlerV2().post(new TextPreviewActivity.10.5(this));
  }
  
  public void d()
  {
    ThreadManagerV2.getUIHandlerV2().post(new TextPreviewActivity.10.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.10
 * JD-Core Version:    0.7.0.1
 */