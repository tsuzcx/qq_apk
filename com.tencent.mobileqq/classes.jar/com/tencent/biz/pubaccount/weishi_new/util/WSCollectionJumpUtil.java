package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stCollection;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.jump.IJumpListener;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import java.util.Map;

public class WSCollectionJumpUtil
{
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, stCollection paramstCollection, int paramInt1, int paramInt2, String paramString)
  {
    if (paramContext != null)
    {
      if (paramstSimpleMetaFeed == null) {
        return;
      }
      a(paramContext, paramstSimpleMetaFeed, paramstCollection.schema, "vertical_layer_collection_of_card", paramString, new WSCollectionJumpUtil.2(paramInt1, paramInt2, paramstCollection, paramstSimpleMetaFeed, paramString));
    }
  }
  
  private static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, stSchema paramstSchema, String paramString1, String paramString2, IJumpListener paramIJumpListener)
  {
    if (paramstSimpleMetaFeed != null)
    {
      if (paramstSchema == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("tab_id", paramString2);
      localBundle.putString("from", paramString1);
      localBundle.putSerializable("feed_info", paramstSimpleMetaFeed);
      new WSStSchemaJumpManager(paramContext).a(paramstSchema).a(localBundle).a(paramIJumpListener).j();
    }
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed, stSchema paramstSchema, String paramString, Map<String, String> paramMap)
  {
    if (paramWSVerticalPageFragment != null)
    {
      if (paramstSimpleMetaFeed == null) {
        return;
      }
      String str1 = paramWSVerticalPageFragment.k();
      String str2 = paramWSVerticalPageFragment.l();
      a(paramWSVerticalPageFragment.getActivity(), paramstSimpleMetaFeed, paramstSchema, "", paramString, new WSCollectionJumpUtil.1(str1, str2, paramstSimpleMetaFeed, paramMap));
    }
  }
  
  private static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, Map<String, String> paramMap)
  {
    WSVerticalBeaconReport.a(paramString1, paramString2, paramstSimpleMetaFeed, paramInt, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSCollectionJumpUtil
 * JD-Core Version:    0.7.0.1
 */