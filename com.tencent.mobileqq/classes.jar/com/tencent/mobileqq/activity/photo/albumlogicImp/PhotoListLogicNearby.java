package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class PhotoListLogicNearby
  extends PhotoListLogicDefault
{
  PhotoListLogicNearby(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth < 320) || (paramLocalMediaInfo.mediaHeight < 320))
    {
      paramLocalMediaInfo = DialogUtil.a(this.mActivity, 230, null, HardCodeUtil.a(2131708074), HardCodeUtil.a(2131708058), null, null, new PhotoListLogicNearby.1(this));
      try
      {
        paramLocalMediaInfo.show();
        return false;
      }
      catch (Exception paramLocalMediaInfo)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListLogicNearby", 2, "showLocationFailDialog fail!", paramLocalMediaInfo);
          }
        }
      }
    }
    return true;
  }
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((((NewPhotoListActivity)this.mActivity).photoListAdapter.getItemViewType(paramInt) == 0) && (!a(localLocalMediaInfo))) {
      return null;
    }
    return super.caseNoSingModeImage(paramView, paramInt);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    return HardCodeUtil.a(2131694424);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if (a(((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt))) {
      super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (paramIntent != null) {
      super.startPhotoPreviewActivity(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicNearby
 * JD-Core Version:    0.7.0.1
 */