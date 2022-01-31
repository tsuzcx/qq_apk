import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class asjb
  implements IEventReceiver
{
  private static volatile asjb jdField_a_of_type_Asjb;
  private SparseArray<asiu> jdField_a_of_type_AndroidUtilSparseArray;
  private asix jdField_a_of_type_Asix = new asix();
  private asja jdField_a_of_type_Asja = new asja();
  private asje jdField_a_of_type_Asje = new asje(this);
  private Map<String, asit> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private asjb()
  {
    stb.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Asje);
  }
  
  private asiw a(String paramString, int paramInt1, asiw paramasiw, int paramInt2, boolean paramBoolean, asiz paramasiz, int paramInt3)
  {
    if ((paramasiw != null) && (this.jdField_a_of_type_Asix.a(paramasiw, paramInt2, paramInt3))) {
      if ((paramasiz != null) && (paramasiz.a != null)) {
        paramasiz.a(paramasiz.a.get(), true, paramasiw);
      }
    }
    do
    {
      do
      {
        return paramasiw;
        if ((paramasiw == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Asix.a(paramasiw))) {
          break;
        }
        paramString = (asit)this.jdField_a_of_type_JavaUtilMap.get(paramasiw.h);
        if (paramString != null) {
          paramString.a(paramasiw);
        }
      } while ((paramasiz == null) || (paramasiz.a == null));
      paramasiz.a(paramasiz.a.get(), true, paramasiw);
      return paramasiw;
      if ((paramasiw == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Asix.b(paramasiw))) {
        break;
      }
      paramString = (asit)this.jdField_a_of_type_JavaUtilMap.get(paramasiw.h);
      if (paramString != null) {
        paramString.a(paramasiw);
      }
    } while ((paramasiz == null) || (paramasiz.a == null));
    paramasiz.a(paramasiz.a.get(), true, paramasiw);
    return paramasiw;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramasiw;
        if (paramasiw == null)
        {
          paramString = new asiw(paramString, paramInt1);
          paramasiw = (asit)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramasiw != null)
          {
            paramasiw.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Asix.a((asiw)localObject, paramInt2, paramasiz);
      }
      for (;;)
      {
        return null;
        if ((paramasiz != null) && (paramasiz.a != null)) {
          paramasiz.a(paramasiz.a.get(), false, null);
        }
      }
    }
    if ((paramasiz != null) && (paramasiz.a != null)) {
      paramasiz.a(paramasiz.a.get(), false, null);
    }
    return null;
  }
  
  public static asjb a()
  {
    if (jdField_a_of_type_Asjb == null) {}
    try
    {
      if (jdField_a_of_type_Asjb == null) {
        jdField_a_of_type_Asjb = new asjb();
      }
      return jdField_a_of_type_Asjb;
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
    paramActivity.overridePendingTransition(2130772278, 2130771990);
  }
  
  private void a(asit paramasit)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramasit.a.h });
    }
    asjd localasjd = new asjd(this);
    a(paramasit.a.jdField_a_of_type_JavaLangString, paramasit.a.jdField_a_of_type_Int, 2, true, localasjd);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Asja.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = asiw.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new asjc(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    asit localasit = (asit)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localasit != null) {
      localasit.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131706823), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(asiw.a(paramString, paramInt1));
  }
  
  private void b(asit paramasit)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramasit.a.h });
    }
    this.jdField_a_of_type_Asja.a(paramasit, (MiniAppOptions)this.b.get(paramasit.a.h));
  }
  
  public asiu a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = asiu.a(paramString);
    if (i > 0)
    {
      asiu localasiu = (asiu)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localasiu;
      if (localasiu == null)
      {
        paramString = new asir();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public asiw a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, asiz paramasiz)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramasiz, 0);
  }
  
  public asiw a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, asiz paramasiz, int paramInt3)
  {
    if (paramasiz == null) {
      return this.jdField_a_of_type_Asix.a(asiw.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Asix.a(asiw.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramasiz, paramInt3);
  }
  
  public void a(asiw paramasiw)
  {
    this.jdField_a_of_type_Asix.jdField_a_of_type_JavaUtilMap.put(paramasiw.h, paramasiw);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (asit)this.jdField_a_of_type_JavaUtilMap.get(asiw.a(paramString, paramInt));
    if ((paramString != null) && (paramString.a())) {
      paramString.b();
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asjb
 * JD-Core Version:    0.7.0.1
 */