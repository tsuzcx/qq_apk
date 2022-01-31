import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.AudioUploadTask;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import java.io.File;

public class ayhb
  extends Handler
{
  public ayhb(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      TroopBarReplyActivity.b(this.a, false);
      return;
    }
    paramMessage = paramMessage.obj.toString();
    File localFile = new File(paramMessage);
    if (localFile.exists()) {}
    for (long l = localFile.length();; l = 0L)
    {
      TroopBarReplyActivity.b(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(8);
      TroopBarReplyActivity.a(this.a, new AudioInfo(paramMessage, (int)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(), l));
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = TroopBarReplyActivity.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask = new TroopBarPublishUtils.AudioUploadTask(this.a, this.a.jdField_a_of_type_AndroidOsHandler, "https://upload.buluo.qq.com/cgi-bin/bar/upload/meida", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      ThreadManager.post(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask, 5, null, true);
      this.a.a(2, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      TroopBarReplyActivity.a(this.a, 0);
      if (!this.a.k) {
        break;
      }
      azho.a(this.a.m, this.a.n, "sure_record", this.a.o, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayhb
 * JD-Core Version:    0.7.0.1
 */