import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmini.sdk.runtime.core.page.widget.WebEditText;
import org.json.JSONException;
import org.json.JSONObject;

class bhha
  implements TextView.OnEditorActionListener
{
  bhha(bhgx parambhgx, WebEditText paramWebEditText, bgmk parambgmk) {}
  
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
        paramTextView.put("inputId", bhgx.a(this.jdField_a_of_type_Bhgx));
        paramTextView.put("value", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.getText().toString());
        this.jdField_a_of_type_Bgmk.a.a("onKeyboardConfirm", paramTextView.toString(), 0);
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.c()) {
          continue;
        }
        this.jdField_a_of_type_Bhgx.a(true);
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
 * Qualified Name:     bhha
 * JD-Core Version:    0.7.0.1
 */