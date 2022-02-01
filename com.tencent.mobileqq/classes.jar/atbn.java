import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class atbn
  extends aarj
{
  atbn(atbm paramatbm) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (atbm.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + atbm.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + atbm.a(this.a));
      atbm.a(this.a).a(atan.a(atbm.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + atbm.a(this.a));
      atbm.a(this.a).a(atan.a(atbm.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + atbm.a(this.a));
      atbm.a(this.a).a(atan.a(atbm.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + atbm.a(this.a) + "] filename " + atbm.a(this.a));
    atbm.a(this.a, paramString1);
    atbm.a(this.a).putString("_m_ForwardUuid", atbm.b(this.a));
    if (atbm.a(this.a) != 102)
    {
      atbm.a(this.a).a(atbm.b(this.a), atbm.a(this.a));
      return;
    }
    atbm.a(this.a, paramInt2);
    atbm.a(this.a).putString("_m_ForwardBusType", String.valueOf(atbm.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!atbm.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(atbm.c(this.a));
      i = 0;
      paramInt2 = i;
      if (atbm.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(atbm.d(this.a));
        j = 0;
        i = j;
        if (atbm.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(atbm.e(this.a));
            if (atan.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + atbm.a(this.a));
            atbm.a(this.a).a(atan.a(atbm.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + atbm.c(this.a) + "] is error filename " + atbm.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + atbm.d(this.a) + "] is error filename " + atbm.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + atbm.e(this.a) + "] is error filename " + atbm.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + atbm.a(this.a));
          atan.a(atan.a(this.a.a), atbm.b(this.a), atbm.b(this.a), atbm.b(this.a), atbm.a(this.a), 0, paramInt1, paramInt2, i, false, atbm.a(this.a), atbm.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbn
 * JD-Core Version:    0.7.0.1
 */