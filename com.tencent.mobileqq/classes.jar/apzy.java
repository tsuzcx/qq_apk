import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import io.flutter.embedding.android.SplashScreen;

public class apzy
  implements SplashScreen
{
  private View jdField_a_of_type_AndroidViewView;
  private apzz jdField_a_of_type_Apzz;
  
  public apzy(apzz paramapzz)
  {
    this.jdField_a_of_type_Apzz = paramapzz;
  }
  
  @Nullable
  public View createSplashView(@NonNull Context paramContext, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560514, null);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public boolean doesSplashViewRememberItsTransition()
  {
    return false;
  }
  
  @Nullable
  public Bundle saveSplashScreenState()
  {
    return null;
  }
  
  public void transitionToFlutter(@NonNull Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    if (this.jdField_a_of_type_Apzz != null) {
      this.jdField_a_of_type_Apzz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzy
 * JD-Core Version:    0.7.0.1
 */