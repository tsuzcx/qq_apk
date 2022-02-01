package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.weiyun.utils.PreferenceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhotoListCustomizationWeiyun
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationWeiyun";
  private boolean i;
  
  PhotoListCustomizationWeiyun(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    NewPhotoListActivity localNewPhotoListActivity = this.c;
    if ((localNewPhotoListActivity != null) && (!localNewPhotoListActivity.isFinishing()) && (paramInt1 == 10010) && (paramInt2 == -1))
    {
      Intent localIntent = new Intent();
      ArrayList localArrayList;
      if (this.e.selectedPhotoList == null) {
        localArrayList = new ArrayList(0);
      } else {
        localArrayList = this.e.selectedPhotoList;
      }
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      localNewPhotoListActivity.setResult(-1, localIntent);
      localNewPhotoListActivity.finish();
      AlbumUtil.anim(localNewPhotoListActivity, false, false);
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((NewPhotoListActivity)localObject).isFinishing()) {
        return;
      }
      this.e.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      localObject = PreferenceUtils.a(((NewPhotoListActivity)localObject).getApplicationContext(), ((PhotoOtherData)this.f).e, "pref_select_album");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PreferenceUtils.a((String)localObject);
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          this.e.albumId = ((String)((List)localObject).get(0));
        }
      }
      this.b.N = false;
      this.i = paramIntent.getBooleanExtra("PhotoConst.ENTER_ALBUM_LIST", false);
      this.e.filter.needVideo = false;
    }
  }
  
  public void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    int j = paramList.size();
    ArrayList localArrayList = this.c.getIntent().getStringArrayListExtra("weiyun_filter_data");
    if (localArrayList != null)
    {
      j -= 1;
      while (j >= paramInt)
      {
        Object localObject1 = (LocalMediaInfo)paramList.get(j);
        int k = ((LocalMediaInfo)localObject1).path.lastIndexOf("/");
        String str = ((LocalMediaInfo)localObject1).path.substring(k + 1);
        Object localObject2 = new File(((LocalMediaInfo)localObject1).path);
        if (((File)localObject2).exists())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(((File)localObject2).length());
          str = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(((LocalMediaInfo)localObject1).fileSize);
          str = ((StringBuilder)localObject2).toString();
        }
        if (localArrayList.contains(str)) {
          paramList.remove(j);
        }
        j -= 1;
      }
    }
    super.a(paramList, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.i) && (!paramBoolean)) {
      b(null);
    }
  }
  
  public void b(Intent paramIntent)
  {
    NewPhotoListActivity localNewPhotoListActivity = this.c;
    if (localNewPhotoListActivity != null)
    {
      if (localNewPhotoListActivity.isFinishing()) {
        return;
      }
      localNewPhotoListActivity.startActivityForResult(paramIntent, 10010);
    }
  }
  
  public void b(View paramView)
  {
    NewPhotoListActivity localNewPhotoListActivity = this.c;
    if ((localNewPhotoListActivity != null) && (!localNewPhotoListActivity.isFinishing())) {
      localNewPhotoListActivity.setResult(-1, new Intent());
    }
    super.b(paramView);
  }
  
  protected void c()
  {
    NewPhotoListActivity localNewPhotoListActivity = this.c;
    if (localNewPhotoListActivity != null)
    {
      if (localNewPhotoListActivity.isFinishing()) {
        return;
      }
      if (this.e.albumId.equals("$RecentAlbumId")) {
        StatisticCollector.getInstance(localNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      } else if ((!this.e.albumName.equalsIgnoreCase("Camera")) && (!this.e.albumName.equalsIgnoreCase("camera")) && (!this.e.albumName.contains("Camera")) && (!this.e.albumName.contains("camera"))) {
        StatisticCollector.getInstance(localNewPhotoListActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
      } else {
        StatisticCollector.getInstance(localNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
      }
      if (this.e.selectedPhotoList != null)
      {
        StatisticConstants.a(localNewPhotoListActivity.getIntent(), this.e.selectedPhotoList.size());
        StatisticConstants.a(localNewPhotoListActivity.getIntent(), this.e.selectedPhotoList.size(), ((PhotoOtherData)this.f).d);
      }
      Intent localIntent = new Intent();
      ArrayList localArrayList;
      if (this.e.selectedPhotoList == null) {
        localArrayList = new ArrayList(0);
      } else {
        localArrayList = this.e.selectedPhotoList;
      }
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      localNewPhotoListActivity.setResult(-1, localIntent);
      localNewPhotoListActivity.finish();
      AlbumUtil.anim(localNewPhotoListActivity, false, false);
    }
  }
  
  public void k()
  {
    super.k();
    NewPhotoListActivity localNewPhotoListActivity = this.c;
    if (localNewPhotoListActivity != null)
    {
      if (localNewPhotoListActivity.isFinishing()) {
        return;
      }
      View localView = localNewPhotoListActivity.findViewById(2131436180);
      if (localView != null) {
        localView.setContentDescription(localNewPhotoListActivity.getString(2131918183));
      }
      if (this.i)
      {
        c(localNewPhotoListActivity.getIntent());
        this.h.a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationWeiyun
 * JD-Core Version:    0.7.0.1
 */