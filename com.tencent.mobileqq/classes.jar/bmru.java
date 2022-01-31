import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(9)
public class bmru
  implements uvi
{
  public static final String a;
  public final int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  bmsf jdField_a_of_type_Bmsf = null;
  public DoodleEmojiItem a;
  public final Object a;
  public final List<DoodleEmojiItem> a;
  public final Queue<DoodleEmojiItem> a;
  public final ConcurrentHashMap<String, DoodleEmojiItem> a;
  public volatile AtomicInteger a;
  uxw jdField_a_of_type_Uxw = new bmry(this);
  public String b;
  protected List<Location> b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ulg.j + "emoji";
    a(jdField_a_of_type_JavaLangString);
  }
  
  public bmru()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangObject = new Object[0];
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 50;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().a();
    if (localBaseApplicationImpl == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("qqstory_emoji", 4);
  }
  
  public static String a(bmru parambmru, String paramString)
  {
    return parambmru.a("emoji_pack_url_" + paramString, "");
  }
  
  private static String a(@NonNull File paramFile)
  {
    return paramFile.getName().substring("emoji_folder_".length());
  }
  
  protected static String a(@NonNull String paramString)
  {
    return jdField_a_of_type_JavaLangString + File.separator + "emoji_zip_" + paramString;
  }
  
  public static void a(bmru parambmru, String paramString1, String paramString2)
  {
    parambmru.a("emoji_pack_md5_" + paramString1, paramString2);
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      wxe.d("DoodleEmojiManager", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      wxe.d("DoodleEmojiManager", "create folder : " + bool);
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  private static boolean a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    do
    {
      return false;
      paramFile = paramFile.listFiles(new bmsa());
    } while ((paramFile == null) || (paramFile.length <= 0));
    return true;
  }
  
  public static String b(bmru parambmru, String paramString)
  {
    return parambmru.a("emoji_pack_name_" + paramString, "");
  }
  
  protected static String b(@NonNull String paramString)
  {
    return jdField_a_of_type_JavaLangString + File.separator + "emoji_folder_" + paramString;
  }
  
  private static void b(bmru parambmru, String paramString1, String paramString2)
  {
    parambmru.a("emoji_pack_url_" + paramString1, paramString2);
  }
  
  public static String c(bmru parambmru, String paramString)
  {
    return parambmru.a("emoji_pack_config_" + paramString, "");
  }
  
  private static void c(bmru parambmru, String paramString1, String paramString2)
  {
    parambmru.a("emoji_pack_name_" + paramString1, paramString2);
  }
  
  public static String d(bmru parambmru, String paramString)
  {
    return parambmru.a("emoji_pack_md5_" + paramString, "");
  }
  
  private static void d(bmru parambmru, String paramString1, String paramString2)
  {
    parambmru.a("emoji_pack_config_" + paramString1, paramString2);
  }
  
  public String a(@NonNull String paramString1, @NonNull String paramString2)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, paramString2);
  }
  
  public List<DoodleEmojiItem> a()
  {
    if (!a())
    {
      wxe.b("DoodleEmojiManager", "getCurrentEmojiPackList but not init yet");
      return Collections.EMPTY_LIST;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, bmsf parambmsf)
  {
    parambmsf = new WeakReference(parambmsf);
    urp.a().a(new vfq(paramInt1, paramInt2), new bmrz(this, parambmsf));
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public void a(List<DoodleEmojiItem> arg1)
  {
    if (??? == null) {
      return;
    }
    bmru localbmru = (bmru)uwa.a(39);
    ArrayList localArrayList = new ArrayList(???.size());
    Iterator localIterator = ???.iterator();
    label36:
    DoodleEmojiItem localDoodleEmojiItem;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localDoodleEmojiItem = (DoodleEmojiItem)localIterator.next();
      if (localDoodleEmojiItem.type != 1) {
        break label436;
      }
      localObject2 = (DoodleEmojiItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localDoodleEmojiItem.pack_id);
      if (localObject2 == null) {
        break label436;
      }
      ??? = ((DoodleEmojiItem)localObject2).getLocalEmojiFolderPath();
      if (TextUtils.equals(((DoodleEmojiItem)localObject2).md5, localDoodleEmojiItem.md5)) {
        break label433;
      }
      wxe.a("DoodleEmojiManager", "EmojiPack md5 has changed. old : %s, new : %s", ((DoodleEmojiItem)localObject2).md5, localDoodleEmojiItem.md5);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          xrg.d(???);
          localObject2 = new bmsb(localDoodleEmojiItem, 0, false, 0L, 0L);
          ((bmsb)localObject2).b = true;
          umc.a().dispatch((Dispatcher.Dispatchable)localObject2);
          ??? = null;
          localDoodleEmojiItem.setLocalEmojiFolderPath(???);
          b(localbmru, localDoodleEmojiItem.pack_id, localDoodleEmojiItem.icon);
          c(localbmru, localDoodleEmojiItem.pack_id, localDoodleEmojiItem.name);
          d(localbmru, localDoodleEmojiItem.pack_id, localDoodleEmojiItem.config);
          a(localbmru, localDoodleEmojiItem.pack_id, localDoodleEmojiItem.md5);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localDoodleEmojiItem.pack_id, localDoodleEmojiItem);
          if (localArrayList.contains(localDoodleEmojiItem)) {
            break label36;
          }
          localArrayList.add(localDoodleEmojiItem);
        }
        catch (Exception localException)
        {
          wxe.d("DoodleEmojiManager", "remove folder : %s failed. error: %s .", new Object[] { ???, localException });
          continue;
        }
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
          if (QLog.isColorLevel()) {
            QLog.i("DoodleEmojiManager", 2, "paster config processResponse " + this.jdField_a_of_type_JavaUtilList.size());
          }
          if (localArrayList.size() <= 0) {
            break;
          }
          wxe.b("DoodleEmojiManager", "start download the first emoji pack if needed : " + ((DoodleEmojiItem)localArrayList.get(0)).pack_id);
          a(((DoodleEmojiItem)localArrayList.get(0)).pack_id, false);
          return;
        }
      }
      label433:
      continue;
      label436:
      ??? = null;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!a()) {
      wxe.d("DoodleEmojiManager", "downloadEmojiPack init state = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) });
    }
    if (paramString == null) {
      throw new IllegalArgumentException("pack id should not be null");
    }
    DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localDoodleEmojiItem == null)
    {
      wxe.d("DoodleEmojiManager", "can not find pack item by id " + paramString);
      return false;
    }
    ??? = new File(b(localDoodleEmojiItem.pack_id));
    if ((a((File)???)) && (!paramBoolean))
    {
      wxe.d("DoodleEmojiManager", "already has local emoji folder, notify download success directly");
      localDoodleEmojiItem.setLocalEmojiFolderPath(((File)???).getPath());
      umc.a().dispatch(new bmsb(localDoodleEmojiItem, 0, true, 0L, 0L));
      return true;
    }
    if (!TextUtils.isEmpty(localDoodleEmojiItem.getLocalEmojiFolderPath()))
    {
      wxe.d("DoodleEmojiManager", "local emoji folder is missing");
      localDoodleEmojiItem.setLocalEmojiFolderPath(null);
    }
    if (TextUtils.isEmpty(localDoodleEmojiItem.download_url))
    {
      wxe.d("DoodleEmojiManager", "can not start download because of empty download-url is found");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(localDoodleEmojiItem))
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localDoodleEmojiItem);
        wxe.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " enqueue");
        d();
        return true;
      }
      wxe.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " is already in pending list");
    }
  }
  
  public void b()
  {
    uxt localuxt = (uxt)uwa.a(9);
    if ((localuxt != null) && (this.jdField_a_of_type_Uxw != null)) {
      localuxt.b(this.jdField_a_of_type_Uxw);
    }
    this.jdField_a_of_type_Bmsf = null;
  }
  
  public void c()
  {
    wxe.b("DoodleEmojiManager", "initLocalPackages, doodle emoji path : " + jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      bmru localbmru = (bmru)uwa.a(39);
      Object localObject1 = new File(jdField_a_of_type_JavaLangString);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles(new bmrv(this));
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          if (i < j)
          {
            File localFile = localObject1[i];
            Object localObject2 = localFile.listFiles(new bmrw(this));
            if ((localObject2 != null) && (localObject2.length > 0))
            {
              localObject2 = a(localFile);
              Object localObject3 = b(localbmru, (String)localObject2);
              localObject3 = new DoodleEmojiItem((String)localObject2, a(localbmru, (String)localObject2), (String)localObject3, null, c(localbmru, (String)localObject2), d(localbmru, (String)localObject2));
              ((DoodleEmojiItem)localObject3).setLocalEmojiFolderPath(localFile.getPath());
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, localObject3);
              wxe.b("DoodleEmojiManager", "load local emoji pack : " + localObject3);
            }
            for (;;)
            {
              i += 1;
              break;
              try
              {
                xrg.d(localFile.getPath());
                wxe.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete it");
              }
              catch (Exception localException)
              {
                wxe.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete failed : " + localException);
              }
            }
          }
        }
      }
      else
      {
        wxe.d("DoodleEmojiManager", "local emoji folder is empty");
      }
      a(((blvu)blqr.a(1)).a());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
  }
  
  protected void d()
  {
    wxe.b("DoodleEmojiManager", "startDownload");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem == null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = ((DoodleEmojiItem)this.jdField_a_of_type_JavaUtilQueue.poll());
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem != null)
        {
          wxe.b("DoodleEmojiManager", "downloader startDownload : " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
          Bosses.get().postJob(new bmrx(this, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem));
        }
        return;
      }
      wxe.b("DoodleEmojiManager", "can not start download because find one is still downloading : " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmru
 * JD-Core Version:    0.7.0.1
 */