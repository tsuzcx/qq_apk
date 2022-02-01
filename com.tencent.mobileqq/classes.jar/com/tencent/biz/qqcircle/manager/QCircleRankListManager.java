package com.tencent.biz.qqcircle.manager;

import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QCircleRankListManager
{
  private static final String TAG = "RANK-QCircleRankListManager";
  
  public static List<QCircleRankListManager.UserMedalBean> parseUserMedalSource(String paramString)
  {
    try
    {
      paramString = (QCircleRankListManager.UserMedalListBean)new Gson().fromJson(paramString, new QCircleRankListManager.1().getType());
      if (paramString == null) {
        return null;
      }
      paramString = paramString.getMedalInfos();
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("RANK-QCircleRankListManager", 1, "[parseUserMedalSource] handle fail, error:", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleRankListManager
 * JD-Core Version:    0.7.0.1
 */