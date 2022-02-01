package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoListLogicTroopFile
  extends PhotoListLogicDefault
{
  protected PhotoListLogicTroopFile(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.getTypeforReportSpcialDiscuss(this.a.a);
    paramIntent = new HashMap();
    int i1 = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while (i1 < this.mPhotoCommonData.selectedPhotoList.size())
    {
      paramArrayList = (String)this.mPhotoCommonData.selectedPhotoList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl(paramArrayList))
      {
        m = k;
        k = i;
        i = m;
        i1 += 1;
        m = k;
        k = i;
        i = m;
      }
      else
      {
        int n;
        if (((PhotoOtherData)this.mOtherCommonData).a(this.mPhotoCommonData, paramArrayList) == 1)
        {
          paramArrayList = ((PhotoOtherData)this.mOtherCommonData).a(this.mPhotoCommonData, paramArrayList);
          n = j;
          m = i;
          if (paramArrayList != null)
          {
            SendVideoActivity.SendVideoInfo localSendVideoInfo = new SendVideoActivity.SendVideoInfo();
            localSendVideoInfo.fileSize = paramArrayList.fileSize;
            localSendVideoInfo.duration = paramArrayList.mDuration;
            paramIntent.put(Integer.valueOf(k), localSendVideoInfo);
            m = i + 1;
            n = j;
          }
        }
        for (;;)
        {
          i = k + 1;
          j = n;
          k = m;
          break;
          n = j + 1;
          m = i;
        }
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, String.valueOf(j), String.valueOf(i), "", "");
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicTroopFile
 * JD-Core Version:    0.7.0.1
 */