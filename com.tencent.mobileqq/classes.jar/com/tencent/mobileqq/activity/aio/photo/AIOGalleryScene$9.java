package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.AppRuntime;

class AIOGalleryScene$9
  implements AdapterView.OnItemClickListener
{
  AIOGalleryScene$9(AIOGalleryScene paramAIOGalleryScene, AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      this.d.aF.dismiss();
      localObject1 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c;
      int i = ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action;
      localObject1 = ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus;
      if (i != 66)
      {
        if (i != 69)
        {
          Object localObject2;
          switch (i)
          {
          default: 
            break;
          case 58: 
            AIOGalleryScene.c(this.d, this.a);
            i = 6;
            break;
          case 57: 
            AIOGalleryScene.a(this.d, this.b, this.c);
            i = 3;
            break;
          case 56: 
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("preResult", (String)localObject1);
            localObject1 = this.d;
            ((AIOGalleryScene)localObject1).a(((AIOGalleryScene)localObject1).ad, this.a.Q, this.a.C, this.a.B, this.a.q, this.a.A, this.a.n, 2, (Intent)localObject2);
            i = 10;
            break;
          case 55: 
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("preResult", (String)localObject1);
            localObject1 = this.d;
            ((AIOGalleryScene)localObject1).a(((AIOGalleryScene)localObject1).ad, this.a.Q, this.a.C, this.a.B, this.a.q, this.a.A, this.a.n, 1, (Intent)localObject2);
            ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
            i = 9;
            break;
          case 54: 
            localObject2 = this.d.Z;
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = this.d.X;
            }
            ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", this.d.aq, 0, "", "", "", "");
            AIOGalleryScene.a(AIOGalleryScene.u(this.d), this.d.ac, this.d.X, (String)localObject1, this.a.N, this.a.P, this.a.Q, false);
            i = 7;
            break;
          case 53: 
            AIOGalleryScene.a(this.d, this.a, this.b, this.c);
            i = 2;
            break;
          case 52: 
            i = 8;
            break;
          case 51: 
            AIOGalleryScene.b(this.d, this.a);
            i = 5;
            break;
          case 50: 
            this.d.a("Pic_Forward_Qzone", 0);
            AIOGalleryUtils.a(AIOGalleryScene.t(this.d), this.d.W, this.d.aa, this.d.ab, this.b, this.d.Y, this.d.Z);
            if (this.d.U) {
              VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
            }
            i = 4;
            break;
          case 49: 
            AIOGalleryScene.a(this.d, this.b);
            i = 1;
            break;
          case 48: 
            AIOGalleryScene.a(this.d, this.a);
            i = 12;
            break;
          }
        }
        else
        {
          PicShareToWX.a(this.c.getPath(), AIOGalleryScene.v(this.d), 1);
          ReportController.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        }
      }
      else
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((this.d.V != null) && (localObject1 != null)) {
          if (this.a.G) {
            this.d.V.a(this.d.ac, true, this.a.H, this.a.F, ((AppRuntime)localObject1).getAccount(), this.a.I);
          } else {
            this.d.V.a(this.d.ac, false, this.a.B, this.a.F, ((AppRuntime)localObject1).getAccount(), this.a.I);
          }
        }
      }
      i = 0;
      ReportController.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.9
 * JD-Core Version:    0.7.0.1
 */