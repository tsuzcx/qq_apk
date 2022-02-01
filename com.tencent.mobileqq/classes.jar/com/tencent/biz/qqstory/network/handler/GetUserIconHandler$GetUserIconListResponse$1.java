package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspIconPostfix;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.IconInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UsrIcon;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class GetUserIconHandler$GetUserIconListResponse$1
  extends SimpleJob<Void>
{
  GetUserIconHandler$GetUserIconListResponse$1(GetUserIconHandler.GetUserIconListResponse paramGetUserIconListResponse, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = this.a.a.icon_info.get();
    HashMap localHashMap = new HashMap();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    Iterator localIterator = paramJobContext.iterator();
    while (localIterator.hasNext())
    {
      paramJobContext = (qqstory_struct.IconInfo)localIterator.next();
      String str2 = paramJobContext.union_id.get().toStringUtf8();
      QQUserUIItem localQQUserUIItem = localUserManager.b(str2);
      if (localQQUserUIItem != null)
      {
        if ((paramJobContext.err_code.get() == 0) && (paramJobContext.usr_icon_list.has()) && (paramJobContext.usr_icon_list.size() > 0))
        {
          paramJobContext = (qqstory_struct.UsrIcon)paramJobContext.usr_icon_list.get(0);
          paramVarArgs = paramJobContext.icon_postfix.get().toStringUtf8();
          String str1 = paramJobContext.jmp_postfix.get().toStringUtf8();
          paramJobContext = paramVarArgs;
          if (!TextUtils.isEmpty(paramVarArgs))
          {
            paramJobContext = new StringBuilder();
            paramJobContext.append("https://pub.idqqimg.com/pc/misc/qqstory_icon/");
            paramJobContext.append(paramVarArgs);
            paramJobContext = paramJobContext.toString();
          }
          paramVarArgs = str1;
          if (!TextUtils.isEmpty(str1))
          {
            paramVarArgs = new StringBuilder();
            paramVarArgs.append("https://story.now.qq.com/mobile/pages/medal.html?_bid=2473&_wv=1031");
            paramVarArgs.append(str1);
            paramVarArgs = paramVarArgs.toString();
          }
          localHashMap.put(str2, new String[] { paramJobContext, paramVarArgs });
          localQQUserUIItem.setUserIcon(paramJobContext, paramVarArgs);
        }
        else
        {
          localHashMap.put(str2, new String[] { "", "" });
          localQQUserUIItem.setUserIcon("", "");
        }
        localQQUserUIItem.iconUrlCacheTime = System.currentTimeMillis();
        localUserManager.a(localQQUserUIItem);
      }
    }
    paramJobContext = new GetUserIconHandler.UserIconUpdateEvent();
    paramJobContext.a = localHashMap;
    StoryDispatcher.a().dispatch(paramJobContext);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler.GetUserIconListResponse.1
 * JD-Core Version:    0.7.0.1
 */