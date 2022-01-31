import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aoxv
  implements azuy
{
  aoxv(aoxu paramaoxu) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, azux paramazux)
  {
    if (aoxu.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aoxu.a(this.a) + "] filename " + aoxu.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramazux.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aoxu.a(this.a) + "] filename " + aoxu.a(this.a));
      aoxu.a(this.a).a(aowt.a(aoxu.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = paramazux.c();
    String str1 = paramazux.d();
    paramInt = paramazux.a();
    String str2 = paramazux.a();
    aoxu.a(this.a, paramazux.b());
    int i = paramazux.b();
    int j = paramazux.c();
    int k = paramazux.d();
    aoxu.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aoxu.a(this.a).putString("_m_ForwardSha", str1);
    aoxu.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aoxu.a(this.a).putString("_m_ForwardUuid", str2);
    aoxu.a(this.a).putString("_m_ForwardSize", String.valueOf(aoxu.a(this.a)));
    if (i != 0) {
      aoxu.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aoxu.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aoxu.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aoxu.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aowt.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aoxu.a(this.a) + "] filename " + aoxu.a(this.a));
      aoxu.a(this.a).a(aowt.a(aoxu.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aoxu.a(this.a) + "] filename " + aoxu.a(this.a));
    aowt.a(aowt.a(this.a.a), aoxu.b(this.a), paramInt, str2, aoxu.a(this.a), 0, i, j, k, false, aoxu.a(this.a), aoxu.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxv
 * JD-Core Version:    0.7.0.1
 */