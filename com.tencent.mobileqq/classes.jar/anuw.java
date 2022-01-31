import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.LogTag;
import dov.com.tencent.mobileqq.richmedia.RichmediaService;
import dov.com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import java.util.HashMap;

public class anuw
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  
  public anuw(VideoSendTaskManager paramVideoSendTaskManager, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (TransferRequest)VideoSendTaskManager.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaVideoSendTaskManager).get(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      LogTag.a(this.jdField_a_of_type_JavaLangString, "RemoveRequest", "[RemoveRequest]TransferRequest is removed");
      return;
    }
    localObject = (MessageForShortVideo)((TransferRequest)localObject).a;
    if ((TextUtils.isEmpty(((MessageForShortVideo)localObject).md5)) || (TextUtils.isEmpty(((MessageForShortVideo)localObject).mLocalMd5)))
    {
      LogTag.a(this.jdField_a_of_type_JavaLangString, "RemoveRequest", "[RemoveRequest]Remove failed:md5=" + ((MessageForShortVideo)localObject).md5 + ",localMd5=" + ((MessageForShortVideo)localObject).mLocalMd5);
      return;
    }
    VideoSendTaskManager.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaVideoSendTaskManager).remove(this.jdField_a_of_type_JavaLangString);
    localObject = RichmediaService.a();
    if (localObject != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
      ((RichmediaService)localObject).a(1002, -1, localBundle);
    }
    LogTag.a(this.jdField_a_of_type_JavaLangString, "RemoveRequest", "[RemoveRequest]Remove success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anuw
 * JD-Core Version:    0.7.0.1
 */