package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class AIOGalleryScene$22
  implements AdapterView.OnItemClickListener
{
  AIOGalleryScene$22(AIOGalleryScene paramAIOGalleryScene, AIORichMediaData paramAIORichMediaData, boolean paramBoolean, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      this.d.aF.dismiss();
      localObject = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).c;
      int i = ((ShareActionSheetBuilder.ActionSheetItem)localObject).action;
      localObject = ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus;
      if (i != 64)
      {
        if (i != 67)
        {
          if (i != 69)
          {
            int j;
            switch (i)
            {
            default: 
              break;
            case 59: 
              AIOGalleryScene.a(this.d, this.a);
              i = 1;
              break;
            case 58: 
              if (this.b) {
                i = 6;
              } else {
                i = 5;
              }
              j = i;
              if (this.d.V.asBinder().pingBinder())
              {
                this.d.V.e(this.a.L);
                QQToast.makeText(AIOGalleryScene.G(this.d), AIOGalleryScene.H(this.d).getString(2131889761), 0).show();
                j = i;
              }
            case 57: 
            case 56: 
            case 55: 
            case 54: 
              for (;;)
              {
                i = j;
                break;
                if (this.d.V.asBinder().pingBinder()) {
                  this.d.V.h(this.a.L);
                }
                i = 3;
                break;
                AIOGalleryScene.b(this.d, this.a, (String)localObject);
                i = 10;
                break;
                AIOGalleryScene.a(this.d, this.a, (String)localObject);
                i = 9;
                break;
                if (this.b) {
                  j = 7;
                } else {
                  j = 6;
                }
                String str = this.d.Z;
                localObject = str;
                if (TextUtils.isEmpty(str)) {
                  localObject = this.d.X;
                }
                AIOGalleryScene.a(AIOGalleryScene.K(this.d), this.d.ac, this.d.X, (String)localObject, this.a.N, this.a.P, this.a.Q, false);
              }
            case 53: 
              AIOGalleryScene.a(this.d, this.a, this.c);
              i = 2;
              break;
            case 52: 
              i = 8;
              break;
            }
            AIOGalleryScene.b(this.d, this.a);
            i = 5;
            break label637;
          }
          PicShareToWX.a(this.c.getPath(), AIOGalleryScene.M(this.d), 1);
          ReportController.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        }
        else if (this.d.V.asBinder().pingBinder())
        {
          this.d.V.f(this.a.L);
          ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
          QQToast.makeText(AIOGalleryScene.I(this.d), 2, AIOGalleryScene.J(this.d).getString(2131889669), 0).show();
        }
        i = -1;
      }
      else
      {
        localObject = (AIOFileVideoData)this.a;
        FileManagerUtil.a(AIOGalleryScene.L(this.d), ((AIOFileVideoData)localObject).c);
        i = 11;
      }
      label637:
      if (this.b) {
        localObject = "0X8009EF7";
      } else {
        localObject = "0X8009EFA";
      }
      ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.22
 * JD-Core Version:    0.7.0.1
 */