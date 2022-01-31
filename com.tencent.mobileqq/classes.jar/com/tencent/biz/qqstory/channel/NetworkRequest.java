package com.tencent.biz.qqstory.channel;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class NetworkRequest
{
  public int a;
  public NetworkRequest.IProtocolListener a;
  public int b;
  private int c;
  
  public NetworkRequest()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  @NonNull
  public static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(ByteStringMicro.copyFromUtf8((String)paramList.next()));
    }
    return localArrayList;
  }
  
  public int a()
  {
    int i = this.c;
    String str = a();
    int j = i;
    if (i == 0)
    {
      j = i;
      if (str.length() > 0)
      {
        j = 0;
        while (j < str.length())
        {
          i = i * 31 + str.charAt(j);
          j += 1;
        }
        this.c = i;
        j = i;
      }
    }
    return j;
  }
  
  public abstract BaseResponse a(byte[] paramArrayOfByte);
  
  public NetworkRequest.IProtocolListener a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest$IProtocolListener;
  }
  
  public abstract String a();
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public void a(NetworkRequest.IProtocolListener paramIProtocolListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest$IProtocolListener = paramIProtocolListener;
  }
  
  public abstract byte[] a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.NetworkRequest
 * JD-Core Version:    0.7.0.1
 */