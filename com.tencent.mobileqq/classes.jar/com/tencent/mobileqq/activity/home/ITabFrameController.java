package com.tencent.mobileqq.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import java.util.HashMap;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ITabFrameController
  extends QRouteApi
{
  public abstract void addFrame(FrameFragment paramFrameFragment, View paramView1, Class<? extends Frame> paramClass, View paramView2);
  
  public abstract Frame buildFrame(FrameFragment paramFrameFragment, String paramString);
  
  public abstract void doFramesPauseAfter(FrameFragment paramFrameFragment);
  
  public abstract void doOnEntry(FrameFragment paramFrameFragment, Intent paramIntent);
  
  public abstract String getCurrentTabTag(QQTabHost paramQQTabHost);
  
  public abstract FrameInfoBean getFrameInfoByClazz(Class paramClass);
  
  public abstract FrameInfoBean getFrameInfoByIndex(int paramInt);
  
  public abstract View[] getTabViews(LayoutInflater paramLayoutInflater);
  
  public abstract void handleThemeChanged(FrameFragment paramFrameFragment);
  
  public abstract boolean hasUnReadRedPacket(AppRuntime paramAppRuntime);
  
  public abstract View[] initTabs(FrameFragment paramFrameFragment, View paramView);
  
  public abstract boolean isFragmentNotMatch();
  
  public abstract boolean isLebaHasRedPoint(HashMap<String, View> paramHashMap);
  
  public abstract int mainTabID2TabIndex(Bundle paramBundle);
  
  public abstract void onDrawCompleteAfter(FrameFragment paramFrameFragment);
  
  public abstract void onResumeAfter(FrameFragment paramFrameFragment);
  
  public abstract void onResumeUpdateSound(FrameFragment paramFrameFragment);
  
  public abstract void revertTabIconChange(FrameFragment paramFrameFragment);
  
  public abstract void setCurrentIntentParams(FrameFragment paramFrameFragment);
  
  public abstract void setFrames(FrameFragment paramFrameFragment, boolean paramBoolean);
  
  public abstract void setSoundEffectsEnableForTab(HashMap<String, View> paramHashMap, boolean paramBoolean, String paramString);
  
  public abstract void updateFrames(FrameFragment paramFrameFragment, int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void updateRedTouch(FrameFragment paramFrameFragment, int paramInt, RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo);
  
  public abstract void updateTabContentDescription(FrameFragment paramFrameFragment, String paramString1, String paramString2);
  
  public abstract void updateTabDefaultFocusIcon(AppRuntime paramAppRuntime, boolean paramBoolean, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt);
  
  public abstract void updateTabRedTouch(FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo);
  
  public abstract void updateUIAfterTabChange(FrameFragment paramFrameFragment, String paramString1, String paramString2, Frame paramFrame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.ITabFrameController
 * JD-Core Version:    0.7.0.1
 */