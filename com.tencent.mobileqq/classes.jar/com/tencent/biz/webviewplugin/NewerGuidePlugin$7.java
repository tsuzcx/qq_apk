package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import org.json.JSONObject;

class NewerGuidePlugin$7
  implements IphonePickerView.IphonePickListener
{
  NewerGuidePlugin$7(NewerGuidePlugin paramNewerGuidePlugin, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    int i = NewerGuidePlugin.b(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin) + 1897;
    int j = NewerGuidePlugin.c(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin) + 1;
    int k = NewerGuidePlugin.d(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin) + 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onDismissOperations year=%s month=%s day=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", 1);
      ((JSONObject)localObject).put("year", i);
      ((JSONObject)localObject).put("month", j);
      ((JSONObject)localObject).put("date", k);
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuidePlugin", 1, "sendDatePickerResp fail", localException);
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.callJs("respDatePicker", new String[] { ((JSONObject)localObject).toString() });
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          NewerGuidePlugin.d(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, paramInt2);
        }
      }
      else {
        NewerGuidePlugin.c(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, paramInt2);
      }
    }
    else {
      NewerGuidePlugin.b(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, paramInt2);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.7
 * JD-Core Version:    0.7.0.1
 */