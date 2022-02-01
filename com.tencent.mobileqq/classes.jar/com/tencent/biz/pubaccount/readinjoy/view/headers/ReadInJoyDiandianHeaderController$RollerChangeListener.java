package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDiandianHeaderController$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int jdField_a_of_type_Int = 0;
  
  protected ReadInJoyDiandianHeaderController$RollerChangeListener(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    int j = 1;
    if (paramInt != 0) {}
    label137:
    for (;;)
    {
      return;
      int i = ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).getCurrentItem();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.jdField_a_of_type_Int = i;
      int k = ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).getCount();
      if (k > 1)
      {
        if (i == 1)
        {
          ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).instantiateItem(null, k - 3);
          if (i != 0) {
            break label124;
          }
          paramInt = k - 3;
        }
        for (;;)
        {
          if (i == paramInt) {
            break label137;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController.jdField_a_of_type_Int = paramInt;
          ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).setCurrentItem(paramInt, false);
          return;
          if (i != k - 3) {
            break;
          }
          ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).instantiateItem(null, 1);
          break;
          label124:
          paramInt = j;
          if (i != k - 2) {
            paramInt = i;
          }
        }
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).a(paramInt);
    if ((this.jdField_a_of_type_Int != i) && (ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController))) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009826", "0X8009826", 0, 0, "", "", "", "", false);
    }
    if ((i >= 0) && (this.jdField_a_of_type_Int >= 0)) {
      this.jdField_a_of_type_Int = i;
    }
    ReadInJoyDiandianHeaderController.HeaderListAdapter localHeaderListAdapter;
    if (ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).get(i) != null)
    {
      localHeaderListAdapter = (ReadInJoyDiandianHeaderController.HeaderListAdapter)((MeasureGridView)ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).get(i)).getAdapter();
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < localHeaderListAdapter.getCount())
      {
        DiandianTopConfig localDiandianTopConfig = (DiandianTopConfig)localHeaderListAdapter.getItem(paramInt);
        if ((localDiandianTopConfig != null) && (!localDiandianTopConfig.hasExposeReported)) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
            if (localDiandianTopConfig.type == 5) {
              localJSONObject.put("list_URL", localDiandianTopConfig.jumpUrl);
            }
            for (;;)
            {
              localJSONObject.put("type", localDiandianTopConfig.type);
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092FC", "0X80092FC", 0, 0, ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).size() + "", i + 1 + "", localDiandianTopConfig.topicId + "", localJSONObject.toString(), false);
              localDiandianTopConfig.hasExposeReported = true;
              localHeaderListAdapter.a(paramInt, localDiandianTopConfig);
              break;
              localJSONObject.put("list_URL", "0");
            }
            QLog.e("ReadInJoyDiandianHeaderController", 2, localJSONException.toString());
          }
          catch (JSONException localJSONException)
          {
            if (!QLog.isColorLevel()) {
              break label359;
            }
          }
        }
      }
      else
      {
        return;
      }
      label359:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */