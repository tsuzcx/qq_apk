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

public class baqy
  implements bapv
{
  private static volatile int jdField_a_of_type_Int = -1;
  HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  public baqy() {}
  
  public baqy(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramHttpCommunicator;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private bdlo a(baqv parambaqv)
  {
    if (parambaqv == null) {
      return null;
    }
    baps localbaps;
    baqz localbaqz;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((parambaqv.jdField_b_of_type_Int == 0) && ((parambaqv instanceof baps)))
    {
      localbaps = (baps)parambaqv;
      localbaqz = (baqz)localbaps.jdField_a_of_type_JavaLangObject;
      if ((localbaqz == null) || (localbaqz.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
      localObject1 = localbaps.jdField_a_of_type_JavaLangString;
      if ((!localbaps.jdField_a_of_type_Boolean) || (localbaps.jdField_a_of_type_JavaLangString == null) || (localbaps.jdField_a_of_type_JavaLangString.startsWith("https"))) {
        break label694;
      }
      localObject3 = bavf.a(localbaps.jdField_a_of_type_JavaLangString);
      localObject2 = bavf.a().a((String)localObject3, 1002);
      localObject2 = bavf.a(localbaps.jdField_a_of_type_JavaLangString, (String)localObject2);
      if ((localObject2 == null) || (((String)localObject2).equals(localbaps.jdField_a_of_type_JavaLangString))) {
        break label694;
      }
      if (!bdje.a((String)localObject3)) {
        parambaqv.jdField_a_of_type_JavaUtilHashMap.put("host", localObject3);
      }
      localbaps.jdField_b_of_type_Boolean = true;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "NeedIpConnect url=" + localbaps.jdField_a_of_type_JavaLangString + " ipUrl=" + (String)localObject2);
        localObject1 = localObject2;
      }
    }
    label694:
    for (;;)
    {
      localObject2 = new bdlo((String)localObject1, localbaps.jdField_a_of_type_ArrayOfByte, localbaqz);
      if (localbaps.jdField_a_of_type_Int == 0) {}
      for (localObject1 = "GET";; localObject1 = "POST")
      {
        ((bdlo)localObject2).b((String)localObject1);
        localObject1 = localbaps.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          ((bdlo)localObject2).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
        }
      }
      ((bdlo)localObject2).j = localbaps.f;
      ((bdlo)localObject2).jdField_e_of_type_JavaLangString = localbaps.jdField_b_of_type_JavaLangString;
      ((bdlo)localObject2).k = localbaps.g;
      ((bdlo)localObject2).l = localbaps.jdField_h_of_type_Boolean;
      ((bdlo)localObject2).jdField_h_of_type_Boolean = localbaps.jdField_b_of_type_Boolean;
      ((bdlo)localObject2).jdField_c_of_type_Boolean = localbaps.jdField_c_of_type_Boolean;
      ((bdlo)localObject2).jdField_a_of_type_JavaLangString = parambaqv.jdField_e_of_type_JavaLangString;
      ((bdlo)localObject2).jdField_c_of_type_Int = parambaqv.g;
      ((bdlo)localObject2).jdField_b_of_type_Int = parambaqv.jdField_f_of_type_Int;
      ((bdlo)localObject2).jdField_a_of_type_Bash = localbaps.jdField_a_of_type_Bash;
      ((bdlo)localObject2).jdField_a_of_type_ArrayOfJavaLangString = localbaps.jdField_a_of_type_ArrayOfJavaLangString;
      ((bdlo)localObject2).jdField_e_of_type_Boolean = localbaps.o;
      ((bdlo)localObject2).d = parambaqv.l;
      ((bdlo)localObject2).i = localbaps.jdField_e_of_type_Boolean;
      if (jdField_a_of_type_Int == -1) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (parambaqv.jdField_e_of_type_Int == 1)
        {
          ((bdlo)localObject2).jdField_a_of_type_Int = 201;
          label507:
          if ((localbaps.jdField_a_of_type_JavaIoOutputStream != null) || (localbaps.jdField_c_of_type_JavaLangString != null)) {
            ((bdlo)localObject2).a(true);
          }
          localbaqz.jdField_a_of_type_Bdlo = ((bdlo)localObject2);
        }
        try
        {
          parambaqv = new URL(((bdlo)localObject2).a());
          localObject1 = localbaps.jdField_a_of_type_Baqw;
          ((baqw)localObject1).jdField_a_of_type_JavaUtilHashMap.put("serverip", parambaqv.getHost());
          ((baqw)localObject1).jdField_a_of_type_JavaUtilHashMap.put("param_url", ((bdlo)localObject2).a());
          return localObject2;
          if (localbaps.d)
          {
            ((bdlo)localObject2).jdField_h_of_type_Int = jdField_a_of_type_Int;
            continue;
            ((bdlo)localObject2).jdField_h_of_type_Int = (jdField_a_of_type_Int / 4);
            continue;
            if (parambaqv.jdField_e_of_type_Int == 2)
            {
              ((bdlo)localObject2).jdField_a_of_type_Int = 202;
              break label507;
            }
            if (parambaqv.jdField_e_of_type_Int != 0) {
              break label507;
            }
            ((bdlo)localObject2).jdField_a_of_type_Int = 200;
          }
        }
        catch (Exception parambaqv)
        {
          for (;;)
          {
            parambaqv.printStackTrace();
          }
        }
      }
      if (parambaqv.jdField_a_of_type_Bapx != null)
      {
        parambaqv.jdField_a_of_type_Baqw.a(1, 9302, "not support by HttpOldEngine", null);
        parambaqv.jdField_a_of_type_Bapx.onResp(parambaqv.jdField_a_of_type_Baqw);
      }
      return null;
    }
  }
  
  private boolean a(bdlo parambdlo, baps parambaps)
  {
    boolean bool = parambdlo.c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "404:" + bool + " ip:" + parambaps.jdField_b_of_type_Boolean);
    }
    return (bool) && (parambaps.jdField_b_of_type_Boolean);
  }
  
  private static String b(baqv parambaqv, String paramString1, String paramString2)
  {
    if ((parambaqv != null) && (parambaqv.d != null) && (parambaqv.d.length() > 0)) {
      return parambaqv.d;
    }
    return paramString1 + "." + MD5.toMD5(basj.a(paramString2, false)) + ".tmp";
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
  
  public void a(baqv parambaqv)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    Object localObject3;
    if ((parambaqv != null) && (parambaqv.jdField_a_of_type_Bapx != null))
    {
      j = 0;
      localObject1 = localObject2;
      i = j;
      if ((parambaqv instanceof baps))
      {
        localObject3 = (baps)parambaqv;
        localObject1 = localObject2;
        i = j;
        if (((baps)localObject3).jdField_a_of_type_Int == 0)
        {
          localObject1 = localObject2;
          i = j;
          if (parambaqv.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = b(parambaqv, parambaqv.jdField_c_of_type_JavaLangString, ((baps)localObject3).jdField_a_of_type_JavaLangString);
            parambaqv.jdField_f_of_type_JavaLangString = ((String)localObject1);
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
      if ((parambaqv.jdField_b_of_type_Int == 0) && ((parambaqv instanceof baps)))
      {
        localObject2 = (baps)parambaqv;
        ((baps)localObject2).jdField_a_of_type_Baqw = new baqw((baqv)localObject2);
        localObject3 = new baqz(this);
        ((baps)localObject2).jdField_a_of_type_JavaLangObject = localObject3;
        ((baqz)localObject3).jdField_a_of_type_Baps = ((baps)localObject2);
        ((baqz)localObject3).jdField_a_of_type_Baqw = ((baps)localObject2).jdField_a_of_type_Baqw;
        if (i == 0) {
          ((baqz)localObject3).b();
        }
        if ((parambaqv.jdField_a_of_type_Baqw.jdField_a_of_type_Int == 2) && (!((baqz)localObject3).jdField_b_of_type_Boolean)) {
          break label204;
        }
        baqz.a((baqz)localObject3);
      }
      do
      {
        return;
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.OldHttpEngine", 2, "sendReq:" + parambaqv + " _id:" + parambaqv.jdField_e_of_type_JavaLangString + " isDownloading _key:" + (String)localObject1);
          }
          parambaqv.jdField_a_of_type_Baqw.jdField_a_of_type_Int = 3;
          baqz.a((baqz)localObject3);
          return;
        }
        c(parambaqv);
        return;
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("req:").append(parambaqv).append(" callback:");
      if (parambaqv == null) {}
      for (parambaqv = (baqv)localObject1;; parambaqv = parambaqv.jdField_a_of_type_Bapx)
      {
        QLog.e("Q.richmedia.OldHttpEngine", 2, parambaqv);
        return;
      }
    }
  }
  
  public void a(bdlo parambdlo)
  {
    if ((parambdlo != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(parambdlo);
    }
  }
  
  public void b(baqv parambaqv)
  {
    if (parambaqv == null) {}
    do
    {
      return;
      if (parambaqv.jdField_f_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambaqv.jdField_f_of_type_JavaLangString);
      }
    } while (!baqz.class.isInstance(parambaqv.jdField_a_of_type_JavaLangObject));
    Object localObject = (baps)parambaqv;
    int i = parambaqv.g;
    if (((baps)localObject).jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      basj.a(i, bool, parambaqv.jdField_f_of_type_Int, parambaqv.jdField_e_of_type_JavaLangString, "cancelReq", "");
      localObject = (baqz)parambaqv.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((baqz)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((baqz)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      bdlo localbdlo = ((baqz)localObject).jdField_a_of_type_Bdlo;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localbdlo);
      }
      ((baqz)localObject).a(parambaqv);
      ((baqz)localObject).a();
      return;
    }
  }
  
  public void c(baqv parambaqv)
  {
    baqz localbaqz;
    do
    {
      try
      {
        bdlo localbdlo1 = a(parambaqv);
        localbaqz = (baqz)parambaqv.jdField_a_of_type_JavaLangObject;
        if ((localbdlo1 != null) && (localbaqz != null))
        {
          baqw localbaqw = parambaqv.jdField_a_of_type_Baqw;
          localbaqw.d += 1;
          localbaqz.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            a(localbdlo1);
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
            bdlo localbdlo2 = a(parambaqv);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            Object localObject = null;
          }
        }
        parambaqv = parambaqv.jdField_a_of_type_Baqw;
        parambaqv.jdField_b_of_type_Int = 9366;
        parambaqv.jdField_a_of_type_JavaLangString = "oldengine close";
        parambaqv.jdField_a_of_type_Int = 1;
        baqz.a(localbaqz);
        return;
      }
    } while ((localbaqz == null) || (localbaqz.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    parambaqv = parambaqv.jdField_a_of_type_Baqw;
    parambaqv.jdField_b_of_type_Int = 9369;
    parambaqv.jdField_a_of_type_JavaLangString = "Out of memory";
    parambaqv.jdField_a_of_type_Int = 1;
    baqz.a(localbaqz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqy
 * JD-Core Version:    0.7.0.1
 */