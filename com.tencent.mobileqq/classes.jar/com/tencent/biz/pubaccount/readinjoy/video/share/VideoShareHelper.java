package com.tencent.biz.pubaccount.readinjoy.video.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.EncryptUinHandler;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.VideoShareUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.IRIJWriteWatchWordShareContract.IView;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordModel;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordPresenter;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoStructMsgHelper;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class VideoShareHelper
  implements AdapterView.OnItemClickListener, IRIJWriteWatchWordShareContract.IView
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private SparseArray<ShareAction> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private EncryptUinHandler jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ReadInJoyAtlasManager.AtlasCallbackImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl = new VideoShareHelper.4(this);
  private RIJWriteWatchWordPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJWriteWatchWordPresenter;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private VideoShareListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareListener;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable = null;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  
  public VideoShareHelper(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl);
    paramActivity = new IntentFilter();
    paramActivity.addAction("com.tencent.process.fav");
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJWriteWatchWordPresenter = new RIJWriteWatchWordPresenter(new RIJWriteWatchWordModel());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJWriteWatchWordPresenter.a(this);
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler.a())
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.getShareUrl()))
      {
        localStringBuilder.append(paramBaseArticleInfo.getShareUrl());
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append("&iid=").append(str);
        }
        localStringBuilder.append("&rowkey=").append(paramBaseArticleInfo.innerUniqueID);
      }
      return localStringBuilder.toString();
    }
  }
  
  private void a(int paramInt1, int paramInt2, BaseArticleInfo paramBaseArticleInfo)
  {
    String str1 = new VideoR5.Builder(null, paramBaseArticleInfo.mSubscribeID, paramBaseArticleInfo.mVideoVid, String.valueOf(paramBaseArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(), paramBaseArticleInfo.mVideoDuration * 1000).e(paramBaseArticleInfo.mAlgorithmID).c(paramBaseArticleInfo.mStrategyId).a(this.jdField_b_of_type_Int).a().a();
    Object localObject;
    String str2;
    String str3;
    if ((paramInt1 != 1) && (paramInt1 != 11) && (paramInt1 != 6))
    {
      long l = this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      localObject = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject).d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a());
      ((ReportInfo.VideoExtraRepoerData)localObject).e = (paramBaseArticleInfo.getVideoDuration() * 1000);
      if (l == 0L)
      {
        paramInt1 = 1;
        ((ReportInfo.VideoExtraRepoerData)localObject).c = paramInt1;
        VideoReporter.a(paramBaseArticleInfo, this.jdField_b_of_type_Int, 26, -1L, (ReportInfo.VideoExtraRepoerData)localObject);
      }
    }
    else
    {
      localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str2 = paramBaseArticleInfo.mSubscribeID;
      str3 = Integer.toString(paramInt2);
      if (TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        break label236;
      }
    }
    label236:
    for (paramBaseArticleInfo = paramBaseArticleInfo.innerUniqueID;; paramBaseArticleInfo = "0")
    {
      ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, str2, "0X800740F", "0X800740F", 0, 0, "1", str3, paramBaseArticleInfo, str1, false);
      return;
      paramInt1 = 2;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
      return;
    }
    str = "";
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("network", GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext));
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("uin", String.valueOf(ReadInJoyUtils.a()));
      ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
      ((JSONObject)localObject).put("source", "2");
      ((JSONObject)localObject).put("version", VideoReporter.a);
      ((JSONObject)localObject).put("vid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoVid());
      if (paramBoolean) {
        ((JSONObject)localObject).put("cancel", String.valueOf(1));
      }
      if (paramInt1 >= 0) {
        ((JSONObject)localObject).put("sourcefrom", String.valueOf(paramInt1));
      }
      if (paramInt2 >= 0) {
        ((JSONObject)localObject).put("share_unit", String.valueOf(paramInt2));
      }
      ((JSONObject)localObject).put("type", 2);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareReport:" + localException.toString());
          localObject = str;
        }
      }
    }
    localObject = new VideoR5.Builder((String)localObject);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID), ((VideoR5.Builder)localObject).a().a(), false);
  }
  
  private void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Boolean = false;
    boolean bool1;
    if (!TextUtils.isEmpty(paramBaseArticleInfo.wechatShareUrl))
    {
      paramString = paramBaseArticleInfo.wechatShareUrl;
      bool1 = true;
      if ((paramBaseArticleInfo.qzoneShareUrl == null) || (!paramBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com"))) {
        break label208;
      }
      paramString = paramBaseArticleInfo.qzoneShareUrl;
    }
    label208:
    for (;;)
    {
      Object localObject = new StringBuilder();
      if (paramBaseArticleInfo.mVideoPlayCount > 0) {
        ((StringBuilder)localObject).append(VideoFeedsHelper.b(paramBaseArticleInfo.mVideoPlayCount)).append(" ");
      }
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
      String str = paramBaseArticleInfo.mTitle;
      localObject = ((StringBuilder)localObject).toString();
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (paramInt == 9) {}
      for (;;)
      {
        VideoShareUtils.a(localBaseActivity, str, (String)localObject, paramString, localBitmap, bool2, paramBaseArticleInfo.innerUniqueID, bool1, null);
        return;
        if (paramInt == 9)
        {
          paramString = paramString + "&sourcefrom=2";
          bool1 = false;
          break;
        }
        paramString = paramString + "&sourcefrom=3";
        bool1 = false;
        break;
        bool2 = false;
      }
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(VideoStructMsgHelper.a.a(paramBaseArticleInfo));
    if ((paramString1 == null) || (paramString1.length() < 5))
    {
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, 21);
      return;
    }
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, DirectForwardActivity.class);
    localIntent.putExtra("toUin", paramString1);
    localIntent.putExtra("uinType", paramInt);
    localIntent.putExtra("uinname", paramString2);
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 21);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start!");
    }
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject = new String[9];
    localObject[0] = "这个视频不错 ~\\(≧▽≦)/~";
    localObject[1] = HardCodeUtil.a(2131716215);
    localObject[2] = HardCodeUtil.a(2131716213);
    localObject[3] = HardCodeUtil.a(2131716210);
    localObject[4] = HardCodeUtil.a(2131716186);
    localObject[5] = HardCodeUtil.a(2131716206);
    localObject[6] = HardCodeUtil.a(2131716214);
    localObject[7] = HardCodeUtil.a(2131716217);
    localObject[8] = HardCodeUtil.a(2131716221);
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131719291, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
    }
    for (;;)
    {
      return;
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1 + "%F0%9F%8E%AC";
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString3;
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString3;
        paramString1 = paramString1 + "&_wv=3";
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString3.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start webview!");
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina end!");
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131719291, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
          paramString1.printStackTrace();
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2(this.jdField_a_of_type_AndroidAppActivity, a(), new VideoShareHelper.SheetItemClickProcessor(this));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setOnDismissListener(new VideoShareHelper.1(this));
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setCancelListener(new VideoShareHelper.2(this));
    String str = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a(a(paramBoolean), 14, str, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    c();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new VideoShareHelper.SendToReadInJoyShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new VideoShareHelper.SendToSpecialFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new VideoShareHelper.SendToFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new VideoShareHelper.SendToMoreFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new VideoShareHelper.SendToQzoneShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new VideoShareHelper.SendToWeChatShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(10, new VideoShareHelper.SendToWeChatCircleShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new VideoShareHelper.SendToSinaShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new VideoShareHelper.OpenInQQBrowserShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new VideoShareHelper.OpenInSysBrowserShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new VideoShareHelper.SendToPcAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new VideoShareHelper.CopyLinkAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new VideoShareHelper.AddFavoriteAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new VideoShareHelper.ReportAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new VideoShareHelper.ReportDislikeAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(161, new VideoShareHelper.ReportVideoPlayFeedbackAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(134, new VideoShareHelper.AddVideoToTopic(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    do
    {
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverURL(), null, null);
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.readinjoy.video.VideoShareHelper", 2, "initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentImageURLDrawable == null);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new VideoShareHelper.3(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null))
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = null;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJWriteWatchWordPresenter.a();
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, Bundle paramBundle, VideoPlayManager paramVideoPlayManager, VideoShareListener paramVideoShareListener, int paramInt, boolean paramBoolean)
  {
    a(paramBaseArticleInfo, paramBundle, paramVideoPlayManager, paramVideoShareListener, paramInt, true, paramBoolean);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, Bundle paramBundle, VideoPlayManager paramVideoPlayManager, VideoShareListener paramVideoShareListener, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareListener = paramVideoShareListener;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_b_of_type_Int = paramInt;
    if (paramBoolean1) {
      a(paramBoolean2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler = ((EncryptUinHandler)a().getBusinessHandler(BusinessHandlerFactory.ENCRYPT_UIN_HANDLER));
    if (this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler.a();
    }
    if (!this.d)
    {
      this.d = true;
      b();
    }
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.c = true;
    BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    ShareAction localShareAction = (ShareAction)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localShareAction == null)
    {
      QLog.e("Q.readinjoy.video.VideoShareHelper", 2, "performActionClick error for can't find shareAction, newAction:" + paramInt);
      return false;
    }
    int i = localShareAction.c();
    int j = localShareAction.a();
    int k = localShareAction.b();
    localShareAction.a(paramInt, localBaseArticleInfo, a(localBaseArticleInfo), paramActionSheetItem);
    a(paramInt, k, localBaseArticleInfo);
    a(i, j, false);
    return true;
  }
  
  public List<Integer>[] a(boolean paramBoolean)
  {
    List localList = ReadInJoyShareHelperV2.a();
    if (!paramBoolean) {
      return new List[] { localList };
    }
    ArrayList localArrayList = new ArrayList();
    if (RIJUgcUtils.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isForbidReprint)) {
      localArrayList.add(Integer.valueOf(134));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mDislikeInfos != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mDislikeInfos.isEmpty())) {
        localArrayList.add(Integer.valueOf(44));
      }
      localArrayList.add(Integer.valueOf(1));
      localArrayList.add(Integer.valueOf(11));
      localArrayList.add(Integer.valueOf(161));
      return new List[] { localList, localArrayList };
      localArrayList.add(Integer.valueOf(6));
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onItemClick, tag = ");
      if (localObject == null) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, bool);
      if (localObject == null) {}
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
  
  public void showFailedToast(@NotNull String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString, 0).a();
  }
  
  public void showSuccessToast(@NotNull String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, paramString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper
 * JD-Core Version:    0.7.0.1
 */