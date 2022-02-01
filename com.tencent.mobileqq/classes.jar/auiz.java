import com.qq.taf.jce.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class auiz
  implements aujd
{
  long jdField_a_of_type_Long;
  aujc jdField_a_of_type_Aujc = null;
  String jdField_a_of_type_JavaLangString;
  String b;
  final String c = "DiscFileUploader<FileAssistant>";
  
  /* Error */
  public long a(com.tencent.mobileqq.transfile.NetResp paramNetResp, aujb paramaujb)
  {
    // Byte code:
    //   0: new 30	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: getfield 36	com/tencent/mobileqq/transfile/NetResp:mRespData	[B
    //   8: invokespecial 39	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_1
    //   12: new 41	java/io/DataInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 44	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 6
    //   22: aload 6
    //   24: ldc2_w 45
    //   27: invokevirtual 50	java/io/DataInputStream:skip	(J)J
    //   30: pop2
    //   31: aload 6
    //   33: invokevirtual 54	java/io/DataInputStream:readInt	()I
    //   36: ifeq +32 -> 68
    //   39: aload_2
    //   40: ldc2_w 55
    //   43: putfield 60	aujb:jdField_a_of_type_Long	J
    //   46: aload_2
    //   47: ldc 62
    //   49: putfield 63	aujb:c	Ljava/lang/String;
    //   52: aload_0
    //   53: aload_2
    //   54: invokevirtual 66	auiz:a	(Laujb;)V
    //   57: aload_1
    //   58: invokevirtual 69	java/io/ByteArrayInputStream:close	()V
    //   61: aload 6
    //   63: invokevirtual 70	java/io/DataInputStream:close	()V
    //   66: lconst_0
    //   67: lreturn
    //   68: aload 6
    //   70: ldc2_w 71
    //   73: invokevirtual 50	java/io/DataInputStream:skip	(J)J
    //   76: pop2
    //   77: aload 6
    //   79: invokevirtual 76	java/io/DataInputStream:readByte	()B
    //   82: istore_3
    //   83: iload_3
    //   84: ifne +65 -> 149
    //   87: aload 6
    //   89: invokevirtual 54	java/io/DataInputStream:readInt	()I
    //   92: istore_3
    //   93: aload 6
    //   95: invokevirtual 54	java/io/DataInputStream:readInt	()I
    //   98: i2l
    //   99: lstore 4
    //   101: iload_3
    //   102: i2l
    //   103: lload 4
    //   105: bipush 32
    //   107: lshl
    //   108: lor
    //   109: lstore 4
    //   111: aload_2
    //   112: getfield 79	aujb:h	J
    //   115: lconst_0
    //   116: lcmp
    //   117: ifne +9 -> 126
    //   120: aload_2
    //   121: lload 4
    //   123: putfield 79	aujb:h	J
    //   126: aload_2
    //   127: lload 4
    //   129: aload_2
    //   130: getfield 79	aujb:h	J
    //   133: lsub
    //   134: putfield 82	aujb:i	J
    //   137: aload_1
    //   138: invokevirtual 69	java/io/ByteArrayInputStream:close	()V
    //   141: aload 6
    //   143: invokevirtual 70	java/io/DataInputStream:close	()V
    //   146: lload 4
    //   148: lreturn
    //   149: iload_3
    //   150: iconst_1
    //   151: if_icmpne +37 -> 188
    //   154: aload_2
    //   155: lconst_0
    //   156: putfield 60	aujb:jdField_a_of_type_Long	J
    //   159: aload_2
    //   160: aload_2
    //   161: getfield 85	aujb:e	J
    //   164: lconst_1
    //   165: ladd
    //   166: putfield 88	aujb:f	J
    //   169: aload_0
    //   170: aload_2
    //   171: invokevirtual 90	auiz:b	(Laujb;)V
    //   174: aload_1
    //   175: invokevirtual 69	java/io/ByteArrayInputStream:close	()V
    //   178: aload 6
    //   180: invokevirtual 70	java/io/DataInputStream:close	()V
    //   183: lconst_0
    //   184: lreturn
    //   185: astore_1
    //   186: lconst_0
    //   187: lreturn
    //   188: aload_2
    //   189: ldc2_w 55
    //   192: putfield 60	aujb:jdField_a_of_type_Long	J
    //   195: aload_2
    //   196: ldc 92
    //   198: putfield 63	aujb:c	Ljava/lang/String;
    //   201: aload_0
    //   202: aload_2
    //   203: invokevirtual 66	auiz:a	(Laujb;)V
    //   206: aload_1
    //   207: invokevirtual 69	java/io/ByteArrayInputStream:close	()V
    //   210: aload 6
    //   212: invokevirtual 70	java/io/DataInputStream:close	()V
    //   215: lconst_0
    //   216: lreturn
    //   217: astore_1
    //   218: lconst_0
    //   219: lreturn
    //   220: astore_2
    //   221: aload_2
    //   222: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   225: aload_1
    //   226: invokevirtual 69	java/io/ByteArrayInputStream:close	()V
    //   229: aload 6
    //   231: invokevirtual 70	java/io/DataInputStream:close	()V
    //   234: ldc2_w 96
    //   237: lreturn
    //   238: astore_2
    //   239: aload_1
    //   240: invokevirtual 69	java/io/ByteArrayInputStream:close	()V
    //   243: aload 6
    //   245: invokevirtual 70	java/io/DataInputStream:close	()V
    //   248: aload_2
    //   249: athrow
    //   250: astore_1
    //   251: goto -3 -> 248
    //   254: astore_1
    //   255: goto -21 -> 234
    //   258: astore_1
    //   259: goto -113 -> 146
    //   262: astore_1
    //   263: lconst_0
    //   264: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	auiz
    //   0	265	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   0	265	2	paramaujb	aujb
    //   82	70	3	i	int
    //   99	48	4	l	long
    //   20	224	6	localDataInputStream	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   174	183	185	java/lang/Exception
    //   206	215	217	java/lang/Exception
    //   22	57	220	java/io/IOException
    //   68	83	220	java/io/IOException
    //   87	101	220	java/io/IOException
    //   111	126	220	java/io/IOException
    //   126	137	220	java/io/IOException
    //   154	174	220	java/io/IOException
    //   188	206	220	java/io/IOException
    //   22	57	238	finally
    //   68	83	238	finally
    //   87	101	238	finally
    //   111	126	238	finally
    //   126	137	238	finally
    //   154	174	238	finally
    //   188	206	238	finally
    //   221	225	238	finally
    //   239	248	250	java/lang/Exception
    //   225	234	254	java/lang/Exception
    //   137	146	258	java/lang/Exception
    //   57	66	262	java/lang/Exception
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Aujc.a(paramLong1, paramLong2);
  }
  
  public void a(aujb paramaujb)
  {
    QLog.i("DiscFileUploader<FileAssistant>", 1, "=_= ^! [Upload Step] Send Error!:" + paramaujb.c);
    paramaujb.c();
    this.jdField_a_of_type_Aujc.a(null, 0);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, aujc paramaujc)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Aujc = paramaujc;
  }
  
  public void a(boolean paramBoolean, aujb paramaujb) {}
  
  public byte[] a(byte[] paramArrayOfByte, long paramLong, aujb paramaujb)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.b == null) || (this.jdField_a_of_type_JavaLangString.length() == 0) || (this.b.length() == 0))
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException();
      }
      paramaujb.jdField_a_of_type_Long = 9005L;
      a(paramaujb);
      return null;
    }
    byte[] arrayOfByte1 = HexUtil.hexStr2Bytes(this.b);
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(this.jdField_a_of_type_JavaLangString);
    int i = arrayOfByte2.length + 2 + 2 + arrayOfByte1.length + 20 + paramArrayOfByte.length;
    localByteArrayOutputStream = new ByteArrayOutputStream(i + 16);
    localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(-1412589450);
      localDataOutputStream.writeInt(1007);
      localDataOutputStream.writeInt(0);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeShort(arrayOfByte2.length);
      localDataOutputStream.write(arrayOfByte2);
      localDataOutputStream.writeShort(arrayOfByte1.length);
      localDataOutputStream.write(arrayOfByte1);
      localDataOutputStream.writeInt((int)(this.jdField_a_of_type_Long & 0xFFFFFFFF));
      localDataOutputStream.writeInt((int)(paramLong & 0xFFFFFFFF));
      localDataOutputStream.writeInt(paramArrayOfByte.length);
      localDataOutputStream.writeInt((int)(this.jdField_a_of_type_Long >> 32));
      localDataOutputStream.writeInt((int)(paramLong >> 32));
      localDataOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception paramaujb)
      {
        return paramArrayOfByte;
      }
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception paramaujb)
      {
        break label319;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramaujb.jdField_a_of_type_Long = 9003L;
      paramaujb.c = auea.a();
      a(paramaujb);
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally {}
  }
  
  public void b(aujb paramaujb)
  {
    QLog.i("DiscFileUploader<FileAssistant>", 1, "=_= ^> [Upload Step] Send Success!Go [Disc Feed]");
    paramaujb.b();
    this.jdField_a_of_type_Aujc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiz
 * JD-Core Version:    0.7.0.1
 */