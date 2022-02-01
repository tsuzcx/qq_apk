import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQTextEjectaFilter;
import com.tencent.mobileqq.shortvideo.filter.QQTextEjectaFilter.EjectaTextureCallBack;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qg.StoryQGSurfaceView;
import com.tencent.qg.sdk.QGJNIBridge;
import com.tencent.qg.sdk.QGRenderer.QGEventListener;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qg.sdk.video.VideoPlayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.story.mode.StoryEffectTextMode.12;
import dov.com.qq.im.story.mode.StoryEffectTextMode.14;
import dov.com.qq.im.story.mode.StoryEffectTextMode.18;
import dov.com.qq.im.story.mode.StoryEffectTextMode.19;
import dov.com.qq.im.story.mode.StoryEffectTextMode.2;
import dov.com.qq.im.story.mode.StoryEffectTextMode.5;
import dov.com.qq.im.story.mode.StoryEffectTextMode.8;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class boza
  extends boyz
  implements bjez, IEventReceiver, yzr
{
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new bozi(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bgua jdField_a_of_type_Bgua;
  private bgub jdField_a_of_type_Bgub = new bozj(this);
  private bjey jdField_a_of_type_Bjey;
  private bjfe jdField_a_of_type_Bjfe;
  private bolb jdField_a_of_type_Bolb = (bolb)bojv.a(5);
  private boyy jdField_a_of_type_Boyy;
  private bozo jdField_a_of_type_Bozo;
  private DoodleEditView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
  private DoodleView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private QQTextEjectaFilter.EjectaTextureCallBack jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter$EjectaTextureCallBack = new bozb(this);
  private QQTextEjectaFilter jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter;
  private StoryQGSurfaceView jdField_a_of_type_ComTencentQgStoryQGSurfaceView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.2(this);
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private wny jdField_a_of_type_Wny = new wny();
  private woa jdField_a_of_type_Woa;
  private yzc jdField_a_of_type_Yzc;
  private int jdField_b_of_type_Int;
  private Animator jdField_b_of_type_AndroidAnimationAnimator;
  private View jdField_b_of_type_AndroidViewView;
  private ScaleAnimation jdField_b_of_type_AndroidViewAnimationScaleAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PressDarkImageButton jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private String jdField_b_of_type_JavaLangString = "";
  private JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private JSONObject jdField_c_of_type_OrgJsonJSONObject;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private volatile boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = 1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = 1;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private boolean l = true;
  private boolean m = true;
  private boolean n;
  private boolean o;
  private boolean p;
  
  public boza(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bolb.a = new wnx(BaseApplicationImpl.getContext(), BaseApplicationImpl.sApplication.getRuntime().getAccount());
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_Woa != null) && (!this.jdField_a_of_type_Woa.jdField_c_of_type_Boolean))
    {
      if ((!bgnt.d(this.jdField_b_of_type_AndroidViewView.getContext())) || (this.jdField_a_of_type_Woa.jdField_d_of_type_Boolean)) {
        G();
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_b_of_type_AndroidViewView.getContext(), anni.a(2131713128), 0).a();
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      int i1 = zlx.a(this.jdField_b_of_type_AndroidViewView.getContext(), 4.0F);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, i1, 0.0F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(1000L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  private void C()
  {
    if ((this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) && (this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
  }
  
  private void D()
  {
    yqp.b("StoryEffectTextMode", "showSoLoading");
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
    }
  }
  
  private void E()
  {
    yqp.b("StoryEffectTextMode", "dismissSoLoading");
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    }
  }
  
  private void F()
  {
    Object localObject = d() + this.jdField_a_of_type_Bolb.a.jdField_b_of_type_Int + "/qg.js";
    if (new File((String)localObject).exists())
    {
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.addJavaScriptFileFromSDCard((String)localObject);
      localObject = d() + this.jdField_a_of_type_Bolb.a.jdField_b_of_type_Int + "/" + this.jdField_a_of_type_Bolb.a.jdField_c_of_type_JavaLangString + "/" + this.jdField_a_of_type_Bolb.a.jdField_c_of_type_JavaLangString + ".js";
      if (QLog.isColorLevel()) {
        QLog.d("StoryEffectTextMode", 2, "load " + (String)localObject);
      }
      if (!new File((String)localObject).exists()) {
        break label305;
      }
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.addJavaScriptFileFromSDCard((String)localObject);
    }
    label305:
    do
    {
      try
      {
        localObject = new JSONObject(this.jdField_a_of_type_Bolb.a.jdField_b_of_type_JavaLangString);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new StoryEffectTextMode.12(this, (JSONObject)localObject), 300L);
        do
        {
          return;
          G();
        } while (!QLog.isColorLevel());
        QLog.e("StoryEffectTextMode", 2, (String)localObject + " is not exists!");
        return;
      }
      catch (JSONException localJSONException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("StoryEffectTextMode", 2, "EVENT_NAME_QG_INIT_CONFIG" + localJSONException.toString());
        return;
      }
      G();
    } while (!QLog.isColorLevel());
    QLog.e("StoryEffectTextMode", 2, localJSONException + " is not exists!");
  }
  
  private void G()
  {
    ThreadManager.getUIHandler().post(new StoryEffectTextMode.14(this));
  }
  
  private void H()
  {
    if (this.jdField_b_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(400L);
      this.jdField_b_of_type_AndroidAnimationAnimator.addListener(new bozf(this));
    }
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidAnimationAnimator.start();
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new bozg(this));
    }
    if ((this.jdField_b_of_type_AndroidAnimationAnimator != null) && (this.jdField_b_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8) {
      this.jdField_a_of_type_AndroidAnimationAnimator.start();
    }
  }
  
  private void J()
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
      return;
    }
    yqp.b("StoryEffectTextMode", "initQGEnvironment success!");
    E();
    K();
  }
  
  private void K()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView == null) {
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView = a();
    }
    if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView != null) {}
    Object localObject;
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        localObject = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a();
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView = ((boyq)localObject).a(this.jdField_a_of_type_Bncn);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView);
        }
      }
      if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView == null) {
        break label269;
      }
      this.jdField_a_of_type_Bjey = new bjey();
      this.jdField_a_of_type_Bjey.a(this);
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getModuleEngine().registerJsModule(this.jdField_a_of_type_Bjey);
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.setExtResPath(d() + this.jdField_a_of_type_Bolb.a.jdField_b_of_type_Int + "/");
      if (this.jdField_a_of_type_Bjfe == null)
      {
        this.jdField_a_of_type_Bjfe = new bjfe();
        VideoPlayer.activeMediaPlayer(this.jdField_a_of_type_Bjfe);
      }
      this.jdField_a_of_type_Bjfe.a(d() + this.jdField_a_of_type_Bolb.a.jdField_b_of_type_Int + "/");
      localObject = new bozh(this);
      if (i1 == 0) {
        break;
      }
      this.jdField_a_of_type_Bnbf.a().queueEvent(new StoryEffectTextMode.18(this, (QGRenderer.QGEventListener)localObject));
      return;
    }
    this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.setQGEventListener((QGRenderer.QGEventListener)localObject);
    return;
    label269:
    yqp.e("StoryEffectTextMode", "QGEnvironment and mQGGLView is null!! ");
  }
  
  private void L()
  {
    QQFilterRenderManager localQQFilterRenderManager = EffectsCameraCaptureView.b();
    if (localQQFilterRenderManager == null)
    {
      CameraCaptureView localCameraCaptureView = this.jdField_a_of_type_Bncn.a();
      if ((localCameraCaptureView instanceof EffectsCameraCaptureView)) {
        ((EffectsCameraCaptureView)localCameraCaptureView).y();
      }
    }
    if ((localQQFilterRenderManager != null) && (!localQQFilterRenderManager.hasQQFilter(181)))
    {
      this.jdField_a_of_type_JavaLangString = localQQFilterRenderManager.pushChainBasedStackTopChain(181, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter$EjectaTextureCallBack);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter = ((QQTextEjectaFilter)localQQFilterRenderManager.getQQFilterByType(181));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter.setIsNeedCameraTexture(this.jdField_j_of_type_Boolean);
    }
    if (a(this.jdField_a_of_type_Bolb.a.jdField_b_of_type_Int)) {
      F();
    }
  }
  
  private Bitmap a(boolean paramBoolean)
  {
    do
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b()) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a(true);
        }
        localBitmap1 = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas;
        int i2;
        int i1;
        Bitmap localBitmap2 = localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localCanvas = new Canvas(localBitmap1);
          if ((paramBoolean) && (this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray != null))
          {
            i2 = Color.parseColor(((wny)this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_i_of_type_Int)).jdField_b_of_type_JavaLangString);
            i1 = i2;
            if (this.jdField_j_of_type_Boolean) {
              i1 = i2 | 0x80000000;
            }
            localCanvas.drawColor(i1);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.draw(localCanvas);
          localBitmap2 = localBitmap1;
          return localBitmap2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Bitmap localBitmap1;
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localBitmap1 = null;
      }
    } while (!QLog.isColorLevel());
    QLog.e("StoryEffectTextModeQ.qqstory.text_filter", 2, "getTextDrawBitmap exception:", localOutOfMemoryError1);
    return localBitmap1;
  }
  
  private StoryQGSurfaceView a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
      if ((!(localView instanceof StoryQGSurfaceView)) || (localView == null)) {
        break label43;
      }
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView = ((StoryQGSurfaceView)localView);
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView;
      label43:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  private String a(int paramInt, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      float f1 = this.jdField_a_of_type_Bolb.a.jdField_c_of_type_Int / 100.0F;
      paramFloat = f1;
      if (!this.jdField_i_of_type_Boolean)
      {
        if (!this.jdField_j_of_type_Boolean) {
          break label88;
        }
        paramFloat = f1;
      }
    }
    for (;;)
    {
      return String.format("rgba(%d,%d,%d,%.2f)", new Object[] { Integer.valueOf(Color.red(paramInt)), Integer.valueOf(Color.green(paramInt)), Integer.valueOf(Color.blue(paramInt)), Float.valueOf(paramFloat) });
      label88:
      paramFloat = 1.0F;
    }
  }
  
  private String a(woa paramwoa)
  {
    if (paramwoa == null) {
      paramwoa = "";
    }
    String str2;
    String str1;
    do
    {
      return paramwoa;
      str2 = d() + paramwoa.jdField_d_of_type_Int + "/" + paramwoa.jdField_d_of_type_JavaLangString + "/" + paramwoa.jdField_d_of_type_JavaLangString;
      str1 = str2 + ".js";
      paramwoa = str1;
    } while (new File(str1).exists());
    return str2 + "_android.js";
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Bgua != null) {
      l();
    }
    this.jdField_a_of_type_Bgua = new bgua(paramString, new Handler());
    this.jdField_a_of_type_Bgua.a(this.jdField_b_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_Bgua.b();
    this.jdField_a_of_type_Bgua.a(this.jdField_a_of_type_Bgub);
    this.jdField_a_of_type_Bgua.b();
  }
  
  private void a(woa paramwoa)
  {
    Object localObject1 = paramwoa.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_d_of_type_AndroidViewView.setContentDescription(anni.a(2131713113) + (String)localObject1 + "’ ");
    this.jdField_h_of_type_Int = paramwoa.jdField_a_of_type_Int;
    int i1 = paramwoa.jdField_c_of_type_Int;
    if ((this.jdField_a_of_type_Bjfe != null) && (this.jdField_a_of_type_Bjfe.isPlaying())) {
      this.jdField_a_of_type_Bjfe.stop();
    }
    if (this.jdField_a_of_type_Yzc != null) {
      this.jdField_a_of_type_Yzc.a(i1);
    }
    Object localObject2;
    if (paramwoa.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(8);
      if (!paramwoa.jdField_a_of_type_Boolean) {
        break label382;
      }
      if (this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray != null)
      {
        localObject1 = (wny)this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_i_of_type_Int);
        this.jdField_a_of_type_Wny = ((wny)localObject1);
        if (localObject1 != null)
        {
          localObject2 = ((wny)localObject1).jdField_e_of_type_JavaLangString;
          Object localObject3 = ((wny)localObject1).jdField_b_of_type_JavaLangString;
          i1 = Color.parseColor((String)localObject2);
          int i2 = Color.parseColor((String)localObject3);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
          localObject2 = (yxm)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
          localObject3 = ((yxm)localObject2).a();
          ((yyb)localObject3).jdField_a_of_type_Int = i1;
          ((yxm)localObject2).a((yyb)localObject3);
          this.jdField_c_of_type_Int = ((wny)localObject1).jdField_a_of_type_Int;
          this.jdField_d_of_type_Int = i2;
          this.jdField_g_of_type_Int = i1;
        }
        if (this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.size() > 1) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Woa = paramwoa;
      a(this.jdField_a_of_type_Woa, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 11, null);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label382:
      localObject1 = paramwoa.jdField_c_of_type_JavaLangString;
      localObject2 = paramwoa.jdField_e_of_type_JavaLangString;
      i1 = Color.parseColor((String)localObject1);
      this.jdField_d_of_type_Int = Color.parseColor((String)localObject2);
      this.jdField_c_of_type_Int = paramwoa.jdField_b_of_type_Int;
      this.jdField_e_of_type_Int = 0;
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Int = i1;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(woa paramwoa, int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    paramwoa.jdField_d_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Woa != null) && (this.jdField_a_of_type_Woa.jdField_d_of_type_Int == paramwoa.jdField_d_of_type_Int) && (this.jdField_g_of_type_Boolean)) {
      G();
    }
    QLog.e("StoryEffectTextMode", 2, "onDownloadOfflinePkgFailed，" + paramwoa.jdField_d_of_type_Int);
  }
  
  private void a(woa paramwoa, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int i1 = 0;
    yqp.b("StoryEffectTextMode", "onTextFilterInfoChange");
    if (paramwoa == null) {}
    Object localObject;
    String str1;
    label280:
    boolean bool;
    label290:
    do
    {
      return;
      this.jdField_a_of_type_Woa = paramwoa;
      this.jdField_c_of_type_JavaLangString = paramString1;
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
      if ((!this.jdField_e_of_type_Boolean) || (!bjes.b.get()))
      {
        if (!this.jdField_i_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_d_of_type_Int);
          this.jdField_h_of_type_Boolean = true;
        }
        this.jdField_g_of_type_Boolean = true;
        return;
      }
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      }
      this.jdField_a_of_type_Woa.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_Woa.jdField_d_of_type_Int);
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Boyy.getCount())
      {
        paramwoa = this.jdField_a_of_type_Boyy.a(paramInt2);
        if (paramwoa.jdField_d_of_type_Int == this.jdField_a_of_type_Woa.jdField_d_of_type_Int) {
          paramwoa.jdField_c_of_type_Boolean = this.jdField_a_of_type_Woa.jdField_c_of_type_Boolean;
        }
        paramInt2 += 1;
      }
      this.jdField_a_of_type_Boyy.notifyDataSetChanged();
      localObject = "";
      if (!this.jdField_a_of_type_Woa.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_g_of_type_Boolean = false;
      E();
      e(true);
      if (!this.jdField_f_of_type_Boolean) {
        F();
      }
      paramwoa = this.jdField_a_of_type_Woa.jdField_d_of_type_JavaLangString;
      str1 = a(this.jdField_a_of_type_Woa);
      localObject = paramwoa;
      if (QLog.isColorLevel())
      {
        QLog.d("StoryEffectTextMode", 2, "load " + str1);
        localObject = paramwoa;
      }
      if (TextUtils.isEmpty(paramString1)) {
        break label851;
      }
      bool = true;
      d(bool);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if ((paramInt3 & 0x2) != 0) {
      a("qg_TemplateChange", (String)localObject);
    }
    if ((paramInt3 & 0x10) != 0) {}
    for (;;)
    {
      try
      {
        if (this.jdField_c_of_type_OrgJsonJSONObject == null) {
          this.jdField_c_of_type_OrgJsonJSONObject = new JSONObject();
        }
        paramwoa = this.jdField_c_of_type_OrgJsonJSONObject;
        if (this.jdField_j_of_type_Boolean) {
          break label1153;
        }
        paramInt2 = i1;
        if (this.jdField_i_of_type_Boolean) {
          break label1153;
        }
        paramwoa.put("cameraStatus", paramInt2);
        a("qg_onCameraSwitch", this.jdField_c_of_type_OrgJsonJSONObject.toString());
      }
      catch (JSONException paramwoa)
      {
        String str2;
        String str3;
        label851:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "EVENT_NAME_QG_ON_CAMERA_SWITCH, JSONException:" + paramwoa.toString());
        continue;
      }
      if ((paramInt3 & 0x1) != 0)
      {
        paramwoa = a(paramInt1, 0.0F);
        str1 = a(this.jdField_e_of_type_Int, 0.0F);
        str2 = a(this.jdField_f_of_type_Int, 0.0F);
        str3 = a(this.jdField_g_of_type_Int, 1.0F);
      }
      try
      {
        if (this.jdField_b_of_type_OrgJsonJSONObject == null) {
          this.jdField_b_of_type_OrgJsonJSONObject = new JSONObject();
        }
        this.jdField_b_of_type_OrgJsonJSONObject.put("colorId", this.jdField_c_of_type_Int);
        this.jdField_b_of_type_OrgJsonJSONObject.put("backgroundColor", paramwoa);
        this.jdField_b_of_type_OrgJsonJSONObject.put("backgroundColor2", str1);
        this.jdField_b_of_type_OrgJsonJSONObject.put("backgroundColor3", str2);
        this.jdField_b_of_type_OrgJsonJSONObject.put("textColor", str3);
        a("qg_BackgroundChange", this.jdField_b_of_type_OrgJsonJSONObject.toString());
      }
      catch (JSONException paramwoa)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "onInputTextComplete, JSONException:" + paramwoa.toString());
        continue;
        paramString1 = paramwoa;
        if (!bdnt.a(paramwoa)) {
          continue;
        }
        paramString1 = bfqc.a(paramwoa, "□");
        continue;
      }
      if ((paramInt3 & 0x8) != 0)
      {
        paramwoa = paramString1;
        if (paramString1 == null) {
          paramwoa = "";
        }
        if ((TextUtils.isEmpty(paramwoa)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
        {
          paramString1 = this.jdField_e_of_type_JavaLangString;
          a("qg_TextChange", paramString1);
        }
      }
      else
      {
        if ((paramInt3 & 0x4) == 0) {
          break label1018;
        }
      }
      try
      {
        paramwoa = new JSONObject();
        paramwoa.put("tmplName", localObject);
        if (!TextUtils.isEmpty(paramString2)) {
          paramwoa.put("scene", paramString2);
        }
        a("qg_Restart", paramwoa.toString());
      }
      catch (JSONException paramwoa)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "QG_RESTART, JSONException:" + paramwoa.toString());
        continue;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Woa.f))
      {
        paramwoa = d() + this.jdField_a_of_type_Woa.jdField_d_of_type_Int + "/" + this.jdField_a_of_type_Woa.jdField_d_of_type_JavaLangString + "/" + this.jdField_a_of_type_Woa.f;
        if (new File(paramwoa).exists())
        {
          b(paramwoa);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StoryEffectTextMode", 2, this.jdField_a_of_type_Woa.jdField_d_of_type_JavaLangString + " is not download！");
          }
          this.jdField_g_of_type_Boolean = true;
          if (!this.jdField_i_of_type_Boolean) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_d_of_type_Int);
          }
          this.jdField_h_of_type_Boolean = true;
          e(false);
          if (bgnt.d(this.jdField_b_of_type_AndroidViewView.getContext()))
          {
            a(this.jdField_a_of_type_Woa, false);
            break label280;
          }
          this.jdField_a_of_type_Woa.jdField_d_of_type_Boolean = true;
          G();
          break label280;
          bool = false;
          break label290;
        }
        if (this.jdField_a_of_type_Bgua == null) {
          break;
        }
        l();
        return;
      }
      if (this.jdField_a_of_type_Bgua == null) {
        break;
      }
      l();
      return;
      label1018:
      if ((paramInt3 & 0x2) != 0) {
        l();
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Woa.f))
      {
        paramwoa = d() + this.jdField_a_of_type_Woa.jdField_d_of_type_Int + "/" + this.jdField_a_of_type_Woa.jdField_d_of_type_JavaLangString + "/" + this.jdField_a_of_type_Woa.f;
        if (new File(paramwoa).exists())
        {
          if (this.jdField_a_of_type_Bgua != null) {
            break;
          }
          a(paramwoa);
          return;
        }
        if (this.jdField_a_of_type_Bgua == null) {
          break;
        }
        l();
        return;
      }
      if (this.jdField_a_of_type_Bgua == null) {
        break;
      }
      l();
      return;
      label1153:
      paramInt2 = 1;
    }
  }
  
  private void a(woa paramwoa, boolean paramBoolean)
  {
    if ((paramwoa == null) || (paramwoa.jdField_d_of_type_Int == 0)) {}
    for (;;)
    {
      return;
      String str = String.valueOf(paramwoa.jdField_d_of_type_Int);
      paramwoa.jdField_d_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(str))
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (nko.a(str) == null) {}
        for (boolean bool = true; (bool) || (paramBoolean); bool = false)
        {
          this.jdField_a_of_type_JavaUtilSet.add(str);
          nko.b(str, localAppRuntime, new boze(this, bool, paramwoa, str), true, 0, true);
          return;
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt == 0) {}
    String str;
    do
    {
      return false;
      str = nko.a(String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("StoryEffectTextMode", 2, "bid = " + paramInt + ", version = " + str);
      }
    } while (str == null);
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("StoryEffectTextModeQ.qqstory.text_filter", 2, " dispatcEvent, isEjectaInited: " + this.jdField_e_of_type_Boolean);
      }
    }
    do
    {
      return false;
      if (this.jdField_f_of_type_Boolean) {
        break;
      }
      this.jdField_g_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.e("StoryEffectTextModeQ.qqstory.text_filter", 2, " dispatcEvent, mIsLoadTemplateManager: " + this.jdField_f_of_type_Boolean);
    return false;
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!a(paramString1)) {}
    for (;;)
    {
      return false;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("value", paramString2);
        paramString2 = this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getQGBridge();
        if (!paramString2.hasRegistered(paramString1)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("StoryEffectTextMode", 2, "dispatchNormalEvent, key:" + paramString1 + ", value:" + localJSONObject.toString());
        }
        paramString2.dispatchJSEvent(paramString1, localJSONObject);
        return true;
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    l();
    a(paramString);
  }
  
  private void b(woa paramwoa)
  {
    yqp.b("StoryEffectTextMode", "onDownloadedResource");
    paramwoa.jdField_c_of_type_Boolean = true;
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {}
    while ((!a(this.jdField_a_of_type_Bolb.a.jdField_b_of_type_Int)) || (this.jdField_a_of_type_Woa == null) || (this.jdField_a_of_type_Woa.jdField_d_of_type_Int != paramwoa.jdField_d_of_type_Int) || (!this.jdField_g_of_type_Boolean)) {
      return;
    }
    this.jdField_g_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("StoryEffectTextMode", 2, "download template resource success！ draw screen！");
    }
    a(this.jdField_a_of_type_Woa, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 11, null);
  }
  
  private void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    yxh localyxh = (yxh)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("GuideLineLayer");
    if (localyxh == null) {
      return;
    }
    localyxh.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  private String c()
  {
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      return this.jdField_d_of_type_JavaLangString;
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  private String d()
  {
    return nku.b();
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
    bnbf localbnbf = this.jdField_a_of_type_Bnbf;
    if ((this.jdField_j_of_type_Boolean) && (paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      localbnbf.j(bool);
      if ((!this.jdField_j_of_type_Boolean) || (!paramBoolean)) {
        break;
      }
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131713127));
      this.jdField_e_of_type_AndroidViewView.setContentDescription(anni.a(2131713106));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      B();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131713118));
    this.jdField_e_of_type_AndroidViewView.setContentDescription(anni.a(2131713116));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    C();
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return ((woa)this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int)).jdField_b_of_type_Boolean;
    }
    return false;
  }
  
  private void e(boolean paramBoolean)
  {
    float f2 = 1.0F;
    this.l = paramBoolean;
    this.jdField_a_of_type_Bnbf.k(paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
    if (paramBoolean)
    {
      f1 = 1.0F;
      ((PressDarkImageButton)localObject).setAlpha(f1);
      localObject = this.jdField_e_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (float f1 = f2;; f1 = 0.5F)
    {
      ((View)localObject).setAlpha(f1);
      return;
      f1 = 0.5F;
      break;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.cancel();
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(330L);
    this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    if (paramBoolean)
    {
      localObject = new TranslateAnimation(zby.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext()) / 2, 0.0F, 0.0F, 0.0F);
      ((TranslateAnimation)localObject).setDuration(300L);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.startAnimation((Animation)localObject);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131713120));
    if (this.jdField_b_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.153846F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(330L);
    this.jdField_c_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationScaleAnimation);
    int i1 = this.jdField_j_of_type_Int;
    if (this.jdField_a_of_type_Woa != null) {}
    for (Object localObject = this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString;; localObject = "")
    {
      yqu.a("textEdit_patten", "exp_panel", i1, 0, new String[] { "", localObject });
      return;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_AndroidViewView == null) || (this.jdField_d_of_type_AndroidViewView.getVisibility() == 8)) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(null);
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.cancel();
    }
    ScaleAnimation localScaleAnimation;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(250L);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new bozd(this));
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131713121));
      if (this.jdField_b_of_type_AndroidViewAnimationScaleAnimation != null) {
        this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.cancel();
      }
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.153846F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
      localScaleAnimation = this.jdField_b_of_type_AndroidViewAnimationScaleAnimation;
      if (!paramBoolean) {
        break label209;
      }
    }
    label209:
    for (long l1 = 330L;; l1 = 0L)
    {
      localScaleAnimation.setDuration(l1);
      this.jdField_c_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationScaleAnimation);
      return;
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break;
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_Bolb = ((bolb)bojv.a(5));
    woa localwoa;
    String str;
    if (this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      localwoa = (woa)this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int);
      if (localwoa != null) {
        str = localwoa.jdField_e_of_type_JavaLangString;
      }
    }
    try
    {
      this.jdField_d_of_type_Int = Color.parseColor(str);
      this.jdField_c_of_type_Int = localwoa.jdField_b_of_type_Int;
      if (!TextUtils.isEmpty(localwoa.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = localwoa.jdField_b_of_type_JavaLangString;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StoryEffectTextMode", 2, "initTextFilterBgColor, Exception:" + localException.toString());
        }
      }
    }
  }
  
  private void o()
  {
    int i2 = 0;
    if (this.n) {
      return;
    }
    Object localObject1 = new yxm(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    Object localObject2 = new yxh(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    localObject2 = new yxz().a(new zah(new yxs[] { localObject1, localObject2 })).a(this.jdField_b_of_type_AndroidViewView.getWidth()).b(this.jdField_b_of_type_AndroidViewView.getHeight()).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((yxx)localObject2);
    ((yxm)localObject1).a(new bozp(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleView(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnTextEditListener();
    this.n = true;
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getIntent().getStringExtra("text_filter_default_screen_touch_tips");
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getIntent().getStringExtra("share_url_target_url") == null) {}
    for (int i1 = 0;; i1 = 1)
    {
      this.jdField_j_of_type_Int = i1;
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131697048);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(c());
      }
      if (this.jdField_a_of_type_Boyy != null) {
        break label336;
      }
      localObject1 = this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray;
      localObject2 = new ArrayList(((SparseArray)localObject1).size());
      i1 = i2;
      while (i1 < ((SparseArray)localObject1).size())
      {
        ((List)localObject2).add(((SparseArray)localObject1).valueAt(i1));
        i1 += 1;
      }
    }
    this.jdField_a_of_type_Boyy = new boyy((List)localObject2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(zlx.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 10.0F));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Boyy);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    label336:
    localObject1 = this.jdField_a_of_type_Boyy.a(this.jdField_a_of_type_Boyy.a());
    this.jdField_d_of_type_AndroidViewView.setContentDescription(anni.a(2131713114) + ((woa)localObject1).jdField_b_of_type_JavaLangString + "’ ");
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.153846F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(0L);
    this.jdField_c_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
  }
  
  private void p()
  {
    nko.b(this.jdField_a_of_type_Bolb.a.jdField_b_of_type_Int + "", BaseApplicationImpl.getApplication().getRuntime(), true, new bozk(this));
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int i2 = this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1);
      a((woa)this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray.get(i2), true);
      i1 += 1;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_Bnbf.S();
    if (this.n) {
      if (TextUtils.isEmpty(((yxm)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a().jdField_a_of_type_JavaLangString)) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      d(bool);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      if (this.jdField_j_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      }
      return;
    }
  }
  
  private void r()
  {
    yyb localyyb = ((yxm)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a();
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anni.a(2131713124));
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setImageResource(2130846143);
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      if (TextUtils.isEmpty(localyyb.jdField_a_of_type_JavaLangString)) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      d(bool);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anni.a(2131713125));
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setImageResource(2130846142);
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
      break;
    }
  }
  
  private void s()
  {
    boolean bool;
    String str1;
    label129:
    int i1;
    if ((!this.jdField_j_of_type_Boolean) || (this.jdField_i_of_type_Boolean))
    {
      bool = true;
      this.jdField_j_of_type_Boolean = bool;
      r();
      if (this.jdField_j_of_type_Boolean) {
        u();
      }
      a(this.jdField_a_of_type_Woa, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 17, null);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter != null)
      {
        if (this.jdField_j_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter.setImagePath(null);
          this.jdField_i_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter.setIsNeedCameraTexture(this.jdField_j_of_type_Boolean);
      }
      if ((this.jdField_j_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        w();
      }
      if (!this.jdField_j_of_type_Boolean) {
        break label178;
      }
      str1 = "open_cam";
      i1 = this.jdField_j_of_type_Int;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label185;
      }
    }
    label178:
    label185:
    for (String str2 = "0";; str2 = "1")
    {
      yqu.a("textEdit", str1, i1, 0, new String[] { "", str2 });
      return;
      bool = false;
      break;
      str1 = "close_cam";
      break label129;
    }
  }
  
  private void t()
  {
    int i1 = this.jdField_a_of_type_Bnbf.d();
    boolean bool;
    label40:
    String str1;
    if (i1 == 2)
    {
      bool = true;
      this.m = bool;
      if (!this.m) {
        break label98;
      }
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anni.a(2131713110));
      if (i1 != 1) {
        break label114;
      }
      str1 = "use_frontCam";
      label49:
      i1 = this.jdField_j_of_type_Int;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label121;
      }
    }
    label98:
    label114:
    label121:
    for (String str2 = "0";; str2 = "1")
    {
      yqu.a("textEdit", str1, i1, 0, new String[] { "", str2 });
      return;
      bool = false;
      break;
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anni.a(2131713123));
      break label40;
      str1 = "use_backCam";
      break label49;
    }
  }
  
  private void u()
  {
    if (((this.jdField_a_of_type_Bnbf.e() == 1) && (this.m)) || ((this.jdField_a_of_type_Bnbf.e() == 2) && (!this.m)))
    {
      this.jdField_a_of_type_Bnbf.d();
      if (this.m) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anni.a(2131713115));
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anni.a(2131713112));
  }
  
  private void v()
  {
    if (!this.jdField_k_of_type_Boolean)
    {
      w();
      return;
    }
    Object localObject;
    if (d())
    {
      this.jdField_a_of_type_Bnbf.Q();
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
      localObject = new biax(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), 2131561460);
      this.o = false;
      ((biax)localObject).a(0, anni.a(2131713126), 0, new bozl(this));
      ThreadManager.getUIHandler().postDelayed(new StoryEffectTextMode.8(this, (biax)localObject), 5000L);
      return;
    }
    this.jdField_a_of_type_Bnbf.q();
    yqu.a("textEdit", "takePhoto", this.jdField_j_of_type_Int, 0, new String[0]);
    int i1 = this.jdField_j_of_type_Int;
    String str2;
    if (this.jdField_i_of_type_Boolean)
    {
      localObject = "3";
      str2 = this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Wny == null) {
        break label254;
      }
      str1 = this.jdField_a_of_type_Wny.jdField_a_of_type_JavaLangString;
      label163:
      yqu.a("textEdit", "done_textEdit", i1, 0, new String[] { localObject, str2, str1 });
      i1 = this.jdField_j_of_type_Int;
      if (!this.jdField_i_of_type_Boolean) {
        break label260;
      }
      localObject = "3";
      label207:
      str2 = this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Wny == null) {
        break label267;
      }
    }
    label260:
    label267:
    for (String str1 = this.jdField_a_of_type_Wny.jdField_a_of_type_JavaLangString;; str1 = "")
    {
      wnx.jdField_a_of_type_Wnz = new wnz(i1, (String)localObject, str2, str1);
      return;
      localObject = "0";
      break;
      label254:
      str1 = "";
      break label163;
      localObject = "0";
      break label207;
    }
  }
  
  private void w()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    x();
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    g(true);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Bozo == null) {
      this.jdField_a_of_type_Bozo = new bozo(this);
    }
    this.jdField_a_of_type_Yzc = new bozm(this, this.jdField_b_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_Yzc.setContentView(2131561825);
    this.jdField_a_of_type_Yzc.a(this.jdField_a_of_type_Bozo);
    if (this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      woa localwoa = (woa)this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int);
      if (localwoa != null)
      {
        int i1 = localwoa.jdField_c_of_type_Int;
        this.jdField_a_of_type_Yzc.a(i1);
      }
    }
    this.jdField_a_of_type_Yzc.a(new bozc(this));
    this.jdField_a_of_type_Yzc.show();
  }
  
  private void y()
  {
    int i1;
    if (this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray != null) {
      i1 = 0;
    }
    for (;;)
    {
      wny localwny;
      Object localObject1;
      Object localObject2;
      if (i1 < this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        int i2 = this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i1);
        if (((wny)this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.get(i2)).jdField_a_of_type_Int != this.jdField_i_of_type_Int) {
          break label331;
        }
        if (i1 >= this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.size() - 1) {
          break label297;
        }
        i1 = this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i1 + 1);
        localwny = (wny)this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
        this.jdField_a_of_type_Wny = localwny;
        localObject1 = localwny.jdField_e_of_type_JavaLangString;
        localObject2 = localwny.jdField_b_of_type_JavaLangString;
        i1 = Color.parseColor((String)localObject1);
        i2 = Color.parseColor((String)localObject2);
        this.jdField_g_of_type_Int = i1;
        this.jdField_c_of_type_Int = localwny.jdField_a_of_type_Int;
        this.jdField_d_of_type_Int = i2;
        if (TextUtils.isEmpty(localwny.jdField_c_of_type_JavaLangString)) {
          break label315;
        }
        this.jdField_e_of_type_Int = Color.parseColor(localwny.jdField_c_of_type_JavaLangString);
        label196:
        if (TextUtils.isEmpty(localwny.jdField_d_of_type_JavaLangString)) {
          break label323;
        }
      }
      label297:
      label315:
      label323:
      for (this.jdField_f_of_type_Int = Color.parseColor(localwny.jdField_d_of_type_JavaLangString);; this.jdField_f_of_type_Int = 0)
      {
        a(this.jdField_a_of_type_Woa, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 1, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_i_of_type_Int = localwny.jdField_a_of_type_Int;
        localObject1 = (yxm)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
        localObject2 = ((yxm)localObject1).a();
        ((yyb)localObject2).jdField_a_of_type_Int = Color.parseColor(localwny.jdField_e_of_type_JavaLangString);
        ((yxm)localObject1).a((yyb)localObject2);
        return;
        i1 = this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.keyAt(0);
        break;
        this.jdField_e_of_type_Int = 0;
        break label196;
      }
      label331:
      i1 += 1;
    }
  }
  
  private void z()
  {
    if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)
    {
      g(true);
      i1 = this.jdField_j_of_type_Int;
      if (this.jdField_a_of_type_Woa != null) {}
      for (str = this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString;; str = "")
      {
        yqu.a("textEdit_patten", "clk_close", i1, 0, new String[] { "", str });
        return;
      }
    }
    f(false);
    int i1 = this.jdField_j_of_type_Int;
    if (this.jdField_a_of_type_Woa != null) {}
    for (String str = this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString;; str = "")
    {
      yqu.a("textEdit_patten", "clk_open", i1, 0, new String[] { "", str });
      return;
    }
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    yqp.b("StoryEffectTextMode", "QG onMethodRequest getTextConfig");
    ThreadManager.getUIHandler().post(new StoryEffectTextMode.19(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10014) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter != null) && (!TextUtils.isEmpty(paramIntent)))
      {
        this.jdField_i_of_type_Boolean = true;
        a(this.jdField_a_of_type_Woa, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 17, null);
        this.jdField_j_of_type_Boolean = false;
        r();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter.setImagePath(paramIntent);
        if (QLog.isColorLevel()) {
          QLog.d("StoryEffectTextMode", 2, "selectedPic, " + paramIntent);
        }
        paramInt1 = this.jdField_j_of_type_Int;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          break label155;
        }
      }
    }
    label155:
    for (paramIntent = "0";; paramIntent = "1")
    {
      yqu.a("textEdit", "done_upload", paramInt1, 0, new String[] { "", paramIntent });
      return;
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    b(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  public String b()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Woa.f)) {
      return d() + this.jdField_a_of_type_Woa.jdField_d_of_type_Int + "/" + this.jdField_a_of_type_Woa.jdField_d_of_type_JavaLangString + "/" + this.jdField_a_of_type_Woa.f;
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    l();
    Object localObject = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a();
    if (localObject != null) {
      ((boyq)localObject).b(this.jdField_a_of_type_JavaLangRunnable);
    }
    g(true);
    if (this.jdField_d_of_type_Boolean) {
      I();
    }
    for (;;)
    {
      localObject = EffectsCameraCaptureView.b();
      if (localObject != null)
      {
        CameraCaptureView localCameraCaptureView = this.jdField_a_of_type_Bncn.a();
        if ((localCameraCaptureView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          String str = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = null;
          localCameraCaptureView.queueEvent(new StoryEffectTextMode.5(this, (QQFilterRenderManager)localObject, str));
        }
      }
      if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getModuleEngine().unRegisterJsModule(this.jdField_a_of_type_Bjey);
        this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getQGBridge().clearRegisteredEvents();
        this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.reset();
      }
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = false;
      this.jdField_k_of_type_Int = 0;
      return;
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    g();
    o();
    label51:
    Object localObject1;
    Object localObject2;
    String str1;
    int i1;
    int i2;
    if (this.jdField_d_of_type_Boolean)
    {
      H();
      if (TextUtils.isEmpty(((yxm)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a().jdField_a_of_type_JavaLangString)) {
        break label572;
      }
      paramBoolean = true;
      d(paramBoolean);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        localObject1 = (woa)this.jdField_a_of_type_Bolb.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int);
        if (localObject1 != null)
        {
          localObject2 = ((woa)localObject1).jdField_b_of_type_JavaLangString;
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          if (!((woa)localObject1).jdField_a_of_type_Boolean) {
            break label593;
          }
          if (this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray != null)
          {
            localObject2 = (wny)this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_i_of_type_Int);
            if (localObject2 != null)
            {
              this.jdField_a_of_type_Wny = ((wny)localObject2);
              str1 = ((wny)localObject2).jdField_e_of_type_JavaLangString;
              String str2 = ((wny)localObject2).jdField_b_of_type_JavaLangString;
              String str3 = ((wny)localObject2).jdField_c_of_type_JavaLangString;
              String str4 = ((wny)localObject2).jdField_d_of_type_JavaLangString;
              i1 = Color.parseColor(str1);
              i2 = Color.parseColor(str2);
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
              this.jdField_c_of_type_Int = ((wny)localObject2).jdField_a_of_type_Int;
              this.jdField_d_of_type_Int = i2;
              if (TextUtils.isEmpty(str3)) {
                break label577;
              }
              this.jdField_e_of_type_Int = Color.parseColor(str3);
              label253:
              if (TextUtils.isEmpty(str4)) {
                break label585;
              }
              this.jdField_f_of_type_Int = Color.parseColor(str4);
              label270:
              this.jdField_g_of_type_Int = i1;
            }
            if (this.jdField_a_of_type_Bolb.a.jdField_b_of_type_AndroidUtilSparseArray.size() > 1) {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            }
          }
          label300:
          this.jdField_a_of_type_Woa = ((woa)localObject1);
          if (!this.jdField_i_of_type_Boolean)
          {
            this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_d_of_type_Int);
            this.jdField_h_of_type_Boolean = true;
          }
        }
      }
      if (!this.jdField_a_of_type_Woa.jdField_b_of_type_Boolean) {
        break label668;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      label348:
      if (this.jdField_j_of_type_Boolean) {
        u();
      }
      i1 = this.jdField_j_of_type_Int;
      localObject2 = this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString;
      if ((!this.jdField_a_of_type_Woa.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Wny != null)) {
        break label689;
      }
      localObject1 = "";
      label394:
      yqu.a("textEdit", "exp_textEdit", i1, 0, new String[] { "", localObject2, localObject1 });
      D();
      e(false);
      localObject1 = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a();
      if (localObject1 == null) {
        break label701;
      }
      ((boyq)localObject1).a(this.jdField_a_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      p();
      if (QLog.isColorLevel()) {
        QLog.i("StoryEffectTextModeQ.qqstory.text_filter", 2, "initCaptureMode textFilter switch, mIsEnable: " + this.jdField_a_of_type_Bolb.a.jdField_a_of_type_Boolean + ", mIsDPCEnable:" + this.jdField_a_of_type_Bolb.a.jdField_b_of_type_Boolean + ", ver:" + nko.a("1018") + ", QGLoader.soloaded:" + bjes.b.get() + ", Build.MODEL:" + Build.MODEL);
      }
      return;
      f(false);
      break;
      label572:
      paramBoolean = false;
      break label51;
      label577:
      this.jdField_e_of_type_Int = 0;
      break label253;
      label585:
      this.jdField_f_of_type_Int = 0;
      break label270;
      label593:
      localObject2 = ((woa)localObject1).jdField_c_of_type_JavaLangString;
      str1 = ((woa)localObject1).jdField_e_of_type_JavaLangString;
      i1 = Color.parseColor((String)localObject2);
      i2 = Color.parseColor(str1);
      this.jdField_c_of_type_Int = ((woa)localObject1).jdField_b_of_type_Int;
      this.jdField_d_of_type_Int = i2;
      this.jdField_e_of_type_Int = 0;
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Int = i1;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      break label300;
      label668:
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label348;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label348;
      label689:
      localObject1 = this.jdField_a_of_type_Wny.jdField_a_of_type_JavaLangString;
      break label394;
      label701:
      yqp.e("StoryEffectTextMode", "warning!!! warning!!! warning!!!, QGEnvironment is null!!!");
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bolb.c();
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
    }
  }
  
  public boolean c()
  {
    int i1 = this.jdField_j_of_type_Int;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (String str = "0";; str = "1")
    {
      yqu.a("textEdit", "clk_upload", i1, 0, new String[] { "", str });
      if (this.l) {
        break;
      }
      A();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    super.d();
    q();
    a(this.jdField_a_of_type_Woa, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 4, "onResume");
    if (this.jdField_a_of_type_Bjfe != null) {
      this.jdField_a_of_type_Bjfe.a();
    }
  }
  
  public void e()
  {
    super.e();
    g(false);
    if (this.jdField_a_of_type_Bjfe != null) {
      this.jdField_a_of_type_Bjfe.c();
    }
  }
  
  public void f()
  {
    super.f();
    l();
    if (this.jdField_a_of_type_Bjfe != null)
    {
      VideoPlayer.unActiveMediaPlayer(this.jdField_a_of_type_Bjfe);
      this.jdField_a_of_type_Bjfe.destroy();
    }
  }
  
  public void g()
  {
    yqp.b("StoryEffectTextMode", "initView");
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return;
    }
    n();
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(2131560941, (ViewGroup)this.jdField_a_of_type_AndroidViewView, false);
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131366872);
      if (localViewGroup != null) {
        localViewGroup.addView(this.jdField_b_of_type_AndroidViewView, 2, localLayoutParams);
      }
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365872));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371690));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371689));
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378362);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378361));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131378360));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378503));
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131371688);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131371968));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368668));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378504));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131378129));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378364));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131364638);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setEditListener(this);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    d(false);
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_d_of_type_Int);
  }
  
  public void h()
  {
    if (d()) {
      a(this.jdField_a_of_type_Woa, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 4, "captureVideo");
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      g(true);
      this.jdField_c_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_j_of_type_Boolean) {
        yqu.a("textEdit", "takeVideo", this.jdField_j_of_type_Int, 0, new String[0]);
      }
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(false);
    }
  }
  
  public void i()
  {
    if (!d())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setVisibility(0);
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_Int = 0;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
    if (this.jdField_j_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
    }
    String str1 = "2";
    if (this.p) {
      str1 = "0";
    }
    if ((!this.jdField_a_of_type_Woa.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Wny != null)) {}
    for (String str2 = this.jdField_a_of_type_Wny.jdField_a_of_type_JavaLangString;; str2 = "")
    {
      yqu.a("textEdit", "done_textEdit", this.jdField_j_of_type_Int, 0, new String[] { str1, this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString, str2 });
      wnx.jdField_a_of_type_Wnz = new wnz(this.jdField_j_of_type_Int, str1, this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString, str2);
      return;
    }
  }
  
  public boolean isValidate()
  {
    return (this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean);
  }
  
  public void j()
  {
    if (!d())
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(false);
    }
    int i1;
    String str2;
    if ((this.jdField_a_of_type_Woa != null) && (this.jdField_a_of_type_Wny != null))
    {
      i1 = this.jdField_j_of_type_Int;
      str2 = this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_Woa.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Wny == null)) {
        break label170;
      }
      str1 = this.jdField_a_of_type_Wny.jdField_a_of_type_JavaLangString;
      yqu.a("textEdit", "done_textEdit", i1, 0, new String[] { "1", str2, str1 });
      i1 = this.jdField_j_of_type_Int;
      str2 = this.jdField_a_of_type_Woa.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Woa.jdField_b_of_type_Boolean) {
        break label176;
      }
    }
    label170:
    label176:
    for (String str1 = "";; str1 = this.jdField_a_of_type_Wny.jdField_a_of_type_JavaLangString)
    {
      wnx.jdField_a_of_type_Wnz = new wnz(i1, "1", str2, str1);
      if (this.jdField_j_of_type_Boolean) {
        yqu.a("textEdit", "takePhoto", this.jdField_j_of_type_Int, 0, new String[0]);
      }
      return;
      str1 = "";
      break;
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Bgua != null)
    {
      this.jdField_a_of_type_Bgua.e();
      this.jdField_a_of_type_Bgua = null;
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      z();
      continue;
      y();
      continue;
      if (!this.l)
      {
        A();
      }
      else
      {
        w();
        continue;
        if (!this.l)
        {
          A();
        }
        else
        {
          s();
          continue;
          t();
          continue;
          if (!this.l) {
            A();
          } else {
            v();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boza
 * JD-Core Version:    0.7.0.1
 */