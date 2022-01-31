package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.FetchCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TitleData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebActivityStackUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebActivityStackUtil.SaveState;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.RecommendAndAdCallback;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.HtmlChangeUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.SavedState;
import com.tencent.widget.EdgeEffect;
import com.tencent.widget.XListView;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mlu;
import mlx;
import mly;
import mlz;
import mma;
import mmb;
import mmc;
import mmf;
import mmh;
import mmi;
import mmk;
import mmm;
import mmn;
import mmo;
import mmp;
import mmr;
import mms;
import mmt;
import mmu;
import mmv;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebActivity
  extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, ArticleCommentModule.FetchCommentObserver, FaceDecoder.DecodeTaskCompletionListener, Observer
{
  volatile int jdField_a_of_type_Int = 0;
  protected long a;
  private View jdField_a_of_type_AndroidViewView;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArticleCommentModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new mmc(this);
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  ReadInJoyAtlasManager.AtlasCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback = new mmn(this);
  private FastWebModule.FastWebArticleRichReqCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule$FastWebArticleRichReqCallback = new mlu(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private TitleData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData;
  private ItemShowDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
  private FastWebActivityStackUtil.SaveState jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState;
  private FastWebActivityStackUtil jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil = new FastWebActivityStackUtil(this);
  private FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private FastWebRequestUtil.RecommendAndAdCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRequestUtil$RecommendAndAdCallback = new mmk(this);
  private FastWebShareUtils jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils = new FastWebShareUtils();
  private Share jdField_a_of_type_ComTencentBizWebviewpluginShare;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new mmb(this);
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new mmi(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected String a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int = -1;
  protected long b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "FastWebActivity";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString = System.currentTimeMillis() + "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 1000;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  private float a()
  {
    int j = 0;
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_Int < 0))
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    int m;
    for (int k = 0; j < this.jdField_a_of_type_ArrayOfInt.length; k = m)
    {
      int n = this.jdField_a_of_type_ArrayOfInt[j];
      m = k;
      if (j <= this.jdField_c_of_type_Int) {
        m = k + n;
      }
      j += 1;
    }
    j = k - this.jdField_d_of_type_Int;
    if (j >= this.jdField_b_of_type_Int) {
      return 1.0F;
    }
    return j / this.jdField_b_of_type_Int;
  }
  
  private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    int j = (int)paramArticleInfo.mChannelID;
    Object localObject;
    if (paramFastWebArticleInfo.c()) {
      localObject = "2";
    }
    for (;;)
    {
      localObject = ReadInJoyUtils.a(this, paramArticleInfo, j, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("comment", paramFastWebArticleInfo.jdField_b_of_type_Long);
        ReportUtil.a(paramArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
        b();
        return;
        localObject = "1";
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        for (;;)
        {
          paramFastWebArticleInfo.printStackTrace();
        }
      }
    }
  }
  
  private void a(BaseData paramBaseData, String paramString)
  {
    QLog.e("Q.readinjoy.fast_web", 2, "errorUrl " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl + "  errorType " + paramBaseData.jdField_d_of_type_Int + " detail: " + paramString);
    throw new IllegalArgumentException(paramString);
  }
  
  private void a(FastWebActivityStackUtil.SaveState paramSaveState)
  {
    t();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramSaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState = paramSaveState;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    g();
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_d_of_type_Boolean);
  }
  
  private void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.jdField_c_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void b(Intent paramIntent)
  {
    t();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
    this.jdField_a_of_type_Boolean = true;
    g();
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    int j = (int)paramArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (ReadInJoyBaseAdapter.a(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!ReadInJoyBaseAdapter.d(paramArticleInfo)) {
        localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a.get(0)).jdField_b_of_type_JavaLangString;
      }
    }
    localObject2 = localObject1;
    if (!(paramArticleInfo instanceof AdvertisementInfo))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject1 = (String)localObject1 + "&";
        localObject2 = (String)localObject1 + "from=0";
      }
    }
    else
    {
      localObject1 = localObject2;
      if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
      {
        localObject1 = localObject2;
        if (NetworkUtil.h(null)) {
          if (!((String)localObject2).contains("?")) {
            break label382;
          }
        }
      }
    }
    label382:
    for (localObject1 = (String)localObject2 + "&";; localObject1 = (String)localObject2 + "?")
    {
      localObject1 = (String)localObject1 + "acttype=42";
      localObject2 = new Intent(this, ReadInJoyArticleDetailActivity.class);
      localBundle.putString("url", (String)localObject1);
      localBundle.putBoolean("hide_operation_bar", true);
      localBundle.putBoolean("from_native", true);
      localBundle.putString("from", String.valueOf(53));
      localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
      localBundle.putLong("articleid", paramArticleInfo.mArticleID);
      localBundle.putString("row_key", paramArticleInfo.innerUniqueID);
      localBundle.putInt("channelid", j);
      localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
      localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
      localBundle.putInt("articalChannelId", 9);
      ((Intent)localObject2).putExtras(localBundle);
      startActivityForResult((Intent)localObject2, 10923);
      return;
      localObject1 = (String)localObject1 + "?";
      break;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "setFavoriteArticle but articleInfo is null.");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
    if (paramBoolean)
    {
      ReadInJoyAtlasManager.a();
      ReadInJoyAtlasManager.a(this, false);
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, new Object[] { "setFavoriteArticle, isFavorite = ", Boolean.valueOf(paramBoolean) });
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "waiting for favorite result now, do not request again.");
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c();
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share((QQAppInterface)ReadInJoyUtils.a(), this);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, 9, false);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new mmt(this), 3000L);
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ReadInJoyAtlasManager.a().a(this, localQQAppInterface.getAccount(), 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID));
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "updateFavoriteStatus but fastWebInfo is null.");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(paramBoolean);
  }
  
  private void d()
  {
    try
    {
      Object localObject = findViewById(2131362892);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        ((View)localObject).setFitsSystemWindows(true);
        ((View)localObject).setPadding(0, ImmersiveUtils.a(this), 0, 0);
      }
      if (ThemeUtil.isInNightMode(ReadInJoyUtils.a()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131366820)).inflate();
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      localObject = this.app.a();
      if (localObject != null)
      {
        this.jdField_a_of_type_Int = ((QQMessageFacade)localObject).b();
        ((QQMessageFacade)localObject).addObserver(this);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363381));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367100));
      findViewById(2131363245).setOnClickListener(this);
      findViewById(2131366987).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131367095));
      this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.mEdgeGlowTop.a(getResources().getDrawable(2131492924));
      this.jdField_a_of_type_ComTencentWidgetXListView.mEdgeGlowBottom.a(getResources().getDrawable(2131492924));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollFlingMode(1);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, (QQAppInterface)ReadInJoyUtils.a());
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366884));
      e();
      findViewById(2131367094).setOnClickListener(this);
      findViewById(2131367100).setOnClickListener(this);
      findViewById(2131367092).setOnClickListener(this);
      k();
      g();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      setResult(-10069, getIntent());
      finish();
    }
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363476));
    if (this.jdField_b_of_type_AndroidWidgetImageView.getDrawable() != null) {}
    for (Drawable localDrawable = this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();; localDrawable = this.jdField_b_of_type_AndroidWidgetImageView.getResources().getDrawable(2130846345))
    {
      localDrawable = ImageUtil.a(localDrawable, -16777216);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367093));
      return;
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_b_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_b_of_type_Long + "");
    }
    while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b())
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      localDrawable = getResources().getDrawable(2130840735);
      localDrawable.setAlpha(127);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      findViewById(2131367099).setVisibility(8);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    Drawable localDrawable = getResources().getDrawable(2130840735);
    localDrawable.setAlpha(255);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    findViewById(2131367099).setOnClickListener(this);
  }
  
  private void g()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
    {
      h();
      return;
    }
    f();
    l();
    HashMap localHashMap = new HashMap();
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.l).longValue();
      TimeUtil.b("fast_web_show_light_house_step4_1");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_JavaUtilList = ReadInJoyLogicEngine.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j);
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        TimeUtil.a("HtmlChangeUtil.parse");
        this.jdField_a_of_type_JavaUtilList = HtmlChangeUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaLangString);
        r();
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
          throw new RuntimeException("parse data is empty!");
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "has parse error, use webview open url!" });
      localHashMap.put("param_error", localException.toString());
    }
    for (;;)
    {
      localHashMap.put("param_uin", ReadInJoyUtils.a());
      localHashMap.put("param_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
      localHashMap.put("param_articleID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      localHashMap.put("param_rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "");
      localHashMap.put("param_channelID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      Object localObject1;
      Object localObject2;
      int j;
      if (!bool)
      {
        i();
        return;
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BaseData)((Iterator)localObject1).next();
          ((BaseData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          ((BaseData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
        }
        TimeUtil.a("HtmlChangeUtil.parse");
        j = 0;
        TimeUtil.b("fast_web_show_light_house_step4_2");
        this.jdField_a_of_type_AndroidWidgetBaseAdapter = new WebFastAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
        this.jdField_a_of_type_ComTencentWidgetXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        localObject2 = ReadInJoyLogicEngine.a().a();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState.jdField_a_of_type_AndroidOsParcelable;
          label513:
          if (localObject1 == null) {
            break label622;
          }
          localObject1 = (AbsListView.SavedState)localObject1;
          this.jdField_a_of_type_ComTencentWidgetXListView.onRestoreInstanceState((Parcelable)localObject1);
          b(((AbsListView.SavedState)localObject1).jdField_b_of_type_Int);
          label538:
          if ((this.jdField_f_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState != null)) {
            break label723;
          }
        }
      }
      label622:
      while (j == 0)
      {
        j();
        if (localObject2 == null) {
          break label730;
        }
        ((FastWebModule)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule$FastWebArticleRichReqCallback);
        break label730;
        if (localObject2 != null)
        {
          localObject1 = ((FastWebModule)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
          break label513;
          b(0);
          break label538;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule = new ArticleCommentModule(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, null, System.currentTimeMillis() + "");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.setCommentObsrver(this);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.fetchNextCommentInfo((QQAppInterface)ReadInJoyUtils.a(), 1);
          return;
        }
        localObject1 = null;
        break label513;
        j = 1;
        break;
      }
      label723:
      label730:
      bool = true;
    }
  }
  
  private void h()
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    if (localFastWebModule == null)
    {
      if (!this.jdField_d_of_type_Boolean) {
        i();
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "fastWebModule == null");
      return;
    }
    localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, 1, new mmp(this));
  }
  
  private void i()
  {
    this.jdField_e_of_type_Boolean = true;
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new mmr(this));
  }
  
  private void j()
  {
    getMainLooper();
    Looper.myQueue().addIdleHandler(new mms(this));
  }
  
  private void k()
  {
    View localView = findViewById(2131367096);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "initFavoriteStatus but articleInfo is null.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    ReadInJoyAtlasManager.a().a(localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
  }
  
  private void m()
  {
    getMainLooper();
    Looper.myQueue().addIdleHandler(new mlx(this));
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || ((this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) && (this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount() != this.jdField_a_of_type_ArrayOfInt.length))) {
      QLog.e("Q.readinjoy.fast_web", 2, "refreshMaxReadHeight itemsHeight == null ");
    }
    int k;
    label223:
    for (;;)
    {
      return;
      int m = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
      if (m > this.jdField_c_of_type_Int) {}
      for (j = 1;; j = 0)
      {
        if ((m < this.jdField_c_of_type_Int) || (this.jdField_a_of_type_ArrayOfInt == null)) {
          break label223;
        }
        k = m;
        if (this.jdField_c_of_type_Int > m) {
          k = this.jdField_c_of_type_Int;
        }
        this.jdField_c_of_type_Int = k;
        k = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
        k = this.jdField_c_of_type_Int - k;
        if (k >= this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount()) {
          break;
        }
        View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(k);
        k = this.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
        m = localView.getTop();
        k = this.jdField_a_of_type_ArrayOfInt[this.jdField_c_of_type_Int] - (k - m);
        if (j == 0) {
          break label225;
        }
        this.jdField_d_of_type_Int = k;
        if (this.jdField_d_of_type_Int < 0) {
          this.jdField_d_of_type_Int = 0;
        }
        QLog.d("Q.readinjoy.fast_web", 2, "  mMaxLastPosition  " + this.jdField_c_of_type_Int + "  mMaxLastItemInvisibleHeight " + this.jdField_d_of_type_Int);
        return;
      }
    }
    label225:
    if (k < this.jdField_d_of_type_Int) {}
    for (int j = k;; j = this.jdField_d_of_type_Int)
    {
      this.jdField_d_of_type_Int = j;
      break;
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      Parcelable localParcelable = this.jdField_a_of_type_ComTencentWidgetXListView.onSaveInstanceState();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        FastWebModule localFastWebModule = ((ReadInJoyLogicManager)this.app.getManager(162)).a().a();
        if (localFastWebModule != null) {
          localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", localParcelable);
        }
      }
    }
  }
  
  private void p()
  {
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localBaseData.jdField_d_of_type_Int == 6) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(j, new mlz(this, localBaseData));
      }
      for (;;)
      {
        j += 1;
        break;
        if (AdData.a(localBaseData)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(j, new mma(this, localBaseData));
        }
      }
    }
  }
  
  private void q()
  {
    long l1 = TimeUtil.c("fast_web_show_light_house_1");
    boolean bool = true;
    if (l1 < 0L) {
      return;
    }
    if (this.jdField_d_of_type_Boolean) {
      bool = false;
    }
    long l2 = TimeUtil.c("fast_web_show_light_house_2");
    long l3 = TimeUtil.c("fast_web_show_light_house_3");
    long l4 = TimeUtil.c("fast_web_show_light_house_draw_finish");
    long l5 = TimeUtil.c("fast_web_show_light_house_step4_2");
    long l6 = TimeUtil.c("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", ReadInJoyUtils.a());
    QLog.d("Q.readinjoy.fast_web", 2, "reportSpentTime, params = " + localHashMap.toString() + "  all cost : " + (l4 - l1));
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebCost", bool, l4 - l1, 0L, localHashMap, null);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if (localBaseData == null) {
          throw new IllegalArgumentException("baseData == null : url " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
        }
        Object localObject;
        switch (localBaseData.jdField_d_of_type_Int)
        {
        case 4: 
        default: 
          break;
        case 3: 
          localObject = (ImageData)localBaseData;
          if ((TextUtils.isEmpty(((ImageData)localObject).jdField_a_of_type_JavaLangString)) || (((ImageData)localObject).jdField_a_of_type_Int < 0) || (((ImageData)localObject).jdField_b_of_type_Int < 0)) {
            a(localBaseData, "url=" + ((ImageData)localObject).jdField_a_of_type_JavaLangString + "width=" + ((ImageData)localObject).jdField_a_of_type_Int + "height=" + ((ImageData)localObject).jdField_b_of_type_Int);
          }
          break;
        case 5: 
          localObject = (VideoData)localBaseData;
          if ((TextUtils.isEmpty(((VideoData)localObject).jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(((VideoData)localObject).e)) || (TextUtils.isEmpty(((VideoData)localObject).jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(((VideoData)localObject).d))) {
            a(localBaseData, "vid=" + ((VideoData)localObject).jdField_b_of_type_JavaLangString + "tid=" + ((VideoData)localObject).e + "appid=" + ((VideoData)localObject).jdField_c_of_type_JavaLangString + "appkey=" + ((VideoData)localObject).d);
          }
          break;
        }
      }
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a()) {}
    FastWebActivityStackUtil.SaveState localSaveState;
    do
    {
      return;
      this.i = true;
      doOnPause();
      doOnStop();
      this.i = false;
      localSaveState = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a();
    } while (localSaveState == null);
    a(localSaveState);
    this.i = true;
    doOnStart();
    doOnResume();
    this.i = false;
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = null;
    this.jdField_f_of_type_Boolean = false;
    this.g = false;
    this.h = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = (System.currentTimeMillis() + "");
    this.jdField_a_of_type_ComTencentWidgetXListView.setDrawFinishedListener(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(null);
  }
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    localIntent.putExtra("readinjoy_open_comment_from_image", true);
    PublicFragmentActivity.a(this, localIntent, ReadInJoyCommentListFragment.class, 1001);
  }
  
  public void a(int paramInt)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.size() > 0)) {
      localArticleInfo.businessId = ((ArticleTopicData.TopicInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
    }
    Intent localIntent = new Intent(this, ReadInJoyDeliverBiuActivity.class);
    localIntent.putExtra("arg_article_info", localArticleInfo);
    localIntent.putExtra("biu_src", 4);
    localIntent.putExtra("arg_from_type", paramInt);
    localIntent.putExtra("feedsType", 1);
    startActivity(localIntent);
    overridePendingTransition(0, 0);
  }
  
  public void a(Intent paramIntent)
  {
    this.i = true;
    doOnPause();
    doOnStop();
    this.i = false;
    FastWebActivityStackUtil.SaveState localSaveState = new FastWebActivityStackUtil.SaveState();
    localSaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    localSaveState.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_ComTencentWidgetXListView.onSaveInstanceState();
    localSaveState.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localSaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a(localSaveState);
    this.jdField_c_of_type_JavaLangString = (ReadInJoyUtils.a() + System.currentTimeMillis());
    b(paramIntent);
    this.i = true;
    doOnStart();
    doOnResume();
    this.i = false;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mArticleID == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID))
    {
      runOnUiThread(new mmo(this));
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, paramArticleInfo + ", fetch comment data success !");
      return;
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, paramArticleInfo + ", fetch comment data success ! but article is not equal");
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, paramArticleInfo + ", fetch comment data fail ! err : " + paramInt + ", errMsg : " + paramString);
  }
  
  public void a(XListView paramXListView)
  {
    long l = System.currentTimeMillis();
    WebFastAdapter localWebFastAdapter = (WebFastAdapter)paramXListView.getAdapter();
    if ((localWebFastAdapter == null) || (localWebFastAdapter.getCount() <= 0)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfInt = new int[localWebFastAdapter.getCount()];
    int j = paramXListView.getWidth();
    int k = AIOUtils.a(300.0F, getResources());
    for (;;)
    {
      try
      {
        int m = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
        View localView;
        if (Build.VERSION.SDK_INT <= 19)
        {
          this.jdField_a_of_type_ArrayOfInt[0] = k;
          break label333;
          if (j < localWebFastAdapter.getCount())
          {
            localView = localWebFastAdapter.a(j, null, paramXListView, true);
            localView.measure(m, 0);
            int n = localView.getMeasuredHeight();
            this.jdField_a_of_type_ArrayOfInt[j] = n;
            j += 1;
            continue;
          }
        }
        else
        {
          localView = localWebFastAdapter.a(0, null, paramXListView, true);
          localView.measure(m, 0);
          this.jdField_a_of_type_ArrayOfInt[0] = localView.getMeasuredHeight();
        }
      }
      catch (Exception paramXListView)
      {
        QLog.e("Q.readinjoy.fast_web", 2, paramXListView, new Object[] { "measureItemHeight sdk version : " + Build.VERSION.SDK_INT });
        j = 0;
        if (j < localWebFastAdapter.getCount())
        {
          this.jdField_a_of_type_ArrayOfInt[j] = k;
          j += 1;
          continue;
          if (this.jdField_b_of_type_Int < 0)
          {
            j = 0;
            if (j < this.jdField_a_of_type_JavaUtilList.size())
            {
              if (((BaseData)this.jdField_a_of_type_JavaUtilList.get(j)).a()) {
                this.jdField_b_of_type_Int += this.jdField_a_of_type_ArrayOfInt[j];
              }
              j += 1;
              continue;
            }
          }
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_ArrayOfInt);
        QLog.d("Q.readinjoy.fast_web", 2, " measure item   : " + (System.currentTimeMillis() - l));
        return;
      }
      label333:
      j = 1;
    }
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {}
    for (Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      Object localObject2 = URLUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
      if (((Map)localObject2).containsKey("_wv")) {}
      for (;;)
      {
        try
        {
          j = Integer.valueOf((String)((Map)localObject2).get("_wv")).intValue();
          localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430138);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840673;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 34;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
          localArrayList.add(localObject2);
          if ((j & 0x8) == 0L)
          {
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430108);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838336;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 2;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
            localArrayList.add(localObject2);
          }
          if ((j & 0x10) == 0L)
          {
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430114);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838337;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 3;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
            localArrayList.add(localObject2);
          }
          if (localObject1 != null)
          {
            localObject2 = "readinjoy_" + ((AppRuntime)localObject1).getAccount() + "_" + 1;
            localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
            if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false)))
            {
              localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430128);
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838335;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 13;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
              localArrayList.add(localObject2);
            }
          }
          if ((j & 0x4000) == 0L)
          {
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430126);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838340;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 9;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
            localArrayList.add(localObject2);
          }
          if ((j & 0x8000) == 0L)
          {
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430127);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838334;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 10;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
            localArrayList.add(localObject2);
          }
          localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430132);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838339;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 12;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
          localArrayList.add(localObject2);
          if ((j & 0x100) == 0L)
          {
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430112);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840672;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 4;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
            localArrayList.add(localObject2);
          }
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && ((j & 0x2000) == 0L))
          {
            localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430124);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130841573;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 6;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
            ((ArrayList)localObject2).add(localObject1);
          }
          if ((j & 0x20) == 0L)
          {
            localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430110);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130838332;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 1;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
            ((ArrayList)localObject2).add(localObject1);
          }
          localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = getString(2131430111);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130840663;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 11;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
          ((ArrayList)localObject2).add(localObject1);
          return (List[])new ArrayList[] { localArrayList, localObject2 };
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
        int j = 0;
      }
    }
  }
  
  protected void b()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new ReportInfo.FeedsReportData();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mSourceArticleId = ((ArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((ArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((ArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((ArticleInfo)localObject2).mServerContext;
      localReportInfo.mInnerId = ((ArticleInfo)localObject2).innerUniqueID;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
          ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        }
        ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_d_of_type_Int;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((SocializeFeedsInfo.FeedsInfoUser)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((ReportInfo.FeedsReportData)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    ReadInJoyLogicEngine.a().a((List)localObject1);
  }
  
  public void c()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label104;
      }
      if ((!SystemUtil.b()) && (!SystemUtil.d())) {
        this.mSystemBarComp.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label104:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      a(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void doOnBackPressed()
  {
    this.jdField_f_of_type_Boolean = true;
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramBundle.get("fast_web_article_info"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      paramBundle = paramBundle.getBundle("banner_webview_extra");
      if ((paramBundle != null) && (paramBundle.get("fast_web_article_info") != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramBundle.get("fast_web_article_info"));
        this.jdField_f_of_type_Int = 1001;
      }
    }
    else
    {
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      this.jdField_c_of_type_JavaLangString = (ReadInJoyUtils.a() + System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.process.fav");
      getBaseContext().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, paramBundle);
      setContentView(2130969606);
      d();
      return true;
    }
    setResult(-10069, getIntent());
    finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c();
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null) {
      getBaseContext().unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
    if (this.app != null)
    {
      localObject = this.app.a();
      if (localObject != null) {
        ((QQMessageFacade)localObject).deleteObserver(this);
      }
    }
    VideoAutoPlayController.a(BaseApplicationImpl.getContext()).jdField_b_of_type_Boolean = false;
    Object localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null) {
      ((FastWebModule)localObject).a();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    a(paramIntent);
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    AbstractGifImage.pauseAll();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
      localObject1 = "2";
    }
    for (;;)
    {
      localObject1 = ReadInJoyUtils.a(this, (ArticleInfo)localObject2, 0, (String)localObject1);
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.jdField_c_of_type_Long) / 1000.0F;
        float f2 = a();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.jdField_c_of_type_JavaLangString);
        QLog.d("Q.readinjoy.fast_web", 2, "  time " + f1 + "  ratio : " + f2 + " session : " + this.jdField_c_of_type_JavaLangString);
        ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
        l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
        if (this.i) {}
      }
      catch (Exception localException)
      {
        try
        {
          long l;
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
          ((JSONObject)localObject1).put("algorithm_id", this.jdField_e_of_type_Long);
          ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
          ((JSONObject)localObject1).put("session_id", this.jdField_c_of_type_JavaLangString);
          ((JSONObject)localObject1).put("os", "1");
          ((JSONObject)localObject1).put("version", "7.6.3".replace(".", ""));
          ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_JavaLangString);
          localObject1 = ((JSONObject)localObject1).toString();
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FB", "0X80066FB", 0, 0, Long.toString(l / 1000L), Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_e_of_type_Int), (String)localObject1, false);
          localObject1 = new ArrayList();
          localObject2 = new ReportInfo();
          ((ReportInfo)localObject2).mUin = ReadInJoyUtils.a();
          ((ReportInfo)localObject2).mSource = 0;
          ((ReportInfo)localObject2).mSourceArticleId = this.jdField_a_of_type_Long;
          ((ReportInfo)localObject2).mChannelId = ((int)this.jdField_b_of_type_Long);
          ((ReportInfo)localObject2).mAlgorithmId = ((int)this.jdField_e_of_type_Long);
          ((ReportInfo)localObject2).mStrategyId = this.jdField_e_of_type_Int;
          ((ReportInfo)localObject2).mOperation = 9;
          ((ReportInfo)localObject2).mOpSource = 12;
          ((ReportInfo)localObject2).mReadTimeLength = ((int)(l / 1000L));
          ((ReportInfo)localObject2).mInnerId = this.jdField_a_of_type_JavaLangString;
          ((ReportInfo)localObject2).mArticleLength = this.jdField_b_of_type_Int;
          ((ReportInfo)localObject2).mReadArticleLength = ((int)(this.jdField_b_of_type_Int * a()));
          ((List)localObject1).add(localObject2);
          ThreadManager.getSubThreadHandler().post(new mly(this, (List)localObject1));
          return;
          localObject1 = "1";
          continue;
          localException = localException;
          QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("Q.readinjoy.fast_web", 2, localJSONException, new Object[] { "0X80066FB!" });
          }
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!this.i) {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
    TimeUtil.b("fast_web_show_light_house_3");
    c();
    AbstractGifImage.resumeAll();
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      }
      this.jdField_c_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a())
    {
      if (this.jdField_f_of_type_Int == 1001) {
        ReadInJoyActivityHelper.a(this.app, this, 11, 0);
      }
      super.finish();
    }
    this.jdField_d_of_type_Boolean = true;
    q();
    o();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      str1 = "";
      if (!this.jdField_f_of_type_Boolean) {
        break label135;
      }
    }
    label135:
    for (String str2 = "1";; str2 = "2")
    {
      PublicAccountReportUtils.a(null, "CliOper", "", str1, "0X8008995", "0X8008995", 0, 0, str2, null, null, null, false);
      s();
      return;
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID + "";
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10922) {
      if (paramInt2 == -10069) {
        ReadInJoyUtils.a(this, ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt1 != 10923) {
              break;
            }
          } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState != null));
          finish();
          return;
          if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == -1))
          {
            paramIntent = paramIntent.getStringExtra("arg_result_json");
            ReadInJoyCommentUtils.a((QQAppInterface)getAppRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, null, paramIntent, false, null, 1, new mmf(this, paramIntent));
            return;
          }
        } while ((paramInt1 != 1001) || (paramIntent == null));
        paramIntent = paramIntent.getSerializableExtra("backToImageData");
      } while (!(paramIntent instanceof List));
      paramIntent = (List)paramIntent;
    } while (paramIntent.isEmpty());
    ItemDatasListUtils.b(this.jdField_a_of_type_JavaUtilList, paramIntent);
    ThreadManager.getUIHandler().post(new mmh(this));
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "update comments info from commentlist activity ! size : " + paramIntent.size());
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if ((paramView.getId() != 2131363245) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    Object localObject;
    ArticleInfo localArticleInfo;
    int j;
    switch (paramView.getId())
    {
    case 2131367094: 
    default: 
      return;
    case 2131363245: 
      this.jdField_f_of_type_Boolean = true;
      finish();
      return;
    case 2131366987: 
      a(18);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      j = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (paramView = "2";; paramView = "1")
      {
        ReportUtil.a((ArticleInfo)localObject, "0X8008991", ReadInJoyUtils.a(this, localArticleInfo, j, paramView).toString());
        return;
      }
    case 2131363476: 
      o();
      startActivity(ReadInJoyUtils.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
      return;
    case 2131366884: 
      a();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      j = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (paramView = "2";; paramView = "1")
      {
        ReportUtil.a((ArticleInfo)localObject, "0X8008990", ReadInJoyUtils.a(this, localArticleInfo, j, paramView).toString());
        return;
      }
    case 2131367099: 
      this.jdField_c_of_type_Boolean = true;
      ReadInJoyCommentUtils.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 4, "发表评论", null, false, null, false);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      j = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (paramView = "2";; paramView = "1")
      {
        ReportUtil.a((ArticleInfo)localObject, "0X8008990", ReadInJoyUtils.a(this, localArticleInfo, j, paramView).toString());
        return;
      }
    case 2131367100: 
      if (!this.jdField_a_of_type_AndroidWidgetImageView.isSelected()) {
        bool = true;
      }
      b(bool);
      if (bool)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        j = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
        for (paramView = "2";; paramView = "1")
        {
          ReportUtil.a((ArticleInfo)localObject, "0X800900B", ReadInJoyUtils.a(localArticleInfo, j, paramView));
          return;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      j = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (paramView = "2";; paramView = "1")
      {
        ReportUtil.a((ArticleInfo)localObject, "0X800901D", ReadInJoyUtils.a(localArticleInfo, j, paramView));
        return;
      }
    case 2131367092: 
      if (paramView.getId() == 2131367092)
      {
        this.g = false;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        j = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
        for (paramView = "2";; paramView = "1")
        {
          ReportUtil.a((ArticleInfo)localObject, "0X800898C", ReadInJoyUtils.a(this, localArticleInfo, j, paramView).toString());
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a());
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this);
          }
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.i.split("\\|");
          paramView = "";
          if (localObject.length > 0) {
            paramView = localObject[((int)(java.lang.Math.random() * localObject.length))];
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(paramView);
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(new mmu(this));
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
        }
      }
      this.g = true;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      j = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (paramView = "2";; paramView = "1")
      {
        ReportUtil.a((ArticleInfo)localObject, "0X8008993", ReadInJoyUtils.a(this, localArticleInfo, j, paramView).toString());
        break;
      }
    }
    if (!this.jdField_a_of_type_ComTencentWidgetXListView.isStackFromBottom()) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(false);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount())
      {
        BaseItemViewHolder localBaseItemViewHolder = (BaseItemViewHolder)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if (localBaseItemViewHolder != null) {
          localBaseItemViewHolder.a(paramString, paramBitmap);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramView = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView != null)
      {
        bool = true;
        QLog.d(paramView, 2, bool);
      }
    }
    else
    {
      if (paramAdapterView != null) {
        break label64;
      }
    }
    label64:
    do
    {
      return;
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
      }
      this.h = true;
      paramInt = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.jdField_c_of_type_Int;
      if (paramInt == 1)
      {
        ((ClipboardManager)getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
        QRUtils.a(2, 2131430005);
        if (this.g) {}
        for (paramAdapterView = "0X8008994";; paramAdapterView = "0X800898D")
        {
          FastWebShareUtils.a(this, paramAdapterView, 9, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          return;
        }
      }
      if (paramInt == 4)
      {
        paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl));
        paramAdapterView.putExtra("normal", true);
        try
        {
          startActivity(paramAdapterView);
          return;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          QRUtils.a(1, 2131430028);
          return;
        }
      }
    } while (paramInt == 5);
    if (paramInt == 34)
    {
      a(17);
      return;
    }
    if (paramInt == 6)
    {
      b(true);
      return;
    }
    if (paramInt == 11)
    {
      ThreadManager.executeOnSubThread(new mmv(this));
      return;
    }
    ReadInJoyLogicEngine.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule$FastWebArticleRichReqCallback);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!(paramObject instanceof MessageRecord)) || (((MessageRecord)paramObject).isSendFromLocal()) || (this.app == null)) {}
    int j;
    do
    {
      do
      {
        return;
        paramObservable = this.app.a();
      } while (paramObservable == null);
      j = paramObservable.b();
    } while (j <= this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = j;
    runOnUiThread(new mmm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */