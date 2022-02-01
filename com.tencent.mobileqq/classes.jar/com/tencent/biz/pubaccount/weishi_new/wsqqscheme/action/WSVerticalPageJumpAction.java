package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi_new.WSHomeLaunchParams;
import com.tencent.biz.pubaccount.weishi_new.WSOpenHomeThenVideoParams;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.HomeLauncher;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedParseUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class WSVerticalPageJumpAction
  extends AbsWSJumpAction
{
  private void a(@NonNull Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    String str;
    if (this.c == null) {
      str = "";
    } else {
      str = this.c;
    }
    paramString2 = new WSOpenHomeThenVideoParams(paramString1, paramString2, new WSAutoShowCommentParams(paramString3), str);
    WSLauncher.HomeLauncher.a(new WSHomeLaunchParams(paramContext, 1, str).a(paramString2).a(paramString1));
  }
  
  private void a(Context paramContext, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("feed_id");
    Object localObject2 = (String)paramMap.get("feeds");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = new HashMap();
        ((Map)localObject1).put("id", str);
        localObject1 = new JSONObject((Map)localObject1).toString();
      }
    }
    boolean bool = "1".equals(paramMap.get("is_pre_open_home"));
    Bundle localBundle = new Bundle();
    localBundle.putString("ext_data", this.a);
    localBundle.putString("scenes_channel_from", this.d);
    localBundle.putString("share_feed_id", str);
    localBundle.putString("scheme_src_type", this.b);
    WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
    if (bool) {
      localObject2 = "from_open_home_then_video";
    } else {
      localObject2 = "from_qq_scheme";
    }
    localWSPublicAccReport.enterPublicAccReport(null, 2, (String)localObject2, localBundle);
    if (bool)
    {
      a(paramContext, str, (String)localObject1, (String)paramMap.get("ext"));
      return;
    }
    localObject1 = WSFeedParseUtils.a((String)localObject1);
    localObject2 = new ArrayList();
    if (localObject1 != null) {
      ((List)localObject2).add(localObject1);
    }
    if (TextUtils.equals((CharSequence)paramMap.get("scenes_from"), "weishi_share_trendstab")) {
      localObject1 = "msg_feed";
    } else {
      localObject1 = "qq_scheme_open_player";
    }
    WSLauncher.VerticalPageLauncher.a(new WSVerticalPageOpenParams(paramContext, (String)localObject1, this.c).a((List)localObject2).a(TextUtils.equals(this.b, "miniapp")).a(localBundle).e(2).a(new WSAutoShowCommentParams((String)paramMap.get("ext"))));
  }
  
  protected boolean a(Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    a(paramContext, paramMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.WSVerticalPageJumpAction
 * JD-Core Version:    0.7.0.1
 */