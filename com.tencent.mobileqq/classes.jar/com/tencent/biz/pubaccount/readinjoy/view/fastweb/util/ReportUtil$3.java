package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import org.json.JSONException;
import org.json.JSONObject;

final class ReportUtil$3
  implements Runnable
{
  ReportUtil$3(byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
        localParcel.setDataPosition(0);
        localArticleInfo = new ArticleInfo(localParcel);
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localParcel.recycle();
          if (localArticleInfo != null) {
            break;
          }
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ArticleInfo localArticleInfo;
            long l1;
            long l2;
            BaseActivity localBaseActivity;
            JSONObject localJSONObject;
          }
        }
        localException1 = localException1;
        localArticleInfo = null;
      }
    }
    l1 = NetConnInfoCenter.getServerTime();
    l2 = this.jdField_a_of_type_Long;
    localBaseActivity = BaseActivity.sTopActivity;
    localJSONObject = new JSONObject();
    if (localBaseActivity != null)
    {
      localJSONObject = RIJTransMergeKanDianReport.a(localBaseActivity, localArticleInfo, (int)localArticleInfo.mChannelID, "2");
      try
      {
        localJSONObject.put("rowkey", localArticleInfo.innerUniqueID);
        localJSONObject.put("duration", l1 - l2);
        ReportUtil.a(localArticleInfo, "0X800A732", localJSONObject.toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.3
 * JD-Core Version:    0.7.0.1
 */