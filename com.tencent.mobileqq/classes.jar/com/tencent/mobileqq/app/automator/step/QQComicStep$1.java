package com.tencent.mobileqq.app.automator.step;

import com.tencent.comic.api.IQQDcReporter;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class QQComicStep$1
  extends MessageObserver
{
  QQComicStep$1(QQComicStep paramQQComicStep) {}
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject = StructMsgFactory.a(((MessageRecord)paramList.next()).msgData);
        if ((localObject instanceof StructMsgForImageShare))
        {
          localObject = (StructMsgForImageShare)localObject;
          if ((((StructMsgForImageShare)localObject).mMsgActionData != null) && (((StructMsgForImageShare)localObject).mMsgActionData.startsWith("comic_plugin.apk")))
          {
            String[] arrayOfString = ((StructMsgForImageShare)localObject).mMsgActionData.substring(((StructMsgForImageShare)localObject).mMsgActionData.indexOf("|") + 1).split("\\|");
            if (arrayOfString.length >= 8) {
              ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.a.mAutomator.a, "3009", "1", "30014", arrayOfString[0], new String[] { arrayOfString[2], arrayOfString[4], AIOGallerySceneWithBusiness.a(((StructMsgForImageShare)localObject).mMsgActionData) });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QQComicStep.1
 * JD-Core Version:    0.7.0.1
 */