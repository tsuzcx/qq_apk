package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.biz.pubaccount.readinjoy.biu.RIJNewBiuCardTransformManager;
import com.tencent.qphone.base.util.QLog;

class FrameworkHandler$5
  implements Runnable
{
  FrameworkHandler$5(FrameworkHandler paramFrameworkHandler) {}
  
  public void run()
  {
    RIJNewBiuCardTransformManager.a().a();
    QLog.d("FrameworkHandler", 2, "transformCommentBiuCard | in recommend feeds and transform ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.5
 * JD-Core Version:    0.7.0.1
 */