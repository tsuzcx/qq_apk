package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import org.json.JSONObject;

class NewerGuidePlugin$6
  implements IphonePickerView.IphonePickListener
{
  NewerGuidePlugin$6(NewerGuidePlugin paramNewerGuidePlugin, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("onConfirmBtClicked mSelectedIndex=%s", new Object[] { Integer.valueOf(NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin)) }));
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", 1);
      ((JSONObject)localObject).put("index", NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin));
    }
    catch (Exception localException)
    {
      QLog.e("NewerGuidePlugin", 1, "sendSelectorResp fail", localException);
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.callJs("respSelector", new String[] { ((JSONObject)localObject).toString() });
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.6
 * JD-Core Version:    0.7.0.1
 */