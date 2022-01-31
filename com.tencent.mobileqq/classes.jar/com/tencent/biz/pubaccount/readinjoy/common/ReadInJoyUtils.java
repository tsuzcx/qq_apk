package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCaptureLauncher;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.RedPntInfoForReport;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.AggregateAvatarUrlDrawable;
import com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.math.BigInteger;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import lnb;
import lnc;
import lnd;
import lne;
import lnf;
import lng;
import lnh;
import lni;
import lnj;
import lnk;
import lnl;
import lnm;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ChannelInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.FriendRecommendInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTraceRecord;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SpecialTopicInfo;

public class ReadInJoyUtils
{
  public static int a;
  public static long a;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static ReadInJoySSOHandlerThread jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread;
  public static ArticleInfo a;
  public static final KandianRedDotInfo.RedPntInfoForReport a;
  private static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  private static final BigInteger jdField_a_of_type_JavaMathBigInteger = BigInteger.ONE.shiftLeft(64);
  public static SimpleDateFormat a;
  private static Map jdField_a_of_type_JavaUtilMap;
  private static Queue jdField_a_of_type_JavaUtilQueue;
  public static volatile boolean a;
  public static int b;
  public static long b;
  private static Handler b;
  public static String b;
  public static boolean b;
  public static int c;
  public static String c;
  public static volatile boolean c;
  public static int d;
  public static String d;
  private static boolean d;
  public static int e;
  private static String jdField_e_of_type_JavaLangString;
  private static volatile boolean jdField_e_of_type_Boolean;
  public static int f;
  private static String jdField_f_of_type_JavaLangString;
  private static volatile boolean jdField_f_of_type_Boolean;
  private static int jdField_g_of_type_Int;
  private static boolean jdField_g_of_type_Boolean;
  private static int h;
  private static int i;
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    jdField_b_of_type_JavaLangString = "0";
    jdField_c_of_type_JavaLangString = "1";
    jdField_d_of_type_JavaLangString = "2";
    jdField_a_of_type_Int = 7;
    jdField_c_of_type_Int = -2;
    jdField_f_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_e_of_type_Int = -1;
    jdField_e_of_type_JavaLangString = "";
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport = new KandianRedDotInfo.RedPntInfoForReport();
    jdField_a_of_type_JavaUtilQueue = new LinkedBlockingQueue(100);
    i = 1;
    jdField_f_of_type_Int = 0;
  }
  
  public static int a()
  {
    if (a() == null) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return -1;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      int j = 0;
      while (j < localException.size())
      {
        localObject1 = (RecentBaseData)localException.get(j);
        if (localObject1 != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)localObject1).a(), AppConstants.at);
          if (bool) {
            return j;
          }
        }
        j += 1;
      }
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public static int a(Context paramContext)
  {
    int k = NetworkUtil.a(paramContext);
    int j;
    if (k >= 1)
    {
      j = k;
      if (k <= 4) {}
    }
    else
    {
      j = 5;
    }
    return j;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 10;
    int m = ReadInJoyBaseAdapter.c((ArticleInfo)paramBaseArticleInfo);
    int k;
    switch (m)
    {
    case 13: 
    default: 
      j = 0;
    case 10: 
    case 12: 
    case 44: 
      k = j;
      if (UtilsForComponent.a((ArticleInfo)paramBaseArticleInfo) == 3) {
        k = j;
      }
      switch (m)
      {
      default: 
        k = j;
      case 5: 
      case 6: 
        label378:
        if (f(paramBaseArticleInfo)) {
          k = 54;
        }
        break;
      }
      break;
    }
    while (!d(paramBaseArticleInfo))
    {
      return k;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        j = 55;
        break;
      }
      j = 1;
      break;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        j = 57;
        break;
      }
      j = 2;
      break;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        j = 58;
        break;
      }
      j = 3;
      break;
      j = 4;
      break;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        j = 56;
        break;
      }
      j = 5;
      break;
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        j = 59;
        break;
      }
      j = 6;
      break;
      j = 7;
      break;
      j = 8;
      break;
      j = 9;
      break;
      j = 11;
      break;
      j = 19;
      break;
      j = 20;
      break;
      j = 18;
      break;
      j = 101;
      break;
      j = 22;
      break;
      j = 21;
      break;
      j = 23;
      break;
      j = 30;
      break;
      j = 29;
      break;
      j = 31;
      break;
      j = 24;
      break;
      j = 26;
      break;
      j = 32;
      break;
      j = 33;
      break;
      j = 34;
      break;
      j = 25;
      break;
      j = 27;
      break;
      j = 28;
      break;
      j = 28;
      break;
      j = 35;
      break;
      j = 36;
      break;
      j = 37;
      break;
      j = 38;
      break;
      j = 39;
      break;
      j = 40;
      break;
      if (b((ArticleInfo)paramBaseArticleInfo))
      {
        j = 41;
        break;
      }
      j = 42;
      break;
      j = 19;
      break;
      j = 37;
      break;
      j = 43;
      break;
      if (d((ArticleInfo)paramBaseArticleInfo))
      {
        j = 45;
        break;
      }
      j = 46;
      break;
      j = 29;
      break;
      j = 30;
      break;
      j = 31;
      break;
      j = 47;
      break;
      j = 48;
      break;
      j = 49;
      break;
      j = 50;
      break;
      j = 51;
      break;
      j = 52;
      break;
      j = 53;
      break;
      j = 54;
      break;
      k = 12;
      break label378;
      k = 13;
      break label378;
      k = 14;
      break label378;
      k = 15;
      break label378;
      k = 16;
      break label378;
      k = 17;
      break label378;
    }
    return 47;
  }
  
  public static long a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return 0L;
    }
    return localAppRuntime.getLongAccountUin();
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    int i3 = 0;
    long l1 = NetConnInfoCenter.getServerTime();
    int j = jdField_a_of_type_Int;
    int k = j - 2;
    if ((paramQQAppInterface == null) || (j <= 0))
    {
      QLog.d("ReadInJoyUtils", 1, "break insert individual push time:" + l1);
      return l1;
    }
    Object localObject1 = new ArrayList();
    Object localObject2;
    int i2;
    int n;
    try
    {
      localObject2 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject2 != null) {
        break label197;
      }
      QLog.d("ReadInJoyUtils", 1, "conversation frame is null");
      return l1;
    }
    catch (Exception paramQQAppInterface)
    {
      i2 = 0;
      n = j;
    }
    label103:
    QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    int m = n;
    j = i2;
    label139:
    if (j != 0)
    {
      j = 0;
      label145:
      n = i3;
      if (j >= m) {}
    }
    for (;;)
    {
      long l2;
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(j);
        if (paramQQAppInterface != null)
        {
          l2 = ((RecentUserBaseData)paramQQAppInterface).a.showUpTime;
          if (l2 <= 0L) {}
        }
        else
        {
          j += 1;
          break label145;
          label197:
          localObject2 = ((Conversation)localObject2).a().b();
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((List)localObject2).iterator();
          Object localObject3;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (!(localObject3 instanceof RecentBaseData)) {
              continue;
            }
            ((List)localObject1).add((RecentBaseData)localObject3);
            continue;
          }
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RecentBaseData)((Iterator)localObject2).next();
            if (localObject3 == null) {
              continue;
            }
            localObject3 = (RecentUserBaseData)localObject3;
            if ((((RecentUserBaseData)localObject3).a == null) || (((RecentUserBaseData)localObject3).a.type != 1008) || (!ServiceAccountFolderManager.b(paramQQAppInterface, ((RecentUserBaseData)localObject3).a.uin))) {
              continue;
            }
            ((Iterator)localObject2).remove();
            continue;
          }
          m = ((List)localObject1).size();
          n = j;
          if (j > m) {
            n = m;
          }
          i1 = 0;
          j = 0;
          if (i1 < n) {
            i2 = j;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int i1;
        boolean bool;
        QLog.d("ReadInJoyUtils", 1, "failed to construct individual push time " + paramQQAppInterface.toString());
      }
      try
      {
        paramQQAppInterface = (RecentBaseData)((List)localObject1).get(i1);
        i2 = j;
        if (paramQQAppInterface == null) {
          break label740;
        }
        i2 = j;
        paramQQAppInterface = (RecentUserBaseData)paramQQAppInterface;
        m = j;
        i2 = j;
        if (paramQQAppInterface.jdField_c_of_type_Int > 0) {
          m = 1;
        }
        i2 = m;
        bool = TextUtils.equals(paramQQAppInterface.a(), AppConstants.at);
        i2 = m;
        if (!bool) {
          break label740;
        }
        j = i1;
        k = m;
        i1 += 1;
        m = k;
        k = j;
        j = m;
      }
      catch (Exception paramQQAppInterface) {}
      m = n;
      break label139;
      n = j;
      if (n >= k)
      {
        QLog.d("ReadInJoyUtils", 1, "insert individual push time:" + l1);
        return l1;
      }
      for (;;)
      {
        QLog.d("ReadInJoyUtils", 1, "insert individual push time:" + l1);
        return l1;
        j = (int)(Math.random() * (k - n)) + 1 + n;
        paramQQAppInterface = (RecentUserBaseData)((List)localObject1).get(j - 1);
        localObject1 = (RecentUserBaseData)((List)localObject1).get(j);
        l2 = Math.max(paramQQAppInterface.a.lastmsgtime, paramQQAppInterface.a.lastmsgdrafttime);
        long l3 = Math.max(((RecentUserBaseData)localObject1).a.lastmsgtime, ((RecentUserBaseData)localObject1).a.lastmsgdrafttime);
        double d1 = Math.random();
        l1 = l2 - ((l2 - l3) * d1) - 1L;
        continue;
        QLog.d("ReadInJoyUtils", 1, "construct individual push first " + m + " msg no red point");
      }
      break label103;
      label740:
      j = k;
      k = i2;
    }
  }
  
  public static Intent a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("banner_activityName", FastWebActivity.class.getName());
    localIntent.putExtra("banner_webViewUrl", paramArticleInfo.mArticleContentUrl);
    localIntent.putExtra("banner_wording", String.format("正在浏览 %s", new Object[] { paramArticleInfo.mTitle }));
    paramActivity = paramArticleInfo.mArticleContentUrl;
    if (!TextUtils.isEmpty(paramActivity))
    {
      paramActivity = Uri.parse(paramActivity);
      if (paramActivity.isHierarchical()) {
        localIntent.putExtra("banner_businessCategory", "WebView_" + paramActivity.getHost());
      }
    }
    paramActivity = new Bundle();
    paramActivity.putParcelable("fast_web_article_info", paramArticleInfo);
    localIntent.putExtra("banner_webview_extra", paramActivity);
    return localIntent;
  }
  
  public static Intent a(Intent paramIntent, ArticleInfo paramArticleInfo, int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    if (paramIntent == null) {
      return paramIntent;
    }
    new ArticleInfo();
    paramArticleInfo = paramArticleInfo.clone();
    paramArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    Object localObject = paramArticleInfo.mSocialFeedInfo;
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    localSocializeFeedsInfo.getClass();
    ((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo(localSocializeFeedsInfo);
    paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    localObject = paramArticleInfo.mSocialFeedInfo;
    localObject.getClass();
    localObject = new SocializeFeedsInfo.BiuCommentInfo((SocializeFeedsInfo)localObject);
    ((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString))) {
      ((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_b_of_type_JavaLangString = (": " + paramString);
    }
    ((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_b_of_type_Int = paramArticleInfo.mFeedType;
    ((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_c_of_type_Int = paramInt2;
    ((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_b_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mFeedId);
    paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject);
    paramIntent.putExtra("arg_article_info", paramArticleInfo);
    paramIntent.putExtra("biu_rowkey", paramArticleInfo.innerUniqueID);
    paramIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
    paramIntent.putExtra("arg_from_type", paramInt3);
    paramIntent.putExtra("biu_src", paramInt1);
    paramIntent.putExtra("feed_id", paramArticleInfo.mFeedId);
    paramIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
    return paramIntent;
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, Drawable paramDrawable)
  {
    boolean bool = false;
    String str = null;
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {}
    do
    {
      return paramDrawable;
      localObject = ((QQMessageFacade)localObject).b(AppConstants.at, 7220);
    } while ((localObject == null) || (((MessageRecord)localObject).isread));
    QLog.d("ReadInJoyUtils", 2, "getSpecAggregateAvatarForKandian run !");
    for (;;)
    {
      try
      {
        localResources = BaseApplicationImpl.getApplication().getResources();
        JSONObject localJSONObject = new JSONObject(((MessageRecord)localObject).extStr);
        if (localJSONObject.has("kdUin"))
        {
          localObject = localJSONObject.getString("kdUin");
          QLog.d("ReadInJoyUtils", 2, "got tipUin from kdUin: " + (String)localObject);
          if (localJSONObject.has("kdDefaultSourceAvatarUrl"))
          {
            str = localJSONObject.getString("kdDefaultSourceAvatarUrl");
            QLog.d("ReadInJoyUtils", 2, "got defaultAvatarUrl from kdDefaultSourceAvatarUrl: " + str);
          }
          if (localJSONObject.has("kdShouldShowMergedAvatar"))
          {
            bool = localJSONObject.getBoolean("kdShouldShowMergedAvatar");
            QLog.d("ReadInJoyUtils", 2, "got shouldShowMergedAvatar from kdShouldShowMergedAvatar: " + bool);
          }
          if (!bool)
          {
            QLog.d("ReadInJoyUtils", 2, "shouldn't show merged icon, give up");
            return paramDrawable;
          }
        }
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        Resources localResources;
        paramQQAppInterface.printStackTrace();
        QLog.d("ReadInJoyUtils", 2, "get merge icon has error : " + paramQQAppInterface);
        return paramDrawable;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          str = paramQQAppInterface.a(1, "kd_" + (String)localObject, (byte)1, 0, 100, true);
          paramQQAppInterface = paramQQAppInterface.a(str);
          if (paramQQAppInterface != null)
          {
            QLog.d("ReadInJoyUtils", 2, "getMergeIcon From cache ! key : " + str + ", tipUin : " + (String)localObject);
            return new BitmapDrawable(localResources, paramQQAppInterface);
          }
          paramQQAppInterface = ReadInJoyUserInfoModule.a(Long.parseLong((String)localObject), null);
          if ((paramQQAppInterface == null) || (TextUtils.isEmpty(ReadInJoyUserInfoModule.a(paramQQAppInterface)))) {
            break;
          }
          return new AggregateAvatarUrlDrawable(ImageUtil.a(paramDrawable), ReadInJoyUserInfoModule.a(paramQQAppInterface), AIOUtils.a(50.0F, localResources), localResources);
        }
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramQQAppInterface = new AggregateAvatarUrlDrawable(ImageUtil.a(paramDrawable), str, AIOUtils.a(50.0F, localResources), localResources);
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        QLog.d("ReadInJoyUtils", 2, "get merge icon has error : " + paramQQAppInterface);
        return paramDrawable;
      }
      localObject = null;
    }
  }
  
  public static Handler a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread == null)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread = new ReadInJoySSOHandlerThread("ReadInJoySSOHandlerThread");
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.getLooper());
      }
      Handler localHandler = jdField_a_of_type_AndroidOsHandler;
      return localHandler;
    }
    finally {}
  }
  
  public static View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate(BaseApplicationImpl.sApplication, 2130971657, null);
    ((DragTextView)localView.findViewById(2131364966)).setDragViewType(2);
    ((ReadInjoyTabDragAnimationView)localView.findViewById(2131364965)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131375269)).setText(paramInt5);
    return localView;
  }
  
  public static ArticleInfo a(String paramString)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    Object localObject5;
    long l1;
    Object localObject6;
    Object localObject2;
    int j;
    for (;;)
    {
      try
      {
        localObject5 = new JSONObject(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyUtils", 2, "web json:" + ((JSONObject)localObject5).toString());
        }
        localObject3 = ((JSONObject)localObject5).optString("title");
        localObject1 = ((JSONObject)localObject5).optString("sourceName");
        l2 = 0L;
        l3 = 0L;
        l7 = 0L;
        l11 = 0L;
      }
      catch (Exception paramString)
      {
        Object localObject3;
        long l11;
        long l8;
        long l9;
        long l10;
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyUtils", 2, "Exception error=" + paramString.getMessage());
        }
        return localArticleInfo;
      }
      for (;;)
      {
        try
        {
          paramString = new String(Base64Util.decode((String)localObject3, 0));
        }
        catch (Exception localException3)
        {
          Object localObject4;
          paramString = (String)localObject1;
          l6 = l7;
          localObject1 = localObject4;
          break;
          if (k == 4) {
            continue;
          }
          if (k != 5) {
            continue;
          }
          continue;
        }
        try
        {
          localObject3 = new String(Base64Util.decode((String)localObject1, 0));
          l6 = l7;
          l5 = l3;
          l4 = l2;
        }
        catch (Exception localException1)
        {
          localObject4 = paramString;
          paramString = (String)localObject1;
          l6 = l7;
          localObject1 = localObject4;
          break;
        }
      }
      try
      {
        localObject1 = ((JSONObject)localObject5).optString("feedsId");
        l1 = l2;
        l6 = l7;
        l5 = l3;
        l4 = l2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l3;
          l4 = l2;
          l1 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l7;
        l5 = l3;
        l4 = l1;
        localObject1 = ((JSONObject)localObject5).optString("ariticleId");
        l2 = l3;
        l6 = l7;
        l5 = l3;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l3;
          l4 = l1;
          l2 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l7;
        l5 = l2;
        l4 = l1;
        localObject1 = ((JSONObject)localObject5).optString("originFeedsId");
        l3 = l7;
        l6 = l7;
        l5 = l2;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l2;
          l4 = l1;
          l3 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l3;
        l5 = l2;
        l4 = l1;
        localObject6 = ((JSONObject)localObject5).optString("businessId");
        l7 = l11;
        localObject2 = localObject3;
        l8 = l3;
        l9 = l2;
        l10 = l1;
        localObject1 = paramString;
        l6 = l3;
        l5 = l2;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          l6 = l3;
          l5 = l2;
          l4 = l1;
          l7 = new BigInteger((String)localObject6).longValue();
          localObject1 = paramString;
          l10 = l1;
          l9 = l2;
          l8 = l3;
          localObject2 = localObject3;
        }
        l1 = ((JSONObject)localObject5).optLong("originFeedsType", 1L);
        paramString = ((JSONObject)localObject5).optString("picurl");
        j = ((JSONObject)localObject5).optInt("duration");
        ((JSONObject)localObject5).optString("callback");
        localObject3 = new String(Base64Util.decode(((JSONObject)localObject5).optString("accountDesc"), 0));
        k = ((JSONObject)localObject5).optInt("feedsType", 1);
        localArticleInfo.mArticleID = l9;
        localArticleInfo.mTitle = ((String)localObject1);
        localArticleInfo.mSubscribeName = ((String)localObject2);
        localArticleInfo.mFirstPagePicUrl = paramString;
        localArticleInfo.mVideoDuration = j;
        localArticleInfo.mFeedId = l10;
        localArticleInfo.mFeedType = k;
        localArticleInfo.mSummary = ((String)localObject3);
        localArticleInfo.businessId = l7;
        paramString = ((JSONObject)localObject5).getJSONArray("biuLevelList");
        localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
        localObject2 = localArticleInfo.mSocialFeedInfo;
        localObject3 = localArticleInfo.mSocialFeedInfo;
        localObject3.getClass();
        ((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo((SocializeFeedsInfo)localObject3);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(l8);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(l1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
        if (paramString == null) {
          break label936;
        }
        j = 0;
        if (j >= paramString.length()) {
          break label936;
        }
        localObject2 = localArticleInfo.mSocialFeedInfo;
        localObject2.getClass();
        localObject2 = new SocializeFeedsInfo.BiuCommentInfo((SocializeFeedsInfo)localObject2);
        localObject3 = paramString.getJSONObject(j);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject3).optLong("uin"));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).optString("comment");
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("biuTime");
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_Int = ((JSONObject)localObject3).optInt("feeds_type", 1);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_c_of_type_Int = ((JSONObject)localObject3).optInt("op_type");
      }
      catch (Exception localException2)
      {
        localObject1 = paramString;
        paramString = (String)localObject4;
        l3 = l5;
        l2 = l4;
        continue;
      }
      try
      {
        localObject3 = ((JSONObject)localObject3).optString("feedsId");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject3).longValue());
        }
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString = new String(Base64Util.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangString, 0));
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        continue;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject2);
      j += 1;
      continue;
      ((Exception)localObject2).printStackTrace();
      l7 = l11;
      localObject2 = paramString;
      l8 = l6;
      l9 = l3;
      l10 = l2;
    }
    label936:
    paramString = ((JSONObject)localObject5).optJSONObject("ugcInfo");
    if ((paramString != null) && ((k == 4) || (k == 5) || ((k == 1) && ((l1 == 4L) || (l1 == 5L)))))
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo = new SocializeFeedsInfo.UGCFeedsInfo();
      k = paramString.optInt("ugcType", 0);
      localObject2 = paramString.optString("ugcComment");
      localObject4 = paramString.optJSONArray("ugcAtLevelList");
      if (localObject4 != null)
      {
        localObject5 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
        localObject6 = localArticleInfo.mSocialFeedInfo;
        localObject6.getClass();
        ((SocializeFeedsInfo.UGCFeedsInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo((SocializeFeedsInfo)localObject6);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
        j = 0;
        for (;;)
        {
          if (j >= ((JSONArray)localObject4).length()) {
            break label1295;
          }
          localObject5 = localArticleInfo.mSocialFeedInfo;
          localObject5.getClass();
          localObject5 = new SocializeFeedsInfo.BiuCommentInfo((SocializeFeedsInfo)localObject5);
          localObject6 = ((JSONArray)localObject4).getJSONObject(j);
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject6).optLong("uin"));
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject6).optString("comment");
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_Int = ((JSONObject)localObject6).optInt("biuTime");
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_Int = ((JSONObject)localObject6).optInt("feeds_type", 1);
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_c_of_type_Int = ((JSONObject)localObject6).optInt("op_type");
          try
          {
            localObject6 = ((JSONObject)localObject6).optString("feedsId");
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject6).longValue());
            }
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString = new String(Base64Util.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString, 0));
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              localException5.printStackTrace();
            }
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject5);
          j += 1;
        }
      }
      label1295:
      localArticleInfo.mTitle = new String(Base64Util.decode((String)localObject2, 0));
      localArticleInfo.mSummary = "";
      if ((k != 3) && (k != 2)) {
        break label1630;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = new SocializeFeedsInfo.UGCPicInfo();
      paramString = paramString.optJSONArray("ugcPicInfo");
      if ((paramString != null) && (paramString.length() > 0))
      {
        ((SocializeFeedsInfo.UGCPicInfo)localObject1).jdField_c_of_type_JavaLangString = paramString.getJSONObject(0).optString("ugcPicUrl");
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    for (;;)
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int = k;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString = localArticleInfo.mTitle;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
      localArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
      localArticleInfo.mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
      return localArticleInfo;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b = new ArrayList();
      localObject2 = new SocializeFeedsInfo.UGCVideoInfo();
      paramString = paramString.optJSONObject("ugcVideoInfo");
      if (paramString != null)
      {
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_d_of_type_JavaLangString = paramString.optString("ugcVideoCoverUrl");
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_a_of_type_Long = paramString.optInt("ugcVideoDuration");
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).jdField_e_of_type_JavaLangString = ((String)localObject1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.add(localObject2);
        continue;
        if (k == 1) {
          localArticleInfo.mFirstPagePicUrl = "";
        }
      }
    }
  }
  
  public static ReadinjoyTabFrame a(Context paramContext)
  {
    if ((paramContext instanceof SplashActivity))
    {
      paramContext = FrameHelperActivity.a((BaseActivity)paramContext);
      if (paramContext != null) {}
    }
    else
    {
      return null;
    }
    return (ReadinjoyTabFrame)paramContext.a(ReadinjoyTabFrame.class);
  }
  
  public static MessageForStructing a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.getCurrentAccountUin());
      jdField_a_of_type_JavaUtilMap.remove(paramQQAppInterface.getCurrentAccountUin());
      return localMessageForStructing;
    }
  }
  
  public static QQCustomDialog a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    boolean bool2 = true;
    if ((paramContext instanceof Activity)) {}
    for (Activity localActivity = (Activity)paramContext;; localActivity = null)
    {
      if (localActivity == null) {
        return null;
      }
      if (ReadInJoyHelper.e(BaseApplicationImpl.getApplication().getRuntime()) > 0)
      {
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "showMobileNetConfirmDlg(), configSwitchEnable=" + bool1);
        }
        if (!bool1) {
          break label191;
        }
        if ((!bool1) || (!CUKingCardHelper.a(localActivity, 1, new lnl(paramOnClickListener1, paramOnClickListener2), "kandian"))) {
          break label186;
        }
      }
      label186:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "showMobileNetConfirmDlg(), shouldOverride=" + bool1);
        }
        if (!bool1) {
          break label235;
        }
        paramContext = DialogUtil.a(paramContext, 232, paramContext.getString(2131437414), paramContext.getString(2131437415), paramContext.getString(2131433029), paramContext.getString(2131433032), paramOnClickListener1, paramOnClickListener2);
        paramContext.show();
        return paramContext;
        bool1 = false;
        break;
      }
      label191:
      paramContext = DialogUtil.a(paramContext, 232, paramContext.getString(2131437414), paramContext.getString(2131437415), paramContext.getString(2131433029), paramContext.getString(2131433032), paramOnClickListener1, paramOnClickListener2);
      paramContext.show();
      return paramContext;
      label235:
      return null;
    }
  }
  
  public static Object a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, paramBoolean);
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.getString(paramString, "");
          if (!TextUtils.isEmpty(paramAppRuntime))
          {
            paramAppRuntime = new ObjectInputStream(new ByteArrayInputStream(PkgTools.a(paramAppRuntime)));
            paramString = paramAppRuntime.readObject();
            paramAppRuntime.close();
            return paramString;
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
      }
    }
    return null;
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public static String a(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt);
      ((JSONObject)localObject).put("kandian_mode", e());
      ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.a());
      ((JSONObject)localObject).put("tab_source", d());
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return new ReadInJoyUtils.ReportR5Builder().a().b().a(paramInt1).d().e().f().g().a(paramString).b(paramInt2).c(paramInt3).a();
  }
  
  public static String a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(d());
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", jdField_d_of_type_Int);
        localJSONObject.put("source", str);
        localJSONObject.put("feeds_type", paramInt2);
        localJSONObject.put("kandian_mode", e());
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localJSONObject.put("rowkey", paramString2);
        localJSONObject.put("pic_number", paramInt1);
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyUtils", 2, "transGridImageClickR5 json exception.");
        paramString1.printStackTrace();
        continue;
      }
      return localJSONObject.toString();
      localJSONObject.put("rowkey", "0");
    }
  }
  
  public static String a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(d());
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", jdField_d_of_type_Int);
        if (TextUtils.isEmpty(paramString3)) {
          continue;
        }
        localJSONObject.put("feeds_source", paramString3);
        localJSONObject.put("feeds_type", paramInt2);
        localJSONObject.put("kandian_mode", e());
        localJSONObject.put("source", str);
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localJSONObject.put("rowkey", paramString2);
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyUtils", 2, "transGridImageClickR5 json exception.");
        paramString1.printStackTrace();
        continue;
        localJSONObject.put("rowkey", "0");
        continue;
      }
      localJSONObject.put("pic_number", paramInt1);
      return localJSONObject.toString();
      localJSONObject.put("feeds_source", "0");
    }
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, ArticleInfo paramArticleInfo)
  {
    try
    {
      paramString1 = a(paramLong, paramInt1, paramInt2, paramBoolean, paramString1, paramString3, paramString4, paramInt5, paramArticleInfo).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, ArticleInfo paramArticleInfo)
  {
    return a(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString1, paramString2, paramString3, paramString4, 0, paramArticleInfo);
  }
  
  public static String a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, ArticleInfo paramArticleInfo, long paramLong2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean2, int paramInt9, int paramInt10)
  {
    paramString1 = a(paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramString1, paramString2, paramString3, paramString4, paramArticleInfo);
    try
    {
      paramString2 = new JSONObject(paramString1);
      paramString2.put("kandian_mode", paramInt7);
      paramString2.put("kandian_mode_new", VideoReporter.a());
      paramString2.put("tab_source", paramInt6);
      if (paramInt5 >= 0) {
        paramString2.put("behavior_type", paramInt5);
      }
      if (paramLong2 > 0L) {
        paramString2.put("stay_duration", paramLong2);
      }
      paramString2.put("video_inserted", paramBoolean2);
      paramString2.put("video_strategyid", paramInt8);
      paramString2.put("proteus_bid", ReadInJoyHelper.a());
      paramString2.put("ads_jump", paramInt9);
      paramString2.put("ads_source", paramInt10);
      paramString2.put("star_logo", b(paramArticleInfo));
      paramString2 = paramString2.toString();
      return paramString2;
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, ArticleInfo paramArticleInfo, String paramString3)
  {
    paramString1 = a(paramLong, paramInt1, paramInt2, 0, 0, paramBoolean, paramString1, null, paramString2, null, 0, paramArticleInfo);
    try
    {
      paramString2 = new JSONObject(paramString1);
      paramString2.put("topicid", paramString3);
      paramString2.put("proteus_bid", ReadInJoyHelper.a());
      return paramString2.toString();
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getConnectionInfo().getBSSID();
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      paramContext = "";
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    int j = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if (NetworkUtil.h(paramContext)) {
        j = 0;
      }
      for (;;)
      {
        localJSONObject.put("network", j);
        localJSONObject.put("version", paramString1);
        localJSONObject.put("os", 1);
        localJSONObject.put("uin", paramString2);
        return localJSONObject.toString();
        boolean bool = NetworkUtil.c(paramContext);
        if (!bool) {
          j = 2;
        }
      }
      return "";
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      if (ReadInJoyBaseAdapter.a(paramArticleInfo)) {
        localJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
      }
      for (;;)
      {
        localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
        localJSONObject.put("feeds_type", "" + a(paramArticleInfo));
        localJSONObject.put("kandian_mode", "" + e());
        localJSONObject.put("tab_source", "" + d());
        return localJSONObject.toString();
        localJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
      }
      return null;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("ReadInJoyUtils", 1, "transMergeKandianReportR5BaseForFastWeb articleInfo is null.");
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithm_id", paramArticleInfo.mAlgorithmID);
      localJSONObject.put("puin_type", paramString);
      localJSONObject.put("source", a(paramInt));
      localJSONObject.put("kandian_mode", e());
      localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
      return localJSONObject.toString();
    }
    catch (JSONException paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject;
    if (a((ArticleInfo)paramBaseArticleInfo))
    {
      localObject = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
      return localObject;
    }
    if (UtilsForComponent.a((ArticleInfo)paramBaseArticleInfo) == 2)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((oidb_cmd0x68b.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
      paramBaseArticleInfo = "";
      int j = 0;
      for (;;)
      {
        localObject = paramBaseArticleInfo;
        if (j >= localArrayList.size()) {
          break;
        }
        localObject = paramBaseArticleInfo + localArrayList.get(j);
        paramBaseArticleInfo = (BaseArticleInfo)localObject;
        if (j != localArrayList.size() - 1) {
          paramBaseArticleInfo = (String)localObject + ",";
        }
        j += 1;
      }
    }
    if (UtilsForComponent.a((ArticleInfo)paramBaseArticleInfo) == 1) {
      return ((oidb_cmd0x68b.SpecialTopicInfo)paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
    }
    if (UtilsForComponent.a((ArticleInfo)paramBaseArticleInfo) == 3) {
      return paramBaseArticleInfo.mSubscribeID;
    }
    if (ReadInJoyBaseAdapter.a((ArticleInfo)paramBaseArticleInfo)) {
      return paramBaseArticleInfo.mSubscribeID;
    }
    if ((ReadInJoyBaseAdapter.f((ArticleInfo)paramBaseArticleInfo)) || (ReadInJoyBaseAdapter.g((ArticleInfo)paramBaseArticleInfo)) || (ReadInJoyBaseAdapter.h((ArticleInfo)paramBaseArticleInfo)) || (ReadInJoyBaseAdapter.i((ArticleInfo)paramBaseArticleInfo))) {
      return String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
    }
    if (ReadInJoyBaseAdapter.b((ArticleInfo)paramBaseArticleInfo)) {
      return paramBaseArticleInfo.mSubscribeID;
    }
    if (ReadInJoyBaseAdapter.l((ArticleInfo)paramBaseArticleInfo)) {
      return paramBaseArticleInfo.mSubscribeID;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_b_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    long l2;
    Object localObject1;
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject2 = paramString.optJSONObject(0);
      if (localObject2 != null)
      {
        String str4 = ((JSONObject)localObject2).optString("vid");
        int m = ((JSONObject)localObject2).optInt("duration");
        String str5 = ((JSONObject)localObject2).optString("thirdIcon");
        String str6 = ((JSONObject)localObject2).optString("thirdName");
        String str7 = ((JSONObject)localObject2).optString("thirdAction");
        String str8 = ((JSONObject)localObject2).optString("innerUniqueID");
        String str9 = ((JSONObject)localObject2).optString("width", "0");
        String str10 = ((JSONObject)localObject2).optString("height", "0");
        int k = ((JSONObject)localObject2).optInt("busiType");
        int j = k;
        if (k == 0) {
          j = 1;
        }
        String str11 = ((JSONObject)localObject2).optString("third_uin", "");
        String str12 = ((JSONObject)localObject2).optString("third_uin_name", "");
        String str3 = "0";
        String str2 = "";
        l2 = 0L;
        paramString = str2;
        localObject1 = str3;
        for (;;)
        {
          try
          {
            JSONArray localJSONArray = ((JSONObject)localObject2).getJSONArray("video_info");
            k = 0;
            str1 = str2;
            l1 = l2;
            localObject2 = str3;
            paramString = str2;
            localObject1 = str3;
            if (k < localJSONArray.length())
            {
              paramString = str2;
              localObject1 = str3;
              JSONObject localJSONObject = localJSONArray.optJSONObject(k);
              if (localJSONObject == null) {
                continue;
              }
              paramString = str2;
              localObject1 = str3;
              int n = localJSONObject.optInt("network_type");
              paramString = str2;
              localObject1 = str3;
              l1 = localJSONObject.optLong("file_size");
              if (n != 2) {
                continue;
              }
              paramString = str2;
              localObject1 = str3;
              localObject2 = String.valueOf(l1);
              paramString = str2;
              localObject1 = localObject2;
              str1 = localJSONObject.optString("url", "");
              paramString = str1;
              localObject1 = localObject2;
              l1 = localJSONObject.optLong("url_expire_time");
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            String str1 = paramString;
            long l1 = l2;
            Object localObject3 = localObject1;
            continue;
          }
          return str4 + ";" + m + ";" + str5 + ";" + str6 + ";" + str7 + ";" + str8 + ";" + j + ";" + str9 + ";" + str10 + ";" + str11 + ";" + str12 + ";" + (String)localObject2 + ";" + str1 + ";" + l1;
          k += 1;
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString;
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      j = 0;
      k = 0;
      if (j >= paramString.length()) {
        break label144;
      }
      int m = paramString.charAt(j);
      if (((97 > m) || (m > 122)) && ((65 > m) || (m > 90)) && ((48 > m) || (m > 57))) {
        break label130;
      }
      k += 1;
      label75:
      if (k <= paramInt) {
        break label137;
      }
    }
    label130:
    label137:
    label144:
    for (int k = 1;; k = 0)
    {
      str = paramString;
      if (k != 0)
      {
        k = j;
        if (j == paramInt) {
          k = j - 1;
        }
        str = paramString.substring(0, k) + "…";
      }
      return str;
      k += 2;
      break label75;
      j += 1;
      break;
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (!ReadInJoyHelper.b(a())) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
    }
    String[] arrayOfString2;
    String[] arrayOfString1;
    do
    {
      do
      {
        do
        {
          return paramString;
        } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://qqpublic.qpic.cn")));
        arrayOfString2 = paramString.split("/");
      } while (arrayOfString2.length < 2);
      arrayOfString1 = arrayOfString2[(arrayOfString2.length - 2)].split("_");
    } while (arrayOfString1.length < 1);
    String str = arrayOfString1[(arrayOfString1.length - 1)];
    Object localObject;
    label125:
    double d2;
    double d1;
    int j;
    label149:
    double d3;
    double d4;
    if ("open".equals(str))
    {
      localObject = ReadInJoyConstants.a;
      int k = localObject.length;
      d2 = 1.0D * paramInt2 / paramInt1;
      d1 = 1.7976931348623157E+308D;
      arrayOfString1 = null;
      j = 0;
      if (j >= k) {
        break label370;
      }
      d3 = 1.0D * ((Integer)localObject[j].second).intValue() / ((Integer)localObject[j].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 >= d1) {
        break label252;
      }
      d1 = Math.abs(d3 - d2);
      arrayOfString1 = localObject[j];
    }
    label370:
    for (;;)
    {
      j += 1;
      break label149;
      if (!"vsmcut".equals(str)) {
        break;
      }
      localObject = ReadInJoyConstants.b;
      break label125;
      label252:
      if ((d4 == d1) && (arrayOfString1 != null))
      {
        int m = Math.abs(((Integer)arrayOfString1.second).intValue() - paramInt2);
        int n = Math.abs(((Integer)arrayOfString1.first).intValue() - paramInt1);
        int i1 = Math.abs(((Integer)localObject[j].second).intValue() - paramInt2);
        if (m + n > Math.abs(((Integer)localObject[j].first).intValue() - paramInt1) + i1)
        {
          d1 = Math.abs(d3 - d2);
          arrayOfString1 = localObject[j];
          continue;
          if (arrayOfString1 == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "the picture size : w : " + paramInt1 + " h : " + paramInt2 + ", select scale : " + arrayOfString1.first + ":" + arrayOfString1.second + " bias : " + d1);
          }
          localObject = arrayOfString2[(arrayOfString2.length - 1)];
          return paramString.replace(String.format("_%s/%s", new Object[] { str, localObject }), String.format("_%s_%d_%d/%s", new Object[] { str, arrayOfString1.first, arrayOfString1.second, localObject }));
        }
      }
    }
  }
  
  @Deprecated
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ReadInJoyHelper.b(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
      return paramString;
    }
    double d2 = 1.0D * paramInt1 / paramInt2;
    double d1 = 1.7976931348623157E+308D;
    Object localObject1 = null;
    int k = ReadInJoyConstants.a.length;
    Object localObject2 = ReadInJoyConstants.a;
    int j = 0;
    label74:
    double d3;
    double d4;
    if (j < k)
    {
      d3 = 1.0D * ((Integer)localObject2[j].second).intValue() / ((Integer)localObject2[j].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 < d1)
      {
        d1 = Math.abs(d3 - d2);
        localObject1 = localObject2[j];
      }
    }
    for (;;)
    {
      j += 1;
      break label74;
      if ((d4 == d1) && (localObject1 != null))
      {
        int m = Math.abs(((Integer)localObject1.second).intValue() - paramInt1);
        int n = Math.abs(((Integer)localObject1.first).intValue() - paramInt2);
        int i1 = Math.abs(((Integer)localObject2[j].second).intValue() - paramInt1);
        if (m + n > Math.abs(((Integer)localObject2[j].first).intValue() - paramInt2) + i1)
        {
          d1 = Math.abs(d3 - d2);
          localObject1 = localObject2[j];
          continue;
          if (localObject1 == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "the picture size : w : " + paramInt2 + " h : " + paramInt1 + ", select scale : " + localObject1.first + ":" + localObject1.second + " bias : " + d1 + " from : " + paramInt3);
          }
          localObject2 = paramString.split("/");
          localObject2 = localObject2[(localObject2.length - 1)];
          return paramString.replace("_open/" + (String)localObject2, "_open_" + localObject1.first + "_" + localObject1.second + "/" + (String)localObject2);
        }
      }
    }
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    return String.format("https://kandian.qq.com/mqq/html/badcase.html?_wv=1027&_bid=2464&articleid=%s&senceID=%s&articleRecommend=%s&articleChannel=%s&algorithmID=%s&strategyID=%s", new Object[] { paramString1, String.valueOf(paramInt1), Base64.encodeToString(str.getBytes(), 0), String.valueOf(paramInt2), String.valueOf(paramLong), String.valueOf(paramInt3) });
  }
  
  public static String a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("algorithm_id", paramLong);
      localJSONObject.put("feeds_friends_interaction", paramInt);
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("version", "7.6.8".replace(".", ""));
      localJSONObject.put("rowkey", paramString);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "", "", false);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      if (paramInt > 0) {
        localJSONObject.put("from", paramInt);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("video_session_id", paramString2);
      }
      paramString2 = localJSONObject.toString();
      return paramString2;
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("kandian_mode", e());
      localJSONObject.put("tab_source", d());
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("feeds_type", a(paramArticleInfo));
      localJSONObject.put("topicId", paramString2);
      localJSONObject.put("proteus_bid", ReadInJoyHelper.a());
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return Long.toString(System.currentTimeMillis());
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    int k = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("time", System.currentTimeMillis());
      localJSONObject.put("algorithm_id", paramString1);
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if (paramBoolean)
      {
        j = 1;
        localJSONObject.put("avatar", j);
        localJSONObject.put("kd_pos", jdField_e_of_type_Int);
        if (!TextUtils.isEmpty(paramString3)) {
          localJSONObject.put("stick", paramString3);
        }
        if (jdField_d_of_type_Int == 6)
        {
          localJSONObject.put("id", paramString2);
          localJSONObject.put("social_uin", paramString4);
        }
        if (!c()) {
          break label231;
        }
        j = 1;
        label143:
        localJSONObject.put("message_status", j);
        if (ReadInJoyHelper.K(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label237;
        }
        j = 1;
        label170:
        localJSONObject.put("reddot_style", j);
        if (!ReadInJoyHelper.r(a())) {
          break label243;
        }
      }
      label231:
      label237:
      label243:
      for (int j = k;; j = 0)
      {
        localJSONObject.put("hemera_switch", j);
        localJSONObject.put("kandian_mode_new", VideoReporter.a());
        paramString1 = localJSONObject.toString();
        return paramString1;
        j = 0;
        break;
        j = 0;
        break label143;
        j = 0;
        break label170;
      }
      return "";
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static String a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return "";
    }
    localJSONArray = new JSONArray();
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", localDislikeInfo.jdField_a_of_type_Int);
        localJSONObject.put("name", localDislikeInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("tagid", localDislikeInfo.jdField_a_of_type_Long);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray.toString();
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public static String a(oidb_cmd0x68b.ChannelInfo paramChannelInfo)
  {
    if (paramChannelInfo == null) {
      return null;
    }
    return paramChannelInfo.bytes_channel_name.get().toStringUtf8();
  }
  
  public static BigInteger a(long paramLong)
  {
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    if (paramLong >= 0L) {
      return localBigInteger;
    }
    return localBigInteger.add(jdField_a_of_type_JavaMathBigInteger);
  }
  
  public static URL a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = paramString.optJSONObject(0);
      if (paramString == null) {}
    }
    for (;;)
    {
      try
      {
        paramString = paramString.optString("picture");
        if (b(paramString))
        {
          if ((paramBaseArticleInfo.isTwoItemVideoFeed()) || (paramBaseArticleInfo.isWeishiGridTwoItemFeed()) || (paramBaseArticleInfo.mMergeVideoId == 1L))
          {
            paramBaseArticleInfo = ReadInJoyDisplayUtils.d();
            paramBaseArticleInfo = b(paramString, ((Integer)paramBaseArticleInfo.second).intValue(), ((Integer)paramBaseArticleInfo.first).intValue(), 2);
            return PubAccountHttpDownloader.a(paramBaseArticleInfo, 3);
          }
          paramBaseArticleInfo = ReadInJoyDisplayUtils.c();
          continue;
          return null;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        paramBaseArticleInfo.printStackTrace();
      }
      paramBaseArticleInfo = paramString;
    }
  }
  
  public static URL a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return PubAccountHttpDownloader.a(paramString, 3);
  }
  
  public static URL a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (a(paramString)) {
      if (!paramBoolean1) {
        break label57;
      }
    }
    label57:
    for (localObject = ReadInJoyDisplayUtils.b();; localObject = ReadInJoyDisplayUtils.a())
    {
      localObject = a(paramString, ((Integer)((android.util.Pair)localObject).second).intValue(), ((Integer)((android.util.Pair)localObject).first).intValue(), 3);
      return a((String)localObject);
    }
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (jdField_a_of_type_JavaUtilQueue != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilQueue.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Integer)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public static Properties a(String paramString)
  {
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(new StringReader(paramString));
      return localProperties;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  private static JSONArray a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.toString())))
        {
          paramString = paramString.optJSONArray("videos");
          if (paramString != null)
          {
            int j = paramString.length();
            if (j >= 1) {
              continue;
            }
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      localJSONObject.put("kandian_mode_new", VideoReporter.a());
      localJSONObject.put("algorithm_id", jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt3, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("algorithm_id", paramLong);
        localJSONObject.put("folder_status", jdField_d_of_type_Int);
        localJSONObject.put("feeds_type", paramInt1);
        localJSONObject.put("time", System.currentTimeMillis());
        localJSONObject.put("channel_id", paramInt2);
        if (!paramBoolean) {
          break label1030;
        }
        paramInt1 = 2;
        localJSONObject.put("network_type", paramInt1);
        localJSONObject.put("feeds_source", paramString1);
        localJSONObject.put("imei", f());
        localJSONObject.put("imsi", g());
        localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
        localJSONObject.put("r_session_id", ReadinjoyReportUtils.jdField_a_of_type_JavaLangString);
        if (paramArticleInfo != null)
        {
          paramString1 = ReadinjoyReportUtils.a(paramArticleInfo.mArticleID);
          if (paramString1 != null)
          {
            localJSONObject.put("r_session_position", paramString1.first);
            localJSONObject.put("r_session_ispush", paramString1.second);
          }
        }
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("rowkey", paramString2);
        }
        if (!TextUtils.isEmpty(paramString3)) {
          localJSONObject.put("account_type", paramString3);
        }
        if ((a(paramArticleInfo)) || (ReadInJoyBaseAdapter.f(paramArticleInfo)) || (ReadInJoyBaseAdapter.g(paramArticleInfo)) || (ReadInJoyBaseAdapter.l(paramArticleInfo)) || (ReadInJoyBaseAdapter.h(paramArticleInfo)) || (ReadInJoyBaseAdapter.i(paramArticleInfo)))
        {
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList == null) {
            break label1035;
          }
          paramInt1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList.size();
          localJSONObject.put("number", paramInt1 + 1);
          paramInt2 = 0;
          if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList != null))
          {
            if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() > 1)
            {
              paramInt1 = 2;
              localJSONObject.put("words", paramInt1);
              localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int);
              localJSONObject.put("comment", paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int);
              localJSONObject.put("biu", paramArticleInfo.mSocialFeedInfo.jdField_f_of_type_Int);
              if (ReadInJoyHelper.K(BaseApplicationImpl.getApplication().getRuntime()) == 1)
              {
                paramInt1 = 1;
                localJSONObject.put("reddot_style", paramInt1);
                localJSONObject.put("feeds_type", a(paramArticleInfo));
                localJSONObject.put("kandian_mode", e());
                localJSONObject.put("kandian_mode_new", VideoReporter.a());
                localJSONObject.put("tab_source", d());
                localJSONObject.put("jump_to_channel", paramInt3);
                if ((paramArticleInfo != null) && (paramArticleInfo.feedsFirstExposurePos != -1)) {
                  localJSONObject.put("card_pos", paramArticleInfo.feedsFirstExposurePos);
                }
                if (!ReadInJoyHelper.r(a())) {
                  break label948;
                }
                paramInt1 = 1;
                localJSONObject.put("hemera_switch", paramInt1);
                localJSONObject.put("proteus_bid", ReadInJoyHelper.a());
                paramString1 = ReadInJoyHelper.a("kd_topic_recommend_card_jump_switch");
                if (!(paramString1 instanceof Boolean)) {
                  break label1015;
                }
                paramBoolean = ((Boolean)paramString1).booleanValue();
                break label1018;
                localJSONObject.put("jump_mode", paramString1);
                localJSONObject.put("star_logo", b(paramArticleInfo));
                long l = 0L;
                paramLong = l;
                if (paramArticleInfo != null)
                {
                  if ((!ReadInJoyBaseAdapter.b(paramArticleInfo)) && (!ReadInJoyBaseAdapter.l(paramArticleInfo)) && (!ReadInJoyBaseAdapter.h(paramArticleInfo))) {
                    break label960;
                  }
                  paramLong = l;
                  if (paramArticleInfo.mTopicRecommendFeedsInfo != null)
                  {
                    paramLong = l;
                    if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null)
                    {
                      paramLong = l;
                      if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)
                      {
                        paramLong = l;
                        if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0) != null) {
                          paramLong = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
                        }
                      }
                    }
                  }
                }
                label736:
                localJSONObject.put("topicid", paramLong);
                if (VideoReporter.jdField_a_of_type_JavaLangString == null) {
                  VideoReporter.jdField_a_of_type_JavaLangString = "7.6.8".replace(".", "");
                }
                localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
                localJSONObject.put("os", "1");
                return localJSONObject;
              }
            }
            else
            {
              if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() == 1)
              {
                paramInt1 = 1;
                continue;
              }
              paramInt1 = paramInt2;
              if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() != 0) {
                continue;
              }
              paramInt1 = paramInt2;
              if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString)) {
                continue;
              }
              paramInt1 = 1;
              continue;
            }
          }
          else
          {
            paramInt1 = paramInt2;
            if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString)) {
              continue;
            }
            paramInt1 = 1;
            continue;
          }
        }
        else
        {
          localJSONObject.put("number", 0);
          localJSONObject.put("words", 0);
          localJSONObject.put("likes", 0);
          localJSONObject.put("comment", 0);
          localJSONObject.put("biu", 0);
          continue;
        }
        paramInt1 = 0;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return localJSONObject;
      }
      continue;
      label948:
      paramInt1 = 0;
      continue;
      label960:
      label1015:
      label1018:
      do
      {
        paramString1 = "1";
        break;
        if ((d(paramArticleInfo)) && ((paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 7) || (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 8)))
        {
          paramLong = paramArticleInfo.mPolymericInfo.f;
          break label736;
        }
        paramLong = paramArticleInfo.businessId;
        break label736;
        paramBoolean = false;
      } while (!paramBoolean);
      paramString1 = "2";
      continue;
      label1030:
      paramInt1 = 1;
      continue;
      label1035:
      paramInt1 = 0;
    }
  }
  
  public static JSONObject a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("algorithm_id", paramArticleInfo.mAlgorithmID);
        localJSONObject.put("puin_type", paramString);
        localJSONObject.put("feeds_type", a(paramArticleInfo));
        localJSONObject.put("source", a(paramInt));
        localJSONObject.put("is_fans", c(paramArticleInfo));
        localJSONObject.put("kandian_mode", e());
        localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
        localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
        if (NetworkUtil.h(paramContext))
        {
          paramInt = 1;
          localJSONObject.put("network_type", paramInt);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "7.6.8".replace(".", ""));
          localJSONObject.put("imei", f());
          localJSONObject.put("imsi", g());
          if (a(paramArticleInfo))
          {
            localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int);
            localJSONObject.put("biu", paramArticleInfo.mSocialFeedInfo.jdField_f_of_type_Int);
            return localJSONObject;
          }
          localJSONObject.put("likes", 0);
          localJSONObject.put("biu", 0);
          return localJSONObject;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return localJSONObject;
      }
      paramInt = 2;
    }
  }
  
  public static JSONObject a(PolymericInfo paramPolymericInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", jdField_d_of_type_Int);
        localJSONObject.put("kandian_mode", String.valueOf(e()));
        localJSONObject.put("tab_source", d());
        j = -1;
        switch (paramPolymericInfo.jdField_a_of_type_Int)
        {
        default: 
          localJSONObject.put("use_type", j);
          if (j == 2)
          {
            l = paramPolymericInfo.jdField_b_of_type_Long;
            localJSONObject.put("type_id", l);
            localJSONObject.put("algorithm_id", paramPolymericInfo.e);
            return localJSONObject;
          }
          long l = paramPolymericInfo.f;
          continue;
          continue;
        }
      }
      catch (JSONException paramPolymericInfo)
      {
        paramPolymericInfo.printStackTrace();
        return localJSONObject;
      }
      int j = 2;
      continue;
      j = 1;
      continue;
      j = 3;
    }
  }
  
  public static void a()
  {
    k = 0;
    try
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label168;
      }
      localObject = ((QQAppInterface)localObject).a();
      if (localObject == null) {
        break label168;
      }
      localObject = ((QQMessageFacade)localObject).b(AppConstants.at, 7220);
      j = k;
      if (localObject != null)
      {
        j = k;
        if (((MessageRecord)localObject).extInt != 1)
        {
          if (((MessageRecord)localObject).extInt != 3) {
            break label203;
          }
          j = k;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          boolean bool;
          jdField_d_of_type_Int = Integer.parseInt(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "update mergefolder status " + jdField_d_of_type_Int);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "current mergefolder status is " + jdField_d_of_type_Int);
          }
          return;
          if (((MessageRecord)localObject).extInt != 2)
          {
            j = k;
            if (((MessageRecord)localObject).extInt != 4) {
              continue;
            }
            continue;
            if (j == 0)
            {
              jdField_d_of_type_Int = 3;
              continue;
              localException1 = localException1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ReadInJoyUtils", 2, "obtainMergeKandianFolderStatus except " + localException1.toString());
              continue;
            }
            if (j != 1) {
              continue;
            }
            jdField_d_of_type_Int = 2;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
          int j = 1;
        }
      }
    }
    if ((localObject != null) && (((MessageRecord)localObject).isread))
    {
      jdField_d_of_type_Int = 1;
      if ((localObject != null) && ((localObject instanceof MessageForStructing)))
      {
        localObject = (MessageForStructing)localObject;
        if (((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue != null)
        {
          bool = TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
          if (bool) {}
        }
      }
    }
  }
  
  public static void a(float paramFloat, Resources paramResources)
  {
    if ((paramFloat == 0.0F) || (paramResources == null)) {
      return;
    }
    jdField_a_of_type_Int = (int)(paramFloat / AIOUtils.a(66.0F, paramResources) + 0.5F);
  }
  
  public static void a(int paramInt)
  {
    jdField_d_of_type_Int = paramInt;
    SPEventReportSwitch.a(paramInt);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mOperation = paramInt1;
      localReportInfo.mSourceArticleId = Long.valueOf(paramString1).longValue();
      localReportInfo.mAlgorithmId = Integer.valueOf(paramString3).intValue();
      localReportInfo.mStrategyId = Integer.valueOf(paramString2).intValue();
      localReportInfo.mUin = a();
      if (TextUtils.isEmpty(paramString4)) {}
      for (long l = -1L;; l = Long.valueOf(paramString4).longValue())
      {
        localReportInfo.mPuin = l;
        paramInt1 = paramInt2;
        if (paramInt2 == -1) {
          paramInt1 = jdField_d_of_type_Int;
        }
        localReportInfo.mFolderStatus = paramInt1;
        localArrayList.add(localReportInfo);
        new UserOperationModule(null, null, ReadInJoyMSFService.a(), null).b(localArrayList);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("ReadInJoyUtils", 1, "reportRealTimeKandianAction error ", paramString1);
    }
  }
  
  public static void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    StatisticCollector.a(paramActivity).a(a(), "actReadInJoyDDShowPopupMenu", true, 0L, 0L, null, "");
    ArrayList localArrayList = new ArrayList();
    PopupMenuDialog.MenuItem localMenuItem;
    if ((ReadInJoyHelper.t(a()) == 1) || (ReadInJoyHelper.t(a()) == 2))
    {
      localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 0;
      localMenuItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131438909);
      localMenuItem.jdField_b_of_type_Int = 2130840783;
      localArrayList.add(localMenuItem);
    }
    if ((ReadInJoyHelper.t(a()) == 1) || (ReadInJoyHelper.t(a()) == 3))
    {
      localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 1;
      localMenuItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131438910);
      localMenuItem.jdField_b_of_type_Int = 2130840784;
      localArrayList.add(localMenuItem);
    }
    PopupMenuDialog.a(paramActivity, localArrayList, new lnc(paramActivity), new lnd(), AIOUtils.a(125.0F, paramActivity.getResources())).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131558949) - paramActivity.getResources().getDimensionPixelSize(2131558953) + AIOUtils.a(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131558968));
  }
  
  public static void a(Context paramContext)
  {
    c(paramContext, null);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject2 = ReadInJoyConstants.jdField_c_of_type_JavaLangString + paramInt;
    String str = ReadInJoyWebDataManager.a().c();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = localObject2;
      if (ReadInJoyHelper.l(a()))
      {
        localObject1 = ReadInJoyWebRenderEngine.a((String)localObject2);
        if (!PublicAccountUtil.e((String)localObject1)) {
          break label111;
        }
      }
    }
    label111:
    for (localObject2 = PublicAccountUtil.a((String)localObject1);; localObject2 = localObject1)
    {
      ReadInJoyWebRenderEngine.a().a((String)localObject2, str, false, false);
      localBundle.putLong("bundle_param_click_time", System.currentTimeMillis());
      a(paramContext, (String)localObject1, localBundle);
      return;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramContext, paramArticleInfo, paramInt, false, 0, false);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if ((paramContext == null) || (paramArticleInfo == null)) {
      return;
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    Object localObject3 = ReadInJoyConstants.jdField_d_of_type_JavaLangString;
    Object localObject1;
    if (((String)localObject3).contains("uin=")) {
      if (paramInt1 == 0) {
        localObject1 = ((String)localObject3).replace("uin=", "uin=" + Base64Util.encodeToString(String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long).getBytes(), 0).replace('\n', ' ').trim());
      }
    }
    for (;;)
    {
      label92:
      if (((String)localObject1).contains("&feedstype=")) {
        if (((!ReadInJoyBaseAdapter.g(paramArticleInfo)) && (!ReadInJoyBaseAdapter.i(paramArticleInfo))) || ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 5))) {
          localObject1 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_b_of_type_JavaLangLong);
        }
      }
      for (;;)
      {
        label171:
        Object localObject4;
        label231:
        Bundle localBundle;
        boolean bool;
        if ((paramInt1 == 3) || (paramInt1 == 5) || (paramInt1 == 2))
        {
          localObject4 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong;
          localObject1 = (String)localObject1 + String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong);
          localBundle = new Bundle();
          if (ReadInJoyWebDataManager.a(paramArticleInfo))
          {
            localObject3 = ReadInJoyWebDataManager.a();
            if ((paramInt1 != 1) && (paramInt1 != 3)) {
              break label1055;
            }
            bool = true;
            label265:
            ((ReadInJoyWebDataManager)localObject3).a(paramArticleInfo, bool, (String)localObject1);
          }
          localObject3 = localObject1;
          if (paramBoolean2) {
            localObject3 = (String)localObject1 + "#comment";
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "new social second url:" + (String)localObject3);
          }
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(ReadInJoyWebDataManager.a().a(((Long)localObject4).longValue())))
          {
            localObject1 = localObject3;
            if (ReadInJoyHelper.l(a()))
            {
              localObject1 = ReadInJoyWebRenderEngine.a((String)localObject3);
              if (!PublicAccountUtil.e((String)localObject1)) {
                break label1128;
              }
            }
          }
        }
        label1055:
        label1128:
        for (localObject3 = PublicAccountUtil.a((String)localObject1);; localObject3 = localJSONException)
        {
          ReadInJoyWebRenderEngine.a().a((String)localObject3, ReadInJoyWebDataManager.a().a(((Long)localObject4).longValue()), false, false);
          localBundle.putLong("bundle_param_click_time", System.currentTimeMillis());
          a(paramContext, (String)localObject1, localBundle);
          if ((paramBoolean1) || ((!a(paramArticleInfo)) && (!ReadInJoyBaseAdapter.a(paramArticleInfo)) && (!ReadInJoyBaseAdapter.f(paramArticleInfo)) && (!ReadInJoyBaseAdapter.g(paramArticleInfo)) && (!ReadInJoyBaseAdapter.h(paramArticleInfo)) && (!ReadInJoyBaseAdapter.i(paramArticleInfo)))) {
            break;
          }
          paramContext = "";
          for (;;)
          {
            try
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("folder_status", jdField_d_of_type_Int);
              if (paramInt1 != 1) {
                continue;
              }
              ((JSONObject)localObject1).put("feeds_source", paramArticleInfo.mSubscribeID);
              ((JSONObject)localObject1).put("rowkey", paramArticleInfo.innerUniqueID);
              ((JSONObject)localObject1).put("feeds_type", "" + a(paramArticleInfo));
              ((JSONObject)localObject1).put("kandian_mode", "" + e());
              ((JSONObject)localObject1).put("tab_source", "" + d());
              if (paramInt2 > 0) {
                ((JSONObject)localObject1).put("entry_mode", "" + paramInt2);
              }
              localObject1 = ((JSONObject)localObject1).toString();
              paramContext = (Context)localObject1;
            }
            catch (JSONException localJSONException)
            {
              long l;
              localJSONException.printStackTrace();
              continue;
              PublicAccountReportUtils.a(null, paramArticleInfo.mSubscribeID, "0X8007B64", "0X8007B64", 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "", paramContext, false);
              return;
            }
            if ((!ReadInJoyBaseAdapter.f(paramArticleInfo)) && (!ReadInJoyBaseAdapter.g(paramArticleInfo)) && (!ReadInJoyBaseAdapter.h(paramArticleInfo)) && (!ReadInJoyBaseAdapter.i(paramArticleInfo))) {
              continue;
            }
            if (ReadInJoyBaseAdapter.m(paramArticleInfo)) {
              break;
            }
            PublicAccountReportUtils.a(null, String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007B64", "0X8007B64", 0, 0, String.valueOf(paramArticleInfo.mFeedId), "0", "", paramContext, false);
            return;
            if ((paramInt1 == 1) || (paramInt1 == 3))
            {
              localObject4 = paramArticleInfo.mSubscribeID;
              localObject1 = localObject4;
              if (localObject4 == null) {
                localObject1 = "";
              }
              localObject1 = ((String)localObject3).replace("uin=", "uin=" + Base64Util.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());
              break label92;
            }
            if ((paramInt1 == 2) || (paramInt1 == 4))
            {
              if (ReadInJoyBaseAdapter.m(paramArticleInfo)) {
                break label1138;
              }
              l = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long;
              localObject1 = ((String)localObject3).replace("uin=", "uin=" + Base64Util.encodeToString(String.valueOf(l).getBytes(), 0).replace('\n', ' ').trim());
              break label92;
            }
            if (paramInt1 != 5) {
              break label1138;
            }
            l = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
            localObject1 = ((String)localObject3).replace("uin=", "uin=" + Base64Util.encodeToString(String.valueOf(l).getBytes(), 0).replace('\n', ' ').trim());
            break label92;
            localObject1 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
            break label171;
            localObject4 = Long.valueOf(paramArticleInfo.mFeedId);
            localObject1 = (String)localObject1 + String.valueOf(paramArticleInfo.mFeedId);
            break label231;
            bool = false;
            break label265;
            ((JSONObject)localObject1).put("feeds_source", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
          }
        }
      }
      label1138:
      Object localObject2 = localObject3;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    a(paramContext, paramArticleInfo, 0, false, 0, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramString == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContext;
      if (!(paramContext instanceof BasePluginActivity)) {
        break;
      }
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    } while (localObject == null);
    if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
    for (int j = 1;; j = 0)
    {
      if ((j == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
      {
        paramContext = new Bundle();
        paramContext.putString("url", paramString);
        paramContext.putBoolean("hide_operation_bar", true);
        paramString = new Intent((Context)localObject, QQBrowserActivity.class);
        paramString.putExtras(paramContext);
        if (paramBundle != null) {
          paramString.putExtras(paramBundle);
        }
        paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        ((Context)localObject).startActivity(paramString);
        return;
      }
      paramContext = new Intent((Context)localObject, JumpActivity.class);
      paramString = Uri.parse(paramString);
      paramContext.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramContext.setData(paramString);
      ((Context)localObject).startActivity(paramContext);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    ThreadManager.post(new lnh(paramHashMap, paramBoolean, paramContext, paramString), 5, null, true);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    localReportInfo.mChannelId = paramInt;
    localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localReportInfo.mOperation = 1;
    localReportInfo.mServerContext = paramArticleInfo.mServerContext;
    localReportInfo.mReadTimeLength = -1;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      ReportInfo.FeedsReportData localFeedsReportData = new ReportInfo.FeedsReportData();
      localFeedsReportData.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        localFeedsReportData.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      localFeedsReportData.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localFeedsReportData.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
      {
        localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramArticleInfo = paramArticleInfo.iterator();
        while (paramArticleInfo.hasNext())
        {
          SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)paramArticleInfo.next();
          if (localFeedsInfoUser != null) {
            localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localFeedsReportData;
    }
    localArrayList.add(localReportInfo);
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject;
    try
    {
      if ((paramBaseArticleInfo.mDislikeInfos == null) || (paramBaseArticleInfo.mDislikeInfos.size() <= 0)) {
        paramBaseArticleInfo.mDislikeInfos = DislikeInfo.a(paramBaseArticleInfo.mDiskLikeInfoString);
      }
      paramBaseArticleInfo.mPictures = a(paramBaseArticleInfo.mJsonPictureList);
      if ((ReadInJoyBaseAdapter.a(paramBaseArticleInfo)) && (!ReadInJoyBaseAdapter.d(paramBaseArticleInfo))) {}
      for (paramBaseArticleInfo.mSinglePicture = a(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString, true, true);; paramBaseArticleInfo.mSinglePicture = a(paramBaseArticleInfo.mFirstPagePicUrl, ReadInJoyBaseAdapter.d((ArticleInfo)paramBaseArticleInfo), true))
      {
        if (TextUtils.isEmpty(paramBaseArticleInfo.mJsonVideoList)) {
          break label449;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUtils", 2, "preParseArticleJsonParam article.mArticleID:" + paramBaseArticleInfo.mArticleID + " article.mTitle:" + paramBaseArticleInfo.mTitle + " article.mSummary:" + paramBaseArticleInfo.mSummary + "mJsonVideoList:" + paramBaseArticleInfo.mJsonVideoList);
        }
        paramBaseArticleInfo.mVideoCoverUrl = a(paramBaseArticleInfo, paramBaseArticleInfo.mJsonVideoList);
        localObject = a(paramBaseArticleInfo.mJsonVideoList);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label490;
        }
        localObject = ((String)localObject).split(";");
        paramBaseArticleInfo.mVideoVid = localObject[0];
        paramBaseArticleInfo.mVideoDuration = Integer.valueOf(localObject[1]).intValue();
        paramBaseArticleInfo.thirdIcon = localObject[2];
        paramBaseArticleInfo.thirdName = localObject[3];
        paramBaseArticleInfo.thirdAction = localObject[4];
        if ((paramBaseArticleInfo.mFeedType != 3) && (TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))) {
          paramBaseArticleInfo.innerUniqueID = localObject[5];
        }
        paramBaseArticleInfo.busiType = Integer.valueOf(localObject[6]).intValue();
        paramBaseArticleInfo.mVideoJsonWidth = Integer.valueOf(localObject[7]).intValue();
        paramBaseArticleInfo.mVideoJsonHeight = Integer.valueOf(localObject[8]).intValue();
        paramBaseArticleInfo.thirdUin = localObject[9];
        paramBaseArticleInfo.thirdUinName = localObject[10];
        paramBaseArticleInfo.mXGFileSize = Long.valueOf(localObject[11]).longValue();
        paramBaseArticleInfo.mThirdVideoURL = localObject[12];
        paramBaseArticleInfo.mThirdVideoURLExpireTime = Long.valueOf(localObject[13]).longValue();
        return;
        if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || ((!ReadInJoyBaseAdapter.a((ArticleInfo)paramBaseArticleInfo)) && (!ReadInJoyBaseAdapter.c((ArticleInfo)paramBaseArticleInfo)))) {
          break;
        }
      }
      localObject = paramBaseArticleInfo.mFirstPagePicUrl;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
      return;
    }
    boolean bool2 = paramBaseArticleInfo.mShowBigPicture;
    if (paramBaseArticleInfo.mVideoType == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBaseArticleInfo.mSinglePicture = a((String)localObject, bool2, bool1);
      break;
      label449:
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!ReadInJoyBaseAdapter.o((ArticleInfo)paramBaseArticleInfo))) {
        paramBaseArticleInfo.busiType = ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_f_of_type_Int;
      }
      label490:
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new lnb(paramQQAppInterface), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.getCurrentAccountUin());
      if (localMessageForStructing == null) {
        jdField_a_of_type_JavaUtilMap.put(paramQQAppInterface.getCurrentAccountUin(), paramMessageForStructing);
      }
      long l;
      do
      {
        QLog.i("ReadInJoyUtils", 1, "updateNewKandianMsgCache :" + paramMessageForStructing.getBaseInfoString());
        return;
        l = localMessageForStructing.time;
      } while (paramMessageForStructing.time <= l);
      jdField_a_of_type_JavaUtilMap.put(paramQQAppInterface.getCurrentAccountUin(), paramMessageForStructing);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    boolean bool4 = false;
    boolean bool1;
    boolean bool5;
    if (!a(paramMessageRecord))
    {
      bool1 = true;
      bool5 = paramQQAppInterface.isBackground_Stop;
      if ((paramQQAppInterface.isBackground_Stop) || (jdField_e_of_type_Boolean)) {
        break label147;
      }
    }
    label147:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool3 = bool4;
      if (!paramQQAppInterface.isBackground_Stop)
      {
        bool3 = bool4;
        if (!(BaseActivity.sTopActivity instanceof ReadInJoyNewFeedsActivity)) {
          bool3 = true;
        }
      }
      if ((bool1) && ((bool5) || (bool2) || (bool3))) {
        ReadInJoyHelper.k(paramQQAppInterface, true);
      }
      QLog.d("ReadInJoyUtils", 1, "saveKandianMsgStickFlag, flag1 = " + bool1 + ", flag2 = " + bool5 + ", flag3 = " + bool2 + ", flag4 = " + bool3);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (!ReadInJoyHelper.f()) {
      return;
    }
    ThreadManager.executeOnSubThread(new lne(paramRedTypeInfo, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    paramQQAppInterface = paramQQAppInterface.c();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      SettingCloneUtil.writeValue(localMobileQQ, paramQQAppInterface, null, "qqsetting_kandian_key", paramBoolean);
      return;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public static void a(String paramString)
  {
    Object localObject = ReadInJoyHelper.a(a(), true, false);
    if (localObject == null)
    {
      QLog.d("ReadInJoyUtils", 1, "updateVideoAutoPlaySetting failed to get sp");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (e() == 6) {
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", paramString);
    }
    for (;;)
    {
      ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
      return;
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", paramString);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
    long l = ReadInJoyHelper.a();
    if ((l != -1L) && (System.currentTimeMillis() - l < 600000L)) {}
  }
  
  public static void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    if (!(paramObject instanceof Serializable)) {
      throw new RuntimeException("the data obj must implement Serializable interface ! ");
    }
    ThreadManager.executeOnFileThread(new lnk(paramObject, paramBoolean, paramString));
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject, ArkLocalAppMgr.IGetAppPathByNameCallback paramIGetAppPathByNameCallback)
  {
    AppRuntime localAppRuntime = a();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((ArkAppCenter)((QQAppInterface)localAppRuntime).getManager(120)).a().a(paramString1, paramString2, paramObject, paramIGetAppPathByNameCallback);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, ReadInJoyUtils.NativeWebVideoCoverGetCallback paramNativeWebVideoCoverGetCallback)
  {
    ThreadManager.executeOnNetWorkThread(new lnm(paramString4, paramString3, paramString2, paramString1, paramNativeWebVideoCoverGetCallback));
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnFileThread(new lnj(paramBoolean, paramString));
  }
  
  public static void a(AppRuntime paramAppRuntime, List paramList)
  {
    if ((paramAppRuntime == null) || (paramList == null) || (paramList.size() < 1)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x68b.RspTraceRecord localRspTraceRecord = (oidb_cmd0x68b.RspTraceRecord)paramList.next();
      localHashMap.put(localRspTraceRecord.bytes_method.get().toStringUtf8(), String.valueOf(localRspTraceRecord.uint32_cost.get()));
    }
    StatisticCollector.a(paramAppRuntime.getApplication()).a(null, "actKandianRefreshBackEndTrace", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_ERROR_CODE", Integer.toString(paramInt));
    StatisticCollector.a(paramAppRuntime.getApplication()).a(null, "actWebRenderLoopEvent", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_STEP", Integer.toString(paramInt));
    localHashMap.put("LOOP_STEP_COST", Long.toString(paramLong));
    StatisticCollector.a(paramAppRuntime.getApplication()).a(null, "actWebRenderLoopEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramAppRuntime == null) || (paramLong < 0L) || (paramLong > 50000L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt1));
    localHashMap.put("channelID", String.valueOf(paramInt2));
    StatisticCollector.a(paramAppRuntime.getApplication()).a(null, "actKandianRefreshSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PLUGIN_STEP", paramString);
    localHashMap.put("PLUGIN_CAN_RENDER", Integer.toString(paramInt));
    localHashMap.put("PLUGIN_STEP_COST_FROM_CLICK", Long.toString(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUtils", 2, "reportWebRenderPluginEventCost PLUGIN_STEP : [" + paramString + "];PLUGIN_CAN_RENDER :[" + paramInt + "]; + PLUGIN_STEP_COST_FROM_CLICK : [" + paramLong + " ms];");
    }
    StatisticCollector.a(paramAppRuntime.getApplication()).a(null, "actreportWebRenderPluginEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = ReadInJoyHelper.a(a(), true, true);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((SharedPreferences)localObject).edit();
    } while (localObject == null);
    ((SharedPreferences.Editor)localObject).putBoolean("readinjoy_noactive_tips", paramBoolean);
    ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static boolean a()
  {
    return (a() instanceof QQAppInterface);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 9999;
  }
  
  public static boolean a(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = System.currentTimeMillis();
    }
    paramLong = l - ReadInJoyHelper.a((QQAppInterface)a());
    if (QLog.isColorLevel()) {
      if (paramLong >= ReadInJoyPageItemCache.jdField_a_of_type_Int) {
        break label90;
      }
    }
    label90:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ReadInJoyUtils", 2, new Object[] { "isNeedToRememberHistoryPos, timeInterval = ", Long.valueOf(paramLong), " , isNeedToRemember = ", Boolean.valueOf(bool) });
      if (paramLong >= ReadInJoyPageItemCache.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = a();
    if (paramContext == null) {}
    while ((paramContext.isBackground_Pause) || (paramContext.isBackground_Stop)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    return UtilsForComponent.b(ReadInJoyBaseAdapter.c(paramArticleInfo));
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.mVideoCoverUrl == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mVideoVid))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (c(paramBaseArticleInfo1))
    {
      bool1 = bool2;
      if (c(paramBaseArticleInfo2))
      {
        bool1 = bool2;
        if (paramBaseArticleInfo1.mPolymericInfo.c == paramBaseArticleInfo2.mPolymericInfo.c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(SocializeFeedsInfo.UGCFeedsInfo paramUGCFeedsInfo)
  {
    return (paramUGCFeedsInfo != null) && (paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList != null) && ((paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() > 1) || ((paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() == 1) && (!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString))));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApplication(), paramQQAppInterface.c(), null, "qqsetting_kandian_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "isDeleteNewKandian, flag = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (paramMessageRecord != null)
    {
      bool2 = bool3;
      if (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.as))
      {
        if (paramMessageRecord.istroop == 1008) {
          break label43;
        }
        bool2 = bool3;
      }
    }
    return bool2;
    label43:
    if ((NetworkUtil.a(paramQQAppInterface.getApp())) && ((jdField_e_of_type_Boolean) || ((ReadInJoyHelper.a(paramQQAppInterface)) && ((BaseActivity.sTopActivity instanceof ReadInJoyNewFeedsActivity))))) {}
    for (bool2 = true;; bool2 = false)
    {
      bool3 = a(paramMessageRecord);
      boolean bool4 = ReadInJoyHelper.f(paramQQAppInterface);
      if ((bool2) || (bool3) || (bool4)) {
        bool1 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "neadShowXinKandianMsg, neadShow=" + bool1 + ", showFlag1=" + bool2 + ", showFlag2=" + bool3 + ", showFlag3=" + bool4);
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      a(paramQQAppInterface, paramMessageRecord);
      return bool1;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord.extStr != null) && ((paramMessageRecord.extLong & 0x1) == 1) && (paramMessageRecord.extStr.contains("lockDisplay")) && (paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "neadForceNotification, ret=" + bool + ", mr=" + paramMessageRecord);
      }
      return bool;
      bool = false;
    }
  }
  
  @Deprecated
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.split("/");
      } while (paramString.length < 2);
      paramString = paramString[(paramString.length - 2)].split("_");
    } while (paramString.length < 1);
    return "open".equals(paramString[(paramString.length - 1)]);
  }
  
  public static boolean a(String paramString, long paramLong, int paramInt, ArticleInfo paramArticleInfo)
  {
    if (!ReadInJoyHelper.r(a())) {}
    while (((paramArticleInfo instanceof AdvertisementInfo)) || ((paramLong != 0L) && (paramLong != 70L)) || (paramInt == 15)) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = URLUtil.a(paramString);
      if (paramString.containsKey("article_type")) {
        return TextUtils.equals("1", (CharSequence)paramString.get("article_type"));
      }
    }
    return h(paramArticleInfo);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = a();
    return ((localAppRuntime instanceof QQAppInterface)) && (((ArkAppCenter)((QQAppInterface)localAppRuntime).getManager(120)).a().a(paramString1, paramString2) != null);
  }
  
  public static URL[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break;
        }
        JSONArray localJSONArray = paramString.optJSONArray("pictures");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          URL[] arrayOfURL = new URL[localJSONArray.length()];
          android.util.Pair localPair = ReadInJoyDisplayUtils.a();
          int j = 0;
          if (j < localJSONArray.length())
          {
            paramString = localJSONArray.optJSONObject(j).optString("picture");
            if (!TextUtils.isEmpty(paramString))
            {
              if (a(paramString))
              {
                paramString = a(paramString, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), 1);
                arrayOfURL[j] = PubAccountHttpDownloader.a(paramString, 3);
              }
            }
            else {
              j += 1;
            }
          }
          else
          {
            return arrayOfURL;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static int b()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData)) {
          localArrayList.add((RecentBaseData)localObject2);
        }
      }
      k = localException.size();
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + localException.toString());
      return -1;
    }
    int k;
    int m;
    if (k > jdField_a_of_type_Int)
    {
      k = jdField_a_of_type_Int;
      break label243;
      if (m < k)
      {
        localObject1 = (RecentBaseData)localException.get(m);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if (!TextUtils.equals(((RecentUserBaseData)localObject1).a(), AppConstants.at))
          {
            if (((RecentUserBaseData)localObject1).a() == 5000) {
              break label248;
            }
            if (((RecentUserBaseData)localObject1).b() > 0)
            {
              int n = ((RecentUserBaseData)localObject1).b();
              j = n + j;
              break label248;
            }
          }
        }
      }
      else
      {
        return j;
      }
    }
    for (;;)
    {
      label243:
      m = 0;
      break;
      label248:
      m += 1;
      break;
    }
  }
  
  public static Handler b()
  {
    if (jdField_b_of_type_AndroidOsHandler == null) {}
    try
    {
      if (jdField_b_of_type_AndroidOsHandler == null) {
        jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      return jdField_b_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static String b()
  {
    boolean bool;
    String str;
    int j;
    if (e() == 6)
    {
      bool = true;
      str = jdField_c_of_type_JavaLangString;
      j = ReadInJoyHelper.b(BaseApplicationImpl.getApplication().getRuntime());
      if (bool) {
        j = ReadInJoyHelper.c(BaseApplicationImpl.getApplication().getRuntime());
      }
      if (j != 0) {
        break label75;
      }
      str = jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = ReadInJoyHelper.a(a(), true, false);
      if (localObject != null) {
        break label99;
      }
      QLog.d("ReadInJoyUtils", 1, "getVideoAutoPlaySetting failed to get sp");
      return str;
      bool = false;
      break;
      label75:
      if (j == 1) {
        str = jdField_c_of_type_JavaLangString;
      } else if (j == 2) {
        str = jdField_b_of_type_JavaLangString;
      }
    }
    label99:
    if (bool) {}
    for (Object localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", str);; localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "getVideoAutoPlaySetting(),isVideoFlowEnter = " + bool + ", autoSetting = " + (String)localObject + ",localSettingDefaultValue=" + str + ", remoteSettingDefaultValue=" + j);
      }
      return localObject;
    }
  }
  
  public static String b(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("reddot_num", paramInt);
      ((JSONObject)localObject).put("kandian_mode", e());
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a())) {
      return "1";
    }
    return "0";
  }
  
  public static String b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.isSubscriptFeed()) {
      return "3";
    }
    if ((paramBaseArticleInfo.mPackInfoObj == null) || (!paramBaseArticleInfo.mPackInfoObj.pack_type.has())) {
      return "";
    }
    int j = paramBaseArticleInfo.mPackInfoObj.pack_type.get();
    if ((j == 3) && (paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((oidb_cmd0x68b.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.has())) {
      return "1";
    }
    if ((j == 2) && (paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.has())) {
      return "2";
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wording", paramString);
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  @Deprecated
  public static String b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ReadInJoyHelper.b(a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
      return paramString;
    }
    double d2 = 1.0D * paramInt1 / paramInt2;
    double d1 = 1.7976931348623157E+308D;
    Object localObject1 = null;
    int k = ReadInJoyConstants.b.length;
    Object localObject2 = ReadInJoyConstants.b;
    int j = 0;
    label74:
    double d3;
    double d4;
    if (j < k)
    {
      d3 = 1.0D * ((Integer)localObject2[j].second).intValue() / ((Integer)localObject2[j].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 < d1)
      {
        d1 = Math.abs(d3 - d2);
        localObject1 = localObject2[j];
      }
    }
    for (;;)
    {
      j += 1;
      break label74;
      if ((d4 == d1) && (localObject1 != null))
      {
        int m = Math.abs(((Integer)localObject1.second).intValue() - paramInt1);
        int n = Math.abs(((Integer)localObject1.first).intValue() - paramInt2);
        int i1 = Math.abs(((Integer)localObject2[j].second).intValue() - paramInt1);
        if (m + n > Math.abs(((Integer)localObject2[j].first).intValue() - paramInt2) + i1)
        {
          d1 = Math.abs(d3 - d2);
          localObject1 = localObject2[j];
          continue;
          if (localObject1 == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUtils", 2, "the video cover size : w : " + paramInt2 + " h : " + paramInt1 + ", select scale : " + localObject1.first + ":" + localObject1.second + " bias : " + d1 + " from : " + paramInt3);
          }
          localObject2 = paramString.split("/");
          localObject2 = localObject2[(localObject2.length - 1)];
          return paramString.replace("_vsmcut/" + (String)localObject2, "_vsmcut_" + localObject1.first + "_" + localObject1.second + "/" + (String)localObject2);
        }
      }
    }
  }
  
  public static JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("kandian_mode", e());
      localJSONObject.put("kandian_mode_new", VideoReporter.a());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilQueue != null) {
      jdField_a_of_type_JavaUtilQueue.clear();
    }
  }
  
  public static void b(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilQueue == null) {
      jdField_a_of_type_JavaUtilQueue = new LinkedBlockingQueue(100);
    }
    if (!jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt)))
    {
      jdField_a_of_type_JavaUtilQueue.poll();
      jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContext;
      if (!(paramContext instanceof BasePluginActivity)) {
        break;
      }
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    } while (localObject == null);
    paramContext = new Bundle();
    paramContext.putString("url", paramString);
    paramContext.putBoolean("hide_operation_bar", true);
    paramString = new Intent((Context)localObject, QQBrowserActivity.class);
    paramString.putExtras(paramContext);
    paramString.putExtra("selfSet_leftViewText", "我的");
    ((Context)localObject).startActivity(paramString);
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    StatisticCollector.a(paramContext).a(paramString, "actKandianVideoPreload", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramQQAppInterface.getAccount());
    localHashMap.put("param_cpu", String.valueOf(DeviceInfoUtil.b()));
    localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.e()));
    localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.f()));
    localHashMap.put("param_version", "7.6.8");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actUserDeviceInfoReport", true, 100L, 0L, localHashMap, "", true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    jdField_e_of_type_Int = -1;
    Object localObject3 = (KandianMergeManager)paramQQAppInterface.getManager(161);
    paramQQAppInterface = "";
    Object localObject1 = "";
    Object localObject2 = "";
    if (paramMessageRecord != null) {
      if (!paramMessageRecord.isread) {
        break label126;
      }
    }
    label539:
    for (int j = 1;; j = 0)
    {
      a(j);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int = j;
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_JavaLangString = ((String)localObject1);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_b_of_type_JavaLangString = paramQQAppInterface;
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_c_of_type_JavaLangString = ((String)localObject2);
      if ((!TextUtils.isEmpty(paramMessageRecord.extStr)) && (!paramMessageRecord.isread)) {}
      for (;;)
      {
        try
        {
          for (;;)
          {
            label126:
            Object localObject6;
            for (;;)
            {
              paramQQAppInterface = new JSONObject(paramMessageRecord.extStr);
              jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Long = paramQQAppInterface.optLong("sp_last_kadnian_red_pnt_exposure_time_key", 0L);
              jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_b_of_type_Long = paramMessageRecord.time;
              return;
              if ((paramMessageRecord.extInt != 1) && (paramMessageRecord.extInt != 3)) {
                break label373;
              }
              if ((localObject3 != null) && (((KandianMergeManager)localObject3).a(paramMessageRecord) == 1))
              {
                j = 5;
                break;
              }
              localObject6 = paramQQAppInterface;
              localObject5 = localObject1;
              localObject3 = localObject2;
              if ((paramMessageRecord instanceof MessageForStructing))
              {
                MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
                localMessageForStructing.parse();
                localObject6 = paramQQAppInterface;
                localObject5 = localObject1;
                localObject3 = localObject2;
                if (localMessageForStructing.structingMsg != null)
                {
                  if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mStrategyIds)) {
                    paramQQAppInterface = localMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
                  }
                  if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mAlgorithmIds)) {
                    localObject1 = localMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
                  }
                  if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mArticleIds)) {
                    localObject2 = localMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
                  }
                  localObject6 = paramQQAppInterface;
                  localObject5 = localObject1;
                  localObject3 = localObject2;
                  if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.reportEventFolderStatusValue)) {
                    try
                    {
                      j = Integer.parseInt(localMessageForStructing.structingMsg.reportEventFolderStatusValue);
                    }
                    catch (Exception localException)
                    {
                      localException.printStackTrace();
                      localObject4 = localObject2;
                      localObject5 = localObject1;
                      localObject6 = paramQQAppInterface;
                    }
                  }
                }
              }
            }
            j = 3;
            paramQQAppInterface = (QQAppInterface)localObject6;
            localObject1 = localObject5;
            localObject2 = localObject4;
            break;
            label373:
            if ((paramMessageRecord.extInt == 2) || (paramMessageRecord.extInt == 4))
            {
              j = 2;
              break;
            }
            if (paramMessageRecord.extInt == 5)
            {
              j = 6;
              break;
            }
            if (paramMessageRecord.extInt != 6) {
              break label539;
            }
            Object localObject5 = paramQQAppInterface;
            Object localObject4 = localObject1;
            try
            {
              localObject6 = new JSONObject(paramMessageRecord.extStr);
              localObject5 = paramQQAppInterface;
              localObject4 = localObject1;
              j = ((JSONObject)localObject6).getInt("folder_status");
              localObject5 = paramQQAppInterface;
              localObject4 = localObject1;
              paramQQAppInterface = ((JSONObject)localObject6).getString("strategy_id");
              localObject5 = paramQQAppInterface;
              localObject4 = localObject1;
              localObject1 = ((JSONObject)localObject6).getString("algorithm_id");
              localObject5 = paramQQAppInterface;
              localObject4 = localObject1;
              localObject6 = ((JSONObject)localObject6).getString("article_id");
              localObject2 = localObject6;
            }
            catch (Exception paramQQAppInterface)
            {
              paramQQAppInterface.printStackTrace();
              j = 10;
              paramQQAppInterface = (QQAppInterface)localObject5;
              localObject1 = localObject4;
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          continue;
        }
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Long = 0L;
      }
    }
  }
  
  public static void b(String paramString)
  {
    jdField_e_of_type_JavaLangString = paramString;
  }
  
  public static void b(boolean paramBoolean)
  {
    jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public static boolean b()
  {
    ArrayList localArrayList = new ArrayList();
    label50:
    int j;
    do
    {
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext()) {
          try
          {
            localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
            if (localObject1 == null) {
              return false;
            }
            localObject1 = ((Conversation)localObject1).a().b();
            if (localObject1 == null) {
              return false;
            }
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = ((Iterator)localObject1).next();
              if (!(localObject2 instanceof RecentBaseData)) {
                break label50;
              }
              localArrayList.add((RecentBaseData)localObject2);
              break label50;
            }
            localIterator = localException.iterator();
          }
          catch (Exception localException)
          {
            QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + localException.toString());
            return false;
          }
        }
        localObject1 = (RecentBaseData)localIterator.next();
      } while (localObject1 == null);
      Object localObject1 = (RecentUserBaseData)localObject1;
      if (TextUtils.equals(((RecentUserBaseData)localObject1).a(), AppConstants.at)) {
        return true;
      }
      j = ((RecentUserBaseData)localObject1).jdField_f_of_type_Int;
    } while ((j & 0x20) != 0);
    return false;
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 17) {
      return false;
    }
    return true;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((!paramBaseArticleInfo.mShowBigPicture) || (paramBaseArticleInfo.mIsGallery != 1) || ((paramBaseArticleInfo.articleStyle != 3) && (paramBaseArticleInfo.articleStyle != 4) && (paramBaseArticleInfo.articleStyle != 5))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(AppConstants.at, 7220);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isread)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt != 5) {
      return a(paramMessageRecord);
    }
    return ((KandianMergeManager)paramQQAppInterface.getManager(161)).d();
  }
  
  @Deprecated
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!paramString.startsWith("http://qqpublic.qpic.cn"));
        paramString = paramString.split("/");
      } while (paramString.length < 2);
      paramString = paramString[(paramString.length - 2)].split("_");
    } while (paramString.length < 1);
    return "vsmcut".equals(paramString[(paramString.length - 1)]);
  }
  
  public static int c()
  {
    try
    {
      jdField_b_of_type_Int += 1;
      int j = jdField_b_of_type_Int;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String c()
  {
    int j = 1;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      if (ReadInJoyHelper.K(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", j);
        ((JSONObject)localObject).put("kandian_mode", e());
        ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.a());
        ((JSONObject)localObject).put("tab_source", d());
        ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
        j = 0;
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private static String c(ArticleInfo paramArticleInfo)
  {
    if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
      return "0";
    }
    long l = Long.parseLong(paramArticleInfo.mSubscribeID);
    try
    {
      bool = ((PublicAccountDataManager)BaseApplicationImpl.getApplication().getRuntime().getManager(55)).a(Long.valueOf(l));
      if (bool) {
        return "1";
      }
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return "2";
  }
  
  public static String c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    if (paramBaseArticleInfo.isSubscriptFeed()) {
      return "1";
    }
    if ((paramBaseArticleInfo.mPackInfoObj != null) && (paramBaseArticleInfo.mPackInfoObj.has()) && (paramBaseArticleInfo.mPackInfoObj.pack_type.get() == 3)) {
      return "2";
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    return a(paramString, "");
  }
  
  public static void c()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread = true;
    }
  }
  
  public static void c(int paramInt)
  {
    i = paramInt;
  }
  
  private static void c(Context paramContext)
  {
    d(paramContext);
    StatisticCollector.a(paramContext).a(a().getAccount(), "actReadInJoyDDShowVideoAS", true, 0L, 0L, null, "");
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(PublicAccountConfigUtil.jdField_e_of_type_JavaLangString))
    {
      String str2 = PublicAccountConfigUtil.jdField_e_of_type_JavaLangString;
      String str1 = str2;
      if (!TextUtils.isEmpty(paramString)) {
        str1 = str2 + "&placeholder=" + Uri.encode(paramString, "utf-8");
      }
      if (System.currentTimeMillis() - jdField_b_of_type_Long > 1000L) {
        SearchUtils.a(null, paramContext, str1);
      }
      jdField_b_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D3", "0X80067D3", 0, 0, "", "", "", c(), false);
      return;
      paramContext.startActivity(new Intent(paramContext, ReadInJoyNewSearchActivity.class));
    }
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    if (paramHashMap != null) {
      paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramHashMap != null)
      {
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(" ");
        }
      }
      QLog.d("Q.readinjoy.video", 2, "actKandianVideoGetUrl, success =" + paramBoolean + ",  data=" + localStringBuilder.toString());
    }
    StatisticCollector.a(paramContext).a(paramString, "actKandianVideoGetUrl", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (jdField_f_of_type_Boolean)
    {
      jdField_f_of_type_Boolean = false;
      f();
    }
    if (ReadInJoyHelper.h())
    {
      ReadInJoyLogicEngine.a().c(0);
      ReadInJoyLogicEngine.a().c(56);
    }
    jdField_e_of_type_Boolean = true;
    ThreadManager.post(new lng(paramQQAppInterface), 8, null, false);
  }
  
  public static boolean c()
  {
    if (!a()) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + localException.toString());
    }
    for (;;)
    {
      int k = localException.size();
      int j = 0;
      while (j < k)
      {
        localObject1 = (RecentBaseData)localException.get(j);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if ((!TextUtils.equals(((RecentUserBaseData)localObject1).a(), AppConstants.at)) && (((RecentUserBaseData)localObject1).a() != 5000))
          {
            int m = ((RecentUserBaseData)localObject1).b();
            if (m > 0) {
              return true;
            }
          }
        }
        j += 1;
      }
    }
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 16) {
      return false;
    }
    return true;
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mPolymericInfo != null) && (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int >= 6);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    int k = jdField_a_of_type_Int;
    if ((paramQQAppInterface == null) || (k <= 0)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return false;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.d("ReadInJoyUtils", 1, "failed to construct recent base " + paramQQAppInterface.toString());
    }
    for (;;)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (RecentUserBaseData)localObject2;
          if ((((RecentUserBaseData)localObject2).a != null) && (((RecentUserBaseData)localObject2).a.type == 1008) && (ServiceAccountFolderManager.b(paramQQAppInterface, ((RecentUserBaseData)localObject2).a.uin))) {
            ((Iterator)localObject1).remove();
          }
        }
      }
      int m = localArrayList.size();
      int j = k;
      if (k > m) {
        j = m;
      }
      while (k < j)
      {
        paramQQAppInterface = (RecentBaseData)localArrayList.get(k);
        if (paramQQAppInterface != null)
        {
          boolean bool = TextUtils.equals(((RecentUserBaseData)paramQQAppInterface).a(), AppConstants.at);
          if (bool) {
            return true;
          }
        }
        k += 1;
        continue;
        k = 0;
      }
    }
  }
  
  public static int d()
  {
    if (ReadInJoyHelper.f())
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        return -1;
      }
      Object localObject;
      if ((localBaseActivity instanceof SplashActivity))
      {
        localObject = FrameHelperActivity.a(BaseActivity.sTopActivity);
        if (localObject != null) {}
      }
      do
      {
        do
        {
          return -1;
          localObject = (ReadinjoyTabFrame)((FrameHelperActivity)localObject).a(ReadinjoyTabFrame.class);
        } while (localObject == null);
        if (ReadInJoyHelper.g()) {
          return 2;
        }
        int j = ((ReadinjoyTabFrame)localObject).a();
        if (j == 0) {
          return 1;
        }
        if (j == 2) {
          return 3;
        }
        if (j == 1) {
          return 2;
        }
        if ((localBaseActivity instanceof PublicFragmentActivity))
        {
          if ((localBaseActivity.getIntent() != null) && (QLog.isColorLevel())) {
            QLog.d("ReadInJoyUtils", 2, new Object[] { "ClassName: ", localBaseActivity.getIntent().getStringExtra("public_fragment_class") });
          }
          if ((localBaseActivity.getIntent() != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class").equals("com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment"))) {
            return 3;
          }
        }
      } while (!(localBaseActivity instanceof ReadInJoyNewFeedsActivity));
      return ReadInJoyNewFeedsActivity.jdField_c_of_type_Int + 1;
    }
    return ReadInJoyNewFeedsActivity.jdField_c_of_type_Int + 1;
  }
  
  public static String d()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", jdField_d_of_type_Int);
      localJSONObject.put("kandian_mode", String.valueOf(e()));
      localJSONObject.put("kandian_mode_new", VideoReporter.a());
      localJSONObject.put("session_id", jdField_e_of_type_JavaLangString);
      if (ArticleInfoModule.a()) {}
      for (String str = "1";; str = "0")
      {
        localJSONObject.put("is_requesting_articles", str);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private static String d(int paramInt)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("releasetype", paramInt + "");
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.length() < 8) {
      return paramString + "|" + paramString.length();
    }
    return paramString.substring(0, 8) + "|" + paramString.length();
  }
  
  public static void d()
  {
    int j = 0;
    Object localObject3;
    Object localObject4;
    MessageForStructing localMessageForStructing;
    Object localObject7;
    try
    {
      localQQAppInterface = (QQAppInterface)a();
      localObject3 = "";
      localObject1 = "0";
      localObject4 = "";
      localMessageRecord = localQQAppInterface.a().b(AppConstants.at, 7220);
      if (!(localMessageRecord instanceof MessageForStructing)) {
        break label506;
      }
      localMessageForStructing = (MessageForStructing)localMessageRecord;
      if (localMessageForStructing.structingMsg != null) {
        break label512;
      }
      localMessageForStructing.parse();
    }
    catch (Exception localException)
    {
      QQAppInterface localQQAppInterface;
      Object localObject1;
      MessageRecord localMessageRecord;
      Object localObject6;
      Object localObject5;
      String[] arrayOfString;
      int k;
      label231:
      localException.printStackTrace();
      label273:
      return;
    }
    if ((localMessageForStructing != null) && (localMessageForStructing.extInt == 1))
    {
      localObject6 = localObject4;
      localObject7 = localObject3;
      localObject5 = localObject1;
      if (localMessageForStructing.structingMsg == null) {
        break label496;
      }
      if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mArticleIds)) {
        localObject3 = localMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
      }
      if (localMessageForStructing.structingMsg.mStrategyIds != null) {
        localObject1 = localMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
      }
      if (localMessageForStructing.structingMsg.mAlgorithmIds != null) {
        localObject4 = localMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
      }
      localObject6 = localObject4;
      localObject7 = localObject3;
      localObject5 = localObject1;
      if (TextUtils.isEmpty(localMessageForStructing.structingMsg.mInnerUniqIds)) {
        break label496;
      }
      arrayOfString = localMessageForStructing.structingMsg.mInnerUniqIds.split("\\|");
      k = arrayOfString.length;
      localObject6 = localObject4;
      localObject7 = localObject3;
      localObject5 = localObject1;
      if (j >= k) {
        break label496;
      }
      localObject7 = arrayOfString[j];
      if (TextUtils.isEmpty((CharSequence)localObject7)) {
        break label516;
      }
      localObject5 = localObject1;
      localObject6 = localObject4;
      localObject4 = localObject7;
      localObject1 = localObject3;
      if ((!"300".equals(localObject5)) || (a(localMessageRecord))) {
        break label484;
      }
      localObject3 = ((KandianMergeManager)localQQAppInterface.getManager(161)).a();
      if ((localObject3 == null) || (((List)localObject3).size() <= 0) || (String.valueOf(((List)localObject3).get(0)).equals(localObject1))) {
        break label523;
      }
      localObject3 = String.valueOf(((List)localObject3).get(0));
      localObject1 = "";
    }
    for (;;)
    {
      localObject7 = new JSONObject();
      ((JSONObject)localObject7).put("algorithm_id", localObject6);
      ((JSONObject)localObject7).put("rowkey", localObject4);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((JSONObject)localObject7).put("articleID", localObject1);
      }
      PublicAccountReportUtils.a(null, "CliOper", "", localMessageForStructing.senderuin, "0X80081DB", "0X80081DB", 0, 0, "", (String)localObject3, localObject5, ((JSONObject)localObject7).toString(), false);
      return;
      if ((localMessageRecord.extInt == 5) && (localMessageForStructing != null))
      {
        PublicAccountReportUtils.a(null, "CliOper", "", localMessageForStructing.senderuin, "0X80081DB", "0X80081DB", 0, 0, "", "0", "0", null, false);
        return;
        label484:
        localObject7 = "";
        localObject3 = localException;
        Object localObject2 = localObject7;
        continue;
        label496:
        localObject2 = localObject7;
        localObject4 = "";
        break label273;
        label506:
        localMessageForStructing = null;
        break;
        label512:
        break;
      }
      return;
      label516:
      j += 1;
      break label231;
      label523:
      localObject3 = "0";
    }
  }
  
  private static void d(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_dian_dian", true);
    ReadInJoyCaptureLauncher.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2131034327, 2131034167);
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    StatisticCollector.a(paramContext).a(paramString, "actVideoFeedsStartTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    jdField_e_of_type_Boolean = false;
  }
  
  public static boolean d()
  {
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(a(), true, true);
    if (localSharedPreferences == null) {
      return true;
    }
    return localSharedPreferences.getBoolean("readinjoy_noactive_tips", true);
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 19) {
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    return (c(paramBaseArticleInfo)) && (paramBaseArticleInfo.mIsInPolymeric);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    if (jdField_c_of_type_Boolean)
    {
      ThreadManager.executeOnSubThread(new lni(paramQQAppInterface));
      jdField_c_of_type_Boolean = false;
    }
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof SplashActivity))
    {
      if (((SplashActivity)localObject).a() != MainFragment.jdField_a_of_type_Int)
      {
        QLog.d("ReadInJoyUtils", 1, "r:Not in conversationtab");
        return false;
      }
    }
    else
    {
      QLog.d("ReadInJoyUtils", 1, "r:top activity is not splash");
      return false;
    }
    if (!ReadInJoyHelper.c(paramQQAppInterface))
    {
      QLog.d("ReadInJoyUtils", 1, "r:config false");
      return false;
    }
    if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), null, "qqsetting_kandian_key", true))
    {
      QLog.d("ReadInJoyUtils", 1, "kandian push disabled");
      return false;
    }
    localObject = ReadInJoyHelper.a(paramQQAppInterface);
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    int j = Calendar.getInstance().get(11);
    if ((!TextUtils.equals((CharSequence)localObject, str)) && (j >= 6))
    {
      if (!b(paramQQAppInterface))
      {
        QLog.d("ReadInJoyUtils", 1, "r:true to get individual push");
        return true;
      }
      QLog.d("ReadInJoyUtils", 1, "r:already has red point");
    }
    for (;;)
    {
      return false;
      QLog.d("ReadInJoyUtils", 1, "r:hour:" + j);
    }
  }
  
  public static int e()
  {
    return i;
  }
  
  public static String e()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", jdField_d_of_type_Int);
      ((JSONObject)localObject).put("session_id", jdField_e_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String e(String paramString)
  {
    if (DeviceInfoUtil.k() > 720L) {
      return a(paramString, 18);
    }
    return a(paramString, 24);
  }
  
  public static void e(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    StatisticCollector.a(paramContext).a(paramString, "actVideoFeedsScrollIntervalTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      MessageForStructing localMessageForStructing;
      QQMessageFacade localQQMessageFacade;
      do
      {
        do
        {
          return;
          localMessageForStructing = a(paramQQAppInterface);
        } while ((a(paramQQAppInterface)) || (localMessageForStructing == null));
        localQQMessageFacade = paramQQAppInterface.a();
      } while (localQQMessageFacade == null);
      localMessageForStructing.time = NetConnInfoCenter.getServerTime();
      MessageRecord localMessageRecord = ((KandianMergeManager)paramQQAppInterface.getManager(161)).a(localMessageForStructing);
      if (localMessageRecord != null) {
        localQQMessageFacade.a(localMessageRecord, paramQQAppInterface.c());
      }
      localQQMessageFacade.a(localMessageForStructing, paramQQAppInterface.c());
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyUtils", 2, "notifyXinKandianMsg");
  }
  
  public static boolean e()
  {
    return jdField_g_of_type_Boolean;
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 18) {
      return false;
    }
    return true;
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return (c(paramBaseArticleInfo)) && (paramBaseArticleInfo.mGroupSubArticleList != null);
  }
  
  public static int f()
  {
    boolean bool2 = false;
    int n = 1024;
    int i1 = 100;
    int i2 = 2;
    int j;
    int k;
    int m;
    boolean bool1;
    if (!TextUtils.isEmpty(PublicAccountConfigUtil.i))
    {
      j = i2;
      k = i1;
      m = n;
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(PublicAccountConfigUtil.i);
        j = i2;
        k = i1;
        m = n;
        bool1 = bool2;
        bool2 = localJSONObject.optBoolean("useNewLogic", false);
        j = i2;
        k = i1;
        m = n;
        bool1 = bool2;
        n = localJSONObject.optInt("minTotalMem", 1024);
        j = i2;
        k = i1;
        m = n;
        bool1 = bool2;
        i1 = localJSONObject.optInt("minAvailableMem", 100);
        j = i2;
        k = i1;
        m = n;
        bool1 = bool2;
        i2 = localJSONObject.optInt("minCpuNum", 2);
        j = i2;
        k = i1;
        m = n;
        bool1 = bool2;
        int i3 = localJSONObject.optInt("minCpuFreq", 1000);
        bool1 = bool2;
        m = i1;
        k = i2;
        j = i3;
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        long l3;
        n = m;
        m = k;
        k = j;
        j = 1000;
        continue;
        if (l2 >>> 20 < m) {
          continue;
        }
        return 2;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        return 1;
        return 0;
      }
      if (bool1)
      {
        l1 = DeviceInfoUtil.e();
        l2 = DeviceInfoUtil.f();
        i1 = DeviceInfoUtil.b();
        l3 = DeviceInfoUtil.a();
        if ((l1 >>> 20 >= n) && (i1 >= k) && (l3 >= j)) {
          return 1;
        }
      }
      if (Build.VERSION.SDK_INT >= 19) {
        return 1;
      }
      return 0;
      bool1 = false;
      n = 1024;
      m = 100;
      k = 2;
      j = 1000;
    }
  }
  
  public static String f()
  {
    Object localObject;
    if (jdField_g_of_type_Int >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = DeviceInfoUtil.a();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    jdField_g_of_type_Int += 1;
    return "null";
  }
  
  public static String f(String paramString)
  {
    return "https://kandian.qq.com/mqq/watchspot/gallery.html?_wv=2147483777&rowkey=" + paramString + "&x5PreFetch=1&_bid=3002";
  }
  
  private static void f()
  {
    AppRuntime localAppRuntime = a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      if (!((QQAppInterface)localAppRuntime).a.b()) {
        ReadinjoySPEventReport.f();
      }
    }
    else {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new lnf(), 500L);
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    StatisticCollector.a(paramContext).a(paramString, "actKandianVideoBehaviors", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void f(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {
      return;
    }
    MessageRecord localMessageRecord = ((QQMessageFacade)localObject).b(AppConstants.at, 7220);
    localObject = localMessageRecord;
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      if (localMessageRecord != null)
      {
        localObject = localMessageRecord;
        if (localMessageRecord.time > jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time) {}
      }
      else
      {
        localObject = jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    b(paramQQAppInterface, (MessageRecord)localObject);
  }
  
  public static boolean f()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(PublicAccountConfigUtil.i)) {}
    try
    {
      bool = new JSONObject(PublicAccountConfigUtil.i).optBoolean("useNewLogic", false);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean f(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_b_of_type_JavaLangLong.longValue() != 17L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_b_of_type_JavaLangLong.longValue() != 16L)) {
      return false;
    }
    return true;
  }
  
  public static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    return (c(paramBaseArticleInfo)) && ((paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9) || (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 10) || (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11));
  }
  
  public static String g()
  {
    Object localObject;
    if (h >= 10) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = DeviceInfoUtil.b();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    h += 1;
    return "null";
  }
  
  public static String g(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("&tp=webp"))) {
      return paramString;
    }
    return paramString.replace("&tp=webp", "");
  }
  
  public static void g(Context paramContext, String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(a(paramContext)));
    StatisticCollector.a(paramContext).a(paramString, "actKandianVideoBehaviorsSeq", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void g(QQAppInterface paramQQAppInterface)
  {
    
    if (paramQQAppInterface == null) {
      return;
    }
    long l1 = paramQQAppInterface.getLongAccountUin();
    long l2 = System.currentTimeMillis();
    jdField_f_of_type_JavaLangString = String.valueOf(l1) + "_" + String.valueOf(l2);
  }
  
  public static boolean g()
  {
    boolean bool = false;
    int j = ReadInJoyHelper.t(a());
    if ((j == 1) || (j == 2) || (j == 3)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_b_of_type_JavaLangLong.longValue() != 19L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_b_of_type_JavaLangLong.longValue() != 18L)) {
      return false;
    }
    return true;
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && ((paramBaseArticleInfo instanceof ArticleInfo)) && (!ReadInJoyBaseAdapter.o((ArticleInfo)paramBaseArticleInfo)) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 6);
  }
  
  public static String h()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      Object localObject2 = f();
      String str = g();
      if ((!((String)localObject2).equals("null")) && (!str.equals("null")))
      {
        jdField_a_of_type_JavaLangString = "0," + (String)localObject2 + "," + str;
        return jdField_a_of_type_JavaLangString;
      }
      Object localObject1 = localObject2;
      if (((String)localObject2).equals("null")) {
        localObject1 = "0";
      }
      localObject2 = str;
      if (str.equals("null")) {
        localObject2 = "0";
      }
      return "0," + (String)localObject1 + "," + (String)localObject2;
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static boolean h()
  {
    if (!jdField_b_of_type_Boolean)
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.KDCfg.name(), null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 2) {
          jdField_d_of_type_Boolean = localObject[1].equals("1");
        }
        jdField_b_of_type_Boolean = true;
      }
    }
    return jdField_d_of_type_Boolean;
  }
  
  private static boolean h(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    switch (paramArticleInfo.mFeedType)
    {
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 10: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return false;
    case 0: 
    case 8: 
    case 12: 
    case 16: 
    case 17: 
      return true;
    }
    switch (ReadInJoyBaseAdapter.c(paramArticleInfo))
    {
    case 4: 
    case 5: 
    case 6: 
    case 9: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    case 17: 
    case 19: 
    case 20: 
    case 21: 
    case 23: 
    case 24: 
    case 26: 
    case 28: 
    case 29: 
    case 30: 
    case 32: 
    case 33: 
    default: 
      return false;
    }
    return true;
  }
  
  public static String i()
  {
    if (jdField_f_of_type_JavaLangString == null) {
      return "0";
    }
    return jdField_f_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils
 * JD-Core Version:    0.7.0.1
 */