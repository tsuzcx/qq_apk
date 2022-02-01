import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.store.ApolloVoiceDIYHelper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anfp
{
  private double jdField_a_of_type_Double = 2147483647.0D;
  private int jdField_a_of_type_Int;
  private WeakReference<ApolloTextureView> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  private int c;
  private int d = -1;
  
  private void b(double paramDouble)
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localApolloTextureView == null) {
      return;
    }
    localApolloTextureView.getRender().mIsFrameMode = true;
    localApolloTextureView.getRender().mDuration = paramDouble;
    localApolloTextureView.getRenderImpl().a(0L);
    String[] arrayOfString2 = anhm.a(13, this.jdField_a_of_type_Int, this.b, true);
    String[] arrayOfString1 = null;
    if (this.c == 1) {
      arrayOfString1 = anhm.a(13, this.jdField_a_of_type_Int, this.b, false);
    }
    localApolloTextureView.getRenderImpl().a(this.jdField_a_of_type_Int, 0, arrayOfString2, arrayOfString1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Double = 2147483647.0D;
  }
  
  public void a(double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloVoiceDIYHelper", 2, "[renderFrame], curSec:" + paramDouble + ",lastDur:" + this.jdField_a_of_type_Double);
    }
    ApolloTextureView localApolloTextureView = (ApolloTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localApolloTextureView == null) {
      return;
    }
    if (paramDouble <= this.jdField_a_of_type_Double) {
      b(paramDouble);
    }
    for (;;)
    {
      this.jdField_a_of_type_Double = paramDouble;
      return;
      localApolloTextureView.queueEvent(new ApolloVoiceDIYHelper.1(this, localApolloTextureView, paramDouble - this.jdField_a_of_type_Double));
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloTextureView);
    if (paramInt1 != this.d) {
      a();
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.d = this.jdField_a_of_type_Int;
    this.b = paramInt2;
    this.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfp
 * JD-Core Version:    0.7.0.1
 */