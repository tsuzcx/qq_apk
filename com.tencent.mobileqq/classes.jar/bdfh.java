import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.utils.QQCustomArkDialog.3;
import com.tencent.mobileqq.utils.QQCustomArkDialog.4;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class bdfh
  extends bdgl
{
  int jdField_a_of_type_Int = 0;
  afdt jdField_a_of_type_Afdt;
  private afdw jdField_a_of_type_Afdw = new bdfi(this);
  private ArkViewImplement.LoadCallback jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback = new bdfj(this);
  ArkAppLoadLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
  ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  int b;
  int c;
  int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean;
  int g = -1;
  
  public bdfh(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  private afdt a(bdfk parambdfk, Bundle paramBundle)
  {
    this.jdField_a_of_type_Afdt = new afdt();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
    if (QLog.isDebugVersion()) {
      QLog.d("QQCustomArkDialog", 4, "w=" + i + ",h=" + j + ", appName:" + parambdfk.jdField_a_of_type_JavaLangString);
    }
    i = paramBundle.getInt("req_type");
    if (ArkFullScreenAppActivity.a(paramBundle))
    {
      this.jdField_a_of_type_Afdt.a(parambdfk.jdField_a_of_type_JavaLangString, parambdfk.b, parambdfk.c, parambdfk.d, parambdfk.jdField_a_of_type_Float, parambdfk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if ((this.jdField_e_of_type_Int == 0) || (this.jdField_f_of_type_Int == 0)) {
        break label289;
      }
      this.jdField_a_of_type_Afdt.setFixSize(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    for (;;)
    {
      anft.a = false;
      return this.jdField_a_of_type_Afdt;
      String str1 = "news";
      if (i == 2) {
        str1 = "music";
      }
      for (;;)
      {
        new ArkAppMessage.Config().fromString("\"config\":{\n        \"forward\":true,\n        \"type\":\"normal\",\n        \"autosize\":true\n    }");
        String str2 = a(paramBundle, "com.tencent.structmsg");
        paramBundle = str2;
        if (!TextUtils.isEmpty(str2)) {
          paramBundle = str2.replace("\\/", "/");
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQCustomArkDialog", 2, ",metaData=" + paramBundle);
        }
        this.jdField_a_of_type_Afdt.a("com.tencent.structmsg", str1, "0.0.0.1", paramBundle, anjs.a(), parambdfk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        break;
        if (i == 4) {
          str1 = "video";
        }
      }
      label289:
      this.jdField_a_of_type_Afdt.setFixSize(this.jdField_d_of_type_Int, this.g);
      this.jdField_a_of_type_Afdt.setMaxSize(this.jdField_d_of_type_Int, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Afdt.setMinSize(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    }
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt("req_type");
    long l = paramBundle.getLong("req_share_id");
    Object localObject = paramBundle.getString("title");
    String str3 = paramBundle.getString("desc");
    String str4 = paramBundle.getString("struct_share_key_source_url");
    String str2 = paramBundle.getString("image_url_remote");
    String str6 = paramBundle.getString("image_url");
    paramBundle.getString("res_pkg_name");
    String str1 = paramBundle.getString("audio_url");
    String str5 = paramBundle.getString("app_name");
    paramBundle = "news";
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("title", localObject);
      if (i != 2) {
        break label285;
      }
      paramBundle = "music";
      localObject = b(str1);
      localJSONObject2.put("musicUrl", localObject);
      str1 = str3;
      if (!TextUtils.isEmpty(str3))
      {
        str1 = str3;
        if (str3.contains(alpo.a(2131710575))) {
          str1 = str3.replace(alpo.a(2131710579), "");
        }
      }
      localJSONObject2.put("desc", str1);
      if (TextUtils.isEmpty(str2)) {
        break label304;
      }
      paramString = str2;
    }
    catch (Exception paramBundle)
    {
      label285:
      label304:
      for (;;)
      {
        label199:
        if (QLog.isColorLevel())
        {
          QLog.e("QQCustomArkDialog", 2, paramBundle.toString());
          continue;
          paramString = "";
        }
      }
    }
    localJSONObject2.put("preview", paramString);
    localJSONObject2.put("tag", str5);
    if (i == 2)
    {
      paramBundle = "music";
      localJSONObject2.put("musicUrl", localObject);
    }
    for (;;)
    {
      localJSONObject2.put("jumpUrl", b(str4));
      localJSONObject2.put("appid", l);
      localJSONObject2.put("app_type", 1);
      localJSONObject1.put(paramBundle, localJSONObject2);
      return localJSONObject1.toString();
      localObject = str1;
      if (i != 4) {
        break;
      }
      paramBundle = "video";
      localObject = str1;
      break;
      if (TextUtils.isEmpty(str6)) {
        break label414;
      }
      str1 = a(str6);
      paramString = ArkEnvironmentManager.getInstance().getAppResPath(paramString);
      bdcs.d(str6, paramString + File.separator + str1);
      paramString = "res:" + str1;
      break label199;
      if (i == 4) {
        paramBundle = "video";
      }
    }
  }
  
  public static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.lastIndexOf(File.separator);
      str = paramString;
    } while (i == -1);
    return paramString.substring(i + 1);
  }
  
  private void a(Bundle paramBundle)
  {
    bdfk localbdfk = new bdfk(paramBundle);
    localbdfk.jdField_a_of_type_Float = anjs.a();
    paramBundle = a(localbdfk, paramBundle);
    paramBundle.a(this.jdField_a_of_type_Afdw);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("http://")) {
        str = paramString.replace("http://", "");
      }
      paramString = str;
    } while (!str.contains("https://"));
    return str.replace("https://", "");
  }
  
  private void d(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    while ((localObject != null) && (!((Activity)localObject).isFinishing())) {
      if (paramInt != 1)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).width = this.jdField_d_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject).height = this.jdField_d_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        this.rBtn.setEnabled(false);
        this.rBtn.setTextColor(Color.parseColor("#656565"));
        return;
        localObject = null;
      }
      else
      {
        this.rBtn.setEnabled(true);
        return;
      }
    }
    QLog.d("QQCustomArkDialog", 1, "onLoadFinish.right now activity is null or finished");
  }
  
  public void a()
  {
    ((LinearLayout)findViewById(2131368344)).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Afdt == null) {
      return;
    }
    this.jdField_a_of_type_Afdt.doOnEvent(paramInt);
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
      if (QLog.isColorLevel()) {
        QLog.i("QQCustomArkDialog", 2, "initArkView:" + paramBundle);
      }
      QLog.i("QQCustomArkDialog", 1, "get init dialog stack", new Exception("InitQQCustomArkDialogStack"));
      b(7);
      setContentView(2131558953);
      View localView = LayoutInflater.from(paramContext).inflate(2131558763, null);
      localView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)localView.findViewById(2131362798));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131369738));
      Object localObject1 = localView.findViewById(2131362821);
      ((RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams()).addRule(14);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      ((LinearLayout)localView.findViewById(2131362805)).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(this.jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback);
      boolean bool1 = paramBundle.getBoolean("is_ark_display_share", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, "from Forward:" + bool1);
      }
      localObject1 = new ArkAppMessage.Config();
      Object localObject2 = paramBundle.getString("forward_ark_app_config");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((ArkAppMessage.Config)localObject1).fromString((String)localObject2);
      }
      if ((ArkFullScreenAppActivity.a(paramBundle)) && ("card".equals(((ArkAppMessage.Config)localObject1).type))) {
        this.g = anjs.jdField_a_of_type_Int;
      }
      boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
      if (bool2)
      {
        localObject2 = MessageForArkApp.limitToSizeRange(anjs.a(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
        if (localObject2 != null)
        {
          this.jdField_e_of_type_Int = ((MessageForArkApp.Size)localObject2).width;
          if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {
            this.jdField_e_of_type_Int = anjs.jdField_a_of_type_Int;
          }
          this.jdField_f_of_type_Int = ((MessageForArkApp.Size)localObject2).height;
          if (QLog.isColorLevel())
          {
            float f1 = anjs.a();
            i = (int)(((MessageForArkApp.Size)localObject2).width / f1);
            j = (int)(((MessageForArkApp.Size)localObject2).height / f1);
            QLog.d("QQCustomArkDialog", 2, "width_from_sdk:" + ((ArkAppMessage.Config)localObject1).width + ", height_from_sdk:" + ((ArkAppMessage.Config)localObject1).height + ", scale:" + f1 + ", realwidth:" + i + ", realheight:" + j);
          }
        }
      }
      localObject1 = null;
      if (this.bodyLayout != null)
      {
        localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)paramContext.getResources().getDimension(2131296784));
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)paramContext.getResources().getDimension(2131296755));
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)paramContext.getResources().getDimension(2131296756));
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)paramContext.getResources().getDimension(2131296780));
      }
      if (!bool1)
      {
        localObject2 = findViewById(2131363482);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
        localObject2 = findViewById(2131365194);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = findViewById(2131365212);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
          this.bodyLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        i = MessageForArkApp.dp2px(1.0F);
        ((LinearLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setStroke(i, 436207616);
        if (this.bodyLayout != null)
        {
          if (!bool2) {
            this.bodyLayout.setBackgroundDrawable(localGradientDrawable);
          }
          addCenterView(localView, (LinearLayout.LayoutParams)localObject2);
        }
        this.jdField_a_of_type_Int = MessageForArkApp.dp2px(390.0F);
        this.jdField_b_of_type_Int = MessageForArkApp.dp2px(30.0F);
        this.jdField_c_of_type_Int = MessageForArkApp.dp2px(30.0F);
        i = paramContext.getResources().getDimensionPixelSize(2131296779);
        j = ((RelativeLayout.LayoutParams)localObject1).leftMargin;
        j = ((RelativeLayout.LayoutParams)localObject1).rightMargin + j;
        QLog.i("QQCustomArkDialog", 1, "init bundle mWidth=" + this.jdField_d_of_type_Int + ", dialogWidth=" + i + ",bodyMargin=" + j);
        this.jdField_d_of_type_Int = (i - j);
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).width = this.jdField_d_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject1).height = this.jdField_d_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        ThreadManager.getUIHandler().post(new QQCustomArkDialog.3(this, paramBundle));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setInputHolderAnchor((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getRootView());
        if (!(paramContext instanceof Activity)) {
          break label1096;
        }
        paramContext = (Activity)paramContext;
        if (paramContext != null)
        {
          anlb.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
        }
        ThreadManager.getUIHandler().postDelayed(new QQCustomArkDialog.4(this), 200L);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        int j;
        if (QLog.isColorLevel())
        {
          QLog.w("QQCustomArkDialog", 2, localException.getMessage());
          continue;
          if (localException != null)
          {
            i = localException.leftMargin;
            j = localException.rightMargin;
            if (QLog.isColorLevel())
            {
              QLog.d("QQCustomArkDialog", 2, "margin=" + (i + j));
              continue;
              label1096:
              paramContext = null;
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.title.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379156)).setText(paramString);
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Afdt != null) {
      this.jdField_a_of_type_Afdt.doOnEvent(2);
    }
    QLog.d("QQCustomArkDialog", 1, "dismiss");
    anft.a = true;
    super.dismiss();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null) && (paramMotionEvent.getAction() == 0) && ((paramMotionEvent.getX() < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getX() - 10.0F) || (paramMotionEvent.getX() > this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getX() + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth() + 10.0F) || (paramMotionEvent.getY() < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getY() - 10.0F) || (paramMotionEvent.getY() > this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getY() + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight() + 10.0F)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.mViewImpl.resetInputState();
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWindowToken(), 0);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    super.setOnDismissListener(paramOnDismissListener);
  }
  
  public void show()
  {
    this.jdField_d_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, new Object[] { "dialog show,arkViewLoadFinish = ", Boolean.valueOf(this.jdField_e_of_type_Boolean), ";alreadyShowDialog:", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = true;
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfh
 * JD-Core Version:    0.7.0.1
 */