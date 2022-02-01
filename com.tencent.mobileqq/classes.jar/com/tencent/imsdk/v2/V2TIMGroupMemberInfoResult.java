package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoResult;
import java.util.ArrayList;
import java.util.List;

public class V2TIMGroupMemberInfoResult
{
  private long nextSeq;
  private List<V2TIMGroupMemberFullInfo> v2TIMGroupMemberFullInfoList = new ArrayList();
  
  public List<V2TIMGroupMemberFullInfo> getMemberInfoList()
  {
    return this.v2TIMGroupMemberFullInfoList;
  }
  
  public long getNextSeq()
  {
    return this.nextSeq;
  }
  
  public void setGroupMemberInfoResult(GroupMemberInfoResult paramGroupMemberInfoResult)
  {
    this.nextSeq = paramGroupMemberInfoResult.getNextSeq();
    this.v2TIMGroupMemberFullInfoList.clear();
    paramGroupMemberInfoResult = paramGroupMemberInfoResult.getGroupMemberInfoList();
    int i = 0;
    while (i < paramGroupMemberInfoResult.size())
    {
      V2TIMGroupMemberFullInfo localV2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
      localV2TIMGroupMemberFullInfo.setGroupMemberInfo((GroupMemberInfo)paramGroupMemberInfoResult.get(i));
      this.v2TIMGroupMemberFullInfoList.add(localV2TIMGroupMemberFullInfo);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupMemberInfoResult
 * JD-Core Version:    0.7.0.1
 */