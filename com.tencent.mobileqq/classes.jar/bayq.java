import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class bayq
  extends baxr
  implements bayp
{
  public static final String TAG = "WebViewBaseBuilder";
  protected boolean bFitSystemWindow = true;
  protected boolean bNeedStatusTrans = true;
  public FrameLayout bottomContainer;
  public LinearLayout contentContainer;
  public String leftName;
  protected AppInterface mAppInterface;
  protected Context mContext;
  protected Activity mInActivity;
  protected Intent mIntent;
  protected SystemBarCompact mSystemBarComp;
  public bbdg mTitleBar;
  public View mViewRoot;
  public View maskView;
  public FrameLayout titleContainer;
  public String titleText;
  public RelativeLayout webviewContainer;
  
  public bayq(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mContext = paramContext;
    this.mInActivity = paramActivity;
    this.mIntent = paramIntent;
    this.mAppInterface = paramAppInterface;
  }
  
  @TargetApi(14)
  private void initLayout()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "initLayout");
    }
    View localView = LayoutInflater.from(this.mContext).inflate(2131497014, null);
    this.mInActivity.setContentView(localView);
    this.mViewRoot = localView.findViewById(2131313550);
    if ((this.bNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.mViewRoot.setFitsSystemWindows(this.bFitSystemWindow);
    }
    this.titleContainer = ((FrameLayout)this.mViewRoot.findViewById(2131311572));
    this.bottomContainer = ((FrameLayout)this.mViewRoot.findViewById(2131297810));
    this.webviewContainer = ((RelativeLayout)this.mViewRoot.findViewById(2131313565));
    this.mLoadProgress = ((ProgressBar)this.mViewRoot.findViewById(2131309309));
    this.maskView = this.mViewRoot.findViewById(2131313568);
    this.contentContainer = ((LinearLayout)this.mViewRoot.findViewById(2131299142));
    if ((this.mIntent != null) && (!this.mIntent.getBooleanExtra("webview_hide_progress", false)))
    {
      this.mLoadingProgressBar = ((WebViewProgressBar)this.mViewRoot.findViewById(2131306308));
      this.mProgressBarController = new bbpa();
      this.mLoadingProgressBar.setController(this.mProgressBarController);
      if ((this.mIsFirstOnPageStart) && (this.mProgressBarController != null) && (this.mProgressBarController.b() != 0)) {
        this.mProgressBarController.a((byte)0);
      }
    }
  }
  
  public void addBottomView(View paramView)
  {
    try
    {
      this.bottomContainer.removeAllViews();
      if (paramView.getLayoutParams() == null) {
        paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      }
      this.bottomContainer.addView(paramView);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void addContentView(View paramView)
  {
    try
    {
      this.contentContainer.addView(paramView);
      this.contentContainer.setVisibility(0);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void addTitleView(View paramView)
  {
    try
    {
      this.titleContainer.removeAllViews();
      if (paramView.getLayoutParams() == null) {
        paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      }
      this.titleContainer.addView(paramView);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  protected void adjustLayout(boolean paramBoolean, bays parambays)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "adjustLayout");
    }
    int i = ImmersiveUtils.getStatusBarHeight(this.mContext);
    if (paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)parambays.b.getLayoutParams();
      localLayoutParams.topMargin = i;
      parambays.b.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)parambays.a.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localLayoutParams.addRule(3, 0);
      parambays.a.setLayoutParams(localLayoutParams);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)parambays.b.getLayoutParams();
    localLayoutParams.topMargin = i;
    parambays.b.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)parambays.a.getLayoutParams();
    localLayoutParams.topMargin = (i + azvv.a(this.mContext, 50.0F));
    parambays.a.setLayoutParams(localLayoutParams);
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "buildLayout");
    }
    initLayout();
    this.mWebview = new TouchWebView(this.mContext);
    this.mWebview.setId(2131313562);
    this.webviewContainer.addView(this.mWebview);
  }
  
  @TargetApi(14)
  public void buildLayout(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "buildLayout...context");
    }
    initLayout();
    this.mWebview = new TouchWebView(paramContext);
    this.mWebview.setId(2131313562);
    this.webviewContainer.addView(this.mWebview, 0, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public void buildTitleBar()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "buildTitleBar");
    }
    this.mTitleBar = new bbdg(this.mInActivity, this.mWebview, this.titleContainer);
    this.titleContainer.setBackgroundResource(2130848801);
    if (this.mIntent != null)
    {
      this.titleText = this.mIntent.getStringExtra("webview_title");
      this.leftName = this.mIntent.getStringExtra("webview_left_name");
      if (!TextUtils.isEmpty(this.titleText)) {
        this.mTitleBar.b(this.titleText);
      }
      if (!TextUtils.isEmpty(this.leftName)) {
        this.mTitleBar.a(this.leftName);
      }
    }
    this.mTitleBar.a(new bayr(this));
  }
  
  public final void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
    onWebViewReady();
  }
  
  public void finish() {}
  
  public boolean handleMessageImp(Message paramMessage)
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBackPressed()
  {
    super.doOnBackPressed(this.mAppInterface);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onCreate");
    }
    if ((this.mIntent != null) && (this.mIntent.getBooleanExtra("window_no_title", true))) {
      this.mInActivity.requestWindowFeature(1);
    }
    if ((this.bNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.mInActivity.getWindow().addFlags(67108864);
      int i = this.mInActivity.getResources().getColor(2131101315);
      this.mSystemBarComp = new SystemBarCompact(this.mInActivity, true, i);
      this.mSystemBarComp.init();
    }
    super.doOnCreate(this.mIntent);
  }
  
  public void onDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void onImmersive(boolean paramBoolean, bays parambays)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onImmersive");
    }
    if (paramBoolean)
    {
      if (this.mSystemBarComp != null) {
        this.mSystemBarComp.setgetStatusBarVisible(false, 0);
      }
      parambays.b.getBackground().setAlpha(0);
      return;
    }
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setgetStatusBarVisible(true, 0);
    }
    parambays.b.setBackgroundResource(2130848801);
    this.mTitleBar.a(255, 0);
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause()
  {
    super.doOnPause();
  }
  
  @TargetApi(14)
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onResume");
    }
    super.doOnResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStop() {}
  
  public void onWebViewReady()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "onWebViewReady");
    }
    if (this.mIntent != null)
    {
      String str = this.mIntent.getStringExtra("url");
      if (!TextUtils.isEmpty(str)) {
        this.mWebview.loadUrl(str);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public final void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
  
  public void setContentViewShow(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.contentContainer;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  protected final void setTittlebarImmersive(boolean paramBoolean, bays parambays)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBaseBuilder", 2, "setTittlebarImmersive");
    }
    adjustLayout(paramBoolean, parambays);
    onImmersive(paramBoolean, parambays);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bayq
 * JD-Core Version:    0.7.0.1
 */