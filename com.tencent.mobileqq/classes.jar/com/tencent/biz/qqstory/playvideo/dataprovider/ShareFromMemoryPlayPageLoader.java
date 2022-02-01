package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShareFromMemoryPlayPageLoader
  extends IGroupPageLoader.BaseGroupPageLoader
{
  private IDataProvider.GroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  private ShareFromMemoryPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo;
  private String jdField_a_of_type_JavaLangString = "";
  
  public ShareFromMemoryPlayPageLoader(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo = paramShareFromMemoryPlayInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = new IDataProvider.GroupId(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
  }
  
  public IDataProvider.StartInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.videoListOrder == 0)
    {
      localObject = ((FeedVideoManager)SuperManager.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId, 1);
      if ((localObject == null) || (((FeedVideoInfo)localObject).mVideoItemList.size() <= 0)) {}
    }
    for (Object localObject = ((StoryVideoItem)((FeedVideoInfo)localObject).mVideoItemList.get(0)).mVid;; localObject = null)
    {
      SLog.d("Q.qqstory.player.data.ShareFromMemoryPlayPageLoader", "getStartInfo GroupId=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId + ",vid=" + (String)localObject + ",feedId=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
      return new IDataProvider.StartInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, (String)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
    }
  }
  
  public List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new ShareFromMemoryPlayPageLoader.VidSyncer(this, (IDataProvider.GroupId)paramList.next()));
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    paramCallBack.a(new ErrorMessage(), Collections.singletonList(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId), true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.ShareFromMemoryPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */