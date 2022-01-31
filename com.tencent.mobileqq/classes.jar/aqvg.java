import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aqvg
  implements bbxs
{
  aqvg(aqvf paramaqvf) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bbxr parambbxr)
  {
    if (aqvf.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + aqvf.a(this.a) + "] filename " + aqvf.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = parambbxr.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + aqvf.a(this.a) + "] filename " + aqvf.a(this.a));
      aqvf.a(this.a).a(aque.a(aqvf.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = parambbxr.c();
    String str1 = parambbxr.d();
    paramInt = parambbxr.a();
    String str2 = parambbxr.a();
    aqvf.a(this.a, parambbxr.b());
    int i = parambbxr.b();
    int j = parambbxr.c();
    int k = parambbxr.d();
    aqvf.a(this.a).putString("_m_ForwardMd5", paramUUID);
    aqvf.a(this.a).putString("_m_ForwardSha", str1);
    aqvf.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    aqvf.a(this.a).putString("_m_ForwardUuid", str2);
    aqvf.a(this.a).putString("_m_ForwardSize", String.valueOf(aqvf.a(this.a)));
    if (i != 0) {
      aqvf.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      aqvf.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      aqvf.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    aqvf.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (aque.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + aqvf.a(this.a) + "] filename " + aqvf.a(this.a));
      aqvf.a(this.a).a(aque.a(aqvf.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + aqvf.a(this.a) + "] filename " + aqvf.a(this.a));
    aque.a(aque.a(this.a.a), aqvf.b(this.a), paramInt, str2, aqvf.a(this.a), 0, i, j, k, false, aqvf.a(this.a), aqvf.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvg
 * JD-Core Version:    0.7.0.1
 */