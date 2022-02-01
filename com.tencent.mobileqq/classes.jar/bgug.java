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
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import org.json.JSONObject;

public class bgug
  extends bgtw
{
  public bgug(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
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
  
  public void setSubTab(bgud parambgud)
  {
    int i = -1;
    if (parambgud != null)
    {
      this.mTopSubTabView = new WebViewTopTabView(BaseApplicationImpl.getContext());
      this.mTopSubTabView.setButtonNum(parambgud.jdField_b_of_type_Int, parambgud.jdField_a_of_type_Int);
      this.mTopSubTabView.setButtonText(parambgud.jdField_a_of_type_ArrayOfJavaLangString);
      this.mTopSubTabView.setButtonBackgroundResource(2130850729, 2130850730, 2130850731);
      this.mTopSubTabView.setButtonTextColorStateList(2131167323);
      this.mTopSubTabView.setLeftAndRightPaddingByDp(10);
      setTitleBarStyle(this.mUIStyle.needTitlebarTranslucent);
    }
    try
    {
      this.centerContainer.removeAllViews();
      this.centerContainer.addView(this.mTopSubTabView, new RelativeLayout.LayoutParams(-2, -1));
      if (this.mUIStyleHandler.mHostActivity.getIntent().getBooleanExtra("topTabSwitchFragment", false))
      {
        this.mTopSubTabView.setOnCheckedChangeListener(new bguh(this));
        if (((QQBrowserActivity)this.mUIStyleHandler.mHostActivity).c != -1) {
          this.mTopSubTabView.setSelectedTab(((QQBrowserActivity)this.mUIStyleHandler.mHostActivity).c);
        }
      }
      else
      {
        if (this.mTopTabHelper != null) {
          this.mTopTabHelper.a(parambgud.jdField_b_of_type_JavaLangString, true);
        }
        localTouchWebView = this.mUIStyleHandler.getWebView();
        if ((localTouchWebView != null) && (!TextUtils.isEmpty(parambgud.jdField_a_of_type_JavaLangString)))
        {
          str = "ok";
          if (!TextUtils.isEmpty(parambgud.jdField_b_of_type_JavaLangString)) {
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
          localTouchWebView.callJs(parambgud.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          continue;
          this.mTopSubTabView.setSelectedTab(this.mUIStyleHandler.mHostActivity.getIntent().getIntExtra("topTabSelectIndex", 0));
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
 * Qualified Name:     bgug
 * JD-Core Version:    0.7.0.1
 */