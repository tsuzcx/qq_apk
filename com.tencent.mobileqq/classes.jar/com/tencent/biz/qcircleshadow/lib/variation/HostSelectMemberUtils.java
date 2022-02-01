package com.tencent.biz.qcircleshadow.lib.variation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;

public class HostSelectMemberUtils
{
  public static ArrayList<HostSelectMemberUtils.QCircleResultData> getResultList(Intent paramIntent)
  {
    Object localObject = paramIntent.getParcelableArrayListExtra("result_set");
    paramIntent = null;
    if (localObject != null)
    {
      paramIntent = new ArrayList(((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
        HostSelectMemberUtils.QCircleResultData localQCircleResultData = new HostSelectMemberUtils.QCircleResultData();
        localQCircleResultData.uin = localResultRecord.uin;
        localQCircleResultData.name = localResultRecord.name;
        paramIntent.add(localQCircleResultData);
      }
    }
    return paramIntent;
  }
  
  public static void onAtClick(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("param_only_friends", paramBoolean);
    localBundle.putInt("param_min", paramInt1);
    localBundle.putInt("param_max", paramInt2);
    localBundle.putInt("param_entrance", 42);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity)paramContext, localBundle, paramInt3);
  }
  
  public static void onPublishClick(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("param_only_friends", paramBoolean);
    localBundle.putInt("param_min", paramInt1);
    localBundle.putInt("param_max", paramInt2);
    localBundle.putInt("param_entrance", 41);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity)paramContext, localBundle, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils
 * JD-Core Version:    0.7.0.1
 */