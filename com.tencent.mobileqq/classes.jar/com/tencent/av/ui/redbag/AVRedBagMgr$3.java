package com.tencent.av.ui.redbag;

import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.qphone.base.util.QLog;

class AVRedBagMgr$3
  implements ResultUI.OnResultUIListener
{
  AVRedBagMgr$3(AVRedBagMgr paramAVRedBagMgr) {}
  
  public void a()
  {
    QLog.w("AVRedBag", 1, "mResultUI 关闭了");
    this.a.a = null;
    AVVoiceRecog.a().b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr.3
 * JD-Core Version:    0.7.0.1
 */