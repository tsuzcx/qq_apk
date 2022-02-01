package com.tencent.mobileqq.activity.photo.album.logicImp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoListLogicFileAssistant
  extends PhotoListLogicDefault
{
  public PhotoListLogicFileAssistant(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  protected void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListLogicFileAssistant", 1, "sendPicAndVideoToFileAssistant...");
    }
    paramIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
    paramIntent.addFlags(603979776);
    paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
    paramIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramActivity.setResult(-1, paramIntent);
    paramActivity.finish();
    AlbumUtil.anim(paramActivity, false, false);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.getTypeforReportSpcialDiscuss(this.a.a);
    paramArrayList = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int n = 0;
    while (n < this.mPhotoCommonData.selectedPhotoList.size()) {
      if (ImageManager.isNetworkUrl((String)this.mPhotoCommonData.selectedPhotoList.get(n)))
      {
        n += 1;
      }
      else
      {
        localObject1 = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(n);
        int m;
        int k;
        if (AlbumUtil.getMediaType((LocalMediaInfo)localObject1) == 1)
        {
          m = i;
          k = j;
          if (localObject1 != null)
          {
            localObject2 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
            paramArrayList.put(Integer.valueOf(i1), localObject2);
            k = j + 1;
            m = i;
          }
        }
        for (;;)
        {
          i1 += 1;
          i = m;
          j = k;
          break;
          m = i + 1;
          k = j;
        }
      }
    }
    Object localObject1 = String.valueOf(i);
    Object localObject2 = String.valueOf(j);
    if (!paramArrayList.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
    }
    for (i = 1;; i = 0)
    {
      if ((ShortVideoBusiManager.b != 0L) && (System.currentTimeMillis() - ShortVideoBusiManager.b < 300000L)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListLogicDataline isConfirmed=" + paramBoolean + " allowUploadInXGTime=" + ShortVideoBusiManager.b);
        }
        if ((!NetworkUtil.b(BaseApplicationImpl.getContext())) || (paramBoolean) || (i == 0)) {
          break;
        }
        paramArrayList = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719019);
        paramIntent = new PhotoListLogicFileAssistant.1(this, paramIntent, i2, (String)localObject1, (String)localObject2);
        if (FreeWifiHelper.a(this.mActivity, 4, new PhotoListLogicFileAssistant.2(this, paramIntent))) {
          DialogUtil.a(this.mActivity, 232, null, paramArrayList, new PhotoListLogicFileAssistant.3(this, paramIntent), new PhotoListLogicFileAssistant.4(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show datalinephoto_mobile_send_confirm dialog");
        }
        return;
      }
      a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList);
      ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject1, (String)localObject2, "", "");
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListLogicFileAssistant", 1, "...onActivityResult...");
    }
    ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
    ((NewPhotoListActivity)this.mActivity).finish();
    AlbumUtil.anim(this.mActivity, false, false);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 100010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicFileAssistant
 * JD-Core Version:    0.7.0.1
 */