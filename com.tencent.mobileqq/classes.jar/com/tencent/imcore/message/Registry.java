package com.tencent.imcore.message;

import com.tencent.imcore.message.core.ExtractMessageSummaryCallback;
import com.tencent.imcore.message.core.ExtractMessageSummaryCallbackGenerator;
import com.tencent.imcore.message.core.ExtractMessageSummaryCallbackGeneratorImpl;
import com.tencent.imcore.message.core.GetAioListCallbackGenerator;
import com.tencent.imcore.message.core.GetAioListCallbackGeneratorImpl;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallback;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallbackGenerator;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallbackGeneratorImpl;
import com.tencent.imcore.message.core.codec.CreatePbSendReqFromMessageCallback;
import com.tencent.imcore.message.core.codec.CreatePbSendReqFromMessageCallbackGenerator;
import com.tencent.imcore.message.core.codec.CreatePbSendReqFromMessageCallbackGeneratorImpl;
import com.tencent.imcore.message.core.codec.IPBMsgElemDecoder;
import com.tencent.imcore.message.core.codec.IPBMsgElemsDecoderGenerator;
import com.tencent.imcore.message.core.codec.IUinPairMsgUinTypeCallbackGenerator;
import com.tencent.imcore.message.core.codec.PBMsgElemsDecoderGeneratorImpl;
import com.tencent.imcore.message.core.codec.RoutingTypeGenerator;
import com.tencent.imcore.message.core.codec.RoutingTypeGeneratorImpl;
import com.tencent.imcore.message.core.codec.TempSessionCacheGenerator;
import com.tencent.imcore.message.core.codec.TempSessionCacheGeneratorImpl;
import com.tencent.imcore.message.core.codec.TempSessionServiceTypeGenerator;
import com.tencent.imcore.message.core.codec.TempSessionServiceTypeGeneratorImpl;
import com.tencent.imcore.message.core.codec.UinPairMsgUinTypeCallbackGeneratorImpl;
import com.tencent.imcore.message.core.codec.UinTypeRoutingTypeMap;
import com.tencent.imcore.message.core.codec.UinTypeRoutingTypeMapImpl;
import com.tencent.mobileqq.service.message.codec.decoder.C2CMessageDecoderGenerator;
import com.tencent.mobileqq.service.message.codec.decoder.C2CMessageDecoderGeneratorImpl;
import com.tencent.mobileqq.service.message.codec.decoder.Decoder;
import java.util.List;

public class Registry
{
  private ExtractMessageSummaryCallbackGenerator jdField_a_of_type_ComTencentImcoreMessageCoreExtractMessageSummaryCallbackGenerator = new ExtractMessageSummaryCallbackGeneratorImpl();
  private GetAioListCallbackGenerator jdField_a_of_type_ComTencentImcoreMessageCoreGetAioListCallbackGenerator = new GetAioListCallbackGeneratorImpl();
  private GetUnreadMsgNumCallbackGenerator jdField_a_of_type_ComTencentImcoreMessageCoreGetUnreadMsgNumCallbackGenerator = new GetUnreadMsgNumCallbackGeneratorImpl();
  private CreatePbSendReqFromMessageCallbackGenerator jdField_a_of_type_ComTencentImcoreMessageCoreCodecCreatePbSendReqFromMessageCallbackGenerator = new CreatePbSendReqFromMessageCallbackGeneratorImpl();
  private IPBMsgElemsDecoderGenerator jdField_a_of_type_ComTencentImcoreMessageCoreCodecIPBMsgElemsDecoderGenerator = new PBMsgElemsDecoderGeneratorImpl();
  private IUinPairMsgUinTypeCallbackGenerator jdField_a_of_type_ComTencentImcoreMessageCoreCodecIUinPairMsgUinTypeCallbackGenerator = new UinPairMsgUinTypeCallbackGeneratorImpl();
  private RoutingTypeGenerator jdField_a_of_type_ComTencentImcoreMessageCoreCodecRoutingTypeGenerator = new RoutingTypeGeneratorImpl();
  private TempSessionCacheGenerator jdField_a_of_type_ComTencentImcoreMessageCoreCodecTempSessionCacheGenerator = new TempSessionCacheGeneratorImpl();
  private TempSessionServiceTypeGenerator jdField_a_of_type_ComTencentImcoreMessageCoreCodecTempSessionServiceTypeGenerator = new TempSessionServiceTypeGeneratorImpl();
  private UinTypeRoutingTypeMap jdField_a_of_type_ComTencentImcoreMessageCoreCodecUinTypeRoutingTypeMap = new UinTypeRoutingTypeMapImpl();
  private C2CMessageDecoderGenerator jdField_a_of_type_ComTencentMobileqqServiceMessageCodecDecoderC2CMessageDecoderGenerator = new C2CMessageDecoderGeneratorImpl();
  
  public Registry()
  {
    a();
  }
  
  private void a() {}
  
  public ExtractMessageSummaryCallbackGenerator a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreExtractMessageSummaryCallbackGenerator;
  }
  
  public GetAioListCallbackGenerator a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreGetAioListCallbackGenerator;
  }
  
  public GetUnreadMsgNumCallbackGenerator a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreGetUnreadMsgNumCallbackGenerator;
  }
  
  public RoutingTypeGenerator a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreCodecRoutingTypeGenerator;
  }
  
  public TempSessionCacheGenerator a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreCodecTempSessionCacheGenerator;
  }
  
  public TempSessionServiceTypeGenerator a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreCodecTempSessionServiceTypeGenerator;
  }
  
  public UinTypeRoutingTypeMap a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreCodecUinTypeRoutingTypeMap;
  }
  
  public C2CMessageDecoderGenerator a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceMessageCodecDecoderC2CMessageDecoderGenerator;
  }
  
  public Decoder a(int paramInt)
  {
    return (Decoder)this.jdField_a_of_type_ComTencentMobileqqServiceMessageCodecDecoderC2CMessageDecoderGenerator.a(Integer.valueOf(paramInt));
  }
  
  public List<IPBMsgElemDecoder> a()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreCodecIPBMsgElemsDecoderGenerator.a();
  }
  
  public void a(Class<? extends IPBMsgElemDecoder> paramClass)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageCoreCodecIPBMsgElemsDecoderGenerator.a(paramClass);
  }
  
  public List<ExtractMessageSummaryCallback> b()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreExtractMessageSummaryCallbackGenerator.a();
  }
  
  public List<CreatePbSendReqFromMessageCallback> c()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreCodecCreatePbSendReqFromMessageCallbackGenerator.a();
  }
  
  public List<GetUnreadMsgNumCallback> d()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreGetUnreadMsgNumCallbackGenerator.a();
  }
  
  public List<GetAioListCallback> e()
  {
    return this.jdField_a_of_type_ComTencentImcoreMessageCoreGetAioListCallbackGenerator.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.Registry
 * JD-Core Version:    0.7.0.1
 */