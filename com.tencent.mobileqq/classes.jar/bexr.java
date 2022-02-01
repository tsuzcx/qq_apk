import ConfigPush.FileStorageServerListInfo;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class bexr
{
  public static int a;
  private static bexr jdField_a_of_type_Bexr;
  public static int b = jdField_a_of_type_Int + 1;
  Application jdField_a_of_type_AndroidAppApplication;
  bexs jdField_a_of_type_Bexs = new bexs(this);
  private List<bfck> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  private bexr(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  public static bexr a()
  {
    if (jdField_a_of_type_Bexr == null) {}
    try
    {
      if (jdField_a_of_type_Bexr == null) {
        jdField_a_of_type_Bexr = new bexr(BaseApplicationImpl.getApplication());
      }
      return jdField_a_of_type_Bexr;
    }
    finally {}
  }
  
  private List<bfck> a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public String a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        bfck localbfck = this.jdField_a_of_type_Bexs.a(paramInt, paramBoolean1);
        if (localbfck != null)
        {
          str = localbfck.a();
          paramInt = localbfck.a();
          localObject1 = str;
          if (str == null) {
            localObject1 = "";
          }
          if ((((String)localObject1).indexOf(':') < 0) || (((String)localObject1).startsWith("["))) {
            break label156;
          }
          localObject1 = "[" + (String)localObject1 + "]";
          break label156;
          localObject1 = str + (String)localObject1 + ":" + paramInt + "/";
        }
        return localObject1;
      }
      finally {}
      String str = "http://";
      continue;
      label156:
      if (paramBoolean2) {
        str = "https://";
      }
    }
  }
  
  public String a(AppInterface paramAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = null;
    if (paramAppInterface == null) {
      paramAppInterface = (AppInterface)localObject;
    }
    for (;;)
    {
      return paramAppInterface;
      String str = "";
      for (;;)
      {
        try
        {
          localObject = ConfigManager.getInstance(BaseApplication.getContext(), paramAppInterface.getHwEngine());
          if (localObject == null) {
            break label292;
          }
          localObject = ((ConfigManager)localObject).getOtherTypeIp(paramAppInterface.getApp().getBaseContext(), 21, paramBoolean1);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            paramAppInterface = ((EndPoint)((List)localObject).get(0)).host;
            paramInt = ((EndPoint)((List)localObject).get(0)).port;
            if ((TextUtils.isEmpty(paramAppInterface)) || (paramInt == -1)) {
              break label276;
            }
            if ((paramAppInterface.indexOf(':') >= 0) && (!paramAppInterface.startsWith("[")))
            {
              paramAppInterface = "[" + paramAppInterface + "]";
              break label298;
              paramAppInterface = (String)localObject + paramAppInterface + ":" + paramInt + "/";
              break;
            }
          }
          else
          {
            if ((!this.jdField_a_of_type_Boolean) && (bhnv.g(BaseApplication.getContext())))
            {
              HwServlet.getConfig(paramAppInterface, paramAppInterface.getCurrentAccountUin());
              this.jdField_a_of_type_Boolean = true;
            }
            localObject = this.jdField_a_of_type_Bexs.a(paramInt, paramBoolean1);
            if (localObject == null) {
              break label281;
            }
            paramAppInterface = ((bfck)localObject).a();
            paramInt = ((bfck)localObject).a();
            paramBoolean2 = false;
            continue;
            localObject = "http://";
            continue;
          }
        }
        finally {}
        label276:
        paramAppInterface = null;
        break;
        label281:
        paramInt = -1;
        paramBoolean2 = false;
        paramAppInterface = str;
        continue;
        label292:
        localObject = null;
        continue;
        label298:
        if (paramBoolean2) {
          localObject = "https://";
        }
      }
    }
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
  
  public void a(List<bfck> paramList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Bexs.a(paramList);
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
    HwConfig localHwConfig = besx.a().a();
    if (localHwConfig != null)
    {
      int i;
      bfcl localbfcl;
      if ((localHwConfig.ipv6List != null) && (localHwConfig.ipv6List.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipv6List.size())
        {
          localbfcl = new bfcl();
          localbfcl.jdField_a_of_type_JavaLangString = ((EndPoint)localHwConfig.ipv6List.get(i)).host;
          localbfcl.jdField_a_of_type_Int = ((EndPoint)localHwConfig.ipv6List.get(i)).port;
          localbfcl.jdField_a_of_type_Boolean = true;
          localArrayList.add(localbfcl);
          i += 1;
        }
      }
      if ((localHwConfig.ipList != null) && (localHwConfig.ipList.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipList.size())
        {
          localbfcl = new bfcl();
          localbfcl.jdField_a_of_type_JavaLangString = ((EndPoint)localHwConfig.ipList.get(i)).host;
          localbfcl.jdField_a_of_type_Int = ((EndPoint)localHwConfig.ipList.get(i)).port;
          localbfcl.jdField_a_of_type_Boolean = false;
          localArrayList.add(localbfcl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexr
 * JD-Core Version:    0.7.0.1
 */