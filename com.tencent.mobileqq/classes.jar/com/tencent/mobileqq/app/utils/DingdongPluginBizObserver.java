package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class DingdongPluginBizObserver
  implements BusinessObserver
{
  public void a(DingdongPluginBizObserver.FeedConfirmNotifyData paramFeedConfirmNotifyData) {}
  
  public void a(DingdongPluginBizObserver.FeedStateUpdateData paramFeedStateUpdateData) {}
  
  public void a(DingdongPluginBizObserver.GetAppListData paramGetAppListData) {}
  
  public void a(DingdongPluginBizObserver.GetOpenIdNotifyData paramGetOpenIdNotifyData) {}
  
  public void a(DingdongPluginBizObserver.NodeUpdateData paramNodeUpdateData) {}
  
  public void a(DingdongPluginBizObserver.ScheduleChangeNotifyData paramScheduleChangeNotifyData) {}
  
  public void a(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData) {}
  
  public void a(DingdongPluginBizObserver.ScheduleNotificationData paramScheduleNotificationData) {}
  
  public void a(DingdongPluginBizObserver.SetAppListData paramSetAppListData) {}
  
  public void a(DingdongPluginBizObserver.UnreadNumUpdateData paramUnreadNumUpdateData) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.UnreadNumUpdateData)));
                      a((DingdongPluginBizObserver.UnreadNumUpdateData)paramObject);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.NodeUpdateData)));
                    a((DingdongPluginBizObserver.NodeUpdateData)paramObject);
                    return;
                  } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.FeedStateUpdateData)));
                  a((DingdongPluginBizObserver.FeedStateUpdateData)paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.FeedConfirmNotifyData)));
                a((DingdongPluginBizObserver.FeedConfirmNotifyData)paramObject);
                return;
              } while (!(paramObject instanceof DingdongPluginBizObserver.ScheduleChangeNotifyData));
              a((DingdongPluginBizObserver.ScheduleChangeNotifyData)paramObject);
              return;
            } while (!(paramObject instanceof DingdongPluginBizObserver.ScheduleNotificationData));
            QLog.e("dingdongSchedule", 2, "Observer nitify get");
            a((DingdongPluginBizObserver.ScheduleNotificationData)paramObject);
            return;
          } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.GetOpenIdNotifyData)));
          a((DingdongPluginBizObserver.GetOpenIdNotifyData)paramObject);
          return;
        } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.GetAppListData)));
        a((DingdongPluginBizObserver.GetAppListData)paramObject);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.SetAppListData)));
      a((DingdongPluginBizObserver.SetAppListData)paramObject);
      return;
    } while ((paramObject == null) || (!(paramObject instanceof DingdongPluginBizObserver.ScheduleMoreSummaryData)));
    a((DingdongPluginBizObserver.ScheduleMoreSummaryData)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.DingdongPluginBizObserver
 * JD-Core Version:    0.7.0.1
 */