import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.script.SpriteBackgroundManager.1;
import com.tencent.mobileqq.apollo.script.SpriteBackgroundManager.2;
import com.tencent.mobileqq.apollo.script.SpriteBackgroundManager.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class anfw
  implements amwb
{
  private anga jdField_a_of_type_Anga;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SpriteBackgroundManager.1(this);
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<ApolloTextureView> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private volatile boolean jdField_a_of_type_Boolean;
  private Runnable jdField_b_of_type_JavaLangRunnable = new SpriteBackgroundManager.2(this);
  private volatile boolean jdField_b_of_type_Boolean;
  
  public anfw(anga paramanga, ApolloTextureView paramApolloTextureView)
  {
    this.jdField_a_of_type_Anga = paramanga;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloTextureView);
  }
  
  private void a(int paramInt)
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localApolloTextureView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, new Object[] { "[execAction], ready to play, actionId:", Integer.valueOf(paramInt) });
    }
    String[] arrayOfString = anlk.a(paramInt);
    this.jdField_a_of_type_JavaLangString = arrayOfString[1];
    localApolloTextureView.getRenderImpl().a(1, null, paramInt, 0, arrayOfString[0], arrayOfString[1]);
  }
  
  private void b(int paramInt)
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localApolloTextureView != null) && (localApolloTextureView.getVisibility() != paramInt)) {
      ThreadManager.getUIHandler().post(new SpriteBackgroundManager.3(this, localApolloTextureView, paramInt));
    }
  }
  
  public void a()
  {
    if (((ApolloTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_JavaLangString == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, new Object[] { "removeBackgroundAction isRunning:", Boolean.valueOf(this.jdField_a_of_type_Boolean), ",actionName:", this.jdField_a_of_type_JavaLangString });
      }
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, "[onCompleteRender]");
    }
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()))
    {
      paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (paramString != null) {
        a(paramString.intValue());
      }
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    b(8);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, "[onStartRender]");
    }
    this.jdField_a_of_type_Boolean = true;
    b(0);
  }
  
  public void a(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean) {
          a();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.addAll(paramList);
      } while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty());
      paramList = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    } while (paramList == null);
    a(paramList.intValue());
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anga.a() == null)) {}
    angf localangf;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, "[onSurfaceReady]");
      }
      this.jdField_a_of_type_Anga.d(true);
      localangf = (angf)this.jdField_a_of_type_Anga.a().getManager(249);
    } while ((!this.jdField_a_of_type_Anga.c()) || (localangf.a().b(null)));
    e();
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    ApolloTextureView localApolloTextureView;
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      localApolloTextureView = (ApolloTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localApolloTextureView == null);
    localApolloTextureView.queueEvent(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localApolloTextureView != null) {
      localApolloTextureView.queueEvent(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void e()
  {
    b(8);
    a();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    }
    Object localObject = (ApolloTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      localObject = ((ApolloTextureView)localObject).getRenderImpl();
      if (localObject != null) {
        ((amul)localObject).c();
      }
    }
    this.jdField_a_of_type_Anga = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfw
 * JD-Core Version:    0.7.0.1
 */