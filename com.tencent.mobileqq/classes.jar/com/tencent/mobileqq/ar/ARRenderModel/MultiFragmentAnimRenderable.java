package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class MultiFragmentAnimRenderable
  implements Handler.Callback, ARBaseRender, ARRenderMangerInnerCallback
{
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ARBaseRender jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
  private ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  ARRenerArumentManager.DrawFrameParements jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements = null;
  private MultiFragmentAnimARResourceInfo jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo;
  private ArVideoResourceInfo jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean = false;
  private ARBaseRender jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
  private boolean jdField_b_of_type_Boolean = false;
  
  public MultiFragmentAnimRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, MultiFragmentAnimARResourceInfo paramMultiFragmentAnimARResourceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo = paramMultiFragmentAnimARResourceInfo;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private ARBaseRender a(ArVideoResourceInfo paramArVideoResourceInfo, int paramInt)
  {
    ARRenderResourceInfo localARRenderResourceInfo = a(paramArVideoResourceInfo);
    ARBaseRender localARBaseRender = ARRenderableConstructorFactoty.a(this, localARRenderResourceInfo, null);
    QLog.d("AREngine_MultiFragmentAnimRenderable", 1, "create new render here " + localARBaseRender);
    boolean bool;
    if (localARBaseRender != null)
    {
      if ((!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (FileUtils.a(paramArVideoResourceInfo.e)) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > paramInt + 1))
      {
        paramArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(paramInt + 1);
        if ((paramArVideoResourceInfo.jdField_d_of_type_Int == 4) && (!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (!FileUtils.a(paramArVideoResourceInfo.e)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "preload next online video, " + paramArVideoResourceInfo.jdField_d_of_type_JavaLangString + ", " + paramArVideoResourceInfo.e);
          }
          AROnlineVideoUtil.a(BaseApplicationImpl.getContext(), paramArVideoResourceInfo);
        }
      }
      if ((localARRenderResourceInfo.jdField_a_of_type_Int != 5) || ((localARRenderResourceInfo.jdField_a_of_type_Long != 2L) && (localARRenderResourceInfo.jdField_a_of_type_Long != 2048L))) {
        break label292;
      }
      bool = true;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(bool, localARRenderResourceInfo);
      if (localARRenderResourceInfo.jdField_a_of_type_Int != 0) {
        break label297;
      }
      paramArVideoResourceInfo = (GeneralARResourceInfo)localARRenderResourceInfo;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(localARRenderResourceInfo.b, localARRenderResourceInfo.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
    }
    label292:
    label297:
    do
    {
      return localARBaseRender;
      bool = false;
      break;
      if ((localARRenderResourceInfo.jdField_a_of_type_Int == 2) || (localARRenderResourceInfo.jdField_a_of_type_Int == 3))
      {
        paramArVideoResourceInfo = (NormalVideoARResourceInfo)localARRenderResourceInfo;
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(localARRenderResourceInfo.b, localARRenderResourceInfo.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
        return localARBaseRender;
      }
    } while (localARRenderResourceInfo.jdField_a_of_type_Int != 4);
    paramArVideoResourceInfo = (OnlineVideoARRenderableInfo)localARRenderResourceInfo;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(localARRenderResourceInfo.b, localARRenderResourceInfo.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
    return localARBaseRender;
  }
  
  private ARRenderResourceInfo a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    ArCloudConfigInfo localArCloudConfigInfo = new ArCloudConfigInfo();
    localArCloudConfigInfo.jdField_d_of_type_Int = paramArVideoResourceInfo.jdField_d_of_type_Int;
    if ((QLog.isDebugVersion()) && (paramArVideoResourceInfo.jdField_d_of_type_Int != 2) && (paramArVideoResourceInfo.jdField_d_of_type_Int != 3) && (paramArVideoResourceInfo.jdField_d_of_type_Int != 4))
    {
      ThreadManager.getUIHandler().post(new MultiFragmentAnimRenderable.1(this));
      QLog.i("AREngine_MultiFragmentAnimRenderable", 2, "buildARRenderResourceInfoForFragmentAnim animInfo.type=" + paramArVideoResourceInfo.jdField_d_of_type_Int);
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramArVideoResourceInfo);
    localArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    localObject = new ArFeatureInfo();
    ((ArFeatureInfo)localObject).jdField_a_of_type_JavaLangString = paramArVideoResourceInfo.c;
    ((ArFeatureInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString;
    localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)localObject);
    localArCloudConfigInfo.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_c_of_type_Int;
    return QQARSession.a(localArCloudConfigInfo, true, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.b, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_c_of_type_Float);
  }
  
  private void b()
  {
    ArVideoResourceInfo localArVideoResourceInfo;
    ARBaseRender localARBaseRender;
    if ((!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int + 1))
    {
      localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1);
      localARBaseRender = a(localArVideoResourceInfo, this.jdField_a_of_type_Int + 1);
      if (localARBaseRender == null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = localARBaseRender;
    this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new MultiFragmentAnimRenderable.2(this, localARBaseRender));
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a();
  }
  
  public ARRenerArumentManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a();
  }
  
  public UniformGLRenderManager a()
  {
    return null;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(ARBaseRender paramARBaseRender, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e()) && (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements != null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        if (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) {
          this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements);
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
    }
    else {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new MultiFragmentAnimRenderable.3(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a(paramDrawFrameParements);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements = paramDrawFrameParements;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    b();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback) {}
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(paramRunnable);
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e()) && (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)) {
        return this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender.b();
      }
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.b();
    }
    return 5;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_MultiFragmentAnimRenderable", 2, "notifyAnimationPlayStatusChange state:" + paramInt1 + " remainTimes:" + paramInt2);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_Int != 0);
          this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.b(paramInt1, paramInt2);
          return;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || ((!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.c()) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Int + 1))) {
            break;
          }
        } while (((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (paramInt2 > 0)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null));
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.b(paramInt1, 0);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.b())) {
          break;
        }
      } while (this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo, this);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.a()) || (paramInt2 > 0));
    b();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) && (!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e())) {
        return this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c();
      }
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c();
    }
    return 2;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_a_of_type_Int = 0;
      ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = a(localArVideoResourceInfo, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender == null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.d();
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e()) && (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)) {
        return this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender.d();
      }
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.d();
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) && (!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e())) {
        return this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e();
      }
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e();
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "onDestroy currentRenderable " + this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender + "  lastRenderable " + this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.f();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender.f();
      this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    AROnlineVideoUtil.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new MultiFragmentAnimRenderable.5(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable
 * JD-Core Version:    0.7.0.1
 */