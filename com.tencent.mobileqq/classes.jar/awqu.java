import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class awqu
{
  public static AtomicLong a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    b = true;
    c = true;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(1L);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == -1000) {
      return 1;
    }
    return 2;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      paramString = paramString.split("\\.");
    } while (paramString.length != 4);
    try
    {
      int i = Integer.parseInt(paramString[0]);
      int j = Integer.parseInt(paramString[1]);
      int k = Integer.parseInt(paramString[2]);
      int m = Integer.parseInt(paramString[3]);
      return m << 24 | i | j << 8 | k << 16;
    }
    catch (Exception paramString)
    {
      QLog.e("MsgBackup", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  public static long a()
  {
    long l = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(1L + l);
    return l;
  }
  
  public static long a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000)) {
      return paramMessageRecord.shmsgseq;
    }
    return 0xFFFF & (short)(int)paramMessageRecord.shmsgseq;
  }
  
  public static String a(double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    double d1 = paramDouble;
    if (paramDouble < 0.0D)
    {
      localStringBuilder.append('-');
      d1 = -paramDouble;
    }
    long l3 = (100.0D * d1 + 0.5D);
    long l1 = 100L;
    int i = 3;
    int j;
    long l2;
    for (;;)
    {
      j = i;
      l2 = l1;
      if (l1 * 10L > l3) {
        break;
      }
      l1 *= 10L;
      i += 1;
    }
    while (j > 0)
    {
      if (j == 2) {
        localStringBuilder.append('.');
      }
      l1 = l3 / l2 % 10L;
      l2 /= 10L;
      if ((j != 1) || (l1 != 0L)) {
        localStringBuilder.append((char)(int)(l1 + 48L));
      }
      j -= 1;
    }
    return localStringBuilder.toString();
  }
  
  private static String a(double paramDouble, boolean paramBoolean)
  {
    if (paramBoolean) {
      return b(paramDouble);
    }
    return a(paramDouble);
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, true);
  }
  
  private static String a(long paramLong, boolean paramBoolean)
  {
    if (paramLong == 0L) {
      str = "0K";
    }
    do
    {
      return str;
      if (paramLong <= 1024L)
      {
        if (paramBoolean) {
          return "1.00K";
        }
        return "1.0K";
      }
      str = "";
      if (paramLong >= 1073741824L)
      {
        str = "" + a(paramLong / 1073741824.0D, paramBoolean);
        return str + "G";
      }
      if (paramLong >= 1048576L)
      {
        if (paramLong >= 1048576000L)
        {
          str = "" + a(paramLong / 1048576.0D / 1024.0D, paramBoolean);
          return str + "G";
        }
        str = "" + a(paramLong / 1048576.0D, paramBoolean);
        return str + "M";
      }
    } while (paramLong < 1024L);
    if (paramLong >= 1024000L)
    {
      str = "" + a(paramLong / 1024.0D / 1024.0D, paramBoolean);
      return str + "M";
    }
    String str = "" + a(paramLong / 1024.0D, paramBoolean);
    return str + "K";
  }
  
  public static String a(awny paramawny)
  {
    String str = String.format("%s_%d", new Object[] { paramawny.jdField_a_of_type_JavaLangString, Integer.valueOf(b(paramawny.jdField_a_of_type_Int)) });
    if (!TextUtils.isEmpty(paramawny.b)) {
      str = String.format("%s_%d_%s", new Object[] { paramawny.jdField_a_of_type_JavaLangString, Integer.valueOf(b(paramawny.jdField_a_of_type_Int)), paramawny.b });
    }
    return awqo.c + str + ".db";
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = "http://%s:%d/";
    if (bdvy.b(paramString)) {
      str = "http://[%s]:%d/";
    }
    return String.format(str, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    String str = String.format("%s_%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (!TextUtils.isEmpty(paramString2)) {
      str = String.format("%s_%d_%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    }
    return awqo.c + str + ".db";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      a("MsgBackup", "decryptPartionUrlParams key is null", new Object[0]);
    }
    String str = paramString1;
    if (b)
    {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString2))
        {
          a("MsgBackup", "originUrl = %s, encryptkey = %s", new Object[] { paramString1, paramString2 });
          String[] arrayOfString = paramString1.split("\\/");
          str = paramString1;
          if (arrayOfString.length == 2)
          {
            paramString1 = MsgBackupJniProxy.decryptFromString(arrayOfString[1], paramString2);
            str = "/" + paramString1;
            a("MsgBackup", "decryptUrl = %s", new Object[] { str });
          }
        }
      }
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      a("MsgBackup", "decrptUrlPathParams key is null", new Object[0]);
    }
    if ((b) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      a("MsgBackup", "decrptUrlPathParams originUrl = %s, ip = %s, port = %d, encryptkey is not null!", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
      paramString1 = paramString1.split(a(paramString2, paramInt));
      if (paramString1.length == 2)
      {
        paramString2 = (String)a(MsgBackupJniProxy.decryptFromString(paramString1[1], paramString3)).get("filepath");
        if (TextUtils.isEmpty(paramString2)) {
          return "";
        }
        paramString1 = paramString2;
        if (c) {
          paramString1 = Uri.decode(paramString2);
        }
        paramString1 = a(paramString1);
        a("decrptUrlPathParams filepath = %s", paramString1, new Object[0]);
      }
    }
    for (;;)
    {
      return paramString1;
      paramString1 = "";
    }
  }
  
  public static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\?");
      if (paramString.length > 1)
      {
        paramString = paramString[1].split("&");
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          int k = localObject.indexOf("=");
          if (k == -1) {}
          for (;;)
          {
            i += 1;
            break;
            localHashMap.put(localObject.substring(0, k), localObject.substring(k + 1));
          }
        }
      }
    }
    return localHashMap;
  }
  
  public static void a()
  {
    atwl.c(awqo.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000))
    {
      paramMsgBackupResEntity.msgSeq = paramMessageRecord.shmsgseq;
      return;
    }
    int i = bbzj.b(paramMessageRecord.msgUid);
    paramMsgBackupResEntity.msgSeq = (0xFFFF & (short)(int)paramMessageRecord.shmsgseq);
    paramMsgBackupResEntity.msgRandom = i;
  }
  
  public static void a(MsgBackupMsgEntity paramMsgBackupMsgEntity)
  {
    if ((b) && (paramMsgBackupMsgEntity != null))
    {
      if (!TextUtils.isEmpty(paramMsgBackupMsgEntity.chatUin)) {
        paramMsgBackupMsgEntity.chatUin = MsgBackupJniProxy.decryptFromString(paramMsgBackupMsgEntity.chatUin, awnr.c);
      }
      if (paramMsgBackupMsgEntity.extraData != null) {
        paramMsgBackupMsgEntity.extraData = MsgBackupJniProxy.decryptFromByteArray(paramMsgBackupMsgEntity.extraData, awnr.c);
      }
      if (paramMsgBackupMsgEntity.extensionData != null) {
        paramMsgBackupMsgEntity.extensionData = MsgBackupJniProxy.decryptFromByteArray(paramMsgBackupMsgEntity.extensionData, awnr.c);
      }
    }
  }
  
  public static void a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((b) && (paramMsgBackupResEntity != null) && (paramMsgBackupResEntity.extraData != null) && (awnr.b != null)) {
      paramMsgBackupResEntity.extraData = MsgBackupJniProxy.encryptFromByteArray(paramMsgBackupResEntity.extraData, awnr.b);
    }
  }
  
  public static void a(String paramString, awny paramawny)
  {
    paramString = paramString.substring(0, paramString.indexOf(".")).split("_");
    paramawny.jdField_a_of_type_JavaLangString = paramString[0];
    paramawny.jdField_a_of_type_Int = c(Integer.parseInt(paramString[1]));
    if (paramString.length > 2) {
      paramawny.b = paramString[2];
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!jdField_a_of_type_Boolean) {}
    String str;
    do
    {
      return;
      str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = "MsgBackup";
      }
    } while (!QLog.isDevelopLevel());
    QLog.d(str, 4, String.format(paramString2, paramVarArgs));
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (!jdField_a_of_type_Boolean) {}
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("MsgBackup", 4, String.format(paramString, paramVarArgs));
  }
  
  public static boolean a()
  {
    String str = awqo.c;
    Object localObject = new File(str);
    boolean bool2 = ((File)localObject).exists();
    if (!bool2) {
      bool2 = ((File)localObject).mkdirs();
    }
    for (;;)
    {
      boolean bool1;
      if (bool2)
      {
        File localFile = new File(awqo.b);
        boolean bool3 = localFile.exists();
        bool1 = bool3;
        localObject = localFile;
        if (!bool3)
        {
          bool1 = localFile.mkdirs();
          localObject = localFile;
        }
      }
      for (;;)
      {
        a("Manager.init.file mkdirs result = %b,dbDirExist = %b,filePath = %s,multimsgDirExist = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(((File)localObject).exists()), str, Boolean.valueOf(bool1) });
        return bool2;
        bool1 = false;
      }
    }
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong <= 1048576L;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3000) {
      return 2;
    }
    return 3;
  }
  
  public static long b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000)) {
      return 0L;
    }
    return bbzj.b(paramMessageRecord.msgUid);
  }
  
  public static String b(double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    double d1 = paramDouble;
    if (paramDouble < 0.0D)
    {
      localStringBuilder.append('-');
      d1 = -paramDouble;
    }
    long l3 = (100.0D * d1 + 0.5D);
    long l1 = 100L;
    int i = 3;
    int j;
    long l2;
    for (;;)
    {
      j = i;
      l2 = l1;
      if (l1 * 10L > l3) {
        break;
      }
      l1 *= 10L;
      i += 1;
    }
    while (j > 0)
    {
      if (j == 2) {
        localStringBuilder.append('.');
      }
      l1 = l3 / l2;
      l2 /= 10L;
      localStringBuilder.append((char)(int)(l1 % 10L + 48L));
      j -= 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    return awqo.b + paramString;
  }
  
  public static String b(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      a("MsgBackup", "encryptUrlParams key is null", new Object[0]);
    }
    String str = paramString1;
    if (b)
    {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString2))
        {
          a("MsgBackup", "encryptUrlParams urlParams = %s, encryptkey is not null!", new Object[] { paramString1 });
          str = MsgBackupJniProxy.encryptFromString(paramString1, paramString2);
          a("MsgBackup", "encryptUrlParams params = %s", new Object[] { str });
        }
      }
    }
    return str;
  }
  
  public static String b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      a("MsgBackup", "decryptUrlParams key is null", new Object[0]);
    }
    Object localObject = paramString1;
    if (b)
    {
      localObject = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = paramString1;
        if (!TextUtils.isEmpty(paramString3))
        {
          a("MsgBackup", "originUrl = %s, ip = %s, port = %d, encryptkey is not null!", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
          paramString2 = a(paramString2, paramInt);
          localObject = paramString1.split(paramString2);
          if (localObject.length == 2)
          {
            paramString1 = MsgBackupJniProxy.decryptFromString(localObject[1], paramString3);
            paramString1 = paramString2 + paramString1;
          }
          a("MsgBackup", "decryptUrl = %s", new Object[] { paramString1 });
          localObject = paramString1;
        }
      }
    }
    return localObject;
  }
  
  public static void b(MsgBackupMsgEntity paramMsgBackupMsgEntity)
  {
    if ((b) && (paramMsgBackupMsgEntity != null) && (awnr.b != null))
    {
      if (!TextUtils.isEmpty(paramMsgBackupMsgEntity.chatUin)) {
        paramMsgBackupMsgEntity.chatUin = MsgBackupJniProxy.encryptFromString(paramMsgBackupMsgEntity.chatUin, awnr.b);
      }
      if (paramMsgBackupMsgEntity.extraData != null) {
        paramMsgBackupMsgEntity.extraData = MsgBackupJniProxy.encryptFromByteArray(paramMsgBackupMsgEntity.extraData, awnr.b);
      }
      if (paramMsgBackupMsgEntity.extensionData != null) {
        paramMsgBackupMsgEntity.extensionData = MsgBackupJniProxy.encryptFromByteArray(paramMsgBackupMsgEntity.extensionData, awnr.b);
      }
    }
  }
  
  public static void b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((b) && (paramMsgBackupResEntity != null) && (paramMsgBackupResEntity.extraData != null) && (awnr.c != null)) {
      paramMsgBackupResEntity.extraData = MsgBackupJniProxy.decryptFromByteArray(paramMsgBackupResEntity.extraData, awnr.c);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, String.format(paramString, paramVarArgs));
    }
  }
  
  public static int c(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 3000;
    }
    return 0;
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (c) {
      str = Uri.encode(paramString);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqu
 * JD-Core Version:    0.7.0.1
 */