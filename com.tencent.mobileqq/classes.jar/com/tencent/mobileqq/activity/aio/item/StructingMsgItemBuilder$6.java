package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class StructingMsgItemBuilder$6
  implements Runnable
{
  StructingMsgItemBuilder$6(StructingMsgItemBuilder paramStructingMsgItemBuilder, StructMsgItemImage paramStructMsgItemImage) {}
  
  public void run()
  {
    Object localObject = URLDrawableHelper.getURL(this.a.aF, 1);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((URL)localObject).toString();
    }
    if ((AbsDownloader.hasFile((String)localObject)) && (this.a.aF.thumbWidthHeightDP != null))
    {
      String str = AbsDownloader.getFilePath((String)localObject);
      QLog.d("StructingMsgItemBuilder", 1, new Object[] { "big image exists, begin compress urlString=", localObject, ", dst=", str });
      StructingMsgItemBuilder.a(str, URLDrawableHelper.getURL(this.a.aF, 65537), this.a.aF.thumbWidthHeightDP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */