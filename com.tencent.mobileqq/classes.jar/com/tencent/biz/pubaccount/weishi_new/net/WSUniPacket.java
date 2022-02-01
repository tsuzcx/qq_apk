package com.tencent.biz.pubaccount.weishi_new.net;

import com.qq.jce.wup.UniAttribute;
import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class WSUniPacket
  extends UniAttribute
{
  static HashMap<String, byte[]> b;
  static HashMap<String, HashMap<String, byte[]>> c;
  protected RequestPacket a = new RequestPacket();
  private int d = 0;
  
  public WSUniPacket()
  {
    this.a.iVersion = 2;
  }
  
  private void a()
  {
    JceInputStream localJceInputStream = new JceInputStream(this.a.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (b == null)
    {
      b = new HashMap();
      b.put("", new byte[0]);
    }
    this._newData = localJceInputStream.readMap(b, 0, false);
  }
  
  private void b()
  {
    JceInputStream localJceInputStream = new JceInputStream(this.a.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (c == null)
    {
      c = new HashMap();
      HashMap localHashMap = new HashMap();
      localHashMap.put("", new byte[0]);
      c.put("", localHashMap);
    }
    this._data = localJceInputStream.readMap(c, 0, false);
    this.cachedClassName = new HashMap();
  }
  
  public void a(int paramInt)
  {
    this.a.iTimeout = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a.sServantName = paramString;
  }
  
  public void b(int paramInt)
  {
    this.a.iRequestId = paramInt;
  }
  
  public void b(String paramString)
  {
    this.a.sFuncName = paramString;
  }
  
  public void decode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
        paramArrayOfByte.setServerEncoding(this.encodeName);
        this.a.readFrom(paramArrayOfByte);
        if (this.a.iVersion == 3)
        {
          a();
          return;
        }
        this._newData = null;
        b();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
    }
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public void decodeVersion2(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
        paramArrayOfByte.setServerEncoding(this.encodeName);
        this.a.readFrom(paramArrayOfByte);
        b();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
    }
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public void decodeVersion3(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
        paramArrayOfByte.setServerEncoding(this.encodeName);
        this.a.readFrom(paramArrayOfByte);
        a();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
    }
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public byte[] encode()
  {
    if (this.a.iVersion == 2)
    {
      if ((this.a.sServantName != null) && (!this.a.sServantName.equals("")))
      {
        if ((this.a.sFuncName == null) || (this.a.sFuncName.equals(""))) {
          throw new IllegalArgumentException("funcName can not is null");
        }
      }
      else {
        throw new IllegalArgumentException("servantName can not is null");
      }
    }
    else
    {
      if (this.a.sServantName == null) {
        this.a.sServantName = "";
      }
      if (this.a.sFuncName == null) {
        this.a.sFuncName = "";
      }
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    if ((this.a.iVersion != 2) && (this.a.iVersion != 1)) {
      ((JceOutputStream)localObject).write(this._newData, 0);
    } else {
      ((JceOutputStream)localObject).write(this._data, 0);
    }
    this.a.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    this.a.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length + 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.putInt(i).put((byte[])localObject).flip();
    return localByteBuffer.array();
  }
  
  public <T> void put(String paramString, T paramT)
  {
    if (!paramString.startsWith("."))
    {
      super.put(paramString, paramT);
      return;
    }
    paramT = new StringBuilder();
    paramT.append("put name can not startwith . , now is ");
    paramT.append(paramString);
    throw new IllegalArgumentException(paramT.toString());
  }
  
  public void useVersion3()
  {
    super.useVersion3();
    this.a.iVersion = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WSUniPacket
 * JD-Core Version:    0.7.0.1
 */