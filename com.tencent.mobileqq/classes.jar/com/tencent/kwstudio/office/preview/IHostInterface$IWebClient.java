package com.tencent.kwstudio.office.preview;

public abstract interface IHostInterface$IWebClient
{
  @Deprecated
  public abstract boolean onConsoleMessage(String paramString);
  
  public abstract boolean onConsoleMessage(String paramString1, int paramInt, String paramString2);
  
  public abstract boolean onJsPrompt(Object paramObject, String paramString1, String paramString2, String paramString3);
  
  public abstract boolean onPageFinished(Object paramObject, String paramString);
  
  public abstract boolean shouldOverrideUrlLoading(Object paramObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.kwstudio.office.preview.IHostInterface.IWebClient
 * JD-Core Version:    0.7.0.1
 */