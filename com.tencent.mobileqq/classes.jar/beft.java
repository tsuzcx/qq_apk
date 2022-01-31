import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.6;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class beft
{
  int jdField_a_of_type_Int = -1;
  public abwu a;
  Intent jdField_a_of_type_AndroidContentIntent;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View a;
  public ViewGroup a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  bdoh<Integer> jdField_a_of_type_Bdoh = new befu(this);
  public bejh a;
  public bejk a;
  public bekh a;
  TouchWebView.OnScrollChangedListener jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener = new befv(this);
  public JsBridgeListener a;
  public WebViewTopTabView a;
  public FadeIconImageView a;
  public String a;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  @Nullable
  private Intent jdField_b_of_type_AndroidContentIntent;
  public View b;
  public ViewGroup b;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public ImageView b;
  public TextView b;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 240;
  private View jdField_c_of_type_AndroidViewView;
  public ImageView c;
  public TextView c;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  public TextView d;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 255;
  public TextView e;
  boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean = true;
  private boolean g;
  
  public beft(bejh parambejh)
  {
    this.jdField_a_of_type_Bejh = parambejh;
    this.jdField_a_of_type_Bejk = parambejh.jdField_a_of_type_Bejk;
    this.jdField_a_of_type_Bekh = new bekh(parambejh);
  }
  
  private void j()
  {
    if ((this.jdField_b_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = asrc.a().c();
      bool2 = this.jdField_b_of_type_AndroidContentIntent.getBooleanExtra("fromAio", false);
    } while ((!bool1) || (!bool2));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.getChildCount())
      {
        if (((RadioButton)this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.getChildAt(i)).isChecked()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public View a()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public String a()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return "";
    }
    return this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
  }
  
  @TargetApi(11)
  public JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    JSONObject localJSONObject;
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localJSONObject = new JSONObject();
        try
        {
          paramString = Uri.parse(paramString);
          Object localObject = paramString.getQueryParameterNames();
          if ((localObject != null) && (((Set)localObject).size() != 0))
          {
            localObject = ((Set)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str1 = (String)((Iterator)localObject).next();
              if (str1.contains("_nav_"))
              {
                String str2 = paramString.getQueryParameter(str1);
                localJSONObject.put(str1.replace("_nav_", ""), str2);
                continue;
                return paramString;
              }
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "getTitlebarConfig error!", paramString);
          paramString = null;
        }
      }
    }
    for (;;)
    {
      paramString = localJSONObject;
    }
  }
  
  public void a() {}
  
  @TargetApi(11)
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
    } while (Build.VERSION.SDK_INT < 11);
    this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  public void a(int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    Object localObject4 = null;
    Drawable[] arrayOfDrawable = this.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
    Object localObject3 = arrayOfDrawable[0];
    Drawable localDrawable = arrayOfDrawable[1];
    Object localObject2 = arrayOfDrawable[2];
    Object localObject1 = arrayOfDrawable[3];
    switch (paramInt1)
    {
    default: 
      paramDrawable = (Drawable)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    for (;;)
    {
      if ((localObject2 != arrayOfDrawable[0]) || (localDrawable != arrayOfDrawable[1]) || (localObject1 != arrayOfDrawable[2]) || (paramDrawable != arrayOfDrawable[3]))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, localDrawable, (Drawable)localObject1, paramDrawable);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(paramInt2);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      }
      return;
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        if (localObject2 == null)
        {
          localObject2 = new ColorDrawable(0);
          ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramDrawable;
          paramDrawable = (Drawable)localObject3;
          continue;
        }
        if ((localObject2 instanceof ColorDrawable))
        {
          ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramDrawable;
          paramDrawable = (Drawable)localObject3;
        }
      }
      else if ((localObject2 instanceof ColorDrawable))
      {
        localObject3 = localObject1;
        localObject1 = null;
        localObject2 = paramDrawable;
        paramDrawable = (Drawable)localObject3;
        continue;
        if (paramDrawable != null)
        {
          paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
          localDrawable = paramDrawable;
          paramDrawable = (Drawable)localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          continue;
          if (paramDrawable != null)
          {
            paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            if (localObject3 == null)
            {
              localObject2 = new ColorDrawable(0);
              ((Drawable)localObject2).setBounds(paramDrawable.getBounds());
              localObject3 = localObject1;
              localObject1 = paramDrawable;
              paramDrawable = (Drawable)localObject3;
              continue;
            }
            if ((localObject3 instanceof ColorDrawable))
            {
              ((Drawable)localObject3).setBounds(paramDrawable.getBounds());
              localObject2 = localObject3;
              localObject3 = paramDrawable;
              paramDrawable = (Drawable)localObject1;
              localObject1 = localObject3;
            }
          }
          else if ((localObject3 instanceof ColorDrawable))
          {
            localObject3 = localObject1;
            localObject1 = paramDrawable;
            localObject2 = localObject4;
            paramDrawable = (Drawable)localObject3;
            continue;
            if (paramDrawable != null) {
              paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
            }
            localObject1 = localObject2;
            localObject2 = localObject3;
            continue;
          }
          localObject2 = localObject3;
          localObject3 = paramDrawable;
          paramDrawable = (Drawable)localObject1;
          localObject1 = localObject3;
          continue;
        }
        localDrawable = paramDrawable;
        paramDrawable = (Drawable)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = paramDrawable;
      paramDrawable = (Drawable)localObject3;
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_e_of_type_Boolean)
    {
      localObject2 = null;
      if ((paramInt < this.jdField_c_of_type_Int) || (!this.jdField_a_of_type_Bejk.v)) {
        break label94;
      }
      this.jdField_a_of_type_Bejk.v = false;
      if (!paramBoolean) {
        break label80;
      }
      localObject1 = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (localObject1 != null) && (localObject1 != this.jdField_a_of_type_AndroidViewViewGroup.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject1);
      }
      return;
      label80:
      b(this.jdField_e_of_type_Int);
      localObject1 = localObject2;
      continue;
      label94:
      localObject1 = localObject2;
      if (paramInt < this.jdField_c_of_type_Int)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_Bejk.v)
        {
          this.jdField_a_of_type_Bejk.v = true;
          if (paramBoolean)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewAnimationAnimation;
          }
          else
          {
            b(this.jdField_d_of_type_Int);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        try
        {
          String str2 = paramIntent.getExtras().getString("leftViewText");
          int i = paramIntent.getExtras().getInt("individuation_url_type");
          String str1 = str2;
          if (i >= 40300)
          {
            str1 = str2;
            if (i <= 40313)
            {
              str1 = str2;
              if (!TextUtils.isEmpty(str2))
              {
                str1 = str2;
                if (str2.contains(alud.a(2131715090))) {
                  str1 = BaseApplicationImpl.getApplication().getString(2131690623);
                }
              }
            }
          }
          bool1 = paramIntent.getBooleanExtra("hide_left_button", false);
          bool2 = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
          paramIntent = str1;
          if (str1 == null) {
            paramIntent = BaseApplicationImpl.getApplication().getString(2131690623);
          }
          if (!beka.a())
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
            break label317;
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
            label166:
            if (AppSetting.jdField_c_of_type_Boolean)
            {
              str1 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
              paramIntent = str1;
              if (!str1.contains(BaseApplicationImpl.getApplication().getString(2131690623))) {
                paramIntent = BaseApplicationImpl.getApplication().getString(2131690623) + str1;
              }
              this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
            }
            if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView == null) {
              break;
            }
            if (bool2) {
              this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
            }
          }
          else
          {
            if (this.jdField_a_of_type_AndroidWidgetTextView.getBackground() != null) {
              break label317;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setLeftViewName exception e = ", paramIntent);
          return;
        }
        label317:
        do
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          break label166;
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
          return;
          if (bool1) {
            break;
          }
        } while (!bool2);
      }
    }
  }
  
  public final void a(Intent paramIntent, View.OnClickListener paramOnClickListener)
  {
    LayoutInflater.from(this.jdField_a_of_type_Bejh.d.getContext()).inflate(2131558692, this.jdField_a_of_type_Bejh.d);
    this.jdField_b_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_Bejh.d.findViewById(2131375863));
    a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376012);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setPadding(0, -bdoo.b(12.0F), 0, 0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368624));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    if (AppSetting.jdField_c_of_type_Boolean) {
      bczz.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    if (paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    }
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368627));
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131689930));
    a(paramIntent);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368670));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375992));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368655));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368638));
    a(this.jdField_c_of_type_AndroidWidgetTextView);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bejh.d.findViewById(2131378112);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378110));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378113));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378108);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new befw(this));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377989));
    e();
    b(this.jdField_d_of_type_JavaLangString);
    a();
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    int k = 2;
    String[] arrayOfString = null;
    int j = 0;
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean)) {
      return;
    }
    Object localObject;
    if ((this.jdField_a_of_type_Bejk.jdField_a_of_type_Long & 0x4) == 0L)
    {
      if (!beka.a()) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplicationImpl.getApplication().getResources().getString(2131690623));
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("youxi.vip.qq.com/imoj"))) {
        paramIntent.putExtra("isScreenOrientationPortrait", true);
      }
      localObject = paramIntent.getStringExtra("title");
      this.jdField_a_of_type_Bejk.j = paramIntent.getBooleanExtra("ishiderefresh", false);
      this.jdField_a_of_type_Bejk.k = paramIntent.getBooleanExtra("ishidebackforward", false);
      boolean bool = paramIntent.getBooleanExtra("hide_left_button", false);
      this.jdField_a_of_type_Bejk.l = paramIntent.getBooleanExtra("show_right_close_button", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "QQBrowser url=" + ndq.b(paramString, new String[0]));
      }
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label688;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label224:
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131690610));
      if (!this.jdField_a_of_type_Bejk.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130840106);
        if ((!this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Bejk.m)) {
          break label700;
        }
        paramString = bdhj.a((Drawable)localObject, -1);
        label306:
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692826));
        j();
      }
      if (b())
      {
        if ((!this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Bejk.m)) {
          break label732;
        }
        c(-1);
      }
      label372:
      if (bool) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label857;
      }
    }
    label688:
    label700:
    label844:
    label857:
    for (int i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity) + 0;; i = 0)
    {
      for (;;)
      {
        int m = View.MeasureSpec.makeMeasureSpec(0, 0);
        int n = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.jdField_a_of_type_AndroidViewViewGroup.measure(m, n);
        i += this.jdField_a_of_type_AndroidViewViewGroup.getMeasuredHeight();
        if (this.jdField_a_of_type_Bejk.p)
        {
          m = this.jdField_a_of_type_AndroidViewViewGroup.getTop();
          n = this.jdField_a_of_type_AndroidViewViewGroup.getBottom();
          this.jdField_a_of_type_AndroidViewViewGroup.layout(this.jdField_a_of_type_AndroidViewViewGroup.getLeft(), m - i, this.jdField_a_of_type_AndroidViewViewGroup.getRight(), n - i);
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          label506:
          if (this.jdField_a_of_type_Bejk.l) {
            a(paramIntent.getStringExtra("left_close_button_text"));
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_Bejk.jdField_a_of_type_JavaLangString)) {
            break label844;
          }
        }
        try
        {
          paramIntent = new JSONObject(URLDecoder.decode(this.jdField_a_of_type_Bejk.jdField_a_of_type_JavaLangString));
          i = k;
          if (paramIntent.has("tabNum")) {
            i = paramIntent.getInt("tabNum");
          }
          if (paramIntent.has("subTextArray")) {}
          for (paramIntent = paramIntent.getJSONArray("subTextArray");; paramIntent = null)
          {
            paramString = arrayOfString;
            if (paramIntent == null) {
              break label822;
            }
            paramString = arrayOfString;
            if (paramIntent.length() <= 0) {
              break label822;
            }
            arrayOfString = new String[paramIntent.length()];
            for (;;)
            {
              paramString = arrayOfString;
              if (j >= paramIntent.length()) {
                break;
              }
              arrayOfString[j] = paramIntent.getString(j);
              j += 1;
            }
            if (!paramIntent.getBooleanExtra("hide_title_left_arrow", false)) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplicationImpl.getApplication().getResources().getString(2131690623));
            break;
            this.jdField_b_of_type_AndroidWidgetTextView.setText("");
            break label224;
            paramString = (String)localObject;
            if (this.jdField_a_of_type_Bejk.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null) {
              break label306;
            }
            paramString = bdhj.a((Drawable)localObject, this.jdField_a_of_type_Bejk.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_e_of_type_Int);
            break label306;
            label732:
            if (this.jdField_a_of_type_Bejk.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null) {
              break label372;
            }
            c(this.jdField_a_of_type_Bejk.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_e_of_type_Int);
            break label372;
            m = this.jdField_a_of_type_AndroidViewViewGroup.getTop();
            n = this.jdField_a_of_type_AndroidViewViewGroup.getBottom();
            this.jdField_a_of_type_AndroidViewViewGroup.layout(this.jdField_a_of_type_AndroidViewViewGroup.getLeft(), m + i, this.jdField_a_of_type_AndroidViewViewGroup.getRight(), i + n);
            this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
            break label506;
          }
          a(new bega(this.jdField_a_of_type_Bejk.jdField_a_of_type_Int, i, null, null, paramString));
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
      c();
      return;
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramView.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    bdob localbdob = new bdob(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new befx(this, paramView, paramInt2));
    localbdob.setDuration(paramInt3);
    this.jdField_a_of_type_Bejk.x = true;
    paramView.startAnimation(localbdob);
  }
  
  public void a(bega parambega)
  {
    int i = -1;
    if (parambega != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonNum(parambega.jdField_b_of_type_Int, parambega.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonText(parambega.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130850184, 2130850185, 2130850186);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167183);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
      a(this.jdField_a_of_type_Bejk.v);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView, new RelativeLayout.LayoutParams(-2, -1));
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(new befz(this));
      if (this.jdField_a_of_type_Bekh != null) {
        this.jdField_a_of_type_Bekh.a(parambega.jdField_b_of_type_JavaLangString, true);
      }
      localTouchWebView = this.jdField_a_of_type_Bejh.a();
      if ((localTouchWebView != null) && (!TextUtils.isEmpty(parambega.jdField_a_of_type_JavaLangString)))
      {
        str = "ok";
        if (!TextUtils.isEmpty(parambega.jdField_b_of_type_JavaLangString)) {
          break label263;
        }
        str = "the subTabCallback isEmpty";
        localJSONObject = new JSONObject();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          TouchWebView localTouchWebView;
          String str;
          JSONObject localJSONObject;
          localJSONObject.put("code", i);
          localJSONObject.put("message", str);
          localTouchWebView.callJs(parambega.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        label263:
        i = 0;
      }
    }
  }
  
  public void a(begb parambegb)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((parambegb != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
      localObject2 = parambegb.jdField_a_of_type_ArrayOfInt;
      if (parambegb.jdField_a_of_type_Int != 1) {
        break label56;
      }
      bool = true;
      ((WebViewTopTabView)localObject1).setRedHotStatus((int[])localObject2, bool);
      localObject2 = this.jdField_a_of_type_Bejh.a();
      if (localObject2 != null) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      label56:
      bool = false;
      break;
      label61:
      localObject1 = "OK";
      JSONObject localJSONObject = new JSONObject();
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.a();
      int i;
      if ((localObject3 == null) || (localObject3.length == 0))
      {
        i = -2;
        localObject1 = "sub tab num is error";
        localObject3 = new JSONObject();
      }
      try
      {
        for (;;)
        {
          ((JSONObject)localObject3).put("code", i);
          ((JSONObject)localObject3).put("message", localObject1);
          ((JSONObject)localObject3).put("data", localJSONObject);
          if (TextUtils.isEmpty(parambegb.jdField_a_of_type_JavaLangString)) {
            break;
          }
          ((TouchWebView)localObject2).callJs(parambegb.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject3).toString() });
          return;
          try
          {
            JSONArray localJSONArray = new JSONArray();
            i = 0;
            while (i < localObject3.length)
            {
              localJSONArray.put(localObject3[i]);
              i += 1;
            }
            localJSONObject.put("tabsStatus", localJSONArray);
            if (QLog.isColorLevel()) {
              QLog.i("WebLog_SwiftIphoneTitleBarUI", 2, "tabsStatusArray = " + localJSONArray.toString());
            }
            i = 0;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            i = -3;
            String str = "construction json error";
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((this.jdField_a_of_type_Bejk.s) && (localViewGroup != null) && (!this.jdField_a_of_type_Bejk.w) && (a()))
    {
      this.jdField_a_of_type_Bejk.w = true;
      this.jdField_a_of_type_Bejk.t = true;
      this.jdField_a_of_type_Bejk.v = true;
      localViewGroup.setBackgroundResource(2130850201);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      }
      paramTouchWebView.setOnScrollChangedListenerForBiz(new befy(this));
    }
  }
  
  public void a(TouchWebView paramTouchWebView, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramTouchWebView == null) {}
    do
    {
      return;
      if (!this.jdField_d_of_type_Boolean)
      {
        paramTouchWebView.setOnScrollChangedListenerForBiz(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
        this.jdField_d_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "setTitleBarScrollChange:" + paramBoolean1 + ", @" + paramInt1 + ", from " + paramInt2 + " to " + paramInt3 + ", " + paramBoolean2 + ", Before: " + paramString1 + ", After: " + paramString2);
      }
      this.jdField_e_of_type_Boolean = paramBoolean1;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      this.jdField_c_of_type_Int = ((int)(paramInt1 * localBaseApplicationImpl.getResources().getDisplayMetrics().density + 0.5F));
      this.jdField_d_of_type_Int = paramInt2;
      this.jdField_e_of_type_Int = paramInt3;
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new bdob(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.jdField_a_of_type_Bdoh);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(localBaseApplicationImpl, 17432581);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new bdob(Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), this.jdField_a_of_type_Bdoh);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(localBaseApplicationImpl, 17432581);
      this.jdField_f_of_type_Boolean = paramBoolean2;
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Int = -1;
      a(this.jdField_b_of_type_Int, false);
    } while (TextUtils.isEmpty(paramString3));
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("result", 0);
      paramString1.put("message", "ok");
      label331:
      paramTouchWebView.callJs(paramString3, new String[] { paramString1.toString() });
      return;
    }
    catch (Exception paramString2)
    {
      break label331;
    }
  }
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      localObject = (RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131377989);
    } while (localObject == null);
    paramWebView = (TextView)((RelativeLayout)localObject).findViewById(2131378029);
    Object localObject = (TextView)((RelativeLayout)localObject).findViewById(2131377968);
    if (paramBoolean)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new SwiftIphoneTitleBarUI.6(this, (TextView)localObject, paramWebView, paramString), 50L);
      return;
    }
    if (!TextUtils.isEmpty(((TextView)localObject).getText().toString()))
    {
      paramWebView.setText(paramString);
      return;
    }
    c(paramString);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        break label70;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.bringToFront();
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
      label70:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690885);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label98;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label39:
      if (TextUtils.isEmpty(paramString3)) {
        break label126;
      }
    }
    for (;;)
    {
      c(paramString3);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!beka.a())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
        break;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView.getBackground() != null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      break;
      label98:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label39;
      label126:
      paramString3 = "";
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener, abwu paramabwu)
  {
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.jdField_a_of_type_Boolean)) {}
    for (int i = 1; paramBoolean; i = 0)
    {
      this.jdField_a_of_type_Bejk.jdField_e_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      e(false);
      return;
    }
    if ((this.jdField_b_of_type_AndroidContentIntent != null) && (this.jdField_b_of_type_AndroidContentIntent.getIntExtra("reqType", -1) == 7))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (b()) {
      e(true);
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.bringToFront();
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (paramString3 != null)
        {
          paramInt1 = 0;
          if (paramString3.length() <= 0) {}
        }
        try
        {
          paramInt1 = Color.parseColor(paramString3);
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(paramInt1);
          if ((paramString1 != null) && (i == 0))
          {
            this.jdField_a_of_type_JavaLangString = paramString1.trim();
            if (this.jdField_a_of_type_Bejk.jdField_a_of_type_OrgJsonJSONObject.has("txtclr"))
            {
              paramString2 = this.jdField_a_of_type_Bejk.jdField_a_of_type_OrgJsonJSONObject.optString("txtclr", "");
              if (!TextUtils.isEmpty(paramString2))
              {
                paramString1 = paramString2;
                if (!paramString2.startsWith("#")) {
                  paramString1 = "#" + paramString2;
                }
              }
            }
          }
          try
          {
            paramInt1 = Color.parseColor(paramString1);
            paramString1 = bdhj.a(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), paramInt1);
            if (paramString1 != null)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
              c(paramInt1);
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, paramString1, new Object[0]);
            }
          }
          a(this.jdField_a_of_type_Bejk.v);
          return;
          e(false);
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramInt1 = 0;
            continue;
            if (paramabwu != null)
            {
              this.jdField_a_of_type_Abwu = paramabwu;
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
              this.jdField_a_of_type_JavaLangString = null;
            }
          }
        }
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) || (!(this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      j();
    }
    paramString3 = this.jdField_a_of_type_Bejk;
    if (paramInt1 != 4)
    {
      paramBoolean = true;
      label457:
      paramString3.jdField_e_of_type_Boolean = paramBoolean;
      switch (paramInt1)
      {
      default: 
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        label597:
        paramInt1 = paramInt2;
        if (paramInt2 == 0)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_Boolean) {
            paramInt1 = 10000;
          }
        }
        if (paramInt1 != 0)
        {
          if (this.jdField_b_of_type_AndroidWidgetImageView == null)
          {
            this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getApplication());
            paramString3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375991);
            paramString3 = new RelativeLayout.LayoutParams(-2, -2);
            paramString3.addRule(7, 2131368638);
            paramString3.addRule(6, 2131368638);
            paramString3.setMargins(0, 0, 0, 0);
            this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramString3);
            if ((this.jdField_a_of_type_AndroidWidgetImageView.getParent() instanceof RelativeLayout)) {
              ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).addView(this.jdField_b_of_type_AndroidWidgetImageView);
            }
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          switch (paramInt1)
          {
          default: 
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            label785:
            if (!TextUtils.isEmpty(paramString2)) {
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramString2);
            }
            if (paramOnClickListener != null) {
              this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      break;
      paramBoolean = false;
      break label457;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130843453, 2130843452);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bdhj.a(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130843453), this.jdField_a_of_type_AndroidWidgetImageView.getResources().getColor(2131166900)));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692823));
      break label597;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130843451, 2130843451);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692822));
      break label597;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130840106, 2130840106);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692824));
      break label597;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130839193, 2130839193);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692826));
      break label597;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843496);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692828));
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
      break label597;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130842168, 2130842171);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131689628));
      break label597;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130849572, 2130849576);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131689628));
      break label597;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130838651, 2130838651);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692825));
      break label597;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130849714, 2130849714);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692825));
      break label597;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130845905, 2130845904);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131692825));
      break label597;
      paramString3 = URLDrawable.getDrawable(QzoneConfig.getInstance().getConfig("QZoneSetting", "sweetIconRUL", "http://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png"), null);
      if (paramString3 == null) {
        break label597;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramString3);
      paramString3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375991);
      if (paramString3 == null) {
        break label597;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramString3.getLayoutParams();
      localLayoutParams.rightMargin = bdoo.b(10.0F);
      paramString3.setLayoutParams(localLayoutParams);
      break label597;
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130840106, 2130840106);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(BaseApplicationImpl.getApplication().getResources().getString(2131719882));
      break label597;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843274);
      break label785;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849801);
      break label785;
      if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
        break label785;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label785;
      if ((paramString1 != null) && (i == 0))
      {
        this.jdField_a_of_type_JavaLangString = paramString1.trim();
      }
      else if (paramabwu != null)
      {
        this.jdField_a_of_type_Abwu = paramabwu;
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int j = -1;
    int k = 0;
    if (paramJSONObject != null) {}
    try
    {
      if ((paramJSONObject.length() > 0) && (!this.jdField_a_of_type_Bejk.w))
      {
        this.jdField_a_of_type_Bejk.w = a();
        if ((this.jdField_a_of_type_Bejk.C) && (this.jdField_a_of_type_Bejh.jdField_c_of_type_AndroidViewView != null)) {
          this.jdField_a_of_type_Bejh.jdField_c_of_type_AndroidViewView.setPadding(0, (int)bdgz.a(BaseApplicationImpl.getApplication(), 30.0F), 0, 0);
        }
      }
      if (paramJSONObject == null) {
        return;
      }
      if (!this.jdField_a_of_type_Bejk.w) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "titlebar config:" + paramJSONObject.toString());
      }
      localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localViewGroup == null) {
        return;
      }
      if (!paramBoolean) {
        break label656;
      }
      localObject2 = paramJSONObject.optString("bgclr", "");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label795;
      }
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("#")) {
        localObject1 = "#" + (String)localObject2;
      }
      i = Color.parseColor((String)localObject1);
    }
    catch (Exception paramJSONObject)
    {
      ViewGroup localViewGroup;
      Object localObject2;
      Object localObject1;
      int i;
      label656:
      while (QLog.isColorLevel())
      {
        QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "game center,doTransparent error:" + paramJSONObject.toString());
        return;
        localViewGroup.getBackground().mutate().setAlpha(j);
        this.jdField_a_of_type_Bejk.jdField_d_of_type_Int = j;
        return;
        continue;
        i = -1;
        continue;
        localObject1 = localObject2;
        continue;
        label795:
        localObject1 = localObject2;
        i = -1;
      }
    }
    localViewGroup.setBackgroundColor(i);
    if ((this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null))
    {
      localObject2 = paramJSONObject.optString("statusclr", "");
      i = k;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!((String)localObject2).startsWith("#"))
        {
          localObject1 = "#" + (String)localObject1;
          i = Color.parseColor((String)localObject1);
        }
      }
      else
      {
        this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(i);
        azmk.a(true, i, this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity.getWindow());
      }
    }
    else
    {
      localObject2 = paramJSONObject.optString("txtclr", "");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("#")) {
          localObject1 = "#" + (String)localObject2;
        }
        i = Color.parseColor((String)localObject1);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
        if ((this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null) && (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getVisibility() == 0))
        {
          localObject1 = bdhj.a(this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getDrawable(), i);
          if (localObject1 != null) {
            this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable((Drawable)localObject1);
          }
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
        localObject1 = bdhj.a(this.jdField_a_of_type_AndroidWidgetTextView.getBackground(), i);
        if (localObject1 != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject1);
        }
        localObject1 = bdhj.a(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), i);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          c(i);
        }
        localObject1 = this.jdField_c_of_type_AndroidViewView.findViewById(2131370574);
        localObject2 = bdhj.a(((View)localObject1).getBackground(), i);
        if (localObject2 != null) {
          ((View)localObject1).setBackgroundDrawable((Drawable)localObject2);
        }
        localObject1 = paramJSONObject.optString("titleclr", "");
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!((String)localObject1).startsWith("#"))
          {
            localObject1 = "#" + (String)localObject1;
            i = Color.parseColor((String)localObject1);
          }
        }
        else
        {
          if ((TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bejh.jdField_a_of_type_JavaLangString))) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Bejh.jdField_a_of_type_JavaLangString);
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
          if (paramJSONObject.optInt("trans", -1) == 0) {
            return;
          }
          paramBoolean = paramJSONObject.optBoolean("anim", false);
          i = paramJSONObject.optInt("dur", 0);
          j = paramJSONObject.optInt("alpha", 0);
          if ((paramBoolean) && (i > 0))
          {
            a(localViewGroup, this.jdField_a_of_type_Bejk.jdField_d_of_type_Int, j, i);
            return;
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bejk.v = paramBoolean;
    if ((paramBoolean) && (this.jdField_b_of_type_JavaLangString != null)) {
      c(this.jdField_b_of_type_JavaLangString);
    }
    while ((paramBoolean) || (this.jdField_c_of_type_JavaLangString == null)) {
      return;
    }
    c(this.jdField_c_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean)
      {
        paramInt1 = QQToast.a(paramInt1);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(paramInt1));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidViewView.getResources().getString(paramInt2));
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  @TargetApi(17)
  public boolean a()
  {
    if ((!this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Bejk.m) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_Bejh.d != null) && (Build.VERSION.SDK_INT >= 17))
    {
      Object localObject1 = (TextView)this.jdField_a_of_type_Bejh.d.findViewById(2131363462);
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((LinearLayout.LayoutParams)localObject2).topMargin -= ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = this.jdField_a_of_type_Bejh.d.findViewById(2131380185);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((FrameLayout.LayoutParams)localObject2).topMargin -= BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298921);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView == null) {
      return false;
    }
    WebViewTopTabView localWebViewTopTabView = this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView;
    if (paramBoolean) {}
    for (;;)
    {
      localWebViewTopTabView.setVisibility(i);
      return true;
      i = 8;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bejk.E)
    {
      if ((!this.jdField_a_of_type_Bejk.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Bejk.m))
      {
        Resources localResources = this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity.getResources();
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(localResources.getColor(2131167116));
        if ((this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null)) {
          this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(0);
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetTextView, true, 2130849550, 2130850060);
      this.jdField_a_of_type_Bejh.a(this.jdField_a_of_type_AndroidWidgetImageView, false, 2130840106, 2130840102);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    do
    {
      do
      {
        return;
      } while (paramInt == this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = paramInt;
      paramInt = Math.max(0, Math.min(paramInt, 255));
      this.jdField_a_of_type_AndroidViewViewGroup.getBackground().mutate().setAlpha(paramInt);
      if ((this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null)) {
        this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.getBackground().mutate().setAlpha(paramInt);
      }
      if (paramInt == this.jdField_d_of_type_Int)
      {
        a(true);
        return;
      }
    } while (paramInt != this.jdField_e_of_type_Int);
    a(false);
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    paramString = this.jdField_a_of_type_Bejh.a();
    if ((paramString != null) && (!this.jdField_d_of_type_Boolean))
    {
      paramString.setOnScrollChangedListenerForBiz(this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener);
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bejk.jdField_e_of_type_Boolean = true;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    do
    {
      return;
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText()))) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        j();
      }
    } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Bejh.a() == null) || (this.jdField_a_of_type_Bejh.a().getPluginEngine() == null)) {}
    WebViewPlugin localWebViewPlugin;
    do
    {
      return false;
      localWebViewPlugin = this.jdField_a_of_type_Bejh.a().getPluginEngine().a(45, false);
    } while (((localWebViewPlugin instanceof UiApiPlugin)) && (((UiApiPlugin)localWebViewPlugin).g));
    if ((this.jdField_a_of_type_Bejk.F) || (this.jdField_a_of_type_Bejk.G)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return false;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = -1;
      a(this.jdField_b_of_type_Int, this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (!this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity.getWindow().clearFlags(1024);
      }
    }
    for (;;)
    {
      return true;
      b(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(1024);
    }
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    if (b())
    {
      View localView = this.jdField_c_of_type_AndroidViewView.findViewById(2131370574);
      localView.setBackgroundDrawable(bdhj.a(localView.getBackground(), paramInt));
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean c()
  {
    return a().getVisibility() == 0;
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      j();
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @TargetApi(11)
  public void e()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.jdField_a_of_type_AndroidViewViewGroup.setLayerType(0, null);
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
    {
      if ((paramBoolean) && (b()))
      {
        this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.n = 100;
        this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.q();
        this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.e(true);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.e(false);
  }
  
  public void f()
  {
    if (this.g)
    {
      f(this.jdField_f_of_type_Int);
      this.g = false;
    }
  }
  
  public void f(int paramInt)
  {
    int i = this.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor();
    if ((i != paramInt) && (!this.g))
    {
      c(true);
      e(i);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    if ((this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null) && (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getVisibility() == 0))
    {
      localDrawable1 = bdhj.a(this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getDrawable(), paramInt);
      if (localDrawable1 != null) {
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localDrawable1);
      }
    }
    Drawable localDrawable2 = this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
    Drawable localDrawable1 = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if (localDrawable2 != null)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable2;
        this.jdField_b_of_type_Boolean = true;
      }
      localDrawable2 = bdhj.a(localDrawable2, paramInt);
      if (localDrawable2 != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable2);
      }
    }
    if (localDrawable1 != null)
    {
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = true;
      }
      localDrawable1 = bdhj.a(localDrawable1, paramInt);
      if (localDrawable1 != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable1);
        c(paramInt);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(paramInt);
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(2131166897));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(2131166897));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(2131166900));
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if (localObject != null)
      {
        ((Drawable)localObject).clearColorFilter();
        ((Drawable)localObject).invalidateSelf();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if (c())
    {
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131370574);
      Drawable localDrawable = ((View)localObject).getBackground();
      if (localDrawable != null)
      {
        localDrawable.clearColorFilter();
        localDrawable.invalidateSelf();
      }
      ((View)localObject).setBackgroundDrawable(localDrawable);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_Bejk.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(paramInt);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Bejk.v) && (this.jdField_a_of_type_Bejk.u))
      {
        this.jdField_a_of_type_Bejk.u = false;
        this.jdField_a_of_type_Bejk.u = true;
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850201);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        return;
      }
    } while ((this.jdField_a_of_type_Bejk.v) || (!this.jdField_a_of_type_Bejk.u));
    this.jdField_a_of_type_Bejk.u = false;
    this.jdField_a_of_type_Bejk.u = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(2131166959));
    g();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beft
 * JD-Core Version:    0.7.0.1
 */