import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aekit.api.standard.ai.AEDetector;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.11;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.13;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.14;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.15;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.17;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.18;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.19;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.20;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.21;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.5;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.6;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.8;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class bill
  extends biwr
  implements avuh, bkrl
{
  private final int jdField_a_of_type_Int = 400;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bijd jdField_a_of_type_Bijd = (bijd)this.jdField_a_of_type_Biws.a(65537, new Object[0]);
  private biks jdField_a_of_type_Biks;
  private bile jdField_a_of_type_Bile = new bilh();
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private QIMFilterCategoryItem jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final String jdField_a_of_type_JavaLangString = "ai_guide_shown";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicReference<avuh> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1500;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQAnimationDrawable jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 2000;
  private View jdField_c_of_type_AndroidViewView;
  private QQAnimationDrawable jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public bill(Activity paramActivity, View paramView, biws parambiws)
  {
    super(paramActivity, paramView, parambiws);
  }
  
  private AnimationSet a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight(), 0.0F);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new DecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localTranslateAnimation);
    }
    return this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
  }
  
  private void a(int paramInt, String paramString)
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(1000L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(1000L);
    String str1 = "";
    String str2 = biiq.f;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131716425) + paramString + ajya.a(2131716424));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setAnimation(a());
      if (TextUtils.isEmpty(str2)) {
        break label423;
      }
      str2 = str2 + File.separator + str1;
      paramString = new File(str2);
      if (!paramString.exists()) {
        break label423;
      }
      File[] arrayOfFile = paramString.listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length <= 0)) {
        break label423;
      }
      paramString = new String[arrayOfFile.length];
      paramInt = 0;
      while (paramInt < arrayOfFile.length)
      {
        String str3 = str2 + File.separator + str1 + "_" + (paramInt + 1) + ".png";
        if (new File(str3).exists()) {
          paramString[paramInt] = str3;
        }
        paramInt += 1;
      }
      str1 = "object";
      continue;
      str1 = "food";
      continue;
      str1 = "scene";
      continue;
      str1 = "face";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2500L);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(true);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
      this.jdField_b_of_type_AndroidViewView.postDelayed(new VideoStoryAIScenePart.8(this), 2500L);
      localAlphaAnimation1.setAnimationListener(new bilt(this, localAlphaAnimation2));
      localAlphaAnimation2.setAnimationListener(new biln(this));
      return;
      label423:
      paramString = null;
    }
  }
  
  private void a(AEMaterialPanel paramAEMaterialPanel)
  {
    Activity localActivity = (Activity)paramAEMaterialPanel.getContext();
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) || (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)))
    {
      int i = vzl.c(localActivity);
      this.jdField_b_of_type_AndroidViewView.post(new VideoStoryAIScenePart.18(this, paramAEMaterialPanel, i));
    }
  }
  
  private void a(AtomicReference<avuh> paramAtomicReference, AEFilterManager paramAEFilterManager)
  {
    if (paramAtomicReference.get() == null) {
      aung.a("Q.videostory", "Q.videostory.capture", "requestAIScene()", "sceneCallback is null");
    }
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
              if ((paramAEFilterManager != null) && (paramAEFilterManager.getAIAttr() != null)) {
                break;
              }
            } while (paramAtomicReference.get() == null);
            ((avuh)paramAtomicReference.get()).a("mQQFilterRenderManager is null");
            return;
            aung.a("Q.videostory", "Q.videostory.capture", "requestAIScene()", "start");
            localObject2 = (PTFaceAttr)paramAEFilterManager.getAIAttr().getFaceAttr();
          } while ((paramAEFilterManager.getAEDetector() == null) || (paramAEFilterManager.getAEDetector().getFaceDetector() == null));
          localObject1 = paramAEFilterManager.getAEDetector().getFaceDetector().getFaceDetector();
          paramAEFilterManager = ((PTFaceAttr)localObject2).getData();
        } while ((paramAEFilterManager == null) || (paramAEFilterManager.length == 0));
        Object localObject1 = ((VideoPreviewFaceOutlineDetector)localObject1).getLastDoTrackSize();
        int i = ((Point)localObject1).x;
        int j = ((Point)localObject1).y;
        localObject1 = new ArrayList();
        Object localObject2 = ((PTFaceAttr)localObject2).getAllFacePoints();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (List)((Iterator)localObject2).next();
            float f1 = ((PointF)((List)localObject3).get(18)).x;
            float f2 = ((PointF)((List)localObject3).get(0)).x;
            float f3 = ((PointF)((List)localObject3).get(9)).y;
            float f4 = ((PointF)((List)localObject3).get(87)).y;
            localObject3 = new bilf();
            ((bilf)localObject3).jdField_b_of_type_Int = ((int)(f3 - f4));
            ((bilf)localObject3).jdField_a_of_type_Int = ((int)(f1 - f2));
            ((ArrayList)localObject1).add(localObject3);
          }
        }
        if ((i == 0) || (j == 0)) {
          break;
        }
        localObject2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        paramAEFilterManager = ByteBuffer.wrap(paramAEFilterManager);
        try
        {
          ((Bitmap)localObject2).copyPixelsFromBuffer(paramAEFilterManager);
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
          this.jdField_a_of_type_Bile.a((Bitmap)localObject2, (ArrayList)localObject1, new bilo(this, paramAtomicReference));
          return;
        }
        catch (Exception paramAEFilterManager) {}
      } while ((avuh)paramAtomicReference.get() == null);
      ((avuh)paramAtomicReference.get()).a(paramAEFilterManager.toString());
      return;
    } while ((avuh)paramAtomicReference.get() == null);
    ((avuh)paramAtomicReference.get()).a("no bitmap");
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.equals("network error"))) {
      this.jdField_a_of_type_AndroidViewView.post(new VideoStoryAIScenePart.15(this));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null)
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b() != 1) {
        break label66;
      }
      e();
      a(null);
      n();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.postDelayed(new VideoStoryAIScenePart.21(this), 1000L);
      xhb.a("mystatus_shoot", "cam_reverse", 0, 0, new String[0]);
      return;
      label66:
      if (!paramBoolean) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.postDelayed(new VideoStoryAIScenePart.20(this), 1000L);
      }
    }
  }
  
  private void k()
  {
    boolean bool;
    int i;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      bool = AEPituCameraCaptureButtonLayout.a();
      if (!birt.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {
        break label131;
      }
      if (!bool) {
        break label141;
      }
      i = 21;
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      localMarginLayoutParams.bottomMargin -= axlk.a(i);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localMarginLayoutParams);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localMarginLayoutParams.bottomMargin -= axlk.a(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localMarginLayoutParams);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localMarginLayoutParams.bottomMargin -= axlk.a(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localMarginLayoutParams);
      label131:
      do
      {
        return;
      } while (!bool);
      i = -55;
      continue;
      label141:
      i = 76;
    }
  }
  
  private void l()
  {
    ((bijn)bijo.a(this.jdField_a_of_type_Bijd).a(bijn.class)).b.a(this.jdField_a_of_type_Bijd, new bilq(this));
    ((biwp)bijo.a(this.jdField_a_of_type_Bijd).a(biwp.class)).a().a(this.jdField_a_of_type_Bijd, new bilr(this));
  }
  
  private void m()
  {
    if (bjaa.a().a("ai_guide_shown", false, 0)) {
      return;
    }
    String str2 = biiq.d;
    String str1 = null;
    Object localObject1 = str1;
    if (!TextUtils.isEmpty(str2))
    {
      Object localObject2 = new File(str2);
      localObject1 = str1;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        localObject1 = str1;
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (localObject2.length > 0)
          {
            localObject1 = new String[localObject2.length];
            int i = 0;
            while (i < localObject2.length)
            {
              str1 = str2 + File.separator + "tap_" + i + ".png";
              if (new File(str1).exists()) {
                localObject1[i] = str1;
              }
              i += 1;
            }
          }
        }
      }
    }
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2000L);
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    if (localObject1 != null) {
      this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a((String[])localObject1);
    }
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new VideoStoryAIScenePart.5(this), 10000L);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.post(new VideoStoryAIScenePart.6(this));
    }
  }
  
  private void o()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.jdField_b_of_type_AndroidViewView.post(new VideoStoryAIScenePart.19(this));
    }
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return super.a(paramInt, paramVarArgs);
    }
    return this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362213);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362217));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362216));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362214));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362215);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363832));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout = ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363880));
    l();
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372075));
    a(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setSceneListener(new bilm(this));
    this.jdField_a_of_type_AndroidOsHandler = new bilp(this, Looper.getMainLooper());
    k();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) && (paramInt == 2))
    {
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new VideoStoryAIScenePart.11(this, paramAEFilterManager);
      }
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 128);
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 128, null, true);
    }
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt).append("");
    String str;
    if (paramQIMFilterCategoryItem != null)
    {
      str = paramQIMFilterCategoryItem.b;
      aung.a("Q.videostory", "Q.videostory.capture", "onFilterSelect", str);
      if (paramInt != 0) {
        a(null);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label102;
      }
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      this.d = paramInt;
      this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = paramQIMFilterCategoryItem;
      xhb.a("mystatus_shoot", "filter_change", 0, 0, new String[0]);
      return;
      str = "no filter";
      break;
      label102:
      e();
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight());
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.setDuration(400L);
      localAnimationSet.addAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
      localAnimationSet.setAnimationListener(new bils(this, paramBoolean, paramInt, paramString));
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 196610: 
    default: 
    case 196609: 
    case 196611: 
    case 196612: 
      do
      {
        return;
        a(null);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoStoryAIScenePart.17(this));
        return;
        b(((Boolean)paramVarArgs[0]).booleanValue());
        return;
      } while (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel == null);
      a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
      return;
    case 196613: 
      o();
      return;
    case 196614: 
      n();
      a(this);
      f();
      return;
    case 196615: 
      i_(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    }
    n();
  }
  
  public void a(avuh paramavuh)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(paramavuh);
  }
  
  public void a(bilk parambilk)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.b())
    {
      a(null);
      e();
      return;
    }
    if ((parambilk.jdField_a_of_type_Int == -1) || ((this.jdField_a_of_type_Bijd != null) && (!this.jdField_a_of_type_Bijd.b())))
    {
      e();
      return;
    }
    Object localObject2 = parambilk.b;
    Object localObject1 = bkrf.a().c(0);
    Bundle localBundle;
    bjcb localbjcb;
    if (localObject1 != null)
    {
      localObject1 = ((QIMFilterCategoryItem)localObject1).b;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label412;
      }
      aung.a("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", (String)localObject2 + " " + (String)localObject1);
      localBundle = new Bundle();
      localBundle.putInt("apply_source", bjcb.jdField_a_of_type_Int);
      localBundle.putInt("capture_scene", 0);
      localBundle.putBoolean("capture_force_enable", this.jdField_c_of_type_Boolean);
      localbjcb = (bjcb)bjav.a(5);
      if (localbjcb.a() != null) {
        break label236;
      }
      parambilk = new ArrayList();
      e();
    }
    for (;;)
    {
      aung.a("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", "filterLister is empty:" + parambilk.size());
      return;
      localObject1 = "";
      break;
      label236:
      localObject1 = localbjcb.a().c;
      Object localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject3).next();
        if (localQIMFilterCategoryItem.b.equals(localObject2))
        {
          localQIMFilterCategoryItem.c = ((String)localObject2);
          localObject2 = new Message();
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("sceneName", parambilk.jdField_a_of_type_JavaLangString);
          ((Bundle)localObject3).putInt("sceneLvOne", parambilk.jdField_a_of_type_Int);
          ((Message)localObject2).setData((Bundle)localObject3);
          ((Message)localObject2).what = 1;
          long l = this.jdField_a_of_type_Long % 1500L;
          if (l > 1100L) {}
          for (;;)
          {
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, 0L);
            this.jdField_a_of_type_AndroidViewView.postDelayed(new VideoStoryAIScenePart.13(this, localQIMFilterCategoryItem, localbjcb, localBundle), 500L);
            parambilk = (bilk)localObject1;
            break;
          }
          label412:
          e();
          return;
        }
      }
      parambilk = (bilk)localObject1;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.b())
    {
      a(null);
      return;
    }
    b(paramString);
    this.jdField_a_of_type_AndroidViewView.post(new VideoStoryAIScenePart.14(this));
    aung.a("Q.videostory", "Q.videostory.capture", "onAISceneFail", paramString);
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131716405));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a();
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    String str2 = biiq.e;
    String str1 = null;
    Object localObject1 = str1;
    if (!TextUtils.isEmpty(str2))
    {
      Object localObject2 = new File(str2);
      localObject1 = str1;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        localObject1 = str1;
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (localObject2.length > 0)
          {
            localObject1 = new String[localObject2.length];
            int i = 0;
            while (i < localObject2.length)
            {
              str1 = str2 + File.separator + "image_000" + i + ".png";
              if (new File(str1).exists()) {
                localObject1[i] = str1;
              }
              i += 1;
            }
          }
        }
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(1500L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    if (localObject1 != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a((String[])localObject1);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
  }
  
  public void e()
  {
    a(0, null, false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 128);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void i_(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bill
 * JD-Core Version:    0.7.0.1
 */