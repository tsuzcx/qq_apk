package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actn;
import ajyc;
import android.app.Activity;
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
import badh;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaVideoView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import omu;
import onk;
import onx;
import ood;
import oxa;
import oxu;
import oxv;
import pax;
import pju;
import pvb;
import pye;
import qcy;
import qcz;
import qda;
import rap;

public class ComponentPGCShortContentBig
  extends ComponentContentBig
  implements View.OnClickListener
{
  public static int a;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private final String jdField_a_of_type_JavaLangString = "ComponentPGCShortContentBig";
  private oxu jdField_a_of_type_Oxu;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  
  static
  {
    jdField_a_of_type_Int = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
  }
  
  public ComponentPGCShortContentBig(Context paramContext)
  {
    super(paramContext);
    this.e = Aladdin.getConfig(205).getIntegerFromString("shortcontent_gif_video_type", 0);
    this.f = Aladdin.getConfig(212).getIntegerFromString("shortcontent_video_reuse", 0);
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
      localObject1 = (qcz)paramArticleInfo.mSocialFeedInfo.a.a.get(0);
      if (TextUtils.isEmpty(((qcz)localObject1).jdField_b_of_type_JavaLangString)) {}
    }
    for (Object localObject1 = ((qcz)localObject1).jdField_b_of_type_JavaLangString;; localObject1 = "")
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
      localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
      if (this.jdField_a_of_type_Boolean) {}
      for (paramLayoutParams = ajyc.a(2131702260);; paramLayoutParams = ajyc.a(2131702340))
      {
        localKanDianRoundCornerTextView.setText(paramLayoutParams);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        return;
      }
    }
    if ((0.667D <= paramFloat1) && (paramFloat1 <= 1.5D))
    {
      paramLayoutParams.width = ((int)(paramFloat1 * paramInt));
      paramLayoutParams.height = paramInt;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(ajyc.a(2131702305));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
      return;
    }
    paramLayoutParams.width = ((int)(paramInt * 1.5D));
    paramLayoutParams.height = paramInt;
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramLayoutParams = ajyc.a(2131702328);; paramLayoutParams = ajyc.a(2131702301))
    {
      localKanDianRoundCornerTextView.setText(paramLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      return;
    }
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
    for (paramLayoutParams = ajyc.a(2131702285);; paramLayoutParams = ajyc.a(2131702325))
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(ajyc.a(2131702257));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(ajyc.a(2131702262));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(ajyc.a(2131702247));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
      return;
    }
    paramLayoutParams.width = paramInt1;
    paramLayoutParams.height = paramInt2;
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramLayoutParams = ajyc.a(2131702263);; paramLayoutParams = ajyc.a(2131702270))
    {
      localKanDianRoundCornerTextView.setText(paramLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      return;
    }
  }
  
  private void a(int paramInt, qcz paramqcz)
  {
    if ((paramInt != this.d) || (this.f == 0))
    {
      if ((paramInt != this.d) || (!a(paramqcz)))
      {
        QLog.d("ComponentPGCShortContentBig", 2, "recreate video");
        if (this.jdField_a_of_type_Oxu != null)
        {
          QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "reset destroy");
          this.jdField_a_of_type_Oxu.d();
        }
        this.jdField_a_of_type_Oxu = oxv.a(paramInt, BaseApplicationImpl.getContext());
        if (paramInt == 1) {
          ((VideoView)this.jdField_a_of_type_Oxu).setUseVid(false);
        }
        if ((this.jdField_a_of_type_Oxu instanceof View))
        {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
          if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams == null) {
            this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, -2);
          }
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)this.jdField_a_of_type_Oxu, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
        }
        this.d = paramInt;
      }
    }
    else {
      return;
    }
    QLog.d("ComponentPGCShortContentBig", 1, "reuse video");
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_Oxu != null) && ((this.jdField_a_of_type_Oxu instanceof VideoView)))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "set url " + paramString);
      oxa.a(paramString);
      ((MediaVideoView)this.jdField_a_of_type_Oxu).setVideoUrl(paramString);
      if (b()) {
        ((MediaVideoView)this.jdField_a_of_type_Oxu).E_();
      }
      if (oxa.a(paramString)) {
        QLog.d("ComponentPGCShortContentBig", 2, "preload cache hit");
      }
      if (((MediaVideoView)this.jdField_a_of_type_Oxu).b() == 3) {
        ((MediaVideoView)this.jdField_a_of_type_Oxu).b();
      }
    }
  }
  
  private void a(qda paramqda)
  {
    if ((paramqda != null) && (this.jdField_a_of_type_Oxu != null))
    {
      this.jdField_a_of_type_Oxu.setMediaPlayVid(paramqda.e);
      this.jdField_a_of_type_Oxu.setMediaPlayUrl(null);
      this.jdField_a_of_type_Oxu.setMediaCoverUrl(paramqda.d);
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "set url " + null);
      if ((this.jdField_a_of_type_Oxu instanceof MediaVideoView))
      {
        ood localood = onx.a(paramqda.e);
        if ((localood == null) || (!localood.a(System.currentTimeMillis() / 1000L, 3600L))) {
          break label132;
        }
        a(localood.jdField_a_of_type_JavaLangString);
        QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "url hit");
      }
    }
    return;
    label132:
    QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "request url by vid " + paramqda.e);
    paramqda = new pye(this, paramqda);
    ThreadManager.getFileThreadHandler().post(new ComponentPGCShortContentBig.2(this, paramqda));
  }
  
  private boolean a(qcz paramqcz)
  {
    if ((this.jdField_a_of_type_Oxu instanceof VideoView))
    {
      VideoView localVideoView = (VideoView)this.jdField_a_of_type_Oxu;
      return (paramqcz != null) && (paramqcz.jdField_a_of_type_Qda != null) && (paramqcz.jdField_a_of_type_Qda.e != null) && (paramqcz.jdField_a_of_type_Qda.e.equals(localVideoView.a()));
    }
    if ((this.jdField_a_of_type_Oxu instanceof GifView)) {
      return !((GifView)this.jdField_a_of_type_Oxu).a();
    }
    return false;
  }
  
  private void b(pax parampax)
  {
    if (parampax != null)
    {
      parampax = parampax.a();
      if (parampax != null)
      {
        if ((parampax.mSocialFeedInfo == null) || (parampax.mSocialFeedInfo.a == null) || (parampax.mSocialFeedInfo.a.a == null) || (parampax.mSocialFeedInfo.a.a.size() <= 0)) {
          break label142;
        }
        parampax = (qcz)parampax.mSocialFeedInfo.a.a.get(0);
        if ((parampax.jdField_a_of_type_Qda == null) || (this.e != 1)) {
          break label129;
        }
        a(1, parampax);
        a(parampax.jdField_a_of_type_Qda);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      ((View)this.jdField_a_of_type_Oxu).setVisibility(0);
      return;
      label129:
      a(0, parampax);
      g();
      continue;
      label142:
      g();
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Oxu instanceof VideoView))
    {
      int i = ((VideoView)this.jdField_a_of_type_Oxu).a();
      return (i != 5) && (i != 7) && (i != 6);
    }
    return false;
  }
  
  public static void f()
  {
    jdField_a_of_type_Int = Aladdin.getConfig(174).getIntegerFromString("gif_playmode", 1);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Oxu != null)
    {
      String str1 = a(this.jdField_a_of_type_Pvb.a).toString();
      String str2 = a(str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getMeasuredWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getMeasuredHeight());
      this.jdField_a_of_type_Oxu.setMediaCoverUrl(str2);
      this.jdField_a_of_type_Oxu.setMediaPlayUrl(str1);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Pvb == null) || (this.jdField_a_of_type_Pvb.a == null)) {
      return;
    }
    Object localObject = getResources().getDisplayMetrics();
    int m = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int i = actn.a(12.0F, getResources());
    int k = actn.a(4.5F, getResources());
    int j = (m - (i * 2 + k * 2)) / 3 * 2 + k;
    k = (m - (i * 2 + k)) / 2;
    this.jdField_b_of_type_Int = j;
    this.c = j;
    if ((this.jdField_a_of_type_Pvb != null) && (this.jdField_a_of_type_Pvb.a != null) && (this.jdField_a_of_type_Pvb.a.a() != null) && (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.a != null) && (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.a.a != null)) {}
    for (localObject = this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.a.a;; localObject = null)
    {
      this.jdField_a_of_type_Boolean = false;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        if (((qcz)((List)localObject).get(0)).jdField_a_of_type_Int > 0)
        {
          i = ((qcz)((List)localObject).get(0)).jdField_a_of_type_Int;
          this.jdField_b_of_type_Int = i;
          if (((qcz)((List)localObject).get(0)).jdField_b_of_type_Int <= 0) {
            break label529;
          }
          i = ((qcz)((List)localObject).get(0)).jdField_b_of_type_Int;
          label309:
          this.c = i;
          if (((qcz)((List)localObject).get(0)).c != 1) {
            break label534;
          }
          this.jdField_a_of_type_Boolean = true;
          label337:
          this.jdField_a_of_type_Pvb.a().a().isShowGif = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
          if (this.jdField_a_of_type_Pvb.a.a().mChannelID != 0L) {
            break label601;
          }
          a(omu.a(m, getResources()), this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
        }
      }
      for (;;)
      {
        QLog.d("ComponentPGCSingleImage", 2, "imageParams.width is " + this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width + "; imageParams.height is " + this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setPadding(0, 0, 0, 0);
        ((View)this.jdField_a_of_type_Oxu).setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
        ((View)this.jdField_a_of_type_Oxu).setPadding(0, 0, 0, 0);
        return;
        i = j;
        break;
        label529:
        i = k;
        break label309;
        label534:
        if (!this.jdField_a_of_type_Pvb.a.a().isUseGif) {
          break label337;
        }
        this.jdField_a_of_type_Boolean = true;
        break label337;
        if (QLog.isColorLevel()) {
          QLog.d("ComponentPGCShortContentBig", 2, "pgc pic info is null");
        }
        if (!this.jdField_a_of_type_Pvb.a.a().isUseGif) {
          break label337;
        }
        this.jdField_a_of_type_Boolean = true;
        break label337;
        label601:
        a(j, k, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      }
    }
  }
  
  private void i()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Pvb == null) || (this.jdField_a_of_type_Pvb.a == null) || (this.jdField_a_of_type_Pvb.a.a() == null)) {
      return;
    }
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvb.a.a();
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
          badh.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
        }
      }
    }
    for (;;)
    {
      QLog.d("ComponentPGCShortContentBig", 1, "[showPicture] isGif " + this.jdField_a_of_type_Boolean + ", urls : " + localArrayList);
      try
      {
        localArticleInfo.click_area = 9;
        onk.b(this.jdField_a_of_type_Pvb.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentPGCShortContentBig", 2, localNullPointerException.getLocalizedMessage());
        return;
      }
      j();
      continue;
      if (this.jdField_a_of_type_Oxu != null) {
        this.jdField_a_of_type_Oxu.B_();
      }
      this.jdField_b_of_type_Boolean = true;
      continue;
      badh.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
    }
  }
  
  private void j()
  {
    Context localContext = getContext();
    if ((this.jdField_a_of_type_Pvb != null) && (this.jdField_a_of_type_Pvb.a != null)) {}
    for (ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvb.a.a();; localArticleInfo = null)
    {
      pju.a(localContext, localArticleInfo);
      return;
    }
  }
  
  protected int a()
  {
    return 9;
  }
  
  protected URL a(pax parampax)
  {
    parampax = parampax.a();
    try
    {
      if (!TextUtils.isEmpty(a(parampax))) {
        return new URL(a(parampax));
      }
      URL localURL = parampax.mSinglePicture;
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
    return parampax.mSinglePicture;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366347));
    this.d = -1;
    a(0, null);
  }
  
  public void a(Object paramObject)
  {
    f();
    super.a(paramObject);
  }
  
  protected void a(pax parampax)
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean) {
      b(parampax);
    }
    for (;;)
    {
      ((View)this.jdField_a_of_type_Oxu).setClickable(true);
      ((View)this.jdField_a_of_type_Oxu).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
      return;
      ((View)this.jdField_a_of_type_Oxu).setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      omu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, a(parampax), getContext());
    }
  }
  
  protected void a(pax parampax, ArticleInfo paramArticleInfo) {}
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Oxu != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Oxu.a())
        {
          bool1 = bool2;
          if (jdField_a_of_type_Int == 3)
          {
            if (!(this.jdField_a_of_type_Oxu instanceof VideoView)) {
              break label66;
            }
            bool1 = ((VideoView)this.jdField_a_of_type_Oxu).b();
          }
        }
      }
    }
    return bool1;
    label66:
    this.jdField_a_of_type_Oxu.B_();
    return false;
  }
  
  protected int b()
  {
    return 2131559857;
  }
  
  public void b()
  {
    h();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Oxu != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Oxu.C_();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Oxu != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Oxu.D_();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Oxu != null) && (this.jdField_a_of_type_Boolean))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "destroy play");
      this.jdField_a_of_type_Oxu.d();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 0) || (jdField_a_of_type_Int == 2))
    {
      i();
      return;
    }
    try
    {
      this.jdField_a_of_type_Pvb.a.a().click_area = a();
      onk.b(this.jdField_a_of_type_Pvb.a.a().a().getContext(), this.jdField_a_of_type_Pvb.a.a(), (int)this.jdField_a_of_type_Pvb.a.a().mChannelID);
      j();
      return;
    }
    catch (NullPointerException paramView)
    {
      for (;;)
      {
        QLog.e("ComponentPGCShortContentBig", 2, paramView.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig
 * JD-Core Version:    0.7.0.1
 */