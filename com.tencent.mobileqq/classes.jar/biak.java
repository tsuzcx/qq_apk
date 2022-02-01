import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasResEngine.VasResController.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class biak
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  biht jdField_a_of_type_Biht = new bial(this);
  private bihz jdField_a_of_type_Bihz;
  
  public biak(int paramInt, Handler paramHandler)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private Manager a(AppRuntime paramAppRuntime)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramAppRuntime instanceof ToolAppRuntime))
    {
      paramAppRuntime = paramAppRuntime.getAppRuntime("modular_web");
      localObject1 = localObject2;
      if ((paramAppRuntime instanceof BrowserAppInterface)) {
        localObject1 = paramAppRuntime.getManager(47);
      }
    }
    do
    {
      do
      {
        return localObject1;
        if ((paramAppRuntime instanceof QQAppInterface)) {
          return paramAppRuntime.getManager(47);
        }
        localObject1 = localObject2;
      } while (!(paramAppRuntime instanceof QzoneMainRuntime));
      paramAppRuntime = BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("qzone_plugin.apk");
      localObject1 = localObject2;
    } while (paramAppRuntime == null);
    return paramAppRuntime.getManager(47);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new VasResController.2(this, paramString, paramInt1, paramInt2), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((this.jdField_a_of_type_Bihz == null) && (localObject != null)) {}
    try
    {
      localObject = a((AppRuntime)localObject);
      if ((localObject instanceof bihw)) {
        this.jdField_a_of_type_Bihz = ((bihw)localObject).a(1);
      }
      if (TextUtils.isEmpty(paramString1)) {
        QLog.e("VasResController", 1, "downLoad error url is empty dst =" + paramString2);
      }
      if ((this.jdField_a_of_type_Bihz != null) && (this.jdField_a_of_type_Bihz.a(paramString1) == null))
      {
        paramString1 = new bihu(paramString1, new File(paramString2));
        this.jdField_a_of_type_Bihz.a(paramString1, this.jdField_a_of_type_Biht, paramBundle);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VasResController", 1, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biak
 * JD-Core Version:    0.7.0.1
 */