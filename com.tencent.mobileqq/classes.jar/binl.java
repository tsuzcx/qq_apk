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
import com.tencent.qphone.base.util.BaseApplication;

public class binl
{
  public int a;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public View a;
  public birg a;
  public birj a;
  public Hole a;
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
  
  public binl(birg parambirg)
  {
    this.jdField_a_of_type_Birg = parambirg;
    this.jdField_a_of_type_Birj = parambirg.jdField_a_of_type_Birj;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (8 == this.c.getVisibility())) {
      if (this.jdField_a_of_type_Birg.jdField_a_of_type_AndroidAppActivity == null) {
        break label91;
      }
    }
    label91:
    for (DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Birg.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();; localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics())
    {
      this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
      this.jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
      if ((this.jdField_a_of_type_Birj == null) || (!this.jdField_a_of_type_Birj.d) || (!this.jdField_a_of_type_Birj.H)) {
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
    if (blry.a(paramActivity))
    {
      paramActivity = paramActivity.findViewById(16908290);
      paramActivity.addOnLayoutChangeListener(new binp(this, paramActivity));
    }
  }
  
  public void a(View paramView)
  {
    int j = paramView.getResources().getColor(2131167179);
    if (this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean) {
      j = paramView.getResources().getColor(2131167180);
    }
    for (;;)
    {
      if ((this.f != null) && ((this.f instanceof TextView))) {
        if (!this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean) {
          break label326;
        }
      }
      label292:
      label308:
      label314:
      label320:
      label326:
      for (int k = 2130842602;; k = 2130842601)
      {
        ((TextView)this.f).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
        ((TextView)this.f).setTextColor(j);
        if ((this.g != null) && ((this.g instanceof TextView))) {
          if (!this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean) {
            break label320;
          }
        }
        for (k = 2130842599;; k = 2130842598)
        {
          ((TextView)this.g).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
          ((TextView)this.g).setTextColor(j);
          if ((this.e != null) && ((this.e instanceof TextView))) {
            if (!this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean) {
              break label314;
            }
          }
          for (k = 2130842593;; k = 2130842592)
          {
            ((TextView)this.e).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
            ((TextView)this.e).setTextColor(j);
            if ((this.d != null) && ((this.d instanceof TextView))) {
              if (!this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean) {
                break label308;
              }
            }
            for (k = 2130842590;; k = 2130842589)
            {
              ((TextView)this.d).setCompoundDrawablesWithIntrinsicBounds(0, k, 0, 0);
              ((TextView)this.d).setTextColor(j);
              if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof Button)))
              {
                j = 2130842585;
                if (!this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean) {
                  break label292;
                }
                j = 2130842595;
              }
              for (;;)
              {
                this.jdField_a_of_type_AndroidViewView.setBackgroundResource(j);
                return;
                if (this.jdField_a_of_type_Birj.H) {
                  j = 2130842597;
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
    if (this.jdField_a_of_type_Birg.jdField_a_of_type_AndroidAppActivity != null)
    {
      localDisplayMetrics = this.jdField_a_of_type_Birg.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
      if (!this.jdField_a_of_type_Birj.d) {
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
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366804);
      this.c = paramView.findViewById(2131378885);
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363661);
      this.d = paramView.findViewById(2131366167);
      this.f = paramView.findViewById(2131377489);
      this.g = paramView.findViewById(2131377348);
      this.h = paramView.findViewById(2131371384);
      this.e = paramView.findViewById(2131366939);
      this.i = paramView.findViewById(2131370633);
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole = ((Hole)paramView.findViewById(2131368067));
      b();
      if (this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean) {
        a(paramView);
      }
      if ((this.jdField_a_of_type_Birj.jdField_c_of_type_Long & 1L) != 0L)
      {
        this.f.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_Birj.jdField_c_of_type_Long & 0x4) != 0L)
      {
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_Birj.jdField_c_of_type_Long & 0x2) != 0L)
      {
        this.h.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if ((((this.jdField_a_of_type_Birj.b & 0x800) != 0L) || ((this.jdField_a_of_type_Birj.a & 0x80000000) != 0L)) && (this.jdField_a_of_type_Birg.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (niz.a().j(this.jdField_a_of_type_Birg.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mUrl)))
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
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(new binm(this, paramView, localDisplayMetrics));
    }
    for (;;)
    {
      paramView = new binn(this, localDisplayMetrics);
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
    if (this.jdField_a_of_type_Birj.jdField_c_of_type_Boolean)
    {
      paramView.setBackgroundResource(2130842595);
      return;
    }
    if (this.jdField_a_of_type_Birj.H)
    {
      paramView.setBackgroundResource(2130842597);
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130842585);
      return;
    }
    paramView.setBackgroundResource(2130842586);
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
    if ((this.jdField_a_of_type_Birj != null) && (this.jdField_a_of_type_Birj.d) && (this.jdField_a_of_type_Birj.H) && (this.jdField_a_of_type_AndroidViewView != null) && (8 == this.c.getVisibility())) {
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
      if (this.jdField_a_of_type_Birg.jdField_a_of_type_AndroidAppActivity == null) {
        break label115;
      }
    }
    label115:
    for (DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Birg.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();; localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics())
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
 * Qualified Name:     binl
 * JD-Core Version:    0.7.0.1
 */