import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder.1;
import cooperation.qqfav.QfavPluginProxyActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class bljl
{
  private Intent a;
  
  public bljl(int paramInt)
  {
    this.a = new Intent();
    this.a.putExtra("nType", paramInt);
  }
  
  public bljl(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public static bljl a()
  {
    return new bljl(3);
  }
  
  public static bljl a(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3)
  {
    return new bljl(7).b("sLocation", paramString2).b("sBrief", paramString3).b("sPublisher", paramString1).a("fLatitude", paramFloat1).a("fLongitude", paramFloat2);
  }
  
  public static bljl a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    String str6 = paramString1;
    String str5 = paramString2;
    String str4 = paramString3;
    String str3 = paramString4;
    String str2 = paramString5;
    String str1 = paramString6;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = bljz.a(paramArrayOfByte);
      str6 = bljz.a(paramArrayOfByte[0], paramString1);
      str5 = bljz.a(paramArrayOfByte[1], paramString2);
      str4 = bljz.a(paramArrayOfByte[2], paramString3);
      str3 = bljz.a(paramArrayOfByte[3], paramString4);
      str2 = bljz.a(paramArrayOfByte[4], paramString5);
      str1 = bljz.a(paramArrayOfByte[5], paramString6);
    }
    paramString1 = new bljl(6).a("nLinkType", paramInt).b("sTitle", str6).b("sUrl", str5).a("bAppShare", paramBoolean).a("lAppId", paramLong).b("sPublisher", str4).b("sBrief", str3).b("sPath", str2).b("sResUrl", str1);
    if (paramBoolean) {}
    for (paramLong = 4L;; paramLong = 1L) {
      return paramString1.a("lCategory", paramLong);
    }
  }
  
  public static bljl a(Intent paramIntent)
  {
    int i = 1;
    if (paramIntent == null) {
      return null;
    }
    ContentValues localContentValues = new ContentValues();
    int j = paramIntent.getIntExtra("from_busi_type", 1);
    Object localObject;
    long l;
    if (j == 0)
    {
      localContentValues.put("shortVideoBusiType", Integer.valueOf(i));
      localContentValues.put("shortVideoDuration", Integer.valueOf(paramIntent.getIntExtra("file_send_duration", 0)));
      localContentValues.put("shortVideoFormat", Integer.valueOf(paramIntent.getIntExtra("file_format", 0)));
      localObject = paramIntent.getStringExtra("file_send_path");
      localContentValues.put("shortVideoLocalPath", (String)localObject);
      localContentValues.put("shortVideoMd5", paramIntent.getStringExtra("file_shortvideo_md5"));
      if (!new File((String)localObject).exists()) {
        break label348;
      }
      l = new File((String)localObject).length();
      label132:
      localContentValues.put("shortVideoSize", Long.valueOf(l));
      String str = paramIntent.getStringExtra("file_name");
      localContentValues.put("shortVideoFileName", str.substring(str.lastIndexOf('/') + 1, str.length()));
      localContentValues.put("shortVideoThumbHeight", Integer.valueOf(paramIntent.getIntExtra("thumbfile_send_height", 0)));
      localContentValues.put("shortVideoThumbMd5", paramIntent.getStringExtra("thumbfile_md5"));
      if (!new File((String)localObject).exists()) {
        break label353;
      }
    }
    label348:
    label353:
    for (i = (int)new File((String)localObject).length();; i = paramIntent.getIntExtra("file_thumb_Size", 0))
    {
      localContentValues.put("shortVideoThumbSize", Integer.valueOf(i));
      localContentValues.put("shortVideoThumbWidth", Integer.valueOf(paramIntent.getIntExtra("thumbfile_send_width", 0)));
      localContentValues.put("shortVideoThumbLocalPath", paramIntent.getStringExtra("thumbfile_send_path"));
      localContentValues.put("shortVideoUuid", paramIntent.getStringExtra("file_uuid"));
      localObject = new bljl(5);
      ((bljl)localObject).a.putExtra("shortVideoContents", localContentValues);
      if (j == 0) {
        ((bljl)localObject).a.putExtra("sBizDataList", bljn.a());
      }
      return ((bljl)localObject).c(paramIntent.getStringExtra("from_uin"));
      i = j;
      break;
      l = 0L;
      break label132;
    }
  }
  
  public static bljl a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, List<ChatMessage> paramList, Map<String, String> paramMap)
  {
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {
      return null;
    }
    bljl localbljl = new bljl(8).c(paramMessageForStructing);
    if (!bljz.a(paramMessageForStructing))
    {
      localbljl.c(paramMessageForStructing);
      return localbljl;
    }
    ArrayList localArrayList = new ArrayList();
    byte[] arrayOfByte = bljz.a(paramMessageForStructing.uniseq, paramMessageForStructing.structingMsg);
    if (arrayOfByte != null) {
      localArrayList.add(arrayOfByte);
    }
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (long l = 1L;; l = paramList.size())
    {
      arrayOfByte = bljz.a(paramMessageForStructing.uniseq, l);
      if (arrayOfByte != null) {
        localArrayList.add(arrayOfByte);
      }
      arrayOfByte = bljz.a(-1L, paramMap);
      if (arrayOfByte != null) {
        localArrayList.add(arrayOfByte);
      }
      bljz.a(paramQQAppInterface, paramMessageForStructing, paramList, paramMap, localArrayList);
      if (localArrayList != null) {
        localbljl.b("sBizDataList", localArrayList);
      }
      return localbljl;
    }
  }
  
  public static bljl a(MessageForShortVideo paramMessageForShortVideo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("shortVideoDuration", Integer.valueOf(paramMessageForShortVideo.videoFileTime));
    localContentValues.put("shortVideoFileTYPE", Integer.valueOf(paramMessageForShortVideo.fileType));
    localContentValues.put("shortVideoFormat", Integer.valueOf(paramMessageForShortVideo.videoFileFormat));
    localContentValues.put("shortVideoMd5", paramMessageForShortVideo.md5);
    int i;
    Object localObject;
    if (paramMessageForShortVideo.busiType == 0)
    {
      i = 1;
      localContentValues.put("shortVideoBusiType", Integer.valueOf(i));
      localObject = ShortVideoUtils.c(paramMessageForShortVideo);
      localContentValues.put("shortVideoLocalPath", (String)localObject);
      long l2 = paramMessageForShortVideo.videoFileSize;
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (new File((String)localObject).exists()) {
          l1 = new File((String)localObject).length();
        }
      }
      localContentValues.put("shortVideoSize", Long.valueOf(l1));
      if (localObject != null) {
        break label356;
      }
      localObject = "";
      label165:
      localContentValues.put("shortVideoFileName", ((String)localObject).substring(((String)localObject).lastIndexOf('/') + 1, ((String)localObject).length()));
      localContentValues.put("shortVideoThumbHeight", Integer.valueOf(paramMessageForShortVideo.thumbHeight));
      localContentValues.put("shortVideoThumbMd5", paramMessageForShortVideo.thumbMD5);
      localContentValues.put("shortVideoThumbWidth", Integer.valueOf(paramMessageForShortVideo.thumbWidth));
      localObject = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      if (!new File((String)localObject).exists()) {
        break label359;
      }
    }
    label356:
    label359:
    for (long l1 = new File((String)localObject).length();; l1 = paramMessageForShortVideo.thumbFileSize)
    {
      localContentValues.put("shortVideoThumbSize", Long.valueOf(l1));
      localContentValues.put("shortVideoThumbLocalPath", (String)localObject);
      localContentValues.put("shortVideoUuid", paramMessageForShortVideo.uuid);
      localObject = new bljl(5);
      ((bljl)localObject).a.putExtra("shortVideoContents", localContentValues);
      if (paramMessageForShortVideo.busiType == 0) {
        ((bljl)localObject).a.putExtra("sBizDataList", bljn.a());
      }
      return localObject;
      i = paramMessageForShortVideo.busiType;
      break;
      break label165;
    }
  }
  
  public static bljl a(Entity paramEntity)
  {
    return new bljl(2).c(paramEntity);
  }
  
  public static bljl a(String paramString)
  {
    return new bljl(6).b("sUrl", paramString);
  }
  
  public static bljl a(String paramString1, int paramInt, String paramString2)
  {
    return new bljl(4).b("sPath", paramString1).a("nDuration", paramInt).b("sBrief", paramString2);
  }
  
  public static bljl a(String paramString1, int paramInt, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    paramInt = bljz.b(paramInt);
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if ((4 == paramInt) || (5 == paramInt)) {
        paramString2 = String.valueOf(paramLong1);
      }
      return new bljl(2).b("sMD5", paramString1).b("sPath", paramString3).a("nPicType", paramInt).b("sPicId", paramString2).a("lSize", paramLong2);
    }
  }
  
  public static bljl a(String paramString1, String paramString2)
  {
    return new bljl(1).b("sText", paramString2).b("sTitle", paramString1);
  }
  
  public static bljl a(ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, String paramString3)
  {
    paramArrayList = new bljl(8).a("sPathList", paramArrayList).b("sTitle", paramString1).a("bOnlyPic", paramBoolean1).b("sText", paramString2).a("bAppShare", paramBoolean2).a("lAppId", paramLong).b("sAppName", paramString3);
    if (paramBoolean2) {}
    for (paramLong = 4L;; paramLong = 1L) {
      return paramArrayList.a("lCategory", paramLong);
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("lUin");
      if (paramIntent.getBooleanExtra("bFailed", false)) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      bljn.a(paramActivity, str, bool, null, false);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject1 = (MessageForArkApp)paramChatMessage;
    if ((localObject1 == null) || (((MessageForArkApp)localObject1).ark_app_message == null)) {}
    Object localObject2;
    label50:
    Object localObject3;
    Object localObject4;
    do
    {
      return;
      localObject2 = (MessageForArkApp)apoe.a(1, ((MessageForArkApp)localObject1).ark_app_message.appName, localObject1, localObject1);
      if (localObject2 != null) {
        break;
      }
      localObject2 = localObject1;
      if ((localObject2 == null) || (((MessageForArkApp)localObject2).ark_app_message == null)) {
        break label553;
      }
      try
      {
        localObject3 = new JSONObject(((MessageForArkApp)localObject2).ark_app_message.metaList);
        if (aqlt.c.equals(((MessageForArkApp)localObject1).ark_app_message.appName))
        {
          localObject4 = ((JSONObject)localObject3).getJSONObject("Location.Search");
          localObject1 = ((JSONObject)localObject4).getString("name");
          localObject2 = ((JSONObject)localObject4).getString("address");
          localObject3 = ((JSONObject)localObject4).getString("lat");
          localObject4 = ((JSONObject)localObject4).getString("lng");
          a(Float.parseFloat((String)localObject3), Float.parseFloat((String)localObject4), (String)localObject1, (String)localObject2, "").b(paramQQAppInterface, paramChatMessage).a((Activity)paramContext, paramChatMessage.senderuin);
          bljv.a(paramQQAppInterface, 11, 0, paramChatMessage.istroop);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("qqfav", 1, paramQQAppInterface, new Object[0]);
        return;
      }
    } while (!"com.tencent.structmsg".equals(((MessageForArkApp)localObject1).ark_app_message.appName));
    localObject1 = null;
    int i = 0;
    if (((JSONObject)localObject3).has("music"))
    {
      localObject1 = ((JSONObject)localObject3).getJSONObject("music");
      i = 1;
    }
    if (((JSONObject)localObject3).has("news")) {
      localObject1 = ((JSONObject)localObject3).getJSONObject("news");
    }
    String str1;
    String str2;
    String str3;
    String str4;
    if (localObject1 != null)
    {
      localObject3 = paramContext.getString(2131717609);
      localObject4 = ((JSONObject)localObject1).getString("title") + "-" + ((JSONObject)localObject1).optString("desc");
      str1 = ((JSONObject)localObject1).optString("tag");
      str2 = ((JSONObject)localObject1).getString("preview");
      str3 = ((JSONObject)localObject1).getString("jumpUrl");
      str4 = ((JSONObject)localObject1).optString("musicUrl", "");
      localObject1 = Long.valueOf(((JSONObject)localObject1).getLong("appid"));
      if ((((Long)localObject1).longValue() == 100243533L) || (((Long)localObject1).longValue() == 100497308L) || (((Long)localObject1).longValue() == 100495085L) || (((Long)localObject1).longValue() == 205141L) || (((Long)localObject1).longValue() == 100895899L)) {
        break label555;
      }
      label449:
      localObject1 = ((MessageForArkApp)localObject2).ark_app_message.toAppXml().getBytes();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      if (i == 0) {
        break label560;
      }
    }
    label553:
    label555:
    label560:
    for (i = 4;; i = 5)
    {
      a(i, (String)localObject3, str3, str1, (String)localObject4, str2, str4, null, false, 0L).b("sBizDataList", (ArrayList)localObject2).b(paramQQAppInterface, paramChatMessage).a((Activity)paramContext, paramChatMessage.senderuin);
      bljv.a(paramQQAppInterface, 9, 0, paramChatMessage.istroop);
      return;
      bljv.a(paramQQAppInterface, 8, 0, paramChatMessage.istroop);
      return;
      break label50;
      break;
      i = 1;
      break label449;
    }
  }
  
  public static bljl b(Entity paramEntity)
  {
    return new bljl(8).c(paramEntity);
  }
  
  public static bljl b(String paramString)
  {
    return new bljl(2).b("sPath", paramString);
  }
  
  public Intent a()
  {
    return this.a;
  }
  
  public bljl a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.a.putExtra("nAuthorType", paramInt).putExtra("lUin", paramLong1).putExtra("sName", paramString1).putExtra("lGroupUin", paramLong2).putExtra("sGroupName", paramString2);
    return this;
  }
  
  public bljl a(long paramLong)
  {
    return a("requestId", paramLong);
  }
  
  public bljl a(long paramLong, String paramString)
  {
    this.a.putExtra("nAuthorType", 1).putExtra("lUin", paramLong).putExtra("sName", paramString);
    return this;
  }
  
  public bljl a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    return a(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue(), paramQQAppInterface.getCurrentNickname());
  }
  
  public bljl a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {
      return this;
    }
    return a(paramQQAppInterface, paramMessageRecord, paramMessageRecord.senderuin, paramMessageRecord.frienduin, paramMessageRecord.issend, paramMessageRecord.istroop);
  }
  
  public bljl a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    int i = bljz.a(paramInt2);
    String str2 = "";
    long l6 = 0L;
    Object localObject4 = "";
    long l5 = 0L;
    String str1;
    long l4;
    Object localObject2;
    long l3;
    Object localObject1;
    Object localObject3;
    long l2;
    if (TextUtils.isEmpty(paramString1))
    {
      i = 1;
      paramInt2 = 0;
      str1 = paramString2;
      l4 = l5;
      localObject2 = localObject4;
      paramString1 = str2;
      l3 = l6;
      for (;;)
      {
        try
        {
          if (!bgnr.a(paramInt1)) {
            continue;
          }
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = str2;
          l3 = l6;
          localObject1 = paramQQAppInterface.getCurrentNickname();
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = (String)localObject1;
          l3 = l6;
          l1 = Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue();
          localObject3 = localObject4;
          l2 = l5;
          label125:
          localObject4 = localObject1;
          if (paramMessageRecord != null)
          {
            localObject4 = localObject1;
            l4 = l2;
            localObject2 = localObject3;
            paramString1 = (String)localObject1;
            l3 = l1;
            if (njo.a(paramMessageRecord))
            {
              l4 = l2;
              localObject2 = localObject3;
              paramString1 = (String)localObject1;
              l3 = l1;
              if (paramMessageRecord.selfuin != null)
              {
                localObject4 = localObject1;
                l4 = l2;
                localObject2 = localObject3;
                paramString1 = (String)localObject1;
                l3 = l1;
                if (paramMessageRecord.selfuin.equals(paramMessageRecord.senderuin)) {}
              }
              else
              {
                l4 = l2;
                localObject2 = localObject3;
                paramString1 = (String)localObject1;
                l3 = l1;
                localObject4 = BaseApplicationImpl.getContext().getString(2131689989);
              }
            }
          }
          l4 = l2;
          localObject2 = localObject3;
          paramString1 = (String)localObject4;
          l3 = l1;
          localObject1 = bfre.a(paramMessageRecord);
          paramMessageRecord = (MessageRecord)localObject4;
          if (localObject1 == null) {
            break label957;
          }
          l4 = l2;
          localObject2 = localObject3;
          paramString1 = (String)localObject4;
          l3 = l1;
          paramMessageRecord = ((bfrf)localObject1).c;
        }
        catch (Exception paramString2)
        {
          label293:
          label460:
          l2 = l3;
          label404:
          label548:
          paramQQAppInterface = localObject2;
          paramMessageRecord = paramString1;
          long l1 = l4;
          paramString1 = paramString2;
          paramString1.printStackTrace();
          l3 = l1;
          continue;
          localObject1 = str1;
          continue;
          localObject1 = paramString2;
          continue;
        }
        if (1000 != paramInt2) {
          continue;
        }
        l4 = l2;
        localObject2 = localObject3;
        paramString1 = paramMessageRecord;
        l3 = l1;
        localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
        if (localObject1 == null) {
          continue;
        }
        l4 = l2;
        localObject2 = localObject3;
        paramString1 = paramMessageRecord;
        l3 = l1;
        localObject1 = ((TroopManager)localObject1).b(str1);
        l4 = l2;
        localObject2 = localObject3;
        paramString1 = paramMessageRecord;
        l3 = l1;
        localObject3 = bglf.a(paramQQAppInterface, (String)localObject1, true);
        l4 = l2;
        localObject2 = localObject3;
        paramString1 = paramMessageRecord;
        l3 = l1;
        l2 = Long.valueOf((String)localObject1).longValue();
        paramString1 = (String)localObject3;
        if (paramInt2 != 1004)
        {
          localObject1 = paramString1;
          l3 = l2;
          if (paramInt2 != 3000) {}
        }
        else if (paramInt2 == 1004)
        {
          paramString2 = str1;
        }
        try
        {
          localObject1 = bglf.c(paramQQAppInterface, paramString2);
          paramString1 = (String)localObject1;
          l3 = Long.valueOf(paramString2).longValue();
          paramQQAppInterface = (QQAppInterface)localObject1;
          l2 = l1;
          return a(i, l2, paramMessageRecord, l3, paramQQAppInterface);
        }
        catch (Exception paramString2)
        {
          paramQQAppInterface = paramString1;
          l3 = l2;
          paramString1 = paramString2;
          l2 = l1;
          l1 = l3;
          continue;
        }
        if (paramInt2 != 1006) {
          break label986;
        }
        l2 = l5;
        localObject3 = localObject4;
        localObject1 = str2;
        l1 = l6;
        if (str1 != null)
        {
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = str2;
          l3 = l6;
          localObject1 = bglf.b(paramQQAppInterface, str1, paramInt2);
          l1 = 0L;
          l2 = l5;
          localObject3 = localObject4;
          continue;
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = str2;
          l3 = l6;
          localObject1 = bglf.b(paramQQAppInterface, paramString2, paramInt2);
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = (String)localObject1;
          l3 = l6;
          l1 = Long.valueOf(paramString2).longValue();
          l2 = l5;
          localObject3 = localObject4;
        }
      }
    }
    for (;;)
    {
      label609:
      l4 = l5;
      localObject2 = localObject4;
      paramString1 = str2;
      l3 = l6;
      localObject3 = bglf.b(paramQQAppInterface, str1, 0);
      localObject1 = localObject3;
      l4 = l5;
      localObject2 = localObject4;
      paramString1 = (String)localObject3;
      l3 = l6;
      if (((String)localObject3).equals(str1))
      {
        localObject1 = localObject3;
        if (paramInt2 == 3000)
        {
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = (String)localObject3;
          l3 = l6;
          localObject1 = bglf.a(paramQQAppInterface, paramString2, str1);
        }
      }
      l4 = l5;
      localObject2 = localObject4;
      paramString1 = (String)localObject1;
      l3 = l6;
      l1 = Long.valueOf(str1).longValue();
      if (1 == paramInt2)
      {
        l4 = l5;
        localObject2 = localObject4;
        paramString1 = (String)localObject1;
        l3 = l1;
      }
      for (localObject3 = bglf.a(paramQQAppInterface, paramString2, true);; localObject3 = bglf.c(paramQQAppInterface, paramString2))
      {
        l4 = l5;
        localObject2 = localObject3;
        paramString1 = (String)localObject1;
        l3 = l1;
        l2 = Long.valueOf(paramString2).longValue();
        break;
        l4 = l5;
        localObject2 = localObject4;
        paramString1 = (String)localObject1;
        l3 = l1;
      }
      label957:
      label986:
      do
      {
        l4 = l5;
        localObject2 = localObject4;
        paramString1 = str2;
        l3 = l6;
        localObject1 = bglf.b(paramQQAppInterface, str1, paramInt2);
        l4 = l5;
        localObject2 = localObject4;
        paramString1 = (String)localObject1;
        l3 = l6;
        l1 = Long.valueOf(str1).longValue();
        l2 = l5;
        localObject3 = localObject4;
        break label125;
        do
        {
          paramString1 = (String)localObject3;
          break label404;
          do
          {
            localObject1 = localObject3;
            l3 = l2;
            break label460;
            str1 = paramString1;
            break;
          } while ((2 != i) && (3 != i));
          if (1 == paramInt2) {
            break label293;
          }
        } while (1000 != paramInt2);
        break label293;
        if ((paramInt2 == 1004) || (paramInt2 == 1000)) {
          break label548;
        }
        if (paramInt2 == 1) {
          break label609;
        }
      } while (paramInt2 != 3000);
    }
  }
  
  public bljl a(String paramString, float paramFloat)
  {
    this.a.putExtra(paramString, paramFloat);
    return this;
  }
  
  public bljl a(String paramString, int paramInt)
  {
    this.a.putExtra(paramString, paramInt);
    return this;
  }
  
  public bljl a(String paramString, long paramLong)
  {
    this.a.putExtra(paramString, paramLong);
    return this;
  }
  
  public bljl a(String paramString, ArrayList<String> paramArrayList)
  {
    this.a.putStringArrayListExtra(paramString, paramArrayList);
    return this;
  }
  
  public bljl a(String paramString, boolean paramBoolean)
  {
    this.a.putExtra(paramString, paramBoolean);
    return this;
  }
  
  public boolean a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131691987, null);
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    if (paramActivity == null) {
      return false;
    }
    this.a.putExtra("nOperation", 1);
    this.a.putExtra("lCollectTime", System.currentTimeMillis());
    if (paramIntent != null) {
      paramIntent.putExtras(this.a);
    }
    for (;;)
    {
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
      paramIntent = this.a;
    }
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    bljw.a().a = true;
    if (paramActivity == null) {
      return false;
    }
    this.a.putExtra("nOperation", 0);
    this.a.putExtra("lCollectTime", System.currentTimeMillis());
    if (paramIntent != null)
    {
      paramIntent.putExtras(this.a);
      switch (paramIntent.getIntExtra("nType", 0))
      {
      }
    }
    String str;
    do
    {
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt, paramBoolean);
      paramIntent = this.a;
      break;
      str = paramIntent.getStringExtra("sPath");
    } while ((paramIntent.getIntExtra("nPicType", 1) != 1) || (!bljz.a(str, paramIntent.getLongExtra("lSize", -1L))));
    paramIntent.putExtra("nReasonInt", 2131694330);
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 1, "QfavBuilder.add: picture too big [" + str + "]");
    }
    bljv.a(null, "Net_AddFav", 3, 3, -3);
    return false;
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, bljm parambljm)
  {
    Object localObject2 = null;
    boolean bool = b(paramActivity, paramString, -1, null);
    Object localObject1 = localObject2;
    if (!bool)
    {
      localObject1 = localObject2;
      if (this.a != null) {
        localObject1 = paramActivity.getString(this.a.getIntExtra("nReasonInt", 2131691988));
      }
    }
    bljn.a(paramActivity, paramString, bool, (String)localObject1, false, paramInt);
    if (parambljm != null) {
      parambljm.b(bool);
    }
    return bool;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt, Intent paramIntent)
  {
    bljw.a().a = true;
    if (paramContext == null) {
      return false;
    }
    this.a.putExtra("nOperation", 0);
    this.a.putExtra("lCollectTime", System.currentTimeMillis());
    if (paramIntent != null)
    {
      paramIntent.putExtras(this.a);
      switch (paramIntent.getIntExtra("nType", 0))
      {
      }
    }
    String str;
    do
    {
      return QfavPluginProxyActivity.a(paramContext, paramString, paramIntent, paramInt);
      paramIntent = this.a;
      break;
      str = paramIntent.getStringExtra("sPath");
    } while ((paramIntent.getIntExtra("nPicType", 1) != 1) || (!bljz.a(str, paramIntent.getLongExtra("lSize", -1L))));
    paramIntent.putExtra("nReasonInt", 2131694330);
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 1, "QfavBuilder.add: picture too big [" + str + "]");
    }
    bljv.a(null, "Net_AddFav", 3, 3, -3);
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    return a(paramQQAppInterface, paramContext, paramFileManagerEntity, paramChatMessage, paramBoolean, "", false);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramFileManagerEntity == null) && (TextUtils.isEmpty(paramString))) {
      return false;
    }
    bljw.a().a = true;
    int m;
    String str1;
    if (paramBoolean2)
    {
      m = 3;
      if (m != 5) {
        break label1212;
      }
      str1 = paramFileManagerEntity.strFilePath;
      paramBoolean2 = true;
    }
    for (;;)
    {
      if ((paramBoolean2) && (!TextUtils.isEmpty(str1))) {}
      for (paramString = new File(str1);; paramString = null)
      {
        label78:
        String str2;
        int n;
        int j;
        int i;
        if (paramFileManagerEntity != null)
        {
          localObject = paramFileManagerEntity.fileName;
          str2 = atwl.a((String)localObject);
          n = 6;
          if (paramChatMessage == null) {
            n = 7;
          }
          j = -1;
          i = j;
          if (paramFileManagerEntity != null) {
            i = j;
          }
          switch (paramFileManagerEntity.getCloudType())
          {
          default: 
            i = j;
          case 3: 
            label152:
            if (paramFileManagerEntity == null) {
              break;
            }
          }
        }
        for (paramString = paramFileManagerEntity.fileName.getBytes();; paramString = paramString.getName().getBytes())
        {
          if (paramString.length < 256) {
            break label315;
          }
          if (!paramBoolean1) {
            bljz.a(paramContext, 2131691990, 1);
          }
          bljv.a(paramQQAppInterface, "User_AddFav", 6, -80010, n, i, str2, null);
          paramQQAppInterface = new ContentValues();
          paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692004));
          this.a.putExtra("fileContents", paramQQAppInterface);
          return false;
          m = atvo.a(paramFileManagerEntity);
          break;
          localObject = str1;
          break label78;
          if (3000 == paramFileManagerEntity.peerType)
          {
            i = 106;
            break label152;
          }
          i = 3;
          break label152;
          i = paramFileManagerEntity.busId;
          break label152;
          i = 25;
          break label152;
        }
        switch (m)
        {
        default: 
          if (!paramBoolean1) {
            bljz.a(paramContext, 2131691991, 0);
          }
          bljv.a(paramQQAppInterface, "User_AddFav", 6, -80003, n, i, str2, null);
          paramQQAppInterface = new ContentValues();
          paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692006));
          this.a.putExtra("fileContents", paramQQAppInterface);
          return false;
        case 1: 
          if ((paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
          {
            if (!paramBoolean1) {
              bljz.a(paramContext, 2131691989, 1);
            }
            bljv.a(paramQQAppInterface, "User_AddFav", 6, -80011, n, i, str2, null);
            paramQQAppInterface = new ContentValues();
            paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692003));
            this.a.putExtra("fileContents", paramQQAppInterface);
            return false;
          }
          break;
        case 4: 
          label315:
          if ((104 == paramFileManagerEntity.busId) && (paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
          {
            if (!paramBoolean1) {
              bljz.a(paramContext, 2131691989, 1);
            }
            bljv.a(paramQQAppInterface, "User_AddFav", 6, -80011, n, i, str2, null);
            paramQQAppInterface = new ContentValues();
            paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692003));
            this.a.putExtra("fileContents", paramQQAppInterface);
            return false;
          }
          break;
        }
        if (paramChatMessage != null) {
          a(paramQQAppInterface, paramChatMessage);
        }
        label688:
        label817:
        while (paramFileManagerEntity == null)
        {
          localObject = "";
          paramString = (String)localObject;
          switch (m)
          {
          default: 
            paramString = (String)localObject;
          case 3: 
            localObject = new ContentValues();
            ((ContentValues)localObject).put("fileCloudType", Integer.valueOf(m));
            if (paramFileManagerEntity == null) {
              break label1174;
            }
            ((ContentValues)localObject).put("fileUuId", paramString);
            ((ContentValues)localObject).put("fileSize", Long.valueOf(paramFileManagerEntity.fileSize));
            ((ContentValues)localObject).put("fileName", paramFileManagerEntity.fileName);
            ((ContentValues)localObject).put("fileMd5", paramFileManagerEntity.strFileMd5);
            ((ContentValues)localObject).put("filePath", paramFileManagerEntity.getFilePath());
            ((ContentValues)localObject).put("fileThumbPath", paramFileManagerEntity.strThumbPath);
            ((ContentValues)localObject).put("filePeerType", Integer.valueOf(paramFileManagerEntity.peerType));
            ((ContentValues)localObject).put("fileBid", Integer.valueOf(paramFileManagerEntity.busId));
            this.a.putExtra("fileContents", (Parcelable)localObject);
            if (paramBoolean1) {
              break label1187;
            }
            paramBoolean1 = a(paramContext, paramQQAppInterface.getAccount(), -1, null);
            str1 = null;
            paramString = str1;
            if (!paramBoolean1)
            {
              paramString = str1;
              if (this.a != null) {
                paramString = paramContext.getString(this.a.getIntExtra("nReasonInt", 2131691988));
              }
            }
            paramQQAppInterface.runOnUiThread(new QfavBuilder.1(this, paramContext, paramQQAppInterface, paramBoolean1, paramString));
            if (paramChatMessage != null) {
              bljv.a(paramQQAppInterface, 5, paramFileManagerEntity.nFileType, paramChatMessage.istroop);
            }
            bljv.a(paramQQAppInterface, "User_AddFav", 6, 0, n, i, str2, null);
            return paramBoolean1;
          }
        }
        label908:
        paramString = paramFileManagerEntity.selfUin;
        Object localObject = paramFileManagerEntity.peerUin;
        int k;
        if (paramFileManagerEntity.bSend)
        {
          k = 1;
          label973:
          int i1 = 0;
          switch (paramFileManagerEntity.peerType)
          {
          default: 
            j = i1;
            if (!paramFileManagerEntity.bSend)
            {
              paramString = paramFileManagerEntity.peerUin;
              j = i1;
            }
            label1045:
            if (TextUtils.isEmpty(paramString))
            {
              paramString = paramQQAppInterface.getCurrentAccountUin();
              k = 1;
            }
            break;
          }
        }
        for (;;)
        {
          a(paramQQAppInterface, null, paramString, (String)localObject, k, j);
          break;
          k = 0;
          break label973;
          j = 1;
          break label1045;
          j = 3000;
          break label1045;
          j = 1004;
          break label1045;
          paramString = paramFileManagerEntity.Uuid;
          break label688;
          paramString = paramFileManagerEntity.strTroopFilePath;
          break label688;
          if (TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey))
          {
            paramString = paramFileManagerEntity.WeiYunFileId;
            break label688;
          }
          paramString = paramFileManagerEntity.WeiYunDirKey + paramFileManagerEntity.WeiYunFileId;
          break label688;
          label1174:
          ((ContentValues)localObject).put("filePath", str1);
          break label817;
          label1187:
          paramBoolean1 = a(paramContext, paramQQAppInterface.getAccount(), -1, null);
          break label908;
        }
      }
      label1212:
      str1 = paramString;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    return a(paramQQAppInterface, paramContext, null, null, false, paramString, true);
  }
  
  public bljl b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramMessageRecord);
    if (paramMessageRecord == null) {}
    for (long l = new Date().getTime();; l = paramMessageRecord.time * 1000L) {
      return paramQQAppInterface.a("lCreateTime", l);
    }
  }
  
  public bljl b(String paramString1, String paramString2)
  {
    this.a.putExtra(paramString1, paramString2);
    return this;
  }
  
  public bljl b(String paramString, ArrayList<byte[]> paramArrayList)
  {
    this.a.putExtra(paramString, paramArrayList);
    return this;
  }
  
  public boolean b(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    return a(paramActivity, paramString, paramInt, paramIntent, true);
  }
  
  public bljl c(Entity paramEntity)
  {
    this.a.putExtra("cvEntityContents", bljz.a(paramEntity, ""));
    this.a.putExtra("sEntityClassName", paramEntity.getClass().getName());
    return this;
  }
  
  public bljl c(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      this.a.putExtra("nAuthorType", 1).putExtra("lUin", l);
      return this;
    }
    catch (Exception paramString) {}
    return this;
  }
  
  public boolean c(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    boolean bool = b(paramActivity, paramString, paramInt, paramIntent);
    bljn.a(paramActivity, paramString, bool, "", false, 2131691987);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljl
 * JD-Core Version:    0.7.0.1
 */