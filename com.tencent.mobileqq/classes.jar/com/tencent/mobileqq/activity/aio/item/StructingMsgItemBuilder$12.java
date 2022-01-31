package com.tencent.mobileqq.activity.aio.item;

import awwr;
import axoa;
import axwd;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class StructingMsgItemBuilder$12
  implements Runnable
{
  StructingMsgItemBuilder$12(StructingMsgItemBuilder paramStructingMsgItemBuilder, awwr paramawwr) {}
  
  public void run()
  {
    Object localObject = axwd.a(this.a.a, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      if ((axoa.b((String)localObject)) && (this.a.a.thumbWidthHeightDP != null))
      {
        String str = axoa.d((String)localObject);
        QLog.d("StructingMsgItemBuilder", 1, new Object[] { "big image exists, begin compress urlString=", localObject, ", dst=", str });
        StructingMsgItemBuilder.a(str, axwd.a(this.a.a, 65537), this.a.a.thumbWidthHeightDP);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */