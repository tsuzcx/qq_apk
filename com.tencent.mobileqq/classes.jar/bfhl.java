import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
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

public class bfhl
{
  private Intent a;
  
  public bfhl(int paramInt)
  {
    this.a = new Intent();
    this.a.putExtra("nType", paramInt);
  }
  
  public bfhl(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public static bfhl a(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3)
  {
    return new bfhl(7).b("sLocation", paramString2).b("sBrief", paramString3).b("sPublisher", paramString1).a("fLatitude", paramFloat1).a("fLongitude", paramFloat2);
  }
  
  public static bfhl a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    String str6 = paramString1;
    String str5 = paramString2;
    String str4 = paramString3;
    String str3 = paramString4;
    String str2 = paramString5;
    String str1 = paramString6;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = bfid.a(paramArrayOfByte);
      str6 = bfid.a(paramArrayOfByte[0], paramString1);
      str5 = bfid.a(paramArrayOfByte[1], paramString2);
      str4 = bfid.a(paramArrayOfByte[2], paramString3);
      str3 = bfid.a(paramArrayOfByte[3], paramString4);
      str2 = bfid.a(paramArrayOfByte[4], paramString5);
      str1 = bfid.a(paramArrayOfByte[5], paramString6);
    }
    paramString1 = new bfhl(6).a("nLinkType", paramInt).b("sTitle", str6).b("sUrl", str5).a("bAppShare", paramBoolean).a("lAppId", paramLong).b("sPublisher", str4).b("sBrief", str3).b("sPath", str2).b("sResUrl", str1);
    if (paramBoolean) {}
    for (paramLong = 4L;; paramLong = 1L) {
      return paramString1.a("lCategory", paramLong);
    }
  }
  
  public static bfhl a(Intent paramIntent)
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
      localObject = new bfhl(5);
      ((bfhl)localObject).a.putExtra("shortVideoContents", localContentValues);
      return ((bfhl)localObject).c(paramIntent.getStringExtra("from_uin"));
      i = j;
      break;
      l = 0L;
      break label132;
    }
  }
  
  public static bfhl a(atmo paramatmo)
  {
    return new bfhl(2).c(paramatmo);
  }
  
  public static bfhl a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, List<ChatMessage> paramList, Map<String, String> paramMap)
  {
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {
      return null;
    }
    bfhl localbfhl = new bfhl(8).c(paramMessageForStructing);
    if (!bfid.a(paramMessageForStructing))
    {
      localbfhl.c(paramMessageForStructing);
      return localbfhl;
    }
    ArrayList localArrayList = new ArrayList();
    byte[] arrayOfByte = bfid.a(paramMessageForStructing.uniseq, paramMessageForStructing.structingMsg);
    if (arrayOfByte != null) {
      localArrayList.add(arrayOfByte);
    }
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (long l = 1L;; l = paramList.size())
    {
      arrayOfByte = bfid.a(paramMessageForStructing.uniseq, l);
      if (arrayOfByte != null) {
        localArrayList.add(arrayOfByte);
      }
      arrayOfByte = bfid.a(-1L, paramMap);
      if (arrayOfByte != null) {
        localArrayList.add(arrayOfByte);
      }
      bfid.a(paramQQAppInterface, paramMessageForStructing, paramList, paramMap, localArrayList);
      if (localArrayList != null) {
        localbfhl.b("sBizDataList", localArrayList);
      }
      return localbfhl;
    }
  }
  
  public static bfhl a(MessageForShortVideo paramMessageForShortVideo)
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
      paramMessageForShortVideo = new bfhl(5);
      paramMessageForShortVideo.a.putExtra("shortVideoContents", localContentValues);
      return paramMessageForShortVideo;
      i = paramMessageForShortVideo.busiType;
      break;
      break label165;
    }
  }
  
  public static bfhl a(String paramString)
  {
    return new bfhl(6).b("sUrl", paramString);
  }
  
  public static bfhl a(String paramString1, int paramInt, String paramString2)
  {
    return new bfhl(4).b("sPath", paramString1).a("nDuration", paramInt).b("sBrief", paramString2);
  }
  
  public static bfhl a(String paramString1, int paramInt, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    paramInt = bfid.b(paramInt);
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if ((4 == paramInt) || (5 == paramInt)) {
        paramString2 = String.valueOf(paramLong1);
      }
      return new bfhl(2).b("sMD5", paramString1).b("sPath", paramString3).a("nPicType", paramInt).b("sPicId", paramString2).a("lSize", paramLong2);
    }
  }
  
  public static bfhl a(String paramString1, String paramString2)
  {
    return new bfhl(1).b("sText", paramString2).b("sTitle", paramString1);
  }
  
  public static bfhl a(ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, String paramString3)
  {
    paramArrayList = new bfhl(8).a("sPathList", paramArrayList).b("sTitle", paramString1).a("bOnlyPic", paramBoolean1).b("sText", paramString2).a("bAppShare", paramBoolean2).a("lAppId", paramLong).b("sAppName", paramString3);
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
      bfhn.a(paramActivity, str, bool, null, false);
      return;
    }
  }
  
  public static bfhl b(atmo paramatmo)
  {
    return new bfhl(8).c(paramatmo);
  }
  
  public static bfhl b(String paramString)
  {
    return new bfhl(2).b("sPath", paramString);
  }
  
  public Intent a()
  {
    return this.a;
  }
  
  public bfhl a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.a.putExtra("nAuthorType", paramInt).putExtra("lUin", paramLong1).putExtra("sName", paramString1).putExtra("lGroupUin", paramLong2).putExtra("sGroupName", paramString2);
    return this;
  }
  
  public bfhl a(long paramLong)
  {
    return a("requestId", paramLong);
  }
  
  public bfhl a(long paramLong, String paramString)
  {
    this.a.putExtra("nAuthorType", 1).putExtra("lUin", paramLong).putExtra("sName", paramString);
    return this;
  }
  
  public bfhl a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    return a(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue(), paramQQAppInterface.getCurrentNickname());
  }
  
  public bfhl a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {
      return this;
    }
    return a(paramQQAppInterface, paramMessageRecord, paramMessageRecord.senderuin, paramMessageRecord.frienduin, paramMessageRecord.issend, paramMessageRecord.istroop);
  }
  
  public bfhl a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return this;
    }
    int i = bfid.a(paramInt2);
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
          if (!bado.a(paramInt1)) {
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
            if (mnf.a(paramMessageRecord))
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
                localObject4 = BaseApplicationImpl.getContext().getString(2131624498);
              }
            }
          }
          l4 = l2;
          localObject2 = localObject3;
          paramString1 = (String)localObject4;
          l3 = l1;
          localObject1 = azhy.a(paramMessageRecord);
          paramMessageRecord = (MessageRecord)localObject4;
          if (localObject1 == null) {
            break label957;
          }
          l4 = l2;
          localObject2 = localObject3;
          paramString1 = (String)localObject4;
          l3 = l1;
          paramMessageRecord = ((azhz)localObject1).c;
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
        localObject3 = babh.a(paramQQAppInterface, (String)localObject1, true);
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
          localObject1 = babh.c(paramQQAppInterface, paramString2);
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
          localObject1 = babh.b(paramQQAppInterface, str1, paramInt2);
          l1 = 0L;
          l2 = l5;
          localObject3 = localObject4;
          continue;
          l4 = l5;
          localObject2 = localObject4;
          paramString1 = str2;
          l3 = l6;
          localObject1 = babh.b(paramQQAppInterface, paramString2, paramInt2);
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
      localObject3 = babh.b(paramQQAppInterface, str1, 0);
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
          localObject1 = babh.a(paramQQAppInterface, paramString2, str1);
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
      for (localObject3 = babh.a(paramQQAppInterface, paramString2, true);; localObject3 = babh.c(paramQQAppInterface, paramString2))
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
        localObject1 = babh.b(paramQQAppInterface, str1, paramInt2);
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
  
  public bfhl a(String paramString, float paramFloat)
  {
    this.a.putExtra(paramString, paramFloat);
    return this;
  }
  
  public bfhl a(String paramString, int paramInt)
  {
    this.a.putExtra(paramString, paramInt);
    return this;
  }
  
  public bfhl a(String paramString, long paramLong)
  {
    this.a.putExtra(paramString, paramLong);
    return this;
  }
  
  public bfhl a(String paramString, ArrayList<String> paramArrayList)
  {
    this.a.putStringArrayListExtra(paramString, paramArrayList);
    return this;
  }
  
  public bfhl a(String paramString, boolean paramBoolean)
  {
    this.a.putExtra(paramString, paramBoolean);
    return this;
  }
  
  public boolean a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131626723, null);
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
  
  public boolean a(Activity paramActivity, String paramString, int paramInt, bfhm parambfhm)
  {
    Object localObject2 = null;
    boolean bool = b(paramActivity, paramString, -1, null);
    Object localObject1 = localObject2;
    if (!bool)
    {
      localObject1 = localObject2;
      if (this.a != null) {
        localObject1 = paramActivity.getString(this.a.getIntExtra("nReasonInt", 2131626724));
      }
    }
    bfhn.a(paramActivity, paramString, bool, (String)localObject1, false, paramInt);
    if (parambfhm != null) {
      parambfhm.b(bool);
    }
    return bool;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    bfia.a().a = true;
    String str = apdh.a(paramFileManagerEntity.fileName);
    int m = 6;
    if (paramChatMessage == null) {
      m = 7;
    }
    int j = -1;
    int i = j;
    switch (paramFileManagerEntity.getCloudType())
    {
    default: 
      i = j;
    }
    while (paramFileManagerEntity.fileName.getBytes().length >= 256)
    {
      if (!paramBoolean) {
        bfid.a(paramActivity, 2131626726, 1);
      }
      bfhz.a(paramQQAppInterface, "User_AddFav", 6, -80010, m, i, str, null);
      paramQQAppInterface = new ContentValues();
      paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131626740));
      this.a.putExtra("fileContents", paramQQAppInterface);
      return false;
      if (3000 == paramFileManagerEntity.peerType)
      {
        i = 106;
      }
      else
      {
        i = 3;
        continue;
        i = paramFileManagerEntity.busId;
        continue;
        i = 25;
      }
    }
    int i1 = apck.a(paramFileManagerEntity);
    switch (i1)
    {
    case 3: 
    default: 
      if (!paramBoolean) {
        bfid.a(paramActivity, 2131626727, 0);
      }
      bfhz.a(paramQQAppInterface, "User_AddFav", 6, -80003, m, i, str, null);
      paramQQAppInterface = new ContentValues();
      paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131626742));
      this.a.putExtra("fileContents", paramQQAppInterface);
      return false;
    case 1: 
      if ((paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
      {
        if (!paramBoolean) {
          bfid.a(paramActivity, 2131626725, 1);
        }
        bfhz.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
        paramQQAppInterface = new ContentValues();
        paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131626739));
        this.a.putExtra("fileContents", paramQQAppInterface);
        return false;
      }
      break;
    case 4: 
      if ((104 == paramFileManagerEntity.busId) && (paramFileManagerEntity.lastTime > 0L) && (paramFileManagerEntity.lastTime <= System.currentTimeMillis() / 1000L))
      {
        if (!paramBoolean) {
          bfid.a(paramActivity, 2131626725, 1);
        }
        bfhz.a(paramQQAppInterface, "User_AddFav", 6, -80011, m, i, str, null);
        paramQQAppInterface = new ContentValues();
        paramQQAppInterface.put("errorMsg", BaseApplicationImpl.getContext().getResources().getString(2131626739));
        this.a.putExtra("fileContents", paramQQAppInterface);
        return false;
      }
      break;
    }
    Object localObject;
    if (paramChatMessage != null)
    {
      a(paramQQAppInterface, paramChatMessage);
      localObject = "";
      paramChatMessage = (ChatMessage)localObject;
    }
    label576:
    int k;
    switch (i1)
    {
    default: 
      paramChatMessage = (ChatMessage)localObject;
    case 3: 
      localObject = new ContentValues();
      ((ContentValues)localObject).put("fileUuId", paramChatMessage);
      ((ContentValues)localObject).put("fileCloudType", Integer.valueOf(i1));
      ((ContentValues)localObject).put("fileSize", Long.valueOf(paramFileManagerEntity.fileSize));
      ((ContentValues)localObject).put("fileName", paramFileManagerEntity.fileName);
      ((ContentValues)localObject).put("fileMd5", paramFileManagerEntity.strFileMd5);
      ((ContentValues)localObject).put("filePath", paramFileManagerEntity.getFilePath());
      ((ContentValues)localObject).put("fileThumbPath", paramFileManagerEntity.strThumbPath);
      ((ContentValues)localObject).put("filePeerType", Integer.valueOf(paramFileManagerEntity.peerType));
      ((ContentValues)localObject).put("fileBid", Integer.valueOf(paramFileManagerEntity.busId));
      this.a.putExtra("fileContents", (Parcelable)localObject);
      if (!paramBoolean)
      {
        paramBoolean = b(paramActivity, paramQQAppInterface.getAccount(), -1, null);
        paramChatMessage = null;
        paramFileManagerEntity = paramChatMessage;
        if (!paramBoolean)
        {
          paramFileManagerEntity = paramChatMessage;
          if (this.a != null) {
            paramFileManagerEntity = paramActivity.getString(this.a.getIntExtra("nReasonInt", 2131626724));
          }
        }
        paramQQAppInterface.runOnUiThread(new QfavBuilder.1(this, paramActivity, paramQQAppInterface, paramBoolean, paramFileManagerEntity));
        label788:
        bfhz.a(paramQQAppInterface, "User_AddFav", 6, 0, m, i, str, null);
        return paramBoolean;
        paramChatMessage = paramFileManagerEntity.selfUin;
        localObject = paramFileManagerEntity.peerUin;
        if (paramFileManagerEntity.bSend)
        {
          k = 1;
          label830:
          int n = 0;
          switch (paramFileManagerEntity.peerType)
          {
          default: 
            j = n;
            if (!paramFileManagerEntity.bSend)
            {
              paramChatMessage = paramFileManagerEntity.peerUin;
              j = n;
            }
            label901:
            if (TextUtils.isEmpty(paramChatMessage))
            {
              paramChatMessage = paramQQAppInterface.getCurrentAccountUin();
              k = 1;
            }
            break;
          }
        }
      }
      break;
    }
    for (;;)
    {
      a(paramQQAppInterface, null, paramChatMessage, (String)localObject, k, j);
      break;
      k = 0;
      break label830;
      j = 1;
      break label901;
      j = 3000;
      break label901;
      j = 1004;
      break label901;
      paramChatMessage = paramFileManagerEntity.Uuid;
      break label576;
      paramChatMessage = paramFileManagerEntity.strTroopFilePath;
      break label576;
      if (TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey))
      {
        paramChatMessage = paramFileManagerEntity.WeiYunFileId;
        break label576;
      }
      paramChatMessage = paramFileManagerEntity.WeiYunDirKey + paramFileManagerEntity.WeiYunFileId;
      break label576;
      paramBoolean = b(paramActivity, paramQQAppInterface.getAccount(), -1, null);
      break label788;
    }
  }
  
  public bfhl b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramMessageRecord);
    if (paramMessageRecord == null) {}
    for (long l = 0L;; l = paramMessageRecord.time) {
      return paramQQAppInterface.a("lCreateTime", l * 1000L);
    }
  }
  
  public bfhl b(String paramString1, String paramString2)
  {
    this.a.putExtra(paramString1, paramString2);
    return this;
  }
  
  public bfhl b(String paramString, ArrayList<byte[]> paramArrayList)
  {
    this.a.putExtra(paramString, paramArrayList);
    return this;
  }
  
  public boolean b(Activity paramActivity, String paramString, int paramInt, Intent paramIntent)
  {
    bfia.a().a = true;
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
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
      paramIntent = this.a;
      break;
      str = paramIntent.getStringExtra("sPath");
    } while ((paramIntent.getIntExtra("nPicType", 1) != 1) || (!bfid.a(str, paramIntent.getLongExtra("lSize", -1L))));
    paramIntent.putExtra("nReasonInt", 2131629510);
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 1, "QfavBuilder.add: picture too big [" + str + "]");
    }
    bfhz.a(null, "Net_AddFav", 3, 3, -3);
    return false;
  }
  
  public bfhl c(atmo paramatmo)
  {
    this.a.putExtra("cvEntityContents", bfid.a(paramatmo, ""));
    this.a.putExtra("sEntityClassName", paramatmo.getClass().getName());
    return this;
  }
  
  public bfhl c(String paramString)
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
    bfhn.a(paramActivity, paramString, bool, "", false, 2131626723);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfhl
 * JD-Core Version:    0.7.0.1
 */