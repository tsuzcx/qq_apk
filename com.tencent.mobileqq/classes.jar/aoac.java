import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCServer;
import eipc.EIPCResult;

public class aoac
  extends QIPCModule
{
  public aoac(VideoPlayIPCServer paramVideoPlayIPCServer, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("VideoPlayIPCServer", 2, "onCall : action = " + paramString);
    }
    if ("CMD_UPDATE_MSG_FOR_VIDEO_FILE_STATUS".equals(paramString))
    {
      paramString = paramBundle.getString("VALUE_MSG_FRIENDUIN");
      paramInt = paramBundle.getInt("VALUE_MSG_ISTROOP");
      long l = paramBundle.getLong("VALUE_MSG_UINSEQ");
      paramString = localQQAppInterface.a().b(paramString, paramInt, l);
      if ((paramString instanceof MessageForShortVideo))
      {
        paramString = (MessageForShortVideo)paramString;
        paramString.videoFileStatus = 2003;
        paramString.transferedSize = 0;
        paramString.videoFileProgress = 100;
        paramString.serial();
        localQQAppInterface.a().a(paramString.frienduin, paramInt, paramString.uniseq, paramString.msgData);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoac
 * JD-Core Version:    0.7.0.1
 */