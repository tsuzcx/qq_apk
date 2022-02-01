package com.tencent.mobileqq.activity.photo.album;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractPhotoPreviewActivity
  extends PeakActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public static final String FROM_WHERE_KEY = "FROM_WHERE";
  public static final String TAG = "PhotoPreviewActivity";
  public BasePreviewAdapter adapter;
  public TextView backToPhotoListBtn;
  RelativeLayout bottomBar;
  public TextView cancelTv;
  public CheckBox flashPicCb;
  public TextView flashTv;
  public DragGallery gallery;
  PhotoPreviewBaseData mPhotoPreviewData;
  PhotoPreviewLogic<? extends AbstractPhotoPreviewActivity, ? extends OtherCommonData> mPhotoPreviewLogic;
  public SurfaceView mSurfaceView;
  public Button magicStickBtn;
  float originalTextSize = 13.0F;
  public CheckBox qualityCheckBox;
  public TextView qualityTv;
  public int reqHeight;
  public int reqWidth;
  RelativeLayout rootLayout;
  public View selectLayout;
  public NumberCheckBox selectedBox;
  public Button sendBtn;
  float smallTextSize = 9.0F;
  public TextView titleView;
  public View topBar;
  
  private void updateMediaInfo(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo != null) && ((paramLocalMediaInfo.mediaWidth == 0) || (paramLocalMediaInfo.mediaHeight == 0)))
    {
      Object localObject = new MediaMetadataUtils.MetaData();
      MediaMetadataUtils.a(paramString, (MediaMetadataUtils.MetaData)localObject);
      paramLocalMediaInfo.mediaWidth = localObject.a[0];
      paramLocalMediaInfo.mediaHeight = localObject.a[1];
      paramLocalMediaInfo.rotation = localObject.a[2];
      localObject = null;
      HashMap localHashMap = this.mPhotoPreviewLogic.mPhotoCommonData.allMediaInfoHashMap;
      if (localHashMap != null) {
        localObject = (LocalMediaInfo)localHashMap.get(paramString);
      }
      if ((localObject != null) && ((((LocalMediaInfo)localObject).mediaWidth == 0) || (((LocalMediaInfo)localObject).mediaHeight == 0)))
      {
        ((LocalMediaInfo)localObject).mediaWidth = paramLocalMediaInfo.mediaWidth;
        ((LocalMediaInfo)localObject).mediaHeight = paramLocalMediaInfo.mediaHeight;
        ((LocalMediaInfo)localObject).rotation = paramLocalMediaInfo.rotation;
      }
    }
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
    return new PhotoPreviewLogicBase(this);
  }
  
  public abstract Class getBackActivity();
  
  public int getCurrentSelectedPostion()
  {
    return this.gallery.getSelectedItemPosition();
  }
  
  public String getExceedMaxSelectNumStr()
  {
    return getResources().getString(2131694869, new Object[] { Integer.valueOf(this.mPhotoPreviewLogic.mPhotoCommonData.maxSelectNum) });
  }
  
  public LocalMediaInfo getMediaInfo(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo1 = null;
    if (this.mPhotoPreviewLogic.mPhotoCommonData.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo1 = (LocalMediaInfo)this.mPhotoPreviewLogic.mPhotoCommonData.selectedMediaInfoHashMap.get(paramString);
    }
    LocalMediaInfo localLocalMediaInfo2 = localLocalMediaInfo1;
    if (localLocalMediaInfo1 == null)
    {
      localLocalMediaInfo2 = localLocalMediaInfo1;
      if (this.mPhotoPreviewLogic.mPhotoCommonData.allMediaInfoHashMap != null) {
        localLocalMediaInfo2 = (LocalMediaInfo)this.mPhotoPreviewLogic.mPhotoCommonData.allMediaInfoHashMap.get(paramString);
      }
    }
    updateMediaInfo(paramString, localLocalMediaInfo2);
    return localLocalMediaInfo2;
  }
  
  public LocalMediaInfo getMediaInfoTemp(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = getMediaInfo(paramString);
    paramString = localLocalMediaInfo;
    if (localLocalMediaInfo == null)
    {
      paramString = new LocalMediaInfo();
      paramString.mMediaType = 0;
    }
    return paramString;
  }
  
  public int getMediaType(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (getMediaInfo(paramString) == null)) {
      return -1;
    }
    return QAlbumUtil.getMediaType(getMediaInfo(paramString));
  }
  
  public ArrayList<String> getSubmitPhotoList()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mPhotoPreviewLogic.mPhotoCommonData.selectedPhotoList.isEmpty())
    {
      int i = this.gallery.getFirstVisiblePosition();
      if (i < this.mPhotoPreviewData.paths.size()) {
        localArrayList.add(this.mPhotoPreviewData.paths.get(i));
      }
      return localArrayList;
    }
    localArrayList.addAll(this.mPhotoPreviewLogic.mPhotoCommonData.selectedPhotoList);
    return localArrayList;
  }
  
  void hideMenuBar()
  {
    this.mPhotoPreviewData.showBar = false;
    this.topBar.setVisibility(4);
  }
  
  protected void initGallery()
  {
    this.gallery.setSupportMatchParent(true);
    this.gallery.setAdapter(this.adapter);
    this.gallery.setOnNoBlankListener(this.adapter);
    this.gallery.setOnItemSelectedListener(this.adapter);
    this.gallery.setSpacing(getResources().getDimensionPixelSize(2131297168));
    this.gallery.setOnItemClickListener(this.adapter);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    if ((this.gallery != null) && (this.gallery.a(false))) {
      return;
    }
    this.mPhotoPreviewLogic.onBackPressed(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = paramCompoundButton.getId();
    if (i == 2131375209) {
      this.mPhotoPreviewLogic.onQualityBtnClick(paramCompoundButton, paramBoolean);
    }
    for (;;)
    {
      if ((!this.qualityCheckBox.isChecked()) && (!this.flashPicCb.isChecked()))
      {
        this.qualityTv.setTextColor(-1);
        this.flashTv.setTextColor(-1);
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (i == 2131367122) {
        this.mPhotoPreviewLogic.mOnCheckedChangedCallback.flashPicCheckedChanged(paramBoolean);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131559682);
    if (Build.VERSION.SDK_INT >= 26)
    {
      int i = getWindow().getDecorView().getSystemUiVisibility();
      getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFEF);
    }
    this.mSurfaceView = ((SurfaceView)findViewById(2131367686));
    this.mSurfaceView.setVisibility(8);
    this.rootLayout = ((RelativeLayout)findViewById(2131377357));
    this.topBar = findViewById(2131379652);
    this.bottomBar = ((RelativeLayout)findViewById(2131363785));
    this.magicStickBtn = ((Button)findViewById(2131370969));
    this.flashPicCb = ((CheckBox)findViewById(2131367122));
    this.flashTv = ((TextView)findViewById(2131367123));
    this.qualityCheckBox = ((CheckBox)findViewById(2131375209));
    this.qualityTv = ((TextView)findViewById(2131375215));
    this.cancelTv = ((TextView)findViewById(2131373064));
    this.sendBtn = ((Button)findViewById(2131377769));
    this.selectedBox = ((NumberCheckBox)findViewById(2131377747));
    this.selectLayout = findViewById(2131377723);
    this.titleView = ((TextView)findViewById(2131379432));
    this.backToPhotoListBtn = ((TextView)findViewById(2131363416));
    this.gallery = ((DragGallery)findViewById(2131367677));
    this.flashPicCb.setVisibility(8);
    this.flashTv.setVisibility(8);
    this.qualityCheckBox.setVisibility(8);
    this.qualityTv.setVisibility(8);
    this.magicStickBtn.setVisibility(8);
    this.mPhotoPreviewLogic = generateLogic();
    this.mPhotoPreviewData = this.mPhotoPreviewLogic.mPhotoPreviewData;
    this.mPhotoPreviewLogic.initData(getIntent());
    this.adapter = this.mPhotoPreviewLogic.getPreviewAdapter();
    initGallery();
    this.mPhotoPreviewLogic.initUI();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.adapter.onDestroy();
    this.mPhotoPreviewLogic.doOnDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent.putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    setIntent(paramIntent);
    this.mPhotoPreviewLogic.initData(paramIntent);
    this.mPhotoPreviewLogic.initUI();
  }
  
  public void onPause()
  {
    super.onPause();
    this.adapter.onPause();
  }
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    this.adapter.onResume();
    this.mPhotoPreviewLogic.doOnResume();
  }
  
  public void setCheckedNumber(String paramString)
  {
    setCheckedNumber(paramString, -1);
  }
  
  public void setCheckedNumber(String paramString, int paramInt)
  {
    if (paramInt >= 0)
    {
      this.selectedBox.setCheckedNumber(paramInt);
      return;
    }
    paramInt = this.mPhotoPreviewLogic.mPhotoCommonData.selectedPhotoList.indexOf(paramString) + 1;
    if (paramInt <= 0)
    {
      this.selectedBox.setChecked(false);
      return;
    }
    if (paramInt >= 100) {
      this.selectedBox.setTextSize(this.smallTextSize);
    }
    for (;;)
    {
      this.selectedBox.setCheckedNumber(paramInt);
      return;
      this.selectedBox.setTextSize(this.originalTextSize);
    }
  }
  
  void showMenuBar()
  {
    this.mPhotoPreviewData.showBar = true;
    this.topBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */