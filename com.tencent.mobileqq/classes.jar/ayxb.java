import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class ayxb
{
  private static int a(int paramInt, MessageRecord paramMessageRecord, String paramString)
  {
    int i = 2;
    if ((paramInt == 9063) || (paramInt == 90632)) {
      paramInt = 1;
    }
    int j;
    do
    {
      do
      {
        return paramInt;
        if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000)) {
          break;
        }
        if (paramInt != -9527) {
          break label119;
        }
        j = a(paramString);
        paramInt = i;
      } while (j == 197);
      if ((j != 202) && (j != 201)) {
        break;
      }
      return 3;
      if (paramInt != -9527) {
        break;
      }
      j = a(paramString);
      paramInt = i;
    } while (j == 199);
    if ((j == 206) || (j == 207)) {
      return 3;
    }
    label119:
    return -1;
  }
  
  private static int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      paramString = paramString.split("_");
      i = j;
      if (paramString != null)
      {
        i = j;
        if (paramString.length != 2) {}
      }
    }
    try
    {
      i = Integer.parseInt(paramString[1]);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return BaseApplicationImpl.getApplication().getResources().getString(2131689982);
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131689981);
  }
  
  public static String a(MessageForPic paramMessageForPic)
  {
    Object localObject2 = null;
    int i;
    try
    {
      String str = paramMessageForPic.getExtInfoFromExtStr("PicUploadExplicitError");
      localObject1 = localObject2;
      if (TextUtils.isEmpty(str)) {
        break label155;
      }
      i = a(Integer.parseInt(str), paramMessageForPic, paramMessageForPic.getExtInfoFromExtStr("PicUploadExplicitErrorReason"));
      if (i == 3)
      {
        str = paramMessageForPic.getExtInfoFromExtStr("SEND_PHOTO_DAY_KEY");
        localObject1 = localObject2;
        if (TextUtils.isEmpty(str)) {
          break label155;
        }
        long l1 = Long.parseLong(str);
        long l2 = SystemClock.uptimeMillis();
        if (onj.a(l1, l2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicUploadExplicitError", 2, "getFailedTip,lastSendPicTime:" + l1 + " timeCurrent:" + l2);
          }
          return a(i);
        }
        paramMessageForPic.removeExtInfoToExtStr("SEND_PHOTO_DAY_KEY");
        paramMessageForPic.updateMsgExtFiled();
        return null;
      }
    }
    catch (Exception paramMessageForPic)
    {
      paramMessageForPic.printStackTrace();
      return null;
    }
    Object localObject1 = a(i);
    label155:
    return localObject1;
  }
  
  public static void a(MessageRecord paramMessageRecord, int paramInt, String paramString1, String paramString2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicUploadExplicitError", 2, "uploadFailUpdateMsg,errCode:" + paramInt + " errStr:" + paramString1 + " uinType:" + paramMessageRecord.istroop + " msg:" + paramMessageRecord);
      }
      int i = a(paramInt, paramMessageRecord, paramString2);
      if (i > 0)
      {
        if (i != 3) {
          break label124;
        }
        paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitError", String.valueOf(paramInt));
        paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitErrorReason", paramString2);
        paramMessageRecord.saveExtInfoToExtStr("SEND_PHOTO_DAY_KEY", String.valueOf(SystemClock.uptimeMillis()));
      }
    }
    for (;;)
    {
      ((MessageForPic)paramMessageRecord).updateMsgExtFiled();
      return;
      label124:
      paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitError", String.valueOf(paramInt));
      paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitErrorReason", paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxb
 * JD-Core Version:    0.7.0.1
 */