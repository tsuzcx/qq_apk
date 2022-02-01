package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.EncryptUinHandler;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.VideoShareUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.IRIJWriteWatchWordShareContract.IView;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordModel;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordPresenter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.ShareReport;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class VideoFeedsShareController
  implements IRIJWriteWatchWordShareContract.IView
{
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(12), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(72) }));
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private SparseArray<ShareAction> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private EncryptUinHandler jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private RIJWriteWatchWordPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJWriteWatchWordPresenter;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsShareController.RIJObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$RIJObserver;
  private VideoFeedsShareController.ShareSheetActionListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ShareSheetActionListener;
  ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new VideoFeedsShareController.ShortVideoMqqHandler(this, null);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = true;
  private boolean e = false;
  
  public VideoFeedsShareController(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, int paramInt1, boolean paramBoolean, VideoFeedsShareController.ShareSheetActionListener paramShareSheetActionListener, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ShareSheetActionListener = paramShareSheetActionListener;
    this.e = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler = ((EncryptUinHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENCRYPT_UIN_HANDLER));
    if (this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler.a();
    }
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJWriteWatchWordPresenter = new RIJWriteWatchWordPresenter(new RIJWriteWatchWordModel());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJWriteWatchWordPresenter.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$RIJObserver = new VideoFeedsShareController.RIJObserver(this, null);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$RIJObserver);
    d();
  }
  
  public static int a()
  {
    return ((Integer)ReadInJoyHelper.a("CONFIG_LAST_SHARE_ACTION", Integer.valueOf(1))).intValue();
  }
  
  @NotNull
  private String a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentBizPubaccountEncryptUinHandler.a())
    {
      if (!TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))
      {
        localStringBuilder.append(paramVideoInfo.jdField_f_of_type_JavaLangString);
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append("&iid=").append(str);
        }
        localStringBuilder.append("&rowkey=").append(paramVideoInfo.g);
      }
      return localStringBuilder.toString();
    }
  }
  
  private void a(int paramInt, VideoInfo paramVideoInfo)
  {
    VideoInfo localVideoInfo2 = null;
    VideoInfo localVideoInfo1 = null;
    ReportInfo.VideoExtraRepoerData localVideoExtraRepoerData;
    if ((paramInt != 1) && (paramInt != 11) && (paramInt != 6) && (!this.e))
    {
      localVideoExtraRepoerData = new ReportInfo.VideoExtraRepoerData();
      localVideoExtraRepoerData.d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
      localVideoExtraRepoerData.e = (paramVideoInfo.a() * 1000);
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break label182;
      }
      localVideoExtraRepoerData.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    }
    label182:
    for (paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; paramInt = -1)
    {
      if (this.jdField_c_of_type_Int == 1)
      {
        localVideoInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        paramVideoInfo = localVideoInfo1;
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) {
          paramVideoInfo = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
        }
        VideoReporter.a(localVideoInfo2, paramInt, 26, -1, localVideoExtraRepoerData, paramVideoInfo);
        return;
      }
      localVideoInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      paramVideoInfo = localVideoInfo2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) {
        paramVideoInfo = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
      }
      VideoReporter.b(localVideoInfo1, paramInt, 26, -1, localVideoExtraRepoerData, paramVideoInfo);
      return;
    }
  }
  
  private void a(int paramInt1, VideoInfo paramVideoInfo, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(this.jdField_b_of_type_Boolean);
    boolean bool1 = false;
    if (!TextUtils.isEmpty(paramVideoInfo.v))
    {
      paramString = paramVideoInfo.v;
      bool1 = true;
      if ((paramVideoInfo.n == null) || (!paramVideoInfo.n.contains("kandianshare.html5.qq.com"))) {
        break label234;
      }
      paramString = paramVideoInfo.n;
    }
    label234:
    for (;;)
    {
      Object localObject = new StringBuilder();
      if (paramVideoInfo.t > 0) {
        ((StringBuilder)localObject).append(VideoFeedsHelper.b(paramVideoInfo.t)).append(" ");
      }
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
      String str = paramVideoInfo.jdField_c_of_type_JavaLangString;
      localObject = ((StringBuilder)localObject).toString();
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (paramInt1 == 9) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        VideoShareUtils.a(localBaseActivity, str, (String)localObject, paramString, localBitmap, bool2, paramVideoInfo.g, bool1, new VideoFeedsShareController.WeChatShareResultCallback(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt2, paramInt3, paramVideoInfo));
        return;
        if (paramInt1 == 9)
        {
          paramString = paramString + "&sourcefrom=2";
          break;
        }
        paramString = paramString + "&sourcefrom=3";
        break;
      }
    }
  }
  
  public static void a(VideoInfo paramVideoInfo, Activity paramActivity, int paramInt1, @NotNull String paramString1, int paramInt2, String paramString2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    paramVideoInfo = VideoStructMsgHelper.a.a(FeedsChannelDataHelper.a(paramVideoInfo));
    Intent localIntent = new Intent();
    localIntent.putExtras(paramVideoInfo);
    if (TextUtils.isEmpty(paramString1))
    {
      ForwardBaseOption.a(paramActivity, localIntent, 21);
      return;
    }
    localIntent.putExtra("toUin", paramString1);
    localIntent.putExtra("uinType", paramInt2);
    localIntent.putExtra("uinname", paramString2);
    ForwardBaseOption.a(paramActivity, localIntent, DirectForwardActivity.class, 21, -1, "");
  }
  
  private void a(VideoInfo paramVideoInfo, @NotNull String paramString1, int paramInt, String paramString2)
  {
    d(1);
    a(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramString1, paramInt, paramString2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(this.jdField_b_of_type_Boolean);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", GalleryReportedUtils.a(this.jdField_a_of_type_AndroidAppActivity));
      localJSONObject.put("os", "1");
      localJSONObject.put("source", this.jdField_a_of_type_Int + "");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("vid", paramString3);
      if (paramBoolean) {
        localJSONObject.put("cancel", String.valueOf(1));
      }
      if (paramInt1 >= 0) {
        localJSONObject.put("sourcefrom", paramInt1 + "");
      }
      if (paramInt2 >= 0) {
        localJSONObject.put("share_unit", paramInt2 + "");
      }
      localJSONObject.put("show", this.jdField_b_of_type_Int);
      localJSONObject.put("type", 1);
      paramVideoInfo = localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramVideoInfo = str;
        if (QLog.isColorLevel())
        {
          QLog.d("VideoFeedsShareController", 2, "shareReport:" + paramString1.toString());
          paramVideoInfo = str;
        }
      }
    }
    paramVideoInfo = new VideoR5.Builder(paramVideoInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(paramString2), String.valueOf(paramLong), paramVideoInfo.a().a(), false);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsShareController", 2, paramString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = 0;
    a("shareMsgToSina start!");
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject = new String[9];
    localObject[0] = HardCodeUtil.a(2131716059);
    localObject[1] = HardCodeUtil.a(2131715988);
    localObject[2] = HardCodeUtil.a(2131716022);
    localObject[3] = HardCodeUtil.a(2131715970);
    localObject[4] = HardCodeUtil.a(2131716017);
    localObject[5] = HardCodeUtil.a(2131715981);
    localObject[6] = HardCodeUtil.a(2131716039);
    localObject[7] = HardCodeUtil.a(2131716000);
    localObject[8] = HardCodeUtil.a(2131715993);
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      a("shareMsgToSina empty title or share_url");
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131719291, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(this.jdField_b_of_type_Boolean);
    a("shareMsgToSina installSinaWeibo:false");
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
      if (this.e) {
        i = 40677;
      }
      paramString3.putExtra("big_brother_source_key", RIJJumpUtils.a(i));
      paramString2.startActivity(paramString3);
      a("shareMsgToSina start webview!");
      return;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131719291, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
      paramString1.printStackTrace();
      return;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, String paramString6, boolean paramBoolean)
  {
    String str2 = "0X800740F";
    String str1 = str2;
    if (!paramBoolean) {
      if (this.jdField_a_of_type_Int != 9)
      {
        str1 = str2;
        if (this.jdField_a_of_type_Int != 12) {}
      }
      else
      {
        str1 = "0X800929A";
      }
    }
    paramString4 = new VideoR5.Builder(paramString4, paramString1, paramString5, paramString3).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a()).c(paramInt1 * 1000);
    if (!paramBoolean) {
      paramString4.e(paramLong).c(paramInt2).g(paramInt4).a(paramString6);
    }
    paramString4.a(paramInt3).M(this.jdField_c_of_type_Int);
    paramString5 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      paramString5.publicAccountReportClickEvent(null, paramString1, str1, str1, 0, 0, "0", paramString2, paramString3, paramString4.a().a(), false);
      return;
      paramString3 = "0";
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    Integer localInteger;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)));
      localInteger = Integer.valueOf(0);
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
        localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
    } while (localInteger.intValue() != 0);
    ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 1);
  }
  
  private boolean a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt)))
    {
      Integer localInteger = Integer.valueOf(0);
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
        localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      if (localInteger.intValue() == 1)
      {
        showFailedToast("分享失败");
        return false;
      }
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 72)) {
        a(true);
      }
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() == 0;
    }
    return true;
  }
  
  private static void b(Context paramContext, int paramInt1, int paramInt2, VideoInfo paramVideoInfo, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    str = "";
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("network", GalleryReportedUtils.a(paramContext));
        localJSONObject.put("os", "1");
        localJSONObject.put("source", paramInt1 + "");
        localJSONObject.put("uin", paramVideoInfo.j);
        localJSONObject.put("rowkey", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
        localJSONObject.put("vid", paramVideoInfo.jdField_a_of_type_JavaLangString);
        if (paramBoolean1) {
          localJSONObject.put("cancel", String.valueOf(1));
        }
        if (paramInt3 >= 0) {
          localJSONObject.put("sourcefrom", paramInt3 + "");
        }
        if (paramInt4 < 0) {
          continue;
        }
        localJSONObject.put("share_unit", paramInt4 + "");
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        paramContext = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsShareController", 2, "shareReport:" + localException.toString());
        paramContext = str;
        continue;
        if (!paramBoolean2) {
          continue;
        }
        paramInt1 = 0;
        continue;
      }
      localJSONObject.put("result", paramInt1);
      localJSONObject.put("show", paramInt2);
      paramContext = localJSONObject.toString();
      paramContext = new VideoR5.Builder(paramContext);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramVideoInfo.g), String.valueOf(paramVideoInfo.jdField_f_of_type_Long), paramContext.a().a(), false);
      ReadInJoyShareHelperV2.ShareReport.a.a(paramBoolean2);
      return;
      paramInt1 = 1;
    }
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    a(paramVideoInfo, "", 0, "");
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new VideoFeedsShareController.SendToReadInJoyShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new VideoFeedsShareController.CopyLinkAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new VideoFeedsShareController.ReportAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new VideoFeedsShareController.SendToSpecialFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new VideoFeedsShareController.SendToFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new VideoFeedsShareController.SendToFriendShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new VideoFeedsShareController.OpenInQQBrowserShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new VideoFeedsShareController.OpenInSysBrowserShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new VideoFeedsShareController.SendToQzoneShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new VideoFeedsShareController.AddFavoriteAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new VideoFeedsShareController.SendToWeChatShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(10, new VideoFeedsShareController.SendToWeChatCircleShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new VideoFeedsShareController.SendToSinaShareAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new VideoFeedsShareController.ReportDislikeAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new VideoFeedsShareController.SendToPcAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(161, new VideoFeedsShareController.ReportVideoPlayFeedbackAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(134, new VideoFeedsShareController.AddVideoToTopic(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(70, new VideoFeedsShareController.AddColorNoteAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(82, new VideoFeedsShareController.RemoveColorNoteAction(this));
  }
  
  private static void d(int paramInt)
  {
    ReadInJoyHelper.a("CONFIG_LAST_SHARE_ACTION", Integer.valueOf(paramInt));
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) && (!jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g))) {
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 2);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {}
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int i = VideoFeedsHelper.b(this.jdField_a_of_type_AndroidAppActivity)[0];
        int j = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity);
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b, localURLDrawableOptions);
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        a("initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentImageURLDrawable == null);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new VideoFeedsShareController.7(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void g()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null));
    Object localObject = new VideoFeedsShareController.8(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.registerWatchDisMissActionListener((ActionSheet.WatchDismissActions)localObject);
    localObject = new ReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
    ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new VideoFeedsShareController.9(this, localVideoInfo));
    ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new VideoFeedsShareController.10(this, localVideoInfo));
    ArrayList localArrayList = new ArrayList();
    if ((localVideoInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.size() > 0))
    {
      Iterator localIterator = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e.iterator();
      if (localIterator.hasNext())
      {
        VideoAdInfo.NegFeedback localNegFeedback = (VideoAdInfo.NegFeedback)localIterator.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_JavaLangString = localNegFeedback.jdField_a_of_type_JavaLangString;
        localDislikeInfo.jdField_a_of_type_Long = ((int)localNegFeedback.jdField_a_of_type_Long);
        if (TextUtils.isEmpty(localVideoInfo.j)) {}
        for (localDislikeInfo.b = "";; localDislikeInfo.b = localVideoInfo.j)
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView((View)localObject, null);
      try
      {
        if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
        {
          if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
          {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnShowListener(new VideoFeedsShareController.11(this));
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    this.d = true;
  }
  
  @TargetApi(11)
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new VideoFeedsShareController.SheetItemClickProcessor(this));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setCancelListener(new VideoFeedsShareController.4(this));
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setOnDismissListener(new VideoFeedsShareController.5(this));
    try
    {
      int i;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().isShowing())
      {
        if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList())) {
          this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setOnShowListener(new VideoFeedsShareController.6(this));
        }
        this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setEnableNotTriggerVirtualNavigationBar(true);
        if (!ReadInJoyHelper.d()) {
          break label204;
        }
        if (paramInt != 2) {
          break label199;
        }
        i = 19;
      }
      for (;;)
      {
        String str = a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a(a(paramInt), i, str, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        f();
        return;
        label199:
        i = 3;
        continue;
        label204:
        if (paramInt == 2) {
          i = 21;
        } else {
          i = 20;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      a("actionSheet.show exception=" + localException);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a("doOnShareButtonPressed()");
    this.jdField_b_of_type_Int = paramInt1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ShareSheetActionListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ShareSheetActionListener.f();
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.i == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)))
      {
        g();
      }
      else
      {
        e();
        a(paramInt2);
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (paramInt2 != -1) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false) {
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramIntent, 0, -1, false, bool);
    return;
    b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramIntent, 1, -1, false, bool);
    a(bool);
    return;
    ReadInJoyShareHelperV2.ShareReport.a.a(bool);
    a(bool);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void a(ColorNoteController paramColorNoteController)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController = paramColorNoteController;
  }
  
  @TargetApi(11)
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719396);
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719356);
    String str3 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719397);
    String str4 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719375);
    String str5 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131690800);
    String str6 = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    boolean bool2 = false;
    Object localObject = new File(str6);
    long l = ((File)localObject).length();
    boolean bool1 = bool2;
    if (((File)localObject).exists())
    {
      bool1 = bool2;
      if (l >= paramMessageForShortVideo.videoFileSize) {
        bool1 = true;
      }
    }
    if (ImmersiveUtils.isSupporImmersive() == -1)
    {
      localObject = ActionSheet.createFullScreenDialog(this.jdField_a_of_type_AndroidAppActivity);
      ((ActionSheet)localObject).addButton(str1);
      ((ActionSheet)localObject).setOnDismissListener(new VideoFeedsShareController.1(this));
      if (paramMessageForShortVideo.videoFileStatus != 5001) {
        ((ActionSheet)localObject).addButton(str3);
      }
      if (!bool1) {
        break label334;
      }
      ((ActionSheet)localObject).addButton(str2);
      ((ActionSheet)localObject).addButton(str4);
    }
    for (;;)
    {
      ((ActionSheet)localObject).addCancelButton(str5);
      if (!((ActionSheet)localObject).isShowing())
      {
        if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
        {
          ((ActionSheet)localObject).getWindow().setFlags(8, 8);
          if (VersionUtils.g()) {
            ((ActionSheet)localObject).getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
          }
          ((ActionSheet)localObject).setOnShowListener(new VideoFeedsShareController.2(this, (ActionSheet)localObject));
        }
        ((ActionSheet)localObject).show();
      }
      ((ActionSheet)localObject).setOnButtonClickListener(new VideoFeedsShareController.3(this, (ActionSheet)localObject, str1, paramMessageForShortVideo, str3, bool1, str6, str2, str4));
      return;
      localObject = ActionSheet.create(this.jdField_a_of_type_AndroidAppActivity);
      break;
      label334:
      ((ActionSheet)localObject).addButton(str2, 7);
      ((ActionSheet)localObject).addButton(str4, 7);
    }
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
      return false;
    }
    if (!a(paramInt)) {
      return false;
    }
    c(paramInt);
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ShareSheetActionListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$ShareSheetActionListener.a(paramInt, localVideoInfo);
    }
    String str = a(localVideoInfo);
    ShareAction localShareAction = (ShareAction)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localShareAction == null) {
      return false;
    }
    int i = localShareAction.c();
    int j = localShareAction.a();
    int k = localShareAction.b();
    localShareAction.a(paramInt, localVideoInfo, str, paramActionSheetItem);
    a(paramInt, localVideoInfo);
    if ((localVideoInfo.jdField_a_of_type_Int == 0) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      paramActionSheetItem = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.getIntent() == null)) {
        break label269;
      }
      paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      label171:
      if (localVideoInfo.w == null) {
        break label274;
      }
    }
    label269:
    label274:
    for (str = localVideoInfo.w;; str = "")
    {
      a(localVideoInfo.j, Integer.toString(k), localVideoInfo.g, paramActionSheetItem, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.a(), localVideoInfo.jdField_f_of_type_Long, localVideoInfo.s, -1, paramInt, str, false);
      a(localVideoInfo, String.valueOf(ReadInJoyUtils.a()), localVideoInfo.g, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_f_of_type_Long, i, j, false);
      return true;
      paramActionSheetItem = null;
      break;
      paramInt = 0;
      break label171;
    }
  }
  
  public List<Integer>[] a(int paramInt)
  {
    List localList = ReadInJoyShareHelperV2.a();
    if ((!RIJAladdinUtils.d()) && (paramInt == 2)) {
      return new List[] { localList };
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c())
      {
        localArrayList.add(0, Integer.valueOf(82));
        QLog.d("VideoFeedsShareController", 2, "mColorNoteController ： open sheet delete colorNote");
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!RIJUgcUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.l))) {
        break label236;
      }
      localArrayList.add(Integer.valueOf(134));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(1));
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if ((localVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localVideoInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          localArrayList.add(Integer.valueOf(44));
        }
      }
      localArrayList.add(Integer.valueOf(11));
      localArrayList.add(Integer.valueOf(161));
      return new List[] { localList, localArrayList };
      localArrayList.add(0, Integer.valueOf(70));
      QLog.d("VideoFeedsShareController", 2, "mColorNoteController ： open sheet add colorNote");
      break;
      label236:
      localArrayList.add(Integer.valueOf(6));
    }
  }
  
  public void b()
  {
    this.d = false;
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJWriteWatchWordPresenter.a();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController$RIJObserver);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController
 * JD-Core Version:    0.7.0.1
 */