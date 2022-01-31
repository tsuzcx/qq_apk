import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.manager.Manager;
import org.json.JSONObject;

public class beyy
  implements Manager
{
  private SparseArray<beyz> jdField_a_of_type_AndroidUtilSparseArray;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public AtomicInteger a;
  public AtomicReference<beyu> a;
  private boolean jdField_a_of_type_Boolean;
  public AtomicReference<beyt> b;
  
  public beyy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
    this.b = new AtomicReference(null);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  }
  
  public int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bahu.a()).getInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "use_times", 0);
  }
  
  public long a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bahu.a()).getLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "active_time", 0L);
  }
  
  public beyz a(int paramInt)
  {
    beyz localbeyz = (beyz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, null);
    if (localbeyz == null) {}
    switch (paramInt)
    {
    default: 
      return localbeyz;
    }
    localbeyz = new beyz(paramInt);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbeyz);
    return localbeyz;
  }
  
  public void a()
  {
    int i = 1;
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    localObject2 = new beyu(1113, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((beyu)localObject2).jdField_a_of_type_Int != -1)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(localObject2);
      this.jdField_a_of_type_Boolean = true;
      localObject2 = ((beyu)localObject2).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        localObject3 = localObject2;
      }
      catch (Exception localException2)
      {
        Object localObject3;
        localObject2 = null;
        continue;
      }
      try
      {
        if (((JSONObject)localObject2).has("publicaccount"))
        {
          localObject3 = ((JSONObject)localObject2).getJSONObject("publicaccount");
          AtomicInteger localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
          if (((JSONObject)localObject3).getBoolean("switch"))
          {
            localAtomicInteger.set(i);
            localObject3 = localObject2;
          }
        }
        else
        {
          if (localObject3 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QQComicPreloadManager", 2, "cannot resolve strategy from server.");
            }
            return;
            return;
            ((Exception)localObject3).printStackTrace();
            localObject3 = localObject2;
            continue;
          }
          localObject3 = beyt.a((JSONObject)localObject3);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new beyt();
            ((beyt)localObject2).jdField_a_of_type_Boolean = true;
            ((beyt)localObject2).jdField_b_of_type_Int = 127;
            ((beyt)localObject2).c = 16777215;
            ((beyt)localObject2).jdField_h_of_type_Boolean = true;
            ((beyt)localObject2).jdField_b_of_type_Boolean = true;
            ((beyt)localObject2).d = true;
            ((beyt)localObject2).jdField_e_of_type_Boolean = true;
            ((beyt)localObject2).jdField_i_of_type_Boolean = true;
            ((beyt)localObject2).jdField_e_of_type_Int = 24;
            ((beyt)localObject2).j = true;
            ((beyt)localObject2).f = 20;
            ((beyt)localObject2).k = true;
            ((beyt)localObject2).g = 6;
            ((beyt)localObject2).jdField_h_of_type_Int = 1;
            ((beyt)localObject2).jdField_i_of_type_Int = 3;
          }
          this.b.set(localObject2);
          return;
        }
      }
      catch (Exception localException1)
      {
        continue;
        i = 0;
      }
    }
  }
  
  public void a(int paramInt)
  {
    beyv.a(a(paramInt));
  }
  
  public void a(long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bahu.a()).edit().putLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "active_time", paramLong).commit();
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[24];
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bahu.a());
    int i = 0;
    while (i < 24)
    {
      arrayOfInt[i] = localSharedPreferences.getInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "use_times" + "_" + i, 0);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bahu.a());
    int i = a();
    localSharedPreferences.edit().putInt(str + "_" + "use_times", i + 1).commit();
    i = Calendar.getInstance().get(11);
    int j = localSharedPreferences.getInt(str + "_" + "use_times" + "_" + i, 0);
    localSharedPreferences.edit().putInt(str + "_" + "use_times" + "_" + i, j + 1).commit();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyy
 * JD-Core Version:    0.7.0.1
 */