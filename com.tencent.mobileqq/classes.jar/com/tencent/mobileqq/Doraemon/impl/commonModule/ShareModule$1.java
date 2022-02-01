package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ShareModule$1
  implements AdapterView.OnItemClickListener
{
  ShareModule$1(ShareModule paramShareModule, int paramInt, APICallback paramAPICallback) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    long l;
    if (localObject1 == null)
    {
      l = paramLong;
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, l);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleShareModule.a.dismiss();
    label104:
    int j;
    int i;
    switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.action)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      j = (int)paramLong;
      if ((paramLong == 2L) || (paramLong == 3L)) {
        if (!WXShareHelper.a().a()) {
          i = 2131720753;
        }
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        if (i != -1)
        {
          localObject1 = BaseApplicationImpl.getContext();
          QQToast.a((Context)localObject1, ((Context)localObject1).getString(i), 0).b(this.jdField_a_of_type_Int);
          l = paramLong;
          break;
          paramLong = 0L;
          break label104;
          paramLong = 1L;
          break label104;
          paramLong = 3L;
          break label104;
          paramLong = 2L;
          break label104;
          paramLong = 4L;
          break label104;
          if (WXShareHelper.a().b()) {
            break label358;
          }
          i = 2131720754;
          continue;
        }
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("selectChanel", j);
          DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, (JSONObject)localObject1);
          l = paramLong;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("DoraemonApi.ShareModule", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
          l = paramLong;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str = localException.getMessage();
            QLog.e("DoraemonApi.ShareModule", 1, "put channel failed!");
            APICallback localAPICallback = this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback;
            Object localObject2 = str;
            if (str == null) {
              localObject2 = "";
            }
            DoraemonUtil.a(localAPICallback, -1, (String)localObject2);
          }
        }
      }
      label358:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.ShareModule.1
 * JD-Core Version:    0.7.0.1
 */