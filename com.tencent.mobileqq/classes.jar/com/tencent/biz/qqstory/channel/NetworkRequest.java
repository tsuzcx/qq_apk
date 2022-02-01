package com.tencent.biz.qqstory.channel;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class NetworkRequest<Respond extends BaseResponse>
{
  public NetworkRequest.IProtocolListener<Respond> a;
  public long b = -1L;
  public int c = 2;
  public int d = 0;
  private int e;
  
  @NonNull
  public static List<ByteStringMicro> b(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(ByteStringMicro.copyFromUtf8((String)paramList.next()));
    }
    return localArrayList;
  }
  
  public abstract String a();
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public void a(NetworkRequest.IProtocolListener<Respond> paramIProtocolListener)
  {
    this.a = paramIProtocolListener;
  }
  
  public abstract BaseResponse b(byte[] paramArrayOfByte);
  
  protected abstract byte[] c();
  
  public NetworkRequest.IProtocolListener<Respond> d()
  {
    return this.a;
  }
  
  public int e()
  {
    int i = this.e;
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
        this.e = i;
        j = i;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.NetworkRequest
 * JD-Core Version:    0.7.0.1
 */