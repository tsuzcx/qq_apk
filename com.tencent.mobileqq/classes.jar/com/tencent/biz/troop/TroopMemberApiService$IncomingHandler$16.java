package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.CreateCommentResult;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class TroopMemberApiService$IncomingHandler$16
  implements RIJCommentNetworkHelper.RIJCreateCommentObserver
{
  TroopMemberApiService$IncomingHandler$16(TroopMemberApiService.IncomingHandler paramIncomingHandler, JSONObject paramJSONObject, BaseCommentData paramBaseCommentData, JSONArray paramJSONArray, Bundle paramBundle) {}
  
  public void a(CreateCommentResult paramCreateCommentResult)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        if (!paramCreateCommentResult.jdField_a_of_type_Boolean) {
          continue;
        }
        i = 0;
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", i);
        this.jdField_a_of_type_OrgJsonJSONObject.put("commentId", paramCreateCommentResult.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_OrgJsonJSONObject.put("comment", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent);
        if (this.jdField_a_of_type_OrgJsonJSONArray != null) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("linkDataList", this.jdField_a_of_type_OrgJsonJSONArray);
        }
        i = j;
        if (paramCreateCommentResult.jdField_a_of_type_Int == -4096) {
          i = 1;
        }
        this.jdField_a_of_type_OrgJsonJSONObject.put("errorType", i);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errorCode", paramCreateCommentResult.jdField_a_of_type_Int);
        this.jdField_a_of_type_OrgJsonJSONObject.put("rptDataList", RIJCommentTopicUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentRptDataList));
      }
      catch (JSONException paramCreateCommentResult)
      {
        int i;
        QLog.e("TroopMemberApiService", 1, "handleCommentEditorNativeResult put create comment result error.");
        continue;
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("BUNDLE_KEY_JS_OBJ", this.jdField_a_of_type_OrgJsonJSONObject.toString());
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a(154, this.jdField_a_of_type_AndroidOsBundle);
      return;
      i = -2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.16
 * JD-Core Version:    0.7.0.1
 */