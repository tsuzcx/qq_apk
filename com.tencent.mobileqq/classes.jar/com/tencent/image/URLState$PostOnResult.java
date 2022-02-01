package com.tencent.image;

public class URLState$PostOnResult
  implements Runnable
{
  Object result;
  
  public URLState$PostOnResult(URLState paramURLState, Object paramObject)
  {
    this.result = paramObject;
  }
  
  public void run()
  {
    this.this$0.onResult(this.result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.URLState.PostOnResult
 * JD-Core Version:    0.7.0.1
 */