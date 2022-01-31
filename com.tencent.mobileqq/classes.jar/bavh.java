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

public class bavh
  implements baue
{
  private static volatile int jdField_a_of_type_Int = -1;
  HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  public bavh() {}
  
  public bavh(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramHttpCommunicator;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private bdpx a(bave parambave)
  {
    if (parambave == null) {
      return null;
    }
    baub localbaub;
    bavi localbavi;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((parambave.jdField_b_of_type_Int == 0) && ((parambave instanceof baub)))
    {
      localbaub = (baub)parambave;
      localbavi = (bavi)localbaub.jdField_a_of_type_JavaLangObject;
      if ((localbavi == null) || (localbavi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
      localObject1 = localbaub.jdField_a_of_type_JavaLangString;
      if ((!localbaub.jdField_a_of_type_Boolean) || (localbaub.jdField_a_of_type_JavaLangString == null) || (localbaub.jdField_a_of_type_JavaLangString.startsWith("https"))) {
        break label694;
      }
      localObject3 = bazo.a(localbaub.jdField_a_of_type_JavaLangString);
      localObject2 = bazo.a().a((String)localObject3, 1002);
      localObject2 = bazo.a(localbaub.jdField_a_of_type_JavaLangString, (String)localObject2);
      if ((localObject2 == null) || (((String)localObject2).equals(localbaub.jdField_a_of_type_JavaLangString))) {
        break label694;
      }
      if (!bdnn.a((String)localObject3)) {
        parambave.jdField_a_of_type_JavaUtilHashMap.put("host", localObject3);
      }
      localbaub.jdField_b_of_type_Boolean = true;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "NeedIpConnect url=" + localbaub.jdField_a_of_type_JavaLangString + " ipUrl=" + (String)localObject2);
        localObject1 = localObject2;
      }
    }
    label694:
    for (;;)
    {
      localObject2 = new bdpx((String)localObject1, localbaub.jdField_a_of_type_ArrayOfByte, localbavi);
      if (localbaub.jdField_a_of_type_Int == 0) {}
      for (localObject1 = "GET";; localObject1 = "POST")
      {
        ((bdpx)localObject2).b((String)localObject1);
        localObject1 = localbaub.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          ((bdpx)localObject2).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
        }
      }
      ((bdpx)localObject2).j = localbaub.f;
      ((bdpx)localObject2).jdField_e_of_type_JavaLangString = localbaub.jdField_b_of_type_JavaLangString;
      ((bdpx)localObject2).k = localbaub.g;
      ((bdpx)localObject2).l = localbaub.jdField_h_of_type_Boolean;
      ((bdpx)localObject2).jdField_h_of_type_Boolean = localbaub.jdField_b_of_type_Boolean;
      ((bdpx)localObject2).jdField_c_of_type_Boolean = localbaub.jdField_c_of_type_Boolean;
      ((bdpx)localObject2).jdField_a_of_type_JavaLangString = parambave.jdField_e_of_type_JavaLangString;
      ((bdpx)localObject2).jdField_c_of_type_Int = parambave.g;
      ((bdpx)localObject2).jdField_b_of_type_Int = parambave.jdField_f_of_type_Int;
      ((bdpx)localObject2).jdField_a_of_type_Bawq = localbaub.jdField_a_of_type_Bawq;
      ((bdpx)localObject2).jdField_a_of_type_ArrayOfJavaLangString = localbaub.jdField_a_of_type_ArrayOfJavaLangString;
      ((bdpx)localObject2).jdField_e_of_type_Boolean = localbaub.o;
      ((bdpx)localObject2).d = parambave.l;
      ((bdpx)localObject2).i = localbaub.jdField_e_of_type_Boolean;
      if (jdField_a_of_type_Int == -1) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (parambave.jdField_e_of_type_Int == 1)
        {
          ((bdpx)localObject2).jdField_a_of_type_Int = 201;
          label507:
          if ((localbaub.jdField_a_of_type_JavaIoOutputStream != null) || (localbaub.jdField_c_of_type_JavaLangString != null)) {
            ((bdpx)localObject2).a(true);
          }
          localbavi.jdField_a_of_type_Bdpx = ((bdpx)localObject2);
        }
        try
        {
          parambave = new URL(((bdpx)localObject2).a());
          localObject1 = localbaub.jdField_a_of_type_Bavf;
          ((bavf)localObject1).jdField_a_of_type_JavaUtilHashMap.put("serverip", parambave.getHost());
          ((bavf)localObject1).jdField_a_of_type_JavaUtilHashMap.put("param_url", ((bdpx)localObject2).a());
          return localObject2;
          if (localbaub.d)
          {
            ((bdpx)localObject2).jdField_h_of_type_Int = jdField_a_of_type_Int;
            continue;
            ((bdpx)localObject2).jdField_h_of_type_Int = (jdField_a_of_type_Int / 4);
            continue;
            if (parambave.jdField_e_of_type_Int == 2)
            {
              ((bdpx)localObject2).jdField_a_of_type_Int = 202;
              break label507;
            }
            if (parambave.jdField_e_of_type_Int != 0) {
              break label507;
            }
            ((bdpx)localObject2).jdField_a_of_type_Int = 200;
          }
        }
        catch (Exception parambave)
        {
          for (;;)
          {
            parambave.printStackTrace();
          }
        }
      }
      if (parambave.jdField_a_of_type_Baug != null)
      {
        parambave.jdField_a_of_type_Bavf.a(1, 9302, "not support by HttpOldEngine", null);
        parambave.jdField_a_of_type_Baug.onResp(parambave.jdField_a_of_type_Bavf);
      }
      return null;
    }
  }
  
  private boolean a(bdpx parambdpx, baub parambaub)
  {
    boolean bool = parambdpx.c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "404:" + bool + " ip:" + parambaub.jdField_b_of_type_Boolean);
    }
    return (bool) && (parambaub.jdField_b_of_type_Boolean);
  }
  
  private static String b(bave parambave, String paramString1, String paramString2)
  {
    if ((parambave != null) && (parambave.d != null) && (parambave.d.length() > 0)) {
      return parambave.d;
    }
    return paramString1 + "." + MD5.toMD5(baws.a(paramString2, false)) + ".tmp";
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
  
  public void a(bave parambave)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    Object localObject3;
    if ((parambave != null) && (parambave.jdField_a_of_type_Baug != null))
    {
      j = 0;
      localObject1 = localObject2;
      i = j;
      if ((parambave instanceof baub))
      {
        localObject3 = (baub)parambave;
        localObject1 = localObject2;
        i = j;
        if (((baub)localObject3).jdField_a_of_type_Int == 0)
        {
          localObject1 = localObject2;
          i = j;
          if (parambave.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = b(parambave, parambave.jdField_c_of_type_JavaLangString, ((baub)localObject3).jdField_a_of_type_JavaLangString);
            parambave.jdField_f_of_type_JavaLangString = ((String)localObject1);
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
      if ((parambave.jdField_b_of_type_Int == 0) && ((parambave instanceof baub)))
      {
        localObject2 = (baub)parambave;
        ((baub)localObject2).jdField_a_of_type_Bavf = new bavf((bave)localObject2);
        localObject3 = new bavi(this);
        ((baub)localObject2).jdField_a_of_type_JavaLangObject = localObject3;
        ((bavi)localObject3).jdField_a_of_type_Baub = ((baub)localObject2);
        ((bavi)localObject3).jdField_a_of_type_Bavf = ((baub)localObject2).jdField_a_of_type_Bavf;
        if (i == 0) {
          ((bavi)localObject3).b();
        }
        if ((parambave.jdField_a_of_type_Bavf.jdField_a_of_type_Int == 2) && (!((bavi)localObject3).jdField_b_of_type_Boolean)) {
          break label204;
        }
        bavi.a((bavi)localObject3);
      }
      do
      {
        return;
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.OldHttpEngine", 2, "sendReq:" + parambave + " _id:" + parambave.jdField_e_of_type_JavaLangString + " isDownloading _key:" + (String)localObject1);
          }
          parambave.jdField_a_of_type_Bavf.jdField_a_of_type_Int = 3;
          bavi.a((bavi)localObject3);
          return;
        }
        c(parambave);
        return;
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("req:").append(parambave).append(" callback:");
      if (parambave == null) {}
      for (parambave = (bave)localObject1;; parambave = parambave.jdField_a_of_type_Baug)
      {
        QLog.e("Q.richmedia.OldHttpEngine", 2, parambave);
        return;
      }
    }
  }
  
  public void a(bdpx parambdpx)
  {
    if ((parambdpx != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(parambdpx);
    }
  }
  
  public void b(bave parambave)
  {
    if (parambave == null) {}
    do
    {
      return;
      if (parambave.jdField_f_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambave.jdField_f_of_type_JavaLangString);
      }
    } while (!bavi.class.isInstance(parambave.jdField_a_of_type_JavaLangObject));
    Object localObject = (baub)parambave;
    int i = parambave.g;
    if (((baub)localObject).jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      baws.a(i, bool, parambave.jdField_f_of_type_Int, parambave.jdField_e_of_type_JavaLangString, "cancelReq", "");
      localObject = (bavi)parambave.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((bavi)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((bavi)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      bdpx localbdpx = ((bavi)localObject).jdField_a_of_type_Bdpx;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localbdpx);
      }
      ((bavi)localObject).a(parambave);
      ((bavi)localObject).a();
      return;
    }
  }
  
  public void c(bave parambave)
  {
    bavi localbavi;
    do
    {
      try
      {
        bdpx localbdpx1 = a(parambave);
        localbavi = (bavi)parambave.jdField_a_of_type_JavaLangObject;
        if ((localbdpx1 != null) && (localbavi != null))
        {
          bavf localbavf = parambave.jdField_a_of_type_Bavf;
          localbavf.d += 1;
          localbavi.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            a(localbdpx1);
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
            bdpx localbdpx2 = a(parambave);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            Object localObject = null;
          }
        }
        parambave = parambave.jdField_a_of_type_Bavf;
        parambave.jdField_b_of_type_Int = 9366;
        parambave.jdField_a_of_type_JavaLangString = "oldengine close";
        parambave.jdField_a_of_type_Int = 1;
        bavi.a(localbavi);
        return;
      }
    } while ((localbavi == null) || (localbavi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    parambave = parambave.jdField_a_of_type_Bavf;
    parambave.jdField_b_of_type_Int = 9369;
    parambave.jdField_a_of_type_JavaLangString = "Out of memory";
    parambave.jdField_a_of_type_Int = 1;
    bavi.a(localbavi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavh
 * JD-Core Version:    0.7.0.1
 */