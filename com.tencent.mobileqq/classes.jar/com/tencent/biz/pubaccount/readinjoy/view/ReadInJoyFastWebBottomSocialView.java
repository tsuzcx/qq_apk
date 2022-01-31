package com.tencent.biz.pubaccount.readinjoy.view;

import ajya;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bhvy;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nol;
import odo;
import ohf;
import ohi;
import oil;
import okb;
import okf;
import onh;
import onz;
import oos;
import oqb;
import org.json.JSONObject;
import osg;
import osj;
import osm;
import ozb;
import oze;
import rch;
import rci;
import rcj;
import rck;
import rcl;
import rlz;
import rno;
import xmq;

public class ReadInJoyFastWebBottomSocialView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final String a;
  public static final String b;
  private static final String jdField_c_of_type_JavaLangString = ajya.a(2131713043);
  private static final String jdField_d_of_type_JavaLangString = ajya.a(2131712811);
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private FastWebActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity;
  private FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyFastWebBottomSocialView.7(this);
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private okb jdField_a_of_type_Okb;
  private osm jdField_a_of_type_Osm;
  oze jdField_a_of_type_Oze = new rck(this);
  private xmq jdField_a_of_type_Xmq;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final Runnable jdField_b_of_type_JavaLangRunnable = new ReadInJoyFastWebBottomSocialView.8(this);
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = rlz.a().b();
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private TextView f;
  private TextView g;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131712842);
    jdField_b_of_type_JavaLangString = ajya.a(2131713032);
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    try
    {
      bhvy.d();
      localObject1 = Aladdin.getConfig(151);
      if (localObject1 != null)
      {
        j = ((AladdinConfig)localObject1).getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
        i = ((AladdinConfig)localObject1).getIntegerFromString("readinjoy_bottom_action_bar_style", -1);
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, "initView,styleBusinessID=" + j + " actionBarStyle=" + i);
        k = 2131559917;
        if (j != 1)
        {
          j = k;
          inflate(this.jdField_a_of_type_AndroidContentContext, j, this);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378102));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378101));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368537));
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368614));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378241));
          this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363278));
          this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378075));
          this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368514));
          this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368513));
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          int k;
          this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oqb.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
          if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
            this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131378878);
          this.jdField_b_of_type_AndroidViewView = findViewById(2131378879);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364493));
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369188));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364351));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368535));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378097));
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnLongClickListener(this);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Oze);
          Object localObject1 = new IntentFilter();
          ((IntentFilter)localObject1).addAction("com.tencent.process.fav");
          this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject1);
          this.f = ((TextView)findViewById(2131378100));
          this.g = ((TextView)findViewById(2131378240));
          this.jdField_a_of_type_Osm = new rch(this);
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            this.g.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          return;
          localException1 = localException1;
          Object localObject2 = null;
          continue;
          if ((i != 1) && (i != 2))
          {
            j = k;
            if (i != 3) {
              continue;
            }
          }
          j = 2131559918;
          this.jdField_a_of_type_Int = i;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ReadInJoyFastWebBottomSocialView", 1, localException2.toString());
          continue;
        }
        int i = -1;
        int j = -1;
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if ((this.jdField_d_of_type_Boolean) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130841204);
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.a = 0L;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.a = 0L;
      return;
    }
    catch (NullPointerException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (this.jdField_d_of_type_Boolean) {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (paramInt != 2) {
          break label74;
        }
        b();
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.a = paramLong;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.jdField_b_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo.a = paramLong;
        return;
      }
      catch (NullPointerException paramString)
      {
        label74:
        paramString.printStackTrace();
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130841214);
    }
  }
  
  private boolean a(okf paramokf)
  {
    if (this.jdField_a_of_type_Okb == null) {
      this.jdField_a_of_type_Okb = new okb(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    if ((!this.jdField_a_of_type_Okb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (oos.b()))
    {
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.findViewById(2131374789)).inflate();
      }
      this.jdField_a_of_type_Okb.a(new rcl(this, paramokf));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Okb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_Okb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_e_of_type_AndroidWidgetImageView.invalidate();
      this.jdField_e_of_type_AndroidWidgetImageView.setScaleX(1.7F);
      this.jdField_e_of_type_AndroidWidgetImageView.setScaleY(1.7F);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(0);
      this.jdField_c_of_type_Boolean = true;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getComposition();
      long l = 1249L;
      if (localObject != null) {
        l = ((LottieComposition)localObject).getDuration();
      }
      localObject = new ReadInJoyFastWebBottomSocialView.3(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject, l);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ohf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 4, "", null, false, null, -1, paramBoolean);
    String str = new ohi(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1).a();
    nol.a((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getAppInterface(), ohf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
    ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (str = "2";; str = "1")
    {
      rno.a(localArticleInfo1, "0X8008990", onh.a(localContext, localArticleInfo2, i, str).toString());
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimation = localScaleAnimation;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new rcj(this));
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void c(boolean paramBoolean)
  {
    int j = 0;
    String str;
    int i;
    if (paramBoolean)
    {
      str = bhvy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b, 99990000L, "9999万+", jdField_c_of_type_JavaLangString);
      if (this.f != null)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          if (jdField_c_of_type_JavaLangString.equalsIgnoreCase(str)) {
            break label126;
          }
          this.f.setText(str);
          i = 0;
          this.f.setVisibility(i);
        }
        label71:
        i = 4;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(j);
      this.jdField_a_of_type_AndroidViewView.setVisibility(i);
      this.jdField_b_of_type_AndroidViewView.setVisibility(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(j);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      break label71;
      label126:
      i = 8;
      break;
      i = 0;
      j = 8;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) {
      f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a());
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "initFavoriteStatus but articleInfo is null.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    ozb.a().a(localArrayList, this.jdField_a_of_type_Oze);
  }
  
  private void d(boolean paramBoolean)
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "setFavoriteArticle but articleInfo is null.");
      return;
    }
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    f(paramBoolean);
    if (paramBoolean)
    {
      ozb.a();
      ozb.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, new Object[] { "setFavoriteArticle, isFavorite = ", Boolean.valueOf(paramBoolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "waiting for favorite result now, do not request again.");
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Xmq != null) {
        this.jdField_a_of_type_Xmq.c();
      }
      this.jdField_a_of_type_Xmq = new xmq((QQAppInterface)onh.a(), (Activity)localObject);
      this.jdField_a_of_type_Xmq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_Xmq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, 9, false);
      this.jdField_a_of_type_Boolean = true;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new ReadInJoyFastWebBottomSocialView.5(this), 3000L);
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (!paramBoolean) {
          break label343;
        }
        ((JSONObject)localObject).put("status", i);
        ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        nol.a(null, "", "0X8009D0F", "0X8009D0F", 0, 0, "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", "", ((JSONObject)localObject).toString(), false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ozb.a().a(localException, localQQAppInterface.getAccount(), 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID));
      break;
      label343:
      i = 0;
    }
  }
  
  private void e()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "updateFavoriteStatus but fastWebInfo is null.");
      return;
    }
    f(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(paramBoolean);
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.g == null) || (this.f == null)) {
      return;
    }
    Object localObject = new int[2];
    int[] arrayOfInt = new int[2];
    this.jdField_b_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject);
    getLocationOnScreen(arrayOfInt);
    int k = this.jdField_b_of_type_AndroidWidgetImageView.getWidth();
    int m = this.jdField_b_of_type_AndroidWidgetImageView.getHeight();
    this.jdField_b_of_type_AndroidWidgetImageView.getLeft();
    int i = localObject[1];
    int j = arrayOfInt[1];
    m /= 9;
    int n = localObject[0];
    k = k * 13 / 20;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    localLayoutParams.leftMargin = (n + k);
    localLayoutParams.topMargin = (i - j - m);
    this.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject);
    k = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    m = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
    i = localObject[1];
    j = arrayOfInt[1];
    m /= 9;
    n = localObject[0];
    k = k * 13 / 20;
    localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = (n + k);
    ((RelativeLayout.LayoutParams)localObject).topMargin = (i - j - m);
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
      getResources().getDimension(2131298581);
      this.f.setTextColor(Color.parseColor("#FF4222"));
      this.f.setBackgroundResource(2130842210);
      this.g.setBackgroundResource(2130842210);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2130841205;
    }
    for (String str = ajya.a(2131713063);; str = ajya.a(2131712786))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
      this.jdField_c_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      return;
      i = 2130841219;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Int = paramInt;
    String str = bhvy.a(paramInt, 99990000L, "9999万+", jdField_d_of_type_JavaLangString);
    if (this.g != null) {
      if (this.jdField_b_of_type_Boolean)
      {
        int j = 8;
        int i = j;
        if (!jdField_d_of_type_JavaLangString.equalsIgnoreCase(str))
        {
          i = j;
          if (this.jdField_a_of_type_Int == 1)
          {
            this.g.setText(str);
            i = 0;
          }
        }
        this.g.setVisibility(i);
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateLikeCntView | like cnt is " + paramInt);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    Object localObject = oil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localObject != null)
    {
      long l = ((oil)localObject).a(2);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      if (l > 0L) {
        paramLong = l;
      }
    }
    for (((FastWebArticleInfo)localObject).b = paramLong;; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b = paramLong)
    {
      c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b());
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean = paramBoolean;
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean) {}
    for (int i = 2130842306;; i = 2130842308)
    {
      localImageView.setImageResource(i);
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateLikeIconView | isLiked  " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = paramLong;
    if (bhvy.n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getAppRuntime()) == 0)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bhvy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c, 99990000L, "9999万+", "Biu"));
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateBiuCntView | biu cnt is " + paramLong);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText("Biu");
    QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateBiuCntView | biu cnt switch is closed ");
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    osj.a().a(this.jdField_a_of_type_Osm);
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null)) {}
    do
    {
      do
      {
        return;
        switch (paramView.getId())
        {
        default: 
          return;
        case 2131363278: 
          if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
            this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
          }
          onz.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        }
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null));
      if ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo == null)) {
        break label586;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean) {
        break;
      }
      rlz.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, onh.a(), 1, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      return;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (a(new rci(this))));
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo != null))
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        b(bool1);
        return;
        bool1 = false;
      }
    }
    b(true);
    return;
    ArticleInfo localArticleInfo1;
    Context localContext;
    ArticleInfo localArticleInfo2;
    int i;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "enter scroll");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.c();
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (paramView = "2";; paramView = "1")
      {
        rno.a(localArticleInfo1, "0X8008990", onh.a(localContext, localArticleInfo2, i, paramView).toString());
        return;
      }
    }
    if ("scroll to history location failed cuz activity or articleinfo is null" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) {}
    for (paramView = "activity is null";; paramView = "")
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, paramView);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "like click event failed");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean = false;
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      paramView.jdField_a_of_type_Int -= 1;
      rno.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009765", "1");
    }
    for (;;)
    {
      c();
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Int);
      osj.a().c();
      osg.a().a(onh.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean = true;
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      paramView.jdField_a_of_type_Int += 1;
      rno.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009764", "1");
    }
    rlz.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.a, onh.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    return;
    label586:
    if (odo.a() == 1)
    {
      bool1 = bool2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.a(18, 0, bool1);
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
        break label675;
      }
    }
    label675:
    for (paramView = "2";; paramView = "1")
    {
      rno.a(localArticleInfo1, "0X8008991", onh.a(localContext, localArticleInfo2, i, paramView, 0).toString());
      return;
      bool1 = false;
      break;
    }
    if (!this.jdField_c_of_type_AndroidWidgetImageView.isSelected()) {}
    for (bool1 = bool3;; bool1 = false)
    {
      d(bool1);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    osj.a().b(this.jdField_a_of_type_Osm);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    }
    do
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      }
    } while ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null));
    ArticleInfo localArticleInfo1;
    Context localContext;
    ArticleInfo localArticleInfo2;
    int i;
    if (odo.b() == 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.a(18, 0, bool);
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
        break label151;
      }
    }
    label151:
    for (paramView = "2";; paramView = "1")
    {
      rno.a(localArticleInfo1, "0X8008991", onh.a(localContext, localArticleInfo2, i, paramView, 0).toString());
      return false;
      bool = false;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    f();
  }
  
  public void setBiuInfo(FusionBiuInfo paramFusionBiuInfo)
  {
    if (paramFusionBiuInfo == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo = paramFusionBiuInfo;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructFusionBiuInfo = paramFusionBiuInfo;
    } while (!this.jdField_d_of_type_Boolean);
    ImageView localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
    if (paramFusionBiuInfo.jdField_b_of_type_Boolean) {}
    for (int i = 2130841214;; i = 2130841204)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  public void setData(FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b);
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Int);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean);
    d();
    e();
  }
  
  public void setFavoriteArticle()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      if (this.jdField_c_of_type_AndroidWidgetImageView.isSelected()) {
        break label25;
      }
    }
    label25:
    for (boolean bool = true;; bool = false)
    {
      d(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView
 * JD-Core Version:    0.7.0.1
 */