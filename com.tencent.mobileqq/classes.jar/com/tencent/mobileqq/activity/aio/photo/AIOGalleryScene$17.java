package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import mqq.app.AppRuntime;

class AIOGalleryScene$17
  implements AdapterView.OnItemClickListener
{
  AIOGalleryScene$17(AIOGalleryScene paramAIOGalleryScene, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, AIORichMediaInfo paramAIORichMediaInfo) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      this.e.aF.dismiss();
      switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).c.action)
      {
      default: 
        break;
      case 64: 
        AIOGalleryScene.b(this.e, this.a);
        i = 7;
        break;
      case 63: 
        if (this.e.V.asBinder().pingBinder())
        {
          localObject = this.e.V.c(this.a.L, this.a.M, this.e.ac);
          if (localObject != null)
          {
            QfavBuilder.a((Intent)localObject).a(AIOGalleryScene.A(this.e), BaseApplicationImpl.getApplication().getRuntime().getAccount());
            QfavReport.a(null, 3, 0, this.a.Q);
            QfavReport.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
          }
        }
        i = 3;
        break;
      case 62: 
        ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.e.aq, 0, "", "", "", "");
        String str = this.e.Z;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.e.X;
        }
        AIOGalleryScene.a(AIOGalleryScene.z(this.e), this.e.ac, this.e.X, (String)localObject, this.a.N, this.a.P, this.a.Q, false);
        break;
      case 61: 
        AIOGalleryScene.a(this.e, this.a, this.b, this.c, this.d);
        break;
      case 60: 
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
        }
        localObject = QZoneHelper.UserInfo.getInstance();
        ((QZoneHelper.UserInfo)localObject).qzone_uin = this.e.W;
        QZoneHelper.forwardToPublishMood(AIOGalleryScene.y(this.e), (QZoneHelper.UserInfo)localObject, this.b.getAbsolutePath(), 10001);
        ReportController.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
        i = 4;
        break;
      case 59: 
        AIOGalleryScene.a(this.e, this.a);
        i = 1;
        break;
      case 58: 
        if (this.e.V.asBinder().pingBinder())
        {
          this.e.V.e(this.a.L);
          QQToast.makeText(AIOGalleryScene.B(this.e), AIOGalleryScene.C(this.e).getString(2131889761), 0).show();
        }
        break;
      }
      int i = 6;
      break label526;
      i = 0;
      label526:
      localObject = this.e.c.c();
      if ((localObject != null) && (((AIORichMediaInfo)localObject).a != null) && (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).a)))
      {
        localObject = (AIOShortVideoData)((AIORichMediaInfo)localObject).a;
        if (((AIOShortVideoData)localObject).d == 0) {
          ReportController.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
        } else if (((AIOShortVideoData)localObject).d == 1) {
          ReportController.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.17
 * JD-Core Version:    0.7.0.1
 */