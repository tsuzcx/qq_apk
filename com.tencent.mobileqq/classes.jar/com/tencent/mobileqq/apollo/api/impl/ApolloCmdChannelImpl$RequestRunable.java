package com.tencent.mobileqq.apollo.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.api.channel.IRequestHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class ApolloCmdChannelImpl$RequestRunable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<ApolloCmdChannelImpl> jdField_a_of_type_JavaLangRefWeakReference;
  private String b;
  
  ApolloCmdChannelImpl$RequestRunable(ApolloCmdChannelImpl paramApolloCmdChannelImpl, long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloCmdChannelImpl);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    ApolloCmdChannelImpl localApolloCmdChannelImpl;
    do
    {
      return;
      localApolloCmdChannelImpl = (ApolloCmdChannelImpl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localApolloCmdChannelImpl == null) || (this.jdField_a_of_type_Long == -1L) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b)));
    synchronized (ApolloCmdChannelImpl.access$000(localApolloCmdChannelImpl))
    {
      Iterator localIterator = ApolloCmdChannelImpl.access$000(localApolloCmdChannelImpl).iterator();
      while (localIterator.hasNext())
      {
        HandleResult localHandleResult = ((IRequestHandler)localIterator.next()).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.b);
        if (localHandleResult != null)
        {
          if (localHandleResult.jdField_a_of_type_Boolean) {
            localIterator.remove();
          }
          if (localHandleResult.b) {
            localApolloCmdChannelImpl.callbackFromRequest(this.jdField_a_of_type_Long, 0, this.jdField_a_of_type_JavaLangString, localHandleResult.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloCmdChannelImpl.RequestRunable
 * JD-Core Version:    0.7.0.1
 */