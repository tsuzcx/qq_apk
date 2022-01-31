import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.WNSStream;
import cooperation.qzone.util.WnsError;

public class bjur
{
  public static JceStruct a(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, paramString, null);
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, String paramString, int[] paramArrayOfInt)
  {
    return a(paramArrayOfByte, paramString, paramArrayOfInt, null);
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, String paramString, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramArrayOfInt[0] = -1000000;
    }
    Object localObject1 = new WNSStream();
    label388:
    for (;;)
    {
      try
      {
        paramArrayOfByte = ((WNSStream)localObject1).unpack(bdpd.b(paramArrayOfByte));
        if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode == 0))
        {
          localObject1 = new UniAttribute();
          ((UniAttribute)localObject1).setEncodeName("utf-8");
          ((UniAttribute)localObject1).decode(paramArrayOfByte.Extra);
          Object localObject2 = (QmfBusiControl)((UniAttribute)localObject1).get("busiCompCtl");
          if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
          {
            localObject2 = WNSStream.decompress(paramArrayOfByte.BusiBuff);
            if (localObject2 != null) {
              paramArrayOfByte.BusiBuff = ((byte[])localObject2);
            }
          }
          else
          {
            localObject1 = new UniAttribute();
            ((UniAttribute)localObject1).setEncodeName("utf-8");
            ((UniAttribute)localObject1).decode(paramArrayOfByte.BusiBuff);
            i = paramArrayOfByte.BizCode;
            paramArrayOfByte = ((UniAttribute)localObject1).get("ret", Short.valueOf(paramArrayOfByte.BizCode));
            if (!(paramArrayOfByte instanceof Short)) {
              continue;
            }
            i = ((Short)paramArrayOfByte).intValue();
            if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
              paramArrayOfInt[0] = i;
            }
            a((UniAttribute)localObject1, paramArrayOfString);
            return (JceStruct)((UniAttribute)localObject1).get(paramString);
          }
          if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
            paramArrayOfInt[0] = 1000002;
          }
          a((UniAttribute)localObject1, paramArrayOfString);
          return null;
          if (!(paramArrayOfByte instanceof Integer)) {
            break label388;
          }
          int i = ((Integer)paramArrayOfByte).intValue();
          continue;
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ProtocolUtils", 2, "decode " + paramString + " error:" + WnsError.getErrorMessage(paramArrayOfByte.WnsCode));
          }
          if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
            paramArrayOfInt[0] = paramArrayOfByte.WnsCode;
          }
          if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
            break;
          }
          paramArrayOfString[0] = WnsError.getErrorMessage(paramArrayOfByte.WnsCode);
          break;
        }
        if (paramArrayOfByte == null)
        {
          if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
            paramArrayOfInt[0] = 1000003;
          }
          return null;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
          paramArrayOfInt[0] = 1000001;
        }
        return null;
      }
      return null;
    }
    return null;
  }
  
  /* Error */
  private static void a(UniAttribute paramUniAttribute, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: ifnull +9 -> 14
    //   8: aload_1
    //   9: arraylength
    //   10: iconst_1
    //   11: if_icmpge +4 -> 15
    //   14: return
    //   15: aload_1
    //   16: iconst_0
    //   17: aload_0
    //   18: ldc 137
    //   20: ldc 139
    //   22: invokevirtual 87	com/qq/jce/wup/UniAttribute:get	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 141	java/lang/String
    //   28: checkcast 141	java/lang/String
    //   31: aastore
    //   32: aload_1
    //   33: iconst_0
    //   34: aaload
    //   35: ifnonnull -21 -> 14
    //   38: aload_1
    //   39: iconst_0
    //   40: ldc 143
    //   42: aastore
    //   43: return
    //   44: astore_0
    //   45: aload_1
    //   46: iconst_0
    //   47: aaload
    //   48: ifnonnull -34 -> 14
    //   51: aload_1
    //   52: iconst_0
    //   53: ldc 143
    //   55: aastore
    //   56: return
    //   57: astore_0
    //   58: aload_1
    //   59: iconst_0
    //   60: aaload
    //   61: ifnonnull +8 -> 69
    //   64: aload_1
    //   65: iconst_0
    //   66: ldc 143
    //   68: aastore
    //   69: aload_0
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramUniAttribute	UniAttribute
    //   0	71	1	paramArrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   15	32	44	java/lang/Throwable
    //   15	32	57	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjur
 * JD-Core Version:    0.7.0.1
 */