package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView.CropListener;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class EditPicCropPart
  extends EditVideoPart
  implements View.OnClickListener, CropNewView.CropListener
{
  protected ViewGroup a;
  protected CropNewView b;
  protected View c;
  protected View d;
  protected TextView e;
  protected View f;
  protected TextView g;
  public Bitmap h;
  public Bitmap i;
  protected TextView j;
  protected TextView k;
  protected boolean l = false;
  boolean m = false;
  boolean n = false;
  int o = 0;
  boolean p = false;
  boolean q = false;
  boolean r = false;
  int[] s = new int[5];
  
  public EditPicCropPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.t == null) {
      return;
    }
    int i1 = this.t.I.h();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBussiRestoreClick , bussiId = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(",hasModified");
      localStringBuilder.append(paramBoolean);
      QLog.d("EditPicCropPart", 2, localStringBuilder.toString());
    }
  }
  
  private void k()
  {
    this.m = true;
    this.a.setVisibility(0);
    if (!this.r)
    {
      this.e.setEnabled(false);
      this.g.setVisibility(8);
    }
    else
    {
      this.g.setVisibility(0);
    }
    m();
    this.c.setEnabled(false);
    this.b.setImageBitmap(this.h);
    this.i = this.h;
  }
  
  private void l()
  {
    this.m = false;
    this.a.setVisibility(8);
    this.h = null;
    this.i = null;
  }
  
  private void m()
  {
    if (this.t.I.h() == 103)
    {
      this.e.setEnabled(false);
      this.e.setText(2131897072);
      this.g.setVisibility(8);
    }
  }
  
  private boolean n()
  {
    int i1 = this.t.I.h();
    boolean bool;
    if (i1 == 103)
    {
      this.t.i();
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBussiCropClick , bussiId = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(",clickHit = ");
      localStringBuilder.append(bool);
      QLog.d("EditPicCropPart", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean o()
  {
    int i1 = this.t.I.h();
    this.p = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBussiCropClickIntercept , bussiId = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(",intercepte = ");
      localStringBuilder.append(false);
      QLog.d("EditPicCropPart", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  private boolean p()
  {
    int i1 = this.t.I.h();
    boolean bool;
    if (i1 == 103)
    {
      bool = true;
      this.t.b();
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBussiBackPressed , bussiId = ");
      localStringBuilder.append(i1);
      localStringBuilder.append(",clickHit = ");
      localStringBuilder.append(bool);
      QLog.d("EditPicCropPart", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void q() {}
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.d.setEnabled(false);
      return;
    }
    if (paramInt == 2) {
      this.d.setEnabled(true);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    GeneratePicArgs localGeneratePicArgs = paramGenerateContext.l;
    localGeneratePicArgs.f += this.o;
    if (this.n)
    {
      paramGenerateContext.o.reservesArray.add("2");
      VideoEditReport.b("0X80075E9", VideoEditReport.c);
      ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setEditHasCut(true);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    c();
    if (paramInt == 7)
    {
      if (!this.m) {
        k();
      }
    }
    else if (this.m) {
      l();
    }
  }
  
  public boolean au_()
  {
    if (this.m)
    {
      if (!p()) {
        this.t.d(0);
      }
      VideoEditReport.b("0X80075D5");
      ((IOCR)QRoute.api(IOCR.class)).report("0X800AAE5", 0);
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    if (!this.l)
    {
      this.l = true;
      this.a = ((ViewGroup)d(2063990982));
      this.a.setOnClickListener(this);
      if (this.t.Z != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
        localLayoutParams.bottomMargin = ViewUtils.dip2px(56.5F);
        this.a.setLayoutParams(localLayoutParams);
      }
      this.b = ((CropNewView)d(2063990998));
      this.c = d(2063990994);
      this.c.setOnClickListener(this);
      this.d = d(2063990996);
      this.d.setOnClickListener(this);
      this.e = ((TextView)d(2063990980));
      this.e.setOnClickListener(this);
      this.f = d(2063990957);
      this.f.setOnClickListener(this);
      this.g = ((TextView)d(2063990997));
      this.j = ((TextView)d(2063990995));
      this.j.setOnClickListener(this);
      this.k = ((TextView)d(2063991462));
      this.b.setCropListener(this);
    }
  }
  
  public void d()
  {
    this.e.setEnabled(true);
    this.c.setEnabled(true);
    this.q = true;
  }
  
  public boolean i()
  {
    return this.n;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2063990957)
    {
      if (i1 != 2063990980)
      {
        switch (i1)
        {
        default: 
          return;
        case 2063990996: 
          d();
          this.b.d();
          VideoEditReport.b("0X80075D4");
          ((IOCR)QRoute.api(IOCR.class)).report("0X800AAE4", 0);
          return;
        case 2063990995: 
          q();
          return;
        }
        this.b.c();
        this.c.setEnabled(false);
        if (!this.r) {
          this.e.setEnabled(false);
        }
        if ((this.t != null) && (this.t.I.h() == 103)) {
          this.e.setEnabled(false);
        }
        this.q = false;
        a(this.q);
        VideoEditReport.b("0X80075D3");
        ((IOCR)QRoute.api(IOCR.class)).report("0X800AAE3", 0);
        return;
      }
      if (o()) {
        return;
      }
      this.o += 1;
      this.n = true;
      boolean bool = this.b.e();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("crop remove face items");
        paramView.append(bool);
        QLog.d("EditPicCrop", 2, paramView.toString());
      }
      if (bool)
      {
        if (this.t.ad != null)
        {
          this.t.ad.remove(FaceLayer.a);
          this.t.ad.remove("DynamicFaceLayer");
          this.t.ad.remove(TextLayer.a);
        }
        paramView = this.b.g();
        if (paramView != null)
        {
          this.h = paramView;
          VideoFilterTools.a().a(this.h);
          this.t.a(this.h, false);
          if (!n()) {
            this.t.I();
          }
        }
        VideoEditReport.b("0X80075D2");
        ((IOCR)QRoute.api(IOCR.class)).report("0X800AAE6", 0);
        GeneratePicArgs.a(this.s);
      }
    }
    else
    {
      this.b.f();
      au_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicCropPart
 * JD-Core Version:    0.7.0.1
 */