package com.tencent.mobileqq.activity.photo.album;

import abqw;
import aime;
import aimf;
import aimg;
import aimj;
import aioo;
import aljq;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aobd;
import bdar;
import bdcs;
import bnnt;
import bnnu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lmm;

public class NewPhotoListActivity
  extends AbstractPhotoListActivity
{
  public static aimg a;
  public Handler a;
  View a;
  public Button a;
  public CheckBox a;
  public TextView a;
  public TextView b;
  public TextView c;
  TextView d;
  
  static
  {
    jdField_a_of_type_Aimg = new aimg();
  }
  
  public NewPhotoListActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new aimf(this);
  }
  
  public int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramString) == null)) {
      return -1;
    }
    return bdar.getMediaType(a(paramString));
  }
  
  public LocalMediaInfo a(String paramString)
  {
    aimj localaimj = this.mPhotoListLogic.mPhotoCommonData;
    LocalMediaInfo localLocalMediaInfo = null;
    if (localaimj.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)localaimj.selectedMediaInfoHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (localaimj.allMediaInfoHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)localaimj.allMediaInfoHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
      {
        bnnu localbnnu = new bnnu();
        bnnt.a(paramString, localbnnu);
        localLocalMediaInfo.mediaWidth = localbnnu.a[0];
        localLocalMediaInfo.mediaHeight = localbnnu.a[1];
        localLocalMediaInfo.rotation = localbnnu.a[2];
        if (localaimj.allMediaInfoHashMap != null)
        {
          paramString = (LocalMediaInfo)localaimj.allMediaInfoHashMap.get(paramString);
          if ((paramString != null) && ((paramString.mediaWidth == 0) || (paramString.mediaHeight == 0)))
          {
            paramString.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramString.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramString.rotation = localLocalMediaInfo.rotation;
          }
        }
      }
      return localLocalMediaInfo;
    }
  }
  
  String a(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      Object localObject = paramString;
      if (localFile.exists())
      {
        localObject = localFile.getName();
        String str = aljq.bk + (String)localObject;
        localObject = paramString;
        if (!str.equals(paramString))
        {
          localObject = new File(aljq.bk);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          boolean bool2 = localFile.renameTo(new File(str));
          boolean bool1 = bool2;
          if (!bool2) {
            bool1 = bdcs.b(paramString, str);
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
    if (lmm.b(BaseApplicationImpl.getContext())) {}
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
  
  public void a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
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
      excuteQueryPhotoTask();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    abqw.a().c();
    if (!CheckPermission.isHasStorageReadAndWritePermission(this)) {
      CheckPermission.requestStoreReadAndWritePermission(this, null);
    }
    return true;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    aobd.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  protected PhotoListLogic generateLogic()
  {
    int i = getIntent().getIntExtra("enter_from", 0);
    PhotoListLogic localPhotoListLogic = aioo.a(i, this);
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
    Dialog localDialog = new Dialog(this, 2131755801);
    localDialog.setContentView(2131559438);
    return localDialog;
  }
  
  public Class getJumpActivity()
  {
    return NewPhotoPreviewActivity.class;
  }
  
  protected void initUI()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131375981);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localRelativeLayout.setFitsSystemWindows(true);
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367310);
    this.d = ((TextView)findViewById(2131379325));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369974));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131373917));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373923));
    this.b = ((TextView)findViewById(2131373918));
    this.c = ((TextView)findViewById(2131368077));
    super.initUI();
    this.mGridView.setOnScrollListener(new aime(this));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.mPhotoListLogic.onMagicStickClick(paramView, new Bundle(), 2, null);
  }
  
  void processNewIntent(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("extra_directly_back", false))
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