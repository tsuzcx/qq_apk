package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.RedPoint;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelCoverInfoModule$9
  implements Runnable
{
  ChannelCoverInfoModule$9(ChannelCoverInfoModule paramChannelCoverInfoModule, List paramList1, List paramList2) {}
  
  public void run()
  {
    Object localObject = this.a.iterator();
    TabChannelCoverInfo localTabChannelCoverInfo;
    while (((Iterator)localObject).hasNext())
    {
      localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      this.this$0.a(localTabChannelCoverInfo);
    }
    localObject = this.b.iterator();
    for (;;)
    {
      JSONObject localJSONObject;
      if (((Iterator)localObject).hasNext())
      {
        localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
        localTabChannelCoverInfo.setStatus(1000);
        if (localTabChannelCoverInfo.redPoint != null) {
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("startTimestamp", localTabChannelCoverInfo.redPoint.jdField_a_of_type_Long);
        localJSONObject.put("endTimestamp", localTabChannelCoverInfo.redPoint.jdField_b_of_type_Long);
        localJSONObject.put("animationTimestamp", localTabChannelCoverInfo.redPoint.jdField_c_of_type_Long);
        localJSONObject.put("isShow", localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean);
        localJSONObject.put("type", localTabChannelCoverInfo.redPoint.jdField_a_of_type_Int);
        localJSONObject.put("titleText", localTabChannelCoverInfo.redPoint.jdField_a_of_type_JavaLangString);
        localJSONObject.put("titleColor", localTabChannelCoverInfo.redPoint.jdField_b_of_type_Int);
        localJSONObject.put("titleBgColor", localTabChannelCoverInfo.redPoint.jdField_c_of_type_Int);
        localTabChannelCoverInfo.redPointJson = localJSONObject.toString();
        label211:
        if ((localTabChannelCoverInfo.mChannelCoverId == 70) && (!TextUtils.isEmpty(localTabChannelCoverInfo.mChannelJumpUrl))) {
          ViolaAccessHelper.a(localTabChannelCoverInfo.mChannelJumpUrl);
        }
        this.this$0.a(localTabChannelCoverInfo);
        continue;
        localObject = ChannelCoverInfoModule.a(this.this$0);
        if (localObject != null)
        {
          QLog.i("ChannelCoverInfoModule", 1, "now channels in db are:\n");
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            QLog.i("ChannelCoverInfoModule", 1, ((TabChannelCoverInfo)((Iterator)localObject).next()).toString());
          }
        }
        QLog.i("ChannelCoverInfoModule", 1, "now channels in db are null:\n");
        return;
      }
      catch (JSONException localJSONException)
      {
        break label211;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.9
 * JD-Core Version:    0.7.0.1
 */