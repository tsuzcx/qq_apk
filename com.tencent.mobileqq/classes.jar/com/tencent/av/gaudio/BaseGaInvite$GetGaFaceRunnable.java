package com.tencent.av.gaudio;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class BaseGaInvite$GetGaFaceRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  final String jdField_a_of_type_JavaLangString;
  WeakReference<BaseGaInvite.GetGaFaceRunnable.OnGetSink> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  
  public BaseGaInvite$GetGaFaceRunnable(String paramString, VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, long paramLong1, long paramLong2, BaseGaInvite.GetGaFaceRunnable.OnGetSink paramOnGetSink)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_JavaLangString = Long.toString(paramLong2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnGetSink);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshUI[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], WaitDelayPost");
      QLog.w(str, 1, localStringBuilder.toString());
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
    int j = AVUtil.c(this.jdField_b_of_type_Int);
    str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, null);
    if ((localBitmap != null) && (!TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      localObject = (BaseGaInvite.GetGaFaceRunnable.OnGetSink)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        bool1 = ((BaseGaInvite.GetGaFaceRunnable.OnGetSink)localObject).a(localBitmap, str);
        break label111;
      }
    }
    boolean bool1 = false;
    label111:
    if (!bool1)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1500L);
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGaFace[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mRelationType[");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("], uinType_Group[");
    localStringBuilder.append(i);
    localStringBuilder.append("], mGroupId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], uinType_Invite[");
    localStringBuilder.append(j);
    localStringBuilder.append("], mInviterUin[");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("], memberName[");
    localStringBuilder.append(str);
    localStringBuilder.append("], faceBitmap[");
    if (localBitmap != null) {
      bool2 = true;
    }
    localStringBuilder.append(bool2);
    localStringBuilder.append("], mWaitDelayPost[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], result[");
    localStringBuilder.append(bool1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void run()
  {
    b("Runnable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable
 * JD-Core Version:    0.7.0.1
 */