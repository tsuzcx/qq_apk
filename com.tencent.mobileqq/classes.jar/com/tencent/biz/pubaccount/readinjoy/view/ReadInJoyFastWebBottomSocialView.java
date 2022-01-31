package com.tencent.biz.pubaccount.readinjoy.view;

import alpo;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
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
import bjxj;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nrt;
import ohq;
import olt;
import olw;
import omz;
import oop;
import oot;
import org.json.JSONObject;
import ors;
import osk;
import otd;
import owy;
import oxb;
import pej;
import pem;
import rsf;
import rsg;
import rsh;
import rsi;
import sdn;
import zbj;

public class ReadInJoyFastWebBottomSocialView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final String a;
  public static final String b;
  private static final String jdField_c_of_type_JavaLangString = alpo.a(2131713415);
  private static final String jdField_d_of_type_JavaLangString = alpo.a(2131713183);
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private FastWebActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity;
  private FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyFastWebBottomSocialView.5(this);
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private oop jdField_a_of_type_Oop;
  pem jdField_a_of_type_Pem = new rsh(this);
  private zbj jdField_a_of_type_Zbj;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final Runnable jdField_b_of_type_JavaLangRunnable = new ReadInJoyFastWebBottomSocialView.6(this);
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131713214);
    jdField_b_of_type_JavaLangString = alpo.a(2131713404);
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
      bjxj.f();
      Object localObject1 = Aladdin.getConfig(151);
      if (localObject1 != null)
      {
        j = ((AladdinConfig)localObject1).getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
        i = ((AladdinConfig)localObject1).getIntegerFromString("readinjoy_bottom_action_bar_style", -1);
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, "initView,styleBusinessID=" + j + " actionBarStyle=" + i);
        k = 2131560016;
        if (j != 1)
        {
          j = k;
          inflate(this.jdField_a_of_type_AndroidContentContext, j, this);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378658));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378656));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368733));
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368814));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378810));
          this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363323));
          this.e = ((TextView)findViewById(2131378626));
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131379504);
          this.jdField_b_of_type_AndroidViewView = findViewById(2131379505);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364565));
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369420));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364420));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368731));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378651));
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnLongClickListener(this);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Pem);
          localObject1 = new IntentFilter();
          ((IntentFilter)localObject1).addAction("com.tencent.process.fav");
          this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject1);
          this.f = ((TextView)findViewById(2131378655));
          this.g = ((TextView)findViewById(2131378809));
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        int i;
        int k;
        Object localObject2 = null;
        continue;
        if ((i != 1) && (i != 2))
        {
          j = k;
          if (i != 3) {}
        }
        else
        {
          j = 2131560017;
          this.jdField_a_of_type_Int = i;
          continue;
          i = -1;
          j = -1;
        }
      }
    }
  }
  
  private boolean a(oot paramoot)
  {
    if (this.jdField_a_of_type_Oop == null) {
      this.jdField_a_of_type_Oop = new oop(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    if ((!this.jdField_a_of_type_Oop.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (otd.b()))
    {
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.findViewById(2131375252)).inflate();
      }
      this.jdField_a_of_type_Oop.a(new rsi(this, paramoot));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Oop.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_Oop.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void b()
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
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new rsg(this));
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void b(boolean paramBoolean)
  {
    olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 4, "", null, false, null, -1, paramBoolean);
    String str = new olw(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1).a();
    nrt.a((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getAppInterface(), olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
    ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (str = "2";; str = "1")
    {
      sdn.a(localArticleInfo1, "0X8008990", ors.a(localContext, localArticleInfo2, i, str).toString());
      return;
    }
  }
  
  private void c()
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
    pej.a().a(localArrayList, this.jdField_a_of_type_Pem);
  }
  
  private void c(boolean paramBoolean)
  {
    int j = 0;
    String str;
    int i;
    if (paramBoolean)
    {
      str = bjxj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b, 99990000L, "9999万+", jdField_c_of_type_JavaLangString);
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
      getResources().getDimension(2131298607);
      this.f.setTextColor(Color.parseColor("#FF4222"));
      this.f.setBackgroundResource(2130842377);
      this.g.setBackgroundResource(2130842377);
    }
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
      pej.a();
      pej.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, new Object[] { "setFavoriteArticle, isFavorite = ", Boolean.valueOf(paramBoolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "waiting for favorite result now, do not request again.");
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Zbj != null) {
        this.jdField_a_of_type_Zbj.c();
      }
      this.jdField_a_of_type_Zbj = new zbj((QQAppInterface)ors.a(), (Activity)localObject);
      this.jdField_a_of_type_Zbj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_Zbj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, 9, false);
      this.jdField_a_of_type_Boolean = true;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new ReadInJoyFastWebBottomSocialView.3(this), 3000L);
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
        nrt.a(null, "", "0X8009D0F", "0X8009D0F", 0, 0, "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", "", ((JSONObject)localObject).toString(), false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      pej.a().a(localException, localQQAppInterface.getAccount(), 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID));
      break;
      label343:
      i = 0;
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
  
  private void f(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2130841325;
    }
    for (String str = alpo.a(2131713435);; str = alpo.a(2131713158))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
      this.jdField_c_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      return;
      i = 2130841339;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Int = paramInt;
    String str = bjxj.a(paramInt, 99990000L, "9999万+", jdField_d_of_type_JavaLangString);
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
    Object localObject = omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localObject != null)
    {
      long l = ((omz)localObject).a(2);
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
    for (int i = 2130842475;; i = 2130842477)
    {
      localImageView.setImageResource(i);
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateLikeIconView | isLiked  " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.e == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c = paramLong;
    if (bjxj.n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getAppRuntime()) == 0)
    {
      this.e.setText(bjxj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c, 99990000L, "9999万+", "Biu"));
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateBiuCntView | biu cnt is " + paramLong);
      return;
    }
    this.e.setText("Biu");
    QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateBiuCntView | biu cnt switch is closed ");
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null)) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131363323: 
        if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
        }
        osk.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null));
    label130:
    ArticleInfo localArticleInfo1;
    Context localContext;
    ArticleInfo localArticleInfo2;
    int i;
    if (ohq.a() == 1)
    {
      bool = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.a(18, 0, bool);
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
        break label532;
      }
    }
    label532:
    for (paramView = "2";; paramView = "1")
    {
      sdn.a(localArticleInfo1, "0X8008991", ors.a(localContext, localArticleInfo2, i, paramView, 0).toString());
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (a(new rsf(this)))) {
        break;
      }
      b(true);
      return;
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
          sdn.a(localArticleInfo1, "0X8008990", ors.a(localContext, localArticleInfo2, i, paramView).toString());
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
        sdn.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009765", "1");
      }
      for (;;)
      {
        b();
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Int);
        oxb.a().c();
        owy.a().a(ors.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean = true;
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
        paramView.jdField_a_of_type_Int += 1;
        sdn.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009764", "1");
      }
      bool = false;
      break label130;
    }
    if (!this.jdField_c_of_type_AndroidWidgetImageView.isSelected()) {}
    for (;;)
    {
      d(bool);
      return;
      bool = false;
    }
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
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null);
    ArticleInfo localArticleInfo1;
    Context localContext;
    ArticleInfo localArticleInfo2;
    int i;
    if (ohq.b() == 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.a(18, 0, bool);
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
        break label144;
      }
    }
    label144:
    for (paramView = "2";; paramView = "1")
    {
      sdn.a(localArticleInfo1, "0X8008991", ors.a(localContext, localArticleInfo2, i, paramView, 0).toString());
      return false;
      bool = false;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    d();
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
    c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView
 * JD-Core Version:    0.7.0.1
 */