import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.utils.ThreadPoolWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import cooperation.weiyun.sdk.download.DownloadType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class bguw
  implements axrt, bgvm, bgvo, bgvr
{
  static axrs jdField_a_of_type_Axrs = new bguy();
  private static Singleton<bguw, Void> jdField_a_of_type_ComTencentWeiyunUtilsSingleton;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private Context jdField_a_of_type_AndroidContentContext;
  private axrr jdField_a_of_type_Axrr;
  private final bguv jdField_a_of_type_Bguv = new bguv();
  private bgvk jdField_a_of_type_Bgvk;
  private bgvl jdField_a_of_type_Bgvl;
  private bgvn jdField_a_of_type_Bgvn;
  private bgvp jdField_a_of_type_Bgvp;
  private final ThreadPoolWrapper jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper = new ThreadPoolWrapper("WyDownloader");
  private final DualHashMap<Long, String> jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap = new DualHashMap();
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final HashMap<Long, bgut> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<Long> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List<bgvj> jdField_a_of_type_JavaUtilList;
  private Map<Long, axsp> jdField_a_of_type_JavaUtilMap = new HashMap();
  private axrr jdField_b_of_type_Axrr;
  private final HashSet<Long> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private LinkedList<Long> jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<String, axro> jdField_b_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentWeiyunUtilsSingleton = new bgux();
  }
  
  private bguw()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, new bguz(this));
  }
  
  public static bguw a()
  {
    return (bguw)jdField_a_of_type_ComTencentWeiyunUtilsSingleton.get(null);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2 + ".tmp";
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      if (localObject == null)
      {
        localIterator.remove();
      }
      else
      {
        localObject = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if ((localObject == null) || (((bgut)localObject).d())) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong)))
        {
          this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
          return;
        }
        if (this.jdField_b_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong))) {
          b();
        }
      }
      a();
      b();
    }
  }
  
  private void a(long paramLong, axsp paramaxsp)
  {
    if (paramaxsp == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(Long.valueOf(paramLong));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramaxsp);
      a();
      b();
      return;
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bgut localbgut1 = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbgut1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    if (paramBoolean1) {
      localbgut2.a(paramBoolean2);
    }
    if (paramBoolean3) {
      localbgut2.b(paramBoolean4);
    }
    a(localbgut2, 1, 0, null);
    return true;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      if (this.jdField_b_of_type_JavaUtilLinkedList.size() >= 2) {
        break label62;
      }
    }
    Long localLong;
    axsp localaxsp;
    label62:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localLong = (Long)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localaxsp = (axsp)this.jdField_a_of_type_JavaUtilMap.remove(localLong);
        if (localaxsp != null) {
          break;
        }
        b();
      }
      return;
    }
    bgut localbgut = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(localLong);
    if ((localbgut == null) || (!a(localbgut.c())) || (localbgut.d()))
    {
      b();
      return;
    }
    this.jdField_b_of_type_JavaUtilLinkedList.add(localLong);
    if (this.jdField_a_of_type_Axrr == null) {
      this.jdField_a_of_type_Axrr = bgvs.a();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bgvd(this, localLong, localaxsp));
  }
  
  public int a()
  {
    ??? = this.jdField_a_of_type_Bguv.a();
    int i = ((bguv)???).d;
    int j = ((bguv)???).c;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashMap.keySet());
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bgve(this, localArrayList));
      }
      return j + i;
    }
  }
  
  public bgut a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bgut localbgut = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbgut == null) {
        return null;
      }
    }
    return bgut.a(localObject.a(), localObject.a().a(), localObject.b(), localObject.a().a());
  }
  
  public bguv a()
  {
    return this.jdField_a_of_type_Bguv.a();
  }
  
  public String a(bgup parambgup, String paramString, bgvj parambgvj)
  {
    return b(parambgup, paramString, true, parambgvj);
  }
  
  public String a(bgup parambgup, String paramString, boolean paramBoolean, bgvj parambgvj)
  {
    return b(parambgup, paramString, paramBoolean, parambgvj);
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, bgvj parambgvj)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    a(paramString1, paramString2, paramString3, paramString4, new bgva(this, parambgvj, i), Integer.toString(i));
    return Integer.toString(i);
  }
  
  void a(int paramInt, bgut parambgut)
  {
    if (parambgut == null) {}
    do
    {
      return;
      synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
      {
        this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.put(Long.valueOf(parambgut.a()), Integer.toString(paramInt));
        ??? = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)???).hasNext())
        {
          bgvj localbgvj = (bgvj)((Iterator)???).next();
          if (localbgvj != null) {
            localbgvj.a(Integer.toString(paramInt));
          }
        }
      }
    } while (parambgut.a() == null);
    parambgut.a().a(Integer.toString(paramInt));
  }
  
  public void a(int paramInt, bgut parambgut, String paramString)
  {
    for (;;)
    {
      bgut localbgut;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = parambgut.a();
        localbgut = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
        if (localbgut == null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), parambgut);
          i = 1;
          a(paramInt, parambgut);
          if (i != 0)
          {
            parambgut.b(paramString);
            if (i == 0) {
              break label175;
            }
            a(parambgut, 1, 0, null);
          }
        }
        else
        {
          if (!localbgut.a().a()) {
            break label181;
          }
          parambgut.a().jdField_a_of_type_Int = localbgut.a().jdField_a_of_type_Int;
          parambgut.a().jdField_b_of_type_Int = localbgut.a().jdField_b_of_type_Int;
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), parambgut);
          i = 1;
        }
      }
      localbgut.a(parambgut.b());
      localbgut.b(parambgut.c());
      continue;
      label175:
      parambgut = localbgut;
      continue;
      label181:
      int i = 0;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    bgut localbgut;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localbgut = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbgut == null) {
        return;
      }
    }
    if (!localbgut.d())
    {
      if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
      {
        a(localbgut, 5, 1810004, null);
        return;
      }
      a(localbgut, 5, paramInt, paramString);
    }
  }
  
  public void a(long paramLong, bgur parambgur)
  {
    bgut localbgut;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localbgut = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbgut == null) {
        return;
      }
    }
    if (!localbgut.d())
    {
      if ((parambgur == null) || (TextUtils.isEmpty(parambgur.c)))
      {
        a(localbgut, 5, 1829002, null);
        return;
      }
      if (!a(localbgut.c()))
      {
        a(localbgut, 5, 1810004, null);
        return;
      }
      ??? = bgut.a(localbgut, parambgur.c, localbgut.d(), parambgur.jdField_b_of_type_JavaLangString, jdField_a_of_type_Axrs, this, a(localbgut.d(), localbgut.a().jdField_a_of_type_JavaLangString));
      localbgut.a((axro)???);
      localbgut.a(parambgur.e);
      localbgut.a().d = parambgur.e;
      a(paramLong, (axsp)???);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, bgut parambgut)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bgut localbgut = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbgut != null) {
        a(localbgut, 5, 1810002, null);
      }
      if (parambgut != null)
      {
        parambgut.a().jdField_a_of_type_Int = 0;
        parambgut.a().jdField_b_of_type_Int = 1810002;
        a(parambgut, true);
      }
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, bguu parambguu, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bgut localbgut = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ??? = localbgut;
      if (localbgut != null) {
        break label66;
      }
      if (parambguu == null) {
        parambguu = null;
      }
    }
    parambguu = parambguu.jdField_a_of_type_Bgut;
    label66:
    do
    {
      a((bgut)???, paramBoolean2);
      return;
      ??? = parambguu;
    } while (parambguu != null);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    bgut localbgut;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localbgut = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbgut == null) {
        return;
      }
    }
    if (!localbgut.d())
    {
      localbgut.b(paramString);
      if (paramBoolean1)
      {
        a(localbgut, 4, 0, null);
        return;
      }
      if (paramBoolean2)
      {
        a(localbgut, 5, 1810008, null);
        return;
      }
      if (paramBoolean3)
      {
        a(localbgut, 5, 1810031, null);
        return;
      }
      if (!a(localbgut.c()))
      {
        a(localbgut, 5, 1810004, null);
        return;
      }
      this.jdField_a_of_type_Bgvp.a(localbgut, DownloadType.FILE_ORDINARY.ordinal());
    }
  }
  
  void a(bgut parambgut, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bguv.a();
    this.jdField_a_of_type_Bguv.a(parambgut, paramInt1, paramInt2);
  }
  
  void a(bgut parambgut, int paramInt1, int paramInt2, String paramString)
  {
    if (parambgut == null) {}
    boolean bool;
    label47:
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        bool = true;
      }
    } while (!bool);
    int i = parambgut.a().jdField_a_of_type_Int;
    parambgut.a().jdField_a_of_type_Int = paramInt1;
    parambgut.a().jdField_b_of_type_Int = paramInt2;
    parambgut.a().jdField_a_of_type_JavaLangString = bgus.a(paramInt2, paramString);
    this.jdField_a_of_type_Bgvl.a(parambgut, true);
    a(parambgut, i, paramInt1);
    return;
    a(parambgut.a());
    i = 1;
    paramInt1 = 1;
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            if ((i != 0) || (parambgut.a().a()))
            {
              bool = true;
              label139:
              if (!bool) {
                break label793;
              }
              synchronized (this.jdField_a_of_type_JavaUtilHashSet)
              {
                this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambgut.a()));
              }
            }
            synchronized (this.jdField_b_of_type_JavaUtilHashSet)
            {
              this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(parambgut.a()));
              parambgut.c(false);
              this.jdField_a_of_type_Bgvn.a(parambgut);
              break;
              bool = false;
              break label139;
              parambgut = finally;
              throw parambgut;
            }
          }
          bool = parambgut.a().c();
          break;
          bool = parambgut.a().b();
          if (!bool) {
            break label790;
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashSet)
          {
            this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambgut.a()));
            parambgut.c(true);
            parambgut.b(false);
            if (this.jdField_a_of_type_Axrr == null) {
              this.jdField_a_of_type_Axrr = bgvs.a();
            }
            this.jdField_a_of_type_Axrr.b(parambgut.a());
            a(parambgut.a());
          }
        }
        if (paramInt2 == 1810002) {
          synchronized (this.jdField_a_of_type_JavaUtilHashMap)
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambgut.a()));
            synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
            {
              this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.removeByKey(Long.valueOf(parambgut.a()));
              synchronized (this.jdField_a_of_type_JavaUtilHashSet)
              {
                this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambgut.a()));
              }
            }
          }
        }
        for (;;)
        {
          synchronized (this.jdField_b_of_type_JavaUtilHashSet)
          {
            this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(parambgut.a()));
            parambgut.c(true);
            if (this.jdField_a_of_type_Axrr == null) {
              this.jdField_a_of_type_Axrr = bgvs.a();
            }
            this.jdField_a_of_type_Axrr.b(parambgut.a());
            paramInt1 = 0;
            a(parambgut.a());
            bool = true;
            break;
            parambgut = finally;
            throw parambgut;
            parambgut = finally;
            throw parambgut;
            parambgut = finally;
            throw parambgut;
          }
          if ((paramInt2 == 1810003) || (paramInt2 == 1810004)) {
            synchronized (this.jdField_a_of_type_JavaUtilHashSet)
            {
              this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(parambgut.a()));
              paramInt1 = 1;
            }
          }
          synchronized (this.jdField_b_of_type_JavaUtilHashSet)
          {
            this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(parambgut.a()));
          }
        }
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambgut.a()));
          synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
          {
            this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.removeByKey(Long.valueOf(parambgut.a()));
            synchronized (this.jdField_a_of_type_JavaUtilHashSet)
            {
              this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(parambgut.a()));
            }
          }
        }
        synchronized (this.jdField_b_of_type_JavaUtilHashSet)
        {
          this.jdField_b_of_type_JavaUtilHashSet.remove(Long.valueOf(parambgut.a()));
          parambgut.a().jdField_b_of_type_JavaLangString = parambgut.d();
          parambgut.a().jdField_b_of_type_Long = parambgut.a().jdField_a_of_type_Long;
          parambgut.a().jdField_a_of_type_Bgut = parambgut;
          a(parambgut.a());
          break;
          parambgut = finally;
          throw parambgut;
          parambgut = finally;
          throw parambgut;
          parambgut = finally;
          throw parambgut;
        }
      }
      label790:
      break label47;
      label793:
      break label47;
      i = 0;
    }
  }
  
  void a(bgut parambgut, boolean paramBoolean)
  {
    if (parambgut == null) {}
    do
    {
      return;
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      while (localIterator.hasNext())
      {
        bgvj localbgvj = (bgvj)localIterator.next();
        if (localbgvj != null) {
          localbgvj.a(parambgut.a(), parambgut.a(), parambgut.b(), paramBoolean);
        }
      }
    } while (parambgut.a() == null);
    parambgut.a().a(parambgut.a(), parambgut.a(), parambgut.b(), paramBoolean);
  }
  
  public void a(bgvj parambgvj)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambgvj);
  }
  
  public void a(bgvk parambgvk, Context paramContext)
  {
    this.jdField_a_of_type_Bgvk = parambgvk;
    if (this.jdField_a_of_type_Bgvk == null) {
      throw new NullPointerException("IFetchListener can not be null!");
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    parambgvk = new ReleaseLooperHandler("weiyun_download-work-thread");
    this.jdField_a_of_type_Bgvl = new bgvl(this, parambgvk);
    this.jdField_a_of_type_Bgvn = new bgvn(this, parambgvk);
    this.jdField_a_of_type_Bgvp = new bgvp(this, this.jdField_a_of_type_Bgvk, parambgvk);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bgvl.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, bgvi parambgvi)
  {
    a(paramString1, paramString2, null, paramString3, parambgvi, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, bgvi parambgvi, String paramString5)
  {
    paramString1 = bgut.a(paramString4, paramString1, paramString2, paramString3, jdField_a_of_type_Axrs, new bgvb(this, parambgvi, paramString4, paramString2));
    if (this.jdField_b_of_type_Axrr == null) {
      this.jdField_b_of_type_Axrr = bgvs.b();
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bgvc(this, paramString1));
    if (paramString5 != null) {
      this.jdField_b_of_type_JavaUtilMap.put(paramString5, paramString1);
    }
  }
  
  public void a(String arg1, List<bgut> paramList)
  {
    if ((!TextUtils.equals(???, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid())) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    for (;;)
    {
      bgut localbgut;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label199;
        }
        localbgut = (bgut)paramList.next();
        long l = localbgut.a();
        int i = localbgut.a().jdField_a_of_type_Int;
        localbgut.a().jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localbgut);
        switch (i)
        {
        case 0: 
        case 1: 
        case 2: 
          a(localbgut, 1, 0, null);
        }
      }
      a(localbgut, 3, 0, null);
      continue;
      a(localbgut, 5, localbgut.a().jdField_b_of_type_Int, localbgut.a().jdField_a_of_type_JavaLangString);
      continue;
      label199:
      return;
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.jdField_a_of_type_JavaUtilHashSet)
      {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashSet);
        ??? = localArrayList.iterator();
        if (!((Iterator)???).hasNext()) {
          return;
        }
        a(((Long)((Iterator)???).next()).longValue(), false, false, false, false);
      }
    }
    for (;;)
    {
      bgut localbgut;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localbgut = (bgut)((Map.Entry)localIterator.next()).getValue();
        if ((!localbgut.c()) || (!paramBoolean2))
        {
          if (!localbgut.a().b()) {
            continue;
          }
          localbgut.c(true);
          if (this.jdField_a_of_type_Axrr != null) {
            this.jdField_a_of_type_Axrr.b(localbgut.a());
          }
          a(localbgut, 5, 1810004, null);
        }
      }
      if ((localbgut.c()) && (paramBoolean2) && (localbgut.a().d())) {
        a(localbgut.a(), false, false, false, false);
      }
    }
  }
  
  public boolean a()
  {
    bguv localbguv = this.jdField_a_of_type_Bguv.a();
    int i = localbguv.jdField_a_of_type_Int;
    return localbguv.jdField_b_of_type_Int + i > 0;
  }
  
  public boolean a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bgut localbgut1 = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbgut1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    a(localbgut2, 3, 0, null);
    return true;
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      bgut localbgut1 = (bgut)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localbgut1 == null)
      {
        a(paramLong);
        return false;
      }
    }
    if (paramBoolean1)
    {
      localbgut2.a(paramBoolean2);
      localbgut2.b(paramBoolean3);
    }
    a(localbgut2, 1, 0, null);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_b_of_type_Axrr != null)
    {
      ??? = (axro)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (??? != null) {
        this.jdField_b_of_type_Axrr.b((axsp)???);
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap)
    {
      paramString = (Long)this.jdField_a_of_type_ComTencentWeiyunUtilsDualHashMap.getByValue(paramString);
      if (paramString == null) {
        return false;
      }
    }
    this.jdField_a_of_type_Bgvl.a(paramString.longValue(), true);
    return true;
  }
  
  boolean a(boolean paramBoolean)
  {
    Context localContext = WeiyunTransmissionGlobal.getInstance().getContext();
    boolean bool = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
    if ((paramBoolean) || (!bool)) {
      return NetworkUtils.isNetworkAvailable(localContext);
    }
    return NetworkUtils.isWifiAvailable(localContext);
  }
  
  public int b()
  {
    ??? = this.jdField_a_of_type_Bguv.a();
    int i = ((bguv)???).d;
    int j = ((bguv)???).jdField_a_of_type_Int;
    int k = ((bguv)???).jdField_b_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilHashMap.keySet());
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bgvf(this, localArrayList));
      }
      return k + (i + j);
    }
  }
  
  String b(bgup parambgup, String paramString, boolean paramBoolean, bgvj parambgvj)
  {
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    paramString = bgut.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), parambgup, paramString, new bguu());
    paramString.b(paramBoolean);
    paramString.a().c = parambgup.jdField_a_of_type_JavaLangString;
    paramString.a(parambgvj);
    this.jdField_a_of_type_Bgvl.a(i, paramString);
    return Integer.toString(i);
  }
  
  public void b(bgvj parambgvj)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(parambgvj)) {
      this.jdField_a_of_type_JavaUtilList.remove(parambgvj);
    }
  }
  
  public boolean b(long paramLong)
  {
    this.jdField_a_of_type_Bgvl.a(paramLong, true);
    return true;
  }
  
  public int c()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaUtilHashSet)
    {
      int i = this.jdField_b_of_type_JavaUtilHashSet.size();
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilHashSet);
      if (!localArrayList.isEmpty()) {
        this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsThreadPoolWrapper.submit(new bgvg(this, localArrayList));
      }
      return i;
    }
  }
  
  public void onResp(axsq paramaxsq)
  {
    if (paramaxsq.jdField_a_of_type_Int == 3) {}
    int j;
    label111:
    label122:
    do
    {
      return;
      if (paramaxsq.jdField_a_of_type_Int == 0) {}
      for (int i = 1;; i = 0)
      {
        j = paramaxsq.jdField_b_of_type_Int;
        paramaxsq = ((axro)paramaxsq.jdField_a_of_type_Axsp).a();
        if ((paramaxsq == null) || (!(paramaxsq instanceof bgut))) {
          break;
        }
        paramaxsq = (bgut)paramaxsq;
        if ((paramaxsq == null) || (paramaxsq.d())) {
          break;
        }
        if (i == 0) {
          break label122;
        }
        File localFile = new File(paramaxsq.d());
        if (!localFile.exists()) {
          break label111;
        }
        IOUtils.scan2MediaStore(WeiyunTransmissionGlobal.getInstance().getContext(), localFile);
        a(paramaxsq, 4, 0, null);
        return;
      }
      a(paramaxsq, 5, 1810031, null);
      return;
    } while (paramaxsq.d());
    if (bgus.a(j))
    {
      a(paramaxsq, 0, j, null);
      return;
    }
    a(paramaxsq, 5, j, null);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    paramaxsp = paramaxsp.a();
    if ((paramaxsp != null) && ((paramaxsp instanceof bgut)))
    {
      paramaxsp = (bgut)paramaxsp;
      if (paramaxsp != null) {
        break label26;
      }
    }
    label26:
    while (paramaxsp.d()) {
      return;
    }
    if (paramaxsp.a().c()) {
      a(paramaxsp, 2, 0, null);
    }
    paramaxsp.a().jdField_a_of_type_Long = paramLong2;
    bguu localbguu = paramaxsp.a();
    if (paramLong1 < paramLong2) {}
    for (;;)
    {
      localbguu.jdField_b_of_type_Long = paramLong1;
      a(paramaxsp, false);
      return;
      paramLong1 = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguw
 * JD-Core Version:    0.7.0.1
 */