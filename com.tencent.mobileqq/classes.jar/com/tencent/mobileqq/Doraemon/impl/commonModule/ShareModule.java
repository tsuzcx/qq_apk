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
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
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
  protected ShareActionSheetBuilder b = null;
  
  private void a(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    paramJSONObject = this.a.h();
    int i;
    if ((paramJSONObject instanceof BaseActivity)) {
      i = ((BaseActivity)paramJSONObject).getTitleBarHeight();
    } else {
      i = 0;
    }
    paramAPICallback = new ShareModule.1(this, i, paramAPICallback);
    if (this.b == null)
    {
      this.b = new ShareActionSheetBuilder(paramJSONObject);
      this.b.setActionSheetTitle(paramJSONObject.getString(2131916565));
      this.b.setActionSheetItems(a(paramJSONObject));
    }
    this.b.setItemClickListener(paramAPICallback);
    try
    {
      this.b.show();
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("DoraemonApi.ShareModule", 2, "actionSheet.show failed!", paramJSONObject);
    }
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894171);
    localActionSheetItem.icon = 2130839221;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894185);
    localActionSheetItem.icon = 2130839222;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894174);
    localActionSheetItem.icon = 2130839219;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, new ArrayList() };
  }
  
  private void b(JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    int i = paramJSONObject.optInt("shareChanel", 0);
    Activity localActivity = this.a.h();
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
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
    if (paramInt != 27)
    {
      if (paramInt != 30) {
        return false;
      }
      a(paramJSONObject, paramAPICallback);
    }
    else
    {
      b(paramJSONObject, paramAPICallback);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.ShareModule
 * JD-Core Version:    0.7.0.1
 */