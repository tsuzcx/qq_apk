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
  private ShareFromMemoryPlayInfo a;
  private IDataProvider.GroupId b;
  private String c = "";
  
  public ShareFromMemoryPlayPageLoader(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo)
  {
    this.a = paramShareFromMemoryPlayInfo;
    this.b = new IDataProvider.GroupId(this.a.feedId);
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
    paramCallBack.a(new ErrorMessage(), Collections.singletonList(this.b), true);
  }
  
  public void b() {}
  
  public IDataProvider.StartInfo c()
  {
    if (this.a.videoListOrder == 0)
    {
      localObject = ((FeedVideoManager)SuperManager.a(12)).a(this.a.feedId, 1);
      if ((localObject != null) && (((FeedVideoInfo)localObject).mVideoItemList.size() > 0))
      {
        localObject = ((StoryVideoItem)((FeedVideoInfo)localObject).mVideoItemList.get(0)).mVid;
        break label68;
      }
    }
    Object localObject = null;
    label68:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getStartInfo GroupId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",vid=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",feedId=");
    localStringBuilder.append(this.a.feedId);
    SLog.d("Q.qqstory.player.data.ShareFromMemoryPlayPageLoader", localStringBuilder.toString());
    return new IDataProvider.StartInfo(this.b, (String)localObject, this.a.feedId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.ShareFromMemoryPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */