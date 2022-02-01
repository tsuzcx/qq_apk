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
  private final MsgTabPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo;
  private final List<MsgTabNodeInfo> jdField_a_of_type_JavaUtilList;
  
  public MsgTabPlayPageLoader(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo = paramMsgTabPlayInfo;
    MsgTabStoryManager localMsgTabStoryManager = (MsgTabStoryManager)PlayModeUtils.a().getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramMsgTabPlayInfo.source == 0) {
      MsgTabStoryUtil.a(localMsgTabStoryManager.a().b(), this.jdField_a_of_type_JavaUtilList, paramMsgTabPlayInfo.nodeUnionId);
    }
  }
  
  public static MsgTabVideoData a(List<MsgTabVideoData> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    int i;
    if (paramList != null)
    {
      localObject2 = localObject1;
      if (paramList.size() > 0)
      {
        int j = paramList.size();
        i = 0;
        localObject1 = null;
        if (i >= j) {
          break label100;
        }
        localObject2 = (MsgTabVideoData)paramList.get(i);
        if (!((MsgTabVideoData)localObject2).b) {
          break label60;
        }
      }
    }
    return localObject2;
    label60:
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localObject1.jdField_a_of_type_Boolean) && (!((MsgTabVideoData)localObject2).jdField_a_of_type_Boolean))
      {
        return (MsgTabVideoData)paramList.get(i);
        label100:
        return localObject1;
      }
    }
  }
  
  public IDataProvider.StartInfo a()
  {
    Object localObject = new MsgTabPlayPageLoader.MsgTabGroupId(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    ((MsgTabPlayPageLoader.MsgTabGroupId)localObject).jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = ((MsgTabStoryManager)QQStoryContext.a().getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    IDataProvider.StartInfo localStartInfo = new IDataProvider.StartInfo((IDataProvider.GroupId)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVideoFeedId);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids.isEmpty()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap.isEmpty()))
    {
      localObject = new IDataProvider.GroupInfo((IDataProvider.GroupId)localObject);
      ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids;
      ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilMap = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap;
      localStartInfo.a = ((IDataProvider.GroupInfo)localObject);
    }
    return localStartInfo;
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
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source == 1)
    {
      localObject = ((StoryHaloManager)PlayModeUtils.a().getManager(QQManagerFactory.STORY_HALO_MANAGER)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.uin);
      if (localObject == null) {
        break label112;
      }
      ((MsgTabNodeInfo)localObject).f = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source;
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    for (;;)
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(MsgTabPlayPageLoader.MsgTabGroupId.a((MsgTabNodeInfo)localIterator.next()));
      }
      label112:
      SLog.d("Q.qqstory.player.data.MsgTabPlayPageLoader", "no data for header group");
    }
    paramCallBack.a(new ErrorMessage(), (List)localObject, true);
  }
  
  public boolean a(IDataProvider.GroupInfo paramGroupInfo)
  {
    if ((paramGroupInfo == null) || (!paramGroupInfo.d()))
    {
      SLog.c("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync");
      return true;
    }
    AssertUtils.a(paramGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId);
    MsgTabPlayPageLoader.MsgTabGroupId localMsgTabGroupId = (MsgTabPlayPageLoader.MsgTabGroupId)paramGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
    if (localMsgTabGroupId.jdField_a_of_type_Boolean)
    {
      SLog.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "won't needSyncVidList. groupId %s is end", localMsgTabGroupId.a());
      return false;
    }
    int i = localMsgTabGroupId.jdField_a_of_type_Int;
    if (paramGroupInfo.jdField_a_of_type_Int != i) {
      SLog.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList() groupId %s, position not match: %d != %d", localMsgTabGroupId.a(), Integer.valueOf(paramGroupInfo.jdField_a_of_type_Int), Integer.valueOf(i));
    }
    if ((i < 0) || (paramGroupInfo.jdField_a_of_type_JavaUtilList.size() - i < 10))
    {
      SLog.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramGroupInfo.jdField_a_of_type_JavaUtilList.size()), paramGroupInfo);
      return true;
    }
    SLog.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. not need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramGroupInfo.jdField_a_of_type_JavaUtilList.size()), paramGroupInfo);
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */