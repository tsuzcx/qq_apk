import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class asfu
  implements behi
{
  asfu(asft paramasft) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, behh parambehh)
  {
    if (asft.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + asft.a(this.a) + "] filename " + asft.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = parambehh.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + asft.a(this.a) + "] filename " + asft.a(this.a));
      asft.a(this.a).a(ases.a(asft.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = parambehh.c();
    String str1 = parambehh.d();
    paramInt = parambehh.a();
    String str2 = parambehh.a();
    asft.a(this.a, parambehh.b());
    int i = parambehh.b();
    int j = parambehh.c();
    int k = parambehh.d();
    asft.a(this.a).putString("_m_ForwardMd5", paramUUID);
    asft.a(this.a).putString("_m_ForwardSha", str1);
    asft.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    asft.a(this.a).putString("_m_ForwardUuid", str2);
    asft.a(this.a).putString("_m_ForwardSize", String.valueOf(asft.a(this.a)));
    if (i != 0) {
      asft.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      asft.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      asft.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    asft.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (ases.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + asft.a(this.a) + "] filename " + asft.a(this.a));
      asft.a(this.a).a(ases.a(asft.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + asft.a(this.a) + "] filename " + asft.a(this.a));
    ases.a(ases.a(this.a.a), asft.b(this.a), paramInt, str2, asft.a(this.a), 0, i, j, k, false, asft.a(this.a), asft.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfu
 * JD-Core Version:    0.7.0.1
 */