import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Map;
import org.json.JSONObject;

class bhcs
  implements TextWatcher
{
  bhcs(bhcq parambhcq, bgid parambgid) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((bhcq.a(this.jdField_a_of_type_Bhcq).containsKey(Integer.valueOf(bhcq.a(this.jdField_a_of_type_Bhcq)))) && (paramCharSequence.toString().equals(bhcq.a(this.jdField_a_of_type_Bhcq).get(Integer.valueOf(bhcq.a(this.jdField_a_of_type_Bhcq)))))) {
      return;
    }
    bhcq.a(this.jdField_a_of_type_Bhcq).remove(Integer.valueOf(bhcq.a(this.jdField_a_of_type_Bhcq)));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", bhcq.a(this.jdField_a_of_type_Bhcq));
      if (paramInt3 == 0)
      {
        localJSONObject.put("cursor", paramInt1);
        localJSONObject.put("value", paramCharSequence.toString());
        if ((paramInt2 == 0) || (paramInt3 != 0)) {
          break label241;
        }
        localJSONObject.put("keyCode", 8);
        label154:
        localJSONObject.put("data", new JSONObject(this.jdField_a_of_type_Bgid.b).optString("data"));
        this.jdField_a_of_type_Bgid.a("onKeyboardValueChange", localJSONObject.toString(), bhcq.a(this.jdField_a_of_type_Bhcq).b());
        return;
      }
    }
    catch (Exception paramCharSequence)
    {
      QMLog.e("WebInputHandler", "onTextChanged error", paramCharSequence);
      return;
    }
    if (paramInt2 != 0) {
      paramInt2 -= 1;
    }
    for (;;)
    {
      localJSONObject.put("cursor", paramInt1 + paramInt3 - paramInt2);
      break;
      label241:
      localJSONObject.put("keyCode", paramCharSequence.charAt(paramInt1 + paramInt3 - 1));
      break label154;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhcs
 * JD-Core Version:    0.7.0.1
 */