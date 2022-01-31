import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class axwu
{
  private static int a(int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 2;
    if ((paramInt == 9063) || (paramInt == 90632)) {
      i = 1;
    }
    do
    {
      do
      {
        return i;
        if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000)) {
          break;
        }
      } while (paramInt == 197);
      if ((paramInt != 202) && (paramInt != 201)) {
        break;
      }
      return 3;
    } while (paramInt == 199);
    if ((paramInt == 206) || (paramInt == 207)) {
      return 3;
    }
    return -1;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return BaseApplicationImpl.getApplication().getResources().getString(2131624430);
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131624429);
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
        break label149;
      }
      i = a(Integer.parseInt(str), paramMessageForPic);
      if (i == 3)
      {
        str = paramMessageForPic.getExtInfoFromExtStr("SEND_PHOTO_DAY_KEY");
        localObject1 = localObject2;
        if (TextUtils.isEmpty(str)) {
          break label149;
        }
        long l1 = Long.parseLong(str);
        long l2 = SystemClock.uptimeMillis();
        if (oby.a(l1, l2))
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
    label149:
    return localObject1;
  }
  
  public static void a(MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicUploadExplicitError", 2, "uploadFailUpdateMsg,errCode:" + paramInt + " errStr:" + paramString + " uinType:" + paramMessageRecord.istroop + " msg:" + paramMessageRecord);
      }
      int i = a(paramInt, paramMessageRecord);
      if (i > 0)
      {
        if (i != 3) {
          break label113;
        }
        paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitError", String.valueOf(paramInt));
        paramMessageRecord.saveExtInfoToExtStr("SEND_PHOTO_DAY_KEY", String.valueOf(SystemClock.uptimeMillis()));
      }
    }
    for (;;)
    {
      ((MessageForPic)paramMessageRecord).updateMsgExtFiled();
      return;
      label113:
      paramMessageRecord.saveExtInfoToExtStr("PicUploadExplicitError", String.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwu
 * JD-Core Version:    0.7.0.1
 */