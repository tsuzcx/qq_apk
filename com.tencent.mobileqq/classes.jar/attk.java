import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class attk
  implements bfxx
{
  attk(attj paramattj) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bfxw parambfxw)
  {
    if (attj.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + attj.a(this.a) + "] filename " + attj.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = parambfxw.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + attj.a(this.a) + "] filename " + attj.a(this.a));
      attj.a(this.a).a(atsi.a(attj.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = parambfxw.c();
    String str1 = parambfxw.d();
    paramInt = parambfxw.a();
    String str2 = parambfxw.a();
    attj.a(this.a, parambfxw.b());
    int i = parambfxw.b();
    int j = parambfxw.c();
    int k = parambfxw.d();
    attj.a(this.a).putString("_m_ForwardMd5", paramUUID);
    attj.a(this.a).putString("_m_ForwardSha", str1);
    attj.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    attj.a(this.a).putString("_m_ForwardUuid", str2);
    attj.a(this.a).putString("_m_ForwardSize", String.valueOf(attj.a(this.a)));
    if (i != 0) {
      attj.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      attj.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      attj.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    attj.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (atsi.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + attj.a(this.a) + "] filename " + attj.a(this.a));
      attj.a(this.a).a(atsi.a(attj.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + attj.a(this.a) + "] filename " + attj.a(this.a));
    atsi.a(atsi.a(this.a.a), attj.b(this.a), paramInt, str2, attj.a(this.a), 0, i, j, k, false, attj.a(this.a), attj.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attk
 * JD-Core Version:    0.7.0.1
 */