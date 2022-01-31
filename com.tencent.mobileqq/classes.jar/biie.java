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

public class biie
  implements Manager
{
  private SparseArray<biif> jdField_a_of_type_AndroidUtilSparseArray;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public AtomicInteger a;
  public AtomicReference<biia> a;
  private boolean jdField_a_of_type_Boolean;
  public AtomicReference<bihz> b;
  
  public biie(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
    this.b = new AtomicReference(null);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  }
  
  public int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bdik.a()).getInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "use_times", 0);
  }
  
  public long a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bdik.a()).getLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "active_time", 0L);
  }
  
  public biif a(int paramInt)
  {
    biif localbiif = (biif)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, null);
    if (localbiif == null) {}
    switch (paramInt)
    {
    default: 
      return localbiif;
    }
    localbiif = new biif(paramInt);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbiif);
    return localbiif;
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
    localObject2 = new biia(1113, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((biia)localObject2).jdField_a_of_type_Int != -1)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(localObject2);
      this.jdField_a_of_type_Boolean = true;
      localObject2 = ((biia)localObject2).jdField_a_of_type_JavaLangString;
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
          localObject3 = bihz.a((JSONObject)localObject3);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new bihz();
            ((bihz)localObject2).jdField_a_of_type_Boolean = true;
            ((bihz)localObject2).jdField_b_of_type_Int = 127;
            ((bihz)localObject2).c = 16777215;
            ((bihz)localObject2).jdField_h_of_type_Boolean = true;
            ((bihz)localObject2).jdField_b_of_type_Boolean = true;
            ((bihz)localObject2).d = true;
            ((bihz)localObject2).jdField_e_of_type_Boolean = true;
            ((bihz)localObject2).jdField_i_of_type_Boolean = true;
            ((bihz)localObject2).jdField_e_of_type_Int = 24;
            ((bihz)localObject2).j = true;
            ((bihz)localObject2).f = 20;
            ((bihz)localObject2).k = true;
            ((bihz)localObject2).g = 6;
            ((bihz)localObject2).jdField_h_of_type_Int = 1;
            ((bihz)localObject2).jdField_i_of_type_Int = 3;
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
    biib.a(a(paramInt));
  }
  
  public void a(long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bdik.a()).edit().putLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "active_time", paramLong).commit();
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[24];
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bdik.a());
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
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", bdik.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biie
 * JD-Core Version:    0.7.0.1
 */