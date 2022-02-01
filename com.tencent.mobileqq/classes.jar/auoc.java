import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import io.flutter.embedding.android.SplashScreen;

public class auoc
  implements SplashScreen
{
  private auod a;
  
  public auoc(auod paramauod)
  {
    this.a = paramauod;
  }
  
  @Nullable
  public View createSplashView(@NonNull Context paramContext, @Nullable Bundle paramBundle)
  {
    return LayoutInflater.from(paramContext).inflate(2131560884, null);
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
    paramRunnable.run();
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auoc
 * JD-Core Version:    0.7.0.1
 */