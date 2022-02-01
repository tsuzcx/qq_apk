package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMMergerElem$1
  implements V2TIMValueCallback<List<Message>>
{
  V2TIMMergerElem$1(V2TIMMergerElem paramV2TIMMergerElem, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(List<Message> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Message localMessage = (Message)paramList.next();
      V2TIMMessage localV2TIMMessage = new V2TIMMessage();
      localV2TIMMessage.setMessage(localMessage);
      localArrayList.add(localV2TIMMessage);
    }
    paramList = this.val$callback;
    if (paramList != null) {
      paramList.onSuccess(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMergerElem.1
 * JD-Core Version:    0.7.0.1
 */