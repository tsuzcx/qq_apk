package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoLogicFactory;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.OnGestureChangeListener;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class NewPhotoPreviewActivity
  extends AbstractPhotoPreviewActivity
  implements DragView.OnGestureChangeListener
{
  View jdField_a_of_type_AndroidViewView;
  NewPhotoSelectedThumbAdapter jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoSelectedThumbAdapter;
  public BubblePopupWindow a;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  boolean jdField_a_of_type_Boolean;
  
  protected void a()
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)findViewById(2131366062));
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    if (localRect != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        i = LiuHaiUtils.a;
      }
      localRect.top -= i;
      localRect.bottom -= i;
      if ((this.mPhotoPreviewData.paths != null) && (-1 != this.mPhotoPreviewData.firstSelectedPostion) && (this.mPhotoPreviewData.paths.get(this.mPhotoPreviewData.firstSelectedPostion) != null))
      {
        LocalMediaInfo localLocalMediaInfo = getMediaInfo((String)this.mPhotoPreviewData.paths.get(this.mPhotoPreviewData.firstSelectedPostion));
        if (localLocalMediaInfo != null) {
          localLocalMediaInfo.thumbRect = localRect;
        }
      }
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(localRect);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetDragView.setEnableDrag(false);
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      AIOLongShotHelper.a(this, paramIntent);
    }
    while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      return;
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public PhotoPreviewLogic generateLogic()
  {
    int i = getIntent().getIntExtra("enter_from", 0);
    PhotoPreviewLogic localPhotoPreviewLogic = PhotoLogicFactory.a(i, this);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "generateLogic:" + localPhotoPreviewLogic.getClass().getName() + " enterFrom:" + i);
    }
    return localPhotoPreviewLogic;
  }
  
  public Class getBackActivity()
  {
    return NewPhotoListActivity.class;
  }
  
  void hideMenuBar()
  {
    super.hideMenuBar();
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
  }
  
  public void initNavigationBarColor()
  {
    ThemeNavigationBarUtil.a(getWindow(), -16777216);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoPreviewActivity", 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    this.mPhotoPreviewLogic.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClickDragView() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onContentMove(float paramFloat)
  {
    if (this.rootLayout != null)
    {
      Drawable localDrawable = this.rootLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      this.topBar.setVisibility(4);
      this.bottomBar.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    LiuHaiUtils.a(this);
    if (LiuHaiUtils.c()) {
      LiuHaiUtils.b(this);
    }
    super.onCreate(paramBundle);
    a();
    if (this.mPhotoPreviewLogic.mPhotoCommonData.myUin == null) {
      this.mPhotoPreviewLogic.mPhotoCommonData.myUin = this.lastLoginUin;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
    super.onDestroy();
  }
  
  public void onGestureFinish()
  {
    Object localObject = this.adapter.getItem(getCurrentSelectedPostion());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = getMediaInfoTemp((String)localObject);
      if (localObject != null)
      {
        if (((LocalMediaInfo)localObject).mMediaType != 0) {
          break label85;
        }
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 4, 0, "", "", "", "");
      }
      this.mPhotoPreviewLogic.onBackPressed(true);
      return;
      label85:
      if (((LocalMediaInfo)localObject).mMediaType == 1) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true);
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onResetPosition()
  {
    if (this.rootLayout != null)
    {
      Drawable localDrawable = this.rootLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(255);
      }
    }
    this.topBar.setVisibility(0);
    if (this.mPhotoPreviewLogic.needShowMultiPhoto())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */