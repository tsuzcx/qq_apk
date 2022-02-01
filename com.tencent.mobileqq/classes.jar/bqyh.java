import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class bqyh
{
  private static bqyh jdField_a_of_type_Bqyh;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bqyi(this));
  private bqyj jdField_a_of_type_Bqyj = new bqyj(this, null);
  private bqyl jdField_a_of_type_Bqyl;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  private bqyh(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bqyj);
    }
  }
  
  public static bqyh a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_Bqyh == null) {
      jdField_a_of_type_Bqyh = new bqyh(paramAppInterface);
    }
    return jdField_a_of_type_Bqyh;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Bqyh != null)
    {
      jdField_a_of_type_Bqyh.b();
      jdField_a_of_type_Bqyh = null;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, int paramInt)
  {
    int i = 4;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), bpyb.class);
    localNewIntent.putExtra("key_latitude", paramDouble1);
    localNewIntent.putExtra("key_longitude", paramDouble2);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("key_lbs_template_cookie", paramInt);
    switch (bhnv.a(BaseApplicationImpl.getApplication().getBaseContext()))
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      localNewIntent.putExtra("key_lbs_template_network_type", i);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LBSDetetor", 2, "getLBSTemplateIds. req:" + paramInt + " netType:" + i + " latitude:" + paramDouble1 + " longitude:" + paramDouble2);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
  
  private void a(boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "callback. isSuccess: " + paramBoolean + " cookie: " + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
    if (this.jdField_a_of_type_Bqyl != null)
    {
      Object localObject = paramArrayList;
      if (paramArrayList == null) {
        localObject = new ArrayList(1);
      }
      this.jdField_a_of_type_Bqyl.a(paramInt, paramBoolean, (ArrayList)localObject);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBSDetetor", 2, "destroy");
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bqyj);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    }
    this.jdField_a_of_type_Bqyl = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  @TargetApi(19)
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        Object localObject = BaseApplicationImpl.getApplication().getBaseContext();
        AppOpsManager localAppOpsManager = (AppOpsManager)((Context)localObject).getSystemService("appops");
        localObject = ((Context)localObject).getApplicationInfo();
        int i = localAppOpsManager.checkOpNoThrow("android:fine_location", ((ApplicationInfo)localObject).uid, ((ApplicationInfo)localObject).packageName);
        int j = localAppOpsManager.checkOpNoThrow("android:coarse_location", ((ApplicationInfo)localObject).uid, ((ApplicationInfo)localObject).packageName);
        if ((i == 0) && (j == 0))
        {
          bool1 = true;
          bool2 = bool1;
        }
      }
      catch (Exception localException1)
      {
        boolean bool1 = true;
        boolean bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSDetetor", 2, "something wrong:" + localException1.toString());
        bool2 = bool1;
        continue;
        bool2 = true;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("LBSDetetor", 2, "check permission by AppOpsManager:" + bool1);
          bool2 = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LBSDetetor", 2, "startCheckPermissionAndDetetLocation. hasPermission:" + bool2);
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
        if (bool2)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, 30000L);
          SosoInterface.a(new bqyk(this, 0, true, true, 30000L, false, false, "NewFlowCameraActivity", paramInt));
        }
        if (this.jdField_a_of_type_Bqyl != null) {
          this.jdField_a_of_type_Bqyl.a(paramInt, bool2);
        }
        return;
      }
      catch (Exception localException2)
      {
        continue;
      }
      bool1 = false;
    }
  }
  
  public void a(bqyl parambqyl)
  {
    this.jdField_a_of_type_Bqyl = parambqyl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqyh
 * JD-Core Version:    0.7.0.1
 */