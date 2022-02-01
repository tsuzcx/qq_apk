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
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoListCustomizationDataline
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationDataline";
  
  protected PhotoListCustomizationDataline(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  protected void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAlbum", 2, "sendPicAndVideoToDataline...");
    }
    paramIntent.setClassName("com.tencent.mobileqq", "com.dataline.activities.LiteActivity");
    paramIntent.addFlags(603979776);
    paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
    paramIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramActivity.startActivityForResult(paramIntent, 2);
    paramActivity.finish();
    AlbumUtil.anim(paramActivity, false, false);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    paramArrayList = new HashMap();
    boolean bool = false;
    int i1 = 0;
    int j = 0;
    int i = 0;
    int n = 0;
    while (i1 < this.e.selectedPhotoList.size())
    {
      Object localObject = (String)this.e.selectedPhotoList.get(i1);
      if (!ImageManager.isNetworkUrl((String)localObject))
      {
        int k;
        int m;
        if (((PhotoOtherData)this.f).a(this.e, (String)localObject) == 1)
        {
          localObject = ((PhotoOtherData)this.f).b(this.e, (String)localObject);
          k = j;
          m = i;
          if (localObject != null)
          {
            SendVideoInfo localSendVideoInfo = new SendVideoInfo();
            localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
            localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
            paramArrayList.put(Integer.valueOf(n), localSendVideoInfo);
            m = i + 1;
            k = j;
          }
        }
        else
        {
          k = j + 1;
          m = i;
        }
        n += 1;
        i = m;
        j = k;
      }
      i1 += 1;
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
      paramIntent = new PhotoListCustomizationDataline.1(this, paramIntent);
      if (FreeWifiHelper.a(this.c, 4, new PhotoListCustomizationDataline.2(this, paramIntent))) {
        DialogUtil.a(this.c, 232, null, paramArrayList, new PhotoListCustomizationDataline.3(this, paramIntent), new PhotoListCustomizationDataline.4(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAlbum", 2, "show datalinephoto_mobile_send_confirm dialog");
      }
      return;
    }
    a(this.c, paramIntent, this.e.selectedPhotoList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationDataline
 * JD-Core Version:    0.7.0.1
 */