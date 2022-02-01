package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import java.util.List;

public class V2TIMMergerElem
  extends V2TIMElem
{
  public void downloadMergerMessage(V2TIMValueCallback<List<V2TIMMessage>> paramV2TIMValueCallback)
  {
    if (getElement() == null) {
      return;
    }
    Message localMessage = getMessage();
    paramV2TIMValueCallback = new V2TIMMergerElem.1(this, paramV2TIMValueCallback);
    MessageCenter.getInstance().downloadRelayMessageList(localMessage, new V2TIMMergerElem.2(this, paramV2TIMValueCallback));
  }
  
  public List<String> getAbstractList()
  {
    if (getElement() == null) {
      return null;
    }
    return ((MergerElement)getElement()).getAbstractList();
  }
  
  public String getTitle()
  {
    if (getElement() == null) {
      return null;
    }
    return ((MergerElement)getElement()).getTitle();
  }
  
  public boolean isLayersOverLimit()
  {
    if (getElement() == null) {
      return false;
    }
    return ((MergerElement)getElement()).isLayerOverLimit();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMRelayElem--->");
    localStringBuilder.append("title:");
    localStringBuilder.append(getTitle());
    localStringBuilder.append(", abstractList:");
    localStringBuilder.append(getAbstractList());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMergerElem
 * JD-Core Version:    0.7.0.1
 */