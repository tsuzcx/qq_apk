package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import org.json.JSONException;
import org.json.JSONObject;
import ozs;
import ssy;

public final class ReportUtil$3
  implements Runnable
{
  public ReportUtil$3(byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    ArticleInfo localArticleInfo;
    long l1;
    long l2;
    BaseActivity localBaseActivity;
    try
    {
      Object localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
      ((Parcel)localObject).setDataPosition(0);
      localObject = new ArticleInfo((Parcel)localObject);
      if (localObject == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localArticleInfo = null;
      }
      l1 = NetConnInfoCenter.getServerTime();
      l2 = this.jdField_a_of_type_Long;
      localBaseActivity = BaseActivity.sTopActivity;
      localJSONObject = new JSONObject();
      if (localBaseActivity == null) {
        break label148;
      }
    }
    JSONObject localJSONObject = ozs.a(localBaseActivity, localArticleInfo, (int)localArticleInfo.mChannelID, "2");
    label148:
    for (;;)
    {
      try
      {
        localJSONObject.put("rowkey", localArticleInfo.innerUniqueID);
        localJSONObject.put("duration", l1 - l2);
        ssy.a(localArticleInfo, "0X800A732", localJSONObject.toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.3
 * JD-Core Version:    0.7.0.1
 */