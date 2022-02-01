package com.tencent.mobileqq.activity;

import Override;
import afar;
import afas;
import afat;
import afau;
import afav;
import afaw;
import afax;
import alwq;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ayrg;
import ayri;
import ayvo;
import ayvq;
import bgyd;
import bisl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class TextPreviewTranslateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f = Color.parseColor("#1F1F1F");
  public static final int g = Color.parseColor("#000000");
  private alwq jdField_a_of_type_Alwq;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ayri jdField_a_of_type_Ayri = new afas(this);
  public ayvo a;
  protected bisl a;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private OcrConfig jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig;
  private ContainerView jdField_a_of_type_ComTencentMobileqqWidgetContainerView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public ayvo b;
  private String jdField_b_of_type_JavaLangString;
  private List<String> jdField_b_of_type_JavaUtilList;
  private String c;
  private String d;
  private String e;
  
  static
  {
    jdField_a_of_type_Int = Color.parseColor("#03081A");
    jdField_b_of_type_Int = Color.parseColor("#00CAFC");
    jdField_c_of_type_Int = Color.parseColor("#FFFFFF");
    jdField_d_of_type_Int = Color.parseColor("#A8A8A8");
    jdField_e_of_type_Int = Color.parseColor("#004080");
  }
  
  private String a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.getTranslateLanguageName(paramString);
    }
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  private List<String> a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.getTranslateSupportLanguages(paramString);
    }
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  private void a()
  {
    if (a(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = "zh";
    }
    for (this.jdField_e_of_type_JavaLangString = "en";; this.jdField_e_of_type_JavaLangString = "zh")
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_d_of_type_JavaLangString));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_e_of_type_JavaLangString));
      this.jdField_a_of_type_JavaUtilList = a(this.jdField_d_of_type_JavaLangString);
      this.jdField_b_of_type_JavaUtilList = a(this.jdField_e_of_type_JavaLangString);
      return;
      this.jdField_d_of_type_JavaLangString = "en";
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this, getResources().getDimensionPixelSize(2131299080));
      this.jdField_a_of_type_Bisl.c(paramInt);
    }
    if (!isFinishing()) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    if (paramTranslateResult == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView == null) || (this.jdField_a_of_type_Alwq == null)) {
      return;
    }
    ContainerView localContainerView = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView;
    alwq localalwq = this.jdField_a_of_type_Alwq;
    String str = paramTranslateResult.b();
    localalwq.jdField_a_of_type_JavaLangString = str;
    localContainerView.setText(str);
    b(paramTranslateResult.jdField_b_of_type_JavaLangString);
    a(paramTranslateResult.jdField_a_of_type_JavaLangString);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = paramString.toLowerCase();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_d_of_type_JavaLangString));
    this.jdField_b_of_type_JavaUtilList = a(this.jdField_d_of_type_JavaLangString);
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      label82:
      if (AppSetting.c) {
        bgyd.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_JavaLangString, getString(2131698708));
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      paramString = getResources();
      if (!this.jdField_a_of_type_Boolean) {
        break label149;
      }
    }
    label149:
    for (int i = 2130845604;; i = 2130846150)
    {
      paramString = paramString.getDrawable(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
      break label82;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      a(2131698709);
      if (this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController != null) {
        this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(paramString1, paramString2, paramString3);
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.length())
      {
        int j = paramString.charAt(i);
        if ((19968 <= j) && (j < 40869)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private String b(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    return new QQText(paramString, 5, 25).toPlainText(false);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setTextColor(jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(jdField_a_of_type_Int);
    Drawable localDrawable = getResources().getDrawable(2130846153);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    localDrawable = getResources().getDrawable(2130846148);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_e_of_type_JavaLangString = paramString.toLowerCase();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_e_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList = a(paramString);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      label79:
      if (AppSetting.c) {
        bgyd.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_e_of_type_JavaLangString, getString(2131698708));
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      paramString = getResources();
      if (!this.jdField_a_of_type_Boolean) {
        break label146;
      }
    }
    label146:
    for (int i = 2130845604;; i = 2130846150)
    {
      paramString = paramString.getDrawable(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
      break label79;
      break;
    }
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("TranslateText");
    this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("WhereAreYouFrom");
  }
  
  private void d()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_FROM", 1);
    setResult(1, localIntent);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378826));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131379350));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(new QQText(this.jdField_b_of_type_JavaLangString, 5, 25));
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)findViewById(2131379351));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379326));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379322));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379327));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379321));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131377135));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_Alwq = new alwq();
    this.jdField_a_of_type_Alwq.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
    b();
    this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig = ((ayrg)this.app.getManager(QQManagerFactory.OCR_MANAGER)).a(false);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout instanceof DispatchTouchEventRelativeLayout)) {
      ((DispatchTouchEventRelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout).setOnDispatchListener(new afax(this.jdField_a_of_type_Alwq));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setHorizontallyScrolling(false);
    int i = DisplayUtil.dip2px(this, 360.0F);
    if (this.jdField_a_of_type_AndroidWidgetEditText.getLineHeight() != 0) {
      i /= this.jdField_a_of_type_AndroidWidgetEditText.getLineHeight();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(i);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new afar(this));
      return;
      i = 17;
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Ayvo != null) && (this.jdField_a_of_type_Ayvo.isShowing())) {
      this.jdField_a_of_type_Ayvo.dismiss();
    }
    if ((this.jdField_b_of_type_Ayvo != null) && (this.jdField_b_of_type_Ayvo.isShowing())) {
      this.jdField_b_of_type_Ayvo.dismiss();
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0));
      ArrayList localArrayList = new ArrayList();
      i = 0;
      j = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        String str = (String)this.jdField_a_of_type_JavaUtilList.get(i);
        if (str.equals(this.jdField_b_of_type_JavaUtilList)) {}
        for (;;)
        {
          i += 1;
          break;
          ayvq localayvq = new ayvq();
          localayvq.jdField_b_of_type_JavaLangString = str;
          localayvq.jdField_a_of_type_JavaLangString = a(str);
          if (str.equalsIgnoreCase(this.jdField_d_of_type_JavaLangString)) {
            j = i;
          }
          localArrayList.add(localayvq);
        }
      }
      this.jdField_b_of_type_Ayvo = ayvo.a(this, localArrayList, j, new afat(this));
    } while (this.jdField_b_of_type_Ayvo == null);
    this.jdField_b_of_type_Ayvo.setOnDismissListener(new afau(this));
    int i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    int j = AIOUtils.dp2px(75.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Ayvo.showAsDropDown(this.jdField_a_of_type_AndroidWidgetTextView, i - j, 0);
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_Ayvo != null) && (this.jdField_b_of_type_Ayvo.isShowing())) {
      this.jdField_b_of_type_Ayvo.dismiss();
    }
    if ((this.jdField_a_of_type_Ayvo != null) && (this.jdField_a_of_type_Ayvo.isShowing())) {
      this.jdField_a_of_type_Ayvo.dismiss();
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0));
      ArrayList localArrayList = new ArrayList();
      i = 0;
      j = 0;
      if (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        String str = (String)this.jdField_b_of_type_JavaUtilList.get(i);
        if (str.equals(this.jdField_d_of_type_JavaLangString)) {}
        for (;;)
        {
          i += 1;
          break;
          ayvq localayvq = new ayvq();
          localayvq.jdField_b_of_type_JavaLangString = str;
          localayvq.jdField_a_of_type_JavaLangString = a(str);
          if (str.equalsIgnoreCase(this.jdField_e_of_type_JavaLangString)) {
            j = i;
          }
          localArrayList.add(localayvq);
        }
      }
      this.jdField_a_of_type_Ayvo = ayvo.a(this, localArrayList, j, new afav(this));
    } while (this.jdField_a_of_type_Ayvo == null);
    this.jdField_a_of_type_Ayvo.setOnDismissListener(new afaw(this));
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    int j = AIOUtils.dp2px(75.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Ayvo.showAsDropDown(this.jdField_b_of_type_AndroidWidgetTextView, i - j, 0);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ForwardUtils.onForwardActivityResult(this.app, paramIntent, this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561555);
    c();
    e();
    d();
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController(this.app);
    addObserver(this.jdField_a_of_type_Ayri);
    a();
    a(this.jdField_d_of_type_JavaLangString);
    b(this.jdField_e_of_type_JavaLangString);
    a(b(this.jdField_b_of_type_JavaLangString), this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ayri);
    this.jdField_a_of_type_Alwq.b(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Alwq.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Alwq.a();
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c())) {
      ImmersiveUtils.a(true, getWindow());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      continue;
      g();
      continue;
      h();
      continue;
      String str = this.jdField_d_of_type_JavaLangString;
      a(this.jdField_e_of_type_JavaLangString);
      b(str);
      a(b(this.jdField_b_of_type_JavaLangString), this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      if ((this.jdField_b_of_type_Ayvo != null) && (this.jdField_b_of_type_Ayvo.isShowing())) {
        this.jdField_b_of_type_Ayvo.dismiss();
      }
      if ((this.jdField_a_of_type_Ayvo != null) && (this.jdField_a_of_type_Ayvo.isShowing())) {
        this.jdField_a_of_type_Ayvo.dismiss();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity
 * JD-Core Version:    0.7.0.1
 */