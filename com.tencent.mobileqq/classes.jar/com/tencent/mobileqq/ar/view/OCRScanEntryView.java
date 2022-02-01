package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.current.AnimationQIMCircleProgress;
import mqq.os.MqqHandler;

public class OCRScanEntryView
  extends ScanEntryProviderView
  implements View.OnClickListener
{
  private RelativeLayout a;
  private View b;
  private TextView c;
  private ImageView d;
  private TextView e;
  private AnimationQIMCircleProgress f;
  private volatile boolean g;
  
  public OCRScanEntryView(Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    super(paramContext, paramScanEntryContainerViewListener);
  }
  
  private void b(String paramString)
  {
    if (this.g)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTakePhotoBtnClick, is in recognize! filePath: ");
      localStringBuilder.append(paramString);
      QLog.e("AREngine_OCRScanEntryView", 1, localStringBuilder.toString());
      return;
    }
    this.g = true;
    if (FileUtil.d(paramString))
    {
      ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment((Activity)this.E, paramString, 0, -1008, null);
      ReportController.b(null, "dc00898", "", "", "0X800AE06", "0X800AE06", 2, 0, "", "0", "0", "");
      this.g = false;
      return;
    }
    ThreadManager.getFileThreadHandler().post(new OCRScanEntryView.1(this));
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.a == null)
    {
      this.a = ((RelativeLayout)LayoutInflater.from(this.E).inflate(2131627303, null, false));
      paramBundle = new FrameLayout.LayoutParams(-1, -1);
      addView(this.a, paramBundle);
      paramBundle = this.a;
      this.F = paramBundle;
      this.b = paramBundle.findViewById(2131439539);
      UniformUtils.a(this.E, this.b);
      this.f = ((AnimationQIMCircleProgress)this.a.findViewById(2131439536));
      this.c = ((TextView)this.a.findViewById(2131439512));
      this.d = ((ImageView)this.a.findViewById(2131439511));
      this.e = ((TextView)this.a.findViewById(2131439515));
      this.f.setBackgroundResource(2130845881);
      this.f.setCenterView();
      this.f.changeMode(0);
      this.c.setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.f.setOnClickListener(this);
    }
  }
  
  public void i_(String paramString)
  {
    if (!FileUtil.d(paramString))
    {
      QLog.d("AREngine_OCRScanEntryView", 1, String.format("doDealGalleryPicFile path: %s is not exist", new Object[] { paramString }));
      return;
    }
    b(paramString);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131439536: 
      ReportController.b(null, "dc00898", "", "", "0X8009C80", "0X8009C80", 0, 0, "", "0", "0", "");
      b(null);
      break;
    case 2131439512: 
      o();
      break;
    case 2131439511: 
      p();
      ReportController.b(null, "dc00898", "", "", "0X8009C86", "0X8009C86", 0, 0, "", "0", "0", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.OCRScanEntryView
 * JD-Core Version:    0.7.0.1
 */