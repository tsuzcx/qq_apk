package com.tencent.biz.pubaccount.readinjoy.config;

import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.Aladdin.InitParams;
import com.tencent.aladdin.config.Aladdin.InitParams.Builder;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.aladdin.config.utils.SpUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameAladdinCfgHandler;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.biz.pubaccount.readinjoy.config.beans.OccasionRule;
import com.tencent.biz.pubaccount.readinjoy.config.beans.ProteusPreloadRule;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyParams;
import com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyRule;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.AdFeedsProteusBidConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.AdNativeProteusBidConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.BarrageConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.BiuTriggerTypeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.CommentFamilyConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.CommentGuideConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyDynamicHeaderConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DefaultFeedsProteusBidConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DoubleShortVideoFontSizeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DynamicOrderChannelListSwitchHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.FeedsPreloadConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.HomePageConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.KBPreDownloadConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.KandianDailySettingConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.KandianOpenOptConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.KingcardConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.MultiVideoConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.NativeProteusBidConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.NativeTextContentConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.PersonalHomePageConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.PtsAlladinKeyConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.PtsCommentFeedsAladdinKeyConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.PtsNativeFeedsAladdinKeyConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJNewReportChannelConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler.Companion;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ResetAllConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ThreadPoolMonitorConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.VDynamicConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.VideoColumnHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.VideoDynamicBufferConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.VideoEntranceTypeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.VideoSdkConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.VideoSingleModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaPicDetailConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaPicSerPreloadHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaSusAutoPlayConfig;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaVideoFeedsConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.WhiteListBidConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.WormholeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.AwesomeCommentConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.KandianReportDataConfigHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdConfigHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.VideoSoftAdConfigHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QQAladdinUtils
{
  @Deprecated
  public static int[] a = { 1, 3, 40, 41, 111, 112, 116, 117, 119, 156, 121, 122, 123, 124, 127, 131, 133, 134, 132, 136, 139, 135, 138, 144, 140, 142, 145, 147, 148, 149, 151, 152, 153, 154, 155, 157, 159, 160, 161, 162, 164, 165, 167, 168, 169, 171, 170, 172, 173, 174, 176, 177, 178, 180, 179, 181, 182, 183, 185, 187, 186, 194, 190, 189, 188, 192, 193, 191, 196, 199, 200, 201, 204, 202, 205, 206, 207, 208, 209, 211, 212, 214, 215, 216, 218, 219, 217, 220, 221, 222, 197, 223, 225, 226, 246, 227, 226, 228, 227, 230, 232, 234, 243, 238, 239, 242, 244, 245, 247, 250, 252, 251, 254, 253, 255, 256, 259, 258, 260, 261, 263, 262, 264, 265, 269, 271, 272, 273, 274, 272, 267, 266, 276, 277, 278, 280, 282, 279, 275, 281, 283, 284, 285, 286, 287, 288, 290, 306, 289, 293, 298, 296, 300, 304, 305, 293, 295, 301, 297, 303, 307, 309, 311, 312, 318, 317, 240, 313, 314, 315, 329, 320, 315, 324, 323, 326, 327, 330, 331, 332, 319, 334, 335, 336, 337, 338, 339, 340, 343, 346, 341, 342, 354, 358, 365, 366, 372, 374, 379 };
  
  static
  {
    Aladdin.registerConfigHandler(111, new BiuTriggerTypeConfigHandler());
    Aladdin.registerConfigHandler(112, new VideoEntranceTypeConfigHandler());
    Aladdin.registerConfigHandler(116, new VideoSdkConfigHandler());
    Aladdin.registerConfigHandler(117, new ChannelListDynamicOrderConfigHandler());
    Aladdin.registerConfigHandler(119, new VideoSingleModeConfigHandler());
    Aladdin.registerConfigHandler(156, new NativeProteusBidConfigHandler());
    Aladdin.registerConfigHandler(121, new KandianReportDataConfigHandler());
    Aladdin.registerConfigHandler(122, new DefaultFeedsProteusBidConfigHandler());
    Aladdin.registerConfigHandler(123, new KandianOpenOptConfigHandler());
    Aladdin.registerConfigHandler(124, new VideoDynamicBufferConfigHandler());
    Aladdin.registerConfigHandler(127, new KBPreDownloadConfigHandler());
    Aladdin.registerConfigHandler(131, new HomePageConfigHandler());
    Aladdin.registerConfigHandler(133, new ThreadPoolMonitorConfigHandler());
    Aladdin.registerConfigHandler(132, new NativeTextContentConfigHandler());
    Aladdin.registerConfigHandler(134, new FeedsPreloadConfigHandler());
    Aladdin.registerConfigHandler(135, new DailyModeConfigHandler());
    Aladdin.registerConfigHandler(138, new AwesomeCommentConfigHandler());
    Aladdin.registerConfigHandler(142, new KingcardConfigHandler());
    Aladdin.registerConfigHandler(147, new AdFeedsProteusBidConfigHandler());
    Aladdin.registerConfigHandler(148, new AdNativeProteusBidConfigHandler());
    Aladdin.registerConfigHandler(149, new KandianDailySettingConfigHandler());
    Aladdin.registerConfigHandler(155, new DynamicOrderChannelListSwitchHandler());
    Aladdin.registerConfigHandler(162, new CommentFamilyConfigHandler());
    Aladdin.registerConfigHandler(170, new ChannelModeConfigHandler());
    Aladdin.registerConfigHandler(181, new CommentGuideConfigHandler());
    Aladdin.registerConfigHandler(182, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(185, new AdConfigHandler());
    Aladdin.registerConfigHandler(187, new ReadInJoyDropFrameAladdinCfgHandler());
    Aladdin.registerConfigHandler(188, new AdConfigHandler());
    Aladdin.registerConfigHandler(157, new DailyDynamicHeaderConfigHandler());
    Aladdin.registerConfigHandler(191, new VideoColumnHandler());
    Aladdin.registerConfigHandler(200, new VideoSoftAdConfigHandler());
    Aladdin.registerConfigHandler(202, new ResetAllConfigHandler());
    Aladdin.registerConfigHandler(211, new ViolaPicDetailConfigHandler());
    Aladdin.registerConfigHandler(219, new MultiVideoConfigHandler());
    Aladdin.registerConfigHandler(221, new DoubleShortVideoFontSizeConfigHandler());
    Aladdin.registerConfigHandler(197, new ViolaPicSerPreloadHandler());
    Aladdin.registerConfigHandler(247, new WhiteListBidConfigHandler());
    Aladdin.registerConfigHandler(244, new PtsAlladinKeyConfigHandler());
    Aladdin.registerConfigHandler(274, new SimpleConfigHandler());
    Aladdin.registerConfigHandler(280, new RIJNewReportChannelConfigHandler());
    Aladdin.registerConfigHandler(282, new ViolaSusAutoPlayConfig());
    Aladdin.registerConfigHandler(287, new WormholeConfigHandler());
    Aladdin.registerConfigHandler(290, new VDynamicConfigHandler());
    Aladdin.registerConfigHandler(304, new PtsNativeFeedsAladdinKeyConfigHandler());
    Aladdin.registerConfigHandler(305, new PtsCommentFeedsAladdinKeyConfigHandler());
    Aladdin.registerConfigHandler(346, new ViolaVideoFeedsConfigHandler());
    Aladdin.registerConfigHandler(360, new PersonalHomePageConfigHandler());
    Aladdin.registerConfigHandler(369, new BarrageConfigHandler());
    Aladdin.registerConfigHandler(401, RIJXTabConfigHandler.a.a());
  }
  
  private static List<Integer> a(int[] paramArrayOfInt)
  {
    Object localObject;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      localObject = new ArrayList();
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
  }
  
  public static void a()
  {
    Aladdin.initialize(Aladdin.InitParams.newBuilder().withUserId(ReadInJoyUtils.a()).withAppVersion("8.5.5").withContext(BaseApplicationImpl.getContext()).withExecutor(QQAsyncTaskExecutor.a).withRequestHandler(new QQAladdinRequestHandler()).withAppFlavorId(AppSetting.a() + "").withLogger(new QQAladdinLogger()).build());
    d();
    e();
    Aladdin.registerBeanClass("SneakyParams", SneakyParams.class);
    Aladdin.registerBeanClass("AchillesParams", AchillesParams.class);
    Aladdin.registerBeanClass("SneakyRule", SneakyRule.class);
    Aladdin.registerBeanClass("OccasionRule", OccasionRule.class);
    Aladdin.registerBeanClass("ProteusPreloadRule", ProteusPreloadRule.class);
    Aladdin.registerConfigParser(136, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    Aladdin.registerConfigParser(139, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    Aladdin.registerConfigParser(140, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    Aladdin.registerConfigParser(334, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
    c();
  }
  
  private static int[] a(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int[] a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return a;
    }
    try
    {
      int[] arrayOfInt = new int[a.length + paramArrayOfInt.length];
      arrayOfInt = Arrays.copyOf(a, arrayOfInt.length);
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, a.length, paramArrayOfInt.length);
      return arrayOfInt;
    }
    catch (Throwable paramArrayOfInt)
    {
      QLog.d("mergeIds", 1, "mergeIds error: " + paramArrayOfInt.getMessage());
    }
    return null;
  }
  
  public static void b()
  {
    Object localObject = VDynamicConfigHandler.a();
    if ((localObject == null) || (localObject.length == 0))
    {
      Aladdin.requestForUpdate(a);
      return;
    }
    int[] arrayOfInt = a((int[])localObject);
    if (arrayOfInt != null)
    {
      localObject = arrayOfInt;
      if (arrayOfInt.length > a.length) {}
    }
    else
    {
      localObject = a;
    }
    Aladdin.requestForUpdate((int[])localObject);
  }
  
  private static void c()
  {
    ThreadManagerV2.executeOnSubThread(new QQAladdinUtils.1());
  }
  
  private static void d()
  {
    SpUtils.registerAladdinSharedPreferences(new QQAladdinUtils.2());
  }
  
  private static void e()
  {
    Object localObject2 = a(Aladdin.getConfigIdList());
    Object localObject1 = a(a);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      i = ((Integer)((Iterator)localObject2).next()).intValue();
      if (!((List)localObject1).contains(Integer.valueOf(i)))
      {
        ((List)localObject1).add(Integer.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.i("QQAladdinUtils", 0, "[initLocalConfigIds] merge configId = " + i);
        }
      }
    }
    a = a((List)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[initLocalConfigIds] ALL_CONFIGS = ");
    localObject2 = a;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append(localObject2[i]).append(" | ");
      i += 1;
    }
    QLog.i("QQAladdinUtils", 1, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.QQAladdinUtils
 * JD-Core Version:    0.7.0.1
 */