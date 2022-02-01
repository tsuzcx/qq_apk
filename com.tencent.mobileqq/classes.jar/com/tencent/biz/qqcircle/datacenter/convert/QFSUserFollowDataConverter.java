package com.tencent.biz.qqcircle.datacenter.convert;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.datacenter.data.QFSUserFollowData;
import com.tencent.richframework.data.idata.IDataConverter;
import cooperation.qqcircle.utils.QCircleCommonUtil;

public class QFSUserFollowDataConverter
  implements IDataConverter<QFSUserFollowData>
{
  private static void a(String paramString, int paramInt)
  {
    MutableLiveData localMutableLiveData = QCircleFeedDataCenter.a().a(QFSUserFollowData.class, paramString);
    if ((localMutableLiveData != null) && (localMutableLiveData.getValue() != null))
    {
      QFSUserFollowData localQFSUserFollowData = (QFSUserFollowData)localMutableLiveData.getValue();
      if (localQFSUserFollowData.a(paramInt))
      {
        localMutableLiveData.setValue(localQFSUserFollowData);
        b(paramString, paramInt);
      }
      return;
    }
    QCircleFeedDataCenter.a().a(new QFSUserFollowData(paramString, paramInt), true);
  }
  
  public static void b(QFSUserFollowData paramQFSUserFollowData)
  {
    if (paramQFSUserFollowData.e())
    {
      a(paramQFSUserFollowData.a(), paramQFSUserFollowData.b());
      return;
    }
    QCircleFeedDataCenter.a().a(paramQFSUserFollowData, true);
  }
  
  private static void b(String paramString, int paramInt)
  {
    paramString = QCircleFeedDataCenter.a().a(QFSUserFollowData.class, QCircleCommonUtil.getCurrentAccount());
    if (paramString != null)
    {
      if (paramString.getValue() == null) {
        return;
      }
      QFSUserFollowData localQFSUserFollowData = (QFSUserFollowData)paramString.getValue();
      localQFSUserFollowData.a(paramInt);
      paramString.setValue(localQFSUserFollowData);
    }
  }
  
  public String a(QFSUserFollowData paramQFSUserFollowData)
  {
    return paramQFSUserFollowData.a();
  }
  
  public void a(QFSUserFollowData paramQFSUserFollowData1, QFSUserFollowData paramQFSUserFollowData2)
  {
    if (paramQFSUserFollowData1 != null)
    {
      if (paramQFSUserFollowData2 == null) {
        return;
      }
      paramQFSUserFollowData1.a(paramQFSUserFollowData2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.convert.QFSUserFollowDataConverter
 * JD-Core Version:    0.7.0.1
 */