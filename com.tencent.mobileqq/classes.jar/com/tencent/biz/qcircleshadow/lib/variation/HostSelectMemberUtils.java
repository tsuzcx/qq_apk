package com.tencent.biz.qcircleshadow.lib.variation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import java.util.ArrayList;
import java.util.Iterator;

public class HostSelectMemberUtils
{
  public static ArrayList<HostSelectMemberUtils.QCircleResultData> getResultList(Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
    if (paramIntent != null)
    {
      ArrayList localArrayList = new ArrayList(paramIntent.size());
      Iterator localIterator = paramIntent.iterator();
      for (;;)
      {
        paramIntent = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramIntent = (ResultRecord)localIterator.next();
        HostSelectMemberUtils.QCircleResultData localQCircleResultData = new HostSelectMemberUtils.QCircleResultData();
        localQCircleResultData.uin = paramIntent.uin;
        localQCircleResultData.name = paramIntent.name;
        localArrayList.add(localQCircleResultData);
      }
    }
    paramIntent = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils
 * JD-Core Version:    0.7.0.1
 */