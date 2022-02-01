import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class azly<VIEW, DATA>
  implements azlv<VIEW, DATA>
{
  protected SparseArray<azlv<? extends View, DATA>> a;
  protected azlw a;
  public BaseActivity a;
  public QQAppInterface a;
  protected VIEW a;
  protected DATA b;
  
  public azly(azlw paramazlw, DATA paramDATA)
  {
    this.jdField_a_of_type_Azlw = paramazlw;
    this.b = paramDATA;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public azlv<? extends View, DATA> a(int paramInt)
  {
    return (azlv)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public VIEW a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent) {}
  
  public void a(azlv<? extends View, DATA> paramazlv)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramazlv.a(), paramazlv);
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
  }
  
  public void a(VIEW paramVIEW)
  {
    this.jdField_a_of_type_JavaLangObject = paramVIEW;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(DATA paramDATA)
  {
    this.b = paramDATA;
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    boolean bool = false;
    if (i < j)
    {
      azlv localazlv = (azlv)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localazlv == null) {
        break label64;
      }
      bool = localazlv.a(paramDATA) | bool;
    }
    label64:
    for (;;)
    {
      i += 1;
      break;
      return bool;
    }
  }
  
  public void b() {}
  
  public void b(azlv<? extends View, DATA> paramazlv)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramazlv.a());
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Azlw != null) {
      this.jdField_a_of_type_Azlw.a(this);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Azlw != null) {
      this.jdField_a_of_type_Azlw.b(this);
    }
  }
  
  @NonNull
  public String toString()
  {
    return String.format("Component@%s{componentType=%s componentName=%s}", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(a()), a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azly
 * JD-Core Version:    0.7.0.1
 */