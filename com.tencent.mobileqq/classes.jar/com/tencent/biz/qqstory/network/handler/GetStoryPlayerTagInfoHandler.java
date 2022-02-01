package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GetStoryPlayerTagInfoHandler
{
  private static ConcurrentHashMap<String, Long> a = new ConcurrentHashMap();
  
  @Nullable
  public static GetStoryPlayerTagInfoRequest.TagInfoBaseVidList a(String paramString, List<GetStoryPlayerTagInfoRequest.TagInfoBaseVidList> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GetStoryPlayerTagInfoRequest.TagInfoBaseVidList localTagInfoBaseVidList = (GetStoryPlayerTagInfoRequest.TagInfoBaseVidList)paramList.next();
        if (paramString.equals(localTagInfoBaseVidList.a)) {
          return localTagInfoBaseVidList;
        }
      }
    }
    return null;
  }
  
  public static void a(@NonNull List<String> paramList, boolean paramBoolean)
  {
    SLog.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "send request : %s", paramList.toString());
    if (paramBoolean)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Long localLong = (Long)a.get(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 60000L))
        {
          ((Iterator)localObject).remove();
          SLog.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "remove same request for feed info:%s", str);
        }
        else
        {
          a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() == 0) {
      return;
    }
    SLog.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "request for feed info:%s", paramList);
    Object localObject = new GetStoryPlayerTagInfoRequest(paramList);
    CmdTaskManger.a().a((NetworkRequest)localObject, new GetStoryPlayerTagInfoHandler.1(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler
 * JD-Core Version:    0.7.0.1
 */