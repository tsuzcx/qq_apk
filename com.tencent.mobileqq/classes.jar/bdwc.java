import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Map;
import org.json.JSONObject;

class bdwc
  implements TextWatcher
{
  bdwc(bdwa parambdwa, bdfs parambdfs) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((bdwa.a(this.jdField_a_of_type_Bdwa).containsKey(Integer.valueOf(bdwa.a(this.jdField_a_of_type_Bdwa)))) && (paramCharSequence.toString().equals(bdwa.a(this.jdField_a_of_type_Bdwa).get(Integer.valueOf(bdwa.a(this.jdField_a_of_type_Bdwa)))))) {
      return;
    }
    bdwa.a(this.jdField_a_of_type_Bdwa).remove(Integer.valueOf(bdwa.a(this.jdField_a_of_type_Bdwa)));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", bdwa.a(this.jdField_a_of_type_Bdwa));
      if (paramInt3 == 0)
      {
        localJSONObject.put("cursor", paramInt1);
        localJSONObject.put("value", paramCharSequence.toString());
        if ((paramInt2 == 0) || (paramInt3 != 0)) {
          break label241;
        }
        localJSONObject.put("keyCode", 8);
        label154:
        localJSONObject.put("data", new JSONObject(this.jdField_a_of_type_Bdfs.b).optString("data"));
        this.jdField_a_of_type_Bdfs.a("onKeyboardValueChange", localJSONObject.toString(), bdwa.a(this.jdField_a_of_type_Bdwa).b());
        return;
      }
    }
    catch (Exception paramCharSequence)
    {
      bdnw.d("WebInputHandler", "onTextChanged error", paramCharSequence);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdwc
 * JD-Core Version:    0.7.0.1
 */