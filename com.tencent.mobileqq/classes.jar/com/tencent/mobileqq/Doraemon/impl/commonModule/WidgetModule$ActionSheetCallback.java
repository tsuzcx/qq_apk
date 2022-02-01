package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import org.json.JSONException;
import org.json.JSONObject;

class WidgetModule$ActionSheetCallback
  implements DialogInterface.OnCancelListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener
{
  APICallback jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public WidgetModule$ActionSheetCallback(ActionSheet paramActionSheet, APICallback paramAPICallback)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback = paramAPICallback;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramView = new JSONObject();
    try
    {
      paramView.put("cancel", false);
      paramView.put("tapIndex", paramInt);
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      String str = paramView.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
      }
      APICallback localAPICallback = this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      DoraemonUtil.a(localAPICallback, -2, paramView);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("cancel", true);
      paramDialogInterface.put("tapIndex", -1);
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      APICallback localAPICallback = this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      DoraemonUtil.a(localAPICallback, -2, paramDialogInterface);
    }
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cancel", true);
      localJSONObject.put("tapIndex", -1);
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
      }
      APICallback localAPICallback = this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      DoraemonUtil.a(localAPICallback, -2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.WidgetModule.ActionSheetCallback
 * JD-Core Version:    0.7.0.1
 */