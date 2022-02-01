package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInjoyFeedsUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.device.RIJDisplayStyleManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FamilyCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoColumnItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.WeishiGridTwoItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJConfigVideoItem
{
  public static VideoPlayManager.VideoPlayParam a(BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramBaseArticleInfo, false);
  }
  
  public static VideoPlayManager.VideoPlayParam a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
    localVideoPlayParam.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
    localVideoPlayParam.jdField_c_of_type_Long = paramBaseArticleInfo.mArticleID;
    localVideoPlayParam.jdField_b_of_type_Int = paramBaseArticleInfo.getVideoDuration();
    localVideoPlayParam.jdField_c_of_type_Int = paramBaseArticleInfo.getVideoWidth();
    localVideoPlayParam.jdField_d_of_type_Int = paramBaseArticleInfo.getVideoHeight();
    localVideoPlayParam.jdField_a_of_type_Long = paramBaseArticleInfo.mXGFileSize;
    localVideoPlayParam.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mTitle;
    Object localObject;
    if (paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false) == null)
    {
      localObject = null;
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((String)localObject);
      localVideoPlayParam.k = paramBaseArticleInfo.getSubscribeUin();
      localVideoPlayParam.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localVideoPlayParam.jdField_g_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new ReadinjoyVideoReportData();
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      ((ReadinjoyVideoReportData)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.getVideoVid();
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      ((ReadinjoyVideoReportData)localObject).k = paramBaseArticleInfo.getVideoWidth();
      ((ReadinjoyVideoReportData)localObject).l = paramBaseArticleInfo.getVideoHeight();
      ((ReadinjoyVideoReportData)localObject).s = paramBaseArticleInfo.getVideoDuration();
      ((ReadinjoyVideoReportData)localObject).p = 0;
      ((ReadinjoyVideoReportData)localObject).q = 0;
      ((ReadinjoyVideoReportData)localObject).r = 0;
      ((ReadinjoyVideoReportData)localObject).jdField_f_of_type_Boolean = false;
      ((ReadinjoyVideoReportData)localObject).g = false;
      ((ReadinjoyVideoReportData)localObject).h = false;
      ((ReadinjoyVideoReportData)localObject).jdField_f_of_type_JavaLangString = "";
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = ((ReadinjoyVideoReportData)localObject);
      localVideoPlayParam.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localVideoPlayParam.e = paramBaseArticleInfo.thirdName;
      localVideoPlayParam.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localVideoPlayParam.jdField_f_of_type_Int = paramBaseArticleInfo.busiType;
      localVideoPlayParam.j = paramBaseArticleInfo.getInnerUniqueID();
      localVideoPlayParam.jdField_b_of_type_Long = paramBaseArticleInfo.mChannelID;
      localVideoPlayParam.jdField_g_of_type_JavaLangString = paramBaseArticleInfo.mThirdVideoURL;
      localVideoPlayParam.jdField_f_of_type_Long = paramBaseArticleInfo.mThirdVideoURLExpireTime;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      if (!paramBoolean) {
        break label400;
      }
    }
    label400:
    for (int i = 3;; i = 0)
    {
      localVideoPlayParam.m = i;
      if (RIJItemViewType.a((ArticleInfo)paramBaseArticleInfo) == 4) {
        localVideoPlayParam.jdField_c_of_type_Boolean = true;
      }
      if ((paramBaseArticleInfo.mChannelID == 56L) && (RIJAladdinUtils.l()))
      {
        i = DisplayUtil.a(BaseApplicationImpl.getApplication().getApplicationContext(), 8.0F);
        localVideoPlayParam.o = i;
        localVideoPlayParam.p = i;
        localVideoPlayParam.q = i;
        localVideoPlayParam.r = i;
      }
      return localVideoPlayParam;
      localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false).getPath();
      break;
    }
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView.getParent() instanceof View)) {
      a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, (View)paramView.getParent());
    }
  }
  
  public static void a(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2)
  {
    paramView2.post(new RIJConfigVideoItem.7(paramView1, paramInt1, paramInt2, paramInt3, paramInt4, paramView2));
  }
  
  private static void a(View paramView1, View paramView2, Context paramContext)
  {
    a(paramView1, true, paramContext);
    a(paramView2, false, paramContext);
  }
  
  private static void a(View paramView, boolean paramBoolean, Context paramContext)
  {
    paramView.getPaddingLeft();
    int k = paramView.getPaddingTop();
    paramView.getPaddingRight();
    int m = paramView.getPaddingBottom();
    int i = RIJDisplayStyleManager.a(paramContext);
    int j;
    if (paramBoolean)
    {
      j = RIJDisplayStyleManager.b(paramContext);
      i /= 2;
    }
    for (;;)
    {
      paramView.setPadding(j, k, i, m);
      return;
      j = i / 2;
      i = RIJDisplayStyleManager.b(paramContext);
    }
  }
  
  private static void a(BaseArticleInfo paramBaseArticleInfo, TextView paramTextView1, View paramView1, TextView paramTextView2, KandianUrlImageView paramKandianUrlImageView, View paramView2, Context paramContext)
  {
    int i = ReadInJoyHelper.e();
    boolean bool2 = ReadInJoyHelper.u();
    paramTextView1.setMaxLines(i);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView1.getLayoutParams();
    float f;
    boolean bool1;
    if (bool2)
    {
      f = 5.0F;
      localLayoutParams.bottomMargin = AIOUtils.a(f, paramContext.getResources());
      if (bool2) {
        break label186;
      }
      bool1 = true;
      label58:
      localLayoutParams.alignWithParent = bool1;
      paramTextView1.setLayoutParams(localLayoutParams);
      if (paramView1 != null) {
        if (!bool2) {
          break label192;
        }
      }
    }
    label186:
    label192:
    for (i = 0;; i = 8)
    {
      paramView1.setVisibility(i);
      if (!paramBaseArticleInfo.hasFamilyCommentIcon()) {
        break label211;
      }
      try
      {
        paramTextView1 = new URL(paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString);
        if (paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int > 0) {
          a(paramKandianUrlImageView, paramTextView1, paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_Int, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int, paramContext);
        }
        paramKandianUrlImageView.setOnClickListener(new RIJConfigVideoItem.6(paramContext, paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString, paramView2));
        paramKandianUrlImageView.setVisibility(0);
        paramTextView2.setVisibility(8);
        return;
      }
      catch (MalformedURLException paramBaseArticleInfo)
      {
        QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI exception");
        return;
      }
      f = 8.0F;
      break;
      bool1 = false;
      break label58;
    }
    label211:
    QLog.d("ReadInJoyBaseAdapter", 2, "innerConfigTwoItemVideoUI setCommentCountText");
    paramKandianUrlImageView.setVisibility(8);
    paramTextView2.setVisibility(0);
    VideoFeedsHelper.a(paramTextView2, paramBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131712891), "0");
  }
  
  /* Error */
  public static void a(com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoColumnItemViewHolder paramBigImgVideoColumnItemViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 387	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   9: ifnull +144 -> 153
    //   12: aload_1
    //   13: getfield 387	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 392	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   23: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +448 -> 474
    //   29: aload_0
    //   30: getfield 403	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   33: aload 6
    //   35: getfield 392	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Ljava/lang/String;
    //   38: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   41: aload_0
    //   42: getfield 403	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   45: iconst_0
    //   46: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   49: aload 6
    //   51: getfield 408	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +439 -> 496
    //   60: new 224	java/net/URL
    //   63: dup
    //   64: aload 6
    //   66: getfield 408	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: astore 7
    //   74: aload_0
    //   75: getfield 411	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   78: aload 7
    //   80: invokevirtual 415	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   83: pop
    //   84: aload_0
    //   85: getfield 411	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   88: iconst_0
    //   89: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   92: aload 6
    //   94: getfield 416	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +426 -> 526
    //   103: aload_0
    //   104: getfield 418	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   107: aload 6
    //   109: getfield 416	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   115: aload_0
    //   116: getfield 418	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   119: iconst_0
    //   120: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   123: aload 6
    //   125: getfield 419	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:j	Ljava/lang/String;
    //   128: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +22 -> 153
    //   134: aload 6
    //   136: getfield 419	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:j	Ljava/lang/String;
    //   139: invokestatic 425	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   142: istore 5
    //   144: aload_0
    //   145: getfield 418	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   148: iload 5
    //   150: invokevirtual 428	android/widget/TextView:setTextColor	(I)V
    //   153: aload_1
    //   154: invokestatic 430	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;
    //   157: astore 6
    //   159: aload 6
    //   161: aload_0
    //   162: getfield 432	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   165: putfield 435	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   168: aload 6
    //   170: aload_0
    //   171: getfield 436	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_Int	I
    //   174: putfield 437	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_a_of_type_Int	I
    //   177: aload 6
    //   179: aload_1
    //   180: putfield 181	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   183: aload_0
    //   184: aload 6
    //   186: putfield 440	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;
    //   189: aload_0
    //   190: getfield 442	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   193: aload_1
    //   194: getfield 60	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   197: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   200: aload_0
    //   201: getfield 442	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   204: invokevirtual 446	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   207: iconst_1
    //   208: invokevirtual 452	android/text/TextPaint:setFakeBoldText	(Z)V
    //   211: aload_0
    //   212: getfield 442	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   215: aload_2
    //   216: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   219: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   222: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   225: ldc_w 462
    //   228: invokevirtual 468	android/content/res/Resources:getColor	(I)I
    //   231: invokevirtual 428	android/widget/TextView:setTextColor	(I)V
    //   234: aload_0
    //   235: getfield 470	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   238: bipush 8
    //   240: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   243: aload_0
    //   244: getfield 472	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   247: aload 6
    //   249: getfield 41	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_b_of_type_Int	I
    //   252: iconst_1
    //   253: invokestatic 477	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyDisplayUtils:a	(IZ)Ljava/lang/String;
    //   256: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   259: aload_0
    //   260: getfield 480	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   263: bipush 10
    //   265: bipush 10
    //   267: bipush 10
    //   269: bipush 10
    //   271: invokestatic 484	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/view/View;IIII)V
    //   274: aload_0
    //   275: getfield 480	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   278: aload_0
    //   279: invokevirtual 490	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   282: aload_0
    //   283: getfield 480	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   286: aload_3
    //   287: invokevirtual 491	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   290: aload_2
    //   291: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   294: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   297: aload_0
    //   298: getfield 432	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   301: aload_0
    //   302: getfield 440	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;
    //   305: invokestatic 496	com/tencent/biz/pubaccount/readinjoy/handlers/VideoHandler:a	(Landroid/content/Context;Landroid/widget/ImageView;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;)V
    //   308: aload_0
    //   309: getfield 432	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   312: aload_1
    //   313: iconst_0
    //   314: invokevirtual 66	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   317: iconst_0
    //   318: aload_2
    //   319: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   322: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   325: invokestatic 499	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;ZLandroid/content/Context;)V
    //   328: aload_0
    //   329: getfield 432	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   332: aload 4
    //   334: invokevirtual 503	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   337: aload_0
    //   338: getfield 506	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   341: fconst_1
    //   342: aload 6
    //   344: getfield 46	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_c_of_type_Int	I
    //   347: aload 6
    //   349: getfield 52	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_d_of_type_Int	I
    //   352: invokestatic 509	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyDisplayUtils:a	(II)F
    //   355: invokevirtual 515	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   358: aload_0
    //   359: getfield 506	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   362: aload_0
    //   363: invokevirtual 516	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   366: aload_2
    //   367: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   370: invokevirtual 519	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;
    //   373: aload_2
    //   374: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   377: invokevirtual 521	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:b	()I
    //   380: aload_1
    //   381: getfield 31	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   384: invokevirtual 526	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:b	(IJ)Z
    //   387: ifeq +26 -> 413
    //   390: aload_0
    //   391: getfield 528	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   394: aload_2
    //   395: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   398: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   401: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   404: ldc_w 529
    //   407: invokevirtual 468	android/content/res/Resources:getColor	(I)I
    //   410: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   413: aload_1
    //   414: getfield 55	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   417: lconst_0
    //   418: lcmp
    //   419: ifgt +119 -> 538
    //   422: aload_0
    //   423: getfield 534	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   426: ldc_w 535
    //   429: invokestatic 371	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   432: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   435: aload_2
    //   436: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   439: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   442: invokestatic 540	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   445: ifeq +132 -> 577
    //   448: aload_0
    //   449: getfield 542	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   452: iconst_0
    //   453: invokevirtual 543	android/widget/ImageView:setVisibility	(I)V
    //   456: aload_0
    //   457: getfield 534	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   460: bipush 8
    //   462: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   465: aload_0
    //   466: getfield 545	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   469: iconst_0
    //   470: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   473: return
    //   474: aload_0
    //   475: getfield 403	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   478: bipush 8
    //   480: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   483: goto -434 -> 49
    //   486: astore 7
    //   488: aload 7
    //   490: invokevirtual 548	java/lang/Exception:printStackTrace	()V
    //   493: goto -401 -> 92
    //   496: aload_0
    //   497: getfield 411	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   500: bipush 8
    //   502: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   505: goto -413 -> 92
    //   508: astore 6
    //   510: aload_0
    //   511: getfield 418	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   514: ldc_w 550
    //   517: invokestatic 425	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   520: invokevirtual 428	android/widget/TextView:setTextColor	(I)V
    //   523: goto -370 -> 153
    //   526: aload_0
    //   527: getfield 418	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   530: bipush 8
    //   532: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   535: goto -382 -> 153
    //   538: aload_0
    //   539: getfield 534	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   542: new 552	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 553	java/lang/StringBuilder:<init>	()V
    //   549: aload_1
    //   550: getfield 55	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   553: invokestatic 556	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:b	(J)Ljava/lang/String;
    //   556: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: ldc_w 561
    //   562: invokestatic 371	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   565: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 564	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   574: goto -139 -> 435
    //   577: aload_0
    //   578: getfield 542	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   581: bipush 8
    //   583: invokevirtual 543	android/widget/ImageView:setVisibility	(I)V
    //   586: aload_2
    //   587: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   590: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   593: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   596: ldc_w 565
    //   599: invokevirtual 569	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   602: astore_3
    //   603: aload_0
    //   604: getfield 534	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   607: aload_3
    //   608: aconst_null
    //   609: aconst_null
    //   610: aconst_null
    //   611: invokevirtual 573	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   614: aload_0
    //   615: getfield 534	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   618: ldc_w 574
    //   621: aload_2
    //   622: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   625: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   628: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   631: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   634: invokevirtual 577	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   637: aload_0
    //   638: getfield 534	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   641: iconst_0
    //   642: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   645: invokestatic 581	com/tencent/mobileqq/vip/CUKingCardHelper:a	()I
    //   648: iconst_1
    //   649: if_icmpne +34 -> 683
    //   652: aload_0
    //   653: getfield 534	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   656: ldc_w 582
    //   659: invokestatic 371	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   662: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   665: aload_0
    //   666: getfield 584	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   669: bipush 8
    //   671: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   674: aload_0
    //   675: getfield 545	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   678: iconst_0
    //   679: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   682: return
    //   683: invokestatic 587	cooperation/readinjoy/ReadInJoyHelper:y	()Z
    //   686: ifeq +302 -> 988
    //   689: aload_2
    //   690: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   693: invokevirtual 589	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:e	()Z
    //   696: ifne +292 -> 988
    //   699: aload_0
    //   700: getfield 436	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_a_of_type_Int	I
    //   703: ifne +285 -> 988
    //   706: invokestatic 591	cooperation/readinjoy/ReadInJoyHelper:f	()Ljava/lang/String;
    //   709: astore 4
    //   711: invokestatic 593	cooperation/readinjoy/ReadInJoyHelper:g	()Ljava/lang/String;
    //   714: astore 6
    //   716: invokestatic 595	cooperation/readinjoy/ReadInJoyHelper:h	()Ljava/lang/String;
    //   719: astore 7
    //   721: aload 4
    //   723: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   726: ifne +228 -> 954
    //   729: invokestatic 600	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/util/RIJQQAppInterfaceUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   732: astore 8
    //   734: ldc 135
    //   736: astore_3
    //   737: aload 8
    //   739: ifnull +9 -> 748
    //   742: aload 8
    //   744: invokevirtual 605	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   747: astore_3
    //   748: new 607	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder
    //   751: dup
    //   752: aconst_null
    //   753: aconst_null
    //   754: aconst_null
    //   755: aconst_null
    //   756: invokespecial 610	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   759: aload_3
    //   760: invokevirtual 613	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder:m	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder;
    //   763: aload_1
    //   764: getfield 100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   767: invokevirtual 615	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder:i	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder;
    //   770: invokevirtual 618	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder:a	()Lcom/tencent/biz/pubaccount/readinjoy/video/report/VideoR5;
    //   773: invokevirtual 622	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5:a	()Ljava/lang/String;
    //   776: astore_1
    //   777: aload_0
    //   778: getfield 584	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   781: iconst_0
    //   782: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   785: aload_0
    //   786: getfield 584	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   789: fconst_2
    //   790: aload_2
    //   791: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   794: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   797: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   800: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   803: invokevirtual 577	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   806: aload_2
    //   807: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   810: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   813: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   816: ldc_w 623
    //   819: invokevirtual 569	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   822: astore_3
    //   823: aload_3
    //   824: iconst_0
    //   825: iconst_0
    //   826: ldc_w 624
    //   829: aload_2
    //   830: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   833: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   836: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   839: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   842: ldc_w 624
    //   845: aload_2
    //   846: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   849: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   852: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   855: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   858: invokevirtual 629	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   861: aload_0
    //   862: getfield 584	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   865: aconst_null
    //   866: aconst_null
    //   867: aload_3
    //   868: aconst_null
    //   869: invokevirtual 632	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   872: aload_2
    //   873: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   876: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   879: aload_0
    //   880: getfield 584	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   883: aload 6
    //   885: aload 7
    //   887: aload 4
    //   889: new 634	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem$4
    //   892: dup
    //   893: aload_1
    //   894: aload_0
    //   895: invokespecial 637	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem$4:<init>	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder;)V
    //   898: invokestatic 640	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   901: aload_0
    //   902: getfield 545	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   905: ldc_w 641
    //   908: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   911: aload_2
    //   912: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   915: iconst_1
    //   916: invokevirtual 644	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:c	(Z)Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   919: pop
    //   920: ldc_w 646
    //   923: invokestatic 652	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   926: checkcast 646	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   929: aconst_null
    //   930: ldc 135
    //   932: ldc_w 654
    //   935: ldc_w 654
    //   938: iconst_0
    //   939: iconst_0
    //   940: ldc 135
    //   942: ldc 135
    //   944: ldc 135
    //   946: aload_1
    //   947: iconst_0
    //   948: invokeinterface 658 12 0
    //   953: return
    //   954: aload_0
    //   955: getfield 584	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   958: bipush 8
    //   960: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   963: aload_0
    //   964: getfield 545	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   967: iconst_0
    //   968: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   971: invokestatic 661	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   974: ifeq -970 -> 4
    //   977: ldc_w 663
    //   980: iconst_2
    //   981: ldc_w 665
    //   984: invokestatic 668	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: return
    //   988: aload_0
    //   989: getfield 584	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   992: bipush 8
    //   994: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   997: aload_0
    //   998: getfield 545	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoColumnItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1001: iconst_0
    //   1002: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   1005: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	paramBigImgVideoColumnItemViewHolder	com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoColumnItemViewHolder
    //   0	1006	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	1006	2	paramRIJDataManager	RIJDataManager
    //   0	1006	3	paramOnClickListener	View.OnClickListener
    //   0	1006	4	paramOnLongClickListener	View.OnLongClickListener
    //   142	7	5	i	int
    //   16	332	6	localObject	Object
    //   508	1	6	localThrowable	java.lang.Throwable
    //   714	170	6	str1	String
    //   72	7	7	localURL	URL
    //   486	3	7	localException	Exception
    //   719	167	7	str2	String
    //   732	11	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   60	92	486	java/lang/Exception
    //   134	153	508	java/lang/Throwable
  }
  
  /* Error */
  public static void a(com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoItemViewHolder paramBigImgVideoItemViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getfield 672	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   9: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +542 -> 554
    //   15: aload_0
    //   16: getfield 676	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:i	Landroid/widget/TextView;
    //   19: aload_1
    //   20: getfield 672	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   23: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   26: aload_1
    //   27: getfield 679	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   30: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +512 -> 545
    //   36: ldc_w 681
    //   39: astore 6
    //   41: aload 6
    //   43: invokestatic 425	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   46: istore 5
    //   48: aload_0
    //   49: getfield 676	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:i	Landroid/widget/TextView;
    //   52: iload 5
    //   54: invokevirtual 428	android/widget/TextView:setTextColor	(I)V
    //   57: aload_0
    //   58: getfield 676	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:i	Landroid/widget/TextView;
    //   61: iconst_0
    //   62: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   65: aload_0
    //   66: getfield 682	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   69: aload_1
    //   70: getfield 685	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   73: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   76: aload_1
    //   77: invokevirtual 322	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:hasFamilyCommentIcon	()Z
    //   80: ifeq +501 -> 581
    //   83: new 224	java/net/URL
    //   86: dup
    //   87: aload_1
    //   88: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FamilyCommentInfo;
    //   91: getfield 329	com/tencent/biz/pubaccount/readinjoy/struct/FamilyCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   97: astore 6
    //   99: aload_1
    //   100: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FamilyCommentInfo;
    //   103: getfield 333	com/tencent/biz/pubaccount/readinjoy/struct/FamilyCommentInfo:jdField_b_of_type_Int	I
    //   106: ifle +33 -> 139
    //   109: aload_0
    //   110: getfield 686	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   113: aload 6
    //   115: aload_1
    //   116: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FamilyCommentInfo;
    //   119: getfield 334	com/tencent/biz/pubaccount/readinjoy/struct/FamilyCommentInfo:jdField_a_of_type_Int	I
    //   122: aload_1
    //   123: getfield 326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:familyCommentInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FamilyCommentInfo;
    //   126: getfield 333	com/tencent/biz/pubaccount/readinjoy/struct/FamilyCommentInfo:jdField_b_of_type_Int	I
    //   129: aload_2
    //   130: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   133: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   136: invokestatic 337	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;IILandroid/content/Context;)V
    //   139: aload_0
    //   140: getfield 686	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   143: iconst_0
    //   144: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   147: aload_0
    //   148: getfield 688	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:h	Landroid/widget/TextView;
    //   151: bipush 8
    //   153: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   156: aload_1
    //   157: getfield 691	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   160: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   163: ifne +494 -> 657
    //   166: new 224	java/net/URL
    //   169: dup
    //   170: aload_1
    //   171: getfield 691	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:vIconUrl	Ljava/lang/String;
    //   174: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   177: astore 6
    //   179: aload_0
    //   180: getfield 693	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   183: aload 6
    //   185: invokevirtual 415	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   188: pop
    //   189: aload_0
    //   190: getfield 693	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   193: iconst_0
    //   194: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   197: aload_0
    //   198: getfield 694	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   201: bipush 10
    //   203: bipush 10
    //   205: bipush 10
    //   207: bipush 10
    //   209: invokestatic 484	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/view/View;IIII)V
    //   212: aload_0
    //   213: getfield 694	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   216: aload_0
    //   217: invokevirtual 490	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   220: aload_0
    //   221: getfield 694	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   224: aload_3
    //   225: invokevirtual 491	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   228: aload_1
    //   229: invokestatic 430	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;
    //   232: astore_3
    //   233: aload_3
    //   234: aload_0
    //   235: getfield 695	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   238: putfield 435	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   241: aload_3
    //   242: aload_0
    //   243: getfield 696	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_Int	I
    //   246: putfield 437	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_a_of_type_Int	I
    //   249: aload_3
    //   250: aload_1
    //   251: putfield 181	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   254: aload_3
    //   255: iconst_1
    //   256: putfield 699	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:n	I
    //   259: aload_0
    //   260: aload_3
    //   261: putfield 700	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;
    //   264: aload_0
    //   265: getfield 701	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   268: bipush 8
    //   270: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   273: aload_0
    //   274: getfield 702	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   277: bipush 8
    //   279: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   282: aload_0
    //   283: getfield 704	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   286: bipush 8
    //   288: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   291: aload_0
    //   292: getfield 705	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   295: aload_1
    //   296: getfield 60	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   299: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   302: aload_0
    //   303: getfield 705	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   306: astore 6
    //   308: invokestatic 710	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine:a	()Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine;
    //   311: aload_1
    //   312: getfield 31	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   315: invokevirtual 713	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyLogicEngine:a	(J)Z
    //   318: ifeq +351 -> 669
    //   321: getstatic 716	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/util/RIJParseColor:jdField_a_of_type_Int	I
    //   324: istore 5
    //   326: aload 6
    //   328: iload 5
    //   330: invokevirtual 428	android/widget/TextView:setTextColor	(I)V
    //   333: aload_0
    //   334: getfield 717	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   337: aload_3
    //   338: getfield 41	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_b_of_type_Int	I
    //   341: iconst_1
    //   342: invokestatic 477	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyDisplayUtils:a	(IZ)Ljava/lang/String;
    //   345: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   348: aload_2
    //   349: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   352: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   355: aload_0
    //   356: getfield 695	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   359: aload_0
    //   360: getfield 700	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;
    //   363: invokestatic 496	com/tencent/biz/pubaccount/readinjoy/handlers/VideoHandler:a	(Landroid/content/Context;Landroid/widget/ImageView;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;)V
    //   366: aload_0
    //   367: getfield 695	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   370: aload_1
    //   371: iconst_0
    //   372: invokevirtual 66	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoCoverUrlWithSmartCut	(Z)Ljava/net/URL;
    //   375: iconst_0
    //   376: aload_2
    //   377: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   380: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   383: invokestatic 499	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;ZLandroid/content/Context;)V
    //   386: aload_0
    //   387: getfield 695	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   390: aload 4
    //   392: invokevirtual 503	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   395: aload_0
    //   396: getfield 717	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   399: iconst_0
    //   400: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   403: aload_0
    //   404: getfield 717	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   407: invokevirtual 720	android/widget/TextView:clearAnimation	()V
    //   410: aload_0
    //   411: getfield 721	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   414: fconst_1
    //   415: aload_3
    //   416: getfield 46	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_c_of_type_Int	I
    //   419: aload_3
    //   420: getfield 52	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_d_of_type_Int	I
    //   423: invokestatic 509	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyDisplayUtils:a	(II)F
    //   426: invokevirtual 515	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   429: aload_0
    //   430: getfield 721	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   433: aload_0
    //   434: invokevirtual 516	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   437: aload_2
    //   438: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   441: invokevirtual 519	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;
    //   444: aload_2
    //   445: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   448: invokevirtual 521	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:b	()I
    //   451: aload_1
    //   452: getfield 31	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   455: invokevirtual 526	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:b	(IJ)Z
    //   458: ifeq +26 -> 484
    //   461: aload_0
    //   462: getfield 722	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   465: aload_2
    //   466: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   469: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   472: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   475: ldc_w 529
    //   478: invokevirtual 468	android/content/res/Resources:getColor	(I)I
    //   481: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   484: aload_1
    //   485: getfield 55	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   488: lconst_0
    //   489: lcmp
    //   490: ifgt +187 -> 677
    //   493: aload_0
    //   494: getfield 723	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   497: ldc_w 535
    //   500: invokestatic 371	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   503: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   506: aload_2
    //   507: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   510: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   513: invokestatic 540	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   516: ifeq +200 -> 716
    //   519: aload_0
    //   520: getfield 724	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   523: iconst_0
    //   524: invokevirtual 543	android/widget/ImageView:setVisibility	(I)V
    //   527: aload_0
    //   528: getfield 723	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   531: bipush 8
    //   533: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   536: aload_0
    //   537: getfield 725	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   540: iconst_0
    //   541: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   544: return
    //   545: aload_1
    //   546: getfield 679	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptColor	Ljava/lang/String;
    //   549: astore 6
    //   551: goto -510 -> 41
    //   554: aload_0
    //   555: getfield 676	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:i	Landroid/widget/TextView;
    //   558: bipush 8
    //   560: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   563: goto -498 -> 65
    //   566: astore 6
    //   568: ldc_w 353
    //   571: iconst_2
    //   572: ldc_w 727
    //   575: invokestatic 360	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: goto -422 -> 156
    //   581: aload_0
    //   582: getfield 686	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   585: bipush 8
    //   587: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   590: aload_0
    //   591: getfield 688	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:h	Landroid/widget/TextView;
    //   594: iconst_0
    //   595: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   598: ldc_w 353
    //   601: iconst_2
    //   602: ldc_w 729
    //   605: invokestatic 360	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: aload_0
    //   609: getfield 688	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:h	Landroid/widget/TextView;
    //   612: new 552	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 553	java/lang/StringBuilder:<init>	()V
    //   619: aload_1
    //   620: invokevirtual 365	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getCommentCount	()I
    //   623: invokestatic 731	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:d	(I)Ljava/lang/String;
    //   626: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: ldc_w 732
    //   632: invokestatic 371	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   635: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 564	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   644: goto -488 -> 156
    //   647: astore 6
    //   649: aload 6
    //   651: invokevirtual 548	java/lang/Exception:printStackTrace	()V
    //   654: goto -457 -> 197
    //   657: aload_0
    //   658: getfield 693	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   661: bipush 8
    //   663: invokevirtual 350	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setVisibility	(I)V
    //   666: goto -469 -> 197
    //   669: getstatic 733	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/util/RIJParseColor:jdField_b_of_type_Int	I
    //   672: istore 5
    //   674: goto -348 -> 326
    //   677: aload_0
    //   678: getfield 723	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   681: new 552	java/lang/StringBuilder
    //   684: dup
    //   685: invokespecial 553	java/lang/StringBuilder:<init>	()V
    //   688: aload_1
    //   689: getfield 55	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   692: invokestatic 556	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:b	(J)Ljava/lang/String;
    //   695: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 561
    //   701: invokestatic 371	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   704: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 564	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   713: goto -207 -> 506
    //   716: aload_0
    //   717: getfield 724	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   720: bipush 8
    //   722: invokevirtual 543	android/widget/ImageView:setVisibility	(I)V
    //   725: aload_2
    //   726: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   729: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   732: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   735: ldc_w 565
    //   738: invokevirtual 569	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   741: astore_3
    //   742: aload_0
    //   743: getfield 723	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   746: aload_3
    //   747: aconst_null
    //   748: aconst_null
    //   749: aconst_null
    //   750: invokevirtual 573	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   753: aload_0
    //   754: getfield 723	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   757: ldc_w 574
    //   760: aload_2
    //   761: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   764: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   767: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   770: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   773: invokevirtual 577	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   776: aload_0
    //   777: getfield 723	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   780: iconst_0
    //   781: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   784: invokestatic 581	com/tencent/mobileqq/vip/CUKingCardHelper:a	()I
    //   787: iconst_1
    //   788: if_icmpne +34 -> 822
    //   791: aload_0
    //   792: getfield 723	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   795: ldc_w 582
    //   798: invokestatic 371	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   801: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   804: aload_0
    //   805: getfield 734	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   808: bipush 8
    //   810: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   813: aload_0
    //   814: getfield 725	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   817: iconst_0
    //   818: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   821: return
    //   822: invokestatic 587	cooperation/readinjoy/ReadInJoyHelper:y	()Z
    //   825: ifeq +302 -> 1127
    //   828: aload_2
    //   829: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   832: invokevirtual 589	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:e	()Z
    //   835: ifne +292 -> 1127
    //   838: aload_0
    //   839: getfield 696	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_a_of_type_Int	I
    //   842: ifne +285 -> 1127
    //   845: invokestatic 591	cooperation/readinjoy/ReadInJoyHelper:f	()Ljava/lang/String;
    //   848: astore 4
    //   850: invokestatic 593	cooperation/readinjoy/ReadInJoyHelper:g	()Ljava/lang/String;
    //   853: astore 6
    //   855: invokestatic 595	cooperation/readinjoy/ReadInJoyHelper:h	()Ljava/lang/String;
    //   858: astore 7
    //   860: aload 4
    //   862: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   865: ifne +228 -> 1093
    //   868: invokestatic 600	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/util/RIJQQAppInterfaceUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   871: astore 8
    //   873: ldc 135
    //   875: astore_3
    //   876: aload 8
    //   878: ifnull +9 -> 887
    //   881: aload 8
    //   883: invokevirtual 605	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   886: astore_3
    //   887: new 607	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder
    //   890: dup
    //   891: aconst_null
    //   892: aconst_null
    //   893: aconst_null
    //   894: aconst_null
    //   895: invokespecial 610	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   898: aload_3
    //   899: invokevirtual 613	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder:m	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder;
    //   902: aload_1
    //   903: getfield 100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   906: invokevirtual 615	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder:i	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder;
    //   909: invokevirtual 618	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder:a	()Lcom/tencent/biz/pubaccount/readinjoy/video/report/VideoR5;
    //   912: invokevirtual 622	com/tencent/biz/pubaccount/readinjoy/video/report/VideoR5:a	()Ljava/lang/String;
    //   915: astore_1
    //   916: aload_0
    //   917: getfield 734	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   920: iconst_0
    //   921: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   924: aload_0
    //   925: getfield 734	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   928: fconst_2
    //   929: aload_2
    //   930: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   933: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   936: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   939: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   942: invokevirtual 577	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   945: aload_2
    //   946: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   949: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   952: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   955: ldc_w 623
    //   958: invokevirtual 569	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   961: astore_3
    //   962: aload_3
    //   963: iconst_0
    //   964: iconst_0
    //   965: ldc_w 624
    //   968: aload_2
    //   969: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   972: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   975: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   978: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   981: ldc_w 624
    //   984: aload_2
    //   985: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   988: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   991: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   994: invokestatic 306	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   997: invokevirtual 629	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   1000: aload_0
    //   1001: getfield 734	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1004: aconst_null
    //   1005: aconst_null
    //   1006: aload_3
    //   1007: aconst_null
    //   1008: invokevirtual 632	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1011: aload_2
    //   1012: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   1015: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   1018: aload_0
    //   1019: getfield 734	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1022: aload 6
    //   1024: aload 7
    //   1026: aload 4
    //   1028: new 736	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem$3
    //   1031: dup
    //   1032: aload_1
    //   1033: aload_0
    //   1034: invokespecial 739	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem$3:<init>	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder;)V
    //   1037: invokestatic 640	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:b	(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    //   1040: aload_0
    //   1041: getfield 725	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1044: ldc_w 641
    //   1047: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   1050: aload_2
    //   1051: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   1054: iconst_1
    //   1055: invokevirtual 644	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:c	(Z)Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   1058: pop
    //   1059: ldc_w 646
    //   1062: invokestatic 652	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1065: checkcast 646	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   1068: aconst_null
    //   1069: ldc 135
    //   1071: ldc_w 654
    //   1074: ldc_w 654
    //   1077: iconst_0
    //   1078: iconst_0
    //   1079: ldc 135
    //   1081: ldc 135
    //   1083: ldc 135
    //   1085: aload_1
    //   1086: iconst_0
    //   1087: invokeinterface 658 12 0
    //   1092: return
    //   1093: aload_0
    //   1094: getfield 734	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1097: bipush 8
    //   1099: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   1102: aload_0
    //   1103: getfield 725	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1106: iconst_0
    //   1107: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   1110: invokestatic 661	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1113: ifeq -1109 -> 4
    //   1116: ldc_w 663
    //   1119: iconst_2
    //   1120: ldc_w 665
    //   1123: invokestatic 668	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1126: return
    //   1127: aload_0
    //   1128: getfield 734	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1131: bipush 8
    //   1133: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   1136: aload_0
    //   1137: getfield 725	com/tencent/biz/pubaccount/readinjoy/video/viewholder/BigImgVideoItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1140: iconst_0
    //   1141: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   1144: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1145	0	paramBigImgVideoItemViewHolder	com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoItemViewHolder
    //   0	1145	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	1145	2	paramRIJDataManager	RIJDataManager
    //   0	1145	3	paramOnClickListener	View.OnClickListener
    //   0	1145	4	paramOnLongClickListener	View.OnLongClickListener
    //   46	627	5	i	int
    //   39	511	6	localObject	Object
    //   566	1	6	localMalformedURLException	MalformedURLException
    //   647	3	6	localException	Exception
    //   853	170	6	str1	String
    //   858	167	7	str2	String
    //   871	11	8	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   83	139	566	java/net/MalformedURLException
    //   139	156	566	java/net/MalformedURLException
    //   166	197	647	java/lang/Exception
  }
  
  private static void a(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    VideoColumnInfo localVideoColumnInfo;
    if (paramBaseArticleInfo.mVideoColumnInfo != null)
    {
      localVideoColumnInfo = paramBaseArticleInfo.mVideoColumnInfo;
      if (localVideoColumnInfo.jdField_d_of_type_Int != 1) {
        break label407;
      }
      paramBaseArticleInfo = paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      paramBaseArticleInfo.height = DisplayUtil.a(paramRIJDataManager.a().a(), 90.0F);
      paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(paramBaseArticleInfo);
    }
    try
    {
      if (!TextUtils.isEmpty(localVideoColumnInfo.jdField_d_of_type_JavaLangString)) {
        a(paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(localVideoColumnInfo.jdField_d_of_type_JavaLangString), paramRIJDataManager.a().a());
      }
    }
    catch (Exception paramBaseArticleInfo)
    {
      try
      {
        if (!TextUtils.isEmpty(localVideoColumnInfo.e))
        {
          paramBaseArticleInfo = ReadInJoyDisplayUtils.a(localVideoColumnInfo.e);
          paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramBaseArticleInfo);
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        try
        {
          a(paramVideoColumnItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(localVideoColumnInfo.jdField_f_of_type_JavaLangString), paramRIJDataManager.a().a());
          paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localVideoColumnInfo.jdField_b_of_type_JavaLangString);
          paramBaseArticleInfo = ReadInJoyTimeUtils.a(localVideoColumnInfo.jdField_a_of_type_Long, true) + HardCodeUtil.a(2131712699);
          String str1 = ReadInJoyHelper.b(localVideoColumnInfo.jdField_b_of_type_Int) + HardCodeUtil.a(2131712807);
          String str2 = localVideoColumnInfo.jdField_c_of_type_Int + HardCodeUtil.a(2131713046);
          paramBaseArticleInfo = paramBaseArticleInfo + " · " + str1 + " · " + str2;
          paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo);
          if (localVideoColumnInfo.jdField_a_of_type_Boolean)
          {
            paramVideoColumnItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            paramVideoColumnItemViewHolder.i.setText(localVideoColumnInfo.jdField_g_of_type_JavaLangString);
          }
        }
        catch (MalformedURLException paramBaseArticleInfo)
        {
          try
          {
            for (;;)
            {
              paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(DisplayUtil.a(paramRIJDataManager.a().a(), 2.0F));
              a(paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, new URL(localVideoColumnInfo.h), paramRIJDataManager.a().a());
              paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoColumnItemViewHolder);
              paramVideoColumnItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(paramVideoColumnItemViewHolder);
              paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewViewGroup.setTag(paramVideoColumnItemViewHolder);
              paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setTag(paramVideoColumnItemViewHolder);
              paramVideoColumnItemViewHolder.i.setTag(paramVideoColumnItemViewHolder);
              return;
              label407:
              paramBaseArticleInfo = paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
              paramBaseArticleInfo.height = DisplayUtil.a(paramRIJDataManager.a().a(), 80.0F);
              paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(paramBaseArticleInfo);
              continue;
              paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(new ColorDrawable(-15837762));
              continue;
              paramBaseArticleInfo = paramBaseArticleInfo;
              if (QLog.isColorLevel())
              {
                QLog.d("ReadInJoyBaseAdapter", 2, "configVideoColumnItemUI cardBgUrl error: ", paramBaseArticleInfo);
                continue;
                paramBaseArticleInfo = new ColorDrawable(-15837762);
                continue;
                paramBaseArticleInfo = paramBaseArticleInfo;
                if (QLog.isColorLevel()) {
                  QLog.d("ReadInJoyBaseAdapter", 2, "configVideoColumnItemUI cardBgColor error: ", paramBaseArticleInfo);
                }
                paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(new ColorDrawable(-15837762));
                continue;
                paramBaseArticleInfo = paramBaseArticleInfo;
                if (QLog.isColorLevel()) {
                  QLog.d("ReadInJoyBaseAdapter", 2, "configImage columnCardIcon error: ", paramBaseArticleInfo);
                }
              }
            }
            paramVideoColumnItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          catch (Exception paramBaseArticleInfo)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseAdapter", 2, "configImage appIcon error: ", paramBaseArticleInfo);
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramVideoColumnItemViewHolder);
    paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = a(paramBaseArticleInfo);
    paramOnClickListener.jdField_a_of_type_AndroidViewView = paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    paramOnClickListener.jdField_a_of_type_Int = paramVideoColumnItemViewHolder.jdField_a_of_type_Int;
    paramOnClickListener.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramOnClickListener;
    paramVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
    paramVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramVideoColumnItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramRIJDataManager.a().a().getResources().getColor(2131167374));
    if (paramBaseArticleInfo.mVideoPlayCount == 0) {
      paramVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      paramVideoColumnItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(paramOnClickListener.jdField_b_of_type_Int, true));
      VideoHandler.a(paramRIJDataManager.a().a(), paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      a(paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().a());
      paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
      paramVideoColumnItemViewHolder.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramVideoColumnItemViewHolder);
      paramVideoColumnItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(paramOnClickListener.jdField_c_of_type_Int, paramOnClickListener.jdField_d_of_type_Int));
      paramVideoColumnItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(paramVideoColumnItemViewHolder);
      if (paramRIJDataManager.a().a().b(paramRIJDataManager.a().b(), paramBaseArticleInfo.mArticleID)) {
        paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidViewView.setBackgroundColor(paramRIJDataManager.a().a().getResources().getColor(2131166917));
      }
      a(paramVideoColumnItemViewHolder, paramBaseArticleInfo, paramRIJDataManager);
      b(paramVideoColumnItemViewHolder, paramBaseArticleInfo, paramRIJDataManager);
      return;
      paramVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(paramBaseArticleInfo.mVideoPlayCount) + HardCodeUtil.a(2131713040));
    }
  }
  
  /* Error */
  public static void a(com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsTwoItemViewHolder paramVideoFeedsTwoItemViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 865	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   4: aconst_null
    //   5: invokevirtual 866	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 867	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   13: aload_0
    //   14: aload_1
    //   15: getfield 871	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubArtilceList	Ljava/util/List;
    //   18: iconst_0
    //   19: invokeinterface 877 2 0
    //   24: checkcast 19	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo
    //   27: putfield 879	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   30: aload_0
    //   31: getfield 880	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   34: aload_2
    //   35: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   38: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   41: invokevirtual 301	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   44: ldc_w 462
    //   47: invokevirtual 468	android/content/res/Resources:getColor	(I)I
    //   50: invokevirtual 532	android/view/View:setBackgroundColor	(I)V
    //   53: aload_0
    //   54: getfield 881	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   57: aload_0
    //   58: getfield 882	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   61: aload_2
    //   62: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   65: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   68: invokestatic 884	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Landroid/view/View;Landroid/view/View;Landroid/content/Context;)V
    //   71: aload_0
    //   72: getfield 867	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   75: astore 8
    //   77: aload 8
    //   79: aload_0
    //   80: getfield 885	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   83: aload_0
    //   84: getfield 886	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   87: aload_0
    //   88: getfield 887	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   91: aload_0
    //   92: getfield 888	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   95: aload_0
    //   96: getfield 865	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   99: aload_2
    //   100: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   103: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   106: invokestatic 890	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/TextView;Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/view/View;Landroid/content/Context;)V
    //   109: aload_0
    //   110: getfield 893	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   113: invokestatic 896	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   116: aload_0
    //   117: getfield 885	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   120: aload 8
    //   122: getfield 60	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   125: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   128: aload_0
    //   129: getfield 885	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   132: invokevirtual 446	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   135: iconst_1
    //   136: invokevirtual 452	android/text/TextPaint:setFakeBoldText	(Z)V
    //   139: aload_0
    //   140: getfield 897	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   143: aload 8
    //   145: getfield 849	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   148: invokestatic 860	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:c	(I)Ljava/lang/String;
    //   151: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   154: aload_0
    //   155: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   158: aload_0
    //   159: getfield 899	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   162: aload 8
    //   164: iconst_0
    //   165: aload_2
    //   166: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   169: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   172: invokestatic 902	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/widget/ImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;ZLandroid/content/Context;)V
    //   175: aload_0
    //   176: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   179: aload_0
    //   180: invokevirtual 852	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   187: aload_3
    //   188: invokevirtual 349	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   191: aload_0
    //   192: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   195: getstatic 908	com/tencent/qqlive/module/videoreport/constants/ExposurePolicy:REPORT_FIRST	Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;
    //   198: invokestatic 914	com/tencent/qqlive/module/videoreport/VideoReport:setElementExposePolicy	(Ljava/lang/Object;Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;)V
    //   201: aload_0
    //   202: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   205: getstatic 920	com/tencent/qqlive/module/videoreport/constants/EndExposurePolicy:REPORT_ALL	Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;
    //   208: invokestatic 924	com/tencent/qqlive/module/videoreport/VideoReport:setElementEndExposePolicy	(Ljava/lang/Object;Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;)V
    //   211: aload_0
    //   212: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   215: ldc_w 926
    //   218: invokestatic 930	com/tencent/qqlive/module/videoreport/VideoReport:setElementId	(Ljava/lang/Object;Ljava/lang/String;)V
    //   221: aload_0
    //   222: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   225: astore 9
    //   227: new 932	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder
    //   230: dup
    //   231: invokespecial 933	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder:<init>	()V
    //   234: aload_2
    //   235: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   238: invokevirtual 521	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:b	()I
    //   241: invokestatic 938	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: invokevirtual 941	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder:a	(Ljava/lang/Number;)Lcom/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder;
    //   247: astore 10
    //   249: aload 8
    //   251: getfield 100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   254: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifeq +707 -> 964
    //   260: ldc_w 943
    //   263: astore_1
    //   264: aload 9
    //   266: aload 10
    //   268: aload_1
    //   269: invokevirtual 946	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder:e	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder;
    //   272: invokevirtual 949	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder:a	()Ljava/util/Map;
    //   275: invokestatic 953	com/tencent/qqlive/module/videoreport/VideoReport:setElementParams	(Ljava/lang/Object;Ljava/util/Map;)V
    //   278: aload_0
    //   279: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   282: aload 8
    //   284: getfield 100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   287: invokestatic 956	com/tencent/qqlive/module/videoreport/VideoReport:setElementReuseIdentifier	(Ljava/lang/Object;Ljava/lang/String;)V
    //   290: aload_0
    //   291: getfield 888	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   294: aload 8
    //   296: invokevirtual 852	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   299: aload 8
    //   301: getfield 959	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsText	Ljava/lang/String;
    //   304: aload 8
    //   306: getfield 962	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsColor	Ljava/lang/String;
    //   309: aload_0
    //   310: getfield 963	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   313: invokestatic 966	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:a	(Ljava/lang/String;Ljava/lang/String;Landroid/widget/TextView;)V
    //   316: aload 8
    //   318: getfield 969	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isAccountShown	Z
    //   321: ifeq +673 -> 994
    //   324: aload_2
    //   325: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   328: invokevirtual 521	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:b	()I
    //   331: ifne +663 -> 994
    //   334: aload 8
    //   336: getfield 973	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   339: ifnull +655 -> 994
    //   342: aload_0
    //   343: getfield 975	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   346: iconst_0
    //   347: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   350: aload_0
    //   351: getfield 975	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   354: aload 8
    //   356: invokevirtual 976	android/view/View:setTag	(Ljava/lang/Object;)V
    //   359: aload_0
    //   360: getfield 975	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   363: ldc_w 977
    //   366: aload_0
    //   367: invokevirtual 980	android/view/View:setTag	(ILjava/lang/Object;)V
    //   370: lconst_0
    //   371: lstore 4
    //   373: aload 8
    //   375: getfield 973	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   378: getfield 986	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   381: invokevirtual 991	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   384: ifeq +16 -> 400
    //   387: aload 8
    //   389: getfield 973	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   392: getfield 986	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   395: invokevirtual 994	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   398: lstore 4
    //   400: aload_0
    //   401: getfield 997	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   404: lload 4
    //   406: invokevirtual 1003	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setHeadImgByUin	(J)V
    //   409: aload_0
    //   410: getfield 997	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   413: aload 8
    //   415: invokevirtual 1004	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(Ljava/lang/Object;)V
    //   418: aload_0
    //   419: getfield 997	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   422: ldc_w 977
    //   425: aload_0
    //   426: invokevirtual 1005	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(ILjava/lang/Object;)V
    //   429: aload_0
    //   430: getfield 997	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   433: bipush 10
    //   435: bipush 10
    //   437: bipush 10
    //   439: bipush 10
    //   441: invokestatic 1006	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Landroid/view/View;IIII)V
    //   444: aload 8
    //   446: getfield 973	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   449: getfield 1010	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:bytes_v_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   452: invokestatic 1015	com/tencent/biz/pubaccount/readinjoy/protocol/RIJPBFieldUtils:b	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   455: astore_1
    //   456: aload_1
    //   457: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   460: ifne +21 -> 481
    //   463: new 224	java/net/URL
    //   466: dup
    //   467: aload_1
    //   468: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   471: astore_1
    //   472: aload_0
    //   473: getfield 1017	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   476: aload_1
    //   477: invokevirtual 415	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   480: pop
    //   481: aload_0
    //   482: getfield 1020	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   485: lload 4
    //   487: invokevirtual 1025	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setNickNameByUin	(J)V
    //   490: aload_0
    //   491: getfield 975	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   494: aload_3
    //   495: invokevirtual 866	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   498: aload_0
    //   499: getfield 997	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   502: aload_3
    //   503: invokevirtual 1026	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   506: aload_0
    //   507: getfield 879	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   510: astore 8
    //   512: aload 8
    //   514: iconst_1
    //   515: putfield 1029	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isTwoItem	Z
    //   518: aload 8
    //   520: aload_0
    //   521: getfield 1030	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   524: aload_0
    //   525: getfield 1031	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   528: aload_0
    //   529: getfield 1032	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   532: aload_0
    //   533: getfield 1033	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   536: aload_0
    //   537: getfield 865	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   540: aload_2
    //   541: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   544: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   547: invokestatic 890	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/TextView;Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/view/View;Landroid/content/Context;)V
    //   550: aload_0
    //   551: getfield 1035	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout	Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;
    //   554: invokestatic 896	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RoundAngleFrameLayout;)V
    //   557: aload_0
    //   558: getfield 1030	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   561: aload 8
    //   563: getfield 60	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   566: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   569: aload_0
    //   570: getfield 1030	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   573: invokevirtual 446	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   576: iconst_1
    //   577: invokevirtual 452	android/text/TextPaint:setFakeBoldText	(Z)V
    //   580: aload_0
    //   581: getfield 1036	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   584: aload 8
    //   586: getfield 849	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   589: invokestatic 860	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:c	(I)Ljava/lang/String;
    //   592: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   595: aload_0
    //   596: getfield 1038	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   599: aload_0
    //   600: getfield 1039	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   603: aload 8
    //   605: iconst_0
    //   606: aload_2
    //   607: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   610: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   613: invokestatic 902	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Landroid/widget/ImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;ZLandroid/content/Context;)V
    //   616: aload_0
    //   617: getfield 1038	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   620: aload_0
    //   621: invokevirtual 852	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   624: aload_0
    //   625: getfield 1038	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   628: aload_3
    //   629: invokevirtual 349	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   632: aload_0
    //   633: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   636: getstatic 908	com/tencent/qqlive/module/videoreport/constants/ExposurePolicy:REPORT_FIRST	Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;
    //   639: invokestatic 914	com/tencent/qqlive/module/videoreport/VideoReport:setElementExposePolicy	(Ljava/lang/Object;Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;)V
    //   642: aload_0
    //   643: getfield 898	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   646: getstatic 920	com/tencent/qqlive/module/videoreport/constants/EndExposurePolicy:REPORT_ALL	Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;
    //   649: invokestatic 924	com/tencent/qqlive/module/videoreport/VideoReport:setElementEndExposePolicy	(Ljava/lang/Object;Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;)V
    //   652: aload_0
    //   653: getfield 1038	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   656: ldc_w 926
    //   659: invokestatic 930	com/tencent/qqlive/module/videoreport/VideoReport:setElementId	(Ljava/lang/Object;Ljava/lang/String;)V
    //   662: aload_0
    //   663: getfield 1038	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   666: astore 9
    //   668: new 932	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder
    //   671: dup
    //   672: invokespecial 933	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder:<init>	()V
    //   675: aload_2
    //   676: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   679: invokevirtual 521	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:b	()I
    //   682: invokestatic 938	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   685: invokevirtual 941	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder:a	(Ljava/lang/Number;)Lcom/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder;
    //   688: astore 10
    //   690: aload 8
    //   692: getfield 100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   695: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   698: ifeq +308 -> 1006
    //   701: ldc_w 943
    //   704: astore_1
    //   705: aload 9
    //   707: aload 10
    //   709: aload_1
    //   710: invokevirtual 946	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder:e	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder;
    //   713: invokevirtual 949	com/tencent/biz/pubaccount/readinjoy/dt/RIJDtParamBuilder:a	()Ljava/util/Map;
    //   716: invokestatic 953	com/tencent/qqlive/module/videoreport/VideoReport:setElementParams	(Ljava/lang/Object;Ljava/util/Map;)V
    //   719: aload_0
    //   720: getfield 1038	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   723: aload 8
    //   725: getfield 100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   728: invokestatic 956	com/tencent/qqlive/module/videoreport/VideoReport:setElementReuseIdentifier	(Ljava/lang/Object;Ljava/lang/String;)V
    //   731: aload_0
    //   732: getfield 1033	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   735: aload 8
    //   737: invokevirtual 852	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   740: aload 8
    //   742: getfield 959	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsText	Ljava/lang/String;
    //   745: aload 8
    //   747: getfield 962	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsColor	Ljava/lang/String;
    //   750: aload_0
    //   751: getfield 1040	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:h	Landroid/widget/TextView;
    //   754: invokestatic 966	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:a	(Ljava/lang/String;Ljava/lang/String;Landroid/widget/TextView;)V
    //   757: aload 8
    //   759: getfield 969	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isAccountShown	Z
    //   762: ifeq +274 -> 1036
    //   765: aload_2
    //   766: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   769: invokevirtual 521	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:b	()I
    //   772: ifne +264 -> 1036
    //   775: aload 8
    //   777: getfield 973	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   780: ifnull +256 -> 1036
    //   783: aload_0
    //   784: getfield 1042	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   787: iconst_0
    //   788: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   791: aload_0
    //   792: getfield 1042	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   795: aload 8
    //   797: invokevirtual 976	android/view/View:setTag	(Ljava/lang/Object;)V
    //   800: aload_0
    //   801: getfield 1042	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   804: ldc_w 977
    //   807: aload_0
    //   808: invokevirtual 980	android/view/View:setTag	(ILjava/lang/Object;)V
    //   811: lconst_0
    //   812: lstore 6
    //   814: lload 6
    //   816: lstore 4
    //   818: aload 8
    //   820: getfield 973	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   823: ifnull +34 -> 857
    //   826: lload 6
    //   828: lstore 4
    //   830: aload 8
    //   832: getfield 973	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   835: getfield 986	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   838: invokevirtual 991	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   841: ifeq +16 -> 857
    //   844: aload 8
    //   846: getfield 973	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   849: getfield 986	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   852: invokevirtual 994	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   855: lstore 4
    //   857: aload_0
    //   858: getfield 1044	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   861: lload 4
    //   863: invokevirtual 1003	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setHeadImgByUin	(J)V
    //   866: aload_0
    //   867: getfield 1044	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   870: aload 8
    //   872: invokevirtual 1004	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(Ljava/lang/Object;)V
    //   875: aload_0
    //   876: getfield 1044	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   879: ldc_w 977
    //   882: aload_0
    //   883: invokevirtual 1005	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setTag	(ILjava/lang/Object;)V
    //   886: aload_0
    //   887: getfield 1044	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   890: bipush 10
    //   892: bipush 10
    //   894: bipush 10
    //   896: bipush 10
    //   898: invokestatic 1006	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem:a	(Landroid/view/View;IIII)V
    //   901: aload 8
    //   903: getfield 973	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPartnerAccountInfo	Ltencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo;
    //   906: getfield 1010	tencent/im/oidb/articlesummary/articlesummary$PartnerAccountInfo:bytes_v_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   909: invokestatic 1015	com/tencent/biz/pubaccount/readinjoy/protocol/RIJPBFieldUtils:b	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   912: astore_1
    //   913: aload_1
    //   914: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   917: ifne +21 -> 938
    //   920: new 224	java/net/URL
    //   923: dup
    //   924: aload_1
    //   925: invokespecial 332	java/net/URL:<init>	(Ljava/lang/String;)V
    //   928: astore_1
    //   929: aload_0
    //   930: getfield 1046	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   933: aload_1
    //   934: invokevirtual 415	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setImage	(Ljava/net/URL;)Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ZImageView;
    //   937: pop
    //   938: aload_0
    //   939: getfield 1048	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView;
    //   942: lload 4
    //   944: invokevirtual 1025	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyNickNameTextView:setNickNameByUin	(J)V
    //   947: aload_0
    //   948: getfield 1042	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   951: aload_3
    //   952: invokevirtual 866	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   955: aload_0
    //   956: getfield 1044	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;
    //   959: aload_3
    //   960: invokevirtual 1026	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   963: return
    //   964: aload 8
    //   966: getfield 100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   969: astore_1
    //   970: goto -706 -> 264
    //   973: astore_1
    //   974: invokestatic 661	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   977: ifeq -496 -> 481
    //   980: ldc_w 353
    //   983: iconst_2
    //   984: ldc_w 1050
    //   987: aload_1
    //   988: invokestatic 834	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   991: goto -510 -> 481
    //   994: aload_0
    //   995: getfield 975	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   998: bipush 8
    //   1000: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   1003: goto -497 -> 506
    //   1006: aload 8
    //   1008: getfield 100	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1011: astore_1
    //   1012: goto -307 -> 705
    //   1015: astore_1
    //   1016: invokestatic 661	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1019: ifeq -81 -> 938
    //   1022: ldc_w 353
    //   1025: iconst_2
    //   1026: ldc_w 1052
    //   1029: aload_1
    //   1030: invokestatic 834	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1033: goto -95 -> 938
    //   1036: aload_0
    //   1037: getfield 1042	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsTwoItemViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1040: bipush 8
    //   1042: invokevirtual 319	android/view/View:setVisibility	(I)V
    //   1045: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1046	0	paramVideoFeedsTwoItemViewHolder	com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsTwoItemViewHolder
    //   0	1046	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	1046	2	paramRIJDataManager	RIJDataManager
    //   0	1046	3	paramOnClickListener	View.OnClickListener
    //   371	572	4	l1	long
    //   812	15	6	l2	long
    //   75	932	8	localBaseArticleInfo	BaseArticleInfo
    //   225	481	9	localKandianUrlImageView	KandianUrlImageView
    //   247	461	10	localRIJDtParamBuilder	com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder
    // Exception table:
    //   from	to	target	type
    //   463	481	973	java/lang/Exception
    //   920	938	1015	java/lang/Exception
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener)
  {
    paramVideoFeedsViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = a(paramBaseArticleInfo);
    localVideoPlayParam.jdField_a_of_type_AndroidViewView = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    localVideoPlayParam.jdField_a_of_type_Int = paramVideoFeedsViewHolder.jdField_a_of_type_Int;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = localVideoPlayParam;
  }
  
  private static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (NetworkUtil.h(paramRIJDataManager.a().a()))
    {
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
    }
    do
    {
      return;
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      Object localObject = paramRIJDataManager.a().a().getResources().getDrawable(2130843379);
      paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(6.0F, paramRIJDataManager.a().a().getResources()));
      paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      if (CUKingCardHelper.a() == 1)
      {
        paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712819));
        paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
        paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
        return;
      }
      if ((!ReadInJoyHelper.y()) || (paramRIJDataManager.a().e()) || (paramVideoFeedsViewHolder.jdField_a_of_type_Int != 0)) {
        break;
      }
      String str1 = ReadInJoyHelper.f();
      String str2 = ReadInJoyHelper.g();
      String str3 = ReadInJoyHelper.h();
      if (!TextUtils.isEmpty(str1))
      {
        QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
        localObject = "";
        if (localQQAppInterface != null) {
          localObject = localQQAppInterface.getCurrentAccountUin();
        }
        paramBaseArticleInfo = new VideoR5.Builder(null, null, null, null).m((String)localObject).i(paramBaseArticleInfo.innerUniqueID).a().a();
        paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(2.0F, paramRIJDataManager.a().a().getResources()));
        localObject = paramRIJDataManager.a().a().getResources().getDrawable(2130843182);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.a(10.0F, paramRIJDataManager.a().a().getResources()), AIOUtils.a(10.0F, paramRIJDataManager.a().a().getResources()));
        paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().a(), paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView, str2, str3, str1, new RIJConfigVideoItem.1(paramBaseArticleInfo, paramVideoFeedsViewHolder));
        paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(1711276032);
        paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
        paramRIJDataManager.a().c(true);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramBaseArticleInfo, false);
        return;
      }
      paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
    return;
    paramVideoFeedsViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
    paramVideoFeedsViewHolder.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
  }
  
  /* Error */
  private static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: checkcast 1078	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 1079	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   13: iconst_0
    //   14: invokevirtual 351	android/widget/TextView:setVisibility	(I)V
    //   17: invokestatic 200	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/util/RIJAladdinUtils:l	()Z
    //   20: ifeq +309 -> 329
    //   23: aload_0
    //   24: getfield 1079	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   27: aconst_null
    //   28: invokestatic 1084	com/tencent/biz/pubaccount/readinjoy/common/ApiCompatibilityUtils:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   31: aload_0
    //   32: getfield 1079	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   35: ldc_w 1086
    //   38: invokestatic 425	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   41: invokevirtual 428	android/widget/TextView:setTextColor	(I)V
    //   44: aload_0
    //   45: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   48: ldc_w 1089
    //   51: invokestatic 425	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   54: invokevirtual 428	android/widget/TextView:setTextColor	(I)V
    //   57: aload_1
    //   58: getfield 672	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   61: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +291 -> 355
    //   67: aload_0
    //   68: getfield 1079	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   71: aload_1
    //   72: getfield 672	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   75: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   78: aload_0
    //   79: getfield 1092	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   82: iconst_0
    //   83: invokevirtual 1095	android/widget/LinearLayout:setVisibility	(I)V
    //   86: aload_1
    //   87: invokestatic 1099	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   90: ifeq +335 -> 425
    //   93: new 1101	org/json/JSONObject
    //   96: dup
    //   97: aload 5
    //   99: getfield 1104	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   102: invokespecial 1105	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   105: astore_1
    //   106: aload_2
    //   107: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   110: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   113: aload_1
    //   114: ldc_w 1107
    //   117: invokevirtual 1111	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: invokestatic 1116	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   123: ifeq +255 -> 378
    //   126: aload_0
    //   127: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   130: aload_2
    //   131: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   134: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   137: ldc_w 1117
    //   140: invokevirtual 1120	android/content/Context:getString	(I)Ljava/lang/String;
    //   143: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   146: iconst_1
    //   147: istore 4
    //   149: aload 5
    //   151: getfield 1123	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   154: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +20 -> 177
    //   160: iload 4
    //   162: ifne +15 -> 177
    //   165: aload_0
    //   166: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   169: aload 5
    //   171: getfield 1123	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   174: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   177: iload 4
    //   179: ifne +43 -> 222
    //   182: aload_0
    //   183: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   186: invokevirtual 1127	android/widget/TextView:getText	()Ljava/lang/CharSequence;
    //   189: aload_2
    //   190: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   193: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   196: ldc_w 1128
    //   199: invokevirtual 1120	android/content/Context:getString	(I)Ljava/lang/String;
    //   202: invokestatic 1134	com/huawei/hms/common/internal/Objects:equal	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   205: ifne +17 -> 222
    //   208: aload 5
    //   210: new 1136	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem$2
    //   213: dup
    //   214: aload_0
    //   215: aload_2
    //   216: invokespecial 1139	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJConfigVideoItem$2:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder;Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager;)V
    //   219: invokestatic 1144	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/AdDownloadStateQueryUtil:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Landroid/webkit/ValueCallback;)V
    //   222: new 1101	org/json/JSONObject
    //   225: dup
    //   226: aload 5
    //   228: getfield 1147	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   231: invokespecial 1105	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   234: astore_1
    //   235: aload_1
    //   236: ldc_w 1149
    //   239: invokevirtual 1111	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifne +17 -> 262
    //   248: aload_0
    //   249: getfield 1079	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   252: aload_1
    //   253: ldc_w 1149
    //   256: invokevirtual 1111	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   262: aload_0
    //   263: getfield 1151	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:jdField_e_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   266: aload_3
    //   267: invokevirtual 491	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   270: aload_0
    //   271: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   274: aload_3
    //   275: invokevirtual 1152	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   278: aload_0
    //   279: getfield 1079	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   282: aload_3
    //   283: invokevirtual 1152	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   286: aload_0
    //   287: getfield 1079	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   290: aload_0
    //   291: invokevirtual 816	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   294: aload_0
    //   295: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   298: aload_0
    //   299: invokevirtual 816	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   302: aload_0
    //   303: getfield 1151	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:jdField_e_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   306: aload_0
    //   307: invokevirtual 490	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   310: aload_0
    //   311: getfield 1155	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   314: bipush 8
    //   316: invokevirtual 1158	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   319: aload_0
    //   320: getfield 1160	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   323: bipush 8
    //   325: invokevirtual 1095	android/widget/LinearLayout:setVisibility	(I)V
    //   328: return
    //   329: aload_0
    //   330: getfield 1079	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   333: ldc_w 1162
    //   336: invokestatic 425	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   339: aload_2
    //   340: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   343: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   346: invokestatic 1167	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdUtils:a	(ILandroid/content/Context;)Landroid/graphics/drawable/ShapeDrawable;
    //   349: invokestatic 1084	com/tencent/biz/pubaccount/readinjoy/common/ApiCompatibilityUtils:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   352: goto -295 -> 57
    //   355: aload_0
    //   356: getfield 1079	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   359: aload_2
    //   360: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   363: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   366: ldc_w 1168
    //   369: invokevirtual 1120	android/content/Context:getString	(I)Ljava/lang/String;
    //   372: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   375: goto -297 -> 78
    //   378: aload_0
    //   379: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   382: aload_2
    //   383: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   386: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   389: ldc_w 1169
    //   392: invokevirtual 1120	android/content/Context:getString	(I)Ljava/lang/String;
    //   395: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   398: goto -249 -> 149
    //   401: astore_1
    //   402: aload_0
    //   403: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   406: aload_2
    //   407: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   410: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   413: ldc_w 1170
    //   416: invokevirtual 1120	android/content/Context:getString	(I)Ljava/lang/String;
    //   419: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   422: goto -273 -> 149
    //   425: aload 5
    //   427: getfield 1123	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   430: invokestatic 398	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   433: ifne +18 -> 451
    //   436: aload_0
    //   437: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   440: aload 5
    //   442: getfield 1123	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   445: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   448: goto -226 -> 222
    //   451: aload_0
    //   452: getfield 1087	com/tencent/biz/pubaccount/readinjoy/video/viewholder/VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   455: aload_2
    //   456: invokevirtual 457	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder;
    //   459: invokevirtual 461	com/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataManager$Builder:a	()Landroid/content/Context;
    //   462: ldc_w 1170
    //   465: invokevirtual 1120	android/content/Context:getString	(I)Ljava/lang/String;
    //   468: invokevirtual 407	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   471: goto -249 -> 222
    //   474: astore_1
    //   475: invokestatic 661	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq -216 -> 262
    //   481: ldc_w 353
    //   484: iconst_2
    //   485: ldc_w 1172
    //   488: aload_1
    //   489: invokestatic 834	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   492: goto -230 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	paramVideoFeedsViewHolder	VideoFeedsViewHolder
    //   0	495	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	495	2	paramRIJDataManager	RIJDataManager
    //   0	495	3	paramOnClickListener	View.OnClickListener
    //   1	177	4	i	int
    //   7	434	5	localAdvertisementInfo	AdvertisementInfo
    // Exception table:
    //   from	to	target	type
    //   93	146	401	org/json/JSONException
    //   378	398	401	org/json/JSONException
    //   222	262	474	org/json/JSONException
  }
  
  public static void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, Set<Long> paramSet)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    a(paramVideoFeedsViewHolder, paramBaseArticleInfo);
    VideoPlayManager.VideoPlayParam localVideoPlayParam = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramRIJDataManager.a().a().getResources().getColor(2131167374));
    if (paramBaseArticleInfo.mVideoPlayCount == 0)
    {
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_b_of_type_Int, true));
      a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramBaseArticleInfo, AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo));
      a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramBaseArticleInfo);
      paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setContentDescription(paramBaseArticleInfo.getSubscribeName());
      paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setContentDescription(paramBaseArticleInfo.getSubscribeName());
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewViewGroup.setTag(paramBaseArticleInfo);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewViewGroup.setTag(2131376634, paramVideoFeedsViewHolder);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(paramOnClickListener);
      if (TextUtils.isEmpty(paramBaseArticleInfo.vIconUrl)) {
        break label702;
      }
    }
    for (;;)
    {
      try
      {
        URL localURL = new URL(paramBaseArticleInfo.vIconUrl);
        paramVideoFeedsViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(localURL);
        paramVideoFeedsViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
          break label714;
        }
        a(paramVideoFeedsViewHolder, paramBaseArticleInfo, paramRIJDataManager, paramOnClickListener);
        VideoHandler.a(paramRIJDataManager.a().a(), paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
        a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramRIJDataManager.a().a());
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(paramOnClickListener);
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramVideoFeedsViewHolder);
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(localVideoPlayParam.jdField_c_of_type_Int, localVideoPlayParam.jdField_d_of_type_Int));
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setOnClickListener(paramOnClickListener);
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setTag(paramVideoFeedsViewHolder);
        if (paramRIJDataManager.a().a().b(paramRIJDataManager.a().b(), paramBaseArticleInfo.mArticleID)) {
          paramVideoFeedsViewHolder.jdField_g_of_type_AndroidViewView.setBackgroundColor(paramRIJDataManager.a().a().getResources().getColor(2131166917));
        }
        ReadInjoyFeedsUtils.a(paramRIJDataManager.a().a(), paramVideoFeedsViewHolder.jdField_b_of_type_AndroidViewViewGroup, paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout);
        if (!RIJAladdinUtils.l()) {
          break label832;
        }
        paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(DisplayUtil.a(paramRIJDataManager.a().a(), 5.0F));
        paramOnLongClickListener = paramRIJDataManager.a().a().getResources().getDrawable(2130843278);
        int i = DisplayUtil.a(paramRIJDataManager.a().a(), 17.0F);
        paramOnLongClickListener.setBounds(0, 0, i, i);
        paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramOnLongClickListener, null, null, null);
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setOnClickListener(paramOnClickListener);
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout.setTag(paramVideoFeedsViewHolder);
        VideoFeedsHelper.a(paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView, paramBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131712881));
        paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
        paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(paramVideoFeedsViewHolder);
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoFeedsViewHolder);
        if (paramBaseArticleInfo.mXGFileSize > 0L) {
          break label883;
        }
        paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712711));
        if ((AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) && (((AdvertisementInfo)paramBaseArticleInfo).mAdVideoFileSize >= 0L)) {
          paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.b(((AdvertisementInfo)paramBaseArticleInfo).mAdVideoFileSize) + HardCodeUtil.a(2131712967));
        }
        a(paramVideoFeedsViewHolder, paramBaseArticleInfo, paramRIJDataManager);
        a(paramVideoFeedsViewHolder, paramRIJDataManager, paramOnClickListener);
        return;
        paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(paramBaseArticleInfo.mVideoPlayCount) + HardCodeUtil.a(2131712883));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      label702:
      paramVideoFeedsViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      continue;
      label714:
      paramVideoFeedsViewHolder.h.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramBaseArticleInfo, paramRIJDataManager.a().a(), paramRIJDataManager.a().b(), paramSet);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnLongClickListener(paramOnLongClickListener);
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
      continue;
      label832:
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(DisplayUtil.a(paramRIJDataManager.a().a(), 0.0F));
      paramOnLongClickListener = paramRIJDataManager.a().a().getResources().getDrawable(2130843277);
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramOnLongClickListener, null, null, null);
      continue;
      label883:
      paramVideoFeedsViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.b(paramBaseArticleInfo.mXGFileSize) + HardCodeUtil.a(2131712967));
    }
  }
  
  public static void a(WeishiGridTwoItemViewHolder paramWeishiGridTwoItemViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    paramWeishiGridTwoItemViewHolder.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
    paramWeishiGridTwoItemViewHolder.jdField_g_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickListener);
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localBaseArticleInfo.mVideoPlayCount));
    paramBaseArticleInfo = paramRIJDataManager.a().a().getResources().getDrawable(2130843380);
    int i = ViewUtils.b(8.0F);
    paramBaseArticleInfo.setBounds(0, 0, i, i);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.b(3.0F));
    VideoFeedsHelper.a(paramWeishiGridTwoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131712708), "0");
    URL localURL = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, false, paramRIJDataManager.a().a());
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramWeishiGridTwoItemViewHolder);
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(paramOnClickListener);
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    VideoFeedsHelper.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramWeishiGridTwoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView);
    localBaseArticleInfo = paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramWeishiGridTwoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramWeishiGridTwoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramWeishiGridTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localBaseArticleInfo.mVideoPlayCount));
    paramWeishiGridTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBaseArticleInfo, null, null, null);
    paramWeishiGridTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.b(3.0F));
    VideoFeedsHelper.a(paramWeishiGridTwoItemViewHolder.jdField_g_of_type_AndroidWidgetTextView, localBaseArticleInfo.getCommentCount(), HardCodeUtil.a(2131712697), "0");
    paramBaseArticleInfo = localBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
    a(paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramBaseArticleInfo, false, paramRIJDataManager.a().a());
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramWeishiGridTwoItemViewHolder);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(paramOnClickListener);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnLongClickListener(paramOnLongClickListener);
    VideoFeedsHelper.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramWeishiGridTwoItemViewHolder.h);
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, ImageView paramImageView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, Context paramContext)
  {
    boolean bool;
    URL localURL;
    if ((paramBaseArticleInfo.isUseGif) && (NetworkUtil.h(paramContext)))
    {
      bool = true;
      paramBaseArticleInfo.isShowGif = bool;
      localURL = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
      if (!paramBaseArticleInfo.isShowGif) {
        break label96;
      }
      paramImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramBaseArticleInfo.gifCoverUrl, localURLDrawableOptions));
    }
    for (;;)
    {
      a(paramKandianUrlImageView, localURL, paramBoolean, paramContext);
      return;
      bool = false;
      break;
      label96:
      paramImageView.setVisibility(8);
    }
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, int paramInt1, int paramInt2, Context paramContext)
  {
    if ((paramKandianUrlImageView == null) || (paramInt2 <= 0)) {
      return;
    }
    double d = paramInt1 / paramInt2;
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    QLog.d("ReadInJoyBaseAdapter", 2, "configImage | whRate " + d + ", origin width " + localLayoutParams.width + " ,origin height " + localLayoutParams.height);
    localLayoutParams.height = Utils.dp2px(18.0D);
    localLayoutParams.width = ((int)(localLayoutParams.height * d));
    QLog.d("ReadInJoyBaseAdapter", 2, "configImage | whRate " + d + ", width " + localLayoutParams.width + " , height " + localLayoutParams.height);
    paramKandianUrlImageView.setLayoutParams(localLayoutParams);
    a(paramKandianUrlImageView, paramURL, false, paramContext);
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext)
  {
    a(paramKandianUrlImageView, paramURL, false, paramContext);
  }
  
  private static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Context paramContext)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, paramContext, paramBoolean);
  }
  
  private static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    if ((RIJFeedsType.f(paramBaseArticleInfo)) || ((paramBaseArticleInfo.busiType == 1) && (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))))
    {
      paramReadInJoyHeadImageView.setHeadImgByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = ImageUtil.c();
    localURLDrawableOptions.mFailedDrawable = ImageUtil.c();
    label179:
    label308:
    for (;;)
    {
      AdvertisementInfo localAdvertisementInfo;
      boolean bool;
      try
      {
        if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
          break label244;
        }
        localAdvertisementInfo = (AdvertisementInfo)paramBaseArticleInfo;
        bool = AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo);
        if (!bool) {
          break label215;
        }
      }
      catch (MalformedURLException paramReadInJoyHeadImageView) {}
      try
      {
        paramBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExt).getString("applogo");
        bool = TextUtils.isEmpty(paramBaseArticleInfo);
        if (!bool) {
          break label179;
        }
        paramBaseArticleInfo = null;
      }
      catch (JSONException paramBaseArticleInfo)
      {
        paramBaseArticleInfo = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "cannot get avatar from app advertisement");
        paramBaseArticleInfo = localObject;
        continue;
      }
      if (paramBaseArticleInfo == null)
      {
        paramReadInJoyHeadImageView.setImageDrawable(ImageUtil.c());
        paramReadInJoyHeadImageView.setVisibility(0);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "configVideoItemUI() ERROR e = " + paramReadInJoyHeadImageView.getMessage());
        return;
        paramBaseArticleInfo = new URL(paramBaseArticleInfo);
        continue;
        label215:
        paramBaseArticleInfo = localObject;
        if (TextUtils.isEmpty(localAdvertisementInfo.mAdCorporateLogo)) {
          continue;
        }
        paramBaseArticleInfo = new URL(localAdvertisementInfo.mAdCorporateLogo);
        continue;
        label244:
        if (TextUtils.isEmpty(paramBaseArticleInfo.thirdIcon))
        {
          paramBaseArticleInfo = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
          break label308;
        }
        paramBaseArticleInfo = new URL(paramBaseArticleInfo.thirdIcon);
        break label308;
      }
      paramBaseArticleInfo = URLDrawable.getDrawable(paramBaseArticleInfo, localURLDrawableOptions);
      paramBaseArticleInfo.setDecodeHandler(URLDrawableDecodeHandler.a);
      paramReadInJoyHeadImageView.setImageDrawable(paramBaseArticleInfo);
      paramReadInJoyHeadImageView.setVisibility(0);
      return;
    }
  }
  
  private static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (RIJFeedsType.f(paramBaseArticleInfo))
    {
      paramReadInJoyNickNameTextView.setNickNameByUin(paramBaseArticleInfo.getSubscribeUin());
      return;
    }
    if (paramBoolean)
    {
      paramReadInJoyNickNameTextView.setText(ReadInJoyAdUtils.a(paramBaseArticleInfo));
      return;
    }
    paramReadInJoyNickNameTextView.setText(ReadInJoyDisplayUtils.a(paramBaseArticleInfo.getSubscribeName(), 18));
  }
  
  private static void a(RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    if (RIJAladdinUtils.l())
    {
      paramRoundAngleFrameLayout.setRadius(28);
      return;
    }
    paramRoundAngleFrameLayout.setRadius(0);
  }
  
  private static void b(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (paramBaseArticleInfo.mXGFileSize <= 0L)
    {
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712965));
      if (!NetworkUtil.h(paramRIJDataManager.a().a())) {
        break label108;
      }
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    }
    label108:
    do
    {
      return;
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.b(paramBaseArticleInfo.mXGFileSize) + HardCodeUtil.a(2131712747));
      break;
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      Object localObject = paramRIJDataManager.a().a().getResources().getDrawable(2130843379);
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(6.0F, paramRIJDataManager.a().a().getResources()));
      paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      if (CUKingCardHelper.a() == 1)
      {
        paramVideoColumnItemViewHolder.jdField_g_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712961));
        paramVideoColumnItemViewHolder.h.setVisibility(8);
        paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
        return;
      }
      if ((!ReadInJoyHelper.y()) || (paramRIJDataManager.a().e()) || (paramVideoColumnItemViewHolder.jdField_a_of_type_Int != 0)) {
        break label542;
      }
      String str1 = ReadInJoyHelper.f();
      String str2 = ReadInJoyHelper.g();
      String str3 = ReadInJoyHelper.h();
      if (!TextUtils.isEmpty(str1))
      {
        QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
        localObject = "";
        if (localQQAppInterface != null) {
          localObject = localQQAppInterface.getCurrentAccountUin();
        }
        paramBaseArticleInfo = new VideoR5.Builder(null, null, null, null).m((String)localObject).i(paramBaseArticleInfo.innerUniqueID).a().a();
        paramVideoColumnItemViewHolder.h.setVisibility(0);
        paramVideoColumnItemViewHolder.h.setCompoundDrawablePadding(AIOUtils.a(2.0F, paramRIJDataManager.a().a().getResources()));
        localObject = paramRIJDataManager.a().a().getResources().getDrawable(2130843182);
        ((Drawable)localObject).setBounds(0, 0, AIOUtils.a(10.0F, paramRIJDataManager.a().a().getResources()), AIOUtils.a(10.0F, paramRIJDataManager.a().a().getResources()));
        paramVideoColumnItemViewHolder.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
        VideoFeedsHelper.b(paramRIJDataManager.a().a(), paramVideoColumnItemViewHolder.h, str2, str3, str1, new RIJConfigVideoItem.5(paramBaseArticleInfo));
        paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(1711276032);
        paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramRIJDataManager.a().c(true);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE1", "0X8009BE1", 0, 0, "", "", "", paramBaseArticleInfo, false);
        return;
      }
      paramVideoColumnItemViewHolder.h.setVisibility(8);
      paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "kingcard guideUrl is empty, so ignore");
    return;
    label542:
    paramVideoColumnItemViewHolder.h.setVisibility(8);
    paramVideoColumnItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramVideoColumnItemViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem
 * JD-Core Version:    0.7.0.1
 */