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
  private int jdField_a_of_type_Int = 1;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AECMShowSquareLayout jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowSquareLayout;
  private String jdField_a_of_type_JavaLangString;
  private PAGFile jdField_a_of_type_OrgLibpagPAGFile;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private boolean jdField_a_of_type_Boolean = false;
  private PAGFile b;
  
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
        this.jdField_a_of_type_OrgLibpagPAGFile = PAGFile.Load(BaseApplicationImpl.getApplication().getResources().getAssets(), "camera/cmshow/ae_camera_cmshow_loading_success.pag");
        this.b = PAGFile.Load(BaseApplicationImpl.getApplication().getResources().getAssets(), "camera/cmshow/ae_camera_cmshow_loading_fail.pag");
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      this.jdField_a_of_type_OrgLibpagPAGFile = null;
      this.b = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      label62:
      break label62;
    }
    this.jdField_a_of_type_OrgLibpagPAGFile = null;
    this.b = null;
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2064318487, this, true);
    this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowSquareLayout = ((AECMShowSquareLayout)findViewById(2064122049));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2064122785));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_OrgLibpagPAGView = new PAGView(paramContext);
      this.jdField_a_of_type_OrgLibpagPAGView.addPAGFlushListener(new AECMShowLoadingView.1(this));
      paramContext = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowSquareLayout.addView(this.jdField_a_of_type_OrgLibpagPAGView, paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("[initViews] mPagInitSucceeded=");
    paramContext.append(this.jdField_a_of_type_Boolean);
    AEQLog.a("AECMShowLoadingView", paramContext.toString());
  }
  
  private void b()
  {
    PAGView localPAGView = this.jdField_a_of_type_OrgLibpagPAGView;
    if (localPAGView != null)
    {
      PAGFile localPAGFile = this.jdField_a_of_type_OrgLibpagPAGFile;
      if (localPAGFile != null)
      {
        localPAGView.setFile(localPAGFile);
        this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(0);
        if (!this.jdField_a_of_type_OrgLibpagPAGView.isPlaying()) {
          this.jdField_a_of_type_OrgLibpagPAGView.play();
        }
      }
    }
  }
  
  private void c()
  {
    PAGView localPAGView = this.jdField_a_of_type_OrgLibpagPAGView;
    if (localPAGView != null)
    {
      PAGFile localPAGFile = this.b;
      if (localPAGFile != null)
      {
        localPAGView.setFile(localPAGFile);
        this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(1);
        this.jdField_a_of_type_OrgLibpagPAGView.addListener(new AECMShowLoadingView.2(this));
        if (!this.jdField_a_of_type_OrgLibpagPAGView.isPlaying()) {
          this.jdField_a_of_type_OrgLibpagPAGView.play();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(getContext().getString(2064515080, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 1)
    {
      b();
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowLoadingView
 * JD-Core Version:    0.7.0.1
 */