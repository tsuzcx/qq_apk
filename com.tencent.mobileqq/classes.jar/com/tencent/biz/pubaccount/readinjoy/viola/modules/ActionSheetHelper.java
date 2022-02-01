package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActionSheetHelper
  implements ActionSheet.WatchDismissActions
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private WeakReference<BridgeModule> jdField_a_of_type_JavaLangRefWeakReference = null;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "BridgeModule.ActionSheetHelper";
  }
  
  public ActionSheetHelper(BridgeModule paramBridgeModule)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBridgeModule);
  }
  
  private void b(JSONObject paramJSONObject, String paramString)
  {
    int k = 0;
    if ((paramJSONObject == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = ((BridgeModule)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getViolaInstance().getActivity();
    } while (localObject1 == null);
    for (;;)
    {
      int n;
      try
      {
        localObject1 = ActionSheet.create((Context)localObject1);
        Object localObject2 = paramJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).setMainTitle((CharSequence)localObject2);
        }
        localObject2 = paramJSONObject.optJSONArray("items");
        int m = paramJSONObject.optInt("selected", -1);
        this.jdField_a_of_type_Boolean = false;
        String str = paramJSONObject.optString("close");
        if (TextUtils.isEmpty(str)) {
          break label367;
        }
        this.jdField_a_of_type_Boolean = true;
        ((ActionSheet)localObject1).addButton(str, 3);
        i = 1;
        j = i;
        if (localObject2 != null)
        {
          j = i;
          if (((JSONArray)localObject2).length() > 0)
          {
            n = ((JSONArray)localObject2).length();
            j = k;
            if (m >= 0)
            {
              j = k;
              if (m < n)
              {
                j = 0;
                if (j >= n) {
                  break label378;
                }
                str = ((JSONArray)localObject2).getString(j);
                if (j != m) {
                  break label372;
                }
                bool = true;
                ((ActionSheet)localObject1).addRadioButton(str, bool);
                j += 1;
                continue;
              }
            }
            if (j >= n) {
              break label378;
            }
            ((ActionSheet)localObject1).addButton(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        paramJSONObject = paramJSONObject.optString("cancel");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          ((ActionSheet)localObject1).addCancelButton(paramJSONObject);
        }
        ((ActionSheet)localObject1).setOnButtonClickListener(new ActionSheetHelper.2(this, paramString));
        ((ActionSheet)localObject1).setOnDismissListener(new ActionSheetHelper.3(this, paramString));
        ((ActionSheet)localObject1).setOnCancelListener(new ActionSheetHelper.4(this, paramString));
        ((ActionSheet)localObject1).registerWatchDisMissActionListener(this);
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject1);
        this.jdField_a_of_type_Int = j;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showActionSheet error:" + paramJSONObject.getMessage());
      return;
      label367:
      int i = 0;
      continue;
      label372:
      boolean bool = false;
      continue;
      label378:
      int j = i + n;
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    new Handler(BaseActivity.sTopActivity.getMainLooper()).post(new ActionSheetHelper.1(this, paramJSONObject, paramString));
  }
  
  public void onDismissOperations() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.ActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */