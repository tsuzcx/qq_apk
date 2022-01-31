import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.ui.VConsoleDragView;
import com.tencent.qqmini.sdk.minigame.ui.VConsoleView;
import com.tencent.qqmini.sdk.minigame.utils.VConsoleLogManager.3;
import com.tencent.qqmini.sdk.minigame.utils.VConsoleLogManager.4;
import java.util.concurrent.ArrayBlockingQueue;

public class bgwh
  implements bgvx
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bgwj(this);
  private View jdField_a_of_type_AndroidViewView;
  private WebView jdField_a_of_type_AndroidWebkitWebView;
  private VConsoleDragView jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView;
  private VConsoleView jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView;
  String jdField_a_of_type_JavaLangString = "file:///android_asset/mini/mini_vconsole.html";
  private ArrayBlockingQueue jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue = new ArrayBlockingQueue(1000);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  private void a()
  {
    this.b = true;
    for (Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.poll(); localPair != null; localPair = (Pair)this.jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.poll()) {
      b((String)localPair.first, (String)localPair.second);
    }
    this.b = false;
  }
  
  private void a(String paramString)
  {
    ThreadManager.c().post(new VConsoleLogManager.4(this, paramString));
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = false;
    this.c = paramBoolean;
    a("javascript:showPannel()");
    VConsoleView localVConsoleView;
    if (this.d)
    {
      localVConsoleView = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView;
      if (!this.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (int i = 8;; i = 0)
    {
      localVConsoleView.setVisibility(i);
      paramBoolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        paramBoolean = true;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      a();
      return;
    }
  }
  
  private void b()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if ((this.jdField_a_of_type_AndroidWebkitWebView == null) || (this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView == null)) {
      return;
    }
    if (this.c)
    {
      VConsoleView localVConsoleView = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = 8;; i = 0)
      {
        localVConsoleView.setVisibility(i);
        bool1 = bool2;
        if (!this.jdField_a_of_type_Boolean) {
          bool1 = true;
        }
        this.jdField_a_of_type_Boolean = bool1;
        this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView.bringToFront();
        return;
      }
    }
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      this.d = bool1;
      break;
      bool1 = false;
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidWebkitWebView == null)
    {
      QMLog.e("[minigame] VConsoleLogManager", "consoleWebView is not ready");
      return;
    }
    ThreadManager.c().post(new VConsoleLogManager.3(this, paramString1, paramString2));
  }
  
  public void a(VConsoleView paramVConsoleView, VConsoleDragView paramVConsoleDragView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView = paramVConsoleView;
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView = paramVConsoleDragView;
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView.bringToFront();
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView.setListener(this);
    this.jdField_a_of_type_AndroidWebkitWebView = paramVConsoleView.jdField_a_of_type_AndroidWebkitWebView;
    this.jdField_a_of_type_AndroidWebkitWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWebkitWebView.setWebViewClient(new bgwi(this));
    this.jdField_a_of_type_Boolean = false;
    paramVConsoleView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView = paramVConsoleView.jdField_a_of_type_AndroidWidgetImageView;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramBoolean) {
      b();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    String str = paramString2.replace("\n", "\\r\\n").replace("\\\"", "\"").replace("\"", "\\\"");
    paramString2 = str;
    if (str.endsWith("\\")) {
      paramString2 = str + "\\";
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue == null) {
        this.jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue = new ArrayBlockingQueue(1000);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.size() == 1000) {
        this.jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.poll();
      }
      this.jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.add(new Pair(paramString1, paramString2));
      if ((this.c) && (!this.b)) {
        a();
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        QMLog.e("[minigame] VConsoleLogManager", "injectLog error", paramString1);
      }
    }
    finally {}
  }
  
  public void d()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwh
 * JD-Core Version:    0.7.0.1
 */