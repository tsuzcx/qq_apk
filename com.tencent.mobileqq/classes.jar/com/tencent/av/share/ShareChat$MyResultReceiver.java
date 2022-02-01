package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lyx;
import lyz;

public class ShareChat$MyResultReceiver
  extends ResultReceiver
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private WeakReference<lyx> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  public ShareChat$MyResultReceiver(Handler paramHandler, lyx paramlyx, int paramInt1, int paramInt2, long paramLong)
  {
    super(paramHandler);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramlyx);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    int i = 2;
    paramBundle = (lyx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramBundle == null) {}
    do
    {
      return;
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        QLog.w("ShareChat", 1, "shareToQzone.onReceiveResult, resultCode[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "]");
        j = this.b;
        if (paramInt == -1) {}
        for (;;)
        {
          paramBundle.a(1, j, i);
          return;
          i = 3;
        }
      case 2: 
      case 3: 
        QLog.w("ShareChat", 1, "shareToMobileQQ.onReceiveResult, resultCode[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "]");
        j = this.b;
        if (paramInt == -1) {}
        for (;;)
        {
          paramBundle.a(0, j, i);
          return;
          i = 3;
        }
      case 4: 
        QLog.w("ShareChat", 1, "startTroop2DCode.PARAM_QRForwardReceiver, resultCode[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "], mIHandle[" + paramBundle.a + "]");
      }
    } while (paramBundle.a == null);
    paramBundle = paramBundle.a;
    int j = this.b;
    if (paramInt == -1) {}
    for (;;)
    {
      paramBundle.b(5, j, i);
      return;
      i = 3;
    }
    QLog.w("ShareChat", 1, "startTroop2DCode.PARAM_ActivityResultReceiver, resultCode[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "]");
    paramBundle.a(5, this.b, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */