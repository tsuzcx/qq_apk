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

public class bmhu
  extends bmht
  implements bfxn, IEventReceiver, xgg
{
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new bmic(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdpb jdField_a_of_type_Bdpb;
  private bdpc jdField_a_of_type_Bdpc = new bmid(this);
  private bfxm jdField_a_of_type_Bfxm;
  private bfxs jdField_a_of_type_Bfxs;
  private blrx jdField_a_of_type_Blrx = (blrx)blqr.a(5);
  private bmhs jdField_a_of_type_Bmhs;
  private bmii jdField_a_of_type_Bmii;
  private DoodleEditView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
  private DoodleView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private QQTextEjectaFilter.EjectaTextureCallBack jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter$EjectaTextureCallBack = new bmhv(this);
  private QQTextEjectaFilter jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQTextEjectaFilter;
  private StoryQGSurfaceView jdField_a_of_type_ComTencentQgStoryQGSurfaceView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryEffectTextMode.2(this);
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private uum jdField_a_of_type_Uum = new uum();
  private uuo jdField_a_of_type_Uuo;
  private xfr jdField_a_of_type_Xfr;
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
  
  public bmhu(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Blrx.a = new uul(BaseApplicationImpl.getContext(), BaseApplicationImpl.sApplication.getRuntime().getAccount());
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_Uuo != null) && (!this.jdField_a_of_type_Uuo.jdField_c_of_type_Boolean))
    {
      if ((!bdin.d(this.jdField_b_of_type_AndroidViewView.getContext())) || (this.jdField_a_of_type_Uuo.jdField_d_of_type_Boolean)) {
        G();
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_b_of_type_AndroidViewView.getContext(), alud.a(2131714827), 0).a();
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      int i1 = xsm.a(this.jdField_b_of_type_AndroidViewView.getContext(), 4.0F);
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
    wxe.b("StoryEffectTextMode", "showSoLoading");
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
    }
  }
  
  private void E()
  {
    wxe.b("StoryEffectTextMode", "dismissSoLoading");
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    }
  }
  
  private void F()
  {
    Object localObject = d() + this.jdField_a_of_type_Blrx.a.jdField_b_of_type_Int + "/qg.js";
    if (new File((String)localObject).exists())
    {
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.addJavaScriptFileFromSDCard((String)localObject);
      localObject = d() + this.jdField_a_of_type_Blrx.a.jdField_b_of_type_Int + "/" + this.jdField_a_of_type_Blrx.a.jdField_c_of_type_JavaLangString + "/" + this.jdField_a_of_type_Blrx.a.jdField_c_of_type_JavaLangString + ".js";
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
        localObject = new JSONObject(this.jdField_a_of_type_Blrx.a.jdField_b_of_type_JavaLangString);
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
      this.jdField_b_of_type_AndroidAnimationAnimator.addListener(new bmhz(this));
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
      this.jdField_a_of_type_AndroidAnimationAnimator.addListener(new bmia(this));
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
    wxe.b("StoryEffectTextMode", "initQGEnvironment success!");
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
          this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView = ((bmhk)localObject).a(this.jdField_a_of_type_Bkoa);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView);
        }
      }
      if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView == null) {
        break label269;
      }
      this.jdField_a_of_type_Bfxm = new bfxm();
      this.jdField_a_of_type_Bfxm.a(this);
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getModuleEngine().registerJsModule(this.jdField_a_of_type_Bfxm);
      this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.setExtResPath(d() + this.jdField_a_of_type_Blrx.a.jdField_b_of_type_Int + "/");
      if (this.jdField_a_of_type_Bfxs == null)
      {
        this.jdField_a_of_type_Bfxs = new bfxs();
        VideoPlayer.activeMediaPlayer(this.jdField_a_of_type_Bfxs);
      }
      this.jdField_a_of_type_Bfxs.a(d() + this.jdField_a_of_type_Blrx.a.jdField_b_of_type_Int + "/");
      localObject = new bmib(this);
      if (i1 == 0) {
        break;
      }
      this.jdField_a_of_type_Bkms.a().queueEvent(new StoryEffectTextMode.18(this, (QGRenderer.QGEventListener)localObject));
      return;
    }
    this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.setQGEventListener((QGRenderer.QGEventListener)localObject);
    return;
    label269:
    wxe.e("StoryEffectTextMode", "QGEnvironment and mQGGLView is null!! ");
  }
  
  private void L()
  {
    QQFilterRenderManager localQQFilterRenderManager = EffectsCameraCaptureView.b();
    if (localQQFilterRenderManager == null)
    {
      CameraCaptureView localCameraCaptureView = this.jdField_a_of_type_Bkoa.a();
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
    if (a(this.jdField_a_of_type_Blrx.a.jdField_b_of_type_Int)) {
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
          if ((paramBoolean) && (this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray != null))
          {
            i2 = Color.parseColor(((uum)this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_i_of_type_Int)).jdField_b_of_type_JavaLangString);
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
      float f1 = this.jdField_a_of_type_Blrx.a.jdField_c_of_type_Int / 100.0F;
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
  
  private String a(uuo paramuuo)
  {
    if (paramuuo == null) {
      paramuuo = "";
    }
    String str2;
    String str1;
    do
    {
      return paramuuo;
      str2 = d() + paramuuo.jdField_d_of_type_Int + "/" + paramuuo.jdField_d_of_type_JavaLangString + "/" + paramuuo.jdField_d_of_type_JavaLangString;
      str1 = str2 + ".js";
      paramuuo = str1;
    } while (new File(str1).exists());
    return str2 + "_android.js";
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Bdpb != null) {
      l();
    }
    this.jdField_a_of_type_Bdpb = new bdpb(paramString, new Handler());
    this.jdField_a_of_type_Bdpb.a(this.jdField_b_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_Bdpb.b();
    this.jdField_a_of_type_Bdpb.a(this.jdField_a_of_type_Bdpc);
    this.jdField_a_of_type_Bdpb.c();
  }
  
  private void a(uuo paramuuo)
  {
    Object localObject1 = paramuuo.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_d_of_type_AndroidViewView.setContentDescription(alud.a(2131714812) + (String)localObject1 + "’ ");
    this.jdField_h_of_type_Int = paramuuo.jdField_a_of_type_Int;
    int i1 = paramuuo.jdField_c_of_type_Int;
    if ((this.jdField_a_of_type_Bfxs != null) && (this.jdField_a_of_type_Bfxs.isPlaying())) {
      this.jdField_a_of_type_Bfxs.stop();
    }
    if (this.jdField_a_of_type_Xfr != null) {
      this.jdField_a_of_type_Xfr.a(i1);
    }
    Object localObject2;
    if (paramuuo.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(8);
      if (!paramuuo.jdField_a_of_type_Boolean) {
        break label382;
      }
      if (this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray != null)
      {
        localObject1 = (uum)this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_i_of_type_Int);
        this.jdField_a_of_type_Uum = ((uum)localObject1);
        if (localObject1 != null)
        {
          localObject2 = ((uum)localObject1).jdField_e_of_type_JavaLangString;
          Object localObject3 = ((uum)localObject1).jdField_b_of_type_JavaLangString;
          i1 = Color.parseColor((String)localObject2);
          int i2 = Color.parseColor((String)localObject3);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
          localObject2 = (xeb)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
          localObject3 = ((xeb)localObject2).a();
          ((xeq)localObject3).jdField_a_of_type_Int = i1;
          ((xeb)localObject2).a((xeq)localObject3);
          this.jdField_c_of_type_Int = ((uum)localObject1).jdField_a_of_type_Int;
          this.jdField_d_of_type_Int = i2;
          this.jdField_g_of_type_Int = i1;
        }
        if (this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.size() > 1) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Uuo = paramuuo;
      a(this.jdField_a_of_type_Uuo, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 11, null);
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
      localObject1 = paramuuo.jdField_c_of_type_JavaLangString;
      localObject2 = paramuuo.jdField_e_of_type_JavaLangString;
      i1 = Color.parseColor((String)localObject1);
      this.jdField_d_of_type_Int = Color.parseColor((String)localObject2);
      this.jdField_c_of_type_Int = paramuuo.jdField_b_of_type_Int;
      this.jdField_e_of_type_Int = 0;
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Int = i1;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(uuo paramuuo, int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    paramuuo.jdField_d_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Uuo != null) && (this.jdField_a_of_type_Uuo.jdField_d_of_type_Int == paramuuo.jdField_d_of_type_Int) && (this.jdField_g_of_type_Boolean)) {
      G();
    }
    QLog.e("StoryEffectTextMode", 2, "onDownloadOfflinePkgFailed，" + paramuuo.jdField_d_of_type_Int);
  }
  
  private void a(uuo paramuuo, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int i1 = 0;
    wxe.b("StoryEffectTextMode", "onTextFilterInfoChange");
    if (paramuuo == null) {}
    Object localObject;
    String str1;
    label280:
    boolean bool;
    label290:
    do
    {
      return;
      this.jdField_a_of_type_Uuo = paramuuo;
      this.jdField_c_of_type_JavaLangString = paramString1;
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
      if ((!this.jdField_e_of_type_Boolean) || (!bfxg.b.get()))
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
      this.jdField_a_of_type_Uuo.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_Uuo.jdField_d_of_type_Int);
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Bmhs.getCount())
      {
        paramuuo = this.jdField_a_of_type_Bmhs.a(paramInt2);
        if (paramuuo.jdField_d_of_type_Int == this.jdField_a_of_type_Uuo.jdField_d_of_type_Int) {
          paramuuo.jdField_c_of_type_Boolean = this.jdField_a_of_type_Uuo.jdField_c_of_type_Boolean;
        }
        paramInt2 += 1;
      }
      this.jdField_a_of_type_Bmhs.notifyDataSetChanged();
      localObject = "";
      if (!this.jdField_a_of_type_Uuo.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_g_of_type_Boolean = false;
      E();
      e(true);
      if (!this.jdField_f_of_type_Boolean) {
        F();
      }
      paramuuo = this.jdField_a_of_type_Uuo.jdField_d_of_type_JavaLangString;
      str1 = a(this.jdField_a_of_type_Uuo);
      localObject = paramuuo;
      if (QLog.isColorLevel())
      {
        QLog.d("StoryEffectTextMode", 2, "load " + str1);
        localObject = paramuuo;
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
        paramuuo = this.jdField_c_of_type_OrgJsonJSONObject;
        if (this.jdField_j_of_type_Boolean) {
          break label1153;
        }
        paramInt2 = i1;
        if (this.jdField_i_of_type_Boolean) {
          break label1153;
        }
        paramuuo.put("cameraStatus", paramInt2);
        a("qg_onCameraSwitch", this.jdField_c_of_type_OrgJsonJSONObject.toString());
      }
      catch (JSONException paramuuo)
      {
        String str2;
        String str3;
        label851:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "EVENT_NAME_QG_ON_CAMERA_SWITCH, JSONException:" + paramuuo.toString());
        continue;
      }
      if ((paramInt3 & 0x1) != 0)
      {
        paramuuo = a(paramInt1, 0.0F);
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
        this.jdField_b_of_type_OrgJsonJSONObject.put("backgroundColor", paramuuo);
        this.jdField_b_of_type_OrgJsonJSONObject.put("backgroundColor2", str1);
        this.jdField_b_of_type_OrgJsonJSONObject.put("backgroundColor3", str2);
        this.jdField_b_of_type_OrgJsonJSONObject.put("textColor", str3);
        a("qg_BackgroundChange", this.jdField_b_of_type_OrgJsonJSONObject.toString());
      }
      catch (JSONException paramuuo)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "onInputTextComplete, JSONException:" + paramuuo.toString());
        continue;
        paramString1 = paramuuo;
        if (!bamp.a(paramuuo)) {
          continue;
        }
        paramString1 = bcll.a(paramuuo, "□");
        continue;
      }
      if ((paramInt3 & 0x8) != 0)
      {
        paramuuo = paramString1;
        if (paramString1 == null) {
          paramuuo = "";
        }
        if ((TextUtils.isEmpty(paramuuo)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
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
        paramuuo = new JSONObject();
        paramuuo.put("tmplName", localObject);
        if (!TextUtils.isEmpty(paramString2)) {
          paramuuo.put("scene", paramString2);
        }
        a("qg_Restart", paramuuo.toString());
      }
      catch (JSONException paramuuo)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StoryEffectTextMode", 2, "QG_RESTART, JSONException:" + paramuuo.toString());
        continue;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Uuo.f))
      {
        paramuuo = d() + this.jdField_a_of_type_Uuo.jdField_d_of_type_Int + "/" + this.jdField_a_of_type_Uuo.jdField_d_of_type_JavaLangString + "/" + this.jdField_a_of_type_Uuo.f;
        if (new File(paramuuo).exists())
        {
          b(paramuuo);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StoryEffectTextMode", 2, this.jdField_a_of_type_Uuo.jdField_d_of_type_JavaLangString + " is not download！");
          }
          this.jdField_g_of_type_Boolean = true;
          if (!this.jdField_i_of_type_Boolean) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_d_of_type_Int);
          }
          this.jdField_h_of_type_Boolean = true;
          e(false);
          if (bdin.d(this.jdField_b_of_type_AndroidViewView.getContext()))
          {
            a(this.jdField_a_of_type_Uuo, false);
            break label280;
          }
          this.jdField_a_of_type_Uuo.jdField_d_of_type_Boolean = true;
          G();
          break label280;
          bool = false;
          break label290;
        }
        if (this.jdField_a_of_type_Bdpb == null) {
          break;
        }
        l();
        return;
      }
      if (this.jdField_a_of_type_Bdpb == null) {
        break;
      }
      l();
      return;
      label1018:
      if ((paramInt3 & 0x2) != 0) {
        l();
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Uuo.f))
      {
        paramuuo = d() + this.jdField_a_of_type_Uuo.jdField_d_of_type_Int + "/" + this.jdField_a_of_type_Uuo.jdField_d_of_type_JavaLangString + "/" + this.jdField_a_of_type_Uuo.f;
        if (new File(paramuuo).exists())
        {
          if (this.jdField_a_of_type_Bdpb != null) {
            break;
          }
          a(paramuuo);
          return;
        }
        if (this.jdField_a_of_type_Bdpb == null) {
          break;
        }
        l();
        return;
      }
      if (this.jdField_a_of_type_Bdpb == null) {
        break;
      }
      l();
      return;
      label1153:
      paramInt2 = 1;
    }
  }
  
  private void a(uuo paramuuo, boolean paramBoolean)
  {
    if ((paramuuo == null) || (paramuuo.jdField_d_of_type_Int == 0)) {}
    for (;;)
    {
      return;
      String str = String.valueOf(paramuuo.jdField_d_of_type_Int);
      paramuuo.jdField_d_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(str))
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (nbv.a(str) == null) {}
        for (boolean bool = true; (bool) || (paramBoolean); bool = false)
        {
          this.jdField_a_of_type_JavaUtilSet.add(str);
          nbv.b(str, localAppRuntime, new bmhy(this, bool, paramuuo, str), true, 0, true);
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
      str = nbv.a(String.valueOf(paramInt));
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
  
  private void b(uuo paramuuo)
  {
    wxe.b("StoryEffectTextMode", "onDownloadedResource");
    paramuuo.jdField_c_of_type_Boolean = true;
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {}
    while ((!a(this.jdField_a_of_type_Blrx.a.jdField_b_of_type_Int)) || (this.jdField_a_of_type_Uuo == null) || (this.jdField_a_of_type_Uuo.jdField_d_of_type_Int != paramuuo.jdField_d_of_type_Int) || (!this.jdField_g_of_type_Boolean)) {
      return;
    }
    this.jdField_g_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("StoryEffectTextMode", 2, "download template resource success！ draw screen！");
    }
    a(this.jdField_a_of_type_Uuo, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 11, null);
  }
  
  private void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    xdw localxdw = (xdw)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("GuideLineLayer");
    if (localxdw == null) {
      return;
    }
    localxdw.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
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
    return ncb.b();
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
    bkms localbkms = this.jdField_a_of_type_Bkms;
    if ((this.jdField_j_of_type_Boolean) && (paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      localbkms.j(bool);
      if ((!this.jdField_j_of_type_Boolean) || (!paramBoolean)) {
        break;
      }
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131714826));
      this.jdField_e_of_type_AndroidViewView.setContentDescription(alud.a(2131714805));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      B();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131714817));
    this.jdField_e_of_type_AndroidViewView.setContentDescription(alud.a(2131714815));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    C();
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return ((uuo)this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int)).jdField_b_of_type_Boolean;
    }
    return false;
  }
  
  private void e(boolean paramBoolean)
  {
    float f2 = 1.0F;
    this.l = paramBoolean;
    this.jdField_a_of_type_Bkms.k(paramBoolean);
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
      localObject = new TranslateAnimation(xin.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext()) / 2, 0.0F, 0.0F, 0.0F);
      ((TranslateAnimation)localObject).setDuration(300L);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.startAnimation((Animation)localObject);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131714819));
    if (this.jdField_b_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.153846F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(330L);
    this.jdField_c_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationScaleAnimation);
    int i1 = this.jdField_j_of_type_Int;
    if (this.jdField_a_of_type_Uuo != null) {}
    for (Object localObject = this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString;; localObject = "")
    {
      wxj.a("textEdit_patten", "exp_panel", i1, 0, new String[] { "", localObject });
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
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new bmhx(this));
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131714820));
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
    this.jdField_a_of_type_Blrx = ((blrx)blqr.a(5));
    uuo localuuo;
    String str;
    if (this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      localuuo = (uuo)this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int);
      if (localuuo != null) {
        str = localuuo.jdField_e_of_type_JavaLangString;
      }
    }
    try
    {
      this.jdField_d_of_type_Int = Color.parseColor(str);
      this.jdField_c_of_type_Int = localuuo.jdField_b_of_type_Int;
      if (!TextUtils.isEmpty(localuuo.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = localuuo.jdField_b_of_type_JavaLangString;
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
    Object localObject1 = new xeb(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    Object localObject2 = new xdw(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    localObject2 = new xeo().a(new xgw(new xeh[] { localObject1, localObject2 })).a(this.jdField_b_of_type_AndroidViewView.getWidth()).b(this.jdField_b_of_type_AndroidViewView.getHeight()).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((xem)localObject2);
    ((xeb)localObject1).a(new bmij(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleView(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnTextEditListener();
    this.n = true;
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getIntent().getStringExtra("text_filter_default_screen_touch_tips");
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getIntent().getStringExtra("share_url_target_url") == null) {}
    for (int i1 = 0;; i1 = 1)
    {
      this.jdField_j_of_type_Int = i1;
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131698197);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(c());
      }
      if (this.jdField_a_of_type_Bmhs != null) {
        break label336;
      }
      localObject1 = this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray;
      localObject2 = new ArrayList(((SparseArray)localObject1).size());
      i1 = i2;
      while (i1 < ((SparseArray)localObject1).size())
      {
        ((List)localObject2).add(((SparseArray)localObject1).valueAt(i1));
        i1 += 1;
      }
    }
    this.jdField_a_of_type_Bmhs = new bmhs((List)localObject2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(xsm.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 10.0F));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bmhs);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    label336:
    localObject1 = this.jdField_a_of_type_Bmhs.a(this.jdField_a_of_type_Bmhs.a());
    this.jdField_d_of_type_AndroidViewView.setContentDescription(alud.a(2131714813) + ((uuo)localObject1).jdField_b_of_type_JavaLangString + "’ ");
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.153846F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(0L);
    this.jdField_c_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
  }
  
  private void p()
  {
    nbv.b(this.jdField_a_of_type_Blrx.a.jdField_b_of_type_Int + "", BaseApplicationImpl.getApplication().getRuntime(), true, new bmie(this));
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int i2 = this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1);
      a((uuo)this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray.get(i2), true);
      i1 += 1;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_Bkms.S();
    if (this.n) {
      if (TextUtils.isEmpty(((xeb)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a().jdField_a_of_type_JavaLangString)) {
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
    xeq localxeq = ((xeb)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a();
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(alud.a(2131714823));
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setImageResource(2130845727);
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      if (TextUtils.isEmpty(localxeq.jdField_a_of_type_JavaLangString)) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      d(bool);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(alud.a(2131714824));
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setImageResource(2130845726);
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
      a(this.jdField_a_of_type_Uuo, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 17, null);
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
      wxj.a("textEdit", str1, i1, 0, new String[] { "", str2 });
      return;
      bool = false;
      break;
      str1 = "close_cam";
      break label129;
    }
  }
  
  private void t()
  {
    int i1 = this.jdField_a_of_type_Bkms.d();
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
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(alud.a(2131714809));
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
      wxj.a("textEdit", str1, i1, 0, new String[] { "", str2 });
      return;
      bool = false;
      break;
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(alud.a(2131714822));
      break label40;
      str1 = "use_backCam";
      break label49;
    }
  }
  
  private void u()
  {
    if (((this.jdField_a_of_type_Bkms.e() == 1) && (this.m)) || ((this.jdField_a_of_type_Bkms.e() == 2) && (!this.m)))
    {
      this.jdField_a_of_type_Bkms.d();
      if (this.m) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(alud.a(2131714814));
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setContentDescription(alud.a(2131714811));
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
      this.jdField_a_of_type_Bkms.Q();
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
      localObject = new beub(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), 2131561236);
      this.o = false;
      ((beub)localObject).a(0, alud.a(2131714825), 0, new bmif(this));
      ThreadManager.getUIHandler().postDelayed(new StoryEffectTextMode.8(this, (beub)localObject), 5000L);
      return;
    }
    this.jdField_a_of_type_Bkms.q();
    wxj.a("textEdit", "takePhoto", this.jdField_j_of_type_Int, 0, new String[0]);
    int i1 = this.jdField_j_of_type_Int;
    String str2;
    if (this.jdField_i_of_type_Boolean)
    {
      localObject = "3";
      str2 = this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Uum == null) {
        break label254;
      }
      str1 = this.jdField_a_of_type_Uum.jdField_a_of_type_JavaLangString;
      label163:
      wxj.a("textEdit", "done_textEdit", i1, 0, new String[] { localObject, str2, str1 });
      i1 = this.jdField_j_of_type_Int;
      if (!this.jdField_i_of_type_Boolean) {
        break label260;
      }
      localObject = "3";
      label207:
      str2 = this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Uum == null) {
        break label267;
      }
    }
    label260:
    label267:
    for (String str1 = this.jdField_a_of_type_Uum.jdField_a_of_type_JavaLangString;; str1 = "")
    {
      uul.jdField_a_of_type_Uun = new uun(i1, (String)localObject, str2, str1);
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
    if (this.jdField_a_of_type_Bmii == null) {
      this.jdField_a_of_type_Bmii = new bmii(this);
    }
    this.jdField_a_of_type_Xfr = new bmig(this, this.jdField_b_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_Xfr.setContentView(2131561590);
    this.jdField_a_of_type_Xfr.a(this.jdField_a_of_type_Bmii);
    if (this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      uuo localuuo = (uuo)this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int);
      if (localuuo != null)
      {
        int i1 = localuuo.jdField_c_of_type_Int;
        this.jdField_a_of_type_Xfr.a(i1);
      }
    }
    this.jdField_a_of_type_Xfr.a(new bmhw(this));
    this.jdField_a_of_type_Xfr.show();
  }
  
  private void y()
  {
    int i1;
    if (this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray != null) {
      i1 = 0;
    }
    for (;;)
    {
      uum localuum;
      Object localObject1;
      Object localObject2;
      if (i1 < this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        int i2 = this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i1);
        if (((uum)this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.get(i2)).jdField_a_of_type_Int != this.jdField_i_of_type_Int) {
          break label331;
        }
        if (i1 >= this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.size() - 1) {
          break label297;
        }
        i1 = this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i1 + 1);
        localuum = (uum)this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
        this.jdField_a_of_type_Uum = localuum;
        localObject1 = localuum.jdField_e_of_type_JavaLangString;
        localObject2 = localuum.jdField_b_of_type_JavaLangString;
        i1 = Color.parseColor((String)localObject1);
        i2 = Color.parseColor((String)localObject2);
        this.jdField_g_of_type_Int = i1;
        this.jdField_c_of_type_Int = localuum.jdField_a_of_type_Int;
        this.jdField_d_of_type_Int = i2;
        if (TextUtils.isEmpty(localuum.jdField_c_of_type_JavaLangString)) {
          break label315;
        }
        this.jdField_e_of_type_Int = Color.parseColor(localuum.jdField_c_of_type_JavaLangString);
        label196:
        if (TextUtils.isEmpty(localuum.jdField_d_of_type_JavaLangString)) {
          break label323;
        }
      }
      label297:
      label315:
      label323:
      for (this.jdField_f_of_type_Int = Color.parseColor(localuum.jdField_d_of_type_JavaLangString);; this.jdField_f_of_type_Int = 0)
      {
        a(this.jdField_a_of_type_Uuo, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 1, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_i_of_type_Int = localuum.jdField_a_of_type_Int;
        localObject1 = (xeb)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
        localObject2 = ((xeb)localObject1).a();
        ((xeq)localObject2).jdField_a_of_type_Int = Color.parseColor(localuum.jdField_e_of_type_JavaLangString);
        ((xeb)localObject1).a((xeq)localObject2);
        return;
        i1 = this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.keyAt(0);
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
      if (this.jdField_a_of_type_Uuo != null) {}
      for (str = this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString;; str = "")
      {
        wxj.a("textEdit_patten", "clk_close", i1, 0, new String[] { "", str });
        return;
      }
    }
    f(false);
    int i1 = this.jdField_j_of_type_Int;
    if (this.jdField_a_of_type_Uuo != null) {}
    for (String str = this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString;; str = "")
    {
      wxj.a("textEdit_patten", "clk_open", i1, 0, new String[] { "", str });
      return;
    }
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    wxe.b("StoryEffectTextMode", "QG onMethodRequest getTextConfig");
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
        a(this.jdField_a_of_type_Uuo, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 17, null);
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
      wxj.a("textEdit", "done_upload", paramInt1, 0, new String[] { "", paramIntent });
      return;
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    b(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  public String b()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Uuo.f)) {
      return d() + this.jdField_a_of_type_Uuo.jdField_d_of_type_Int + "/" + this.jdField_a_of_type_Uuo.jdField_d_of_type_JavaLangString + "/" + this.jdField_a_of_type_Uuo.f;
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    l();
    Object localObject = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a();
    if (localObject != null) {
      ((bmhk)localObject).b(this.jdField_a_of_type_JavaLangRunnable);
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
        CameraCaptureView localCameraCaptureView = this.jdField_a_of_type_Bkoa.a();
        if ((localCameraCaptureView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          String str = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = null;
          localCameraCaptureView.queueEvent(new StoryEffectTextMode.5(this, (QQFilterRenderManager)localObject, str));
        }
      }
      if (this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView != null)
      {
        this.jdField_a_of_type_ComTencentQgStoryQGSurfaceView.getModuleEngine().unRegisterJsModule(this.jdField_a_of_type_Bfxm);
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
      if (TextUtils.isEmpty(((xeb)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer")).a().jdField_a_of_type_JavaLangString)) {
        break label572;
      }
      paramBoolean = true;
      d(paramBoolean);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        localObject1 = (uuo)this.jdField_a_of_type_Blrx.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_h_of_type_Int);
        if (localObject1 != null)
        {
          localObject2 = ((uuo)localObject1).jdField_b_of_type_JavaLangString;
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          if (!((uuo)localObject1).jdField_a_of_type_Boolean) {
            break label593;
          }
          if (this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray != null)
          {
            localObject2 = (uum)this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_i_of_type_Int);
            if (localObject2 != null)
            {
              this.jdField_a_of_type_Uum = ((uum)localObject2);
              str1 = ((uum)localObject2).jdField_e_of_type_JavaLangString;
              String str2 = ((uum)localObject2).jdField_b_of_type_JavaLangString;
              String str3 = ((uum)localObject2).jdField_c_of_type_JavaLangString;
              String str4 = ((uum)localObject2).jdField_d_of_type_JavaLangString;
              i1 = Color.parseColor(str1);
              i2 = Color.parseColor(str2);
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i1);
              this.jdField_c_of_type_Int = ((uum)localObject2).jdField_a_of_type_Int;
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
            if (this.jdField_a_of_type_Blrx.a.jdField_b_of_type_AndroidUtilSparseArray.size() > 1) {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            }
          }
          label300:
          this.jdField_a_of_type_Uuo = ((uuo)localObject1);
          if (!this.jdField_i_of_type_Boolean)
          {
            this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_d_of_type_Int);
            this.jdField_h_of_type_Boolean = true;
          }
        }
      }
      if (!this.jdField_a_of_type_Uuo.jdField_b_of_type_Boolean) {
        break label668;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      label348:
      if (this.jdField_j_of_type_Boolean) {
        u();
      }
      i1 = this.jdField_j_of_type_Int;
      localObject2 = this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString;
      if ((!this.jdField_a_of_type_Uuo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Uum != null)) {
        break label689;
      }
      localObject1 = "";
      label394:
      wxj.a("textEdit", "exp_textEdit", i1, 0, new String[] { "", localObject2, localObject1 });
      D();
      e(false);
      localObject1 = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a();
      if (localObject1 == null) {
        break label701;
      }
      ((bmhk)localObject1).a(this.jdField_a_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      p();
      if (QLog.isColorLevel()) {
        QLog.i("StoryEffectTextModeQ.qqstory.text_filter", 2, "initCaptureMode textFilter switch, mIsEnable: " + this.jdField_a_of_type_Blrx.a.jdField_a_of_type_Boolean + ", mIsDPCEnable:" + this.jdField_a_of_type_Blrx.a.jdField_b_of_type_Boolean + ", ver:" + nbv.a("1018") + ", QGLoader.soloaded:" + bfxg.b.get() + ", Build.MODEL:" + Build.MODEL);
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
      localObject2 = ((uuo)localObject1).jdField_c_of_type_JavaLangString;
      str1 = ((uuo)localObject1).jdField_e_of_type_JavaLangString;
      i1 = Color.parseColor((String)localObject2);
      i2 = Color.parseColor(str1);
      this.jdField_c_of_type_Int = ((uuo)localObject1).jdField_b_of_type_Int;
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
      localObject1 = this.jdField_a_of_type_Uum.jdField_a_of_type_JavaLangString;
      break label394;
      label701:
      wxe.e("StoryEffectTextMode", "warning!!! warning!!! warning!!!, QGEnvironment is null!!!");
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Blrx.c();
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
      wxj.a("textEdit", "clk_upload", i1, 0, new String[] { "", str });
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
    a(this.jdField_a_of_type_Uuo, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 4, "onResume");
    if (this.jdField_a_of_type_Bfxs != null) {
      this.jdField_a_of_type_Bfxs.a();
    }
  }
  
  public void e()
  {
    super.e();
    g(false);
    if (this.jdField_a_of_type_Bfxs != null) {
      this.jdField_a_of_type_Bfxs.c();
    }
  }
  
  public void f()
  {
    super.f();
    l();
    if (this.jdField_a_of_type_Bfxs != null)
    {
      VideoPlayer.unActiveMediaPlayer(this.jdField_a_of_type_Bfxs);
      this.jdField_a_of_type_Bfxs.destroy();
    }
  }
  
  public void g()
  {
    wxe.b("StoryEffectTextMode", "initView");
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return;
    }
    n();
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(2131560736, (ViewGroup)this.jdField_a_of_type_AndroidViewView, false);
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131366606);
      if (localViewGroup != null) {
        localViewGroup.addView(this.jdField_b_of_type_AndroidViewView, 2, localLayoutParams);
      }
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365638));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371132));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371131));
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131377524);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377523));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131377522));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377663));
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131371130);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131371397));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368360));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377664));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131377318));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377526));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131364433);
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
      a(this.jdField_a_of_type_Uuo, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, 4, "captureVideo");
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      g(true);
      this.jdField_c_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_j_of_type_Boolean) {
        wxj.a("textEdit", "takeVideo", this.jdField_j_of_type_Int, 0, new String[0]);
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
    if ((!this.jdField_a_of_type_Uuo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Uum != null)) {}
    for (String str2 = this.jdField_a_of_type_Uum.jdField_a_of_type_JavaLangString;; str2 = "")
    {
      wxj.a("textEdit", "done_textEdit", this.jdField_j_of_type_Int, 0, new String[] { str1, this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString, str2 });
      uul.jdField_a_of_type_Uun = new uun(this.jdField_j_of_type_Int, str1, this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString, str2);
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
    if ((this.jdField_a_of_type_Uuo != null) && (this.jdField_a_of_type_Uum != null))
    {
      i1 = this.jdField_j_of_type_Int;
      str2 = this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_Uuo.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Uum == null)) {
        break label170;
      }
      str1 = this.jdField_a_of_type_Uum.jdField_a_of_type_JavaLangString;
      wxj.a("textEdit", "done_textEdit", i1, 0, new String[] { "1", str2, str1 });
      i1 = this.jdField_j_of_type_Int;
      str2 = this.jdField_a_of_type_Uuo.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Uuo.jdField_b_of_type_Boolean) {
        break label176;
      }
    }
    label170:
    label176:
    for (String str1 = "";; str1 = this.jdField_a_of_type_Uum.jdField_a_of_type_JavaLangString)
    {
      uul.jdField_a_of_type_Uun = new uun(i1, "1", str2, str1);
      if (this.jdField_j_of_type_Boolean) {
        wxj.a("textEdit", "takePhoto", this.jdField_j_of_type_Int, 0, new String[0]);
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
    if (this.jdField_a_of_type_Bdpb != null)
    {
      this.jdField_a_of_type_Bdpb.f();
      this.jdField_a_of_type_Bdpb = null;
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
    default: 
      return;
    case 2131377526: 
      z();
      return;
    case 2131364433: 
      y();
      return;
    case 2131377669: 
      if (!this.l)
      {
        A();
        return;
      }
      w();
      return;
    case 2131371397: 
      if (!this.l)
      {
        A();
        return;
      }
      s();
      return;
    case 2131377318: 
      t();
      return;
    }
    if (!this.l)
    {
      A();
      return;
    }
    v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhu
 * JD-Core Version:    0.7.0.1
 */