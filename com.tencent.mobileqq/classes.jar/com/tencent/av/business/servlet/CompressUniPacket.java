package com.tencent.av.business.servlet;

import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class CompressUniPacket
  extends UniPacket
{
  private final String a = "compressed";
  
  public CompressUniPacket(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 20	java/util/zip/Inflater
    //   9: dup
    //   10: invokespecial 23	java/util/zip/Inflater:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: aload_1
    //   16: iconst_0
    //   17: aload_1
    //   18: arraylength
    //   19: invokevirtual 27	java/util/zip/Inflater:setInput	([BII)V
    //   22: sipush 4096
    //   25: newarray byte
    //   27: astore_2
    //   28: new 29	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: invokespecial 30	java/io/ByteArrayOutputStream:<init>	()V
    //   35: astore 4
    //   37: aload_3
    //   38: invokevirtual 34	java/util/zip/Inflater:finished	()Z
    //   41: ifne +18 -> 59
    //   44: aload 4
    //   46: aload_2
    //   47: iconst_0
    //   48: aload_3
    //   49: aload_2
    //   50: invokevirtual 38	java/util/zip/Inflater:inflate	([B)I
    //   53: invokevirtual 41	java/io/ByteArrayOutputStream:write	([BII)V
    //   56: goto -19 -> 37
    //   59: aload 4
    //   61: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: goto +12 -> 79
    //   70: astore_1
    //   71: goto +14 -> 85
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 48	java/util/zip/DataFormatException:printStackTrace	()V
    //   79: aload_3
    //   80: invokevirtual 51	java/util/zip/Inflater:end	()V
    //   83: aload_1
    //   84: areturn
    //   85: aload_3
    //   86: invokevirtual 51	java/util/zip/Inflater:end	()V
    //   89: goto +5 -> 94
    //   92: aload_1
    //   93: athrow
    //   94: goto -2 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	CompressUniPacket
    //   0	97	1	paramArrayOfByte	byte[]
    //   27	39	2	arrayOfByte	byte[]
    //   74	2	2	localDataFormatException	java.util.zip.DataFormatException
    //   13	73	3	localInflater	java.util.zip.Inflater
    //   35	25	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	56	70	finally
    //   59	65	70	finally
    //   75	79	70	finally
    //   37	56	74	java/util/zip/DataFormatException
    //   59	65	74	java/util/zip/DataFormatException
  }
  
  public <T> T getByClass(String paramString, T paramT)
  {
    Object localObject = this._data;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (this._data.containsKey("compressed"))
      {
        bool1 = bool2;
        if (this._data.get("compressed") != null)
        {
          localObject = (byte[])((HashMap)this._data.get("compressed")).get("string");
          if ("true".equalsIgnoreCase(new String((byte[])localObject)))
          {
            localObject = (HashMap)this._data.get(paramString);
            if (localObject != null)
            {
              localObject = ((HashMap)localObject).entrySet().iterator();
              if (((Iterator)localObject).hasNext())
              {
                localObject = (Map.Entry)((Iterator)localObject).next();
                ((Map.Entry)localObject).setValue(a((byte[])((Map.Entry)localObject).getValue()));
              }
            }
            bool1 = true;
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("是否压缩 ");
            localStringBuilder.append(new String((byte[])localObject));
            QLog.e("CompressUniPacket", 1, localStringBuilder.toString());
            bool1 = bool2;
          }
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not compressed ");
    ((StringBuilder)localObject).append(bool1);
    QLog.i("CompressUniPacket", 2, ((StringBuilder)localObject).toString());
    return super.getByClass(paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.servlet.CompressUniPacket
 * JD-Core Version:    0.7.0.1
 */