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
    Object localObject1 = this.a.u.h(paramInt);
    if (!AIORichMediaInfo.class.isInstance(localObject1)) {
      return;
    }
    localObject1 = (AIORichMediaInfo)localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onItemClick");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" FirstVisiblePosition ");
      ((StringBuilder)localObject2).append(AIOImageListScene.l(this.a).getFirstVisiblePosition());
      ((StringBuilder)localObject2).append(" LastVisiblePosition ");
      ((StringBuilder)localObject2).append(AIOImageListScene.m(this.a).getLastVisiblePosition());
      QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject2).toString());
    }
    if (AIOImageListScene.n(this.a))
    {
      localObject2 = ((AIORichMediaInfo)localObject1).a;
      if (AIOFilePicData.class.isInstance(localObject2))
      {
        AIOFilePicData localAIOFilePicData = (AIOFilePicData)localObject2;
        if ((localAIOFilePicData.c(20) == null) && (localAIOFilePicData.c(18) == null) && (localAIOFilePicData.c(16) == null)) {
          if (QLog.isColorLevel())
          {
            paramAdapterView = new StringBuilder();
            paramAdapterView.append("AIOFilePicData has null path,onItemClick: ");
            paramAdapterView.append(paramInt);
            QLog.d("AIOImageListScene", 2, paramAdapterView.toString());
          }
        }
      }
      else if (AIOLightVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        QQToast.makeText(AIOImageListScene.o(this.a), HardCodeUtil.a(2131898348), 0).show();
        return;
      }
      int i = this.a.B();
      if (i == 1)
      {
        if (AIOShortVideoData.class.isInstance(localObject2)) {
          QQToast.makeText(AIOImageListScene.p(this.a), HardCodeUtil.a(2131898355), 0).show();
        }
      }
      else if (i == 2)
      {
        if (AIOImageData.class.isInstance(localObject2)) {
          QQToast.makeText(AIOImageListScene.q(this.a), HardCodeUtil.a(2131898353), 0).show();
        }
      }
      else if ((i == 0) && (!AIOImageData.class.isInstance(localObject2)) && (!AIOFilePicData.class.isInstance(localObject2))) {
        AIOShortVideoData.class.isInstance(localObject2);
      }
      if (((AIORichMediaInfo)localObject1).getSelected() == 1) {
        i = 1;
      } else {
        i = 0;
      }
      this.a.a((AIORichMediaInfo)localObject1, i ^ 0x1, false);
      if (!this.a.a(paramView, (GalleryImage)localObject1)) {
        ((AbstractImageAdapter)paramAdapterView.getAdapter()).notifyDataSetChanged();
      }
      this.a.A();
    }
    else
    {
      if (AIOLightVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageListScene", 2, "lightvideo could not be opened");
        }
        QQToast.makeText(AIOImageListScene.r(this.a), HardCodeUtil.a(2131898358), 0).show();
        return;
      }
      AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a);
      this.a.u.g(paramInt);
      this.a.u.d(AIOImageListScene.s(this.a).getFirstVisiblePosition());
      this.a.u.e(AIOImageListScene.t(this.a).getLastVisiblePosition());
      this.a.D();
      this.a.a("Multi_Pic_big", 1);
    }
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("onItemClick");
      paramAdapterView.append(paramInt);
      paramAdapterView.append(" FirstVisiblePosition ");
      paramAdapterView.append(AIOImageListScene.u(this.a).getFirstVisiblePosition());
      paramAdapterView.append(" LastVisiblePosition ");
      paramAdapterView.append(AIOImageListScene.v(this.a).getLastVisiblePosition());
      paramAdapterView.append(" SelectedIndex = ");
      paramAdapterView.append(this.a.u.b());
      QLog.d("AIOImageListScene", 2, paramAdapterView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.4
 * JD-Core Version:    0.7.0.1
 */