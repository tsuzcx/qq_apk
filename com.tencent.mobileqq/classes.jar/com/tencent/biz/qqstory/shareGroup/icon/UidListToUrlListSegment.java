package com.tencent.biz.qqstory.shareGroup.icon;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.util.Pair;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class UidListToUrlListSegment
  extends JobSegment<List<String>, List<String>>
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  private String a = "story.icon.UidListToUrlListSegment";
  
  public UidListToUrlListSegment(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    this.a = localStringBuilder.toString();
  }
  
  private void b(List<String> paramList)
  {
    IconLog.a(this.a, "fireRefreshUserInfo : %s", new JSONArray(paramList));
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new QQUserUIItem.UserID(null, (String)paramList.next()));
    }
    new GetUserInfoHandler(this).a(1, localArrayList);
  }
  
  private Pair<List<String>, Boolean> c(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    paramList = paramList.iterator();
    boolean bool = true;
    while (paramList.hasNext())
    {
      QQUserUIItem localQQUserUIItem = localUserManager.b((String)paramList.next());
      if ((localQQUserUIItem != null) && (localQQUserUIItem.headUrl != null))
      {
        localArrayList.add(localQQUserUIItem.headUrl);
      }
      else
      {
        localArrayList.add("stub_url");
        bool = false;
      }
    }
    return new Pair(localArrayList, Boolean.valueOf(bool));
  }
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent != null) && (!paramUpdateUserInfoEvent.g.isFail()) && (paramUpdateUserInfoEvent.b != null))
    {
      IconLog.a(this.a, "refresh user info success, let's return the new info");
      ArrayList localArrayList = new ArrayList();
      paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.b.iterator();
      while (paramUpdateUserInfoEvent.hasNext()) {
        localArrayList.add(((QQUserUIItem)paramUpdateUserInfoEvent.next()).headUrl);
      }
      a(localArrayList);
      return;
    }
    IconLog.b(this.a, "refresh user info fail %s", paramUpdateUserInfoEvent);
    if (paramUpdateUserInfoEvent == null) {
      paramUpdateUserInfoEvent = new ErrorMessage(-1, "event is null");
    } else {
      paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.g;
    }
    notifyError(paramUpdateUserInfoEvent);
  }
  
  protected void a(JobContext paramJobContext, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramJobContext = Collections.unmodifiableList(paramList);
      paramList = c(paramJobContext);
      IconLog.a(this.a, "getUnionIdListFromCache ok=%s", paramList.second);
      a((List)paramList.first);
      if (!((Boolean)paramList.second).booleanValue())
      {
        IconLog.a(this.a, "fireRefreshUserInfo");
        b(paramJobContext);
      }
      return;
    }
    notifyError(new ErrorMessage(-1, ""));
  }
  
  protected void a(List<String> paramList)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyResult url list : ");
    localStringBuilder.append(new JSONArray(paramList));
    IconLog.a(str, localStringBuilder.toString());
    if (paramList.size() == 1)
    {
      IconLog.b(this.a, "add one more default item because of product logic");
      paramList.add("stub_url");
    }
    super.notifyResult(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.UidListToUrlListSegment
 * JD-Core Version:    0.7.0.1
 */