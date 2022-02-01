package com.tencent.biz.pubaccount.weishi_new.report;

import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

final class WSReportDc00898$1
  implements Runnable
{
  WSReportDc00898$1(int paramInt, Object paramObject) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    if (i != 6)
    {
      if (i != 112)
      {
        if (i != 115)
        {
          if (i != 117)
          {
            if (i != 141)
            {
              switch (i)
              {
              default: 
                return;
              case 303: 
                localObject = this.jdField_a_of_type_JavaLangObject;
                if (!(localObject instanceof String)) {
                  break;
                }
                WSReportDc00898.a("officialacc_weishi", "single_video_exp", 0, 0, 0L, 0L, (String)localObject, WSReportDc00898.b());
                return;
              case 302: 
                if (!this.jdField_a_of_type_JavaLangObject.getClass().isArray()) {
                  break;
                }
                localObject = (Object[])this.jdField_a_of_type_JavaLangObject;
                WSReportDc00898.a("officialacc_weishi", "feeds_load_fail", ((Integer)localObject[0]).intValue(), 0, ((Long)localObject[1]).longValue(), 0L, "", "");
                return;
              case 301: 
                if (this.jdField_a_of_type_JavaLangObject.getClass().isArray())
                {
                  localObject = (Object[])this.jdField_a_of_type_JavaLangObject;
                  int j = ((Integer)localObject[0]).intValue();
                  String str1 = (String)localObject[1];
                  String str2 = (String)localObject[2];
                  int k = ((Integer)localObject[3]).intValue();
                  int m = ((Integer)localObject[4]).intValue();
                  int n = ((Integer)localObject[5]).intValue();
                  i = ((Integer)localObject[6]).intValue();
                  localObject = WSReportDc00898.a(str1, str2, k, m, n);
                  if (j != 2) {
                    WSReportDc00898.a("officialacc_weishi", "feeds_video_exp", 0, 0, 0L, 0L, UserAction.getQIMEI(), WSReportDc00898.b());
                  } else {
                    WSReportDc00898.a("weishi_share_officialacc", "feeds_dl_exp", 0, 0, 0L, 0L, UserAction.getQIMEI(), WSReportDc00898.b());
                  }
                }
                else
                {
                  localObject = "";
                  i = 0;
                }
                WSReportDc00898.a("officialacc_weishi", "feeds_exp_cpl", i, 0, 0L, 0L, (String)localObject, WSReportDc00898.b());
                return;
              }
            }
            else
            {
              localObject = this.jdField_a_of_type_JavaLangObject;
              if ((localObject instanceof String)) {
                WSReportDc00898.a("officialacc_weishi", "push_video_clk", 0, 0, 0L, 0L, (String)localObject, WSReportDc00898.b());
              }
            }
          }
          else if (this.jdField_a_of_type_JavaLangObject.getClass().isArray())
          {
            localObject = (Object[])this.jdField_a_of_type_JavaLangObject;
            long l = ((Long)localObject[0]).longValue();
            i = ((Integer)localObject[1]).intValue();
            WSReportDc00898.a("officialacc_weishi", "officialacc_quit", 0, (int)l, i, 0L, UserAction.getQIMEI(), "");
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaLangObject;
          if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 4)) {
            WSReportDc00898.a("weishi_share_officialacc", "dtest_dl_ws", 0, 0, 0L, 0L, "", WSReportDc00898.b());
          }
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaLangObject;
        if ((localObject instanceof String))
        {
          WSReportDc00898.a("officialacc_weishi", "feeds_clk", 0, 0, 0L, 0L, (String)localObject, WSReportDc00898.b());
          return;
        }
        if ((localObject instanceof Integer))
        {
          i = ((Integer)localObject).intValue();
          if (i != 2)
          {
            if (i != 114)
            {
              if (i != 115) {
                return;
              }
              WSReportDc00898.a("weishi_share_officialacc", "feeds_dl_ws", 0, 0, 0L, 0L, "", WSReportDc00898.b());
              return;
            }
            WSReportDc00898.a("weishi_share_officialacc", "feeds_clk_ws", 0, 0, 0L, 0L, "", WSReportDc00898.b());
            return;
          }
          WSReportDc00898.a("officialacc_weishi", "feeds_clk_videoplay", 0, 0, 0L, 0L, "", WSReportDc00898.b());
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaLangObject;
      if ((localObject instanceof WSRedDotPushMsg)) {
        localObject = WSReportDc00898.a((WSRedDotPushMsg)localObject);
      } else {
        localObject = WSReportDc00898.c();
      }
      WSReportDc00898.a("officialacc_weishi", "feeds_exp", 0, 0, 0L, 0L, (String)localObject, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898.1
 * JD-Core Version:    0.7.0.1
 */