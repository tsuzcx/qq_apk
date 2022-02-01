package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupApplication;
import com.tencent.imsdk.group.GroupApplicationResult;
import java.util.ArrayList;
import java.util.List;

public class V2TIMGroupApplicationResult
{
  private long reportedTimestamp = 0L;
  private int unreadCount = 0;
  private List<V2TIMGroupApplication> v2TIMGroupApplicationList = new ArrayList();
  
  public List<V2TIMGroupApplication> getGroupApplicationList()
  {
    return this.v2TIMGroupApplicationList;
  }
  
  public int getUnreadCount()
  {
    return this.unreadCount;
  }
  
  void setGroupApplicationResult(GroupApplicationResult paramGroupApplicationResult)
  {
    this.unreadCount = ((int)paramGroupApplicationResult.getUnreadCount());
    this.v2TIMGroupApplicationList.clear();
    paramGroupApplicationResult = paramGroupApplicationResult.getGroupApplicationList();
    if (paramGroupApplicationResult != null)
    {
      int i = 0;
      while (i < paramGroupApplicationResult.size())
      {
        V2TIMGroupApplication localV2TIMGroupApplication = new V2TIMGroupApplication();
        localV2TIMGroupApplication.setGroupApplication((GroupApplication)paramGroupApplicationResult.get(i));
        this.v2TIMGroupApplicationList.add(localV2TIMGroupApplication);
        i += 1;
      }
    }
  }
  
  void setReportedTimestamp(long paramLong)
  {
    this.reportedTimestamp = paramLong;
  }
  
  void setUnreadCount(int paramInt)
  {
    this.unreadCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupApplicationResult
 * JD-Core Version:    0.7.0.1
 */