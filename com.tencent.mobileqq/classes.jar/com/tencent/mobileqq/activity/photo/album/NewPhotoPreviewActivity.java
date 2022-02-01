package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomization;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.HorizontalListView;
import mqq.app.MobileQQ;

@RoutePage(desc="相册图片预览页面", path="/base/album/photopreview")
public class NewPhotoPreviewActivity
  extends AbstractPhotoPreviewActivity
{
  public boolean mEnableLiuHai;
  public BubblePopupWindow popup;
  public NewPhotoSelectedThumbAdapter selectedPhotoAdapter;
  View selectedPhotoListDivider;
  HorizontalListView selectedPhotoListView;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("[PhotoPreviewActivity] [onActivityResult] requestCode = ");
      paramIntent.append(paramInt1);
      paramIntent.append("  resultCode:");
      paramIntent.append(paramInt2);
      paramIntent.append("  ok:");
      paramIntent.append(-1);
      QLog.d("QQAlbum", 4, paramIntent.toString());
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    LiuHaiUtils.a(this);
    LiuHaiUtils.a(this);
    if (LiuHaiUtils.c()) {
      LiuHaiUtils.b(this);
    }
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    boolean bool = super.doOnCreate(paramBundle);
    this.mPhotoPreviewCustomization.a().mRoot.setFitsSystemWindows(true);
    return bool;
  }
  
  public void doOnDestroy()
  {
    BubblePopupWindow localBubblePopupWindow = this.popup;
    if (localBubblePopupWindow != null) {
      localBubblePopupWindow.dismiss();
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    SmallScreenUtils.a(MobileQQ.getContext(), false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(MobileQQ.getContext(), true);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(MobileQQ.getContext(), 2, true);
  }
  
  public PhotoPreviewCustomization<? extends OtherCommonData> generateCustomization()
  {
    int i = getIntent().getIntExtra("enter_from", 0);
    PhotoPreviewCustomization localPhotoPreviewCustomization = ((IPhotoLogicFactory)QRoute.api(IPhotoLogicFactory.class)).createPhotoPreviewLogic(this, getIntent());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateLogic:");
      localStringBuilder.append(localPhotoPreviewCustomization.getClass().getName());
      localStringBuilder.append(" enterFrom:");
      localStringBuilder.append(i);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    return localPhotoPreviewCustomization;
  }
  
  public void initNavigationBarColor()
  {
    ThemeNavigationBarUtil.a(getWindow(), -16777216);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */