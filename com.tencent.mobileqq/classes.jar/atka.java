import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class atka
  implements bfol
{
  atka(atjz paramatjz) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bfok parambfok)
  {
    if (atjz.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + atjz.a(this.a) + "] filename " + atjz.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = parambfok.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + atjz.a(this.a) + "] filename " + atjz.a(this.a));
      atjz.a(this.a).a(atiy.a(atjz.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = parambfok.c();
    String str1 = parambfok.d();
    paramInt = parambfok.a();
    String str2 = parambfok.a();
    atjz.a(this.a, parambfok.b());
    int i = parambfok.b();
    int j = parambfok.c();
    int k = parambfok.d();
    atjz.a(this.a).putString("_m_ForwardMd5", paramUUID);
    atjz.a(this.a).putString("_m_ForwardSha", str1);
    atjz.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    atjz.a(this.a).putString("_m_ForwardUuid", str2);
    atjz.a(this.a).putString("_m_ForwardSize", String.valueOf(atjz.a(this.a)));
    if (i != 0) {
      atjz.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      atjz.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      atjz.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    atjz.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (atiy.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + atjz.a(this.a) + "] filename " + atjz.a(this.a));
      atjz.a(this.a).a(atiy.a(atjz.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + atjz.a(this.a) + "] filename " + atjz.a(this.a));
    atiy.a(atiy.a(this.a.a), atjz.b(this.a), paramInt, str2, atjz.a(this.a), 0, i, j, k, false, atjz.a(this.a), atjz.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atka
 * JD-Core Version:    0.7.0.1
 */