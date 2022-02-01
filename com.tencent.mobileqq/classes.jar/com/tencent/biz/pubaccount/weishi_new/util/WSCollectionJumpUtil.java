package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stCollection;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.jump.IJumpListener;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import java.util.ArrayList;
import java.util.List;

public class WSCollectionJumpUtil
{
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, stCollection paramstCollection, int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramContext, paramstSimpleMetaFeed, paramstCollection, "vertical_layer_collection_of_card", "feeds", paramString, new WSCollectionJumpUtil.3(paramInt1, paramInt2, paramstCollection, paramstSimpleMetaFeed, paramString), new WSCollectionJumpUtil.4(paramInt1, paramInt2, paramstCollection, paramstSimpleMetaFeed, paramString)))
    {
      WSReportUtils.b(String.valueOf(System.currentTimeMillis()));
      WSVerticalBeaconReport.b(paramString);
    }
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString)
  {
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null)) {
      return;
    }
    String str1 = paramWSVerticalPageFragment.a();
    String str2 = paramWSVerticalPageFragment.b();
    a(paramWSVerticalPageFragment.getActivity(), paramstSimpleMetaFeed, paramstSimpleMetaFeed.collection, "vertical_layer_collection", str2, paramString, new WSCollectionJumpUtil.1(str1, str2, paramstSimpleMetaFeed), new WSCollectionJumpUtil.2(str1, str2, paramstSimpleMetaFeed));
  }
  
  private static boolean a(stSchema paramstSchema)
  {
    if (paramstSchema == null) {}
    while ((TextUtils.isEmpty(paramstSchema.miniAppSchema)) && (TextUtils.isEmpty(paramstSchema.schema)) && (TextUtils.isEmpty(paramstSchema.H5Url))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, stCollection paramstCollection, String paramString1, String paramString2, String paramString3, IJumpListener paramIJumpListener, WSCollectionJumpUtil.IJumpCollectionPageListener paramIJumpCollectionPageListener)
  {
    if ((paramstSimpleMetaFeed == null) || (paramstCollection == null)) {
      return false;
    }
    if ((paramstCollection.click_action == 2) && (WeishiGuideUtils.a(paramContext)) && (a(paramstCollection.schema)))
    {
      new WSStSchemaJumpManager(paramContext).a(paramstCollection.schema).a(paramIJumpListener).a();
      return false;
    }
    paramIJumpListener = new ArrayList();
    paramIJumpListener.add(paramstSimpleMetaFeed);
    WSVerticalPageFragment.a(new WSVerticalPageOpenParams(paramContext, paramString1, paramString2).a(paramIJumpListener).a(0).a(paramstCollection).a(paramString3));
    if (paramIJumpCollectionPageListener != null) {
      paramIJumpCollectionPageListener.a();
    }
    return true;
  }
  
  private static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    WSVerticalBeaconReport.a(paramString1, paramString2, paramstSimpleMetaFeed, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSCollectionJumpUtil
 * JD-Core Version:    0.7.0.1
 */