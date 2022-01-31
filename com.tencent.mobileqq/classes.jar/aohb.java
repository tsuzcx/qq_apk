import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aohb
  implements ayui
{
  aohb(aoha paramaoha) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, ayuh paramayuh)
  {
    if (aoha.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aoha.a(this.a) + "] filename " + aoha.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramayuh.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aoha.a(this.a) + "] filename " + aoha.a(this.a));
      aoha.a(this.a).a(aofz.a(aoha.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = paramayuh.c();
    String str1 = paramayuh.d();
    paramInt = paramayuh.a();
    String str2 = paramayuh.a();
    aoha.a(this.a, paramayuh.b());
    int i = paramayuh.b();
    int j = paramayuh.c();
    int k = paramayuh.d();
    aoha.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aoha.a(this.a).putString("_m_ForwardSha", str1);
    aoha.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aoha.a(this.a).putString("_m_ForwardUuid", str2);
    aoha.a(this.a).putString("_m_ForwardSize", String.valueOf(aoha.a(this.a)));
    if (i != 0) {
      aoha.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aoha.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aoha.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aoha.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aofz.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aoha.a(this.a) + "] filename " + aoha.a(this.a));
      aoha.a(this.a).a(aofz.a(aoha.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aoha.a(this.a) + "] filename " + aoha.a(this.a));
    aofz.a(aofz.a(this.a.a), aoha.b(this.a), paramInt, str2, aoha.a(this.a), 0, i, j, k, false, aoha.a(this.a), aoha.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aohb
 * JD-Core Version:    0.7.0.1
 */