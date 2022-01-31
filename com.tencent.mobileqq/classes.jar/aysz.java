import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class aysz
  implements ayry
{
  private static volatile int jdField_a_of_type_Int = -1;
  HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  public aysz() {}
  
  public aysz(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramHttpCommunicator;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private bbmg a(aysw paramaysw)
  {
    if (paramaysw == null) {
      return null;
    }
    ayrv localayrv;
    ayta localayta;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((paramaysw.jdField_b_of_type_Int == 0) && ((paramaysw instanceof ayrv)))
    {
      localayrv = (ayrv)paramaysw;
      localayta = (ayta)localayrv.jdField_a_of_type_JavaLangObject;
      if ((localayta == null) || (localayta.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
      localObject1 = localayrv.jdField_a_of_type_JavaLangString;
      if ((!localayrv.jdField_a_of_type_Boolean) || (localayrv.jdField_a_of_type_JavaLangString == null) || (localayrv.jdField_a_of_type_JavaLangString.startsWith("https"))) {
        break label694;
      }
      localObject3 = ayxe.a(localayrv.jdField_a_of_type_JavaLangString);
      localObject2 = ayxe.a().a((String)localObject3, 1002);
      localObject2 = ayxe.a(localayrv.jdField_a_of_type_JavaLangString, (String)localObject2);
      if ((localObject2 == null) || (((String)localObject2).equals(localayrv.jdField_a_of_type_JavaLangString))) {
        break label694;
      }
      if (!bbjw.a((String)localObject3)) {
        paramaysw.jdField_a_of_type_JavaUtilHashMap.put("host", localObject3);
      }
      localayrv.jdField_b_of_type_Boolean = true;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "NeedIpConnect url=" + localayrv.jdField_a_of_type_JavaLangString + " ipUrl=" + (String)localObject2);
        localObject1 = localObject2;
      }
    }
    label694:
    for (;;)
    {
      localObject2 = new bbmg((String)localObject1, localayrv.jdField_a_of_type_ArrayOfByte, localayta);
      if (localayrv.jdField_a_of_type_Int == 0) {}
      for (localObject1 = "GET";; localObject1 = "POST")
      {
        ((bbmg)localObject2).b((String)localObject1);
        localObject1 = localayrv.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          ((bbmg)localObject2).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
        }
      }
      ((bbmg)localObject2).j = localayrv.f;
      ((bbmg)localObject2).jdField_e_of_type_JavaLangString = localayrv.jdField_b_of_type_JavaLangString;
      ((bbmg)localObject2).k = localayrv.g;
      ((bbmg)localObject2).l = localayrv.jdField_h_of_type_Boolean;
      ((bbmg)localObject2).jdField_h_of_type_Boolean = localayrv.jdField_b_of_type_Boolean;
      ((bbmg)localObject2).jdField_c_of_type_Boolean = localayrv.jdField_c_of_type_Boolean;
      ((bbmg)localObject2).jdField_a_of_type_JavaLangString = paramaysw.jdField_e_of_type_JavaLangString;
      ((bbmg)localObject2).jdField_c_of_type_Int = paramaysw.g;
      ((bbmg)localObject2).jdField_b_of_type_Int = paramaysw.jdField_f_of_type_Int;
      ((bbmg)localObject2).jdField_a_of_type_Ayug = localayrv.jdField_a_of_type_Ayug;
      ((bbmg)localObject2).jdField_a_of_type_ArrayOfJavaLangString = localayrv.jdField_a_of_type_ArrayOfJavaLangString;
      ((bbmg)localObject2).jdField_e_of_type_Boolean = localayrv.o;
      ((bbmg)localObject2).d = paramaysw.l;
      ((bbmg)localObject2).i = localayrv.jdField_e_of_type_Boolean;
      if (jdField_a_of_type_Int == -1) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (paramaysw.jdField_e_of_type_Int == 1)
        {
          ((bbmg)localObject2).jdField_a_of_type_Int = 201;
          label507:
          if ((localayrv.jdField_a_of_type_JavaIoOutputStream != null) || (localayrv.jdField_c_of_type_JavaLangString != null)) {
            ((bbmg)localObject2).a(true);
          }
          localayta.jdField_a_of_type_Bbmg = ((bbmg)localObject2);
        }
        try
        {
          paramaysw = new URL(((bbmg)localObject2).a());
          localObject1 = localayrv.jdField_a_of_type_Aysx;
          ((aysx)localObject1).jdField_a_of_type_JavaUtilHashMap.put("serverip", paramaysw.getHost());
          ((aysx)localObject1).jdField_a_of_type_JavaUtilHashMap.put("param_url", ((bbmg)localObject2).a());
          return localObject2;
          if (localayrv.d)
          {
            ((bbmg)localObject2).jdField_h_of_type_Int = jdField_a_of_type_Int;
            continue;
            ((bbmg)localObject2).jdField_h_of_type_Int = (jdField_a_of_type_Int / 4);
            continue;
            if (paramaysw.jdField_e_of_type_Int == 2)
            {
              ((bbmg)localObject2).jdField_a_of_type_Int = 202;
              break label507;
            }
            if (paramaysw.jdField_e_of_type_Int != 0) {
              break label507;
            }
            ((bbmg)localObject2).jdField_a_of_type_Int = 200;
          }
        }
        catch (Exception paramaysw)
        {
          for (;;)
          {
            paramaysw.printStackTrace();
          }
        }
      }
      if (paramaysw.jdField_a_of_type_Aysa != null)
      {
        paramaysw.jdField_a_of_type_Aysx.a(1, 9302, "not support by HttpOldEngine", null);
        paramaysw.jdField_a_of_type_Aysa.onResp(paramaysw.jdField_a_of_type_Aysx);
      }
      return null;
    }
  }
  
  private boolean a(bbmg parambbmg, ayrv paramayrv)
  {
    boolean bool = parambbmg.c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "404:" + bool + " ip:" + paramayrv.jdField_b_of_type_Boolean);
    }
    return (bool) && (paramayrv.jdField_b_of_type_Boolean);
  }
  
  private static String b(aysw paramaysw, String paramString1, String paramString2)
  {
    if ((paramaysw != null) && (paramaysw.d != null) && (paramaysw.d.length() > 0)) {
      return paramaysw.d;
    }
    return paramString1 + "." + MD5.toMD5(ayui.a(paramString2, false)) + ".tmp";
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Int >= 0) {}
    for (;;)
    {
      return;
      Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 5) {}
      }
      try
      {
        jdField_a_of_type_Int = Integer.valueOf(localObject[4]).intValue();
        label56:
        if (jdField_a_of_type_Int == -1) {
          jdField_a_of_type_Int = 1;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.richmedia.OldHttpEngine", 2, "[initCmwapConnectionTypeFromDpc]: " + jdField_a_of_type_Int);
        return;
      }
      catch (Exception localException)
      {
        break label56;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "destroy " + this);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = null;
    }
  }
  
  public void a(aysw paramaysw)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    Object localObject3;
    if ((paramaysw != null) && (paramaysw.jdField_a_of_type_Aysa != null))
    {
      j = 0;
      localObject1 = localObject2;
      i = j;
      if ((paramaysw instanceof ayrv))
      {
        localObject3 = (ayrv)paramaysw;
        localObject1 = localObject2;
        i = j;
        if (((ayrv)localObject3).jdField_a_of_type_Int == 0)
        {
          localObject1 = localObject2;
          i = j;
          if (paramaysw.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = b(paramaysw, paramaysw.jdField_c_of_type_JavaLangString, ((ayrv)localObject3).jdField_a_of_type_JavaLangString);
            paramaysw.jdField_f_of_type_JavaLangString = ((String)localObject1);
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(localObject1, localObject1) == null) {
              break label346;
            }
          }
        }
      }
    }
    label204:
    label346:
    for (int i = 1;; i = j)
    {
      if ((paramaysw.jdField_b_of_type_Int == 0) && ((paramaysw instanceof ayrv)))
      {
        localObject2 = (ayrv)paramaysw;
        ((ayrv)localObject2).jdField_a_of_type_Aysx = new aysx((aysw)localObject2);
        localObject3 = new ayta(this);
        ((ayrv)localObject2).jdField_a_of_type_JavaLangObject = localObject3;
        ((ayta)localObject3).jdField_a_of_type_Ayrv = ((ayrv)localObject2);
        ((ayta)localObject3).jdField_a_of_type_Aysx = ((ayrv)localObject2).jdField_a_of_type_Aysx;
        if (i == 0) {
          ((ayta)localObject3).b();
        }
        if ((paramaysw.jdField_a_of_type_Aysx.jdField_a_of_type_Int == 2) && (!((ayta)localObject3).jdField_b_of_type_Boolean)) {
          break label204;
        }
        ayta.a((ayta)localObject3);
      }
      do
      {
        return;
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.OldHttpEngine", 2, "sendReq:" + paramaysw + " _id:" + paramaysw.jdField_e_of_type_JavaLangString + " isDownloading _key:" + (String)localObject1);
          }
          paramaysw.jdField_a_of_type_Aysx.jdField_a_of_type_Int = 3;
          ayta.a((ayta)localObject3);
          return;
        }
        c(paramaysw);
        return;
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("req:").append(paramaysw).append(" callback:");
      if (paramaysw == null) {}
      for (paramaysw = (aysw)localObject1;; paramaysw = paramaysw.jdField_a_of_type_Aysa)
      {
        QLog.e("Q.richmedia.OldHttpEngine", 2, paramaysw);
        return;
      }
    }
  }
  
  public void a(bbmg parambbmg)
  {
    if ((parambbmg != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(parambbmg);
    }
  }
  
  public void b(aysw paramaysw)
  {
    if (paramaysw == null) {}
    do
    {
      return;
      if (paramaysw.jdField_f_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaysw.jdField_f_of_type_JavaLangString);
      }
    } while (!ayta.class.isInstance(paramaysw.jdField_a_of_type_JavaLangObject));
    Object localObject = (ayrv)paramaysw;
    int i = paramaysw.g;
    if (((ayrv)localObject).jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ayui.a(i, bool, paramaysw.jdField_f_of_type_Int, paramaysw.jdField_e_of_type_JavaLangString, "cancelReq", "");
      localObject = (ayta)paramaysw.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((ayta)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((ayta)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      bbmg localbbmg = ((ayta)localObject).jdField_a_of_type_Bbmg;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localbbmg);
      }
      ((ayta)localObject).a(paramaysw);
      ((ayta)localObject).a();
      return;
    }
  }
  
  public void c(aysw paramaysw)
  {
    ayta localayta;
    do
    {
      try
      {
        bbmg localbbmg1 = a(paramaysw);
        localayta = (ayta)paramaysw.jdField_a_of_type_JavaLangObject;
        if ((localbbmg1 != null) && (localayta != null))
        {
          aysx localaysx = paramaysw.jdField_a_of_type_Aysx;
          localaysx.d += 1;
          localayta.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            a(localbbmg1);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          System.gc();
          try
          {
            bbmg localbbmg2 = a(paramaysw);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            Object localObject = null;
          }
        }
        paramaysw = paramaysw.jdField_a_of_type_Aysx;
        paramaysw.jdField_b_of_type_Int = 9366;
        paramaysw.jdField_a_of_type_JavaLangString = "oldengine close";
        paramaysw.jdField_a_of_type_Int = 1;
        ayta.a(localayta);
        return;
      }
    } while ((localayta == null) || (localayta.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    paramaysw = paramaysw.jdField_a_of_type_Aysx;
    paramaysw.jdField_b_of_type_Int = 9369;
    paramaysw.jdField_a_of_type_JavaLangString = "Out of memory";
    paramaysw.jdField_a_of_type_Int = 1;
    ayta.a(localayta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aysz
 * JD-Core Version:    0.7.0.1
 */