package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ArticleCommentView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.AvatarView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.BiuCommentView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.CornerTextImageView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.GridImageView.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLikeButton.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.SummaryView.Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lkh;

public class ProteusSupportUtil
{
  public static double a;
  
  public static double a(TemplateBean paramTemplateBean)
  {
    if ((a > 0.0D) && (paramTemplateBean != null) && (!paramTemplateBean.a())) {
      return a;
    }
    if ((paramTemplateBean != null) && (paramTemplateBean.a() != null)) {}
    try
    {
      a = Double.valueOf((String)paramTemplateBean.a().a("id_separator").jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean.b.get("height")).doubleValue();
      if (QLog.isColorLevel()) {
        QLog.d("ProteusSupportUtil", 2, new Object[] { "sProteusSeparatorHeight = ", Double.valueOf(a) });
      }
      return a;
    }
    catch (Exception paramTemplateBean)
    {
      for (;;)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorHeight exception.");
      }
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    TemplateBean localTemplateBean = a(paramInt, paramBaseArticleInfo);
    Container localContainer = paramVafContext.a().a(paramVafContext, localTemplateBean);
    paramBaseArticleInfo = localObject;
    if (localContainer != null)
    {
      localContainer.setBackgroundDrawable(paramVafContext.a().getResources().getDrawable(2130839723));
      paramBaseArticleInfo = new ProteusItemView(paramVafContext.a());
      localContainer.setTag(localTemplateBean);
      paramBaseArticleInfo.a(localContainer);
    }
    return paramBaseArticleInfo;
  }
  
  /* Error */
  public static TemplateBean a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 140	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   4: ifnull +184 -> 188
    //   7: aload_1
    //   8: getfield 140	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   11: invokevirtual 21	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:a	()Z
    //   14: ifne +174 -> 188
    //   17: aload_1
    //   18: getfield 140	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   21: areturn
    //   22: aload_1
    //   23: invokestatic 145	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_none_img_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   26: astore_2
    //   27: aload_2
    //   28: invokestatic 150	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:a	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   31: astore_2
    //   32: aload_1
    //   33: invokestatic 156	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   36: ifne +150 -> 186
    //   39: aload_1
    //   40: aload_2
    //   41: putfield 140	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   44: aload_2
    //   45: areturn
    //   46: astore_1
    //   47: ldc 67
    //   49: iconst_2
    //   50: ldc 158
    //   52: aload_1
    //   53: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   56: aload_2
    //   57: areturn
    //   58: aload_1
    //   59: invokestatic 165	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_large_video_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   62: astore_2
    //   63: goto -36 -> 27
    //   66: aload_1
    //   67: invokestatic 168	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_small_video_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   70: astore_2
    //   71: goto -44 -> 27
    //   74: aload_1
    //   75: invokestatic 171	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_large_img_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   78: astore_2
    //   79: goto -52 -> 27
    //   82: aload_1
    //   83: invokestatic 174	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_small_img_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   86: astore_2
    //   87: goto -60 -> 27
    //   90: aload_1
    //   91: invokestatic 177	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_triple_img_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   94: astore_2
    //   95: goto -68 -> 27
    //   98: aload_1
    //   99: invokestatic 180	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_single_topic_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   102: astore_2
    //   103: goto -76 -> 27
    //   106: aload_1
    //   107: invokestatic 183	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInJoy_gallery_big_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   110: astore_2
    //   111: goto -84 -> 27
    //   114: aload_1
    //   115: invokestatic 186	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_gallery_triple_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   118: astore_2
    //   119: goto -92 -> 27
    //   122: aload_1
    //   123: invokestatic 189	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_social_small_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   126: astore_2
    //   127: goto -100 -> 27
    //   130: aload_1
    //   131: invokestatic 192	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_pgc_multi_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   134: astore_2
    //   135: goto -108 -> 27
    //   138: aload_1
    //   139: invokestatic 195	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_topic_recommend_pgc_multi_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   142: astore_2
    //   143: goto -116 -> 27
    //   146: aload_1
    //   147: invokestatic 198	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_topic_recommend_pgc_big_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   150: astore_2
    //   151: goto -124 -> 27
    //   154: aload_1
    //   155: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/proteus/data/ReadInjoy_topic_recommend_pgc_small_cell:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   158: astore_2
    //   159: goto -132 -> 27
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_2
    //   165: ldc 67
    //   167: iconst_2
    //   168: ldc 203
    //   170: aload_1
    //   171: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_2
    //   175: areturn
    //   176: astore_1
    //   177: goto -12 -> 165
    //   180: astore_1
    //   181: aconst_null
    //   182: astore_2
    //   183: goto -136 -> 47
    //   186: aload_2
    //   187: areturn
    //   188: iload_0
    //   189: lookupswitch	default:+131->320, 1:+-107->82, 2:+-115->74, 3:+-99->90, 5:+-123->66, 6:+-131->58, 10:+-67->122, 29:+-91->98, 34:+-59->130, 39:+-115->74, 40:+-43->146, 41:+-35->154, 42:+-51->138, 47:+-83->106, 60:+-75->114, 66:+-131->58
    //   321: impdep1
    //   322: <illegal opcode>
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramInt	int
    //   0	323	1	paramBaseArticleInfo	BaseArticleInfo
    //   26	161	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	44	46	org/json/JSONException
    //   0	22	162	java/lang/Exception
    //   22	27	162	java/lang/Exception
    //   27	32	162	java/lang/Exception
    //   58	63	162	java/lang/Exception
    //   66	71	162	java/lang/Exception
    //   74	79	162	java/lang/Exception
    //   82	87	162	java/lang/Exception
    //   90	95	162	java/lang/Exception
    //   98	103	162	java/lang/Exception
    //   106	111	162	java/lang/Exception
    //   114	119	162	java/lang/Exception
    //   122	127	162	java/lang/Exception
    //   130	135	162	java/lang/Exception
    //   138	143	162	java/lang/Exception
    //   146	151	162	java/lang/Exception
    //   154	159	162	java/lang/Exception
    //   32	44	176	java/lang/Exception
    //   0	22	180	org/json/JSONException
    //   22	27	180	org/json/JSONException
    //   27	32	180	org/json/JSONException
    //   58	63	180	org/json/JSONException
    //   66	71	180	org/json/JSONException
    //   74	79	180	org/json/JSONException
    //   82	87	180	org/json/JSONException
    //   90	95	180	org/json/JSONException
    //   98	103	180	org/json/JSONException
    //   106	111	180	org/json/JSONException
    //   114	119	180	org/json/JSONException
    //   122	127	180	org/json/JSONException
    //   130	135	180	org/json/JSONException
    //   138	143	180	org/json/JSONException
    //   146	151	180	org/json/JSONException
    //   154	159	180	org/json/JSONException
  }
  
  private static void a(int paramInt, TemplateBean paramTemplateBean, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramTemplateBean == null) || (paramTemplateBean.a() == null)) {}
    ViewBean localViewBean;
    label316:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              switch (paramInt)
              {
              default: 
                return;
              case 6: 
                if (!NetworkState.isWifiConn()) {
                  break label316;
                }
                paramIReadInJoyModel = paramTemplateBean.a("id_large_video_icon");
                if (paramIReadInJoyModel != null) {
                  paramIReadInJoyModel.a("visibility", "VISIBLE");
                }
                paramTemplateBean = paramTemplateBean.a("id_video_bg");
              }
            } while (paramTemplateBean == null);
            paramTemplateBean.a("visibility", "GONE");
            return;
            localViewBean = paramTemplateBean.a("id_info_avator");
            if (localViewBean != null) {
              localViewBean.a("setArticleModel:", paramIReadInJoyModel);
            }
            localViewBean = paramTemplateBean.a("id_summary");
            if (localViewBean != null) {
              localViewBean.a("setArticleModel:", paramIReadInJoyModel);
            }
            localViewBean = paramTemplateBean.a("id_biu_comment");
            if (localViewBean != null) {
              localViewBean.a("setArticleModel:", paramIReadInJoyModel);
            }
            paramTemplateBean = paramTemplateBean.a("id_corner_text_image");
          } while (paramTemplateBean == null);
          paramTemplateBean.a("setArticleModel:", paramIReadInJoyModel);
          return;
          localViewBean = paramTemplateBean.a("id_info_avator");
          if (localViewBean != null) {
            localViewBean.a("setArticleModel:", paramIReadInJoyModel);
          }
          localViewBean = paramTemplateBean.a("id_summary");
          if (localViewBean != null) {
            localViewBean.a("setArticleModel:", paramIReadInJoyModel);
          }
          localViewBean = paramTemplateBean.a("id_biu_comment");
          if (localViewBean != null) {
            localViewBean.a("setArticleModel:", paramIReadInJoyModel);
          }
          paramTemplateBean = paramTemplateBean.a("id_multi_image");
        } while (paramTemplateBean == null);
        paramTemplateBean.a("setArticleModel:", paramIReadInJoyModel.a());
        return;
        paramIReadInJoyModel = paramTemplateBean.a("id_large_video_icon");
        if (paramIReadInJoyModel != null) {
          paramIReadInJoyModel.a("visibility", "VISIBLE");
        }
        paramTemplateBean = paramTemplateBean.a("id_video_bg");
      } while (paramTemplateBean == null);
      paramTemplateBean.a("visibility", "GONE");
      return;
      localViewBean = paramTemplateBean.a("id_large_video_icon");
      if (localViewBean != null) {
        localViewBean.a("visibility", "GONE");
      }
      localViewBean = paramTemplateBean.a("id_video_bg");
      if (localViewBean != null) {
        localViewBean.a("visibility", "VISIBLE");
      }
      localViewBean = paramTemplateBean.a("id_video_paly_text");
    } while (localViewBean == null);
    paramTemplateBean = "流量播放";
    if (CUKingCardHelper.a() == 1) {
      paramTemplateBean = "免流量播放";
    }
    for (;;)
    {
      localViewBean.a("setText:", paramTemplateBean);
      return;
      if (paramIReadInJoyModel.a().mXGFileSize > 0L) {
        paramTemplateBean = VideoFeedsHelper.b(paramIReadInJoyModel.a().mXGFileSize) + "流量";
      }
    }
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, FaceDecoder paramFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null) || (paramProteusItemView.a().getTag() == null)) {
      return;
    }
    Object localObject = (TemplateBean)paramProteusItemView.a().getTag();
    TemplateBean localTemplateBean = a(paramInt, paramBaseArticleInfo);
    if ((localObject != null) && (localTemplateBean.a() != ((TemplateBean)localObject).a()))
    {
      localObject = paramVafContext.a().a(paramVafContext, localTemplateBean);
      if (localObject != null)
      {
        ((Container)localObject).setBackgroundDrawable(paramVafContext.a().getResources().getDrawable(2130839723));
        paramProteusItemView.a();
        paramProteusItemView.a((Container)localObject);
      }
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
    }
    localObject = paramProteusItemView.a();
    ((Container)localObject).setTag(localTemplateBean);
    paramProteusItemView.setModel(paramIReadInJoyModel, paramReadInJoyBaseAdapter.a());
    a(paramInt, localTemplateBean, paramIReadInJoyModel);
    if (localTemplateBean != null) {
      a(((Container)localObject).a(), localTemplateBean.a());
    }
    a((Container)localObject, paramVafContext, paramFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramBaseArticleInfo);
    a((Container)localObject, paramIReadInJoyModel, localTemplateBean);
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    a(ReadInJoyBaseAdapter.c(paramArticleInfo), paramArticleInfo);
  }
  
  private static void a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel, TemplateBean paramTemplateBean)
  {
    ViewBase localViewBase1 = paramContainer.a();
    ViewBase localViewBase2 = localViewBase1.a("id_separator");
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if ((localArticleInfo == null) || (localViewBase2 == null))
    {
      QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
      return;
    }
    Layout.Params localParams = localViewBase2.b();
    int j = localParams.b;
    int i = Utils.b(5.0D);
    int k = paramIReadInJoyModel.a();
    int m = paramIReadInJoyModel.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      localParams.c = 0;
      localParams.d = 0;
      localParams.a = -1;
      i = Utils.b(10.0D);
    }
    for (;;)
    {
      localParams.b = i;
      localViewBase2.a(localParams);
      paramIReadInJoyModel = localViewBase1.b();
      if (paramIReadInJoyModel.b >= 0) {
        paramIReadInJoyModel.b = (i - j + paramIReadInJoyModel.b);
      }
      paramIReadInJoyModel = localViewBase1.b();
      paramContainer.setLayoutParams(new LinearLayout.LayoutParams(paramIReadInJoyModel.a, paramIReadInJoyModel.b));
      return;
      if ((k == 29) || (k == 30) || (m == 29) || (m == 30))
      {
        localParams.c = 0;
        localParams.d = 0;
        localParams.a = -1;
      }
      else if (a(k, m))
      {
        if (a(m))
        {
          double d2 = a(paramTemplateBean);
          if (d2 > 0.0D) {}
          for (double d1 = d2;; d1 = 5.0D)
          {
            i = Utils.b(d1);
            if ((d2 <= 0.0D) || (d2 >= 1.0D)) {
              break label321;
            }
            localParams.c = Utils.b(12.0D);
            localParams.d = Utils.b(12.0D);
            break;
          }
          label321:
          localParams.c = 0;
          localParams.d = 0;
          localParams.a = -1;
        }
        else
        {
          localParams.c = 0;
          localParams.d = 0;
          localParams.a = -1;
        }
      }
      else
      {
        localParams.c = 0;
        localParams.d = 0;
        localParams.a = -1;
      }
    }
  }
  
  private static void a(Container paramContainer, VafContext paramVafContext, FaceDecoder paramFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel, BaseArticleInfo paramBaseArticleInfo)
  {
    ViewFactory.a(paramContainer.a(), new lkh(paramVafContext, paramFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramContainer, paramBaseArticleInfo));
  }
  
  public static void a(VafContext paramVafContext)
  {
    OfflineUtils.b();
    paramVafContext.a().a("ReadInJoyLikeButton", new ReadInJoyLikeButton.Builder());
    paramVafContext.a().a("QQAvatarView", new AvatarView.Builder());
    paramVafContext.a().a("ReadInJoyVariableImageContentView", new GridImageView.Builder());
    paramVafContext.a().a("ReadInJoySummaryView", new SummaryView.Builder());
    paramVafContext.a().a("ReadInJoyCommentView", new ArticleCommentView.Builder());
    paramVafContext.a().a("ReadInJoyBiuCommentView", new BiuCommentView.Builder());
    paramVafContext.a().a("CornerTextImageView", new CornerTextImageView.Builder());
  }
  
  private static void a(ViewBase paramViewBase, ViewBean paramViewBean)
  {
    if (paramViewBase != null)
    {
      paramViewBase.b(paramViewBean);
      if ((paramViewBase instanceof Layout))
      {
        paramViewBase = ((Layout)paramViewBase).a();
        List localList = Arrays.asList(paramViewBean.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean);
        if (paramViewBase != null)
        {
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
            QLog.d("ProteusSupportUtil", 2, "bindDataImpl: fail to bind data for " + paramViewBean.jdField_a_of_type_JavaLangString + "due to ViewBean - ViewBase count mismatch");
          }
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!ProteusSettingUtil.a()) {
      return false;
    }
    switch (paramInt)
    {
    case 10: 
    case 34: 
    default: 
      return false;
    case 0: 
      return true;
    case 6: 
    case 66: 
      return true;
    case 3: 
      return true;
    case 2: 
    case 39: 
      return true;
    case 1: 
      return true;
    case 29: 
      return true;
    case 47: 
    case 60: 
      return true;
    }
    return true;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 0) || (paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 47) || (paramInt1 == 60) || (paramInt1 == 39) || (paramInt1 == 66) || (paramInt1 == 50) || (paramInt1 == 51) || (paramInt1 == 52) || (paramInt1 == 53)) && ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 5) || (paramInt2 == 6) || (paramInt2 == 47) || (paramInt2 == 60) || (paramInt2 == 39) || (paramInt2 == 66) || (paramInt2 == 50) || (paramInt2 == 51) || (paramInt2 == 52) || (paramInt2 == 53));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil
 * JD-Core Version:    0.7.0.1
 */