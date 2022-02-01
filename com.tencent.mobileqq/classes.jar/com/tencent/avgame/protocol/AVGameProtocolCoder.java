package com.tencent.avgame.protocol;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AVGameProtocolCoder
  extends BaseProtocolCoder
{
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "ProfileService", "OnlinePush" };
  private final HashMap<String, ProtocolCoder> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public String[] cmdHeaderPrefix()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (!TextUtils.isEmpty(str)) {}
    for (ProtocolCoder localProtocolCoder = (ProtocolCoder)this.jdField_a_of_type_JavaUtilHashMap.get(str);; localProtocolCoder = null)
    {
      if (localProtocolCoder != null) {}
      for (paramToServiceMsg = localProtocolCoder.a(paramToServiceMsg, paramFromServiceMsg);; paramToServiceMsg = null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameProtocolCoder", 4, "decode, cmd[" + str + "], coder[" + localProtocolCoder + "], result[" + paramToServiceMsg + "]");
        }
        return paramToServiceMsg;
      }
    }
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (!TextUtils.isEmpty(str)) {}
    for (ProtocolCoder localProtocolCoder = (ProtocolCoder)this.jdField_a_of_type_JavaUtilHashMap.get(str);; localProtocolCoder = null)
    {
      if (localProtocolCoder != null) {}
      for (boolean bool = localProtocolCoder.a(paramToServiceMsg, paramUniPacket);; bool = false)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameProtocolCoder", 4, "encodeReqMsg, cmd[" + str + "], coder[" + localProtocolCoder + "], ret[" + bool + "]");
        }
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.protocol.AVGameProtocolCoder
 * JD-Core Version:    0.7.0.1
 */