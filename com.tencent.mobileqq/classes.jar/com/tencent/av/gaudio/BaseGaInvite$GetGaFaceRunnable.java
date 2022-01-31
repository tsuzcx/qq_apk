package com.tencent.av.gaudio;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lnr;
import mqo;

public class BaseGaInvite$GetGaFaceRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  final String jdField_a_of_type_JavaLangString;
  WeakReference<lnr> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  
  public BaseGaInvite$GetGaFaceRunnable(String paramString, VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, long paramLong1, long paramLong2, lnr paramlnr)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_JavaLangString = Long.toString(paramLong2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramlnr);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "refreshUI[" + paramString + "], WaitDelayPost");
      return;
    }
    b(paramString);
  }
  
  void b(String paramString)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Boolean = false;
    int i = this.jdField_a_of_type_Int;
    String str = String.valueOf(this.jdField_a_of_type_Long);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, null, true, false);
    int j = mqo.c(this.jdField_b_of_type_Int);
    str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, null);
    Object localObject;
    if ((localBitmap != null) && (!TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      localObject = (lnr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {}
    }
    for (boolean bool1 = ((lnr)localObject).a(localBitmap, str);; bool1 = false)
    {
      if (!bool1)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1500L);
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      paramString = new StringBuilder().append("setGaFace[").append(paramString).append("], mRelationType[").append(this.jdField_b_of_type_Int).append("], uinType_Group[").append(i).append("], mGroupId[").append(this.jdField_a_of_type_Long).append("], uinType_Invite[").append(j).append("], mInviterUin[").append(this.jdField_b_of_type_JavaLangString).append("], memberName[").append(str).append("], faceBitmap[");
      if (localBitmap != null) {
        bool2 = true;
      }
      QLog.w((String)localObject, 1, bool2 + "], mWaitDelayPost[" + this.jdField_a_of_type_Boolean + "], result[" + bool1 + "]");
      return;
    }
  }
  
  public void run()
  {
    b("Runnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable
 * JD-Core Version:    0.7.0.1
 */