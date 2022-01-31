import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aowa
  implements azva
{
  aowa(aovz paramaovz) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, azuz paramazuz)
  {
    if (aovz.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aovz.a(this.a) + "] filename " + aovz.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramazuz.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aovz.a(this.a) + "] filename " + aovz.a(this.a));
      aovz.a(this.a).a(aouy.a(aovz.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = paramazuz.c();
    String str1 = paramazuz.d();
    paramInt = paramazuz.a();
    String str2 = paramazuz.a();
    aovz.a(this.a, paramazuz.b());
    int i = paramazuz.b();
    int j = paramazuz.c();
    int k = paramazuz.d();
    aovz.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aovz.a(this.a).putString("_m_ForwardSha", str1);
    aovz.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aovz.a(this.a).putString("_m_ForwardUuid", str2);
    aovz.a(this.a).putString("_m_ForwardSize", String.valueOf(aovz.a(this.a)));
    if (i != 0) {
      aovz.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aovz.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aovz.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aovz.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aouy.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aovz.a(this.a) + "] filename " + aovz.a(this.a));
      aovz.a(this.a).a(aouy.a(aovz.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aovz.a(this.a) + "] filename " + aovz.a(this.a));
    aouy.a(aouy.a(this.a.a), aovz.b(this.a), paramInt, str2, aovz.a(this.a), 0, i, j, k, false, aovz.a(this.a), aovz.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aowa
 * JD-Core Version:    0.7.0.1
 */