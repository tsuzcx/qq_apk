package com.tencent.biz.pubaccount.readinjoy.view;

import aluw;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import nrt;
import ntd;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyBaseAdapter$34
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID))
      {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localObject instanceof QQAppInterface)) {
          break label181;
        }
        localObject = (QQAppInterface)localObject;
        if (localObject != null) {
          if (!((aluw)((AppInterface)localObject).getManager(56)).a(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID))) {
            break label151;
          }
        }
      }
      label151:
      for (Object localObject = "1";; localObject = "0")
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("fans", localObject);
        String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID)) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
        nrt.a(null, str2, "0X80077B9", "0X80077B9", 0, 0, "", "", (String)localObject, ntd.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, this.jdField_a_of_type_OrgJsonJSONObject), false);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video", 2, "report JSON fail");
          continue;
          String str1 = "0";
          continue;
          label181:
          str1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.34
 * JD-Core Version:    0.7.0.1
 */