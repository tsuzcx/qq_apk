package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

public class PhotoListCustomizationTroopHw
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopHw";
  private final int jdField_a_of_type_Int = 1024;
  private final long jdField_a_of_type_Long = 600000L;
  
  protected PhotoListCustomizationTroopHw(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2131697456, new Object[] { Integer.valueOf(i) });
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2131697457, new Object[] { Integer.valueOf(i) });
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a(paramInt);
    if (localLocalMediaInfo == null)
    {
      super.a(paramView, paramInt, paramCheckBox);
      return;
    }
    if (a(localLocalMediaInfo)) {
      super.a(paramView, paramInt, paramCheckBox);
    }
  }
  
  boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i;
    if (AlbumUtil.getMediaType(paramLocalMediaInfo) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (paramLocalMediaInfo.mDuration > 600000L))
    {
      paramLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131708072));
      ((StringBuilder)localObject).append(10L);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131708084));
      QQToast.a(paramLocalMediaInfo, ((StringBuilder)localObject).toString(), 0).a();
      return false;
    }
    long l = 0L;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
    while (((Iterator)localObject).hasNext()) {
      l += FileUtils.getFileSizes((String)((Iterator)localObject).next());
    }
    if (l + FileUtils.getFileSizes(paramLocalMediaInfo.path) > 1073741824L)
    {
      paramLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131708078));
      ((StringBuilder)localObject).append("1.0G");
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131708107));
      QQToast.a(paramLocalMediaInfo, ((StringBuilder)localObject).toString(), 0).a();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopHw
 * JD-Core Version:    0.7.0.1
 */