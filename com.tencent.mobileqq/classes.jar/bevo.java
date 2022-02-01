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

public class bevo
  implements beuo
{
  private static volatile int jdField_a_of_type_Int = -1;
  bhuw jdField_a_of_type_Bhuw;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  public bevo() {}
  
  public bevo(bhuw parambhuw, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_Bhuw = parambhuw;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static bevm a(bevl parambevl)
  {
    return new bevo(new bhuw(), true).b(parambevl);
  }
  
  private bhva a(bevl parambevl)
  {
    if (parambevl == null) {
      return null;
    }
    if ((parambevl instanceof beum))
    {
      beum localbeum = (beum)parambevl;
      bevp localbevp = (bevp)localbeum.jdField_a_of_type_JavaLangObject;
      if ((localbevp == null) || (localbevp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
      bhva localbhva = new bhva(localbeum.jdField_a_of_type_JavaLangString, localbeum.jdField_a_of_type_ArrayOfByte, localbevp);
      if (localbeum.jdField_a_of_type_Int == 0) {}
      for (Object localObject = "GET";; localObject = "POST")
      {
        localbhva.b((String)localObject);
        localObject = localbeum.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localbhva.a((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      localbhva.i = localbeum.f;
      localbhva.jdField_e_of_type_JavaLangString = localbeum.jdField_b_of_type_JavaLangString;
      localbhva.j = localbeum.g;
      localbhva.k = localbeum.jdField_h_of_type_Boolean;
      localbhva.g = localbeum.jdField_b_of_type_Boolean;
      localbhva.jdField_b_of_type_Boolean = localbeum.jdField_c_of_type_Boolean;
      localbhva.jdField_a_of_type_JavaLangString = parambevl.jdField_e_of_type_JavaLangString;
      localbhva.jdField_c_of_type_Int = parambevl.jdField_f_of_type_Int;
      localbhva.jdField_b_of_type_Int = parambevl.jdField_e_of_type_Int;
      localbhva.jdField_a_of_type_Bewq = localbeum.jdField_a_of_type_Bewq;
      localbhva.jdField_a_of_type_ArrayOfJavaLangString = localbeum.jdField_a_of_type_ArrayOfJavaLangString;
      localbhva.d = localbeum.o;
      localbhva.jdField_c_of_type_Boolean = parambevl.m;
      localbhva.jdField_h_of_type_Boolean = localbeum.e;
      if (jdField_a_of_type_Int == -1) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (parambevl.jdField_d_of_type_Int == 1)
        {
          localbhva.jdField_a_of_type_Int = 201;
          label347:
          if ((localbeum.jdField_a_of_type_JavaIoOutputStream != null) || (localbeum.jdField_c_of_type_JavaLangString != null)) {
            localbhva.a(true);
          }
          localbevp.jdField_a_of_type_Bhva = localbhva;
        }
        try
        {
          parambevl = new URL(localbhva.a());
          localObject = localbeum.jdField_a_of_type_Bevm;
          ((bevm)localObject).jdField_a_of_type_JavaUtilHashMap.put("serverip", parambevl.getHost());
          ((bevm)localObject).jdField_a_of_type_JavaUtilHashMap.put("param_url", localbhva.a());
          return localbhva;
          if (localbeum.d)
          {
            localbhva.jdField_h_of_type_Int = jdField_a_of_type_Int;
            continue;
            localbhva.jdField_h_of_type_Int = (jdField_a_of_type_Int / 4);
            continue;
            if (parambevl.jdField_d_of_type_Int == 2)
            {
              localbhva.jdField_a_of_type_Int = 202;
              break label347;
            }
            if (parambevl.jdField_d_of_type_Int != 0) {
              break label347;
            }
            localbhva.jdField_a_of_type_Int = 200;
          }
        }
        catch (Exception parambevl)
        {
          for (;;)
          {
            parambevl.printStackTrace();
          }
        }
      }
    }
    if (parambevl.jdField_a_of_type_Beuq != null)
    {
      parambevl.jdField_a_of_type_Bevm.a(1, 9302, "not support by HttpOldEngine", null);
      parambevl.jdField_a_of_type_Beuq.onResp(parambevl.jdField_a_of_type_Bevm);
    }
    return null;
  }
  
  private void a(beum parambeum)
  {
    if ((parambeum.jdField_a_of_type_Boolean) && (parambeum.jdField_a_of_type_JavaUtilList == null) && (parambeum.jdField_a_of_type_JavaLangString != null) && (!parambeum.jdField_a_of_type_JavaLangString.startsWith("https")))
    {
      String str = InnerDns.getHostFromUrl(parambeum.jdField_a_of_type_JavaLangString);
      int i = InnerDns.getPortFromUrl(parambeum.jdField_a_of_type_JavaLangString);
      if (str != null)
      {
        ArrayList localArrayList = InnerDns.getInstance().reqSerAddrList(str, 1002);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          Object localObject = ((bewy)localArrayList.get(0)).a(parambeum.jdField_a_of_type_JavaLangString);
          parambeum.jdField_a_of_type_JavaLangString = bews.a(parambeum.jdField_a_of_type_JavaLangString, (String)localObject);
          localObject = new bewy();
          ((bewy)localObject).jdField_a_of_type_JavaLangString = str;
          if (i != -1) {
            ((bewy)localObject).jdField_a_of_type_Int = i;
          }
          ((bewy)localObject).jdField_b_of_type_Boolean = true;
          localArrayList.add(localObject);
          parambeum.jdField_a_of_type_JavaUtilList = localArrayList;
          parambeum.jdField_b_of_type_Boolean = false;
          parambeum.g = true;
          parambeum.jdField_b_of_type_JavaLangString = str;
          parambeum.jdField_a_of_type_JavaUtilHashMap.put("host", str);
        }
      }
    }
  }
  
  private static String b(bevl parambevl, String paramString1, String paramString2)
  {
    if ((parambevl != null) && (parambevl.jdField_d_of_type_JavaLangString != null) && (parambevl.jdField_d_of_type_JavaLangString.length() > 0)) {
      return parambevl.jdField_d_of_type_JavaLangString;
    }
    return paramString1 + "." + MD5.toMD5(bews.a(paramString2, false)) + ".tmp";
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
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bhuw != null)) {
        this.jdField_a_of_type_Bhuw.b();
      }
      this.jdField_a_of_type_Bhuw = null;
    }
  }
  
  public void a(bevl parambevl)
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    int i;
    if ((parambevl != null) && (parambevl.jdField_a_of_type_Beuq != null) && ((parambevl instanceof beum)))
    {
      localObject2 = null;
      localObject3 = (beum)parambevl;
      localObject1 = localObject2;
      if (((beum)localObject3).jdField_a_of_type_Int != 0) {
        break label276;
      }
      localObject1 = localObject2;
      if (parambevl.jdField_c_of_type_JavaLangString == null) {
        break label276;
      }
      localObject2 = b(parambevl, parambevl.jdField_c_of_type_JavaLangString, ((beum)localObject3).jdField_a_of_type_JavaLangString);
      parambevl.jdField_f_of_type_JavaLangString = ((String)localObject2);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(localObject2, localObject2) == null) {
        break label276;
      }
      i = 1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      a((beum)localObject3);
      ((beum)localObject3).jdField_a_of_type_Bevm = new bevm((bevl)localObject3);
      bevp localbevp = new bevp(this);
      ((beum)localObject3).jdField_a_of_type_JavaLangObject = localbevp;
      localbevp.jdField_a_of_type_Beum = ((beum)localObject3);
      localbevp.jdField_a_of_type_Bevm = ((beum)localObject3).jdField_a_of_type_Bevm;
      if (i == 0) {
        localbevp.b();
      }
      if ((parambevl.jdField_a_of_type_Bevm.jdField_a_of_type_Int != 2) || (localbevp.jdField_b_of_type_Boolean))
      {
        bevp.a(localbevp);
        return;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("sendReq:").append(parambevl).append(" _id:").append(parambevl.jdField_e_of_type_JavaLangString).append(" isDownloading key:");
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          QLog.e("Q.richmedia.OldHttpEngine", 2, (String)localObject2);
        }
        parambevl.jdField_a_of_type_Bevm.jdField_a_of_type_Int = 3;
        bevp.a(localbevp);
        return;
      }
      a(parambevl, false);
      return;
      label276:
      i = 0;
    }
  }
  
  public void a(bevl parambevl, boolean paramBoolean)
  {
    bevp localbevp;
    do
    {
      try
      {
        bhva localbhva1 = a(parambevl);
        localbevp = (bevp)parambevl.jdField_a_of_type_JavaLangObject;
        if ((localbhva1 != null) && (localbevp != null))
        {
          localbhva1.l = paramBoolean;
          bevm localbevm = parambevl.jdField_a_of_type_Bevm;
          localbevm.jdField_d_of_type_Int += 1;
          localbevp.jdField_b_of_type_Int = 0;
          if (paramBoolean)
          {
            b(localbhva1);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        bhva localbhva3;
        for (;;)
        {
          System.gc();
          try
          {
            bhva localbhva2 = a(parambevl);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            localbhva3 = null;
          }
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          a(localbhva3);
          return;
        }
        parambevl = parambevl.jdField_a_of_type_Bevm;
        parambevl.jdField_b_of_type_Int = 9366;
        parambevl.jdField_a_of_type_JavaLangString = "oldengine close";
        parambevl.jdField_a_of_type_Int = 1;
        bevp.a(localbevp);
        return;
      }
    } while ((localbevp == null) || (localbevp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    parambevl = parambevl.jdField_a_of_type_Bevm;
    parambevl.jdField_b_of_type_Int = 9369;
    parambevl.jdField_a_of_type_JavaLangString = "Out of memory";
    parambevl.jdField_a_of_type_Int = 1;
    bevp.a(localbevp);
  }
  
  public void a(bhva parambhva)
  {
    if ((parambhva != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Bhuw != null)) {
      this.jdField_a_of_type_Bhuw.a(parambhva);
    }
  }
  
  public bevm b(bevl parambevl)
  {
    if ((parambevl != null) && ((parambevl instanceof beum)))
    {
      beum localbeum = (beum)parambevl;
      localbeum.i = true;
      a(localbeum);
      localbeum.jdField_a_of_type_Bevm = new bevm(localbeum);
      bevp localbevp = new bevp(this);
      localbeum.jdField_a_of_type_JavaLangObject = localbevp;
      localbevp.jdField_a_of_type_Beum = localbeum;
      localbevp.jdField_a_of_type_Bevm = localbeum.jdField_a_of_type_Bevm;
      localbevp.b();
      a(parambevl, true);
      return parambevl.jdField_a_of_type_Bevm;
    }
    return null;
  }
  
  public void b(bevl parambevl)
  {
    if (parambevl == null) {}
    do
    {
      return;
      if (parambevl.jdField_f_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambevl.jdField_f_of_type_JavaLangString);
      }
    } while (!bevp.class.isInstance(parambevl.jdField_a_of_type_JavaLangObject));
    Object localObject = (beum)parambevl;
    int i = parambevl.jdField_f_of_type_Int;
    if (((beum)localObject).jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      bews.a(i, bool, parambevl.jdField_e_of_type_Int, parambevl.jdField_e_of_type_JavaLangString, "cancelReq", "");
      localObject = (bevp)parambevl.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((bevp)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((bevp)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      bhva localbhva = ((bevp)localObject).jdField_a_of_type_Bhva;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_Bhuw != null)) {
        this.jdField_a_of_type_Bhuw.b(localbhva);
      }
      ((bevp)localObject).a(parambevl);
      ((bevp)localObject).a();
      return;
    }
  }
  
  public void b(bhva parambhva)
  {
    if ((parambhva != null) && (this.jdField_a_of_type_Bhuw != null)) {
      this.jdField_a_of_type_Bhuw.a(parambhva);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevo
 * JD-Core Version:    0.7.0.1
 */