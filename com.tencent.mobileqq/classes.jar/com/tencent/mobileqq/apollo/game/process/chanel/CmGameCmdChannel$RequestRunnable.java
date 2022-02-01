package com.tencent.mobileqq.apollo.game.process.chanel;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class CmGameCmdChannel$RequestRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<CmGameCmdChannel> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  CmGameCmdChannel$RequestRunnable(CmGameCmdChannel paramCmGameCmdChannel, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCmGameCmdChannel);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void run()
  {
    ??? = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (??? == null) {
      return;
    }
    CmGameCmdChannel localCmGameCmdChannel = (CmGameCmdChannel)((WeakReference)???).get();
    if (localCmGameCmdChannel == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        return;
      }
      synchronized (localCmGameCmdChannel.a)
      {
        Iterator localIterator = localCmGameCmdChannel.a.iterator();
        while (localIterator.hasNext())
        {
          HandleResult localHandleResult = ((CmGameCmdChannel.IRequestHandler)localIterator.next()).a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          if (localHandleResult != null)
          {
            if (localHandleResult.jdField_a_of_type_Boolean) {
              localIterator.remove();
            }
            if (localHandleResult.b) {
              localCmGameCmdChannel.a(0, this.jdField_a_of_type_JavaLangString, localHandleResult.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel.RequestRunnable
 * JD-Core Version:    0.7.0.1
 */