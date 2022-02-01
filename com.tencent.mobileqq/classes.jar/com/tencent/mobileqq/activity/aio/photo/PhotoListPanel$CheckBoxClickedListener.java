package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class PhotoListPanel$CheckBoxClickedListener
  implements View.OnClickListener
{
  int a;
  CheckBox b;
  
  public PhotoListPanel$CheckBoxClickedListener(PhotoListPanel paramPhotoListPanel) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.b = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if ((this.c.f != null) && (this.c.f.getItemCount() > 0))
    {
      LocalMediaInfo localLocalMediaInfo = this.c.f.a(this.a);
      int j = this.c.f.getItemViewType(this.a);
      if ((!localLocalMediaInfo.mChecked) && (AlbumUtil.a(this.c.d, this.c.k, PhotoListPanel.a)))
      {
        this.b.setChecked(localLocalMediaInfo.mChecked);
      }
      else
      {
        int i;
        if ((this.c.l.a == 9501) && (!localLocalMediaInfo.mChecked))
        {
          Object localObject = this.c.d.iterator();
          String str;
          for (i = 0; ((Iterator)localObject).hasNext(); i = (int)(i + FileUtils.getFileSizes(str))) {
            str = (String)((Iterator)localObject).next();
          }
          if (i + FileUtils.getFileSizes(localLocalMediaInfo.path) > 52428800L)
          {
            localObject = (SmartDeviceProxyMgr)this.c.i.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
            if ((localObject != null) && (((SmartDeviceProxyMgr)localObject).c()))
            {
              long l1 = 0L;
              try
              {
                long l2 = Long.parseLong(this.c.l.b);
                l1 = l2;
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
              if (((SmartDeviceProxyMgr)localObject).a(l1, 1))
              {
                QQToast.makeText(this.c.k, "选择图片总大小不能超过50M", 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
                this.b.setChecked(localLocalMediaInfo.mChecked);
                break label633;
              }
            }
          }
        }
        localLocalMediaInfo.mChecked ^= true;
        this.b.setChecked(localLocalMediaInfo.mChecked);
        if (localLocalMediaInfo.mChecked)
        {
          if (j == 0) {
            this.c.a(localLocalMediaInfo.path, this.c.l.s);
          }
          this.c.d.add(localLocalMediaInfo.path);
          this.c.u.add(localLocalMediaInfo.position);
          if (this.c.V != null) {
            this.c.V.a(this.c.getSelectedPhotosIntent());
          }
          i = this.c.d.size();
          ((NumberCheckBox)this.b).setCheckedNumber(i);
          ReportController.b(null, "CliOper", "", "", "0X8005E08", "0X8005E08", 0, 0, "", "", "", "");
          if (PhotoListPanel.b(this.c) != null) {
            PhotoListPanel.b(this.c).a(this.c.getContext(), localLocalMediaInfo.path, this.c.K.isChecked(), this.c.g, null, true);
          }
        }
        else
        {
          if (j == 0) {
            this.c.a(localLocalMediaInfo.path);
          }
          this.c.d.remove(localLocalMediaInfo.path);
          this.c.u.remove(localLocalMediaInfo.position);
          if (this.c.V != null) {
            this.c.V.a(this.c.getSelectedPhotosIntent());
          }
        }
        this.c.f();
        this.c.n();
        this.c.p();
      }
    }
    label633:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.CheckBoxClickedListener
 * JD-Core Version:    0.7.0.1
 */