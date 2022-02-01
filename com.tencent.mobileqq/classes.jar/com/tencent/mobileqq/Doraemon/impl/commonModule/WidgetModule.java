package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import org.json.JSONArray;
import org.json.JSONObject;

public class WidgetModule
  extends DoraemonAPIModule
{
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    int i = 0;
    if (paramInt != 28)
    {
      if (paramInt != 29) {
        return false;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if ((paramString != null) && (paramString.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
      if ((paramString != null) && (!paramString.isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramString, 230);
        paramString = paramJSONObject.optString("title");
        if (!TextUtils.isEmpty(paramString)) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString);
        }
        paramString = paramJSONObject.optString("content");
        if (!TextUtils.isEmpty(paramString)) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
        }
        paramString = new WidgetModule.DialogCallback(paramAPICallback);
        paramAPICallback = paramJSONObject.optString("confirmText");
        if (!TextUtils.isEmpty(paramAPICallback)) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramAPICallback, paramString);
        }
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramJSONObject, paramString);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(paramString);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return true;
      }
      QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
      return false;
    }
    paramString = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((paramString != null) && (paramString.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
    if ((paramString != null) && (!paramString.isFinishing()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        DoraemonUtil.a(paramAPICallback, -1, "param error");
        return true;
      }
      int j = paramString.length();
      for (paramInt = 0; i < j; paramInt = 1)
      {
        String str = paramString.optString(i, "");
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(str);
        i += 1;
      }
      paramString = new WidgetModule.ActionSheetCallback(this.jdField_a_of_type_ComTencentWidgetActionSheet, paramAPICallback);
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(paramJSONObject);
        paramInt = 1;
      }
      if (paramInt != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(paramString);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnCancelListener(paramString);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(paramString);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return true;
      }
      DoraemonUtil.a(paramAPICallback, -1, "param error");
      return true;
    }
    QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
    return false;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.WidgetModule
 * JD-Core Version:    0.7.0.1
 */