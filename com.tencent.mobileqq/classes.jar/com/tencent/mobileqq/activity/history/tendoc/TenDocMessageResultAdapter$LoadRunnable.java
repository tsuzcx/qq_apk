package com.tencent.mobileqq.activity.history.tendoc;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;

class TenDocMessageResultAdapter$LoadRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  
  TenDocMessageResultAdapter$LoadRunnable(TenDocMessageResultAdapter paramTenDocMessageResultAdapter, int paramInt, String paramString, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("loadMessageResult, run(), keyword = ");
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)???).append(", loadType = ");
      ((StringBuilder)???).append(this.jdField_a_of_type_Int);
      QLog.i("TenDocMessageResultAdapter", 2, ((StringBuilder)???).toString());
    }
    Object localObject2 = new ArrayList();
    ??? = this.this$0;
    Object localObject4 = TenDocMessageResultAdapter.a((TenDocMessageResultAdapter)???, TenDocMessageResultAdapter.a((TenDocMessageResultAdapter)???), (ArrayList)localObject2);
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("loadMessageResult, get: messageItems[] = ");
      ((StringBuilder)???).append(localObject2);
      QLog.i("TenDocMessageResultAdapter", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (TenDocMessageResultAdapter.a(this.this$0).equals(this.jdField_a_of_type_JavaLangString))
      {
        TenDocMessageResultAdapter.a(this.this$0, true);
        TenDocMessageResultAdapter.a(this.this$0, (ChatHistorySearchData)localObject4);
        localObject2 = TenDocMessageResultAdapter.a(this.this$0).obtainMessage(2, localObject2);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putLong("searchSequence", this.jdField_a_of_type_Long);
        ((Bundle)localObject4).putString("searchKeyword", this.jdField_a_of_type_JavaLangString);
        ((Message)localObject2).setData((Bundle)localObject4);
        ((Message)localObject2).sendToTarget();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter.LoadRunnable
 * JD-Core Version:    0.7.0.1
 */