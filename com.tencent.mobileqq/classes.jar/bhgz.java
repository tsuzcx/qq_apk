import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import java.util.Map;
import org.json.JSONObject;

class bhgz
  implements TextWatcher
{
  bhgz(bhgx parambhgx, bgmk parambgmk) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((bhgx.a(this.jdField_a_of_type_Bhgx).containsKey(Integer.valueOf(bhgx.a(this.jdField_a_of_type_Bhgx)))) && (paramCharSequence.toString().equals(bhgx.a(this.jdField_a_of_type_Bhgx).get(Integer.valueOf(bhgx.a(this.jdField_a_of_type_Bhgx)))))) {
      return;
    }
    bhgx.a(this.jdField_a_of_type_Bhgx).remove(Integer.valueOf(bhgx.a(this.jdField_a_of_type_Bhgx)));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("inputId", bhgx.a(this.jdField_a_of_type_Bhgx));
      if (paramInt3 == 0)
      {
        localJSONObject.put("cursor", paramInt1);
        localJSONObject.put("value", paramCharSequence.toString());
        if ((paramInt2 == 0) || (paramInt3 != 0)) {
          break label241;
        }
        localJSONObject.put("keyCode", 8);
        label154:
        localJSONObject.put("data", new JSONObject(this.jdField_a_of_type_Bgmk.b).optString("data"));
        this.jdField_a_of_type_Bgmk.a("onKeyboardValueChange", localJSONObject.toString(), bhgx.a(this.jdField_a_of_type_Bhgx).b());
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
 * Qualified Name:     bhgz
 * JD-Core Version:    0.7.0.1
 */