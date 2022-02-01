package com.tencent.aelight.camera.ae.cmshow;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class AECMShowLoadingView
  extends RelativeLayout
{
  private AECMShowSquareLayout a;
  private PAGView b;
  private TextView c;
  private boolean d = false;
  private PAGFile e;
  private PAGFile f;
  private int g = 1;
  private String h;
  
  public AECMShowLoadingView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECMShowLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECMShowLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    a(paramContext);
  }
  
  private void a()
  {
    try
    {
      if (FeatureManager.Features.PAG.init())
      {
        this.e = PAGFile.Load(BaseApplicationImpl.getApplication().getResources().getAssets(), "camera/cmshow/ae_camera_cmshow_loading_success.pag");
        this.f = PAGFile.Load(BaseApplicationImpl.getApplication().getResources().getAssets(), "camera/cmshow/ae_camera_cmshow_loading_fail.pag");
        this.d = true;
        return;
      }
      this.e = null;
      this.f = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      label62:
      break label62;
    }
    this.e = null;
    this.f = null;
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2064056347, this, true);
    this.a = ((AECMShowSquareLayout)findViewById(2063990969));
    this.c = ((TextView)findViewById(2063991560));
    if (this.d)
    {
      this.b = new PAGView(paramContext);
      this.b.addPAGFlushListener(new AECMShowLoadingView.1(this));
      paramContext = new ViewGroup.LayoutParams(-1, -1);
      this.a.addView(this.b, paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("[initViews] mPagInitSucceeded=");
    paramContext.append(this.d);
    AEQLog.a("AECMShowLoadingView", paramContext.toString());
  }
  
  private void b()
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null)
    {
      PAGFile localPAGFile = this.e;
      if (localPAGFile != null)
      {
        localPAGView.setComposition(localPAGFile);
        this.b.setRepeatCount(0);
        if (!this.b.isPlaying()) {
          this.b.play();
        }
      }
    }
  }
  
  private void c()
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null)
    {
      PAGFile localPAGFile = this.f;
      if (localPAGFile != null)
      {
        localPAGView.setComposition(localPAGFile);
        this.b.setRepeatCount(1);
        this.b.addListener(new AECMShowLoadingView.2(this));
        if (!this.b.isPlaying()) {
          this.b.play();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText(getContext().getString(2064187405, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    this.g = paramInt;
    paramInt = this.g;
    if (paramInt == 1)
    {
      b();
      return;
    }
    if (paramInt == 2)
    {
      this.h = paramString;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowLoadingView
 * JD-Core Version:    0.7.0.1
 */