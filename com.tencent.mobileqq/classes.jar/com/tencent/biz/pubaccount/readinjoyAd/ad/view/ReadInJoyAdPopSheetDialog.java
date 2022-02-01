package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdPopSheetDialog;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdPopSheetDialog.OnPopSheetDismissListener;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyAdPopSheetDialog
  extends IRIJAdPopSheetDialog
  implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener
{
  private static final String a = "com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog";
  private String b;
  private String c;
  private String d;
  private TouchWebView e;
  private GdtWebViewBuilder f;
  private WebViewProgressBar g;
  private WebViewProgressBarController h;
  private RelativeLayout i;
  private Activity j;
  private IRIJAdPopSheetDialog.OnPopSheetDismissListener k;
  private long l = 0L;
  private long m = 0L;
  private SoftKeyboardStateHelper n;
  private RelativeLayout o;
  private long p = -1L;
  
  public ReadInJoyAdPopSheetDialog(Activity paramActivity)
  {
    super(paramActivity, 2131953338);
    c();
    this.j = paramActivity;
  }
  
  public ReadInJoyAdPopSheetDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    this(paramActivity);
    if (paramString1 != null)
    {
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramString3;
    }
    this.m = SystemClock.currentThreadTimeMillis();
  }
  
  public static ReadInJoyAdPopSheetDialog a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    return new ReadInJoyAdPopSheetDialog(paramActivity, paramString1, paramString2, paramString3);
  }
  
  private void a(Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.e = new TouchWebView(paramActivity);
    this.i.removeAllViews();
    this.i.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
    this.i.setVisibility(0);
    this.f = new ReadInJoyAdPopSheetDialog.7(this, paramActivity.getApplicationContext(), paramActivity, null, localAppInterface);
    this.f.a(this.e);
    new WebViewDirector(this.f).a(null, localAppInterface, null);
  }
  
  private void b()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append("&acttype=9000&rsptype=1");
      localObject1 = ((StringBuilder)localObject1).toString();
      long l1 = SystemClock.currentThreadTimeMillis();
      localObject2 = "";
      localObject3 = new Bundle();
      localObject1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), (String)localObject1, "GET", null, (Bundle)localObject3);
      if (localObject1 != null)
      {
        localObject1 = new String((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d(a, 1, new Object[] { "loadForm result = ", localObject1 });
        }
        localObject1 = new JSONObject((String)localObject1);
        int i1 = ((JSONObject)localObject1).getInt("ret");
        if (i1 == 0)
        {
          localObject3 = ((JSONObject)localObject1).getJSONObject("data");
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject2 = ((JSONObject)localObject3).optString("clickid");
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = a;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("loadForm clickid = ");
              ((StringBuilder)localObject3).append((String)localObject2);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
              localObject1 = localObject2;
            }
          }
        }
        else
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = a;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("retCode = ");
            ((StringBuilder)localObject3).append(i1);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d(a, 1, new Object[] { Integer.valueOf(2), "requestAdData bytes null" });
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.d;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("loadForm: get click id costTime=");
        ((StringBuilder)localObject3).append(SystemClock.currentThreadTimeMillis() - l1);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("&click_id=");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
      ThreadManager.getUIHandler().post(new ReadInJoyAdPopSheetDialog.3(this, (String)localObject1));
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("loadForm exception:");
        ((StringBuilder)localObject3).append(localException.getMessage());
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
  }
  
  private void c()
  {
    View localView = getLayoutInflater().inflate(2131626114, null);
    ((RelativeLayout)localView.findViewById(2131440507)).setOnClickListener(new ReadInJoyAdPopSheetDialog.4(this));
    localView.setOnClickListener(new ReadInJoyAdPopSheetDialog.5(this));
    this.g = ((WebViewProgressBar)localView.findViewById(2131440738));
    this.h = new WebViewProgressBarController();
    this.h.a(this.g);
    this.g.setController(this.h);
    this.i = ((RelativeLayout)localView.findViewById(2131440510));
    this.n = new SoftKeyboardStateHelper(localView);
    this.o = ((RelativeLayout)localView.findViewById(2131440508));
    Object localObject = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
    this.p = System.currentTimeMillis();
    this.n.a(new ReadInJoyAdPopSheetDialog.6(this, (RelativeLayout.LayoutParams)localObject));
    setOnDismissListener(this);
    setOnShowListener(this);
    localObject = BaseApplicationImpl.getContext();
    int i1 = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
    int i2 = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
    double d1 = i1;
    Double.isNaN(d1);
    int i3 = (int)(d1 * 0.85D);
    localObject = (RelativeLayout)localView.findViewById(2131440508);
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = i3;
      ((ViewGroup.LayoutParams)localObject).height = i3;
    }
    setContentView(localView);
    getWindow().setLayout(i1, i2);
  }
  
  public void a(IRIJAdPopSheetDialog.OnPopSheetDismissListener paramOnPopSheetDismissListener)
  {
    this.k = paramOnPopSheetDismissListener;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel())
    {
      paramDialogInterface = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDismiss h5Url = ");
      localStringBuilder.append(this.b);
      QLog.d(paramDialogInterface, 2, localStringBuilder.toString());
    }
    paramDialogInterface = this.f;
    if (paramDialogInterface != null)
    {
      paramDialogInterface.c();
      this.f = null;
    }
    paramDialogInterface = this.k;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel())
    {
      paramDialogInterface = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow h5Url = ");
      localStringBuilder.append(this.b);
      QLog.d(paramDialogInterface, 2, localStringBuilder.toString());
    }
    paramDialogInterface = this.g;
    if (paramDialogInterface != null) {
      paramDialogInterface.setVisibility(0);
    }
    paramDialogInterface = this.h;
    if (paramDialogInterface != null) {
      paramDialogInterface.a((byte)0);
    }
    paramDialogInterface = this.i;
    if (paramDialogInterface != null) {
      paramDialogInterface.setVisibility(4);
    }
    ThreadManager.excute(new ReadInJoyAdPopSheetDialog.2(this), 128, null, true);
  }
  
  public void show()
  {
    getWindow().setFlags(8, 8);
    super.show();
    getWindow().getDecorView().setSystemUiVisibility(2);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ReadInJoyAdPopSheetDialog.1(this));
    getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog
 * JD-Core Version:    0.7.0.1
 */