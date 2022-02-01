package com.tencent.mobileqq.app.proxy;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.service.message.RecentConvInfo;
import java.util.List;

public abstract interface RecentUserProxy
{
  public abstract RecentUser a(String paramString, int paramInt);
  
  public abstract Entity a(@NonNull Object paramObject);
  
  public abstract RecentConvInfo a(String paramString, int paramInt);
  
  public abstract List<RecentUser> a();
  
  public abstract List<RecentUser> a(boolean paramBoolean);
  
  public abstract List<RecentUser> a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract List<RecentUser> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(RecentUser paramRecentUser);
  
  public abstract void a(RecentUser paramRecentUser, boolean paramBoolean);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract boolean a(@NonNull RecentUser paramRecentUser);
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, int paramInt);
  
  public abstract RecentUser b(String paramString, int paramInt);
  
  public abstract void b();
  
  public abstract void b(RecentUser paramRecentUser);
  
  public abstract void b(RecentUser paramRecentUser, boolean paramBoolean);
  
  public abstract boolean b(@NonNull String paramString);
  
  public abstract void c();
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.RecentUserProxy
 * JD-Core Version:    0.7.0.1
 */