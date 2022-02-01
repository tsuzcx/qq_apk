package com.tencent.imcore.message;

import com.tencent.imcore.message.adder.AddMessageHandlerGenerator;
import com.tencent.imcore.message.adder.AddMessageHandlerGeneratorImpl;
import com.tencent.imcore.message.adder.C2CAddMessageHandlerGenerator;
import com.tencent.imcore.message.adder.C2CAddMessageHandlerGeneratorImpl;
import com.tencent.imcore.message.adder.IAddMessageHandler;
import com.tencent.imcore.message.adder.IC2CAddMessageHandler;
import com.tencent.imcore.message.aiolist.AioMsgHandlerGenerator;
import com.tencent.imcore.message.aiolist.AioMsgHandlerGeneratorImpl;
import com.tencent.imcore.message.aiolist.IAioMsgHandler;
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
import com.tencent.imcore.message.decoder.IMessageDecoder;
import com.tencent.imcore.message.decoder.MessageDecoderGenerator;
import com.tencent.imcore.message.decoder.MessageDecoderGeneratorImpl;
import com.tencent.imcore.message.msgboxappender.IMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.MsgBoxAppenderGenerator;
import com.tencent.imcore.message.msgboxappender.MsgBoxAppenderGeneratorImpl;
import com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGenerator;
import com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGeneratorImpl;
import com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider;
import com.tencent.mobileqq.app.pbsendhandler.IPbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGenerator;
import com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGeneratorImpl;
import com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.RichTextAndMsgViaProviderGenerator;
import com.tencent.mobileqq.app.richtext.RichTextAndMsgViaProviderGeneratorImpl;
import com.tencent.mobileqq.service.message.codec.decoder.C2CMessageDecoderGenerator;
import com.tencent.mobileqq.service.message.codec.decoder.C2CMessageDecoderGeneratorImpl;
import com.tencent.mobileqq.service.message.codec.decoder.Decoder;
import java.util.List;

public class Registry
{
  private RoutingTypeGenerator a = new RoutingTypeGeneratorImpl();
  private UinTypeRoutingTypeMap b = new UinTypeRoutingTypeMapImpl();
  private TempSessionServiceTypeGenerator c = new TempSessionServiceTypeGeneratorImpl();
  private TempSessionCacheGenerator d = new TempSessionCacheGeneratorImpl();
  private IPBMsgElemsDecoderGenerator e = new PBMsgElemsDecoderGeneratorImpl();
  private IUinPairMsgUinTypeCallbackGenerator f = new UinPairMsgUinTypeCallbackGeneratorImpl();
  private ExtractMessageSummaryCallbackGenerator g = new ExtractMessageSummaryCallbackGeneratorImpl();
  private CreatePbSendReqFromMessageCallbackGenerator h = new CreatePbSendReqFromMessageCallbackGeneratorImpl();
  private GetUnreadMsgNumCallbackGenerator i = new GetUnreadMsgNumCallbackGeneratorImpl();
  private GetAioListCallbackGenerator j = new GetAioListCallbackGeneratorImpl();
  private C2CMessageDecoderGenerator k = new C2CMessageDecoderGeneratorImpl();
  private MessageDecoderGenerator l = new MessageDecoderGeneratorImpl();
  private AddMessageHandlerGenerator m = new AddMessageHandlerGeneratorImpl();
  private AioMsgHandlerGenerator n = new AioMsgHandlerGeneratorImpl();
  private C2CAddMessageHandlerGenerator o = new C2CAddMessageHandlerGeneratorImpl();
  private MsgBoxAppenderGenerator p = new MsgBoxAppenderGeneratorImpl();
  private GeneralFlagProviderGenerator q = new GeneralFlagProviderGeneratorImpl();
  private PbSendReqHandlerGenerator r = new PbSendReqHandlerGeneratorImpl();
  private RichTextAndMsgViaProviderGenerator s = new RichTextAndMsgViaProviderGeneratorImpl();
  
  public Registry()
  {
    D();
  }
  
  private void D() {}
  
  public PbSendReqHandlerGenerator A()
  {
    return this.r;
  }
  
  public List<IRichTextAndMsgViaProvider> B()
  {
    return this.s.a();
  }
  
  public RichTextAndMsgViaProviderGenerator C()
  {
    return this.s;
  }
  
  public RoutingTypeGenerator a()
  {
    return this.a;
  }
  
  public Decoder a(int paramInt)
  {
    return (Decoder)this.k.a(Integer.valueOf(paramInt));
  }
  
  public void a(Class<? extends IPBMsgElemDecoder> paramClass)
  {
    this.e.a(paramClass);
  }
  
  public UinTypeRoutingTypeMap b()
  {
    return this.b;
  }
  
  public TempSessionServiceTypeGenerator c()
  {
    return this.c;
  }
  
  public TempSessionCacheGenerator d()
  {
    return this.d;
  }
  
  public List<IPBMsgElemDecoder> e()
  {
    return this.e.a();
  }
  
  public List<ExtractMessageSummaryCallback> f()
  {
    return this.g.a();
  }
  
  public ExtractMessageSummaryCallbackGenerator g()
  {
    return this.g;
  }
  
  public List<CreatePbSendReqFromMessageCallback> h()
  {
    return this.h.a();
  }
  
  public C2CMessageDecoderGenerator i()
  {
    return this.k;
  }
  
  public List<GetUnreadMsgNumCallback> j()
  {
    return this.i.a();
  }
  
  public GetUnreadMsgNumCallbackGenerator k()
  {
    return this.i;
  }
  
  public GetAioListCallbackGenerator l()
  {
    return this.j;
  }
  
  public List<GetAioListCallback> m()
  {
    return this.j.a();
  }
  
  public List<IMessageDecoder> n()
  {
    return this.l.a();
  }
  
  public MessageDecoderGenerator o()
  {
    return this.l;
  }
  
  public List<IAddMessageHandler> p()
  {
    return this.m.a();
  }
  
  public AddMessageHandlerGenerator q()
  {
    return this.m;
  }
  
  public List<IAioMsgHandler> r()
  {
    return this.n.a();
  }
  
  public AioMsgHandlerGenerator s()
  {
    return this.n;
  }
  
  public List<IC2CAddMessageHandler> t()
  {
    return this.o.a();
  }
  
  public C2CAddMessageHandlerGenerator u()
  {
    return this.o;
  }
  
  public List<IMsgBoxAppender> v()
  {
    return this.p.a();
  }
  
  public MsgBoxAppenderGenerator w()
  {
    return this.p;
  }
  
  public List<IGeneralFlagProvider> x()
  {
    return this.q.a();
  }
  
  public GeneralFlagProviderGenerator y()
  {
    return this.q;
  }
  
  public List<IPbSendReqHandler> z()
  {
    return this.r.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.Registry
 * JD-Core Version:    0.7.0.1
 */