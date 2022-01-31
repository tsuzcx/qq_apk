import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.3;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.6;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import org.json.JSONArray;

public class beim
  extends behq
  implements Handler.Callback, AdapterView.OnItemClickListener, szy
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  public Activity a;
  public Bitmap a;
  public Handler a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  public WebViewFragment a;
  public String a;
  private sdq jdField_a_of_type_Sdq;
  szw jdField_a_of_type_Szw = null;
  public boolean a;
  int b;
  public String b;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  private final String jdField_c_of_type_JavaLangString = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=";
  boolean jdField_c_of_type_Boolean = false;
  
  public beim()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new bhtd(Looper.getMainLooper(), this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Sdq = new sdq(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Sdq.a(this);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a();
    }
    String str = ((Intent)localObject).getStringExtra("url");
    if (str == null)
    {
      str = ((Intent)localObject).getStringExtra("key_params_qq");
      localObject = str;
      if (str != null) {}
    }
    for (localObject = "";; localObject = str)
    {
      this.jdField_a_of_type_Sdq.a((String)localObject);
      return;
    }
  }
  
  View a()
  {
    Object localObject = (bejh)this.jdField_a_of_type_Behr.a().a(2);
    if ((((bejh)localObject).a.jdField_a_of_type_Boolean) || (((bejh)localObject).a.jdField_b_of_type_Boolean)) {}
    for (int i = 2131363457;; i = 2131378043)
    {
      View localView = this.jdField_a_of_type_AndroidAppActivity.findViewById(i);
      localObject = localView;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        localObject = localView;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bejh != null)
        {
          localObject = localView;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bejh.d != null) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
          }
        }
      }
      return localObject;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Sdq.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Szw != null)
    {
      this.jdField_a_of_type_Szw.a();
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        View localView = a();
        if (localView != null) {
          localView.setDrawingCacheEnabled(false);
        }
      }
      this.jdField_a_of_type_Szw = null;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "unregisterScreenshotObserver!");
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          a();
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          }
        } while (this.jdField_a_of_type_Sdq == null);
        this.jdField_a_of_type_Sdq.a();
        return;
      } while (!a());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "ScreenshotResume!");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SwiftBrowserScreenShotHandler.1(this), 1000L);
      return;
      if ((this.jdField_a_of_type_Sdq != null) && (this.jdField_a_of_type_Sdq.a() != null)) {
        this.jdField_a_of_type_Sdq.a().onConfigurationChanged();
      }
      paramInt = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
    } while (this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView == null);
    if (paramInt < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
  
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->fromType:" + paramInt);
    }
    if ((!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) || (!((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->activity is not resume!");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->begin time:" + System.currentTimeMillis());
    }
    paramString = "";
    if (this.jdField_a_of_type_Sdq != null) {
      paramUri = this.jdField_a_of_type_Sdq.c();
    }
    int i;
    for (;;)
    {
      paramUri = Uri.parse(paramUri);
      try
      {
        paramUri = paramUri.getQueryParameter("article_id");
        paramString = paramUri;
        if (paramUri == null) {
          paramString = "";
        }
        azqs.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A69", "0X8006A69", 0, 0, "", paramString, "", "");
        nrt.a("0X8006A69", "", "", paramString, "", "");
        if (QLog.isDevelopLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->after report time:" + System.currentTimeMillis());
        }
        paramUri = a();
        if (paramUri == null)
        {
          QLog.e("SwiftBrowserScreenShotHandler", 1, "onDetectScreenshot error, root = null");
          return;
          paramUri = "";
        }
      }
      catch (Exception paramUri)
      {
        for (;;)
        {
          paramUri.printStackTrace();
          paramUri = paramString;
        }
        paramUri.buildDrawingCache();
        paramString = paramUri.getDrawingCache();
        if (QLog.isDevelopLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->get screenshot time:" + System.currentTimeMillis());
        }
        i = BaseApplicationImpl.getContext().getResources().getConfiguration().orientation;
        if (paramString == null) {
          break label482;
        }
      }
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8))) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = sdp.a(this.jdField_a_of_type_AndroidAppActivity.getWindow(), paramString);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (this.jdField_a_of_type_Sdq != null) {
        this.jdField_a_of_type_Sdq.a(paramInt);
      }
      if (paramInt != 1) {
        break label487;
      }
      this.jdField_a_of_type_Boolean = true;
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.arg1 = i;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->send msg_show_pad time:" + System.currentTimeMillis());
      }
    }
    for (;;)
    {
      ThreadManager.executeOnFileThread(new SwiftBrowserScreenShotHandler.3(this, paramInt));
      paramString.recycle();
      label482:
      paramUri.destroyDrawingCache();
      return;
      label487:
      if (paramInt == 2) {
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695751, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Sdq != null) {
      this.jdField_a_of_type_Sdq.a(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_Sdq != null) {
      this.jdField_a_of_type_Sdq.a(paramString1, paramString2, paramInt);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare->imgUrl:" + paramString + ", isGif:" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    localObject = ((CookieManager)localObject).getCookie(paramString);
    if (localObject != null) {
      localBundle.putString("Cookie", (String)localObject);
    }
    this.jdField_a_of_type_Sdq.a().show();
    this.jdField_b_of_type_JavaLangString = paramString;
    ThreadManager.executeOnSubThread(new SwiftBrowserScreenShotHandler.6(this, paramString, localBundle, paramBoolean));
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_Sdq != null) {
      this.jdField_a_of_type_Sdq.a(paramJSONArray);
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin isShow:" + paramBoolean + ", orientation:" + paramInt);
    }
    if (paramBoolean) {
      if (!this.jdField_c_of_type_Boolean) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag() instanceof Integer)))
          {
            int i = ((Integer)this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag()).intValue();
            if (i != paramInt)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->orientation change old:" + i + ", new:" + paramInt);
              }
              localObject = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363457);
              if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bejh != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bejh.d != null)) {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bejh.d.findViewById(2131363457);
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              ((RelativeLayout)localObject).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
              this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad create time:" + System.currentTimeMillis());
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559498, null));
            localObject = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363457);
            if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bejh != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bejh.d != null)) {
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bejh.d.findViewById(2131363457);
            }
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(12);
            localLayoutParams.setMargins(0, 0, aepi.a(10.0F, BaseApplicationImpl.getContext().getResources()), aepi.a(65.0F, BaseApplicationImpl.getContext().getResources()));
            ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(Integer.valueOf(paramInt));
            if (paramInt == 2)
            {
              localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376189).getLayoutParams();
              ((LinearLayout.LayoutParams)localObject).width = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297436);
              ((LinearLayout.LayoutParams)localObject).height = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297437);
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376189).setOnClickListener(new beio(this));
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation() != null)
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().cancel();
            this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
          }
          ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376189)).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        } while (!QLog.isDevelopLevel());
        QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad visible time:" + System.currentTimeMillis());
        return;
        if (QLog.isDevelopLevel())
        {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainer:" + this.jdField_a_of_type_AndroidWidgetLinearLayout);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainerVisibility:" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility());
          }
        }
      } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0));
      Object localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(300L);
      ((AlphaAnimation)localObject).setAnimationListener(new beip(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    } while (!QLog.isDevelopLevel());
    QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad gone time:" + System.currentTimeMillis());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Szw != null;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Behr.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Behr.a();
    c();
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_Szw == null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Object localObject = new DisplayMetrics();
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_b_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
      this.jdField_c_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
      this.jdField_a_of_type_Float = ((DisplayMetrics)localObject).density;
      this.jdField_a_of_type_Szw = new szw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Szw.a(this);
      localObject = a();
      if (localObject != null)
      {
        ((View)localObject).setDrawingCacheEnabled(true);
        ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new bein(this, (View)localObject));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "registerScreenshotObserver->mScreenWidth:" + this.jdField_b_of_type_Int + ", mScreenHeight:" + this.jdField_c_of_type_Int + ", mScreenDensity:" + this.jdField_a_of_type_Float);
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Sdq != null)) {
      this.jdField_a_of_type_Sdq.c(paramString.replace("|", "｜"));
    }
    while ((this.jdField_a_of_type_Sdq == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_Sdq.b())) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    this.jdField_a_of_type_Sdq.c(BaseApplicationImpl.getContext().getResources().getString(2131695749));
  }
  
  public void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Sdq != null)) {
      this.jdField_a_of_type_Sdq.c(paramString.replace("|", "｜"));
    }
  }
  
  public void d(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Sdq != null)) {
      this.jdField_a_of_type_Sdq.b(paramString);
    }
  }
  
  public void e(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Sdq != null)) {
      this.jdField_a_of_type_Sdq.e(paramString);
    }
  }
  
  public void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ybk.a(1, 2131695754);
      return;
    }
    paramString = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString, true, true, true, true, true, 4);
    paramString.putExtra("EditPicType", this.jdField_a_of_type_Sdq.b());
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_show_pad time:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      a(true, paramMessage.arg1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_hide_pad time:" + System.currentTimeMillis());
      }
      a(false, 0);
      continue;
      f(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->begin!");
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->tag null!");
      }
    }
    do
    {
      do
      {
        return;
        paramInt = ((bdmy)paramAdapterView).a.action;
      } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null);
      str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().getUrl();
      paramAdapterView = "";
      paramView = Uri.parse(str);
      try
      {
        paramView = paramView.getQueryParameter("article_id");
        paramAdapterView = paramView;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
        }
        azqs.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1001", paramView, "", "");
        nrt.a("0X8006A1F", "", "1001", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action friend!");
        continue;
        azqs.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1002", paramView, "", "");
        nrt.a("0X8006A1F", "", "1002", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action qzone!");
        continue;
        azqs.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1003", paramView, "", "");
        nrt.a("0X8006A1F", "", "1003", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat!");
        continue;
        azqs.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1004", paramView, "", "");
        nrt.a("0X8006A1F", "", "1004", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat circle!");
        continue;
        nrt.a(null, "", "0X800787A", "0X800787A", 0, 0, paramView, str, "", "");
        azqs.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1005", paramView, "", "");
        nrt.a("0X8006A1F", "", "1005", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action sina weibo!");
        continue;
      }
      paramView = paramAdapterView;
      if (paramAdapterView == null) {
        paramView = "";
      }
      switch (paramInt)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->end!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beim
 * JD-Core Version:    0.7.0.1
 */