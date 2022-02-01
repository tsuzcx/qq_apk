package com.tencent.biz.pubaccount.util;

import achv;
import android.app.Activity;
import android.text.TextUtils;
import bhhr;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import olh;
import org.json.JSONException;
import pqf;
import pqg;
import rmu;
import rna;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public final class ReadinjoyReportUtils$3
  implements Runnable
{
  public ReadinjoyReportUtils$3(int paramInt1, Activity paramActivity, boolean paramBoolean, int paramInt2) {}
  
  public void run()
  {
    int m = 0;
    Object localObject2 = "0";
    int k = 0;
    if (this.jdField_a_of_type_Int == 0) {
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
        break label631;
      }
    }
    label589:
    label609:
    label631:
    for (boolean bool1 = bhhr.t(this.jdField_a_of_type_AndroidAppActivity, ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getCurrentAccountUin());; bool1 = false)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {}
      for (Object localObject1 = ((rna)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a();; localObject1 = "0")
      {
        int i;
        Object localObject3;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals("0")))
        {
          j = 0;
          localObject1 = "0";
          i = 0;
          k = i;
          localObject2 = localObject1;
          m = j;
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
            break label609;
          }
          localObject3 = (rmu)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
          k = i;
          localObject2 = localObject1;
          m = j;
          if (((rmu)localObject3).a() != 1) {
            break label609;
          }
          k = i;
          localObject2 = localObject1;
          m = j;
          if (!((rmu)localObject3).b()) {
            break label609;
          }
          localObject1 = ((rmu)localObject3).a();
          bool1 = ((rmu)localObject3).a();
          i = 0;
        }
        for (int j = 2;; j = k)
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Int != 40677)
            {
              localObject2 = rmu.b(this.jdField_a_of_type_AndroidAppActivity, 0);
              if ((!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) || (this.jdField_a_of_type_Int != 0) || (localObject2 == null) || (!((RefreshData)localObject2).isAD) || (((RefreshData)localObject2).adExposureReports == null) || (((RefreshData)localObject2).adExposureReports.size() <= 0)) {}
            }
            try
            {
              localObject3 = new qq_ad_get.QQAdGetRsp.AdInfo();
              long l = ((RefreshData)localObject2).adId.longValue();
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject3).report_info.trace_info.aid.set(l);
              ((qq_ad_get.QQAdGetRsp.AdInfo)localObject3).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(((RefreshData)localObject2).getUrls(((RefreshData)localObject2).adExposureReports));
              achv.a(0, 1, (qq_ad_get.QQAdGetRsp.AdInfo)localObject3);
              m = this.jdField_a_of_type_Int;
              boolean bool2 = this.jdField_a_of_type_Boolean;
              if (bool1)
              {
                k = 1;
                localObject3 = pqf.a(m, (String)localObject1, i, j, bool2, k);
                if ((this.jdField_a_of_type_Int == 0) && (localObject2 == null)) {
                  break label589;
                }
              }
              try
              {
                if (!((RefreshData)localObject2).isAD) {
                  break label589;
                }
                k = 1;
                ((pqg)localObject3).a("ad_page", k);
                ((pqg)localObject3).a("banner_refresh_length", this.b);
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  localJSONException.printStackTrace();
                  continue;
                  k = 0;
                }
              }
              olh.a(null, "CliOper", "", "", "0X80066F8", "0X80066F8", 0, 0, bmhv.a("default_feeds_proteus_offline_bid"), "", "", ((pqg)localObject3).a(), false);
              olh.a("0X80066F8", "", "", "", "", pqf.b(this.jdField_a_of_type_Int));
              if (this.jdField_a_of_type_Int == 70)
              {
                localObject2 = bmhv.a("default_feeds_proteus_offline_bid");
                m = this.jdField_a_of_type_Int;
                bool2 = this.jdField_a_of_type_Boolean;
                if (bool1)
                {
                  k = 1;
                  olh.a(null, "CliOper", "", "", "0X8009861", "0X8009861", 0, 0, (String)localObject2, "", "", pqf.a(m, (String)localObject1, i, j, bool2, k).a(), false);
                  olh.a("0X8009861", "", "", "", "", pqf.b(this.jdField_a_of_type_Int));
                }
              }
              else
              {
                return;
                if (bool1)
                {
                  i = 1;
                  j = 1;
                  break;
                }
                i = 1;
                j = 2;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                localNumberFormatException.printStackTrace();
                continue;
                k = 0;
                continue;
                k = 0;
              }
            }
          }
          bool1 = false;
          localObject1 = localJSONException;
          i = m;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.3
 * JD-Core Version:    0.7.0.1
 */