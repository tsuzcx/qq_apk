package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentRptDataUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class TroopMemberApiService$IncomingHandler$16
  implements IRIJCommentNetworkHelper.RIJCreateCommentObserver
{
  TroopMemberApiService$IncomingHandler$16(TroopMemberApiService.IncomingHandler paramIncomingHandler, JSONObject paramJSONObject, BaseCommentData paramBaseCommentData, JSONArray paramJSONArray, Bundle paramBundle) {}
  
  public void a(CreateCommentResult paramCreateCommentResult)
  {
    try
    {
      boolean bool = paramCreateCommentResult.jdField_a_of_type_Boolean;
      j = 0;
      if (!bool) {
        break label199;
      }
      i = 0;
    }
    catch (JSONException paramCreateCommentResult)
    {
      for (;;)
      {
        int j;
        label161:
        continue;
        label199:
        int i = -2;
      }
    }
    this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", i);
    this.jdField_a_of_type_OrgJsonJSONObject.put("commentId", paramCreateCommentResult.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_OrgJsonJSONObject.put("comment", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentContent);
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {
      this.jdField_a_of_type_OrgJsonJSONObject.put("linkDataList", this.jdField_a_of_type_OrgJsonJSONArray);
    }
    i = j;
    if (paramCreateCommentResult.jdField_a_of_type_Int == -4096) {
      i = 1;
    }
    this.jdField_a_of_type_OrgJsonJSONObject.put("errorType", i);
    this.jdField_a_of_type_OrgJsonJSONObject.put("errorCode", paramCreateCommentResult.jdField_a_of_type_Int);
    this.jdField_a_of_type_OrgJsonJSONObject.put("rptDataList", ((IRIJCommentRptDataUtil)QRoute.api(IRIJCommentRptDataUtil.class)).getJsonForWeb(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentRptDataList));
    break label161;
    QLog.e("TroopMemberApiService", 1, "handleCommentEditorNativeResult put create comment result error.");
    this.jdField_a_of_type_AndroidOsBundle.putString("BUNDLE_KEY_JS_OBJ", this.jdField_a_of_type_OrgJsonJSONObject.toString());
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a(154, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.16
 * JD-Core Version:    0.7.0.1
 */