package com.tencent.imcore.message.facade.add.inner;

import com.tencent.imcore.message.facade.IAddMultiMessagesInnerProcessor;
import java.util.ArrayList;

class AddMultiMsgProcessorProvider$1
  extends ArrayList<IAddMultiMessagesInnerProcessor>
{
  AddMultiMsgProcessorProvider$1(AddMultiMsgProcessorProvider paramAddMultiMsgProcessorProvider)
  {
    add(new QIMProcessor());
    add(new QFileAssistantProcessor());
    add(new WeatherReportProcessor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.AddMultiMsgProcessorProvider.1
 * JD-Core Version:    0.7.0.1
 */