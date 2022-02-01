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
  private QQCustomDialog b;
  private ActionSheet c;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    int i = 0;
    if (paramInt != 28)
    {
      if (paramInt != 29) {
        return false;
      }
      paramString = this.b;
      if ((paramString != null) && (paramString.isShowing())) {
        this.b.dismiss();
      }
      paramString = this.a.h();
      if ((paramString != null) && (!paramString.isFinishing()))
      {
        this.b = DialogUtil.a(paramString, 230);
        paramString = paramJSONObject.optString("title");
        if (!TextUtils.isEmpty(paramString)) {
          this.b.setTitle(paramString);
        }
        paramString = paramJSONObject.optString("content");
        if (!TextUtils.isEmpty(paramString)) {
          this.b.setMessage(paramString);
        }
        paramString = new WidgetModule.DialogCallback(paramAPICallback);
        paramAPICallback = paramJSONObject.optString("confirmText");
        if (!TextUtils.isEmpty(paramAPICallback)) {
          this.b.setPositiveButton(paramAPICallback, paramString);
        }
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.b.setNegativeButton(paramJSONObject, paramString);
        }
        this.b.setOnCancelListener(paramString);
        this.b.show();
        return true;
      }
      QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
      return false;
    }
    paramString = this.c;
    if ((paramString != null) && (paramString.isShowing())) {
      this.c.dismiss();
    }
    paramString = this.a.h();
    if ((paramString != null) && (!paramString.isFinishing()))
    {
      this.c = ActionSheet.create(paramString);
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
        this.c.addButton(str);
        i += 1;
      }
      paramString = new WidgetModule.ActionSheetCallback(this.c, paramAPICallback);
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        this.c.addCancelButton(paramJSONObject);
        paramInt = 1;
      }
      if (paramInt != 0)
      {
        this.c.setOnButtonClickListener(paramString);
        this.c.setOnCancelListener(paramString);
        this.c.setOnDismissListener(paramString);
        this.c.show();
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
    Object localObject = this.b;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.b.dismiss();
    }
    localObject = this.c;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing())) {
      this.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.WidgetModule
 * JD-Core Version:    0.7.0.1
 */