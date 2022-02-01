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
  private Activity a;
  private HashMap<Integer, IDirector> b;
  private int c;
  private String d;
  private String e;
  
  public FriendShipViewManager(@NonNull Activity paramActivity)
  {
    this.a = paramActivity;
    this.b = new HashMap();
    this.c = 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnResume");
    }
    IDirector localIDirector = (IDirector)this.b.get(Integer.valueOf(this.c));
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
    Object localObject = (IDirector)this.b.get(Integer.valueOf(this.c));
    if (localObject != null)
    {
      ((IDirector)localObject).b();
      ((IDirector)localObject).e();
      this.b.put(Integer.valueOf(this.c), null);
      this.c = 0;
    }
    IDirector localIDirector = (IDirector)this.b.get(Integer.valueOf(paramInt));
    localObject = localIDirector;
    if (localIDirector == null)
    {
      localObject = BaseDirector.a(paramInt, this.a);
      if (localObject == null) {
        return false;
      }
      this.b.put(Integer.valueOf(paramInt), localObject);
    }
    if ((localObject instanceof LottieAnimDirector)) {
      ((LottieAnimDirector)localObject).a(this.d, this.e);
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
    this.d = paramString1;
    this.e = paramString2;
    paramString1 = this.d;
    if (paramString1 != null) {
      this.d = paramString1.trim();
    }
    paramString1 = this.e;
    if (paramString1 != null) {
      this.e = paramString1.trim();
    }
    a(3);
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnPause");
    }
    IDirector localIDirector = (IDirector)this.b.get(Integer.valueOf(this.c));
    if (localIDirector != null) {
      localIDirector.c();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipViewManager", 2, "doOnDestroy");
    }
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() != null)
      {
        ((IDirector)localEntry.getValue()).b();
        ((IDirector)localEntry.getValue()).e();
      }
    }
    this.b.clear();
    this.c = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipViewManager
 * JD-Core Version:    0.7.0.1
 */