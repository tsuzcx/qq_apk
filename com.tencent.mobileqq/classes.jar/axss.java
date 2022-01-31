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

public class axss
  implements axrr
{
  private static volatile int jdField_a_of_type_Int = -1;
  HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  public axss(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramHttpCommunicator;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private bakw a(axsp paramaxsp)
  {
    if (paramaxsp == null) {
      return null;
    }
    axro localaxro;
    axst localaxst;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((paramaxsp.jdField_b_of_type_Int == 0) && ((paramaxsp instanceof axro)))
    {
      localaxro = (axro)paramaxsp;
      localaxst = (axst)localaxro.jdField_a_of_type_JavaLangObject;
      if ((localaxst == null) || (localaxst.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
      localObject1 = localaxro.jdField_a_of_type_JavaLangString;
      if ((!localaxro.jdField_a_of_type_Boolean) || (localaxro.jdField_a_of_type_JavaLangString == null) || (localaxro.jdField_a_of_type_JavaLangString.startsWith("https"))) {
        break label694;
      }
      localObject3 = axwx.a(localaxro.jdField_a_of_type_JavaLangString);
      localObject2 = axwx.a().a((String)localObject3, 1002);
      localObject2 = axwx.a(localaxro.jdField_a_of_type_JavaLangString, (String)localObject2);
      if ((localObject2 == null) || (((String)localObject2).equals(localaxro.jdField_a_of_type_JavaLangString))) {
        break label694;
      }
      if (!baip.a((String)localObject3)) {
        paramaxsp.jdField_a_of_type_JavaUtilHashMap.put("host", localObject3);
      }
      localaxro.jdField_b_of_type_Boolean = true;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "NeedIpConnect url=" + localaxro.jdField_a_of_type_JavaLangString + " ipUrl=" + (String)localObject2);
        localObject1 = localObject2;
      }
    }
    label694:
    for (;;)
    {
      localObject2 = new bakw((String)localObject1, localaxro.jdField_a_of_type_ArrayOfByte, localaxst);
      if (localaxro.jdField_a_of_type_Int == 0) {}
      for (localObject1 = "GET";; localObject1 = "POST")
      {
        ((bakw)localObject2).b((String)localObject1);
        localObject1 = localaxro.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          ((bakw)localObject2).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
        }
      }
      ((bakw)localObject2).j = localaxro.f;
      ((bakw)localObject2).jdField_e_of_type_JavaLangString = localaxro.jdField_b_of_type_JavaLangString;
      ((bakw)localObject2).k = localaxro.g;
      ((bakw)localObject2).l = localaxro.jdField_h_of_type_Boolean;
      ((bakw)localObject2).jdField_h_of_type_Boolean = localaxro.jdField_b_of_type_Boolean;
      ((bakw)localObject2).jdField_c_of_type_Boolean = localaxro.jdField_c_of_type_Boolean;
      ((bakw)localObject2).jdField_a_of_type_JavaLangString = paramaxsp.jdField_e_of_type_JavaLangString;
      ((bakw)localObject2).jdField_c_of_type_Int = paramaxsp.g;
      ((bakw)localObject2).jdField_b_of_type_Int = paramaxsp.jdField_f_of_type_Int;
      ((bakw)localObject2).jdField_a_of_type_Axtz = localaxro.jdField_a_of_type_Axtz;
      ((bakw)localObject2).jdField_a_of_type_ArrayOfJavaLangString = localaxro.jdField_a_of_type_ArrayOfJavaLangString;
      ((bakw)localObject2).jdField_e_of_type_Boolean = localaxro.o;
      ((bakw)localObject2).d = paramaxsp.l;
      ((bakw)localObject2).i = localaxro.jdField_e_of_type_Boolean;
      if (jdField_a_of_type_Int == -1) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (paramaxsp.jdField_e_of_type_Int == 1)
        {
          ((bakw)localObject2).jdField_a_of_type_Int = 201;
          label507:
          if ((localaxro.jdField_a_of_type_JavaIoOutputStream != null) || (localaxro.jdField_c_of_type_JavaLangString != null)) {
            ((bakw)localObject2).a(true);
          }
          localaxst.jdField_a_of_type_Bakw = ((bakw)localObject2);
        }
        try
        {
          paramaxsp = new URL(((bakw)localObject2).a());
          localObject1 = localaxro.jdField_a_of_type_Axsq;
          ((axsq)localObject1).jdField_a_of_type_JavaUtilHashMap.put("serverip", paramaxsp.getHost());
          ((axsq)localObject1).jdField_a_of_type_JavaUtilHashMap.put("param_url", ((bakw)localObject2).a());
          return localObject2;
          if (localaxro.d)
          {
            ((bakw)localObject2).jdField_h_of_type_Int = jdField_a_of_type_Int;
            continue;
            ((bakw)localObject2).jdField_h_of_type_Int = (jdField_a_of_type_Int / 4);
            continue;
            if (paramaxsp.jdField_e_of_type_Int == 2)
            {
              ((bakw)localObject2).jdField_a_of_type_Int = 202;
              break label507;
            }
            if (paramaxsp.jdField_e_of_type_Int != 0) {
              break label507;
            }
            ((bakw)localObject2).jdField_a_of_type_Int = 200;
          }
        }
        catch (Exception paramaxsp)
        {
          for (;;)
          {
            paramaxsp.printStackTrace();
          }
        }
      }
      if (paramaxsp.jdField_a_of_type_Axrt != null)
      {
        paramaxsp.jdField_a_of_type_Axsq.a(1, 9302, "not support by HttpOldEngine", null);
        paramaxsp.jdField_a_of_type_Axrt.onResp(paramaxsp.jdField_a_of_type_Axsq);
      }
      return null;
    }
  }
  
  private boolean a(bakw parambakw, axro paramaxro)
  {
    boolean bool = parambakw.c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "404:" + bool + " ip:" + paramaxro.jdField_b_of_type_Boolean);
    }
    return (bool) && (paramaxro.jdField_b_of_type_Boolean);
  }
  
  private static String b(axsp paramaxsp, String paramString1, String paramString2)
  {
    if ((paramaxsp != null) && (paramaxsp.d != null) && (paramaxsp.d.length() > 0)) {
      return paramaxsp.d;
    }
    return paramString1 + "." + MD5.toMD5(axub.a(paramString2, false)) + ".tmp";
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
  
  public void a(axsp paramaxsp)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    Object localObject3;
    if ((paramaxsp != null) && (paramaxsp.jdField_a_of_type_Axrt != null))
    {
      j = 0;
      localObject1 = localObject2;
      i = j;
      if ((paramaxsp instanceof axro))
      {
        localObject3 = (axro)paramaxsp;
        localObject1 = localObject2;
        i = j;
        if (((axro)localObject3).jdField_a_of_type_Int == 0)
        {
          localObject1 = localObject2;
          i = j;
          if (paramaxsp.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = b(paramaxsp, paramaxsp.jdField_c_of_type_JavaLangString, ((axro)localObject3).jdField_a_of_type_JavaLangString);
            paramaxsp.jdField_f_of_type_JavaLangString = ((String)localObject1);
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
      if ((paramaxsp.jdField_b_of_type_Int == 0) && ((paramaxsp instanceof axro)))
      {
        localObject2 = (axro)paramaxsp;
        ((axro)localObject2).jdField_a_of_type_Axsq = new axsq((axsp)localObject2);
        localObject3 = new axst(this);
        ((axro)localObject2).jdField_a_of_type_JavaLangObject = localObject3;
        ((axst)localObject3).jdField_a_of_type_Axro = ((axro)localObject2);
        ((axst)localObject3).jdField_a_of_type_Axsq = ((axro)localObject2).jdField_a_of_type_Axsq;
        if (i == 0) {
          ((axst)localObject3).b();
        }
        if ((paramaxsp.jdField_a_of_type_Axsq.jdField_a_of_type_Int == 2) && (!((axst)localObject3).jdField_b_of_type_Boolean)) {
          break label204;
        }
        axst.a((axst)localObject3);
      }
      do
      {
        return;
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.OldHttpEngine", 2, "sendReq:" + paramaxsp + " _id:" + paramaxsp.jdField_e_of_type_JavaLangString + " isDownloading _key:" + (String)localObject1);
          }
          paramaxsp.jdField_a_of_type_Axsq.jdField_a_of_type_Int = 3;
          axst.a((axst)localObject3);
          return;
        }
        c(paramaxsp);
        return;
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("req:").append(paramaxsp).append(" callback:");
      if (paramaxsp == null) {}
      for (paramaxsp = (axsp)localObject1;; paramaxsp = paramaxsp.jdField_a_of_type_Axrt)
      {
        QLog.e("Q.richmedia.OldHttpEngine", 2, paramaxsp);
        return;
      }
    }
  }
  
  public void a(bakw parambakw)
  {
    if ((parambakw != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(parambakw);
    }
  }
  
  public void b(axsp paramaxsp)
  {
    if (paramaxsp == null) {}
    do
    {
      return;
      if (paramaxsp.jdField_f_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaxsp.jdField_f_of_type_JavaLangString);
      }
    } while (!axst.class.isInstance(paramaxsp.jdField_a_of_type_JavaLangObject));
    Object localObject = (axro)paramaxsp;
    int i = paramaxsp.g;
    if (((axro)localObject).jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      axub.a(i, bool, paramaxsp.jdField_f_of_type_Int, paramaxsp.jdField_e_of_type_JavaLangString, "cancelReq", "");
      localObject = (axst)paramaxsp.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((axst)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((axst)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      bakw localbakw = ((axst)localObject).jdField_a_of_type_Bakw;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localbakw);
      }
      ((axst)localObject).a(paramaxsp);
      ((axst)localObject).a();
      return;
    }
  }
  
  public void c(axsp paramaxsp)
  {
    axst localaxst;
    do
    {
      try
      {
        bakw localbakw1 = a(paramaxsp);
        localaxst = (axst)paramaxsp.jdField_a_of_type_JavaLangObject;
        if ((localbakw1 != null) && (localaxst != null))
        {
          axsq localaxsq = paramaxsp.jdField_a_of_type_Axsq;
          localaxsq.d += 1;
          localaxst.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            a(localbakw1);
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
            bakw localbakw2 = a(paramaxsp);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            Object localObject = null;
          }
        }
        paramaxsp = paramaxsp.jdField_a_of_type_Axsq;
        paramaxsp.jdField_b_of_type_Int = 9366;
        paramaxsp.jdField_a_of_type_JavaLangString = "oldengine close";
        paramaxsp.jdField_a_of_type_Int = 1;
        axst.a(localaxst);
        return;
      }
    } while ((localaxst == null) || (localaxst.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    paramaxsp = paramaxsp.jdField_a_of_type_Axsq;
    paramaxsp.jdField_b_of_type_Int = 9369;
    paramaxsp.jdField_a_of_type_JavaLangString = "Out of memory";
    paramaxsp.jdField_a_of_type_Int = 1;
    axst.a(localaxst);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axss
 * JD-Core Version:    0.7.0.1
 */