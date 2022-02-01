package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.AECaptureParam;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.FaceunlockBgDrawable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class QFaceUnlockCameraCaptureUnit
  extends AEPituCameraUnit
  implements View.OnClickListener
{
  private String E;
  private Button F;
  private int G;
  private int H = 0;
  private View aA;
  private View aB;
  private View aC;
  private Handler ap;
  private MediaRecorder aq;
  private TextView ar;
  private TextView as;
  private LinearLayout at;
  private RelativeLayout au;
  private FaceunlockBgDrawable av;
  private int aw = 155;
  private int ax = 211;
  private String ay;
  private Runnable az = new QFaceUnlockCameraCaptureUnit.1(this);
  
  public QFaceUnlockCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
  }
  
  private void N()
  {
    this.G = 0;
    this.F.setText(2131896903);
    this.F.setVisibility(0);
    this.F.setEnabled(false);
    this.H = 0;
    this.as.setVisibility(8);
    this.at.setVisibility(8);
    this.ar.setVisibility(0);
  }
  
  private void O()
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.2(this));
  }
  
  private Camera.Size b(List<Camera.Size> paramList1, List<Camera.Size> paramList2)
  {
    List<Camera.Size> localList = null;
    Object localObject = null;
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return null;
      }
      HashSet localHashSet = new HashSet(paramList1);
      int i = -1;
      Iterator localIterator = paramList2.iterator();
      paramList1 = localObject;
      for (;;)
      {
        localList = paramList1;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList2 = (Camera.Size)localIterator.next();
        if (localHashSet.contains(paramList2))
        {
          int j = paramList2.width * paramList2.height;
          if (j > i)
          {
            paramList1 = paramList2;
            i = j;
          }
        }
      }
    }
    return localList;
  }
  
  private void j(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.3(this, paramBoolean));
  }
  
  private void k(boolean paramBoolean)
  {
    MediaRecorder localMediaRecorder = this.aq;
    if (localMediaRecorder != null)
    {
      localMediaRecorder.setPreviewDisplay(null);
      this.aq.setOnErrorListener(null);
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "releaseRecord begin");
        }
        this.aq.release();
        if (paramBoolean) {
          this.ap.post(new QFaceUnlockCameraCaptureUnit.4(this));
        }
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "releaseRecord end");
        }
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("releaseRecord failed, Exception: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, localStringBuilder.toString());
      }
      catch (IllegalStateException localIllegalStateException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("releaseRecord failed, IllegalStateException: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, localStringBuilder.toString());
      }
    }
    this.aq = null;
  }
  
  protected boolean E()
  {
    return false;
  }
  
  protected AECaptureParam G()
  {
    AECaptureParam localAECaptureParam = super.G();
    localAECaptureParam.g(1);
    return localAECaptureParam;
  }
  
  protected void S() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityResult");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    s().getWindow().setFlags(1024, 1024);
    s().requestWindowFeature(1);
    super.a(paramBundle);
    this.E = this.b.getActivity().getIntent().getStringExtra("key_face_unlock_code");
    this.ap = new Handler();
    if (TextUtils.isEmpty(this.E))
    {
      this.E = "6978";
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "verification code is null, use default code");
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    if (paramBoolean)
    {
      this.F.setEnabled(true);
      return;
    }
    QLog.e("QFaceUnlockCameraCaptureUnit", 1, "Camera start fail!");
  }
  
  public void aa() {}
  
  public void ad() {}
  
  public boolean ak()
  {
    return super.ak();
  }
  
  public void au()
  {
    N();
    this.aB.setVisibility(8);
    this.aA.setVisibility(8);
    this.aC.setVisibility(8);
  }
  
  public void f(boolean paramBoolean) {}
  
  public View j()
  {
    View localView = super.j();
    ((TextView)localView.findViewById(2063990954)).setOnClickListener(this);
    this.F = ((Button)localView.findViewById(2063991340));
    this.aC = localView.findViewById(2063991009);
    this.aB = localView.findViewById(2063991096);
    this.aA = localView.findViewById(2063990965);
    this.ar = ((TextView)this.g.findViewById(2063991428));
    this.at = ((LinearLayout)this.g.findViewById(2063991360));
    this.as = ((TextView)this.g.findViewById(2063991067));
    this.au = ((RelativeLayout)localView.findViewById(2063991064));
    au();
    this.G = 0;
    this.F.setEnabled(false);
    this.F.setText(2131896903);
    this.F.setOnClickListener(this);
    this.H = 0;
    int i = AIOUtils.b(this.aw, s().getResources());
    this.av = new FaceunlockBgDrawable();
    this.av.a(AIOUtils.b(this.aw + this.ax, s().getResources()));
    this.av.a(i);
    this.av.b(1);
    if (Build.VERSION.SDK_INT > 15) {
      this.au.setBackground(this.av);
    } else {
      this.au.setBackgroundDrawable(this.av);
    }
    this.as.setText(this.E);
    return localView;
  }
  
  public void k()
  {
    super.k();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityResume");
    }
  }
  
  public void l()
  {
    super.l();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityPause");
    }
    j(false);
    this.ap.removeCallbacksAndMessages(null);
  }
  
  public void m()
  {
    super.m();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onDestroy");
    }
  }
  
  protected int n()
  {
    return 2064056467;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2063990954)
    {
      s().finish();
      s().overridePendingTransition(2130772090, 2130772374);
      return;
    }
    super.onClick(paramView);
    if (paramView.getId() != 2063991340) {
      return;
    }
    int i = this.G;
    if (i == 0)
    {
      this.G = 1;
      this.F.setText(2131896905);
      this.as.setVisibility(0);
      this.at.setVisibility(0);
      this.ar.setVisibility(8);
      O();
      return;
    }
    if (i == 1)
    {
      this.F.setEnabled(false);
      this.G = 2;
      j(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QFaceUnlockCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */