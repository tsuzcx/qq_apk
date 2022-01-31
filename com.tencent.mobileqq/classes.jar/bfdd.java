import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqmini.sdk.runtime.core.page.widget.WebEditText;
import org.json.JSONException;
import org.json.JSONObject;

class bfdd
  implements TextView.OnEditorActionListener
{
  bfdd(bfda parambfda, WebEditText paramWebEditText, bekj parambekj) {}
  
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
        paramTextView.put("inputId", bfda.a(this.jdField_a_of_type_Bfda));
        paramTextView.put("value", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.getText().toString());
        this.jdField_a_of_type_Bekj.a.a("onKeyboardConfirm", paramTextView.toString(), 0);
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.c()) {
          continue;
        }
        this.jdField_a_of_type_Bfda.a(true);
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
 * Qualified Name:     bfdd
 * JD-Core Version:    0.7.0.1
 */