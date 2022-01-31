package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpResponseBean;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import mvz;
import mwa;
import mwb;
import mwc;
import mwd;
import mwe;
import mwf;
import mwh;
import mwi;
import mwj;
import mwk;
import mwl;
import mwp;
import mwr;
import mws;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PublicAccountUtil
{
  private static volatile int jdField_a_of_type_Int = -1;
  public static QQCustomDialog a;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString = "tag_delete_oldkandian_flag";
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public static MqqHandler a;
  public static boolean a;
  
  public static int a(int paramInt)
  {
    if (paramInt < 0) {
      return paramInt;
    }
    if ((0x200000 & paramInt) != 0) {
      return -2;
    }
    if ((0x4000000 & paramInt) != 0) {
      return -3;
    }
    if ((0x2000000 & paramInt) != 0) {
      return -4;
    }
    if ((0x800000 & paramInt) != 0) {
      return -5;
    }
    if ((0x8000000 & paramInt) != 0) {
      return -6;
    }
    if ((0x80000000 & paramInt) != 0) {
      return -9;
    }
    return -1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = -1;
    int k = j;
    if (paramQQAppInterface != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label22;
      }
      k = j;
    }
    label22:
    do
    {
      int i;
      do
      {
        do
        {
          return k;
          localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
          k = j;
        } while (localObject == null);
        Object localObject = ((PublicAccountDataManager)localObject).b(paramString);
        if (localObject != null)
        {
          if (((PublicAccountInfo)localObject).extendType == 2) {
            return -7;
          }
          return a(((PublicAccountInfo)localObject).accountFlag);
        }
        localObject = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((TroopInfo)localObject).associatePubAccount != 0L) {
            i = -4;
          }
        }
        paramQQAppInterface = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
        k = i;
      } while (paramQQAppInterface == null);
      k = i;
    } while (paramQQAppInterface.a(paramString) == null);
    return -7;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int j = a(paramQQAppInterface, paramString);
    int i = j;
    if (j == -1) {
      i = a(paramInt);
    }
    return i;
  }
  
  public static long a(long paramLong)
  {
    long l = -1L;
    if ((0x200 & paramLong) != 0L) {
      l = -8L;
    }
    return l;
  }
  
  public static long a(String paramString)
  {
    try
    {
      paramString = paramString.split(":");
      if (paramString.length == 6)
      {
        int j = 40;
        int i = 0;
        long l1 = 0L;
        while (i < paramString.length)
        {
          long l2 = Long.parseLong(paramString[i], 16);
          long l3 = l2;
          if (j > 0) {
            l3 = l2 << j;
          }
          l1 += l3;
          j -= 8;
          i += 1;
        }
        return l1;
      }
    }
    catch (Exception paramString)
    {
      return 0L;
    }
    return 0L;
  }
  
  public static AccountDetail a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (AccountDetail)paramQQAppInterface.a(AccountDetail.class, paramString);
    paramQQAppInterface.a();
    return paramString;
  }
  
  public static String a()
  {
    return "7.6.3,3,3565";
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject;
    if (paramBaseArticleInfo == null)
    {
      localObject = "";
      return localObject;
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          if ((paramBaseArticleInfo.mFeedType != 17) && (paramBaseArticleInfo.mFeedType != 16) && (paramBaseArticleInfo.mFeedType != 19) && (paramBaseArticleInfo.mFeedType != 18)) {
            break label212;
          }
          String str2 = "";
          String str3 = "";
          String str1 = str3;
          localObject = str2;
          if (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null)
          {
            str1 = str3;
            localObject = str2;
            if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a != null)
            {
              str1 = str3;
              localObject = str2;
              if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)
              {
                localObject = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c;
                str1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).jdField_a_of_type_JavaLangString;
              }
            }
          }
          paramBaseArticleInfo = (String)localObject + str1 + (String)localObject + " " + paramBaseArticleInfo.mTitle;
          localObject = paramBaseArticleInfo;
          try
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PublicAccountUtil", 2, new Object[] { "createStructingMsgBriefSuffix suffix = ", paramBaseArticleInfo });
            return paramBaseArticleInfo;
          }
          catch (Throwable localThrowable1) {}
        }
      }
      catch (Throwable localThrowable2)
      {
        label212:
        paramBaseArticleInfo = "";
        continue;
      }
      localThrowable1.printStackTrace();
      QLog.d("PublicAccountUtil", 1, "createStructingMsgBriefSuffix throw Throwable, create failed.");
      return paramBaseArticleInfo;
      if ((TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) && (paramBaseArticleInfo.isSocialFeed())) {
        paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString;
      } else {
        paramBaseArticleInfo = paramBaseArticleInfo.mTitle;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      str = b(paramQQAppInterface, paramBaseArticleInfo);
      paramBaseArticleInfo = a(paramBaseArticleInfo);
      paramQQAppInterface = paramBaseArticleInfo;
    } while (TextUtils.isEmpty(str));
    return str + ": " + paramBaseArticleInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
      str = paramString;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        str = paramString;
        if (paramQQAppInterface != null) {
          str = paramQQAppInterface.name;
        }
      }
    }
    return str;
  }
  
  public static String a(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return String.valueOf(paramObject);
  }
  
  public static String a(String paramString)
  {
    SkinData localSkinData = null;
    Object localObject1 = paramString;
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject1 = SharedPreUtils.r(BaseApplicationImpl.getApplication(), str);
      if (localObject1 == null) {
        break label123;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null) {
          localSkinData = new SkinData((JSONObject)localObject1);
        }
        localObject1 = paramString;
        if (localSkinData != null)
        {
          paramString = HtmlOffline.a(paramString, "_kdSkinID=" + localSkinData.id);
          if (SharedPreUtils.v(BaseApplicationImpl.getApplication(), str)) {
            localObject1 = HtmlOffline.a(paramString, "_kdSkinVoice=1");
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject2 = null;
        continue;
      }
      return HtmlOffline.a(paramString, "_kdSkinVoice=0");
      label123:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public static NewIntent a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, String paramString)
  {
    // Byte code:
    //   0: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 192
    //   8: iconst_2
    //   9: ldc_w 289
    //   12: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: ldc 2
    //   17: monitorenter
    //   18: aload_2
    //   19: ifnull +7 -> 26
    //   22: aload_2
    //   23: putstatic 291	com/tencent/biz/pubaccount/util/PublicAccountUtil:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   26: ldc 2
    //   28: monitorexit
    //   29: new 293	mqq/app/NewIntent
    //   32: dup
    //   33: aload_1
    //   34: ldc_w 295
    //   37: invokespecial 298	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   40: astore_1
    //   41: aload_1
    //   42: ldc_w 300
    //   45: ldc_w 302
    //   48: invokevirtual 306	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   51: pop
    //   52: new 308	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest
    //   55: dup
    //   56: invokespecial 309	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: getfield 313	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:seqno	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   64: iconst_0
    //   65: invokevirtual 319	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   68: aload_2
    //   69: getfield 322	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: iconst_1
    //   73: invokevirtual 319	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   76: aload_2
    //   77: getfield 326	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:versionInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   80: ldc 134
    //   82: invokevirtual 330	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   85: aload_2
    //   86: getfield 333	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:uin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: aload_3
    //   90: invokestatic 335	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   93: l2i
    //   94: invokevirtual 319	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   97: aload_1
    //   98: ldc_w 337
    //   101: aload_2
    //   102: invokevirtual 341	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:toByteArray	()[B
    //   105: invokevirtual 344	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   108: pop
    //   109: aload_1
    //   110: new 346	mwn
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 349	mwn:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   118: invokevirtual 353	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 357	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   126: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +12 -> 141
    //   132: ldc 192
    //   134: iconst_2
    //   135: ldc_w 359
    //   138: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_1
    //   142: areturn
    //   143: astore_0
    //   144: ldc 2
    //   146: monitorexit
    //   147: aload_0
    //   148: athrow
    //   149: astore_3
    //   150: goto -53 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramQQAppInterface	QQAppInterface
    //   0	153	1	paramContext	Context
    //   0	153	2	paramMqqHandler	MqqHandler
    //   0	153	3	paramString	String
    // Exception table:
    //   from	to	target	type
    //   22	26	143	finally
    //   26	29	143	finally
    //   144	147	143	finally
    //   85	97	149	java/lang/Exception
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (JSONException paramString)
    {
      return null;
    }
    catch (NullPointerException paramString)
    {
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_MqqOsMqqHandler = null;
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.post(new mwc(localUri, paramInt2, paramInt1, paramString), 5, null, false);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          i = Integer.parseInt(paramString2);
          paramString2 = Uri.parse(paramString1);
          if (paramString2 == null) {
            continue;
          }
          String str = paramString2.getHost();
          if ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str)))) {
            continue;
          }
          ThreadManager.post(new mwd(paramString2, i, paramString3, paramString4, paramInt, paramString1), 5, null, false);
          return;
        }
      }
      catch (NumberFormatException paramString2)
      {
        for (;;)
        {
          int i = 0;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public static void a(int paramInt, String paramString, List paramList)
  {
    ThreadManager.executeOnSubThread(new mwh(paramList, paramInt, paramString));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    Object localObject = paramProfileParams.a;
    if ((TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b))) {
      b(paramActivity, paramQQAppInterface, paramProfileParams);
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(((ProfileParams.CurLoginUsr)localObject).b))
      {
        String str = paramQQAppInterface.getCurrentAccountUin();
        if (!((ProfileParams.CurLoginUsr)localObject).b.equals(str))
        {
          c(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
        b(paramActivity, paramQQAppInterface, paramProfileParams);
        return;
      }
      localObject = new mwp(paramActivity, paramQQAppInterface, paramProfileParams);
      localObject = QZoneShareManager.a(paramQQAppInterface, paramProfileParams.a(), (BusinessObserver)localObject);
      if (localObject != null)
      {
        if (!a(paramActivity, (OpenID)localObject, paramQQAppInterface, paramProfileParams)) {}
        for (int i = 1; i != 0; i = 0)
        {
          b(paramActivity, paramQQAppInterface, paramProfileParams);
          return;
        }
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    switch (a(paramQQAppInterface, paramString, paramInt))
    {
    default: 
      a(paramIntent, paramContext, paramString);
    case -6: 
      return;
    }
    CrmUtils.a(paramContext, paramIntent, paramString, false, -1, true, -1);
  }
  
  private static void a(Intent paramIntent, Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 78));
      paramIntent.putExtra("uin", paramString);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
      return;
      paramIntent.setClassName(paramActivity, QidianProfileCardActivity.class.getName());
    }
  }
  
  public static void a(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, AccountDetailActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("uin", paramString);
      paramIntent.addFlags(67108864);
      paramContext.startActivity(paramIntent);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2131034132, 2131034133);
      }
      return;
      paramIntent.setClassName(paramContext, AccountDetailActivity.class.getName());
    }
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfileForResult app: " + paramQQAppInterface + " | activity: " + paramActivity + " | uin: " + paramString + " | accountFlag: " + paramInt1 + " | requestCode: " + paramInt2 + " | source: " + paramInt3);
    }
    if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      switch (a(paramQQAppInterface, paramString, paramInt1))
      {
      default: 
        a(paramIntent, paramQQAppInterface, paramActivity, paramString, paramInt2, paramInt3, paramBoolean);
        return;
      }
    } while (!BmqqSegmentUtil.a(paramActivity, paramString));
    a(paramIntent, paramActivity, paramString, paramInt2, paramInt3);
    return;
    CrmUtils.a(paramActivity, paramIntent, paramString, false, 5, true, paramInt2);
  }
  
  private static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = ReadInJoyConstants.i + Base64Util.encodeToString(paramString.getBytes(), 0);
      paramIntent = new Intent(paramActivity, PublicAccountBrowser.class);
      paramIntent.putExtra("url", str);
      paramActivity.startActivityForResult(paramIntent, paramInt1);
    }
    switch (paramInt2)
    {
    default: 
      return;
      if (paramIntent == null) {
        paramIntent = new Intent(paramActivity, AccountDetailActivity.class);
      }
      for (;;)
      {
        paramIntent.putExtra("uin", paramString);
        paramIntent.putExtra("source", 5);
        paramIntent.addFlags(67108864);
        break;
        paramIntent.setClassName(paramActivity, AccountDetailActivity.class.getName());
      }
    }
    PublicAccountHandler.a(paramQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "gotoProfile app: " + paramQQAppInterface + " | context: " + paramContext + " | uin: " + paramString + " | accountFlag: " + paramInt);
    }
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramInt = a(paramQQAppInterface, paramString, paramInt);
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4))
    {
      if (paramIntent != null) {
        break label221;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("source", 105);
    }
    label221:
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        a(paramIntent, paramContext, paramString);
        return;
        if ((paramInt == -1) && (paramIntent == null))
        {
          paramIntent = new Intent();
          paramIntent.putExtra("source", 104);
        }
        break;
      case -6: 
        if (!BmqqSegmentUtil.a(paramContext, paramString)) {
          break;
        }
        b(paramIntent, paramContext, paramString);
        return;
      case -7: 
        CrmUtils.a(paramContext, paramIntent, paramString, false, -1, true, -1);
        return;
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    a(null, paramIntent, paramString);
  }
  
  public static void a(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      try
      {
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
        return;
      }
      finally {}
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    b(paramAppInterface, paramContext, paramString, -1);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver)
  {
    a(paramAppInterface, paramContext, paramString, paramPublicAccountObserver, true, 0);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, int paramInt)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramContext.getApplicationContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "PubAccountFollowSvc.follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    for (;;)
    {
      try
      {
        localFollowRequest.uin.set((int)Long.parseLong(paramString));
        localFollowRequest.type.set(paramInt);
        localFollowRequest.ext.set("0");
        localNewIntent.setObserver(new mwk(paramPublicAccountObserver, paramString, paramContext, paramAppInterface));
        localNewIntent.putExtra("data", localFollowRequest.toByteArray());
        paramAppInterface.startServlet(localNewIntent);
        if (!(paramAppInterface instanceof QQAppInterface)) {
          break label176;
        }
        paramAppInterface = (QQAppInterface)paramAppInterface;
        PublicAccountReportUtils.a(paramAppInterface, paramString, 0);
        return;
      }
      catch (NumberFormatException paramAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("PublicAccountUtil", 2, "Follow Request got wrong uin:" + paramString);
      return;
      label176:
      paramAppInterface = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface))) {
        paramAppInterface = (QQAppInterface)paramAppInterface;
      } else {
        paramAppInterface = null;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean)
  {
    a(paramAppInterface, paramContext, paramString, paramPublicAccountObserver, paramBoolean, 0);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean, int paramInt)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(paramContext.getApplicationContext(), PublicAccountServlet.class);
      localNewIntent.putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.ext.set("" + paramInt);
      try
      {
        localFollowRequest.uin.set((int)Long.parseLong(paramString));
        localNewIntent.setObserver(new mwi(paramPublicAccountObserver, paramString, paramBoolean, paramContext, paramAppInterface, paramInt));
        localNewIntent.putExtra("data", localFollowRequest.toByteArray());
        paramAppInterface.startServlet(localNewIntent);
        return;
      }
      catch (NumberFormatException paramAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.w("PublicAccountUtil", 2, "Follow Request got wrong uin:" + paramString);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = paramQQAppInterface.getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mAlgorithmId = paramInt1;
    localReportInfo.mOperation = paramInt3;
    localReportInfo.mOpSource = 3;
    localReportInfo.mStrategyId = paramInt2;
    localArrayList.add(localReportInfo);
    new UserOperationModule(paramQQAppInterface, null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    b(paramQQAppInterface, paramContext, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.a(paramContext.getResources().getString(2131430175));
    localActionSheet.a(2131434041, 3);
    if (paramString.equals("2010741172")) {
      localActionSheet.b(2131430044);
    }
    localActionSheet.c(2131433015);
    localActionSheet.a(new mvz(paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean, paramContext, localActionSheet));
    localActionSheet.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, PublicAccountObserver paramPublicAccountObserver)
  {
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp().getApplicationContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "unfollow");
    Object localObject3 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((PublicAccountDataManager)localObject3).a(paramString);
      ((PublicAccountDataManager)localObject3).b(paramString);
      if (localObject1 == null)
      {
        localObject2 = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
        if (localObject2 != null)
        {
          localObject3 = ((EqqDetailDataManager)localObject2).a(paramString);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      localObject3 = new mobileqq_mp.UnFollowRequest();
      for (;;)
      {
        try
        {
          ((mobileqq_mp.UnFollowRequest)localObject3).uin.set((int)Long.parseLong(paramString));
          if (localObject1 != null) {
            break label222;
          }
          paramContext = new mwj(paramPublicAccountObserver, paramString, paramBoolean, paramContext, localObject1, paramQQAppInterface);
          localNewIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject3).toByteArray());
          localNewIntent.setObserver(paramContext);
          paramQQAppInterface.startServlet(localNewIntent);
          return;
        }
        catch (NumberFormatException paramQQAppInterface) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("PublicAccountUtil", 2, "Unfollow Request got wrong uin:" + paramString);
        return;
        label222:
        localObject1 = localObject2;
      }
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      continue;
      localObject1 = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, int paramInt)
  {
    if (paramMessageForStructing == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j;
    int i;
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))
    {
      localObject = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|");
      j = localObject.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          String str1 = localObject[i];
          try
          {
            localArrayList.add(Integer.valueOf(Integer.parseInt(str1)));
            i += 1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
        }
      }
    }
    Object localObject = new ArrayList();
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))
    {
      String[] arrayOfString = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|");
      j = arrayOfString.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          String str2 = arrayOfString[i];
          try
          {
            ((ArrayList)localObject).add(Integer.valueOf(Integer.parseInt(str2)));
            i += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
    {
      paramMessageForStructing = a(paramMessageForStructing.structingMsg.mMsgActionData);
      if (paramMessageForStructing == null) {}
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramMessageForStructing.getString("id"));
        if ((l == -1L) || (localArrayList.size() <= 0) || (((ArrayList)localObject).size() <= 0)) {
          break;
        }
        a(paramQQAppInterface, l, ((Integer)localArrayList.get(0)).intValue(), ((Integer)((ArrayList)localObject).get(0)).intValue(), paramInt);
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        paramMessageForStructing.printStackTrace();
      }
      long l = -1L;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.getCurrentAccountUin(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.a(11);
    if ((localPublicAccountHandler.a != null) && (localPublicAccountHandler.a.contains(paramString))) {
      localPublicAccountHandler.a.remove(paramString);
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.b(paramString);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (ReadInJoyHelper.a(paramQQAppInterface))
    {
      localObject = (KandianMergeManager)paramQQAppInterface.getManager(161);
      paramQQAppInterface = paramString1;
      if (!TextUtils.isEmpty(paramString3)) {
        paramQQAppInterface = paramString3 + ": " + paramString1;
      }
      ((KandianMergeManager)localObject).a(paramQQAppInterface, paramString2, paramInt, paramBoolean);
    }
    do
    {
      return;
      localObject = paramQQAppInterface.a();
    } while (localObject == null);
    ThreadManager.post(new mwe((QQMessageFacade)localObject, paramString3, paramString1, paramString2, paramQQAppInterface), 10, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, 0, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i = 1;
    Object localObject2 = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_Int == -1) {
          jdField_a_of_type_Int = ((SharedPreferences)localObject2).getInt(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0);
        }
        boolean bool;
        if (jdField_a_of_type_Int == 0)
        {
          bool = true;
          break label297;
          jdField_a_of_type_Int = i;
          ((SharedPreferences)localObject2).edit().putInt(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), jdField_a_of_type_Int).commit();
          if ((bool) && (paramBoolean))
          {
            ??? = paramQQAppInterface.a().a();
            if (??? != null)
            {
              localObject2 = ((RecentUserProxy)???).b(AppConstants.aq, 1008);
              if (localObject2 != null)
              {
                ((RecentUserProxy)???).b((RecentUser)localObject2);
                ??? = paramQQAppInterface.getHandler(Conversation.class);
                if (??? != null) {
                  ((MqqHandler)???).sendEmptyMessage(1009);
                }
              }
            }
            ??? = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
            if (??? != null)
            {
              ((PublicAccountDataManager)???).c(AppConstants.aq);
              paramQQAppInterface = paramQQAppInterface.getHandler(PublicAccountFragment.class);
              if (paramQQAppInterface != null) {
                paramQQAppInterface.sendEmptyMessage(0);
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("PublicAccountUtil", 2, "updateDeleteOldKandian notDeleteState = " + bool + ", isDelete = " + paramBoolean);
          }
        }
        else
        {
          bool = false;
          break label297;
          i = 0;
        }
      }
      label297:
      if (!paramBoolean) {}
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, Intent paramIntent, String paramString)
  {
    if (paramMessageRecord != null)
    {
      if (paramMessageRecord.istroop == 1) {
        paramIntent.putExtra("groupUin", paramMessageRecord.frienduin);
      }
      if (paramMessageRecord.istroop == 3000) {
        paramIntent.putExtra("dicussgroup_uin", paramMessageRecord.frienduin);
      }
      if (paramMessageRecord.istroop == 0) {
        paramIntent.putExtra("friend_uin", paramMessageRecord.frienduin);
      }
      paramIntent.putExtra("friendUin", paramMessageRecord.senderuin);
      paramIntent.putExtra("uinType", paramMessageRecord.istroop);
      paramIntent.putExtra("fromAio", true);
    }
    paramMessageRecord = paramIntent.getComponent();
    if ((paramMessageRecord == null) || (TextUtils.isEmpty(paramString))) {}
    label294:
    for (;;)
    {
      return;
      int i = paramString.indexOf("?");
      if (i != -1)
      {
        paramString = paramString.substring(i + 1).split("&");
        i = 0;
        for (;;)
        {
          if (i >= paramString.length) {
            break label294;
          }
          if (paramString[i].startsWith("_webviewtype="))
          {
            paramString = paramString[i].split("=");
            if ((paramString.length != 2) || (TextUtils.isEmpty(paramString[1]))) {
              break;
            }
            try
            {
              switch (Integer.parseInt(paramString[1]))
              {
              case 0: 
              case 1: 
                paramIntent.setComponent(new ComponentName(paramMessageRecord.getPackageName(), CouponActivity.class.getName()));
                return;
              }
            }
            catch (NumberFormatException paramMessageRecord)
            {
              return;
            }
          }
          if (paramString[i].startsWith("url="))
          {
            paramMessageRecord = paramString[i].split("=");
            if ((paramMessageRecord.length != 2) || (TextUtils.isEmpty(paramMessageRecord[1]))) {
              break;
            }
            a(paramIntent, URLDecoder.decode(paramMessageRecord[1]));
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    String str;
    do
    {
      do
      {
        return;
        localUri = Uri.parse(paramString);
      } while (localUri == null);
      str = localUri.getHost();
    } while ((TextUtils.isEmpty(str)) || ((!"article.mp.qq.com".equalsIgnoreCase(str)) && (!"post.mp.qq.com".equalsIgnoreCase(str))));
    ThreadManager.post(new mwb(localUri, paramString), 5, null, false);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "videoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface)))
    {
      b(paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
    localObject = new Intent("readInJoy_video_play_real_time_report");
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_AID", paramString1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_VID", paramString2);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RTYPE", paramInt1);
    ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RCODE", paramInt2);
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    paramInt = a(paramInt);
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == -4)) {}
    while (a(paramLong) == -8L) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, OpenID paramOpenID, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if ((paramOpenID != null) && (!TextUtils.isEmpty(paramOpenID.openID)))
    {
      if (!paramOpenID.openID.equals(paramProfileParams.a().jdField_a_of_type_JavaLangString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        c(paramActivity, paramQQAppInterface, paramProfileParams);
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(Context paramContext, ProfileParams paramProfileParams)
  {
    return (paramContext == null) || (paramProfileParams == null) || (paramProfileParams.a == null) || (TextUtils.isEmpty(paramProfileParams.a()));
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramAppInterface = paramAppInterface.getEntityManagerFactory(paramAppInterface.getAccount()).createEntityManager();
    if ((PublicAccountInfo)paramAppInterface.a(PublicAccountInfo.class, paramString) != null)
    {
      paramAppInterface.a();
      return true;
    }
    paramString = (AccountDetail)paramAppInterface.a(AccountDetail.class, paramString);
    paramAppInterface.a();
    try
    {
      paramAppInterface = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      paramAppInterface.mergeFrom(paramString.accountData);
      int i = paramAppInterface.follow_type.get();
      if (i == 1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramAppInterface) {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i = a(paramQQAppInterface, paramString);
    if ((i == -3) || (i == -4)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    if (ReadInJoyHelper.e(paramQQAppInterface)) {
      if ((paramInt == -2000) || (paramInt == -1000)) {
        bool = true;
      }
    }
    while ((!b(paramQQAppInterface, paramString)) && (paramInt != -2000) && (paramInt != -1000)) {
      return bool;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return ("3046055438".equals(paramString)) || ("3026775809".equals(paramString)) || ("2711679534".equals(paramString));
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 0) {}
    do
    {
      return false;
      paramString1 = Uri.parse(paramString1);
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getHost())) || ((!"article.mp.qq.com".equalsIgnoreCase(paramString1.getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(paramString1.getHost()))));
    ThreadManager.post(new mwa(paramString1, paramInt, paramString2), 5, null, false);
    return true;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.extendType == 2) {
          return 1024;
        }
        return 1008;
      }
    }
    return 1008;
  }
  
  private static MessageForStructing b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
    localMessageForStructing.structingMsg = StructMsgFactory.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 500;
    localMessageForStructing.selfuin = paramQQAppInterface.c();
    localMessageForStructing.frienduin = AppConstants.ar;
    localMessageForStructing.senderuin = AppConstants.ar;
    localMessageForStructing.istroop = 1008;
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private static MessageForStructing b(MessageForStructing paramMessageForStructing, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramMessageForStructing == null) || (!(paramMessageForStructing instanceof MessageForStructing)) || (!paramMessageForStructing.isread)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(paramMessageForStructing.msgtype);
    localMessageForStructing.copyStructingMsg(paramMessageForStructing);
    localMessageForStructing.issend = 1;
    localMessageForStructing.isread = true;
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessageForStructing.structingMsg.mMsgBrief = paramString1;
      localMessageForStructing.doPrewrite();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localMessageForStructing.structingMsg.mArticleIds = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localMessageForStructing.structingMsg.mOrangeWord = paramString3;
    }
    if (!TextUtils.isEmpty(paramString4)) {}
    try
    {
      localMessageForStructing.time = Long.parseLong(paramString4);
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    catch (Exception paramMessageForStructing)
    {
      for (;;)
      {
        paramMessageForStructing.printStackTrace();
      }
    }
  }
  
  public static String b()
  {
    try
    {
      Object localObject1 = ((WifiManager)ReadInJoyUtils.a().getApplication().getSystemService("wifi")).getConnectionInfo().getBSSID();
      Object localObject2 = new JSONObject();
      Object localObject3 = SosoInterface.b();
      if (localObject3 != null)
      {
        localObject3 = ((SosoInterface.SosoLbsInfo)localObject3).a;
        if (localObject3 != null)
        {
          ((JSONObject)localObject2).put("lon", a(Double.valueOf(((SosoInterface.SosoLocation)localObject3).b)));
          ((JSONObject)localObject2).put("lat", a(Double.valueOf(((SosoInterface.SosoLocation)localObject3).jdField_a_of_type_Double)));
          ((JSONObject)localObject2).put("countryID", a(((SosoInterface.SosoLocation)localObject3).c));
          ((JSONObject)localObject2).put("prov", a(((SosoInterface.SosoLocation)localObject3).d));
          ((JSONObject)localObject2).put("city", a(((SosoInterface.SosoLocation)localObject3).e));
          ((JSONObject)localObject2).put("dist", a(((SosoInterface.SosoLocation)localObject3).g));
          ((JSONObject)localObject2).put("road", a(((SosoInterface.SosoLocation)localObject3).j));
          ((JSONObject)localObject2).put("town", a(((SosoInterface.SosoLocation)localObject3).h));
          ((JSONObject)localObject2).put("time", a(Long.valueOf(((SosoInterface.SosoLocation)localObject3).jdField_a_of_type_Long / 1000L)));
          ((JSONObject)localObject2).put("platform", "android");
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((JSONObject)localObject2).put("bssid", a((String)localObject1));
      }
      localObject1 = ((JSONObject)localObject2).toString();
      localObject1 = ((String)localObject1).getBytes();
      localObject2 = new byte[localObject1.length];
      int i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte)(localObject1[i] ^ 0xB6));
        i += 1;
      }
      return Base64Util.encodeToString((byte[])localObject2, 2);
    }
    catch (Exception localException)
    {
      return "";
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    if ((paramBaseArticleInfo.mFeedType == 17) || (paramBaseArticleInfo.mFeedType == 16) || (paramBaseArticleInfo.mFeedType == 19) || (paramBaseArticleInfo.mFeedType == 18)) {
      return "";
    }
    if ((paramBaseArticleInfo.mFeedType == 4) || (paramBaseArticleInfo.mFeedType == 5))
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) {
        return "";
      }
      paramQQAppInterface = ReadInJoyUserInfoModule.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long, null);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.nick;
      }
      return String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
    }
    if (paramBaseArticleInfo.isSocialFeed())
    {
      paramQQAppInterface = ReadInJoyUserInfoModule.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long, null);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.nick;
      }
      return String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
    }
    return paramBaseArticleInfo.mSubscribeName;
  }
  
  public static void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_Int = -1;
      return;
    }
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    d(paramActivity, paramQQAppInterface, paramProfileParams);
    paramActivity.finish();
  }
  
  private static void b(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, QidianProfileCardActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 78));
      paramIntent.putExtra("uin", paramString);
      paramContext.startActivity(paramIntent);
      return;
      paramIntent.setClassName(paramContext, QidianProfileCardActivity.class.getName());
    }
  }
  
  private static void b(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("7.6.3,3,3565");
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      label90:
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new mwl(paramContext, paramAppInterface, paramInt, paramString));
      paramAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception localException)
    {
      break label90;
    }
  }
  
  static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label37:
    label298:
    label304:
    for (;;)
    {
      return;
      int i = paramString.indexOf("?");
      if (i != -1)
      {
        paramString = paramString.substring(i + 1).split("&");
        i = 0;
        if (i < paramString.length) {
          if (!paramString[i].startsWith("url=")) {}
        }
        for (paramString = URLDecoder.decode(paramString[i].split("=")[1]);; paramString = "")
        {
          if (TextUtils.isEmpty(paramString)) {
            break label304;
          }
          i = paramString.indexOf("?");
          if (i == -1) {
            break;
          }
          paramString = paramString.substring(i + 1).split("&");
          paramQQAppInterface.getCurrentAccountUin();
          i = 0;
          label111:
          if (i < paramString.length) {
            if (!paramString[i].startsWith("mailid=")) {}
          }
          for (paramString = paramString[i].split("=")[1];; paramString = "")
          {
            if (TextUtils.isEmpty(paramString)) {
              break label298;
            }
            paramQQAppInterface = String.format("http://w.mail.qq.com/cgi-bin/login?mailid=%1$s&target=mobileqqdel&fwd=mq&uin=%2$s&fun=from3g", new Object[] { paramString, paramQQAppInterface.getCurrentAccountUin() });
            try
            {
              paramQQAppInterface = HttpBaseUtil.a(paramQQAppInterface, "GET", new Bundle(), null).a;
              if (paramQQAppInterface.getStatusLine().getStatusCode() != 200) {
                continue;
              }
              paramQQAppInterface = new JSONObject(HttpBaseUtil.a(paramQQAppInterface));
              if (!paramQQAppInterface.has("ret")) {
                continue;
              }
              i = paramQQAppInterface.getInt("ret");
              if (i != 0) {
                continue;
              }
              i = 1;
            }
            catch (Exception paramQQAppInterface)
            {
              for (;;)
              {
                i = 0;
                continue;
                i = 0;
              }
            }
            if (i != 0) {
              break;
            }
            QQToast.a(paramContext.getApplicationContext(), paramContext.getResources().getString(2131430045), 0).a();
            return;
            i += 1;
            break label37;
            i += 1;
            break label111;
          }
          break;
        }
      }
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountUtil", 2, "doVideoPlayRealtimeReport aid=" + paramString1 + ", vid=" + paramString2 + ", rtype=" + paramInt1 + ", rcode=" + paramInt2);
    }
    ThreadManager.post(new mwf(paramString2, paramString1, paramInt1, paramInt2), 5, null, true);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int == -1) {
        jdField_a_of_type_Int = localSharedPreferences.getInt(jdField_a_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin(), 0);
      }
      if (jdField_a_of_type_Int != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString) == -2;
  }
  
  public static boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if ((paramString != null) && (("article.mp.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected static final void c(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    paramQQAppInterface = new mwr(paramActivity, paramProfileParams, paramQQAppInterface);
    paramProfileParams = new mws(paramActivity, paramProfileParams);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131430025);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131430159);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131433015, paramQQAppInterface);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131430027, paramQQAppInterface);
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(paramProfileParams);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception paramActivity) {}
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    return;
  }
  
  public static boolean c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null) {
        return d(paramString.getHost());
      }
    }
    return false;
  }
  
  public static void d(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams)
  {
    if (a(paramActivity, paramProfileParams)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, AccountDetailActivity.class);
    localIntent.addFlags(268435456);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("profile_params", paramProfileParams);
    localBundle.putString("pkg_name", paramActivity.getIntent().getStringExtra("pkg_name"));
    localIntent.putExtras(localBundle);
    a(paramActivity, paramQQAppInterface, paramProfileParams.b(), paramProfileParams.a(), localIntent);
  }
  
  public static boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("article.mp.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)) || ("kandian.qq.com".equalsIgnoreCase(paramString)) || ("sqimg.qq.com".equalsIgnoreCase(paramString)));
  }
  
  public static boolean e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if ((paramString != null) && (("kandian.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)) || ("act.kandian.qq.com".equalsIgnoreCase(paramString)) || ("node.kandian.qq.com".equalsIgnoreCase(paramString)))) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil
 * JD-Core Version:    0.7.0.1
 */