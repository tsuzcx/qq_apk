package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class QQStoryShareGroupProfileActivity$UpdateUserInfoEventReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public QQStoryShareGroupProfileActivity$UpdateUserInfoEventReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent.g.isSuccess()) && (paramUpdateUserInfoEvent.b != null) && (!paramUpdateUserInfoEvent.b.isEmpty()) && (paramQQStoryShareGroupProfileActivity.u != null))
    {
      if (paramQQStoryShareGroupProfileActivity.G)
      {
        paramQQStoryShareGroupProfileActivity.d.f.notifyDataSetChanged();
        return;
      }
      int j = 0;
      int i = j;
      Object localObject;
      if (paramQQStoryShareGroupProfileActivity.u.headerUnionIdList != null)
      {
        i = j;
        if (!paramQQStoryShareGroupProfileActivity.u.headerUnionIdList.isEmpty())
        {
          localObject = paramUpdateUserInfoEvent.b.iterator();
          QQUserUIItem localQQUserUIItem;
          do
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
          } while (!paramQQStoryShareGroupProfileActivity.u.headerUnionIdList.contains(localQQUserUIItem.uid));
          i = 1;
        }
      }
      j = i;
      if (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.z))
      {
        paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.b.iterator();
        do
        {
          j = i;
          if (!paramUpdateUserInfoEvent.hasNext()) {
            break;
          }
          localObject = (QQUserUIItem)paramUpdateUserInfoEvent.next();
        } while (!paramQQStoryShareGroupProfileActivity.z.equals(((QQUserUIItem)localObject).uid));
        j = 1;
      }
      if (j != 0) {
        QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramQQStoryShareGroupProfileActivity.u);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.UpdateUserInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */