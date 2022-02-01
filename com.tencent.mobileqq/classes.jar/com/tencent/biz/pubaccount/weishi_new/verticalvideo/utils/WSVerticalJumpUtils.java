package com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils;

import UserGrowth.stCallWeishiButton;
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
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Map;

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
    localWSDownloadParams.mScene = WSVerticalUtils.a(paramWSVerticalPageFragment.k());
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().d();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = WeishiUtils.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramWSVerticalPageFragment != null)
    {
      if (paramstSimpleMetaFeed == null) {
        return;
      }
      if (WeishiUtils.o()) {
        return;
      }
      if (WeishiScehmeUtil.a(paramstSimpleMetaFeed.feed_material_jump_url)) {
        paramstSimpleMetaFeed = paramstSimpleMetaFeed.feed_material_jump_url;
      } else {
        paramstSimpleMetaFeed = WeishiScehmeUtil.a(paramstSimpleMetaFeed);
      }
      if (WeishiGuideUtils.a(BaseApplicationImpl.getContext()))
      {
        WeishiScehmeUtil.a(paramWSVerticalPageFragment.getActivity(), "biz_src_jc_gzh_weishi", paramstSimpleMetaFeed);
        return;
      }
      WeishiDownloadUtil.a(paramWSVerticalPageFragment.getActivity(), a(paramWSVerticalPageFragment, 3, paramstSimpleMetaFeed), true);
    }
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, WSVerticalItemData paramWSVerticalItemData)
  {
    a(paramWSVerticalPageFragment, paramWSVerticalItemData, false);
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, WSVerticalItemData paramWSVerticalItemData, boolean paramBoolean)
  {
    if (WeishiUtils.o()) {
      return;
    }
    if ((paramWSVerticalPageFragment != null) && (paramWSVerticalItemData != null) && (paramWSVerticalItemData.f() != null))
    {
      stSchema localstSchema = paramWSVerticalItemData.f().a();
      if (localstSchema == null) {
        return;
      }
      String str1 = paramWSVerticalPageFragment.k();
      String str2 = paramWSVerticalPageFragment.l();
      new WSStSchemaJumpManager(paramWSVerticalPageFragment.getActivity()).a(localstSchema).a(true).a(new WSVerticalJumpUtils.2(str1, str2, paramWSVerticalItemData, localstSchema, paramBoolean)).j();
    }
  }
  
  public static void a(String paramString, WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    
    if ((paramWSVerticalPageFragment != null) && (paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      if (paramstSimpleMetaFeed.poster.avatarSchema == null) {
        return;
      }
      String str1 = paramWSVerticalPageFragment.k();
      String str2 = paramWSVerticalPageFragment.l();
      Map localMap = ((WSVerticalPageContract.Presenter)paramWSVerticalPageFragment.aO_()).n();
      stSimpleMetaPerson localstSimpleMetaPerson = paramstSimpleMetaFeed.poster;
      new WSStSchemaJumpManager(paramWSVerticalPageFragment.getActivity()).a(localstSimpleMetaPerson.avatarSchema).a(a(paramWSVerticalPageFragment, 1, localstSimpleMetaPerson.avatarSchema.schema)).a(new WSVerticalJumpUtils.3(str1, str2, paramString, paramstSimpleMetaFeed, localMap)).j();
    }
  }
  
  public static void b(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment != null) && (paramstSimpleMetaFeed != null))
    {
      if (paramstSimpleMetaFeed.new_icon == null) {
        return;
      }
      if (WeishiUtils.o()) {
        return;
      }
      String str1 = paramWSVerticalPageFragment.k();
      String str2 = paramWSVerticalPageFragment.l();
      Object localObject = paramstSimpleMetaFeed.new_icon;
      int i = ((stNewIconStyle)localObject).tag_type;
      int j = ((stNewIconStyle)localObject).id;
      localObject = a(paramstSimpleMetaFeed);
      new WSStSchemaJumpManager(paramWSVerticalPageFragment.getActivity()).a((stSchema)localObject).a(true).a(a(paramWSVerticalPageFragment, 4, ((stSchema)localObject).schema)).a(new WSVerticalJumpUtils.1(str1, str2, paramstSimpleMetaFeed, i, j)).j();
    }
  }
  
  private static void b(String paramString, int paramInt1, int paramInt2)
  {
    WSReportDC898Vertical.a(paramString, paramInt1, paramInt2);
  }
  
  private static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    WSVerticalBeaconReport.a(paramString1, paramString2, paramInt, paramstSimpleMetaFeed);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, Map<String, String> paramMap)
  {
    WSVerticalBeaconReport.a(paramString1, paramString2, paramString3, paramInt, paramstSimpleMetaFeed, paramMap);
  }
  
  public static void c(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment != null) && (paramstSimpleMetaFeed != null))
    {
      if (paramstSimpleMetaFeed.weishiButton == null) {
        return;
      }
      if (WeishiUtils.o()) {
        return;
      }
      String str1 = paramWSVerticalPageFragment.k();
      String str2 = paramWSVerticalPageFragment.l();
      new WSStSchemaJumpManager(paramWSVerticalPageFragment.getActivity()).a(paramstSimpleMetaFeed.weishiButton.schema).a(true).c(true).a(new WSVerticalJumpUtils.4(str1, str2, paramstSimpleMetaFeed)).j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils
 * JD-Core Version:    0.7.0.1
 */