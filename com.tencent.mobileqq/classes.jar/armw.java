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

public class armw
  implements IEventReceiver
{
  private static volatile armw jdField_a_of_type_Armw;
  private SparseArray<armp> jdField_a_of_type_AndroidUtilSparseArray;
  private arms jdField_a_of_type_Arms = new arms();
  private armv jdField_a_of_type_Armv = new armv();
  private armz jdField_a_of_type_Armz = new armz(this);
  private Map<String, armo> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private armw()
  {
    sgi.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Armz);
  }
  
  private armr a(String paramString, int paramInt1, armr paramarmr, int paramInt2, boolean paramBoolean, armu paramarmu, int paramInt3)
  {
    if ((paramarmr != null) && (this.jdField_a_of_type_Arms.a(paramarmr, paramInt2, paramInt3))) {
      if ((paramarmu != null) && (paramarmu.a != null)) {
        paramarmu.a(paramarmu.a.get(), true, paramarmr);
      }
    }
    do
    {
      do
      {
        return paramarmr;
        if ((paramarmr == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Arms.a(paramarmr))) {
          break;
        }
        paramString = (armo)this.jdField_a_of_type_JavaUtilMap.get(paramarmr.h);
        if (paramString != null) {
          paramString.a(paramarmr);
        }
      } while ((paramarmu == null) || (paramarmu.a == null));
      paramarmu.a(paramarmu.a.get(), true, paramarmr);
      return paramarmr;
      if ((paramarmr == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Arms.b(paramarmr))) {
        break;
      }
      paramString = (armo)this.jdField_a_of_type_JavaUtilMap.get(paramarmr.h);
      if (paramString != null) {
        paramString.a(paramarmr);
      }
    } while ((paramarmu == null) || (paramarmu.a == null));
    paramarmu.a(paramarmu.a.get(), true, paramarmr);
    return paramarmr;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramarmr;
        if (paramarmr == null)
        {
          paramString = new armr(paramString, paramInt1);
          paramarmr = (armo)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramarmr != null)
          {
            paramarmr.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Arms.a((armr)localObject, paramInt2, paramarmu);
      }
      for (;;)
      {
        return null;
        if ((paramarmu != null) && (paramarmu.a != null)) {
          paramarmu.a(paramarmu.a.get(), false, null);
        }
      }
    }
    if ((paramarmu != null) && (paramarmu.a != null)) {
      paramarmu.a(paramarmu.a.get(), false, null);
    }
    return null;
  }
  
  public static armw a()
  {
    if (jdField_a_of_type_Armw == null) {}
    try
    {
      if (jdField_a_of_type_Armw == null) {
        jdField_a_of_type_Armw = new armw();
      }
      return jdField_a_of_type_Armw;
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
    paramActivity.overridePendingTransition(2130772277, 2130771990);
  }
  
  private void a(armo paramarmo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramarmo.a.h });
    }
    army localarmy = new army(this);
    a(paramarmo.a.jdField_a_of_type_JavaLangString, paramarmo.a.jdField_a_of_type_Int, 2, true, localarmy);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Armv.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = armr.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new armx(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    armo localarmo = (armo)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localarmo != null) {
      localarmo.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131641027), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(armr.a(paramString, paramInt1));
  }
  
  private void b(armo paramarmo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramarmo.a.h });
    }
    this.jdField_a_of_type_Armv.a(paramarmo, (MiniAppOptions)this.b.get(paramarmo.a.h));
  }
  
  public armp a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = armp.a(paramString);
    if (i > 0)
    {
      armp localarmp = (armp)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localarmp;
      if (localarmp == null)
      {
        paramString = new armm();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public armr a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, armu paramarmu)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramarmu, 0);
  }
  
  public armr a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, armu paramarmu, int paramInt3)
  {
    if (paramarmu == null) {
      return this.jdField_a_of_type_Arms.a(armr.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Arms.a(armr.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramarmu, paramInt3);
  }
  
  public void a(armr paramarmr)
  {
    this.jdField_a_of_type_Arms.jdField_a_of_type_JavaUtilMap.put(paramarmr.h, paramarmr);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (armo)this.jdField_a_of_type_JavaUtilMap.get(armr.a(paramString, paramInt));
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
 * Qualified Name:     armw
 * JD-Core Version:    0.7.0.1
 */