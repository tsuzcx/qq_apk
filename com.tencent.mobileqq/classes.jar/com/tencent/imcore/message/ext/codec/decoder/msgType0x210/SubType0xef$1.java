package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class SubType0xef$1
  implements Runnable
{
  SubType0xef$1(int paramInt) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Linkstar Push!ChooserAc!! msgType = ");
    localStringBuilder.append(this.a);
    QQToast.a(localBaseApplication, localStringBuilder.toString(), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xef.1
 * JD-Core Version:    0.7.0.1
 */