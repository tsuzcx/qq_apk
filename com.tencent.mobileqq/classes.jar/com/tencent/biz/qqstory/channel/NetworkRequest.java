package com.tencent.biz.qqstory.channel;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class NetworkRequest<Respond extends BaseResponse>
{
  public int a;
  public long a;
  public NetworkRequest.IProtocolListener<Respond> a;
  public int b = 0;
  private int c;
  
  public NetworkRequest()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 2;
  }
  
  @NonNull
  public static List<ByteStringMicro> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(ByteStringMicro.copyFromUtf8((String)paramList.next()));
    }
    return localArrayList;
  }
  
  public abstract BaseResponse a(byte[] paramArrayOfByte);
  
  public NetworkRequest.IProtocolListener<Respond> a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest$IProtocolListener;
  }
  
  public abstract String a();
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public void a(NetworkRequest.IProtocolListener<Respond> paramIProtocolListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest$IProtocolListener = paramIProtocolListener;
  }
  
  protected abstract byte[] a();
  
  public int b()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.NetworkRequest
 * JD-Core Version:    0.7.0.1
 */