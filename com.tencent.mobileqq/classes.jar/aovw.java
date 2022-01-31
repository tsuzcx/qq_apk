import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aovw
  implements azuy
{
  aovw(aovv paramaovv) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, azux paramazux)
  {
    if (aovv.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aovv.a(this.a) + "] filename " + aovv.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramazux.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aovv.a(this.a) + "] filename " + aovv.a(this.a));
      aovv.a(this.a).a(aouu.a(aovv.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = paramazux.c();
    String str1 = paramazux.d();
    paramInt = paramazux.a();
    String str2 = paramazux.a();
    aovv.a(this.a, paramazux.b());
    int i = paramazux.b();
    int j = paramazux.c();
    int k = paramazux.d();
    aovv.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aovv.a(this.a).putString("_m_ForwardSha", str1);
    aovv.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aovv.a(this.a).putString("_m_ForwardUuid", str2);
    aovv.a(this.a).putString("_m_ForwardSize", String.valueOf(aovv.a(this.a)));
    if (i != 0) {
      aovv.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aovv.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aovv.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aovv.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aouu.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aovv.a(this.a) + "] filename " + aovv.a(this.a));
      aovv.a(this.a).a(aouu.a(aovv.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aovv.a(this.a) + "] filename " + aovv.a(this.a));
    aouu.a(aouu.a(this.a.a), aovv.b(this.a), paramInt, str2, aovv.a(this.a), 0, i, j, k, false, aovv.a(this.a), aovv.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovw
 * JD-Core Version:    0.7.0.1
 */