package com.tencent.luggage.wxa.pn;

import com.tencent.luggage.wxa.qz.o;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public class b
{
  public static CodingErrorAction a = CodingErrorAction.REPORT;
  
  public static String a(ByteBuffer paramByteBuffer)
  {
    Object localObject = Charset.forName("UTF8").newDecoder();
    ((CharsetDecoder)localObject).onMalformedInput(a);
    ((CharsetDecoder)localObject).onUnmappableCharacter(a);
    try
    {
      paramByteBuffer.mark();
      localObject = ((CharsetDecoder)localObject).decode(paramByteBuffer).toString();
      paramByteBuffer.reset();
      return localObject;
    }
    catch (CharacterCodingException paramByteBuffer)
    {
      throw new com.tencent.luggage.wxa.pk.b(1007, paramByteBuffer);
    }
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramInt1, paramInt2, "ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      o.b("MicroMsg.AppBrandNetWork.Charsetfunctions", paramArrayOfByte.toString());
    }
    return "";
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      o.b("MicroMsg.AppBrandNetWork.Charsetfunctions", paramString.toString());
    }
    return new byte[0];
  }
  
  public static byte[] b(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      o.b("MicroMsg.AppBrandNetWork.Charsetfunctions", paramString.toString());
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pn.b
 * JD-Core Version:    0.7.0.1
 */