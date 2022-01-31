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

public class auek
  implements IEventReceiver
{
  private static volatile auek jdField_a_of_type_Auek;
  private SparseArray<aued> jdField_a_of_type_AndroidUtilSparseArray;
  private aueg jdField_a_of_type_Aueg = new aueg();
  private auej jdField_a_of_type_Auej = new auej();
  private auen jdField_a_of_type_Auen = new auen(this);
  private Map<String, auec> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private auek()
  {
    umc.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Auen);
  }
  
  private auef a(String paramString, int paramInt1, auef paramauef, int paramInt2, boolean paramBoolean, auei paramauei, int paramInt3)
  {
    if ((paramauef != null) && (this.jdField_a_of_type_Aueg.a(paramauef, paramInt2, paramInt3))) {
      if ((paramauei != null) && (paramauei.a != null)) {
        paramauei.a(paramauei.a.get(), true, paramauef);
      }
    }
    do
    {
      do
      {
        return paramauef;
        if ((paramauef == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Aueg.a(paramauef))) {
          break;
        }
        paramString = (auec)this.jdField_a_of_type_JavaUtilMap.get(paramauef.h);
        if (paramString != null) {
          paramString.a(paramauef);
        }
      } while ((paramauei == null) || (paramauei.a == null));
      paramauei.a(paramauei.a.get(), true, paramauef);
      return paramauef;
      if ((paramauef == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Aueg.b(paramauef))) {
        break;
      }
      paramString = (auec)this.jdField_a_of_type_JavaUtilMap.get(paramauef.h);
      if (paramString != null) {
        paramString.a(paramauef);
      }
    } while ((paramauei == null) || (paramauei.a == null));
    paramauei.a(paramauei.a.get(), true, paramauef);
    return paramauef;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramauef;
        if (paramauef == null)
        {
          paramString = new auef(paramString, paramInt1);
          paramauef = (auec)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramauef != null)
          {
            paramauef.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Aueg.a((auef)localObject, paramInt2, paramauei);
      }
      for (;;)
      {
        return null;
        if ((paramauei != null) && (paramauei.a != null)) {
          paramauei.a(paramauei.a.get(), false, null);
        }
      }
    }
    if ((paramauei != null) && (paramauei.a != null)) {
      paramauei.a(paramauei.a.get(), false, null);
    }
    return null;
  }
  
  public static auek a()
  {
    if (jdField_a_of_type_Auek == null) {}
    try
    {
      if (jdField_a_of_type_Auek == null) {
        jdField_a_of_type_Auek = new auek();
      }
      return jdField_a_of_type_Auek;
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
    paramActivity.overridePendingTransition(2130772293, 2130771990);
  }
  
  private void a(auec paramauec)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramauec.a.h });
    }
    auem localauem = new auem(this);
    a(paramauec.a.jdField_a_of_type_JavaLangString, paramauec.a.jdField_a_of_type_Int, 2, true, localauem);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Auej.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = auef.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new auel(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    auec localauec = (auec)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localauec != null) {
      localauec.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), alud.a(2131707207), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(auef.a(paramString, paramInt1));
  }
  
  private void b(auec paramauec)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramauec.a.h });
    }
    this.jdField_a_of_type_Auej.a(paramauec, (MiniAppOptions)this.b.get(paramauec.a.h));
  }
  
  public aued a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = aued.a(paramString);
    if (i > 0)
    {
      aued localaued = (aued)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localaued;
      if (localaued == null)
      {
        paramString = new auea();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public auef a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, auei paramauei)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramauei, 0);
  }
  
  public auef a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, auei paramauei, int paramInt3)
  {
    if (paramauei == null) {
      return this.jdField_a_of_type_Aueg.a(auef.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Aueg.a(auef.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramauei, paramInt3);
  }
  
  public void a(auef paramauef)
  {
    this.jdField_a_of_type_Aueg.jdField_a_of_type_JavaUtilMap.put(paramauef.h, paramauef);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (auec)this.jdField_a_of_type_JavaUtilMap.get(auef.a(paramString, paramInt));
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
 * Qualified Name:     auek
 * JD-Core Version:    0.7.0.1
 */