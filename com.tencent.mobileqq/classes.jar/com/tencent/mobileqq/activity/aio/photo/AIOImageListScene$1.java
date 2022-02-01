package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

class AIOImageListScene$1
  implements ActionSheet.OnButtonClickListener
{
  AIOImageListScene$1(AIOImageListScene paramAIOImageListScene, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.a.getContent(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView)) {
        if (paramView.equals(AIOImageListScene.a(this.b).getResources().getString(2131886528)))
        {
          paramInt = this.b.B();
          if (paramInt == 1)
          {
            this.b.v();
            paramView = this.b;
            paramView.a("Multi_Forward_Contacts", paramView.v.size());
          }
          else if ((paramInt == 2) && (!this.b.v.isEmpty()) && (this.b.w.asBinder().pingBinder()))
          {
            paramView = (AIOShortVideoData)((AIORichMediaInfo)this.b.v.get(0)).a;
            paramView = this.b.w.c(paramView.L, paramView.M, this.b.H);
            if (paramView != null) {
              ForwardBaseOption.a(AIOImageListScene.b(this.b), paramView);
            }
          }
        }
        else if (paramView.equals(AIOImageListScene.c(this.b).getResources().getString(2131890805)))
        {
          paramView = new StringBuilder();
          paramView.append(this.b.z);
          paramView.append("__qzone_pic_permission__");
          paramView.append(this.b.D);
          if (LocalMultiProcConfig.getInt4Uin(paramView.toString(), -1, Long.valueOf(this.b.z).longValue()) == 0)
          {
            paramView = new QQCustomDialog(AIOImageListScene.d(this.b), 2131953338);
            paramView.setContentView(2131624611);
            paramView.setTitle(AIOImageListScene.e(this.b).getString(2131895447));
            paramView.setMessage(AIOImageListScene.f(this.b).getString(2131895445));
            paramView.setNegativeButton(AIOImageListScene.g(this.b).getString(2131895446), new AIOImageListScene.1.1(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.b.z, "40", "1");
          }
          else if (this.b.v.size() > 20)
          {
            QQToast.makeText(AIOImageListScene.i(this.b), 2131889677, 0).show();
          }
          else
          {
            this.b.w();
          }
        }
        else if (paramView.equals(AIOImageListScene.j(this.b).getResources().getString(2131890811)))
        {
          if (this.b.v.size() > 20) {
            QQToast.makeText(AIOImageListScene.k(this.b), 2131889677, 0).show();
          } else {
            this.b.y();
          }
        }
      }
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.1
 * JD-Core Version:    0.7.0.1
 */