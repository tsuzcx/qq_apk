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
    boolean bool = TextUtils.isEmpty(str);
    Object localObject = null;
    ProtocolCoder localProtocolCoder;
    if (!bool) {
      localProtocolCoder = (ProtocolCoder)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    } else {
      localProtocolCoder = null;
    }
    if (localProtocolCoder != null) {
      localObject = localProtocolCoder.a(paramToServiceMsg, paramFromServiceMsg);
    }
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("decode, cmd[");
      paramToServiceMsg.append(str);
      paramToServiceMsg.append("], coder[");
      paramToServiceMsg.append(localProtocolCoder);
      paramToServiceMsg.append("], result[");
      paramToServiceMsg.append(localObject);
      paramToServiceMsg.append("]");
      QLog.i("AVGameProtocolCoder", 4, paramToServiceMsg.toString());
    }
    return localObject;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    ProtocolCoder localProtocolCoder;
    if (!TextUtils.isEmpty(str)) {
      localProtocolCoder = (ProtocolCoder)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    } else {
      localProtocolCoder = null;
    }
    boolean bool;
    if (localProtocolCoder != null) {
      bool = localProtocolCoder.a(paramToServiceMsg, paramUniPacket);
    } else {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("encodeReqMsg, cmd[");
      paramToServiceMsg.append(str);
      paramToServiceMsg.append("], coder[");
      paramToServiceMsg.append(localProtocolCoder);
      paramToServiceMsg.append("], ret[");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append("]");
      QLog.i("AVGameProtocolCoder", 4, paramToServiceMsg.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.protocol.AVGameProtocolCoder
 * JD-Core Version:    0.7.0.1
 */