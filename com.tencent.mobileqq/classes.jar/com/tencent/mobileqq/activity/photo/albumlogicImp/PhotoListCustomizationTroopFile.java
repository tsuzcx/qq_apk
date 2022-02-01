package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoListCustomizationTroopFile
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopFile";
  
  protected PhotoListCustomizationTroopFile(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    paramIntent = new HashMap();
    int i = 0;
    int j = 0;
    while (i < this.e.selectedPhotoList.size())
    {
      paramArrayList = (String)this.e.selectedPhotoList.get(i);
      if (!ImageManager.isNetworkUrl(paramArrayList))
      {
        if (((PhotoOtherData)this.f).a(this.e, paramArrayList) == 1)
        {
          paramArrayList = ((PhotoOtherData)this.f).b(this.e, paramArrayList);
          if (paramArrayList != null)
          {
            SendVideoInfo localSendVideoInfo = new SendVideoInfo();
            localSendVideoInfo.fileSize = paramArrayList.fileSize;
            localSendVideoInfo.duration = paramArrayList.mDuration;
            paramIntent.put(Integer.valueOf(j), localSendVideoInfo);
          }
        }
        j += 1;
      }
      i += 1;
    }
    PhotoUtils.sendPhoto(this.c, this.c.getIntent(), this.e.selectedPhotoList, ((PhotoOtherData)this.f).d, this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopFile
 * JD-Core Version:    0.7.0.1
 */