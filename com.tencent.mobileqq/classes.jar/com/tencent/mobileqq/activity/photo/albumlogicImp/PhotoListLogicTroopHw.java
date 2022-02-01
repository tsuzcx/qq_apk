package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

class PhotoListLogicTroopHw
  extends PhotoListLogicDefault
{
  private final int jdField_a_of_type_Int = 1024;
  private final long jdField_a_of_type_Long = 600000L;
  
  protected PhotoListLogicTroopHw(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (AlbumUtil.getMediaType(paramLocalMediaInfo) == 1) {}
    for (int i = 1; (i != 0) && (paramLocalMediaInfo.mDuration > 600000L); i = 0)
    {
      QQToast.a(this.mActivity, HardCodeUtil.a(2131708053) + 10L + HardCodeUtil.a(2131708065), 0).a();
      return false;
    }
    Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
    for (long l = 0L; localIterator.hasNext(); l = FileUtils.a((String)localIterator.next()) + l) {}
    if (FileUtils.a(paramLocalMediaInfo.path) + l > 1073741824L)
    {
      QQToast.a(this.mActivity, HardCodeUtil.a(2131708059) + "1.0G" + HardCodeUtil.a(2131708088), 0).a();
      return false;
    }
    return true;
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.isSupportVideoCheckbox) {
      return ((NewPhotoListActivity)this.mActivity).getString(2131697443, new Object[] { Integer.valueOf(i) });
    }
    return ((NewPhotoListActivity)this.mActivity).getString(2131697444, new Object[] { Integer.valueOf(i) });
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if (localLocalMediaInfo == null) {
      super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
    }
    while (!a(localLocalMediaInfo)) {
      return;
    }
    super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicTroopHw
 * JD-Core Version:    0.7.0.1
 */