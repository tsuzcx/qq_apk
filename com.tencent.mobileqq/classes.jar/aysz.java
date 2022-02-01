import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aysz<VIEW, DATA>
  implements aysw<VIEW, DATA>
{
  protected SparseArray<aysw<? extends View, DATA>> a;
  protected aysx a;
  public BaseActivity a;
  public QQAppInterface a;
  protected VIEW a;
  protected DATA b;
  
  public aysz(aysx paramaysx, DATA paramDATA)
  {
    this.jdField_a_of_type_Aysx = paramaysx;
    this.b = paramDATA;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public aysw<? extends View, DATA> a(int paramInt)
  {
    return (aysw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public VIEW a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent) {}
  
  public void a(aysw<? extends View, DATA> paramaysw)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramaysw.a(), paramaysw);
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
      aysw localaysw = (aysw)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localaysw == null) {
        break label64;
      }
      bool = localaysw.a(paramDATA) | bool;
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
  
  public void b(aysw<? extends View, DATA> paramaysw)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramaysw.a());
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
    if (this.jdField_a_of_type_Aysx != null) {
      this.jdField_a_of_type_Aysx.a(this);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Aysx != null) {
      this.jdField_a_of_type_Aysx.b(this);
    }
  }
  
  @NonNull
  public String toString()
  {
    return String.format("Component@%s{componentType=%s componentName=%s}", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(a()), a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysz
 * JD-Core Version:    0.7.0.1
 */