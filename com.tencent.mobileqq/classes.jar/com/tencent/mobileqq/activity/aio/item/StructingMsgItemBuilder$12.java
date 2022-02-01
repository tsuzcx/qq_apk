package com.tencent.mobileqq.activity.aio.item;

import bdqr;
import beqz;
import beyq;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class StructingMsgItemBuilder$12
  implements Runnable
{
  StructingMsgItemBuilder$12(StructingMsgItemBuilder paramStructingMsgItemBuilder, bdqr parambdqr) {}
  
  public void run()
  {
    Object localObject = beyq.a(this.a.a, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      if ((beqz.b((String)localObject)) && (this.a.a.thumbWidthHeightDP != null))
      {
        String str = beqz.d((String)localObject);
        QLog.d("StructingMsgItemBuilder", 1, new Object[] { "big image exists, begin compress urlString=", localObject, ", dst=", str });
        StructingMsgItemBuilder.a(str, beyq.a(this.a.a, 65537), this.a.a.thumbWidthHeightDP);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */