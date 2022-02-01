package com.tencent.av.business.handler;

import com.tencent.avcore.jni.data.NetAddr;
import java.util.List;

public class AudioTransClientInfoHandlerExtend$InfoInterfaceData
{
  private static InfoInterfaceData a;
  public int a;
  public long a;
  public List<NetAddr> a;
  public int b;
  
  static
  {
    jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData = new InfoInterfaceData();
  }
  
  public static InfoInterfaceData a()
  {
    return jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChannelType[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], mSessionId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], mTransType[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend.InfoInterfaceData
 * JD-Core Version:    0.7.0.1
 */