package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import gxh_message.Dialogue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class BaseMessageProcessorForTroopAndDisc$QTroopHotChatTopicHandler
{
  protected ArrayList<MessageRecord> a;
  protected PBDecodeContext b;
  protected boolean c;
  protected msg_comm.MsgHead d;
  protected long e;
  protected long f;
  protected long g;
  protected long h;
  protected List<im_msg_body.Elem> i;
  protected byte j;
  protected String k;
  protected boolean l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected TroopMemberInfo s;
  protected int t;
  protected int u;
  protected int v;
  protected int w;
  
  public BaseMessageProcessorForTroopAndDisc$QTroopHotChatTopicHandler(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<im_msg_body.Elem> paramList, byte paramByte, String paramString)
  {
    this.a = paramArrayList;
    this.b = paramPBDecodeContext;
    this.c = paramBoolean;
    this.d = paramMsgHead;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramLong3;
    this.h = paramLong4;
    this.i = paramList;
    this.j = paramByte;
    this.k = paramString;
  }
  
  private void l()
  {
    Object localObject1 = this.i;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
      if ((((im_msg_body.Elem)localObject2).general_flags.has()) && (((im_msg_body.Elem)localObject2).general_flags.bytes_pb_reserve.has()))
      {
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        localResvAttr.mergeFrom(((im_msg_body.Elem)localObject2).general_flags.bytes_pb_reserve.get().toByteArray());
        if (localResvAttr.bytes_user_vip_info.has())
        {
          localObject2 = new Dialogue();
          ((Dialogue)localObject2).mergeFrom(localResvAttr.bytes_user_vip_info.get().toByteArray());
          this.w = ((Dialogue)localObject2).diyfontid.get();
        }
      }
    }
  }
  
  public int a()
  {
    return this.m;
  }
  
  public int b()
  {
    return this.n;
  }
  
  public int c()
  {
    return this.o;
  }
  
  public int d()
  {
    return this.p;
  }
  
  public int e()
  {
    return this.q;
  }
  
  public int f()
  {
    return this.r;
  }
  
  public int g()
  {
    return this.v;
  }
  
  public int h()
  {
    return this.w;
  }
  
  public TroopMemberInfo i()
  {
    return this.s;
  }
  
  public QTroopHotChatTopicHandler j()
  {
    this.l = false;
    this.m = -100;
    this.n = -100;
    this.o = -100;
    this.p = -100;
    this.q = -100;
    this.r = -100;
    this.w = -100;
    this.v = -100;
    this.t = 0;
    this.s = null;
    this.u = 0;
    l();
    k();
    return this;
  }
  
  protected void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler
 * JD-Core Version:    0.7.0.1
 */