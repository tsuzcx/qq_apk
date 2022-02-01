package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ShareChat$MyResultReceiver
  extends ResultReceiver
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private WeakReference<ShareChat.SharePanel> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  public ShareChat$MyResultReceiver(Handler paramHandler, ShareChat.SharePanel paramSharePanel, int paramInt1, int paramInt2, long paramLong)
  {
    super(paramHandler);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSharePanel);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    paramBundle = (ShareChat.SharePanel)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramBundle == null) {
      return;
    }
    int j = this.jdField_a_of_type_Int;
    int i = 2;
    StringBuilder localStringBuilder;
    if (j != 1)
    {
      if ((j != 2) && (j != 3))
      {
        if (j != 4)
        {
          if (j != 5) {
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startTroop2DCode.PARAM_ActivityResultReceiver, resultCode[");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("], seq[");
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localStringBuilder.append("]");
          QLog.w("ShareChat", 1, localStringBuilder.toString());
          paramBundle.a(5, this.b, 3);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startTroop2DCode.PARAM_QRForwardReceiver, resultCode[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("], mIHandle[");
        localStringBuilder.append(paramBundle.a);
        localStringBuilder.append("]");
        QLog.w("ShareChat", 1, localStringBuilder.toString());
        if (paramBundle.a != null)
        {
          paramBundle = paramBundle.a;
          j = this.b;
          if (paramInt != -1) {
            i = 3;
          }
          paramBundle.b(5, j, i);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("shareToMobileQQ.onReceiveResult, resultCode[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("]");
        QLog.w("ShareChat", 1, localStringBuilder.toString());
        j = this.b;
        if (paramInt != -1) {
          i = 3;
        }
        paramBundle.a(0, j, i);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareToQzone.onReceiveResult, resultCode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]");
      QLog.w("ShareChat", 1, localStringBuilder.toString());
      j = this.b;
      if (paramInt != -1) {
        i = 3;
      }
      paramBundle.a(1, j, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */