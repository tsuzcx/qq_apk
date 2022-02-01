package com.tencent.biz.pubaccount.weishi_new.profile;

import UserGrowth.stSimpleMetaPerson;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSView;
import com.tencent.biz.pubaccount.weishi_new.profile.data.WSProfileHomePageData;

public abstract interface WSProfileContract$View
  extends IWSView<WSProfileHomePageData>
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void a(@NonNull stSimpleMetaPerson paramstSimpleMetaPerson, boolean paramBoolean);
  
  public abstract void a(@NonNull String paramString);
  
  public abstract void a(@Nullable String paramString, boolean paramBoolean);
  
  public abstract void aP_();
  
  public abstract void aQ_();
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(@Nullable String paramString);
  
  public abstract String c();
  
  public abstract void c(int paramInt);
  
  public abstract void c(@Nullable String paramString);
  
  public abstract void d();
  
  public abstract void d(int paramInt);
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.View
 * JD-Core Version:    0.7.0.1
 */