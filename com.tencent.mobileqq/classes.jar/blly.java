import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(17)
public class blly
  implements blwi, bmpp
{
  public int a;
  private long jdField_a_of_type_Long;
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public blnr a;
  private blro jdField_a_of_type_Blro;
  private blrs jdField_a_of_type_Blrs = new blme(this);
  private blrt jdField_a_of_type_Blrt;
  private blrw jdField_a_of_type_Blrw = new blmd(this);
  bmcu jdField_a_of_type_Bmcu;
  private bmjj jdField_a_of_type_Bmjj = new blmc(this);
  public AppInterface a;
  private final EffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
  private ProviderViewEditContainer jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer;
  public QIMProviderContainerView a;
  private SpeedFlexibleRecyclerView jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView;
  protected DoodleLayout a;
  private QIMCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  private QIMCameraCaptureButtonLayout jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  private QIMCameraCaptureButtonLayout jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public blly(AppInterface paramAppInterface, View paramView, bmcu parambmcu)
  {
    this.jdField_a_of_type_Blnr = new blmb(this);
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bmcu = parambmcu;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363888));
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView = ((QIMProviderContainerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372365));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131366807));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363948));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364906);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366569);
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)paramView.findViewById(2131363938));
    this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)paramView.findViewById(2131376284));
    if ((this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout == null) && ((this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout instanceof QIMCameraStoryCaptureButtonLayout))) {
      this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Blrt = new blrt();
    this.jdField_a_of_type_Blrt.a(this.jdField_a_of_type_Blrw);
    this.jdField_a_of_type_Blrt.a(paramView);
    this.jdField_a_of_type_Blro = new blro();
    this.jdField_a_of_type_Blro.a(this.jdField_a_of_type_Blrs);
    this.jdField_a_of_type_Blro.a(paramView);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout == null) {
      return 10000;
    }
    return (int)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.a();
  }
  
  public DoodleLayout a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("makeSureInitStub mDoodleLayout:");
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
        break label395;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" mEditContainer:");
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
        break label400;
      }
    }
    label395:
    label400:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("CaptureController", 2, bool);
      long l1;
      long l2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
      {
        l1 = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131365397));
        this.jdField_a_of_type_AndroidViewViewStub.inflate();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363940));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEntrance(0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCaptureControllerAndPreloadView(this);
        blut.a().a(0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CaptureController", 2, new Object[] { "onFirstFrameShownInternal initDoodleLayout:", Long.valueOf(l2 - l1) });
        }
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        l1 = System.currentTimeMillis();
        this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131373263));
        this.jdField_b_of_type_AndroidViewViewStub.inflate();
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131372367));
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(0);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setProviderViewListener(this);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setStickerListener(((DoodleEditView)localObject).a());
        ((DoodleEditView)localObject).setFrom(0);
        ((DoodleEditView)localObject).a(false);
        ((DoodleEditView)localObject).setDoodleEditViewListener(new bllz(this));
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365572).setOnTouchListener(new blma(this));
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CaptureController", 2, new Object[] { "onFirstFrameShownInternal initEditContainer:", Long.valueOf(l2 - l1) });
        }
      }
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Blnr);
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8)) {
      g();
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null) || (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.getVisibility() != 0))
    {
      if (!this.f) {
        break label57;
      }
      if (paramInt != 0) {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(paramInt);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
      label57:
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = SystemClock.elapsedRealtime();
    if ((1 == paramInt1) && (l - this.jdField_a_of_type_Long > 4000L))
    {
      QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), alpo.a(2131710155), 0).a();
      this.jdField_a_of_type_Long = l;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      if ((paramInt2 == 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(this.e);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onActivityResult null!!!");
      }
    }
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    Object localObject;
    if (paramInt != -1)
    {
      localObject = (VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366524);
      if (localObject != null) {
        ((VideoFilterViewPager)localObject).setCurrentItem(paramInt, false);
      }
    }
    if (paramQIMFilterCategoryItem != null)
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.a.iterator();
      while (paramQIMFilterCategoryItem.hasNext())
      {
        localObject = (String)paramQIMFilterCategoryItem.next();
        if (EffectsCameraCaptureView.a(bncp.a().a((String)localObject))) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.A();
        }
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureController", 2, "changeProviderViewStateWithExtra: invoked. info: index = " + paramInt);
    }
    MusicProviderView localMusicProviderView;
    if (paramInt == 104)
    {
      paramObject = (QIMMusicConfigManager)blmf.a(2);
      localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
      if (localMusicProviderView != null) {
        localMusicProviderView.setPreSelectTagIndex(paramObject.a() - 1);
      }
    }
    try
    {
      localMusicProviderView.h();
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.d("CaptureController", 1, String.format("throwable = %s", new Object[] { paramObject }));
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == this.jdField_c_of_type_Int) && (!paramBoolean))
    {
      f();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().d(true);
    }
    for (this.jdField_c_of_type_Int = -1;; this.jdField_c_of_type_Int = paramInt)
    {
      this.jdField_d_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true);
      if ((this.jdField_c_of_type_Int == -1) || (this.jdField_a_of_type_Boolean)) {
        a(true, 150);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.getVisibility() != 0) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class)))
    {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a().l();
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(bmrr parambmrr)
  {
    ((urk)urr.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString)
  {
    boolean bool2 = true;
    Object localObject;
    if (VideoPrefsUtil.getDefaultPrefs() != null)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        bool1 = true;
        VideoPrefsUtil.setMaterialMute(bool1);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onDrawTemplateOnScreen isOriginal").append(this.jdField_c_of_type_Boolean).append(" ");
        if (VideoPrefsUtil.getDefaultPrefs() != null) {
          break label138;
        }
        bool1 = true;
        label64:
        QLog.d("CaptureController", 2, bool1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
        if ((azey.a(bnkz.a)) && (paramPtvTemplateInfo != null))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
          if (paramPtvTemplateInfo.funcType != PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) {
            break label143;
          }
        }
      }
    }
    label138:
    label143:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((EffectsCameraCaptureView)localObject).g(bool1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect(paramString);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label64;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_Boolean) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setMovieEffect(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawMovieTemplateOnScreen isOriginal" + this.jdField_c_of_type_Boolean);
      }
      return;
      VideoPrefsUtil.setMaterialMute(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    this.jdField_c_of_type_Boolean = paramBoolean;
    Object localObject;
    if (this.jdField_c_of_type_Boolean)
    {
      VideoPrefsUtil.setMaterialMute(false);
      localObject = EffectsCameraCaptureView.b();
      if (localObject != null)
      {
        localObject = ((QQFilterRenderManager)localObject).getBusinessOperation();
        if (paramBoolean) {
          break label85;
        }
      }
    }
    label85:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((FilterBusinessOperation)localObject).setEffectMute(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onPlayVideoMusic isOriginal" + this.jdField_c_of_type_Boolean);
      }
      return;
      VideoPrefsUtil.setMaterialMute(true);
      break;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    float f1 = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    ObjectAnimator localObjectAnimator2;
    Object localObject1;
    if (paramBoolean)
    {
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { 0.0F, f1 });
      localObject1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { 0.0F, f1 });
      if (!c()) {
        break label292;
      }
    }
    label292:
    for (ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, "translationY", new float[] { 0.0F, f1 });; localObjectAnimator1 = null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);
      Object localObject2 = localObject1;
      localObject1 = localScaleAnimation;
      ((ScaleAnimation)localObject1).setDuration(paramInt);
      ((ScaleAnimation)localObject1).setFillAfter(true);
      localObjectAnimator2.setDuration(paramInt).start();
      ((ObjectAnimator)localObject2).setDuration(paramInt).start();
      if (c()) {
        localObjectAnimator1.setDuration(paramInt).start();
      }
      this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject1);
      return;
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { f1, 0.0F });
      localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { f1, 0.0F });
      if (c()) {}
      for (localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, "translationY", new float[] { f1, 0.0F });; localObjectAnimator1 = null)
      {
        localObject1 = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F);
        break;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Blrt.a())
    {
      this.jdField_a_of_type_Blrt.d();
      return true;
    }
    if (this.jdField_a_of_type_Blro.b())
    {
      this.jdField_a_of_type_Blro.e();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      blut.a().a(0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.d() == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature AdvancedProviderView.sBeautyLevel equals to level");
      }
      return;
    }
    if (GLVideoClipUtil.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
      }
      paramInt = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(paramInt);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    if (azbu.a().b()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt != 4) {
                break;
              }
            } while ((this.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0));
            this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
            if (!this.e) {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            }
            this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          } while (!c());
          this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setVisibility(8);
          return;
          if (paramInt != 0) {
            break;
          }
        } while (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        if (!this.e) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      } while (!c());
      this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setVisibility(0);
      return;
      if (paramInt == 7)
      {
        if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
        {
          this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
        }
        f();
        return;
      }
    } while (paramInt != 3);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    if (!this.e) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Blrt.a();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Blrt.a().a(true, (Activity)this.jdField_a_of_type_AndroidViewView.getContext());
    }
    this.jdField_a_of_type_Blrt.a().a(this.jdField_a_of_type_Bmjj, paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
    MusicItemInfo localMusicItemInfo = ((blpo)blmf.a().c(8)).a();
    EffectsCameraCaptureView localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
    if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.b())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localEffectsCameraCaptureView.f(paramBoolean);
      return;
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    bncp.a().a(0);
    ((blnl)blmf.a(5)).a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
  }
  
  public void c(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.k)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawSharpFaceFeature unSupport!");
      }
      return;
    }
    boolean bool;
    label32:
    EffectsCameraCaptureView localEffectsCameraCaptureView;
    if (paramInt > 0)
    {
      bool = true;
      QQSharpFaceFilter.sSharpFaceOpen = bool;
      localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if (!QQSharpFaceFilter.sSharpFaceOpen) {
        break label122;
      }
    }
    label122:
    for (int i = paramInt;; i = -1)
    {
      localEffectsCameraCaptureView.d(i);
      if ((!QLog.isColorLevel()) || (QQSharpFaceFilter.sSharpFaceOpen)) {
        break;
      }
      QLog.d("CaptureController", 2, new Object[] { "onDrawSharpFaceFeature level = ", paramInt + ", faceOpen:", Boolean.valueOf(QQSharpFaceFilter.sSharpFaceOpen) });
      return;
      bool = false;
      break label32;
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean c()
  {
    return this.g;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.g();
    }
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class)) {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a().m();
      }
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setIsGuideMode(paramBoolean);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_d_of_type_Boolean) {}
    while ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a())) {
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d()))
    {
      b(7, null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(false);
      return true;
    }
    return false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Blnr);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    blut.a().a(0);
  }
  
  public void e(int paramInt) {}
  
  public void e(boolean paramBoolean)
  {
    if (this.e != paramBoolean)
    {
      this.e = paramBoolean;
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.b(paramBoolean);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.u();
      }
    }
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.c();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    this.jdField_c_of_type_Int = -1;
  }
  
  public void f(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.g())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.h();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      if (((bkiu)blmf.a(13)).a()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean, false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.u();
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.f());
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void h() {}
  
  public void i()
  {
    j();
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131369774);
    if ((localObject != null) && ((localObject instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout)localObject;
      if ((localObject != null) && (((RelativeLayout)localObject).isShown()))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        localObject = (VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366524);
        if (localObject != null) {
          ((VideoFilterViewPager)localObject).c();
        }
      }
    }
  }
  
  public void k()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
    if ((!MusicProviderView.jdField_a_of_type_Boolean) && (localActivity.getIntent() != null)) {
      localActivity.getIntent().removeExtra("video_tag_info");
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureController", 2, "onStop...");
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.d();
    ((blmy)blmf.a(9)).a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.f();
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.e();
    bncp.a().a(0);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.h();
    }
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      blut.a().a(0, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void n()
  {
    f();
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null))
    {
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.b();
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().a();
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.f();
    bncp.a().a(0);
    VideoFilterViewPager localVideoFilterViewPager = (VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366524);
    if (localVideoFilterViewPager != null) {
      localVideoFilterViewPager.a(0);
    }
    blut.a().a(0);
  }
  
  public void o() {}
  
  public void p() {}
  
  public void q() {}
  
  public void r() {}
  
  public void s() {}
  
  public void t() {}
  
  public void u()
  {
    this.jdField_d_of_type_Boolean = true;
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
    DoodleLayout localDoodleLayout = blut.a().a(0);
    if (localDoodleLayout != null) {
      localDoodleLayout.setRecording(this.jdField_d_of_type_Boolean);
    }
    if (localMusicProviderView != null) {
      localMusicProviderView.b(true);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true, true);
    }
  }
  
  public void v()
  {
    this.jdField_d_of_type_Boolean = false;
    DoodleLayout localDoodleLayout = blut.a().a(0);
    if (localDoodleLayout != null) {
      localDoodleLayout.setRecording(this.jdField_d_of_type_Boolean);
    }
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.t();
    }
  }
  
  public void x()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.b(this.jdField_c_of_type_Int, blmo.jdField_b_of_type_Int, blmo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void y()
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(AdvancedProviderView.class)))
    {
      AdvancedProviderView localAdvancedProviderView = (AdvancedProviderView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(AdvancedProviderView.class);
      if (localAdvancedProviderView != null) {
        localAdvancedProviderView.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blly
 * JD-Core Version:    0.7.0.1
 */