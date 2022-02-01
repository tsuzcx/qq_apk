import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import org.json.JSONObject;

public class bioa
  extends binq
{
  public bioa(birg parambirg)
  {
    super(parambirg);
  }
  
  public int a(RadioGroup paramRadioGroup)
  {
    if ((paramRadioGroup != null) && ((paramRadioGroup instanceof WebViewTopTabView)))
    {
      int i = 0;
      while (i < paramRadioGroup.getChildCount())
      {
        if (((RadioButton)paramRadioGroup.getChildAt(i)).isChecked()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(binx parambinx)
  {
    int i = -1;
    if (parambinx != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonNum(parambinx.jdField_b_of_type_Int, parambinx.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonText(parambinx.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130850799, 2130850800, 2130850801);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167291);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
      a(this.jdField_a_of_type_Birj.v);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView, new RelativeLayout.LayoutParams(-2, -1));
      if (this.jdField_a_of_type_Birg.a.getIntent().getBooleanExtra("topTabSwitchFragment", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(new biob(this));
        if (((QQBrowserActivity)this.jdField_a_of_type_Birg.a).c != -1) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(((QQBrowserActivity)this.jdField_a_of_type_Birg.a).c);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Bisg != null) {
          this.jdField_a_of_type_Bisg.a(parambinx.jdField_b_of_type_JavaLangString, true);
        }
        localTouchWebView = this.jdField_a_of_type_Birg.a();
        if ((localTouchWebView != null) && (!TextUtils.isEmpty(parambinx.jdField_a_of_type_JavaLangString)))
        {
          str = "ok";
          if (!TextUtils.isEmpty(parambinx.jdField_b_of_type_JavaLangString)) {
            break label337;
          }
          str = "the subTabCallback isEmpty";
          localJSONObject = new JSONObject();
        }
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
          localTouchWebView.callJs(parambinx.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          continue;
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(this.jdField_a_of_type_Birg.a.getIntent().getIntExtra("topTabSelectIndex", 0));
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        label337:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bioa
 * JD-Core Version:    0.7.0.1
 */