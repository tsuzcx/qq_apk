package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;

class AVRedBagMgr$5
  implements GetRedBag.GetRedBagListener
{
  AVRedBagMgr$5(AVRedBagMgr paramAVRedBagMgr) {}
  
  public void a(GetRedBag paramGetRedBag)
  {
    if (paramGetRedBag == this.a.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag)
    {
      this.a.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag = null;
      this.a.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag$GetRedBagListener = null;
      this.a.a("onGetRedBagResult", AVRedBagMgr.d(this.a), paramGetRedBag.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + paramGetRedBag + "], src[" + this.a.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr.5
 * JD-Core Version:    0.7.0.1
 */