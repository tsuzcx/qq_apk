package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aekt;
import alpo;
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
import bcch;
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
import orc;
import ors;
import osf;
import osl;
import otf;
import pcc;
import pcw;
import pcx;
import pgd;
import pqd;
import qbs;
import qev;
import qmr;
import qms;
import qmt;
import rqj;

public class ComponentPGCShortContentBig
  extends ComponentContentBig
  implements View.OnClickListener
{
  public static int a;
  public static String a;
  private float jdField_a_of_type_Float;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private pcw jdField_a_of_type_Pcw;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
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
      localObject1 = (qms)paramArticleInfo.mSocialFeedInfo.a.a.get(0);
      if (TextUtils.isEmpty(((qms)localObject1).jdField_b_of_type_JavaLangString)) {}
    }
    for (Object localObject1 = ((qms)localObject1).jdField_b_of_type_JavaLangString;; localObject1 = "")
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
      b(alpo.a(2131702723));
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
    b(alpo.a(2131702723));
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
    for (paramLayoutParams = alpo.a(2131702668);; paramLayoutParams = alpo.a(2131702708))
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(alpo.a(2131702640));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(alpo.a(2131702645));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(alpo.a(2131702630));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
      return;
    }
    paramLayoutParams.width = paramInt1;
    paramLayoutParams.height = paramInt2;
    KanDianRoundCornerTextView localKanDianRoundCornerTextView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramLayoutParams = alpo.a(2131702646);; paramLayoutParams = alpo.a(2131702653))
    {
      localKanDianRoundCornerTextView.setText(paramLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      return;
    }
  }
  
  private void a(int paramInt, qms paramqms)
  {
    if ((paramInt != this.jdField_d_of_type_Int) || (this.jdField_f_of_type_Int == 0))
    {
      if ((paramInt != this.jdField_d_of_type_Int) || (!a(paramqms)))
      {
        QLog.d("ComponentPGCShortContentBig", 2, "recreate video");
        if (this.jdField_a_of_type_Pcw != null)
        {
          QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "reset destroy");
          this.jdField_a_of_type_Pcw.d();
        }
        this.jdField_a_of_type_Pcw = pcx.a(paramInt, BaseApplicationImpl.getContext());
        if (paramInt == 1) {
          ((VideoView)this.jdField_a_of_type_Pcw).setUseVid(false);
        }
        if ((this.jdField_a_of_type_Pcw instanceof View))
        {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
          if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams == null) {
            this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, -2);
          }
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)this.jdField_a_of_type_Pcw, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
        }
        this.jdField_d_of_type_Int = paramInt;
      }
    }
    else {
      return;
    }
    QLog.d("ComponentPGCShortContentBig", 1, "reuse video");
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_Pcw != null) && ((this.jdField_a_of_type_Pcw instanceof VideoView)))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "set url " + paramString);
      pcc.a(paramString);
      ((MediaVideoView)this.jdField_a_of_type_Pcw).setVideoUrl(paramString);
      if (b()) {
        ((MediaVideoView)this.jdField_a_of_type_Pcw).E_();
      }
      if (pcc.a(paramString)) {
        QLog.d("ComponentPGCShortContentBig", 2, "preload cache hit");
      }
      if (((MediaVideoView)this.jdField_a_of_type_Pcw).b() == 3) {
        ((MediaVideoView)this.jdField_a_of_type_Pcw).c();
      }
    }
  }
  
  private void a(qmt paramqmt)
  {
    if ((paramqmt != null) && (this.jdField_a_of_type_Pcw != null))
    {
      this.jdField_a_of_type_Pcw.setMediaPlayVid(paramqmt.e);
      this.jdField_a_of_type_Pcw.setMediaPlayUrl(null);
      this.jdField_a_of_type_Pcw.setMediaCoverUrl(paramqmt.d);
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "set url " + null);
      if ((this.jdField_a_of_type_Pcw instanceof MediaVideoView))
      {
        osl localosl = osf.a(paramqmt.e);
        if ((localosl == null) || (!localosl.a(System.currentTimeMillis() / 1000L, 3600L))) {
          break label132;
        }
        a(localosl.jdField_a_of_type_JavaLangString);
        QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "url hit");
      }
    }
    return;
    label132:
    QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "request url by vid " + paramqmt.e);
    paramqmt = new qev(this, paramqmt);
    ThreadManager.getFileThreadHandler().post(new ComponentPGCShortContentBig.2(this, paramqmt));
  }
  
  private boolean a(qms paramqms)
  {
    if ((this.jdField_a_of_type_Pcw instanceof VideoView))
    {
      VideoView localVideoView = (VideoView)this.jdField_a_of_type_Pcw;
      return (paramqms != null) && (paramqms.jdField_a_of_type_Qmt != null) && (paramqms.jdField_a_of_type_Qmt.e != null) && (paramqms.jdField_a_of_type_Qmt.e.equals(localVideoView.a()));
    }
    if ((this.jdField_a_of_type_Pcw instanceof GifView)) {
      return !((GifView)this.jdField_a_of_type_Pcw).a();
    }
    return false;
  }
  
  private void b(String paramString)
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(alpo.a(2131702643));
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
  
  private void b(pgd parampgd)
  {
    if (parampgd != null)
    {
      parampgd = parampgd.a();
      if (parampgd != null)
      {
        if ((parampgd.mSocialFeedInfo == null) || (parampgd.mSocialFeedInfo.a == null) || (parampgd.mSocialFeedInfo.a.a == null) || (parampgd.mSocialFeedInfo.a.a.size() <= 0)) {
          break label142;
        }
        parampgd = (qms)parampgd.mSocialFeedInfo.a.a.get(0);
        if ((parampgd.jdField_a_of_type_Qmt == null) || (this.jdField_e_of_type_Int != 1)) {
          break label129;
        }
        a(1, parampgd);
        a(parampgd.jdField_a_of_type_Qmt);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      ((View)this.jdField_a_of_type_Pcw).setVisibility(0);
      return;
      label129:
      a(0, parampgd);
      j();
      continue;
      label142:
      j();
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Pcw instanceof VideoView))
    {
      int i = ((VideoView)this.jdField_a_of_type_Pcw).a();
      return (i != 5) && (i != 7) && (i != 6);
    }
    return false;
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_Float == 0.0F) || (this.jdField_b_of_type_Float == 0.0F) || (this.jdField_c_of_type_Float == 0.0F) || (this.jdField_d_of_type_Float == 0.0F) || (this.jdField_e_of_type_Float == 0.0F) || (this.jdField_f_of_type_Float == 0.0F) || (this.h == 0)) {}
    label145:
    do
    {
      return false;
      long l;
      if ((this.jdField_a_of_type_Qbs != null) && (this.jdField_a_of_type_Qbs.a != null) && (this.jdField_a_of_type_Qbs.a.a() != null))
      {
        l = this.jdField_a_of_type_Qbs.a.a().mChannelID;
        if (this.h != 1) {
          continue;
        }
        if ((l != 0L) && (l != otf.b())) {
          break label145;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        return bool;
        l = -1L;
        break;
      }
    } while (this.h != 2);
    return true;
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
    if (this.jdField_a_of_type_Pcw != null)
    {
      String str1 = a(this.jdField_a_of_type_Qbs.a).toString();
      String str2 = a(str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getMeasuredWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getMeasuredHeight());
      this.jdField_a_of_type_Pcw.setMediaCoverUrl(str2);
      this.jdField_a_of_type_Pcw.setMediaPlayUrl(str1);
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_Qbs == null) || (this.jdField_a_of_type_Qbs.a == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Qbs != null) && (this.jdField_a_of_type_Qbs.a != null) && (this.jdField_a_of_type_Qbs.a.a() != null) && (this.jdField_a_of_type_Qbs.a.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_Qbs.a.a().mSocialFeedInfo.a != null) && (this.jdField_a_of_type_Qbs.a.a().mSocialFeedInfo.a.a != null)) {}
    for (ArrayList localArrayList = this.jdField_a_of_type_Qbs.a.a().mSocialFeedInfo.a.a;; localArrayList = null)
    {
      this.jdField_a_of_type_Boolean = false;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.jdField_b_of_type_Int = ((qms)localArrayList.get(0)).jdField_a_of_type_Int;
        this.jdField_c_of_type_Int = ((qms)localArrayList.get(0)).jdField_b_of_type_Int;
        if (((qms)localArrayList.get(0)).jdField_c_of_type_Int == 1)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Qbs.a().a().isShowGif = this.jdField_a_of_type_Boolean;
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
        ((View)this.jdField_a_of_type_Pcw).setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
        ((View)this.jdField_a_of_type_Pcw).setPadding(0, 0, 0, 0);
        return;
        if (!this.jdField_a_of_type_Qbs.a.a().isUseGif) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ComponentPGCShortContentBig", 2, "pgc pic info is null");
        }
        if (!this.jdField_a_of_type_Qbs.a.a().isUseGif) {
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
    int i = aekt.a(12.0F, getResources());
    int j = aekt.a(4.5F, getResources());
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
        b(alpo.a(2131702723));
        return;
      }
    } while (f1 >= this.jdField_f_of_type_Float);
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.width = ((int)(i * this.jdField_d_of_type_Float));
    b(alpo.a(2131702723));
  }
  
  private void m()
  {
    int j = aekt.a(12.0F, getResources());
    int k = aekt.a(4.5F, getResources());
    int i = (this.g - (j * 2 + k * 2)) / 3 * 2 + k;
    j = (this.g - (j * 2 + k)) / 2;
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_c_of_type_Int == 0))
    {
      this.jdField_c_of_type_Int = i;
      this.jdField_b_of_type_Int = i;
    }
    if (this.jdField_a_of_type_Qbs.a.a().mChannelID == 0L)
    {
      a(orc.a(this.g, getResources()), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
      return;
    }
    a(i, j, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
  
  private void n()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Qbs == null) || (this.jdField_a_of_type_Qbs.a == null) || (this.jdField_a_of_type_Qbs.a.a() == null)) {
      return;
    }
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qbs.a.a();
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
          bcch.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
        }
      }
    }
    for (;;)
    {
      QLog.d("ComponentPGCShortContentBig", 1, "[showPicture] isGif " + this.jdField_a_of_type_Boolean + ", urls : " + localArrayList);
      try
      {
        localArticleInfo.click_area = 9;
        ors.b(this.jdField_a_of_type_Qbs.a.a().a().getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        QLog.e("ComponentPGCShortContentBig", 2, localNullPointerException.getLocalizedMessage());
        return;
      }
      o();
      continue;
      if (this.jdField_a_of_type_Pcw != null) {
        this.jdField_a_of_type_Pcw.B_();
      }
      this.jdField_b_of_type_Boolean = true;
      continue;
      bcch.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
    }
  }
  
  private void o()
  {
    Context localContext = getContext();
    if ((this.jdField_a_of_type_Qbs != null) && (this.jdField_a_of_type_Qbs.a != null)) {}
    for (ArticleInfo localArticleInfo = this.jdField_a_of_type_Qbs.a.a();; localArticleInfo = null)
    {
      pqd.a(localContext, localArticleInfo);
      return;
    }
  }
  
  protected int a()
  {
    return 9;
  }
  
  protected URL a(pgd parampgd)
  {
    parampgd = parampgd.a();
    try
    {
      if (!TextUtils.isEmpty(a(parampgd))) {
        return new URL(a(parampgd));
      }
      URL localURL = parampgd.mSinglePicture;
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      QLog.e("ComponentPGCShortContentBig", 1, localMalformedURLException.getMessage());
    }
    return parampgd.mSinglePicture;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366450));
    this.jdField_d_of_type_Int = -1;
    a(0, null);
  }
  
  public void a(Object paramObject)
  {
    f();
    super.a(paramObject);
  }
  
  protected void a(pgd parampgd)
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean) {
      b(parampgd);
    }
    for (;;)
    {
      ((View)this.jdField_a_of_type_Pcw).setClickable(true);
      ((View)this.jdField_a_of_type_Pcw).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
      return;
      ((View)this.jdField_a_of_type_Pcw).setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, a(parampgd), getContext());
    }
  }
  
  protected void a(pgd parampgd, ArticleInfo paramArticleInfo) {}
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Pcw != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Pcw.a())
        {
          bool1 = bool2;
          if (jdField_a_of_type_Int == 3)
          {
            if (!(this.jdField_a_of_type_Pcw instanceof VideoView)) {
              break label66;
            }
            bool1 = ((VideoView)this.jdField_a_of_type_Pcw).c();
          }
        }
      }
    }
    return bool1;
    label66:
    this.jdField_a_of_type_Pcw.B_();
    return false;
  }
  
  protected int b()
  {
    return 2131559952;
  }
  
  public void b()
  {
    k();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Pcw != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Pcw.C_();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Pcw != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Pcw.D_();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Pcw != null) && (this.jdField_a_of_type_Boolean))
    {
      QLog.d("gifvideo.ComponentPGCShortContentBig", 1, "destroy play");
      this.jdField_a_of_type_Pcw.d();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 0) || (jdField_a_of_type_Int == 2))
    {
      n();
      return;
    }
    try
    {
      this.jdField_a_of_type_Qbs.a.a().click_area = a();
      o();
      ors.b(this.jdField_a_of_type_Qbs.a.a().a().getContext(), this.jdField_a_of_type_Qbs.a.a(), (int)this.jdField_a_of_type_Qbs.a.a().mChannelID);
      return;
    }
    catch (NullPointerException paramView)
    {
      QLog.e("ComponentPGCShortContentBig", 2, paramView.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig
 * JD-Core Version:    0.7.0.1
 */