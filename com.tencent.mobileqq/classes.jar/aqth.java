import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aqth
  implements bbxs
{
  aqth(aqtg paramaqtg) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bbxr parambbxr)
  {
    if (aqtg.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aqtg.a(this.a) + "] filename " + aqtg.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = parambbxr.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aqtg.a(this.a) + "] filename " + aqtg.a(this.a));
      aqtg.a(this.a).a(aqsf.a(aqtg.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = parambbxr.c();
    String str1 = parambbxr.d();
    paramInt = parambbxr.a();
    String str2 = parambbxr.a();
    aqtg.a(this.a, parambbxr.b());
    int i = parambbxr.b();
    int j = parambbxr.c();
    int k = parambbxr.d();
    aqtg.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aqtg.a(this.a).putString("_m_ForwardSha", str1);
    aqtg.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aqtg.a(this.a).putString("_m_ForwardUuid", str2);
    aqtg.a(this.a).putString("_m_ForwardSize", String.valueOf(aqtg.a(this.a)));
    if (i != 0) {
      aqtg.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aqtg.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aqtg.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aqtg.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aqsf.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aqtg.a(this.a) + "] filename " + aqtg.a(this.a));
      aqtg.a(this.a).a(aqsf.a(aqtg.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aqtg.a(this.a) + "] filename " + aqtg.a(this.a));
    aqsf.a(aqsf.a(this.a.a), aqtg.b(this.a), paramInt, str2, aqtg.a(this.a), 0, i, j, k, false, aqtg.a(this.a), aqtg.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqth
 * JD-Core Version:    0.7.0.1
 */