import android.os.Handler;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bfgz
{
  private static long jdField_a_of_type_Long;
  private static LruCache<String, Integer> jdField_a_of_type_AndroidUtilLruCache = new LruCache(5);
  private static volatile bfhc jdField_a_of_type_Bfhc;
  private static Map<String, BufferedWriter> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static LinkedBlockingQueue<bfhb> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue(256);
  private static long b = 1048576L;
  
  public static String a(String paramString)
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    return bfhg.b + bfgt.c(paramString) + "/" + str + "/miniprogramLog/";
  }
  
  public static void a(String paramString1, String paramString2)
  {
    b(b(paramString1), paramString2);
  }
  
  private static boolean a(String paramString)
  {
    return Pattern.compile("^[-\\+]?[\\d]*$").matcher(paramString).matches();
  }
  
  private static String b(String paramString)
  {
    String str = a(paramString);
    Object localObject3 = (Integer)jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    Object localObject6 = new File(str);
    if (!((File)localObject6).exists()) {
      ((File)localObject6).mkdirs();
    }
    Object localObject1 = localObject3;
    Object localObject5;
    int j;
    int i;
    Object localObject7;
    Object localObject2;
    if (localObject3 == null)
    {
      localObject3 = Integer.valueOf(1);
      localObject5 = localObject3;
      try
      {
        localObject6 = ((File)localObject6).listFiles();
        localObject1 = localObject3;
        if (localObject6 != null)
        {
          localObject5 = localObject3;
          localObject1 = localObject3;
          if (localObject6.length > 0)
          {
            localObject5 = localObject3;
            j = localObject6.length;
            i = 0;
            for (;;)
            {
              localObject1 = localObject3;
              if (i >= j) {
                break;
              }
              localObject5 = localObject3;
              localObject7 = localObject6[i].getName();
              localObject1 = localObject3;
              localObject5 = localObject3;
              if (((String)localObject7).contains("log"))
              {
                localObject5 = localObject3;
                localObject7 = ((String)localObject7).substring(((String)localObject7).lastIndexOf("log") + 1);
                localObject1 = localObject3;
                localObject5 = localObject3;
                if (a((String)localObject7))
                {
                  localObject1 = localObject3;
                  localObject5 = localObject3;
                  if (Integer.valueOf((String)localObject7).intValue() > ((Integer)localObject3).intValue())
                  {
                    localObject5 = localObject3;
                    localObject1 = Integer.valueOf((String)localObject7);
                  }
                }
              }
              i += 1;
              localObject3 = localObject1;
            }
          }
        }
        if (System.currentTimeMillis() - jdField_a_of_type_Long <= 60000L) {
          break label572;
        }
      }
      catch (Exception localException1)
      {
        betc.d("MiniLog", paramString, localException1);
        localObject2 = localObject5;
      }
    }
    else
    {
      jdField_a_of_type_Long = System.currentTimeMillis();
      localObject3 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (belh.a(str + "log" + localObject2).length() <= b) {
          break label572;
        }
        localObject3 = localObject2;
        if (((Integer)localObject2).intValue() >= 5) {
          continue;
        }
        localObject3 = localObject2;
        i = ((Integer)localObject2).intValue();
        localObject3 = Integer.valueOf(i + 1);
      }
      catch (Exception localException3)
      {
        localObject2 = localObject3;
        localObject3 = localException3;
        ((Exception)localObject3).printStackTrace();
        localObject3 = localObject2;
        continue;
      }
      jdField_a_of_type_AndroidUtilLruCache.put(paramString, localObject3);
      return str + "log" + localObject3;
      localObject3 = localObject2;
      new File(str + "log" + 1).delete();
      localObject2 = Integer.valueOf(1);
      i = 2;
      localObject3 = localObject2;
      if (i <= 5)
      {
        try
        {
          localObject6 = new File(str + "log" + i);
          if (!((File)localObject6).exists()) {
            break label569;
          }
          betc.b("MiniLog", "rename from file:log" + i + " to file:" + localObject2);
          localObject7 = new StringBuilder().append(str).append("log");
          j = ((Integer)localObject2).intValue();
          localObject5 = Integer.valueOf(j + 1);
          localObject3 = localObject5;
          ((File)localObject6).renameTo(new File(localObject2));
          localObject2 = localObject5;
        }
        catch (Exception localException2)
        {
          continue;
          label569:
          continue;
        }
        i += 1;
        continue;
        label572:
        Object localObject4 = localObject2;
      }
    }
  }
  
  private static void b()
  {
    if (jdField_a_of_type_Bfhc == null) {
      try
      {
        if (jdField_a_of_type_Bfhc == null) {
          jdField_a_of_type_Bfhc = new bfhc(bejn.a().getLooper(), null);
        }
        return;
      }
      finally {}
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    bfhb localbfhb = new bfhb();
    localbfhb.b = paramString2;
    localbfhb.a = paramString1;
    b();
    if (jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.offer(localbfhb))
    {
      jdField_a_of_type_Bfhc.removeMessages(2);
      jdField_a_of_type_Bfhc.sendEmptyMessageDelayed(2, 1000L);
    }
  }
  
  private static void c()
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.isEmpty()) {
          break label186;
        }
        localbfhb = (bfhb)jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.poll();
        if ((localbfhb == null) || (TextUtils.isEmpty(localbfhb.a))) {
          continue;
        }
        str = localbfhb.a;
        localFile = new File(str);
        if (localFile.exists()) {
          continue;
        }
        belh.a(str);
        localBufferedWriter1 = new BufferedWriter(new bfhd(localFile, true), 8192);
      }
      catch (Throwable localThrowable)
      {
        bfhb localbfhb;
        String str;
        File localFile;
        BufferedWriter localBufferedWriter1;
        if (localThrowable.getMessage() == null) {
          continue;
        }
        betc.d("MiniLog", localThrowable.getMessage());
        try
        {
          return;
        }
        finally {}
        localBufferedWriter2 = (BufferedWriter)jdField_a_of_type_JavaUtilMap.get(str);
        localObject1 = localBufferedWriter2;
        if (localBufferedWriter2 != null) {
          continue;
        }
        localObject1 = new BufferedWriter(new bfhd(localFile, true), 8192);
        continue;
      }
      finally
      {
        d();
      }
      localBufferedWriter1.write(localbfhb.b);
      jdField_a_of_type_JavaUtilMap.put(str, localBufferedWriter1);
    }
    for (;;)
    {
      BufferedWriter localBufferedWriter2;
      Object localObject1;
      label186:
      d();
    }
  }
  
  private static void d()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      BufferedWriter localBufferedWriter = (BufferedWriter)localIterator.next();
      if (localBufferedWriter != null) {
        try
        {
          localBufferedWriter.flush();
          localBufferedWriter.close();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgz
 * JD-Core Version:    0.7.0.1
 */