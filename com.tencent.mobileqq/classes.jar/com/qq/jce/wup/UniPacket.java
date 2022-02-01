package com.qq.jce.wup;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class UniPacket
  extends UniAttribute
{
  public static final int UniPacketHeadSize = 4;
  static HashMap<String, HashMap<String, byte[]>> cache__tempdata;
  static HashMap<String, byte[]> newCache__tempdata;
  protected RequestPacket _package = new RequestPacket();
  private int oldRespIret = 0;
  
  public UniPacket()
  {
    this._package.iVersion = 2;
  }
  
  public UniPacket(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      useVersion3();
      return;
    }
    this._package.iVersion = 2;
  }
  
  private void parseBufferV2()
  {
    JceInputStream localJceInputStream = new JceInputStream(this._package.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (cache__tempdata == null)
    {
      cache__tempdata = new HashMap();
      HashMap localHashMap = new HashMap();
      localHashMap.put("", new byte[0]);
      cache__tempdata.put("", localHashMap);
    }
    this._data = localJceInputStream.readMap(cache__tempdata, 0, false);
    this.cachedClassName = new HashMap();
  }
  
  private void parseBufferV3()
  {
    JceInputStream localJceInputStream = new JceInputStream(this._package.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (newCache__tempdata == null)
    {
      newCache__tempdata = new HashMap();
      newCache__tempdata.put("", new byte[0]);
    }
    this._newData = localJceInputStream.readMap(newCache__tempdata, 0, false);
  }
  
  public byte[] createOldRespEncode()
  {
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    ((JceOutputStream)localObject).write(this._data, 0);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    JceOutputStream localJceOutputStream = new JceOutputStream(0);
    localJceOutputStream.setServerEncoding(this.encodeName);
    localJceOutputStream.write(this._package.iVersion, 1);
    localJceOutputStream.write(this._package.cPacketType, 2);
    localJceOutputStream.write(this._package.iRequestId, 3);
    localJceOutputStream.write(this._package.iMessageType, 4);
    localJceOutputStream.write(this.oldRespIret, 5);
    localJceOutputStream.write((byte[])localObject, 6);
    localJceOutputStream.write(this._package.status, 7);
    return JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
  }
  
  public UniPacket createResponse()
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setRequestId(getRequestId());
    localUniPacket.setServantName(getServantName());
    localUniPacket.setFuncName(getFuncName());
    localUniPacket.setEncodeName(this.encodeName);
    localUniPacket._package.iVersion = this._package.iVersion;
    return localUniPacket;
  }
  
  public void decode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
        paramArrayOfByte.setServerEncoding(this.encodeName);
        this._package.readFrom(paramArrayOfByte);
        if (this._package.iVersion == 3)
        {
          parseBufferV3();
          return;
        }
        this._newData = null;
        parseBufferV2();
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
        this._package.readFrom(paramArrayOfByte);
        parseBufferV2();
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
        this._package.readFrom(paramArrayOfByte);
        parseBufferV3();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
    }
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    this._package.display(paramStringBuilder, paramInt);
  }
  
  public byte[] encode()
  {
    if (this._package.iVersion == 2)
    {
      if ((this._package.sServantName != null) && (!this._package.sServantName.equals("")))
      {
        if ((this._package.sFuncName == null) || (this._package.sFuncName.equals(""))) {
          throw new IllegalArgumentException("funcName can not is null");
        }
      }
      else {
        throw new IllegalArgumentException("servantName can not is null");
      }
    }
    else
    {
      if (this._package.sServantName == null) {
        this._package.sServantName = "";
      }
      if (this._package.sFuncName == null) {
        this._package.sFuncName = "";
      }
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    if ((this._package.iVersion != 2) && (this._package.iVersion != 1)) {
      ((JceOutputStream)localObject).write(this._newData, 0);
    } else {
      ((JceOutputStream)localObject).write(this._data, 0);
    }
    this._package.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    this._package.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length + 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.putInt(i).put((byte[])localObject).flip();
    return localByteBuffer.array();
  }
  
  public String getFuncName()
  {
    return this._package.sFuncName;
  }
  
  public int getOldRespIret()
  {
    return this.oldRespIret;
  }
  
  public int getPackageVersion()
  {
    return this._package.iVersion;
  }
  
  public int getRequestId()
  {
    return this._package.iRequestId;
  }
  
  public String getServantName()
  {
    return this._package.sServantName;
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
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this._package.readFrom(paramJceInputStream);
  }
  
  public void setFuncName(String paramString)
  {
    this._package.sFuncName = paramString;
  }
  
  public void setOldRespIret(int paramInt)
  {
    this.oldRespIret = paramInt;
  }
  
  public void setRequestId(int paramInt)
  {
    this._package.iRequestId = paramInt;
  }
  
  public void setServantName(String paramString)
  {
    this._package.sServantName = paramString;
  }
  
  public void useVersion3()
  {
    super.useVersion3();
    this._package.iVersion = 3;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    this._package.writeTo(paramJceOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.jce.wup.UniPacket
 * JD-Core Version:    0.7.0.1
 */