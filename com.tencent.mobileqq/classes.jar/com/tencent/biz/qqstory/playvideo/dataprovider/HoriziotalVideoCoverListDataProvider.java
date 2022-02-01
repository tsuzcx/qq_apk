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
  private int jdField_a_of_type_Int = -1;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public HoriziotalVideoCoverListDataProvider(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public List<String> a()
  {
    SLog.a("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "getData , verticalPosition = %d , size = %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, ArrayList<StoryPlayerVideoData> paramArrayList, IDataProvider.GroupId paramGroupId)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      SLog.b("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "close , set data invalidate");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      StoryPlayerVideoData localStoryPlayerVideoData = (StoryPlayerVideoData)paramArrayList.next();
      if ((!localStoryPlayerVideoData.a()) && (!TextUtils.isEmpty(localStoryPlayerVideoData.a))) {
        localArrayList.add(localStoryPlayerVideoData.a);
      }
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_a_of_type_Int = paramInt;
    int i;
    if ((paramGroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId))
    {
      paramArrayList = (MsgTabPlayPageLoader.MsgTabGroupId)paramGroupId;
      if (paramArrayList.a != null)
      {
        i = paramArrayList.a.jdField_a_of_type_Int;
        this.b = i;
        label129:
        i = this.jdField_a_of_type_JavaUtilList.size();
        if (paramGroupId != null) {
          break label186;
        }
      }
    }
    label186:
    for (paramArrayList = "";; paramArrayList = paramGroupId.toString())
    {
      SLog.a("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "setDataList , verticalPosition = %d , size = %d, groupId= %s, msgTabNodeType=%d", Integer.valueOf(paramInt), Integer.valueOf(i), paramArrayList, Integer.valueOf(this.b));
      return;
      i = -1;
      break;
      this.b = -1;
      break label129;
    }
  }
  
  public boolean a()
  {
    return this.b == 12;
  }
  
  public boolean b()
  {
    return this.b == 13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.HoriziotalVideoCoverListDataProvider
 * JD-Core Version:    0.7.0.1
 */