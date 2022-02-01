package com.tencent.biz.qqstory.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.GetUserIconHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqSubscription;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetInfoCard;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetSearchFeedList;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspReport;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspSubscription;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetForbiddenStates;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeWatched;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqSetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqVideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspForbidStory;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetForbiddenList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetForbiddenStates;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspSetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspVideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.PicSpecs;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfoExt;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSourceTagInfo;
import com.tencent.biz.qqstory.notification.StoryMsgNotification;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.VideoSourceTagInfoHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0xcc.SubMsgType0xcc.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xd0.SubMsgType0xd0.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xda.SubMsgType0xda.MsgBody;

public class QQStoryHandler
  extends BusinessHandler
{
  public static final String a;
  public static final String b = StoryApi.a("StorySvc.video_config_set");
  public static final String c = StoryApi.a("StorySvc.video_get_user_mask_list");
  public static final String d = StoryApi.a("StorySvc.video_set_user_mask");
  public static final String e = StoryApi.a("StorySvc.video_get_user_mask_states");
  public static final String f = StoryApi.a("StorySvc.video_show_video_list");
  public static final String g = StoryApi.a("StorySvc.get_official_recommend");
  public static final String h = StoryApi.a("StorySvc.pgc_subscribe_operation");
  public static final String i = StoryApi.a("StorySvc.pgc_person_page");
  public static final String j = StoryApi.a("StorySvc.pgc_search_feedlist_get");
  public static final String k = StoryApi.a("StorySvc.pgc_client_report");
  public static final String l = StoryApi.a("StorySvc.video_aio_sync_publish");
  public static final String m = StoryApi.a("StorySvc.get_video_reader_config");
  public static final String n = StoryApi.a("StorySvc.msgtab_node_feedback");
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.video_config_get");
  }
  
  public QQStoryHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static boolean a(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof byte[])) && (((byte[])paramObject).length > 0);
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1;
    if (paramObject != null)
    {
      paramToServiceMsg = new qqstory_service.RspSetConfig();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        int i2 = paramToServiceMsg.result.error_code.get();
        i1 = 1;
        if (i2 == 0)
        {
          notifyUI(1004, true, null);
          notifyUI(1019, true, null);
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
    else
    {
      i1 = 0;
    }
    if (i1 == 0)
    {
      notifyUI(1004, false, null);
      notifyUI(1019, false, null);
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    SLog.b("QQStoryHandler", "handleGetForbidList");
    boolean bool2;
    int i2;
    Object localObject;
    if (paramObject != null)
    {
      bool2 = paramToServiceMsg.extraData.getBoolean("isNotAllowed");
      i2 = paramToServiceMsg.extraData.getInt("count");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("tag");
      localObject = new qqstory_service.RspGetForbiddenList();
    }
    for (;;)
    {
      int i1;
      try
      {
        ((qqstory_service.RspGetForbiddenList)localObject).mergeFrom((byte[])paramObject);
        int i3 = ((qqstory_service.RspGetForbiddenList)localObject).result.error_code.get();
        i1 = 1;
        if (i3 == 0)
        {
          if (((qqstory_service.RspGetForbiddenList)localObject).is_end.get() == 0) {
            break label348;
          }
          bool1 = true;
          paramFromServiceMsg = ((qqstory_service.RspGetForbiddenList)localObject).next_cookie.get().toByteArray();
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.length == 0)) {
            break label354;
          }
          localObject = ((qqstory_service.RspGetForbiddenList)localObject).user_list.get();
          if (((List)localObject).size() < i2) {
            bool1 = true;
          }
          paramObject = new ArrayList();
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            qqstory_struct.UserInfo localUserInfo = (qqstory_struct.UserInfo)((Iterator)localObject).next();
            QQStoryUserInfo localQQStoryUserInfo = new QQStoryUserInfo();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localUserInfo.uid.get());
            localStringBuilder.append("");
            localQQStoryUserInfo.uin = localStringBuilder.toString();
            localQQStoryUserInfo.setNick(ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localQQStoryUserInfo.uin));
            if (bool2) {
              localQQStoryUserInfo.isAllowed = 1;
            } else {
              localQQStoryUserInfo.isInterested = 1;
            }
            paramObject.add(localQQStoryUserInfo);
            continue;
          }
          notifyUI(1001, true, new Object[] { paramObject, paramFromServiceMsg, Boolean.valueOf(bool1), paramToServiceMsg });
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        i1 = 0;
      }
      if (i1 == 0) {
        notifyUI(1001, false, null);
      }
      return;
      label348:
      boolean bool1 = false;
      continue;
      label354:
      bool1 = true;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("reqUin");
    QQStoryManager localQQStoryManager;
    if (paramObject != null)
    {
      localQQStoryManager = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
      paramToServiceMsg = new qqstory_service.RspGetForbiddenStates();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label54:
      int i2;
      int i1;
      break label54;
    }
    paramToServiceMsg = null;
    i2 = 0;
    i1 = i2;
    if (paramToServiceMsg != null)
    {
      i1 = i2;
      if (paramToServiceMsg.result.error_code.get() == 0)
      {
        paramFromServiceMsg = localQQStoryManager.a(str);
        paramToServiceMsg = paramToServiceMsg.user_list.get();
        i1 = i2;
        if (paramToServiceMsg.size() > 0)
        {
          paramToServiceMsg = (qqstory_struct.UserInfo)paramToServiceMsg.get(0);
          i1 = paramToServiceMsg.ext.his_story_forbidden.get();
          i2 = paramToServiceMsg.ext.my_story_forbidden.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new QQStoryUserInfo();
            paramToServiceMsg.uin = str;
            paramToServiceMsg.setNick(ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
            localQQStoryManager.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramToServiceMsg);
          }
          paramToServiceMsg.isAllowed = i2;
          paramToServiceMsg.isInterested = i1;
          if (paramToServiceMsg.getStatus() == 1000) {
            localQQStoryManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist(paramToServiceMsg);
          } else {
            localQQStoryManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramToServiceMsg);
          }
          notifyUI(1005, true, paramToServiceMsg);
          i1 = 1;
        }
      }
    }
    if (i1 == 0) {
      notifyUI(1005, true, null);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    if (paramObject != null) {
      try
      {
        paramToServiceMsg = new qqstory_service.RspGetUserVideoList();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = (qqstory_struct.ErrorInfo)paramToServiceMsg.result.get();
        paramFromServiceMsg = paramToServiceMsg.video_list.get();
        paramToServiceMsg = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext()) {
          paramToServiceMsg.add(((qqstory_struct.StoryVideoDes)paramFromServiceMsg.next()).video_cover.get().toStringUtf8());
        }
        notifyUI(1006, true, paramToServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      notifyUI(1006, false, null);
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i6 = 1;
    int i5 = 1;
    int i4;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null)) {
      i4 = 0;
    } else {
      i4 = 1;
    }
    long l1;
    if (paramToServiceMsg == null) {
      l1 = -1L;
    } else {
      l1 = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("extra_start_time");
    }
    int i1;
    if (paramFromServiceMsg == null) {
      i1 = -1;
    } else {
      i1 = paramFromServiceMsg.getBusinessFailCode();
    }
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = "local data";
    } else {
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    }
    int i3 = i1;
    Object localObject = paramToServiceMsg;
    int i2;
    if (a(paramObject))
    {
      i2 = i1;
      paramFromServiceMsg = paramToServiceMsg;
    }
    for (;;)
    {
      try
      {
        qqstory_pgc.RspGetInfoCard localRspGetInfoCard = new qqstory_pgc.RspGetInfoCard();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        localRspGetInfoCard.mergeFrom((byte[])paramObject);
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramObject = (qqstory_pgc.ErrorInfo)localRspGetInfoCard.result.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        i1 = paramObject.error_code.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject.error_desc.get().toStringUtf8();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        i3 = paramObject.error_code.get();
        if (i3 == 0)
        {
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          if (localRspGetInfoCard.user.has())
          {
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject = UserInfo.convertFrom((qqstory_pgc.UserInfo)localRspGetInfoCard.user.get());
            if (paramObject != null)
            {
              i2 = i1;
              paramFromServiceMsg = paramToServiceMsg;
              if (paramObject.checkData()) {
                break label680;
              }
            }
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject = new StringBuilder();
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append("QQStoryHandler handleGetPGCUserInfoCard user=");
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append(null);
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            QQStoryManager.c(paramObject.toString());
            paramObject = null;
            i2 = 1;
            if (i2 != 0)
            {
              i2 = i1;
              paramFromServiceMsg = paramToServiceMsg;
              StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { i });
            }
            else
            {
              i2 = i1;
              paramFromServiceMsg = paramToServiceMsg;
              StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { i });
            }
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            notifyUI(1009, true, paramObject);
            i2 = i6;
            i3 = i1;
            localObject = paramToServiceMsg;
            try
            {
              if (!QLog.isColorLevel()) {
                break label647;
              }
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("QQStoryHandler handleGetPGCUserInfoCard isSuccess=");
              paramFromServiceMsg.append(true);
              paramFromServiceMsg.append(" user:");
              paramFromServiceMsg.append(paramObject);
              QLog.d("Q.qqstory.protocol", 2, paramFromServiceMsg.toString());
              i2 = i6;
              i3 = i1;
              localObject = paramToServiceMsg;
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
            {
              i2 = i5;
              continue;
            }
          }
        }
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        i3 = i1;
        localObject = paramToServiceMsg;
        if (QLog.isColorLevel())
        {
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          localObject = new StringBuilder();
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          ((StringBuilder)localObject).append("QQStoryHandler handleGetPGCUserInfoCard error_code=");
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          ((StringBuilder)localObject).append(paramObject.error_code.get());
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          ((StringBuilder)localObject).append(" user:");
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          ((StringBuilder)localObject).append(localRspGetInfoCard.user.get());
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          QLog.d("Q.qqstory.protocol", 2, ((StringBuilder)localObject).toString());
          i3 = i1;
          localObject = paramToServiceMsg;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        i3 = 0;
        paramToServiceMsg = paramFromServiceMsg;
        i1 = i2;
        i2 = i3;
        paramFromServiceMsg = paramObject;
        paramFromServiceMsg.printStackTrace();
        i3 = i1;
        localObject = paramToServiceMsg;
        break label647;
      }
      i2 = 0;
      label647:
      if (i2 == 0) {
        notifyUI(1009, false, null);
      }
      if (i4 == 0) {
        a(i, l1, i3, (String)localObject);
      }
      return;
      label680:
      i2 = 0;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i7 = 1;
    int i6 = 1;
    int i4;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null)) {
      i4 = 0;
    } else {
      i4 = 1;
    }
    long l1;
    if (paramToServiceMsg == null) {
      l1 = -1L;
    } else {
      l1 = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("extra_start_time");
    }
    int i1;
    if (paramFromServiceMsg == null) {
      i1 = -1;
    } else {
      i1 = paramFromServiceMsg.getBusinessFailCode();
    }
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = "local data";
    } else {
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    }
    int i3 = i1;
    Object localObject1 = paramToServiceMsg;
    int i2;
    if (a(paramObject))
    {
      i2 = i1;
      paramFromServiceMsg = paramToServiceMsg;
    }
    for (;;)
    {
      boolean bool;
      try
      {
        localObject1 = new qqstory_pgc.RspGetSearchFeedList();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        ((qqstory_pgc.RspGetSearchFeedList)localObject1).mergeFrom((byte[])paramObject);
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramObject = (qqstory_pgc.ErrorInfo)((qqstory_pgc.RspGetSearchFeedList)localObject1).result.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        i1 = paramObject.error_code.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject.error_desc.get().toStringUtf8();
        if (i1 == 0)
        {
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          if (!((qqstory_pgc.RspGetSearchFeedList)localObject1).result_type.has()) {
            break label976;
          }
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          i3 = ((qqstory_pgc.RspGetSearchFeedList)localObject1).result_type.get();
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          paramObject = ((qqstory_pgc.RspGetSearchFeedList)localObject1).feed_list.get();
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          ArrayList localArrayList = new ArrayList();
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          paramObject = paramObject.iterator();
          int i5 = 0;
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          if (paramObject.hasNext())
          {
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            localObject2 = UserInfo.convertFrom((qqstory_pgc.UserInfo)paramObject.next());
            if (localObject2 != null)
            {
              i2 = i1;
              paramFromServiceMsg = paramToServiceMsg;
              if (((UserInfo)localObject2).checkData())
              {
                i2 = i1;
                paramFromServiceMsg = paramToServiceMsg;
                localArrayList.add(localObject2);
                continue;
              }
            }
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            StringBuilder localStringBuilder = new StringBuilder();
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            localStringBuilder.append("QQStoryHandler handleGetPGCSearchFeedList user=");
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            localStringBuilder.append(localObject2);
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            QQStoryManager.c(localStringBuilder.toString());
            i5 = 1;
            continue;
          }
          if (i5 != 0)
          {
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            StoryReportor.b("story_check", "pgc_check", 0, 1, new String[] { j });
          }
          else
          {
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            StoryReportor.b("story_check", "pgc_check", 0, 0, new String[] { j });
          }
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          if (!((qqstory_pgc.RspGetSearchFeedList)localObject1).is_end.has()) {
            break label982;
          }
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          i5 = ((qqstory_pgc.RspGetSearchFeedList)localObject1).is_end.get();
          i2 = i5;
          break label985;
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          if (!((qqstory_pgc.RspGetSearchFeedList)localObject1).next_cookie.has()) {
            break label1003;
          }
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          paramObject = ((qqstory_pgc.RspGetSearchFeedList)localObject1).next_cookie.get().toStringUtf8();
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          Object localObject2 = new ArrayList();
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          if (((qqstory_pgc.RspGetSearchFeedList)localObject1).key_word_list.has())
          {
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            localObject1 = ((qqstory_pgc.RspGetSearchFeedList)localObject1).key_word_list.get().iterator();
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            if (((Iterator)localObject1).hasNext())
            {
              i2 = i1;
              paramFromServiceMsg = paramToServiceMsg;
              ((List)localObject2).add(((ByteStringMicro)((Iterator)localObject1).next()).toStringUtf8());
              continue;
            }
          }
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          notifyUI(1010, true, new Object[] { Integer.valueOf(i3), localArrayList, Boolean.valueOf(bool), paramObject, localObject2 });
          i2 = i7;
          i3 = i1;
          localObject1 = paramToServiceMsg;
          try
          {
            if (!QLog.isColorLevel()) {
              break label943;
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("QQStoryHandler handleGetPGCSearchFeedList isSuccess=");
            paramFromServiceMsg.append(true);
            paramFromServiceMsg.append(" userInfoList:");
            paramFromServiceMsg.append(localArrayList);
            paramFromServiceMsg.append(" isEnd:");
            paramFromServiceMsg.append(bool);
            paramFromServiceMsg.append(" nextCookie:");
            paramFromServiceMsg.append(paramObject);
            QLog.d("Q.qqstory.protocol", 2, paramFromServiceMsg.toString());
            i2 = i7;
            i3 = i1;
            localObject1 = paramToServiceMsg;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            i2 = i6;
            continue;
          }
        }
        else
        {
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          i3 = i1;
          localObject1 = paramToServiceMsg;
          if (!QLog.isColorLevel()) {
            break label940;
          }
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          localObject1 = new StringBuilder();
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          ((StringBuilder)localObject1).append("QQStoryHandler handleGetPGCSearchFeedList error_code=");
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          ((StringBuilder)localObject1).append(paramObject.error_code.get());
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          QLog.d("Q.qqstory.protocol", 2, ((StringBuilder)localObject1).toString());
          i3 = i1;
          localObject1 = paramToServiceMsg;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        i3 = 0;
        paramToServiceMsg = paramFromServiceMsg;
        i1 = i2;
        i2 = i3;
        paramFromServiceMsg = paramObject;
        paramFromServiceMsg.printStackTrace();
        i3 = i1;
        localObject1 = paramToServiceMsg;
        break label943;
      }
      label940:
      i2 = 0;
      label943:
      if (i2 == 0) {
        notifyUI(1010, false, null);
      }
      if (i4 == 0) {
        a(j, l1, i3, (String)localObject1);
      }
      return;
      label976:
      i3 = 2;
      continue;
      label982:
      i2 = 0;
      label985:
      if (i2 == 1)
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        label1003:
        paramObject = null;
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1;
    if (paramToServiceMsg == null) {
      i1 = 0;
    } else {
      i1 = paramToServiceMsg.extraData.getInt("userType", 0);
    }
    if (paramToServiceMsg == null) {
      localObject = null;
    } else {
      localObject = paramToServiceMsg.extraData.getString("unionId");
    }
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(i1);
    int i6 = 1;
    int i5 = 1;
    arrayOfObject[1] = localObject;
    int i4;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null)) {
      i4 = 0;
    } else {
      i4 = 1;
    }
    long l1;
    if (paramToServiceMsg == null) {
      l1 = -1L;
    } else {
      l1 = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("extra_start_time");
    }
    if (paramFromServiceMsg == null) {
      i1 = -1;
    } else {
      i1 = paramFromServiceMsg.getBusinessFailCode();
    }
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = "local data";
    } else {
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    }
    int i3 = i1;
    Object localObject = paramToServiceMsg;
    int i2;
    if (a(paramObject))
    {
      i2 = i1;
      paramFromServiceMsg = paramToServiceMsg;
    }
    for (;;)
    {
      try
      {
        localObject = new qqstory_pgc.RspSubscription();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        ((qqstory_pgc.RspSubscription)localObject).mergeFrom((byte[])paramObject);
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramObject = (qqstory_pgc.ErrorInfo)((qqstory_pgc.RspSubscription)localObject).result.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        i1 = paramObject.error_code.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject.error_desc.get().toStringUtf8();
        if (i1 == 0)
        {
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          if (((qqstory_pgc.RspSubscription)localObject).is_subscribe.get() != 1) {
            break label565;
          }
          bool = true;
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          arrayOfObject[2] = Boolean.valueOf(bool);
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          notifyUI(1011, true, arrayOfObject);
          i2 = i6;
          i3 = i1;
          localObject = paramToServiceMsg;
          try
          {
            if (!QLog.isColorLevel()) {
              break label526;
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("QQStoryHandler handleEditPGCSubscribeStatus isSuccess=");
            paramFromServiceMsg.append(true);
            paramFromServiceMsg.append(" isSubscribe:");
            paramFromServiceMsg.append(bool);
            QLog.d("Q.qqstory.protocol", 2, paramFromServiceMsg.toString());
            i2 = i6;
            i3 = i1;
            localObject = paramToServiceMsg;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            i2 = i5;
            continue;
          }
        }
        else
        {
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          i3 = i1;
          localObject = paramToServiceMsg;
          if (!QLog.isColorLevel()) {
            break label523;
          }
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          localObject = new StringBuilder();
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          ((StringBuilder)localObject).append("QQStoryHandler handleEditPGCSubscribeStatus error_code=");
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          ((StringBuilder)localObject).append(paramObject.error_code.get());
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          QLog.d("Q.qqstory.protocol", 2, ((StringBuilder)localObject).toString());
          i3 = i1;
          localObject = paramToServiceMsg;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        i3 = 0;
        paramToServiceMsg = paramFromServiceMsg;
        i1 = i2;
        i2 = i3;
        paramFromServiceMsg = paramObject;
        paramFromServiceMsg.printStackTrace();
        i3 = i1;
        localObject = paramToServiceMsg;
        break label526;
      }
      label523:
      i2 = 0;
      label526:
      if (i2 == 0)
      {
        arrayOfObject[2] = null;
        notifyUI(1011, false, arrayOfObject);
      }
      if (i4 == 0) {
        a(h, l1, i3, (String)localObject);
      }
      return;
      label565:
      boolean bool = false;
    }
  }
  
  public byte a(FromServiceMsg paramFromServiceMsg, int paramInt, String paramString)
  {
    int i1 = 0;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        int i2 = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" handleGetTlvRsp ret=");
          ((StringBuilder)localObject).append(i2);
          QLog.i("QQStoryHandler", 2, ((StringBuilder)localObject).toString());
        }
        if ((i2 == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
          int i5 = paramFromServiceMsg.length;
          if (4 <= i5)
          {
            localObject = String.valueOf(PkgTools.getLongData(paramFromServiceMsg, 0));
            if ((localObject == null) || (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
            {
              if (QLog.isColorLevel()) {
                QLog.i("QQStoryHandler", 2, "handleGetTlvRsp uin error");
              }
              return -1;
            }
          }
          if (5 <= i5) {
            i1 = paramFromServiceMsg[4];
          }
          if (7 <= i5) {
            i1 = PkgTools.getShortData(paramFromServiceMsg, 5);
          } else {
            i1 = 0;
          }
          i2 = 0;
          b1 = 0;
          int i4;
          for (int i3 = 7; i2 < i1; i3 = i4)
          {
            byte b2 = b1;
            i4 = i3;
            if (i3 + 4 <= i5)
            {
              i4 = PkgTools.getShortData(paramFromServiceMsg, i3);
              int i6 = i3 + 2;
              i3 = PkgTools.getShortData(paramFromServiceMsg, i6);
              i6 += 2;
              b2 = b1;
              if ((i4 & 0xFFFF) == paramInt)
              {
                if (i3 == 0) {
                  b1 = 0;
                } else {
                  b1 = (byte)PkgTools.getShortData(paramFromServiceMsg, i6);
                }
                b2 = b1;
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(paramString);
                  ((StringBuilder)localObject).append(" handleGetTlvRsp value=");
                  ((StringBuilder)localObject).append(b1);
                  QLog.w("QQStoryHandler", 2, ((StringBuilder)localObject).toString());
                  b2 = b1;
                }
              }
              i4 = i6 + i3;
            }
            i2 += 1;
            b1 = b2;
          }
          paramInt = 1;
          break label436;
        }
      }
    }
    byte b1 = 0;
    paramInt = i1;
    label436:
    if (paramInt == 0) {
      return -1;
    }
    return b1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.protocol", 2, "getQQStoryConfig");
    }
    qqstory_service.ReqGetConfig localReqGetConfig = new qqstory_service.ReqGetConfig();
    Object localObject = (StoryConfigManager)SuperManager.a(10);
    long l2 = ((StoryConfigManager)localObject).c();
    long l1 = ((StoryConfigManager)localObject).d();
    long l3 = TimeUnit.DAYS.toMillis(1L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("lastGetConfigTime ");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    SLog.b("Q.qqstory.protocol", ((StringBuilder)localObject).toString());
    if (Math.abs(System.currentTimeMillis() - l2) > l3) {
      localReqGetConfig.get_pic_specs.set(1);
    }
    l2 = TimeUnit.DAYS.toMillis(1L);
    if (Math.abs(System.currentTimeMillis() - l1) > l2) {
      localReqGetConfig.get_video_tag_info.set(1);
    }
    localObject = createToServiceMsg(jdField_a_of_type_JavaLangString);
    ((ToServiceMsg)localObject).putWupBuffer(localReqGetConfig.toByteArray());
    a((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setNowTabIsOpen value=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("QQStoryHandler", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      short s = (short)paramInt;
      Object localObject2 = new byte[19];
      PkgTools.dWord2Byte((byte[])localObject2, 0, l1);
      localObject2[4] = 0;
      PkgTools.word2Byte((byte[])localObject2, 5, (short)2);
      PkgTools.dWordTo2Bytes((byte[])localObject2, 7, 42060);
      PkgTools.word2Byte((byte[])localObject2, 9, (short)2);
      PkgTools.word2Byte((byte[])localObject2, 11, s);
      PkgTools.dWordTo2Bytes((byte[])localObject2, 13, 40319);
      PkgTools.word2Byte((byte[])localObject2, 15, (short)2);
      PkgTools.word2Byte((byte[])localObject2, 17, (short)1);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject2));
      localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromQQStoryHandler", true);
      a((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryHandler", 2, "setNowTabIsOpen ex", localException);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("value=");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.i("QQStoryHandler", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      short s = (short)paramInt1;
      localObject2 = new byte[13];
      PkgTools.dWord2Byte((byte[])localObject2, 0, l1);
      localObject2[4] = 0;
      PkgTools.word2Byte((byte[])localObject2, 5, (short)1);
      PkgTools.dWordTo2Bytes((byte[])localObject2, 7, paramInt2);
      PkgTools.word2Byte((byte[])localObject2, 9, (short)2);
      PkgTools.word2Byte((byte[])localObject2, 11, s);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject2));
      localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      ((ToServiceMsg)localObject2).extraData.putBoolean(paramString, true);
      a((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" exception=");
        QLog.i("QQStoryHandler", 2, ((StringBuilder)localObject2).toString(), localException);
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = new qqstory_pgc.ReqSubscription();
    ((qqstory_pgc.ReqSubscription)localObject).type.set(paramInt1, true);
    if (!TextUtils.isEmpty(paramString)) {
      ((qqstory_pgc.ReqSubscription)localObject).union_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    }
    ((qqstory_pgc.ReqSubscription)localObject).operation.set(paramInt2, true);
    ((qqstory_pgc.ReqSubscription)localObject).from.set(paramInt3, true);
    ToServiceMsg localToServiceMsg = createToServiceMsg(h);
    localToServiceMsg.extraData.putInt("userType", paramInt1);
    localToServiceMsg.extraData.putString("unionId", paramString);
    localToServiceMsg.putWupBuffer(((qqstory_pgc.ReqSubscription)localObject).toByteArray());
    a(localToServiceMsg);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQStoryHandler editPGCSubscribeStatus type=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" unionId=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" operation=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.qqstory.protocol", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if (paramStoryPushMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.protocol", 2, "onRecvStoryPush pushMsg nullException---------------");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvStoryPush pushMsg: ");
      localStringBuilder.append(paramStoryPushMsg);
      QLog.w("Q.qqstory.protocol", 2, localStringBuilder.toString());
    }
    if ((paramStoryPushMsg.jdField_a_of_type_Int != 1) && (paramStoryPushMsg.jdField_a_of_type_Int != 2))
    {
      notifyUI(1012, true, paramStoryPushMsg);
      StoryMsgNotification.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramStoryPushMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "6.6.0 comment and like, ignore, only accept 7.1.0 comment and like");
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    byte b1 = a(paramFromServiceMsg, 42083, "reqUserGetMsgTabOpen");
    notifyUI(1024, true, Byte.valueOf(b1));
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleMsgTabStoryIsOpen, msgTabStoryIsOpenTlvValue:");
      paramFromServiceMsg.append(b1);
      QLog.i("QQStoryHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramFromServiceMsg, paramObject, "reqUserSetMsgTabOpen");
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = paramObject;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        int i1 = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append(paramString);
          paramObject.append(" handleSetTlvRsp result");
          paramObject.append(i1);
          QLog.i("QQStoryHandler", 2, paramObject.toString());
        }
        if (i1 == 0)
        {
          if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(PkgTools.getLongData(paramFromServiceMsg, 0));
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
              {
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append(paramString);
                paramFromServiceMsg.append("uin error");
                QLog.i("QQStoryHandler", 1, paramFromServiceMsg.toString());
              }
            }
          }
        }
        else
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(paramString);
          paramFromServiceMsg.append(" handleSetTlvRsp result");
          paramFromServiceMsg.append(i1);
          QLog.w("QQStoryHandler", 1, paramFromServiceMsg.toString());
          StoryReportor.b("handleSetTlvRsp", paramString, 0, i1, new String[] { "" });
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.protocol", 2, "sendPbRequest. request is null.");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPbRequest. cmd=");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      QLog.d("Q.qqstory.protocol", 2, localStringBuilder.toString());
    }
    paramToServiceMsg.extraData.putLong("extra_start_time", System.currentTimeMillis());
    super.sendPbReq(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramToServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        i1 = -1;
        if (paramFromServiceMsg.uint32_result.has()) {
          i1 = paramFromServiceMsg.uint32_result.get();
        }
        if (i1 == 0)
        {
          long l1 = paramToServiceMsg.getInt();
          paramToServiceMsg.get();
          int i2 = paramToServiceMsg.getShort();
          if (!QLog.isColorLevel()) {
            break label484;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleNowTabIsOpen, request success, tlvCount = ");
          paramFromServiceMsg.append(i2);
          paramFromServiceMsg.append(" uin:");
          paramFromServiceMsg.append(Long.valueOf(l1));
          QLog.d("Q.qqstory.fourTab", 2, paramFromServiceMsg.toString());
          break label484;
          if ((paramToServiceMsg.hasRemaining()) && (i1 < i2))
          {
            int i3 = paramToServiceMsg.getShort();
            int i4 = paramToServiceMsg.getShort();
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("handleNowTabIsOpen, TLV type: ");
              paramFromServiceMsg.append(i3);
              paramFromServiceMsg.append(",legnth: ");
              paramFromServiceMsg.append(i4);
              QLog.d("Q.qqstory.fourTab", 2, paramFromServiceMsg.toString());
            }
            if (i3 == -23476)
            {
              i1 = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramToServiceMsg = new StringBuilder();
                paramToServiceMsg.append("handleNowTabIsOpen nowTabOpenStatus is :");
                paramToServiceMsg.append(i1);
                QLog.i("Q.qqstory.fourTab", 2, paramToServiceMsg.toString());
              }
              if (i1 == 0) {
                return;
              }
              try
              {
                paramToServiceMsg = new Integer[5];
                paramToServiceMsg[0] = Integer.valueOf(1);
                paramToServiceMsg[3] = Integer.valueOf(i1 - 1);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().a(paramToServiceMsg, true);
                return;
              }
              catch (Exception paramToServiceMsg)
              {
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append("er : ");
                paramFromServiceMsg.append(paramToServiceMsg.getMessage());
                QLog.w("Q.qqstory.fourTab", 2, paramFromServiceMsg.toString(), paramToServiceMsg);
                return;
              }
            }
            if (!QLog.isColorLevel()) {
              break label490;
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleNowTabIsOpen TLV error T: ");
            paramFromServiceMsg.append(i3);
            QLog.i("Q.qqstory.fourTab", 2, paramFromServiceMsg.toString());
            break label490;
          }
        }
        else if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleNowTabIsOpen pkg_result: ");
          paramToServiceMsg.append(i1);
          QLog.d("Q.qqstory.fourTab", 2, paramToServiceMsg.toString());
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleNowTabIsOpen exception: ");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.d("Q.qqstory.fourTab", 2, paramFromServiceMsg.toString());
        }
      }
      return;
      label484:
      int i1 = 0;
      continue;
      label490:
      i1 += 1;
    }
  }
  
  public void a(String paramString)
  {
    qqstory_service.ReqGetForbiddenStates localReqGetForbiddenStates = new qqstory_service.ReqGetForbiddenStates();
    Object localObject = new ArrayList();
    try
    {
      ((List)localObject).add(Long.valueOf(Long.parseLong(paramString)));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localReqGetForbiddenStates.uid_list.set((List)localObject);
    localObject = createToServiceMsg(e);
    ((ToServiceMsg)localObject).putWupBuffer(localReqGetForbiddenStates.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("reqUin", paramString);
    a((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = new qqstory_service.ReqMsgTabNodeWatched();
    ((qqstory_service.ReqMsgTabNodeWatched)localObject).node_type.set(paramInt1);
    ((qqstory_service.ReqMsgTabNodeWatched)localObject).operation.set(paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      ((qqstory_service.ReqMsgTabNodeWatched)localObject).unionID.set(ByteStringMicro.copyFromUtf8(paramString), true);
    }
    ((qqstory_service.ReqMsgTabNodeWatched)localObject).recommend_id.set(paramLong);
    ToServiceMsg localToServiceMsg = createToServiceMsg(n);
    localToServiceMsg.extraData.putString("unionId", paramString);
    localToServiceMsg.putWupBuffer(((qqstory_service.ReqMsgTabNodeWatched)localObject).toByteArray());
    a(localToServiceMsg);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQStoryHandler reqMsgTabStoryNodeFeedback unionId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", nodeType = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", operation = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", recommendId = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("Q.qqstory.protocol", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportNetRspResult. cmd=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" errorCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg=");
      localStringBuilder.append(paramString2);
      QLog.d("Q.qqstory.protocol", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    StoryReportor.b("story_net", paramString1, 0, paramInt, new String[] { paramString2, String.valueOf(paramLong), StoryReportor.a(null) });
  }
  
  public void a(ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.protocol", 2, "handStoryPush0xcc. data == null");
      }
      return;
    }
    for (;;)
    {
      try
      {
        localObject2 = new SubMsgType0xcc.MsgBody();
        ((SubMsgType0xcc.MsgBody)localObject2).mergeFrom(paramArrayOfByte);
        int i1 = ((SubMsgType0xcc.MsgBody)localObject2).uint32_msg_type.get();
        String str2 = ((SubMsgType0xcc.MsgBody)localObject2).bytes_sub_type.get().toStringUtf8();
        String str3 = ((SubMsgType0xcc.MsgBody)localObject2).bytes_msg_info.get().toStringUtf8();
        long l1 = 0L;
        if (((SubMsgType0xcc.MsgBody)localObject2).uint64_uin.has()) {
          l1 = ((SubMsgType0xcc.MsgBody)localObject2).uint64_uin.get();
        }
        if (((SubMsgType0xcc.MsgBody)localObject2).bytes_union_id.has())
        {
          paramArrayOfByte = ((SubMsgType0xcc.MsgBody)localObject2).bytes_union_id.get().toStringUtf8();
          if (!((SubMsgType0xcc.MsgBody)localObject2).bytes_vid.has()) {
            break label279;
          }
          localObject1 = ((SubMsgType0xcc.MsgBody)localObject2).bytes_vid.get().toStringUtf8();
          if (!((SubMsgType0xcc.MsgBody)localObject2).bytes_feed_id.has()) {
            break label285;
          }
          str1 = ((SubMsgType0xcc.MsgBody)localObject2).bytes_feed_id.get().toStringUtf8();
          if (!((SubMsgType0xcc.MsgBody)localObject2).bytes_cover_url.has()) {
            break label291;
          }
          localObject2 = ((SubMsgType0xcc.MsgBody)localObject2).bytes_cover_url.get().toStringUtf8();
          a(new StoryPushMsg(i1, str2, str3, l1, paramArrayOfByte, str1, (String)localObject1, (String)localObject2));
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handStoryPush0xcc. merge exception:");
          ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
          QLog.w("Q.qqstory.protocol", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      paramArrayOfByte = null;
      continue;
      label279:
      Object localObject1 = null;
      continue;
      label285:
      String str1 = null;
      continue;
      label291:
      Object localObject2 = null;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 42083, "reqUserSetMsgTabOpen");
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    int i1 = a(paramFromServiceMsg, 42215, "reqUserGetEnableAlbumScan");
    ((StoryConfigManager)SuperManager.a(10)).b("sp_key_user_enable_album_scan", Integer.valueOf(i1));
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleMsgTabStoryIsOpen, userEnableAlbumScanTlvValue:");
      paramFromServiceMsg.append(i1);
      QLog.i("QQStoryHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  public void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramFromServiceMsg, paramObject, "reqUserGetEnableAlbumScan");
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null) {
      paramToServiceMsg = new qqstory_service.RspGetConfig();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label27:
      Object localObject1;
      int i2;
      int i1;
      int i4;
      int i3;
      Object localObject2;
      Object localObject3;
      break label27;
    }
    paramToServiceMsg = null;
    if ((paramToServiceMsg != null) && (paramToServiceMsg.result.error_code.get() == 0))
    {
      if (paramToServiceMsg.user_config.has())
      {
        paramFromServiceMsg = (StoryConfigManager)SuperManager.a(10);
        paramFromServiceMsg.a(System.currentTimeMillis());
        localObject1 = paramToServiceMsg.user_config.get();
        paramObject = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
        localObject1 = ((List)localObject1).iterator();
        i2 = 0;
        for (i1 = 0;; i1 = i4)
        {
          i4 = i2;
          i3 = i1;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (qqstory_struct.UserConfig)((Iterator)localObject1).next();
          localObject3 = ((qqstory_struct.UserConfig)localObject2).config_key.get().toStringUtf8();
          if ("netType".equals(localObject3))
          {
            i2 = ((qqstory_struct.UserConfig)localObject2).config_value.get();
            notifyUI(1003, true, Integer.valueOf(i2));
            paramObject.a(i2);
            i3 = 1;
            i4 = i1;
          }
          else
          {
            boolean bool;
            if ("story_publish_flag_compress".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {
                bool = true;
              } else {
                bool = false;
              }
              paramFromServiceMsg.b("story_publish_flag_compress", Boolean.valueOf(bool));
              i3 = i2;
              i4 = i1;
            }
            else if ("story_publish_flag_compress_configurable".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {
                bool = true;
              } else {
                bool = false;
              }
              paramFromServiceMsg.b("story_publish_flag_compress_configurable", Boolean.valueOf(bool));
              i3 = i2;
              i4 = i1;
            }
            else if ("auto_play_type".equals(localObject3))
            {
              i1 = ((qqstory_struct.UserConfig)localObject2).config_value.get();
              notifyUI(1018, true, Integer.valueOf(i1));
              paramObject.b(i1);
              i4 = 1;
              i3 = i2;
            }
            else if ("self_notify".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {
                bool = true;
              } else {
                bool = false;
              }
              paramObject.a(bool);
              i3 = i2;
              i4 = i1;
            }
            else if ("special_notify".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {
                bool = true;
              } else {
                bool = false;
              }
              paramObject.b(bool);
              i3 = i2;
              i4 = i1;
            }
            else if ("pub_allow_stranger".equals(localObject3))
            {
              ((qqstory_struct.UserConfig)localObject2).config_value.get();
              paramFromServiceMsg.b("key_last_used_permission", Integer.valueOf(10001));
              SLog.a("QQStoryHandler", "get default permission from server. type is %d.", Integer.valueOf(10001));
              i3 = i2;
              i4 = i1;
            }
            else if ("mainpage_auto_reqdata_interval".equals(localObject3))
            {
              long l1 = ((qqstory_struct.UserConfig)localObject2).config_value.get() * 1000;
              SLog.a("Q.qqstory.home.position", "set disable autorefresh time:%d", Long.valueOf(l1));
              paramFromServiceMsg.b("key_disable_auto_refresh_time", Long.valueOf(l1));
              i3 = i2;
              i4 = i1;
            }
            else if ("show_allow_stranger_state".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {
                bool = true;
              } else {
                bool = false;
              }
              paramObject.d(bool);
              i3 = i2;
              i4 = i1;
            }
            else if ("allow_stranger_state".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {
                bool = true;
              } else {
                bool = false;
              }
              paramObject.c(bool);
              i3 = i2;
              i4 = i1;
            }
            else if ("allow_stranger_day_num".equals(localObject3))
            {
              paramObject.c(((qqstory_struct.UserConfig)localObject2).config_value.get());
              i3 = i2;
              i4 = i1;
            }
            else if ("show_auto_post2discovery".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {
                bool = true;
              } else {
                bool = false;
              }
              paramObject.e(bool);
              i3 = i2;
              i4 = i1;
            }
            else if ("auto_post2discovery".equals(localObject3))
            {
              if (((qqstory_struct.UserConfig)localObject2).config_value.get() == 1) {
                bool = true;
              } else {
                bool = false;
              }
              paramObject.f(bool);
              i3 = i2;
              i4 = i1;
            }
            else
            {
              i3 = i2;
              i4 = i1;
              if ("proto_retry_list".equals(localObject3))
              {
                localObject2 = ((qqstory_struct.UserConfig)localObject2).config_value_bytes.get().toStringUtf8();
                paramFromServiceMsg.a((String)localObject2);
                i3 = i2;
                i4 = i1;
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  QQStoryContext.a().a().a((String)localObject2);
                  i4 = i1;
                  i3 = i2;
                }
              }
            }
          }
          i2 = i3;
        }
      }
      i4 = 0;
      i3 = 0;
      if (paramToServiceMsg.pic_specs_list.has())
      {
        ((StoryConfigManager)SuperManager.a(10)).b(System.currentTimeMillis());
        paramObject = paramToServiceMsg.pic_specs_list.get();
        paramFromServiceMsg = new JSONObject();
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          localObject2 = (qqstory_struct.PicSpecs)paramObject.next();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("find specs in response ");
          ((StringBuilder)localObject1).append(((qqstory_struct.PicSpecs)localObject2).pic_bid.get().toStringUtf8());
          ((StringBuilder)localObject1).append(", specs ");
          ((StringBuilder)localObject1).append(((qqstory_struct.PicSpecs)localObject2).pic_spec.get());
          SLog.b("Q.qqstory.protocol", ((StringBuilder)localObject1).toString());
          localObject1 = ((qqstory_struct.PicSpecs)localObject2).pic_bid.get().toStringUtf8();
          localObject2 = ((qqstory_struct.PicSpecs)localObject2).pic_spec.get();
          localObject3 = new JSONArray((Collection)localObject2);
          try
          {
            paramFromServiceMsg.put((String)localObject1, localObject3);
          }
          catch (JSONException localJSONException2)
          {
            label1084:
            break label1084;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Invalid json format in ");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append(localObject2);
          SLog.d("QQStoryHandler", ((StringBuilder)localObject3).toString());
        }
        StoryConfigManager.f(paramFromServiceMsg.toString());
        paramObject = new StringBuilder();
        paramObject.append("get thumbnail config formatted in json ");
        paramObject.append(paramFromServiceMsg.toString());
        SLog.b("Q.qqstory.protocol", paramObject.toString());
      }
      else
      {
        SLog.b("Q.qqstory.protocol", "no thumbnail pic_specs_list found, check for day limitation");
      }
      i2 = i4;
      i1 = i3;
      if (paramToServiceMsg.video_source_tag_list.has())
      {
        paramFromServiceMsg = paramToServiceMsg.video_source_tag_list.get();
        paramToServiceMsg = new JSONObject();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          localObject1 = (qqstory_struct.VideoSourceTagInfo)paramFromServiceMsg.next();
          i1 = ((qqstory_struct.VideoSourceTagInfo)localObject1).source_tag_type.get();
          paramObject = ((qqstory_struct.VideoSourceTagInfo)localObject1).jump_url.get().toStringUtf8();
          localObject1 = ((qqstory_struct.VideoSourceTagInfo)localObject1).wording.get().toStringUtf8();
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("jump_url", paramObject);
            ((JSONObject)localObject2).put("wording", localObject1);
            paramToServiceMsg.put(String.valueOf(i1), localObject2);
          }
          catch (JSONException localJSONException1)
          {
            label1335:
            break label1335;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Invalid json format, tagType: ");
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append(", jumpUrl: ");
          ((StringBuilder)localObject2).append(paramObject);
          ((StringBuilder)localObject2).append(", wording: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          SLog.d("QQStoryHandler", ((StringBuilder)localObject2).toString());
        }
        paramFromServiceMsg = (StoryConfigManager)SuperManager.a(10);
        paramFromServiceMsg.c(System.currentTimeMillis());
        paramFromServiceMsg.b(paramToServiceMsg.toString());
        VideoSourceTagInfoHelper.a();
        SLog.a("QQStoryHandler", "video_source_tag_list format json : %s", paramToServiceMsg.toString());
        i2 = i4;
        i1 = i3;
      }
    }
    else
    {
      i2 = 0;
      i1 = 0;
    }
    if (i2 == 0) {
      notifyUI(1003, false, Integer.valueOf(-1));
    }
    if (i1 == 0) {
      notifyUI(1018, false, Integer.valueOf(-1));
    }
    notifyUI(1016, true, Integer.valueOf(0));
  }
  
  public void b(String paramString)
  {
    Object localObject = new qqstory_service.ReqVideoReaderConf();
    ((qqstory_service.ReqVideoReaderConf)localObject).vid.set(ByteStringMicro.copyFromUtf8(paramString), true);
    ToServiceMsg localToServiceMsg = createToServiceMsg(m);
    localToServiceMsg.putWupBuffer(((qqstory_service.ReqVideoReaderConf)localObject).toByteArray());
    a(localToServiceMsg);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqSyncShortvideoToStory() vid = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQStoryHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.protocol", 2, "handStoryPush0xd0. data == null");
      }
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new SubMsgType0xd0.MsgBody();
        ((SubMsgType0xd0.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        int i1 = ((SubMsgType0xd0.MsgBody)localObject).uint32_msg_type.get();
        String str1 = ((SubMsgType0xd0.MsgBody)localObject).bytes_sub_type.get().toStringUtf8();
        String str2 = ((SubMsgType0xd0.MsgBody)localObject).bytes_msg_info.get().toStringUtf8();
        if (((SubMsgType0xd0.MsgBody)localObject).bytes_cover_url.has())
        {
          paramArrayOfByte = ((SubMsgType0xd0.MsgBody)localObject).bytes_cover_url.get().toStringUtf8();
          paramArrayOfByte = new StoryPushMsg(i1, str1, str2, 0L, "", null, paramArrayOfByte);
          long l1 = ((SubMsgType0xd0.MsgBody)localObject).uint64_hot_topic_id.get();
          if (l1 > 0L) {
            paramArrayOfByte.jdField_a_of_type_AndroidOsBundle.putLong("hot_topic_id", l1);
          }
          str1 = ((SubMsgType0xd0.MsgBody)localObject).bytes_hot_topic_name.get().toStringUtf8();
          if (!TextUtils.isEmpty(str1)) {
            paramArrayOfByte.jdField_a_of_type_AndroidOsBundle.putString("hot_topic_name", str1);
          }
          l1 = ((SubMsgType0xd0.MsgBody)localObject).uint64_big_v_id.get();
          if (l1 > 0L) {
            paramArrayOfByte.jdField_a_of_type_AndroidOsBundle.putLong("big_v_id", l1);
          }
          str1 = ((SubMsgType0xd0.MsgBody)localObject).bytes_big_v_union_id.get().toStringUtf8();
          if (!TextUtils.isEmpty(str1)) {
            paramArrayOfByte.jdField_a_of_type_AndroidOsBundle.putString("big_v_union_id", str1);
          }
          i1 = ((SubMsgType0xd0.MsgBody)localObject).uint32_pgc_type.get();
          if (i1 > 0) {
            paramArrayOfByte.jdField_a_of_type_AndroidOsBundle.putInt("pgc_type", i1);
          }
          str1 = ((SubMsgType0xd0.MsgBody)localObject).bytes_pgc_column_union_id.get().toStringUtf8();
          if (!TextUtils.isEmpty(str1)) {
            paramArrayOfByte.jdField_a_of_type_AndroidOsBundle.putString("pgc_column_union_id", str1);
          }
          if (!TextUtils.isEmpty(((SubMsgType0xd0.MsgBody)localObject).bytes_link.get().toStringUtf8())) {
            paramArrayOfByte.jdField_a_of_type_AndroidOsBundle.putString("link", ((SubMsgType0xd0.MsgBody)localObject).bytes_link.get().toStringUtf8());
          }
          a(paramArrayOfByte);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handStoryPush0xd0. merge exception:");
          ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
          QLog.w("Q.qqstory.protocol", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      paramArrayOfByte = null;
    }
  }
  
  public void c(int paramInt)
  {
    a(paramInt, 42215, "reqUserSetEnableAlbumScan");
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isAdd");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isNotAllowed");
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("uins");
    int i1;
    if (paramObject != null)
    {
      QQStoryManager localQQStoryManager = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
      paramFromServiceMsg = new qqstory_service.RspForbidStory();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.result.error_code.get() == 0)
        {
          paramObject = paramToServiceMsg.iterator();
          while (paramObject.hasNext())
          {
            String str = (String)paramObject.next();
            if (bool1)
            {
              paramFromServiceMsg = localQQStoryManager.a(str);
              paramToServiceMsg = paramFromServiceMsg;
              if (paramFromServiceMsg == null)
              {
                paramToServiceMsg = new QQStoryUserInfo();
                paramToServiceMsg.uin = str;
                paramToServiceMsg.setNick(ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
                localQQStoryManager.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramToServiceMsg);
              }
              if (bool2)
              {
                paramToServiceMsg.isAllowed = 1;
                if (!localQQStoryManager.jdField_b_of_type_JavaUtilList.contains(paramToServiceMsg)) {
                  localQQStoryManager.jdField_b_of_type_JavaUtilList.add(paramToServiceMsg);
                }
              }
              else
              {
                paramToServiceMsg.isInterested = 1;
                if (!localQQStoryManager.jdField_a_of_type_JavaUtilList.contains(paramToServiceMsg)) {
                  localQQStoryManager.jdField_a_of_type_JavaUtilList.add(paramToServiceMsg);
                }
              }
              if (paramToServiceMsg.getStatus() == 1000) {
                localQQStoryManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist(paramToServiceMsg);
              } else {
                localQQStoryManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramToServiceMsg);
              }
            }
            else
            {
              paramToServiceMsg = localQQStoryManager.a(str);
              if (paramToServiceMsg != null)
              {
                if (bool2)
                {
                  paramToServiceMsg.isAllowed = 0;
                  localQQStoryManager.jdField_b_of_type_JavaUtilList.remove(paramToServiceMsg);
                }
                else
                {
                  paramToServiceMsg.isInterested = 0;
                  localQQStoryManager.jdField_a_of_type_JavaUtilList.remove(paramToServiceMsg);
                }
                localQQStoryManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramToServiceMsg);
                localQQStoryManager.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
              }
            }
          }
          notifyUI(1002, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          i1 = 1;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
    else
    {
      i1 = 0;
    }
    if (i1 == 0) {
      notifyUI(1002, false, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.protocol", 2, "handStoryPush0xda. data == null");
      }
      return;
    }
    for (;;)
    {
      SubMsgType0xda.MsgBody localMsgBody;
      int i1;
      String str4;
      String str5;
      String str6;
      int i2;
      try
      {
        localMsgBody = new SubMsgType0xda.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        i1 = localMsgBody.uint32_msg_type.get();
        str4 = localMsgBody.bytes_sub_type.get().toStringUtf8();
        str5 = localMsgBody.bytes_msg_info.get().toStringUtf8();
        str6 = localMsgBody.bytes_version_ctrl.get().toStringUtf8();
        boolean bool = localMsgBody.bytes_feed_id.has();
        localObject3 = null;
        localObject2 = null;
        if (!bool) {
          break label566;
        }
        paramArrayOfByte = localMsgBody.bytes_feed_id.get().toStringUtf8();
        if (!localMsgBody.bytes_union_id.has()) {
          break label571;
        }
        str1 = localMsgBody.bytes_union_id.get().toStringUtf8();
        if (!localMsgBody.bytes_cover_url.has()) {
          break label578;
        }
        localObject1 = localMsgBody.bytes_cover_url.get().toStringUtf8();
        i2 = localMsgBody.uint32_comment_id.get();
        if (!localMsgBody.bytes_ext_info.has()) {
          break label584;
        }
        localObject4 = localMsgBody.bytes_ext_info.get().toStringUtf8();
        try
        {
          Object localObject5 = new JSONObject((String)localObject4);
          localObject4 = ((JSONObject)localObject5).optString("from_nick", null);
          localObject3 = localObject2;
          localObject2 = paramArrayOfByte;
          try
          {
            String str2 = ((JSONObject)localObject5).optString("vid", null);
            localObject3 = str2;
            localObject2 = paramArrayOfByte;
            String str3 = ((JSONObject)localObject5).optString("feed_id", paramArrayOfByte);
            localObject3 = str2;
            localObject2 = str3;
            localObject5 = ((JSONObject)localObject5).optString("cover_url", (String)localObject1);
            paramArrayOfByte = str2;
            localObject3 = str3;
            localObject1 = localObject5;
            localObject2 = localObject4;
          }
          catch (Exception localException1)
          {
            paramArrayOfByte = (byte[])localObject2;
            localObject2 = localObject4;
          }
          SLog.b("Q.qqstory.protocol", "decode json fail", localException2);
        }
        catch (Exception localException2)
        {
          localObject2 = null;
        }
        localObject4 = localObject3;
        localObject3 = paramArrayOfByte;
        paramArrayOfByte = (byte[])localObject4;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if ((!TextUtils.isEmpty(str6)) && (AppSetting.a(str6) >= 0)) {
        paramArrayOfByte = new StoryPushMsg(i1, str4, str5, 0L, "", (String)localObject3, str1, i2, (String)localObject1, (String)localObject2, paramArrayOfByte);
      }
      try
      {
        a(paramArrayOfByte);
        continue;
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("handleStoryPush0xda 版本过低，notification被过滤了，version = ");
          paramArrayOfByte.append(str6);
          paramArrayOfByte.append(", type = ");
          paramArrayOfByte.append(i1);
          paramArrayOfByte.append(", subType = ");
          paramArrayOfByte.append(str4);
          paramArrayOfByte.append(", msgInfo = ");
          paramArrayOfByte.append(str5);
          QLog.w("Q.qqstory.protocol", 2, paramArrayOfByte.toString());
        }
        if (!localMsgBody.bytes_icon_union_id.has()) {
          break label565;
        }
        paramArrayOfByte = localMsgBody.bytes_icon_union_id.get().toStringUtf8();
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          break label565;
        }
        GetUserIconHandler.a(paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handStoryPush0xda. merge exception:");
        ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
        QLog.w("Q.qqstory.protocol", 2, ((StringBuilder)localObject1).toString());
      }
      label565:
      return;
      label566:
      paramArrayOfByte = null;
      continue;
      label571:
      String str1 = "";
      continue;
      label578:
      Object localObject1 = null;
      continue;
      label584:
      Object localObject2 = null;
      Object localObject4 = localObject2;
      Object localObject3 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
    }
  }
  
  public void d(int paramInt)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    Object localObject = new qqstory_struct.UserConfig();
    ((qqstory_struct.UserConfig)localObject).config_key.set(ByteStringMicro.copyFromUtf8("auto_play_type"));
    ((qqstory_struct.UserConfig)localObject).config_value.set(paramInt);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localReqSetConfig.user_config.set(localArrayList);
    localObject = createToServiceMsg(b);
    ((ToServiceMsg)localObject).putWupBuffer(localReqSetConfig.toByteArray());
    a((ToServiceMsg)localObject);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i6 = 1;
    int i5 = 1;
    int i4;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null)) {
      i4 = 0;
    } else {
      i4 = 1;
    }
    long l1;
    if (paramToServiceMsg == null) {
      l1 = -1L;
    } else {
      l1 = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("extra_start_time");
    }
    int i1;
    if (paramFromServiceMsg == null) {
      i1 = -1;
    } else {
      i1 = paramFromServiceMsg.getBusinessFailCode();
    }
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = "local data";
    } else {
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    }
    int i3;
    int i2;
    if (a(paramObject))
    {
      i3 = i1;
      paramFromServiceMsg = paramToServiceMsg;
      try
      {
        Object localObject = new qqstory_pgc.RspReport();
        i3 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        ((qqstory_pgc.RspReport)localObject).mergeFrom((byte[])paramObject);
        i3 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramObject = (qqstory_pgc.ErrorInfo)((qqstory_pgc.RspReport)localObject).result.get();
        i3 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        i2 = paramObject.error_code.get();
        i3 = i2;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject.error_desc.get().toStringUtf8();
        if (i2 == 0)
        {
          i3 = i2;
          paramFromServiceMsg = paramToServiceMsg;
          notifyUI(1015, true, new Object[] { Integer.valueOf(i2), paramToServiceMsg });
          i1 = i6;
          i3 = i2;
          paramFromServiceMsg = paramToServiceMsg;
          try
          {
            if (!QLog.isColorLevel()) {
              break label393;
            }
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("QQStoryHandler handleGetClientReport isSuccess=");
            paramFromServiceMsg.append(true);
            QLog.d("Q.qqstory.protocol", 2, paramFromServiceMsg.toString());
            i1 = i6;
            i3 = i2;
            paramFromServiceMsg = paramToServiceMsg;
          }
          catch (InvalidProtocolBufferMicroException paramObject)
          {
            i1 = i5;
            break label383;
          }
        }
        else
        {
          i3 = i2;
          paramFromServiceMsg = paramToServiceMsg;
          if (QLog.isColorLevel())
          {
            i3 = i2;
            paramFromServiceMsg = paramToServiceMsg;
            localObject = new StringBuilder();
            i3 = i2;
            paramFromServiceMsg = paramToServiceMsg;
            ((StringBuilder)localObject).append("QQStoryHandler handleGetClientReport error_code=");
            i3 = i2;
            paramFromServiceMsg = paramToServiceMsg;
            ((StringBuilder)localObject).append(paramObject.error_code.get());
            i3 = i2;
            paramFromServiceMsg = paramToServiceMsg;
            QLog.d("Q.qqstory.protocol", 2, ((StringBuilder)localObject).toString());
          }
          i1 = 0;
          i3 = i2;
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        i1 = 0;
        paramToServiceMsg = paramFromServiceMsg;
        i2 = i3;
        label383:
        paramObject.printStackTrace();
        paramFromServiceMsg = paramToServiceMsg;
        i3 = i2;
      }
      label393:
      paramToServiceMsg = paramFromServiceMsg;
    }
    else
    {
      i2 = 0;
      i3 = i1;
      i1 = i2;
    }
    if (i1 == 0) {
      notifyUI(1015, false, null);
    }
    if (i4 == 0) {
      a(k, l1, i3, paramToServiceMsg);
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1;
    if (paramToServiceMsg == null) {
      l1 = -1L;
    } else {
      l1 = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("extra_start_time");
    }
    int i1;
    if (paramFromServiceMsg == null) {
      i1 = -1;
    } else {
      i1 = paramFromServiceMsg.getBusinessFailCode();
    }
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = "local data";
    } else {
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    }
    int i3 = i1;
    Object localObject = paramToServiceMsg;
    if (a(paramObject))
    {
      int i2 = i1;
      paramFromServiceMsg = paramToServiceMsg;
      try
      {
        qqstory_service.RspVideoReaderConf localRspVideoReaderConf = new qqstory_service.RspVideoReaderConf();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        localRspVideoReaderConf.mergeFrom((byte[])paramObject);
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramObject = (qqstory_struct.ErrorInfo)localRspVideoReaderConf.result.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        i1 = paramObject.error_code.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject.error_desc.get().toStringUtf8();
        i3 = i1;
        localObject = paramToServiceMsg;
        if (i1 == 0)
        {
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          notifyUI(1017, true, new QQStoryBanInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (qqstory_struct.VideoReaderConf)localRspVideoReaderConf.reader_conf.get()));
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          if (QLog.isColorLevel())
          {
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject = new StringBuilder();
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append("QQStoryHandler handleVideoReaderConfig errorCode = ");
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append(i1);
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append(", errorDesc = ");
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append(paramToServiceMsg);
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append(", useTime = ");
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append(l1);
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            QLog.d("Q.qqstory.protocol", 2, paramObject.toString());
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i3 = i2;
        localObject = paramFromServiceMsg;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("QQStoryHandler handleVideoReaderConfig: ");
          paramObject.append(QLog.getStackTraceString(paramToServiceMsg));
          paramObject.append(", useTime = ");
          paramObject.append(l1);
          QLog.d("Q.qqstory.protocol", 2, paramObject.toString());
          localObject = paramFromServiceMsg;
          i3 = i2;
        }
      }
    }
    notifyUI(1017, false, null);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("QQStoryHandler handleVideoReaderConfig errorCode = ");
      paramToServiceMsg.append(i3);
      paramToServiceMsg.append(", errorDesc = ");
      paramToServiceMsg.append((String)localObject);
      paramToServiceMsg.append(", useTime = ");
      paramToServiceMsg.append(l1);
      QLog.d("Q.qqstory.protocol", 2, paramToServiceMsg.toString());
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      paramToServiceMsg = null;
    } else {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("unionId");
    }
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[1] = paramToServiceMsg;
    int i1;
    if (paramFromServiceMsg == null) {
      i1 = -1;
    } else {
      i1 = paramFromServiceMsg.getBusinessFailCode();
    }
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = "local data";
    } else {
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    }
    int i3 = i1;
    Object localObject = paramToServiceMsg;
    if (a(paramObject))
    {
      int i2 = i1;
      paramFromServiceMsg = paramToServiceMsg;
      try
      {
        localObject = new qqstory_service.RspMsgTabNodeWatched();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        ((qqstory_service.RspMsgTabNodeWatched)localObject).mergeFrom((byte[])paramObject);
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramObject = (qqstory_struct.ErrorInfo)((qqstory_service.RspMsgTabNodeWatched)localObject).result.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        i1 = paramObject.error_code.get();
        i2 = i1;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject.error_desc.get().toStringUtf8();
        if (i1 == 0)
        {
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          i3 = i1;
          localObject = paramToServiceMsg;
          if (QLog.isColorLevel())
          {
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject = new StringBuilder();
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append("QQStoryHandler handlerMsgTabStoryNodeFeedback isSuccess=");
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            paramObject.append(false);
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            QLog.d("Q.qqstory.protocol", 2, paramObject.toString());
            i3 = i1;
            localObject = paramToServiceMsg;
          }
        }
        else
        {
          i2 = i1;
          paramFromServiceMsg = paramToServiceMsg;
          i3 = i1;
          localObject = paramToServiceMsg;
          if (QLog.isColorLevel())
          {
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            localObject = new StringBuilder();
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            ((StringBuilder)localObject).append("QQStoryHandler handlerMsgTabStoryNodeFeedback error_code=");
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            ((StringBuilder)localObject).append(paramObject.error_code.get());
            i2 = i1;
            paramFromServiceMsg = paramToServiceMsg;
            QLog.d("Q.qqstory.protocol", 2, ((StringBuilder)localObject).toString());
            i3 = i1;
            localObject = paramToServiceMsg;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        localObject = paramFromServiceMsg;
        i3 = i2;
      }
    }
    arrayOfObject[2] = null;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("QQStoryHandler handlerMsgTabStoryNodeFeedback error_code=");
      paramToServiceMsg.append(i3);
      paramToServiceMsg.append(" errorDesc=");
      paramToServiceMsg.append((String)localObject);
      QLog.d("Q.qqstory.protocol", 2, paramToServiceMsg.toString());
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QQStoryObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQStoryHandle onReceive. cmd=");
      localStringBuilder.append(str);
      QLog.d("Q.qqstory.protocol", 2, localStringBuilder.toString());
    }
    if (jdField_a_of_type_JavaLangString.equals(str))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (b.equals(str))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (c.equals(str))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (d.equals(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (e.equals(str))
    {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (f.equals(str))
    {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (i.equals(str))
    {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (j.equals(str))
    {
      l(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (h.equals(str))
    {
      m(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x480_9".equals(str))
    {
      if (paramToServiceMsg.extraData.getBoolean("reqFromQQStoryHandler"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("reqUserGetMsgTabOpen"))
      {
        a(paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("reqUserGetEnableAlbumScan")) {
        b(paramFromServiceMsg);
      }
    }
    else if ("OidbSvc.0x4ff_9".equals(str))
    {
      if (paramToServiceMsg.extraData.getBoolean("reqFromQQStoryHandler"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQStoryHandler", 2, "CMD_SET_DETAIL_INFO : ");
        }
      }
      else
      {
        if (paramToServiceMsg.extraData.getBoolean("reqUserSetMsgTabOpen"))
        {
          a(paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.extraData.getBoolean("reqUserSetEnableAlbumScan")) {
          b(paramFromServiceMsg, paramObject);
        }
      }
    }
    else
    {
      if (k.equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (l.equals(str)) {
        return;
      }
      if (m.equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (n.equals(str)) {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryHandler
 * JD-Core Version:    0.7.0.1
 */