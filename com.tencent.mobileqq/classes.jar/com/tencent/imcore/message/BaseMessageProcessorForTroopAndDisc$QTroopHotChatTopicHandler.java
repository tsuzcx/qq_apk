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
  protected byte a;
  protected int a;
  protected long a;
  protected TroopMemberInfo a;
  protected PBDecodeContext a;
  protected String a;
  protected ArrayList<MessageRecord> a;
  protected List<im_msg_body.Elem> a;
  protected msg_comm.MsgHead a;
  protected boolean a;
  protected int b;
  protected long b;
  protected boolean b;
  protected int c;
  protected long c;
  protected int d;
  protected long d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  
  public BaseMessageProcessorForTroopAndDisc$QTroopHotChatTopicHandler(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<im_msg_body.Elem> paramList, byte paramByte, String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext = paramPBDecodeContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead = paramMsgHead;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = paramLong3;
    this.jdField_d_of_type_Long = paramLong4;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void b()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
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
          this.i = ((Dialogue)localObject2).diyfontid.get();
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public QTroopHotChatTopicHandler a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -100;
    this.jdField_b_of_type_Int = -100;
    this.jdField_c_of_type_Int = -100;
    this.jdField_d_of_type_Int = -100;
    this.e = -100;
    this.f = -100;
    this.i = -100;
    this.g = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = null;
    this.h = 0;
    b();
    a();
    return this;
  }
  
  public TroopMemberInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  }
  
  protected void a() {}
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler
 * JD-Core Version:    0.7.0.1
 */