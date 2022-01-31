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
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder.1;
import cooperation.qqfav.QfavPluginProxyActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class biqt
{
  private Intent a;
  
  public biqt(int paramInt)
  {
    this.a = new Intent();
    this.a.putExtra("nType", paramInt);
  }
  
  public biqt(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public static biqt a(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3)
  {
    return new biqt(7).b("sLocation", paramString2).b("sBrief", paramString3).b("sPublisher", paramString1).a("fLatitude", paramFloat1).a("fLongitude", paramFloat2);
  }
  
  public static biqt a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    String str6 = paramString1;
    String str5 = paramString2;
    String str4 = paramString3;
    String str3 = paramString4;
    String str2 = paramString5;
    String str1 = paramString6;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = birl.a(paramArrayOfByte);
      str6 = birl.a(paramArrayOfByte[0], paramString1);
      str5 = birl.a(paramArrayOfByte[1], paramString2);
      str4 = birl.a(paramArrayOfByte[2], paramString3);
      str3 = birl.a(paramArrayOfByte[3], paramString4);
      str2 = birl.a(paramArrayOfByte[4], paramString5);
      str1 = birl.a(paramArrayOfByte[5], paramString6);
    }
    paramString1 = new biqt(6).a("nLinkType", paramInt).b("sTitle", str6).b("sUrl", str5).a("bAppShare", paramBoolean).a("lAppId", paramLong).b("sPublisher", str4).b("sBrief", str3).b("sPath", str2).b("sResUrl", str1);
    if (paramBoolean) {}
    for (paramLong = 4L;; paramLong = 1L) {
      return paramString1.a("lCategory", paramLong);
    }
  }
  
  public static biqt a(Intent paramIntent)
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
        break label330;
      }
      l = new File((String)localObject).length();
      label132:
      localContentValues.put("shortVideoSize", Long.valueOf(l));
      String str = paramIntent.getStringExtra("file_name");
      localContentValues.put("shortVideoFileName", str.substring(str.lastIndexOf('/') + 1, str.length()));
      localContentValues.put("shortVideoThumbHeight", Integer.valueOf(paramIntent.getIntExtra("thumbfile_send_height", 0)));
      localContentValues.put("shortVideoThumbMd5", paramIntent.getStringExtra("thumbfile_md5"));
      if (!new File((String)localObject).exists()) {
        break label335;
      }
    }
    label330:
    label335:
    for (i = (int)new File((String)localObject).length();; i = paramIntent.getIntExtra("file_thumb_Size", 0))
    {
      localContentValues.put("shortVideoThumbSize", Integer.valueOf(i));
      localContentValues.put("shortVideoThumbWidth", Integer.valueOf(paramIntent.getIntExtra("thumbfile_send_width", 0)));
      localContentValues.put("shortVideoThumbLocalPath", paramIntent.getStringExtra("thumbfile_send_path"));
      localContentValues.put("shortVideoUuid", paramIntent.getStringExtra("file_uuid"));
      localObject = new biqt(5);
      ((biqt)localObject).a.putExtra("shortVideoContents", localContentValues);
      return ((biqt)localObject).c(paramIntent.getStringExtra("from_uin"));
      i = j;
      break;
      l = 0L;
      break label132;
    }
  }
  
  public static biqt a(awbv paramawbv)
  {
    return new biqt(2).c(paramawbv);
  }
  
  public static biqt a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, List<ChatMessage> paramList, Map<String, String> paramMap)
  {
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {
      return null;
    }
    biqt localbiqt = new biqt(8).c(paramMessageForStructing);
    if (!birl.a(paramMessageForStructing))
    {
      localbiqt.c(paramMessageForStructing);
      return localbiqt;
    }
    ArrayList localArrayList = new ArrayList();
    byte[] arrayOfByte = birl.a(paramMessageForStructing.uniseq, paramMessageForStructing.structingMsg);
    if (arrayOfByte != null) {
      localArrayList.add(arrayOfByte);
    }
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (long l = 1L;; l = paramList.size())
    {
      arrayOfByte = birl.a(paramMessageForStructing.uniseq, l);
      if (arrayOfByte != null) {
        localArrayList.add(arrayOfByte);
      }
      arrayOfByte = birl.a(-1L, paramMap);
      if (arrayOfByte != null) {
        localArrayList.add(arrayOfByte);
      }
      birl.a(paramQQAppInterface, paramMessageForStructing, paramList, paramMap, localArrayList);
      if (localArrayList != null) {
        localbiqt.b("sBizDataList", localArrayList);
      }
      return localbiqt;
    }
  }
  
  public static biqt a(MessageForShortVideo paramMessageForShortVideo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("shortVideoDuration", Integer.valueOf(paramMessageForShortVideo.videoFileTime));
    localContentValues.put("shortVideoFileTYPE", Integer.valueOf(paramMessageForShortVideo.fileType));
    localContentValues.put("shortVideoFormat", Integer.valueOf(paramMessageForShortVideo.videoFileFormat));
    localContentValues.put("shortVideoMd5", paramMessageForShortVideo.md5);
    int i;
    String str;
    if (paramMessageForShortVideo.busiType == 0)
    {
      i = 1;
      localContentValues.put("shortVideoBusiType", Integer.valueOf(i));
      str = ShortVideoUtils.c(paramMessageForShortVideo);
      localContentValues.put("shortVideoLocalPath", str);
      long l2 = paramMessageForShortVideo.videoFileSize;
      l1 = l2;
      if (str != null)
      {
        l1 = l2;
        if (new File(str).exists()) {
          l1 = new File(str).length();
        }
      }
      localContentValues.put("shortVideoSize", Long.valueOf(l1));
      if (str != null) {
        break label332;
      }
      str = "";
      label165:
      localContentValues.put("shortVideoFileName", str.substring(str.lastIndexOf('/') + 1, str.length()));
      localContentValues.put("shortVideoThumbHeight", Integer.valueOf(paramMessageForShortVideo.thumbHeight));
      localContentValues.put("shortVideoThumbMd5", paramMessageForShortVideo.thumbMD5);
      localContentValues.put("shortVideoThumbWidth", Integer.valueOf(paramMessageForShortVideo.thumbWidth));
      str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      if (!new File(str).exists()) {
        break label335;
      }
    }
    label332:
    label335:
    for (long l1 = new File(str).length();; l1 = paramMessageForShortVideo.thumbFileSize)
    {
      localContentValues.put("shortVideoThumbSize", Long.valueOf(l1));
      localContentValues.put("shortVideoThumbLocalPath", str);
      localContentValues.put("shortVideoUuid", paramMessageForShortVideo.uuid);
      paramMessageForShortVideo = new biqt(5);
      paramMessageForShortVideo.a.putExtra("shortVideoContents", localContentValues);
      return paramMessageForShortVideo;
      i = paramMessageForShortVideo.busiType;
      break;
      break label165;
    }
  }
  
  public static biqt a(String paramString)
  {
    return new biqt(6).b("sUrl", paramString);
  }
  
  public static biqt a(String paramString1, int paramInt, String paramString2)
  {
    return new biqt(4).b("sPath", paramString1).a("nDuration", paramInt).b("sBrief", paramString2);
  }
  
  public static biqt a(String paramString1, int paramInt, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    paramInt = birl.b(paramInt);
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if ((4 == paramInt) || (5 == paramInt)) {
        paramString2 = String.valueOf(paramLong1);
      }
      return new biqt(2).b("sMD5", paramString1).b("sPath", paramString3).a("nPicType", paramInt).b("sPicId", paramString2).a("lSize", paramLong2);
    }
  }
  
  public static biqt a(String paramString1, String paramString2)
  {
    return new biqt(1).b("sText", paramString2).b("sTitle", paramString1);
  }
  
  public static biqt a(ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, String paramString3)
  {
    paramArrayList = new biqt(8).a("sPathList", paramArrayList).b("sTitle", paramString1).a("bOnlyPic", paramBoolean1).b("sText", paramString2).a("bAppShare", paramBoolean2).a("lAppId", paramLong).b("sAppName", paramString3);
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
      biqv.a(paramActivity, str, bool, null, false);
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
      localObject2 = (MessageForArkApp)anjp.a(1, ((MessageForArkApp)localObject1).ark_app_message.appName, localObject1, localObject1);
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
        if (aogs.c.equals(((MessageForArkApp)localObject1).ark_app_message.appName))
        {
          localObject4 = ((JSONObject)localObject3).getJSONObject("Location.Search");
          localObject1 = ((JSONObject)localObject4).getString("name");
          localObject2 = ((JSONObject)localObject4).getString("address");
          localObject3 = ((JSONObject)localObject4).getString("lat");
          localObject4 = ((JSONObject)localObject4).getString("lng");
          a(Float.parseFloat((String)localObject3), Float.parseFloat((String)localObject4), (String)localObject1, (String)localObject2, "").b(paramQQAppInterface, paramChatMessage).a((Activity)paramContext, paramChatMessage.senderuin);
          birh.a(paramQQAppInterface, 11, 0, paramChatMessage.istroop);
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
      localObject3 = paramContext.getString(2131719559);
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
      birh.a(paramQQAppInterface, 9, 0, paramChatMessage.istroop);
      return;
      birh.a(paramQQAppInterface, 8, 0, paramChatMessage.istroop);
      return;
      break label50;
      break;
      i = 1;
      break label449;
    }
  }
  
  public static biqt b(awbv paramawbv)
  {
    return new biqt(8).c(paramawbv);
  }
  
  public static biqt b(String paramString)
  {
    return new biqt(2).b("sPath", paramString);
  }
  
  public Intent a()
  {
    return this.a;
  }
  
  public biqt a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.a.putExtra("nAuthorType", paramInt).putExtra("lUin", paramLong1).putExtra("sName", paramString1).putExtra("lGroupUin", paramLong2).putExtra("sGroupName", paramString2);
    return this;
  }
  
  public biqt a(long paramLong)
  {
    return a("requestId", paramLong);
  }
  
  public biqt a(long paramLong, String paramString)
  {
    this.a.putExtra("nAuthorType", 1).putExtra("lUin", paramLong).putExtra("sName", paramString);
    return this;
  }
  
  public biqt a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    return a(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue(), paramQQAppInterface.getCurrentNickname());
  }
  
  public biqt a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {
      return this;
    }
    return a(paramQQAppInterface, paramMessageRecord, paramMessageRecord.senderuin, paramMessageRecord.frienduin, paramMessageRecord.issend, paramMessageRecord.istroop);
  }
  
  public biqt a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    int i = birl.a(paramInt2);
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
          if (!bdec.a(paramInt1)) {
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
            if (nav.a(paramMessageRecord))
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
                localObject4 = BaseApplicationImpl.getContext().getString(2131690099);
              }
            }
          }
          l4 = l2;
          localObject2 = localObject3;
          paramString1 = (String)localObject4;
          l3 = l1;
          localObject1 = bcid.a(paramMessageRecord);
          paramMessageRecord = (MessageRecord)localObject4;
          if (localObject1 == null) {
            break label957;
          }
          l4 = l2;
          localObject2 = localObject3;
          paramString1 = (String)localObject4;
          l3 = l1;
          paramMessageRecord = ((bcie)localObject1).c;
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
        localObject3 = bdbt.a(paramQQAppInterface, (String)localObject1, true);
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
          localObject1 = bdbt.c(paramQQAppInterface, paramString2);
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
          localObject1 = bdbt.b(paramQQAppInterface, str1, paramInt2);
          l1 = 0L;
          l2 = l5;
          localObject3 = localObject4;
          continue;
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = str2;
          l3 = l6;
          localObject1 = bdbt.b(paramQQAppInterface, paramString2, paramInt2);
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
      localObject3 = bdbt.b(paramQQAppInterface, str1, 0);
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
          localObject1 = bdbt.a(paramQQAppInterface, paramString2, str1);
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
      for (localObject3 = bdbt.a(paramQQAppInterface, paramString2, true);; localObject3 = bdbt.c(paramQQAppInterface, paramString2))
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
        localObject1 = bdbt.b(paramQQAppInterface, str1, paramInt2);
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
  
  public biqt a(String paramString, float paramFloat)
  {
    this.a.putExtra(paramString, paramFloat);
    return this;
  }
  
  public biqt a(String paramString, int paramInt)
  {
    this.a.putExtra(paramString, paramInt);
    return this;
  }
  
  public biqt a(String paramString, long paramLong)
  {
    this.a.putExtra(paramString, paramLong);
    return this;
  }
  
  public biqt a(String paramString, ArrayList<String> paramArrayList)
  {
    this.a.putStringArrayListExtra(paramString, paramArrayList);
    return this;
  }
  
  public biqt a(String paramString, boolean paramBoolean)
  {
    this.a.putExtra(paramString, paramBoolean);
    return this;
  }
  
  public boolean a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131692401, null);
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
    biri.a().a = true;
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
    } while ((paramIntent.getIntExtra("nPicType", 1) != 1) || (!birl.a(str, paramIntent.getLongExtra("lSize", -1L))));
    paramIntent.putExtra("nReasonInt", 2131695350);
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 1, "QfavBuilder.add: picture too big [" + str + "]");
    }
    birh.a(null, "Net_AddFav", 3, 3, -3);
    return false;
  }
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, biqu parambiqu)
  {
    Object localObject2 = null;
    boolean bool = b(paramActivity, paramString, -1, null);
    Object localObject1 = localObject2;
    if (!bool)
    {
      localObject1 = localObject2;
      if (this.a != null) {
        localObject1 = paramActivity.getString(this.a.getIntExtra("nReasonInt", 2131692402));
      }
    }
    biqv.a(paramActivity, paramString, bool, (String)localObject1, false, paramInt);
    if (parambiqu != null) {
      parambiqu.b(bool);
    }
    return bool;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt, Intent paramIntent)
  {
    biri.a().a = true;
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
    } while ((paramIntent.getIntExtra("nPicType", 1) != 1) || (!birl.a(str, paramIntent.getLongExtra("lSize", -1L))));
    paramIntent.putExtra("nReasonInt", 2131695350);
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 1, "QfavBuilder.add: picture too big [" + str + "]");
    }
    birh.a(null, "Net_AddFav", 3, 3, -3);
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
    biri.a().a = true;
    if ((paramBoolean2) && (!TextUtils.isEmpty(paramString))) {}
    for (Object localObject1 = new File(paramString);; localObject1 = null)
    {
      String str;
      int m;
      int j;
      int i;
      if (paramFileManagerEntity != null)
      {
        localObject2 = paramFileManagerEntity.fileName;
        str = arof.a((String)localObject2);
        m = 6;
        if (paramChatMessage == null) {
          m = 7;
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
          label128:
          if (paramFileManagerEntity == null) {
            break;
          }
        }
      }
      for (localObject1 = paramFileManagerEntity.fileName.getBytes();; localObject1 = ((File)localObject1).getName().getBytes())
      {
        if (localObject1.length < 256) {
          break label282;
        }
        if (!paramBoolean1) {
          birl.a(paramContext, 2131692404, 1);
        }
        birh.a(paramQQAppInterface, "User_AddFav", 6, -80010, m, i, str, null);
        paramQQAppInterface = new ContentValues();
        paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692418));
        this.a.putExtra("fileContents", paramQQAppInterface);
        return false;
        localObject2 = paramString;
        break;
        if (3000 == paramFileManagerEntity.peerType)
        {
          i = 106;
          break label128;
        }
        i = 3;
        break label128;
        i = paramFileManagerEntity.busId;
        break label128;
        i = 25;
        break label128;
      }
      label282:
      if (paramBoolean2) {}
      for (int n = 3;; n = arni.a(paramFileManagerEntity)) {
        switch (n)
        {
        default: 
          if (!paramBoolean1) {
            birl.a(paramContext, 2131692405, 0);
          }
          birh.a(paramQQAppInterface, "User_AddFav", 6, -80003, m, i, str, null);
          paramQQAppInterface = new ContentValues();
          paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692420));
          this.a.putExtra("fileContents", paramQQAppInterface);
          return false;
        }
      }
      if ((paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
      {
        if (!paramBoolean1) {
          birl.a(paramContext, 2131692403, 1);
        }
        birh.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
        paramQQAppInterface = new ContentValues();
        paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692417));
        this.a.putExtra("fileContents", paramQQAppInterface);
        return false;
        if ((104 == paramFileManagerEntity.busId) && (paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
        {
          if (!paramBoolean1) {
            birl.a(paramContext, 2131692403, 1);
          }
          birh.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
          paramQQAppInterface = new ContentValues();
          paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131692417));
          this.a.putExtra("fileContents", paramQQAppInterface);
          return false;
        }
      }
      if (paramChatMessage != null) {
        a(paramQQAppInterface, paramChatMessage);
      }
      label668:
      label797:
      label888:
      while (paramFileManagerEntity == null)
      {
        localObject2 = "";
        localObject1 = localObject2;
        switch (n)
        {
        default: 
          localObject1 = localObject2;
        case 3: 
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("fileCloudType", Integer.valueOf(n));
          if (paramFileManagerEntity == null) {
            break label1154;
          }
          ((ContentValues)localObject2).put("fileUuId", (String)localObject1);
          ((ContentValues)localObject2).put("fileSize", Long.valueOf(paramFileManagerEntity.fileSize));
          ((ContentValues)localObject2).put("fileName", paramFileManagerEntity.fileName);
          ((ContentValues)localObject2).put("fileMd5", paramFileManagerEntity.strFileMd5);
          ((ContentValues)localObject2).put("filePath", paramFileManagerEntity.getFilePath());
          ((ContentValues)localObject2).put("fileThumbPath", paramFileManagerEntity.strThumbPath);
          ((ContentValues)localObject2).put("filePeerType", Integer.valueOf(paramFileManagerEntity.peerType));
          ((ContentValues)localObject2).put("fileBid", Integer.valueOf(paramFileManagerEntity.busId));
          this.a.putExtra("fileContents", (Parcelable)localObject2);
          if (paramBoolean1) {
            break label1167;
          }
          paramBoolean1 = a(paramContext, paramQQAppInterface.getAccount(), -1, null);
          localObject1 = null;
          paramString = (String)localObject1;
          if (!paramBoolean1)
          {
            paramString = (String)localObject1;
            if (this.a != null) {
              paramString = paramContext.getString(this.a.getIntExtra("nReasonInt", 2131692402));
            }
          }
          paramQQAppInterface.runOnUiThread(new QfavBuilder.1(this, paramContext, paramQQAppInterface, paramBoolean1, paramString));
          if (paramChatMessage != null) {
            birh.a(paramQQAppInterface, 5, paramFileManagerEntity.nFileType, paramChatMessage.istroop);
          }
          birh.a(paramQQAppInterface, "User_AddFav", 6, 0, m, i, str, null);
          return paramBoolean1;
        }
      }
      localObject1 = paramFileManagerEntity.selfUin;
      Object localObject2 = paramFileManagerEntity.peerUin;
      int k;
      if (paramFileManagerEntity.bSend)
      {
        k = 1;
        label953:
        int i1 = 0;
        switch (paramFileManagerEntity.peerType)
        {
        default: 
          j = i1;
          if (!paramFileManagerEntity.bSend)
          {
            localObject1 = paramFileManagerEntity.peerUin;
            j = i1;
          }
          label1025:
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = paramQQAppInterface.getCurrentAccountUin();
            k = 1;
          }
          break;
        }
      }
      for (;;)
      {
        a(paramQQAppInterface, null, (String)localObject1, (String)localObject2, k, j);
        break;
        k = 0;
        break label953;
        j = 1;
        break label1025;
        j = 3000;
        break label1025;
        j = 1004;
        break label1025;
        localObject1 = paramFileManagerEntity.Uuid;
        break label668;
        localObject1 = paramFileManagerEntity.strTroopFilePath;
        break label668;
        if (TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey))
        {
          localObject1 = paramFileManagerEntity.WeiYunFileId;
          break label668;
        }
        localObject1 = paramFileManagerEntity.WeiYunDirKey + paramFileManagerEntity.WeiYunFileId;
        break label668;
        label1154:
        ((ContentValues)localObject2).put("filePath", paramString);
        break label797;
        label1167:
        paramBoolean1 = a(paramContext, paramQQAppInterface.getAccount(), -1, null);
        break label888;
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    return a(paramQQAppInterface, paramContext, null, null, false, paramString, true);
  }
  
  public biqt b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramMessageRecord);
    if (paramMessageRecord == null) {}
    for (long l = 0L;; l = paramMessageRecord.time) {
      return paramQQAppInterface.a("lCreateTime", l * 1000L);
    }
  }
  
  public biqt b(String paramString1, String paramString2)
  {
    this.a.putExtra(paramString1, paramString2);
    return this;
  }
  
  public biqt b(String paramString, ArrayList<byte[]> paramArrayList)
  {
    this.a.putExtra(paramString, paramArrayList);
    return this;
  }
  
  public boolean b(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    return a(paramActivity, paramString, paramInt, paramIntent, true);
  }
  
  public biqt c(awbv paramawbv)
  {
    this.a.putExtra("cvEntityContents", birl.a(paramawbv, ""));
    this.a.putExtra("sEntityClassName", paramawbv.getClass().getName());
    return this;
  }
  
  public biqt c(String paramString)
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
    biqv.a(paramActivity, paramString, bool, "", false, 2131692401);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biqt
 * JD-Core Version:    0.7.0.1
 */