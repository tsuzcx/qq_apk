import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aoxz
  implements azva
{
  aoxz(aoxy paramaoxy) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, azuz paramazuz)
  {
    if (aoxy.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aoxy.a(this.a) + "] filename " + aoxy.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramazuz.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aoxy.a(this.a) + "] filename " + aoxy.a(this.a));
      aoxy.a(this.a).a(aowx.a(aoxy.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = paramazuz.c();
    String str1 = paramazuz.d();
    paramInt = paramazuz.a();
    String str2 = paramazuz.a();
    aoxy.a(this.a, paramazuz.b());
    int i = paramazuz.b();
    int j = paramazuz.c();
    int k = paramazuz.d();
    aoxy.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aoxy.a(this.a).putString("_m_ForwardSha", str1);
    aoxy.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aoxy.a(this.a).putString("_m_ForwardUuid", str2);
    aoxy.a(this.a).putString("_m_ForwardSize", String.valueOf(aoxy.a(this.a)));
    if (i != 0) {
      aoxy.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aoxy.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aoxy.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aoxy.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aowx.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aoxy.a(this.a) + "] filename " + aoxy.a(this.a));
      aoxy.a(this.a).a(aowx.a(aoxy.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aoxy.a(this.a) + "] filename " + aoxy.a(this.a));
    aowx.a(aowx.a(this.a.a), aoxy.b(this.a), paramInt, str2, aoxy.a(this.a), 0, i, j, k, false, aoxy.a(this.a), aoxy.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxz
 * JD-Core Version:    0.7.0.1
 */