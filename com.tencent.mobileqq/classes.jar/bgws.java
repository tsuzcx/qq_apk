import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqreader.ui.ReaderHomeTabFragment;

public class bgws
  extends bccj
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private Intent b;
  private View c;
  private String e;
  private int jdField_f_of_type_Int = -1;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private String h;
  
  public bgws(bcfx parambcfx)
  {
    super(parambcfx);
    this.jdField_a_of_type_AndroidAppActivity = parambcfx.jdField_a_of_type_AndroidAppActivity;
    this.jdField_b_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    int i = this.jdField_b_of_type_AndroidContentIntent.getIntExtra("key_subtab", 0);
    this.jdField_b_of_type_AndroidContentIntent.removeExtra("key_subtab");
    this.e = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("key_title_bar_left_tab_url");
    this.jdField_f_of_type_JavaLangString = this.jdField_b_of_type_AndroidContentIntent.getStringExtra("key_title_bar_right_tab_url");
    if (this.jdField_a_of_type_Bcga.jdField_a_of_type_Int != i) {
      g(i);
    }
    this.jdField_g_of_type_JavaLangString = bbdh.a(this.jdField_a_of_type_AndroidAppActivity).jdField_a_of_type_JavaLangString;
    this.h = bgwk.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private ImageView a(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent();
      Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = (((RelativeLayout.LayoutParams)localObject).width + baxn.a(this.jdField_a_of_type_AndroidAppActivity, 13.0F));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((RelativeLayout.LayoutParams)localObject).width, ((RelativeLayout.LayoutParams)localObject).height);
      localLayoutParams.topMargin = ((RelativeLayout.LayoutParams)localObject).topMargin;
      localObject = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ImageView)localObject).setContentDescription(paramString);
      ((ImageView)localObject).setOnClickListener(paramOnClickListener);
      ((ImageView)localObject).setImageResource(paramInt);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
      localViewGroup.addView((View)localObject, localViewGroup.indexOfChild(this.jdField_a_of_type_AndroidWidgetImageView), localLayoutParams);
      return localObject;
    }
    return null;
  }
  
  private void a(RadioButton paramRadioButton, boolean paramBoolean)
  {
    paramRadioButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130846077));
    paramRadioButton.setButtonDrawable(null);
    paramRadioButton.setGravity(17);
    paramRadioButton.setTextColor(-16777216);
    paramRadioButton.setTextSize(2, 18.0F);
    paramRadioButton.setTypeface(Typeface.DEFAULT_BOLD);
    paramRadioButton.setChecked(paramBoolean);
  }
  
  private boolean d()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isBookStore=");
    if (100 == this.jdField_f_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      bgwf.e("ReaderTitleBarView", bool);
      if (100 != this.jdField_f_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetRadioGroup = new RadioGroup(this.jdField_a_of_type_AndroidAppActivity);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setDividerDrawable(null);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setDividerPadding(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetRadioGroup, localLayoutParams);
      RadioButton localRadioButton = new RadioButton(this.jdField_a_of_type_AndroidAppActivity);
      localRadioButton.setId(2131373423);
      localLayoutParams = new ViewGroup.LayoutParams(baxn.a(this.jdField_a_of_type_AndroidAppActivity, 68.0F), baxn.a(this.jdField_a_of_type_AndroidAppActivity, 34.0F));
      a(localRadioButton, true);
      localRadioButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717180));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.addView(localRadioButton, localLayoutParams);
      localRadioButton = new RadioButton(this.jdField_a_of_type_AndroidAppActivity);
      localRadioButton.setId(2131373424);
      a(localRadioButton, false);
      localRadioButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717182));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.addView(localRadioButton, localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new bgwu(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new ViewGroup.LayoutParams(baxn.a(this.jdField_a_of_type_AndroidAppActivity, 186.0F), baxn.a(this.jdField_a_of_type_AndroidAppActivity, 44.0F)));
  }
  
  private void i(int paramInt)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
    if (localDrawable != null)
    {
      localDrawable = bbef.a(localDrawable, paramInt);
      if (localDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
      }
    }
  }
  
  private void j(int paramInt)
  {
    String str;
    if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
      switch (paramInt)
      {
      default: 
        str = "";
        paramInt = 0;
        i = paramInt;
        if (this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
          this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(str);
        }
        break;
      }
    }
    for (int i = paramInt;; i = 0)
    {
      k(i);
      return;
      bgwi.a(this.jdField_g_of_type_JavaLangString, this.h, "5", "502", "", "3", "", "", "");
      str = this.e;
      paramInt = 0;
      break;
      bgwi.a(this.jdField_g_of_type_JavaLangString, this.h, "5", "2206", "", "3", "", "", "");
      paramInt = 1;
      str = this.jdField_f_of_type_JavaLangString;
      break;
    }
  }
  
  private void k(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidWidgetRadioGroup.getChildCount();
    if ((paramInt < 0) || (paramInt >= j)) {
      return;
    }
    int i = 0;
    label20:
    RadioButton localRadioButton;
    if (i < j)
    {
      localRadioButton = (RadioButton)this.jdField_a_of_type_AndroidWidgetRadioGroup.getChildAt(i);
      if (i != paramInt) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      localRadioButton.setSelected(bool);
      i += 1;
      break label20;
      break;
    }
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Bcfx.c instanceof RefreshView)) {
      ((RefreshView)this.jdField_a_of_type_Bcfx.c).a(false);
    }
    if (this.jdField_a_of_type_Bcfx.b != null) {
      this.jdField_a_of_type_Bcfx.b.setVisibility(8);
    }
    this.jdField_a_of_type_Bcga.f = true;
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT_BOLD);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.jdField_c_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130849549));
    int i;
    int j;
    int k;
    int m;
    Object localObject;
    label289:
    label311:
    label361:
    boolean bool;
    label426:
    label451:
    Drawable localDrawable;
    if (d())
    {
      f(-1);
      d(-1);
      i = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop();
      j = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom();
      k = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft();
      m = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight();
      if ((this.jdField_b_of_type_AndroidContentIntent == null) || (this.jdField_b_of_type_AndroidContentIntent.getBundleExtra("theme") == null)) {
        break label639;
      }
      localObject = this.jdField_b_of_type_AndroidContentIntent.getBundleExtra("theme");
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(((Bundle)localObject).getInt("readerBgColor", -1));
      this.jdField_a_of_type_AndroidWidgetTextView.getBackground().setColorFilter(new LightingColorFilter(Color.rgb(0, 0, 0), ((Bundle)localObject).getInt("readerTextColor", -16777216)));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(((Bundle)localObject).getInt("readerTextColor", -16777216));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(((Bundle)localObject).getInt("readerTextColor", -16777216));
      if (!d()) {
        break label650;
      }
      bgwk.a(this.jdField_a_of_type_AndroidViewViewGroup, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity));
      if (this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        j = this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getResources().getDimensionPixelSize(2131298865);
        if (!d()) {
          break label665;
        }
        bgwk.a(this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer, -i);
        this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.p = true;
        this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.q = true;
        if (this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null)
        {
          if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            break label705;
          }
          this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(-6710887);
          localObject = this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a().getWindow();
          if (d()) {
            break label783;
          }
          bool = true;
          ImmersiveUtils.a(bool, (Window)localObject);
          this.jdField_a_of_type_Bcga.i = true;
        }
      }
      if ((this.jdField_g_of_type_Int != 1) || (104 == this.jdField_f_of_type_Int)) {
        break label823;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130846055);
      if (!d()) {
        break label789;
      }
      localObject = bbef.a(localDrawable, -1);
      label522:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694222));
      label551:
      if (102 == this.jdField_f_of_type_Int)
      {
        if ((TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
          break label835;
        }
        i();
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = a(2130846056, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717181), new bgwt(this));
      }
      return;
      f(-16777216);
      d(-16777216);
      break;
      label639:
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
      break label289;
      label650:
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(k, i, m, j);
      break label311;
      label665:
      if (!(this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment instanceof ReaderHomeTabFragment)) {
        break label361;
      }
      bgwk.a(this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView, -j - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity));
      break label361;
      label705:
      this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(-1);
      if (Build.VERSION.SDK_INT <= 23) {
        break label426;
      }
      localObject = this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a().getWindow();
      if (localObject == null) {
        break label426;
      }
      ((Window)localObject).clearFlags(67108864);
      ((Window)localObject).getDecorView().setSystemUiVisibility(1280);
      ((Window)localObject).addFlags(-2147483648);
      ((Window)localObject).setStatusBarColor(0);
      break label426;
      label783:
      bool = false;
      break label451;
      label789:
      localObject = localDrawable;
      if (this.jdField_a_of_type_Bcga.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null) {
        break label522;
      }
      localObject = bbef.a(localDrawable, this.jdField_a_of_type_Bcga.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.d);
      break label522;
      label823:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label551;
      label835:
      bgwf.a("ReaderTitleBarView", "mTitleBarLeftTabUrl=" + this.e + ",mTitleBarRightTabUrl=" + this.jdField_f_of_type_JavaLangString);
    }
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    if (paramIntent != null)
    {
      this.jdField_f_of_type_Int = paramIntent.getIntExtra("key_tab_id", -1);
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("item_type", -1);
    }
    this.jdField_a_of_type_Bcga.jdField_a_of_type_JavaLangString = null;
    super.a(paramIntent, paramString);
    if (d())
    {
      a(this.jdField_a_of_type_Bcga.jdField_a_of_type_OrgJsonJSONObject, false);
      if ((this.jdField_a_of_type_Bcfx.a() != null) && (!this.jdField_a_of_type_Bcga.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Bcga.q = true;
        a(this.jdField_a_of_type_Bcfx.a());
      }
    }
  }
  
  public void a(boolean paramBoolean, Window paramWindow)
  {
    if (paramBoolean)
    {
      ImmersiveUtils.a(false, paramWindow);
      i(-1);
      return;
    }
    ImmersiveUtils.a(true, paramWindow);
    i(-16777216);
  }
  
  public void h(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_f_of_type_Int = paramInt;
      Window localWindow = this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a().getWindow();
      a(d(), localWindow);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgws
 * JD-Core Version:    0.7.0.1
 */