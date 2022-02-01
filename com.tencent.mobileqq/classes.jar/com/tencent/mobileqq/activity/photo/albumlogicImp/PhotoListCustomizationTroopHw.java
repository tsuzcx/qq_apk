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
  private final long i = 600000L;
  private final int j = 1024;
  
  protected PhotoListCustomizationTroopHw(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    if (localLocalMediaInfo == null)
    {
      super.a(paramView, paramInt, paramCheckBox);
      return;
    }
    if (h(localLocalMediaInfo)) {
      super.a(paramView, paramInt, paramCheckBox);
    }
  }
  
  public String c(LocalMediaInfo paramLocalMediaInfo)
  {
    int k = this.e.maxSelectNum;
    if (this.b.B) {
      return this.c.getString(2131895229, new Object[] { Integer.valueOf(k) });
    }
    return this.c.getString(2131895230, new Object[] { Integer.valueOf(k) });
  }
  
  boolean h(LocalMediaInfo paramLocalMediaInfo)
  {
    int k;
    if (AlbumUtil.getMediaType(paramLocalMediaInfo) == 1) {
      k = 1;
    } else {
      k = 0;
    }
    if ((k != 0) && (paramLocalMediaInfo.mDuration > 600000L))
    {
      paramLocalMediaInfo = this.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905871));
      ((StringBuilder)localObject).append(10L);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905882));
      QQToast.makeText(paramLocalMediaInfo, ((StringBuilder)localObject).toString(), 0).show();
      return false;
    }
    long l = 0L;
    Object localObject = this.e.selectedPhotoList.iterator();
    while (((Iterator)localObject).hasNext()) {
      l += FileUtils.getFileSizes((String)((Iterator)localObject).next());
    }
    if (l + FileUtils.getFileSizes(paramLocalMediaInfo.path) > 1073741824L)
    {
      paramLocalMediaInfo = this.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905877));
      ((StringBuilder)localObject).append("1.0G");
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905905));
      QQToast.makeText(paramLocalMediaInfo, ((StringBuilder)localObject).toString(), 0).show();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopHw
 * JD-Core Version:    0.7.0.1
 */