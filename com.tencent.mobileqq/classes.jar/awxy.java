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

public class awxy
  implements IEventReceiver
{
  private static volatile awxy jdField_a_of_type_Awxy;
  private SparseArray<awxr> jdField_a_of_type_AndroidUtilSparseArray;
  private awxu jdField_a_of_type_Awxu = new awxu();
  private awxx jdField_a_of_type_Awxx = new awxx();
  private awyb jdField_a_of_type_Awyb = new awyb(this);
  private Map<String, awxq> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private awxy()
  {
    wad.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Awyb);
  }
  
  private awxt a(String paramString, int paramInt1, awxt paramawxt, int paramInt2, boolean paramBoolean, awxw paramawxw, int paramInt3)
  {
    if ((paramawxt != null) && (this.jdField_a_of_type_Awxu.a(paramawxt, paramInt2, paramInt3))) {
      if ((paramawxw != null) && (paramawxw.a != null)) {
        paramawxw.a(paramawxw.a.get(), true, paramawxt);
      }
    }
    do
    {
      do
      {
        return paramawxt;
        if ((paramawxt == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Awxu.a(paramawxt))) {
          break;
        }
        paramString = (awxq)this.jdField_a_of_type_JavaUtilMap.get(paramawxt.h);
        if (paramString != null) {
          paramString.a(paramawxt);
        }
      } while ((paramawxw == null) || (paramawxw.a == null));
      paramawxw.a(paramawxw.a.get(), true, paramawxt);
      return paramawxt;
      if ((paramawxt == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Awxu.b(paramawxt))) {
        break;
      }
      paramString = (awxq)this.jdField_a_of_type_JavaUtilMap.get(paramawxt.h);
      if (paramString != null) {
        paramString.a(paramawxt);
      }
    } while ((paramawxw == null) || (paramawxw.a == null));
    paramawxw.a(paramawxw.a.get(), true, paramawxt);
    return paramawxt;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramawxt;
        if (paramawxt == null)
        {
          paramString = new awxt(paramString, paramInt1);
          paramawxt = (awxq)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramawxt != null)
          {
            paramawxt.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Awxu.a((awxt)localObject, paramInt2, paramawxw);
      }
      for (;;)
      {
        return null;
        if ((paramawxw != null) && (paramawxw.a != null)) {
          paramawxw.a(paramawxw.a.get(), false, null);
        }
      }
    }
    if ((paramawxw != null) && (paramawxw.a != null)) {
      paramawxw.a(paramawxw.a.get(), false, null);
    }
    return null;
  }
  
  public static awxy a()
  {
    if (jdField_a_of_type_Awxy == null) {}
    try
    {
      if (jdField_a_of_type_Awxy == null) {
        jdField_a_of_type_Awxy = new awxy();
      }
      return jdField_a_of_type_Awxy;
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
    paramActivity.overridePendingTransition(2130772299, 2130771990);
  }
  
  private void a(awxq paramawxq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramawxq.a.h });
    }
    awya localawya = new awya(this);
    a(paramawxq.a.jdField_a_of_type_JavaLangString, paramawxq.a.jdField_a_of_type_Int, 2, true, localawya);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Awxx.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = awxt.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new awxz(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    awxq localawxq = (awxq)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localawxq != null) {
      localawxq.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), anvx.a(2131706286), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(awxt.a(paramString, paramInt1));
  }
  
  private void b(awxq paramawxq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramawxq.a.h });
    }
    this.jdField_a_of_type_Awxx.a(paramawxq, (MiniAppOptions)this.b.get(paramawxq.a.h));
  }
  
  public awxr a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = awxr.a(paramString);
    if (i > 0)
    {
      awxr localawxr = (awxr)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localawxr;
      if (localawxr == null)
      {
        paramString = new awxo();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public awxt a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, awxw paramawxw)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramawxw, 0);
  }
  
  public awxt a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, awxw paramawxw, int paramInt3)
  {
    if (paramawxw == null) {
      return this.jdField_a_of_type_Awxu.a(awxt.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Awxu.a(awxt.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramawxw, paramInt3);
  }
  
  public void a(awxt paramawxt)
  {
    this.jdField_a_of_type_Awxu.jdField_a_of_type_JavaUtilMap.put(paramawxt.h, paramawxt);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (awxq)this.jdField_a_of_type_JavaUtilMap.get(awxt.a(paramString, paramInt));
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
 * Qualified Name:     awxy
 * JD-Core Version:    0.7.0.1
 */