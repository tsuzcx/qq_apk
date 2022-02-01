package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.text.TextUtils;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar.VideoCoverListDataProvider;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoriziotalVideoCoverListDataProvider
  implements VideoCoverListBar.VideoCoverListDataProvider
{
  private List<String> a = new ArrayList();
  private int b = -1;
  private final boolean c;
  private int d = -1;
  
  public HoriziotalVideoCoverListDataProvider(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public List<String> a()
  {
    SLog.a("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "getData , verticalPosition = %d , size = %d", Integer.valueOf(this.b), Integer.valueOf(this.a.size()));
    return this.a;
  }
  
  public void a(int paramInt, ArrayList<StoryPlayerVideoData> paramArrayList, IDataProvider.GroupId paramGroupId)
  {
    if (!this.c)
    {
      SLog.b("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "close , set data invalidate");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      StoryPlayerVideoData localStoryPlayerVideoData = (StoryPlayerVideoData)paramArrayList.next();
      if ((!localStoryPlayerVideoData.a()) && (!TextUtils.isEmpty(localStoryPlayerVideoData.b))) {
        localArrayList.add(localStoryPlayerVideoData.b);
      }
    }
    this.a = localArrayList;
    this.b = paramInt;
    boolean bool = paramGroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId;
    int i = -1;
    if (bool)
    {
      paramArrayList = (MsgTabPlayPageLoader.MsgTabGroupId)paramGroupId;
      if (paramArrayList.a != null) {
        i = paramArrayList.a.b;
      }
      this.d = i;
    }
    else
    {
      this.d = -1;
    }
    i = this.a.size();
    if (paramGroupId == null) {
      paramArrayList = "";
    } else {
      paramArrayList = paramGroupId.toString();
    }
    SLog.a("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "setDataList , verticalPosition = %d , size = %d, groupId= %s, msgTabNodeType=%d", Integer.valueOf(paramInt), Integer.valueOf(i), paramArrayList, Integer.valueOf(this.d));
  }
  
  public boolean b()
  {
    return this.d == 12;
  }
  
  public boolean c()
  {
    return this.d == 13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.HoriziotalVideoCoverListDataProvider
 * JD-Core Version:    0.7.0.1
 */