import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class atti
  extends aavm
{
  atti(atth paramatth) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (atth.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + atth.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + atth.a(this.a));
      atth.a(this.a).a(atsi.a(atth.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + atth.a(this.a));
      atth.a(this.a).a(atsi.a(atth.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + atth.a(this.a));
      atth.a(this.a).a(atsi.a(atth.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + atth.a(this.a) + "] filename " + atth.a(this.a));
    atth.a(this.a, paramString1);
    atth.a(this.a).putString("_m_ForwardUuid", atth.b(this.a));
    if (atth.a(this.a) != 102)
    {
      atth.a(this.a).a(atth.b(this.a), atth.a(this.a));
      return;
    }
    atth.a(this.a, paramInt2);
    atth.a(this.a).putString("_m_ForwardBusType", String.valueOf(atth.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!atth.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(atth.c(this.a));
      i = 0;
      paramInt2 = i;
      if (atth.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(atth.d(this.a));
        j = 0;
        i = j;
        if (atth.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(atth.e(this.a));
            if (atsi.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + atth.a(this.a));
            atth.a(this.a).a(atsi.a(atth.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + atth.c(this.a) + "] is error filename " + atth.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + atth.d(this.a) + "] is error filename " + atth.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + atth.e(this.a) + "] is error filename " + atth.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + atth.a(this.a));
          atsi.a(atsi.a(this.a.a), atth.b(this.a), atth.b(this.a), atth.b(this.a), atth.a(this.a), 0, paramInt1, paramInt2, i, false, atth.a(this.a), atth.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atti
 * JD-Core Version:    0.7.0.1
 */