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
  extends JobSegment
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  private String a = "story.icon.UidListToUrlListSegment";
  
  public UidListToUrlListSegment(String paramString) {}
  
  private Pair a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      QQUserUIItem localQQUserUIItem = localUserManager.b((String)paramList.next());
      if ((localQQUserUIItem != null) && (localQQUserUIItem.headUrl != null)) {
        localArrayList.add(localQQUserUIItem.headUrl);
      }
      for (;;)
      {
        break;
        localArrayList.add("stub_url");
        bool = false;
      }
    }
    return new Pair(localArrayList, Boolean.valueOf(bool));
  }
  
  private void b(List paramList)
  {
    IconLog.a(this.a, "fireRefreshUserInfo : %s", new JSONArray(paramList));
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new QQUserUIItem.UserID(null, (String)paramList.next()));
    }
    new GetUserInfoHandler(this).a(1, localArrayList);
  }
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent == null) || (paramUpdateUserInfoEvent.errorInfo.isFail()) || (paramUpdateUserInfoEvent.a == null))
    {
      IconLog.b(this.a, "refresh user info fail %s", paramUpdateUserInfoEvent);
      if (paramUpdateUserInfoEvent == null) {}
      for (paramUpdateUserInfoEvent = new ErrorMessage(-1, "event is null");; paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.errorInfo)
      {
        notifyError(paramUpdateUserInfoEvent);
        return;
      }
    }
    IconLog.a(this.a, "refresh user info success, let's return the new info");
    ArrayList localArrayList = new ArrayList();
    paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.a.iterator();
    while (paramUpdateUserInfoEvent.hasNext()) {
      localArrayList.add(((QQUserUIItem)paramUpdateUserInfoEvent.next()).headUrl);
    }
    a(localArrayList);
  }
  
  protected void a(JobContext paramJobContext, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      notifyError(new ErrorMessage(-1, ""));
    }
    do
    {
      return;
      paramJobContext = Collections.unmodifiableList(paramList);
      paramList = a(paramJobContext);
      IconLog.a(this.a, "getUnionIdListFromCache ok=%s", paramList.second);
      a((List)paramList.first);
    } while (((Boolean)paramList.second).booleanValue());
    IconLog.a(this.a, "fireRefreshUserInfo");
    b(paramJobContext);
  }
  
  protected void a(List paramList)
  {
    IconLog.a(this.a, "notifyResult url list : " + new JSONArray(paramList));
    if (paramList.size() == 1)
    {
      IconLog.b(this.a, "add one more default item because of product logic");
      paramList.add("stub_url");
    }
    super.notifyResult(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.UidListToUrlListSegment
 * JD-Core Version:    0.7.0.1
 */