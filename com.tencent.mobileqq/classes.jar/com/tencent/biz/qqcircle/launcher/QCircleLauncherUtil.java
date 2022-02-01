package com.tencent.biz.qqcircle.launcher;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment;
import com.tencent.biz.qqcircle.immersive.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest.Builder;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetLikeFeedListRequest.Builder;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageRequest.Builder;
import com.tencent.biz.qqcircle.preload.task.QCirclePersonalDetailPreLoaderTask;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest.Builder;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;

public class QCircleLauncherUtil
{
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null)
    {
      QLog.e("QCircleLauncherUtil", 1, "context is null,cannot start activity");
      return;
    }
    paramIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(Intent paramIntent, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      paramIntent.putExtra("key_attrs", paramHashMap);
      Object localObject = (String)paramHashMap.get("key_scheme");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramIntent.putExtra("key_scheme", (String)localObject);
      }
      if (paramHashMap.containsKey("image"))
      {
        localObject = ((String)paramHashMap.get("image")).split(";");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localObject.length)
        {
          localArrayList.add(localObject[i]);
          i += 1;
        }
        paramIntent.putExtra(QCircleHostQzoneHelper.QZONE_SHARE_IMAGES(), localArrayList);
      }
      if (paramHashMap.containsKey("content")) {
        paramIntent.putExtra(QCircleHostQzoneHelper.QZONE_SHARE_SUMMERY(), (String)paramHashMap.get("content"));
      }
      if (paramHashMap.containsKey("frompage")) {
        try
        {
          paramIntent.putExtra("fromType", Integer.parseInt((String)paramHashMap.get("frompage")));
          return;
        }
        catch (Exception paramIntent)
        {
          QLog.e("QCircleLauncherUtil", 1, "parse frompage error", paramIntent);
        }
      }
    }
  }
  
  public static void a(QCircleInitBean paramQCircleInitBean)
  {
    Object localObject2 = paramQCircleInitBean.getUser().id.get();
    if (!QCircleConfigHelper.bg())
    {
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = QCircleCommonUtil.getCurrentAccount();
        paramQCircleInitBean.getUser().id.set((String)localObject1);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("2001");
      ((StringBuilder)localObject2).append((String)localObject1);
      PreLoader.remove(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("2001");
      ((StringBuilder)localObject2).append((String)localObject1);
      PreLoader.preLoad(((StringBuilder)localObject2).toString(), new QCirclePersonalDetailPreLoaderTask((String)localObject1, paramQCircleInitBean));
      return;
    }
    a((String)localObject2);
  }
  
  private static void a(String paramString)
  {
    QCircleRequestCall localQCircleRequestCall = QCircleRequestSender.a().b().b(false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("2001");
    localStringBuilder.append(paramString);
    localQCircleRequestCall.a(localStringBuilder.toString(), new QFSGetMainPageRequest.Builder(paramString).c().d()).a();
    localQCircleRequestCall = QCircleRequestSender.a().b().b(false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("2012");
    localStringBuilder.append(paramString);
    localQCircleRequestCall.a(localStringBuilder.toString(), new QFSGetFeedListRequest.Builder(paramString).a(0).b(9).c().d()).a();
    if (QCircleCommonUtil.isOwner(paramString))
    {
      localQCircleRequestCall = QCircleRequestSender.a().b().b(false);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("2011");
      localStringBuilder.append(paramString);
      localQCircleRequestCall.a(localStringBuilder.toString(), new QFSGetLikeFeedListRequest.Builder(paramString).a(0).b(42).c().d()).a();
    }
  }
  
  public static boolean a()
  {
    return (!QCircleConfigHelper.bg()) && (QCircleConfigHelper.a("qqcircle", "secondary_key_qqcircle_enable_content_detail_flutter_v5", Integer.valueOf(1)).intValue() == 1);
  }
  
  public static String b()
  {
    Object localObject;
    if (QCircleConfigHelper.bg()) {
      localObject = QFSLayerPageFragment.class;
    } else {
      localObject = QCircleContentDetailFragment.class;
    }
    return ((Class)localObject).getName();
  }
  
  public static Class c()
  {
    if (QCircleConfigHelper.bg()) {
      return QCircleFragmentActivity.class;
    }
    return QCircleTransFragmentActivity.class;
  }
  
  public static String d()
  {
    Object localObject;
    if (QCircleConfigHelper.bg()) {
      localObject = QFSPersonalDetailsFragment.class;
    } else {
      localObject = QCirclePersonalDetailFragment.class;
    }
    return ((Class)localObject).getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil
 * JD-Core Version:    0.7.0.1
 */