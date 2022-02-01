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

public class awlu
  implements IEventReceiver
{
  private static volatile awlu jdField_a_of_type_Awlu;
  private SparseArray<awln> jdField_a_of_type_AndroidUtilSparseArray;
  private awlq jdField_a_of_type_Awlq = new awlq();
  private awlt jdField_a_of_type_Awlt = new awlt();
  private awlx jdField_a_of_type_Awlx = new awlx(this);
  private Map<String, awlm> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private awlu()
  {
    wfo.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_Awlx);
  }
  
  private awlp a(String paramString, int paramInt1, awlp paramawlp, int paramInt2, boolean paramBoolean, awls paramawls, int paramInt3)
  {
    if ((paramawlp != null) && (this.jdField_a_of_type_Awlq.a(paramawlp, paramInt2, paramInt3))) {
      if ((paramawls != null) && (paramawls.a != null)) {
        paramawls.a(paramawls.a.get(), true, paramawlp);
      }
    }
    do
    {
      do
      {
        return paramawlp;
        if ((paramawlp == null) || (paramInt2 != 1) || (!this.jdField_a_of_type_Awlq.a(paramawlp))) {
          break;
        }
        paramString = (awlm)this.jdField_a_of_type_JavaUtilMap.get(paramawlp.h);
        if (paramString != null) {
          paramString.a(paramawlp);
        }
      } while ((paramawls == null) || (paramawls.a == null));
      paramawls.a(paramawls.a.get(), true, paramawlp);
      return paramawlp;
      if ((paramawlp == null) || (paramInt2 != 2) || (!this.jdField_a_of_type_Awlq.b(paramawlp))) {
        break;
      }
      paramString = (awlm)this.jdField_a_of_type_JavaUtilMap.get(paramawlp.h);
      if (paramString != null) {
        paramString.a(paramawlp);
      }
    } while ((paramawls == null) || (paramawls.a == null));
    paramawls.a(paramawls.a.get(), true, paramawlp);
    return paramawlp;
    if (paramBoolean)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        Object localObject = paramawlp;
        if (paramawlp == null)
        {
          paramString = new awlp(paramString, paramInt1);
          paramawlp = (awlm)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramawlp != null)
          {
            paramawlp.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_Awlq.a((awlp)localObject, paramInt2, paramawls);
      }
      for (;;)
      {
        return null;
        if ((paramawls != null) && (paramawls.a != null)) {
          paramawls.a(paramawls.a.get(), false, null);
        }
      }
    }
    if ((paramawls != null) && (paramawls.a != null)) {
      paramawls.a(paramawls.a.get(), false, null);
    }
    return null;
  }
  
  public static awlu a()
  {
    if (jdField_a_of_type_Awlu == null) {}
    try
    {
      if (jdField_a_of_type_Awlu == null) {
        jdField_a_of_type_Awlu = new awlu();
      }
      return jdField_a_of_type_Awlu;
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
  
  private void a(awlm paramawlm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramawlm.a.h });
    }
    awlw localawlw = new awlw(this);
    a(paramawlm.a.jdField_a_of_type_JavaLangString, paramawlm.a.jdField_a_of_type_Int, 2, true, localawlw);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_Awlt.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = awlp.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new awlv(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    awlm localawlm = (awlm)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localawlm != null) {
      localawlm.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), anni.a(2131705598), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(awlp.a(paramString, paramInt1));
  }
  
  private void b(awlm paramawlm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramawlm.a.h });
    }
    this.jdField_a_of_type_Awlt.a(paramawlm, (MiniAppOptions)this.b.get(paramawlm.a.h));
  }
  
  public awln a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = awln.a(paramString);
    if (i > 0)
    {
      awln localawln = (awln)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localawln;
      if (localawln == null)
      {
        paramString = new awlk();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public awlp a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, awls paramawls)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramawls, 0);
  }
  
  public awlp a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, awls paramawls, int paramInt3)
  {
    if (paramawls == null) {
      return this.jdField_a_of_type_Awlq.a(awlp.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_Awlq.a(awlp.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramawls, paramInt3);
  }
  
  public void a(awlp paramawlp)
  {
    this.jdField_a_of_type_Awlq.jdField_a_of_type_JavaUtilMap.put(paramawlp.h, paramawlp);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (awlm)this.jdField_a_of_type_JavaUtilMap.get(awlp.a(paramString, paramInt));
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
 * Qualified Name:     awlu
 * JD-Core Version:    0.7.0.1
 */