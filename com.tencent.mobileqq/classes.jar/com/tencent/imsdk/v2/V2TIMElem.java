package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.GroupTipsElement;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.LocationElement;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.message.VideoElement;
import java.io.Serializable;
import java.util.List;

public class V2TIMElem
  implements Serializable
{
  private final String TAG = "V2TIMElem";
  private int elemIndex;
  private Message message;
  
  public void appendElem(V2TIMElem paramV2TIMElem)
  {
    if (this.message == null)
    {
      IMLog.e("V2TIMElem", "appendElem error, must be first elem from message");
      return;
    }
    Object localObject;
    if ((paramV2TIMElem instanceof V2TIMTextElem))
    {
      localObject = new TextElement();
      ((TextElement)localObject).setTextContent(((V2TIMTextElem)paramV2TIMElem).getText());
      this.message.addElement((MessageBaseElement)localObject);
    }
    else
    {
      if (!(paramV2TIMElem instanceof V2TIMCustomElem)) {
        break label131;
      }
      localObject = new CustomElement();
      V2TIMCustomElem localV2TIMCustomElem = (V2TIMCustomElem)paramV2TIMElem;
      ((CustomElement)localObject).setData(localV2TIMCustomElem.getData());
      ((CustomElement)localObject).setDescription(localV2TIMCustomElem.getDescription());
      ((CustomElement)localObject).setExtension(localV2TIMCustomElem.getExtension());
      this.message.addElement((MessageBaseElement)localObject);
    }
    paramV2TIMElem.setMessage(this.message);
    paramV2TIMElem.setElemIndex(this.message.getMessageBaseElements().size() - 1);
    return;
    label131:
    IMLog.e("V2TIMElem", "appendElem error, not support this elem type");
  }
  
  MessageBaseElement getElement()
  {
    Object localObject = this.message;
    if (localObject == null) {
      return null;
    }
    localObject = ((Message)localObject).getMessageBaseElements();
    if (this.elemIndex >= 0)
    {
      int i = ((List)localObject).size();
      int j = this.elemIndex;
      if (i <= j) {
        return null;
      }
      return (MessageBaseElement)((List)localObject).get(j);
    }
    return null;
  }
  
  Message getMessage()
  {
    return this.message;
  }
  
  public V2TIMElem getNextElem()
  {
    Object localObject1 = this.message;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((Message)localObject1).getMessageBaseElements();
    int i = this.elemIndex + 1;
    if (i >= ((List)localObject2).size()) {
      return null;
    }
    localObject1 = new V2TIMElem();
    localObject2 = (MessageBaseElement)((List)localObject2).get(i);
    if ((localObject2 instanceof TextElement))
    {
      localObject1 = new V2TIMTextElem();
    }
    else if ((localObject2 instanceof ImageElement))
    {
      localObject1 = new V2TIMImageElem();
    }
    else if ((localObject2 instanceof VideoElement))
    {
      localObject1 = new V2TIMVideoElem();
    }
    else if ((localObject2 instanceof SoundElement))
    {
      localObject1 = new V2TIMSoundElem();
    }
    else
    {
      boolean bool = localObject2 instanceof FileElement;
      if (bool) {
        localObject1 = new V2TIMFaceElem();
      } else if (bool) {
        localObject1 = new V2TIMFileElem();
      } else if ((localObject2 instanceof CustomElement)) {
        localObject1 = new V2TIMCustomElem();
      } else if ((localObject2 instanceof LocationElement)) {
        localObject1 = new V2TIMLocationElem();
      } else if ((localObject2 instanceof MergerElement)) {
        localObject1 = new V2TIMMergerElem();
      } else if ((localObject2 instanceof GroupTipsElement)) {
        localObject1 = new V2TIMGroupTipsElem();
      }
    }
    ((V2TIMElem)localObject1).setMessage(this.message);
    ((V2TIMElem)localObject1).setElemIndex(i);
    return localObject1;
  }
  
  void setElemIndex(int paramInt)
  {
    this.elemIndex = paramInt;
  }
  
  void setMessage(Message paramMessage)
  {
    this.message = paramMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMElem
 * JD-Core Version:    0.7.0.1
 */