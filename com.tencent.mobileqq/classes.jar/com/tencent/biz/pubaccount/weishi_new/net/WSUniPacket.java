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
  static HashMap<String, byte[]> jdField_a_of_type_JavaUtilHashMap;
  static HashMap<String, HashMap<String, byte[]>> b;
  private int jdField_a_of_type_Int = 0;
  protected RequestPacket a;
  
  public WSUniPacket()
  {
    this.jdField_a_of_type_ComQqTafRequestPacket = new RequestPacket();
    this.jdField_a_of_type_ComQqTafRequestPacket.iVersion = 2;
  }
  
  private void a()
  {
    JceInputStream localJceInputStream = new JceInputStream(this.jdField_a_of_type_ComQqTafRequestPacket.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (jdField_a_of_type_JavaUtilHashMap == null)
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_JavaUtilHashMap.put("", new byte[0]);
    }
    this._newData = localJceInputStream.readMap(jdField_a_of_type_JavaUtilHashMap, 0, false);
  }
  
  private void b()
  {
    JceInputStream localJceInputStream = new JceInputStream(this.jdField_a_of_type_ComQqTafRequestPacket.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (b == null)
    {
      b = new HashMap();
      HashMap localHashMap = new HashMap();
      localHashMap.put("", new byte[0]);
      b.put("", localHashMap);
    }
    this._data = localJceInputStream.readMap(b, 0, false);
    this.cachedClassName = new HashMap();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComQqTafRequestPacket.iTimeout = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComQqTafRequestPacket.sServantName = paramString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComQqTafRequestPacket.iRequestId = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName = paramString;
  }
  
  public void decode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
        paramArrayOfByte.setServerEncoding(this.encodeName);
        this.jdField_a_of_type_ComQqTafRequestPacket.readFrom(paramArrayOfByte);
        if (this.jdField_a_of_type_ComQqTafRequestPacket.iVersion == 3)
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
        this.jdField_a_of_type_ComQqTafRequestPacket.readFrom(paramArrayOfByte);
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
        this.jdField_a_of_type_ComQqTafRequestPacket.readFrom(paramArrayOfByte);
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
    if (this.jdField_a_of_type_ComQqTafRequestPacket.iVersion == 2)
    {
      if ((this.jdField_a_of_type_ComQqTafRequestPacket.sServantName != null) && (!this.jdField_a_of_type_ComQqTafRequestPacket.sServantName.equals("")))
      {
        if ((this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName == null) || (this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName.equals(""))) {
          throw new IllegalArgumentException("funcName can not is null");
        }
      }
      else {
        throw new IllegalArgumentException("servantName can not is null");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComQqTafRequestPacket.sServantName == null) {
        this.jdField_a_of_type_ComQqTafRequestPacket.sServantName = "";
      }
      if (this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName == null) {
        this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName = "";
      }
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    if ((this.jdField_a_of_type_ComQqTafRequestPacket.iVersion != 2) && (this.jdField_a_of_type_ComQqTafRequestPacket.iVersion != 1)) {
      ((JceOutputStream)localObject).write(this._newData, 0);
    } else {
      ((JceOutputStream)localObject).write(this._data, 0);
    }
    this.jdField_a_of_type_ComQqTafRequestPacket.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    this.jdField_a_of_type_ComQqTafRequestPacket.writeTo((JceOutputStream)localObject);
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
    this.jdField_a_of_type_ComQqTafRequestPacket.iVersion = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WSUniPacket
 * JD-Core Version:    0.7.0.1
 */