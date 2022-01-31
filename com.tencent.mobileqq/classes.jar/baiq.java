import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger.1;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Random;

public class baiq
{
  protected static final List<String> a;
  protected static Map<String, bamt> a;
  protected akhq a;
  protected final String a;
  protected final String b = "5520";
  protected final String c = "3";
  protected final String d = "5";
  protected final String e = "cgi-bin/httpconn";
  public String f;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add("2408:8756:3af0:10::107");
    jdField_a_of_type_JavaUtilList.add("240e:ff:f101:10::104");
    jdField_a_of_type_JavaUtilList.add("2402:4e00:8010::132");
    jdField_a_of_type_JavaUtilList.add("2402:4e00:8010::22");
    jdField_a_of_type_JavaUtilList.add("2408:80f1:31:50::21");
    jdField_a_of_type_JavaUtilList.add("240e:e1:a900:50::3d");
    jdField_a_of_type_JavaUtilList.add("2402:4e00:8020:2::86");
    jdField_a_of_type_JavaUtilList.add("2409:8c1e:8fd0:50::1c");
    jdField_a_of_type_JavaUtilList.add("2408:8711:10:10::13");
    jdField_a_of_type_JavaUtilList.add("240e:928:1400:10::23");
    jdField_a_of_type_JavaUtilList.add("2402:4e00:8030:1::a0");
    jdField_a_of_type_JavaUtilList.add("2409:8702:4860:10::41");
  }
  
  public baiq(String paramString, Class<? extends bamt> paramClass, akhq paramakhq)
  {
    this.jdField_a_of_type_JavaLangString = "0x6ff0072";
    this.jdField_a_of_type_Akhq = paramakhq;
    this.f = paramString;
    if (jdField_a_of_type_JavaUtilMap == null) {
      jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if ((bamt)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      paramClass = bams.a(paramClass);
      jdField_a_of_type_JavaUtilMap.put(paramString, paramClass);
    }
  }
  
  private String a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    try
    {
      paramString1 = new URL("http", paramString2, paramInt, "cgi-bin/httpconn").toString();
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private String a(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject2;
    Object localObject1;
    if (!paramBoolean)
    {
      bool1 = true;
      localObject2 = a("htdata3.qq.com", "cgi-bin/httpconn", bool1);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        if (paramBoolean) {
          break label77;
        }
      }
    }
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject1 = a("htdata4.qq.com", "cgi-bin/httpconn", bool1);
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = a("cgi-bin/httpconn", paramBoolean);
      }
      return localObject2;
      bool1 = false;
      break;
    }
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = InetAddress.getAllByName(paramString1);
        if (localObject1 == null) {
          break label150;
        }
        int j = localObject1.length;
        if (i >= j) {
          break label150;
        }
        localObject2 = localObject1[i];
        if (((localObject2 instanceof Inet4Address)) && (paramBoolean))
        {
          localObject1 = localObject2.getHostAddress();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label145;
          }
          paramString2 = a(paramString2, (String)localObject1, 80);
        }
      }
      catch (UnknownHostException paramString1)
      {
        Object localObject2;
        paramString2 = null;
        QLog.i("TroopAvatarManger", 1, "UnknownHostException", paramString1);
        return paramString2;
      }
      try
      {
        QLog.i("TroopAvatarManger", 1, String.format("tryGetIpByHost host[%s] %s", new Object[] { paramString1, localObject1 }));
        return paramString2;
      }
      catch (UnknownHostException paramString1)
      {
        continue;
      }
      if (((localObject2 instanceof Inet6Address)) && (!paramBoolean))
      {
        localObject1 = localObject2.getHostAddress();
      }
      else
      {
        i += 1;
        continue;
        label145:
        paramString2 = null;
        continue;
        label150:
        localObject1 = null;
      }
    }
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    int i = new Random().nextInt(100);
    String str;
    if (paramBoolean)
    {
      int j = jdField_a_of_type_JavaUtilList.size();
      str = (String)jdField_a_of_type_JavaUtilList.get(Math.abs(i) % j);
    }
    for (;;)
    {
      paramString = a(paramString, str, 80);
      QLog.i("TroopAvatarManger", 1, String.format("tryGetIpByRandomIp ip=%s bIpv6=%b", new Object[] { str, Boolean.valueOf(paramBoolean) }));
      return paramString;
      if (Math.abs(i) % 2 == 0) {
        str = "14.17.18.20";
      } else {
        str = "112.90.139.96";
      }
    }
  }
  
  public ArrayList<bamr> a()
  {
    return ((bamt)jdField_a_of_type_JavaUtilMap.get(this.f)).a();
  }
  
  public List<String> a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramAppInterface = new ArrayList();
    boolean bool2 = ajyd.a().a();
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    Object localObject = ayvl.a();
    ((ayvl)localObject).b();
    if (i == 3)
    {
      String str = ((ayvl)localObject).a(0, bool2);
      if (!TextUtils.isEmpty(str)) {
        paramAppInterface.add(str + "cgi-bin/httpconn");
      }
      if (!bool2) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject = ((ayvl)localObject).a(0, bool1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramAppInterface.add((String)localObject + "cgi-bin/httpconn");
        }
        if (paramAppInterface.size() < 2)
        {
          localObject = a(false);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramAppInterface.add(localObject);
          }
        }
        localObject = a("cgi-bin/httpconn", "htdata3.qq.com", 80);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramAppInterface.add(localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarManger", 2, String.format("getSrvAddr type=%d prefV6=%b getUrl=%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Arrays.toString(paramAppInterface.toArray()) }));
        }
        i = 0;
        while (i < paramAppInterface.size())
        {
          paramAppInterface.set(i, (String)paramAppInterface.get(i) + "?htcmd=" + "0x6ff0072" + "&ver=" + "5520" + "&ukey=" + paramString5 + "&range=" + paramString2 + "&uin=" + paramString4 + "&seq=23&groupuin=" + paramString3 + "&filetype=" + "3" + "&imagetype=" + "5" + "&userdata=" + paramString1);
          i += 1;
        }
      }
    }
    if (i == 2)
    {
      bool1 = true;
      label416:
      localObject = ((ayvl)localObject).a(0, bool1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInterface.add((String)localObject + "cgi-bin/httpconn");
      }
      if (i != 2) {
        break label533;
      }
    }
    label533:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = a(bool1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInterface.add(localObject);
      }
      localObject = a("cgi-bin/httpconn", "htdata3.qq.com", 80);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      paramAppInterface.add(localObject);
      break;
      bool1 = false;
      break label416;
    }
    return paramAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Akhq = null;
  }
  
  public void a(Class<? extends Thread> paramClass, AppInterface paramAppInterface, ArrayList<TroopClipPic> paramArrayList, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    ThreadManager.executeOnNetWorkThread(new TroopAvatarManger.1(this, paramAppInterface, paramString1, paramString3, paramString2, (bamt)jdField_a_of_type_JavaUtilMap.get(this.f), paramClass, paramArrayList, paramHashMap));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Akhq != null) {
      this.jdField_a_of_type_Akhq.e(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_Akhq != null) {
      this.jdField_a_of_type_Akhq.a(paramString, paramInt, paramArrayList);
    }
  }
  
  public void a(Observer paramObserver)
  {
    ((bamt)jdField_a_of_type_JavaUtilMap.get(this.f)).addObserver(paramObserver);
  }
  
  public void b(Observer paramObserver)
  {
    ((bamt)jdField_a_of_type_JavaUtilMap.get(this.f)).a(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baiq
 * JD-Core Version:    0.7.0.1
 */