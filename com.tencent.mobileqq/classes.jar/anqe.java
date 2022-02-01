import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.1;
import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anqe
  extends bhzs
  implements amwd
{
  private int jdField_a_of_type_Int = 0;
  private WeakReference<angr> jdField_a_of_type_JavaLangRefWeakReference;
  
  public anqe(angr paramangr, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramangr);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new ApolloDrawerInfoViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, new Object[] { "[onNotifyStatusChanged], clickPart:", Integer.valueOf(paramInt), ",apolloId:", paramString });
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      anfr localanfr = ((angr)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
      if (localanfr != null) {
        localanfr.a(angi.a(paramInt), null, paramString);
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, "[onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    ThreadManager.post(new ApolloDrawerInfoViewListener.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqe
 * JD-Core Version:    0.7.0.1
 */