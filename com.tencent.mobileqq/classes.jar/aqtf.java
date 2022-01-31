import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aqtf
  extends yuh
{
  aqtf(aqte paramaqte) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aqte.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aqte.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aqte.a(this.a));
      aqte.a(this.a).a(aqsf.a(aqte.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aqte.a(this.a));
      aqte.a(this.a).a(aqsf.a(aqte.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aqte.a(this.a));
      aqte.a(this.a).a(aqsf.a(aqte.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aqte.a(this.a) + "] filename " + aqte.a(this.a));
    aqte.a(this.a, paramString1);
    aqte.a(this.a).putString("_m_ForwardUuid", aqte.b(this.a));
    if (aqte.a(this.a) != 102)
    {
      aqte.a(this.a).a(aqte.b(this.a), aqte.a(this.a));
      return;
    }
    aqte.a(this.a, paramInt2);
    aqte.a(this.a).putString("_m_ForwardBusType", String.valueOf(aqte.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aqte.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aqte.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aqte.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aqte.d(this.a));
        j = 0;
        i = j;
        if (aqte.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aqte.e(this.a));
            if (aqsf.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aqte.a(this.a));
            aqte.a(this.a).a(aqsf.a(aqte.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aqte.c(this.a) + "] is error filename " + aqte.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aqte.d(this.a) + "] is error filename " + aqte.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aqte.e(this.a) + "] is error filename " + aqte.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aqte.a(this.a));
          aqsf.a(aqsf.a(this.a.a), aqte.b(this.a), aqte.b(this.a), aqte.b(this.a), aqte.a(this.a), 0, paramInt1, paramInt2, i, false, aqte.a(this.a), aqte.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqtf
 * JD-Core Version:    0.7.0.1
 */