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

public class bqav
  extends bqau
  implements bkfz, IEventReceiver, zdm
{
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new bqbd(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhud jdField_a_of_type_Bhud;
  private bhue jdField_a_of_type_Bhue = new bqbe(this);
  private bkfy jdField_a_of_type_Bkfy;
  private bkge jdField_a_of_type_Bkge;
  private bpmw jdField_a_of_type_Bpmw = (bpmw)bplq.a(5);
  private bqat jdField_a_of_type_Bqat;
  private bqbj jdField_a_of_type_Bqbj;
  private DoodleEditView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
  private DoodleView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private QQTextEjectaFilter.EjectaTextureCallBack jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter$EjectaTextureCallBack = new bqaw(this);
  private QQTextEjectaFilter jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter;
  private StoryQGSurfaceView jdField_a_of_type_ComTencentQgStoryQGSurfaceView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.2(this);
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private wrt jdField_a_of_type_Wrt = new wrt();
  private wrv jdField_a_of_type_Wrv;
  private zcx jdField_a_of_type_Zcx;
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
  
  public bqav(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bpmw.a = new wrs(BaseApplicationImpl.getContext(), BaseApplicationImpl.sApplication.getRuntime().getAccount());
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_Wrv != null) && (!this.jdField_a_of_type_Wrv.jdField_c_of_type_Boolean))
    {
      if ((!bhnv.d(this.jdField_b_of_type_AndroidViewView.getContext())) || (this.jdField_a_of_type_Wrv.jdField_d_of_type_Boolean)) {
        G();
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_b_of_type_AndroidViewView.getContext(), anzj.a(2131713237), 0).a();
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      int i1 = zps.a(this.jdField_b_of_type_AndroidViewView.getContext(), 4.0F);
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
    yuk.b("StoryEffectTextMode", "showSoLoading");
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
    }
  }
  
  private void E()
  {
    yuk.b("StoryEffectTextMode", "dismissSoLoading");
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    }
  }
  
  private void F()
  {
    Object localObject = d() + this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_Int + "/qg.js";
    if (new File((String)localObject).exists())
    {
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.addJavaScriptFileFromSDCard((String)localObject);
      localObject = d() + this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_Int + "/" + this.jdField_a_of_type_Bpmw.a.jdField_c_of_type_JavaLangString + "/" + this.jdField_a_of_type_Bpmw.a.jdField_c_of_type_JavaLangString + ".js";
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
        localObject = new JSONObject(this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_JavaLangString);
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
      this.jdField_b_of_type_AndroidAnimationAnimator.addListener(new bqba(this));
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
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new bqbb(this));
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
    yuk.b("StoryEffectTextMode", "initQGEnvironment success!");
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
          this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView = ((bqal)localObject).a(this.jdField_a_of_type_Bodv);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView);
        }
      }
      if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView == null) {
        break label269;
      }
      this.jdField_a_of_type_Bkfy = new bkfy();
      this.jdField_a_of_type_Bkfy.a(this);
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getModuleEngine().registerJsModule(this.jdField_a_of_type_Bkfy);
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.setExtResPath(d() + this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_Int + "/");
      if (this.jdField_a_of_type_Bkge == null)
      {
        this.jdField_a_of_type_Bkge = new bkge();
        VideoPlayer.activeMediaPlayer(this.jdField_a_of_type_Bkge);
      }
      this.jdField_a_of_type_Bkge.a(d() + this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_Int + "/");
      localObject = new bqbc(this);
      if (i1 == 0) {
        break;
      }
      this.jdField_a_of_type_Bocn.a().queueEvent(new StoryEffectTextMode.18(this, (QGRenderer.QGEventListener)localObject));
      return;
    }
    this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.setQGEventListener((QGRenderer.QGEventListener)localObject);
    return;
    label269:
    yuk.e("StoryEffectTextMode", "QGEnvironment and mQGGLView is null!! ");
  }
  
  private void L()
  {
    QQFilterRenderManager localQQFilterRenderManager = EffectsCameraCaptureView.b();
    if (localQQFilterRenderManager == null)
    {
      CameraCaptureView localCameraCaptureView = this.jdField_a_of_type_Bodv.a();
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
    if (a(this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_Int)) {
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
          if ((paramBoolean) && (this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray != null))
          {
            i2 = Color.parseColor(((wrt)this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_i_of_type_Int)).jdField_b_of_type_JavaLangString);
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
      float f1 = this.jdField_a_of_type_Bpmw.a.jdField_c_of_type_Int / 100.0F;
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
  
  private String a(wrv paramwrv)
  {
    if (paramwrv == null) {
      paramwrv = "";
    }
    String str2;
    String str1;
    do
    {
      return paramwrv;
      str2 = d() + paramwrv.jdField_d_of_type_Int + "/" + paramwrv.jdField_d_of_type_JavaLangString + "/" + paramwrv.jdField_d_of_type_JavaLangString;
      str1 = str2 + ".js";
      paramwrv = str1;
    } while (new File(str1).exists());
    return str2 + "_android.js";
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Bhud != null) {
      l();
    }
    this.jdField_a_of_type_Bhud = new bhud(paramString, new Handler());
    this.jdField_a_of_type_Bhud.a(this.jdField_b_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_Bhud.b();
    this.jdField_a_of_type_Bhud.a(this.jdField_a_of_type_Bhue);
    this.jdField_a_of_type_Bhud.b();
  }
  
  private void a(wrv paramwrv)
  {
    Object localObject1 = paramwrv.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_d_of_type_AndroidViewView.setContentDescription(anzj.a(2131713222) + (String)localObject1 + "’ ");
    this.jdField_h_of_type_Int = paramwrv.jdField_a_of_type_Int;
    int i1 = paramwrv.jdField_c_of_type_Int;
    if ((this.jdField_a_of_type_Bkge != null) && (this.jdField_a_of_type_Bkge.isPlaying())) {
      this.jdField_a_of_type_Bkge.stop();
    }
    if (this.jdField_a_of_type_Zcx != null) {
      this.jdField_a_of_type_Zcx.a(i1);
    }
    Object localObject2;
    if (paramwrv.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(8);
      if (!paramwrv.jdField_a_of_type_Boolean) {
        break label382;
      }
      if (this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray != null)
      {
        localObject1 = (wrt)this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_i_of_type_Int);
        this.jdField_a_of_type_Wrt = ((wrt)localObject1);
        if (localObject1 != null)
        {
          localObject2 = ((wrt)localObject1).jdField_e_of_type_JavaLangString;
          Object localObject3 = ((wrt)localObject1).jdField_b_of_type_JavaLangString;
          i1 = Color.parseColor((String)localObject2);
          int i2 = Color.parseColor((String)localObject3);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
          localObject2 = (zbh)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
          localObject3 = ((zbh)localObject2).a();
          ((zbw)localObject3).jdField_a_of_type_Int = i1;
          ((zbh)localObject2).a((zbw)localObject3);
          this.jdField_c_of_type_Int = ((wrt)localObject1).jdField_a_of_type_Int;
          this.jdField_d_of_type_Int = i2;
          this.jdField_g_of_type_Int = i1;
        }
        if (this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.size() > 1) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Wrv = paramwrv;
      a(this.jdField_a_of_type_Wrv, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 11, null);
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
      localObject1 = paramwrv.jdField_c_of_type_JavaLangString;
      localObject2 = paramwrv.jdField_e_of_type_JavaLangString;
      i1 = Color.parseColor((String)localObject1);
      this.jdField_d_of_type_Int = Color.parseColor((String)localObject2);
      this.jdField_c_of_type_Int = paramwrv.jdField_b_of_type_Int;
      this.jdField_e_of_type_Int = 0;
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Int = i1;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(wrv paramwrv, int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    paramwrv.jdField_d_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Wrv != null) && (this.jdField_a_of_type_Wrv.jdField_d_of_type_Int == paramwrv.jdField_d_of_type_Int) && (this.jdField_g_of_type_Boolean)) {
      G();
    }
    QLog.e("StoryEffectTextMode", 2, "onDownloadOfflinePkgFailed，" + paramwrv.jdField_d_of_type_Int);
  }
  
  private void a(wrv paramwrv, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int i1 = 0;
    yuk.b("StoryEffectTextMode", "onTextFilterInfoChange");
    if (paramwrv == null) {}
    Object localObject;
    String str1;
    label280:
    boolean bool;
    label290:
    do
    {
      return;
      this.jdField_a_of_type_Wrv = paramwrv;
      this.jdField_c_of_type_JavaLangString = paramString1;
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
      if ((!this.jdField_e_of_type_Boolean) || (!bkfs.b.get()))
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
      this.jdField_a_of_type_Wrv.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_Wrv.jdField_d_of_type_Int);
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Bqat.getCount())
      {
        paramwrv = this.jdField_a_of_type_Bqat.a(paramInt2);
        if (paramwrv.jdField_d_of_type_Int == this.jdField_a_of_type_Wrv.jdField_d_of_type_Int) {
          paramwrv.jdField_c_of_type_Boolean = this.jdField_a_of_type_Wrv.jdField_c_of_type_Boolean;
        }
        paramInt2 += 1;
      }
      this.jdField_a_of_type_Bqat.notifyDataSetChanged();
      localObject = "";
      if (!this.jdField_a_of_type_Wrv.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_g_of_type_Boolean = false;
      E();
      e(true);
      if (!this.jdField_f_of_type_Boolean) {
        F();
      }
      paramwrv = this.jdField_a_of_type_Wrv.jdField_d_of_type_JavaLangString;
      str1 = a(this.jdField_a_of_type_Wrv);
      localObject = paramwrv;
      if (QLog.isColorLevel())
      {
        QLog.d("StoryEffectTextMode", 2, "load " + str1);
        localObject = paramwrv;
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
        paramwrv = this.jdField_c_of_type_OrgJsonJSONObject;
        if (this.jdField_j_of_type_Boolean) {
          break label1153;
        }
        paramInt2 = i1;
        if (this.jdField_i_of_type_Boolean) {
          break label1153;
        }
        paramwrv.put("cameraStatus", paramInt2);
        a("qg_onCameraSwitch", this.jdField_c_of_type_OrgJsonJSONObject.toString());
      }
      catch (JSONException paramwrv)
      {
        String str2;
        String str3;
        label851:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "EVENT_NAME_QG_ON_CAMERA_SWITCH, JSONException:" + paramwrv.toString());
        continue;
      }
      if ((paramInt3 & 0x1) != 0)
      {
        paramwrv = a(paramInt1, 0.0F);
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
        this.jdField_b_of_type_OrgJsonJSONObject.put("backgroundColor", paramwrv);
        this.jdField_b_of_type_OrgJsonJSONObject.put("backgroundColor2", str1);
        this.jdField_b_of_type_OrgJsonJSONObject.put("backgroundColor3", str2);
        this.jdField_b_of_type_OrgJsonJSONObject.put("textColor", str3);
        a("qg_BackgroundChange", this.jdField_b_of_type_OrgJsonJSONObject.toString());
      }
      catch (JSONException paramwrv)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "onInputTextComplete, JSONException:" + paramwrv.toString());
        continue;
        paramString1 = paramwrv;
        if (!begp.a(paramwrv)) {
          continue;
        }
        paramString1 = bgqd.a(paramwrv, "□");
        continue;
      }
      if ((paramInt3 & 0x8) != 0)
      {
        paramwrv = paramString1;
        if (paramString1 == null) {
          paramwrv = "";
        }
        if ((TextUtils.isEmpty(paramwrv)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
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
        paramwrv = new JSONObject();
        paramwrv.put("tmplName", localObject);
        if (!TextUtils.isEmpty(paramString2)) {
          paramwrv.put("scene", paramString2);
        }
        a("qg_Restart", paramwrv.toString());
      }
      catch (JSONException paramwrv)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "QG_RESTART, JSONException:" + paramwrv.toString());
        continue;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Wrv.f))
      {
        paramwrv = d() + this.jdField_a_of_type_Wrv.jdField_d_of_type_Int + "/" + this.jdField_a_of_type_Wrv.jdField_d_of_type_JavaLangString + "/" + this.jdField_a_of_type_Wrv.f;
        if (new File(paramwrv).exists())
        {
          b(paramwrv);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StoryEffectTextMode", 2, this.jdField_a_of_type_Wrv.jdField_d_of_type_JavaLangString + " is not download！");
          }
          this.jdField_g_of_type_Boolean = true;
          if (!this.jdField_i_of_type_Boolean) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_d_of_type_Int);
          }
          this.jdField_h_of_type_Boolean = true;
          e(false);
          if (bhnv.d(this.jdField_b_of_type_AndroidViewView.getContext()))
          {
            a(this.jdField_a_of_type_Wrv, false);
            break label280;
          }
          this.jdField_a_of_type_Wrv.jdField_d_of_type_Boolean = true;
          G();
          break label280;
          bool = false;
          break label290;
        }
        if (this.jdField_a_of_type_Bhud == null) {
          break;
        }
        l();
        return;
      }
      if (this.jdField_a_of_type_Bhud == null) {
        break;
      }
      l();
      return;
      label1018:
      if ((paramInt3 & 0x2) != 0) {
        l();
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Wrv.f))
      {
        paramwrv = d() + this.jdField_a_of_type_Wrv.jdField_d_of_type_Int + "/" + this.jdField_a_of_type_Wrv.jdField_d_of_type_JavaLangString + "/" + this.jdField_a_of_type_Wrv.f;
        if (new File(paramwrv).exists())
        {
          if (this.jdField_a_of_type_Bhud != null) {
            break;
          }
          a(paramwrv);
          return;
        }
        if (this.jdField_a_of_type_Bhud == null) {
          break;
        }
        l();
        return;
      }
      if (this.jdField_a_of_type_Bhud == null) {
        break;
      }
      l();
      return;
      label1153:
      paramInt2 = 1;
    }
  }
  
  private void a(wrv paramwrv, boolean paramBoolean)
  {
    if ((paramwrv == null) || (paramwrv.jdField_d_of_type_Int == 0)) {}
    for (;;)
    {
      return;
      String str = String.valueOf(paramwrv.jdField_d_of_type_Int);
      paramwrv.jdField_d_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(str))
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (nmj.a(str) == null) {}
        for (boolean bool = true; (bool) || (paramBoolean); bool = false)
        {
          this.jdField_a_of_type_JavaUtilSet.add(str);
          nmj.b(str, localAppRuntime, new bqaz(this, bool, paramwrv, str), true, 0, true);
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
      str = nmj.a(String.valueOf(paramInt));
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
  
  private void b(wrv paramwrv)
  {
    yuk.b("StoryEffectTextMode", "onDownloadedResource");
    paramwrv.jdField_c_of_type_Boolean = true;
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {}
    while ((!a(this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_Int)) || (this.jdField_a_of_type_Wrv == null) || (this.jdField_a_of_type_Wrv.jdField_d_of_type_Int != paramwrv.jdField_d_of_type_Int) || (!this.jdField_g_of_type_Boolean)) {
      return;
    }
    this.jdField_g_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("StoryEffectTextMode", 2, "download template resource success！ draw screen！");
    }
    a(this.jdField_a_of_type_Wrv, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 11, null);
  }
  
  private void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    zbc localzbc = (zbc)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("GuideLineLayer");
    if (localzbc == null) {
      return;
    }
    localzbc.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
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
    return nmp.b();
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
    bocn localbocn = this.jdField_a_of_type_Bocn;
    if ((this.jdField_j_of_type_Boolean) && (paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      localbocn.j(bool);
      if ((!this.jdField_j_of_type_Boolean) || (!paramBoolean)) {
        break;
      }
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131713236));
      this.jdField_e_of_type_AndroidViewView.setContentDescription(anzj.a(2131713215));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      B();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131713227));
    this.jdField_e_of_type_AndroidViewView.setContentDescription(anzj.a(2131713225));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    C();
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return ((wrv)this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int)).jdField_b_of_type_Boolean;
    }
    return false;
  }
  
  private void e(boolean paramBoolean)
  {
    float f2 = 1.0F;
    this.l = paramBoolean;
    this.jdField_a_of_type_Bocn.k(paramBoolean);
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
      localObject = new TranslateAnimation(zft.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext()) / 2, 0.0F, 0.0F, 0.0F);
      ((TranslateAnimation)localObject).setDuration(300L);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.startAnimation((Animation)localObject);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131713229));
    if (this.jdField_b_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.153846F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(330L);
    this.jdField_c_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationScaleAnimation);
    int i1 = this.jdField_j_of_type_Int;
    if (this.jdField_a_of_type_Wrv != null) {}
    for (Object localObject = this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString;; localObject = "")
    {
      yup.a("textEdit_patten", "exp_panel", i1, 0, new String[] { "", localObject });
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
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new bqay(this));
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131713230));
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
    this.jdField_a_of_type_Bpmw = ((bpmw)bplq.a(5));
    wrv localwrv;
    String str;
    if (this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      localwrv = (wrv)this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int);
      if (localwrv != null) {
        str = localwrv.jdField_e_of_type_JavaLangString;
      }
    }
    try
    {
      this.jdField_d_of_type_Int = Color.parseColor(str);
      this.jdField_c_of_type_Int = localwrv.jdField_b_of_type_Int;
      if (!TextUtils.isEmpty(localwrv.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = localwrv.jdField_b_of_type_JavaLangString;
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
    Object localObject1 = new zbh(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    Object localObject2 = new zbc(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    localObject2 = new zbu().a(new zec(new zbn[] { localObject1, localObject2 })).a(this.jdField_b_of_type_AndroidViewView.getWidth()).b(this.jdField_b_of_type_AndroidViewView.getHeight()).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((zbs)localObject2);
    ((zbh)localObject1).a(new bqbk(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleView(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnTextEditListener();
    this.n = true;
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getIntent().getStringExtra("text_filter_default_screen_touch_tips");
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getIntent().getStringExtra("share_url_target_url") == null) {}
    for (int i1 = 0;; i1 = 1)
    {
      this.jdField_j_of_type_Int = i1;
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131697097);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(c());
      }
      if (this.jdField_a_of_type_Bqat != null) {
        break label336;
      }
      localObject1 = this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray;
      localObject2 = new ArrayList(((SparseArray)localObject1).size());
      i1 = i2;
      while (i1 < ((SparseArray)localObject1).size())
      {
        ((List)localObject2).add(((SparseArray)localObject1).valueAt(i1));
        i1 += 1;
      }
    }
    this.jdField_a_of_type_Bqat = new bqat((List)localObject2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(zps.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 10.0F));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bqat);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    label336:
    localObject1 = this.jdField_a_of_type_Bqat.a(this.jdField_a_of_type_Bqat.a());
    this.jdField_d_of_type_AndroidViewView.setContentDescription(anzj.a(2131713223) + ((wrv)localObject1).jdField_b_of_type_JavaLangString + "’ ");
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.153846F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(0L);
    this.jdField_c_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
  }
  
  private void p()
  {
    nmj.b(this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_Int + "", BaseApplicationImpl.getApplication().getRuntime(), true, new bqbf(this));
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int i2 = this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1);
      a((wrv)this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray.get(i2), true);
      i1 += 1;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_Bocn.S();
    if (this.n) {
      if (TextUtils.isEmpty(((zbh)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a().jdField_a_of_type_JavaLangString)) {
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
    zbw localzbw = ((zbh)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a();
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anzj.a(2131713233));
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setImageResource(2130846158);
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      if (TextUtils.isEmpty(localzbw.jdField_a_of_type_JavaLangString)) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      d(bool);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anzj.a(2131713234));
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setImageResource(2130846157);
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
      a(this.jdField_a_of_type_Wrv, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 17, null);
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
      yup.a("textEdit", str1, i1, 0, new String[] { "", str2 });
      return;
      bool = false;
      break;
      str1 = "close_cam";
      break label129;
    }
  }
  
  private void t()
  {
    int i1 = this.jdField_a_of_type_Bocn.d();
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
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anzj.a(2131713219));
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
      yup.a("textEdit", str1, i1, 0, new String[] { "", str2 });
      return;
      bool = false;
      break;
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anzj.a(2131713232));
      break label40;
      str1 = "use_backCam";
      break label49;
    }
  }
  
  private void u()
  {
    if (((this.jdField_a_of_type_Bocn.e() == 1) && (this.m)) || ((this.jdField_a_of_type_Bocn.e() == 2) && (!this.m)))
    {
      this.jdField_a_of_type_Bocn.d();
      if (this.m) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anzj.a(2131713224));
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(anzj.a(2131713221));
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
      this.jdField_a_of_type_Bocn.Q();
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
      localObject = new bjbv(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), 2131561501);
      this.o = false;
      ((bjbv)localObject).a(0, anzj.a(2131713235), 0, new bqbg(this));
      ThreadManager.getUIHandler().postDelayed(new StoryEffectTextMode.8(this, (bjbv)localObject), 5000L);
      return;
    }
    this.jdField_a_of_type_Bocn.q();
    yup.a("textEdit", "takePhoto", this.jdField_j_of_type_Int, 0, new String[0]);
    int i1 = this.jdField_j_of_type_Int;
    String str2;
    if (this.jdField_i_of_type_Boolean)
    {
      localObject = "3";
      str2 = this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Wrt == null) {
        break label254;
      }
      str1 = this.jdField_a_of_type_Wrt.jdField_a_of_type_JavaLangString;
      label163:
      yup.a("textEdit", "done_textEdit", i1, 0, new String[] { localObject, str2, str1 });
      i1 = this.jdField_j_of_type_Int;
      if (!this.jdField_i_of_type_Boolean) {
        break label260;
      }
      localObject = "3";
      label207:
      str2 = this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Wrt == null) {
        break label267;
      }
    }
    label260:
    label267:
    for (String str1 = this.jdField_a_of_type_Wrt.jdField_a_of_type_JavaLangString;; str1 = "")
    {
      wrs.jdField_a_of_type_Wru = new wru(i1, (String)localObject, str2, str1);
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
    if (this.jdField_a_of_type_Bqbj == null) {
      this.jdField_a_of_type_Bqbj = new bqbj(this);
    }
    this.jdField_a_of_type_Zcx = new bqbh(this, this.jdField_b_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_Zcx.setContentView(2131561866);
    this.jdField_a_of_type_Zcx.a(this.jdField_a_of_type_Bqbj);
    if (this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      wrv localwrv = (wrv)this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int);
      if (localwrv != null)
      {
        int i1 = localwrv.jdField_c_of_type_Int;
        this.jdField_a_of_type_Zcx.a(i1);
      }
    }
    this.jdField_a_of_type_Zcx.a(new bqax(this));
    this.jdField_a_of_type_Zcx.show();
  }
  
  private void y()
  {
    int i1;
    if (this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray != null) {
      i1 = 0;
    }
    for (;;)
    {
      wrt localwrt;
      Object localObject1;
      Object localObject2;
      if (i1 < this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        int i2 = this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i1);
        if (((wrt)this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.get(i2)).jdField_a_of_type_Int != this.jdField_i_of_type_Int) {
          break label331;
        }
        if (i1 >= this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.size() - 1) {
          break label297;
        }
        i1 = this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i1 + 1);
        localwrt = (wrt)this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
        this.jdField_a_of_type_Wrt = localwrt;
        localObject1 = localwrt.jdField_e_of_type_JavaLangString;
        localObject2 = localwrt.jdField_b_of_type_JavaLangString;
        i1 = Color.parseColor((String)localObject1);
        i2 = Color.parseColor((String)localObject2);
        this.jdField_g_of_type_Int = i1;
        this.jdField_c_of_type_Int = localwrt.jdField_a_of_type_Int;
        this.jdField_d_of_type_Int = i2;
        if (TextUtils.isEmpty(localwrt.jdField_c_of_type_JavaLangString)) {
          break label315;
        }
        this.jdField_e_of_type_Int = Color.parseColor(localwrt.jdField_c_of_type_JavaLangString);
        label196:
        if (TextUtils.isEmpty(localwrt.jdField_d_of_type_JavaLangString)) {
          break label323;
        }
      }
      label297:
      label315:
      label323:
      for (this.jdField_f_of_type_Int = Color.parseColor(localwrt.jdField_d_of_type_JavaLangString);; this.jdField_f_of_type_Int = 0)
      {
        a(this.jdField_a_of_type_Wrv, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 1, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_i_of_type_Int = localwrt.jdField_a_of_type_Int;
        localObject1 = (zbh)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
        localObject2 = ((zbh)localObject1).a();
        ((zbw)localObject2).jdField_a_of_type_Int = Color.parseColor(localwrt.jdField_e_of_type_JavaLangString);
        ((zbh)localObject1).a((zbw)localObject2);
        return;
        i1 = this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.keyAt(0);
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
      if (this.jdField_a_of_type_Wrv != null) {}
      for (str = this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString;; str = "")
      {
        yup.a("textEdit_patten", "clk_close", i1, 0, new String[] { "", str });
        return;
      }
    }
    f(false);
    int i1 = this.jdField_j_of_type_Int;
    if (this.jdField_a_of_type_Wrv != null) {}
    for (String str = this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString;; str = "")
    {
      yup.a("textEdit_patten", "clk_open", i1, 0, new String[] { "", str });
      return;
    }
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    yuk.b("StoryEffectTextMode", "QG onMethodRequest getTextConfig");
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
        a(this.jdField_a_of_type_Wrv, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 17, null);
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
      yup.a("textEdit", "done_upload", paramInt1, 0, new String[] { "", paramIntent });
      return;
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    b(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  public String b()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Wrv.f)) {
      return d() + this.jdField_a_of_type_Wrv.jdField_d_of_type_Int + "/" + this.jdField_a_of_type_Wrv.jdField_d_of_type_JavaLangString + "/" + this.jdField_a_of_type_Wrv.f;
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    l();
    Object localObject = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a();
    if (localObject != null) {
      ((bqal)localObject).b(this.jdField_a_of_type_JavaLangRunnable);
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
        CameraCaptureView localCameraCaptureView = this.jdField_a_of_type_Bodv.a();
        if ((localCameraCaptureView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          String str = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = null;
          localCameraCaptureView.queueEvent(new StoryEffectTextMode.5(this, (QQFilterRenderManager)localObject, str));
        }
      }
      if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getModuleEngine().unRegisterJsModule(this.jdField_a_of_type_Bkfy);
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
      if (TextUtils.isEmpty(((zbh)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a().jdField_a_of_type_JavaLangString)) {
        break label572;
      }
      paramBoolean = true;
      d(paramBoolean);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        localObject1 = (wrv)this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int);
        if (localObject1 != null)
        {
          localObject2 = ((wrv)localObject1).jdField_b_of_type_JavaLangString;
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          if (!((wrv)localObject1).jdField_a_of_type_Boolean) {
            break label593;
          }
          if (this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray != null)
          {
            localObject2 = (wrt)this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_i_of_type_Int);
            if (localObject2 != null)
            {
              this.jdField_a_of_type_Wrt = ((wrt)localObject2);
              str1 = ((wrt)localObject2).jdField_e_of_type_JavaLangString;
              String str2 = ((wrt)localObject2).jdField_b_of_type_JavaLangString;
              String str3 = ((wrt)localObject2).jdField_c_of_type_JavaLangString;
              String str4 = ((wrt)localObject2).jdField_d_of_type_JavaLangString;
              i1 = Color.parseColor(str1);
              i2 = Color.parseColor(str2);
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
              this.jdField_c_of_type_Int = ((wrt)localObject2).jdField_a_of_type_Int;
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
            if (this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_AndroidUtilSparseArray.size() > 1) {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            }
          }
          label300:
          this.jdField_a_of_type_Wrv = ((wrv)localObject1);
          if (!this.jdField_i_of_type_Boolean)
          {
            this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_d_of_type_Int);
            this.jdField_h_of_type_Boolean = true;
          }
        }
      }
      if (!this.jdField_a_of_type_Wrv.jdField_b_of_type_Boolean) {
        break label668;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      label348:
      if (this.jdField_j_of_type_Boolean) {
        u();
      }
      i1 = this.jdField_j_of_type_Int;
      localObject2 = this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString;
      if ((!this.jdField_a_of_type_Wrv.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Wrt != null)) {
        break label689;
      }
      localObject1 = "";
      label394:
      yup.a("textEdit", "exp_textEdit", i1, 0, new String[] { "", localObject2, localObject1 });
      D();
      e(false);
      localObject1 = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a();
      if (localObject1 == null) {
        break label701;
      }
      ((bqal)localObject1).a(this.jdField_a_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      p();
      if (QLog.isColorLevel()) {
        QLog.i("StoryEffectTextModeQ.qqstory.text_filter", 2, "initCaptureMode textFilter switch, mIsEnable: " + this.jdField_a_of_type_Bpmw.a.jdField_a_of_type_Boolean + ", mIsDPCEnable:" + this.jdField_a_of_type_Bpmw.a.jdField_b_of_type_Boolean + ", ver:" + nmj.a("1018") + ", QGLoader.soloaded:" + bkfs.b.get() + ", Build.MODEL:" + Build.MODEL);
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
      localObject2 = ((wrv)localObject1).jdField_c_of_type_JavaLangString;
      str1 = ((wrv)localObject1).jdField_e_of_type_JavaLangString;
      i1 = Color.parseColor((String)localObject2);
      i2 = Color.parseColor(str1);
      this.jdField_c_of_type_Int = ((wrv)localObject1).jdField_b_of_type_Int;
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
      localObject1 = this.jdField_a_of_type_Wrt.jdField_a_of_type_JavaLangString;
      break label394;
      label701:
      yuk.e("StoryEffectTextMode", "warning!!! warning!!! warning!!!, QGEnvironment is null!!!");
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Bpmw.c();
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
      yup.a("textEdit", "clk_upload", i1, 0, new String[] { "", str });
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
    a(this.jdField_a_of_type_Wrv, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 4, "onResume");
    if (this.jdField_a_of_type_Bkge != null) {
      this.jdField_a_of_type_Bkge.a();
    }
  }
  
  public void e()
  {
    super.e();
    g(false);
    if (this.jdField_a_of_type_Bkge != null) {
      this.jdField_a_of_type_Bkge.c();
    }
  }
  
  public void f()
  {
    super.f();
    l();
    if (this.jdField_a_of_type_Bkge != null)
    {
      VideoPlayer.unActiveMediaPlayer(this.jdField_a_of_type_Bkge);
      this.jdField_a_of_type_Bkge.destroy();
    }
  }
  
  public void g()
  {
    yuk.b("StoryEffectTextMode", "initView");
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return;
    }
    n();
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(2131560972, (ViewGroup)this.jdField_a_of_type_AndroidViewView, false);
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131366923);
      if (localViewGroup != null) {
        localViewGroup.addView(this.jdField_b_of_type_AndroidViewView, 2, localLayoutParams);
      }
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365917));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371798));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371797));
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378519);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378518));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131378517));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378662));
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131371796);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131372082));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368742));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378663));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131378286));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378521));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131364684);
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
      a(this.jdField_a_of_type_Wrv, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 4, "captureVideo");
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      g(true);
      this.jdField_c_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_j_of_type_Boolean) {
        yup.a("textEdit", "takeVideo", this.jdField_j_of_type_Int, 0, new String[0]);
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
    if ((!this.jdField_a_of_type_Wrv.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Wrt != null)) {}
    for (String str2 = this.jdField_a_of_type_Wrt.jdField_a_of_type_JavaLangString;; str2 = "")
    {
      yup.a("textEdit", "done_textEdit", this.jdField_j_of_type_Int, 0, new String[] { str1, this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString, str2 });
      wrs.jdField_a_of_type_Wru = new wru(this.jdField_j_of_type_Int, str1, this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString, str2);
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
    if ((this.jdField_a_of_type_Wrv != null) && (this.jdField_a_of_type_Wrt != null))
    {
      i1 = this.jdField_j_of_type_Int;
      str2 = this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_Wrv.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Wrt == null)) {
        break label170;
      }
      str1 = this.jdField_a_of_type_Wrt.jdField_a_of_type_JavaLangString;
      yup.a("textEdit", "done_textEdit", i1, 0, new String[] { "1", str2, str1 });
      i1 = this.jdField_j_of_type_Int;
      str2 = this.jdField_a_of_type_Wrv.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Wrv.jdField_b_of_type_Boolean) {
        break label176;
      }
    }
    label170:
    label176:
    for (String str1 = "";; str1 = this.jdField_a_of_type_Wrt.jdField_a_of_type_JavaLangString)
    {
      wrs.jdField_a_of_type_Wru = new wru(i1, "1", str2, str1);
      if (this.jdField_j_of_type_Boolean) {
        yup.a("textEdit", "takePhoto", this.jdField_j_of_type_Int, 0, new String[0]);
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
    if (this.jdField_a_of_type_Bhud != null)
    {
      this.jdField_a_of_type_Bhud.e();
      this.jdField_a_of_type_Bhud = null;
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
 * Qualified Name:     bqav
 * JD-Core Version:    0.7.0.1
 */