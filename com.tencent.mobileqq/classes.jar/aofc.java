import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aofc
  implements ayui
{
  aofc(aofb paramaofb) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, ayuh paramayuh)
  {
    if (aofb.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aofb.a(this.a) + "] filename " + aofb.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramayuh.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aofb.a(this.a) + "] filename " + aofb.a(this.a));
      aofb.a(this.a).a(aoea.a(aofb.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = paramayuh.c();
    String str1 = paramayuh.d();
    paramInt = paramayuh.a();
    String str2 = paramayuh.a();
    aofb.a(this.a, paramayuh.b());
    int i = paramayuh.b();
    int j = paramayuh.c();
    int k = paramayuh.d();
    aofb.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aofb.a(this.a).putString("_m_ForwardSha", str1);
    aofb.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aofb.a(this.a).putString("_m_ForwardUuid", str2);
    aofb.a(this.a).putString("_m_ForwardSize", String.valueOf(aofb.a(this.a)));
    if (i != 0) {
      aofb.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aofb.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aofb.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aofb.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aoea.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aofb.a(this.a) + "] filename " + aofb.a(this.a));
      aofb.a(this.a).a(aoea.a(aofb.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aofb.a(this.a) + "] filename " + aofb.a(this.a));
    aoea.a(aoea.a(this.a.a), aofb.b(this.a), paramInt, str2, aofb.a(this.a), 0, i, j, k, false, aofb.a(this.a), aofb.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aofc
 * JD-Core Version:    0.7.0.1
 */