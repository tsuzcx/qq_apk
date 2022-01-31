package com.tencent.mobileqq.app;

import acus;
import ajxn;
import aktg;
import android.text.TextUtils;
import awcj;
import axqw;
import bbjn;
import bbqc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.StickerInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class SignatureManager$3
  implements Runnable
{
  SignatureManager$3(RichStatus paramRichStatus, String paramString) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      int i;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        Object localObject1 = (ajxn)localQQAppInterface.getManager(51);
        boolean bool = ((ajxn)localObject1).b(this.jdField_a_of_type_JavaLangString);
        if (!bool) {
          return;
        }
        long l2 = NetConnInfoCenter.getServerTime();
        if (localObject4 == null)
        {
          localObject1 = ((ajxn)localObject1).a(this.jdField_a_of_type_JavaLangString);
          if (localObject1 == null) {
            return;
          }
          bool = ((ExtensionInfo)localObject1).isAdded2C2C;
          if (bool) {
            return;
          }
          localObject4 = ((ExtensionInfo)localObject1).getRichStatus();
          long l3 = l2 - ((RichStatus)localObject4).time;
          if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, "insertSignMsgIfNeeded serverTime = " + l2 + " richTime = " + ((RichStatus)localObject4).time);
          }
          if ((l3 > 0L) && (l3 >= 604800L)) {
            return;
          }
          if ((((RichStatus)localObject4).isEmpty()) || (TextUtils.isEmpty(((RichStatus)localObject4).feedsId)))
          {
            localObject1 = localQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 0, new int[] { -1034 });
            if (localObject1 != null)
            {
              localObject1 = ((List)localObject1).iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject4 = (MessageRecord)((Iterator)localObject1).next();
                localQQAppInterface.a().a(((MessageRecord)localObject4).frienduin, 0, ((MessageRecord)localObject4).msgtype, ((MessageRecord)localObject4).uniseq);
                localQQAppInterface.a().b(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, ((MessageRecord)localObject4).uniseq);
                continue;
              }
            }
          }
        }
        Object localObject5;
        int j;
        Object localObject6;
        Object localObject7;
        int k;
        int m;
        JSONObject localJSONObject;
        Object localObject3 = null;
      }
      catch (Exception localException)
      {
        return;
        ((acus)localQQAppInterface.getManager(282)).a(this.jdField_a_of_type_JavaLangString, 0, 1);
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "insertSignMsgIfNeeded delete signature");
        }
        bbjn.b(localQQAppInterface.c(), this.jdField_a_of_type_JavaLangString, 0L);
        return;
        localObject5 = (SignatureManager)localQQAppInterface.getManager(58);
        if (!SignatureManager.a.containsKey(Integer.valueOf(((RichStatus)localObject4).tplId)))
        {
          localObject5 = bbqc.a(localQQAppInterface, ((RichStatus)localObject4).tplId);
          if (localObject5 != null) {
            SignatureManager.a.put(Integer.valueOf(((RichStatus)localObject4).tplId), localObject5);
          }
        }
        if (localQQAppInterface.a().a().a(this.jdField_a_of_type_JavaLangString, 0) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, "insertSignMsgIfNeeded fail ResentUser = null ");
          }
          return;
        }
        localObject5 = new JSONObject();
        try
        {
          ((JSONObject)localObject5).put("ver", "1.0");
          ((JSONObject)localObject5).put("time", String.valueOf(((RichStatus)localObject4).time));
          if ((((RichStatus)localObject4).actionText != null) && (((RichStatus)localObject4).actionText.trim().length() > 0))
          {
            ((JSONObject)localObject5).put("aid", String.valueOf(((RichStatus)localObject4).actionId));
            ((JSONObject)localObject5).put("actiontext", ((RichStatus)localObject4).actionText);
          }
          if ((((RichStatus)localObject4).dataText != null) && (((RichStatus)localObject4).dataText.trim().length() > 0))
          {
            ((JSONObject)localObject5).put("did", String.valueOf(((RichStatus)localObject4).dataId));
            ((JSONObject)localObject5).put("datatext", ((RichStatus)localObject4).dataText);
          }
          ((JSONObject)localObject5).put("loctextpos", String.valueOf(((RichStatus)localObject4).locationPosition));
          if ((((RichStatus)localObject4).plainText != null) && (((RichStatus)localObject4).plainText.size() > 0))
          {
            j = ((RichStatus)localObject4).plainText.size();
            localObject6 = new JSONArray();
            i = 0;
            if (i < j)
            {
              localObject7 = (String)((RichStatus)localObject4).plainText.get(i);
              if (localObject7 == null) {
                break label1930;
              }
              ((JSONArray)localObject6).put(localObject7);
              break label1930;
            }
            if (((JSONArray)localObject6).length() > 0) {
              ((JSONObject)localObject5).put("plaintext", localObject6);
            }
          }
          if (((RichStatus)localObject4).topics.size() > 0) {
            ((JSONObject)localObject5).put("topics", ((RichStatus)localObject4).topicToJson());
          }
          if (((RichStatus)localObject4).topicsPos.size() > 0) {
            ((JSONObject)localObject5).put("topicsPos", ((RichStatus)localObject4).topicPosToJson());
          }
          if ((((RichStatus)localObject4).locationText != null) && (((RichStatus)localObject4).locationText.trim().length() > 0)) {
            ((JSONObject)localObject5).put("loctext", ((RichStatus)localObject4).locationText);
          }
          if (!TextUtils.isEmpty(((RichStatus)localObject4).feedsId)) {
            ((JSONObject)localObject5).put("feedid", ((RichStatus)localObject4).feedsId);
          }
          ((JSONObject)localObject5).put("tplid", ((RichStatus)localObject4).tplId);
          k = 0;
          m = 0;
          j = m;
          i = k;
          if (((RichStatus)localObject4).sigZanInfo != null)
          {
            j = m;
            i = k;
            if (((RichStatus)localObject4).sigZanInfo.get(Integer.valueOf(255)) != null)
            {
              i = ((awcj)((RichStatus)localObject4).sigZanInfo.get(Integer.valueOf(255))).b;
              j = ((awcj)((RichStatus)localObject4).sigZanInfo.get(Integer.valueOf(255))).c;
            }
          }
          ((JSONObject)localObject5).put("count", i);
          ((JSONObject)localObject5).put("zanfalg", j);
          if ((((RichStatus)localObject4).mStickerInfos != null) && (((RichStatus)localObject4).mStickerInfos.size() > 0))
          {
            localObject6 = new JSONArray();
            i = 0;
            if (i < ((RichStatus)localObject4).mStickerInfos.size())
            {
              localObject7 = (RichStatus.StickerInfo)((RichStatus)localObject4).mStickerInfos.get(i);
              localJSONObject = new JSONObject();
              localJSONObject.put("id", ((RichStatus.StickerInfo)localObject7).id);
              localJSONObject.put("posX", ((RichStatus.StickerInfo)localObject7).posX);
              localJSONObject.put("posY", ((RichStatus.StickerInfo)localObject7).posY);
              localJSONObject.put("width", ((RichStatus.StickerInfo)localObject7).width);
              localJSONObject.put("height", ((RichStatus.StickerInfo)localObject7).height);
              ((JSONArray)localObject6).put(localJSONObject);
              i += 1;
              continue;
            }
            ((JSONObject)localObject5).put("sticker", localObject6);
          }
          ((JSONObject)localObject5).put("fontId", ((RichStatus)localObject4).fontId);
          ((JSONObject)localObject5).put("fontType", ((RichStatus)localObject4).fontType);
          if (((JSONObject)localObject5).length() <= 3)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Signature", 2, "insertSignMsgIfNeeded sign is empty,rs.actionText is:" + ((RichStatus)localObject4).actionText + ",rs.dataText is:" + ((RichStatus)localObject4).dataText + ",rs.plainText is:" + ((RichStatus)localObject4).plainText + ",rs.locationText is:" + ((RichStatus)localObject4).locationText);
            }
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, "insertSignMsgIfNeeded failed,error msg is:" + localJSONException.getMessage(), localJSONException);
          }
          return;
        }
        localObject5 = ((JSONObject)localObject5).toString();
        l2 = NetConnInfoCenter.getServerTimeMillis();
        localObject6 = (acus)localQQAppInterface.getManager(282);
        localObject7 = new BeancurdMsg();
        ((BeancurdMsg)localObject7).frienduin = this.jdField_a_of_type_JavaLangString;
        ((BeancurdMsg)localObject7).busiid = 1;
        ((BeancurdMsg)localObject7).isNeedDelHistory = true;
        ((BeancurdMsg)localObject7).ispush = true;
        ((BeancurdMsg)localObject7).startTime = NetConnInfoCenter.getServerTime();
        ((BeancurdMsg)localObject7).validTime = 2592000L;
        ((BeancurdMsg)localObject7).buffer = ((String)localObject5);
        ((acus)localObject6).a((BeancurdMsg)localObject7);
        bbjn.b(localQQAppInterface.c(), this.jdField_a_of_type_JavaLangString, l2);
        if (localJSONException != null)
        {
          localJSONException.isAdded2C2C = true;
          ((ajxn)localQQAppInterface.getManager(51)).a(localJSONException);
        }
        axqw.b(localQQAppInterface, "CliOper", "", "", "signature", "aio_sig_show", 0, 0, String.valueOf(((RichStatus)localObject4).tplId), "", "", "");
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "insert signature cost:" + (System.currentTimeMillis() - l1) + " ms");
        }
        SignatureManager.a(true);
      }
      continue;
      label1930:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.3
 * JD-Core Version:    0.7.0.1
 */