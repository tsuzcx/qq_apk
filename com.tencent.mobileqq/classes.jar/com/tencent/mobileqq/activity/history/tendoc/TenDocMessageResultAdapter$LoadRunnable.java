package com.tencent.mobileqq.activity.history.tendoc;

import android.os.Bundle;
import android.os.Message;
import bfmt;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.qphone.base.util.QLog;
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
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageResultAdapter", 2, "loadMessageResult, run(), keyword = " + this.jdField_a_of_type_JavaLangString + ", loadType = " + this.jdField_a_of_type_Int);
    }
    Object localObject2 = new ArrayList();
    Object localObject4 = TenDocMessageResultAdapter.a(this.this$0, TenDocMessageResultAdapter.a(this.this$0), (ArrayList)localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageResultAdapter", 2, "loadMessageResult, get: messageItems[] = " + localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter.LoadRunnable
 * JD-Core Version:    0.7.0.1
 */