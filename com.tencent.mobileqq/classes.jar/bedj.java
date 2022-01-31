import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class bedj
{
  String jdField_a_of_type_JavaLangString = "DEVICE_NONE";
  HashMap<String, bedk> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  boolean jdField_a_of_type_Boolean = false;
  String b = "DEVICE_NONE";
  String c = "DEVICE_NONE";
  String d = "unknow";
  
  public bedj(TraeAudioManager paramTraeAudioManager) {}
  
  public int a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = this.jdField_a_of_type_JavaUtilHashMap.size();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return i;
  }
  
  public int a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    paramString = (bedk)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {}
    for (int i = paramString.a();; i = -1)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return i;
    }
  }
  
  public String a()
  {
    return this.d;
  }
  
  public String a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    int i = 0;
    Map.Entry localEntry;
    if (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      if (i != paramInt) {}
    }
    for (localObject = (bedk)localEntry.getValue();; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = ((bedk)localObject).a();; localObject = "DEVICE_NONE")
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        return localObject;
        i += 1;
        break;
      }
    }
  }
  
  public String a(String paramString)
  {
    Object localObject1 = null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      ((Map.Entry)localObject2).getKey();
      ((Map.Entry)localObject2).getValue();
      bedk localbedk = (bedk)((Map.Entry)localObject2).getValue();
      if ((localbedk != null) && (localbedk.a()) && (!localbedk.a().equals(paramString)))
      {
        if (localObject1 == null) {
          localObject2 = localbedk;
        }
        for (;;)
        {
          localObject1 = localObject2;
          break;
          localObject2 = localbedk;
          if (localbedk.a() < localObject1.a()) {
            localObject2 = localObject1;
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    if (localObject1 != null) {
      return localObject1.a();
    }
    return "DEVICE_SPEAKERPHONE";
  }
  
  public ArrayList<String> a()
  {
    new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    ArrayList localArrayList = b();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return localArrayList;
  }
  
  public HashMap<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    localHashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", b());
    localHashMap.put("EXTRA_DATA_CONNECTEDDEVICE", f());
    localHashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", g());
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return localHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaLangString = "DEVICE_NONE";
    this.b = "DEVICE_NONE";
    this.c = "DEVICE_NONE";
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.d = "unknow";
      return;
    }
    if (paramString.isEmpty())
    {
      this.d = "unknow";
      return;
    }
    this.d = paramString;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return bool;
  }
  
  public boolean a(String paramString)
  {
    AudioDeviceInterface.LogTraceEntry(" strConfigs:" + paramString);
    if ((paramString == null) || (paramString.length() <= 0)) {}
    do
    {
      String str;
      do
      {
        return false;
        str = paramString.replace("\n", "").replace("\r", "");
      } while ((str == null) || (str.length() <= 0));
      paramString = str;
      if (str.indexOf(";") < 0) {
        paramString = str + ";";
      }
      paramString = paramString.split(";");
    } while ((paramString == null) || (1 > paramString.length));
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = 0;
    while (i < paramString.length)
    {
      a(paramString[i], i);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a();
    return true;
  }
  
  boolean a(String paramString, int paramInt)
  {
    AudioDeviceInterface.LogTraceEntry(" devName:" + paramString + " priority:" + paramInt);
    bedk localbedk = new bedk(this);
    if (localbedk.a(paramString, paramInt)) {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "err dev exist!");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return false;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localbedk);
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, " n" + a() + " 0:" + a(0));
      }
      AudioDeviceInterface.LogTraceExit();
      return true;
    }
    QLog.e("TraeAudioManager", 2, " err dev init!");
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    Object localObject = (bedk)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localObject != null) && (((bedk)localObject).a() != paramBoolean))
    {
      ((bedk)localObject).a(paramBoolean);
      ((bedk)localObject).b(paramBoolean);
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append(" ++setVisible:").append(paramString);
        if (!paramBoolean) {
          break label101;
        }
        paramString = " Y";
        QLog.w("TraeAudioManager", 2, paramString);
      }
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return paramBoolean;
      label101:
      paramString = " N";
      break;
    }
  }
  
  public String b()
  {
    Object localObject1 = null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      ((Map.Entry)localObject2).getKey();
      ((Map.Entry)localObject2).getValue();
      bedk localbedk = (bedk)((Map.Entry)localObject2).getValue();
      if ((localbedk != null) && (localbedk.a()) && (localbedk.b()))
      {
        if (localObject1 == null) {
          localObject2 = localbedk;
        }
        for (;;)
        {
          localObject1 = localObject2;
          break;
          localObject2 = localbedk;
          if (localbedk.a() < localObject1.a()) {
            localObject2 = localObject1;
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    if (localObject1 != null) {
      return localObject1.a();
    }
    return "DEVICE_SPEAKERPHONE";
  }
  
  ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      bedk localbedk = (bedk)((Map.Entry)localIterator.next()).getValue();
      if ((localbedk != null) && (localbedk.a()) && (localbedk.b())) {
        localArrayList.add(localbedk.a());
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  public boolean b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    paramString = (bedk)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {}
    for (boolean bool = paramString.a();; bool = false)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return bool;
    }
  }
  
  public String c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    Object localObject = (bedk)this.jdField_a_of_type_JavaUtilHashMap.get(this.c);
    if ((localObject != null) && (((bedk)localObject).a())) {}
    for (localObject = this.c;; localObject = null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return localObject;
    }
  }
  
  public boolean c(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    bedk localbedk = (bedk)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localbedk != null) && (localbedk.a())) {
      this.c = paramString;
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return bool;
    }
  }
  
  public String d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    String str = f();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return str;
  }
  
  public boolean d(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    bedk localbedk = (bedk)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localbedk != null) && (localbedk.a()))
    {
      if ((this.b != null) && (!this.b.equals(paramString))) {
        this.jdField_a_of_type_JavaLangString = this.b;
      }
      this.b = paramString;
      this.c = "";
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return bool;
    }
  }
  
  public String e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    String str = g();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return str;
  }
  
  String f()
  {
    bedk localbedk = (bedk)this.jdField_a_of_type_JavaUtilHashMap.get(this.b);
    if ((localbedk != null) && (localbedk.a())) {
      return this.b;
    }
    return "DEVICE_NONE";
  }
  
  String g()
  {
    bedk localbedk = (bedk)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaLangString);
    if ((localbedk != null) && (localbedk.a())) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return "DEVICE_NONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bedj
 * JD-Core Version:    0.7.0.1
 */