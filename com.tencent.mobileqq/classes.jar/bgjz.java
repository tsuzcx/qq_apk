import ActionMsg.MsgBody;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class bgjz
{
  public static MsgBody a(String paramString)
  {
    MsgBody localMsgBody = new MsgBody();
    try
    {
      JceInputStream localJceInputStream = new JceInputStream(HexUtil.hexStr2Bytes(paramString));
      localJceInputStream.setServerEncoding("utf-8");
      localMsgBody.readFrom(localJceInputStream);
      return localMsgBody;
    }
    catch (Exception localException)
    {
      QLog.w("ActionMsgUtil", 2, "decode error msg = " + paramString);
      QLog.w("ActionMsgUtil", 2, localException.toString());
      localMsgBody.msg = "";
      localMsgBody.action = "";
      localMsgBody.shareAppID = 0L;
      localMsgBody.actMsgContentValue = "";
    }
    return localMsgBody;
  }
  
  public static bgka a(byte[] paramArrayOfByte)
  {
    bgka localbgka = new bgka();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
        localbgka.jdField_a_of_type_Int = paramArrayOfByte.get();
        if (paramArrayOfByte.get() != 0) {
          continue;
        }
        i = -3004;
        localbgka.b = i;
        if (paramArrayOfByte.hasRemaining())
        {
          i = paramArrayOfByte.get();
          byte[] arrayOfByte = new byte[paramArrayOfByte.getShort()];
          paramArrayOfByte.get(arrayOfByte);
          localbgka.c = i;
          localbgka.jdField_a_of_type_JavaLangString = new String(arrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("ActionMsgUtil", 2, "decodeAppShareCookie succes appShareCookie.buissnessType =" + localbgka.jdField_a_of_type_Int + "appShareCookie.action" + localbgka.b + "appShareCookie.actionType" + localbgka.c + "appShareCookie.actionValue" + localbgka.jdField_a_of_type_JavaLangString);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        int i;
        paramArrayOfByte.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ActionMsgUtil", 2, "decodeAppShareCookie", paramArrayOfByte);
      }
      return localbgka;
      i = -3005;
    }
    return localbgka;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 0L, null);
  }
  
  public static String a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    String str = paramString1;
    if (paramString1 == null)
    {
      str = "";
      QLog.w("ActionMsgUtil", 2, "encode msg is null");
    }
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = "";
      QLog.w("ActionMsgUtil", 2, "encode action is null");
    }
    paramString2 = new MsgBody();
    paramString2.msg = str;
    paramString2.action = paramString1;
    paramString2.shareAppID = paramLong;
    paramString2.actMsgContentValue = paramString3;
    paramString1 = new JceOutputStream();
    paramString1.setServerEncoding("utf-8");
    paramString2.writeTo(paramString1);
    return HexUtil.bytes2HexStr(paramString1.toByteArray());
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -3000) || (paramInt == -3004) || (paramInt == -3005);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == -2009) || (paramInt == -3012);
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == -2016;
  }
  
  public static boolean d(int paramInt)
  {
    return paramInt == -2007;
  }
  
  public static boolean e(int paramInt)
  {
    return paramInt == -2039;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjz
 * JD-Core Version:    0.7.0.1
 */