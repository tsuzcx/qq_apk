package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.utils.AlbumUtil;

public class PhotoListCustomizationExtendFriendPhotoWall
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationExtendFriendPhotoWall";
  
  protected PhotoListCustomizationExtendFriendPhotoWall(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 10015))
    {
      this.c.setResult(-1, paramIntent);
      this.c.finish();
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.e.customSendBtnText = this.c.getString(2131892542);
  }
  
  public void b(Intent paramIntent)
  {
    this.c.startActivityForResult(paramIntent, 10015);
  }
  
  public String c(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.e.maxSelectNum;
    return this.c.getString(2131892552, new Object[] { Integer.valueOf(i) });
  }
  
  protected void c()
  {
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
    this.c.setResult(-1, localIntent);
    this.c.finish();
    AlbumUtil.anim(this.c, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationExtendFriendPhotoWall
 * JD-Core Version:    0.7.0.1
 */