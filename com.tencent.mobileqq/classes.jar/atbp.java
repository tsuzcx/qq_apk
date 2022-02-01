import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class atbp
  implements beyd
{
  atbp(atbo paramatbo) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, beyc parambeyc)
  {
    if (atbo.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + atbo.a(this.a) + "] filename " + atbo.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = parambeyc.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + atbo.a(this.a) + "] filename " + atbo.a(this.a));
      atbo.a(this.a).a(atan.a(atbo.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = parambeyc.c();
    String str1 = parambeyc.d();
    paramInt = parambeyc.a();
    String str2 = parambeyc.a();
    atbo.a(this.a, parambeyc.b());
    int i = parambeyc.b();
    int j = parambeyc.c();
    int k = parambeyc.d();
    atbo.a(this.a).putString("_m_ForwardMd5", paramUUID);
    atbo.a(this.a).putString("_m_ForwardSha", str1);
    atbo.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    atbo.a(this.a).putString("_m_ForwardUuid", str2);
    atbo.a(this.a).putString("_m_ForwardSize", String.valueOf(atbo.a(this.a)));
    if (i != 0) {
      atbo.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      atbo.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      atbo.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    atbo.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (atan.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + atbo.a(this.a) + "] filename " + atbo.a(this.a));
      atbo.a(this.a).a(atan.a(atbo.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + atbo.a(this.a) + "] filename " + atbo.a(this.a));
    atan.a(atan.a(this.a.a), atbo.b(this.a), paramInt, str2, atbo.a(this.a), 0, i, j, k, false, atbo.a(this.a), atbo.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbp
 * JD-Core Version:    0.7.0.1
 */