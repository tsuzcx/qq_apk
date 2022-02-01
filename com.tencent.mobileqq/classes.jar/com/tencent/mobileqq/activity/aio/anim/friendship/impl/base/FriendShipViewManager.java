package com.tencent.mobileqq.activity.aio.anim.friendship.impl.base;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.anim.friendship.IFriendShipAnimManager;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FriendShipViewManager
  implements IFriendShipAnimManager
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, IDirector> jdField_a_of_type_JavaUtilHashMap;
  private String b;
  
  public FriendShipViewManager(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnResume");
    }
    IDirector localIDirector = (IDirector)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localIDirector != null) {
      localIDirector.d();
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("play anim ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("FriendShipViewManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0) {
      return false;
    }
    Object localObject = (IDirector)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localObject != null)
    {
      ((IDirector)localObject).b();
      ((IDirector)localObject).e();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), null);
      this.jdField_a_of_type_Int = 0;
    }
    IDirector localIDirector = (IDirector)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    localObject = localIDirector;
    if (localIDirector == null)
    {
      localObject = BaseDirector.a(paramInt, this.jdField_a_of_type_AndroidAppActivity);
      if (localObject == null) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
    }
    if ((localObject instanceof LottieAnimDirector)) {
      ((LottieAnimDirector)localObject).a(this.jdField_a_of_type_JavaLangString, this.b);
    }
    ((IDirector)localObject).a(new FriendShipViewManager.1(this, (IDirector)localObject));
    return true;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("play , url = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(paramString2);
    QLog.i("FriendShipViewManager", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    paramString1 = this.jdField_a_of_type_JavaLangString;
    if (paramString1 != null) {
      this.jdField_a_of_type_JavaLangString = paramString1.trim();
    }
    paramString1 = this.b;
    if (paramString1 != null) {
      this.b = paramString1.trim();
    }
    a(3);
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnPause");
    }
    IDirector localIDirector = (IDirector)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localIDirector != null) {
      localIDirector.c();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnDestroy");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() != null)
      {
        ((IDirector)localEntry.getValue()).b();
        ((IDirector)localEntry.getValue()).e();
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipViewManager
 * JD-Core Version:    0.7.0.1
 */