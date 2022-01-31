package com.tencent.biz.pubaccount.readinjoy.engine;

import aepi;
import alof;
import alwx;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bdfz;
import bdhj;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import nxu;
import org.json.JSONObject;
import ors;
import owt;
import owu;
import owv;
import pgr;
import sex;
import syb;

public class KandianSubscribeManager
  implements Manager
{
  public static final String a;
  private alwx jdField_a_of_type_Alwx = new owt(this);
  private KandianSubscribeManager.MsgBoxSetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianSubscribeManager$MsgBoxSetTopInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<owv> jdField_a_of_type_JavaUtilList = new LinkedList();
  pgr jdField_a_of_type_Pgr = new owu(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = KandianSubscribeManager.class.getSimpleName();
  }
  
  public KandianSubscribeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianSubscribeManager$MsgBoxSetTopInfo = ((KandianSubscribeManager.MsgBoxSetTopInfo)ors.a(paramQQAppInterface, "kandian_subscribe_settop_info_key", true));
    QLog.d(jdField_a_of_type_JavaLangString, 1, "read settop info from sp. " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianSubscribeManager$MsgBoxSetTopInfo);
  }
  
  public static Drawable a(Drawable paramDrawable, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 == null) {}
    for (;;)
    {
      return paramDrawable;
      Object localObject2 = ((QQMessageFacade)localObject1).b(alof.aR, 1008);
      if ((localObject2 != null) && (!((MessageRecord)localObject2).isread) && (((MessageRecord)localObject2).msgtype == -2011)) {
        try
        {
          localObject1 = BaseApplicationImpl.getApplication().getResources();
          localObject2 = (MessageForStructing)localObject2;
          if (!((MessageForStructing)localObject2).mIsParsed) {
            ((MessageForStructing)localObject2).parse();
          }
          if ((((MessageForStructing)localObject2).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject2).structingMsg.mExtraData)))
          {
            localObject2 = new JSONObject(((MessageForStructing)localObject2).structingMsg.mExtraData).optString("uin", "");
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramQQAppInterface = paramQQAppInterface.a(1, "kd_dt_" + (String)localObject2, (byte)3, 0, 100, true);
              Object localObject3 = (sex)bdfz.a(paramQQAppInterface);
              if (localObject3 != null)
              {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "getMergeIcon From cache ! key : " + paramQQAppInterface + ", tipUin : " + (String)localObject2);
                return localObject3;
              }
              localObject3 = bdhj.a(paramDrawable);
              if (localObject3 != null)
              {
                localObject1 = new sex((Bitmap)localObject3, aepi.a(50.0F, (Resources)localObject1), (Resources)localObject1, (String)localObject2, 1);
                bdfz.a(paramQQAppInterface, (Sizeable)localObject1);
                return localObject1;
              }
            }
          }
        }
        catch (OutOfMemoryError paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          QLog.d(jdField_a_of_type_JavaLangString, 2, "get merge icon has error : " + paramQQAppInterface);
          return paramDrawable;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          QLog.d(jdField_a_of_type_JavaLangString, 2, "get merge icon has error : " + paramQQAppInterface);
        }
      }
    }
    return paramDrawable;
  }
  
  public static KandianRedDotInfo a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface == null) {
      return null;
    }
    MessageRecord localMessageRecord = localQQAppInterface.a().b(alof.aR, 1008);
    if (localMessageRecord == null) {
      return null;
    }
    if ((localMessageRecord instanceof MessageForStructing))
    {
      ors.a(alof.aR, localQQAppInterface);
      return KandianRedDotInfo.createRedDotFromMessageRecord(localMessageRecord, "kandian_dt_red_dot_info");
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, -1);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = nxu.b(paramContext, paramInt2, 70);
    KandianRedDotInfo localKandianRedDotInfo = a();
    if (localKandianRedDotInfo != null) {
      localIntent.putExtra("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
    }
    localIntent.putExtra("kandian_subscribe_launch_from", paramInt2);
    if (!(paramContext instanceof BaseActivity)) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new KandianSubscribeManager.1(this));
  }
  
  private static void b(MessageRecord paramMessageRecord, String paramString1, long paramLong, String paramString2)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = alof.aR;
    paramMessageRecord.senderuin = alof.aR;
    paramMessageRecord.istroop = 1008;
    paramMessageRecord.msg = paramString1;
    paramMessageRecord.time = paramLong;
    paramMessageRecord.extLong = 0;
    paramMessageRecord.extStr = paramString2;
    paramMessageRecord.createMessageUniseq();
  }
  
  public alwx a()
  {
    return this.jdField_a_of_type_Alwx;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianSubscribeManager$MsgBoxSetTopInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianSubscribeManager$MsgBoxSetTopInfo.tryToSetTop();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    KandianSubscribeManager.MsgBoxSetTopInfo localMsgBoxSetTopInfo = new KandianSubscribeManager.MsgBoxSetTopInfo();
    localMsgBoxSetTopInfo.setTopStartTime = paramInt1;
    localMsgBoxSetTopInfo.setTopPosition = paramInt2;
    if (paramInt3 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localMsgBoxSetTopInfo.allowSettop = bool;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianSubscribeManager$MsgBoxSetTopInfo != null) {
        localMsgBoxSetTopInfo.lastSetTopTimeMillis = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianSubscribeManager$MsgBoxSetTopInfo.lastSetTopTimeMillis;
      }
      ors.a("kandian_subscribe_settop_info_key", localMsgBoxSetTopInfo, true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianSubscribeManager$MsgBoxSetTopInfo = localMsgBoxSetTopInfo;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "update settop info : " + localMsgBoxSetTopInfo);
      return;
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, long paramLong)
  {
    if (paramArticleInfo == null) {
      return;
    }
    String str = syb.a(paramArticleInfo, this.jdField_a_of_type_Pgr);
    if (paramArticleInfo.msgBoxBriefPreFixType == 2) {}
    for (paramArticleInfo = paramArticleInfo.msgBoxBriefPreFix; (TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null); paramArticleInfo = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "brief is empty, give up insert !");
      return;
    }
    ThreadManager.post(new KandianSubscribeManager.4(this, str, paramLong, paramArticleInfo), 10, null, false);
  }
  
  public void a(@NonNull owv paramowv)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramowv)) {
      this.jdField_a_of_type_JavaUtilList.add(paramowv);
    }
  }
  
  public boolean a()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.aR, 1008);
    return ((localMessageRecord instanceof MessageForStructing)) && (!localMessageRecord.isread);
  }
  
  public void b(owv paramowv)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramowv);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager
 * JD-Core Version:    0.7.0.1
 */