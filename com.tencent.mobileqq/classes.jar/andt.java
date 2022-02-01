import com.tencent.mobileqq.apollo.sdk.CmShowViewListener.1;
import com.tencent.mobileqq.apollo.sdk.CmShowViewListener.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class andt
  extends bhow
  implements ampy
{
  private int jdField_a_of_type_Int = 3;
  private anda jdField_a_of_type_Anda;
  private WeakReference<ande> jdField_a_of_type_JavaLangRefWeakReference;
  
  public andt(ande paramande, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramande);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(anda paramanda)
  {
    this.jdField_a_of_type_Anda = paramanda;
  }
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_ApolloDrawerInfoViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new CmShowViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onNotifyLongTouch name", paramString });
    if (this.jdField_a_of_type_Anda != null) {
      this.jdField_a_of_type_Anda.a(paramString);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_ApolloDrawerInfoViewListener", 2, new Object[] { "[onNotifyStatusChanged], clickPart:", Integer.valueOf(paramInt), ",apolloId:", paramString });
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      andf localandf = ((ande)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
      if (localandf != null) {
        localandf.a(anck.a(paramInt), null, paramString);
      }
    }
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onNotifyStatusChanged clickPart:", Integer.valueOf(paramInt), " apolloId:" + paramString });
    if (this.jdField_a_of_type_Anda != null) {
      this.jdField_a_of_type_Anda.a(paramInt, paramString);
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_ApolloDrawerInfoViewListener", 2, "[onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    ThreadManager.post(new CmShowViewListener.1(this, paramInt1, paramInt2), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andt
 * JD-Core Version:    0.7.0.1
 */