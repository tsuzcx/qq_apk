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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("create new render here ");
    ((StringBuilder)localObject).append(localARBaseRender);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool2 = true;
    QLog.d("AREngine_MultiFragmentAnimRenderable", 1, (String)localObject);
    if (localARBaseRender != null)
    {
      if ((!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (FileUtils.fileExists(paramArVideoResourceInfo.e)))
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size();
        paramInt += 1;
        if (i > paramInt)
        {
          paramArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
          if ((paramArVideoResourceInfo.jdField_d_of_type_Int == 4) && (!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (!FileUtils.fileExists(paramArVideoResourceInfo.e)))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("preload next online video, ");
              ((StringBuilder)localObject).append(paramArVideoResourceInfo.jdField_d_of_type_JavaLangString);
              ((StringBuilder)localObject).append(", ");
              ((StringBuilder)localObject).append(paramArVideoResourceInfo.e);
              QLog.w("AREngine_MultiFragmentAnimRenderable", 2, ((StringBuilder)localObject).toString());
            }
            AROnlineVideoUtil.a(BaseApplicationImpl.getContext(), paramArVideoResourceInfo);
          }
        }
      }
      if (localARRenderResourceInfo.jdField_a_of_type_Int == 5)
      {
        bool1 = bool2;
        if (localARRenderResourceInfo.jdField_a_of_type_Long == 2L) {
          break label269;
        }
        if (localARRenderResourceInfo.jdField_a_of_type_Long == 2048L)
        {
          bool1 = bool2;
          break label269;
        }
      }
      boolean bool1 = false;
      label269:
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(bool1, localARRenderResourceInfo);
      if (localARRenderResourceInfo.jdField_a_of_type_Int == 0)
      {
        paramArVideoResourceInfo = (GeneralARResourceInfo)localARRenderResourceInfo;
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(localARRenderResourceInfo.b, localARRenderResourceInfo.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
        return localARBaseRender;
      }
      if ((localARRenderResourceInfo.jdField_a_of_type_Int != 2) && (localARRenderResourceInfo.jdField_a_of_type_Int != 3))
      {
        if (localARRenderResourceInfo.jdField_a_of_type_Int == 4)
        {
          paramArVideoResourceInfo = (OnlineVideoARRenderableInfo)localARRenderResourceInfo;
          this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(localARRenderResourceInfo.b, localARRenderResourceInfo.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
          return localARBaseRender;
        }
      }
      else
      {
        paramArVideoResourceInfo = (NormalVideoARResourceInfo)localARRenderResourceInfo;
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(localARRenderResourceInfo.b, localARRenderResourceInfo.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
      }
    }
    return localARBaseRender;
  }
  
  private ARRenderResourceInfo a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    ArCloudConfigInfo localArCloudConfigInfo = new ArCloudConfigInfo();
    localArCloudConfigInfo.jdField_d_of_type_Int = paramArVideoResourceInfo.jdField_d_of_type_Int;
    if ((QLog.isDebugVersion()) && (paramArVideoResourceInfo.jdField_d_of_type_Int != 2) && (paramArVideoResourceInfo.jdField_d_of_type_Int != 3) && (paramArVideoResourceInfo.jdField_d_of_type_Int != 4))
    {
      ThreadManager.getUIHandler().post(new MultiFragmentAnimRenderable.1(this));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildARRenderResourceInfoForFragmentAnim animInfo.type=");
      ((StringBuilder)localObject).append(paramArVideoResourceInfo.jdField_d_of_type_Int);
      QLog.i("AREngine_MultiFragmentAnimRenderable", 2, ((StringBuilder)localObject).toString());
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
    if ((!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int + 1))
    {
      ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1);
      ARBaseRender localARBaseRender = a(localArVideoResourceInfo, this.jdField_a_of_type_Int + 1);
      if (localARBaseRender == null)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = localARBaseRender;
      this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new MultiFragmentAnimRenderable.2(this, localARBaseRender));
    }
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
    ARBaseRender localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localARBaseRender != null)
    {
      if ((!localARBaseRender.e()) && (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements != null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        paramDrawFrameParements = this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
        if (paramDrawFrameParements != null) {
          paramDrawFrameParements.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements);
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        return;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new MultiFragmentAnimRenderable.3(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a(paramDrawFrameParements);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements = paramDrawFrameParements;
    }
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
    ARBaseRender localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localARBaseRender != null)
    {
      if (!localARBaseRender.e())
      {
        localARBaseRender = this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
        if (localARBaseRender != null) {
          return localARBaseRender.b();
        }
      }
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.b();
    }
    return 5;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyAnimationPlayStatusChange state:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" remainTimes:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("AREngine_MultiFragmentAnimRenderable", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        if (paramInt1 != 2)
        {
          if (paramInt1 == 3) {}
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo;
          if ((localObject != null) && ((((ArVideoResourceInfo)localObject).c()) || (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() == this.jdField_a_of_type_Int + 1)))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (paramInt2 > 0)) {
              return;
            }
            if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null)) {
              return;
            }
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.b(paramInt1, 0);
            return;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo;
          if ((localObject != null) && (((ArVideoResourceInfo)localObject).b()))
          {
            if (this.jdField_b_of_type_Boolean) {
              return;
            }
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo, this);
            return;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo;
          if ((localObject == null) || (!((ArVideoResourceInfo)localObject).a()) || (paramInt2 > 0)) {
            return;
          }
          b();
          return;
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
    else if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.b(paramInt1, paramInt2);
    }
  }
  
  public int c()
  {
    ARBaseRender localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localARBaseRender != null)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) && (!localARBaseRender.e())) {
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
      localObject = (ArVideoResourceInfo)this.jdField_a_of_type_ComTencentMobileqqArARRenderModelMultiFragmentAnimARResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = a((ArVideoResourceInfo)localObject, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = ((ArVideoResourceInfo)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localObject == null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
    } else {
      ((ARBaseRender)localObject).c();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    ARBaseRender localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localARBaseRender != null) {
      localARBaseRender.d();
    }
  }
  
  public boolean d()
  {
    ARBaseRender localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localARBaseRender != null)
    {
      if (!localARBaseRender.e())
      {
        localARBaseRender = this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
        if (localARBaseRender != null) {
          return localARBaseRender.d();
        }
      }
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.d();
    }
    return false;
  }
  
  public void e()
  {
    ARBaseRender localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localARBaseRender != null) {
      localARBaseRender.e();
    }
  }
  
  public boolean e()
  {
    ARBaseRender localARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localARBaseRender != null)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) && (!localARBaseRender.e())) {
        return this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e();
      }
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e();
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy currentRenderable ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender);
      ((StringBuilder)localObject).append("  lastRenderable ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender);
      QLog.w("AREngine_MultiFragmentAnimRenderable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localObject != null)
    {
      ((ARBaseRender)localObject).f();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if (localObject != null)
    {
      ((ARBaseRender)localObject).f();
      this.jdField_b_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements = null;
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    AROnlineVideoUtil.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
      if (paramMessage != null) {
        paramMessage.a(new MultiFragmentAnimRenderable.5(this));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable
 * JD-Core Version:    0.7.0.1
 */