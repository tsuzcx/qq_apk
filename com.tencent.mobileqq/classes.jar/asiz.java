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

public class asiz
  implements IEventReceiver
{
  private static volatile asiz jdField_a_of_type_Asiz;
  private SparseArray<asis> jdField_a_of_type_AndroidUtilSparseArray;
  private asiv jdField_a_of_type_Asiv = new asiv();
  private asiy jdField_a_of_type_Asiy = new asiy();
  private asjc jdField_a_of_type_Asjc = new asjc(this);
  private Map<String, asir> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private asiz()
  {
    ste.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Asjc);
  }
  
  private asiu a(String paramString, int paramInt1, asiu paramasiu, int paramInt2, boolean paramBoolean, asix paramasix, int paramInt3)
  {
    if ((paramasiu != null) && (this.jdField_a_of_type_Asiv.a(paramasiu, paramInt2, paramInt3))) {
      if ((paramasix != null) && (paramasix.a != null)) {
        paramasix.a(paramasix.a.get(), true, paramasiu);
      }
    }
    do
    {
      do
      {
        return paramasiu;
        if ((paramasiu == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Asiv.a(paramasiu))) {
          break;
        }
        paramString = (asir)this.jdField_a_of_type_JavaUtilMap.get(paramasiu.h);
        if (paramString != null) {
          paramString.a(paramasiu);
        }
      } while ((paramasix == null) || (paramasix.a == null));
      paramasix.a(paramasix.a.get(), true, paramasiu);
      return paramasiu;
      if ((paramasiu == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Asiv.b(paramasiu))) {
        break;
      }
      paramString = (asir)this.jdField_a_of_type_JavaUtilMap.get(paramasiu.h);
      if (paramString != null) {
        paramString.a(paramasiu);
      }
    } while ((paramasix == null) || (paramasix.a == null));
    paramasix.a(paramasix.a.get(), true, paramasiu);
    return paramasiu;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramasiu;
        if (paramasiu == null)
        {
          paramString = new asiu(paramString, paramInt1);
          paramasiu = (asir)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramasiu != null)
          {
            paramasiu.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Asiv.a((asiu)localObject, paramInt2, paramasix);
      }
      for (;;)
      {
        return null;
        if ((paramasix != null) && (paramasix.a != null)) {
          paramasix.a(paramasix.a.get(), false, null);
        }
      }
    }
    if ((paramasix != null) && (paramasix.a != null)) {
      paramasix.a(paramasix.a.get(), false, null);
    }
    return null;
  }
  
  public static asiz a()
  {
    if (jdField_a_of_type_Asiz == null) {}
    try
    {
      if (jdField_a_of_type_Asiz == null) {
        jdField_a_of_type_Asiz = new asiz();
      }
      return jdField_a_of_type_Asiz;
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
  
  private void a(asir paramasir)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramasir.a.h });
    }
    asjb localasjb = new asjb(this);
    a(paramasir.a.jdField_a_of_type_JavaLangString, paramasir.a.jdField_a_of_type_Int, 2, true, localasjb);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Asiy.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = asiu.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new asja(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    asir localasir = (asir)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localasir != null) {
      localasir.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131706812), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(asiu.a(paramString, paramInt1));
  }
  
  private void b(asir paramasir)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramasir.a.h });
    }
    this.jdField_a_of_type_Asiy.a(paramasir, (MiniAppOptions)this.b.get(paramasir.a.h));
  }
  
  public asis a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = asis.a(paramString);
    if (i > 0)
    {
      asis localasis = (asis)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localasis;
      if (localasis == null)
      {
        paramString = new asip();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public asiu a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, asix paramasix)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramasix, 0);
  }
  
  public asiu a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, asix paramasix, int paramInt3)
  {
    if (paramasix == null) {
      return this.jdField_a_of_type_Asiv.a(asiu.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Asiv.a(asiu.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramasix, paramInt3);
  }
  
  public void a(asiu paramasiu)
  {
    this.jdField_a_of_type_Asiv.jdField_a_of_type_JavaUtilMap.put(paramasiu.h, paramasiu);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (asir)this.jdField_a_of_type_JavaUtilMap.get(asiu.a(paramString, paramInt));
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
 * Qualified Name:     asiz
 * JD-Core Version:    0.7.0.1
 */