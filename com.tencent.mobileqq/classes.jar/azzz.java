import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.util.Utils.1;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;

public class azzz
{
  private static int jdField_a_of_type_Int;
  static Boolean jdField_a_of_type_JavaLangBoolean;
  public static String a;
  private static StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private static final Set<Long> jdField_a_of_type_JavaUtilSet;
  private static final char[] jdField_a_of_type_ArrayOfChar = { 12290, -225, -255, 33, 63, -244, -229, 44, 32 };
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new Utils.1(100);
    jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { ajjy.a(2131650218), ajjy.a(2131650215), ajjy.a(2131650234), ajjy.a(2131650222), ajjy.a(2131650239), ajjy.a(2131650220), ajjy.a(2131650213), ajjy.a(2131650229), ajjy.a(2131650228), ajjy.a(2131650241), ajjy.a(2131650214), ajjy.a(2131650221) };
  }
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static int a(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    return i;
  }
  
  public static int a(int paramInt)
  {
    int i = 2;
    if (jdField_a_of_type_JavaLangStringBuilder.length() > 560) {}
    try
    {
      int j = jdField_a_of_type_JavaLangStringBuilder.toString().getBytes("utf-8").length;
      if ((jdField_a_of_type_Int != j) && (QLog.isColorLevel())) {
        QLog.d("Utils", 2, "calculate byte num not equal byte num returned by getBytes(),totalByteNum is:" + jdField_a_of_type_Int + ",byteNum" + j);
      }
      label76:
      jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      jdField_a_of_type_Int = 0;
      if ((paramInt >= 0) && (paramInt < 128)) {
        i = 1;
      }
      for (;;)
      {
        jdField_a_of_type_JavaLangStringBuilder.append(Character.toChars(paramInt));
        jdField_a_of_type_Int += i;
        return i;
        if ((paramInt < 128) || (paramInt >= 2048)) {
          if ((paramInt >= 2048) && (paramInt < 65536)) {
            i = 3;
          } else if ((paramInt >= 65536) && (paramInt < 2097152)) {
            i = 4;
          } else if ((paramInt >= 2097152) && (paramInt < 67108864)) {
            i = 5;
          } else {
            i = 6;
          }
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label76;
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, paramInt1, paramInt2);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, 1, 19);
    Calendar localCalendar3 = Calendar.getInstance();
    localCalendar3.set(1, 2, 18);
    Calendar localCalendar4 = Calendar.getInstance();
    localCalendar4.set(1, 3, 20);
    Calendar localCalendar5 = Calendar.getInstance();
    localCalendar5.set(1, 4, 19);
    Calendar localCalendar6 = Calendar.getInstance();
    localCalendar6.set(1, 5, 20);
    Calendar localCalendar7 = Calendar.getInstance();
    localCalendar7.set(1, 6, 21);
    Calendar localCalendar8 = Calendar.getInstance();
    localCalendar8.set(1, 7, 22);
    Calendar localCalendar9 = Calendar.getInstance();
    localCalendar9.set(1, 8, 22);
    Calendar localCalendar10 = Calendar.getInstance();
    localCalendar10.set(1, 9, 22);
    Calendar localCalendar11 = Calendar.getInstance();
    localCalendar11.set(1, 10, 23);
    Calendar localCalendar12 = Calendar.getInstance();
    localCalendar12.set(1, 11, 22);
    Calendar localCalendar13 = Calendar.getInstance();
    localCalendar13.set(1, 12, 21);
    if ((localCalendar1.compareTo(localCalendar2) > 0) && (localCalendar1.compareTo(localCalendar3) <= 0)) {
      return 1;
    }
    if ((localCalendar1.compareTo(localCalendar3) > 0) && (localCalendar1.compareTo(localCalendar4) <= 0)) {
      return 2;
    }
    if ((localCalendar1.compareTo(localCalendar4) > 0) && (localCalendar1.compareTo(localCalendar5) <= 0)) {
      return 3;
    }
    if ((localCalendar1.compareTo(localCalendar5) > 0) && (localCalendar1.compareTo(localCalendar6) <= 0)) {
      return 4;
    }
    if ((localCalendar1.compareTo(localCalendar6) > 0) && (localCalendar1.compareTo(localCalendar7) <= 0)) {
      return 5;
    }
    if ((localCalendar1.compareTo(localCalendar7) > 0) && (localCalendar1.compareTo(localCalendar8) <= 0)) {
      return 6;
    }
    if ((localCalendar1.compareTo(localCalendar8) > 0) && (localCalendar1.compareTo(localCalendar9) <= 0)) {
      return 7;
    }
    if ((localCalendar1.compareTo(localCalendar9) > 0) && (localCalendar1.compareTo(localCalendar10) <= 0)) {
      return 8;
    }
    if ((localCalendar1.compareTo(localCalendar10) > 0) && (localCalendar1.compareTo(localCalendar11) <= 0)) {
      return 9;
    }
    if ((localCalendar1.compareTo(localCalendar11) > 0) && (localCalendar1.compareTo(localCalendar12) <= 0)) {
      return 10;
    }
    if ((localCalendar1.compareTo(localCalendar12) > 0) && (localCalendar1.compareTo(localCalendar13) <= 0)) {
      return 11;
    }
    return 12;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt3 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static int a(long paramLong)
  {
    return (int)paramLong;
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  @SuppressLint({"NewApi"})
  public static int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return -1;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static int a(String paramString)
  {
    return a(paramString)[0];
  }
  
  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear(10);
    localCalendar.clear(12);
    localCalendar.clear(13);
    localCalendar.clear(14);
    return localCalendar.getTimeInMillis();
  }
  
  public static long a(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  @SuppressLint({"NewApi"})
  public static long a(File paramFile)
  {
    paramFile = new StatFs(paramFile.getPath());
    long l = paramFile.getBlockSize();
    return paramFile.getAvailableBlocks() * l;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[7] & 0xFF) << 56;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte[(paramInt + 3)]) | a(paramArrayOfByte[(paramInt + 2)]) << 8 | a(paramArrayOfByte[(paramInt + 1)]) << 16 | a(paramArrayOfByte[paramInt]) << 24;
  }
  
  @SuppressLint({"NewApi"})
  public static File a(Context paramContext)
  {
    if (a()) {
      return paramContext.getExternalCacheDir();
    }
    paramContext = "/Android/data/" + paramContext.getPackageName() + "/cache/";
    return new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return jdField_a_of_type_ArrayOfJavaLangString[(paramInt - 1)];
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    return a(a(paramInt1, paramInt2));
  }
  
  @SuppressLint({"NewApi"})
  public static String a(Context paramContext)
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      paramContext = "/Android/data/" + paramContext.getPackageName() + "/cache/";
      return Environment.getExternalStorageDirectory().getPath() + paramContext;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "0|0";
    }
    return paramString.charAt(0) + "|" + paramString.length();
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (paramString == null) {
      str = paramString;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return str;
            str = paramString;
          } while (paramString.length() == 0);
          str = paramString;
        } while (paramString.length() <= paramInt);
        paramString = paramString.substring(0, paramInt);
        if (paramString.codePointAt(paramString.length() - 1) == 20) {
          break;
        }
        str = paramString;
      } while (paramString.length() < 4);
      str = paramString;
    } while (paramString.codePointAt(paramString.length() - 4) != 20);
    return paramString.substring(0, paramString.length() - 1);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { "QQ注册验证码" }, 3);
  }
  
  private static String a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    label140:
    label193:
    label330:
    label336:
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("Utils", 2, "oriAdd=" + paramString1 + "smsbody=" + paramString2);
      }
      if (paramArrayOfString1 != null)
      {
        int j = paramArrayOfString1.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfString1[i];
          if ((str == null) || (str.length() <= 0) || (!paramString1.startsWith(str))) {}
        }
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (paramArrayOfString2 == null) || (paramArrayOfString2.length == 0) || (paramString2 == null)) {
            break label336;
          }
          j = paramArrayOfString2.length;
          i = 0;
          if (i < j)
          {
            paramString1 = paramArrayOfString2[i];
            if ((paramString1 == null) || (paramString1.length() <= 0) || (!paramString2.contains(paramString1))) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label330;
            }
            paramArrayOfString1 = paramString2.toCharArray();
            paramString1 = "";
            j = 0;
            int k = 0;
            if (j < paramArrayOfString1.length)
            {
              char c = paramArrayOfString1[j];
              if ((c >= '0') && (c <= '9'))
              {
                paramString2 = paramString1 + String.valueOf(c);
                i = 1;
              }
              do
              {
                j += 1;
                paramString1 = paramString2;
                k = i;
                break label193;
                i += 1;
                break;
                i += 1;
                break label140;
                paramString2 = paramString1;
                i = k;
              } while (k == 0);
              if (paramString1.length() < paramInt) {}
            }
            else
            {
              if ((paramString1 == null) || (paramString1.length() <= 0)) {
                break label321;
              }
            }
            for (;;)
            {
              return paramString1;
              paramString2 = "";
              i = 0;
              break;
              paramString1 = null;
            }
          }
          break;
        }
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static ArrayList<String> a(String paramString, int paramInt1, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ArrayList<ArrayList<MessageForText.AtTroopMemberInfo>> paramArrayList1)
  {
    ArrayList localArrayList2 = new ArrayList();
    int i2 = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    ArrayList localArrayList1 = null;
    int i1 = 0;
    int j = 0;
    int n = 0;
    int i3;
    int k;
    label62:
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
    String str1;
    label171:
    label195:
    String str2;
    int i4;
    String str3;
    if (j < i2)
    {
      i3 = paramString.codePointAt(j);
      k = i;
      if (paramArrayList == null) {
        break label1123;
      }
      k = i;
      if (i >= paramArrayList.size()) {
        break label1123;
      }
      localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)paramArrayList.get(i);
      if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.isValid()))
      {
        if ((localAtTroopMemberInfo == null) || (localAtTroopMemberInfo.startPos != j)) {
          break label477;
        }
        str1 = paramString.substring(localAtTroopMemberInfo.startPos, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen);
        k = a(str1);
        localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + i1));
        if (localArrayList1 != null) {
          break label1120;
        }
        localArrayList1 = new ArrayList();
        localArrayList1.add(localAtTroopMemberInfo);
        k = k + 11 + 8;
        i += 1;
        if (n + k <= paramInt1) {
          break label835;
        }
        str2 = localStringBuilder.toString();
        m = -1;
        if (localArrayList1 != null) {
          break label667;
        }
        i4 = str2.length() - paramInt2;
        n = 0;
      }
      for (;;)
      {
        if (n < jdField_a_of_type_ArrayOfChar.length)
        {
          m = str2.lastIndexOf(jdField_a_of_type_ArrayOfChar[n]);
          if (m <= i4) {}
        }
        else
        {
          n = str2.lastIndexOf('\024');
          if ((m <= i4) || (n != -1)) {
            break label563;
          }
          str2 = localStringBuilder.substring(0, m + 1);
          str3 = localStringBuilder.substring(m + 1);
          localStringBuilder.setLength(0);
          m = a(str3);
          localStringBuilder.append(str3);
          label326:
          i4 = str2.length();
          localArrayList2.add(str2);
          paramArrayList1.add(localArrayList1);
          if (str1 == null) {
            break label679;
          }
          localStringBuilder.append(str1);
          n = localAtTroopMemberInfo.textLen - 1 + j;
          label374:
          j = n;
          if (i3 == 20)
          {
            if (n + 1 < i2) {
              break label720;
            }
            j = n;
            if (QLog.isColorLevel())
            {
              QLog.e("Utils", 2, "there is no other char behind EMO_HEAD_CODE,msg is:" + paramString);
              j = n;
            }
          }
          label434:
          localArrayList1 = null;
          m += k;
          k = i1 - i4;
          j += 1;
          i1 = k;
          n = m;
          break;
          i += 1;
          break label62;
          label477:
          if (i3 == 20)
          {
            if ((j + 1 < i2) && ((paramString.charAt(j + 1) == 'ÿ') || (paramString.charAt(j + 1) == 'ǿ')))
            {
              str1 = null;
              k = 20;
              break label195;
            }
            str1 = null;
            k = 12;
            break label195;
          }
          k = a(i3);
          str1 = null;
          break label195;
        }
        n += 1;
      }
      label563:
      if ((n - 2 < 0) || (str2.charAt(n - 1) != 'ÿ') || (str2.charAt(n - 2) != '\024')) {
        break label1133;
      }
    }
    label667:
    label679:
    label720:
    label860:
    label1120:
    label1123:
    label1133:
    for (int m = n - 2;; m = n)
    {
      if (m > i4)
      {
        str2 = localStringBuilder.substring(0, m);
        str3 = localStringBuilder.substring(m);
        localStringBuilder.setLength(0);
        m = a(str3);
        localStringBuilder.append(str3);
        break label326;
      }
      localStringBuilder.setLength(0);
      m = 0;
      break label326;
      localStringBuilder.setLength(0);
      m = 0;
      break label326;
      if (i3 > 65535)
      {
        localStringBuilder.appendCodePoint(i3);
        n = j + 1;
        break label374;
      }
      localStringBuilder.append((char)i3);
      n = j;
      break label374;
      if ('ÿ' == paramString.charAt(n + 1))
      {
        j = n;
        if (n + 4 >= i2) {
          break label434;
        }
        localStringBuilder.append(paramString.charAt(n + 1));
        localStringBuilder.append(paramString.charAt(n + 2));
        localStringBuilder.append(paramString.charAt(n + 3));
        localStringBuilder.append(paramString.charAt(n + 4));
        j = n + 4;
        break label434;
      }
      localStringBuilder.append(paramString.charAt(n + 1));
      j = n + 1;
      break label434;
      if (str1 != null)
      {
        localStringBuilder.append(str1);
        m = localAtTroopMemberInfo.textLen - 1 + j;
        j = m;
        if (i3 == 20)
        {
          if (m + 1 < i2) {
            break label975;
          }
          j = m;
          if (QLog.isColorLevel())
          {
            QLog.e("Utils", 2, "there is no other char behind EMO_HEAD_CODE,msg is:" + paramString);
            j = m;
          }
        }
      }
      for (;;)
      {
        m = n + k;
        k = i1;
        break;
        if (i3 > 65535)
        {
          localStringBuilder.appendCodePoint(i3);
          m = j + 1;
          break label860;
        }
        localStringBuilder.append((char)i3);
        m = j;
        break label860;
        if ('ÿ' == paramString.charAt(m + 1))
        {
          j = m;
          if (m + 4 < i2)
          {
            localStringBuilder.append(paramString.charAt(m + 1));
            localStringBuilder.append(paramString.charAt(m + 2));
            localStringBuilder.append(paramString.charAt(m + 3));
            localStringBuilder.append(paramString.charAt(m + 4));
            j = m + 4;
          }
        }
        else
        {
          localStringBuilder.append(paramString.charAt(m + 1));
          j = m + 1;
        }
      }
      if (localStringBuilder.length() > 0)
      {
        localArrayList2.add(localStringBuilder.toString());
        paramArrayList1.add(localArrayList1);
      }
      return localArrayList2;
      break label171;
      localAtTroopMemberInfo = null;
      i = k;
      break;
    }
  }
  
  public static short a(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(a(paramArrayOfByte[(paramInt + 1)]) | a(paramArrayOfByte[paramInt]) << 8);
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      QLog.e("Utils", 1, paramCloseable, new Object[0]);
    }
  }
  
  public static void a(String paramString)
  {
    ExceptionTracker.printCallStack(paramString, 1);
  }
  
  public static void a(Throwable paramThrowable) {}
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public static boolean a(Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(jdField_a_of_type_JavaLangString.trim()))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", jdField_a_of_type_JavaLangString.trim());
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.equals(paramString))
      {
        Process.killProcess(localRunningAppProcessInfo.pid);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.equals(ajed.E)) || (paramString.equals(String.valueOf(ajed.F))) || (paramString.equals(String.valueOf(ajed.G))) || (paramString.equals(String.valueOf(ajed.H))) || (paramString.equals(String.valueOf(ajed.J))) || (paramString.equals(String.valueOf(ajed.D))) || (paramString.equals(String.valueOf(ajed.C))) || (paramString.equals(String.valueOf(ajed.T))) || (paramString.equals(String.valueOf(ajed.ab))) || (paramString.equals(String.valueOf(ajed.aA))) || (paramString.equals(String.valueOf(ajed.z))) || (paramString.equals(String.valueOf(ajed.A))) || (paramString.equals(String.valueOf(ajed.B))) || (paramString.equals(String.valueOf(ajed.Z))) || (paramString.equals(String.valueOf(ajed.x))) || (paramString.equals(String.valueOf(ajed.w))) || (paramString.equals(String.valueOf(ajed.aa))) || (paramString.equals(String.valueOf(ajed.V))) || (paramString.equals(String.valueOf(ajed.Y))) || (paramString.equals(String.valueOf(ajed.W))) || (paramString.equals(String.valueOf(ajed.ac))) || (paramString.equals(String.valueOf(ajed.ad))) || (paramString.equals(String.valueOf(ajed.aq))) || (paramString.equals(String.valueOf(ajed.as))) || (paramString.equals(String.valueOf(ajed.at))) || (paramString.equals(String.valueOf(ajed.az))) || (paramString.equals(String.valueOf(66600000L))) || (paramString.equals(String.valueOf(ajed.aC))) || (paramString.equals(String.valueOf(9946L))) || (paramString.equals(String.valueOf(ajed.aL)));
  }
  
  public static byte[] a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)((0xFF00 & paramInt) >> 8);
    int k = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), k, j, i };
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = null;
      return paramString;
    }
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = a(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static int[] a(String paramString)
  {
    int i2 = paramString.length();
    int k = 0;
    int m = 0;
    int i = 0;
    if (k < i2)
    {
      int i3 = paramString.codePointAt(k);
      int n;
      int j;
      if (i3 == 20) {
        if ((k + 4 < i2) && ((paramString.charAt(k + 1) == 'ÿ') || (paramString.charAt(k + 1) == 'ǿ')))
        {
          i += 20;
          n = m + 1;
          j = k + 4;
        }
      }
      for (;;)
      {
        k = j + 1;
        m = n;
        break;
        i += 12;
        j = k + 1;
        n = m;
        continue;
        int i1 = i + a(i3);
        j = k;
        n = m;
        i = i1;
        if (i3 > 255)
        {
          j = k + 1;
          n = m;
          i = i1;
        }
      }
    }
    return new int[] { i, m };
  }
  
  public static int b(long paramLong1, long paramLong2)
  {
    return a(paramLong1 - -9223372036854775808L, -9223372036854775808L + paramLong2);
  }
  
  public static long b()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    int i = localStatFs.getBlockSize();
    int j = localStatFs.getAvailableBlocks();
    long l = i;
    return j * l;
  }
  
  public static String b(String paramString)
  {
    int i = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString == null) {
      localStringBuilder.append("null");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramString.length() == 0)
      {
        localStringBuilder.append("");
      }
      else
      {
        int j = paramString.length();
        if (j > 10)
        {
          localStringBuilder.append(paramString.charAt(0)).append(paramString.charAt(1)).append("***").append(paramString.charAt(j - 1)).append('[').append(j).append(']');
        }
        else
        {
          localStringBuilder.append(paramString.charAt(0));
          while (i < paramString.length())
          {
            localStringBuilder.append('*');
            i += 1;
          }
        }
      }
    }
  }
  
  public static String b(String paramString, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("len must be greater than 0,len is:" + paramInt);
    }
    if (paramString == null) {}
    while (paramString.length() <= paramInt) {
      return paramString;
    }
    return paramString.substring(0, paramInt) + "...";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    String str = ajjy.a(2131650240);
    return a(paramString1, paramString2, new String[] { "106" }, new String[] { str, "Login Verification Code" }, 3);
  }
  
  public static boolean b()
  {
    return (Environment.getExternalStorageState().equals("mounted")) && (Environment.getExternalStorageDirectory().exists());
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return ajed.aB.equals(paramString);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.lastIndexOf('_');
    } while (i <= 0);
    return paramString.substring(i + 1);
  }
  
  public static String c(String paramString1, String paramString2)
  {
    String str1 = ajjy.a(2131650232);
    String str2 = ajjy.a(2131650216);
    return a(paramString1, paramString2, new String[] { "1062", "1065", "1066", "1069" }, new String[] { str1, str2 }, 3);
  }
  
  public static boolean c()
  {
    Boolean localBoolean = jdField_a_of_type_JavaLangBoolean;
    Object localObject = localBoolean;
    long l1;
    if (localBoolean == null)
    {
      localObject = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      if (localObject != null)
      {
        localObject = ((SimpleAccount)localObject).getUin();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          l1 = 0L;
        }
      }
    }
    else
    {
      try
      {
        long l2 = Long.parseLong((String)localObject);
        l1 = l2;
      }
      catch (Exception localException)
      {
        label52:
        break label52;
      }
      if (!jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(l1))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      localObject = Boolean.valueOf(bool);
      return ((Boolean)localObject).booleanValue();
    }
  }
  
  public static boolean c(String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      label9:
      break label9;
    }
    return ((l1 >= 2726500000L) && (l1 <= 2726511999L)) || ((l1 >= 800000000L) && (l1 <= 800099999L)) || ((l1 >= 938000000L) && (l1 <= 938099999L)) || ((l1 >= 1068660000L) && (l1 <= 1068669960L)) || ((l1 >= 2355000000L) && (l1 <= 2355199999L)) || (l1 == 56268888L);
  }
  
  public static String d(String paramString1, String paramString2)
  {
    String str1 = ajjy.a(2131650225);
    String str2 = ajjy.a(2131650226);
    return a(paramString1, paramString2, new String[] { "10010", "106" }, new String[] { str1, str2, "QQ" }, 3);
  }
  
  public static boolean d()
  {
    boolean bool2 = false;
    List localList = BaseApplicationImpl.sApplication.getAllAccounts();
    boolean bool1 = bool2;
    if (localList != null)
    {
      bool1 = bool2;
      if (localList.size() >= 8) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Utils", 2, "isAccountNumExceedMax, isExceed=" + bool1);
    }
    return bool1;
  }
  
  public static boolean d(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!"0".equals(paramString)) && (!"10000".equals(paramString)) && (!"1000000".equals(paramString)) && (!"80000000".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azzz
 * JD-Core Version:    0.7.0.1
 */