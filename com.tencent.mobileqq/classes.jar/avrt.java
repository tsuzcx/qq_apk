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

public class avrt
  implements IEventReceiver
{
  private static volatile avrt jdField_a_of_type_Avrt;
  private SparseArray<avrm> jdField_a_of_type_AndroidUtilSparseArray;
  private avrp jdField_a_of_type_Avrp = new avrp();
  private avrs jdField_a_of_type_Avrs = new avrs();
  private avrw jdField_a_of_type_Avrw = new avrw(this);
  private Map<String, avrl> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private avrt()
  {
    vli.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Avrw);
  }
  
  private avro a(String paramString, int paramInt1, avro paramavro, int paramInt2, boolean paramBoolean, avrr paramavrr, int paramInt3)
  {
    if ((paramavro != null) && (this.jdField_a_of_type_Avrp.a(paramavro, paramInt2, paramInt3))) {
      if ((paramavrr != null) && (paramavrr.a != null)) {
        paramavrr.a(paramavrr.a.get(), true, paramavro);
      }
    }
    do
    {
      do
      {
        return paramavro;
        if ((paramavro == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Avrp.a(paramavro))) {
          break;
        }
        paramString = (avrl)this.jdField_a_of_type_JavaUtilMap.get(paramavro.h);
        if (paramString != null) {
          paramString.a(paramavro);
        }
      } while ((paramavrr == null) || (paramavrr.a == null));
      paramavrr.a(paramavrr.a.get(), true, paramavro);
      return paramavro;
      if ((paramavro == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Avrp.b(paramavro))) {
        break;
      }
      paramString = (avrl)this.jdField_a_of_type_JavaUtilMap.get(paramavro.h);
      if (paramString != null) {
        paramString.a(paramavro);
      }
    } while ((paramavrr == null) || (paramavrr.a == null));
    paramavrr.a(paramavrr.a.get(), true, paramavro);
    return paramavro;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramavro;
        if (paramavro == null)
        {
          paramString = new avro(paramString, paramInt1);
          paramavro = (avrl)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramavro != null)
          {
            paramavro.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Avrp.a((avro)localObject, paramInt2, paramavrr);
      }
      for (;;)
      {
        return null;
        if ((paramavrr != null) && (paramavrr.a != null)) {
          paramavrr.a(paramavrr.a.get(), false, null);
        }
      }
    }
    if ((paramavrr != null) && (paramavrr.a != null)) {
      paramavrr.a(paramavrr.a.get(), false, null);
    }
    return null;
  }
  
  public static avrt a()
  {
    if (jdField_a_of_type_Avrt == null) {}
    try
    {
      if (jdField_a_of_type_Avrt == null) {
        jdField_a_of_type_Avrt = new avrt();
      }
      return jdField_a_of_type_Avrt;
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
    paramActivity.overridePendingTransition(2130772300, 2130771990);
  }
  
  private void a(avrl paramavrl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramavrl.a.h });
    }
    avrv localavrv = new avrv(this);
    a(paramavrl.a.jdField_a_of_type_JavaLangString, paramavrl.a.jdField_a_of_type_Int, 2, true, localavrv);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Avrs.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = avro.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new avru(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    avrl localavrl = (avrl)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localavrl != null) {
      localavrl.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), amtj.a(2131705935), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(avro.a(paramString, paramInt1));
  }
  
  private void b(avrl paramavrl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramavrl.a.h });
    }
    this.jdField_a_of_type_Avrs.a(paramavrl, (MiniAppOptions)this.b.get(paramavrl.a.h));
  }
  
  public avrm a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = avrm.a(paramString);
    if (i > 0)
    {
      avrm localavrm = (avrm)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localavrm;
      if (localavrm == null)
      {
        paramString = new avrj();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public avro a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, avrr paramavrr)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramavrr, 0);
  }
  
  public avro a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, avrr paramavrr, int paramInt3)
  {
    if (paramavrr == null) {
      return this.jdField_a_of_type_Avrp.a(avro.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Avrp.a(avro.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramavrr, paramInt3);
  }
  
  public void a(avro paramavro)
  {
    this.jdField_a_of_type_Avrp.jdField_a_of_type_JavaUtilMap.put(paramavro.h, paramavro);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (avrl)this.jdField_a_of_type_JavaUtilMap.get(avro.a(paramString, paramInt));
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
 * Qualified Name:     avrt
 * JD-Core Version:    0.7.0.1
 */