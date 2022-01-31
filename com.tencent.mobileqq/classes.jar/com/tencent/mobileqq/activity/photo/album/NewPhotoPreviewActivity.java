package com.tencent.mobileqq.activity.photo.album;

import aiqw;
import aiqy;
import aitd;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import aofm;
import azqs;
import bexu;
import bhvx;
import bnle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mbt;

public class NewPhotoPreviewActivity
  extends AbstractPhotoPreviewActivity
  implements bhvx
{
  public aiqw a;
  public View a;
  public BubblePopupWindow a;
  public DragView a;
  public HorizontalListView a;
  
  public void F()
  {
    Object localObject = this.adapter.getItem(getCurrentSelectedPostion());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = getMediaInfoTemp((String)localObject);
      if (localObject != null)
      {
        if (((LocalMediaInfo)localObject).mMediaType != 0) {
          break label77;
        }
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        azqs.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 4, 0, "", "", "", "");
      }
      this.mPhotoPreviewLogic.onBackPressed(true);
      return;
      label77:
      if (((LocalMediaInfo)localObject).mMediaType == 1) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void G()
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
  
  public void H() {}
  
  protected void a()
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)findViewById(2131365489));
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    if (localRect != null)
    {
      if (this.mEnableLiuHai) {
        i = bnle.a;
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
  
  public void a(float paramFloat)
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void c(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  public PhotoPreviewLogic generateLogic()
  {
    int i = getIntent().getIntExtra("enter_from", 0);
    PhotoPreviewLogic localPhotoPreviewLogic = aitd.a(i, this);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "generateLogic:" + localPhotoPreviewLogic.getClass().getName() + " enterFrom:" + i);
    }
    return localPhotoPreviewLogic;
  }
  
  public Class getBackActivity()
  {
    return NewPhotoListActivity.class;
  }
  
  public void hideMenuBar()
  {
    super.hideMenuBar();
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoPreviewActivity", 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    this.mPhotoPreviewLogic.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bnle.a(this);
    if (bnle.c()) {
      bnle.b(this);
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
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    mbt.a(BaseApplicationImpl.getContext(), false);
    bexu.a(BaseApplicationImpl.getContext(), true);
    aofm.a(BaseApplicationImpl.getContext(), 2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */