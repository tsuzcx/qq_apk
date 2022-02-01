package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedParseUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WSVideoCollectionPageJumpAction
  extends AbsWSJumpAction
{
  private String a(String paramString)
  {
    if (TextUtils.equals(paramString, "fullscreen_videoplay")) {
      return "vertical_layer_collection";
    }
    if (TextUtils.equals(paramString, "feeds")) {
      return "vertical_layer_collection_of_card";
    }
    return "vertical_layer_collection";
  }
  
  private void a(Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    String str2 = (String)paramMap.get("cid");
    String str3 = (String)paramMap.get("feed_id");
    Object localObject = (String)paramMap.get("feeds");
    String str4 = a(this.c);
    boolean bool = TextUtils.equals("1", (String)paramMap.get("panel_show"));
    ArrayList localArrayList = new ArrayList();
    localObject = WSFeedParseUtils.a((String)localObject);
    if ((paramObject instanceof Bundle))
    {
      paramMap = (Bundle)paramObject;
      String str1 = paramMap.getString("tab_id");
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramMap.getSerializable("feed_info");
      paramObject = localObject;
      paramMap = str1;
      if (localstSimpleMetaFeed != null)
      {
        paramObject = localstSimpleMetaFeed;
        paramMap = str1;
      }
    }
    else
    {
      paramMap = "";
      paramObject = localObject;
    }
    if (paramObject != null) {
      localArrayList.add(paramObject);
    }
    paramObject = new Bundle();
    paramObject.putString("ext_data", this.a);
    WSVerticalPageFragment.a(new WSVerticalPageOpenParams(paramContext, str4, this.c).a(0).d(str2).e(str3).a(localArrayList).a(paramMap).d(bool).a(TextUtils.equals(this.b, "miniapp")).a(paramObject));
  }
  
  protected boolean a(Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    a(paramContext, paramMap, paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.WSVideoCollectionPageJumpAction
 * JD-Core Version:    0.7.0.1
 */