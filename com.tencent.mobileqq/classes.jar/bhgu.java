import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.widget.MiniAppTextArea;
import com.tencent.qqmini.sdk.utils.ColorUtils;
import org.json.JSONObject;

public class bhgu
  implements TextWatcher
{
  public bhgu(MiniAppTextArea paramMiniAppTextArea, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt, JSONObject paramJSONObject3, bgmk parambgmk) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    JSONObject localJSONObject;
    if ((paramCharSequence != null) && (paramCharSequence.length() == 0))
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetMiniAppTextArea.setTextSize(2, this.jdField_a_of_type_OrgJsonJSONObject.optInt("fontSize"));
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetMiniAppTextArea.setTextColor(ColorUtils.parseColor(this.jdField_a_of_type_OrgJsonJSONObject.optString("color")));
      }
      MiniAppTextArea.b(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetMiniAppTextArea);
      if ((paramCharSequence != null) && (!paramCharSequence.toString().equals(MiniAppTextArea.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetMiniAppTextArea))))
      {
        localJSONObject = new JSONObject();
        MiniAppTextArea.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetMiniAppTextArea, paramCharSequence.toString());
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("inputId", this.jdField_a_of_type_Int);
        if (paramInt3 == 0)
        {
          localJSONObject.put("cursor", paramInt1);
          localJSONObject.put("value", MiniAppTextArea.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetMiniAppTextArea));
          if ((paramInt2 == 0) || (paramInt3 != 0)) {
            break label299;
          }
          localJSONObject.put("keyCode", 8);
          localJSONObject.put("data", this.c.optString("data"));
          this.jdField_a_of_type_Bgmk.a("onKeyboardValueChange", localJSONObject.toString(), MiniAppTextArea.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetMiniAppTextArea).b());
          return;
          if (this.b == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetMiniAppTextArea.setTextSize(2, this.b.optInt("fontSize"));
          this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetMiniAppTextArea.setTextColor(ColorUtils.parseColor(this.b.optString("color")));
          break;
        }
        if (paramInt2 != 0)
        {
          paramInt2 -= 1;
          localJSONObject.put("cursor", paramInt1 + paramInt3 - paramInt2);
          continue;
        }
        paramInt2 = 0;
      }
      catch (Exception paramCharSequence)
      {
        QMLog.e("MiniAppTextArea", "onTextChanged error", paramCharSequence);
        return;
      }
      continue;
      label299:
      localJSONObject.put("keyCode", paramCharSequence.charAt(paramInt1 + paramInt3 - 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgu
 * JD-Core Version:    0.7.0.1
 */