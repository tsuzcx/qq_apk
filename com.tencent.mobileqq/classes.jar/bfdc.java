import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Map;
import org.json.JSONObject;

class bfdc
  implements TextWatcher
{
  bfdc(bfda parambfda, bekj parambekj) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((bfda.a(this.jdField_a_of_type_Bfda).containsKey(Integer.valueOf(bfda.a(this.jdField_a_of_type_Bfda)))) && (paramCharSequence.toString().equals(bfda.a(this.jdField_a_of_type_Bfda).get(Integer.valueOf(bfda.a(this.jdField_a_of_type_Bfda)))))) {
      return;
    }
    bfda.a(this.jdField_a_of_type_Bfda).remove(Integer.valueOf(bfda.a(this.jdField_a_of_type_Bfda)));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", bfda.a(this.jdField_a_of_type_Bfda));
      if (paramInt3 == 0)
      {
        localJSONObject.put("cursor", paramInt1);
        localJSONObject.put("value", paramCharSequence.toString());
        if ((paramInt2 == 0) || (paramInt3 != 0)) {
          break label241;
        }
        localJSONObject.put("keyCode", 8);
        label154:
        localJSONObject.put("data", new JSONObject(this.jdField_a_of_type_Bekj.b).optString("data"));
        this.jdField_a_of_type_Bekj.a("onKeyboardValueChange", localJSONObject.toString(), bfda.a(this.jdField_a_of_type_Bfda).b());
        return;
      }
    }
    catch (Exception paramCharSequence)
    {
      betc.d("WebInputHandler", "onTextChanged error", paramCharSequence);
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
 * Qualified Name:     bfdc
 * JD-Core Version:    0.7.0.1
 */