import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher.1;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher.2;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher.3;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher.4;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;

public class apec
{
  public static volatile long a;
  public static apec a;
  public static boolean a;
  public final int a;
  public final Handler a;
  public final Runnable a;
  public final Map<String, String> a;
  public final ConcurrentHashMap<Integer, HashMap<String, apfj>> a;
  public final CopyOnWriteArrayList<apfx> a;
  public final CopyOnWriteArraySet<String> a;
  public final Map<String, HashMap<String, String>> b;
  public final CopyOnWriteArraySet<String> b;
  public final CopyOnWriteArraySet<String> c = new CopyOnWriteArraySet();
  
  private apec()
  {
    this.jdField_a_of_type_Int = 64;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LRULinkedHashMap(32));
    this.jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new LRULinkedHashMap(64));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangRunnable = new BubbleDiyFetcher.1(this);
  }
  
  public static apec a()
  {
    if (jdField_a_of_type_Apec == null) {}
    try
    {
      if (jdField_a_of_type_Apec == null) {
        jdField_a_of_type_Apec = new apec();
      }
      return jdField_a_of_type_Apec;
    }
    finally {}
  }
  
  public Bitmap a(apfx paramapfx, apfk paramapfk)
  {
    if ((paramapfx == null) || (paramapfk == null)) {
      return null;
    }
    paramapfx = "BubbleDiyFetcher_" + paramapfk.jdField_a_of_type_Int + "_" + paramapfk.jdField_a_of_type_JavaLangString.toUpperCase() + "_" + "chartlet";
    paramapfk = (Bitmap)BaseApplicationImpl.sImageCache.get(paramapfx);
    if (paramapfk != null)
    {
      this.c.remove(paramapfx);
      return paramapfk;
    }
    this.c.add(paramapfx);
    paramapfx = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramapfx instanceof QQAppInterface)) {
      a((QQAppInterface)paramapfx, 500);
    }
    return null;
  }
  
  public String a(apfx paramapfx, String paramString)
  {
    Object localObject;
    if ((paramapfx == null) || (TextUtils.isEmpty(paramString))) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      localObject = str;
    } while (str != null);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "fetchDiyText: put VipBubbleDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramapfx);
    paramapfx = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramapfx instanceof QQAppInterface)) {
      a((QQAppInterface)paramapfx, 500);
    }
    return null;
  }
  
  @TargetApi(11)
  public void a()
  {
    HashSet localHashSet = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      apfx localapfx = (apfx)localIterator.next();
      if ((localapfx != null) && (localapfx.getCallback() != null) && (a(localapfx.jdField_a_of_type_JavaLangString))) {
        localHashSet.add(localapfx.jdField_a_of_type_JavaLangString);
      }
    }
    if (localHashSet.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "refreshDrawableOnUiThread: " + TextUtils.join(",", localHashSet));
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new BubbleDiyFetcher.3(this, localHashSet));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      ThreadManager.post(new BubbleDiyFetcher.2(this, paramQQAppInterface), 5, null, false);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.c.isEmpty()));
      if (paramInt <= 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        b(paramQQAppInterface);
        return;
      }
    } while (System.currentTimeMillis() <= jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "postLoadBubbleDiyTexts delay:  " + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
    jdField_a_of_type_Long = System.currentTimeMillis() + paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("BubbleDiyFetcher", 2, String.format("uinAndDiyId %s, text cache is %b, diy paster cache is %b", new Object[] { paramString, Boolean.valueOf(this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)), Boolean.valueOf(this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) }));
        }
        if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) || (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramString))) {
          break;
        }
        paramQQAppInterface = new BubbleDiyEntity();
        paramQQAppInterface.uinAndDiyId = paramString;
        paramQQAppInterface.diyText = ((String)this.jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.uinAndDiyId));
        BubbleDiyEntity.parsePasterMap(paramQQAppInterface, (HashMap)this.jdField_b_of_type_JavaUtilMap.get(paramString));
        paramString = new ArrayList();
        paramString.add(paramQQAppInterface);
      } while (paramBusinessObserver == null);
      paramBusinessObserver.onUpdate(1, true, paramString);
      return;
      localObject = (BubbleDiyEntity)paramQQAppInterface.getEntityManagerFactory().createEntityManager().find(BubbleDiyEntity.class, " uinAndDiyId=? ", new String[] { paramString });
      if (localObject == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "query bubbleDiy from database, uinAndDiyId: " + paramString);
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString, ((BubbleDiyEntity)localObject).diyText);
      this.jdField_b_of_type_JavaUtilMap.put(paramString, ((BubbleDiyEntity)localObject).convertToPasterMap());
      paramQQAppInterface = new ArrayList();
      paramQQAppInterface.add(localObject);
    } while (paramBusinessObserver == null);
    paramBusinessObserver.onUpdate(1, true, paramQQAppInterface);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "start request diy id " + paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString);
    Object localObject = new ArrayList();
    ((List)localObject).add(paramString);
    ((aped)paramQQAppInterface.getBusinessHandler(70)).a((List)localObject, paramBusinessObserver);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, List<BubbleDiyEntity> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)paramList.next();
      if (paramBoolean) {
        paramQQAppInterface.getEntityManagerFactory().createEntityManager().persistOrReplace(localBubbleDiyEntity);
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localBubbleDiyEntity.uinAndDiyId);
      this.jdField_a_of_type_JavaUtilMap.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.diyText);
      this.jdField_b_of_type_JavaUtilMap.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.convertToPasterMap());
      if (!TextUtils.isEmpty(localBubbleDiyEntity.topLeftId)) {
        a(localBubbleDiyEntity.topLeftId);
      }
      if (!TextUtils.isEmpty(localBubbleDiyEntity.topRightId)) {
        a(localBubbleDiyEntity.topRightId);
      }
      if (!TextUtils.isEmpty(localBubbleDiyEntity.bottomLeftId)) {
        a(localBubbleDiyEntity.bottomLeftId);
      }
      if (!TextUtils.isEmpty(localBubbleDiyEntity.bottomRightId)) {
        a(localBubbleDiyEntity.bottomRightId);
      }
    }
    a();
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.endsWith(paramString)) {
          d(str);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    Iterator localIterator;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)))
    {
      paramString = (HashMap)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    }
    while (localIterator.hasNext())
    {
      String[] arrayOfString = ((String)localIterator.next()).split("_");
      if ((arrayOfString.length == 4) && (paramString.containsValue(arrayOfString[3])))
      {
        return false;
        return false;
      }
    }
    return true;
  }
  
  public Bitmap b(apfx paramapfx, apfk paramapfk)
  {
    if ((paramapfx == null) || (paramapfk == null) || (TextUtils.isEmpty(paramapfx.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramapfx.jdField_a_of_type_JavaLangString))
    {
      Object localObject = (HashMap)this.jdField_b_of_type_JavaUtilMap.get(paramapfx.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((HashMap)localObject).containsKey(paramapfk.jdField_a_of_type_JavaLangString.toUpperCase())))
      {
        localObject = (String)((HashMap)localObject).get(paramapfk.jdField_a_of_type_JavaLangString.toUpperCase());
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "diy id " + paramapfx.jdField_a_of_type_JavaLangString + " has no pasterId for align: " + paramapfk.jdField_a_of_type_JavaLangString.toUpperCase());
          }
          return null;
        }
      }
      else
      {
        return null;
      }
      paramapfk = "BubbleDiyFetcher_" + paramapfk.jdField_a_of_type_Int + "_" + paramapfk.jdField_a_of_type_JavaLangString.toUpperCase() + "_" + (String)localObject;
      localObject = (Bitmap)BaseApplicationImpl.sImageCache.get(paramapfk);
      if (localObject != null)
      {
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramapfk);
        return localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "can not found bitmap cache in BaseApplicationImpl.sImageCache! " + paramapfk);
      }
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramapfk);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "fetchDiyPaster: put VipBubbleDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramapfx);
      paramapfx = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramapfx instanceof QQAppInterface)) {
        a((QQAppInterface)paramapfx, 500);
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "can not found cache in diyPasterCache! " + paramapfx.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramapfx.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    VasQuickUpdateManager localVasQuickUpdateManager;
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      c();
      if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) {
        break label231;
      }
      localVasQuickUpdateManager = (VasQuickUpdateManager)((AppRuntime)localObject1).getManager(184);
      localObject2 = null;
      ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
      Iterator localIterator = localArrayList.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        String[] arrayOfString = ((String)localIterator.next()).split("_");
        if (arrayOfString.length != 4) {
          break label247;
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new String[localArrayList.size()];
        }
        localObject2 = arrayOfString[3];
        int j = i + 1;
        localObject1[i] = ("bubble.paster." + (String)localObject2 + ".png");
        i = j;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BubbleDiyFetcher", 2, "now download from VasQuickUpdateManager list: " + TextUtils.join(",", (Object[])localObject2));
        }
        localVasQuickUpdateManager.downloadGatherItem(2L, localObject2[0], (String[])localObject2, "0");
      }
      label231:
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("BubbleDiyFetcher", 2, "all paster has decode!");
      return;
      label247:
      localObject1 = localObject2;
    }
  }
  
  @TargetApi(11)
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      a(paramQQAppInterface);
    } while ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) && (this.c.isEmpty()));
    ThreadManager.post(new BubbleDiyFetcher.4(this, paramQQAppInterface), 5, null, false);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "notifyPasterDownloadComplete " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramString);
      a();
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() > 0)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        d((String)localIterator.next());
      }
      a();
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "mUnCacheDiyId size is 0!");
      }
    }
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Object localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
      int j = ((ArrayList)localObject1).size();
      Object localObject2 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      int i = 0;
      while (i < j)
      {
        BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)((EntityManager)localObject2).find(BubbleDiyEntity.class, (String)((ArrayList)localObject1).get(i));
        if (localBubbleDiyEntity != null) {
          localArrayList.add(localBubbleDiyEntity);
        }
        i += 1;
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BubbleDiyEntity)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(((BubbleDiyEntity)localObject2).uinAndDiyId);
      }
    } while (localArrayList.isEmpty());
    a(paramQQAppInterface, false, localArrayList);
  }
  
  public void c(String paramString)
  {
    Object localObject1 = (BubbleManager)BaseApplicationImpl.getApplication().getRuntime().getManager(44);
    Object localObject2 = paramString.split("_");
    Object localObject5;
    Object localObject4;
    if (localObject2.length == 4)
    {
      localObject5 = localObject2[1];
      localObject4 = localObject2[2];
      if (BaseApplicationImpl.sImageCache.get(paramString) == null)
      {
        localObject1 = new File(((BubbleManager)localObject1).a(), String.valueOf(localObject5)).getAbsolutePath();
        Object localObject6 = (String)localObject1 + File.separatorChar + "chartlet" + File.separatorChar + "chartlet.png";
        localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("BubbleDiyFetcher_" + localObject5 + "_" + "chartlet");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject6 = new File((String)localObject6);
          localObject1 = localObject2;
          if (((File)localObject6).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.i("BubbleDiyFetcher", 2, "createStaticBitmapCache: decode and put scale bitmap into BaseApplicationImpl.sImageCache, " + ((File)localObject6).getAbsolutePath());
            }
            localObject2 = bfpx.a(((File)localObject6).getAbsolutePath());
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              BaseApplicationImpl.sImageCache.put("BubbleDiyFetcher_" + localObject5 + "_" + "chartlet", localObject2);
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 == null) {}
      }
    }
    try
    {
      localObject2 = (HashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(Integer.parseInt(localObject5)));
      if ((localObject2 != null) && (((HashMap)localObject2).containsKey(localObject4)))
      {
        localObject2 = (apfj)((HashMap)localObject2).get(localObject4);
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, localObject2.a[2], localObject2.a[3], true);
        BaseApplicationImpl.sImageCache.put(paramString, localObject1);
        this.c.remove(paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BubbleDiyFetcher", 1, "createStaticBitmapCache error!", localException);
        Object localObject3 = null;
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void d(String paramString)
  {
    File localFile = ((BubbleManager)BaseApplicationImpl.getApplication().getRuntime().getManager(44)).b();
    Object localObject1 = paramString.split("_");
    String str2;
    Object localObject4;
    Object localObject2;
    if (localObject1.length == 4)
    {
      String str1 = localObject1[3];
      str2 = localObject1[1];
      localObject4 = localObject1[2];
      if (BaseApplicationImpl.sImageCache.get(paramString) == null)
      {
        localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("BubbleDiyFetcher_" + str1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localFile = new File(localFile, str1 + ".png");
          localObject1 = localObject2;
          if (localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.i("BubbleDiyFetcher", 2, "decode and put scale bitmap into BaseApplicationImpl.sImageCache, " + localFile.getAbsolutePath());
            }
            localObject2 = bfpx.a(localFile.getAbsolutePath());
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              BaseApplicationImpl.sImageCache.put("BubbleDiyFetcher_" + str1, localObject2);
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 == null) {}
      }
    }
    try
    {
      localObject2 = (HashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(Integer.parseInt(str2)));
      if ((localObject2 != null) && (((HashMap)localObject2).containsKey(localObject4)))
      {
        localObject2 = (apfj)((HashMap)localObject2).get(localObject4);
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, localObject2.a[2], localObject2.a[3], true);
        BaseApplicationImpl.sImageCache.put(paramString, localObject1);
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BubbleDiyFetcher", 2, "", localException);
        }
        Object localObject3 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apec
 * JD-Core Version:    0.7.0.1
 */