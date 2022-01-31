import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.1;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.2;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.3;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.4;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.5;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.6;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.7;
import com.tencent.qqmini.sdk.minigame.ui.GameUIProxy;
import com.tencent.qqmini.sdk.minigame.ui.LoadingUI;

public class bdqv
  extends bdlh
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private GameUIProxy jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy;
  private LoadingUI jdField_a_of_type_ComTencentQqminiSdkMinigameUiLoadingUI;
  
  public bdqv(GameUIProxy paramGameUIProxy)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy = paramGameUIProxy;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getActivity();
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiLoadingUI = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getLoadingUI();
  }
  
  private void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(bdlg parambdlg)
  {
    switch (parambdlg.jdField_a_of_type_Int)
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
            bdnw.b("GameRuntimeStateObserver", "Game engine loading");
          } while (!(parambdlg.jdField_a_of_type_JavaLangObject instanceof String));
          a(new GameRuntimeStateObserver.1(this, (String)parambdlg.jdField_a_of_type_JavaLangObject));
          return;
          bdnw.b("GameRuntimeStateObserver", "Game engine loaded");
          if ((parambdlg.jdField_a_of_type_JavaLangObject instanceof String)) {
            a(new GameRuntimeStateObserver.2(this, (String)parambdlg.jdField_a_of_type_JavaLangObject));
          }
        } while (parambdlg.jdField_a_of_type_Bdlq == null);
        parambdlg.jdField_a_of_type_Bdlq.notifyRuntimeEvent(4, new Object[0]);
        return;
        bdnw.b("GameRuntimeStateObserver", "Failed to load game engine");
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          a(new GameRuntimeStateObserver.3(this));
        }
        this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.reportEnineLoadFail();
        return;
        bdnw.b("GameRuntimeStateObserver", "Game package loading");
      } while (!(parambdlg.jdField_a_of_type_JavaLangObject instanceof Float));
      a(new GameRuntimeStateObserver.4(this, (Float)parambdlg.jdField_a_of_type_JavaLangObject));
      return;
      bdnw.b("GameRuntimeStateObserver", "Game package loaded");
      a(new GameRuntimeStateObserver.5(this));
      return;
      bdnw.b("GameRuntimeStateObserver", "Failed to load game package");
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        a(new GameRuntimeStateObserver.6(this));
      }
      this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.reportGkpLoadFail();
      return;
      bdnw.b("GameRuntimeStateObserver", "Game First render");
      a(new GameRuntimeStateObserver.7(this));
    } while (parambdlg.jdField_a_of_type_Bdlq == null);
    parambdlg.jdField_a_of_type_Bdlq.notifyRuntimeEvent(11, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqv
 * JD-Core Version:    0.7.0.1
 */