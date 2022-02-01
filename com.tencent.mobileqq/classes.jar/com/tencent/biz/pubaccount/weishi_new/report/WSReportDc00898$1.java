package com.tencent.biz.pubaccount.weishi_new.report;

import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import umw;

public final class WSReportDc00898$1
  implements Runnable
{
  public WSReportDc00898$1(int paramInt, Object paramObject) {}
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
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
                return;
              } while (!(this.jdField_a_of_type_JavaLangObject instanceof String));
              umw.a("officialacc_weishi", "single_video_exp", 0, 0, 0L, 0L, (String)this.jdField_a_of_type_JavaLangObject, umw.b());
              return;
            } while (!this.jdField_a_of_type_JavaLangObject.getClass().isArray());
            localObject = (Object[])this.jdField_a_of_type_JavaLangObject;
            long l = ((Long)localObject[0]).longValue();
            i = ((Integer)localObject[1]).intValue();
            umw.a("officialacc_weishi", "officialacc_quit", 0, (int)l, i, 0L, "", "");
            return;
            if ((this.jdField_a_of_type_JavaLangObject instanceof WSRedDotPushMsg)) {}
            for (localObject = umw.a((WSRedDotPushMsg)this.jdField_a_of_type_JavaLangObject);; localObject = umw.c())
            {
              umw.a("officialacc_weishi", "feeds_exp", 0, 0, 0L, 0L, (String)localObject, "");
              return;
            }
          } while (!(this.jdField_a_of_type_JavaLangObject instanceof String));
          umw.a("officialacc_weishi", "push_video_clk", 0, 0, 0L, 0L, (String)this.jdField_a_of_type_JavaLangObject, umw.b());
          return;
          if ((this.jdField_a_of_type_JavaLangObject instanceof String))
          {
            umw.a("officialacc_weishi", "feeds_clk", 0, 0, 0L, 0L, (String)this.jdField_a_of_type_JavaLangObject, umw.b());
            return;
          }
        } while (!(this.jdField_a_of_type_JavaLangObject instanceof Integer));
        switch (((Integer)this.jdField_a_of_type_JavaLangObject).intValue())
        {
        default: 
          return;
        case 2: 
          umw.a("officialacc_weishi", "feeds_clk_videoplay", 0, 0, 0L, 0L, "", umw.b());
          return;
        case 115: 
          umw.a("weishi_share_officialacc", "feeds_dl_ws", 0, 0, 0L, 0L, "", umw.b());
          return;
        }
        umw.a("weishi_share_officialacc", "feeds_clk_ws", 0, 0, 0L, 0L, "", umw.b());
        return;
      } while ((!(this.jdField_a_of_type_JavaLangObject instanceof Integer)) || (((Integer)this.jdField_a_of_type_JavaLangObject).intValue() != 4));
      umw.a("weishi_share_officialacc", "dtest_dl_ws", 0, 0, 0L, 0L, "", umw.b());
      return;
      localObject = "";
      int i = 0;
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
        localObject = umw.a(str1, str2, k, m, n);
        switch (j)
        {
        default: 
          umw.a("officialacc_weishi", "feeds_video_exp", 0, 0, 0L, 0L, "", umw.b());
        }
      }
      for (;;)
      {
        umw.a("officialacc_weishi", "feeds_exp_cpl", i, 0, 0L, 0L, (String)localObject, umw.b());
        return;
        umw.a("weishi_share_officialacc", "feeds_dl_exp", 0, 0, 0L, 0L, "", umw.b());
      }
    } while (!this.jdField_a_of_type_JavaLangObject.getClass().isArray());
    Object localObject = (Object[])this.jdField_a_of_type_JavaLangObject;
    umw.a("officialacc_weishi", "feeds_load_fail", ((Integer)localObject[0]).intValue(), 0, ((Long)localObject[1]).longValue(), 0L, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898.1
 * JD-Core Version:    0.7.0.1
 */