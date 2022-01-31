import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmini.sdk.runtime.core.page.widget.WebEditText;
import org.json.JSONException;
import org.json.JSONObject;

class bhct
  implements TextView.OnEditorActionListener
{
  bhct(bhcq parambhcq, WebEditText paramWebEditText, bgid parambgid) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramTextView = new JSONObject();
        paramTextView.put("inputId", bhcq.a(this.jdField_a_of_type_Bhcq));
        paramTextView.put("value", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.getText().toString());
        this.jdField_a_of_type_Bgid.a.a("onKeyboardConfirm", paramTextView.toString(), 0);
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.c()) {
          continue;
        }
        this.jdField_a_of_type_Bhcq.a(true);
        return true;
      }
      catch (JSONException paramTextView)
      {
        for (;;)
        {
          paramTextView.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhct
 * JD-Core Version:    0.7.0.1
 */