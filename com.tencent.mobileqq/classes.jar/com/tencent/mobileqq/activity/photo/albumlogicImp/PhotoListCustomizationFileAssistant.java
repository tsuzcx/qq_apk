package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoListCustomizationFileAssistant
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant";
  
  public PhotoListCustomizationFileAssistant(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListCustomizationFileAssistant", 1, "...onActivityResult...");
    }
    this.c.setResult(-1, paramIntent);
    this.c.finish();
    AlbumUtil.anim(this.c, false, false);
  }
  
  protected void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListCustomizationFileAssistant", 1, "sendPicAndVideoToFileAssistant...");
    }
    paramIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
    paramIntent.addFlags(603979776);
    paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
    paramIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramActivity.setResult(-1, paramIntent);
    paramActivity.finish();
    AlbumUtil.anim(paramActivity, false, false);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    paramArrayList = new HashMap();
    boolean bool = false;
    int i = 0;
    int j = 0;
    while (i < this.e.selectedPhotoList.size())
    {
      if (!ImageManager.isNetworkUrl((String)this.e.selectedPhotoList.get(i)))
      {
        LocalMediaInfo localLocalMediaInfo = this.h.t.a(i);
        if ((AlbumUtil.getMediaType(localLocalMediaInfo) == 1) && (localLocalMediaInfo != null))
        {
          SendVideoInfo localSendVideoInfo = new SendVideoInfo();
          localSendVideoInfo.fileSize = localLocalMediaInfo.fileSize;
          localSendVideoInfo.duration = localLocalMediaInfo.mDuration;
          paramArrayList.put(Integer.valueOf(j), localSendVideoInfo);
        }
        j += 1;
      }
      i += 1;
    }
    if (!paramArrayList.isEmpty())
    {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
      i = 1;
    }
    else
    {
      i = 0;
    }
    paramBoolean = bool;
    if (SVBusiUtil.c != 0L)
    {
      paramBoolean = bool;
      if (System.currentTimeMillis() - SVBusiUtil.c < 300000L) {
        paramBoolean = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("PhotoListCustomizationDataline isConfirmed=");
      paramArrayList.append(paramBoolean);
      paramArrayList.append(" allowUploadInXGTime=");
      paramArrayList.append(SVBusiUtil.c);
      QLog.d("QQAlbum", 2, paramArrayList.toString());
    }
    if ((NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) && (!paramBoolean) && (i != 0))
    {
      paramArrayList = this.c.getResources().getString(2131916238);
      paramIntent = new PhotoListCustomizationFileAssistant.1(this, paramIntent);
      if (FreeWifiHelper.a(this.c, 4, new PhotoListCustomizationFileAssistant.2(this, paramIntent))) {
        DialogUtil.a(this.c, 232, null, paramArrayList, new PhotoListCustomizationFileAssistant.3(this, paramIntent), new PhotoListCustomizationFileAssistant.4(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAlbum", 2, "show datalinephoto_mobile_send_confirm dialog");
      }
      return;
    }
    a(this.c, paramIntent, this.e.selectedPhotoList);
  }
  
  public void b(Intent paramIntent)
  {
    this.c.startActivityForResult(paramIntent, 10010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant
 * JD-Core Version:    0.7.0.1
 */