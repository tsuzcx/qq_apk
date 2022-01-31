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

public class aytb
  implements aysa
{
  private static volatile int jdField_a_of_type_Int = -1;
  HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  public aytb() {}
  
  public aytb(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramHttpCommunicator;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private bbmu a(aysy paramaysy)
  {
    if (paramaysy == null) {
      return null;
    }
    ayrx localayrx;
    aytc localaytc;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((paramaysy.jdField_b_of_type_Int == 0) && ((paramaysy instanceof ayrx)))
    {
      localayrx = (ayrx)paramaysy;
      localaytc = (aytc)localayrx.jdField_a_of_type_JavaLangObject;
      if ((localaytc == null) || (localaytc.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
      localObject1 = localayrx.jdField_a_of_type_JavaLangString;
      if ((!localayrx.jdField_a_of_type_Boolean) || (localayrx.jdField_a_of_type_JavaLangString == null) || (localayrx.jdField_a_of_type_JavaLangString.startsWith("https"))) {
        break label694;
      }
      localObject3 = ayxg.a(localayrx.jdField_a_of_type_JavaLangString);
      localObject2 = ayxg.a().a((String)localObject3, 1002);
      localObject2 = ayxg.a(localayrx.jdField_a_of_type_JavaLangString, (String)localObject2);
      if ((localObject2 == null) || (((String)localObject2).equals(localayrx.jdField_a_of_type_JavaLangString))) {
        break label694;
      }
      if (!bbkk.a((String)localObject3)) {
        paramaysy.jdField_a_of_type_JavaUtilHashMap.put("host", localObject3);
      }
      localayrx.jdField_b_of_type_Boolean = true;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "NeedIpConnect url=" + localayrx.jdField_a_of_type_JavaLangString + " ipUrl=" + (String)localObject2);
        localObject1 = localObject2;
      }
    }
    label694:
    for (;;)
    {
      localObject2 = new bbmu((String)localObject1, localayrx.jdField_a_of_type_ArrayOfByte, localaytc);
      if (localayrx.jdField_a_of_type_Int == 0) {}
      for (localObject1 = "GET";; localObject1 = "POST")
      {
        ((bbmu)localObject2).b((String)localObject1);
        localObject1 = localayrx.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          ((bbmu)localObject2).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
        }
      }
      ((bbmu)localObject2).j = localayrx.f;
      ((bbmu)localObject2).jdField_e_of_type_JavaLangString = localayrx.jdField_b_of_type_JavaLangString;
      ((bbmu)localObject2).k = localayrx.g;
      ((bbmu)localObject2).l = localayrx.jdField_h_of_type_Boolean;
      ((bbmu)localObject2).jdField_h_of_type_Boolean = localayrx.jdField_b_of_type_Boolean;
      ((bbmu)localObject2).jdField_c_of_type_Boolean = localayrx.jdField_c_of_type_Boolean;
      ((bbmu)localObject2).jdField_a_of_type_JavaLangString = paramaysy.jdField_e_of_type_JavaLangString;
      ((bbmu)localObject2).jdField_c_of_type_Int = paramaysy.g;
      ((bbmu)localObject2).jdField_b_of_type_Int = paramaysy.jdField_f_of_type_Int;
      ((bbmu)localObject2).jdField_a_of_type_Ayui = localayrx.jdField_a_of_type_Ayui;
      ((bbmu)localObject2).jdField_a_of_type_ArrayOfJavaLangString = localayrx.jdField_a_of_type_ArrayOfJavaLangString;
      ((bbmu)localObject2).jdField_e_of_type_Boolean = localayrx.o;
      ((bbmu)localObject2).d = paramaysy.l;
      ((bbmu)localObject2).i = localayrx.jdField_e_of_type_Boolean;
      if (jdField_a_of_type_Int == -1) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (paramaysy.jdField_e_of_type_Int == 1)
        {
          ((bbmu)localObject2).jdField_a_of_type_Int = 201;
          label507:
          if ((localayrx.jdField_a_of_type_JavaIoOutputStream != null) || (localayrx.jdField_c_of_type_JavaLangString != null)) {
            ((bbmu)localObject2).a(true);
          }
          localaytc.jdField_a_of_type_Bbmu = ((bbmu)localObject2);
        }
        try
        {
          paramaysy = new URL(((bbmu)localObject2).a());
          localObject1 = localayrx.jdField_a_of_type_Aysz;
          ((aysz)localObject1).jdField_a_of_type_JavaUtilHashMap.put("serverip", paramaysy.getHost());
          ((aysz)localObject1).jdField_a_of_type_JavaUtilHashMap.put("param_url", ((bbmu)localObject2).a());
          return localObject2;
          if (localayrx.d)
          {
            ((bbmu)localObject2).jdField_h_of_type_Int = jdField_a_of_type_Int;
            continue;
            ((bbmu)localObject2).jdField_h_of_type_Int = (jdField_a_of_type_Int / 4);
            continue;
            if (paramaysy.jdField_e_of_type_Int == 2)
            {
              ((bbmu)localObject2).jdField_a_of_type_Int = 202;
              break label507;
            }
            if (paramaysy.jdField_e_of_type_Int != 0) {
              break label507;
            }
            ((bbmu)localObject2).jdField_a_of_type_Int = 200;
          }
        }
        catch (Exception paramaysy)
        {
          for (;;)
          {
            paramaysy.printStackTrace();
          }
        }
      }
      if (paramaysy.jdField_a_of_type_Aysc != null)
      {
        paramaysy.jdField_a_of_type_Aysz.a(1, 9302, "not support by HttpOldEngine", null);
        paramaysy.jdField_a_of_type_Aysc.onResp(paramaysy.jdField_a_of_type_Aysz);
      }
      return null;
    }
  }
  
  private boolean a(bbmu parambbmu, ayrx paramayrx)
  {
    boolean bool = parambbmu.c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "404:" + bool + " ip:" + paramayrx.jdField_b_of_type_Boolean);
    }
    return (bool) && (paramayrx.jdField_b_of_type_Boolean);
  }
  
  private static String b(aysy paramaysy, String paramString1, String paramString2)
  {
    if ((paramaysy != null) && (paramaysy.d != null) && (paramaysy.d.length() > 0)) {
      return paramaysy.d;
    }
    return paramString1 + "." + MD5.toMD5(ayuk.a(paramString2, false)) + ".tmp";
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
  
  public void a(aysy paramaysy)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    Object localObject3;
    if ((paramaysy != null) && (paramaysy.jdField_a_of_type_Aysc != null))
    {
      j = 0;
      localObject1 = localObject2;
      i = j;
      if ((paramaysy instanceof ayrx))
      {
        localObject3 = (ayrx)paramaysy;
        localObject1 = localObject2;
        i = j;
        if (((ayrx)localObject3).jdField_a_of_type_Int == 0)
        {
          localObject1 = localObject2;
          i = j;
          if (paramaysy.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = b(paramaysy, paramaysy.jdField_c_of_type_JavaLangString, ((ayrx)localObject3).jdField_a_of_type_JavaLangString);
            paramaysy.jdField_f_of_type_JavaLangString = ((String)localObject1);
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
      if ((paramaysy.jdField_b_of_type_Int == 0) && ((paramaysy instanceof ayrx)))
      {
        localObject2 = (ayrx)paramaysy;
        ((ayrx)localObject2).jdField_a_of_type_Aysz = new aysz((aysy)localObject2);
        localObject3 = new aytc(this);
        ((ayrx)localObject2).jdField_a_of_type_JavaLangObject = localObject3;
        ((aytc)localObject3).jdField_a_of_type_Ayrx = ((ayrx)localObject2);
        ((aytc)localObject3).jdField_a_of_type_Aysz = ((ayrx)localObject2).jdField_a_of_type_Aysz;
        if (i == 0) {
          ((aytc)localObject3).b();
        }
        if ((paramaysy.jdField_a_of_type_Aysz.jdField_a_of_type_Int == 2) && (!((aytc)localObject3).jdField_b_of_type_Boolean)) {
          break label204;
        }
        aytc.a((aytc)localObject3);
      }
      do
      {
        return;
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.OldHttpEngine", 2, "sendReq:" + paramaysy + " _id:" + paramaysy.jdField_e_of_type_JavaLangString + " isDownloading _key:" + (String)localObject1);
          }
          paramaysy.jdField_a_of_type_Aysz.jdField_a_of_type_Int = 3;
          aytc.a((aytc)localObject3);
          return;
        }
        c(paramaysy);
        return;
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("req:").append(paramaysy).append(" callback:");
      if (paramaysy == null) {}
      for (paramaysy = (aysy)localObject1;; paramaysy = paramaysy.jdField_a_of_type_Aysc)
      {
        QLog.e("Q.richmedia.OldHttpEngine", 2, paramaysy);
        return;
      }
    }
  }
  
  public void a(bbmu parambbmu)
  {
    if ((parambbmu != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(parambbmu);
    }
  }
  
  public void b(aysy paramaysy)
  {
    if (paramaysy == null) {}
    do
    {
      return;
      if (paramaysy.jdField_f_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaysy.jdField_f_of_type_JavaLangString);
      }
    } while (!aytc.class.isInstance(paramaysy.jdField_a_of_type_JavaLangObject));
    Object localObject = (ayrx)paramaysy;
    int i = paramaysy.g;
    if (((ayrx)localObject).jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ayuk.a(i, bool, paramaysy.jdField_f_of_type_Int, paramaysy.jdField_e_of_type_JavaLangString, "cancelReq", "");
      localObject = (aytc)paramaysy.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((aytc)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((aytc)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      bbmu localbbmu = ((aytc)localObject).jdField_a_of_type_Bbmu;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localbbmu);
      }
      ((aytc)localObject).a(paramaysy);
      ((aytc)localObject).a();
      return;
    }
  }
  
  public void c(aysy paramaysy)
  {
    aytc localaytc;
    do
    {
      try
      {
        bbmu localbbmu1 = a(paramaysy);
        localaytc = (aytc)paramaysy.jdField_a_of_type_JavaLangObject;
        if ((localbbmu1 != null) && (localaytc != null))
        {
          aysz localaysz = paramaysy.jdField_a_of_type_Aysz;
          localaysz.d += 1;
          localaytc.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            a(localbbmu1);
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
            bbmu localbbmu2 = a(paramaysy);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            Object localObject = null;
          }
        }
        paramaysy = paramaysy.jdField_a_of_type_Aysz;
        paramaysy.jdField_b_of_type_Int = 9366;
        paramaysy.jdField_a_of_type_JavaLangString = "oldengine close";
        paramaysy.jdField_a_of_type_Int = 1;
        aytc.a(localaytc);
        return;
      }
    } while ((localaytc == null) || (localaytc.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    paramaysy = paramaysy.jdField_a_of_type_Aysz;
    paramaysy.jdField_b_of_type_Int = 9369;
    paramaysy.jdField_a_of_type_JavaLangString = "Out of memory";
    paramaysy.jdField_a_of_type_Int = 1;
    aytc.a(localaytc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aytb
 * JD-Core Version:    0.7.0.1
 */