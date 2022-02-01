package com.tencent.hippy.qq.module;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import org.json.JSONArray;
import org.json.JSONObject;

class QQUiModule$5
  implements Runnable
{
  QQUiModule$5(QQUiModule paramQQUiModule, String paramString, Promise paramPromise) {}
  
  public void run()
  {
    if (QQUiModule.access$100(this.this$0) != null)
    {
      if (QQUiModule.access$100(this.this$0).isShowing()) {
        QQUiModule.access$100(this.this$0).dismiss();
      }
      if (this.val$strJson.equals(QQUiModule.access$200(this.this$0)))
      {
        QQUiModule.access$302(this.this$0, this.val$promise);
        QQUiModule.access$100(this.this$0).show();
        return;
      }
    }
    Object localObject2 = this.this$0.getActivity();
    if (localObject2 == null)
    {
      QLog.e("QQUiModule", 1, "showActionSheet activity is null");
      return;
    }
    for (;;)
    {
      int n;
      try
      {
        Object localObject1 = new JSONObject(this.val$strJson);
        localObject2 = ActionSheet.create((Context)localObject2);
        Object localObject3 = ((JSONObject)localObject1).optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((ActionSheet)localObject2).setMainTitle((CharSequence)localObject3);
        }
        localObject3 = ((JSONObject)localObject1).optJSONArray("items");
        int m = ((JSONObject)localObject1).optInt("selected", -1);
        Object localObject4 = this.this$0;
        int k = 0;
        QQUiModule.access$402((QQUiModule)localObject4, false);
        localObject4 = ((JSONObject)localObject1).optString("close");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          QQUiModule.access$402(this.this$0, true);
          ((ActionSheet)localObject2).addButton((CharSequence)localObject4, 3);
          i = 1;
          j = i;
          if (localObject3 != null)
          {
            j = i;
            if (((JSONArray)localObject3).length() > 0)
            {
              n = ((JSONArray)localObject3).length();
              j = k;
              if (m >= 0)
              {
                j = k;
                if (m < n)
                {
                  j = 0;
                  if (j >= n) {
                    break label487;
                  }
                  localObject4 = ((JSONArray)localObject3).getString(j);
                  if (j != m) {
                    break label481;
                  }
                  bool = true;
                  ((ActionSheet)localObject2).addRadioButton((CharSequence)localObject4, bool);
                  j += 1;
                  continue;
                }
              }
              if (j >= n) {
                break label487;
              }
              ((ActionSheet)localObject2).addButton(((JSONArray)localObject3).getString(j));
              j += 1;
              continue;
            }
          }
          localObject1 = ((JSONObject)localObject1).optString("cancel");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((ActionSheet)localObject2).addCancelButton((CharSequence)localObject1);
          }
          ((ActionSheet)localObject2).setOnButtonClickListener(this.this$0);
          ((ActionSheet)localObject2).setOnDismissListener(this.this$0);
          ((ActionSheet)localObject2).setOnCancelListener(this.this$0);
          ((ActionSheet)localObject2).registerWatchDisMissActionListener(this.this$0);
          QQUiModule.access$102(this.this$0, (ActionSheet)localObject2);
          QQUiModule.access$302(this.this$0, this.val$promise);
          this.this$0.mActionSheetItemCount = j;
          QQUiModule.access$202(this.this$0, this.val$strJson);
          QQUiModule.access$100(this.this$0).show();
          return;
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showActionSheet error:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("QQUiModule", 2, ((StringBuilder)localObject2).toString());
        return;
      }
      int i = 0;
      continue;
      label481:
      boolean bool = false;
      continue;
      label487:
      int j = i + n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule.5
 * JD-Core Version:    0.7.0.1
 */