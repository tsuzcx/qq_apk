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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class amro
  implements amqs, amqu, Handler.Callback
{
  private int jdField_a_of_type_Int;
  private amqs jdField_a_of_type_Amqs;
  private amqu jdField_a_of_type_Amqu;
  amra jdField_a_of_type_Amra = null;
  private amrn jdField_a_of_type_Amrn;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArVideoResourceInfo jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean;
  private amqs jdField_b_of_type_Amqs;
  private boolean jdField_b_of_type_Boolean;
  
  public amro(amqu paramamqu, amrn paramamrn)
  {
    this.jdField_a_of_type_Amqu = paramamqu;
    this.jdField_a_of_type_Amrn = paramamrn;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private amqs a(ArVideoResourceInfo paramArVideoResourceInfo, int paramInt)
  {
    amqw localamqw = a(paramArVideoResourceInfo);
    amqs localamqs = amqy.a(this, localamqw, null);
    QLog.d("AREngine_MultiFragmentAnimRenderable", 1, "create new render here " + localamqs);
    boolean bool;
    if (localamqs != null)
    {
      if ((!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (bdcs.a(paramArVideoResourceInfo.e)) && (this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > paramInt + 1))
      {
        paramArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(paramInt + 1);
        if ((paramArVideoResourceInfo.jdField_d_of_type_Int == 4) && (!TextUtils.isEmpty(paramArVideoResourceInfo.e)) && (!bdcs.a(paramArVideoResourceInfo.e)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "preload next online video, " + paramArVideoResourceInfo.jdField_d_of_type_JavaLangString + ", " + paramArVideoResourceInfo.e);
          }
          anby.a(BaseApplicationImpl.getContext(), paramArVideoResourceInfo);
        }
      }
      if ((localamqw.jdField_a_of_type_Int != 5) || ((localamqw.jdField_a_of_type_Long != 2L) && (localamqw.jdField_a_of_type_Long != 2048L))) {
        break label292;
      }
      bool = true;
      this.jdField_a_of_type_Amqu.a().a();
      this.jdField_a_of_type_Amqu.a().a(bool, localamqw);
      if (localamqw.jdField_a_of_type_Int != 0) {
        break label297;
      }
      paramArVideoResourceInfo = (amri)localamqw;
      this.jdField_a_of_type_Amqu.a().a(localamqw.b, localamqw.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
    }
    label292:
    label297:
    do
    {
      return localamqs;
      bool = false;
      break;
      if ((localamqw.jdField_a_of_type_Int == 2) || (localamqw.jdField_a_of_type_Int == 3))
      {
        paramArVideoResourceInfo = (amrr)localamqw;
        this.jdField_a_of_type_Amqu.a().a(localamqw.b, localamqw.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
        return localamqs;
      }
    } while (localamqw.jdField_a_of_type_Int != 4);
    paramArVideoResourceInfo = (amru)localamqw;
    this.jdField_a_of_type_Amqu.a().a(localamqw.b, localamqw.jdField_a_of_type_Int, paramArVideoResourceInfo.a);
    return localamqs;
  }
  
  private amqw a(ArVideoResourceInfo paramArVideoResourceInfo)
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
    ((ArFeatureInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_d_of_type_JavaLangString;
    localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)localObject);
    localArCloudConfigInfo.jdField_c_of_type_Int = this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_c_of_type_Int;
    return anbo.a(localArCloudConfigInfo, true, this.jdField_a_of_type_Amrn.jdField_a_of_type_Long, this.jdField_a_of_type_Amrn.jdField_c_of_type_Int, this.jdField_a_of_type_Amrn.jdField_a_of_type_Float, this.jdField_a_of_type_Amrn.b, this.jdField_a_of_type_Amrn.jdField_c_of_type_Float);
  }
  
  private void b()
  {
    ArVideoResourceInfo localArVideoResourceInfo;
    amqs localamqs;
    if ((!this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int + 1))
    {
      localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int + 1);
      localamqs = a(localArVideoResourceInfo, this.jdField_a_of_type_Int + 1);
      if (localamqs == null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_Amqs = this.jdField_a_of_type_Amqs;
    this.jdField_a_of_type_Amqs = localamqs;
    this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Amqu.a(new MultiFragmentAnimRenderable.2(this, localamqs));
  }
  
  public amqz a()
  {
    return this.jdField_a_of_type_Amqu.a();
  }
  
  public anbv a()
  {
    return null;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_Amqu.a();
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_Amqu.a(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Amqu.a();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(amqs paramamqs, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(amra paramamra)
  {
    if (this.jdField_a_of_type_Amqs != null)
    {
      if ((!this.jdField_a_of_type_Amqs.e()) && (this.jdField_b_of_type_Amqs != null) && (this.jdField_a_of_type_Amra != null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        if (this.jdField_b_of_type_Amqs != null) {
          this.jdField_b_of_type_Amqs.a(this.jdField_a_of_type_Amra);
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
    }
    else {
      return;
    }
    if (this.jdField_b_of_type_Amqs != null) {
      this.jdField_a_of_type_Amqu.a(new MultiFragmentAnimRenderable.3(this));
    }
    this.jdField_a_of_type_Amqs.a(paramamra);
    this.jdField_a_of_type_Amra = paramamra;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    b();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, amqu paramamqu) {}
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Amqu.a(paramRunnable);
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_Amqs != null)
    {
      if ((!this.jdField_a_of_type_Amqs.e()) && (this.jdField_b_of_type_Amqs != null)) {
        return this.jdField_b_of_type_Amqs.b();
      }
      return this.jdField_a_of_type_Amqs.b();
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
          this.jdField_a_of_type_Amqu.b(paramInt1, paramInt2);
          return;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || ((!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.c()) && (this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Int + 1))) {
            break;
          }
        } while (((this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (paramInt2 > 0)) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Amqs != null));
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Amqu.b(paramInt1, 0);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.b())) {
          break;
        }
      } while (this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Amqu.a(this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo, this);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.a()) || (paramInt2 > 0));
    b();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Amqs != null)
    {
      if ((this.jdField_b_of_type_Amqs != null) && (!this.jdField_a_of_type_Amqs.e())) {
        return this.jdField_b_of_type_Amqs.c();
      }
      return this.jdField_a_of_type_Amqs.c();
    }
    return 2;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Amrn.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_a_of_type_Int = 0;
      ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Amrn.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Amqs = a(localArVideoResourceInfo, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    }
    if (this.jdField_a_of_type_Amqs == null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Amqs.c();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Amqs != null) {
      this.jdField_a_of_type_Amqs.d();
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Amqs != null)
    {
      if ((!this.jdField_a_of_type_Amqs.e()) && (this.jdField_b_of_type_Amqs != null)) {
        return this.jdField_b_of_type_Amqs.d();
      }
      return this.jdField_a_of_type_Amqs.d();
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Amqs != null) {
      this.jdField_a_of_type_Amqs.e();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Amqs != null)
    {
      if ((this.jdField_b_of_type_Amqs != null) && (!this.jdField_a_of_type_Amqs.e())) {
        return this.jdField_b_of_type_Amqs.e();
      }
      return this.jdField_a_of_type_Amqs.e();
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "onDestroy currentRenderable " + this.jdField_a_of_type_Amqs + "  lastRenderable " + this.jdField_b_of_type_Amqs);
    }
    if (this.jdField_a_of_type_Amqs != null)
    {
      this.jdField_a_of_type_Amqs.f();
      this.jdField_a_of_type_Amqs = null;
    }
    if (this.jdField_b_of_type_Amqs != null)
    {
      this.jdField_b_of_type_Amqs.f();
      this.jdField_b_of_type_Amqs = null;
    }
    this.jdField_a_of_type_Amra = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Amqu != null) {
        this.jdField_a_of_type_Amqu.a(new MultiFragmentAnimRenderable.5(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amro
 * JD-Core Version:    0.7.0.1
 */