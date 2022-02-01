import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.1;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.2;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.3;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.5;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class aobx
  implements Handler.Callback, aobb, aobd
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aobb jdField_a_of_type_Aobb;
  private aobd jdField_a_of_type_Aobd;
  aobj jdField_a_of_type_Aobj = null;
  private aobw jdField_a_of_type_Aobw;
  private ArVideoResourceInfo jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean;
  private aobb jdField_b_of_type_Aobb;
  private boolean jdField_b_of_type_Boolean;
  
  public aobx(aobd paramaobd, aobw paramaobw)
  {
    this.jdField_a_of_type_Aobd = paramaobd;
    this.jdField_a_of_type_Aobw = paramaobw;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private aobb a(ArVideoResourceInfo paramArVideoResourceInfo, int paramInt)
  {
    aobf localaobf = a(paramArVideoResourceInfo);
    aobb localaobb = aobh.a(this, localaobf, null);
    QLog.d("AREngine_MultiFragmentAnimRenderable", 1, "create new render here " + localaobb);
    boolean bool;
    if (localaobb != null)
    {
      if ((!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (FileUtils.fileExists(paramArVideoResourceInfo.e)) && (this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > paramInt + 1))
      {
        paramArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(paramInt + 1);
        if ((paramArVideoResourceInfo.jdField_d_of_type_Int == 4) && (!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (!FileUtils.fileExists(paramArVideoResourceInfo.e)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "preload next online video, " + paramArVideoResourceInfo.jdField_d_of_type_JavaLangString + ", " + paramArVideoResourceInfo.e);
          }
          aoma.a(BaseApplicationImpl.getContext(), paramArVideoResourceInfo);
        }
      }
      if ((localaobf.jdField_a_of_type_Int != 5) || ((localaobf.jdField_a_of_type_Long != 2L) && (localaobf.jdField_a_of_type_Long != 2048L))) {
        break label292;
      }
      bool = true;
      this.jdField_a_of_type_Aobd.a().a();
      this.jdField_a_of_type_Aobd.a().a(bool, localaobf);
      if (localaobf.jdField_a_of_type_Int != 0) {
        break label297;
      }
      paramArVideoResourceInfo = (aobr)localaobf;
      this.jdField_a_of_type_Aobd.a().a(localaobf.b, localaobf.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
    }
    label292:
    label297:
    do
    {
      return localaobb;
      bool = false;
      break;
      if ((localaobf.jdField_a_of_type_Int == 2) || (localaobf.jdField_a_of_type_Int == 3))
      {
        paramArVideoResourceInfo = (aoca)localaobf;
        this.jdField_a_of_type_Aobd.a().a(localaobf.b, localaobf.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
        return localaobb;
      }
    } while (localaobf.jdField_a_of_type_Int != 4);
    paramArVideoResourceInfo = (aocd)localaobf;
    this.jdField_a_of_type_Aobd.a().a(localaobf.b, localaobf.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
    return localaobb;
  }
  
  private aobf a(ArVideoResourceInfo paramArVideoResourceInfo)
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
    ((ArFeatureInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString;
    localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)localObject);
    localArCloudConfigInfo.jdField_c_of_type_Int = this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_c_of_type_Int;
    return aolr.a(localArCloudConfigInfo, true, this.jdField_a_of_type_Aobw.jdField_a_of_type_Long, this.jdField_a_of_type_Aobw.jdField_c_of_type_Int, this.jdField_a_of_type_Aobw.jdField_a_of_type_Float, this.jdField_a_of_type_Aobw.b, this.jdField_a_of_type_Aobw.jdField_c_of_type_Float);
  }
  
  private void b()
  {
    ArVideoResourceInfo localArVideoResourceInfo;
    aobb localaobb;
    if ((!this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int + 1))
    {
      localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1);
      localaobb = a(localArVideoResourceInfo, this.jdField_a_of_type_Int + 1);
      if (localaobb == null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_Aobb = this.jdField_a_of_type_Aobb;
    this.jdField_a_of_type_Aobb = localaobb;
    this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Aobd.a(new MultiFragmentAnimRenderable.2(this, localaobb));
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_Aobd.a();
  }
  
  public aobi a()
  {
    return this.jdField_a_of_type_Aobd.a();
  }
  
  public aoly a()
  {
    return null;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_Aobd.a(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aobd.a();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(aobb paramaobb, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(aobj paramaobj)
  {
    if (this.jdField_a_of_type_Aobb != null)
    {
      if ((!this.jdField_a_of_type_Aobb.e()) && (this.jdField_b_of_type_Aobb != null) && (this.jdField_a_of_type_Aobj != null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        if (this.jdField_b_of_type_Aobb != null) {
          this.jdField_b_of_type_Aobb.a(this.jdField_a_of_type_Aobj);
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
    }
    else {
      return;
    }
    if (this.jdField_b_of_type_Aobb != null) {
      this.jdField_a_of_type_Aobd.a(new MultiFragmentAnimRenderable.3(this));
    }
    this.jdField_a_of_type_Aobb.a(paramaobj);
    this.jdField_a_of_type_Aobj = paramaobj;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    b();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, aobd paramaobd) {}
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Aobd.a(paramRunnable);
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_Aobb != null)
    {
      if ((!this.jdField_a_of_type_Aobb.e()) && (this.jdField_b_of_type_Aobb != null)) {
        return this.jdField_b_of_type_Aobb.b();
      }
      return this.jdField_a_of_type_Aobb.b();
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
          this.jdField_a_of_type_Aobd.b(paramInt1, paramInt2);
          return;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || ((!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.c()) && (this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Int + 1))) {
            break;
          }
        } while (((this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (paramInt2 > 0)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Aobb != null));
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Aobd.b(paramInt1, 0);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.b())) {
          break;
        }
      } while (this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Aobd.a(this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo, this);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.a()) || (paramInt2 > 0));
    b();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Aobb != null)
    {
      if ((this.jdField_b_of_type_Aobb != null) && (!this.jdField_a_of_type_Aobb.e())) {
        return this.jdField_b_of_type_Aobb.c();
      }
      return this.jdField_a_of_type_Aobb.c();
    }
    return 2;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Aobw.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_a_of_type_Int = 0;
      ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Aobw.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aobb = a(localArVideoResourceInfo, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    }
    if (this.jdField_a_of_type_Aobb == null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Aobb.c();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aobb != null) {
      this.jdField_a_of_type_Aobb.d();
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Aobb != null)
    {
      if ((!this.jdField_a_of_type_Aobb.e()) && (this.jdField_b_of_type_Aobb != null)) {
        return this.jdField_b_of_type_Aobb.d();
      }
      return this.jdField_a_of_type_Aobb.d();
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aobb != null) {
      this.jdField_a_of_type_Aobb.e();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Aobb != null)
    {
      if ((this.jdField_b_of_type_Aobb != null) && (!this.jdField_a_of_type_Aobb.e())) {
        return this.jdField_b_of_type_Aobb.e();
      }
      return this.jdField_a_of_type_Aobb.e();
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "onDestroy currentRenderable " + this.jdField_a_of_type_Aobb + "  lastRenderable " + this.jdField_b_of_type_Aobb);
    }
    if (this.jdField_a_of_type_Aobb != null)
    {
      this.jdField_a_of_type_Aobb.f();
      this.jdField_a_of_type_Aobb = null;
    }
    if (this.jdField_b_of_type_Aobb != null)
    {
      this.jdField_b_of_type_Aobb.f();
      this.jdField_b_of_type_Aobb = null;
    }
    this.jdField_a_of_type_Aobj = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    aoma.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Aobd != null) {
        this.jdField_a_of_type_Aobd.a(new MultiFragmentAnimRenderable.5(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobx
 * JD-Core Version:    0.7.0.1
 */