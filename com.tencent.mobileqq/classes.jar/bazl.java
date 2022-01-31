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

public class bazl
  extends bazb
{
  public bazl(bbcj parambbcj)
  {
    super(parambbcj);
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
  
  public void a(bazi parambazi)
  {
    int i = -1;
    if (parambazi != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonNum(parambazi.jdField_b_of_type_Int, parambazi.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonText(parambazi.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130849425, 2130849426, 2130849427);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131101526);
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(10);
      a(this.jdField_a_of_type_Bbcm.t);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView, new RelativeLayout.LayoutParams(-2, -1));
      if (this.jdField_a_of_type_Bbcj.a.getIntent().getBooleanExtra("topTabSwitchFragment", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setOnCheckedChangeListener(new bazm(this));
        if (((QQBrowserActivity)this.jdField_a_of_type_Bbcj.a).jdField_b_of_type_Int != -1) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(((QQBrowserActivity)this.jdField_a_of_type_Bbcj.a).jdField_b_of_type_Int);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Bbdj != null) {
          this.jdField_a_of_type_Bbdj.a(parambazi.jdField_b_of_type_JavaLangString, true);
        }
        localTouchWebView = this.jdField_a_of_type_Bbcj.a();
        if ((localTouchWebView != null) && (!TextUtils.isEmpty(parambazi.jdField_a_of_type_JavaLangString)))
        {
          str = "ok";
          if (!TextUtils.isEmpty(parambazi.jdField_b_of_type_JavaLangString)) {
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
          localTouchWebView.callJs(parambazi.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          continue;
          this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setSelectedTab(this.jdField_a_of_type_Bbcj.a.getIntent().getIntExtra("topTabSelectIndex", 0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bazl
 * JD-Core Version:    0.7.0.1
 */