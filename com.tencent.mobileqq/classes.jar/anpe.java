import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.CmshowAppController.3;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.CmshowAppController.4;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.CmshowAppController.5;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloKapuEntranceTips;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.wadl.ipc.WadlResult;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class anpe
  extends bhyn
  implements View.OnClickListener, bjrc
{
  private float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int = 0;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private bjra jdField_a_of_type_Bjra = new bjra();
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private ApolloKapuEntranceTips jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  private int c;
  
  public anpe(ApolloPanel paramApolloPanel)
  {
    this.jdField_a_of_type_Bjra.a(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(paramApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, paramApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.fromNetworkWithCacheBitmap(ApolloPanel.a(paramApolloPanel), amms.d, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/kapu/apollo_kapu_progress_lottie.zip", false);
  }
  
  private Drawable a()
  {
    Object localObject = amms.c;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getResources().getDrawable(2130838510);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getResources().getDrawable(2130838510);
    localObject = anev.a("" + ((String)localObject).hashCode(), localURLDrawableOptions, (String)localObject, false);
    if (localObject != null) {
      ((URLDrawable)localObject).startDownload();
    }
    return localObject;
  }
  
  private JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", amms.g);
      localJSONObject.put("iconUrl", amms.c);
      localJSONObject.put("apkUrl", amms.jdField_b_of_type_JavaLangString);
      localJSONObject.put("packageName", amms.jdField_a_of_type_JavaLangString);
      localJSONObject.put("versionCode", amms.jdField_a_of_type_Int);
      localJSONObject.put("apkSign", amms.h);
      localJSONObject.put("appName", amms.i);
      localJSONObject.put("sourceId", "biz_src_zf_lmx");
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QLog.e("CmshowAppController", 1, localException, new Object[0]);
    }
    return null;
  }
  
  private void a(float paramFloat)
  {
    ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel).post(new ApolloPanel.CmshowAppController.3(this, paramFloat));
  }
  
  private boolean a()
  {
    boolean bool = true;
    Object localObject = amms.jdField_b_of_type_JavaLangString;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (TextUtils.isEmpty((CharSequence)localObject))) {
      bool = false;
    }
    do
    {
      return bool;
      localObject = a();
    } while (localObject == null);
    ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel, true);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bjra.a((JSONObject)localObject, 2);
      return true;
    }
    this.jdField_b_of_type_Boolean = true;
    return true;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmshowAppController", 2, "checkEntranceTips");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {}
    for (;;)
    {
      return;
      ankc localankc = (ankc)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      ApolloKapuEntranceTips localApolloKapuEntranceTips;
      if (this.jdField_a_of_type_Int == 3) {
        localApolloKapuEntranceTips = localankc.a(true);
      }
      while (localApolloKapuEntranceTips != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmshowAppController", 2, new Object[] { "checkEntranceTips, tips=", localApolloKapuEntranceTips });
        }
        if (localApolloKapuEntranceTips.duration > 0L) {}
        for (int i = (int)(localApolloKapuEntranceTips.duration / 1000L);; i = 5)
        {
          ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel, ApolloPanel.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel), 49, localApolloKapuEntranceTips.text, i, this);
          localApolloKapuEntranceTips.shownCount += 1;
          localankc.a(localApolloKapuEntranceTips);
          anme.a(101, String.valueOf(localApolloKapuEntranceTips.adId), localApolloKapuEntranceTips.traceInfo);
          this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips = localApolloKapuEntranceTips;
          return;
          if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 2)) {
            break label214;
          }
          localApolloKapuEntranceTips = localankc.a(false);
          break;
        }
        label214:
        localApolloKapuEntranceTips = null;
      }
    }
  }
  
  private void g()
  {
    if (ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel).getBackground() == null) {
      ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel).setBackgroundDrawable(a());
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(this.jdField_a_of_type_Float);
      return;
    }
    ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel).endAnimation();
    ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel).setVisibility(8);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Bjra.a(a(), 5);
  }
  
  public void a()
  {
    b();
    if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel) != null)
    {
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel).removeMessages(3);
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel).sendEmptyMessageDelayed(3, 1000L);
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("CmshowAppController", 1, new Object[] { "download, downloadSrc=", Integer.valueOf(paramInt), ", mStatus=", Integer.valueOf(this.jdField_a_of_type_Int) });
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1) {}
    Context localContext;
    do
    {
      return;
      localContext = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getContext();
      if (!NetworkUtil.isNetworkAvailable(localContext))
      {
        QQToast.a(localContext, 1, localContext.getString(2131694512), 0).b(0);
        return;
      }
      if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getContext())) {
        break;
      }
      QQToast.a(localContext, localContext.getString(2131690099), 0).b(0);
    } while (!a());
    this.jdField_a_of_type_Int = 1;
    g();
    e();
    return;
    anpf localanpf = new anpf(this);
    anpg localanpg = new anpg(this, localContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("即将消耗");
    localStringBuilder.append(amms.f);
    localStringBuilder.append("流量下载厘米秀APP，当前为非WIFI网络，是否继续下载？");
    bhdj.a(localContext, 230, anvx.a(2131699975), localStringBuilder.toString(), anvx.a(2131699971), anvx.a(2131699969), localanpg, localanpf).show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt2;
    a(paramInt1);
  }
  
  public void a(int paramInt, WadlResult paramWadlResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmshowAppController", 2, new Object[] { "onTaskStatusChanged localStatus:", Integer.valueOf(paramInt), ",wadlResult:", paramWadlResult });
    }
    switch (paramInt)
    {
    default: 
    case 4: 
    case -2: 
      do
      {
        do
        {
          do
          {
            return;
            ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel, false);
          } while (this.jdField_a_of_type_Int == 2);
          this.jdField_a_of_type_Int = 2;
          ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel).post(new ApolloPanel.CmshowAppController.4(this));
          if (this.jdField_b_of_type_Int == 1)
          {
            anme.a(103, String.valueOf(amms.jdField_b_of_type_Int), amms.j, "{\"returnValue\":0}");
            return;
          }
        } while ((this.jdField_b_of_type_Int != 3) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "unlockeddownloadsuccess", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { String.valueOf(this.c) });
        return;
        ApolloPanel.c(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel, false);
        this.jdField_a_of_type_Int = 0;
        ThreadManager.getUIHandler().post(new ApolloPanel.CmshowAppController.5(this));
      } while (this.jdField_b_of_type_Int != 1);
      anme.a(103, String.valueOf(amms.jdField_b_of_type_Int), amms.j, "{\"returnValue\":1}");
      return;
    }
    this.jdField_a_of_type_Float = (paramWadlResult.d / 100.0F);
    a(this.jdField_a_of_type_Float);
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmshowAppController", 2, new Object[] { "onTaskQuery resInfos:", paramArrayList, ",mIsNeedDownload:", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bjra.a(amms.g, amms.jdField_b_of_type_JavaLangString, amms.jdField_a_of_type_Int, paramArrayList))
    {
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_b_of_type_Boolean)
      {
        a();
        this.jdField_a_of_type_Int = 1;
        this.jdField_b_of_type_Boolean = false;
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1) {
        h();
      }
      this.jdField_a_of_type_Int = 2;
    } while (!QLog.isColorLevel());
    QLog.d("CmshowAppController", 2, new Object[] { "onTaskQuery find apk already download, mStatus:", Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  void b()
  {
    d();
    g();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.destroy();
    this.jdField_a_of_type_Bjra.a();
  }
  
  void d()
  {
    if (bhfn.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getContext(), amms.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getContext().getPackageManager().getLaunchIntentForPackage(amms.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmshowAppController", 2, new Object[] { "checkStatus mStatus:", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      if (this.jdField_a_of_type_Int == 0) {}
      return;
      if (ApolloPanel.e(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel))
      {
        this.jdField_a_of_type_Int = 1;
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bjra.a(amms.g);
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return;
    }
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).d(4);
  }
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.isClick = true;
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null)) {
            ((ankc)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips);
          }
          if (paramView.getId() != 2131363825) {
            anme.a(102, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.adId), this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.traceInfo);
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_Blhb != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_Blhb.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_Blhb.dismiss();
        }
        switch (this.jdField_a_of_type_Int)
        {
        }
      }
      catch (Exception localException)
      {
        QLog.e("CmshowAppController", 2, localException, new Object[0]);
        if (this.jdField_a_of_type_Int != 3) {
          continue;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getContext(), 1, anvx.a(2131699984), 0).b(0);
        b();
        continue;
        h();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips == null) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.activityUrl);
        if (bool) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_AndroidContentIntent = new Intent("android.intent.action.VIEW");
          this.jdField_a_of_type_AndroidContentIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("url", this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.activityUrl);
          localObject = Uri.parse(String.format("cmshowidol://ui_openPage?pageName=webBrowser&data=%s", new Object[] { URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8") }));
          this.jdField_a_of_type_AndroidContentIntent.setData((Uri)localObject);
          QLog.d("CmshowAppController", 1, new Object[] { "open kapu with url=", this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.activityUrl });
          if (this.jdField_a_of_type_AndroidContentIntent != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getContext().startActivity(this.jdField_a_of_type_AndroidContentIntent);
            anme.a(102, String.valueOf(amms.jdField_b_of_type_Int), amms.j);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("CmshowAppController", 1, "parse kapu activity uri failed, e", localThrowable);
          continue;
          b();
          continue;
        }
        int i = this.jdField_a_of_type_Int;
        if (i != 2) {
          continue;
        }
        i = 2;
        continue;
        i = 1;
        continue;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getContext(), 1, anvx.a(2131699976), 0).b(0);
        continue;
        continue;
      }
      if (this.jdField_a_of_type_Int != 3) {
        continue;
      }
      i = 0;
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "aio_clickkapoo", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType()), i, new String[0]);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpe
 * JD-Core Version:    0.7.0.1
 */