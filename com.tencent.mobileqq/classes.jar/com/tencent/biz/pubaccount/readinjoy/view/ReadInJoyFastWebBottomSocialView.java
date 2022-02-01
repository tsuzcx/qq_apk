package com.tencent.biz.pubaccount.readinjoy.view;

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
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CommentReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuidePopuppWindow;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.CommentGuideConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ReadInJoyFastWebBottomSocialView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final String a;
  public static final String b;
  private static final String jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131712996);
  private static final String jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131712774);
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GuidePopuppWindow jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  ReadInJoyAtlasManager.AtlasCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback = new ReadInJoyFastWebBottomSocialView.4(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private FastWebActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity;
  private FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private Share jdField_a_of_type_ComTencentBizWebviewpluginShare;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyFastWebBottomSocialView.5(this);
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final Runnable jdField_b_of_type_JavaLangRunnable = new ReadInJoyFastWebBottomSocialView.6(this);
  private boolean jdField_b_of_type_Boolean = false;
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
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712805);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131712985);
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
      ReadInJoyHelper.f();
      Object localObject1 = Aladdin.getConfig(151);
      if (localObject1 != null)
      {
        j = ((AladdinConfig)localObject1).getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
        i = ((AladdinConfig)localObject1).getIntegerFromString("readinjoy_bottom_action_bar_style", -1);
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, "initView,styleBusinessID=" + j + " actionBarStyle=" + i);
        k = 2131560299;
        if (j != 1)
        {
          j = k;
          inflate(this.jdField_a_of_type_AndroidContentContext, j, this);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380270));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380269));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369619));
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369710));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380440));
          this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363725));
          this.e = ((TextView)findViewById(2131380231));
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131381200);
          this.jdField_b_of_type_AndroidViewView = findViewById(2131381201);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365082));
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370366));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364920));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369616));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380263));
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnLongClickListener(this);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
          localObject1 = new IntentFilter();
          ((IntentFilter)localObject1).addAction("com.tencent.process.fav");
          this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject1);
          this.f = ((TextView)findViewById(2131380268));
          this.g = ((TextView)findViewById(2131380439));
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
          j = 2131560300;
          this.jdField_a_of_type_Int = i;
          continue;
          i = -1;
          j = -1;
        }
      }
    }
  }
  
  private boolean a(GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow = new GuidePopuppWindow(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (CommentGuideConfigHandler.b()))
    {
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.findViewById(2131376571)).inflate();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(new ReadInJoyFastWebBottomSocialView.7(this, paramOnGuideDismissListener));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getWindow().getDecorView());
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
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new ReadInJoyFastWebBottomSocialView.2(this));
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void b(boolean paramBoolean)
  {
    ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 4, "", null, false, null, -1, paramBoolean);
    String str = new ReadInJoyCommentUtils.CommentReportR5Builder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getAppInterface(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
    ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (str = "2";; str = "1")
    {
      ReportUtil.a(localArticleInfo1, "0X8008990", RIJTransMergeKanDianReport.a(localContext, localArticleInfo2, i, str).toString());
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
    ReadInJoyAtlasManager.a().a(localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
  }
  
  private void c(boolean paramBoolean)
  {
    int j = 0;
    String str;
    int i;
    if (paramBoolean)
    {
      str = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b, 99990000L, "9999万+", jdField_c_of_type_JavaLangString);
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
      getResources().getDimension(2131298854);
      this.f.setTextColor(Color.parseColor("#FF4222"));
      this.f.setBackgroundResource(2130842955);
      this.g.setBackgroundResource(2130842955);
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
      ReadInJoyAtlasManager.a();
      ReadInJoyAtlasManager.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, new Object[] { "setFavoriteArticle, isFavorite = ", Boolean.valueOf(paramBoolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "waiting for favorite result now, do not request again.");
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c();
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share((QQAppInterface)ReadInJoyUtils.a(), (Activity)localObject);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, 9, false);
      this.jdField_a_of_type_Boolean = true;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new ReadInJoyFastWebBottomSocialView.3(this), 3000L);
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (!paramBoolean) {
          break label365;
        }
        ((JSONObject)localObject).put("status", i);
        ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        ((JSONObject)localObject).put("source_from", "3");
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009D0F", "0X8009D0F", 0, 0, "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", "", ((JSONObject)localObject).toString(), false);
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ReadInJoyAtlasManager.a().a(localException, localQQAppInterface.getAccount(), 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID));
      break;
      label365:
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
      i = 2130841829;
    }
    for (String str = HardCodeUtil.a(2131713016);; str = HardCodeUtil.a(2131712749))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
      this.jdField_c_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      return;
      i = 2130841843;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Int = paramInt;
    String str = ReadInJoyHelper.a(paramInt, 99990000L, "9999万+", jdField_d_of_type_JavaLangString);
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
    Object localObject = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localObject != null)
    {
      long l = ((ReadInJoyCommentDataManager)localObject).a(2);
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
    for (int i = 2130843069;; i = 2130843071)
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
    if (ReadInJoyHelper.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.getAppRuntime()) == 0)
    {
      this.e.setText(ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c, 99990000L, "9999万+", "Biu"));
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
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        switch (paramView.getId())
        {
        }
      }
      if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      }
      TimeSliceHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null));
    label140:
    ArticleInfo localArticleInfo1;
    Context localContext;
    ArticleInfo localArticleInfo2;
    int i;
    if (BiuBehaviour.a() == 1)
    {
      bool = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.a(18, 0, bool);
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
        break label568;
      }
    }
    label568:
    for (Object localObject = "2";; localObject = "1")
    {
      ReportUtil.a(localArticleInfo1, "0X8008991", RIJTransMergeKanDianReport.a(localContext, localArticleInfo2, i, (String)localObject, 0).toString());
      break;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (a(new ReadInJoyFastWebBottomSocialView.1(this)))) {
        break;
      }
      b(true);
      break;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
      {
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, "enter scroll");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity.c();
        localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localContext = this.jdField_a_of_type_AndroidContentContext;
        localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
        for (localObject = "2";; localObject = "1")
        {
          ReportUtil.a(localArticleInfo1, "0X8008990", RIJTransMergeKanDianReport.a(localContext, localArticleInfo2, i, (String)localObject).toString());
          break;
        }
      }
      if ("scroll to history location failed cuz activity or articleinfo is null" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null) {}
      for (localObject = "activity is null";; localObject = "")
      {
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, (String)localObject);
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
      {
        QLog.d("ReadInJoyFastWebBottomSocialView", 2, "like click event failed");
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean = false;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
        ((FastWebArticleInfo)localObject).jdField_a_of_type_Int -= 1;
        ReportUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009765", "1");
      }
      for (;;)
      {
        b();
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Int);
        ReadInJoyLogicEngineEventDispatcher.a().d();
        ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
        break;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
        ((FastWebArticleInfo)localObject).jdField_a_of_type_Int += 1;
        ReportUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009764", "1");
      }
      bool = false;
      break label140;
    }
    if (!this.jdField_c_of_type_AndroidWidgetImageView.isSelected()) {}
    for (;;)
    {
      d(bool);
      break;
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
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity == null);
    ArticleInfo localArticleInfo1;
    Context localContext;
    ArticleInfo localArticleInfo2;
    int i;
    if (BiuBehaviour.b() == 1)
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
      ReportUtil.a(localArticleInfo1, "0X8008991", RIJTransMergeKanDianReport.a(localContext, localArticleInfo2, i, paramView, 0).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView
 * JD-Core Version:    0.7.0.1
 */