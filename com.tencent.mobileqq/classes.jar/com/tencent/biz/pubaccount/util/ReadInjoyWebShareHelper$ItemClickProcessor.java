package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.jetbrains.annotations.NotNull;

class ReadInjoyWebShareHelper$ItemClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  ReadInjoyWebShareHelper$ItemClickProcessor(ReadInjoyWebShareHelper paramReadInjoyWebShareHelper) {}
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    ActionItem localActionItem = ReadInjoyWebShareHelper.a(this.a).a(ReadInjoyWebShareHelper.a(this.a), ReadInjoyWebShareHelper.b(this.a), paramInt);
    if (localActionItem == null) {
      return false;
    }
    if (localActionItem.jdField_a_of_type_Boolean)
    {
      this.a.b(localActionItem.jdField_a_of_type_JavaLangString);
      return true;
    }
    switch (paramInt)
    {
    default: 
      this.a.b(localActionItem.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return super.a(paramInt, paramActionSheetItem);
      this.a.b(localActionItem.jdField_a_of_type_JavaLangString);
      continue;
      ReadInjoyWebShareHelper.a(this.a, paramActionSheetItem);
      continue;
      ReadInjoyWebShareHelper.a(this.a).a(ReadInjoyWebShareHelper.a(this.a).c);
      ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
      continue;
      ReadInjoyWebShareHelper.a(this.a).b(ReadInjoyWebShareHelper.a(this.a).c);
      ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
      continue;
      ReadInjoyWebShareHelper.a(this.a).c();
      ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
      continue;
      ReadInjoyWebShareHelper.a(this.a).a(this.a);
      ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
      continue;
      ReadInjoyWebShareHelper.a(this.a);
      ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
      continue;
      if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).c))
      {
        TeamWorkConvertUtils.a(1, 3);
        TeamWorkConvertUtils.a(ReadInjoyWebShareHelper.a(this.a).c, ReadInjoyWebShareHelper.a(this.a).jdField_a_of_type_JavaLangString);
        ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
        continue;
        if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).c))
        {
          this.a.a.d(ReadInjoyWebShareHelper.a(this.a).c, new ReadInjoyWebShareHelper.ItemClickProcessor.1(this, localActionItem));
          continue;
          ReadInjoyWebShareHelper.a(this.a).c(ReadInjoyWebShareHelper.a(this.a).c);
          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
          continue;
          ReadInjoyWebShareHelper.b(this.a);
          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
          continue;
          this.a.b("not_care");
          continue;
          Object localObject;
          if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).e))
          {
            localObject = AddFriendLogicActivity.a(this.a.a(), 1, ReadInjoyWebShareHelper.a(this.a).e + "", null, 3096, 1, ReadInjoyWebShareHelper.a(this.a).f, null, null, null, null);
            this.a.a().startActivity((Intent)localObject);
          }
          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
          continue;
          if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).e))
          {
            localObject = AIOUtils.a(new Intent(this.a.a(), SplashActivity.class), null);
            ((Intent)localObject).putExtra("uin", ReadInjoyWebShareHelper.a(this.a).e);
            ((Intent)localObject).putExtra("uintype", 0);
            this.a.a().startActivity((Intent)localObject);
            ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
            continue;
            if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).e))
            {
              localObject = new ActivityURIRequest(this.a.a(), "/pubaccount/detail");
              ((ActivityURIRequest)localObject).extra().putString("uin", ReadInjoyWebShareHelper.a(this.a).e);
              ((ActivityURIRequest)localObject).extra().putBoolean("from_js", true);
              QRoute.startUri((URIRequest)localObject, null);
              ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
              continue;
              this.a.b("unfollow");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.ItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */