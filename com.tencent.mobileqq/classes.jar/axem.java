import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class axem
  implements IEventReceiver
{
  private static volatile axem jdField_a_of_type_Axem;
  private SparseArray<axef> jdField_a_of_type_AndroidUtilSparseArray;
  private axei jdField_a_of_type_Axei = new axei();
  private axel jdField_a_of_type_Axel = new axel();
  private axep jdField_a_of_type_Axep = new axep(this);
  private Map<String, axee> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private axem()
  {
    wjj.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Axep);
  }
  
  private axeh a(String paramString, int paramInt1, axeh paramaxeh, int paramInt2, boolean paramBoolean, axek paramaxek, int paramInt3)
  {
    if ((paramaxeh != null) && (this.jdField_a_of_type_Axei.a(paramaxeh, paramInt2, paramInt3))) {
      if ((paramaxek != null) && (paramaxek.a != null)) {
        paramaxek.a(paramaxek.a.get(), true, paramaxeh);
      }
    }
    do
    {
      do
      {
        return paramaxeh;
        if ((paramaxeh == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Axei.a(paramaxeh))) {
          break;
        }
        paramString = (axee)this.jdField_a_of_type_JavaUtilMap.get(paramaxeh.h);
        if (paramString != null) {
          paramString.a(paramaxeh);
        }
      } while ((paramaxek == null) || (paramaxek.a == null));
      paramaxek.a(paramaxek.a.get(), true, paramaxeh);
      return paramaxeh;
      if ((paramaxeh == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Axei.b(paramaxeh))) {
        break;
      }
      paramString = (axee)this.jdField_a_of_type_JavaUtilMap.get(paramaxeh.h);
      if (paramString != null) {
        paramString.a(paramaxeh);
      }
    } while ((paramaxek == null) || (paramaxek.a == null));
    paramaxek.a(paramaxek.a.get(), true, paramaxeh);
    return paramaxeh;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramaxeh;
        if (paramaxeh == null)
        {
          paramString = new axeh(paramString, paramInt1);
          paramaxeh = (axee)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramaxeh != null)
          {
            paramaxeh.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Axei.a((axeh)localObject, paramInt2, paramaxek);
      }
      for (;;)
      {
        return null;
        if ((paramaxek != null) && (paramaxek.a != null)) {
          paramaxek.a(paramaxek.a.get(), false, null);
        }
      }
    }
    if ((paramaxek != null) && (paramaxek.a != null)) {
      paramaxek.a(paramaxek.a.get(), false, null);
    }
    return null;
  }
  
  public static axem a()
  {
    if (jdField_a_of_type_Axem == null) {}
    try
    {
      if (jdField_a_of_type_Axem == null) {
        jdField_a_of_type_Axem = new axem();
      }
      return jdField_a_of_type_Axem;
    }
    finally {}
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "runApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    Intent localIntent = new Intent(paramActivity, MiniAppActivity.class);
    localIntent.putExtra("key_appid", paramString);
    localIntent.putExtra("key_appType", paramInt);
    localIntent.putExtra("key_options", paramMiniAppOptions);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.setFlags(268435456);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130772302, 2130771990);
  }
  
  private void a(axee paramaxee)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramaxee.a.h });
    }
    axeo localaxeo = new axeo(this);
    a(paramaxee.a.jdField_a_of_type_JavaLangString, paramaxee.a.jdField_a_of_type_Int, 2, true, localaxeo);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Axel.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = axeh.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new axen(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    axee localaxee = (axee)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localaxee != null) {
      localaxee.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), anzj.a(2131705705), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(axeh.a(paramString, paramInt1));
  }
  
  private void b(axee paramaxee)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramaxee.a.h });
    }
    this.jdField_a_of_type_Axel.a(paramaxee, (MiniAppOptions)this.b.get(paramaxee.a.h));
  }
  
  public axef a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = axef.a(paramString);
    if (i > 0)
    {
      axef localaxef = (axef)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localaxef;
      if (localaxef == null)
      {
        paramString = new axec();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public axeh a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, axek paramaxek)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramaxek, 0);
  }
  
  public axeh a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, axek paramaxek, int paramInt3)
  {
    if (paramaxek == null) {
      return this.jdField_a_of_type_Axei.a(axeh.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Axei.a(axeh.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramaxek, paramInt3);
  }
  
  public void a(axeh paramaxeh)
  {
    this.jdField_a_of_type_Axei.jdField_a_of_type_JavaUtilMap.put(paramaxeh.h, paramaxeh);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (axee)this.jdField_a_of_type_JavaUtilMap.get(axeh.a(paramString, paramInt));
    if ((paramString != null) && (paramString.a())) {
      paramString.b();
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axem
 * JD-Core Version:    0.7.0.1
 */