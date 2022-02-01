package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoPreviewCustomizationReadInJoy
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy";
  private boolean b = false;
  private boolean j = false;
  private boolean k = false;
  private Dialog l;
  
  PhotoPreviewCustomizationReadInJoy(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    if (this.b)
    {
      s().n.setVisibility(8);
      s().l.setVisibility(8);
    }
    if (this.b)
    {
      this.c.findViewById(2131431716).setVisibility(0);
      this.c.findViewById(2131431716).setOnClickListener(new PhotoPreviewCustomizationReadInJoy.1(this));
    }
    if (((this.d.l) || (this.f.isSingleMode)) && (!this.b)) {
      s().g.setVisibility(8);
    }
    if (this.j)
    {
      s().g.setVisibility(0);
      if ((this.d.y.size() > 1) && (this.f.selectedPhotoList.size() > 1))
      {
        s().g.setEnabled(false);
        return;
      }
      s().g.setEnabled(true);
      return;
    }
    if (this.k) {
      s().g.setVisibility(0);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.b = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver", false);
    this.j = paramIntent.getBooleanExtra("from_readinjoy_ugc_deliver_preview", false);
    this.k = paramIntent.getBooleanExtra("from_readinjoy_ugc", false);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = s().m();
    if (paramInt1 != -1) {
      this.d.m = ((String)this.d.y.get(paramInt1));
    }
    if (this.d.m != null)
    {
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.d.g)
      {
        if ((!this.b) && (!this.k) && (!this.j))
        {
          paramView = new HashMap(1);
          if ((this.f.selectedMediaInfoHashMap != null) && ((LocalMediaInfo)this.f.selectedMediaInfoHashMap.get(this.d.m) != null)) {
            paramView.put("param_localmediainfo", this.f.selectedMediaInfoHashMap.get(this.d.m));
          }
          paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.c, this.d.m, true, true, true, true, true, paramInt2, m(), 4, paramView);
        }
        else
        {
          if (this.b)
          {
            paramInt1 = s().m();
            if (paramInt1 < this.d.y.size()) {
              this.d.m = ((String)this.d.y.get(paramInt1));
            }
          }
          paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.c, this.d.m, true, true, true, true, true, 8, m(), 0);
        }
      }
      else
      {
        paramView = new Bundle();
        paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.c, this.d.m, true, true, true, true, true, 2, m(), 4, paramView);
      }
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.g).d);
      if (this.d.r) {
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      } else {
        paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.d.u);
      }
      paramView.putExtra("PhotoConst.readinjoy_delete_pic_position", s().m());
      this.c.startActivity(paramView);
      this.c.overridePendingTransition(2130772090, 2130772092);
      s().g.setClickable(false);
      paramView = this.c.getIntent();
      if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
      {
        paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
        if (paramView != null) {
          ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
        }
      }
    }
    LpReportInfo_pf00064.allReport(603, 4, 1);
  }
  
  public void b()
  {
    super.b();
    int i;
    if ((this.f.selectedPhotoList != null) && (this.f.selectedPhotoList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!this.d.l) && (!this.f.isSingleMode) && (this.b)) {
      s().g.setEnabled(true);
    }
  }
  
  protected void j()
  {
    super.j();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy
 * JD-Core Version:    0.7.0.1
 */