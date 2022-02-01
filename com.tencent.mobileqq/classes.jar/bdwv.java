import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class bdwv
  implements bdvu
{
  private static volatile int jdField_a_of_type_Int = -1;
  bgut jdField_a_of_type_Bgut;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  public bdwv() {}
  
  public bdwv(bgut parambgut, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_Bgut = parambgut;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static bdwt a(bdws parambdws)
  {
    return new bdwv(new bgut(), true).b(parambdws);
  }
  
  private bgux a(bdws parambdws)
  {
    if (parambdws == null) {
      return null;
    }
    if ((parambdws instanceof bdvs))
    {
      bdvs localbdvs = (bdvs)parambdws;
      bdww localbdww = (bdww)localbdvs.jdField_a_of_type_JavaLangObject;
      if ((localbdww == null) || (localbdww.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
      bgux localbgux = new bgux(localbdvs.jdField_a_of_type_JavaLangString, localbdvs.jdField_a_of_type_ArrayOfByte, localbdww);
      if (localbdvs.jdField_a_of_type_Int == 0) {}
      for (Object localObject = "GET";; localObject = "POST")
      {
        localbgux.b((String)localObject);
        localObject = localbdvs.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localbgux.a((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      localbgux.i = localbdvs.f;
      localbgux.jdField_e_of_type_JavaLangString = localbdvs.jdField_b_of_type_JavaLangString;
      localbgux.j = localbdvs.g;
      localbgux.k = localbdvs.jdField_h_of_type_Boolean;
      localbgux.g = localbdvs.jdField_b_of_type_Boolean;
      localbgux.jdField_b_of_type_Boolean = localbdvs.jdField_c_of_type_Boolean;
      localbgux.jdField_a_of_type_JavaLangString = parambdws.jdField_e_of_type_JavaLangString;
      localbgux.jdField_c_of_type_Int = parambdws.jdField_f_of_type_Int;
      localbgux.jdField_b_of_type_Int = parambdws.jdField_e_of_type_Int;
      localbgux.jdField_a_of_type_Bdxx = localbdvs.jdField_a_of_type_Bdxx;
      localbgux.jdField_a_of_type_ArrayOfJavaLangString = localbdvs.jdField_a_of_type_ArrayOfJavaLangString;
      localbgux.d = localbdvs.o;
      localbgux.jdField_c_of_type_Boolean = parambdws.m;
      localbgux.jdField_h_of_type_Boolean = localbdvs.e;
      if (jdField_a_of_type_Int == -1) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (parambdws.jdField_d_of_type_Int == 1)
        {
          localbgux.jdField_a_of_type_Int = 201;
          label347:
          if ((localbdvs.jdField_a_of_type_JavaIoOutputStream != null) || (localbdvs.jdField_c_of_type_JavaLangString != null)) {
            localbgux.a(true);
          }
          localbdww.jdField_a_of_type_Bgux = localbgux;
        }
        try
        {
          parambdws = new URL(localbgux.a());
          localObject = localbdvs.jdField_a_of_type_Bdwt;
          ((bdwt)localObject).jdField_a_of_type_JavaUtilHashMap.put("serverip", parambdws.getHost());
          ((bdwt)localObject).jdField_a_of_type_JavaUtilHashMap.put("param_url", localbgux.a());
          return localbgux;
          if (localbdvs.d)
          {
            localbgux.jdField_h_of_type_Int = jdField_a_of_type_Int;
            continue;
            localbgux.jdField_h_of_type_Int = (jdField_a_of_type_Int / 4);
            continue;
            if (parambdws.jdField_d_of_type_Int == 2)
            {
              localbgux.jdField_a_of_type_Int = 202;
              break label347;
            }
            if (parambdws.jdField_d_of_type_Int != 0) {
              break label347;
            }
            localbgux.jdField_a_of_type_Int = 200;
          }
        }
        catch (Exception parambdws)
        {
          for (;;)
          {
            parambdws.printStackTrace();
          }
        }
      }
    }
    if (parambdws.jdField_a_of_type_Bdvw != null)
    {
      parambdws.jdField_a_of_type_Bdwt.a(1, 9302, "not support by HttpOldEngine", null);
      parambdws.jdField_a_of_type_Bdvw.onResp(parambdws.jdField_a_of_type_Bdwt);
    }
    return null;
  }
  
  private void a(bdvs parambdvs)
  {
    if ((parambdvs.jdField_a_of_type_Boolean) && (parambdvs.jdField_a_of_type_JavaUtilList == null) && (parambdvs.jdField_a_of_type_JavaLangString != null) && (!parambdvs.jdField_a_of_type_JavaLangString.startsWith("https")))
    {
      String str = InnerDns.getHostFromUrl(parambdvs.jdField_a_of_type_JavaLangString);
      int i = InnerDns.getPortFromUrl(parambdvs.jdField_a_of_type_JavaLangString);
      if (str != null)
      {
        ArrayList localArrayList = InnerDns.getInstance().reqSerAddrList(str, 1002);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          Object localObject = ((bdyf)localArrayList.get(0)).a(parambdvs.jdField_a_of_type_JavaLangString);
          parambdvs.jdField_a_of_type_JavaLangString = bdxz.a(parambdvs.jdField_a_of_type_JavaLangString, (String)localObject);
          localObject = new bdyf();
          ((bdyf)localObject).jdField_a_of_type_JavaLangString = str;
          if (i != -1) {
            ((bdyf)localObject).jdField_a_of_type_Int = i;
          }
          ((bdyf)localObject).jdField_b_of_type_Boolean = true;
          localArrayList.add(localObject);
          parambdvs.jdField_a_of_type_JavaUtilList = localArrayList;
          parambdvs.jdField_b_of_type_Boolean = false;
          parambdvs.g = true;
          parambdvs.jdField_b_of_type_JavaLangString = str;
          parambdvs.jdField_a_of_type_JavaUtilHashMap.put("host", str);
        }
      }
    }
  }
  
  private static String b(bdws parambdws, String paramString1, String paramString2)
  {
    if ((parambdws != null) && (parambdws.jdField_d_of_type_JavaLangString != null) && (parambdws.jdField_d_of_type_JavaLangString.length() > 0)) {
      return parambdws.jdField_d_of_type_JavaLangString;
    }
    return paramString1 + "." + MD5.toMD5(bdxz.a(paramString2, false)) + ".tmp";
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bgut != null)) {
        this.jdField_a_of_type_Bgut.b();
      }
      this.jdField_a_of_type_Bgut = null;
    }
  }
  
  public void a(bdws parambdws)
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    int i;
    if ((parambdws != null) && (parambdws.jdField_a_of_type_Bdvw != null) && ((parambdws instanceof bdvs)))
    {
      localObject2 = null;
      localObject3 = (bdvs)parambdws;
      localObject1 = localObject2;
      if (((bdvs)localObject3).jdField_a_of_type_Int != 0) {
        break label276;
      }
      localObject1 = localObject2;
      if (parambdws.jdField_c_of_type_JavaLangString == null) {
        break label276;
      }
      localObject2 = b(parambdws, parambdws.jdField_c_of_type_JavaLangString, ((bdvs)localObject3).jdField_a_of_type_JavaLangString);
      parambdws.jdField_f_of_type_JavaLangString = ((String)localObject2);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(localObject2, localObject2) == null) {
        break label276;
      }
      i = 1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      a((bdvs)localObject3);
      ((bdvs)localObject3).jdField_a_of_type_Bdwt = new bdwt((bdws)localObject3);
      bdww localbdww = new bdww(this);
      ((bdvs)localObject3).jdField_a_of_type_JavaLangObject = localbdww;
      localbdww.jdField_a_of_type_Bdvs = ((bdvs)localObject3);
      localbdww.jdField_a_of_type_Bdwt = ((bdvs)localObject3).jdField_a_of_type_Bdwt;
      if (i == 0) {
        localbdww.b();
      }
      if ((parambdws.jdField_a_of_type_Bdwt.jdField_a_of_type_Int != 2) || (localbdww.jdField_b_of_type_Boolean))
      {
        bdww.a(localbdww);
        return;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("sendReq:").append(parambdws).append(" _id:").append(parambdws.jdField_e_of_type_JavaLangString).append(" isDownloading key:");
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          QLog.e("Q.richmedia.OldHttpEngine", 2, (String)localObject2);
        }
        parambdws.jdField_a_of_type_Bdwt.jdField_a_of_type_Int = 3;
        bdww.a(localbdww);
        return;
      }
      a(parambdws, false);
      return;
      label276:
      i = 0;
    }
  }
  
  public void a(bdws parambdws, boolean paramBoolean)
  {
    bdww localbdww;
    do
    {
      try
      {
        bgux localbgux1 = a(parambdws);
        localbdww = (bdww)parambdws.jdField_a_of_type_JavaLangObject;
        if ((localbgux1 != null) && (localbdww != null))
        {
          localbgux1.l = paramBoolean;
          bdwt localbdwt = parambdws.jdField_a_of_type_Bdwt;
          localbdwt.jdField_d_of_type_Int += 1;
          localbdww.jdField_b_of_type_Int = 0;
          if (paramBoolean)
          {
            b(localbgux1);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        bgux localbgux3;
        for (;;)
        {
          System.gc();
          try
          {
            bgux localbgux2 = a(parambdws);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            localbgux3 = null;
          }
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          a(localbgux3);
          return;
        }
        parambdws = parambdws.jdField_a_of_type_Bdwt;
        parambdws.jdField_b_of_type_Int = 9366;
        parambdws.jdField_a_of_type_JavaLangString = "oldengine close";
        parambdws.jdField_a_of_type_Int = 1;
        bdww.a(localbdww);
        return;
      }
    } while ((localbdww == null) || (localbdww.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    parambdws = parambdws.jdField_a_of_type_Bdwt;
    parambdws.jdField_b_of_type_Int = 9369;
    parambdws.jdField_a_of_type_JavaLangString = "Out of memory";
    parambdws.jdField_a_of_type_Int = 1;
    bdww.a(localbdww);
  }
  
  public void a(bgux parambgux)
  {
    if ((parambgux != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Bgut != null)) {
      this.jdField_a_of_type_Bgut.a(parambgux);
    }
  }
  
  public bdwt b(bdws parambdws)
  {
    if ((parambdws != null) && ((parambdws instanceof bdvs)))
    {
      bdvs localbdvs = (bdvs)parambdws;
      localbdvs.i = true;
      a(localbdvs);
      localbdvs.jdField_a_of_type_Bdwt = new bdwt(localbdvs);
      bdww localbdww = new bdww(this);
      localbdvs.jdField_a_of_type_JavaLangObject = localbdww;
      localbdww.jdField_a_of_type_Bdvs = localbdvs;
      localbdww.jdField_a_of_type_Bdwt = localbdvs.jdField_a_of_type_Bdwt;
      localbdww.b();
      a(parambdws, true);
      return parambdws.jdField_a_of_type_Bdwt;
    }
    return null;
  }
  
  public void b(bdws parambdws)
  {
    if (parambdws == null) {}
    do
    {
      return;
      if (parambdws.jdField_f_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambdws.jdField_f_of_type_JavaLangString);
      }
    } while (!bdww.class.isInstance(parambdws.jdField_a_of_type_JavaLangObject));
    Object localObject = (bdvs)parambdws;
    int i = parambdws.jdField_f_of_type_Int;
    if (((bdvs)localObject).jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      bdxz.a(i, bool, parambdws.jdField_e_of_type_Int, parambdws.jdField_e_of_type_JavaLangString, "cancelReq", "");
      localObject = (bdww)parambdws.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((bdww)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((bdww)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      bgux localbgux = ((bdww)localObject).jdField_a_of_type_Bgux;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Bgut != null)) {
        this.jdField_a_of_type_Bgut.b(localbgux);
      }
      ((bdww)localObject).a(parambdws);
      ((bdww)localObject).a();
      return;
    }
  }
  
  public void b(bgux parambgux)
  {
    if ((parambgux != null) && (this.jdField_a_of_type_Bgut != null)) {
      this.jdField_a_of_type_Bgut.a(parambgux);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwv
 * JD-Core Version:    0.7.0.1
 */