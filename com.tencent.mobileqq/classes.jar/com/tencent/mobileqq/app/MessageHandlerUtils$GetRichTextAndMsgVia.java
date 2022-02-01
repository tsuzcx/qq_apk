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
  private int jdField_a_of_type_Int;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(-1000), Integer.valueOf(-1049), Integer.valueOf(-2056), Integer.valueOf(-2000), Integer.valueOf(-2002), Integer.valueOf(-2007), Integer.valueOf(-2058), Integer.valueOf(-2039), Integer.valueOf(-2011), Integer.valueOf(-2051), Integer.valueOf(-7002), Integer.valueOf(-2020), Integer.valueOf(-2022), Integer.valueOf(-2071), Integer.valueOf(-5008), Integer.valueOf(-5013), Integer.valueOf(-5014), Integer.valueOf(-5012), Integer.valueOf(-5018), Integer.valueOf(-1051), Integer.valueOf(-1052), Integer.valueOf(-1035), Integer.valueOf(-2057), Integer.valueOf(-7001), Integer.valueOf(-5016), Integer.valueOf(-5017), Integer.valueOf(-7005) }));
  private im_msg_body.RichText jdField_a_of_type_TencentImMsgIm_msg_body$RichText;
  
  public MessageHandlerUtils$GetRichTextAndMsgVia(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = paramRichText;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static im_msg_body.RichText a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    Iterator localIterator = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().c().iterator();
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
  
  private void a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype))) {
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public GetRichTextAndMsgVia a()
  {
    Iterator localIterator = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().m().iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = ((IRichTextAndMsgViaProvider)localIterator.next()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = ((im_msg_body.RichText)arrayOfObject[0]);
      this.jdField_a_of_type_Int = ((Integer)arrayOfObject[1]).intValue();
    }
    a();
    return this;
  }
  
  public im_msg_body.RichText a()
  {
    return this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandlerUtils.GetRichTextAndMsgVia
 * JD-Core Version:    0.7.0.1
 */