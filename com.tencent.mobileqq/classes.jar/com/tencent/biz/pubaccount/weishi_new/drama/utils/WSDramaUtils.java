package com.tencent.biz.pubaccount.weishi_new.drama.utils;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import UserGrowth.stGetFollowedDramasRsp;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaData;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaVideoPlayReportParams;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSDramaUtils
{
  public static String a = "_preview_1";
  public static String b = "_preview_2";
  public static String c = "_preview_3";
  
  @Nullable
  public static WSFollowDramaData a(@Nullable stGetFollowedDramasRsp paramstGetFollowedDramasRsp)
  {
    if (paramstGetFollowedDramasRsp == null) {
      return null;
    }
    WSFollowDramaData localWSFollowDramaData = new WSFollowDramaData();
    localWSFollowDramaData.a(paramstGetFollowedDramasRsp.title);
    localWSFollowDramaData.a(a(paramstGetFollowedDramasRsp.dramas));
    return localWSFollowDramaData;
  }
  
  public static String a(Context paramContext, stDramaInfo paramstDramaInfo)
  {
    if (paramstDramaInfo.isPublishCompleted) {
      return paramContext.getString(1929838605, new Object[] { Integer.valueOf(paramstDramaInfo.curPublishedFeedNum) });
    }
    return paramContext.getString(1929838606, new Object[] { Integer.valueOf(paramstDramaInfo.curPublishedFeedNum) });
  }
  
  public static String a(AbsWSDramaHolder paramAbsWSDramaHolder)
  {
    if (paramAbsWSDramaHolder != null) {
      paramAbsWSDramaHolder = paramAbsWSDramaHolder.c;
    } else {
      paramAbsWSDramaHolder = null;
    }
    if (paramAbsWSDramaHolder != null) {
      return paramAbsWSDramaHolder.e();
    }
    return "";
  }
  
  @NonNull
  public static List<WSFollowDramaItemData> a(@Nullable ArrayList<stDrama> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList == null) {
      return localArrayList;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      stDrama localstDrama = (stDrama)paramArrayList.next();
      if (localstDrama != null)
      {
        stDramaInfo localstDramaInfo = localstDrama.dramaInfo;
        if (localstDramaInfo != null) {
          localArrayList.add(new WSFollowDramaItemData().a(localstDramaInfo.id).b(localstDramaInfo.coverImg).c(localstDramaInfo.name).a(localstDrama.showUpdate).b(localstDramaInfo.isPublishCompleted).b(localstDramaInfo.curPublishedFeedNum).a(localstDramaInfo.curWatchedFeedNum));
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(WSDramaPageContract.View paramView, WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    AbsWSDramaHolder localAbsWSDramaHolder = paramView.e();
    WSDramaBeaconReport.a(new WSDramaVideoPlayReportParams(paramView.b(), paramWSPlayerParam).a(c(localAbsWSDramaHolder)).b(paramBoolean).a(d(localAbsWSDramaHolder)));
  }
  
  public static void a(WSDramaPageFragment paramWSDramaPageFragment, String paramString1, String paramString2, String paramString3)
  {
    if (paramWSDramaPageFragment != null)
    {
      if (WeishiUtils.o()) {
        return;
      }
      Object localObject = paramWSDramaPageFragment.aK_();
      if (!a(paramString1, paramString2))
      {
        if (a((WSPlayerManager)localObject)) {
          return;
        }
        paramWSDramaPageFragment.e(false);
        localObject = new Bundle();
        ((Bundle)localObject).putString("drama_id", paramString1);
        ((Bundle)localObject).putString("current_episode_id", paramString2);
        paramString3 = new WSVerticalPageOpenParams(paramWSDramaPageFragment.getActivity(), "drama_preview", b(paramWSDramaPageFragment.b(), paramString3)).a(1).b(4097).a((Bundle)localObject);
        WSLauncher.VerticalPageLauncher.b(paramString3);
        localObject = paramWSDramaPageFragment.e();
        WSDramaBeaconReport.a(paramString2, a((AbsWSDramaHolder)localObject), paramString1, d((AbsWSDramaHolder)localObject), paramWSDramaPageFragment.b());
        paramWSDramaPageFragment = new StringBuilder();
        paramWSDramaPageFragment.append("[WSDramaUtils.java][startVerticalPageSeamless] params:");
        paramWSDramaPageFragment.append(paramString3);
        WSLog.d("WSDramaUtilsLog", paramWSDramaPageFragment.toString());
      }
    }
  }
  
  private static boolean a(WSPlayerManager paramWSPlayerManager)
  {
    return (paramWSPlayerManager != null) && ((paramWSPlayerManager.l()) || (paramWSPlayerManager.j()));
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2));
  }
  
  public static String b(AbsWSDramaHolder paramAbsWSDramaHolder)
  {
    if (paramAbsWSDramaHolder != null) {
      paramAbsWSDramaHolder = paramAbsWSDramaHolder.c;
    } else {
      paramAbsWSDramaHolder = null;
    }
    if (paramAbsWSDramaHolder != null) {
      return paramAbsWSDramaHolder.d();
    }
    return "";
  }
  
  private static String b(String paramString1, String paramString2)
  {
    int i = paramString1.hashCode();
    if (i != -1282366045)
    {
      if (i != -763476863)
      {
        if ((i == 836791522) && (paramString1.equals("grid_drama_follow")))
        {
          i = 2;
          break label76;
        }
      }
      else if (paramString1.equals("grid_drama_card"))
      {
        i = 0;
        break label76;
      }
    }
    else if (paramString1.equals("aio_red_dot"))
    {
      i = 1;
      break label76;
    }
    i = -1;
    label76:
    Object localObject = "";
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          paramString1 = "";
        } else {
          paramString1 = "feeds_history";
        }
      }
      else {
        paramString1 = "direct";
      }
    }
    else {
      paramString1 = "feeds";
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static void b(WSDramaPageContract.View paramView, WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    AbsWSDramaHolder localAbsWSDramaHolder = paramView.e();
    WSDramaBeaconReport.b(new WSDramaVideoPlayReportParams(paramView.b(), paramWSPlayerParam).a(c(localAbsWSDramaHolder)).a(d(localAbsWSDramaHolder)).a(paramBoolean));
  }
  
  public static void b(WSDramaPageFragment paramWSDramaPageFragment, String paramString1, String paramString2, String paramString3)
  {
    if ((paramWSDramaPageFragment != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("drama_id", paramString1);
      localBundle.putString("current_episode_id", paramString2);
      paramWSDramaPageFragment = new WSVerticalPageOpenParams(paramWSDramaPageFragment.getActivity(), "drama_history", b(paramWSDramaPageFragment.b(), paramString3)).a(1).a(localBundle);
      WSLauncher.VerticalPageLauncher.a(paramWSDramaPageFragment);
      paramString1 = new StringBuilder();
      paramString1.append("[WSDramaUtils.java][startVerticalPageHistory] params:");
      paramString1.append(paramWSDramaPageFragment);
      WSLog.d("WSDramaUtilsLog", paramString1.toString());
    }
  }
  
  public static String c(AbsWSDramaHolder paramAbsWSDramaHolder)
  {
    if (paramAbsWSDramaHolder != null) {
      paramAbsWSDramaHolder = paramAbsWSDramaHolder.c;
    } else {
      paramAbsWSDramaHolder = null;
    }
    if (paramAbsWSDramaHolder != null) {
      return paramAbsWSDramaHolder.b();
    }
    return "";
  }
  
  public static int d(AbsWSDramaHolder paramAbsWSDramaHolder)
  {
    if (paramAbsWSDramaHolder != null) {
      paramAbsWSDramaHolder = paramAbsWSDramaHolder.c;
    } else {
      paramAbsWSDramaHolder = null;
    }
    if (paramAbsWSDramaHolder != null) {
      return paramAbsWSDramaHolder.c();
    }
    return 0;
  }
  
  public static int e(AbsWSDramaHolder paramAbsWSDramaHolder)
  {
    if (paramAbsWSDramaHolder != null) {
      paramAbsWSDramaHolder = paramAbsWSDramaHolder.c;
    } else {
      paramAbsWSDramaHolder = null;
    }
    if ((paramAbsWSDramaHolder != null) && (paramAbsWSDramaHolder.i() != null)) {
      return paramAbsWSDramaHolder.i().videoPoolType;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils
 * JD-Core Version:    0.7.0.1
 */