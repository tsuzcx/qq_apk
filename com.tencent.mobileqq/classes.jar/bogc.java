import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(17)
public class bogc
  extends bofy
{
  private long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final EffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
  private ProviderViewEditContainer jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer;
  public QIMProviderContainerView a;
  private SpeedFlexibleRecyclerView jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView;
  protected DoodleLayout a;
  private AbsAECaptureButton jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton;
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public int a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton == null) {
      return 10000;
    }
    return (int)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.d();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void a(int paramInt)
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
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = SystemClock.elapsedRealtime();
    if ((1 == paramInt1) && (l - this.jdField_a_of_type_Long > 4000L))
    {
      QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), anvx.a(2131709231), 0).a();
      this.jdField_a_of_type_Long = l;
    }
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    Object localObject;
    if (paramInt != -1)
    {
      localObject = (VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366988);
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
        if (EffectsCameraCaptureView.a(bpjt.a().a((String)localObject))) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.u();
        }
      }
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == this.jdField_c_of_type_Int) && (!paramBoolean))
    {
      b();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().d(true);
      this.jdField_c_of_type_Int = -1;
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(true);
    if ((this.jdField_c_of_type_Int == -1) || (this.jdField_a_of_type_Boolean)) {
      a(true, 150);
    }
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.getVisibility() != 0) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class)))
    {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(bpbd parambpbd)
  {
    ((wjl)wjs.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
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
          break label137;
        }
        bool1 = true;
        label63:
        QLog.d("CaptureController", 2, bool1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
        if ((bdcw.a(bpqs.a)) && (paramPtvTemplateInfo != null))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
          if (paramPtvTemplateInfo.funcType != PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) {
            break label142;
          }
        }
      }
    }
    label137:
    label142:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((EffectsCameraCaptureView)localObject).e(bool1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect(paramString);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label63;
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
      localObject = EffectsCameraCaptureView.a();
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
    float f = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    ObjectAnimator localObjectAnimator2;
    Object localObject1;
    if (paramBoolean)
    {
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { 0.0F, f });
      localObject1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { 0.0F, f });
      if (!b()) {
        break label292;
      }
    }
    label292:
    for (ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, "translationY", new float[] { 0.0F, f });; localObjectAnimator1 = null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);
      Object localObject2 = localObject1;
      localObject1 = localScaleAnimation;
      ((ScaleAnimation)localObject1).setDuration(paramInt);
      ((ScaleAnimation)localObject1).setFillAfter(true);
      localObjectAnimator2.setDuration(paramInt).start();
      ((ObjectAnimator)localObject2).setDuration(paramInt).start();
      if (b()) {
        localObjectAnimator1.setDuration(paramInt).start();
      }
      this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject1);
      return;
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { f, 0.0F });
      localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { f, 0.0F });
      if (b()) {}
      for (localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, "translationY", new float[] { f, 0.0F });; localObjectAnimator1 = null)
      {
        localObject1 = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F);
        break;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void aJ_() {}
  
  public void a_(int paramInt, Object paramObject)
  {
    if (bczv.a().a()) {}
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
            if (!this.d) {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            }
            this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          } while (!b());
          this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setVisibility(8);
          return;
          if (paramInt != 0) {
            break;
          }
        } while (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        if (!this.d) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      } while (!b());
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
        b();
        return;
      }
    } while (paramInt != 3);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    if (!this.d) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.d();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    this.jdField_c_of_type_Int = -1;
  }
  
  public void b(int paramInt)
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
      localEffectsCameraCaptureView.c(i);
      if ((!QLog.isColorLevel()) || (QQSharpFaceFilter.sSharpFaceOpen)) {
        break;
      }
      QLog.d("CaptureController", 2, new Object[] { "onDrawSharpFaceFeature level = ", paramInt + ", faceOpen:", Boolean.valueOf(QQSharpFaceFilter.sSharpFaceOpen) });
      return;
      bool = false;
      break label32;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(MusicProviderView.class);
    MusicItemInfo localMusicItemInfo = ((boje)bogd.a().c(8)).a();
    EffectsCameraCaptureView localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
    if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.b())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localEffectsCameraCaptureView.d(paramBoolean);
      return;
    }
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    d();
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131370478);
    if ((localObject != null) && ((localObject instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout)localObject;
      if ((localObject != null) && (((RelativeLayout)localObject).isShown()))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        localObject = (VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366988);
        if (localObject != null) {
          ((VideoFilterViewPager)localObject).c();
        }
      }
    }
  }
  
  public void d(int paramInt) {}
  
  public void e() {}
  
  public void f() {}
  
  public void h() {}
  
  public void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogc
 * JD-Core Version:    0.7.0.1
 */