import ConfigPush.FileStorageServerListInfo;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class batm
{
  public static int a;
  private static batm jdField_a_of_type_Batm;
  public static int b = jdField_a_of_type_Int + 1;
  Application jdField_a_of_type_AndroidAppApplication;
  batn jdField_a_of_type_Batn = new batn(this);
  private List<bayc> jdField_a_of_type_JavaUtilList;
  
  private batm(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  public static batm a()
  {
    if (jdField_a_of_type_Batm == null) {}
    try
    {
      if (jdField_a_of_type_Batm == null) {
        jdField_a_of_type_Batm = new batm(BaseApplicationImpl.getApplication());
      }
      return jdField_a_of_type_Batm;
    }
    finally {}
  }
  
  private List<bayc> a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    try
    {
      bayc localbayc = this.jdField_a_of_type_Batn.a(paramInt, paramBoolean);
      if (localbayc != null)
      {
        Object localObject3 = localbayc.a();
        paramInt = localbayc.a();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = localObject1;
        if (((String)localObject1).indexOf(':') >= 0)
        {
          localObject3 = localObject1;
          if (!((String)localObject1).startsWith("[")) {
            localObject3 = "[" + (String)localObject1 + "]";
          }
        }
        localObject1 = "http://" + (String)localObject3 + ":" + paramInt + "/";
      }
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppApplication.getSharedPreferences("SosoSrvAddrList", 0).edit();
    if (localObject != null) {
      ((SharedPreferences.Editor)localObject).putString("SosoSrvAddrList_key", null).commit();
    }
    localObject = new Intent("com.tencent.receiver.soso");
    ((Intent)localObject).putExtra("com.tencent.receiver.soso.type", b);
    this.jdField_a_of_type_AndroidAppApplication.sendBroadcast((Intent)localObject);
  }
  
  public void a(ArrayList<FileStorageServerListInfo> paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppApplication;
    if (Build.VERSION.SDK_INT > 10) {}
    StringBuilder localStringBuilder;
    for (int i = 4;; i = 0)
    {
      localObject = ((Application)localObject).getSharedPreferences("SosoSrvAddrList", i);
      if (paramArrayList == null) {
        return;
      }
      localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)paramArrayList.next();
        localStringBuilder.append(localFileStorageServerListInfo.sIP).append(":").append(localFileStorageServerListInfo.iPort).append("|");
      }
    }
    ((SharedPreferences)localObject).edit().putString("SosoSrvAddrList_key", localStringBuilder.toString()).commit();
    paramArrayList = new Intent("com.tencent.receiver.soso");
    paramArrayList.putExtra("com.tencent.receiver.soso.type", jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidAppApplication.sendBroadcast(paramArrayList);
  }
  
  public void a(List<bayc> paramList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Batn.a(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void b()
  {
    ArrayList localArrayList = new ArrayList();
    HwConfig localHwConfig = baoc.a().a();
    if (localHwConfig != null)
    {
      int i;
      bayd localbayd;
      if ((localHwConfig.ipv6List != null) && (localHwConfig.ipv6List.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipv6List.size())
        {
          localbayd = new bayd();
          localbayd.jdField_a_of_type_JavaLangString = ((EndPoint)localHwConfig.ipv6List.get(i)).host;
          localbayd.jdField_a_of_type_Int = ((EndPoint)localHwConfig.ipv6List.get(i)).port;
          localbayd.jdField_a_of_type_Boolean = true;
          localArrayList.add(localbayd);
          i += 1;
        }
      }
      if ((localHwConfig.ipList != null) && (localHwConfig.ipList.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipList.size())
        {
          localbayd = new bayd();
          localbayd.jdField_a_of_type_JavaLangString = ((EndPoint)localHwConfig.ipList.get(i)).host;
          localbayd.jdField_a_of_type_Int = ((EndPoint)localHwConfig.ipList.get(i)).port;
          localbayd.jdField_a_of_type_Boolean = false;
          localArrayList.add(localbayd);
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SosoSrvAddrProvider", 2, String.format("init iplist=%s", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batm
 * JD-Core Version:    0.7.0.1
 */