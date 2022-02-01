package com.tencent.mobileqq.apollo.api.impl;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/impl/ApolloMessageServiceImpl$Companion$MessageType;", "", "(Ljava/lang/String;I)V", "STATE_OR_DRESS_CHANGE", "TRACE_SPAN_MESSAGE", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public enum ApolloMessageServiceImpl$Companion$MessageType
{
  static
  {
    MessageType localMessageType1 = new MessageType("STATE_OR_DRESS_CHANGE", 0);
    STATE_OR_DRESS_CHANGE = localMessageType1;
    MessageType localMessageType2 = new MessageType("TRACE_SPAN_MESSAGE", 1);
    TRACE_SPAN_MESSAGE = localMessageType2;
    $VALUES = new MessageType[] { localMessageType1, localMessageType2 };
  }
  
  private ApolloMessageServiceImpl$Companion$MessageType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloMessageServiceImpl.Companion.MessageType
 * JD-Core Version:    0.7.0.1
 */