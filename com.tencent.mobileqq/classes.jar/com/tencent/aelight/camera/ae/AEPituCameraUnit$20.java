package com.tencent.aelight.camera.ae;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class AEPituCameraUnit$20
  implements Runnable
{
  AEPituCameraUnit$20(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    AEQLog.b(this.this$0.a, "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)this.this$0.g.findViewById(2063991433);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      AEQLog.b(this.this$0.a, "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)this.this$0.g.findViewById(2063991435);
    if ((localObject != null) && (!this.this$0.aA()))
    {
      ((ViewStub)localObject).inflate();
      AEQLog.b(this.this$0.a, "AEPartAction--inflate captureModeCode");
    }
    localObject = this.this$0;
    ((AEPituCameraUnit)localObject).i = ((AEPituCameraCaptureButtonLayout)((AEPituCameraUnit)localObject).g.findViewById(2063990959));
    localObject = this.this$0.i;
    AEPituCameraUnit localAEPituCameraUnit = this.this$0;
    ((AbsAECaptureButton)localObject).a(localAEPituCameraUnit, localAEPituCameraUnit.z.u(), this.this$0.h);
    if (!this.this$0.M())
    {
      localObject = (RelativeLayout.LayoutParams)this.this$0.i.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(-30.0F, this.this$0.i.getResources());
      this.this$0.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.this$0.i.h();
    }
    if (this.this$0.A)
    {
      this.this$0.i.i();
      this.this$0.au();
    }
    this.this$0.R.b();
    if (this.this$0.u.shouldStartCamera())
    {
      this.this$0.aF();
      this.this$0.S.a();
      if ((AEPituCameraUnit.g(this.this$0) > 0) && (AEPituCameraUnit.h(this.this$0) > 0)) {
        this.this$0.S.b(851973, new Object[] { Arrays.asList(new Integer[] { Integer.valueOf(AEPituCameraUnit.g(this.this$0)), Integer.valueOf(AEPituCameraUnit.h(this.this$0)) }) });
      }
    }
    localObject = this.this$0;
    AEPituCameraUnit.a((AEPituCameraUnit)localObject, (AECompoundButton)((AEPituCameraUnit)localObject).g.findViewById(2063991009));
    if (AEPituCameraUnit.i(this.this$0) != null)
    {
      AEPituCameraUnit.i(this.this$0).setOnClickListener(this.this$0);
      AEPituCameraUnit.i(this.this$0).setSelected(false);
      AEPituCameraUnit.i(this.this$0).setVisibility(8);
      if (this.this$0.ae)
      {
        localObject = this.this$0;
        ((AEPituCameraUnit)localObject).a(((AEPituCameraUnit)localObject).ae, AEPituCameraUnit.i(this.this$0));
      }
    }
    localObject = this.this$0;
    AEPituCameraUnit.b((AEPituCameraUnit)localObject, (AECompoundButton)((AEPituCameraUnit)localObject).g.findViewById(2063990965));
    if (AEPituCameraUnit.j(this.this$0) != null)
    {
      AECameraDaTongHelper.a.a(AEPituCameraUnit.j(this.this$0), "em_ae_switch_btn");
      AEPituCameraUnit.j(this.this$0).setOnClickListener(this.this$0);
      AEPituCameraUnit.j(this.this$0).setContentDescription(AEPituCameraUnit.j(this.this$0).getResources().getString(2064187700));
      if (!CameraUtils.d())
      {
        AEPituCameraUnit.j(this.this$0).setVisibility(4);
        AEPituCameraUnit.j(this.this$0).setEnabled(false);
      }
    }
    if (this.this$0.A)
    {
      this.this$0.S.b();
      this.this$0.R.h();
    }
    this.this$0.g.setOnTouchListener(this.this$0);
    if (this.this$0.M()) {
      this.this$0.g.setOnClickListener(new AEPituCameraUnit.20.1(this));
    }
    this.this$0.ao();
    AEPituCameraUnit.k(this.this$0);
    AEPituCameraUnit.l(this.this$0);
    AEPituCameraUnit.a(this.this$0, true);
    if (AEPituCameraUnit.m(this.this$0) != null)
    {
      localObject = AEPituCameraUnit.m(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
      AEPituCameraUnit.a(this.this$0, null);
    }
    AEQLog.b(this.this$0.a, "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.20
 * JD-Core Version:    0.7.0.1
 */