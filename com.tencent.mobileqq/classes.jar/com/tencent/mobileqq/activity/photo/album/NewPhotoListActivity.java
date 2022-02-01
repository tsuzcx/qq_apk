package com.tencent.mobileqq.activity.photo.album;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoLogicFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.PhotoGridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NewPhotoListActivity
  extends AbstractPhotoListActivity
{
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  public CheckBox a;
  public TextView a;
  NewPhotoListActivity.QZoneGetAlbumListNumObserver jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity$QZoneGetAlbumListNumObserver = new NewPhotoListActivity.QZoneGetAlbumListNumObserver(this);
  public TextView b;
  public TextView c;
  TextView d;
  
  public NewPhotoListActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new NewPhotoListActivity.NewPhotoListActivityHandler(this);
  }
  
  public static String a(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      Object localObject = paramString;
      if (localFile.exists())
      {
        localObject = localFile.getName();
        String str = AppConstants.SDCARD_IMG_CAMERA + (String)localObject;
        localObject = paramString;
        if (!str.equals(paramString))
        {
          localObject = new File(AppConstants.SDCARD_IMG_CAMERA);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          boolean bool2 = localFile.renameTo(new File(str));
          boolean bool1 = bool2;
          if (!bool2) {
            bool1 = FileUtils.b(paramString, str);
          }
          QLog.d("PhotoListActivity", 2, new Object[] { "saveToDCIM rename to :", str });
          localObject = paramString;
          if (bool1) {
            localObject = str;
          }
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PhotoListActivity", 2, "saveToDCIM :", localThrowable);
    }
    return paramString;
  }
  
  public void a()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {}
    label27:
    do
    {
      return;
      Intent localIntent = new Intent();
      Object localObject = null;
      try
      {
        File localFile = createImageFile();
        localObject = localFile;
      }
      catch (IOException localIOException)
      {
        break label27;
      }
    } while (localObject == null);
    FileProvider7Helper.setSystemCapture(this, localObject, localIntent);
    startActivityForResult(localIntent, 16);
  }
  
  public void a(String paramString)
  {
    try
    {
      FileProvider7Helper.savePhotoToSysAlbum(this, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("PhotoListActivity", 2, "scanMediaFile :", paramString);
    }
  }
  
  void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramList != null) && (paramHashMap != null) && (this.mPhotoListLogic.mPhotoCommonData.allMediaInfoHashMap != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!paramHashMap.containsKey(str)) {
          paramHashMap.put(str, this.mPhotoListLogic.mPhotoCommonData.allMediaInfoHashMap.get(str));
        }
      }
    }
  }
  
  protected boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      boolean bool3 = paramIntent.getBooleanExtra("extra_directly_back", false);
      boolean bool4 = paramIntent.getBooleanExtra("PhotoConst.IS_VIDEO_RECORDED", false);
      bool1 = bool2;
      if (bool3)
      {
        if (!bool4) {
          break label50;
        }
        this.mPhotoListLogic.handleVideoCapture(paramIntent);
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label50:
      this.mPhotoListLogic.handlePicCapture(paramIntent);
    }
  }
  
  public void b()
  {
    if (((this.mPhotoListData.isShowCamera) && ("$RecentAlbumId".equals(this.mPhotoListLogic.mPhotoCommonData.albumId))) || ((this.mPhotoListData.showCameraInVideo) && ("$VideoAlbumId".equals(this.mPhotoListLogic.mPhotoCommonData.albumId)))) {
      excuteQueryPhotoTask(true);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!CheckPermission.isHasStorageReadAndWritePermission(this)) {
      CheckPermission.requestStoreReadAndWritePermission(this, null);
    }
    return true;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  protected PhotoListLogic generateLogic()
  {
    int i = getIntent().getIntExtra("enter_from", 0);
    PhotoListLogic localPhotoListLogic = PhotoLogicFactory.a(i, this);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "generateLogic:" + localPhotoListLogic.getClass().getName() + " enterFrom:" + i);
    }
    return localPhotoListLogic;
  }
  
  public AbstractAlbumListFragment getAlbumListFragment()
  {
    return new AlbumListFragment();
  }
  
  protected Dialog getDialog()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755842);
    localReportDialog.setContentView(2131559683);
    return localReportDialog;
  }
  
  public Class getJumpActivity()
  {
    return NewPhotoPreviewActivity.class;
  }
  
  protected void initUI()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131377356);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localRelativeLayout.setFitsSystemWindows(true);
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368071);
    this.d = ((TextView)findViewById(2131381000));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370969));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131375209));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375215));
    this.b = ((TextView)findViewById(2131375210));
    this.c = ((TextView)findViewById(2131368901));
    super.initUI();
    this.mGridView.addOnScrollListener(new NewPhotoListActivity.1(this));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.mPhotoListLogic.onMagicStickClick(paramView, new Bundle(), 2, null);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  void processNewIntent(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("extra_directly_back", false);
    if (paramIntent.getIntExtra("p_e_s_type", 0) == 7)
    {
      this.mPhotoListData.needQueryTask = false;
      this.mPhotoListLogic.initData(paramIntent);
      return;
    }
    if (bool)
    {
      this.mPhotoListData.needQueryTask = false;
      a(paramIntent);
      QLog.d("PhotoListActivity", 2, "PhotoListActivity onNewIntent() camera back");
      return;
    }
    setIntent(paramIntent);
    this.mPhotoListLogic.initData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity
 * JD-Core Version:    0.7.0.1
 */