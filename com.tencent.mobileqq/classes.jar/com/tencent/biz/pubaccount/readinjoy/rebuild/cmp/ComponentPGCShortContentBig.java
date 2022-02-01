package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPredownloadManager;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.IMediaView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaVideoView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaViewFactory;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.PGCShortContentUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ComponentPGCShortContentBig
  extends ComponentContentBig
  implements View.OnClickListener
{
  public static int a;
  public static String a;
  private float jdField_a_of_type_Float;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private IMediaView jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 0;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 0;
  private int g;
  private int h = 0;
  
  static
  {
    jdField_a_of_type_Int = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
    jdField_a_of_type_JavaLangString = "";
  }
  
  public ComponentPGCShortContentBig(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public ComponentPGCShortContentBig(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentPGCShortContentBig(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.a != null) && (paramArticleInfo.mSocialFeedInfo.a.a.size() > 0))
    {
      localObject1 = (SocializeFeedsInfo.PGCPicInfo)paramArticleInfo.mSocialFeedInfo.a.a.get(0);
      if (TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject1).jdField_b_of_type_JavaLangString)) {}
    }
    for (Object localObject1 = ((SocializeFeedsInfo.PGCPicInfo)localObject1).jdField_b_of_type_JavaLangString;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if ((!TextUtils.isEmpty(paramArticleInfo.gifCoverUrl)) && (this.jdField_a_of_type_Boolean)) {
          localObject2 = paramArticleInfo.gifCoverUrl;
        }
      }
      else {
        return localObject2;
      }
      return paramArticleInfo.mFirstPagePicUrl;
    }
  }
  
  private String a(String paramString, int paramInt)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.contains("qpic.cn/qq_public"));
    return paramString.replaceAll("/\\d+($|\\?)", "/" + paramInt + "$1");
  }
  
  private String a(String paramString, int paramInt1, int paramInt2)
  {
    int k = 0;
    int j = 0;
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.contains("qpic.cn/qq_public")) {
        break label31;
      }
      localObject = paramString;
    }
    label31:
    int i;
    String str;
    double[] arrayOfDouble1;
    String[] arrayOfString1;
    double[] arrayOfDouble2;
    String[] arrayOfString2;
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = new int[5];
          Object tmp38_36 = localObject;
          tmp38_36[0] = '´';
          Object tmp44_38 = tmp38_36;
          tmp44_38[1] = 'È';
          Object tmp50_44 = tmp44_38;
          tmp50_44[2] = 320;
          Object tmp56_50 = tmp50_44;
          tmp56_50[3] = 600;
          Object tmp62_56 = tmp56_50;
          tmp62_56[4] = 900;
          tmp62_56;
          i = 0;
          str = paramString;
          if (i < localObject.length)
          {
            if (paramInt1 - 20 > localObject[i]) {
              break label595;
            }
            str = a(paramString, localObject[i]);
          }
          arrayOfDouble1 = new double[15];
          double[] tmp115_113 = arrayOfDouble1;
          tmp115_113[0] = 0.62105D;
          double[] tmp121_115 = tmp115_113;
          tmp121_115[1] = 0.83158D;
          double[] tmp127_121 = tmp121_115;
          tmp127_121[2] = 0.93684D;
          double[] tmp133_127 = tmp127_121;
          tmp133_127[3] = 1.0D;
          double[] tmp137_133 = tmp133_127;
          tmp137_133[4] = 1.1049D;
          double[] tmp143_137 = tmp137_133;
          tmp143_137[5] = 1.11579D;
          double[] tmp149_143 = tmp143_137;
          tmp149_143[6] = 1.24476D;
          double[] tmp156_149 = tmp149_143;
          tmp156_149[7] = 1.25263D;
          double[] tmp163_156 = tmp156_149;
          tmp163_156[8] = 1.30526D;
          double[] tmp170_163 = tmp163_156;
          tmp170_163[9] = 1.66434D;
          double[] tmp177_170 = tmp170_163;
          tmp177_170[10] = 1.67368D;
          double[] tmp184_177 = tmp177_170;
          tmp184_177[11] = 1.80723D;
          double[] tmp191_184 = tmp184_177;
          tmp191_184[12] = 1.88421D;
          double[] tmp198_191 = tmp191_184;
          tmp198_191[13] = 2.5035D;
          double[] tmp205_198 = tmp198_191;
          tmp205_198[14] = 2.51579D;
          tmp205_198;
          arrayOfString1 = new String[15];
          arrayOfString1[0] = "59_95";
          arrayOfString1[1] = "79_95";
          arrayOfString1[2] = "89_95";
          arrayOfString1[3] = "280_280";
          arrayOfString1[4] = "158_143";
          arrayOfString1[5] = "212_190";
          arrayOfString1[6] = "178_143";
          arrayOfString1[7] = "119_95";
          arrayOfString1[8] = "248_190";
          arrayOfString1[9] = "238_143";
          arrayOfString1[10] = "159_95";
          arrayOfString1[11] = "750_415";
          arrayOfString1[12] = "179_95";
          arrayOfString1[13] = "358_143";
          arrayOfString1[14] = "239_95";
          arrayOfDouble2 = new double[5];
          double[] tmp326_324 = arrayOfDouble2;
          tmp326_324[0] = 0.5625D;
          double[] tmp332_326 = tmp326_324;
          tmp332_326[1] = 0.75D;
          double[] tmp338_332 = tmp332_326;
          tmp338_332[2] = 1.0D;
          double[] tmp342_338 = tmp338_332;
          tmp342_338[3] = 1.33333D;
          double[] tmp348_342 = tmp342_338;
          tmp348_342[4] = 1.77777D;
          tmp348_342;
          arrayOfString2 = new String[5];
          arrayOfString2[0] = "90_160";
          arrayOfString2[1] = "30_40";
          arrayOfString2[2] = "280_280";
          arrayOfString2[3] = "40_30";
          arrayOfString2[4] = "160_90";
          if (str.contains("_open")) {
            break;
          }
          localObject = str;
        } while (!str.contains("_vsmcut"));
        localObject = str;
      } while (str.contains("_open_"));
      localObject = str;
    } while (str.contains("_vsmcut_"));
    double d1 = paramInt1 / paramInt2;
    paramString = "";
    if (str.contains("_open"))
    {
      if (d1 < arrayOfDouble1[0]) {
        paramString = arrayOfString1[0];
      }
      paramInt1 = j;
      if (d1 > arrayOfDouble1[(arrayOfDouble1.length - 1)])
      {
        paramString = arrayOfString1[(arrayOfString1.length - 1)];
        paramInt1 = j;
      }
      for (;;)
      {
        localObject = paramString;
        if (paramInt1 < arrayOfDouble1.length - 1)
        {
          if ((d1 < arrayOfDouble1[paramInt1]) || (d1 >= arrayOfDouble1[(paramInt1 + 1)])) {
            break label615;
          }
          if (d1 - arrayOfDouble1[paramInt1] >= arrayOfDouble1[(paramInt1 + 1)] - d1) {
            break label604;
          }
        }
        label595:
        label604:
        for (localObject = arrayOfString1[paramInt1];; localObject = arrayOfString1[(paramInt1 + 1)])
        {
          return str.replace("_open", "_open_" + (String)localObject);
          i += 1;
          break;
        }
        label615:
        paramInt1 += 1;
      }
    }
    if (d1 < arrayOfDouble2[0]) {
      paramString = arrayOfString2[0];
    }
    paramInt1 = k;
    if (d1 > arrayOfDouble2[(arrayOfDouble2.length - 1)])
    {
      paramString = arrayOfString2[(arrayOfString2.length - 1)];
      paramInt1 = k;
    }
    for (;;)
    {
      localObject = paramString;
      if (paramInt1 < arrayOfDouble2.length - 1)
      {
        if ((d1 < arrayOfDouble2[paramInt1]) || (d1 >= arrayOfDouble2[(paramInt1 + 1)])) {
          break label765;
        }
        if (d1 - arrayOfDouble2[paramInt1] >= arrayOfDouble2[(paramInt1 + 1)] - d1) {
          break label754;
        }
      }
      label754:
      for (localObject = arrayOfString2[paramInt1];; localObject = arrayOfString2[(paramInt1 + 1)]) {
        return str.replace("_vsmcut", "_vsmcut_" + (String)localObject);
      }
      label765:
      paramInt1 += 1;
    }
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramFloat1 /= paramFloat2;
    if (paramFloat1 < 0.667D)
    {
      paramLayoutParams.width = (paramInt * 2 / 3);
      paramLayoutParams.height = paramInt;
      b(HardCodeUtil.a(2131702403));
      return;
    }
    if ((0.667D <= paramFloat1) && (paramFloat1 <= 1.5D))
    {
      paramLayoutParams.width = ((int)(paramFloat1 * paramInt));
      paramLayoutParams.height = paramInt;
      b("");
      return;
    }
    paramLayoutParams.width = ((int)(paramInt * 1.5D));
    paramLayoutParams.height = paramInt;
    b(HardCodeUtil.a(2131702403));
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramFloat1 /= paramFloat2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
    {
      if (paramFloat1 >= 0.455D) {
        break label81;
      }
      paramLayoutParams.width = paramInt2;
      paramLayoutParams.height = paramInt1;
      localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
      if (!this.jdField_a_of_type_Boolean) {
        break label70;
      }
    }
    label70:
    for (paramLayoutParams = HardCodeUtil.a(2131702348);; paramLayoutParams = HardCodeUtil.a(2131702388))
    {
      localKanDianRoundCornerTextView.setText(paramLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      return;
    }
    label81:
    if ((0.455D <= paramFloat1) && (paramFloat1 <= 0.7441D))
    {
      paramLayoutParams.width = paramInt2;
      paramLayoutParams.height = paramInt1;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702320));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
      return;
    }
    if ((0.7441D <= paramFloat1) && (paramFloat1 <= 1.3439D))
    {
      paramLayoutParams.width = paramInt1;
      paramLayoutParams.height = paramInt1;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702325));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
      return;
    }
    if ((1.3439D <= paramFloat1) && (paramFloat1 <= 2.2D))
    {
      paramLayoutParams.width = paramInt1;
      paramLayoutParams.height = paramInt2;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702310));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
      return;
    }
    paramLayoutParams.width = paramInt1;
    paramLayoutParams.height = paramInt2;
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramLayoutParams = HardCodeUtil.a(2131702326);; paramLayoutParams = HardCodeUtil.a(2131702333))
    {
      localKanDianRoundCornerTextView.setText(paramLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      return;
    }
  }
  
  private void a(int paramInt, SocializeFeedsInfo.PGCPicInfo paramPGCPicInfo)
  {
    if ((paramInt != this.jdField_d_of_type_Int) || (this.jdField_f_of_type_Int == 0))
    {
      if ((paramInt != this.jdField_d_of_type_Int) || (!a(paramPGCPicInfo)))
      {
        QLog.d("ComponentPGCShortContentBig", 2, "recreate video");
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView != null)
        {
          QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "reset destroy");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.d();
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView = MediaViewFactory.a(paramInt, BaseApplicationImpl.getContext());
        if (paramInt == 1)
        {
          ((VideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).setUseVid(false);
          ((VideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).setShowVideoMask(false);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView instanceof View))
        {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
          if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams == null) {
            this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, -2);
          }
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
        }
        this.jdField_d_of_type_Int = paramInt;
      }
    }
    else {
      return;
    }
    QLog.d("ComponentPGCShortContentBig", 1, "reuse video");
  }
  
  private void a(SocializeFeedsInfo.PGCVideoInfo paramPGCVideoInfo)
  {
    if ((paramPGCVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.setMediaPlayVid(paramPGCVideoInfo.e);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.setMediaPlayUrl(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.setMediaCoverUrl(paramPGCVideoInfo.d);
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "set url " + null);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView instanceof MediaVideoView))
      {
        VideoUrlInfo localVideoUrlInfo = ThirdVideoManager.a(paramPGCVideoInfo.e);
        if ((localVideoUrlInfo == null) || (!localVideoUrlInfo.a(System.currentTimeMillis() / 1000L, 3600L))) {
          break label132;
        }
        a(localVideoUrlInfo.jdField_a_of_type_JavaLangString);
        QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "url hit");
      }
    }
    return;
    label132:
    QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "request url by vid " + paramPGCVideoInfo.e);
    paramPGCVideoInfo = new ComponentPGCShortContentBig.1(this, paramPGCVideoInfo);
    ThreadManager.getFileThreadHandler().post(new ComponentPGCShortContentBig.2(this, paramPGCVideoInfo));
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView instanceof VideoView)))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "set url " + paramString);
      VideoPredownloadManager.a(paramString);
      ((MediaVideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).setVideoUrl(paramString);
      if (b()) {
        ((MediaVideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).openVideo();
      }
      if (VideoPredownloadManager.a(paramString)) {
        QLog.d("ComponentPGCShortContentBig", 2, "preload cache hit");
      }
      if (((MediaVideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).getAction() == 3) {
        ((MediaVideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).startPlay();
      }
    }
  }
  
  private boolean a(SocializeFeedsInfo.PGCPicInfo paramPGCPicInfo)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView instanceof VideoView))
    {
      VideoView localVideoView = (VideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView;
      return (paramPGCPicInfo != null) && (paramPGCPicInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo != null) && (paramPGCPicInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.e != null) && (paramPGCPicInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.e.equals(localVideoView.getVideoVid()));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView instanceof GifView))
    {
      if (!((GifView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).isPlaying()) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  private void b(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel != null)
    {
      paramIReadInJoyModel = paramIReadInJoyModel.a();
      if (paramIReadInJoyModel != null)
      {
        if ((paramIReadInJoyModel.mSocialFeedInfo == null) || (paramIReadInJoyModel.mSocialFeedInfo.a == null) || (paramIReadInJoyModel.mSocialFeedInfo.a.a == null) || (paramIReadInJoyModel.mSocialFeedInfo.a.a.size() <= 0)) {
          break label142;
        }
        paramIReadInJoyModel = (SocializeFeedsInfo.PGCPicInfo)paramIReadInJoyModel.mSocialFeedInfo.a.a.get(0);
        if ((paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo == null) || (this.jdField_e_of_type_Int != 1)) {
          break label129;
        }
        a(1, paramIReadInJoyModel);
        a(paramIReadInJoyModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      ((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).setVisibility(0);
      return;
      label129:
      a(0, paramIReadInJoyModel);
      j();
      continue;
      label142:
      j();
    }
  }
  
  private void b(String paramString)
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702323));
      return;
    }
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      localKanDianRoundCornerTextView.setVisibility(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(paramString);
      return;
      i = 4;
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView instanceof VideoView))
    {
      int i = ((VideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).getCurrentState();
      return (i != 5) && (i != 7) && (i != 6);
    }
    return false;
  }
  
  private boolean c()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Float == 0.0F) || (this.jdField_b_of_type_Float == 0.0F) || (this.jdField_c_of_type_Float == 0.0F) || (this.jdField_d_of_type_Float == 0.0F) || (this.jdField_e_of_type_Float == 0.0F) || (this.jdField_f_of_type_Float == 0.0F) || (this.h == 0)) {
      return false;
    }
    long l;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null)) {
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mChannelID;
    }
    while (this.h == 1) {
      if ((l == 0L) || (l == DailyModeConfigHandler.b()))
      {
        return true;
        l = -1L;
      }
      else
      {
        return false;
      }
    }
    if (this.h == 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void f()
  {
    jdField_a_of_type_Int = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
  }
  
  private void g()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.g = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    h();
    i();
  }
  
  private void h()
  {
    this.jdField_e_of_type_Int = Aladdin.getConfig(205).getIntegerFromString("shortcontent_gif_video_type", 0);
    this.jdField_f_of_type_Int = Aladdin.getConfig(212).getIntegerFromString("shortcontent_video_reuse", 0);
  }
  
  private void i()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(269);
    if (localAladdinConfig != null)
    {
      jdField_a_of_type_JavaLangString = localAladdinConfig.getString("shortcontent_report_key", "");
      this.jdField_a_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_x_multipler", 0.0F);
      this.jdField_b_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_divisor", 0.0F);
      this.jdField_c_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_long_multiplier", 0.0F);
      this.jdField_d_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_width_multiplier", 0.0F);
      this.jdField_e_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_long_ratio", 0.0F);
      this.jdField_f_of_type_Float = localAladdinConfig.getFloatFromString("shortcontent_width_ratio", 0.0F);
      this.h = localAladdinConfig.getIntegerFromString("shortcontent_channel", 0);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView != null)
    {
      String str1 = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a).toString();
      String str2 = a(str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getMeasuredWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getMeasuredHeight());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.setMediaCoverUrl(str2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.setMediaPlayUrl(str1);
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a == null)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a.a != null)) {}
    for (ArrayList localArrayList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.a.a;; localArrayList = null)
    {
      this.jdField_a_of_type_Boolean = false;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.jdField_b_of_type_Int = ((SocializeFeedsInfo.PGCPicInfo)localArrayList.get(0)).jdField_a_of_type_Int;
        this.jdField_c_of_type_Int = ((SocializeFeedsInfo.PGCPicInfo)localArrayList.get(0)).jdField_b_of_type_Int;
        if (((SocializeFeedsInfo.PGCPicInfo)localArrayList.get(0)).jdField_c_of_type_Int == 1)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a().a().isShowGif = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
          if (!c()) {
            break label438;
          }
          QLog.d("ComponentPGCShortContentBig", 2, "configOptimizedImageLayoutParams");
          l();
        }
      }
      for (;;)
      {
        QLog.d("ComponentPGCSingleImage", 2, "imageParams.width is " + this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width + "; imageParams.height is " + this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setPadding(0, 0, 0, 0);
        ((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
        ((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).setPadding(0, 0, 0, 0);
        return;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().isUseGif) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ComponentPGCShortContentBig", 2, "pgc pic info is null");
        }
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().isUseGif) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        break;
        label438:
        QLog.d("ComponentPGCShortContentBig", 2, "configDefaultdImageLayoutParams");
        m();
      }
    }
  }
  
  private void l()
  {
    int i = AIOUtils.a(12.0F, getResources());
    int j = AIOUtils.a(4.5F, getResources());
    i = (int)((this.g - (i * this.jdField_a_of_type_Float + j)) / this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = i;
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width = i;
      b("");
    }
    float f1;
    do
    {
      return;
      f1 = this.jdField_c_of_type_Int / this.jdField_b_of_type_Int;
      if ((f1 >= this.jdField_f_of_type_Float) && (f1 <= this.jdField_e_of_type_Float))
      {
        this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width = ((int)(i / f1));
        b("");
        return;
      }
      if (f1 > this.jdField_e_of_type_Float)
      {
        this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width = ((int)(i * this.jdField_c_of_type_Float));
        b(HardCodeUtil.a(2131702403));
        return;
      }
    } while (f1 >= this.jdField_f_of_type_Float);
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width = ((int)(i * this.jdField_d_of_type_Float));
    b(HardCodeUtil.a(2131702403));
  }
  
  private void m()
  {
    int j = AIOUtils.a(12.0F, getResources());
    int k = AIOUtils.a(4.5F, getResources());
    int i = (this.g - (j * 2 + k * 2)) / 3 * 2 + k;
    j = (this.g - (j * 2 + k)) / 2;
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_c_of_type_Int == 0))
    {
      this.jdField_c_of_type_Int = i;
      this.jdField_b_of_type_Int = i;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mChannelID == 0L)
    {
      a(ReadInJoyDisplayUtils.a(this.g, getResources()), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      return;
    }
    a(i, j, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
  
  private void n()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() == null)) {
      return;
    }
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    String str2 = a(localArticleInfo);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.contains("https")) {
        str1 = str2.replaceFirst("https", "http");
      }
    }
    localArrayList.add(str1);
    if ((jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Boolean)) {
      if (this.jdField_b_of_type_Boolean) {
        if (Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 0) {
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a() != null)) {
            TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("ComponentPGCShortContentBig", 1, "[showPicture] isGif " + this.jdField_a_of_type_Boolean + ", urls : " + localArrayList);
      try
      {
        localArticleInfo.clickArea = 9;
        RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentPGCShortContentBig", 2, localNullPointerException.getLocalizedMessage());
        return;
      }
      o();
      continue;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.a();
      }
      this.jdField_b_of_type_Boolean = true;
      continue;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a() != null)) {
        TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
      }
    }
  }
  
  private void o()
  {
    Context localContext = getContext();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null)) {}
    for (ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();; localArticleInfo = null)
    {
      PGCShortContentUtils.a(localContext, localArticleInfo);
      return;
    }
  }
  
  protected int a()
  {
    return 9;
  }
  
  protected URL a(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    try
    {
      if (!TextUtils.isEmpty(a(paramIReadInJoyModel))) {
        return new URL(a(paramIReadInJoyModel));
      }
      URL localURL = paramIReadInJoyModel.mSinglePicture;
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      QLog.e("ComponentPGCShortContentBig", 1, localMalformedURLException.getMessage());
    }
    return paramIReadInJoyModel.mSinglePicture;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367102));
    this.jdField_d_of_type_Int = -1;
    a(0, null);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean) {
      b(paramIReadInJoyModel);
    }
    for (;;)
    {
      ((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).setClickable(true);
      ((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).setOnClickListener(this);
      return;
      ((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).setVisibility(8);
      paramIReadInJoyModel = a(paramIReadInJoyModel);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setClickable(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
      }
      PGCShortContentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, getContext(), this.jdField_a_of_type_JavaNetURL, paramIReadInJoyModel, new ComponentPGCShortContentBig.3(this, paramIReadInJoyModel));
    }
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel, ArticleInfo paramArticleInfo) {}
  
  public void a(Object paramObject)
  {
    f();
    super.a(paramObject);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.isPlaying())
        {
          bool1 = bool2;
          if (jdField_a_of_type_Int == 3)
          {
            if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView instanceof VideoView)) {
              break label66;
            }
            bool1 = ((VideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView).startPlay();
          }
        }
      }
    }
    return bool1;
    label66:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.a();
    return false;
  }
  
  protected int b()
  {
    return 2131560242;
  }
  
  public void b()
  {
    k();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.b();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.c();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView != null) && (this.jdField_a_of_type_Boolean))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "destroy play");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoWrappersMediaIMediaView.d();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 0) || (jdField_a_of_type_Int == 2)) {
      n();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().clickArea = a();
        o();
        RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a().getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a(), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mChannelID);
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentPGCShortContentBig", 2, localNullPointerException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig
 * JD-Core Version:    0.7.0.1
 */