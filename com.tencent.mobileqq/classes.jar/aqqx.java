import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aqqx
  implements bbtj
{
  aqqx(aqqw paramaqqw) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bbti parambbti)
  {
    if (aqqw.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aqqw.a(this.a) + "] filename " + aqqw.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = parambbti.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aqqw.a(this.a) + "] filename " + aqqw.a(this.a));
      aqqw.a(this.a).a(aqpv.a(aqqw.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = parambbti.c();
    String str1 = parambbti.d();
    paramInt = parambbti.a();
    String str2 = parambbti.a();
    aqqw.a(this.a, parambbti.b());
    int i = parambbti.b();
    int j = parambbti.c();
    int k = parambbti.d();
    aqqw.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aqqw.a(this.a).putString("_m_ForwardSha", str1);
    aqqw.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aqqw.a(this.a).putString("_m_ForwardUuid", str2);
    aqqw.a(this.a).putString("_m_ForwardSize", String.valueOf(aqqw.a(this.a)));
    if (i != 0) {
      aqqw.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aqqw.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aqqw.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aqqw.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aqpv.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aqqw.a(this.a) + "] filename " + aqqw.a(this.a));
      aqqw.a(this.a).a(aqpv.a(aqqw.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aqqw.a(this.a) + "] filename " + aqqw.a(this.a));
    aqpv.a(aqpv.a(this.a.a), aqqw.b(this.a), paramInt, str2, aqqw.a(this.a), 0, i, j, k, false, aqqw.a(this.a), aqqw.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqx
 * JD-Core Version:    0.7.0.1
 */