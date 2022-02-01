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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqreader.ui.ReaderHomeTabFragment;

public class bkvo
  extends bgtw
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  public bkvo(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
    this.jdField_a_of_type_AndroidAppActivity = paramSwiftBrowserUIStyleHandler.mHostActivity;
    this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_subtab", 0);
    this.jdField_a_of_type_AndroidContentIntent.removeExtra("key_subtab");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_title_bar_left_tab_url");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_title_bar_right_tab_url");
    if (this.mUIStyle.mSubIndex != i) {
      setTopTabSelection(i);
    }
    this.c = DeviceInfoUtil.getNetInfo(this.jdField_a_of_type_AndroidAppActivity).networkType;
    this.d = bkvi.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private ImageView a(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    if ((this.rightViewImg != null) && (this.rightViewImg.getVisibility() == 0))
    {
      ViewGroup localViewGroup = (ViewGroup)this.rightViewImg.getParent();
      Object localObject = (RelativeLayout.LayoutParams)this.rightViewImg.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = (((RelativeLayout.LayoutParams)localObject).width + DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 13.0F));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((RelativeLayout.LayoutParams)localObject).width, ((RelativeLayout.LayoutParams)localObject).height);
      localLayoutParams.topMargin = ((RelativeLayout.LayoutParams)localObject).topMargin;
      localObject = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ImageView)localObject).setContentDescription(paramString);
      ((ImageView)localObject).setOnClickListener(paramOnClickListener);
      ((ImageView)localObject).setImageResource(paramInt);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
      localViewGroup.addView((View)localObject, localViewGroup.indexOfChild(this.rightViewImg), localLayoutParams);
      return localObject;
    }
    return null;
  }
  
  private void a()
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
      localRadioButton.setId(2131374544);
      localLayoutParams = new ViewGroup.LayoutParams(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 68.0F), DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 34.0F));
      a(localRadioButton, true);
      localRadioButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131716139));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.addView(localRadioButton, localLayoutParams);
      localRadioButton = new RadioButton(this.jdField_a_of_type_AndroidAppActivity);
      localRadioButton.setId(2131374545);
      a(localRadioButton, false);
      localRadioButton.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131716141));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.addView(localRadioButton, localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new bkvq(this));
    this.centerContainer.removeAllViews();
    this.centerContainer.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new ViewGroup.LayoutParams(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 186.0F), DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 44.0F)));
  }
  
  private void a(RadioButton paramRadioButton, boolean paramBoolean)
  {
    paramRadioButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130846895));
    paramRadioButton.setButtonDrawable(null);
    paramRadioButton.setGravity(17);
    paramRadioButton.setTextColor(-16777216);
    paramRadioButton.setTextSize(2, 18.0F);
    paramRadioButton.setTypeface(Typeface.DEFAULT_BOLD);
    paramRadioButton.setChecked(paramBoolean);
  }
  
  private boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isBookStore=");
    if (100 == this.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      bkvd.e("ReaderTitleBarView", bool);
      if (100 != this.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    if (this.leftView == null) {
      bkvd.a("ReaderTitleBarView", "leftView is null");
    }
    Drawable localDrawable;
    do
    {
      do
      {
        return;
        localDrawable = this.leftView.getBackground();
      } while (localDrawable == null);
      localDrawable = bfvo.a(localDrawable, paramInt);
    } while (localDrawable == null);
    this.leftView.setBackgroundDrawable(localDrawable);
  }
  
  private void c(int paramInt)
  {
    String str;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      switch (paramInt)
      {
      default: 
        str = "";
        paramInt = 0;
        i = paramInt;
        if (this.mUIStyleHandler.mHostFragment != null) {
          this.mUIStyleHandler.mHostFragment.webView.loadUrl(str);
        }
        break;
      }
    }
    for (int i = paramInt;; i = 0)
    {
      d(i);
      return;
      bkvg.a(this.c, this.d, "5", "502", "", "3", "", "", "");
      str = this.jdField_a_of_type_JavaLangString;
      paramInt = 0;
      break;
      bkvg.a(this.c, this.d, "5", "2206", "", "3", "", "", "");
      paramInt = 1;
      str = this.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  private void d(int paramInt)
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
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_Int = paramInt;
      Window localWindow = this.mUIStyleHandler.mHostFragment.getHostActivity().getWindow();
      a(a(), localWindow);
    }
  }
  
  public void a(boolean paramBoolean, Window paramWindow)
  {
    if (paramBoolean)
    {
      ImmersiveUtils.a(false, paramWindow);
      b(-1);
      return;
    }
    ImmersiveUtils.a(true, paramWindow);
    b(-16777216);
  }
  
  public void initTitleBar(Intent paramIntent, String paramString)
  {
    if (paramIntent != null)
    {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("key_tab_id", -1);
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("item_type", -1);
    }
    this.mUIStyle.mControlParam = null;
    super.initTitleBar(paramIntent, paramString);
    if (a())
    {
      doTransparent(this.mUIStyle.transparentTitlebarConfig, false);
      if ((this.mUIStyleHandler.getWebView() != null) && (!this.mUIStyle.isFullScreen))
      {
        this.mUIStyle.isGrandualChangeTitlebarBg = true;
        enableTitlebarBgGrandualChange(this.mUIStyleHandler.getWebView());
      }
    }
  }
  
  public void initTitleContainer()
  {
    super.initTitleContainer();
    if ((this.mUIStyleHandler.webviewWrapper instanceof RefreshView)) {
      ((RefreshView)this.mUIStyleHandler.webviewWrapper).a(false);
    }
    if (this.mUIStyleHandler.mBrowserTips != null) {
      this.mUIStyleHandler.mBrowserTips.setVisibility(8);
    }
    this.mUIStyle.needHideBottomBar = true;
    this.centerView.setTypeface(Typeface.DEFAULT_BOLD);
    this.leftView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.centerView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.rightViewText.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.leftView.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130850595));
    int i;
    int j;
    int k;
    int m;
    Object localObject;
    label292:
    label314:
    label364:
    boolean bool;
    label429:
    label454:
    Drawable localDrawable;
    if (a())
    {
      setTitleBarButtonColor(-1);
      setTitleBarTextColor(-1);
      i = this.titleContainer.getPaddingTop();
      j = this.titleContainer.getPaddingBottom();
      k = this.titleContainer.getPaddingLeft();
      m = this.titleContainer.getPaddingRight();
      if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("theme") == null)) {
        break label644;
      }
      localObject = this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("theme");
      this.titleContainer.setBackgroundColor(((Bundle)localObject).getInt("readerBgColor", -1));
      this.leftView.getBackground().setColorFilter(new LightingColorFilter(Color.rgb(0, 0, 0), ((Bundle)localObject).getInt("readerTextColor", -16777216)));
      this.centerView.setTextColor(((Bundle)localObject).getInt("readerTextColor", -16777216));
      this.rightViewText.setTextColor(((Bundle)localObject).getInt("readerTextColor", -16777216));
      if (!a()) {
        break label655;
      }
      bkvi.a(this.titleContainer, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity));
      if (this.mUIStyleHandler.mHostFragment != null)
      {
        j = this.mUIStyleHandler.mHostFragment.getResources().getDimensionPixelSize(2131299076);
        if (!a()) {
          break label670;
        }
        bkvi.a(this.mUIStyleHandler.mHostFragment.contentView, -i);
        this.mUIStyleHandler.mHostFragment.mNeedStatusTrans = true;
        this.mUIStyleHandler.mHostFragment.mActNeedImmersive = true;
        if (this.mUIStyleHandler.mHostFragment.mSystemBarComp != null)
        {
          if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            break label710;
          }
          this.mUIStyleHandler.mHostFragment.mSystemBarComp.setBackgroundColor(-6710887);
          localObject = this.mUIStyleHandler.mHostFragment.getHostActivity().getWindow();
          if (a()) {
            break label788;
          }
          bool = true;
          ImmersiveUtils.a(bool, (Window)localObject);
          this.mUIStyle.mUsingCustomTitleBarColor = true;
        }
      }
      if ((this.jdField_b_of_type_Int != 1) || (104 == this.jdField_a_of_type_Int)) {
        break label828;
      }
      this.rightViewImg.setVisibility(0);
      localDrawable = this.rightViewImg.getResources().getDrawable(2130846873);
      if (!a()) {
        break label794;
      }
      localObject = bfvo.a(localDrawable, -1);
      label525:
      this.rightViewImg.setImageDrawable((Drawable)localObject);
      this.rightViewImg.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131693708));
      label554:
      if (102 == this.jdField_a_of_type_Int)
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
          break label840;
        }
        a();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = a(2130846874, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131716140), new bkvp(this));
      }
      return;
      setTitleBarButtonColor(-16777216);
      setTitleBarTextColor(-16777216);
      break;
      label644:
      this.titleContainer.setBackgroundColor(-1);
      break label292;
      label655:
      this.titleContainer.setPadding(k, i, m, j);
      break label314;
      label670:
      if (!(this.mUIStyleHandler.mHostFragment instanceof ReaderHomeTabFragment)) {
        break label364;
      }
      bkvi.a(this.mUIStyleHandler.mHostFragment.webView, -j - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity));
      break label364;
      label710:
      this.mUIStyleHandler.mHostFragment.mSystemBarComp.setBackgroundColor(-1);
      if (Build.VERSION.SDK_INT <= 23) {
        break label429;
      }
      localObject = this.mUIStyleHandler.mHostFragment.getHostActivity().getWindow();
      if (localObject == null) {
        break label429;
      }
      ((Window)localObject).clearFlags(67108864);
      ((Window)localObject).getDecorView().setSystemUiVisibility(1280);
      ((Window)localObject).addFlags(-2147483648);
      ((Window)localObject).setStatusBarColor(0);
      break label429;
      label788:
      bool = false;
      break label454;
      label794:
      localObject = localDrawable;
      if (this.mUIStyle.mTitleStyle == null) {
        break label525;
      }
      localObject = bfvo.a(localDrawable, this.mUIStyle.mTitleStyle.leftAndRightBtnColor);
      break label525;
      label828:
      this.rightViewImg.setVisibility(8);
      break label554;
      label840:
      bkvd.a("ReaderTitleBarView", "mTitleBarLeftTabUrl=" + this.jdField_a_of_type_JavaLangString + ",mTitleBarRightTabUrl=" + this.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvo
 * JD-Core Version:    0.7.0.1
 */