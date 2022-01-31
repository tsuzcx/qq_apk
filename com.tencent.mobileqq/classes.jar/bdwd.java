import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmini.sdk.runtime.core.page.widget.WebEditText;
import org.json.JSONException;
import org.json.JSONObject;

class bdwd
  implements TextView.OnEditorActionListener
{
  bdwd(bdwa parambdwa, WebEditText paramWebEditText, bdfs parambdfs) {}
  
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
        paramTextView.put("inputId", bdwa.a(this.jdField_a_of_type_Bdwa));
        paramTextView.put("value", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.getText().toString());
        this.jdField_a_of_type_Bdfs.a.a("onKeyboardConfirm", paramTextView.toString(), 0);
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.c()) {
          continue;
        }
        this.jdField_a_of_type_Bdwa.a(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdwd
 * JD-Core Version:    0.7.0.1
 */