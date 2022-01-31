import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class awan
{
  private QQAppInterface a;
  
  public awan(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -2000) || (paramInt == -2022) || (paramInt == -1035) || (paramInt == -1036);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1004) || (paramInt == 1005) || (paramInt == 2005) || (paramInt == 5001) || (paramInt == 5002);
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = this.a.a().a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
      if ((paramMessageRecord instanceof aypb)) {
        return (int)((aypb)paramMessageRecord).c();
      }
    }
    return -1;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.a == null)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      if (((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForLightVideo))) {
        this.a.a().b(paramMessageRecord, this.a.getAccount());
      }
      while (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMsg cost:").append(System.currentTimeMillis() - l).append(" uniseq = ").append(paramMessageRecord.uniseq).append(", msgtype = ").append(paramMessageRecord.msgtype);
        QLog.d("MediaMsgController", 2, localStringBuilder.toString());
        return;
        ((akfv)this.a.a(13)).a(paramMessageRecord);
        this.a.a().a(paramMessageRecord, this.a.getCurrentAccountUin());
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, akat paramakat, awar paramawar)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramawar != null) {
      paramawar.a(paramMessageRecord);
    }
    this.a.a().b(paramMessageRecord, paramakat);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.extraflag == 32768)) {
      return true;
    }
    int i;
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      i = ((MessageForShortVideo)paramMessageRecord).videoFileStatus;
    }
    for (;;)
    {
      return b(i);
      if (((paramMessageRecord instanceof MessageForPic)) && (((MessageForPic)paramMessageRecord).size <= 0L))
      {
        int j = a(paramMessageRecord);
        i = j;
        if (j == 0) {
          return true;
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      File localFile = new File(paramString);
      if ((localFile.exists()) && (GifDrawable.isGifFile(localFile)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaMsgController", 2, "isDoutuPic gifFile");
        }
        return true;
      }
      i = bgky.a(paramString);
    } while ((i != 2000) && (i != 3));
    if (QLog.isColorLevel()) {
      QLog.d("MediaMsgController", 2, new Object[] { "isDoutuPic imageType:", Integer.valueOf(i) });
    }
    return true;
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = this.a.a().a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
      if (!(paramMessageRecord instanceof aypb)) {}
    }
    for (int i = ((aypb)paramMessageRecord).e();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaMsgController", 2, new Object[] { "getUploadProgress:", Integer.valueOf(i) });
      }
      return i;
    }
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramMessageRecord;
      if ((localMessageForShortVideo.busiType == 0) && (localMessageForShortVideo.videoFileStatus != 998) && (TextUtils.isEmpty(localMessageForShortVideo.md5)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaMsgController", 2, "isVideoNeedPreCompress is true, " + paramMessageRecord.uniseq);
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if (b(paramMessageRecord))
    {
      axfj localaxfj = new axfj(this.a, this.a.getApplication(), (MessageForShortVideo)paramMessageRecord, null);
      axfi.a().a(paramMessageRecord.uniseq, localaxfj);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awan
 * JD-Core Version:    0.7.0.1
 */