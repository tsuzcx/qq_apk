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
      ReLinkerInstance.a(this.this$0, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.b);
      this.jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LoadListener.a();
      return;
    }
    catch (MissingLibraryException localMissingLibraryException)
    {
      this.jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LoadListener.a(localMissingLibraryException);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      this.jdField_a_of_type_ComGetkeepsafeRelinkerReLinker$LoadListener.a(localUnsatisfiedLinkError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.ReLinkerInstance.1
 * JD-Core Version:    0.7.0.1
 */