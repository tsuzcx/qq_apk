package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;
import java.util.Map;
import spx;
import sqa;
import sqb;
import sqc;
import sqj;
import sqt;

public class VVideoView
  extends FrameLayout
  implements IVView<VVideo>
{
  public int a;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private VVideo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo;
  private WeakReference<VVideo> jdField_a_of_type_JavaLangRefWeakReference;
  private sqb jdField_a_of_type_Sqb;
  private sqc jdField_a_of_type_Sqc;
  private int b;
  private int c = 1;
  
  public VVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 1;
  }
  
  public VVideoView(@NonNull Context paramContext, VVideo paramVVideo)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo = paramVVideo;
    setTag("VVideoView");
  }
  
  public int a()
  {
    return this.c;
  }
  
  public VVideo a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (VVideo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public sqb a()
  {
    return this.jdField_a_of_type_Sqb;
  }
  
  public sqc a()
  {
    return this.jdField_a_of_type_Sqc;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Sqb != null) {
      this.jdField_a_of_type_Sqb.f(this);
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = getLayoutParams();
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if ((a() != null) && (a().getInstance() != null) && (a().getInstance().getActivity() != null))
    {
      localObject = a().getInstance().getActivity();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getWindow();
        if ((getParent() instanceof ViewGroup))
        {
          this.b = ((ViewGroup)getParent()).indexOfChild(this);
          a();
          ((ViewGroup)getParent()).removeView(this);
          b();
        }
        localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        if ((a() == null) || (a().getInstance() == null) || (a().getInstance().getFragment() == null) || (!((ViolaFragment)a().getInstance().getFragment()).a())) {
          break label188;
        }
        ((ViolaFragment)a().getInstance().getFragment()).a().addView(this, localLayoutParams);
      }
    }
    return;
    label188:
    ((Window)localObject).addContentView(this, localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a().getInstance().getActivity() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VVideoView", 2, "initView: playerType=" + paramInt1 + ", sceneType=" + paramInt2);
      }
      if (paramInt1 != 1) {
        break label154;
      }
      localObject1 = new sqa(a().getInstance().getActivity(), this, paramInt2, a().getInstance());
      setVideoViewControlListener((sqb)localObject1);
      localObject2 = (BaseModule)ViolaModuleManager.findModuleMapById(a().getInstance().getInstanceId()).get(BridgeModule.MODULE_NAME);
      if ((localObject2 instanceof BridgeModule))
      {
        localObject2 = ((BridgeModule)localObject2).getField("predownload");
        if ((localObject2 instanceof VideoPreDownloadMgr)) {
          ((sqa)localObject1).a((VideoPreDownloadMgr)localObject2);
        }
      }
    }
    return;
    label154:
    if (this.jdField_a_of_type_Int == 1)
    {
      localObject1 = new ViolaVideoView(a().getInstance().getActivity());
      setVideoViewControlListener(new sqj(a().getInstance().getActivity(), (spx)localObject1, this, a().getInstance()));
      addView((View)localObject1, -1, -1);
      return;
    }
    Object localObject1 = new ViolaVideoView(a().getInstance().getActivity());
    Object localObject2 = new sqt(a().getInstance().getActivity(), (spx)localObject1, this, a().getInstance());
    setVideoViewControlListener((sqb)localObject2);
    setVideoViewLifeCycleChangeListener((sqc)localObject2);
    addView((View)localObject1, -1, -1);
  }
  
  public void a(VVideo paramVVideo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVVideo);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo.videoFireEvent(paramString, paramObject);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Sqb != null) {
      this.jdField_a_of_type_Sqb.g(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    if ((a() != null) && (a().getParent() != null) && (a().getParent().getHostView() != null))
    {
      if ((getParent() != null) && ((getParent() instanceof ViewGroup)))
      {
        a();
        ((ViewGroup)getParent()).removeView(this);
        b();
      }
      ((ViewGroup)a().getParent().getHostView()).addView(this, this.b, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public void setVideoViewControlListener(sqb paramsqb)
  {
    this.jdField_a_of_type_Sqb = paramsqb;
  }
  
  public void setVideoViewLifeCycleChangeListener(sqc paramsqc)
  {
    this.jdField_a_of_type_Sqc = paramsqc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView
 * JD-Core Version:    0.7.0.1
 */