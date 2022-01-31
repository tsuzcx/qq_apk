package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SubHandleBase
{
  public long a;
  public VideoAppInterface a;
  public WeakReference b;
  public final String i = "AVRedBag_" + getClass().getSimpleName() + "_" + this.jdField_a_of_type_Long;
  
  public SubHandleBase(AVRedBagMgr paramAVRedBagMgr)
  {
    this.jdField_a_of_type_Long = AudioHelper.a();
    this.b = new WeakReference(paramAVRedBagMgr);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramAVRedBagMgr.a();
  }
  
  public AVActivity a()
  {
    AVRedBagMgr localAVRedBagMgr = (AVRedBagMgr)this.b.get();
    if (localAVRedBagMgr != null) {
      return localAVRedBagMgr.a();
    }
    return null;
  }
  
  public AVRedBagMgr a()
  {
    AVRedBagMgr localAVRedBagMgr = (AVRedBagMgr)this.b.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.redbag.SubHandleBase
 * JD-Core Version:    0.7.0.1
 */