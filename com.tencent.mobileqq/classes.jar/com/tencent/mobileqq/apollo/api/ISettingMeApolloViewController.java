package com.tencent.mobileqq.apollo.api;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/ISettingMeApolloViewController;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "destroyApollo", "", "getObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "getView", "Landroid/view/View;", "init", "settingMe", "Lcom/tencent/mobileqq/activity/QQSettingMe;", "content", "Landroid/view/ViewGroup;", "initApolloDrawerStatus", "onDestroy", "onDrawerClosed", "onDrawerOpened", "onPause", "recoverApollo", "refreshApolloView", "showExploreBox", "url", "", "updateCmshowStatus", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface ISettingMeApolloViewController
  extends QRouteApi
{
  public abstract void destroyApollo();
  
  @NotNull
  public abstract BusinessObserver getObserver();
  
  @NotNull
  public abstract View getView();
  
  public abstract void init(@Nullable QQSettingMe paramQQSettingMe, @Nullable ViewGroup paramViewGroup);
  
  public abstract void initApolloDrawerStatus();
  
  public abstract void onDestroy();
  
  public abstract void onDrawerClosed();
  
  public abstract void onDrawerOpened();
  
  public abstract void onPause();
  
  public abstract void recoverApollo();
  
  public abstract void refreshApolloView();
  
  public abstract void showExploreBox(@Nullable String paramString);
  
  public abstract void updateCmshowStatus();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ISettingMeApolloViewController
 * JD-Core Version:    0.7.0.1
 */