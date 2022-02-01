package com.tencent.aelight.camera.aebase.lifecycle;

import android.support.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GlobalViewModelFactory
  implements ViewModelProvider.Factory
{
  private static GlobalViewModelFactory jdField_a_of_type_ComTencentAelightCameraAebaseLifecycleGlobalViewModelFactory = new GlobalViewModelFactory();
  private static final String jdField_a_of_type_JavaLangString = "GlobalViewModelFactory";
  private HashMap<String, ViewModel> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, AtomicInteger> b = new HashMap();
  
  public static GlobalViewModelFactory a()
  {
    return jdField_a_of_type_ComTencentAelightCameraAebaseLifecycleGlobalViewModelFactory;
  }
  
  public void a(ViewModel paramViewModel)
  {
    if ((paramViewModel instanceof GlobalViewModel))
    {
      Object localObject = (AtomicInteger)this.b.get(paramViewModel.getClass().getName());
      if ((localObject != null) && (((AtomicInteger)localObject).decrementAndGet() == 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramViewModel.getClass().getName());
        this.b.remove(paramViewModel.getClass().getName());
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramViewModel.getClass().getName());
        localStringBuilder.append(" has removed");
        QLog.d((String)localObject, 1, localStringBuilder.toString());
      }
    }
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    if (GlobalViewModel.class.isAssignableFrom(paramClass))
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramClass.getName())) {
        try
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.getName(), paramClass.newInstance());
          this.b.put(paramClass.getName(), new AtomicInteger(0));
        }
        catch (InstantiationException localInstantiationException)
        {
          localInstantiationException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      localObject = (AtomicInteger)this.b.get(paramClass.getName());
      if (localObject != null)
      {
        ((AtomicInteger)localObject).incrementAndGet();
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass.getName());
        localStringBuilder.append(" has created and ref = ");
        localStringBuilder.append(((AtomicInteger)localObject).get());
        QLog.d(str, 1, localStringBuilder.toString());
      }
      return (ViewModel)this.jdField_a_of_type_JavaUtilHashMap.get(paramClass.getName());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot create non global view model ");
    ((StringBuilder)localObject).append(paramClass.getName());
    ((StringBuilder)localObject).append(" by GlobalViewModelFactory");
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.lifecycle.GlobalViewModelFactory
 * JD-Core Version:    0.7.0.1
 */