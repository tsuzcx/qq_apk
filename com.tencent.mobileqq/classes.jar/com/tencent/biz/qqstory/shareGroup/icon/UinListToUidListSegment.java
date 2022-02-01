package com.tencent.biz.qqstory.shareGroup.icon;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class UinListToUidListSegment
  extends JobSegment<List<String>, List<String>>
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  private String a = "story.icon.UinListToUidListSegment";
  
  public UinListToUidListSegment(String paramString) {}
  
  private List<String> a(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = localUserManager.b((String)paramList.next(), false);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      } else {
        return null;
      }
    }
    return localArrayList;
  }
  
  private void b(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new QQUserUIItem.UserID((String)paramList.next(), null));
    }
    new GetUserInfoHandler(this).a(0, localArrayList);
  }
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent == null) || (paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList == null))
    {
      IconLog.b(this.a, "convert user info fail, event=%s", paramUpdateUserInfoEvent);
      if (paramUpdateUserInfoEvent == null) {}
      for (paramUpdateUserInfoEvent = new ErrorMessage(-1, "event is null");; paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage)
      {
        notifyError(paramUpdateUserInfoEvent);
        return;
      }
    }
    IconLog.b(this.a, "convert user info success");
    ArrayList localArrayList = new ArrayList();
    paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.iterator();
    while (paramUpdateUserInfoEvent.hasNext()) {
      localArrayList.add(((QQUserUIItem)paramUpdateUserInfoEvent.next()).uid);
    }
    a(localArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      notifyError(new ErrorMessage(-1, "uinList should not be empty"));
      return;
    }
    paramJobContext = Collections.unmodifiableList(paramList);
    paramList = a(paramJobContext);
    if (paramList != null)
    {
      IconLog.a(this.a, "getUnionIdListFromCache ok");
      a(paramList);
      return;
    }
    IconLog.a(this.a, "fireGetUnionIdListFromServer");
    b(paramJobContext);
  }
  
  protected void a(List<String> paramList)
  {
    IconLog.a(this.a, "notifyResult union id list : " + new JSONArray(paramList));
    super.notifyResult(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.UinListToUidListSegment
 * JD-Core Version:    0.7.0.1
 */