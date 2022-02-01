package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.BasePublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.NewPublicAccountServlet;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.applets.PublicAccountIntent;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySpEventReportUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpResponseBean;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.RetInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class PublicAccountUtilImpl
  implements IPublicAccountUtil
{
  public static final String AB_TEST_LOADTIME = "ab_test_loadtime_";
  public static final String AB_TEST_SHAREPRE = "ab_test_sharePre";
  public static final String AB_TEST_SWITCH = "ab_test_switch_";
  private static volatile int DELETE_OLDKANDIAN_FLAG = -1;
  private static Object LOCK = new Object();
  private static String TAG_DELETE_OLDKANDIAN_FLAG = "tag_delete_oldkandian_flag";
  private static boolean isComeFromReadInjoy = false;
  public static long lastRequestLbsTime = 0L;
  public static MqqHandler publicAccountAIOuiHandler;
  private static WeakReference<Handler> qqLsHandler;
  
  private static boolean WenHao(String paramString1, String paramString2)
  {
    if (paramString1.length() != paramString2.length()) {
      return false;
    }
    int i = 0;
    while (i < paramString2.length())
    {
      if ((paramString1.charAt(i) != paramString2.charAt(i)) && (paramString2.charAt(i) != '?')) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean XingHao(String paramString1, String paramString2)
  {
    int m = paramString1.length();
    int k = paramString2.length();
    int n = paramString2.indexOf("*");
    int i;
    if (n != -1)
    {
      if (n != 0)
      {
        i = 0;
        while (i < n)
        {
          if (paramString1.charAt(i) != paramString2.charAt(i)) {
            return false;
          }
          i += 1;
        }
        return XingHao(paramString1.substring(n, m), paramString2.substring(n, k));
      }
      if (k == 1) {
        return true;
      }
      i = 0;
      while (i < m)
      {
        j = paramString1.charAt(i);
        int i1 = n + 1;
        if ((j != paramString2.charAt(i1)) && (paramString2.charAt(i1) != '*'))
        {
          i += 1;
        }
        else
        {
          j = 1;
          break label149;
        }
      }
      int j = 0;
      i = 0;
      label149:
      if (j == 0) {
        return false;
      }
      if (i == m) {
        return true;
      }
      return XingHao(paramString1.substring(i, m), paramString2.substring(n + 1, k));
    }
    if (m == k)
    {
      if (m == 0) {
        return true;
      }
      i = 0;
      while (i < k)
      {
        if (paramString1.charAt(i) != paramString2.charAt(i)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static String bytesToString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(paramArrayOfByte[i]);
      localStringBuffer.append(",");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static MessageForStructing configureStructingMsgWithFields(MessageForStructing paramMessageForStructing, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramMessageForStructing != null) && ((paramMessageForStructing instanceof MessageForStructing)) && (paramMessageForStructing.isread))
    {
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
      if (!TextUtils.isEmpty(paramString4)) {
        try
        {
          localMessageForStructing.time = Long.parseLong(paramString4);
        }
        catch (Exception paramMessageForStructing)
        {
          paramMessageForStructing.printStackTrace();
        }
      }
      localMessageForStructing.extInt = 0;
      localMessageForStructing.extLong = 0;
      return localMessageForStructing;
    }
    return null;
  }
  
  private static boolean containLbsUin(AppInterface paramAppInterface, String paramString)
  {
    paramString = new UinPair(paramAppInterface.getCurrentAccountUin(), paramString);
    PublicAccountHandlerImpl localPublicAccountHandlerImpl = (PublicAccountHandlerImpl)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localPublicAccountHandlerImpl.lbsUinList == null)
    {
      EntityManager localEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
      localPublicAccountHandlerImpl.lbsUinList = localEntityManager.query(UinPair.class, false, "userUin=? ", new String[] { paramAppInterface.getCurrentAccountUin() }, null, null, null, null);
      localEntityManager.close();
      if (localPublicAccountHandlerImpl.lbsUinList == null) {
        localPublicAccountHandlerImpl.lbsUinList = new ArrayList();
      }
    }
    return localPublicAccountHandlerImpl.lbsUinList.contains(paramString);
  }
  
  public static boolean convert0xcf8ToMobileMP(byte[] paramArrayOfByte, oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse1)
  {
    if (paramGetPublicAccountDetailInfoResponse == null) {
      return false;
    }
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramArrayOfByte);
      int i = -1;
      if (paramArrayOfByte.uint32_result.has())
      {
        int j = paramArrayOfByte.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handle OidbSvc.0xcf8|OIDBSSOPke.result=");
          ((StringBuilder)localObject1).append(j);
          QLog.i("PublicAccountUtil", 2, ((StringBuilder)localObject1).toString());
          i = j;
        }
      }
      if ((i == 0) && (paramArrayOfByte.bytes_bodybuffer.has()) && (paramArrayOfByte.bytes_bodybuffer.get() != null))
      {
        paramGetPublicAccountDetailInfoResponse.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
        if (paramGetPublicAccountDetailInfoResponse.ret_info.has())
        {
          paramArrayOfByte = new mobileqq_mp.RetInfo();
          paramArrayOfByte.ret_code.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get());
          paramArrayOfByte.err_info.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).err_info.get());
          paramGetPublicAccountDetailInfoResponse1.ret_info.set(paramArrayOfByte);
        }
        paramGetPublicAccountDetailInfoResponse1.seqno.set(paramGetPublicAccountDetailInfoResponse.seqno.get());
        paramGetPublicAccountDetailInfoResponse1.uin.set((int)paramGetPublicAccountDetailInfoResponse.luin.get());
        paramGetPublicAccountDetailInfoResponse1.name.set(paramGetPublicAccountDetailInfoResponse.name.get());
        paramGetPublicAccountDetailInfoResponse1.display_number.set(paramGetPublicAccountDetailInfoResponse.display_number.get());
        paramGetPublicAccountDetailInfoResponse1.summary.set(paramGetPublicAccountDetailInfoResponse.summary.get());
        paramGetPublicAccountDetailInfoResponse1.is_recv_msg.set(paramGetPublicAccountDetailInfoResponse.is_recv_msg.get());
        paramGetPublicAccountDetailInfoResponse1.is_recv_push.set(paramGetPublicAccountDetailInfoResponse.is_recv_push.get());
        paramGetPublicAccountDetailInfoResponse1.certified_grade.set(paramGetPublicAccountDetailInfoResponse.certified_grade.get());
        Object localObject2;
        ArrayList localArrayList;
        oidb_cmd0xcf8.ConfigInfo localConfigInfo;
        mobileqq_mp.ConfigInfo localConfigInfo1;
        if (paramGetPublicAccountDetailInfoResponse.config_group_info.has())
        {
          paramArrayOfByte = new ArrayList();
          localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
            localArrayList = new ArrayList();
            localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
              localConfigInfo1 = new mobileqq_mp.ConfigInfo();
              localConfigInfo1.type.set(localConfigInfo.type.get());
              localConfigInfo1.title.set(localConfigInfo.title.get());
              localConfigInfo1.content.set(localConfigInfo.content.get());
              localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
              localConfigInfo1.url.set(localConfigInfo.url.get());
              localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
              localConfigInfo1.state.set(localConfigInfo.state.get());
              localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
              localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
              localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
              localArrayList.add(localConfigInfo1);
            }
            localObject2 = new mobileqq_mp.ConfigGroupInfo();
            ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
            paramArrayOfByte.add(localObject2);
          }
          paramGetPublicAccountDetailInfoResponse1.config_group_info.set(paramArrayOfByte);
        }
        paramGetPublicAccountDetailInfoResponse1.is_show_share_button.set(paramGetPublicAccountDetailInfoResponse.is_show_share_button.get());
        paramGetPublicAccountDetailInfoResponse1.is_show_follow_button.set(paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get());
        paramGetPublicAccountDetailInfoResponse1.follow_type.set(paramGetPublicAccountDetailInfoResponse.follow_type.get());
        paramGetPublicAccountDetailInfoResponse1.is_sync_lbs.set(paramGetPublicAccountDetailInfoResponse.is_sync_lbs.get());
        paramGetPublicAccountDetailInfoResponse1.group_id.set(paramGetPublicAccountDetailInfoResponse.group_id.get());
        paramGetPublicAccountDetailInfoResponse1.show_flag.set(paramGetPublicAccountDetailInfoResponse.show_flag.get());
        paramGetPublicAccountDetailInfoResponse1.account_flag.set(paramGetPublicAccountDetailInfoResponse.account_flag.get());
        paramGetPublicAccountDetailInfoResponse1.luin.set(paramGetPublicAccountDetailInfoResponse.luin.get());
        paramGetPublicAccountDetailInfoResponse1.config_background_color.set(paramGetPublicAccountDetailInfoResponse.config_background_color.get());
        paramGetPublicAccountDetailInfoResponse1.config_background_img.set(paramGetPublicAccountDetailInfoResponse.config_background_img.get());
        if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has())
        {
          paramArrayOfByte = new ArrayList();
          localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
            localArrayList = new ArrayList();
            localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
              localConfigInfo1 = new mobileqq_mp.ConfigInfo();
              localConfigInfo1.type.set(localConfigInfo.type.get());
              localConfigInfo1.title.set(localConfigInfo.title.get());
              localConfigInfo1.content.set(localConfigInfo.content.get());
              localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
              localConfigInfo1.url.set(localConfigInfo.url.get());
              localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
              localConfigInfo1.state.set(localConfigInfo.state.get());
              localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
              localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
              localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
              localArrayList.add(localConfigInfo1);
            }
            localObject2 = new mobileqq_mp.ConfigGroupInfo();
            ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
            paramArrayOfByte.add(localObject2);
          }
          paramGetPublicAccountDetailInfoResponse1.config_group_info_new.set(paramArrayOfByte);
        }
        paramGetPublicAccountDetailInfoResponse1.certified_description.set(paramGetPublicAccountDetailInfoResponse.certified_description.get());
        paramGetPublicAccountDetailInfoResponse1.unified_account_descrpition.set(paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get());
        paramGetPublicAccountDetailInfoResponse1.account_flag2.set(paramGetPublicAccountDetailInfoResponse.account_flag2.get());
        return true;
      }
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.w("PublicAccountUtil", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
      return false;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.w("PublicAccountUtil", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
    }
    return false;
  }
  
  private static void createFakeStructingMsgWithFields(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle())
    {
      localObject = paramString1;
      if (!TextUtils.isEmpty(paramString3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString3);
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append(paramString1);
        localObject = ((StringBuilder)localObject).toString();
      }
      ((IKanDianMergeManager)((QQAppInterface)paramAppInterface).getRuntimeService(IKanDianMergeManager.class)).createFakeMsgForMergeKandian((String)localObject, paramString2, paramInt, paramBoolean);
      return;
    }
    Object localObject = ((QQAppInterface)paramAppInterface).getMessageFacade();
    if (localObject != null) {
      ThreadManager.post(new PublicAccountUtilImpl.15((QQMessageFacade)localObject, paramString3, paramString1, paramString2, paramAppInterface), 10, null, false);
    }
  }
  
  private static void displayToast(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static int getAccountTypeInner(int paramInt)
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
    if ((paramInt & 0x80000000) != 0) {
      return -9;
    }
    return -11;
  }
  
  private static IPublicAccountConfigAttr.PaConfigInfo getConfigInfo(PublicAccountDetailImpl paramPublicAccountDetailImpl, int paramInt1, int paramInt2)
  {
    if (paramPublicAccountDetailImpl.paConfigAttrs != null)
    {
      if (paramPublicAccountDetailImpl.paConfigAttrs.isEmpty()) {
        return null;
      }
      IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo;
      do
      {
        paramPublicAccountDetailImpl = paramPublicAccountDetailImpl.paConfigAttrs.iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!paramPublicAccountDetailImpl.hasNext()) {
              break;
            }
            localObject = (IPublicAccountConfigAttr)paramPublicAccountDetailImpl.next();
          } while (((IPublicAccountConfigAttr)localObject).getType() != paramInt1);
          localObject = ((IPublicAccountConfigAttr)localObject).getConfigs().iterator();
        }
        localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)((Iterator)localObject).next();
      } while (localPaConfigInfo.e != paramInt2);
      return localPaConfigInfo;
    }
    return null;
  }
  
  public static IPublicAccountConfigAttr.PaConfigInfo getMessageHistoryInfo(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = getConfigInfo(paramPublicAccountDetailImpl, 0, 9);
    if (localPaConfigInfo == null)
    {
      paramPublicAccountDetailImpl = getConfigInfo(paramPublicAccountDetailImpl, 0, 0);
      if ((paramPublicAccountDetailImpl != null) && ("历史消息".equals(paramPublicAccountDetailImpl.b))) {
        return paramPublicAccountDetailImpl;
      }
    }
    return localPaConfigInfo;
  }
  
  public static Integer getMessageSetting(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    paramPublicAccountDetailImpl = getConfigInfo(paramPublicAccountDetailImpl, 0, 10);
    if (paramPublicAccountDetailImpl == null) {
      return null;
    }
    return Integer.valueOf(paramPublicAccountDetailImpl.f);
  }
  
  private static String getNonNullObejct(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return String.valueOf(paramObject);
  }
  
  private static int getSubscriptCount(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      paramAppInterface = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (paramAppInterface != null)
      {
        i = ((ArrayList)paramAppInterface.getPublicAccountScriptList()).size();
        break label40;
      }
    }
    int i = 0;
    label40:
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getSubscriptCount count: ");
      paramAppInterface.append(i);
      QLog.d("PublicAccountUtil", 2, paramAppInterface.toString());
    }
    return i;
  }
  
  private void gotoAIO(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("gotoAIO app: ");
      ((StringBuilder)localObject1).append(paramAppInterface);
      ((StringBuilder)localObject1).append(" | context: ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" | uin: ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" | accountFlag: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("PublicAccountUtil", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramAppInterface != null) && (paramContext != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject1 = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject1 != null)
      {
        localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)localObject1).findPublicAccountInfoCache(paramString);
        if (localObject1 != null)
        {
          localObject1 = ((PublicAccountInfo)localObject1).name;
          break label161;
        }
      }
      localObject1 = "";
      label161:
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramString;
      }
      int i = getAccountType(paramAppInterface, paramString, paramInt);
      paramAppInterface = new Intent(paramContext, ChatActivity.class);
      paramInt = 1008;
      if (i == -7)
      {
        paramAppInterface.putExtra("chat_subType", 1);
        paramInt = 0;
      }
      paramAppInterface.putExtra("uin", paramString);
      paramAppInterface.putExtra("uintype", paramInt);
      paramAppInterface.putExtra("uinname", (String)localObject2);
      paramAppInterface.putExtra("leftViewText", paramContext.getString(2131887625));
      paramContext.startActivity(paramAppInterface);
    }
  }
  
  private static boolean isLike(String paramString1, String paramString2)
  {
    if (paramString2.indexOf("?") != -1) {
      return WenHao(paramString1, paramString2);
    }
    if (paramString2.indexOf("*") != -1) {
      return XingHao(paramString1, paramString2);
    }
    return false;
  }
  
  private boolean isMediaAndOtherSubscript(int paramInt)
  {
    paramInt = getAccountType(paramInt);
    return (paramInt == -3) || (paramInt == -4);
  }
  
  public static boolean isShopOrServiceAccount(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    boolean bool = false;
    if (paramPublicAccountDetailImpl == null) {
      return false;
    }
    int i = getAccountTypeInner(paramPublicAccountDetailImpl.accountFlag);
    if ((i == -5) || (i == -11)) {
      bool = true;
    }
    return bool;
  }
  
  private static long macToLong(String paramString)
  {
    long l1 = 0L;
    try
    {
      paramString = paramString.split(":");
      if (paramString.length == 6)
      {
        int i = 0;
        l1 = 0L;
        int j = 40;
        while (i < paramString.length)
        {
          long l3 = Long.parseLong(paramString[i], 16);
          long l2 = l3;
          if (j > 0) {
            l2 = l3 << j;
          }
          l1 += l2;
          j -= 8;
          i += 1;
        }
      }
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private static MessageForStructing newStructingMsgWithFields(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
    localMessageForStructing.structingMsg = StructMsgFactory.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 142;
    localMessageForStructing.selfuin = paramAppInterface.getCurrentUin();
    localMessageForStructing.frienduin = AppConstants.NEW_KANDIAN_UIN;
    localMessageForStructing.senderuin = AppConstants.NEW_KANDIAN_UIN;
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
    if (!TextUtils.isEmpty(paramString4)) {
      try
      {
        localMessageForStructing.time = Long.parseLong(paramString4);
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
      }
    }
    localMessageForStructing.extInt = 0;
    localMessageForStructing.extLong = 0;
    return localMessageForStructing;
  }
  
  private static void openBmqqProfile(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, QidianProfileCardActivity.class);
    } else {
      paramIntent.setClassName(paramContext, QidianProfileCardActivity.class.getName());
    }
    paramIntent.putExtra("AllInOne", new AllInOne(paramString, 104));
    paramIntent.putExtra("uin", paramString);
    paramContext.startActivity(paramIntent);
  }
  
  private static void openBmqqProfileForResult(Intent paramIntent, Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, QidianProfileCardActivity.class);
    } else {
      paramIntent.setClassName(paramActivity, QidianProfileCardActivity.class.getName());
    }
    paramIntent.putExtra("AllInOne", new AllInOne(paramString, 104));
    paramIntent.putExtra("uin", paramString);
    paramActivity.startActivityForResult(paramIntent, paramInt1);
  }
  
  private static void openPublicAccountProfileForResult(Intent paramIntent, AppInterface paramAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 == 1) {
      PublicAccountHandlerImpl.reportClickPublicAccountEventInner(paramAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
    }
    if (paramBoolean)
    {
      paramIntent = new StringBuilder();
      paramIntent.append(ReadInJoyConstants.l);
      paramIntent.append(Base64Util.encodeToString(paramString.getBytes(), 0));
      paramAppInterface = paramIntent.toString();
      if ((!TextUtils.isEmpty(paramAppInterface)) && (((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).isViolaUrlFromWeb(paramAppInterface)))
      {
        ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).startViolaPage(paramActivity, null, ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).getviolaurlfromweb(paramAppInterface), null);
        return;
      }
      paramIntent = new Intent(paramActivity, PublicAccountBrowserImpl.class);
      paramIntent.putExtra("url", paramAppInterface);
    }
    else
    {
      if (paramIntent == null) {
        paramIntent = new Intent(paramActivity, PublicAccountDetailActivityImpl.class);
      } else {
        paramIntent.setClassName(paramActivity, PublicAccountDetailActivityImpl.class.getName());
      }
      paramIntent.putExtra("uin", paramString);
      paramIntent.putExtra("source", 5);
      paramIntent.addFlags(67108864);
    }
    paramActivity.startActivityForResult(paramIntent, paramInt1);
  }
  
  public static String pickOutFreakingPhoneNumber(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    paramPublicAccountDetailImpl = getConfigInfo(paramPublicAccountDetailImpl, 0, 8);
    if (paramPublicAccountDetailImpl == null) {
      return null;
    }
    return paramPublicAccountDetailImpl.n;
  }
  
  private static void removeMail(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new PublicAccountUtilImpl.1(paramAppInterface, paramContext, paramString));
  }
  
  private static void reportPublicAccountPushRedDotExposure(String paramString)
  {
    Object localObject = (AppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    MessageRecord localMessageRecord = ((QQAppInterface)localObject).getMessageFacade().r(paramString, 1008);
    if (localMessageRecord != null)
    {
      if (localMessageRecord.isread) {
        return;
      }
      String str = localMessageRecord.getExtInfoFromExtStr("has_report");
      if ((TextUtils.isEmpty(str)) || (!"1".equals(str)))
      {
        localMessageRecord.saveExtInfoToExtStr("has_report", "1");
        ((QQAppInterface)localObject).getMessageFacade().a(localMessageRecord.frienduin, 1008, localMessageRecord.uniseq, "extStr", localMessageRecord.extStr);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009A7C", "0X8009A7C", 0, 0, paramString, "", "", "", false);
      }
    }
  }
  
  private static void saveLbsUin(AppInterface paramAppInterface, String paramString)
  {
    paramString = new UinPair(paramAppInterface.getCurrentAccountUin(), paramString);
    PublicAccountHandlerImpl localPublicAccountHandlerImpl = (PublicAccountHandlerImpl)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localPublicAccountHandlerImpl.lbsUinList == null) {
      localPublicAccountHandlerImpl.lbsUinList = new ArrayList();
    }
    localPublicAccountHandlerImpl.lbsUinList.add(paramString);
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager();
    paramAppInterface.persist(paramString);
    paramAppInterface.close();
  }
  
  private static void sendDelMailReq(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    i = paramString.indexOf("?");
    if (i == -1) {
      return;
    }
    paramString = paramString.substring(i + 1).split("&");
    j = 0;
    i = 0;
    int k;
    String str;
    for (;;)
    {
      k = paramString.length;
      str = "";
      if (i >= k) {
        break;
      }
      if (paramString[i].startsWith("url="))
      {
        paramString = URLDecoder.decode(paramString[i].split("=")[1]);
        break label97;
      }
      i += 1;
    }
    paramString = "";
    label97:
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    i = paramString.indexOf("?");
    if (i == -1) {
      return;
    }
    String[] arrayOfString = paramString.substring(i + 1).split("&");
    paramAppInterface.getCurrentAccountUin();
    i = 0;
    for (;;)
    {
      paramString = str;
      if (i >= arrayOfString.length) {
        break;
      }
      if (arrayOfString[i].startsWith("mailid="))
      {
        paramString = arrayOfString[i].split("=")[1];
        break;
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(paramString)) {
      paramAppInterface = String.format("https://w.mail.qq.com/cgi-bin/login?mailid=%1$s&target=mobileqqdel&fwd=mq&uin=%2$s&fun=from3g", new Object[] { paramString, paramAppInterface.getCurrentAccountUin() });
    }
    try
    {
      paramAppInterface = HttpBaseUtil.a(paramAppInterface, "GET", new Bundle(), null).a;
      i = j;
      if (paramAppInterface.getStatusLine().getStatusCode() == 200)
      {
        paramAppInterface = new JSONObject(HttpBaseUtil.b(paramAppInterface));
        i = j;
        if (paramAppInterface.has("ret"))
        {
          k = paramAppInterface.getInt("ret");
          i = j;
          if (k == 0) {
            i = 1;
          }
        }
      }
    }
    catch (Exception paramAppInterface)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i == 0) {
      ThreadManager.getUIHandler().post(new PublicAccountUtilImpl.2(paramContext));
    }
  }
  
  private static void sendDetailInfoRequest(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.8.17,3,5770");
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      label92:
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new PublicAccountUtilImpl.9(paramContext, paramAppInterface, paramInt, paramString));
      paramAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception localException)
    {
      break label92;
    }
  }
  
  public static void setMessageSetting(PublicAccountDetailImpl paramPublicAccountDetailImpl, int paramInt)
  {
    paramPublicAccountDetailImpl = getConfigInfo(paramPublicAccountDetailImpl, 0, 10);
    if (paramPublicAccountDetailImpl == null) {
      return;
    }
    paramPublicAccountDetailImpl.f = paramInt;
  }
  
  public static byte[] stringToBytes(String paramString)
  {
    paramString = paramString.split(",");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.put((byte)Integer.parseInt(paramString[i]));
      i += 1;
    }
    return localByteBuffer.array();
  }
  
  public String addSkinParams(String paramString)
  {
    Object localObject = paramString;
    String str;
    SkinData localSkinData;
    if (!TextUtils.isEmpty(paramString))
    {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = SharedPreUtils.br(BaseApplicationImpl.getApplication(), str);
      localSkinData = null;
      if (localObject == null) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject);
    }
    catch (Exception localException)
    {
      label47:
      break label47;
    }
    localObject = null;
    if (localObject != null) {
      localSkinData = new SkinData((JSONObject)localObject);
    }
    localObject = paramString;
    if (localSkinData != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("_kdSkinID=");
      ((StringBuilder)localObject).append(localSkinData.id);
      paramString = HtmlOffline.a(paramString, ((StringBuilder)localObject).toString());
      if (SharedPreUtils.bz(BaseApplicationImpl.getApplication(), str)) {
        return HtmlOffline.a(paramString, "_kdSkinVoice=1");
      }
      localObject = HtmlOffline.a(paramString, "_kdSkinVoice=0");
    }
    return localObject;
  }
  
  public boolean articleReport(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 0) {
      return false;
    }
    paramString1 = Uri.parse(paramString1);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.getHost())) && (("article.mp.qq.com".equalsIgnoreCase(paramString1.getHost())) || ("post.mp.qq.com".equalsIgnoreCase(paramString1.getHost()))))
    {
      ThreadManager.post(new PublicAccountUtilImpl.11(this, paramString1, paramInt, paramString2), 5, null, false);
      return true;
    }
    return false;
  }
  
  public int caculateMsgTabRedPntExcludeSelf(String paramString)
  {
    Object localObject1 = RecentDataListManager.a().c;
    int i = 0;
    if (localObject1 == null) {
      return 0;
    }
    localObject1 = new ArrayList((Collection)localObject1);
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
      if ((localRecentUserBaseData != null) && (localRecentUserBaseData.mUser != null))
      {
        if ((localRecentUserBaseData.mUser.getType() == 1008) && (ServiceAccountFolderManager.b((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), localRecentUserBaseData.mUser.uin))) {
          ((Iterator)localObject2).remove();
        }
      }
      else {
        ((Iterator)localObject2).remove();
      }
    }
    int k;
    for (int j = 0; i < ((List)localObject1).size(); j = k)
    {
      localObject2 = (RecentUserBaseData)((List)localObject1).get(i);
      if (((RecentUserBaseData)localObject2).mUser.getType() == 1008)
      {
        k = j;
        if (TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, paramString)) {
          break label241;
        }
        if (TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, AppConstants.TROOP_ASSISTANT_UIN))
        {
          k = j;
          break label241;
        }
      }
      k = j;
      if (((RecentUserBaseData)localObject2).getUnreadNum() > 0) {
        k = j + ((RecentUserBaseData)localObject2).getUnreadNum();
      }
      label241:
      i += 1;
    }
    return j;
  }
  
  public void cleanPublicAccountObserver()
  {
    try
    {
      publicAccountAIOuiHandler = null;
      return;
    }
    finally {}
  }
  
  public String constructAttributeL()
  {
    String str2 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    Object localObject = new JSONObject();
    try
    {
      String str1 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getIMEIForReport();
      if (str1 == null) {
        str1 = "";
      }
      ((JSONObject)localObject).put("adcode", str2);
      ((JSONObject)localObject).put("deviceCode", str1);
      ((JSONObject)localObject).put("macAddress", "");
      String str3 = DeviceInfoUtil.j();
      if ((!TextUtils.isEmpty(str3)) && (str3.length() == 16)) {
        ((JSONObject)localObject).put("android_id", str3);
      }
      ((IReadInJoySpEventReportUtil)QRoute.api(IReadInJoySpEventReportUtil.class)).addLbsInfo((JSONObject)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("constructAttributeL,adCode:");
        localStringBuilder.append(str2);
        localStringBuilder.append(",deviceID:");
        localStringBuilder.append(str1);
        localStringBuilder.append(",macAddress:");
        localStringBuilder.append("");
        localStringBuilder.append(",androidID : ");
        localStringBuilder.append(str3);
        QLog.d("PublicAccountUtil", 2, localStringBuilder.toString());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    byte[] arrayOfByte = ((JSONObject)localObject).toString().getBytes();
    localObject = new byte[arrayOfByte.length];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      localObject[i] = ((byte)(arrayOfByte[i] ^ 0xB6));
      i += 1;
    }
    return Base64Util.encodeToString((byte[])localObject, 2);
  }
  
  public void createFakeStructingMsgWithFields(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    createFakeStructingMsgWithFields(paramAppInterface, paramString1, paramString2, paramString3, 0, paramBoolean);
  }
  
  public String createStructingMsgBrief(AppInterface paramAppInterface, Object paramObject)
  {
    return ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).createStructingMsgBrief(paramAppInterface, (AbsBaseArticleInfo)paramObject);
  }
  
  public void deletePubAccountMsg(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramAppInterface = (QQAppInterface)paramAppInterface;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(paramContext, null);
    localActionSheet.setMainTitle(paramContext.getResources().getString(2131893858));
    localActionSheet.addButton(2131888438, 3);
    if (paramString.equals("2010741172")) {
      localActionSheet.addButton(2131892913);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new PublicAccountUtilImpl.3(this, paramAppInterface, paramString, paramInt, paramLong, paramBoolean, paramContext, localActionSheet));
    localActionSheet.show();
  }
  
  public void doVideoPlayRealtimeReport(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doVideoPlayRealtimeReport aid=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", vid=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", rtype=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", rcode=");
      localStringBuilder.append(paramInt2);
      QLog.i("PublicAccountUtil", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new PublicAccountUtilImpl.16(this, paramString2, paramString1, paramInt1, paramInt2), 5, null, true);
  }
  
  public void enterTimTeam(Context paramContext, AppInterface paramAppInterface)
  {
    boolean bool = ((Boolean)SharedPreUtils.a(paramContext, paramAppInterface.getCurrentAccountUin(), "config_tim_team_is_web", Boolean.valueOf(false))).booleanValue();
    String str = (String)SharedPreUtils.a(paramContext, paramAppInterface.getCurrentAccountUin(), "config_tim_team_url", "https://m.q.qq.com/a/p/1109953074?s=pages%2Fnotification%2Findex%3FenterType%3DqqMiniHelper");
    Object localObject = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if ((!bool) && (((IMiniAppService)localObject).isMiniAppUrl(str)))
    {
      ((IMiniAppService)localObject).startMiniApp(paramContext, str, 1043, null);
    }
    else
    {
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", str);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("webStyle", "noBottomBar");
      paramContext.startActivity((Intent)localObject);
    }
    ((QQAppInterface)paramAppInterface).getMessageFacade().a(AppConstants.TIM_TEAM_UIN, 1008, true, true);
  }
  
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver)
  {
    followUin(paramAppInterface, paramContext, paramString, paramIPublicAccountObserver, true, 0);
  }
  
  @Deprecated
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver, int paramInt)
  {
    if ((paramAppInterface != null) && (paramContext != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramContext = new PublicAccountUtilImpl.8(this, paramIPublicAccountObserver, paramString, paramAppInterface, paramContext);
      paramIPublicAccountObserver = (QQAppInterface)paramAppInterface;
      paramAppInterface.addObserver(new NewPublicAccountObserver(paramContext, paramIPublicAccountObserver));
      PublicAccountStateReporter.a(paramIPublicAccountObserver, true, paramString, 0);
      if (!(paramAppInterface instanceof AppInterface))
      {
        paramAppInterface = BaseApplicationImpl.getApplication().peekAppRuntime();
        if ((paramAppInterface != null) && ((paramAppInterface instanceof AppInterface))) {
          paramAppInterface = (AppInterface)paramAppInterface;
        } else {
          paramAppInterface = null;
        }
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(paramAppInterface, paramString, 0);
    }
  }
  
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver, boolean paramBoolean)
  {
    followUin(paramAppInterface, paramContext, paramString, paramIPublicAccountObserver, paramBoolean, 0);
  }
  
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver, boolean paramBoolean, int paramInt)
  {
    followUin(paramAppInterface, paramContext, paramString, paramIPublicAccountObserver, paramBoolean, paramInt, false);
  }
  
  public void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Object localObject;
    mobileqq_mp.FollowRequest localFollowRequest;
    if ((paramAppInterface != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramContext = BaseApplicationImpl.getContext();
      boolean bool2 = false;
      boolean bool1 = false;
      if (paramBoolean2)
      {
        paramBoolean2 = true;
      }
      else
      {
        localObject = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        paramBoolean2 = bool1;
        if (localObject != null)
        {
          localObject = (PublicAccountDetailImpl)((IPublicAccountDataManager)localObject).findAccountDetailInfo(paramString);
          paramBoolean2 = bool1;
          if (localObject != null) {
            if (getAccountType(((PublicAccountDetailImpl)localObject).accountFlag) == -4) {
              paramBoolean2 = bool2;
            } else {
              paramBoolean2 = true;
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("followUin() uin: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("  useNewProtocol: ");
        ((StringBuilder)localObject).append(paramBoolean2);
        QLog.d("PublicAccountUtil", 2, ((StringBuilder)localObject).toString());
      }
      if (((paramAppInterface instanceof AppInterface)) && (!paramBoolean2))
      {
        localObject = new NewIntent(paramContext.getApplicationContext(), PublicAccountServletImpl.class);
        ((NewIntent)localObject).putExtra("cmd", "follow");
        localFollowRequest = new mobileqq_mp.FollowRequest();
        PBStringField localPBStringField = localFollowRequest.ext;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt);
        localPBStringField.set(localStringBuilder.toString());
      }
    }
    try
    {
      localFollowRequest.uin.set((int)Long.parseLong(paramString));
      ((NewIntent)localObject).setObserver(new PublicAccountUtilImpl.5(this, paramIPublicAccountObserver, paramString, paramBoolean1, paramContext, paramAppInterface, paramInt));
      ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
      paramAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (NumberFormatException paramAppInterface)
    {
      label323:
      break label323;
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("Follow Request got wrong uin:");
      paramAppInterface.append(paramString);
      QLog.w("PublicAccountUtil", 2, paramAppInterface.toString());
    }
    return;
    paramIPublicAccountObserver = new NewPublicAccountObserver(new PublicAccountUtilImpl.4(this, paramIPublicAccountObserver, paramString, paramAppInterface, paramContext, paramInt, paramBoolean1));
    paramContext = new PublicAccountIntent(paramContext.getApplicationContext(), NewPublicAccountServlet.class);
    paramContext.a(paramIPublicAccountObserver);
    paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_CMD", "newFollow");
    paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_UIN", paramString);
    paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_IS_FOLLOW", true);
    paramContext.putExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", paramInt);
    paramAppInterface.startServlet(paramContext);
    return;
  }
  
  public int getAccountType(int paramInt)
  {
    return getAccountTypeInner(paramInt);
  }
  
  public int getAccountType(AppInterface paramAppInterface, String paramString)
  {
    int j = -1;
    int k = j;
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      Object localObject = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      k = j;
      if (localObject != null)
      {
        localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(paramString);
        if (localObject != null) {
          if (((PublicAccountInfo)localObject).extendType != 2) {}
        }
        do
        {
          return -7;
          return getAccountType(((PublicAccountInfo)localObject).accountFlag);
          localObject = ((TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString);
          int i = j;
          if (localObject != null)
          {
            i = j;
            if (((TroopInfo)localObject).associatePubAccount != 0L) {
              i = -4;
            }
          }
          paramAppInterface = (EqqDetailDataManager)paramAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
          k = i;
          if (paramAppInterface == null) {
            break;
          }
          k = i;
        } while (paramAppInterface.a(paramString) != null);
      }
    }
    return k;
  }
  
  public int getAccountType(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    int j = getAccountType(paramAppInterface, paramString);
    int i = j;
    if (j == -1) {
      i = getAccountType(paramInt);
    }
    return i;
  }
  
  public long getAccountType2(long paramLong)
  {
    if ((0x200 & paramLong) != 0L) {
      return -8L;
    }
    if ((paramLong & 0x100000) != 0L) {
      return -10L;
    }
    return -1L;
  }
  
  public String getNickName(AppInterface paramAppInterface, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramAppInterface = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      str = paramString;
      if (paramAppInterface != null)
      {
        paramAppInterface = (PublicAccountInfo)paramAppInterface.findPublicAccountInfoCache(paramString);
        str = paramString;
        if (paramAppInterface != null) {
          str = paramAppInterface.name;
        }
      }
    }
    return str;
  }
  
  public int getPubAccountRecentUserPosInMessageList(String paramString)
  {
    Object localObject1 = RecentDataListManager.a().c;
    if (localObject1 == null) {
      return 2147483647;
    }
    localObject1 = new ArrayList((Collection)localObject1);
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
      if ((localRecentUserBaseData != null) && (localRecentUserBaseData.mUser != null))
      {
        if ((localRecentUserBaseData.mUser.getType() == 1008) && (ServiceAccountFolderManager.b((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), localRecentUserBaseData.mUser.uin))) {
          ((Iterator)localObject2).remove();
        }
      }
      else {
        ((Iterator)localObject2).remove();
      }
    }
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (RecentUserBaseData)((List)localObject1).get(i);
      if ((((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, paramString))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  /* Error */
  public NewIntent getPublicAccountDetailRequest(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, String paramString)
  {
    // Byte code:
    //   0: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: new 278	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: ldc_w 1517
    //   20: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: aload 4
    //   28: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: ldc_w 289
    //   35: iconst_2
    //   36: aload 5
    //   38: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 684	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: ldc 2
    //   46: monitorenter
    //   47: aload_3
    //   48: ifnull +7 -> 55
    //   51: aload_3
    //   52: putstatic 1199	com/tencent/biz/pubaccount/util/api/impl/PublicAccountUtilImpl:publicAccountAIOuiHandler	Lmqq/os/MqqHandler;
    //   55: ldc 2
    //   57: monitorexit
    //   58: new 1023	mqq/app/NewIntent
    //   61: dup
    //   62: aload_2
    //   63: ldc_w 1025
    //   66: invokespecial 1026	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   69: astore_2
    //   70: aload_2
    //   71: ldc_w 1028
    //   74: ldc_w 1030
    //   77: invokevirtual 1031	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   80: pop
    //   81: new 1033	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest
    //   84: dup
    //   85: invokespecial 1034	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:<init>	()V
    //   88: astore_3
    //   89: aload_3
    //   90: getfield 1040	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:seqno	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: iconst_0
    //   94: invokevirtual 334	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   97: aload_3
    //   98: getfield 1043	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   101: iconst_1
    //   102: invokevirtual 334	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   105: aload_3
    //   106: getfield 1037	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:versionInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   109: ldc_w 1039
    //   112: invokevirtual 345	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   115: aload_3
    //   116: getfield 1044	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:uin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: aload 4
    //   121: invokestatic 178	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   124: l2i
    //   125: invokevirtual 334	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   128: aload_2
    //   129: ldc_w 1046
    //   132: aload_3
    //   133: invokevirtual 1047	com/tencent/mobileqq/mp/mobileqq_mp$GetPublicAccountDetailInfoRequest:toByteArray	()[B
    //   136: invokevirtual 1050	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   139: pop
    //   140: aload_2
    //   141: new 1519	com/tencent/biz/pubaccount/util/api/impl/PublicAccountUtilImpl$10
    //   144: dup
    //   145: aload_0
    //   146: aload_1
    //   147: invokespecial 1522	com/tencent/biz/pubaccount/util/api/impl/PublicAccountUtilImpl$10:<init>	(Lcom/tencent/biz/pubaccount/util/api/impl/PublicAccountUtilImpl;Lcom/tencent/common/app/AppInterface;)V
    //   150: invokevirtual 1059	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   153: aload_1
    //   154: aload_2
    //   155: invokevirtual 1063	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   158: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +13 -> 174
    //   164: ldc_w 289
    //   167: iconst_2
    //   168: ldc_w 1065
    //   171: invokestatic 684	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_2
    //   175: areturn
    //   176: astore_1
    //   177: ldc 2
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: astore 4
    //   184: goto -56 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	PublicAccountUtilImpl
    //   0	187	1	paramAppInterface	AppInterface
    //   0	187	2	paramContext	Context
    //   0	187	3	paramMqqHandler	MqqHandler
    //   0	187	4	paramString	String
    //   13	24	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	55	176	finally
    //   55	58	176	finally
    //   177	180	176	finally
    //   115	128	182	java/lang/Exception
  }
  
  public String getSourceId(String paramString)
  {
    if ("2105640434".equals(paramString)) {
      return "biz_src_gzh_bodong";
    }
    if ("2747277822".equals(paramString)) {
      return "biz_src_gzh_games";
    }
    if ("2080578142".equals(paramString)) {
      return "biz_src_gwh";
    }
    if ("3046055438".equals(paramString)) {
      return "biz_src_gzh_qqgw";
    }
    if ("2993250418".equals(paramString)) {
      return "biz_src_gzh_qqmusic";
    }
    if ("2909288299".equals(paramString)) {
      return "biz_src_gzh_news";
    }
    if ("2711679534".equals(paramString)) {
      return "biz_src_gzh_qianbao";
    }
    if ("2632129500".equals(paramString)) {
      return "biz_src_gzh_chwl";
    }
    if ("1816533856".equals(paramString)) {
      return "biz_src_gzh_qqzb";
    }
    if ("3288261892".equals(paramString)) {
      return "biz_src_gzh_ketang";
    }
    if ("3383393803".equals(paramString)) {
      return "biz_src_gzh_fudao";
    }
    if ("3026775809".equals(paramString)) {
      return "biz_src_gzh_sport";
    }
    if ("2658655094".equals(paramString)) {
      return "biz_src_gzh_weather";
    }
    return "biz_src_gzh";
  }
  
  public int getUinType(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (paramAppInterface != null)
    {
      paramAppInterface = (PublicAccountInfo)paramAppInterface.findPublicAccountInfo(paramString);
      if ((paramAppInterface != null) && (paramAppInterface.extendType == 2)) {
        return 1024;
      }
    }
    return 1008;
  }
  
  public String getVersionInfo()
  {
    return "8.8.17,3,5770";
  }
  
  public void gotoProfile(Intent paramIntent, AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoProfile app: ");
      localStringBuilder.append(paramAppInterface);
      localStringBuilder.append(" | context: ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(" | uin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | accountFlag: ");
      localStringBuilder.append(paramInt);
      QLog.d("PublicAccountUtil", 2, localStringBuilder.toString());
    }
    if ((paramAppInterface != null) && (paramContext != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString))
      {
        ((IKandianSubscribeManager)((QQAppInterface)paramAppInterface).getRuntimeService(IKandianSubscribeManager.class)).lanuchKandianSubscribeActivity(paramContext, 3);
        return;
      }
      paramInt = getAccountType(paramAppInterface, paramString, paramInt);
      if ((paramInt != -2) && (paramInt != -3) && (paramInt != -4))
      {
        paramAppInterface = paramIntent;
        if (paramInt == -1)
        {
          paramAppInterface = paramIntent;
          if (paramIntent == null)
          {
            paramAppInterface = new Intent();
            paramAppInterface.putExtra("source", 104);
          }
        }
      }
      else
      {
        paramAppInterface = paramIntent;
        if (paramIntent == null)
        {
          paramAppInterface = new Intent();
          paramAppInterface.putExtra("source", 105);
        }
      }
      if (paramInt != -7)
      {
        if (paramInt != -6)
        {
          openPublicAccountProfile(paramAppInterface, paramContext, paramString);
          return;
        }
        if (BmqqSegmentUtil.a(paramContext, paramString)) {
          openBmqqProfile(paramAppInterface, paramContext, paramString);
        }
      }
      else
      {
        CrmUtils.a(paramContext, paramAppInterface, paramString, false, -1, true, -1);
      }
    }
  }
  
  public void gotoProfileForResult(Intent paramIntent, AppInterface paramAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoProfileForResult app: ");
      localStringBuilder.append(paramAppInterface);
      localStringBuilder.append(" | activity: ");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append(" | uin: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | accountFlag: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" | requestCode: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" | source: ");
      localStringBuilder.append(paramInt3);
      QLog.d("PublicAccountUtil", 2, localStringBuilder.toString());
    }
    if ((paramAppInterface != null) && (paramActivity != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramInt1 = getAccountType(paramAppInterface, paramString, paramInt1);
      if (paramInt1 != -7)
      {
        if (paramInt1 != -6)
        {
          openPublicAccountProfileForResult(paramIntent, paramAppInterface, paramActivity, paramString, paramInt2, paramInt3, paramBoolean);
          return;
        }
        if (BmqqSegmentUtil.a(paramActivity, paramString)) {
          openBmqqProfileForResult(paramIntent, paramActivity, paramString, paramInt2, paramInt3);
        }
      }
      else
      {
        CrmUtils.a(paramActivity, paramIntent, paramString, false, 5, true, paramInt2);
      }
    }
  }
  
  public boolean isComeFromReadInJoy()
  {
    return isComeFromReadInjoy;
  }
  
  public boolean isDeleteOldKandian(AppInterface paramAppInterface)
  {
    ??? = paramAppInterface.getApplication();
    boolean bool = false;
    SharedPreferences localSharedPreferences = ((MobileQQ)???).getSharedPreferences("mobileQQ", 0);
    synchronized (LOCK)
    {
      if (DELETE_OLDKANDIAN_FLAG == -1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(TAG_DELETE_OLDKANDIAN_FLAG);
        localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
        DELETE_OLDKANDIAN_FLAG = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
      }
      if (DELETE_OLDKANDIAN_FLAG != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean isFollowUin(AppInterface paramAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramAppInterface = paramAppInterface.getEntityManagerFactory(paramAppInterface.getAccount()).createEntityManager();
      if ((PublicAccountInfo)paramAppInterface.find(PublicAccountInfo.class, paramString) != null)
      {
        paramAppInterface.close();
        return true;
      }
      paramString = (PublicAccountDetailImpl)paramAppInterface.find(PublicAccountDetailImpl.class, paramString);
      paramAppInterface.close();
    }
    try
    {
      paramAppInterface = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      paramAppInterface.mergeFrom(paramString.accountData);
      int i = paramAppInterface.follow_type.get();
      bool1 = bool2;
      if (i == 1) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramAppInterface) {}
    return false;
  }
  
  public boolean isInterestAccount(AppInterface paramAppInterface, String paramString)
  {
    return getAccountType(paramAppInterface, paramString) == -2;
  }
  
  public boolean isInterestAccountOrUnSupportMsgType(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    return (paramInt == -2000) || (paramInt == -1000);
  }
  
  public boolean isKandianHost(String paramString)
  {
    return BasePublicAccountUtil.a(paramString);
  }
  
  public boolean isKandianNeedAddSkinParamsUrl(String paramString)
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
  
  public boolean isKandianUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null) {
        return isKandianHost(paramString.getHost());
      }
    }
    return false;
  }
  
  public boolean isMediaAndOtherSubscript(AppInterface paramAppInterface, String paramString)
  {
    int i = getAccountType(paramAppInterface, paramString);
    return (i == -3) || (i == -4);
  }
  
  public boolean isMsgTabStoryNodeListVisible()
  {
    Object localObject = BaseActivity.sTopActivity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (!(BaseActivity.sTopActivity instanceof SplashActivity)) {
        return false;
      }
      localObject = FrameHelperActivity.a(BaseActivity.sTopActivity);
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = (Conversation)((FrameHelperActivity)localObject).a(Conversation.class);
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((Conversation)localObject).M();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (((MsgTabStoryNodeListManager)localObject).getMode() != 1) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isPublicAccountUrl(String paramString)
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
  
  public boolean isQWalletPubAccount(Object paramObject)
  {
    if ((paramObject instanceof SessionInfo))
    {
      paramObject = (SessionInfo)paramObject;
      if (paramObject.b != null) {
        return "2711679534".equals(paramObject.b);
      }
    }
    return false;
  }
  
  public boolean isQZoneWithReadInJoyUrl(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (paramString.startsWith("https://www.urlshare.cn"))
      {
        String str = Uri.parse(paramString).getQueryParameter("url");
        paramString = str;
        if (!TextUtils.isEmpty(str)) {
          try
          {
            paramString = URLDecoder.decode(str);
          }
          catch (Exception localException)
          {
            paramString = str;
            if (QLog.isColorLevel())
            {
              QLog.e("PublicAccountUtil", 2, localException.toString());
              paramString = str;
            }
          }
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          bool1 = bool2;
          if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianUrl(paramString)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isSubscribeAccount(AppInterface paramAppInterface, String paramString)
  {
    int i = getAccountType(paramAppInterface, paramString);
    return (i == -3) || (i == -4) || (i == -2);
  }
  
  public boolean isSubscript(int paramInt, long paramLong)
  {
    paramInt = getAccountType(paramInt);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != -2)
    {
      bool1 = bool2;
      if (paramInt != -3)
      {
        if (paramInt == -4) {
          return true;
        }
        if (getAccountType2(paramLong) == -8L) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void modifyIntentForSpecificBrowserIfNeeded(Intent paramIntent, String paramString)
  {
    modifyIntentForSpecificBrowserIfNeeded(null, paramIntent, paramString);
  }
  
  public void modifyIntentForSpecificBrowserIfNeeded(MessageRecord paramMessageRecord, Intent paramIntent, String paramString)
  {
    if (paramMessageRecord != null) {}
    for (;;)
    {
      try
      {
        if (paramMessageRecord.istroop == 1)
        {
          paramIntent.putExtra("groupUin", paramMessageRecord.frienduin);
          Object localObject = (TroopManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
          if (localObject != null)
          {
            localObject = ((TroopManager)localObject).f(paramMessageRecord.frienduin);
            if (localObject != null) {
              paramIntent.putExtra("isAdmin", ((TroopInfo)localObject).isAdmin());
            }
          }
        }
        if (paramMessageRecord.istroop == 3000) {
          paramIntent.putExtra("dicussgroup_uin", paramMessageRecord.frienduin);
        }
        paramIntent.putExtra("friend_uin", paramMessageRecord.frienduin);
        paramIntent.putExtra("friendUin", paramMessageRecord.senderuin);
        paramIntent.putExtra("uinType", paramMessageRecord.istroop);
        paramIntent.putExtra("is_send", paramMessageRecord.isSend());
        paramIntent.putExtra("fromAio", true);
        paramMessageRecord = paramIntent.getComponent();
        if (paramMessageRecord != null)
        {
          if (TextUtils.isEmpty(paramString)) {
            return;
          }
          i = paramString.indexOf("?");
          if (i == -1) {
            return;
          }
          paramString = paramString.substring(i + 1).split("&");
          i = 0;
          if (i >= paramString.length) {
            break label368;
          }
          boolean bool = paramString[i].startsWith("_webviewtype=");
          if (bool)
          {
            paramString = paramString[i].split("=");
            if (paramString.length == 2)
            {
              bool = TextUtils.isEmpty(paramString[1]);
              if (bool) {}
            }
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        int i;
        paramMessageRecord.printStackTrace();
      }
      try
      {
        i = Integer.parseInt(paramString[1]);
        if (i != 0)
        {
          if (i != 1) {
            return;
          }
          paramIntent.setComponent(new ComponentName(paramMessageRecord.getPackageName(), CouponActivity.class.getName()));
        }
        return;
      }
      catch (NumberFormatException paramMessageRecord) {}
      if (paramString[i].startsWith("url="))
      {
        paramMessageRecord = paramString[i].split("=");
        if ((paramMessageRecord.length == 2) && (!TextUtils.isEmpty(paramMessageRecord[1]))) {
          modifyIntentForSpecificBrowserIfNeeded(paramIntent, URLDecoder.decode(paramMessageRecord[1]));
        }
        return;
      }
      i += 1;
      continue;
      return;
    }
    label368:
    return;
  }
  
  public void onPublicAccountArkMsgClick(AppInterface paramAppInterface, ChatMessage paramChatMessage)
  {
    if (paramAppInterface != null)
    {
      if (paramChatMessage == null) {
        return;
      }
      String str;
      if (paramChatMessage.mExJsonObject != null) {
        str = paramChatMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
      } else {
        str = "";
      }
      PublicAccountEventReport.a((QQAppInterface)paramAppInterface, paramChatMessage.senderuin, 0, 6, paramChatMessage.msgId, str);
    }
  }
  
  public void onRecentConversationPublicAccountFolderClick(AppInterface paramAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    paramRecentUser = new Intent();
    if (paramRecentBaseData != null) {
      paramRecentUser.putExtra("serviceUnReadNumber", paramRecentBaseData.mUnreadNum);
    }
    SubscribeLaucher.a(paramActivity, 9004, paramRecentUser);
    if (QLog.isColorLevel()) {
      QLog.d("RecentUtil", 2, "enterServiceAccountFolderActivityFromMsgTab");
    }
    if (paramRecentBaseData == null) {
      paramInt = -1;
    } else {
      paramInt = paramRecentBaseData.mPosition;
    }
    ThreadManager.executeOnSubThread(new PublicAccountUtilImpl.18(this, paramAppInterface, paramInt));
  }
  
  public void openPublicAccountProfile(Intent paramIntent, Context paramContext, String paramString)
  {
    if (paramIntent == null) {
      paramIntent = new Intent(paramContext, PublicAccountDetailActivityImpl.class);
    } else {
      paramIntent.setClassName(paramContext, PublicAccountDetailActivityImpl.class.getName());
    }
    paramIntent.putExtra("uin", paramString);
    paramIntent.addFlags(67108864);
    paramContext.startActivity(paramIntent);
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).overridePendingTransition(2130772009, 2130772010);
    }
  }
  
  public JSONObject parseString2Json(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (JSONException|NullPointerException|Exception paramString) {}
    return null;
  }
  
  public IPublicAccountDetail queryAccountDetail(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (PublicAccountDetailImpl)paramAppInterface.find(PublicAccountDetailImpl.class, paramString);
    paramAppInterface.close();
    return paramString;
  }
  
  public void removeLbsUin(AppInterface paramAppInterface, String paramString)
  {
    paramString = new UinPair(paramAppInterface.getCurrentAccountUin(), paramString);
    PublicAccountHandlerImpl localPublicAccountHandlerImpl = (PublicAccountHandlerImpl)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if ((localPublicAccountHandlerImpl.lbsUinList != null) && (localPublicAccountHandlerImpl.lbsUinList.contains(paramString))) {
      localPublicAccountHandlerImpl.lbsUinList.remove(paramString);
    }
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager();
    paramAppInterface.remove(paramString);
    paramAppInterface.close();
  }
  
  public void reportForPublicAccountExposure(String paramString)
  {
    ThreadManager.executeOnSubThread(new PublicAccountUtilImpl.17(this, paramString));
  }
  
  public void reportPAShareButtonEvent(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Uri localUri = Uri.parse(paramString);
    if (localUri != null)
    {
      String str = localUri.getHost();
      if ((!TextUtils.isEmpty(str)) && (("article.mp.qq.com".equalsIgnoreCase(str)) || ("post.mp.qq.com".equalsIgnoreCase(str)))) {
        ThreadManager.post(new PublicAccountUtilImpl.12(this, localUri, paramString), 5, null, false);
      }
    }
  }
  
  public void reportPAShareItemEvent(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Uri localUri = Uri.parse(paramString);
    if (localUri != null)
    {
      String str = localUri.getHost();
      if ((!TextUtils.isEmpty(str)) && (("article.mp.qq.com".equalsIgnoreCase(str)) || ("post.mp.qq.com".equalsIgnoreCase(str)))) {
        ThreadManager.post(new PublicAccountUtilImpl.13(this, localUri, paramInt2, paramInt1, paramString), 5, null, false);
      }
    }
  }
  
  public void reportPAShareItemEvent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(paramString2)) {
        i = Integer.parseInt(paramString2);
      } else {
        i = 0;
      }
    }
    catch (NumberFormatException paramString2)
    {
      int i;
      label30:
      String str;
      break label30;
    }
    i = 0;
    paramString2 = Uri.parse(paramString1);
    if (paramString2 != null)
    {
      str = paramString2.getHost();
      if ((!TextUtils.isEmpty(str)) && (("article.mp.qq.com".equalsIgnoreCase(str)) || ("post.mp.qq.com".equalsIgnoreCase(str)))) {
        ThreadManager.post(new PublicAccountUtilImpl.14(this, paramString2, i, paramString3, paramString4, paramInt, paramString1), 5, null, false);
      }
    }
  }
  
  public void resetDeleteOldKandian()
  {
    synchronized (LOCK)
    {
      DELETE_OLDKANDIAN_FLAG = -1;
      return;
    }
  }
  
  public void sendDetailInfoRequest(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    sendDetailInfoRequest(paramAppInterface, paramContext, paramString, -1);
  }
  
  public void setComeFromReadInJoy(boolean paramBoolean)
  {
    isComeFromReadInjoy = paramBoolean;
  }
  
  public void setLSAccountDetailRequestHandler(Handler paramHandler)
  {
    if (paramHandler != null) {}
    try
    {
      qqLsHandler = new WeakReference(paramHandler);
      break label25;
      qqLsHandler = null;
      label25:
      return;
    }
    finally {}
  }
  
  public boolean shouldPreloadWebProcess(String paramString)
  {
    return ("3046055438".equals(paramString)) || ("3026775809".equals(paramString)) || ("2711679534".equals(paramString));
  }
  
  public boolean shouldUseWebviewSwitchFunction()
  {
    return false;
  }
  
  public boolean showPubAccUin(AppInterface paramAppInterface)
  {
    return false;
  }
  
  public void unfollowUin(AppInterface paramAppInterface, Context paramContext, String paramString, boolean paramBoolean, IPublicAccountObserver paramIPublicAccountObserver)
  {
    unfollowUin(paramAppInterface, paramContext, paramString, paramBoolean, paramIPublicAccountObserver, false);
  }
  
  public void unfollowUin(AppInterface paramAppInterface, Context paramContext, String paramString, boolean paramBoolean1, IPublicAccountObserver paramIPublicAccountObserver, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface;
    BaseApplication localBaseApplication;
    Object localObject1;
    Object localObject2;
    if (((paramAppInterface instanceof QQAppInterface)) && (paramContext != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localQQAppInterface = (QQAppInterface)paramAppInterface;
      localBaseApplication = BaseApplicationImpl.getContext();
      paramAppInterface = (IPublicAccountDataManager)localQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      localObject1 = null;
      if (paramAppInterface != null)
      {
        localObject2 = (PublicAccountDetailImpl)paramAppInterface.findAccountDetailInfo(paramString);
        paramAppInterface = (PublicAccountInfo)paramAppInterface.findPublicAccountInfo(paramString);
        paramAppInterface = (AppInterface)localObject1;
        paramContext = (Context)localObject2;
        if (localObject2 == null)
        {
          EqqDetailDataManager localEqqDetailDataManager = (EqqDetailDataManager)localQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
          paramAppInterface = (AppInterface)localObject1;
          paramContext = (Context)localObject2;
          if (localEqqDetailDataManager != null)
          {
            paramAppInterface = localEqqDetailDataManager.a(paramString);
            paramContext = (Context)localObject2;
          }
        }
      }
      else
      {
        paramContext = null;
        paramAppInterface = (AppInterface)localObject1;
      }
      boolean bool;
      if ((!paramBoolean2) && (paramContext != null) && (getAccountType(paramContext.accountFlag) == -4)) {
        bool = false;
      } else {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unFollowUin() uin: ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("  useNewProtocol: ");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("PublicAccountUtil", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!paramBoolean2) && (paramContext != null) && (getAccountType(paramContext.accountFlag) == -4))
      {
        localObject1 = new NewIntent(localQQAppInterface.getApp().getApplicationContext(), PublicAccountServletImpl.class);
        ((NewIntent)localObject1).putExtra("cmd", "unfollow");
        localObject2 = new mobileqq_mp.UnFollowRequest();
      }
    }
    try
    {
      ((mobileqq_mp.UnFollowRequest)localObject2).uin.set((int)Long.parseLong(paramString));
      if (paramAppInterface != null) {
        paramAppInterface = paramContext;
      }
      paramAppInterface = new PublicAccountUtilImpl.6(this, paramIPublicAccountObserver, paramString, paramBoolean1, localBaseApplication, paramAppInterface, localQQAppInterface);
      ((NewIntent)localObject1).putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(paramAppInterface);
      localQQAppInterface.startServlet((NewIntent)localObject1);
      return;
    }
    catch (NumberFormatException paramAppInterface)
    {
      label354:
      break label354;
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("Unfollow Request got wrong uin:");
      paramAppInterface.append(paramString);
      QLog.w("PublicAccountUtil", 2, paramAppInterface.toString());
    }
    return;
    if (paramAppInterface == null) {
      paramContext = paramAppInterface;
    }
    paramAppInterface = new NewPublicAccountObserver(new PublicAccountUtilImpl.7(this, paramContext, localQQAppInterface, paramString, paramIPublicAccountObserver, paramBoolean1, localBaseApplication), localQQAppInterface);
    paramAppInterface.a(localQQAppInterface);
    localQQAppInterface.removeObserver(paramAppInterface);
    localQQAppInterface.addObserver(paramAppInterface);
    PublicAccountStateReporter.a(localQQAppInterface, false, paramString, 0);
  }
  
  public void updateDeleteOldKandian(AppInterface paramAppInterface, boolean paramBoolean)
  {
    Object localObject2 = paramAppInterface.getApplication().getSharedPreferences("mobileQQ", 0);
    for (;;)
    {
      int i;
      synchronized (LOCK)
      {
        StringBuilder localStringBuilder;
        if (DELETE_OLDKANDIAN_FLAG == -1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(TAG_DELETE_OLDKANDIAN_FLAG);
          localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
          DELETE_OLDKANDIAN_FLAG = ((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), 0);
        }
        int j = DELETE_OLDKANDIAN_FLAG;
        i = 1;
        if (j == 0)
        {
          bool = true;
          break label345;
          DELETE_OLDKANDIAN_FLAG = i;
          localObject2 = ((SharedPreferences)localObject2).edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(TAG_DELETE_OLDKANDIAN_FLAG);
          localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
          ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), DELETE_OLDKANDIAN_FLAG).commit();
          if ((bool) && (paramBoolean))
          {
            ??? = ((QQAppInterface)paramAppInterface).getProxyManager().g();
            if (??? != null)
            {
              localObject2 = ((RecentUserProxy)???).c(AppConstants.OLD_KANDIAN_UIN, 1008);
              if (localObject2 != null)
              {
                ((RecentUserProxy)???).a((RecentUser)localObject2);
                ??? = paramAppInterface.getHandler(Conversation.class);
                if (??? != null) {
                  ((MqqHandler)???).sendEmptyMessage(1009);
                }
              }
            }
            ??? = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (??? != null)
            {
              ((IPublicAccountDataManager)???).delPublicAccountInfoCache(AppConstants.OLD_KANDIAN_UIN);
              paramAppInterface = paramAppInterface.getHandler(PublicAccountFragment.class);
              if (paramAppInterface != null) {
                paramAppInterface.sendEmptyMessage(0);
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("updateDeleteOldKandian notDeleteState = ");
            paramAppInterface.append(bool);
            paramAppInterface.append(", isDelete = ");
            paramAppInterface.append(paramBoolean);
            QLog.i("PublicAccountUtil", 2, paramAppInterface.toString());
          }
          return;
        }
      }
      boolean bool = false;
      label345:
      if (!paramBoolean) {
        i = 0;
      }
    }
  }
  
  public void videoPlayRealtimeReport(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("videoPlayRealtimeReport aid=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", vid=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", rtype=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", rcode=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("PublicAccountUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof AppInterface)))
      {
        doVideoPlayRealtimeReport(paramString1, paramString2, paramInt1, paramInt2);
        return;
      }
      localObject = new Intent("readInJoy_video_play_real_time_report");
      ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_AID", paramString1);
      ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_VID", paramString2);
      ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RTYPE", paramInt1);
      ((Intent)localObject).putExtra("VIDEO_REALTIME_REPORT_RCODE", paramInt2);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl
 * JD-Core Version:    0.7.0.1
 */