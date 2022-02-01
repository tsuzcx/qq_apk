package com.tencent.biz.pubaccount.weishi_new.profile;

import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stSimpleMetaPerson;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.util.ArrayList;

public abstract interface WSProfileContract$Presenter
  extends IWSPresenter<WSProfileContract.View>
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(@Nullable stSimpleMetaPerson paramstSimpleMetaPerson, @Nullable String paramString);
  
  public abstract void a(@Nullable Bundle paramBundle);
  
  public abstract void a(WSSimpleBaseEvent paramWSSimpleBaseEvent);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract ArrayList<Class> b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract stSimpleMetaPerson c();
  
  public abstract String d();
  
  public abstract stShareInfo e();
  
  public abstract boolean f();
  
  public abstract String g();
  
  public abstract boolean h();
  
  public abstract boolean i();
  
  public abstract boolean j();
  
  public abstract boolean k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.Presenter
 * JD-Core Version:    0.7.0.1
 */