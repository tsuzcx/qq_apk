package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ShareModule
  extends DoraemonAPIModule
{
  protected ShareActionSheetBuilder a;
  
  public ShareModule()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
  }
  
  private void a(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
    if ((paramJSONObject instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)paramJSONObject).getTitleBarHeight();; i = 0)
    {
      paramAPICallback = new ShareModule.1(this, i, paramAPICallback);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(paramJSONObject);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(paramJSONObject.getString(2131719311));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(paramJSONObject));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(paramAPICallback);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("DoraemonApi.ShareModule", 2, "actionSheet.show failed!", paramJSONObject);
      }
    }
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696380);
    localActionSheetItem.icon = 2130839214;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696394);
    localActionSheetItem.icon = 2130839215;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696401);
    localActionSheetItem.icon = 2130839218;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696383);
    localActionSheetItem.icon = 2130839212;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, new ArrayList() };
  }
  
  private void b(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    int i = paramJSONObject.optInt("shareChanel", 0);
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
    if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
    {
      DoraemonUtil.a(paramAPICallback, -1, "net work not available");
      return;
    }
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 8);
    localIntent.putExtra("chanelId", i);
    localIntent.putExtra("params", paramJSONObject.toString());
    localActivity.startActivity(localIntent);
    DoraemonUtil.a(paramAPICallback, APIParam.a);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    switch (paramInt)
    {
    case 28: 
    case 29: 
    default: 
      return false;
    case 30: 
      a(paramJSONObject, paramAPICallback);
    }
    for (;;)
    {
      return true;
      b(paramJSONObject, paramAPICallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.ShareModule
 * JD-Core Version:    0.7.0.1
 */