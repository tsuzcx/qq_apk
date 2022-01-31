import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ShortVideoUploadABTest.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ayvd
{
  public static long a;
  public static ayve a;
  public static Object a;
  public static HashMap<Long, ayve> a;
  public static boolean a;
  public static long b;
  public static ayve b;
  public static long c;
  public static long d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Boolean = true;
  }
  
  public static ayve a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ayve localayve2 = (ayve)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ayve localayve1 = localayve2;
      if (localayve2 == null) {
        localayve1 = new ayve();
      }
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localayve1);
      return localayve1;
    }
  }
  
  public static String a(ayve paramayve)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("(Andr)老方案\n");
    String str;
    if (paramayve.jdField_c_of_type_Int == 0)
    {
      str = "成功";
      localStringBuilder2 = localStringBuilder2.append(str);
      if (paramayve.jdField_c_of_type_Int != 0) {
        break label317;
      }
      str = "";
      label44:
      localStringBuilder2.append(str).append("\n");
      localStringBuilder1.append("等待:").append(paramayve.jdField_b_of_type_Long).append("ms\n");
      localStringBuilder1.append("时长:").append(paramayve.jdField_d_of_type_Int).append("s\n");
      localStringBuilder1.append("Size:").append(paramayve.jdField_a_of_type_Long / 1024L).append("KB").append("\n");
      localStringBuilder1.append("AIO跳转:").append("400ms\n");
      localStringBuilder1.append("合成:").append(paramayve.jdField_e_of_type_Long).append("ms\n");
      localStringBuilder1.append("缩略图:").append(paramayve.h).append("ms\n");
      localStringBuilder1.append("Processor:").append(paramayve.g + "ms\n");
      localStringBuilder1.append("落地:").append(paramayve.jdField_d_of_type_JavaLangString).append("ms\n");
      localStringBuilder1.append("MD5:").append(paramayve.jdField_b_of_type_JavaLangString).append("\n");
      int i = ayta.a().a();
      if (i == -1) {
        break label346;
      }
      localStringBuilder1.append("Net:").append(ajsd.c[i]).append("\n");
    }
    for (;;)
    {
      localStringBuilder1.append("StepInfo:").append(paramayve.jdField_c_of_type_JavaLangString).append("\n");
      localStringBuilder1.append("版本:").append(AppSetting.b());
      return localStringBuilder1.toString();
      str = "失败(";
      break;
      label317:
      str = String.valueOf(paramayve.jdField_c_of_type_Int) + ")";
      break label44;
      label346:
      localStringBuilder1.append("Net:").append("None").append("\n");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if ((jdField_a_of_type_Ayve != null) && (b != null))
      {
        jdField_a_of_type_Ayve.jdField_a_of_type_Float = ((float)jdField_a_of_type_Ayve.jdField_b_of_type_Long);
        b.jdField_a_of_type_Float = ((float)b.jdField_b_of_type_Long);
        QLog.d("ShortVideoUploadABTest", 2, "VideoABTest :  performABTest : New :" + jdField_a_of_type_Ayve.jdField_a_of_type_Float + " Old:" + b.jdField_a_of_type_Float);
        localStringBuilder1 = new StringBuilder("(Andr)新老对比结果:\n");
        localStringBuilder2 = localStringBuilder1.append("新方案:").append("用户等待:");
        if (jdField_a_of_type_Ayve.jdField_b_of_type_Long >= 0L) {
          break label290;
        }
      }
      label290:
      for (Object localObject1 = "0";; localObject1 = String.valueOf(jdField_a_of_type_Ayve.jdField_b_of_type_Long))
      {
        localStringBuilder2.append((String)localObject1).append("ms,时长:").append(jdField_a_of_type_Ayve.jdField_d_of_type_Int).append("s").append("\n");
        localStringBuilder1.append("老方案:").append("用户等待:").append(b.jdField_b_of_type_Long).append("ms,时长:").append(b.jdField_d_of_type_Int).append("s").append("\n");
        localStringBuilder1.append("----------\n结论:");
        if (jdField_a_of_type_Ayve.jdField_a_of_type_Float > b.jdField_a_of_type_Float) {
          break;
        }
        localStringBuilder1.append("新方案更优");
        localObject1 = new SessionInfo();
        ((SessionInfo)localObject1).jdField_a_of_type_Int = jdField_a_of_type_Ayve.jdField_a_of_type_Int;
        ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = jdField_a_of_type_Ayve.jdField_a_of_type_JavaLangString;
        ThreadManager.getUIHandler().postDelayed(new ShortVideoUploadABTest.1(paramQQAppInterface, (SessionInfo)localObject1, localStringBuilder1), 200L);
        jdField_a_of_type_Ayve = null;
        b = null;
        return;
      }
      localStringBuilder1.append("老方案更优");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String arg2, long paramLong, int paramInt2)
  {
    if (!b(paramInt1, ???)) {
      return;
    }
    for (;;)
    {
      ayve localayve;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localayve = a(paramLong);
        if (localayve.jdField_d_of_type_Long == 0L)
        {
          QLog.d("ShortVideoUploadABTest", 2, "VideoABTest :  uinSeq" + paramLong + " FinishAt " + SystemClock.uptimeMillis());
          localayve.jdField_d_of_type_Long = SystemClock.uptimeMillis();
          if (paramInt2 != 3) {
            break label178;
          }
          localayve.jdField_b_of_type_Int = 1;
          if ((localayve.jdField_c_of_type_Long != 0L) && (localayve.l != 0L)) {
            a(paramQQAppInterface, localayve);
          }
        }
        else
        {
          return;
        }
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong + " Wait for : Merge_" + localayve.l + " Click_" + localayve.jdField_c_of_type_Long);
      continue;
      label178:
      localayve.jdField_b_of_type_Int = 0;
      if (localayve.jdField_c_of_type_Long != 0L) {
        a(paramQQAppInterface, localayve);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if ((!b(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) || (paramString == null)) {
      return;
    }
    aanz.b(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
  }
  
  @TargetApi(10)
  public static void a(QQAppInterface paramQQAppInterface, ayve paramayve)
  {
    if (!b(paramayve.jdField_a_of_type_Int, paramayve.jdField_a_of_type_JavaLangString)) {
      return;
    }
    String str1 = paramayve.f;
    if ((str1 != null) && (str1.length() > 0)) {
      paramayve.n = new File(str1).length();
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 10)
        {
          localObject = new MediaMetadataRetriever();
          ((MediaMetadataRetriever)localObject).setDataSource(str1);
          paramayve.p = Long.valueOf(((MediaMetadataRetriever)localObject).extractMetadata(9)).longValue();
          ((MediaMetadataRetriever)localObject).release();
        }
        paramayve.jdField_b_of_type_Long = (paramayve.jdField_d_of_type_Long - paramayve.jdField_c_of_type_Long - 400L);
        paramayve.jdField_a_of_type_Float = ((float)paramayve.jdField_b_of_type_Long / paramayve.jdField_d_of_type_Int);
        if (paramayve.jdField_b_of_type_Int != 1) {
          break label214;
        }
        str1 = b(paramayve);
        jdField_a_of_type_Ayve = paramayve;
        Object localObject = new SessionInfo();
        ((SessionInfo)localObject).jdField_a_of_type_Int = paramayve.jdField_a_of_type_Int;
        ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramayve.jdField_a_of_type_JavaLangString;
        a(paramQQAppInterface);
        a(paramQQAppInterface, BaseApplication.getContext().getBaseContext(), (SessionInfo)localObject, str1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : dumpABTestInfo : dstPath : " + localException);
      continue;
      label214:
      String str2 = a(paramayve);
      b = paramayve;
    }
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = jdField_a_of_type_Boolean;
    if (b(paramInt, paramString)) {
      if (jdField_a_of_type_Boolean) {
        break label62;
      }
    }
    label62:
    for (bool1 = bool3;; bool1 = false)
    {
      jdField_a_of_type_Boolean = bool1;
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : sEnablePreUpload" + jdField_a_of_type_Boolean);
      bool1 = bool2;
      return bool1;
    }
  }
  
  public static String b(ayve paramayve)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("(Andr)新方案\n结果:");
    String str;
    if (paramayve.jdField_c_of_type_Int == 0)
    {
      str = "成功";
      localStringBuilder2 = localStringBuilder2.append(str);
      if (paramayve.jdField_c_of_type_Int != 0) {
        break label452;
      }
      str = "";
      label45:
      localStringBuilder2.append(str).append("\n");
      localStringBuilder2 = localStringBuilder1.append("等待:");
      if (paramayve.jdField_b_of_type_Long >= 0L) {
        break label463;
      }
      str = "0";
      label77:
      localStringBuilder2.append(str).append("ms");
      if (paramayve.jdField_b_of_type_Long >= 0L) {
        break label474;
      }
      localStringBuilder1.append("(").append(paramayve.jdField_b_of_type_Long).append(")\n");
      label120:
      localStringBuilder1.append("Rollback:").append(paramayve.jdField_e_of_type_Int).append("\n");
      localStringBuilder1.append("录制时长:").append(paramayve.i).append("ms\n");
      localStringBuilder1.append("合成指令:").append(paramayve.j).append("ms\n");
      localStringBuilder1.append("合成:").append("mqq_").append(paramayve.l).append("ms,  svr_").append(paramayve.m).append("ms\n");
      localStringBuilder1.append("时长:").append("mqq_").append(paramayve.p).append("ms,  svr_").append(paramayve.q).append("s\n");
      localStringBuilder1.append("Size:").append("mqq_").append(paramayve.n / 1024L).append("KB,  svr_").append(paramayve.o / 1024L).append("KB\n");
      localStringBuilder1.append("落地:").append(paramayve.jdField_d_of_type_JavaLangString).append("ms\n");
      localStringBuilder1.append("upload:").append(paramayve.g + "ms\n");
      int i = ayta.a().a();
      if (i == -1) {
        break label484;
      }
      localStringBuilder1.append("Net:").append(ajsd.c[i]).append("\n");
    }
    for (;;)
    {
      localStringBuilder1.append("分片耗时:").append(paramayve.jdField_e_of_type_JavaLangString).append("\n");
      localStringBuilder1.append("uniSeq:").append(paramayve.k).append("\n");
      localStringBuilder1.append("版本:").append(AppSetting.b());
      return localStringBuilder1.toString();
      str = "失败-";
      break;
      label452:
      str = String.valueOf(paramayve.jdField_c_of_type_Int);
      break label45;
      label463:
      str = String.valueOf(paramayve.jdField_b_of_type_Long);
      break label77;
      label474:
      localStringBuilder1.append("\n");
      break label120;
      label484:
      localStringBuilder1.append("Net:").append("None").append("\n");
    }
  }
  
  public static boolean b(int paramInt, String paramString)
  {
    if (!a()) {}
    do
    {
      return false;
      if ((paramInt == 0) && ("51640996".equalsIgnoreCase(paramString))) {
        return true;
      }
    } while ((paramInt != 1) || (!"498450958".equalsIgnoreCase(paramString)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayvd
 * JD-Core Version:    0.7.0.1
 */