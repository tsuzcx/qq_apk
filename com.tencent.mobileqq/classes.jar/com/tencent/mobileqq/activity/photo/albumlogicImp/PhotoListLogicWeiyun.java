package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import cooperation.weiyun.utils.PreferenceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhotoListLogicWeiyun
  extends PhotoListLogicDefault
{
  private boolean a;
  
  PhotoListLogicWeiyun(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void b()
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if ((localNewPhotoListActivity == null) || (localNewPhotoListActivity.isFinishing())) {
      return;
    }
    Intent localIntent;
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))
    {
      StatisticCollector.getInstance(localNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      if (this.mPhotoCommonData.selectedPhotoList != null)
      {
        StatisticConstants.a(localNewPhotoListActivity.getIntent(), this.mPhotoCommonData.selectedPhotoList.size());
        StatisticConstants.a(localNewPhotoListActivity.getIntent(), this.mPhotoCommonData.selectedPhotoList.size(), this.mPhotoCommonData.currentQualityType);
      }
      localIntent = new Intent();
      if (this.mPhotoCommonData.selectedPhotoList != null) {
        break label252;
      }
    }
    label252:
    for (ArrayList localArrayList = new ArrayList(0);; localArrayList = this.mPhotoCommonData.selectedPhotoList)
    {
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      localNewPhotoListActivity.setResult(-1, localIntent);
      localNewPhotoListActivity.finish();
      AlbumUtil.anim(localNewPhotoListActivity, false, false);
      return;
      if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera")))
      {
        StatisticCollector.getInstance(localNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        break;
      }
      StatisticCollector.getInstance(localNewPhotoListActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
      break;
    }
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    Object localObject = (NewPhotoListActivity)this.mActivity;
    if ((localObject == null) || (((NewPhotoListActivity)localObject).isFinishing())) {
      return;
    }
    this.mPhotoCommonData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
    localObject = PreferenceUtils.a(((NewPhotoListActivity)localObject).getApplicationContext(), this.mPhotoCommonData.myUin, "pref_select_album");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = PreferenceUtils.a((String)localObject);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        this.mPhotoCommonData.albumId = ((String)((List)localObject).get(0));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.isRecodeLastAlbumPath = false;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.ENTER_ALBUM_LIST", false);
  }
  
  public boolean needVedio()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    Intent localIntent;
    if ((localNewPhotoListActivity != null) && (!localNewPhotoListActivity.isFinishing()) && (paramInt1 == 100010) && (paramInt2 == -1))
    {
      localIntent = new Intent();
      if (this.mPhotoCommonData.selectedPhotoList != null) {
        break label100;
      }
    }
    label100:
    for (ArrayList localArrayList = new ArrayList(0);; localArrayList = this.mPhotoCommonData.selectedPhotoList)
    {
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      localNewPhotoListActivity.setResult(-1, localIntent);
      localNewPhotoListActivity.finish();
      AlbumUtil.anim(localNewPhotoListActivity, false, false);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
  }
  
  public void onAlbumListShown(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
      onTitleBtnCancelClick(null);
    }
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if ((localNewPhotoListActivity != null) && (!localNewPhotoListActivity.isFinishing())) {
      localNewPhotoListActivity.setResult(-1, new Intent());
    }
    super.onTitleBtnCancelClick(paramView);
  }
  
  public void postInitUI()
  {
    super.postInitUI();
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if ((localNewPhotoListActivity == null) || (localNewPhotoListActivity.isFinishing())) {}
    do
    {
      return;
      View localView = localNewPhotoListActivity.findViewById(2131369487);
      if (localView != null) {
        localView.setContentDescription(localNewPhotoListActivity.getString(2131720758));
      }
    } while (!this.jdField_a_of_type_Boolean);
    enterAlbumListFragment(localNewPhotoListActivity.getIntent());
    localNewPhotoListActivity.transAlbumList(true);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if ((localNewPhotoListActivity == null) || (localNewPhotoListActivity.isFinishing())) {
      return;
    }
    localNewPhotoListActivity.startActivityForResult(paramIntent, 100010);
  }
  
  public void updateAddData(List<LocalMediaInfo> paramList, int paramInt)
  {
    int i = paramList.size();
    ArrayList localArrayList = ((NewPhotoListActivity)this.mActivity).getIntent().getStringArrayListExtra("weiyun_filter_data");
    if (localArrayList != null)
    {
      i -= 1;
      if (i >= paramInt)
      {
        Object localObject = (LocalMediaInfo)paramList.get(i);
        int j = ((LocalMediaInfo)localObject).path.lastIndexOf("/");
        String str = ((LocalMediaInfo)localObject).path.substring(j + 1);
        File localFile = new File(((LocalMediaInfo)localObject).path);
        if (localFile.exists()) {}
        for (localObject = str + localFile.length();; localObject = str + ((LocalMediaInfo)localObject).fileSize)
        {
          if (localArrayList.contains(localObject)) {
            paramList.remove(i);
          }
          i -= 1;
          break;
        }
      }
    }
    super.updateAddData(paramList, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicWeiyun
 * JD-Core Version:    0.7.0.1
 */