package com.tencent.mobileqq.apollo.aioChannel;

import amwq;
import amww;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class ApolloCmdChannel$RequestRunable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<ApolloCmdChannel> jdField_a_of_type_JavaLangRefWeakReference;
  private String b;
  
  ApolloCmdChannel$RequestRunable(ApolloCmdChannel paramApolloCmdChannel, long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloCmdChannel);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      localApolloCmdChannel = (ApolloCmdChannel)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localApolloCmdChannel == null) || (this.jdField_a_of_type_Long == -1L) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b)));
    synchronized (ApolloCmdChannel.access$000(localApolloCmdChannel))
    {
      Iterator localIterator = ApolloCmdChannel.access$000(localApolloCmdChannel).iterator();
      while (localIterator.hasNext())
      {
        amww localamww = ((amwq)localIterator.next()).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.b);
        if (localamww != null)
        {
          if (localamww.jdField_a_of_type_Boolean) {
            localIterator.remove();
          }
          if (localamww.b) {
            localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_Long, 0, this.jdField_a_of_type_JavaLangString, localamww.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.RequestRunable
 * JD-Core Version:    0.7.0.1
 */