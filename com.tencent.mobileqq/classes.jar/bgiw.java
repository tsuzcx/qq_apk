import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import org.json.JSONObject;

public class bgiw
  extends bccj
{
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  
  public bgiw(bcfx parambcfx)
  {
    super(parambcfx);
    parambcfx = parambcfx.jdField_a_of_type_AndroidAppActivity.getIntent();
    int j = parambcfx.getIntExtra("key_subtab", 0);
    parambcfx.removeExtra("key_subtab");
    if (this.jdField_a_of_type_Bcga.jdField_a_of_type_Int != j) {
      g(j);
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
    boolean bool;
    if (this.jdField_a_of_type_Bcga.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      if (!this.jdField_a_of_type_Bcga.jdField_a_of_type_OrgJsonJSONObject.has("txtclr"))
      {
        bool = true;
        this.g = bool;
        if (this.jdField_a_of_type_Bcga.jdField_a_of_type_OrgJsonJSONObject.has("titleclr")) {
          break label563;
        }
        bool = true;
        label113:
        this.h = bool;
        if (this.jdField_a_of_type_Bcga.jdField_a_of_type_OrgJsonJSONObject.has("bgclr")) {
          break label569;
        }
        bool = true;
        label137:
        this.i = bool;
      }
    }
    else
    {
      if (this.i)
      {
        int j = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop();
        int k = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom();
        int m = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft();
        int n = this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight();
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(m, j, n, k);
        if (this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
        {
          this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.p = true;
          this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.q = true;
          if (this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d == null) {
            this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.F();
          }
          if (this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null)
          {
            this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(-4210753);
            this.jdField_a_of_type_Bcga.i = true;
          }
        }
      }
      if ((!this.i) || (!this.h) || (!this.g)) {
        this.jdField_a_of_type_Bcfx.a(this.jdField_a_of_type_Bcga.jdField_a_of_type_OrgJsonJSONObject, true);
      }
      if ((this.jdField_a_of_type_Bcga.d & 0x20) != 0L)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        a("", this.c.getResources().getString(2131690832), "", false, 0, 0, null, null, null);
        this.c.setOnClickListener(new bgix(this));
      }
      if ((this.jdField_a_of_type_Bcga.d & 0x40) != 0L)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(9);
        localLayoutParams.leftMargin = baxn.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 15.0F);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      }
      if (this.jdField_a_of_type_Bcga.b != -1) {
        break label585;
      }
      if ((this.jdField_a_of_type_Bcga.d & 1L) <= 0L) {
        break label575;
      }
      b(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.b.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.c.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      if (this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
        this.jdField_a_of_type_Bcfx.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
      }
      return;
      bool = false;
      break;
      label563:
      bool = false;
      break label113;
      label569:
      bool = false;
      break label137;
      label575:
      b(255);
      continue;
      label585:
      b(this.jdField_a_of_type_Bcga.b);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      if (this.g) {
        f(-1);
      }
      if (this.h) {
        d(-1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130849670, 2130849671, 2130849672);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167123);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(14);
      }
    }
    do
    {
      return;
      if (this.g) {
        f(-16777216);
      }
      if (this.h) {
        d(-16777216);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView == null);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130849682, 2130849683, 2130849684);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167131);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgiw
 * JD-Core Version:    0.7.0.1
 */