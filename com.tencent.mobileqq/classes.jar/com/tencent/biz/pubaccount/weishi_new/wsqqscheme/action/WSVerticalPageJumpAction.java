package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedParseUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import org.json.JSONObject;

public class WSVerticalPageJumpAction
  extends AbsWSJumpAction
{
  private void a(Context paramContext, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("feed_id");
    Object localObject = (String)paramMap.get("feeds");
    paramMap = (Map<String, String>)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMap = (Map<String, String>)localObject;
      if (!TextUtils.isEmpty(str))
      {
        paramMap = new HashMap();
        paramMap.put("id", str);
        paramMap = new JSONObject(paramMap).toString();
      }
    }
    localObject = WSFeedParseUtils.a(paramMap);
    paramMap = new ArrayList();
    if (localObject != null) {
      paramMap.add(localObject);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("ext_data", this.a);
    ((Bundle)localObject).putString("scenes_channel_from", this.d);
    WSVerticalPageFragment.a(new WSVerticalPageOpenParams(paramContext, "qq_scheme_open_player", this.c).a(paramMap).a(TextUtils.equals(this.b, "miniapp")).a((Bundle)localObject));
  }
  
  protected boolean a(Context paramContext, Map<String, String> paramMap, Object paramObject)
  {
    a(paramContext, paramMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.WSVerticalPageJumpAction
 * JD-Core Version:    0.7.0.1
 */