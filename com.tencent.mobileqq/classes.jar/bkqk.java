import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class bkqk
  implements aysb
{
  private static bkqk jdField_a_of_type_Bkqk;
  public bkqm a;
  private HashMap<String, bkql> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  
  public bkqk()
  {
    this.jdField_a_of_type_Bkqm = new bkqm(this);
  }
  
  public static bkqk a()
  {
    if (jdField_a_of_type_Bkqk == null) {
      jdField_a_of_type_Bkqk = new bkqk();
    }
    return jdField_a_of_type_Bkqk;
  }
  
  private void a(FilterDesc paramFilterDesc)
  {
    ThreadManager.getSubThreadHandler().post(new VideoFilterListDownloader.1(this, paramFilterDesc));
  }
  
  private void a(FilterDesc paramFilterDesc, long paramLong, int paramInt)
  {
    if (paramFilterDesc != null) {}
    try
    {
      Object localObject2 = ((bjbk)bjae.a(5)).a;
      Object localObject1 = new ArrayList();
      if (localObject2 != null) {
        localObject1 = ((bkqp)localObject2).a(0).c;
      }
      localObject1 = ((List)localObject1).iterator();
      do
      {
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (QIMFilterCategoryItem)((Iterator)localObject1).next();
          } while (((QIMFilterCategoryItem)localObject2).jdField_a_of_type_Int != 103);
          localObject2 = ((QIMFilterCategoryItem)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
        }
      } while (!((String)((Iterator)localObject2).next()).equals(paramFilterDesc.name));
      long l = paramFilterDesc.bundle.getLong("requestStartTime", System.currentTimeMillis());
      xhe.a("record_filter_download", xhe.a(paramInt, System.currentTimeMillis() - l, paramFilterDesc.resurl, paramLong, paramFilterDesc.name));
      QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener report.");
      return;
    }
    catch (Exception paramFilterDesc)
    {
      QLog.i("VideoFilterListDownloader", 2, "Report exception.");
    }
  }
  
  private void a(FilterDesc paramFilterDesc, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      int i;
      try
      {
        bkql localbkql = (bkql)this.jdField_a_of_type_JavaUtilHashMap.get(paramFilterDesc.name);
        if ((localbkql != null) && (localbkql.jdField_a_of_type_JavaUtilArrayList != null))
        {
          i = 0;
          if (i < localbkql.jdField_a_of_type_JavaUtilArrayList.size())
          {
            bkqn localbkqn = (bkqn)((WeakReference)localbkql.jdField_a_of_type_JavaUtilArrayList.get(i)).get();
            if (localbkqn != null) {
              localArrayList.add(localbkqn);
            }
          }
          else
          {
            localbkql.jdField_a_of_type_JavaUtilArrayList.clear();
            this.jdField_a_of_type_JavaUtilHashMap.remove(paramFilterDesc.name);
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            i = 0;
            if (i < localArrayList.size())
            {
              paramFilterDesc = (bkqn)localArrayList.get(i);
              if (paramFilterDesc != null) {
                paramFilterDesc.a(paramBoolean);
              }
              i += 1;
              continue;
            }
          }
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      i += 1;
    }
  }
  
  public static boolean a(FilterDesc paramFilterDesc)
  {
    String str = paramFilterDesc.getResFold(bkue.b);
    bkqo.a();
    File localFile = new File(str + "params.json");
    boolean bool = false;
    if (!localFile.exists()) {
      bool = true;
    }
    if ((!bool) && (paramFilterDesc.respicname != null) && (!paramFilterDesc.respicname.equals("")) && (!new File(str + paramFilterDesc.respicname).exists()))
    {
      QLog.i("VideoFilterListDownloader", 2, "check false respicname file not exists :" + paramFilterDesc.name);
      return true;
    }
    return bool;
  }
  
  /* Error */
  private boolean a(FilterDesc paramFilterDesc, bkqn parambkqn)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	bkqk:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 174 1 0
    //   9: aload_0
    //   10: getfield 21	bkqk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   13: aload_1
    //   14: getfield 122	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:name	Ljava/lang/String;
    //   17: invokevirtual 178	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 180	bkql
    //   23: astore 4
    //   25: aload 4
    //   27: ifnonnull +63 -> 90
    //   30: new 180	bkql
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 254	bkql:<init>	(Lbkqk;)V
    //   38: astore 4
    //   40: aload 4
    //   42: aload_1
    //   43: putfield 257	bkql:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc	Lcom/tencent/mobileqq/richmedia/capture/data/FilterDesc;
    //   46: aload 4
    //   48: getfield 181	bkql:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   51: new 190	java/lang/ref/WeakReference
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 260	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   59: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   62: pop
    //   63: aload_0
    //   64: getfield 21	bkqk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   67: aload_1
    //   68: getfield 122	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:name	Ljava/lang/String;
    //   71: aload 4
    //   73: invokevirtual 264	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: iconst_0
    //   78: istore_3
    //   79: aload_0
    //   80: getfield 26	bkqk:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 206 1 0
    //   88: iload_3
    //   89: ireturn
    //   90: aload 4
    //   92: getfield 181	bkql:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: new 190	java/lang/ref/WeakReference
    //   98: dup
    //   99: aload_2
    //   100: invokespecial 260	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   103: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: iconst_1
    //   108: istore_3
    //   109: goto -30 -> 79
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 26	bkqk:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   117: invokeinterface 206 1 0
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	bkqk
    //   0	124	1	paramFilterDesc	FilterDesc
    //   0	124	2	parambkqn	bkqn
    //   78	31	3	bool	boolean
    //   23	68	4	localbkql	bkql
    // Exception table:
    //   from	to	target	type
    //   9	25	112	finally
    //   30	77	112	finally
    //   90	107	112	finally
  }
  
  public void a(aysx paramaysx)
  {
    paramaysx = (FilterDesc)paramaysx.a.a();
    if (paramaysx != null) {
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener onFailed file: " + paramaysx.resurl);
    }
  }
  
  public void a(FilterDesc paramFilterDesc, bkqn parambkqn)
  {
    if (!a(paramFilterDesc, parambkqn)) {
      a(paramFilterDesc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqk
 * JD-Core Version:    0.7.0.1
 */