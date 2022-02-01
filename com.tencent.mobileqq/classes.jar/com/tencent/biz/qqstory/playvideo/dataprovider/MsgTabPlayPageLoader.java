package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MsgTabPlayPageLoader
  extends IGroupPageLoader.BaseGroupPageLoader
{
  private final MsgTabPlayInfo a;
  private final List<MsgTabNodeInfo> b;
  
  public MsgTabPlayPageLoader(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.a = paramMsgTabPlayInfo;
    MsgTabStoryManager localMsgTabStoryManager = (MsgTabStoryManager)PlayModeUtils.b().getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
    this.b = new ArrayList();
    if (paramMsgTabPlayInfo.source == 0) {
      MsgTabStoryUtil.a(localMsgTabStoryManager.a().d(), this.b, paramMsgTabPlayInfo.nodeUnionId);
    }
  }
  
  public static MsgTabVideoData b(List<MsgTabVideoData> paramList)
  {
    MsgTabVideoData localMsgTabVideoData = null;
    Object localObject1 = null;
    Object localObject2 = localMsgTabVideoData;
    if (paramList != null)
    {
      localObject2 = localMsgTabVideoData;
      if (paramList.size() > 0)
      {
        int i = 0;
        int j = paramList.size();
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= j) {
            break;
          }
          localMsgTabVideoData = (MsgTabVideoData)paramList.get(i);
          if (localMsgTabVideoData.f) {
            return localMsgTabVideoData;
          }
          if (localObject1 == null)
          {
            localObject2 = localMsgTabVideoData;
          }
          else
          {
            localObject2 = localObject1;
            if (localObject1.a)
            {
              localObject2 = localObject1;
              if (!localMsgTabVideoData.a) {
                return (MsgTabVideoData)paramList.get(i);
              }
            }
          }
          i += 1;
          localObject1 = localObject2;
        }
      }
    }
    return localObject2;
  }
  
  public List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new MsgTabPlayPageLoader.MsgTabVidSyncer((MsgTabPlayPageLoader.MsgTabGroupId)paramList.next()));
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    if (this.a.source == 1)
    {
      localObject = ((StoryHaloManager)PlayModeUtils.b().getManager(QQManagerFactory.STORY_HALO_MANAGER)).b(this.a.uin);
      if (localObject != null)
      {
        ((MsgTabNodeInfo)localObject).w = this.a.source;
        this.b.add(localObject);
      }
      else
      {
        SLog.d("Q.qqstory.player.data.MsgTabPlayPageLoader", "no data for header group");
      }
    }
    Object localObject = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(MsgTabPlayPageLoader.MsgTabGroupId.a((MsgTabNodeInfo)localIterator.next()));
    }
    paramCallBack.a(new ErrorMessage(), (List)localObject, true);
  }
  
  public boolean a(IDataProvider.GroupInfo paramGroupInfo)
  {
    if ((paramGroupInfo != null) && (paramGroupInfo.e()))
    {
      AssertUtils.assertTrue(paramGroupInfo.b instanceof MsgTabPlayPageLoader.MsgTabGroupId);
      MsgTabPlayPageLoader.MsgTabGroupId localMsgTabGroupId = (MsgTabPlayPageLoader.MsgTabGroupId)paramGroupInfo.b;
      if (localMsgTabGroupId.g)
      {
        SLog.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "won't needSyncVidList. groupId %s is end", localMsgTabGroupId.a());
        return false;
      }
      int i = localMsgTabGroupId.f;
      if (paramGroupInfo.e != i) {
        SLog.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList() groupId %s, position not match: %d != %d", localMsgTabGroupId.a(), Integer.valueOf(paramGroupInfo.e), Integer.valueOf(i));
      }
      if ((i >= 0) && (paramGroupInfo.c.size() - i >= 10))
      {
        SLog.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. not need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramGroupInfo.c.size()), paramGroupInfo);
        return false;
      }
      SLog.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramGroupInfo.c.size()), paramGroupInfo);
      return true;
    }
    SLog.c("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync");
    return true;
  }
  
  public void b() {}
  
  public IDataProvider.StartInfo c()
  {
    Object localObject = new MsgTabPlayPageLoader.MsgTabGroupId(this.a.nodeUnionId);
    ((MsgTabPlayPageLoader.MsgTabGroupId)localObject).a = ((MsgTabStoryManager)QQStoryContext.j().getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).b(this.a.nodeUnionId);
    IDataProvider.StartInfo localStartInfo = new IDataProvider.StartInfo((IDataProvider.GroupId)localObject, this.a.mStartVid, this.a.mStartVideoFeedId);
    if ((this.a.mVids != null) && (!this.a.mVids.isEmpty()) && (this.a.mFeedIdMap != null) && (!this.a.mFeedIdMap.isEmpty()))
    {
      localObject = new IDataProvider.GroupInfo((IDataProvider.GroupId)localObject);
      ((IDataProvider.GroupInfo)localObject).c = this.a.mVids;
      ((IDataProvider.GroupInfo)localObject).d = this.a.mFeedIdMap;
      localStartInfo.d = ((IDataProvider.GroupInfo)localObject);
    }
    return localStartInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */