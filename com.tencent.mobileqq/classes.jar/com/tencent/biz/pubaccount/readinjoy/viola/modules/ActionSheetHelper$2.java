package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class ActionSheetHelper$2
  implements ActionSheet.OnButtonClickListener
{
  ActionSheetHelper$2(ActionSheetHelper paramActionSheetHelper, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    for (;;)
    {
      try
      {
        paramView.put("index", paramInt);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesActionSheetHelper.a) || (paramInt != 0)) {
          continue;
        }
        paramView.put("type", 2);
        if (ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesActionSheetHelper) != null) {
          ((BridgeModule)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesActionSheetHelper).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
        }
      }
      catch (JSONException paramView)
      {
        continue;
      }
      ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesActionSheetHelper).dismiss();
      return;
      paramView.put("type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.ActionSheetHelper.2
 * JD-Core Version:    0.7.0.1
 */