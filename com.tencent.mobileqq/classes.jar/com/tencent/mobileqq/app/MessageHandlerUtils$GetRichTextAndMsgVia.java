package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.core.codec.CreatePbSendReqFromMessageCallback;
import com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

class MessageHandlerUtils$GetRichTextAndMsgVia
{
  private AppInterface a;
  private MessageRecord b;
  private im_msg_body.RichText c;
  private int d;
  private ArrayList<Integer> e = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(-1000), Integer.valueOf(-1049), Integer.valueOf(-2056), Integer.valueOf(-2000), Integer.valueOf(-2002), Integer.valueOf(-2007), Integer.valueOf(-2058), Integer.valueOf(-2039), Integer.valueOf(-2011), Integer.valueOf(-2051), Integer.valueOf(-7002), Integer.valueOf(-2020), Integer.valueOf(-2022), Integer.valueOf(-2071), Integer.valueOf(-5008), Integer.valueOf(-5013), Integer.valueOf(-5014), Integer.valueOf(-5012), Integer.valueOf(-5018), Integer.valueOf(-1051), Integer.valueOf(-1052), Integer.valueOf(-1035), Integer.valueOf(-2057), Integer.valueOf(-7001), Integer.valueOf(-5016), Integer.valueOf(-5017), Integer.valueOf(-7005), Integer.valueOf(-8018) }));
  
  public MessageHandlerUtils$GetRichTextAndMsgVia(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    this.a = paramAppInterface;
    this.b = paramMessageRecord;
    this.c = paramRichText;
    this.d = paramInt;
  }
  
  private static im_msg_body.RichText a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    Iterator localIterator = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().h().iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      im_msg_body.RichText localRichText = ((CreatePbSendReqFromMessageCallback)localIterator.next()).a(paramMessageRecord, paramAppInterface);
      localObject = localRichText;
      if (localRichText != null) {
        localObject = localRichText;
      }
    }
    return localObject;
  }
  
  private void d()
  {
    if (!this.e.contains(Integer.valueOf(this.b.msgtype))) {
      this.c = a(this.a, this.b);
    }
  }
  
  public im_msg_body.RichText a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public GetRichTextAndMsgVia c()
  {
    Iterator localIterator = ((IMessageFacade)this.a.getRuntimeService(IMessageFacade.class, "")).getRegistry().B().iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = ((IRichTextAndMsgViaProvider)localIterator.next()).a(this.a, this.b, this.c, this.d);
      this.c = ((im_msg_body.RichText)arrayOfObject[0]);
      this.d = ((Integer)arrayOfObject[1]).intValue();
    }
    d();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandlerUtils.GetRichTextAndMsgVia
 * JD-Core Version:    0.7.0.1
 */