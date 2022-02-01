package com.getkeepsafe.relinker;

import android.content.Context;

class ReLinkerInstance$1
  implements Runnable
{
  ReLinkerInstance$1(ReLinkerInstance paramReLinkerInstance, Context paramContext, String paramString1, String paramString2, ReLinker.LoadListener paramLoadListener) {}
  
  public void run()
  {
    try
    {
      ReLinkerInstance.a(this.this$0, this.a, this.b, this.c);
      this.d.a();
      return;
    }
    catch (MissingLibraryException localMissingLibraryException)
    {
      this.d.a(localMissingLibraryException);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      this.d.a(localUnsatisfiedLinkError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.ReLinkerInstance.1
 * JD-Core Version:    0.7.0.1
 */