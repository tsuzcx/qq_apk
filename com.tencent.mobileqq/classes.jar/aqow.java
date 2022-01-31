import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aqow
  extends yps
{
  aqow(aqov paramaqov) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aqov.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aqov.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aqov.a(this.a));
      aqov.a(this.a).a(aqnw.a(aqov.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aqov.a(this.a));
      aqov.a(this.a).a(aqnw.a(aqov.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aqov.a(this.a));
      aqov.a(this.a).a(aqnw.a(aqov.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aqov.a(this.a) + "] filename " + aqov.a(this.a));
    aqov.a(this.a, paramString1);
    aqov.a(this.a).putString("_m_ForwardUuid", aqov.b(this.a));
    if (aqov.a(this.a) != 102)
    {
      aqov.a(this.a).a(aqov.b(this.a), aqov.a(this.a));
      return;
    }
    aqov.a(this.a, paramInt2);
    aqov.a(this.a).putString("_m_ForwardBusType", String.valueOf(aqov.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aqov.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aqov.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aqov.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aqov.d(this.a));
        j = 0;
        i = j;
        if (aqov.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aqov.e(this.a));
            if (aqnw.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aqov.a(this.a));
            aqov.a(this.a).a(aqnw.a(aqov.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aqov.c(this.a) + "] is error filename " + aqov.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aqov.d(this.a) + "] is error filename " + aqov.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aqov.e(this.a) + "] is error filename " + aqov.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aqov.a(this.a));
          aqnw.a(aqnw.a(this.a.a), aqov.b(this.a), aqov.b(this.a), aqov.b(this.a), aqov.a(this.a), 0, paramInt1, paramInt2, i, false, aqov.a(this.a), aqov.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqow
 * JD-Core Version:    0.7.0.1
 */