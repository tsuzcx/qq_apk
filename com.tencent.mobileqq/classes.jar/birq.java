import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.download.AEResDownloader.1;
import dov.com.qq.im.ae.download.AEResDownloader.2;
import dov.com.qq.im.ae.download.AEResDownloader.3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class birq
  implements axeq, axes
{
  private static final birq jdField_a_of_type_Birq = new birq();
  private static final HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("AEResDownloader");
  private List<ShortVideoResourceManager.SVConfigItem> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<Integer, Long> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean;
  private List<birs> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), "new_qq_android_native_short_filter_");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "new_qq_android_native_ptu_res_");
  }
  
  private birq()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    Looper localLooper = this.jdField_a_of_type_AndroidOsHandlerThread.getLooper();
    if (localLooper != null)
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(localLooper);
      return;
    }
    bjah.d("AEResDownloader", "[HandlerThread init error:loop = null]");
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  public static birq a()
  {
    return jdField_a_of_type_Birq;
  }
  
  private List<ShortVideoResourceManager.SVConfigItem> a(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ShortVideoResourceManager.SVConfigItem localSVConfigItem1 = (ShortVideoResourceManager.SVConfigItem)paramList.next();
        ShortVideoResourceManager.SVConfigItem localSVConfigItem2 = new ShortVideoResourceManager.SVConfigItem();
        localSVConfigItem2.name = localSVConfigItem1.name;
        localSVConfigItem2.arm_url = localSVConfigItem1.arm_url;
        localSVConfigItem2.armv7a_url = localSVConfigItem1.armv7a_url;
        localSVConfigItem2.x86_url = localSVConfigItem1.x86_url;
        localSVConfigItem2.arm64v8a_url = localSVConfigItem1.arm64v8a_url;
        localSVConfigItem2.arm_md5 = localSVConfigItem1.arm_md5;
        localSVConfigItem2.armv7a_md5 = localSVConfigItem1.armv7a_md5;
        localSVConfigItem2.x86_md5 = localSVConfigItem1.x86_md5;
        localSVConfigItem2.arm64v8a_md5 = localSVConfigItem1.arm64v8a_md5;
        localSVConfigItem2.versionCode = localSVConfigItem1.versionCode;
        localSVConfigItem2.predownload = localSVConfigItem1.predownload;
        localSVConfigItem2.extend1 = localSVConfigItem1.extend1;
        localSVConfigItem2.extend2 = localSVConfigItem1.extend2;
        localCopyOnWriteArrayList.add(localSVConfigItem2);
      }
      return localCopyOnWriteArrayList;
    }
    return null;
  }
  
  private void a()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
    bjah.b("AEResDownloader", "【onConfigResult】mDownLoadListItem.size :" + this.jdField_a_of_type_JavaUtilList.size());
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      i = ShortVideoResourceManager.a(null, this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_b_of_type_JavaUtilMap == null)
      {
        bjah.d("AEResDownloader", "【AEDownLoad Error】: mStatusMap NULL");
        this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
      }
      if (i != 0) {
        break label209;
      }
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(-1), Integer.valueOf(4));
      bjah.b("AEResDownloader", "【onConfigResult Info】download config success");
      a(a(this.jdField_a_of_type_JavaUtilList), (QQAppInterface)localObject1);
    }
    Object localObject2;
    label209:
    do
    {
      return;
      localObject2 = new CopyOnWriteArrayList();
      int j = ShortVideoResourceManager.a(null, (List)localObject2);
      i = j;
      if (j != 0) {
        break;
      }
      i = j;
      if (((List)localObject2).size() <= 0) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_JavaUtilList = ((List)localObject2);
      i = j;
      break;
      if (ShortVideoResourceManager.a("[{\n        \"name\": \"new_qq_android_native_short_filter_62\",\n        \"arm_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_62.zip\",\n        \"armv7a_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_62.zip\",\n        \"x86_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_62.zip\",\n        \"arm64v8a_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_filter_62_64bit.zip\",\n        \"arm_md5\": \"124a724c15ec4750ba2c7c839d0940e7\",\n        \"armv7a_md5\": \"124a724c15ec4750ba2c7c839d0940e7\",\n        \"x86_md5\": \"124a724c15ec4750ba2c7c839d0940e7\",\n        \"arm64v8a_md5\": \"c2389ffc9a539aeac0a6921ad6321ee2\",\n        \"versionCode\": \"62\",\n        \"predownload\": false\n    },{\n        \"name\": \"new_qq_android_native_ptu_res_70\",\n        \"arm_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_70.zip\",\n        \"armv7a_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_70.zip\",\n        \"x86_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_70.zip\",\n        \"arm64v8a_url\": \"http://down.qq.com/shadow_qqcamera/Android/new_qq_android_native_ptu_res_70_64bit.zip\",\n        \"arm_md5\": \"68611e650a7057e4cca3fe9091c589c8\",\n        \"armv7a_md5\": \"68611e650a7057e4cca3fe9091c589c8\",\n        \"x86_md5\": \"68611e650a7057e4cca3fe9091c589c8\",\n        \"arm64v8a_md5\": \"858d312925b6e2edcaa44e92a104d92c\",\n        \"versionCode\": \"70\",\n        \"predownload\": false\n    }]", this.jdField_a_of_type_JavaUtilList) == 0)
      {
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(-1), Integer.valueOf(4));
        bjah.b("AEResDownloader", "【onConfigResult Info】Use Local to Download package");
        a(a(this.jdField_a_of_type_JavaUtilList), (QQAppInterface)localObject1);
        return;
      }
      this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(-1));
      bjah.d("AEResDownloader", "【Error】Local Config is not useful！！！！");
    } while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0));
    localObject1 = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      i = ((Integer)((Iterator)localObject1).next()).intValue();
      localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((birs)((Iterator)localObject2).next()).a(i, false, -102);
      }
    }
  }
  
  private void a(@Nullable List<ShortVideoResourceManager.SVConfigItem> paramList, @Nullable QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramQQAppInterface == null)) {
      bjah.d("AEResDownloader", "【SERIOUS ERROR】startDownLoad: listItem == null || appInterface == null");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
    {
      int i;
      int j;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek() == null)
        {
          bjah.d("AEResDownloader", "[Download Queue empty]");
          return;
        }
        i = ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek()).intValue();
        if ((this.jdField_b_of_type_JavaUtilMap != null) && (this.jdField_b_of_type_JavaUtilMap.containsKey(Integer.valueOf(i))))
        {
          j = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(i))).intValue();
          bjah.a("AEResDownloader", "[ready to Download] res_to_download:" + i);
          bjah.a("AEResDownloader", "[ready to Download] status:" + j);
          if (!a()) {
            break label265;
          }
          if (j == 3) {
            return;
          }
          this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(i), Integer.valueOf(3));
          if (j == 2) {
            a(paramList, paramQQAppInterface, i);
          }
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
          bjah.b("AEResDownloader", "【AEResDownloader】follow doUserDownloadResourceFilterAsync");
          ShortVideoResourceManager.a(paramQQAppInterface, paramList, this, (String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
          return;
        }
      }
      catch (NoSuchElementException paramList)
      {
        bjah.d("AEResDownloader", "【SERIOUS ERROR】LinkedList.getFirst():NoSuchElementException ");
        return;
      }
      bjah.d("AEResDownloader", "[SERIOUS ERROR] cant find mission");
      return;
      label265:
      if ((j != 3) && (j != 2))
      {
        if (!a(paramList, this, paramQQAppInterface, i))
        {
          bjah.b("AEResDownloader", "【AEResDownloader】follow doUserDownloadResourceFilterAsync");
          a(paramList, paramQQAppInterface, i);
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
          ShortVideoResourceManager.a(paramQQAppInterface, paramList, this, (String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
          this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(i), Integer.valueOf(3));
          return;
        }
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(i), Integer.valueOf(2));
      }
    }
  }
  
  private void a(@Nullable List<ShortVideoResourceManager.SVConfigItem> paramList, @Nullable QQAppInterface paramQQAppInterface, @Nullable int paramInt)
  {
    if ((paramList == null) || (paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) == null)) {}
    for (;;)
    {
      return;
      paramQQAppInterface = (ayxs)paramQQAppInterface.getManager(193);
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      } while (!paramList.name.startsWith((String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))));
      while ((paramQQAppInterface.a()) && (paramList != null))
      {
        if ((axfr.a()) && (paramList.check64BitReady()))
        {
          paramQQAppInterface.a(paramList.arm64v8a_url);
          return;
        }
        paramQQAppInterface.a(paramList.armv7a_url);
        return;
        paramList = null;
      }
    }
  }
  
  private boolean a(@Nullable List<ShortVideoResourceManager.SVConfigItem> paramList, @Nullable axeq paramaxeq, @Nullable QQAppInterface paramQQAppInterface, @Nullable int paramInt)
  {
    if ((paramList == null) || (paramQQAppInterface == null) || (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) == null)) {
      return false;
    }
    ayxs localayxs = (ayxs)paramQQAppInterface.getManager(193);
    Iterator localIterator = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
    } while (!localSVConfigItem.name.startsWith((String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))));
    for (;;)
    {
      if (localayxs.a())
      {
        paramaxeq = new birr(this, paramQQAppInterface, "ae_camera_res", new AEResDownloader.3(this, paramInt, paramQQAppInterface, paramList, paramaxeq), 4000L);
        if (localSVConfigItem != null)
        {
          if ((axfr.a()) && (localSVConfigItem.check64BitReady())) {}
          for (paramList = localSVConfigItem.arm64v8a_url;; paramList = localSVConfigItem.armv7a_url)
          {
            boolean bool = localayxs.a(10091, null, localSVConfigItem.name, 0, paramList, ShortVideoResourceManager.a(localSVConfigItem.name), 4, 0, true, paramaxeq);
            bjah.b("AEResDownloader", "【onConfigResult】ctrl.requestPreDownload :" + bool);
            return bool;
          }
        }
        return false;
      }
      return false;
      localSVConfigItem = null;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    bjaa.a().a("key_ae_res_" + paramInt2, paramInt1, 4);
  }
  
  private void b(int paramInt, @Nullable birs parambirs, boolean paramBoolean)
  {
    bjah.b("AEResDownloader", "【START】[requestAEKitDownload] + BEGIN, index = " + paramInt);
    if (this.jdField_b_of_type_JavaUtilMap == null)
    {
      bjah.d("AEResDownloader", "【AEDownLoad Error】: mStatusMap NULL");
      this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    }
    if (!this.jdField_b_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Integer.valueOf(0));
    }
    int i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).intValue();
    if (i == 4)
    {
      if (parambirs != null) {
        parambirs.a(paramInt, true, 0);
      }
      bjah.b("AEResDownloader", "【AEDownLoad Ready】: package_index :" + paramInt);
    }
    do
    {
      return;
      if (i == 3)
      {
        a(parambirs);
        bjah.b("AEResDownloader", "【AEDownLoad DOWNLOADING】: package_index :" + paramInt);
        return;
      }
      if ((bbfj.g(null)) && ((!paramBoolean) || (bbfj.h(null)))) {}
      for (i = 1; i == 0; i = 0)
      {
        if (parambirs != null) {
          parambirs.a(paramInt, false, -6);
        }
        bjah.d("AEResDownloader", "【AEDownLoad Error】: NetWork Error");
        return;
      }
      a(parambirs);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(Integer.valueOf(paramInt)))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(Integer.valueOf(paramInt));
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Integer.valueOf(1));
      }
      if (!this.jdField_b_of_type_JavaUtilMap.containsKey(Integer.valueOf(-1)))
      {
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(-1), Integer.valueOf(3));
        ShortVideoResourceManager.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this);
        return;
      }
    } while ((this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(-1)) == null) || (((Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(-1))).intValue() != 4));
    a(1, 0);
  }
  
  public void G_()
  {
    bjah.d("AEResDownloader", ajya.a(2131700006));
    axdu.a(3, -1500);
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilMap != null)
    {
      Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localInteger != null) {
        return localInteger.intValue();
      }
      return 0;
    }
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEResDownloader.2(this));
      return;
    }
    a();
  }
  
  public void a(int paramInt, @Nullable birs parambirs, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEResDownloader.1(this, paramInt, parambirs, paramBoolean));
      return;
    }
    b(paramInt, parambirs, paramBoolean);
  }
  
  public void a(@Nullable birs parambirs)
  {
    if (parambirs == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.contains(parambirs))) {
          continue;
        }
        this.jdField_b_of_type_JavaUtilList.add(parambirs);
      }
      finally {}
    }
  }
  
  public void a(@Nullable String paramString1, int paramInt, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    int i;
    if ((paramInt == 0) || (paramInt == 1))
    {
      i = 0;
      if (this.jdField_b_of_type_JavaUtilMap == null)
      {
        bjah.d("AEResDownloader", "【AEDownLoad Error】: mStatusMap NULL");
        this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
      }
      paramString1 = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    }
    int j;
    label268:
    label297:
    label380:
    long l;
    for (;;)
    {
      if (paramString1.hasNext())
      {
        j = ((Integer)paramString1.next()).intValue();
        if (str.startsWith((String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j))))
        {
          bjah.b("AEResDownloader", "【onDownloadFinish】 result = " + paramInt + ", name = " + str + ", filePath = " + paramString2);
          if (i == 0)
          {
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(j), Integer.valueOf(4));
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(Integer.valueOf(j));
            paramString1 = new Intent();
            paramString1.setAction((String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)));
            paramString1.setPackage(BaseApplicationImpl.getContext().getPackageName());
            BaseApplicationImpl.getContext().sendBroadcast(paramString1);
            b(Integer.valueOf(str.substring(((String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j))).length())).intValue(), j);
            if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
              break label386;
            }
            paramString1 = this.jdField_b_of_type_JavaUtilList.iterator();
            if (!paramString1.hasNext()) {
              break label386;
            }
            paramString2 = (birs)paramString1.next();
            if (i != 0) {
              break label380;
            }
          }
          for (bool = true;; bool = false)
          {
            paramString2.a(j, bool, i);
            break label297;
            i = paramInt;
            break;
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(j), Integer.valueOf(0));
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(Integer.valueOf(j));
            break label268;
          }
          label386:
          if (paramInt != 1)
          {
            l = -1L;
            if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j)) != null) {
              l = System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j))).longValue();
            }
            paramString1 = bizt.a();
            if (paramInt != 0) {
              break label493;
            }
          }
        }
      }
    }
    label493:
    for (boolean bool = true;; bool = false)
    {
      paramString1.a(bool, j, paramInt, l);
      bjah.b("AEResDownloader", "【On DownLoadFinish】start download next");
      paramString1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      a(a(this.jdField_a_of_type_JavaUtilList), paramString1);
      return;
    }
  }
  
  public void a(@Nullable String paramString, long paramLong1, long paramLong2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.jdField_b_of_type_JavaUtilMap == null)
    {
      bjah.d("AEResDownloader", "【AEDownLoad Error】: mStatusMap NULL");
      this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    }
    bjah.a("AEResDownloader", "[onUpdateProgress] name = " + str + ", totalLen = " + paramLong2 + ", curOffset = " + paramLong1);
    paramString = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      int i = ((Integer)paramString.next()).intValue();
      if (str.startsWith((String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i))))
      {
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(i), Integer.valueOf(3));
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
        {
          Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext()) {
            ((birs)localIterator.next()).a(i, paramLong1, paramLong2);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(@Nullable birs parambirs)
  {
    if (parambirs == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_b_of_type_JavaUtilList == null) {
          continue;
        }
        this.jdField_b_of_type_JavaUtilList.remove(parambirs);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birq
 * JD-Core Version:    0.7.0.1
 */