package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.ViolaTopicVideoDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;
import java.util.Map;

public class VVideoView
  extends FrameLayout
  implements IVView<VVideo>
{
  public int a;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private VVideo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo;
  private VVideoView.OnVideoViewControlListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewControlListener;
  private VVideoView.OnVideoViewLifeCycleChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewLifeCycleChangeListener;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private WeakReference<VVideo> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private Boolean jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1;
  private Boolean jdField_c_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private int jdField_d_of_type_Int = 1;
  private Boolean jdField_d_of_type_JavaLangBoolean = Boolean.valueOf(false);
  
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
    addOnLayoutChangeListener(new VVideoView.1(this));
  }
  
  private boolean a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    if (getParent() == null) {
      return true;
    }
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if ((a() == null) || (a().getParent() == null)) {
      return false;
    }
    return a().getParent().getHostView() == localViewGroup;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public VVideo a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (VVideo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public VVideoView.OnVideoViewControlListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewControlListener;
  }
  
  public VVideoView.OnVideoViewLifeCycleChangeListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewLifeCycleChangeListener;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo.getInstance() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo.getInstance().getUrl())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo.getInstance().getUrl().contains("VideoFeeds.js")) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo.getInstance().getMasterVideoRef())))
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800AF0F", "0X800AF0F", 0, 0, null, null, null, "" + System.currentTimeMillis(), false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo.getInstance().setMasterVideoRef(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideo.getRef());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Int = paramInt;
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
          this.jdField_b_of_type_Int = ((ViewGroup)getParent()).indexOfChild(this);
          b();
          ((ViewGroup)getParent()).removeView(this);
          c();
        }
        localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        if ((a() == null) || (a().getInstance() == null) || (!(a().getInstance().getFragment() instanceof ViolaFragment)) || (!((ViolaFragment)a().getInstance().getFragment()).isSuspension())) {
          break label196;
        }
        ((ViolaFragment)a().getInstance().getFragment()).getCommonSuspensionGestureLayout().addView(this, localLayoutParams);
      }
    }
    return;
    label196:
    ((Window)localObject).addContentView(this, localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramString, paramBoolean, false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a().getInstance().getActivity() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VVideoView", 2, "initView: playerType=" + paramInt1 + ", sceneType=" + paramInt2 + ",autoAttachVideoView:" + paramBoolean1 + ",videoToken:" + paramString + ",firstFrameDrawed:" + this.jdField_d_of_type_JavaLangBoolean + ",handAttachVideoView:" + paramBoolean2);
      }
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean2);
      this.jdField_c_of_type_Int = paramInt1;
      if (paramInt1 != 1) {
        break label227;
      }
      paramString = new VVideoDelegate(a().getInstance().getActivity(), this, paramInt2, a().getInstance(), paramString, paramBoolean1);
      setVideoViewControlListener(paramString);
      localObject = ViolaModuleManager.findModuleMapById(a().getInstance().getInstanceId());
      if (localObject != null)
      {
        localObject = (BaseModule)((Map)localObject).get(BridgeModule.MODULE_NAME);
        if ((localObject instanceof BridgeModule))
        {
          localObject = ((BridgeModule)localObject).getField("predownload");
          if ((localObject instanceof VideoPreDownloadMgr)) {
            paramString.a((VideoPreDownloadMgr)localObject);
          }
        }
      }
    }
    return;
    label227:
    if (this.jdField_a_of_type_Int == 1)
    {
      paramString = new ViolaVideoView(a().getInstance().getActivity());
      setVideoViewControlListener(new ViolaVideoDelegate(a().getInstance().getActivity(), paramString, this, a().getInstance()));
      addView(paramString, -1, -1);
      return;
    }
    paramString = new ViolaVideoView(a().getInstance().getActivity());
    Object localObject = new ViolaTopicVideoDelegate(a().getInstance().getActivity(), paramString, this, a().getInstance());
    setVideoViewControlListener((VVideoView.OnVideoViewControlListener)localObject);
    setVideoViewLifeCycleChangeListener((VVideoView.OnVideoViewLifeCycleChangeListener)localObject);
    addView(paramString, -1, -1);
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
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewControlListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewControlListener.f(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt;
    if ((a() != null) && (a().getParent() != null) && (a().getParent().getHostView() != null))
    {
      if ((getParent() != null) && ((getParent() instanceof ViewGroup)))
      {
        b();
        ((ViewGroup)getParent()).removeView(this);
        c();
      }
      ((ViewGroup)a().getParent().getHostView()).addView(this, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewControlListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewControlListener.g(this);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    try
    {
      if ((a() != null) && (!this.jdField_b_of_type_JavaLangBoolean.booleanValue()) && (this.jdField_c_of_type_Int == 1) && (this.jdField_c_of_type_JavaLangBoolean.booleanValue()) && (a())) {
        a().f();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VVideoView", 2, "onDetachedFromWindow error:" + localException.getMessage());
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewControlListener != null) && (!this.jdField_d_of_type_JavaLangBoolean.booleanValue()) && (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()))
    {
      this.jdField_d_of_type_JavaLangBoolean = Boolean.valueOf(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewControlListener.i();
    }
  }
  
  public void setAutoDestroy(Boolean paramBoolean)
  {
    this.jdField_c_of_type_JavaLangBoolean = paramBoolean;
  }
  
  public void setBringToRootByAnim(Boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaLangBoolean = paramBoolean;
  }
  
  public void setVideoViewControlListener(VVideoView.OnVideoViewControlListener paramOnVideoViewControlListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewControlListener = paramOnVideoViewControlListener;
  }
  
  public void setVideoViewLifeCycleChangeListener(VVideoView.OnVideoViewLifeCycleChangeListener paramOnVideoViewLifeCycleChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView$OnVideoViewLifeCycleChangeListener = paramOnVideoViewLifeCycleChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView
 * JD-Core Version:    0.7.0.1
 */