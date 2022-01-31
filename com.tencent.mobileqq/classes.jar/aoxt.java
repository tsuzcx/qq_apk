import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aoxt
  extends xbc
{
  aoxt(aoxs paramaoxs) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aoxs.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aoxs.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aoxs.a(this.a));
      aoxs.a(this.a).a(aowt.a(aoxs.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aoxs.a(this.a));
      aoxs.a(this.a).a(aowt.a(aoxs.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aoxs.a(this.a));
      aoxs.a(this.a).a(aowt.a(aoxs.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aoxs.a(this.a) + "] filename " + aoxs.a(this.a));
    aoxs.a(this.a, paramString1);
    aoxs.a(this.a).putString("_m_ForwardUuid", aoxs.b(this.a));
    if (aoxs.a(this.a) != 102)
    {
      aoxs.a(this.a).a(aoxs.b(this.a), aoxs.a(this.a));
      return;
    }
    aoxs.a(this.a, paramInt2);
    aoxs.a(this.a).putString("_m_ForwardBusType", String.valueOf(aoxs.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aoxs.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aoxs.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aoxs.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aoxs.d(this.a));
        j = 0;
        i = j;
        if (aoxs.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aoxs.e(this.a));
            if (aowt.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aoxs.a(this.a));
            aoxs.a(this.a).a(aowt.a(aoxs.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aoxs.c(this.a) + "] is error filename " + aoxs.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aoxs.d(this.a) + "] is error filename " + aoxs.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aoxs.e(this.a) + "] is error filename " + aoxs.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aoxs.a(this.a));
          aowt.a(aowt.a(this.a.a), aoxs.b(this.a), aoxs.b(this.a), aoxs.b(this.a), aoxs.a(this.a), 0, paramInt1, paramInt2, i, false, aoxs.a(this.a), aoxs.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxt
 * JD-Core Version:    0.7.0.1
 */