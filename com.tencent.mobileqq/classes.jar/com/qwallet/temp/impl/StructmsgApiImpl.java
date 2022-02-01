package com.qwallet.temp.impl;

import com.qwallet.temp.IStructmsgApi;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout31;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StructmsgApiImpl
  implements IStructmsgApi
{
  public void handleStructMsgElement(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = (MessageForStructing)paramMessageRecord;
    List localList = ((StructMsgForGeneralShare)paramMessageRecord.structingMsg).getStructMsgItemLists();
    if ((localList != null) && (localList.size() > 0))
    {
      Object localObject = localList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((AbsStructMsgElement)((Iterator)localObject).next() instanceof StructMsgItemLayout31)) {
          ((Iterator)localObject).remove();
        }
      }
      localObject = StructMsgElementFactory.a(0);
      ((AbsStructMsgItem)localObject).a(new StructMsgItemHr());
      ((AbsStructMsgItem)localObject).a = paramMessageRecord.structingMsg;
      localList.add(localObject);
      localObject = StructMsgElementFactory.a(31);
      ((AbsStructMsgItem)localObject).a = paramMessageRecord.structingMsg;
      localList.add(localObject);
      paramMessageRecord.saveExtInfoToExtStr("wallet_ad_msg", "1");
    }
  }
  
  public boolean instanceofMessageForStructing(Object paramObject)
  {
    return paramObject instanceof MessageForStructing;
  }
  
  public void notifyAdExposureCheckersDestroy()
  {
    Iterator localIterator = StructMsgItemLayout31.b.iterator();
    while (localIterator.hasNext())
    {
      AdExposureChecker localAdExposureChecker = (AdExposureChecker)localIterator.next();
      localAdExposureChecker.onActivityDestroy();
      localAdExposureChecker.setCallback(null);
    }
    StructMsgItemLayout31.b.clear();
    StructMsgItemLayout31.a = null;
  }
  
  public void notifyAdExposureCheckersPause()
  {
    Iterator localIterator = StructMsgItemLayout31.b.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityPause();
    }
  }
  
  public void notifyAdExposureCheckersResume()
  {
    Iterator localIterator = StructMsgItemLayout31.b.iterator();
    while (localIterator.hasNext()) {
      ((AdExposureChecker)localIterator.next()).onActivityResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.StructmsgApiImpl
 * JD-Core Version:    0.7.0.1
 */