package com.tencent.av.ui.redbag;

import com.tencent.av.business.handler.AVC2CDataHandler;
import com.tencent.av.business.handler.AVC2CDataHandler.C2CDataHandler;
import com.tencent.qphone.base.util.QLog;

public class ListenPeerMsg
  extends SubHandleBase
{
  public int a;
  public AVC2CDataHandler.C2CDataHandler a;
  public boolean a;
  public boolean b = false;
  
  ListenPeerMsg(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandler = new ListenPeerMsg.1(this);
    paramAVRedBagMgr = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (paramAVRedBagMgr != null)
    {
      paramAVRedBagMgr.a(11, this.jdField_a_of_type_ComTencentAvBusinessHandlerAVC2CDataHandler$C2CDataHandler);
      return;
    }
    QLog.w(this.i, 1, "ListenPeerMsg, mHandlerForVideo为空");
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.i, 1, "resetData[" + paramString + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.ListenPeerMsg
 * JD-Core Version:    0.7.0.1
 */