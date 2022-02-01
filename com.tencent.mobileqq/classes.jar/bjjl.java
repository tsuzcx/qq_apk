import android.os.Bundle;
import mqq.observer.SSOAccountObserver;

class bjjl
  extends SSOAccountObserver
{
  bjjl(bjjj parambjjj, int paramInt) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    bjjj.a(this.jdField_a_of_type_Bjjj, paramString, this.jdField_a_of_type_Int, paramInt2, -102);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    bjji.a().a(paramString);
    bjjj.a(paramString);
    bjjj.a(this.jdField_a_of_type_Bjjj, paramString, this.jdField_a_of_type_Int, 0, 0);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    bjjj.a(this.jdField_a_of_type_Bjjj, paramString, this.jdField_a_of_type_Int, 2006, -100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjjl
 * JD-Core Version:    0.7.0.1
 */