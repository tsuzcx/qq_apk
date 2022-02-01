import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin.1;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.ResultInfo;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenIdentify;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenStart;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aurh
  extends WebViewPlugin
  implements Handler.Callback, View.OnClickListener, aurw, EIPCResultCallback
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TogetherBusinessServlet.RspOpenIdentify jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify;
  private TogetherBusinessServlet.RspOpenStart jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  
  public aurh()
  {
    this.mPluginNameSpace = "together_business";
    aurt.a().a(this);
    try
    {
      QIPCClientHelper.getInstance().register(aury.a());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TogetherBusinessForWebPlugin", 1, new Object[] { "register WatchTogetherClientIPCModule ipc module error.", localException.getMessage() });
    }
  }
  
  private Intent a()
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
      return null;
    }
    return this.mRuntime.a().getIntent();
  }
  
  private Bundle a(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("uinType", -1);
    if (j == -1) {
      j = paramIntent.getIntExtra("curtype", -1);
    }
    for (;;)
    {
      int i;
      switch (j)
      {
      default: 
        paramIntent = null;
        i = -1;
        if ((TextUtils.isEmpty(paramIntent)) || (i == -1)) {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "curType or uin is error: uinType=" + j + " chatId=" + paramIntent);
          }
        }
        break;
      }
      for (;;)
      {
        return null;
        paramIntent = paramIntent.getStringExtra("friend_uin");
        i = 2;
        break;
        i = 1;
        paramIntent = paramIntent.getStringExtra("groupUin");
        break;
        try
        {
          l = Long.parseLong(paramIntent);
          if (l != -1L)
          {
            a(l, i, paramString1, paramString2, paramString3);
            paramIntent = new Bundle();
            paramIntent.putString("req_data", paramString1);
            paramIntent.putString("req_sign", paramString2);
            paramIntent.putInt("session_type", i);
            paramIntent.putLong("uin", l);
            paramIntent.putString("appid", paramString3);
            return paramIntent;
          }
        }
        catch (NumberFormatException paramIntent)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherBusinessForWebPlugin", 2, "uin string to long error");
            }
            long l = -1L;
          }
        }
      }
    }
  }
  
  private Bundle a(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    Object localObject;
    String str;
    Intent localIntent;
    for (;;)
    {
      return null;
      try
      {
        localObject = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject).optString("req_data");
        localObject = ((JSONObject)localObject).optString("req_sign");
        if (((TextUtils.isEmpty(paramVarArgs)) || (TextUtils.isEmpty((CharSequence)localObject))) && (QLog.isColorLevel())) {
          QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam param error" + " data=" + paramVarArgs + " sign=" + (String)localObject);
        }
        str = new JSONObject(paramVarArgs).optString("appid");
        localIntent = a();
        if (localIntent == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam intent is null");
          return null;
        }
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return null;
      }
    }
    paramVarArgs = a(paramVarArgs, (String)localObject, str, localIntent);
    return paramVarArgs;
  }
  
  private String a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "getCloseTogetherRoomCallBack isShow=" + paramBoolean);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("close_room", paramBoolean);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TogetherBusinessForWebPlugin", 4, "getCloseTogetherRoomCallBack:", localJSONException);
        }
      }
    }
  }
  
  private String a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "getShowButtonCallBack isShow=" + paramBoolean + " text=" + paramString);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("is_show_button", paramBoolean);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("button_text", paramString);
      }
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private JSONObject a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "quitOrCloseMsg type=" + paramInt);
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("type", paramInt);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private void a(int paramInt, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.a(localBaseApplication, paramInt, paramString, 1).b(localBaseApplication.getResources().getDimensionPixelSize(2131299076));
  }
  
  private void a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  private void a(String paramString)
  {
    WatchTogetherFloatingData localWatchTogetherFloatingData;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.optString("uin");
        String str2 = paramString.optString("url");
        int i = paramString.optInt("aio_type");
        bool = paramString.optBoolean("author");
        double d1 = paramString.optDouble("video_width", 0.0D);
        double d2 = paramString.optDouble("video_height", 0.0D);
        String str3 = paramString.optString("callback", "");
        String str4 = paramString.optString("from", "watchroom");
        localWatchTogetherFloatingData = new WatchTogetherFloatingData();
        localWatchTogetherFloatingData.setSmallUrl(str2);
        localWatchTogetherFloatingData.setCurUin(str1);
        localWatchTogetherFloatingData.setCurType(i);
        localWatchTogetherFloatingData.setIsAdm(bool);
        localWatchTogetherFloatingData.setFrom(str4);
        Object localObject = "";
        if ((this.mRuntime != null) && (this.mRuntime.a() != null))
        {
          paramString = this.mRuntime.a().getCurrentUrl();
          localWatchTogetherFloatingData.setBigUrl(paramString);
          if ((d1 > 0.0D) && (d2 > 0.0D))
          {
            localWatchTogetherFloatingData.setVideoWidth(d1);
            localWatchTogetherFloatingData.setVideoHeight(d2);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("SHOW_FLOATING_WINDOW ");
            ((StringBuilder)localObject).append("uin=").append(str1).append(" roomUrl=").append(str2).append(" sessionType=").append(i).append(" author=").append(bool).append(" videoWidth").append(d1).append(" videoHeight=").append(d2).append(" methodName=").append(str3).append(" bigUrl").append(paramString).append(" from=").append(str4);
            QLog.d("TogetherBusinessForWebPlugin", 2, ((StringBuilder)localObject).toString());
          }
          if (!"watchroom".equals(str4)) {
            break;
          }
          if ((this.jdField_b_of_type_Boolean) && (!FloatingScreenPermission.checkPermission(BaseApplication.getContext())))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherBusinessForWebPlugin", 2, "SHOW_FLOATING_WINDOW no permission");
            }
            callJs(str3, new String[] { a(true) });
          }
        }
        else
        {
          paramString = (String)localObject;
          if (this.mRuntime == null) {
            continue;
          }
          paramString = (String)localObject;
          if (this.mRuntime.a() == null) {
            continue;
          }
          paramString = this.mRuntime.a().getUrl();
          continue;
        }
        i = aurt.a().a(BaseApplication.getContext(), localWatchTogetherFloatingData);
        if (i == 1)
        {
          bool = true;
          this.jdField_b_of_type_Boolean = bool;
          if (i != 1) {
            callJs(str3, new String[] { "" });
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("TogetherBusinessForWebPlugin", 2, "SHOW_FLOATING_WINDOW resultCode=" + i);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool = false;
    }
    aurt.a().a(localWatchTogetherFloatingData);
  }
  
  private void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
      return;
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.mRuntime.a(), 2131755826);
    localQQCustomDialog.setContentView(2131559016);
    if (!TextUtils.isEmpty(paramString1)) {
      localQQCustomDialog.setTitle(paramString1);
    }
    for (;;)
    {
      localQQCustomDialog.setMessage(paramString2);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.setNegativeButton(this.mRuntime.a().getString(2131690600), new aurj(this, localQQCustomDialog));
      localQQCustomDialog.setPositiveButton(this.mRuntime.a().getString(2131690602), paramOnClickListener);
      localQQCustomDialog.show();
      return;
      localQQCustomDialog.setTitle(null);
    }
  }
  
  private void a(String... paramVarArgs)
  {
    try
    {
      this.d = new JSONObject(paramVarArgs[0]).optString("callback", "");
      return;
    }
    catch (JSONException paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherBusinessForWebPlugin", 2, paramVarArgs, new Object[0]);
      return;
    }
    catch (Throwable paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherBusinessForWebPlugin", 2, paramVarArgs, new Object[0]);
    }
  }
  
  private boolean a()
  {
    if (!NetworkUtil.isNetSupport(null))
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      localMessage.obj = "当前网络不可用，请检查网络设置。";
      localMessage.arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button network not well");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(Bundle paramBundle)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.confirmText))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button confirmText is empty");
      }
      return false;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = new aurk(this, null, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.confirmText, new auri(this, paramBundle));
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    return true;
  }
  
  private boolean a(TogetherBusinessServlet.ResultInfo paramResultInfo)
  {
    if ((paramResultInfo == null) || (!paramResultInfo.showErrorMsg)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button resultInfo is empty or no need showErrorMsg");
      }
    }
    do
    {
      return false;
      if (!TextUtils.isEmpty(paramResultInfo.errorMsg)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button errorMsg is empty");
    return false;
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = paramResultInfo.errorMsg;
    localMessage.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    return true;
  }
  
  private boolean a(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return true;
    }
    try
    {
      boolean bool = new JSONObject(paramVarArgs[0]).optBoolean("draw_button_by_qq", true);
      return bool;
    }
    catch (JSONException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return true;
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(paramString);
      }
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.mRuntime.a() != null)
    {
      localObject1 = (ViewGroup)LayoutInflater.from(this.mRuntime.a()).inflate(2131559962, null);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      if (this.mRuntime.a().mUIStyleHandler.mRootView != null) {
        this.mRuntime.a().mUIStyleHandler.mRootView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.mRuntime.a().findViewById(2131373088));
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131166984));
      localObject1 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = AIOUtils.dp2px(75.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.mRuntime.a().findViewById(2131365665)).setVisibility(8);
      localObject1 = (ViewGroup)this.mRuntime.a().findViewById(2131363636);
      int i = AIOUtils.dp2px(16.0F, ((ViewGroup)localObject1).getResources());
      ((ViewGroup)localObject1).setPadding(i, 0, i, 0);
      localObject2 = new Button(this.mRuntime.a());
      ((Button)localObject2).setText(paramString);
      ((Button)localObject2).setGravity(17);
      ((Button)localObject2).setTextColor(this.mRuntime.a().getResources().getColor(2131167045));
      ((Button)localObject2).setBackground(this.mRuntime.a().getDrawable(2130839326));
      ((Button)localObject2).setTextSize(1, 17.0F);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramString = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(45.0F, this.jdField_a_of_type_AndroidViewView.getResources()));
      paramString.addRule(15);
      ((ViewGroup)localObject1).addView((View)localObject2, paramString);
      return;
      localObject1 = ((ViewStub)this.mRuntime.a().findViewById(2131372164)).inflate();
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = -2;
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("closeOrQuitBusiness ");
      localStringBuilder.append("type=").append(paramInt);
      QLog.d("TogetherBusinessForWebPlugin", 2, localStringBuilder.toString());
    }
    dispatchJsEvent("close_business", a(paramInt), null);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("playOrPauseVideo ");
      localStringBuilder.append("type=").append(paramInt);
      QLog.d("TogetherBusinessForWebPlugin", 2, localStringBuilder.toString());
    }
    dispatchJsEvent("play_control", a(paramInt), null);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934595L) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("ti.qq.com/sportslive/mini/room")))
    {
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder().append("handleEvent type =");
        if (paramLong != 8589934595L) {
          break label82;
        }
      }
      label82:
      for (paramString = "load_error";; paramString = "http_error")
      {
        QLog.d("TogetherBusinessForWebPlugin", 2, paramString);
        aurt.a().b(2);
        return true;
      }
    }
    if (paramLong == 8589934623L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "handleEvent type =init_webview_complete");
      }
      aurt.a().c();
      return true;
    }
    if ((paramLong == 8589934600L) && (paramMap != null))
    {
      if ((paramMap.get("requestCode") == null) || (!(paramMap.get("requestCode") instanceof Integer))) {
        return false;
      }
      Integer localInteger = (Integer)paramMap.get("requestCode");
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "handleEvent type =on activityResult requestCode=" + localInteger);
      }
      if (localInteger.intValue() == 200)
      {
        aurt.a().a(null);
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "Call TogetherBusinessForWebPlugin handleJsRequest, url=" + paramString1 + " pkgName=" + paramString2 + " method=" + paramString3);
    }
    if ("together_business".equals(paramString2))
    {
      if ("show_together_button".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherBusinessForWebPlugin", 2, "call show_together_button");
        }
        a(-1L, -1, null, null, null);
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify = null;
        paramJsBridgeListener = a(paramVarArgs);
        a(paramVarArgs);
        if (paramJsBridgeListener != null)
        {
          this.jdField_a_of_type_Boolean = a(paramVarArgs);
          QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_identify", paramJsBridgeListener, this);
        }
      }
      for (;;)
      {
        return true;
        if ("click_together_button".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button mRspOpenIdentify=" + this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify);
          }
          this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart = null;
          a(-1L, -1, null, null, null);
          paramString1 = a(paramVarArgs);
          if ((paramString1 == null) || (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify == null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button bundle or mRspOpenIdentify is null");
            }
            return true;
          }
          paramString1.putInt("business_type", this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType);
          if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType == 2) {
            if (this.jdField_a_of_type_Int != 2) {
              break label344;
            }
          }
          label344:
          for (paramJsBridgeListener = "c2c_AIO";; paramJsBridgeListener = "Grp_AIO")
          {
            bcef.b(null, "dc00899", paramJsBridgeListener, "", "video_tab", "clk_share_grp", 0, 0, this.jdField_a_of_type_Long + "", this.c, "", "");
            if (!a()) {
              break;
            }
            return true;
          }
          if (a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.resultInfo)) {
            return true;
          }
          if (a(paramString1)) {
            return true;
          }
          QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", paramString1, this);
        }
        else if ("dispear_together_button".equals(paramString3))
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
        else if ("show_floating_window".equals(paramString3))
        {
          a(paramVarArgs[0]);
        }
        else
        {
          int i;
          if ("close_floating_window".equals(paramString3)) {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString1.optString("uin");
              i = paramString1.optInt("aio_type");
              paramString1 = new WatchTogetherFloatingData();
              paramString1.setCurUin(paramJsBridgeListener);
              paramString1.setCurType(i);
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder("CLOSE_FLOATING_WINDOW ");
                paramString1.append("uin=").append(paramJsBridgeListener).append(" sessionType=").append(i);
                QLog.d("TogetherBusinessForWebPlugin", 2, paramString1.toString());
              }
              paramJsBridgeListener = new TogetherBusinessForWebPlugin.1(this);
              ThreadManager.getUIHandlerV2().postDelayed(paramJsBridgeListener, 500L);
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          } else if ("loading_status_notify".equals(paramString3)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              i = paramJsBridgeListener.optInt("status");
              double d1 = paramJsBridgeListener.optDouble("video_width", 0.0D);
              double d2 = paramJsBridgeListener.optDouble("video_height", 0.0D);
              if (QLog.isColorLevel())
              {
                paramJsBridgeListener = new StringBuilder("LOAD_STATUS_NOTIFY ");
                paramJsBridgeListener.append("videoWidth=").append(d1).append(" videoHeight=").append(d2).append(" status=").append(i);
                QLog.d("TogetherBusinessForWebPlugin", 2, paramJsBridgeListener.toString());
              }
              aurt.a().a(d1, d2);
              aurt.a().b(i);
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      String str = (String)paramMessage.obj;
      a(paramMessage.arg1, str);
      return true;
    }
    if (paramMessage.what == 2)
    {
      paramMessage = (aurk)paramMessage.obj;
      a(paramMessage.jdField_a_of_type_JavaLangString, paramMessage.jdField_b_of_type_JavaLangString, paramMessage.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    }
    if (paramMessage.what == 3)
    {
      b((String)paramMessage.obj);
      return true;
    }
    if (paramMessage.what == 4)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      return true;
    }
    return false;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult.code != 0) || (paramEIPCResult.data == null)) {}
    label53:
    do
    {
      do
      {
        return;
        Serializable localSerializable = paramEIPCResult.data.getSerializable("QQAIOMediaSvc.open_identify");
        if (localSerializable != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify = ((TogetherBusinessServlet.RspOpenIdentify)localSerializable);
          boolean bool;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.buttonText))
          {
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("TogetherBusinessForWebPlugin", 2, "callback from CMD_OPEN_IDENTIFY isShowButton=" + bool + " mDrawButtonByQQ=" + this.jdField_a_of_type_Boolean);
            }
            if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType == 2)) {
              if (this.jdField_a_of_type_Int != 2) {
                break label262;
              }
            }
          }
          for (paramEIPCResult = "c2c_AIO";; paramEIPCResult = "Grp_AIO")
          {
            bcef.b(null, "dc00899", paramEIPCResult, "", "video_tab", "exp_share_grp", 0, 0, this.jdField_a_of_type_Long + "", this.c, "", "");
            paramEIPCResult = a(bool, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.buttonText);
            if (!TextUtils.isEmpty(this.d)) {
              callJs(this.d, new String[] { paramEIPCResult });
            }
            if ((!bool) || (!this.jdField_a_of_type_Boolean)) {
              break;
            }
            paramEIPCResult = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
            paramEIPCResult.obj = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.buttonText;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramEIPCResult);
            return;
            bool = false;
            break label53;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("TogetherBusinessForWebPlugin", 2, "callback from CMD_OPEN_START ");
        }
        paramEIPCResult = paramEIPCResult.data.getSerializable("QQAIOMediaSvc.open_start");
      } while (paramEIPCResult == null);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart = ((TogetherBusinessServlet.RspOpenStart)paramEIPCResult);
    } while (!a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart.resultInfo));
    label262:
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart = null;
    Object localObject = a();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam intent is null");
      }
    }
    Bundle localBundle;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localBundle = a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, (Intent)localObject);
      if ((localBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify != null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button bundle or mRspOpenIdentify is null");
      }
    }
    localBundle.putInt("business_type", this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType == 2) {
      if (this.jdField_a_of_type_Int != 2) {
        break label218;
      }
    }
    label218:
    for (localObject = "c2c_AIO";; localObject = "Grp_AIO")
    {
      bcef.b(null, "dc00899", (String)localObject, "", "video_tab", "clk_share_grp", 0, 0, this.jdField_a_of_type_Long + "", this.c, "", "");
      if ((a()) || (a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.resultInfo)) || (a(localBundle))) {
        break;
      }
      QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", localBundle, this);
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    aurt.a().b(this);
    QIPCClientHelper.getInstance().getClient().unRegisterModule(aury.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurh
 * JD-Core Version:    0.7.0.1
 */