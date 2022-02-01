import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.3;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.BaseApplication;

public class biej
{
  public int a;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public View a;
  public Hole a;
  public SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle a;
  public SwiftBrowserUIStyleHandler a;
  Runnable jdField_a_of_type_JavaLangRunnable = new SwiftFloatViewUI.3(this);
  public int b;
  public View b;
  int c;
  public View c;
  int d;
  public View d;
  public View e;
  public View f;
  public View g;
  public View h;
  public View i;
  
  public biej(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle = paramSwiftBrowserUIStyleHandler.mUIStyle;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (8 == this.c.getVisibility())) {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.mHostActivity == null) {
        break label91;
      }
    }
    label91:
    for (DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.mHostActivity.getResources().getDisplayMetrics();; localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics())
    {
      this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
      this.jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle == null) || (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.isScreenLandscape) || (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.isFromQzoneGame)) {
        break;
      }
      c();
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Int - 50.0F * localDisplayMetrics.density));
    localLayoutParams.topMargin = ((int)(this.jdField_b_of_type_Int - localDisplayMetrics.density * 100.0F));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  @TargetApi(11)
  public void a(Activity paramActivity)
  {
    if (blhi.a(paramActivity))
    {
      paramActivity = paramActivity.findViewById(16908290);
      paramActivity.addOnLayoutChangeListener(new bien(this, paramActivity));
    }
  }
  
  public void a(View paramView)
  {
    int j = paramView.getResources().getColor(2131167222);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mNeedChangeFloatBarRes) {
      j = paramView.getResources().getColor(2131167223);
    }
    for (;;)
    {
      if ((this.f != null) && ((this.f instanceof TextView))) {
        if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mNeedChangeFloatBarRes) {
          break label326;
        }
      }
      label292:
      label308:
      label314:
      label320:
      label326:
      for (int k = 2130842677;; k = 2130842676)
      {
        ((TextView)this.f).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
        ((TextView)this.f).setTextColor(j);
        if ((this.g != null) && ((this.g instanceof TextView))) {
          if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mNeedChangeFloatBarRes) {
            break label320;
          }
        }
        for (k = 2130842674;; k = 2130842673)
        {
          ((TextView)this.g).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
          ((TextView)this.g).setTextColor(j);
          if ((this.e != null) && ((this.e instanceof TextView))) {
            if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mNeedChangeFloatBarRes) {
              break label314;
            }
          }
          for (k = 2130842668;; k = 2130842667)
          {
            ((TextView)this.e).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
            ((TextView)this.e).setTextColor(j);
            if ((this.d != null) && ((this.d instanceof TextView))) {
              if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mNeedChangeFloatBarRes) {
                break label308;
              }
            }
            for (k = 2130842665;; k = 2130842664)
            {
              ((TextView)this.d).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
              ((TextView)this.d).setTextColor(j);
              if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof Button)))
              {
                j = 2130842660;
                if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mNeedChangeFloatBarRes) {
                  break label292;
                }
                j = 2130842670;
              }
              for (;;)
              {
                this.jdField_a_of_type_AndroidViewView.setBackgroundResource(j);
                return;
                if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.isFromQzoneGame) {
                  j = 2130842672;
                }
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(16)
  public void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    DisplayMetrics localDisplayMetrics;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.mHostActivity != null)
    {
      localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.mHostActivity.getResources().getDisplayMetrics();
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.isScreenLandscape) {
        break label557;
      }
      if (localDisplayMetrics.heightPixels <= localDisplayMetrics.widthPixels) {
        break label539;
      }
      j = localDisplayMetrics.heightPixels;
      label54:
      this.jdField_a_of_type_Int = j;
      if (localDisplayMetrics.heightPixels <= localDisplayMetrics.widthPixels) {
        break label548;
      }
      j = localDisplayMetrics.widthPixels;
      label78:
      this.jdField_b_of_type_Int = j;
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366946);
      this.c = paramView.findViewById(2131378950);
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363763);
      this.d = paramView.findViewById(2131366298);
      this.f = paramView.findViewById(2131377525);
      this.g = paramView.findViewById(2131377385);
      this.h = paramView.findViewById(2131371538);
      this.e = paramView.findViewById(2131367078);
      this.i = paramView.findViewById(2131370784);
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole = ((Hole)paramView.findViewById(2131368241));
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mNeedChangeFloatBarRes) {
        a(paramView);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mFloatBarRulesFromUrl & 1L) != 0L)
      {
        this.f.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mFloatBarRulesFromUrl & 0x4) != 0L)
      {
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mFloatBarRulesFromUrl & 0x2) != 0L)
      {
        this.h.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if ((((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mWWVRulesFromUrl & 0x800) != 0L) || ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mRulesFromUrl & 0x80000000) != 0L)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.mHostFragment != null) && (nro.a().j(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.mHostFragment.mUrl)))
      {
        this.e.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("secondHandSharePre", 0);
      if (!localSharedPreferences.getBoolean("first_float_tip", true)) {
        break label626;
      }
      this.c.setVisibility(0);
      localSharedPreferences.edit().putBoolean("first_float_tip", false).apply();
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(new biek(this, paramView, localDisplayMetrics));
    }
    for (;;)
    {
      paramView = new biel(this, localDisplayMetrics);
      this.d.setOnClickListener(paramOnClickListener);
      this.f.setOnClickListener(paramOnClickListener);
      this.h.setOnClickListener(paramOnClickListener);
      this.g.setOnClickListener(paramOnClickListener);
      this.e.setOnClickListener(paramOnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(paramView);
      this.c.setOnTouchListener(paramView);
      this.i.setOnTouchListener(paramView);
      return;
      localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      break;
      label539:
      j = localDisplayMetrics.widthPixels;
      break label54;
      label548:
      j = localDisplayMetrics.heightPixels;
      break label78;
      label557:
      if (localDisplayMetrics.heightPixels < localDisplayMetrics.widthPixels)
      {
        j = localDisplayMetrics.heightPixels;
        label576:
        this.jdField_a_of_type_Int = j;
        if (localDisplayMetrics.heightPixels >= localDisplayMetrics.widthPixels) {
          break label617;
        }
      }
      label617:
      for (j = localDisplayMetrics.widthPixels;; j = localDisplayMetrics.heightPixels)
      {
        this.jdField_b_of_type_Int = j;
        break;
        j = localDisplayMetrics.widthPixels;
        break label576;
      }
      label626:
      this.c.setVisibility(8);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.mNeedChangeFloatBarRes)
    {
      paramView.setBackgroundResource(2130842670);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.isFromQzoneGame)
    {
      paramView.setBackgroundResource(2130842672);
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130842660);
      return;
    }
    paramView.setBackgroundResource(2130842661);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.f != null)
    {
      localView = this.f;
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int j = 8;; j = 0)
    {
      localView.setVisibility(j);
      if ((!paramBoolean) && (this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4))) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.isScreenLandscape) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.isFromQzoneGame) && (this.jdField_a_of_type_AndroidViewView != null) && (8 == this.c.getVisibility())) {
      c();
    }
  }
  
  public void c()
  {
    int j;
    int k;
    if (this.jdField_b_of_type_Int > this.jdField_a_of_type_Int)
    {
      j = this.jdField_a_of_type_Int;
      k = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.mHostActivity == null) {
        break label115;
      }
    }
    label115:
    for (DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.mHostActivity.getResources().getDisplayMetrics();; localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics())
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(k - localDisplayMetrics.density * 70.0F));
      localLayoutParams.topMargin = (j / 2 - this.jdField_a_of_type_AndroidViewView.getWidth() / 2);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
      j = this.jdField_b_of_type_Int;
      k = this.jdField_a_of_type_Int;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biej
 * JD-Core Version:    0.7.0.1
 */