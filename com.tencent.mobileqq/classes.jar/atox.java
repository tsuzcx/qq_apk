import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class atox
  implements atow
{
  static bauf jdField_a_of_type_Bauf = new atpa();
  private static File jdField_a_of_type_JavaIoFile;
  private static Comparator<File> jdField_a_of_type_JavaUtilComparator = new atoy();
  private baue jdField_a_of_type_Baue;
  private baug jdField_a_of_type_Baug = new atoz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, List<atpb>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap<String, baub> b;
  
  public atox(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Baue = paramQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (jdField_a_of_type_JavaIoFile == null)
    {
      jdField_a_of_type_JavaIoFile = new File(atlv.jdField_a_of_type_JavaLangString);
      QLog.d("ListenTogether.downloader", 1, new Object[] { "init getCacheFilePath=", jdField_a_of_type_JavaIoFile });
    }
    if (!jdField_a_of_type_JavaIoFile.exists())
    {
      boolean bool = jdField_a_of_type_JavaIoFile.mkdir();
      QLog.d("ListenTogether.downloader", 1, "mkdir cache dir, result: " + bool);
    }
    return new File(atlv.jdField_a_of_type_JavaLangString, bflr.d(paramString)).getAbsolutePath();
  }
  
  private void a(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo != null) {}
    int i;
    label116:
    Object localObject1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramMusicInfo.jdField_a_of_type_JavaLangString))
        {
          QLog.d("ListenTogether.downloader", 1, "musicInfo or id is empty");
          return;
        }
        if (!a(atlw.a().b)) {
          continue;
        }
        i = atlw.a().jdField_a_of_type_Int;
        if (i <= 0)
        {
          QLog.d("ListenTogether.downloader", 2, String.format("download, maxCacheCount <= 0: %s", new Object[] { Integer.valueOf(i) }));
          c();
          b();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label116;
        }
      }
      finally {}
      QLog.d("ListenTogether.downloader", 2, String.format("download, musicId: %s", new Object[] { paramMusicInfo.jdField_a_of_type_JavaLangString }));
      if (a(paramMusicInfo.jdField_a_of_type_JavaLangString))
      {
        QLog.d("ListenTogether.downloader", 1, "download, cache file is exist");
      }
      else
      {
        localObject2 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMusicInfo.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label320;
        }
        localObject1 = localObject2;
        if (paramMusicInfo.b != null)
        {
          localObject1 = localObject2;
          if (paramMusicInfo.b.size() > 0)
          {
            localObject1 = new ArrayList();
            localObject2 = paramMusicInfo.b.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              str = (String)((Iterator)localObject2).next();
              if (!TextUtils.isEmpty(str)) {
                ((List)localObject1).add(new atpb(paramMusicInfo.jdField_a_of_type_JavaLangString, str));
              }
            }
          }
        }
        label263:
        if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
          break;
        }
        QLog.d("ListenTogether.downloader", 1, "musicReqInfoList is empty!, " + paramMusicInfo);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramMusicInfo.jdField_a_of_type_JavaLangString, localObject1);
    label320:
    Iterator localIterator = null;
    String str = null;
    Object localObject2 = localIterator;
    if (localObject1 != null)
    {
      localObject2 = localIterator;
      if (((List)localObject1).size() > 0)
      {
        localIterator = ((List)localObject1).iterator();
        localObject1 = str;
      }
    }
    label402:
    label583:
    label593:
    label595:
    for (;;)
    {
      localObject2 = localObject1;
      boolean bool;
      if (localIterator.hasNext())
      {
        localObject2 = (atpb)localIterator.next();
        if (((atpb)localObject2).jdField_a_of_type_Int == 1)
        {
          bool = true;
          break label583;
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label593;
        }
        QLog.d("ListenTogether.downloader", 2, String.format("musicReqInfo not found, isDownloading: %s", new Object[] { Boolean.valueOf(bool) }));
        break;
        if ((((atpb)localObject2).jdField_a_of_type_Int == 0) && (localObject1 == null))
        {
          localObject1 = localObject2;
          break label595;
        }
        do
        {
          if (!b(i))
          {
            QLog.d("ListenTogether.downloader", 1, "download, over cache count");
            break;
          }
          localObject2 = new baub();
          ((baub)localObject2).jdField_a_of_type_Baug = this.jdField_a_of_type_Baug;
          ((baub)localObject2).jdField_a_of_type_JavaLangString = ((atpb)localObject1).b;
          ((baub)localObject2).jdField_a_of_type_Int = 0;
          ((baub)localObject2).c = ((atpb)localObject1).d;
          ((baub)localObject2).e = 1;
          ((baub)localObject2).a(new Object[] { paramMusicInfo, localObject1 });
          ((baub)localObject2).jdField_a_of_type_Bauf = jdField_a_of_type_Bauf;
          this.jdField_a_of_type_Baue.a((bave)localObject2);
          ((atpb)localObject1).jdField_a_of_type_Int = 1;
          break;
          break label595;
          bool = false;
          localObject1 = localObject2;
          break label583;
          break label263;
          if (bool) {
            break label402;
          }
        } while (localObject1 != null);
      }
      break;
    }
  }
  
  private boolean a(int paramInt)
  {
    int i = bfbh.a(BaseApplicationImpl.getContext());
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("netTypeNeedDownload, requestNetType: %s, netType: %s, needDownload: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool) }));
      }
      return bool;
      if (paramInt == 1)
      {
        if (i == 1) {
          bool = true;
        }
      }
      else if (paramInt == 2)
      {
        if ((i == 1) || (i == 4)) {
          bool = true;
        }
      }
      else if (paramInt == 3)
      {
        if ((i == 1) || (i == 4) || (i == 3)) {
          bool = true;
        }
      }
      else if ((paramInt == 4) && ((i == 1) || (i == 4) || (i == 3) || (i == 2)))
      {
        bool = true;
        continue;
      }
      bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(a(paramString)).exists();
  }
  
  public static void b()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new File(atlv.jdField_a_of_type_JavaLangString);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.isFile())
          {
            String str1 = a(QQMusicPlayService.a());
            String str2 = localObject2.getAbsolutePath();
            if ((TextUtils.isEmpty(str1)) || (!str1.equals(str2))) {
              break label128;
            }
            QLog.d("ListenTogether.downloader", 1, String.format("removeAllCacheFiles, %s is playing", new Object[] { str2 }));
          }
          for (;;)
          {
            i += 1;
            break;
            label128:
            localObject2.delete();
          }
        }
      }
    }
    QLog.d("ListenTogether.downloader", 1, "removeAllCacheFiles, costTime: " + (System.currentTimeMillis() - l));
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    String str = a(QQMusicPlayService.a());
    File localFile1 = new File(atlv.jdField_a_of_type_JavaLangString);
    Object localObject;
    int i;
    if (localFile1.exists())
    {
      localObject = localFile1.listFiles();
      if ((localObject == null) || (localObject.length < paramInt)) {
        return true;
      }
      localObject = Arrays.asList((Object[])localObject);
      Collections.sort((List)localObject, jdField_a_of_type_JavaUtilComparator);
      i = ((List)localObject).size() - paramInt + 1;
      if (i <= ((List)localObject).size()) {
        break label286;
      }
      i = ((List)localObject).size();
    }
    label286:
    for (;;)
    {
      int j = 0;
      if (j < i)
      {
        File localFile2 = (File)((List)localObject).get(j);
        if ((!TextUtils.isEmpty(str)) && (str.equals(localFile2.getAbsolutePath()))) {
          QLog.d("ListenTogether.downloader", 1, "checkCacheStorage, " + str + " is playing...");
        }
        for (;;)
        {
          j += 1;
          break;
          localFile2.delete();
          QLog.d("ListenTogether.downloader", 1, String.format("checkCacheStorage, del index: %s, file: %s", new Object[] { Integer.valueOf(j), localFile2.getAbsolutePath() }));
        }
      }
      if (localFile1.listFiles() != null) {}
      for (i = localFile1.listFiles().length;; i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ListenTogether.downloader", 2, String.format("checkCacheCount, %s / %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
        }
        if (i < paramInt) {
          bool = true;
        }
        return bool;
      }
    }
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (bave)((Map.Entry)localIterator.next()).getValue();
        this.jdField_a_of_type_Baue.b((bave)localObject2);
        if ((localObject2 instanceof baub))
        {
          localObject2 = (baub)localObject2;
          if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.downloader", 2, String.format("cancelAllRequests, cancel req url: %s", new Object[] { ((baub)localObject2).jdField_a_of_type_JavaLangString }));
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label123;
      }
    }
    finally {}
    QLog.d("ListenTogether.downloader", 2, "cancelAllRequests...");
    label123:
  }
  
  public void a()
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.downloader", 2, "destroy");
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +15 -> 21
    //   9: ldc 83
    //   11: iconst_1
    //   12: ldc_w 354
    //   15: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 59	atox:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 357	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 344	bave
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +13 -> 47
    //   37: aload_0
    //   38: getfield 52	atox:jdField_a_of_type_Baue	Lbaue;
    //   41: aload_2
    //   42: invokeinterface 346 2 0
    //   47: aload_0
    //   48: getfield 57	atox:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   51: aload_1
    //   52: invokevirtual 357	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq -41 -> 18
    //   62: ldc 83
    //   64: iconst_2
    //   65: new 100	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 359
    //   75: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: goto -70 -> 18
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	atox
    //   0	96	1	paramString	String
    //   32	10	2	localbave	bave
    // Exception table:
    //   from	to	target	type
    //   2	18	91	finally
    //   21	33	91	finally
    //   37	47	91	finally
    //   47	88	91	finally
  }
  
  public void a(List<MusicInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.d("ListenTogether.downloader", 1, "downloadMusicRes, musicList is empty!");
    }
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((MusicInfo)paramList.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atox
 * JD-Core Version:    0.7.0.1
 */