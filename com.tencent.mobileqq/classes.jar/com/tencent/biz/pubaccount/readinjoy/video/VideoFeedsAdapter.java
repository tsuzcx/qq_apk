package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.VideoShareUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAnimUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.gdtad.util.GdtAppOpenUtil;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lzk;
import lzl;
import lzm;
import lzn;
import lzo;
import lzp;
import lzs;
import lzt;
import lzu;
import lzv;
import lzx;
import lzy;
import lzz;
import maa;
import mab;
import mac;
import mad;
import mae;
import maf;
import mag;
import mah;
import mai;
import maj;
import mak;
import mal;
import mam;
import man;
import mao;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsAdapter
  extends BaseAdapter
  implements View.OnClickListener, AdapterView.OnItemClickListener, VideoFeedsGestureLayout.CustomClickListener
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new lzk(this, Looper.getMainLooper());
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private VideoFeedsAdapter.AdapterEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener;
  private VideoFeedsAdapter.BaseItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseItemHolder;
  private VideoFeedsAdapter.BaseVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder;
  private VideoFeedsAppJumpManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppJumpManager;
  private VideoFeedsCommentManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager;
  public VideoFeedsListView.ListViewEventListener a;
  private VideoFeedsListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new mad(this);
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public final MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private String jdField_b_of_type_JavaLangString;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private Set jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 5;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private Set jdField_c_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private boolean j;
  private boolean k = true;
  private boolean l;
  private boolean m;
  private boolean n;
  
  VideoFeedsAdapter(Context paramContext, Activity paramActivity, VideoFeedsListView paramVideoFeedsListView, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$ListViewEventListener = new lzv(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new lzp(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView = paramVideoFeedsListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$ListViewEventListener);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.b();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840829);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840832);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492970));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = VideoAutoPlayController.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(250L);
    this.jdField_a_of_type_Boolean = paramBoolean;
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private Intent a(VideoInfo paramVideoInfo)
  {
    AbsStructMsg localAbsStructMsg = null;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("detail_url", paramVideoInfo.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("title", paramVideoInfo.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("image_url_remote", paramVideoInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131430100, new Object[] { paramVideoInfo.jdField_c_of_type_JavaLangString }));
    if (paramVideoInfo.jdField_a_of_type_Int == 6)
    {
      localIntent.putExtra("struct_share_key_source_icon", "https://q.url.cn/s/jBJuV");
      localIntent.putExtra("app_name", "QQ看点");
      localIntent.putExtra("struct_share_key_source_action", "plugin");
      localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localAbsStructMsg = StructMsgFactory.a(localIntent.getExtras());
      localAbsStructMsg.mMsgServiceID = 83;
    }
    for (;;)
    {
      if (localAbsStructMsg != null) {
        localIntent.putExtra("stuctmsg_bytes", localAbsStructMsg.getBytes());
      }
      return localIntent;
      if (paramVideoInfo.jdField_a_of_type_Int == 7)
      {
        localIntent.putExtra("app_name", "QQ搜索");
        localIntent.putExtra("desc", paramVideoInfo.jdField_d_of_type_JavaLangString);
        localAbsStructMsg = StructMsgFactory.a(localIntent.getExtras());
        localAbsStructMsg.mMsgServiceID = 1;
      }
    }
  }
  
  private Drawable a(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localBitmap);
    }
    for (;;)
    {
      return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
  }
  
  private Bundle a(VideoInfo paramVideoInfo)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("VINFO", paramVideoInfo.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putString("TINFO", paramVideoInfo.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_TIME", paramVideoInfo.jdField_d_of_type_Int);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_WIDTH", paramVideoInfo.jdField_b_of_type_Int);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_HEIGHT", paramVideoInfo.jdField_c_of_type_Int);
    ((Bundle)localObject).putInt("FULL_VIDEO_TIME", paramVideoInfo.jdField_d_of_type_Int);
    ((Bundle)localObject).putString("source_puin", paramVideoInfo.jdField_j_of_type_JavaLangString);
    ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_UIN", paramVideoInfo.jdField_j_of_type_JavaLangString);
    ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_NAME", paramVideoInfo.k);
    ((Bundle)localObject).putInt("TYPE", paramVideoInfo.jdField_a_of_type_Int);
    ((Bundle)localObject).putString("ARTICLE_ID", paramVideoInfo.jdField_g_of_type_JavaLangString);
    ((Bundle)localObject).putInt("layout_item", 5);
    ((Bundle)localObject).putBoolean("video_url_load", false);
    ((Bundle)localObject).putString("image_url_remote", paramVideoInfo.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject).putString("detail_url", paramVideoInfo.jdField_f_of_type_JavaLangString + "&sourcefrom=0");
    ((Bundle)localObject).putString("video_url", paramVideoInfo.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putString("title", paramVideoInfo.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putString("req_create_time", paramVideoInfo.jdField_e_of_type_JavaLangString);
    ((Bundle)localObject).putString("brief_key", paramVideoInfo.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putInt("PREVIEW_START_POSI", VideoPlayUtils.a((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a()));
    localObject = (StructMsgForGeneralShare)StructMsgFactory.a((Bundle)localObject);
    if ((!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject).mMsgBrief)) && (((StructMsgForGeneralShare)localObject).mMsgBrief.indexOf("[视频]") == -1)) {
      ((StructMsgForGeneralShare)localObject).mMsgBrief = ("[视频]" + ((StructMsgForGeneralShare)localObject).mMsgBrief);
    }
    String str1 = paramVideoInfo.jdField_m_of_type_JavaLangString;
    String str2 = paramVideoInfo.l;
    PAVideoStructMsgUtil.a((StructMsgForGeneralShare)localObject);
    ((StructMsgForGeneralShare)localObject).mSourceAction = "web";
    String str3 = paramVideoInfo.jdField_j_of_type_JavaLangString;
    String str4 = PAVideoStructMsgUtil.a(str3);
    String str5 = paramVideoInfo.k;
    if (!TextUtils.isEmpty(str3)) {
      ((StructMsgForGeneralShare)localObject).mSourceAppid = Long.valueOf(str3).longValue();
    }
    ((StructMsgForGeneralShare)localObject).source_puin = paramVideoInfo.jdField_j_of_type_JavaLangString;
    if (paramVideoInfo.jdField_a_of_type_Int > 1) {
      if ((!TextUtils.isEmpty(str3)) && (!str3.equals("16888")))
      {
        ((StructMsgForGeneralShare)localObject).mSourceUrl = str4;
        if ((str5 != null) && (!"".equals(str5))) {
          ((StructMsgForGeneralShare)localObject).mSourceThirdName = str5;
        }
        label434:
        if ((str5 != null) && (!"".equals(str5))) {
          ((StructMsgForGeneralShare)localObject).mSourceName = str5;
        }
        if ((str1 == null) || ("".equals(str1))) {
          break label556;
        }
      }
    }
    label556:
    for (((StructMsgForGeneralShare)localObject).mSourceIcon = str1;; ((StructMsgForGeneralShare)localObject).mSourceIcon = "https://q.url.cn/s/jBJuV")
    {
      ((StructMsgForGeneralShare)localObject).setFlag(0);
      paramVideoInfo = new Bundle();
      paramVideoInfo.putInt("forward_type", -3);
      paramVideoInfo.putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject).mMsgServiceID);
      paramVideoInfo.putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject).getBytes());
      return paramVideoInfo;
      if (!TextUtils.isEmpty(str2))
      {
        ((StructMsgForGeneralShare)localObject).mSourceUrl = str2;
        break;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = "";
      break;
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str4;
      break label434;
    }
  }
  
  @TargetApi(9)
  private View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968984, null);
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131363794);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131363796);
    GridView localGridView2 = (GridView)localView.findViewById(2131363795);
    GridView localGridView1 = (GridView)localView.findViewById(2131363797);
    Object localObject1 = (TextView)localView.findViewById(2131362797);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f1));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131432998);
    ((TextView)localObject1).setOnClickListener(new lzt(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new lzu(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      localElasticHorScrView1.setOverScrollMode(2);
      localElasticHorScrView2.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label438;
      }
    }
    label438:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i1 = ((List)localObject1).size();
      localGridView2.setNumColumns(i1);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i1 - 1) * 10 + i1 * 75 + 3) * f1));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i1 = localLayoutParams.width;
      int i2 = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f1 * (i2 * 75 + (i2 - 1) * 10 + 3)));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(i2);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new lzx(this, localElasticHorScrView1, i1, localElasticHorScrView2, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  private void a(int paramInt1, VideoFeedsAdapter.BaseVideoItemHolder paramBaseVideoItemHolder, VideoInfo paramVideoInfo, int paramInt2)
  {
    if (((paramInt1 == 0) && ((this.jdField_a_of_type_AndroidAppActivity instanceof VideoFeedsPlayActivity)) && (this.jdField_f_of_type_Boolean)) || (paramVideoInfo.jdField_a_of_type_Boolean))
    {
      paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView.setText("");
      paramBaseVideoItemHolder.m.setText("");
      paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      paramBaseVideoItemHolder.m.getPaint().setFakeBoldText(true);
      if ((paramVideoInfo.jdField_a_of_type_Int == 0) || (paramVideoInfo.jdField_a_of_type_Int == 5)) {
        break label599;
      }
      paramBaseVideoItemHolder.jdField_i_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.a(paramVideoInfo.jdField_j_of_type_Int));
      paramBaseVideoItemHolder.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      label107:
      paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setTag(paramBaseVideoItemHolder);
      paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      Object localObject = paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = paramVideoInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity);
      ((ViewGroup.LayoutParams)localObject).width = -1;
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(paramBaseVideoItemHolder);
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(paramBaseVideoItemHolder);
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(409409L);
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramBaseVideoItemHolder);
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localObject = paramVideoInfo.a();
      if (localObject == null) {
        break label611;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      label334:
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      VideoFeedsHelper.a(paramBaseVideoItemHolder.jdField_e_of_type_AndroidWidgetTextView, 0L);
      VideoFeedsHelper.a(paramBaseVideoItemHolder.g, paramVideoInfo.a() * 1000);
      if ((this.jdField_b_of_type_Boolean) || (paramInt1 != 0)) {
        break label622;
      }
      paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      label401:
      paramBaseVideoItemHolder.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramBaseVideoItemHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if ((!TextUtils.isEmpty(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString)) && (!paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
        break label634;
      }
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      label461:
      paramBaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramBaseVideoItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setTag(paramBaseVideoItemHolder);
      paramBaseVideoItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label645;
      }
      paramBaseVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      paramBaseVideoItemHolder.k.setVisibility(8);
      paramBaseVideoItemHolder.j.setText(VideoFeedsHelper.b(paramVideoInfo.jdField_b_of_type_Long) + "流量");
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramBaseVideoItemHolder.j.setVisibility(8);
      paramBaseVideoItemHolder.l.setVisibility(8);
      return;
      paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      paramBaseVideoItemHolder.m.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      break;
      label599:
      paramBaseVideoItemHolder.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      break label107;
      label611:
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      break label334;
      label622:
      paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label401;
      label634:
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      break label461;
      label645:
      paramBaseVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.size() <= 0)) {}
    while (this.m) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "showAdNeg");
    }
    this.m = true;
    Paint localPaint = new Paint();
    localPaint.setTextSize(AIOUtils.a(14.0F, paramView.getResources()));
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    float f2;
    for (float f1 = 0.0F; i1 < paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.size(); f1 = f2)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = i1;
      localMenuItem.jdField_a_of_type_JavaLangString = ((VideoAdInfo.NegFeedback)paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.get(i1)).jdField_a_of_type_JavaLangString;
      localMenuItem.jdField_b_of_type_JavaLangString = "#07D0B0";
      localMenuItem.jdField_a_of_type_Float = 14.0F;
      localMenuItem.jdField_c_of_type_JavaLangString = localMenuItem.jdField_a_of_type_JavaLangString;
      localMenuItem.jdField_b_of_type_Int = 0;
      localArrayList.add(localMenuItem);
      float f3 = localPaint.measureText(localMenuItem.jdField_a_of_type_JavaLangString);
      f2 = f1;
      if (f3 > f1) {
        f2 = f3;
      }
      i1 += 1;
    }
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      bool2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      bool1 = bool2;
      if (bool2) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      i1 = Math.round(f1) + AIOUtils.a(30.0F, paramView.getResources());
      int i2 = AIOUtils.a(10.0F, paramView.getResources());
      int i3 = AIOUtils.a(6.0F, paramView.getResources());
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, new mam(this, paramVideoInfo), new man(this, bool1), i1);
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, paramView.getWidth() - i1 - i2, i3 * -1);
      return;
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "gotoAdMore");
    }
    if ((paramVideoInfo == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))) {
      return;
    }
    Object localObject;
    if (paramVideoInfo.c())
    {
      localObject = GdtBaseAdItem.obtain(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.r).setTraceId(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h).setProductId(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.i).setDeepLinkUrl(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.n).setAutoDownLoad(true).setDownloadScheme(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_f_of_type_JavaLangString);
      ((GdtBaseAdItem)localObject).setDeepLinkUrl(null).setPackageName(null);
      GdtAppOpenUtil.a((GdtBaseAdItem)localObject);
    }
    for (;;)
    {
      VideoReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, null);
      return;
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramVideoInfo.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    }
  }
  
  private void a(VideoFeedsAdapter.ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo, int paramInt)
  {
    Object localObject1;
    if (paramVideoInfo.jdField_a_of_type_Int != 0) {
      if (paramInt == 4)
      {
        paramADVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramADVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setTag(paramADVideoItemHolder);
        paramADVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramADVideoItemHolder);
        paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        if (!TextUtils.isEmpty(paramVideoInfo.k)) {
          paramADVideoItemHolder.n.setText(paramVideoInfo.k);
        }
        if (TextUtils.isEmpty(paramVideoInfo.jdField_j_of_type_JavaLangString)) {
          break label271;
        }
        localObject1 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramVideoInfo.jdField_j_of_type_JavaLangString, 3, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
        paramADVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        label115:
        if (paramInt != 4) {
          break label473;
        }
        paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramADVideoItemHolder);
        paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        localObject1 = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView.getResources();
        paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject1).getDisplayMetrics().widthPixels * 0.7D));
        if (TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) {
          break label439;
        }
        paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject1).getDisplayMetrics().widthPixels * 0.224D));
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l))) {
        break label457;
      }
      paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l);
      return;
      paramADVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(paramADVideoItemHolder);
      paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      break;
      label271:
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramADVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramADVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramVideoInfo.jdField_m_of_type_JavaLangString)) {
            break label411;
          }
          localObject1 = new URL("https://q.url.cn/s/jBJuV");
          localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
          paramADVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (MalformedURLException localMalformedURLException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException.getMessage());
        break;
        label411:
        localObject2 = new URL(paramVideoInfo.jdField_m_of_type_JavaLangString);
      }
      paramADVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      break label115;
      label439:
      paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((Resources)localObject2).getText(2131438669));
    }
    label457:
    paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((Resources)localObject2).getText(2131438670));
    return;
    label473:
    paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    Object localObject2 = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString))
    {
      ((SpannableStringBuilder)localObject2).append(ReadInJoyUtils.a(paramVideoInfo.jdField_c_of_type_JavaLangString, 72));
      ((SpannableStringBuilder)localObject2).append("  ");
    }
    Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l))) {
      paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l;
    }
    for (;;)
    {
      paramInt = AIOUtils.a(paramVideoInfo.length() * 11 + 19, (Resources)localObject3);
      int i1 = AIOUtils.a(16.0F, (Resources)localObject3);
      Bitmap localBitmap = Bitmap.createBitmap(paramInt, i1, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localCanvas.drawBitmap(BitmapFactory.decodeResource((Resources)localObject3, 2130840676), AIOUtils.a(4.0F, (Resources)localObject3), AIOUtils.a(4.0F, (Resources)localObject3), localPaint);
      localPaint.setTextSize(AIOUtils.a(11.0F, (Resources)localObject3));
      localPaint.setColor(-1);
      localCanvas.drawText(paramVideoInfo, AIOUtils.a(15.0F, (Resources)localObject3), AIOUtils.a(12.0F, (Resources)localObject3), localPaint);
      int i2 = AIOUtils.a(2.0F, (Resources)localObject3);
      int i3 = AIOUtils.a(1.0F, (Resources)localObject3);
      int i4 = AIOUtils.a(0.5F, (Resources)localObject3);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(i3);
      localPaint.setColor(2147483647);
      localCanvas.drawLine(i2 + i4, i4, paramInt - i2 - i4, i4, localPaint);
      localCanvas.drawLine(i2 + i4, i1 - i4, paramInt - i2 - i4, i1 - i4, localPaint);
      localCanvas.drawLine(i4, i2 + i4, i4, i1 - i2 - i4, localPaint);
      localCanvas.drawLine(paramInt - i4, i2 + i4, paramInt - i4, i1 - i2 - i4, localPaint);
      localCanvas.drawArc(new RectF(i4, i4, i2 * 2 + i4, i2 * 2 + i4), -180.0F, 90.0F, false, localPaint);
      localCanvas.drawArc(new RectF(paramInt - i2 * 2 - i4, i4, paramInt - i4, i2 * 2 + i4), -90.0F, 90.0F, false, localPaint);
      localCanvas.drawArc(new RectF(i4, i1 - i2 * 2 - i4, i2 * 2 + i4, i1 - i4), 90.0F, 90.0F, false, localPaint);
      localCanvas.drawArc(new RectF(paramInt - i2 * 2 - i4, i1 - i2 * 2 - i4, paramInt - i4, i1 - i4), 0.0F, 90.0F, false, localPaint);
      ((SpannableStringBuilder)localObject2).setSpan(new ImageSpan(this.jdField_a_of_type_AndroidContentContext, localBitmap, 0), ((SpannableStringBuilder)localObject2).length() - 1, ((SpannableStringBuilder)localObject2).length(), 33);
      paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView.setTag(paramADVideoItemHolder);
      paramADVideoItemHolder.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      paramADVideoItemHolder.jdField_e_of_type_AndroidWidgetLinearLayout.setTag(paramADVideoItemHolder);
      return;
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_c_of_type_Int == 12)) {
        try
        {
          paramVideoInfo = new JSONObject(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.r);
          if (PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"))) {
            paramVideoInfo = ((Resources)localObject3).getText(2131438668).toString();
          } else {
            paramVideoInfo = ((Resources)localObject3).getText(2131438667).toString();
          }
        }
        catch (JSONException paramVideoInfo)
        {
          paramVideoInfo = ((Resources)localObject3).getText(2131438667).toString();
        }
      } else {
        paramVideoInfo = ((Resources)localObject3).getText(2131438674).toString();
      }
    }
  }
  
  private void a(VideoFeedsAdapter.BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    if (paramBaseVideoItemHolder == null) {}
    do
    {
      return;
      if (paramBaseVideoItemHolder.jdField_a_of_type_Int == 2)
      {
        paramBaseVideoItemHolder.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramBaseVideoItemHolder.h.setVisibility(8);
        paramBaseVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramBaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext)) {
          b(paramBaseVideoItemHolder);
        }
        b((VideoFeedsAdapter.VideoItemHolder)paramBaseVideoItemHolder);
        VideoFeedsHelper.a(((VideoFeedsAdapter.VideoItemHolder)paramBaseVideoItemHolder).jdField_a_of_type_AndroidViewView, 8, 200);
        return;
      }
    } while (((paramBaseVideoItemHolder.jdField_a_of_type_Int != 0) && (paramBaseVideoItemHolder.jdField_a_of_type_Int != 1)) || (paramBaseVideoItemHolder == null));
    paramBaseVideoItemHolder.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramBaseVideoItemHolder.h.setVisibility(8);
    if ((TextUtils.isEmpty(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_JavaLangString)) || (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      paramBaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext)) {
        b(paramBaseVideoItemHolder);
      }
      if ((paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) && ((paramBaseVideoItemHolder instanceof VideoFeedsAdapter.VideoItemHolder))) {
        b((VideoFeedsAdapter.VideoItemHolder)paramBaseVideoItemHolder);
      }
      VideoFeedsHelper.a(((VideoFeedsAdapter.VideoItemHolder)paramBaseVideoItemHolder).jdField_a_of_type_AndroidViewView, 8, 200);
      return;
      paramBaseVideoItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void a(VideoFeedsAdapter.BaseVideoItemHolder paramBaseVideoItemHolder, View paramView)
  {
    paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367332));
    paramBaseVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367094));
    paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)paramView.findViewById(2131367339));
    paramBaseVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367096));
    paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367132));
    paramBaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367100));
    paramBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131367110));
    paramBaseVideoItemHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367109));
    paramBaseVideoItemHolder.g = ((TextView)paramView.findViewById(2131367111));
    paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367103));
    paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367090));
    paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367131));
    paramBaseVideoItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367104));
    paramBaseVideoItemHolder.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367107));
    paramBaseVideoItemHolder.h = ((TextView)paramView.findViewById(2131367133));
    paramBaseVideoItemHolder.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367108));
    paramBaseVideoItemHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367102);
    paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)paramView.findViewById(2131367351));
    paramBaseVideoItemHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131367101);
    paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367112));
    paramBaseVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367113));
    paramBaseVideoItemHolder.m = ((TextView)paramView.findViewById(2131367349));
    paramBaseVideoItemHolder.j = ((TextView)paramView.findViewById(2131367352));
    paramBaseVideoItemHolder.k = ((TextView)paramView.findViewById(2131367354));
    paramBaseVideoItemHolder.l = ((TextView)paramView.findViewById(2131367353));
    paramBaseVideoItemHolder.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367350));
  }
  
  private void a(VideoFeedsAdapter.BaseVideoItemHolder paramBaseVideoItemHolder, VideoInfo paramVideoInfo)
  {
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam2 = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam1 = localVideoPlayParam2;
    if (localVideoPlayParam2 == null) {
      localVideoPlayParam1 = new VideoFeedsPlayManager.VideoPlayParam();
    }
    localVideoPlayParam1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localVideoPlayParam1.jdField_a_of_type_ComTencentImageURLImageView = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView;
    localVideoPlayParam1.jdField_a_of_type_AndroidWidgetRelativeLayout = paramBaseVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout;
    localVideoPlayParam1.jdField_a_of_type_AndroidWidgetImageView = paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetImageView;
    localVideoPlayParam1.jdField_a_of_type_AndroidWidgetTextView = paramBaseVideoItemHolder.jdField_e_of_type_AndroidWidgetTextView;
    localVideoPlayParam1.jdField_b_of_type_AndroidWidgetTextView = paramBaseVideoItemHolder.jdField_f_of_type_AndroidWidgetTextView;
    localVideoPlayParam1.jdField_a_of_type_AndroidWidgetSeekBar = paramBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar;
    localVideoPlayParam1.jdField_b_of_type_AndroidWidgetSeekBar = paramBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar;
    localVideoPlayParam1.jdField_c_of_type_AndroidWidgetTextView = paramBaseVideoItemHolder.g;
    localVideoPlayParam1.jdField_b_of_type_AndroidWidgetRelativeLayout = paramBaseVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout;
    localVideoPlayParam1.jdField_d_of_type_AndroidWidgetTextView = paramBaseVideoItemHolder.h;
    localVideoPlayParam1.jdField_a_of_type_Int = paramBaseVideoItemHolder.jdField_b_of_type_Int;
    localVideoPlayParam1.jdField_c_of_type_AndroidWidgetRelativeLayout = paramBaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout;
    localVideoPlayParam1.jdField_e_of_type_AndroidWidgetTextView = paramBaseVideoItemHolder.j;
    localVideoPlayParam1.jdField_f_of_type_AndroidWidgetTextView = paramBaseVideoItemHolder.k;
    localVideoPlayParam1.g = paramBaseVideoItemHolder.l;
    localVideoPlayParam1.jdField_a_of_type_Boolean = true;
    paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = localVideoPlayParam1;
  }
  
  private void a(VideoFeedsAdapter.FooterItemHolder paramFooterItemHolder)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText("加载更多");
    }
    for (;;)
    {
      paramFooterItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(8);
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败");
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(VideoFeedsAdapter.VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, null);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder = paramVideoItemHolder;
    if (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
    {
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = new ReadinjoyVideoReportData();
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Int = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_JavaLangString = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Int = 2;
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.h = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.i = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.s = paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Int = paramVideoItemHolder.jdField_b_of_type_Int;
    }
    if ((paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Boolean)) {
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData = new ReadinjoyAdVideoReportData();
    }
    if (a(paramVideoItemHolder))
    {
      int i1 = 300;
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l1 < 1000L) {
        i1 = 1000;
      }
      if (this.jdField_a_of_type_Long != 0L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_scrollInterval", String.valueOf(l1));
        ReadInJoyUtils.e(this.jdField_a_of_type_AndroidContentContext, ReadInJoyUtils.a(), true, localHashMap);
      }
      if ((paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)) {
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.n = l1;
      }
      if ((paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData != null)) {
        paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, i1);
    }
    for (;;)
    {
      if ((paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        PublicAccountUtil.a(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    }
  }
  
  @TargetApi(11)
  private void a(VideoFeedsAdapter.VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo, int paramInt)
  {
    Object localObject1;
    if (paramVideoInfo.jdField_a_of_type_Int != 0)
    {
      paramVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (!TextUtils.isEmpty(paramVideoInfo.k)) {
        paramVideoItemHolder.n.setText(paramVideoInfo.k);
      }
      if (!TextUtils.isEmpty(paramVideoInfo.jdField_j_of_type_JavaLangString))
      {
        localObject1 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramVideoInfo.jdField_j_of_type_JavaLangString, 3, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
        paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((!TextUtils.isEmpty(paramVideoInfo.jdField_j_of_type_JavaLangString)) && (!"16888".equals(paramVideoInfo.jdField_j_of_type_JavaLangString)) && (!paramVideoInfo.jdField_f_of_type_Boolean) && (!paramVideoInfo.jdField_a_of_type_Boolean) && (paramVideoInfo.jdField_a_of_type_Int != 6)) {
          break label497;
        }
        paramVideoItemHolder.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        label133:
        paramVideoItemHolder.jdField_e_of_type_AndroidWidgetLinearLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        paramVideoItemHolder.jdField_g_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_g_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        label165:
        if (!paramVideoInfo.a()) {
          break label584;
        }
        paramVideoItemHolder.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (paramVideoInfo.jdField_e_of_type_Int <= 0) {
          break label543;
        }
        localObject1 = VideoFeedsHelper.d(paramVideoInfo.jdField_e_of_type_Int);
        label196:
        paramVideoItemHolder.p.setText((CharSequence)localObject1);
        paramVideoItemHolder.h.setTag(paramVideoItemHolder);
        paramVideoItemHolder.h.setOnClickListener(this);
        paramVideoItemHolder.h.setVisibility(0);
        paramVideoItemHolder.jdField_i_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_i_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        paramVideoItemHolder.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramVideoItemHolder.jdField_g_of_type_AndroidWidgetLinearLayout.setTag(paramVideoItemHolder);
        paramVideoItemHolder.jdField_g_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        paramVideoItemHolder.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (!paramVideoInfo.jdField_g_of_type_Boolean) {
          break label551;
        }
        paramVideoItemHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840826);
        paramVideoItemHolder.r.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492901));
        label314:
        VideoFeedsHelper.a(paramVideoItemHolder.r, paramVideoInfo.jdField_m_of_type_Int);
      }
    }
    for (;;)
    {
      if ((paramInt == 1) || (paramInt == 2)) {
        b(paramVideoItemHolder);
      }
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.getHeight();
      localURLDrawableOptions.mLoadingDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mFailedDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramVideoInfo.jdField_m_of_type_JavaLangString)) {
            break label481;
          }
          localObject1 = new URL("https://q.url.cn/s/jBJuV");
          localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
          paramVideoItemHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (MalformedURLException localMalformedURLException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException.getMessage());
        break;
        label481:
        localObject2 = new URL(paramVideoInfo.jdField_m_of_type_JavaLangString);
      }
      label497:
      paramVideoItemHolder.o.setText("关注");
      paramVideoItemHolder.o.setTextColor(Color.parseColor("#07D0B0"));
      paramVideoItemHolder.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      break label133;
      paramVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      break label165;
      label543:
      Object localObject2 = "评论";
      break label196;
      label551:
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840841);
      paramVideoItemHolder.r.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131493123));
      break label314;
      label584:
      paramVideoItemHolder.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void a(VideoFeedsAdapter.VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8)
      {
        paramVideoItemHolder.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramVideoItemHolder.jdField_f_of_type_AndroidWidgetRelativeLayout.setAlpha(0.99F);
        VideoFeedsHelper.a(paramVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout, 0);
        VideoFeedsHelper.a(paramVideoItemHolder.jdField_a_of_type_AndroidViewView, 0);
        if (paramVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          VideoFeedsHelper.a(paramVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout, 0);
        }
      }
    }
    for (;;)
    {
      if (paramVideoItemHolder.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
        VideoFeedsHelper.a(paramVideoItemHolder.jdField_b_of_type_AndroidViewView, 8);
      }
      return;
      if (paramVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
      {
        VideoFeedsHelper.a(paramVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout, 8);
        VideoFeedsHelper.a(paramVideoItemHolder.jdField_a_of_type_AndroidViewView, 8);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c()) && (paramVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
          VideoFeedsHelper.a(paramVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout, 8);
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "shareMsgToSina start!");
    }
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject = new String[9];
    localObject[0] = "这个视频不错 ~\\(≧▽≦)/~";
    localObject[1] = "吼精彩的视频，分享给大家";
    localObject[2] = "鹅妹子嘤~ 分享一发";
    localObject[3] = "好赞的视频，分享一波";
    localObject[4] = "hhh 视频界的一股清流";
    localObject[5] = "因吹斯汀";
    localObject[6] = "吃瓜群众转发围观";
    localObject[7] = "震惊！这个视频竟然....";
    localObject[8] = "厉害了我的哥";
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "shareMsgToSina empty title or share_url");
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131435286, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_d_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1 + "%F0%9F%8E%AC";
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString3;
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString3;
        paramString1 = paramString1 + "&_wv=3";
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString2.startActivity(paramString3);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "shareMsgToSina start webview!");
        return;
      }
      catch (Exception paramString1)
      {
        paramString1 = paramString1;
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131435286, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        paramString1.printStackTrace();
        return;
      }
      finally {}
    }
  }
  
  private boolean a(VideoFeedsAdapter.BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    return (this.jdField_a_of_type_AndroidContentContext != null) && (NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext)) && (paramBaseVideoItemHolder != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long >= 0L);
  }
  
  private boolean a(VideoFeedsAdapter.VideoItemHolder paramVideoItemHolder)
  {
    boolean bool2 = true;
    if (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) {
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_Boolean = true;
    }
    boolean bool1 = bool2;
    int i1;
    String str;
    if (this.i)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        bool1 = bool2;
        if (NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext))
        {
          bool1 = bool2;
          if (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
          {
            bool1 = bool2;
            if (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
            {
              this.i = false;
              i1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
              int i2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_PLAY_STATUS", 0);
              str = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getString("VIDEO_ARTICLE_ID", "");
              if ((4 != i1) || (3 != i2) || (!str.equals(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString))) {
                break label213;
              }
            }
          }
        }
      }
    }
    label213:
    for (paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_Boolean = false;; paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_Boolean = true)
    {
      if (1 != i1)
      {
        bool1 = bool2;
        if (2 != i1) {}
      }
      else
      {
        bool1 = bool2;
        if (str.equals(paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString)) {
          bool1 = false;
        }
      }
      return bool1;
    }
  }
  
  private List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430091);
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Int = 2130838332;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject1);
    localObject1 = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430097);
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Int = 2130838333;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_Int = 3;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject1);
    localObject1 = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430109);
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Int = 2130838336;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_Int = 9;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject1);
    localObject1 = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430110);
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Int = 2130838330;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_Int = 10;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject1);
    localObject1 = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430115);
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Int = 2130838335;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_Int = 12;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject1);
    localObject1 = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430095);
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_a_of_type_Int = 2130840650;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_Int = 4;
    ((PublicAccountBrowser.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject1);
    localObject1 = new ArrayList();
    Object localObject2 = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430107);
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Int = 2130841536;
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_b_of_type_Int = 6;
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if ((((VideoInfo)localObject2).jdField_b_of_type_JavaUtilArrayList != null) && (((VideoInfo)localObject2).jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject2 = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430108);
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Int = 2130840640;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_b_of_type_Int = 24;
      ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject1).add(localObject2);
    }
    localObject2 = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430094);
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Int = 2130840641;
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_b_of_type_Int = 11;
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430093);
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Int = 2130838328;
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_b_of_type_Int = 1;
    ((PublicAccountBrowser.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject1).add(localObject2);
    return (List[])new ArrayList[] { localArrayList, localObject1 };
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    Intent localIntent;
    if (paramVideoInfo.jdField_a_of_type_Int == 0)
    {
      paramVideoInfo = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      paramVideoInfo.putInt("forward_type", 21);
      paramVideoInfo.putBoolean("forward_need_sendmsg", true);
      paramVideoInfo.putString("forward_thumb", ShortVideoUtils.a(this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getString("thumbfile_md5"), "jpg"));
      localIntent = new Intent();
      localIntent.putExtras(paramVideoInfo);
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, localIntent);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_d_of_type_Boolean);
      return;
      if ((paramVideoInfo.jdField_a_of_type_Int == 6) || (paramVideoInfo.jdField_a_of_type_Int == 7))
      {
        paramVideoInfo = a(paramVideoInfo);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, 21);
      }
      else
      {
        paramVideoInfo = a(paramVideoInfo);
        localIntent = new Intent();
        localIntent.putExtras(paramVideoInfo);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, 21);
      }
    }
  }
  
  private void b(VideoFeedsAdapter.BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    if (!a(paramBaseVideoItemHolder)) {
      return;
    }
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    String str;
    if (this.h) {
      str = "免流量播放";
    }
    for (;;)
    {
      localVideoPlayParam.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840843);
      localVideoPlayParam.jdField_e_of_type_AndroidWidgetTextView.setText(str);
      localVideoPlayParam.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      localVideoPlayParam.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localVideoPlayParam.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoPlayParam.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localVideoPlayParam.jdField_e_of_type_AndroidWidgetTextView.setTag(paramBaseVideoItemHolder);
      if ((this.h) || (TextUtils.isEmpty(CUKingCardHelper.a("kandian")))) {
        break;
      }
      localVideoPlayParam.g.setVisibility(0);
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, paramBaseVideoItemHolder.l);
      return;
      str = VideoFeedsHelper.b(localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long) + "流量";
      if (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long <= 0L) {
        str = "流量播放";
      }
    }
  }
  
  private void b(VideoFeedsAdapter.VideoItemHolder paramVideoItemHolder)
  {
    switch (paramVideoItemHolder.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      localObject = (RelativeLayout.LayoutParams)paramVideoItemHolder.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(35.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramVideoItemHolder.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
      paramVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
      return;
    }
    Object localObject = (LinearLayout.LayoutParams)paramVideoItemHolder.jdField_c_of_type_AndroidViewView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    ((LinearLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramVideoItemHolder.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
    paramVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
      if ((paramVideoInfo.jdField_a_of_type_Int == 6) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
        localIntent.putExtra("feedsType", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      }
      localIntent.putExtra("biu_src", 2);
      localIntent.putExtra("arg_from_type", 8);
      localIntent.putExtra("arg_article_info", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "innerOpenReadInJoyBiuActivity error exception = " + paramVideoInfo.getMessage());
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() uin=" + paramString);
    }
    if (paramString == null) {}
    boolean bool1;
    do
    {
      return;
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      boolean bool2;
      for (bool1 = false; localIterator.hasNext(); bool1 = bool2)
      {
        VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
        bool2 = bool1;
        if (localVideoInfo.jdField_j_of_type_JavaLangString != null)
        {
          bool2 = bool1;
          if (localVideoInfo.jdField_j_of_type_JavaLangString.equals(paramString))
          {
            if (!localVideoInfo.jdField_f_of_type_Boolean) {
              bool1 = true;
            }
            localVideoInfo.jdField_f_of_type_Boolean = true;
            bool2 = bool1;
          }
        }
      }
      if (bool1) {
        b(paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() isDataChanged=" + bool1);
  }
  
  private void d(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    paramString = ReadInJoyConstants.i + Base64Util.encodeToString(String.valueOf(paramString).getBytes(), 2);
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramString);
  }
  
  private void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleConnetNetWorkChange");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.post(new mae(this, paramBoolean));
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, null);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c()))
    {
      if (!this.l) {
        break label137;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout, 8);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_AndroidViewView, 8);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_AndroidViewView, 8);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_d_of_type_AndroidWidgetRelativeLayout, 8);
      }
      return;
      label137:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder == null) {}
    do
    {
      do
      {
        return;
        try
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_JavaLangString, null, null);
          if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) || (!(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable))) {
            break;
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
          return;
        }
        catch (Exception localException) {}
      } while (!QLog.isColorLevel());
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
      return;
    } while (this.jdField_a_of_type_ComTencentImageURLDrawable == null);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new mab(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new VideoPreloadReportData(VideoPreloadReportData.jdField_c_of_type_Int, VideoPreloadReportData.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new mac(this));
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleNotNetWorkChange");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e(false);
    }
  }
  
  private void p()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
    Object localObject = new maf(this);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a((ActionSheet.WatchDismissActions)localObject);
    localObject = new ReadInJoyDisLikeDialogView(this.jdField_a_of_type_AndroidContentContext);
    ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new mag(this, localVideoInfo));
    ArrayList localArrayList = new ArrayList();
    if ((localVideoInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.size() > 0))
    {
      Iterator localIterator = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.iterator();
      if (localIterator.hasNext())
      {
        VideoAdInfo.NegFeedback localNegFeedback = (VideoAdInfo.NegFeedback)localIterator.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_JavaLangString = localNegFeedback.jdField_a_of_type_JavaLangString;
        localDislikeInfo.jdField_a_of_type_Int = ((int)localNegFeedback.jdField_a_of_type_Long);
        if (TextUtils.isEmpty(localVideoInfo.jdField_j_of_type_JavaLangString)) {}
        for (localDislikeInfo.jdField_b_of_type_JavaLangString = "";; localDislikeInfo.jdField_b_of_type_JavaLangString = localVideoInfo.jdField_j_of_type_JavaLangString)
        {
          localArrayList.add(localDislikeInfo);
          break;
        }
      }
    }
    if (localArrayList.size() == 0) {}
    for (;;)
    {
      return;
      ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(localArrayList);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a((View)localObject, null);
      try
      {
        if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
        {
          if ((VersionUtils.g()) && (!ShortVideoUtils.c()))
          {
            this.jdField_b_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(8, 8);
            this.jdField_b_of_type_ComTencentWidgetActionSheet.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnShowListener(new mai(this));
          }
          this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    int i1 = -1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder != null) {
      i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_Int;
    }
    return i1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new mah(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.b(true);
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = (VideoFeedsAdapter.VideoItemHolder)paramView.getTag();
          if (paramView == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseItemHolder) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseItemHolder == null);
        if ((paramView != null) && (paramView.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseItemHolder.jdField_b_of_type_Int + 1) && (paramView.jdField_b_of_type_Int != getCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.a();
          return;
        }
      } while ((paramView == null) || (paramView.jdField_b_of_type_Int != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseItemHolder.jdField_b_of_type_Int - 1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.b();
      return;
      switch (paramView.jdField_a_of_type_Int)
      {
      case 3: 
      case 4: 
      default: 
        if (paramView.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
          break label304;
        }
        paramView.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
        a(paramView, true);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c()) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channel_id", 409409);
      label216:
      PublicAccountReportUtils.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", VideoReporter.a(null, null, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, localJSONObject), false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      VideoFeedsHelper.a(paramView.jdField_a_of_type_AndroidViewView, 0, 200);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
      VideoFeedsHelper.a(paramView.jdField_a_of_type_AndroidViewView, 8, 200);
      return;
      label304:
      if (!this.l) {
        paramView.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
      a(paramView, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label216;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (VideoFeedsAdapter.VideoItemHolder)paramView.getTag();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.n);
        a(paramView, true);
        this.n = false;
        return;
      } while (paramView.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0);
      a(paramView, false);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.n = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    VideoFeedsAdapter.VideoItemHolder localVideoItemHolder = (VideoFeedsAdapter.VideoItemHolder)paramView.getTag();
    if (localVideoItemHolder != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder) {}
    Object localObject1;
    do
    {
      do
      {
        return;
      } while ((localVideoItemHolder == null) || (localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (TextUtils.isEmpty(localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString)));
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840642));
      ReadInJoyAnimUtils.a(paramView, paramInt1, paramInt2);
      localObject1 = new ScaleAnimation(1.0F, 2.0F, 1.0F, 2.0F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject1).setDuration(300L);
      ((ScaleAnimation)localObject1).setInterpolator(new LinearInterpolator());
      localObject2 = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F, 0.0F });
      ((ObjectAnimator)localObject2).addListener(new mao(this, localVideoItemHolder, paramView));
      ((ObjectAnimator)localObject2).setDuration(300L);
      ((ObjectAnimator)localObject2).setInterpolator(new LinearInterpolator());
      localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.removeView(paramView);
      localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.addView(paramView);
      paramView.setAlpha(1.0F);
      paramView.postDelayed(new lzl(this, paramView, (ScaleAnimation)localObject1, (ObjectAnimator)localObject2), 200L);
    } while (localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Boolean);
    localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Boolean = true;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof VideoFeedsPlayActivity)) {
      ((VideoFeedsPlayActivity)this.jdField_a_of_type_AndroidAppActivity).a(localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, true);
    }
    a(localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, Boolean.valueOf(true));
    localVideoItemHolder.jdField_d_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    Object localObject2 = new JSONObject();
    if ((localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      paramView = localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      ((JSONObject)localObject2).put("channel_id", 409409);
      ((JSONObject)localObject2).put("rowkey", localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      label400:
      String str = localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
      if (!TextUtils.isEmpty(localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString)) {}
      for (localObject1 = localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;; localObject1 = "0")
      {
        PublicAccountReportUtils.a(null, str, "0X80091AA", "0X80091AA", 0, 0, "0", "0", (String)localObject1, VideoReporter.a(paramView, localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, (JSONObject)localObject2), false);
        return;
        paramView = null;
        break;
      }
    }
    catch (Exception localException)
    {
      break label400;
    }
  }
  
  public void a(VideoFeedsAdapter.AdapterEventListener paramAdapterEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener = paramAdapterEventListener;
  }
  
  public void a(VideoFeedsAppJumpManager paramVideoFeedsAppJumpManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppJumpManager = paramVideoFeedsAppJumpManager;
  }
  
  public void a(VideoFeedsCommentManager paramVideoFeedsCommentManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager = paramVideoFeedsCommentManager;
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    n();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
  }
  
  public void a(VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager = paramVideoFeedsRecommendManager;
  }
  
  @TargetApi(11)
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131437365);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131437342);
    String str3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131437366);
    String str4 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131437347);
    String str5 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131432998);
    String str6 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = false;
    Object localObject = new File(str6);
    long l1 = ((File)localObject).length();
    boolean bool1 = bool2;
    if (((File)localObject).exists())
    {
      bool1 = bool2;
      if (l1 >= paramMessageForShortVideo.videoFileSize) {
        bool1 = true;
      }
    }
    if (ImmersiveUtils.isSupporImmersive() == -1)
    {
      localObject = ActionSheet.b(this.jdField_a_of_type_AndroidAppActivity);
      ((ActionSheet)localObject).c(str1);
      ((ActionSheet)localObject).setOnDismissListener(new lzm(this));
      if (paramMessageForShortVideo.videoFileStatus != 5001) {
        ((ActionSheet)localObject).c(str3);
      }
      if (!bool1) {
        break label334;
      }
      ((ActionSheet)localObject).c(str2);
      ((ActionSheet)localObject).c(str4);
    }
    for (;;)
    {
      ((ActionSheet)localObject).d(str5);
      if (!((ActionSheet)localObject).isShowing())
      {
        if ((VersionUtils.g()) && (!ShortVideoUtils.c()))
        {
          ((ActionSheet)localObject).getWindow().setFlags(8, 8);
          if (VersionUtils.g()) {
            ((ActionSheet)localObject).getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
          }
          ((ActionSheet)localObject).setOnShowListener(new lzn(this, (ActionSheet)localObject));
        }
        ((ActionSheet)localObject).show();
      }
      ((ActionSheet)localObject).a(new lzo(this, (ActionSheet)localObject, str1, paramMessageForShortVideo, str3, bool1, str6, str2, str4));
      return;
      localObject = ActionSheet.a(this.jdField_a_of_type_AndroidAppActivity);
      break;
      label334:
      ((ActionSheet)localObject).a(str2, 7);
      ((ActionSheet)localObject).a(str4, 7);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    int i1 = a();
    if (i1 == -1) {}
    VideoFeedsAdapter.BaseVideoItemHolder localBaseVideoItemHolder;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            i1 += this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getHeaderViewsCount();
          } while ((i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()) || (i1 > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getLastVisiblePosition()));
          localBaseVideoItemHolder = (VideoFeedsAdapter.BaseVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()).getTag();
        } while (!(localBaseVideoItemHolder instanceof VideoFeedsAdapter.VideoItemHolder));
        if (!paramBoolean.booleanValue()) {
          break;
        }
      } while (((VideoFeedsAdapter.VideoItemHolder)localBaseVideoItemHolder).jdField_b_of_type_AndroidWidgetImageView == null);
      ((VideoFeedsAdapter.VideoItemHolder)localBaseVideoItemHolder).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localBaseVideoItemHolder.j.setVisibility(8);
    } while ((this.h) || (TextUtils.isEmpty(CUKingCardHelper.a("kandian"))));
    localBaseVideoItemHolder.l.setVisibility(8);
    return;
    b((VideoFeedsAdapter.VideoItemHolder)localBaseVideoItemHolder);
  }
  
  public void a(String paramString)
  {
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_g_of_type_JavaLangString))) {
        paramString = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
      }
    }
    for (;;)
    {
      if ((i1 == -1) || (paramString == null)) {}
      do
      {
        do
        {
          return;
          i1 += 1;
          break;
          i1 += this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getHeaderViewsCount();
        } while ((i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()) || (i1 > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getLastVisiblePosition()));
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()).getTag();
      } while (!(localObject instanceof VideoFeedsAdapter.VideoItemHolder));
      Object localObject = (VideoFeedsAdapter.VideoItemHolder)localObject;
      if (paramString.jdField_e_of_type_Int > 0) {}
      for (paramString = VideoFeedsHelper.d(paramString.jdField_e_of_type_Int);; paramString = "评论")
      {
        ((VideoFeedsAdapter.VideoItemHolder)localObject).p.setText(paramString);
        return;
      }
      paramString = null;
      i1 = -1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label10:
    label152:
    for (;;)
    {
      return;
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size()) {
        if (!paramString.equals(((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaLangString)) {}
      }
      for (;;)
      {
        if (i1 == -1) {
          break label152;
        }
        i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getHeaderViewsCount() + i1;
        if ((i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()) || (i1 > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getLastVisiblePosition())) {
          break;
        }
        paramString = (VideoFeedsAdapter.BaseItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()).getTag();
        if ((paramString == null) || (!(paramString instanceof VideoFeedsAdapter.VideoItemHolder)) || (((VideoFeedsAdapter.VideoItemHolder)paramString).jdField_i_of_type_AndroidWidgetTextView == null)) {
          break;
        }
        ((VideoFeedsAdapter.VideoItemHolder)paramString).jdField_i_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.a(paramInt));
        return;
        i1 += 1;
        break label10;
        i1 = -1;
      }
    }
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_g_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      if (i1 == -1) {}
      label246:
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
                i1 += 1;
                break;
                i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getHeaderViewsCount() + i1;
              } while ((i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()) || (i1 > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getLastVisiblePosition()));
              paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()).getTag();
            } while ((!(paramString instanceof VideoFeedsAdapter.VideoItemHolder)) || ((paramString instanceof VideoFeedsAdapter.ADVideoItemHolder)));
            paramString = (VideoFeedsAdapter.VideoItemHolder)paramString;
            if (!paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Boolean) {
              break label246;
            }
            paramString.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840826);
            paramString.r.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492901));
          } while (!paramBoolean.booleanValue());
          ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(a())).jdField_m_of_type_Int += 1;
          VideoFeedsHelper.a(paramString.r, ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(a())).jdField_m_of_type_Int);
          return;
          paramString.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130840841);
          paramString.r.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131493123));
        } while (!paramBoolean.booleanValue());
        if (((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(a())).jdField_m_of_type_Int == 1)
        {
          ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(a())).jdField_m_of_type_Int = 0;
          VideoFeedsHelper.a(paramString.r, ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(a())).jdField_m_of_type_Int);
          return;
        }
      } while (((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(a())).jdField_m_of_type_Int <= 1);
      ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(a())).jdField_m_of_type_Int -= 1;
      VideoFeedsHelper.a(paramString.r, ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(a())).jdField_m_of_type_Int);
      return;
      i1 = -1;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout != null) && ((this.jdField_a_of_type_AndroidAppActivity instanceof VideoFeedsPlayActivity)))
    {
      ((VideoFeedsPlayActivity)this.jdField_a_of_type_AndroidAppActivity).a(paramBoolean);
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new maj(this));
  }
  
  public void b(View paramView) {}
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new mal(this, paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new mak(this));
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getHeaderViewsCount();
    VideoFeedsAdapter.FooterItemHolder localFooterItemHolder;
    if ((i1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()) && (i1 <= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getLastVisiblePosition()) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()).getTag() instanceof VideoFeedsAdapter.FooterItemHolder)))
    {
      localFooterItemHolder = (VideoFeedsAdapter.FooterItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.getFirstVisiblePosition()).getTag();
      if (this.jdField_a_of_type_Int != 1) {
        break label131;
      }
      localFooterItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText("加载更多");
    }
    label131:
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        localFooterItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        localFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败");
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    localFooterItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    localFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    localFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "doOnShareButtonPressed()");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setNeedDetectScreenOrientation(false);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c())) {
        break;
      }
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder != null) && (((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_Int)).jdField_a_of_type_Boolean) && (((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_Int)).jdField_g_of_type_Int == 1) && (((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_Int)).a(this.jdField_a_of_type_AndroidAppActivity))) {
        p();
      } else {
        i();
      }
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void f()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
  }
  
  public void g()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!localVideoInfo.jdField_a_of_type_Boolean)
      {
        if (this.j)
        {
          if ((paramInt == 0) && (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)))
          {
            if (localVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
              return 1;
            }
            return 0;
          }
          localVideoInfo.a(true);
          return 2;
        }
        if (localVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
          return 1;
        }
        return 0;
      }
      if (localVideoInfo.jdField_g_of_type_Int == 1)
      {
        if (localVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
          return 5;
        }
        return 4;
      }
    }
    else
    {
      return 3;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = getItemViewType(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969659, paramViewGroup, false);
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      switch (i1)
      {
      default: 
        paramViewGroup = null;
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)paramView.findViewById(2131367334));
        paramViewGroup.jdField_a_of_type_Int = i1;
      }
    }
    for (;;)
    {
      label98:
      paramViewGroup.jdField_b_of_type_Int = paramInt;
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        localObject = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        label135:
        switch (i1)
        {
        }
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(1.0F);
        label1305:
        for (;;)
        {
          return paramView;
          paramViewGroup = new VideoFeedsAdapter.VideoItemHolder();
          if (i1 == 0)
          {
            ((LayoutInflater)localObject).inflate(2130969666, (ViewGroup)paramView.findViewById(2131367332), true);
            ((LayoutInflater)localObject).inflate(2130969668, (ViewGroup)paramView.findViewById(2131367331), true);
            ((LayoutInflater)localObject).inflate(2130969667, (ViewGroup)paramView.findViewById(2131367333), true);
          }
          for (;;)
          {
            a(paramViewGroup, paramView);
            paramViewGroup.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367355));
            paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367115));
            paramViewGroup.n = ((TextView)paramView.findViewById(2131367117));
            paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367356));
            paramViewGroup.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131367364);
            paramViewGroup.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367118));
            paramViewGroup.o = ((TextView)paramView.findViewById(2131367120));
            paramViewGroup.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367360));
            paramViewGroup.jdField_i_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367125));
            paramViewGroup.q = ((TextView)paramView.findViewById(2131367363));
            paramViewGroup.h = ((RelativeLayout)paramView.findViewById(2131367122));
            paramViewGroup.p = ((TextView)paramView.findViewById(2131367124));
            paramViewGroup.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367341));
            paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)paramView.findViewById(2131367307));
            paramViewGroup.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367348));
            paramViewGroup.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView = ((VideoFeedsGradientMaskView)paramView.findViewById(2131367340));
            paramViewGroup.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367361));
            paramViewGroup.r = ((TextView)paramView.findViewById(2131367362));
            paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367126));
            paramView.setTag(paramViewGroup);
            break;
            if (i1 == 1)
            {
              ((LayoutInflater)localObject).inflate(2130969666, (ViewGroup)paramView.findViewById(2131367332), true);
              ((LayoutInflater)localObject).inflate(2130969668, (ViewGroup)paramView.findViewById(2131367341), true);
              ((LayoutInflater)localObject).inflate(2130969667, (ViewGroup)paramView.findViewById(2131367348), true);
            }
            else
            {
              ((LayoutInflater)localObject).inflate(2130969665, (ViewGroup)paramView.findViewById(2131367332), true);
              ((LayoutInflater)localObject).inflate(2130969668, (ViewGroup)paramView.findViewById(2131367341), true);
              ((LayoutInflater)localObject).inflate(2130969667, (ViewGroup)paramView.findViewById(2131367348), true);
            }
          }
          paramViewGroup = new VideoFeedsAdapter.ADVideoItemHolder();
          if (i1 == 4)
          {
            ((LayoutInflater)localObject).inflate(2130969663, (ViewGroup)paramView.findViewById(2131367331), true);
            ((LayoutInflater)localObject).inflate(2130969661, (ViewGroup)paramView.findViewById(2131367333), true);
            ((LayoutInflater)localObject).inflate(2130969666, (ViewGroup)paramView.findViewById(2131367332), true);
            a(paramViewGroup, paramView);
            paramViewGroup.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367355));
            paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367115));
            paramViewGroup.n = ((TextView)paramView.findViewById(2131367117));
            paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367356));
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367357));
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367358));
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367359));
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367337));
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367338));
          }
          for (paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367163));; paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367347)))
          {
            paramView.setTag(paramViewGroup);
            break;
            ((LayoutInflater)localObject).inflate(2130969663, (ViewGroup)paramView.findViewById(2131367331), true);
            ((LayoutInflater)localObject).inflate(2130969661, (ViewGroup)paramView.findViewById(2131367333), true);
            ((LayoutInflater)localObject).inflate(2130969662, (ViewGroup)paramView.findViewById(2131367332), true);
            a(paramViewGroup, paramView);
            paramViewGroup.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131367355));
            paramViewGroup.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367344));
            paramViewGroup.n = ((TextView)paramView.findViewById(2131367346));
            paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367345));
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367343));
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367337));
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367338));
          }
          ((LayoutInflater)localObject).inflate(2130969664, (ViewGroup)paramView.findViewById(2131367332), true);
          paramViewGroup = new VideoFeedsAdapter.FooterItemHolder();
          paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365203));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367097));
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363434));
          paramView.setTag(paramViewGroup);
          break;
          if ((i1 == 0) || (i1 == 1) || (i1 == 2))
          {
            paramViewGroup = (VideoFeedsAdapter.VideoItemHolder)paramView.getTag();
            break label98;
          }
          if ((i1 == 4) || (i1 == 5))
          {
            paramViewGroup = (VideoFeedsAdapter.ADVideoItemHolder)paramView.getTag();
            break label98;
          }
          if (i1 != 3) {
            break label1318;
          }
          paramViewGroup = (VideoFeedsAdapter.FooterItemHolder)paramView.getTag();
          break label98;
          localObject = null;
          break label135;
          if ((i1 == 0) || (i1 == 1) || (i1 == 2)) {
            a((VideoFeedsAdapter.VideoItemHolder)paramViewGroup, (VideoInfo)localObject, i1);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder == paramViewGroup) {
              break label1305;
            }
            a((VideoFeedsAdapter.BaseVideoItemHolder)paramViewGroup, (VideoInfo)localObject);
            a(paramInt, (VideoFeedsAdapter.BaseVideoItemHolder)paramViewGroup, (VideoInfo)localObject, i1);
            break;
            a((VideoFeedsAdapter.ADVideoItemHolder)paramViewGroup, (VideoInfo)localObject, i1);
          }
        }
        a((VideoFeedsAdapter.FooterItemHolder)paramViewGroup);
      }
      label1318:
      paramViewGroup = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener = null;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
  }
  
  @TargetApi(11)
  public void i()
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      if (ImmersiveUtils.isSupporImmersive() == -1)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.b(this.jdField_a_of_type_AndroidAppActivity);
        localView = a();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localView, null);
      }
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
        {
          if ((VersionUtils.g()) && (!ShortVideoUtils.c()))
          {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnShowListener(new lzs(this));
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          m();
        }
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "actionSheet.show exception=" + localException);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
      break;
      localView = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(localView, null);
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long <= 0L)) {
      return;
    }
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
    localVideoPlayParam.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    localVideoPlayParam.jdField_d_of_type_AndroidWidgetTextView.setText("当前为非WiFi环境，继续播放将消耗流量");
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    Object localObject2 = (VideoFeedsAdapter.BaseItemHolder)paramView.getTag();
    VideoInfo localVideoInfo;
    if ((localObject2 instanceof VideoFeedsAdapter.VideoItemHolder))
    {
      localVideoInfo = ((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (localVideoInfo == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    label1805:
    for (;;)
    {
      label60:
      return;
      for (;;)
      {
        Object localObject1;
        int i1;
        for (;;)
        {
          if (localVideoInfo == null) {
            break label1805;
          }
          if ((localVideoInfo.jdField_a_of_type_Int == 0) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {}
          for (str = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; str = null)
          {
            localObject1 = new JSONObject();
            switch (paramView.getId())
            {
            default: 
              return;
            case 2131367104: 
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView == null) {
                break label60;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.d();
              return;
            }
          }
          if ((((VideoFeedsAdapter.BaseItemHolder)localObject2).jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a() == 5)) {
            VideoFeedsHelper.a(((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_AndroidViewView, 8, 200);
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
          return;
          if ((((VideoFeedsAdapter.BaseItemHolder)localObject2).jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a() == 5)) {
            VideoFeedsHelper.a(((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_AndroidViewView, 8, 200);
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
          return;
          c(localVideoInfo);
          try
          {
            ((JSONObject)localObject1).put("algorithm_id", localVideoInfo.jdField_d_of_type_Long);
            ((JSONObject)localObject1).put("strategy_id", localVideoInfo.i);
            ((JSONObject)localObject1).put("channel_id", -1);
            paramView = new ReportInfo.VideoExtraRepoerData();
            paramView.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
            paramView.jdField_e_of_type_Int = (localVideoInfo.a() * 1000);
            paramView.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
            i1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
            VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, i1, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.i, 25, -1, paramView);
            if (this.jdField_a_of_type_Boolean)
            {
              localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
              if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString))
              {
                paramView = localVideoInfo.jdField_g_of_type_JavaLangString;
                PublicAccountReportUtils.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramView, VideoReporter.a(str, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000, (JSONObject)localObject1), false);
                if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager == null) {
                  break;
                }
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(1, localVideoInfo, 0L, 0L);
                return;
              }
            }
          }
          catch (JSONException paramView)
          {
            for (;;)
            {
              paramView.printStackTrace();
              continue;
              paramView = "0";
            }
            localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
            if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
            for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
            {
              PublicAccountReportUtils.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramView, VideoReporter.a(str, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000, (JSONObject)localObject1), false);
              break;
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager != null) && (localVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.b(false);
        }
        if (localVideoInfo.jdField_a_of_type_Boolean)
        {
          a(localVideoInfo);
          return;
        }
        paramView = (VideoFeedsAdapter.VideoItemHolder)localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onClick accountInfo busiType = " + paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int + "accountUin = " + paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString);
        }
        if ((paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
        {
          if (paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) {
            break label988;
          }
          paramView = ReadInJoyConstants.jdField_f_of_type_JavaLangString + Base64Util.encodeToString(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString.getBytes(), 2);
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
        }
        try
        {
          for (;;)
          {
            ((JSONObject)localObject1).put("channel_id", -1);
            localObject1 = localVideoInfo.jdField_j_of_type_JavaLangString;
            if (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {
              break;
            }
            paramView = localVideoInfo.jdField_g_of_type_JavaLangString;
            PublicAccountReportUtils.a(null, (String)localObject1, "0X8007410", "0X8007410", 0, 0, "0", "", paramView, VideoReporter.a(str, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L, null), false);
            return;
            label988:
            if ((!TextUtils.isEmpty(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString)) && (!paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString.equals("16888"))) {
              d(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString);
            }
          }
        }
        catch (JSONException paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
            continue;
            paramView = "0";
          }
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.d();
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(4, localVideoInfo, 0L, 0L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + localVideoInfo.jdField_j_of_type_JavaLangString + ", isFollowed=" + localVideoInfo.jdField_f_of_type_Boolean + ", pname=" + localVideoInfo.k);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          str = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
          for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
          {
            PublicAccountReportUtils.a(null, str, "0X800929B", "0X800929B", 0, 0, "", "", paramView, VideoReporter.a(null, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L, null), false);
            c(localVideoInfo.jdField_j_of_type_JavaLangString);
            return;
          }
        }
        String str = localVideoInfo.jdField_j_of_type_JavaLangString;
        if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
        for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
        {
          PublicAccountReportUtils.a(null, str, "0X80078FD", "0X80078FD", 0, 0, "", "", paramView, VideoReporter.a(null, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L, null), false);
          break;
        }
        if ((!localVideoInfo.jdField_a_of_type_Boolean) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder instanceof VideoFeedsAdapter.ADVideoItemHolder))) {
          break;
        }
        a(((VideoFeedsAdapter.ADVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder).jdField_a_of_type_AndroidViewViewGroup, localVideoInfo);
        return;
        if (!localVideoInfo.jdField_a_of_type_Boolean) {
          break;
        }
        a(localVideoInfo);
        return;
        a(paramView);
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a(true, false);
        if (this.jdField_a_of_type_Boolean)
        {
          PublicAccountReportUtils.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", VideoReporter.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, null), false);
          return;
        }
        PublicAccountReportUtils.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", VideoReporter.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, null), false);
        return;
        if ((this.jdField_a_of_type_AndroidViewAnimationScaleAnimation != null) && (paramView.findViewById(2131367126) != null)) {
          paramView.findViewById(2131367126).startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
        }
        if (!localVideoInfo.jdField_g_of_type_Boolean)
        {
          localVideoInfo.jdField_g_of_type_Boolean = true;
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof VideoFeedsPlayActivity)) {
            ((VideoFeedsPlayActivity)this.jdField_a_of_type_AndroidAppActivity).a(localVideoInfo.jdField_g_of_type_JavaLangString, true);
          }
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("channel_id", 409409);
          if (!localVideoInfo.jdField_g_of_type_Boolean) {
            break label1714;
          }
          i1 = 0;
          label1589:
          ((JSONObject)localObject1).put("type", i1);
        }
        catch (Exception paramView)
        {
          label1599:
          break label1599;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {
            paramView = localVideoInfo.jdField_g_of_type_JavaLangString;
          }
        }
        for (;;)
        {
          PublicAccountReportUtils.a(null, (String)localObject2, "0X800929C", "0X800929C", 0, 0, "0", "0", paramView, VideoReporter.a(str, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, (JSONObject)localObject1), false);
          a(localVideoInfo.jdField_g_of_type_JavaLangString, Boolean.valueOf(true));
          return;
          localVideoInfo.jdField_g_of_type_Boolean = false;
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof VideoFeedsPlayActivity)) {
            break;
          }
          ((VideoFeedsPlayActivity)this.jdField_a_of_type_AndroidAppActivity).a(localVideoInfo.jdField_g_of_type_JavaLangString, false);
          break;
          label1714:
          i1 = 1;
          break label1589;
          paramView = "0";
          continue;
          localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
          if (!TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
          for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
          {
            PublicAccountReportUtils.a(null, (String)localObject2, "0X80091A9", "0X80091A9", 0, 0, "0", "0", paramView, VideoReporter.a(str, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, (JSONObject)localObject1), false);
            break;
          }
        }
        localVideoInfo = null;
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView != null)
      {
        bool = true;
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, bool);
      }
    }
    else
    {
      if ((paramAdapterView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        break label89;
      }
    }
    label89:
    VideoInfo localVideoInfo;
    Object localObject1;
    label202:
    Object localObject2;
    String str;
    for (;;)
    {
      return;
      bool = false;
      break;
      localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(3, localVideoInfo, 0L, 0L);
      }
      int i1 = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.jdField_b_of_type_Int;
      paramAdapterView = localVideoInfo.jdField_f_of_type_JavaLangString;
      if (i1 == 1)
      {
        paramView = this.jdField_a_of_type_AndroidContentContext;
        localObject1 = this.jdField_a_of_type_AndroidContentContext;
        ((ClipboardManager)paramView.getSystemService("clipboard")).setText(paramAdapterView);
        QRUtils.a(2, 2131429988);
        paramInt = 3;
        if ((localVideoInfo.jdField_a_of_type_Int != 0) || (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label1990;
        }
        paramAdapterView = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        localObject1 = new JSONObject();
      }
      try
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              ((JSONObject)localObject1).put("algorithm_id", localVideoInfo.jdField_d_of_type_Long);
              ((JSONObject)localObject1).put("strategy_id", localVideoInfo.i);
              ((JSONObject)localObject1).put("channel_id", -1);
              ((JSONObject)localObject1).put("from", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
              if ((i1 != 1) && (i1 != 11) && (i1 != 6))
              {
                paramView = new ReportInfo.VideoExtraRepoerData();
                paramView.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
                paramView.jdField_e_of_type_Int = (localVideoInfo.a() * 1000);
                i1 = -1;
                if (this.jdField_a_of_type_AndroidAppActivity != null)
                {
                  paramView.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
                  i1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
                }
                VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, i1, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.i, 26, -1, paramView);
              }
              if (!this.jdField_a_of_type_Boolean) {
                break label2010;
              }
              localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
              str = Integer.toString(paramInt);
              if (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {
                break label2003;
              }
              paramView = localVideoInfo.jdField_g_of_type_JavaLangString;
              PublicAccountReportUtils.a(null, (String)localObject2, "0X800929A", "0X800929A", 0, 0, "0", str, paramView, VideoReporter.a(paramAdapterView, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L, (JSONObject)localObject1), false);
              return;
              if (i1 == 11)
              {
                paramView = null;
                try
                {
                  paramAdapterView = URLEncoder.encode(paramAdapterView, "UTF-8");
                  if (!TextUtils.isEmpty(localVideoInfo.jdField_j_of_type_JavaLangString))
                  {
                    paramView = localVideoInfo.jdField_j_of_type_JavaLangString;
                    paramInt = 0;
                    if (localVideoInfo.jdField_a_of_type_Int == 6) {
                      paramInt = 1;
                    }
                    paramAdapterView = "https://post.mp.qq.com/jubao/index?_wv=3&puin=" + paramView + "&uin_type=" + paramInt + "&url=" + paramAdapterView + "&type=4&key=" + localVideoInfo.jdField_g_of_type_JavaLangString;
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "click jubao btn, reportUrl:" + paramAdapterView);
                    }
                    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_d_of_type_Boolean);
                    paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                    paramView.putExtra("url", paramAdapterView);
                    paramView.putExtra("hide_more_button", true);
                    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
                    paramInt = 3;
                  }
                }
                catch (UnsupportedEncodingException paramAdapterView)
                {
                  for (;;)
                  {
                    paramAdapterView = paramView;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "encode url failed, because UTF-8 is unknown");
                      paramAdapterView = paramView;
                      continue;
                      paramView = "0";
                    }
                  }
                }
              }
            }
            if (i1 == 2)
            {
              b(localVideoInfo);
              paramInt = 0;
              break;
            }
            if (i1 == 4)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_d_of_type_Boolean);
              paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramAdapterView + "&sourcefrom=6"));
              paramAdapterView.putExtra("normal", true);
              try
              {
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramAdapterView);
                paramInt = 3;
              }
              catch (ActivityNotFoundException paramAdapterView)
              {
                for (;;)
                {
                  this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(false);
                  QRUtils.a(1, 2131430011);
                }
              }
            }
          }
          if (i1 == 3)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_d_of_type_Boolean);
            paramView = new Bundle();
            paramView.putString("title", localVideoInfo.jdField_c_of_type_JavaLangString);
            paramView.putString("desc", localVideoInfo.jdField_d_of_type_JavaLangString);
            paramView.putString("detail_url", paramAdapterView + "&sourcefrom=1");
            paramAdapterView = new ArrayList(1);
            paramAdapterView.add(localVideoInfo.jdField_b_of_type_JavaLangString);
            paramView.putStringArrayList("image_url", paramAdapterView);
            paramView.putLong("req_share_id", 0L);
            QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramView, null);
            paramInt = 1;
            break label202;
          }
          if (i1 == 6)
          {
            if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, "当前网络不可用", 0).a();
              return;
            }
            VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
            localVideoInfo.jdField_c_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_d_of_type_Boolean);
            ((VideoFeedsPlayActivity)this.jdField_a_of_type_AndroidAppActivity).b(true);
            paramAdapterView = localVideoInfo.k;
            paramView = new Bundle();
            paramView.putInt("videoDuration", localVideoInfo.jdField_d_of_type_Int);
            if (TextUtils.isEmpty(localVideoInfo.jdField_j_of_type_JavaLangString))
            {
              paramLong = 0L;
              label1115:
              paramView.putLong("publishAccountUin", paramLong);
              paramView.putString("publishAccountName", paramAdapterView);
              paramView.putLong("feedsId", localVideoInfo.jdField_c_of_type_Long);
              paramView.putInt("feedsType", localVideoInfo.jdField_f_of_type_Int);
              if (localVideoInfo.jdField_a_of_type_Int != 6) {
                break label1275;
              }
              paramInt = 1;
              label1168:
              paramView.putInt("videoType", paramInt);
              if (localVideoInfo.jdField_g_of_type_JavaLangString != null) {
                break label1280;
              }
            }
            label1280:
            for (paramAdapterView = "";; paramAdapterView = localVideoInfo.jdField_g_of_type_JavaLangString)
            {
              ReadInJoyAtlasManager.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 2, paramAdapterView, localVideoInfo.jdField_c_of_type_JavaLangString, localVideoInfo.jdField_d_of_type_JavaLangString, localVideoInfo.jdField_b_of_type_JavaLangString, localVideoInfo.jdField_f_of_type_JavaLangString + "&sourcefrom=6", paramView);
              localVideoInfo.jdField_b_of_type_Boolean = true;
              paramInt = 6;
              break;
              paramLong = Long.valueOf(localVideoInfo.jdField_j_of_type_JavaLangString).longValue();
              break label1115;
              label1275:
              paramInt = 2;
              break label1168;
            }
          }
          if ((i1 == 9) || (i1 == 10))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_d_of_type_Boolean);
            if (i1 == 9) {
              paramInt = 2;
            }
            for (paramAdapterView = paramAdapterView + "&sourcefrom=2";; paramAdapterView = paramAdapterView + "&sourcefrom=3")
            {
              paramView = new StringBuilder();
              if (localVideoInfo.jdField_j_of_type_Int > 0) {
                paramView.append(VideoFeedsHelper.b(localVideoInfo.jdField_j_of_type_Int)).append(" ");
              }
              VideoShareUtils.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_c_of_type_JavaLangString, paramView.toString(), paramAdapterView, this.jdField_a_of_type_AndroidGraphicsBitmap, i1);
              break;
              paramInt = 4;
            }
          }
          if (i1 == 22)
          {
            if (localVideoInfo.jdField_a_of_type_Int == 0) {
              break;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_d_of_type_Boolean);
            paramAdapterView = ReadInJoyUtils.a(localVideoInfo.jdField_g_of_type_JavaLangString, 3, localVideoInfo.h, -1, localVideoInfo.jdField_d_of_type_Long, localVideoInfo.i);
            paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            paramView.putExtra("url", paramAdapterView);
            paramView.putExtra("hide_more_button", true);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
            paramInt = 3;
            break label202;
          }
          if (i1 == 12)
          {
            a(localVideoInfo.jdField_c_of_type_JavaLangString, "", localVideoInfo.jdField_f_of_type_JavaLangString + "&sourcefrom=4", localVideoInfo.jdField_b_of_type_JavaLangString);
            paramInt = 5;
            break label202;
          }
          if (i1 == 24)
          {
            this.e = true;
            paramAdapterView = new JSONObject();
            try
            {
              paramAdapterView.put("channel_id", 409409);
              paramAdapterView.put("source", 2);
              paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
              if ((paramView.jdField_b_of_type_JavaUtilArrayList != null) && (paramView.jdField_b_of_type_JavaUtilArrayList.size() > 0))
              {
                this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
                localObject1 = new lzy(this);
                this.jdField_b_of_type_ComTencentWidgetActionSheet.a((ActionSheet.WatchDismissActions)localObject1);
                localObject1 = new ReadInJoyDisLikeDialogView(this.jdField_a_of_type_AndroidContentContext);
                ((ReadInJoyDisLikeDialogView)localObject1).setOnUninterestConfirmListener(new lzz(this, paramView, paramAdapterView));
                localObject2 = new ArrayList();
                paramInt = 0;
                while (paramInt < 8)
                {
                  ((ArrayList)localObject2).add("" + paramInt);
                  paramInt += 1;
                }
              }
            }
            catch (JSONException paramView)
            {
              for (;;)
              {
                paramView.printStackTrace();
              }
              ((ReadInJoyDisLikeDialogView)localObject1).setUninterestData(paramView.jdField_b_of_type_JavaUtilArrayList);
              this.jdField_b_of_type_ComTencentWidgetActionSheet.a((View)localObject1, null);
              try
              {
                if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
                {
                  if ((VersionUtils.g()) && (!ShortVideoUtils.c()))
                  {
                    this.jdField_b_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(8, 8);
                    this.jdField_b_of_type_ComTencentWidgetActionSheet.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
                    this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnShowListener(new maa(this));
                  }
                  this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
                  PublicAccountReportUtils.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, VideoReporter.a(null, null, null, null, paramAdapterView), false);
                }
              }
              catch (Exception paramAdapterView)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "dislikeSheet.show exception=" + paramAdapterView);
                  }
                }
              }
              paramInt = 3;
              break label202;
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "文章ID为：" + paramView.jdField_g_of_type_JavaLangString + "的负反馈数据为空!");
              }
            }
          }
        }
        paramInt = 3;
        break label202;
        label1990:
        paramAdapterView = null;
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          continue;
          label2003:
          paramView = "0";
        }
        label2010:
        localObject2 = localVideoInfo.jdField_j_of_type_JavaLangString;
        str = Integer.toString(paramInt);
        if (TextUtils.isEmpty(localVideoInfo.jdField_g_of_type_JavaLangString)) {}
      }
    }
    for (paramView = localVideoInfo.jdField_g_of_type_JavaLangString;; paramView = "0")
    {
      PublicAccountReportUtils.a(null, (String)localObject2, "0X800740F", "0X800740F", 0, 0, "0", str, paramView, VideoReporter.a(paramAdapterView, localVideoInfo.jdField_j_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L, (JSONObject)localObject1), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */