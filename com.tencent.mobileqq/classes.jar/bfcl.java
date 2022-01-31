import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Map;
import org.json.JSONObject;

class bfcl
  implements TextWatcher
{
  bfcl(bfcj parambfcj, bejs parambejs) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((bfcj.a(this.jdField_a_of_type_Bfcj).containsKey(Integer.valueOf(bfcj.a(this.jdField_a_of_type_Bfcj)))) && (paramCharSequence.toString().equals(bfcj.a(this.jdField_a_of_type_Bfcj).get(Integer.valueOf(bfcj.a(this.jdField_a_of_type_Bfcj)))))) {
      return;
    }
    bfcj.a(this.jdField_a_of_type_Bfcj).remove(Integer.valueOf(bfcj.a(this.jdField_a_of_type_Bfcj)));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", bfcj.a(this.jdField_a_of_type_Bfcj));
      if (paramInt3 == 0)
      {
        localJSONObject.put("cursor", paramInt1);
        localJSONObject.put("value", paramCharSequence.toString());
        if ((paramInt2 == 0) || (paramInt3 != 0)) {
          break label241;
        }
        localJSONObject.put("keyCode", 8);
        label154:
        localJSONObject.put("data", new JSONObject(this.jdField_a_of_type_Bejs.b).optString("data"));
        this.jdField_a_of_type_Bejs.a("onKeyboardValueChange", localJSONObject.toString(), bfcj.a(this.jdField_a_of_type_Bfcj).b());
        return;
      }
    }
    catch (Exception paramCharSequence)
    {
      besl.d("WebInputHandler", "onTextChanged error", paramCharSequence);
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
 * Qualified Name:     bfcl
 * JD-Core Version:    0.7.0.1
 */