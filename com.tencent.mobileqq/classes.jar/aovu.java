import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aovu
  extends xbc
{
  aovu(aovt paramaovt) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aovt.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aovt.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aovt.a(this.a));
      aovt.a(this.a).a(aouu.a(aovt.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aovt.a(this.a));
      aovt.a(this.a).a(aouu.a(aovt.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aovt.a(this.a));
      aovt.a(this.a).a(aouu.a(aovt.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aovt.a(this.a) + "] filename " + aovt.a(this.a));
    aovt.a(this.a, paramString1);
    aovt.a(this.a).putString("_m_ForwardUuid", aovt.b(this.a));
    if (aovt.a(this.a) != 102)
    {
      aovt.a(this.a).a(aovt.b(this.a), aovt.a(this.a));
      return;
    }
    aovt.a(this.a, paramInt2);
    aovt.a(this.a).putString("_m_ForwardBusType", String.valueOf(aovt.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aovt.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aovt.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aovt.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aovt.d(this.a));
        j = 0;
        i = j;
        if (aovt.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aovt.e(this.a));
            if (aouu.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aovt.a(this.a));
            aovt.a(this.a).a(aouu.a(aovt.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aovt.c(this.a) + "] is error filename " + aovt.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aovt.d(this.a) + "] is error filename " + aovt.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aovt.e(this.a) + "] is error filename " + aovt.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aovt.a(this.a));
          aouu.a(aouu.a(this.a.a), aovt.b(this.a), aovt.b(this.a), aovt.b(this.a), aovt.a(this.a), 0, paramInt1, paramInt2, i, false, aovt.a(this.a), aovt.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovu
 * JD-Core Version:    0.7.0.1
 */