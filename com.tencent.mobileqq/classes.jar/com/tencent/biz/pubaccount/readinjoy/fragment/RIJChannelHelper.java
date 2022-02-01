package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.RedPoint;
import com.tencent.qphone.base.util.QLog;

public class RIJChannelHelper
{
  public static int a(ChannelCoverInfo paramChannelCoverInfo)
  {
    if ((paramChannelCoverInfo != null) && (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelJumpUrl))) {
      return 2;
    }
    return 1;
  }
  
  public static int a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if ((paramTabChannelCoverInfo == null) || (paramTabChannelCoverInfo.redPoint == null))
    {
      if (paramTabChannelCoverInfo != null) {}
      for (paramTabChannelCoverInfo = paramTabChannelCoverInfo.toString();; paramTabChannelCoverInfo = "")
      {
        QLog.d("RIJChannelHelper", 2, new Object[] { "getRedDotType, info is null or redPoint is null", paramTabChannelCoverInfo });
        return -1;
      }
    }
    QLog.d("RIJChannelHelper", 2, new Object[] { "getRedDotType, info = ", paramTabChannelCoverInfo.toString() });
    if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)
    {
      long l = System.currentTimeMillis() / 1000L;
      if ((l >= paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Long) && (l <= paramTabChannelCoverInfo.redPoint.b)) {
        return paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Int;
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelHelper
 * JD-Core Version:    0.7.0.1
 */