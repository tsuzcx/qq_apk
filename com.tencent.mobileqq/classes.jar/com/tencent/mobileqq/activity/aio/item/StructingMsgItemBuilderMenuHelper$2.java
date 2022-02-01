package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.net.URL;

class StructingMsgItemBuilderMenuHelper$2
  implements Runnable
{
  StructingMsgItemBuilderMenuHelper$2(StructingMsgItemBuilderMenuHelper paramStructingMsgItemBuilderMenuHelper, StructMsgItemImage paramStructMsgItemImage, int paramInt, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = URLDrawableHelper.getURL(this.a.aF, 1);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((URL)localObject).toString();
    }
    localObject = AbsDownloader.getFilePath((String)localObject);
    QfavBuilder.a(this.a.aw, this.b, this.a.av, this.a.aB, (String)localObject, this.a.aC).b(this.c, this.d).a(this.e, this.c.getAccount());
    QfavReport.a(this.c, 6, 3);
    QfavReport.a(this.c, 2, 0, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilderMenuHelper.2
 * JD-Core Version:    0.7.0.1
 */