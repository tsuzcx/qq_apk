package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class PhotoListCustomizationNearby
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby";
  
  PhotoListCustomizationNearby(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  private boolean h(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth >= 320) && (paramLocalMediaInfo.mediaHeight >= 320)) {
      return true;
    }
    paramLocalMediaInfo = DialogUtil.a(this.c, 230, null, HardCodeUtil.a(2131905891), HardCodeUtil.a(2131905876), null, null, new PhotoListCustomizationNearby.1(this));
    try
    {
      paramLocalMediaInfo.show();
    }
    catch (Exception paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListCustomizationNearby", 2, "showLocationFailDialog fail!", paramLocalMediaInfo);
      }
    }
    return false;
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if (h(this.h.t.a(paramInt))) {
      super.a(paramView, paramInt, paramCheckBox);
    }
  }
  
  public Intent b(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    if ((this.h.t.getItemViewType(paramInt) == 0) && (!h(localLocalMediaInfo))) {
      return null;
    }
    return super.b(paramView, paramInt);
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent != null) {
      super.b(paramIntent);
    }
  }
  
  public String c(LocalMediaInfo paramLocalMediaInfo)
  {
    return HardCodeUtil.a(2131892068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby
 * JD-Core Version:    0.7.0.1
 */