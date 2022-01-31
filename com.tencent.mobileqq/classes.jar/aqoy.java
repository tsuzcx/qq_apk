import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aqoy
  implements bbtj
{
  aqoy(aqox paramaqox) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bbti parambbti)
  {
    if (aqox.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aqox.a(this.a) + "] filename " + aqox.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = parambbti.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aqox.a(this.a) + "] filename " + aqox.a(this.a));
      aqox.a(this.a).a(aqnw.a(aqox.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = parambbti.c();
    String str1 = parambbti.d();
    paramInt = parambbti.a();
    String str2 = parambbti.a();
    aqox.a(this.a, parambbti.b());
    int i = parambbti.b();
    int j = parambbti.c();
    int k = parambbti.d();
    aqox.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aqox.a(this.a).putString("_m_ForwardSha", str1);
    aqox.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aqox.a(this.a).putString("_m_ForwardUuid", str2);
    aqox.a(this.a).putString("_m_ForwardSize", String.valueOf(aqox.a(this.a)));
    if (i != 0) {
      aqox.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aqox.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aqox.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aqox.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aqnw.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aqox.a(this.a) + "] filename " + aqox.a(this.a));
      aqox.a(this.a).a(aqnw.a(aqox.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aqox.a(this.a) + "] filename " + aqox.a(this.a));
    aqnw.a(aqnw.a(this.a.a), aqox.b(this.a), paramInt, str2, aqox.a(this.a), 0, i, j, k, false, aqox.a(this.a), aqox.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqoy
 * JD-Core Version:    0.7.0.1
 */