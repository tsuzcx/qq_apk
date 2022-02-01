package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.utils.AlbumUtil;
import java.util.List;

public class PhotoListLogicHealthEntry
  extends PhotoListLogicDefault
{
  private int a;
  private int b;
  private int c;
  
  public PhotoListLogicHealthEntry(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void b()
  {
    if ((this.mPhotoCommonData != null) && (this.mPhotoCommonData.selectedPhotoList != null) && (this.mActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("img_list", this.mPhotoCommonData.selectedPhotoList);
      ((NewPhotoListActivity)this.mActivity).setResult(-1, localIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      AlbumUtil.anim(this.mActivity, false, false);
    }
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a = paramIntent.getIntExtra("min_width", 200);
    this.b = paramIntent.getIntExtra("min_height", 200);
    this.c = paramIntent.getIntExtra("max_gif_size", 8388608);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        if (paramInt1 != 100010) {
          break;
        }
      } while ((this.mPhotoCommonData.selectedPhotoList == null) || (this.mActivity == null));
      paramIntent = new Intent();
      paramIntent.putStringArrayListExtra("img_list", this.mPhotoCommonData.selectedPhotoList);
      ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      return;
    } while (paramInt1 != 17);
    ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
    ((NewPhotoListActivity)this.mActivity).finish();
  }
  
  public void updateAddData(List<LocalMediaInfo> paramList, int paramInt)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.get(i);
        if ((!localLocalMediaInfo.path.endsWith(".gif")) && ((localLocalMediaInfo.mediaHeight < this.b) || (localLocalMediaInfo.mediaWidth < this.a))) {
          paramList.remove(i);
        }
        if ((localLocalMediaInfo.path.endsWith(".gif")) && (localLocalMediaInfo.fileSize > this.c)) {
          paramList.remove(i);
        }
        i -= 1;
      }
    }
    super.updateAddData(paramList, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicHealthEntry
 * JD-Core Version:    0.7.0.1
 */