import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger.1;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Random;

public class azhn
{
  protected static final List<String> a;
  protected static Map<String, azlp> a;
  protected ajtg a;
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
  
  public azhn(String paramString, Class<? extends azlp> paramClass, ajtg paramajtg)
  {
    this.jdField_a_of_type_JavaLangString = "0x6ff0072";
    this.jdField_a_of_type_Ajtg = paramajtg;
    this.f = paramString;
    if (jdField_a_of_type_JavaUtilMap == null) {
      jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if ((azlp)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      paramClass = azlo.a(paramClass);
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
  
  public String a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    boolean bool;
    if ((i == 2) || (i == 3))
    {
      bool = true;
      paramAppInterface = axve.a();
      paramAppInterface.b();
      if (paramAppInterface == null) {
        break label295;
      }
      paramAppInterface = paramAppInterface.a(0, bool);
      if (QLog.isColorLevel()) {
        QLog.i("TroopAvatarManger", 2, String.format("ip=%s by getSrvAddr type=%d", new Object[] { paramAppInterface, Integer.valueOf(i) }));
      }
    }
    for (;;)
    {
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface + "cgi-bin/httpconn";
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarManger", 2, "getUrl " + paramAppInterface);
        }
        return paramAppInterface + "?htcmd=" + "0x6ff0072" + "&ver=" + "5520" + "&ukey=" + paramString5 + "&range=" + paramString2 + "&uin=" + paramString4 + "&seq=23&groupuin=" + paramString3 + "&filetype=" + "3" + "&imagetype=" + "5" + "&userdata=" + paramString1;
        bool = false;
        break;
      }
      if (bool) {}
      for (String str = a("cgi-bin/httpconn", bool);; str = a("cgi-bin/httpconn"))
      {
        paramAppInterface = str;
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        paramAppInterface = str;
        if (bool) {
          break;
        }
        paramAppInterface = a("cgi-bin/httpconn", bool);
        break;
      }
      label295:
      paramAppInterface = null;
    }
  }
  
  public String a(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject3 = InetAddress.getByName("htdata3.qq.com").getHostAddress();
        localObject2 = a(paramString, (String)localObject3, 80);
        localObject1 = localObject2;
      }
      catch (UnknownHostException localUnknownHostException1)
      {
        Object localObject3;
        String str;
        label121:
        localObject2 = null;
      }
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.i("TroopAvatarManger", 2, String.format("tryGetIpByHost 1 %s", new Object[] { localObject3 }));
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty(localObject1)) {
            localObject3 = localObject1;
          }
        }
        catch (UnknownHostException localUnknownHostException2)
        {
          continue;
        }
        try
        {
          str = InetAddress.getByName("htdata4.qq.com").getHostAddress();
          localObject3 = localObject1;
          paramString = a(paramString, str, 80);
          localObject2 = paramString;
          localObject3 = paramString;
          if (QLog.isColorLevel())
          {
            localObject3 = paramString;
            QLog.i("TroopAvatarManger", 2, String.format("tryGetIpByHost 2 %s", new Object[] { str }));
            localObject2 = paramString;
          }
        }
        catch (UnknownHostException paramString)
        {
          localObject2 = localUnknownHostException1;
          if (!QLog.isColorLevel()) {
            break label121;
          }
          QLog.i("TroopAvatarManger", 2, "UnknownHostException2", paramString);
          return localUnknownHostException1;
        }
      }
      return localObject2;
      Object localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.i("TroopAvatarManger", 2, "UnknownHostException", localUnknownHostException1);
        localObject1 = localObject2;
      }
    }
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    int i = new Random(100L).nextInt();
    String str;
    if (paramBoolean)
    {
      int j = jdField_a_of_type_JavaUtilList.size();
      str = (String)jdField_a_of_type_JavaUtilList.get(Math.abs(i) % j);
    }
    for (;;)
    {
      paramString = a(paramString, str, 80);
      if (QLog.isColorLevel()) {
        QLog.i("TroopAvatarManger", 2, String.format("tryGetIpByRandomIp ip=%s bIpv6=%b", new Object[] { str, Boolean.valueOf(paramBoolean) }));
      }
      return paramString;
      if (Math.abs(i) % 2 == 0) {
        str = "14.17.18.20";
      } else {
        str = "112.90.139.96";
      }
    }
  }
  
  public ArrayList<azln> a()
  {
    return ((azlp)jdField_a_of_type_JavaUtilMap.get(this.f)).a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ajtg = null;
  }
  
  public void a(Class<? extends Thread> paramClass, AppInterface paramAppInterface, ArrayList<TroopClipPic> paramArrayList, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    ThreadManager.executeOnNetWorkThread(new TroopAvatarManger.1(this, paramAppInterface, paramString1, paramString3, paramString2, (azlp)jdField_a_of_type_JavaUtilMap.get(this.f), paramClass, paramArrayList, paramHashMap));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Ajtg != null) {
      this.jdField_a_of_type_Ajtg.e(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_Ajtg != null) {
      this.jdField_a_of_type_Ajtg.a(paramString, paramInt, paramArrayList);
    }
  }
  
  public void a(Observer paramObserver)
  {
    ((azlp)jdField_a_of_type_JavaUtilMap.get(this.f)).addObserver(paramObserver);
  }
  
  public void b(Observer paramObserver)
  {
    ((azlp)jdField_a_of_type_JavaUtilMap.get(this.f)).a(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhn
 * JD-Core Version:    0.7.0.1
 */