package com.tencent.mobileqq.activity;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout;
import com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.QQProgressDialog;
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
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TranslateSelectableMenu jdField_a_of_type_ComTencentMobileqqActivitySelectableTranslateSelectableMenu;
  private OCRObserver jdField_a_of_type_ComTencentMobileqqOcrOCRObserver = new TextPreviewTranslateActivity.2(this);
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private OcrConfig jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig;
  TranslateLanguageOptionsView jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
  private ContainerView jdField_a_of_type_ComTencentMobileqqWidgetContainerView;
  protected QQProgressDialog a;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  TranslateLanguageOptionsView jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
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
    OcrConfig localOcrConfig = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig;
    if (localOcrConfig != null) {
      return localOcrConfig.getTranslateLanguageName(paramString);
    }
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  private List<String> a(String paramString)
  {
    OcrConfig localOcrConfig = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig;
    if (localOcrConfig != null) {
      return localOcrConfig.getTranslateSupportLanguages(paramString);
    }
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  private void a()
  {
    if (a(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_d_of_type_JavaLangString = "zh";
      this.jdField_e_of_type_JavaLangString = "en";
    }
    else
    {
      this.jdField_d_of_type_JavaLangString = "en";
      this.jdField_e_of_type_JavaLangString = "zh";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_d_of_type_JavaLangString));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_e_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_d_of_type_JavaLangString);
    this.jdField_b_of_type_JavaUtilList = a(this.jdField_e_of_type_JavaLangString);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299168));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    }
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    if (paramTranslateResult == null) {
      return;
    }
    ContainerView localContainerView = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView;
    if (localContainerView != null)
    {
      TranslateSelectableMenu localTranslateSelectableMenu = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTranslateSelectableMenu;
      if (localTranslateSelectableMenu != null)
      {
        String str = paramTranslateResult.a();
        localTranslateSelectableMenu.jdField_a_of_type_JavaLangString = str;
        localContainerView.setText(str);
        b(paramTranslateResult.jdField_b_of_type_JavaLangString);
        a(paramTranslateResult.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = paramString.toLowerCase();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_d_of_type_JavaLangString));
    this.jdField_b_of_type_JavaUtilList = a(this.jdField_d_of_type_JavaLangString);
    paramString = this.jdField_b_of_type_JavaUtilList;
    if ((paramString != null) && (paramString.size() > 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      paramString = getResources();
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 2130845794;
      } else {
        i = 2130846354;
      }
      paramString = paramString.getDrawable(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if (AppSetting.d) {
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_d_of_type_JavaLangString, getString(2131699089));
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      a(2131699090);
      TranslateController localTranslateController = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
      if (localTranslateController != null) {
        localTranslateController.a(paramString1, paramString2, paramString3);
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((19968 <= j) && (j < 40869)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private String b(String paramString)
  {
    if (StringUtil.a(paramString)) {
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
    Drawable localDrawable = getResources().getDrawable(2130846357);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    localDrawable = getResources().getDrawable(2130846352);
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
    paramString = this.jdField_a_of_type_JavaUtilList;
    if ((paramString != null) && (paramString.size() > 1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      paramString = getResources();
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 2130845794;
      } else {
        i = 2130846354;
      }
      paramString = paramString.getDrawable(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if (AppSetting.d) {
      AccessibilityUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_e_of_type_JavaLangString, getString(2131699089));
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378621));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131379104));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(new QQText(this.jdField_b_of_type_JavaLangString, 5, 25));
    this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)findViewById(2131379105));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379087));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379083));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379088));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379082));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131376999));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTranslateSelectableMenu = new TranslateSelectableMenu();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTranslateSelectableMenu.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
    b();
    this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig = ((IOCRService)this.app.getRuntimeService(IOCRService.class, "")).getOCRConfig(false);
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if ((localRelativeLayout instanceof DispatchTouchEventRelativeLayout)) {
      ((DispatchTouchEventRelativeLayout)localRelativeLayout).setOnDispatchListener(new TextPreviewTranslateActivity.DispatchListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTranslateSelectableMenu));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setHorizontallyScrolling(false);
    int i = DisplayUtil.a(this, 360.0F);
    if (this.jdField_a_of_type_AndroidWidgetEditText.getLineHeight() != 0) {
      i /= this.jdField_a_of_type_AndroidWidgetEditText.getLineHeight();
    } else {
      i = 17;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(i);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new TextPreviewTranslateActivity.1(this));
  }
  
  private void f()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
      return;
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        String str = (String)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!str.equals(this.jdField_b_of_type_JavaUtilList))
        {
          TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
          localOptionItem.jdField_b_of_type_JavaLangString = str;
          localOptionItem.jdField_a_of_type_JavaLangString = a(str);
          if (str.equalsIgnoreCase(this.jdField_d_of_type_JavaLangString)) {
            j = i;
          }
          ((List)localObject).add(localOptionItem);
        }
        i += 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView = TranslateLanguageOptionsView.a(this, (List)localObject, j, new TextPreviewTranslateActivity.3(this));
      localObject = this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
      if (localObject != null)
      {
        ((TranslateLanguageOptionsView)localObject).setOnDismissListener(new TextPreviewTranslateActivity.4(this));
        i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
        j = AIOUtils.b(75.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.showAsDropDown(this.jdField_a_of_type_AndroidWidgetTextView, i - j, 0);
      }
    }
  }
  
  private void h()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
      return;
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        String str = (String)this.jdField_b_of_type_JavaUtilList.get(i);
        if (!str.equals(this.jdField_d_of_type_JavaLangString))
        {
          TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
          localOptionItem.jdField_b_of_type_JavaLangString = str;
          localOptionItem.jdField_a_of_type_JavaLangString = a(str);
          if (str.equalsIgnoreCase(this.jdField_e_of_type_JavaLangString)) {
            j = i;
          }
          ((List)localObject).add(localOptionItem);
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView = TranslateLanguageOptionsView.a(this, (List)localObject, j, new TextPreviewTranslateActivity.5(this));
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
      if (localObject != null)
      {
        ((TranslateLanguageOptionsView)localObject).setOnDismissListener(new TextPreviewTranslateActivity.6(this));
        i = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
        j = AIOUtils.b(75.0F, getResources());
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.showAsDropDown(this.jdField_b_of_type_AndroidWidgetTextView, i - j, 0);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ForwardUtils.a(this.app, paramIntent, this);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561520);
    c();
    e();
    d();
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController(this.app);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
    a();
    a(this.jdField_d_of_type_JavaLangString);
    b(this.jdField_e_of_type_JavaLangString);
    a(b(this.jdField_b_of_type_JavaLangString), this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTranslateSelectableMenu.b(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTranslateSelectableMenu.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTranslateSelectableMenu.a();
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor())) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131379084: 
    case 2131379085: 
    case 2131379086: 
    default: 
      break;
    case 2131379088: 
      Object localObject = this.jdField_d_of_type_JavaLangString;
      a(this.jdField_e_of_type_JavaLangString);
      b((String)localObject);
      a(b(this.jdField_b_of_type_JavaLangString), this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      localObject = this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
      if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
        this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
      if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
      }
      break;
    case 2131379087: 
      g();
      break;
    case 2131379083: 
      h();
      break;
    case 2131379082: 
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity
 * JD-Core Version:    0.7.0.1
 */