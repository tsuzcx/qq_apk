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

public class auab
  implements IEventReceiver
{
  private static volatile auab jdField_a_of_type_Auab;
  private SparseArray<atzu> jdField_a_of_type_AndroidUtilSparseArray;
  private atzx jdField_a_of_type_Atzx = new atzx();
  private auaa jdField_a_of_type_Auaa = new auaa();
  private auae jdField_a_of_type_Auae = new auae(this);
  private Map<String, atzt> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private auab()
  {
    uht.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Auae);
  }
  
  private atzw a(String paramString, int paramInt1, atzw paramatzw, int paramInt2, boolean paramBoolean, atzz paramatzz, int paramInt3)
  {
    if ((paramatzw != null) && (this.jdField_a_of_type_Atzx.a(paramatzw, paramInt2, paramInt3))) {
      if ((paramatzz != null) && (paramatzz.a != null)) {
        paramatzz.a(paramatzz.a.get(), true, paramatzw);
      }
    }
    do
    {
      do
      {
        return paramatzw;
        if ((paramatzw == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Atzx.a(paramatzw))) {
          break;
        }
        paramString = (atzt)this.jdField_a_of_type_JavaUtilMap.get(paramatzw.h);
        if (paramString != null) {
          paramString.a(paramatzw);
        }
      } while ((paramatzz == null) || (paramatzz.a == null));
      paramatzz.a(paramatzz.a.get(), true, paramatzw);
      return paramatzw;
      if ((paramatzw == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Atzx.b(paramatzw))) {
        break;
      }
      paramString = (atzt)this.jdField_a_of_type_JavaUtilMap.get(paramatzw.h);
      if (paramString != null) {
        paramString.a(paramatzw);
      }
    } while ((paramatzz == null) || (paramatzz.a == null));
    paramatzz.a(paramatzz.a.get(), true, paramatzw);
    return paramatzw;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramatzw;
        if (paramatzw == null)
        {
          paramString = new atzw(paramString, paramInt1);
          paramatzw = (atzt)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramatzw != null)
          {
            paramatzw.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Atzx.a((atzw)localObject, paramInt2, paramatzz);
      }
      for (;;)
      {
        return null;
        if ((paramatzz != null) && (paramatzz.a != null)) {
          paramatzz.a(paramatzz.a.get(), false, null);
        }
      }
    }
    if ((paramatzz != null) && (paramatzz.a != null)) {
      paramatzz.a(paramatzz.a.get(), false, null);
    }
    return null;
  }
  
  public static auab a()
  {
    if (jdField_a_of_type_Auab == null) {}
    try
    {
      if (jdField_a_of_type_Auab == null) {
        jdField_a_of_type_Auab = new auab();
      }
      return jdField_a_of_type_Auab;
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
    paramActivity.overridePendingTransition(2130772292, 2130771990);
  }
  
  private void a(atzt paramatzt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramatzt.a.h });
    }
    auad localauad = new auad(this);
    a(paramatzt.a.jdField_a_of_type_JavaLangString, paramatzt.a.jdField_a_of_type_Int, 2, true, localauad);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Auaa.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = atzw.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new auac(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    atzt localatzt = (atzt)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localatzt != null) {
      localatzt.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131707195), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(atzw.a(paramString, paramInt1));
  }
  
  private void b(atzt paramatzt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramatzt.a.h });
    }
    this.jdField_a_of_type_Auaa.a(paramatzt, (MiniAppOptions)this.b.get(paramatzt.a.h));
  }
  
  public atzu a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = atzu.a(paramString);
    if (i > 0)
    {
      atzu localatzu = (atzu)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localatzu;
      if (localatzu == null)
      {
        paramString = new atzr();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public atzw a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, atzz paramatzz)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramatzz, 0);
  }
  
  public atzw a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, atzz paramatzz, int paramInt3)
  {
    if (paramatzz == null) {
      return this.jdField_a_of_type_Atzx.a(atzw.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Atzx.a(atzw.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramatzz, paramInt3);
  }
  
  public void a(atzw paramatzw)
  {
    this.jdField_a_of_type_Atzx.jdField_a_of_type_JavaUtilMap.put(paramatzw.h, paramatzw);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (atzt)this.jdField_a_of_type_JavaUtilMap.get(atzw.a(paramString, paramInt));
    if ((paramString != null) && (paramString.a())) {
      paramString.b();
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auab
 * JD-Core Version:    0.7.0.1
 */