package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SubHandleBase
{
  public VideoAppInterface a;
  public long b;
  public WeakReference<AVRedBagMgr> b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_b_of_type_Long;
  
  SubHandleBase(AVRedBagMgr paramAVRedBagMgr)
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Long = AudioHelper.b();
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAVRedBagMgr);
    this.a = paramAVRedBagMgr.a();
  }
  
  AVActivity a()
  {
    AVRedBagMgr localAVRedBagMgr = (AVRedBagMgr)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localAVRedBagMgr != null) {
      return localAVRedBagMgr.a();
    }
    return null;
  }
  
  AVRedBagMgr a()
  {
    AVRedBagMgr localAVRedBagMgr = (AVRedBagMgr)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localAVRedBagMgr == null) {
      QLog.d(this.i, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localAVRedBagMgr;
  }
  
  protected void finalize()
  {
    QLog.d(this.i, 1, "finalize, " + toString());
    super.finalize();
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.SubHandleBase
 * JD-Core Version:    0.7.0.1
 */