package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentAvatarView.Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentContentView.Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLikeView.Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentRichTextView.Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.ExposeReplyCommentView.Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.PTSCommentLinkView.Builder;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.AccountCardItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.AnswerProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.BigImageProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.BigImageVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.BiuAnswerProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.BiuPgcProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.BiuUgcProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ColumnTwoVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.CommentBiuProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.DoubleShortVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.DoubleVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.GalleryProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.KandianTenProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.LiveDoubleVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.LiveSingleVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.MultiVideoColumnProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.NewPolymericMultiVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.NoteCardProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.PackProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcShortContentProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.QuestionAnswerCardProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.QuestionCardProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.SmallImageProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.TripleProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.UgcProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.WechatSimpleVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.FluencyLogUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.LogUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ArticleCommentView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.AvatarView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.AvatarView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.BiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.BiuCommentView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.CornerTextImageView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.CornerTextImageView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.GridImageView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.GridImageView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ProteusTickerView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyAdLocationView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyAdVideoCompleteGuide.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyAwesomeCommentView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyBiuButton.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyCoordinateView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyFriendsBiu.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyGifView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLikeButton.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLottieView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyShareView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyVideoView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyApngImageView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyAsynImageIcon.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyImageView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyProgressView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.SummaryView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.SummaryView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.UsersCommentsView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.Builder;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteItemViewUtil;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteItemViewUtil.Companion;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.ReadInJoySrtHandler;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLayoutImpl;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText.Builder;
import com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJAdDownloadViewBase.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBigImageProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBigVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBrandOptimizationProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdPKImageProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameHorizListProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameListProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameNewStyleProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameTripleImgProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdSmallImageProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdTripleProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ProteusSupportAdUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdCommonBlurImageView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdInnerOperateView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyBlurImageView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyIconText.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView.Builder;
import com.tencent.biz.pubaccount.util.ProteusReportUtil;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ProteusSupportUtil
{
  private static double jdField_a_of_type_Double = 0.0D;
  private static int jdField_a_of_type_Int;
  private static final ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private static final Map<Integer, ProteusItem> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      a(3, new TripleProteusItem());
      a(72, new AnswerProteusItem());
      a(73, new BiuAnswerProteusItem());
      a(74, new QuestionCardProteusItem());
      a(90, new QuestionAnswerCardProteusItem());
      a(91, new QuestionAnswerCardProteusItem());
      a(75, new QuestionCardProteusItem());
      a(21, new UgcProteusItem());
      a(22, new UgcProteusItem());
      a(36, new UgcProteusItem());
      a(23, new UgcProteusItem());
      a(120, new UgcProteusItem());
      a(80, new UgcProteusItem());
      a(34, new PgcProteusItem());
      a(16, new PgcProteusItem());
      a(17, new PgcProteusItem());
      a(19, new PgcProteusItem());
      a(18, new PgcProteusItem());
      a(20, new PgcProteusItem());
      a(65, new PgcProteusItem());
      a(64, new PgcProteusItem());
      a(48, new PgcProteusItem());
      a(25, new BiuUgcProteusItem());
      a(24, new BiuUgcProteusItem());
      a(26, new BiuUgcProteusItem());
      a(107, new UgcProteusItem());
      a(108, new BiuUgcProteusItem());
      a(37, new BiuUgcProteusItem());
      a(81, new BiuUgcProteusItem());
      a(35, new BiuPgcProteusItem());
      a(12, new BiuPgcProteusItem());
      a(10, new BiuPgcProteusItem());
      a(11, new BiuPgcProteusItem());
      a(28, new BiuPgcProteusItem());
      a(27, new BiuPgcProteusItem());
      a(49, new BiuPgcProteusItem());
      a(62, new BiuPgcProteusItem());
      a(63, new BiuPgcProteusItem());
      a(33, new BiuPgcProteusItem());
      a(31, new PgcProteusItem());
      a(32, new PgcProteusItem());
      a(79, new PackProteusItem());
      a(76, new PackProteusItem());
      a(77, new PackProteusItem());
      a(78, new PackProteusItem());
      a(83, new PgcProteusItem());
      a(84, new PgcProteusItem());
      a(85, new PgcProteusItem());
      a(86, new PgcProteusItem());
      a(89, new AccountCardItem());
      a(92, new BiuUgcProteusItem());
      a(94, new BiuPgcProteusItem());
      a(95, new BiuPgcProteusItem());
      a(101, new GalleryProteusItem());
      a(102, new GalleryProteusItem());
      a(103, new GalleryProteusItem());
      a(105, new AdTripleProteusItem());
      a(66, new AdBigVideoProteusItem());
      a(115, new AdBigVideoProteusItem());
      a(39, new AdBigImageProteusItem());
      a(116, new AdPKImageProteusItem());
      a(106, new AdSmallImageProteusItem());
      a(140, new AdQQMiniGameListProteusItem());
      a(146, new AdQQMiniGameHorizListProteusItem());
      a(141, new AdQQMiniGameVideoProteusItem());
      a(143, new AdQQMiniGameVideoProteusItem());
      a(144, new AdQQMiniGameTripleImgProteusItem());
      a(145, new AdQQMiniGameNewStyleProteusItem());
      a(109, new PgcShortContentProteusItem());
      a(110, new PgcShortContentProteusItem());
      a(111, new PgcShortContentProteusItem());
      a(132, new PgcShortContentProteusItem());
      a(133, new PgcShortContentProteusItem());
      a(134, new PgcShortContentProteusItem());
      a(112, new BiuPgcProteusItem());
      a(113, new BiuPgcProteusItem());
      a(114, new BiuPgcProteusItem());
      a(126, new BigImageVideoProteusItem());
      a(2, new BigImageProteusItem());
      a(1, new SmallImageProteusItem());
      a(121, new DoubleShortVideoProteusItem());
      a(124, new MultiVideoColumnProteusItem());
      a(125, new MultiVideoColumnProteusItem());
      a(127, new AdBrandOptimizationProteusItem());
      a(129, new LiveSingleVideoProteusItem());
      a(130, new LiveDoubleVideoProteusItem());
      a(131, new NewPolymericMultiVideoProteusItem());
      a(46, new DoubleVideoProteusItem());
      a(123, new NoteCardProteusItem());
      a(135, new KandianTenProteusItem());
      a(137, new CommentBiuProteusItem());
      a(139, new CommentBiuProteusItem());
      a(138, new CommentBiuProteusItem());
      a(142, new ColumnTwoVideoProteusItem());
      a(147, new WechatSimpleVideoProteusItem());
    }
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(5));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(47));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(60));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(39));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(66));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(50));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(51));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(52));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(53));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(96));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(103));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(102));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(101));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(104));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(105));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(106));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(116));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(121));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(126));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(115));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(124));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(125));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(127));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(140));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(141));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(129));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(130));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(136));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(46));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(142));
    jdField_a_of_type_Int = 0;
  }
  
  private static double a(TemplateBean paramTemplateBean)
  {
    TraceUtils.traceBegin("getProteusSeparatorMarginLeftPx");
    if ((jdField_a_of_type_Double > 0.0D) && (paramTemplateBean != null))
    {
      TemplateFactory localTemplateFactory = TemplateFactory.a("default_feeds", false);
      if ((localTemplateFactory != null) && (!localTemplateFactory.a(paramTemplateBean)))
      {
        TraceUtils.traceEnd();
        return jdField_a_of_type_Double;
      }
    }
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {}
    try
    {
      paramTemplateBean = paramTemplateBean.getViewBean().findViewById("id_separator");
      if (paramTemplateBean != null) {
        jdField_a_of_type_Double = Float.valueOf((String)paramTemplateBean.valueBean.normalValue.get("margin_left")).floatValue();
      }
    }
    catch (Exception paramTemplateBean)
    {
      for (;;)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorMarginLeft exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TemplateFactory", 2, new Object[] { "sProteusSeparatorMarginLeft = ", Double.valueOf(jdField_a_of_type_Double) });
    }
    TraceUtils.traceEnd();
    return jdField_a_of_type_Double;
  }
  
  private static int a(TemplateBean paramTemplateBean)
  {
    TraceUtils.traceBegin("getProteusSeparatorHeightPx");
    if ((jdField_a_of_type_Int > 0) && (paramTemplateBean != null))
    {
      localTemplateFactory = TemplateFactory.a("default_feeds", false);
      if ((localTemplateFactory != null) && (!localTemplateFactory.a(paramTemplateBean)))
      {
        TraceUtils.traceEnd();
        FluencyLogUtil.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] SeparatorHeight : " + jdField_a_of_type_Int);
        return jdField_a_of_type_Int;
      }
    }
    TemplateFactory localTemplateFactory = TemplateFactory.a("default_feeds", false);
    paramTemplateBean = null;
    if (localTemplateFactory != null) {
      paramTemplateBean = localTemplateFactory.getTemplate("ReadInjoy_triple_img_cell");
    }
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {}
    for (;;)
    {
      try
      {
        paramTemplateBean = paramTemplateBean.getViewBean().findViewById("id_separator");
        if (paramTemplateBean == null) {
          continue;
        }
        paramTemplateBean = (SizeValue)paramTemplateBean.valueBean.normalValue.get("height");
        if (paramTemplateBean != null) {
          jdField_a_of_type_Int = paramTemplateBean.getLayoutSize();
        }
        FluencyLogUtil.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] getSeparatorHeightPx");
      }
      catch (Exception paramTemplateBean)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorHeight exception.");
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TemplateFactory", 2, new Object[] { "sProteusSeparatorHeight = ", Integer.valueOf(jdField_a_of_type_Int) });
      }
      TraceUtils.traceEnd();
      return jdField_a_of_type_Int;
      jdField_a_of_type_Int = Utils.dp2px(0.5D);
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (LogUtils.a()) {
      LogUtils.a("ProteusSupportUtil", "[getView] " + paramBaseArticleInfo + " adapterViewType: " + paramInt);
    }
    long l1 = System.currentTimeMillis();
    TraceUtils.traceBegin("ProteusSupportUtil.getView");
    TraceUtils.traceBegin("ProteusSupportUtil#getView#getTemplateBean");
    TemplateBean localTemplateBean = a(paramVafContext, paramInt, paramBaseArticleInfo);
    TraceUtils.traceEnd();
    String str;
    if (localTemplateBean != null)
    {
      str = "[" + localTemplateBean.getStyleName() + "]";
      paramBaseArticleInfo = null;
      if ((!(paramVafContext.getTemplateFactory() instanceof TemplateFactory)) || (localTemplateBean == null)) {
        break label458;
      }
    }
    label256:
    label441:
    label448:
    label458:
    for (Object localObject = ProteusPreloadManager.a.a(((TemplateFactory)paramVafContext.getTemplateFactory()).b(), localTemplateBean.getStyleName());; localObject = null)
    {
      if (localObject == null)
      {
        TraceUtils.traceBegin(str + "#inflate");
        localObject = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
        FluencyLogUtil.a("ProteusSupportUtil", "[getView] inflate");
        TraceUtils.traceEnd();
      }
      for (;;)
      {
        label240:
        long l2;
        if (localObject != null)
        {
          TraceUtils.traceBegin(str + "#setBackgroundDrawable");
          if ((RIJAladdinUtils.g()) && (ReadInJoyHelper.o()))
          {
            paramInt = 1;
            paramBaseArticleInfo = paramVafContext.getContext().getResources();
            if (paramInt == 0) {
              break label441;
            }
            paramInt = 2130841883;
            ((Container)localObject).setBackgroundDrawable(paramBaseArticleInfo.getDrawable(paramInt));
            paramBaseArticleInfo = new ProteusItemView(paramVafContext.getContext());
            paramBaseArticleInfo.a((Container)localObject);
            TraceUtils.traceEnd();
            FluencyLogUtil.a("ProteusSupportUtil", "[getView]  add Container ");
          }
        }
        else
        {
          if ((QLog.isColorLevel()) && (localObject != null)) {
            LogUtils.a((View)localObject, "ProteusSupportUtil");
          }
          l2 = System.currentTimeMillis();
          if (localTemplateBean == null) {
            break label448;
          }
        }
        for (paramVafContext = localTemplateBean.getStyleName();; paramVafContext = "templateBean is null")
        {
          ReadInJoyPTSCostHelper.a("ProteusSupportUtil", paramVafContext, "ProteusSupportUtil.getView", l2 - l1);
          TraceUtils.traceEnd();
          return paramBaseArticleInfo;
          FluencyLogUtil.a("ProteusSupportUtil", "[getView]  new proteusItemView ");
          localObject = new ProteusItemView(paramVafContext.getContext());
          ((ProteusItemView)localObject).setVisibility(8);
          QLog.i("ProteusSupportUtil", 1, "[getView] 未找到样式,请确认是否下发该卡片的样式:" + paramBaseArticleInfo + " adapterViewType: " + paramInt + "  " + paramVafContext.getTemplateFactory());
          paramBaseArticleInfo = (BaseArticleInfo)localObject;
          str = "";
          break;
          paramInt = 0;
          break label240;
          paramInt = 2130841884;
          break label256;
        }
      }
    }
  }
  
  /* Error */
  public static TemplateBean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +18 -> 19
    //   4: ldc 177
    //   6: iconst_0
    //   7: invokestatic 182	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	(Ljava/lang/String;Z)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +506 -> 520
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: invokevirtual 347	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getTemplateFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;
    //   23: checkcast 179	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory
    //   26: astore 4
    //   28: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +39 -> 70
    //   34: ldc 251
    //   36: iconst_2
    //   37: new 261	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 447
    //   47: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: ldc_w 449
    //   57: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_1
    //   61: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_2
    //   71: getfield 455	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   74: ifnull +20 -> 94
    //   77: aload 4
    //   79: aload_2
    //   80: getfield 455	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   83: invokevirtual 185	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Z
    //   86: ifne +8 -> 94
    //   89: aload_2
    //   90: getfield 455	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   93: areturn
    //   94: getstatic 20	com/tencent/biz/pubaccount/readinjoy/common/ProteusSupportUtil:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   97: iload_1
    //   98: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: invokeinterface 217 2 0
    //   106: checkcast 457	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItem
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +152 -> 263
    //   114: aload_3
    //   115: iload_1
    //   116: aload_2
    //   117: invokeinterface 460 3 0
    //   122: astore_0
    //   123: aload_3
    //   124: ifnull +391 -> 515
    //   127: aload_3
    //   128: iload_1
    //   129: aload_0
    //   130: invokeinterface 463 3 0
    //   135: astore_3
    //   136: aload_3
    //   137: ifnonnull +375 -> 512
    //   140: aload 4
    //   142: ifnull +310 -> 452
    //   145: aload 4
    //   147: aload_0
    //   148: invokevirtual 467	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   151: astore 4
    //   153: aload 4
    //   155: astore_3
    //   156: aload_2
    //   157: aload_3
    //   158: putfield 455	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   161: new 261	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 469
    //   171: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: astore 4
    //   176: aload_0
    //   177: ifnull +280 -> 457
    //   180: new 261	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   187: aload_0
    //   188: ldc_w 471
    //   191: invokevirtual 477	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 479
    //   200: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: invokevirtual 480	org/json/JSONObject:toString	()Ljava/lang/String;
    //   207: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 482
    //   213: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore_2
    //   220: ldc 251
    //   222: iconst_2
    //   223: aload 4
    //   225: aload_2
    //   226: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: ldc 251
    //   237: iconst_1
    //   238: new 261	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 484
    //   248: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_3
    //   262: areturn
    //   263: iload_1
    //   264: lookupswitch	default:+100->364, 1:+116->380, 5:+108->372, 29:+132->396, 34:+156->420, 40:+172->436, 41:+180->444, 42:+164->428, 47:+140->404, 60:+148->412, 96:+148->412, 104:+124->388
    //   365: invokestatic 489	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoyNoneImgCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   368: astore_0
    //   369: goto -246 -> 123
    //   372: aload_2
    //   373: invokestatic 492	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInJoySmallVideoCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   376: astore_0
    //   377: goto -254 -> 123
    //   380: aload_2
    //   381: invokestatic 495	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInJoySmallImgCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   384: astore_0
    //   385: goto -262 -> 123
    //   388: aload_2
    //   389: invokestatic 498	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInJoyAdSmallImgCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   392: astore_0
    //   393: goto -270 -> 123
    //   396: aload_2
    //   397: invokestatic 501	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInJoySingleTopicCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   400: astore_0
    //   401: goto -278 -> 123
    //   404: aload_2
    //   405: invokestatic 504	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInJoyGalleryBigCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   408: astore_0
    //   409: goto -286 -> 123
    //   412: aload_2
    //   413: invokestatic 507	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoyGalleryTripleCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   416: astore_0
    //   417: goto -294 -> 123
    //   420: aload_2
    //   421: invokestatic 510	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoyPgcMultiCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   424: astore_0
    //   425: goto -302 -> 123
    //   428: aload_2
    //   429: invokestatic 513	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoyTopicRecommendPgcMultiCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   432: astore_0
    //   433: goto -310 -> 123
    //   436: aload_2
    //   437: invokestatic 516	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoyTopicRecommendPgcBigCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   440: astore_0
    //   441: goto -318 -> 123
    //   444: aload_2
    //   445: invokestatic 519	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoyTopicRecommendPgcSmallCell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   448: astore_0
    //   449: goto -326 -> 123
    //   452: aconst_null
    //   453: astore_3
    //   454: goto -298 -> 156
    //   457: ldc_w 440
    //   460: astore_2
    //   461: goto -241 -> 220
    //   464: astore_0
    //   465: aconst_null
    //   466: astore_3
    //   467: ldc 251
    //   469: iconst_1
    //   470: ldc_w 521
    //   473: aload_0
    //   474: invokestatic 525	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   477: goto -216 -> 261
    //   480: astore_0
    //   481: aconst_null
    //   482: astore_3
    //   483: ldc 251
    //   485: iconst_1
    //   486: ldc_w 527
    //   489: aload_0
    //   490: invokestatic 525	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   493: goto -232 -> 261
    //   496: astore_0
    //   497: goto -14 -> 483
    //   500: astore_0
    //   501: goto -18 -> 483
    //   504: astore_0
    //   505: goto -38 -> 467
    //   508: astore_0
    //   509: goto -42 -> 467
    //   512: goto -356 -> 156
    //   515: aconst_null
    //   516: astore_3
    //   517: goto -381 -> 136
    //   520: goto -492 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramVafContext	VafContext
    //   0	523	1	paramInt	int
    //   0	523	2	paramBaseArticleInfo	BaseArticleInfo
    //   109	408	3	localObject1	Object
    //   10	214	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   70	94	464	org/json/JSONException
    //   94	110	464	org/json/JSONException
    //   114	123	464	org/json/JSONException
    //   127	136	464	org/json/JSONException
    //   364	369	464	org/json/JSONException
    //   372	377	464	org/json/JSONException
    //   380	385	464	org/json/JSONException
    //   388	393	464	org/json/JSONException
    //   396	401	464	org/json/JSONException
    //   404	409	464	org/json/JSONException
    //   412	417	464	org/json/JSONException
    //   420	425	464	org/json/JSONException
    //   428	433	464	org/json/JSONException
    //   436	441	464	org/json/JSONException
    //   444	449	464	org/json/JSONException
    //   70	94	480	java/lang/Exception
    //   94	110	480	java/lang/Exception
    //   114	123	480	java/lang/Exception
    //   127	136	480	java/lang/Exception
    //   364	369	480	java/lang/Exception
    //   372	377	480	java/lang/Exception
    //   380	385	480	java/lang/Exception
    //   388	393	480	java/lang/Exception
    //   396	401	480	java/lang/Exception
    //   404	409	480	java/lang/Exception
    //   412	417	480	java/lang/Exception
    //   420	425	480	java/lang/Exception
    //   428	433	480	java/lang/Exception
    //   436	441	480	java/lang/Exception
    //   444	449	480	java/lang/Exception
    //   145	153	496	java/lang/Exception
    //   156	176	500	java/lang/Exception
    //   180	220	500	java/lang/Exception
    //   220	261	500	java/lang/Exception
    //   145	153	504	org/json/JSONException
    //   156	176	508	org/json/JSONException
    //   180	220	508	org/json/JSONException
    //   220	261	508	org/json/JSONException
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = null;
    if (!UGRuleManager.c(paramBaseArticleInfo))
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema is not ugCard");
      return null;
    }
    int i = ReadInJoySrtHandler.jdField_a_of_type_Int;
    ReadInJoySrtHandler localReadInJoySrtHandler = ReadInJoySrtHandler.a();
    boolean bool = localReadInJoySrtHandler.a(paramBaseArticleInfo, true, i);
    if (bool)
    {
      str = localReadInJoySrtHandler.a(paramBaseArticleInfo, i, null, null);
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema ugUrl is " + str);
    }
    localReadInJoySrtHandler.a(paramBaseArticleInfo, bool, true, i);
    return str;
  }
  
  private static void a()
  {
    FluencyLogUtil.a("ProteusSupportUtil", "resetProteusSeparatorHeightPx ");
    QLog.d("TemplateFactory", 4, "resetProteusSeparatorHeightPx");
    jdField_a_of_type_Int = 0;
  }
  
  private static void a(int paramInt, ProteusItem paramProteusItem)
  {
    if (paramProteusItem == null) {
      throw new NullPointerException();
    }
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramProteusItem);
  }
  
  public static void a(int paramInt, ProteusItemView paramProteusItemView, VafContext paramVafContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel, BaseArticleInfo paramBaseArticleInfo)
  {
    Container localContainer = paramProteusItemView.a();
    ViewFactory.findClickableViewListener(localContainer.getVirtualView(), new ProteusSupportUtil.2(paramInt, localContainer, paramIReadInJoyModel, paramBaseArticleInfo, paramVafContext, paramProteusItemView, paramIFaceDecoder, paramReadInJoyBaseAdapter));
  }
  
  private static void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    TraceUtils.traceBegin("ProteusSupportUtil.bindView");
    if (paramContainer == null)
    {
      TraceUtils.traceEnd();
      return;
    }
    FluencyLogUtil.a("ProteusSupportUtil", "[bindView]");
    Object localObject = (ProteusItem)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      ((ProteusItem)localObject).a(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2);
      TraceUtils.traceEnd();
    }
    for (;;)
    {
      TraceUtils.traceEnd();
      return;
      paramContainer = paramContainer.getVirtualView();
      switch (paramInt1)
      {
      default: 
        break;
      case 10: 
        localObject = (AvatarView)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((AvatarView)localObject).a(paramIReadInJoyModel);
        }
        localObject = (SummaryView)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((SummaryView)localObject).a(paramIReadInJoyModel);
        }
        localObject = (BiuCommentView)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((BiuCommentView)localObject).a(paramIReadInJoyModel);
        }
        paramContainer = (CornerTextImageView)paramContainer.findViewBaseByName("id_corner_text_image");
        if (paramContainer != null) {
          paramContainer.a(paramIReadInJoyModel);
        }
        break;
      case 34: 
      case 40: 
      case 41: 
      case 42: 
        localObject = (AvatarView)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((AvatarView)localObject).a(paramIReadInJoyModel);
        }
        localObject = (SummaryView)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((SummaryView)localObject).a(paramIReadInJoyModel);
        }
        localObject = (BiuCommentView)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((BiuCommentView)localObject).a(paramIReadInJoyModel);
        }
        paramContainer = (GridImageView)paramContainer.findViewBaseByName("id_multi_image");
        if (paramContainer != null) {
          paramContainer.a(paramIReadInJoyModel.a());
        }
        break;
      }
    }
  }
  
  private static void a(IReadInJoyModel paramIReadInJoyModel, VafContext paramVafContext)
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = paramIReadInJoyModel.a();
    BaseArticleInfo localBaseArticleInfo;
    if (localReadInJoyBaseAdapter != null)
    {
      localBaseArticleInfo = localReadInJoyBaseAdapter.b(paramIReadInJoyModel.g() + 1);
      if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mProteusTemplateBean == null))
      {
        QLog.d("ProteusSupportUtil", 2, "next.mProteusTemplateBean == null " + localBaseArticleInfo);
        if ((localReadInJoyBaseAdapter.a() == null) || (!localReadInJoyBaseAdapter.a().a(paramIReadInJoyModel.b()))) {
          break label97;
        }
        localBaseArticleInfo.mProteusTemplateBean = localReadInJoyBaseAdapter.a().a(localBaseArticleInfo);
      }
    }
    return;
    label97:
    localBaseArticleInfo.mProteusTemplateBean = a(paramVafContext, paramIReadInJoyModel.b(), localBaseArticleInfo);
  }
  
  private static void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    if ((paramIReadInJoyModel != null) && (paramViewBase != null) && (paramViewBase.getNativeView() != null))
    {
      paramIReadInJoyModel = paramIReadInJoyModel.b();
      if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mProteusTemplateBean != null))
      {
        paramIReadInJoyModel = (ViewBean)paramIReadInJoyModel.mProteusTemplateBean.getViewDataBinding().get("id_separator");
        if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.valueBean != null) && (paramIReadInJoyModel.valueBean.normalValue != null))
        {
          paramIReadInJoyModel = paramIReadInJoyModel.valueBean.normalValue.get("setBackgroundColorString:");
          if (!(paramIReadInJoyModel instanceof String)) {}
        }
      }
    }
    try
    {
      paramViewBase.getNativeView().setBackgroundColor(Color.parseColor((String)paramIReadInJoyModel));
      return;
    }
    catch (Exception paramIReadInJoyModel)
    {
      QLog.d("ProteusSupportUtil", 1, paramIReadInJoyModel.getMessage());
    }
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel, int paramInt2, String paramString)
  {
    if (LogUtils.a()) {
      LogUtils.a("ProteusSupportUtil", "[bindData]  adapterViewType: " + paramInt1 + ", data : " + paramBaseArticleInfo);
    }
    TraceUtils.traceBegin("ProteusSupportUtil.bindData");
    long l1 = System.currentTimeMillis();
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      TraceUtils.traceEnd();
      return;
    }
    b(paramVafContext, paramString);
    Object localObject = paramProteusItemView.a();
    TemplateBean localTemplateBean = a(paramVafContext, paramInt1, paramBaseArticleInfo);
    int i;
    int j;
    if ((!a(paramProteusItemView.a(), paramInt1)) && ((localObject == null) || (localTemplateBean == null) || (localTemplateBean.getId() == ((TemplateBean)localObject).getId())))
    {
      paramString = (String)localObject;
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (localTemplateBean != null)
        {
          paramString = (String)localObject;
          if (((TemplateBean)localObject).getStyleName() != null)
          {
            paramString = (String)localObject;
            if (localTemplateBean.getStyleName() != null)
            {
              paramString = (String)localObject;
              if (localTemplateBean.getStyleName().equals(((TemplateBean)localObject).getStyleName())) {}
            }
          }
        }
      }
    }
    else
    {
      if (localTemplateBean == null) {
        break label537;
      }
      i = localTemplateBean.getId();
      if (localObject == null) {
        break label543;
      }
      j = ((TemplateBean)localObject).getId();
      label207:
      QLog.i("ProteusSupportUtil", 1, "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      FluencyLogUtil.a("ProteusSupportUtil", "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      paramString = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      if (paramString != null)
      {
        paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841884));
        paramProteusItemView.c();
        paramProteusItemView.a(paramString);
        LogUtils.a(paramString.getVirtualView(), "ProteusSupportUtil");
        LogUtils.a(paramString, "ProteusSupportUtil");
      }
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
      a();
      paramString = null;
    }
    localObject = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean);
    paramProteusItemView.setModel(paramIReadInJoyModel, paramReadInJoyBaseAdapter.a().a());
    TraceUtils.traceBegin("ProteusSupportUtil.bindDataImpl");
    label452:
    long l2;
    if (localTemplateBean != null)
    {
      QLog.i("ProteusSupportUtil", 1, "[bindData] bind data for " + localTemplateBean.getStyleName());
      a((Container)localObject, paramString, localTemplateBean);
      TraceUtils.traceEnd();
      a(paramInt1, (Container)localObject, paramIReadInJoyModel, paramInt2);
      a(paramInt1, paramProteusItemView, paramVafContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramBaseArticleInfo);
      TraceUtils.traceBegin("ProteusSupportUtil.configDivider");
      a(paramIReadInJoyModel, paramVafContext);
      a((Container)localObject, paramIReadInJoyModel, localTemplateBean);
      TraceUtils.traceEnd();
      l2 = System.currentTimeMillis();
      if (localTemplateBean == null) {
        break label561;
      }
    }
    label537:
    label543:
    label561:
    for (paramProteusItemView = localTemplateBean.getStyleName();; paramProteusItemView = "")
    {
      ReadInJoyPTSCostHelper.a("ProteusSupportUtil", paramProteusItemView, " ProteusSupportUtil.bindData", l2 - l1);
      TraceUtils.traceEnd();
      return;
      i = -1;
      break;
      j = -1;
      break label207;
      QLog.d("ProteusSupportUtil", 2, "[bindData] newTemplateBean is null");
      break label452;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    a(null, RIJItemViewType.a(paramArticleInfo), paramArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramTemplateBean == null)) {
      return;
    }
    String str = ReadinjoyReportUtils.b(paramBaseArticleInfo.mChannelID);
    HashMap localHashMap = new HashMap();
    Map localMap = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    if (paramTemplateBean != null) {
      localHashMap.putAll(paramTemplateBean);
    }
    ProteusReportUtil.a((ArticleInfo)paramBaseArticleInfo, str, str, (int)paramBaseArticleInfo.mChannelID, localHashMap);
    ProteusReportUtil.a(paramTemplateBean);
    ReadInJoyHelper.a(paramBaseArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    if ((paramBaseArticleInfo == null) || (paramViewBase == null) || (paramTemplateBean == null)) {}
    do
    {
      do
      {
        return;
        paramViewBase = paramTemplateBean.getDataAttribute(paramViewBase.getViewId()).get("rowkey");
      } while (!(paramViewBase instanceof String));
      paramViewBase = (String)paramViewBase;
    } while (TextUtils.isEmpty(paramViewBase));
    paramBaseArticleInfo.viewRowkey = paramViewBase;
  }
  
  public static void a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    a(paramTemplateBean, paramViewBase, "click_T");
  }
  
  public static void a(TemplateBean paramTemplateBean, ViewBase paramViewBase, String paramString)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    String str = (String)paramTemplateBean.getDataAttribute(paramViewBase.getName(), paramString);
    if (str == null)
    {
      QLog.d("ProteusSupportUtil", 2, "reportDataAttrInfo bigT is null");
      return;
    }
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getName());
    if (paramTemplateBean != null)
    {
      paramTemplateBean = paramTemplateBean.entrySet().iterator();
      while (paramTemplateBean.hasNext())
      {
        Object localObject = (Map.Entry)paramTemplateBean.next();
        paramViewBase = (String)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        if (!TextUtils.equals(paramViewBase, paramString)) {
          localReportR5Builder.b(paramViewBase, localObject.toString());
        }
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", str, str, 0, 0, "", "", "", localReportR5Builder.a(), false);
  }
  
  protected static void a(ViewBean paramViewBean)
  {
    if (paramViewBean == null) {}
    do
    {
      return;
      paramViewBean = paramViewBean.getDynamicValue("setProteusReportInfo:");
    } while (!(paramViewBean instanceof JSONObject));
    try
    {
      JSONObject localJSONObject = (JSONObject)paramViewBean;
      paramViewBean = localJSONObject.getString("click_T");
      localJSONObject = localJSONObject.getJSONObject("info");
      RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localReportR5Builder.b(str, localJSONObject.get(str).toString());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramViewBean, paramViewBean, 0, 0, "", "", "", localReportR5Builder.a(), false);
    }
    catch (Exception paramViewBean)
    {
      QLog.d("ProteusSupportUtil", 1, paramViewBean, new Object[] { "" });
      return;
    }
  }
  
  public static void a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel, TemplateBean paramTemplateBean)
  {
    if (DividerConfigUtils.a(paramContainer, paramIReadInJoyModel)) {
      return;
    }
    ViewBase localViewBase1 = paramContainer.getVirtualView();
    ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_separator");
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if ((localArticleInfo == null) || (localViewBase2 == null))
    {
      QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
      return;
    }
    Layout.Params localParams = localViewBase2.getComLayoutParams();
    int m = localParams.mLayoutHeight;
    int j = Utils.dp2px(5.0D);
    double d = Utils.dp2px(6.0D);
    int i = paramIReadInJoyModel.a();
    int k = paramIReadInJoyModel.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      TraceUtils.traceBegin("configDivider.FollowFeeds");
      localParams.mLayoutMarginLeft = 0;
      localParams.mLayoutMarginRight = 0;
      localParams.mLayoutWidth = -1;
      i = Utils.dp2px(5.0D);
      TraceUtils.traceEnd();
    }
    for (;;)
    {
      localParams.mLayoutHeight = i;
      localViewBase2.setComLayoutParams(localParams);
      paramIReadInJoyModel = localViewBase1.getComLayoutParams();
      if (paramIReadInJoyModel.mLayoutHeight >= 0) {
        paramIReadInJoyModel.mLayoutHeight = (i - m + paramIReadInJoyModel.mLayoutHeight);
      }
      paramIReadInJoyModel = localViewBase1.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(paramIReadInJoyModel.mLayoutWidth, paramIReadInJoyModel.mLayoutHeight));
      return;
      if (DailyModeConfigHandler.c((int)localArticleInfo.mChannelID))
      {
        TraceUtils.traceBegin("configDivider.DailyFeeds");
        paramIReadInJoyModel = paramIReadInJoyModel.b();
        j = 0;
        k = 0;
        i = k;
        if (paramIReadInJoyModel != null)
        {
          i = k;
          if (paramIReadInJoyModel.mProteusTemplateBean != null)
          {
            if (paramIReadInJoyModel.mProteusTemplateBean.getDataAttribute(null, "position_jump") == null) {
              break label344;
            }
            i = 1;
          }
        }
        label279:
        if (localArticleInfo.mProteusTemplateBean != null)
        {
          if (localArticleInfo.mProteusTemplateBean.getDataAttribute(null, "position_jump") != null) {
            j = 1;
          }
        }
        else
        {
          label305:
          if (j == i) {
            break label356;
          }
          localParams.mLayoutMarginLeft = 0;
          localParams.mLayoutMarginRight = 0;
          localParams.mLayoutWidth = -1;
          i = Utils.dp2px(5.0D);
        }
        for (;;)
        {
          TraceUtils.traceEnd();
          break;
          label344:
          i = 0;
          break label279;
          j = 0;
          break label305;
          label356:
          j = b(paramTemplateBean);
          i = j;
          if (j == a(paramTemplateBean))
          {
            i = a(paramTemplateBean);
            j = Utils.dp2px(a(paramTemplateBean));
            localParams.mLayoutMarginRight = j;
            localParams.mLayoutMarginLeft = j;
            localParams.mLayoutWidth = -1;
          }
        }
      }
      if ((i == 29) || (i == 30) || (k == 29) || (k == 30))
      {
        i = a(paramTemplateBean);
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if ((a(paramIReadInJoyModel.b())) || (a(paramIReadInJoyModel)))
      {
        i = 0;
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if (a(i, k, paramIReadInJoyModel.b()))
      {
        TraceUtils.traceBegin("configDivider.normal");
        TraceUtils.traceBegin("configDivider.normal.getProteusSeparatorHeightPx");
        i = a(paramTemplateBean);
        TraceUtils.traceEnd();
        TraceUtils.traceBegin("configDivider.normal.getProteusSeparatorMarginLeftPx");
        d = a(paramTemplateBean);
        TraceUtils.traceEnd();
        j = Utils.dp2px(d);
        localParams.mLayoutMarginRight = j;
        localParams.mLayoutMarginLeft = j;
        localParams.mLayoutWidth = -1;
        TraceUtils.traceEnd();
      }
      else
      {
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
        i = j;
        if (!b(k))
        {
          a(paramIReadInJoyModel, localViewBase2);
          i = j;
        }
      }
    }
  }
  
  public static void a(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    if (paramTemplateBean2 == null)
    {
      QLog.d("ProteusSupportUtil", 1, new Object[] { "[bindDynamicValueWithoutRecursion", "newTemplateBean == null", "return" });
      return;
    }
    TraceUtils.traceBegin("ProteusSupportUtil.bindDynamicValueWithoutRecursion");
    long l = System.currentTimeMillis();
    Map localMap1 = paramContainer.getViewIdMapping();
    Map localMap2 = paramTemplateBean2.getViewDataBinding();
    HashSet localHashSet = new HashSet();
    if (paramTemplateBean1 != null) {}
    for (paramContainer = paramTemplateBean1.getViewDataBinding();; paramContainer = null)
    {
      if (localMap1 != null) {
        localHashSet.addAll(localMap1.keySet());
      }
      localHashSet.removeAll(localMap2.keySet());
      StringBuilder localStringBuilder = new StringBuilder("bindDynamicValueWithoutRecursion: ");
      Iterator localIterator = localMap2.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ViewBean localViewBean = (ViewBean)localMap2.get(str);
        label187:
        ViewBase localViewBase;
        label206:
        int i;
        if (paramContainer != null)
        {
          paramTemplateBean1 = (ViewBean)paramContainer.get(str);
          if (localMap1 == null) {
            break label339;
          }
          localViewBase = (ViewBase)localMap1.get(str);
          TraceUtils.traceBegin("bindDynamicValueWithoutRecursion.bindDynamicVal.check");
          if ((str == null) || (localViewBase == null) || (localViewBean == null) || ((paramTemplateBean1 != null) && (localViewBean.valueBean.dynamicValue.equals(paramTemplateBean1.valueBean.dynamicValue)))) {
            break label345;
          }
          i = 1;
          label256:
          TraceUtils.traceEnd();
          if (i == 0) {
            break label350;
          }
          localViewBean.setVisible(true);
          localViewBase.bindDynamicValue(localViewBean);
          TraceUtils.traceEnd();
          localStringBuilder.append("[bindNewValue] bind dynamicValue: ").append(localViewBean.valueBean.dynamicValue).append(" viewId = ").append(str).append("\n");
        }
        for (;;)
        {
          if (localViewBase != null) {
            localViewBase.setVisibility(0);
          }
          TraceUtils.traceEnd();
          break;
          paramTemplateBean1 = null;
          break label187;
          label339:
          localViewBase = null;
          break label206;
          label345:
          i = 0;
          break label256;
          label350:
          if ((QLog.isColorLevel()) && (localViewBean != null)) {
            localStringBuilder.append("skip: ").append(localViewBean.valueBean.dynamicValue).append(" viewId = ").append(str).append("\n");
          }
        }
      }
      QLog.i("ProteusSupportUtil", 1, localStringBuilder.toString());
      paramContainer = localHashSet.iterator();
      while (paramContainer.hasNext())
      {
        paramTemplateBean1 = (ViewBase)localMap1.get((String)paramContainer.next());
        if (paramTemplateBean1 != null) {
          paramTemplateBean1.setVisibility(8);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProteusSupportUtil", 2, "bindDynamicValueWithoutRecursion_____ " + paramTemplateBean2.getStyleName() + " cost " + (System.currentTimeMillis() - l) + "ms");
      }
      TraceUtils.traceEnd();
      return;
    }
  }
  
  public static void a(Container paramContainer, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new ProteusSupportUtil.1(paramVafContext, paramTemplateBean));
  }
  
  public static void a(VafContext paramVafContext, String paramString)
  {
    paramVafContext.setTemplateFactory(TemplateFactory.a(paramString, true));
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeButton", new ReadInJoyLikeButton.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAvatarView", new AvatarView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVariableImageContentView", new GridImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySummaryView", new SummaryView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCommentView", new ArticleCommentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuCommentView", new BiuCommentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("CornerTextImageView", new CornerTextImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyMiddleBodyView", new ReadInJoyMiddleBodyView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyUsersCommentView", new UsersCommentsView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyFriendsBiu", new ReadInJoyFriendsBiu.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyQARichView", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuButton", new ReadInJoyBiuButton.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCoordinateView", new ReadInJoyCoordinateView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySocializeRecommendFollowView", new ReadInJoySocializeRecommendFollowView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("UILabel", new ReadInjoyTextView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageView", new ReadInjoyImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("UIImageView", new ReadInjoyImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageIcon", new ReadInjoyAsynImageIcon.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusCollectionView", new RvPolymericContainer.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdVideoGuide", new ReadInJoyAdVideoCompleteGuide.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("PTSAvatarView", new CommentAvatarView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("QQAvatarView", new CommentAvatarView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentRichTextView", new CommentRichTextView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJRichTextView", new CommentContentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentLikeButton", new CommentLikeView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyExposeReplyCommentView", new ExposeReplyCommentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAwesomeCommentView", new ReadInJoyAwesomeCommentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdDownloadView", new RIJAdDownloadViewBase.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdLocationView", new ReadInJoyAdLocationView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyIconText", new ReadInJoyIconText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyDoubleImageView", new ReadInjoyDoubleImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBlurImageView", new ReadInJoyBlurImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBubbleView", new ReadInJoyAdBubbleView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdCommonBlurImageView", new ReadInJoyAdCommonBlurImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdInnerOperateView", new ReadInJoyAdInnerOperateView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusTickerView", new ProteusTickerView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyShareView", new ReadInJoyShareView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyApngImageView", new ReadInjoyApngImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBrandOptimizationView", new ReadInJoyAdBrandOptimizationView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyProgressView", new ReadInjoyProgressView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentLinksView", new PTSCommentLinkView.Builder());
    a();
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyArticleBottomVideoView", new ReadInJoyArticleBottomVideoView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVideoView", new ReadInJoyVideoView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyGifView", new ReadInJoyGifView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusMarqueeLabel", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLinkClickableLabel", new ReadInjoyTextView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLottieView", new ReadInJoyLottieView.Builder());
  }
  
  public static void a(ViewBase paramViewBase, ViewBean paramViewBean)
  {
    if (paramViewBase != null)
    {
      paramViewBase.bindDynamicValue(paramViewBean);
      if ((paramViewBase instanceof Layout))
      {
        paramViewBase = ((Layout)paramViewBase).getSubViews();
        if ((paramViewBase != null) && (paramViewBean.children != null))
        {
          List localList = Arrays.asList(paramViewBean.children);
          int j = paramViewBase.size();
          if (localList.size() == j)
          {
            int i = 0;
            while (i < j)
            {
              a((ViewBase)paramViewBase.get(i), (ViewBean)localList.get(i));
              i += 1;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProteusSupportUtil", 2, "bindDataImpl: fail to bind data for " + paramViewBean.viewId + "due to ViewBean - ViewBase count mismatch");
          }
        }
      }
      FluencyLogUtil.a("ProteusSupportUtil", "[bindDynamicValue]");
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!ProteusSettingUtil.a()) {}
    do
    {
      return false;
      switch (paramInt)
      {
      }
    } while (ProteusSupportAdUtil.a(paramInt));
    return jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
  }
  
  public static boolean a(int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    TraceUtils.traceBegin("configDivider.isDividerNormal");
    if ((b(paramInt1)) && ((b(paramInt2)) || (PTSLiteItemViewUtil.a.a(paramArticleInfo, paramInt2) == 0))) {}
    for (boolean bool = true;; bool = false)
    {
      TraceUtils.traceEnd();
      return bool;
    }
  }
  
  public static boolean a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel != null) {
      try
      {
        int i = paramIReadInJoyModel.b();
        if ((i == 66) || (i == 39))
        {
          paramIReadInJoyModel = paramIReadInJoyModel.b();
          if ((paramIReadInJoyModel != null) && (AdvertisementInfo.isAdvertisementInfo(paramIReadInJoyModel)))
          {
            paramIReadInJoyModel = ((AdvertisementInfo)paramIReadInJoyModel).mAdExtInfo;
            if (paramIReadInJoyModel != null)
            {
              i = new JSONObject(paramIReadInJoyModel).optInt("is_video_new");
              return i == 1;
            }
          }
        }
      }
      catch (Exception paramIReadInJoyModel)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardAdBigImgOrAdVideo JSONException, e = ", paramIReadInJoyModel);
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    // Byte code:
    //   0: ldc_w 1345
    //   3: invokestatic 175	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +154 -> 161
    //   10: aload_0
    //   11: getfield 1348	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   14: invokestatic 800	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +144 -> 161
    //   20: aload_0
    //   21: getfield 1351	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   24: bipush 29
    //   26: if_icmpeq +8 -> 34
    //   29: invokestatic 188	com/tencent/widget/TraceUtils:traceEnd	()V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 473	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 1348	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   42: invokespecial 1334	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 887	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 836 1 0
    //   57: ifeq +104 -> 161
    //   60: aload_2
    //   61: invokeinterface 840 1 0
    //   66: checkcast 219	java/lang/String
    //   69: astore_3
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 1354	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: astore 4
    //   77: ldc_w 1356
    //   80: aload_3
    //   81: invokevirtual 706	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -33 -> 51
    //   87: ldc 251
    //   89: iconst_1
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc_w 1358
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload 4
    //   104: aastore
    //   105: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: invokestatic 188	com/tencent/widget/TraceUtils:traceEnd	()V
    //   111: ldc_w 1360
    //   114: aload 4
    //   116: invokestatic 1363	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 706	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +19 -> 141
    //   125: ldc_w 1365
    //   128: aload 4
    //   130: invokestatic 1363	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 706	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   136: istore_1
    //   137: iload_1
    //   138: ifeq +7 -> 145
    //   141: iconst_1
    //   142: istore_1
    //   143: iload_1
    //   144: ireturn
    //   145: iconst_0
    //   146: istore_1
    //   147: goto -4 -> 143
    //   150: astore_0
    //   151: ldc 251
    //   153: iconst_1
    //   154: ldc_w 1367
    //   157: aload_0
    //   158: invokestatic 1343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: invokestatic 188	com/tencent/widget/TraceUtils:traceEnd	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 251
    //   169: iconst_1
    //   170: ldc_w 1369
    //   173: aload_0
    //   174: invokestatic 1343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: goto -16 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramArticleInfo	ArticleInfo
    //   136	11	1	bool	boolean
    //   50	11	2	localIterator	Iterator
    //   69	12	3	str	String
    //   75	54	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	51	150	org/json/JSONException
    //   51	137	150	org/json/JSONException
    //   34	51	166	java/lang/Exception
    //   51	137	166	java/lang/Exception
  }
  
  private static boolean a(BaseArticleInfo paramBaseArticleInfo, ViewBase paramViewBase, VafContext paramVafContext)
  {
    boolean bool = paramBaseArticleInfo instanceof AdvertisementInfo;
    if ((paramViewBase == null) || (paramVafContext == null) || (paramVafContext.getContext() == null) || (paramBaseArticleInfo == null)) {
      bool = false;
    }
    return bool;
  }
  
  private static boolean a(Container paramContainer, int paramInt)
  {
    if (Aladdin.getConfig(330).getIntegerFromString("isAllowLayoutErrorCheck", 0) != 1) {
      return false;
    }
    if (paramContainer != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = paramContainer.getChildCount();
        i = 0;
        if (i < j)
        {
          View localView = paramContainer.getChildAt(i);
          Object localObject;
          if ((localView instanceof NativeLayoutImpl))
          {
            localObject = (NativeLayoutImpl)localView;
            if ((((NativeLayoutImpl)localObject).getChildCount() == 0) && (((NativeLayoutImpl)localObject).getBackgroundColor() == 0))
            {
              IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
              QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
              if (((NativeLayoutImpl)localObject).getContentDescription() == null) {
                continue;
              }
              localObject = ((NativeLayoutImpl)localObject).getContentDescription().toString();
              localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(localQQAppInterface, "CliOper", "", "", "0X8009AC1", "0X8009AC1", 0, 0, "", "", "", (String)localObject, false);
              if (QLog.isColorLevel())
              {
                LogUtils.a(paramContainer.getVirtualView(), "ProteusSupportUtil");
                LogUtils.a(paramContainer, "ProteusSupportUtil");
              }
              QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] empty native layout " + paramInt);
            }
          }
          if ((QLog.isColorLevel()) && ((localView instanceof ViewGroup)))
          {
            localObject = (ViewGroup)localView;
            QLog.e("ProteusSupportUtil", 1, "ChildCount " + ((ViewGroup)localObject).getChildCount());
            break label269;
            localObject = "";
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramContainer)
      {
        QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] ", paramContainer);
      }
      label269:
      i += 1;
    }
  }
  
  public static boolean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramVafContext, paramInt, paramBaseArticleInfo) != null;
  }
  
  public static boolean a(VafContext paramVafContext, String paramString)
  {
    paramString = TemplateFactory.a(paramString, true);
    if (paramVafContext.getTemplateFactory() == null)
    {
      paramVafContext.setTemplateFactory(paramString);
      return true;
    }
    if ((paramString != null) && (paramString.getTemplateId() != paramVafContext.getTemplateFactory().getTemplateId()))
    {
      paramVafContext.setTemplateFactory(paramString);
      return true;
    }
    return false;
  }
  
  private static int b(TemplateBean paramTemplateBean)
  {
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {
      try
      {
        paramTemplateBean = (SizeValue)paramTemplateBean.getViewBean().findViewById("id_separator").valueBean.normalValue.get("height");
        FluencyLogUtil.a("ProteusSupportUtil", "[getSepatatorHeight] getSepatatorHeight");
        int i = paramTemplateBean.getLayoutSize();
        return i;
      }
      catch (Exception paramTemplateBean)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorHeight exception.");
      }
    }
    return 0;
  }
  
  private static void b(VafContext paramVafContext, String paramString)
  {
    paramString = TemplateFactory.a(paramString, false);
    if ((paramString != null) && (paramVafContext.getTemplateFactory() != paramString)) {
      paramVafContext.setTemplateFactory(paramString);
    }
  }
  
  public static boolean b(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt))) {}
    while (paramInt >= 148) {
      return true;
    }
    return false;
  }
  
  @Deprecated
  private static boolean b(BaseArticleInfo paramBaseArticleInfo, int paramInt, ViewBase paramViewBase, VafContext paramVafContext)
  {
    if (paramBaseArticleInfo != null) {}
    switch (paramInt)
    {
    default: 
      return true;
    case 1071: 
      return AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo);
    case 1007: 
      if ((RIJFeedsType.c((ArticleInfo)paramBaseArticleInfo)) || (RIJFeedsType.d((ArticleInfo)paramBaseArticleInfo))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    case 1036: 
    case 1174: 
    case 1175: 
      return false;
    case 1045: 
      return ReadinJoyActionUtil.a((ArticleInfo)paramBaseArticleInfo);
    }
    return a(paramBaseArticleInfo, paramViewBase, paramVafContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil
 * JD-Core Version:    0.7.0.1
 */