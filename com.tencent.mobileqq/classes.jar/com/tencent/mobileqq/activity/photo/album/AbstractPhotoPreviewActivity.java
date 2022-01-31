package com.tencent.mobileqq.activity.photo.album;

import aiqf;
import aiqy;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apkp;
import bnsf;
import bnsg;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractPhotoPreviewActivity
  extends PeakActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public static final String FROM_WHERE_KEY = "FROM_WHERE";
  public static final String TAG = "PhotoPreviewActivity";
  public AbstractPhotoPreviewActivity.ImageAdapter adapter = new AbstractPhotoPreviewActivity.ImageAdapter(this);
  public TextView backToPhotoListBtn;
  public RelativeLayout bottomBar;
  public RelativeLayout bottom_blackLH;
  public TextView cancelTv;
  public CheckBox flashPicCb;
  public TextView flashTv;
  public DragGallery gallery;
  ImageView mCenterVideoPlayBtn;
  public boolean mEnableLiuHai = false;
  public PhotoPreviewBaseData mPhotoPreviewData;
  PhotoPreviewLogic mPhotoPreviewLogic;
  public SurfaceView mSurfaceView;
  public aiqf mVideoPlayController;
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
  public LinearLayout top_blackLH;
  
  public abstract PhotoPreviewLogic generateLogic();
  
  public abstract Class getBackActivity();
  
  public Drawable getCoverDrawable(String paramString, int paramInt1, int paramInt2, LocalMediaInfo paramLocalMediaInfo)
  {
    apkp localapkp = new apkp(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localapkp, localapkp);
        localURLDrawable.setTag(paramLocalMediaInfo);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception paramLocalMediaInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoPreviewActivity", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, paramLocalMediaInfo);
        }
      }
    }
    return localapkp;
  }
  
  public int getCurrentSelectedPostion()
  {
    return this.gallery.getSelectedItemPosition();
  }
  
  public String getExceedMaxSelectNumStr()
  {
    return getResources().getString(2131695260, new Object[] { Integer.valueOf(this.mPhotoPreviewLogic.mPhotoCommonData.maxSelectNum) });
  }
  
  public URL getFileUrl(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    String str = paramFile.getPath();
    if ((!TextUtils.isEmpty(str)) && (getMediaType(str) == 1)) {
      return QAlbumUtil.generateAlbumVideoThumbURL(str, "VIDEO");
    }
    try
    {
      paramFile = paramFile.toURI().toURL();
      return paramFile;
    }
    catch (MalformedURLException paramFile) {}
    return null;
  }
  
  public LocalMediaInfo getMediaInfo(String paramString)
  {
    if (this.mPhotoPreviewLogic.mPhotoCommonData.selectedMediaInfoHashMap != null) {}
    for (LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.mPhotoPreviewLogic.mPhotoCommonData.selectedMediaInfoHashMap.get(paramString);; localLocalMediaInfo = null)
    {
      if ((localLocalMediaInfo == null) && (this.mPhotoPreviewLogic.mPhotoCommonData.allMediaInfoHashMap != null)) {
        localLocalMediaInfo = (LocalMediaInfo)this.mPhotoPreviewLogic.mPhotoCommonData.allMediaInfoHashMap.get(paramString);
      }
      for (;;)
      {
        Object localObject;
        if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
        {
          localObject = new bnsg();
          bnsf.a(paramString, (bnsg)localObject);
          localLocalMediaInfo.mediaWidth = localObject.a[0];
          localLocalMediaInfo.mediaHeight = localObject.a[1];
          localLocalMediaInfo.rotation = localObject.a[2];
          localObject = this.mPhotoPreviewLogic.mPhotoCommonData.allMediaInfoHashMap;
          if (localObject == null) {
            break label196;
          }
        }
        label196:
        for (paramString = (LocalMediaInfo)((HashMap)localObject).get(paramString);; paramString = null)
        {
          if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
          {
            paramString.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramString.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramString.rotation = localLocalMediaInfo.rotation;
          }
          return localLocalMediaInfo;
        }
      }
    }
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
    if (i == 2131373968) {
      this.mPhotoPreviewLogic.onQualityBtnClick(paramCompoundButton, paramBoolean);
    }
    for (;;)
    {
      if ((!this.qualityCheckBox.isChecked()) && (!this.flashPicCb.isChecked()))
      {
        this.qualityTv.setTextColor(-1);
        this.flashTv.setTextColor(-1);
      }
      return;
      if (i == 2131366474) {
        this.mPhotoPreviewLogic.mOnCheckedChangedCallback.flashPicCheckedChanged(paramBoolean);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131559436);
    this.mSurfaceView = ((SurfaceView)findViewById(2131367029));
    this.mSurfaceView.setVisibility(8);
    this.rootLayout = ((RelativeLayout)findViewById(2131376035));
    this.topBar = findViewById(2131378144);
    this.bottomBar = ((RelativeLayout)findViewById(2131363377));
    this.magicStickBtn = ((Button)findViewById(2131369993));
    this.flashPicCb = ((CheckBox)findViewById(2131366474));
    this.flashTv = ((TextView)findViewById(2131366475));
    this.qualityCheckBox = ((CheckBox)findViewById(2131373968));
    this.qualityTv = ((TextView)findViewById(2131373974));
    this.cancelTv = ((TextView)findViewById(2131371892));
    this.sendBtn = ((Button)findViewById(2131376395));
    this.selectedBox = ((NumberCheckBox)findViewById(2131376372));
    this.selectLayout = findViewById(2131376352);
    this.titleView = ((TextView)findViewById(2131377938));
    this.backToPhotoListBtn = ((TextView)findViewById(2131363031));
    this.gallery = ((DragGallery)findViewById(2131367020));
    this.flashPicCb.setVisibility(8);
    this.flashTv.setVisibility(8);
    this.qualityCheckBox.setVisibility(8);
    this.qualityTv.setVisibility(8);
    this.magicStickBtn.setVisibility(8);
    this.mPhotoPreviewLogic = generateLogic();
    this.mPhotoPreviewData = this.mPhotoPreviewLogic.mPhotoPreviewData;
    this.mPhotoPreviewLogic.initData(getIntent());
    this.mPhotoPreviewLogic.initUI();
  }
  
  public void onDestroy()
  {
    QQLiveImage.onBackground(this);
    super.onDestroy();
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
    if (this.mVideoPlayController != null) {
      this.mVideoPlayController.i();
    }
  }
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
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
  
  public void showMenuBar()
  {
    this.mPhotoPreviewData.showBar = true;
    this.topBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */