package com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils;

import UserGrowth.stNewIconStyle;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.commercial.AbsWSRichWidgetData;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class WSVerticalJumpUtils
{
  private static stSchema a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str3 = paramstSimpleMetaFeed.new_icon.h5_url;
    String str2 = paramstSimpleMetaFeed.new_icon.schema_url;
    String str1 = str2;
    if (TextUtils.isEmpty(str3))
    {
      str1 = str2;
      if (!WeishiScehmeUtil.a(str2)) {
        str1 = WeishiScehmeUtil.a(paramstSimpleMetaFeed);
      }
    }
    paramstSimpleMetaFeed = new stSchema();
    paramstSimpleMetaFeed.schema = str1;
    paramstSimpleMetaFeed.H5Url = str3;
    return paramstSimpleMetaFeed;
  }
  
  private static WSDownloadParams a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt, String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = WSVerticalUtils.a(paramWSVerticalPageFragment.a());
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = WeishiUtils.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null)) {}
    while (WeishiUtils.c()) {
      return;
    }
    if (WeishiScehmeUtil.a(paramstSimpleMetaFeed.feed_material_jump_url)) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.feed_material_jump_url; WeishiGuideUtils.a(BaseApplicationImpl.getContext()); paramstSimpleMetaFeed = WeishiScehmeUtil.a(paramstSimpleMetaFeed))
    {
      WeishiScehmeUtil.a(paramWSVerticalPageFragment.getActivity(), "biz_src_jc_gzh_weishi", paramstSimpleMetaFeed);
      return;
    }
    WeishiDownloadUtil.a(paramWSVerticalPageFragment.getActivity(), a(paramWSVerticalPageFragment, 3, paramstSimpleMetaFeed), true);
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, WSVerticalItemData paramWSVerticalItemData)
  {
    if (WeishiUtils.c()) {}
    stSchema localstSchema;
    do
    {
      do
      {
        return;
      } while ((paramWSVerticalPageFragment == null) || (paramWSVerticalItemData == null) || (paramWSVerticalItemData.a() == null));
      localstSchema = paramWSVerticalItemData.a().a();
    } while (localstSchema == null);
    String str1 = paramWSVerticalPageFragment.a();
    String str2 = paramWSVerticalPageFragment.b();
    new WSStSchemaJumpManager(paramWSVerticalPageFragment.getActivity()).a(localstSchema).a(true).a(new WSVerticalJumpUtils.2(str1, str2, paramWSVerticalItemData, localstSchema)).a();
  }
  
  public static void a(String paramString, WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.poster == null) || (paramstSimpleMetaFeed.poster.avatarSchema == null)) {
      return;
    }
    String str1 = paramWSVerticalPageFragment.a();
    String str2 = paramWSVerticalPageFragment.b();
    stSimpleMetaPerson localstSimpleMetaPerson = paramstSimpleMetaFeed.poster;
    new WSStSchemaJumpManager(paramWSVerticalPageFragment.getActivity()).a(localstSimpleMetaPerson.avatarSchema).a(a(paramWSVerticalPageFragment, 1, localstSimpleMetaPerson.avatarSchema.schema)).a(new WSVerticalJumpUtils.3(str1, str2, paramString, paramstSimpleMetaFeed)).a();
  }
  
  public static void b(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.new_icon == null)) {}
    while (WeishiUtils.c()) {
      return;
    }
    String str1 = paramWSVerticalPageFragment.a();
    String str2 = paramWSVerticalPageFragment.b();
    Object localObject = paramstSimpleMetaFeed.new_icon;
    int i = ((stNewIconStyle)localObject).tag_type;
    int j = ((stNewIconStyle)localObject).id;
    localObject = a(paramstSimpleMetaFeed);
    new WSStSchemaJumpManager(paramWSVerticalPageFragment.getActivity()).a((stSchema)localObject).a(true).a(a(paramWSVerticalPageFragment, 4, ((stSchema)localObject).schema)).a(new WSVerticalJumpUtils.1(str1, str2, paramstSimpleMetaFeed, i, j)).a();
  }
  
  private static void b(String paramString, int paramInt1, int paramInt2)
  {
    WSReportDC898Vertical.a(paramString, paramInt1, paramInt2);
  }
  
  private static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    WSVerticalBeaconReport.d(paramString1, paramString2, paramInt, paramstSimpleMetaFeed);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    WSVerticalBeaconReport.a(paramString1, paramString2, paramString3, paramInt, paramstSimpleMetaFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils
 * JD-Core Version:    0.7.0.1
 */