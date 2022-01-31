import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class asot
{
  public HashMap<String, String> a;
  protected boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  
  public asot(String paramString1, String paramString2)
  {
    this("default", paramString1, paramString2);
  }
  
  protected asot(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    c();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  protected String a()
  {
    return this.d + this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    asoq.a(this);
    this.jdField_a_of_type_Boolean = true;
    if (!(this instanceof asos)) {
      asoq.e(this.d);
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
    } while ((this instanceof asos));
    asoq.d(this.d);
  }
  
  void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("loss", "0");
      this.jdField_a_of_type_JavaUtilHashMap.put("benefit", "0");
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject2 = BaseApplicationImpl.getApplication();
    HashMap localHashMap1 = new HashMap();
    for (;;)
    {
      String str;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localHashMap1.putAll(this.jdField_a_of_type_JavaUtilHashMap);
        if (localObject2 != null)
        {
          ??? = ((BaseApplicationImpl)localObject2).getApplicationContext();
          localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
          if (localObject2 != null)
          {
            localObject2 = ((AppRuntime)localObject2).getAccount();
            str = this.c;
            if (!this.jdField_b_of_type_Boolean) {
              break label98;
            }
            azmz.a((Context)???).a((String)localObject2, str, true, 0L, 0L, localHashMap1, null);
          }
        }
        c();
        return;
      }
      label98:
      azmz.a((Context)???).a((String)localObject2, str, false, 0L, 0L, localHashMap2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     asot
 * JD-Core Version:    0.7.0.1
 */