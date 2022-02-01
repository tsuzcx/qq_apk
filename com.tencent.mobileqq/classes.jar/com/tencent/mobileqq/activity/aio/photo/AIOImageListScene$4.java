package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;

class AIOImageListScene$4
  implements AdapterView.OnItemClickListener
{
  AIOImageListScene$4(AIOImageListScene paramAIOImageListScene) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject1 = this.a.a.a(paramInt);
    if (!AIORichMediaInfo.class.isInstance(localObject1)) {}
    label646:
    for (;;)
    {
      return;
      localObject1 = (AIORichMediaInfo)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + AIOImageListScene.a(this.a).getFirstVisiblePosition() + " LastVisiblePosition " + AIOImageListScene.b(this.a).getLastVisiblePosition());
      }
      Object localObject2;
      int i;
      if (AIOImageListScene.a(this.a))
      {
        localObject2 = ((AIORichMediaInfo)localObject1).a;
        if (AIOFilePicData.class.isInstance(localObject2))
        {
          if ((((AIOFilePicData)localObject2).a(20) == null) && (((AIOFilePicData)localObject2).a(18) == null) && (((AIOFilePicData)localObject2).a(16) == null))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("AIOImageListScene", 2, "AIOFilePicData has null path,onItemClick: " + paramInt);
          }
        }
        else if (AIOLightVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
        {
          QQToast.a(AIOImageListScene.l(this.a), HardCodeUtil.a(2131700167), 0).a();
          return;
        }
        i = this.a.a();
        if (i == 1)
        {
          if (AIOShortVideoData.class.isInstance(localObject2)) {
            QQToast.a(AIOImageListScene.m(this.a), HardCodeUtil.a(2131700174), 0).a();
          }
        }
        else if (i == 2)
        {
          if (AIOImageData.class.isInstance(localObject2)) {
            QQToast.a(AIOImageListScene.n(this.a), HardCodeUtil.a(2131700172), 0).a();
          }
        }
        else {
          if ((i == 0) && (!AIOImageData.class.isInstance(localObject2))) {
            break label481;
          }
        }
        if (((AIORichMediaInfo)localObject1).getSelected() == 1)
        {
          i = 1;
          label343:
          localObject2 = this.a;
          if (i != 0) {
            break label510;
          }
          label354:
          ((AIOImageListScene)localObject2).a((AIORichMediaInfo)localObject1, bool, false);
          if (!this.a.a(paramView, (GalleryImage)localObject1)) {
            ((AbstractImageAdapter)paramAdapterView.getAdapter()).notifyDataSetChanged();
          }
          this.a.w();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label646;
        }
        QLog.d("AIOImageListScene", 2, "onItemClick" + paramInt + " FirstVisiblePosition " + AIOImageListScene.e(this.a).getFirstVisiblePosition() + " LastVisiblePosition " + AIOImageListScene.f(this.a).getLastVisiblePosition() + " SelectedIndex = " + this.a.a.b());
        return;
        label481:
        if ((AIOFilePicData.class.isInstance(localObject2)) || (!AIOShortVideoData.class.isInstance(localObject2))) {
          break;
        }
        break;
        i = 0;
        break label343;
        label510:
        bool = false;
        break label354;
        if (AIOLightVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOImageListScene", 2, "lightvideo could not be opened");
          }
          QQToast.a(AIOImageListScene.o(this.a), HardCodeUtil.a(2131700177), 0).a();
          return;
        }
        if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a)) {}
        this.a.a.e(paramInt);
        this.a.a.b(AIOImageListScene.c(this.a).getFirstVisiblePosition());
        this.a.a.c(AIOImageListScene.d(this.a).getLastVisiblePosition());
        this.a.t();
        this.a.a("Multi_Pic_big", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.4
 * JD-Core Version:    0.7.0.1
 */