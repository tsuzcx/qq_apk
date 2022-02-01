package com.tencent.biz.pubaccount.weishi_new.main;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

public abstract interface WSMainContract$Presenter
  extends IWSPresenter<WSMainContract.View>
{
  public abstract List<QBaseFragment> getFragments(Bundle paramBundle);
  
  @Nullable
  public abstract stSimpleMetaFeed getIntentFeed();
  
  @NonNull
  public abstract String getIntentFeedId();
  
  public abstract void handleIntent(Bundle paramBundle);
  
  public abstract void onRightLeftPageSelected(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSMainContract.Presenter
 * JD-Core Version:    0.7.0.1
 */