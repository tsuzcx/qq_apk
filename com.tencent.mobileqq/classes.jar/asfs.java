import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class asfs
  extends zrz
{
  asfs(asfr paramasfr) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (asfr.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + asfr.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + asfr.a(this.a));
      asfr.a(this.a).a(ases.a(asfr.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + asfr.a(this.a));
      asfr.a(this.a).a(ases.a(asfr.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + asfr.a(this.a));
      asfr.a(this.a).a(ases.a(asfr.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + asfr.a(this.a) + "] filename " + asfr.a(this.a));
    asfr.a(this.a, paramString1);
    asfr.a(this.a).putString("_m_ForwardUuid", asfr.b(this.a));
    if (asfr.a(this.a) != 102)
    {
      asfr.a(this.a).a(asfr.b(this.a), asfr.a(this.a));
      return;
    }
    asfr.a(this.a, paramInt2);
    asfr.a(this.a).putString("_m_ForwardBusType", String.valueOf(asfr.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!asfr.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(asfr.c(this.a));
      i = 0;
      paramInt2 = i;
      if (asfr.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(asfr.d(this.a));
        j = 0;
        i = j;
        if (asfr.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(asfr.e(this.a));
            if (ases.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + asfr.a(this.a));
            asfr.a(this.a).a(ases.a(asfr.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + asfr.c(this.a) + "] is error filename " + asfr.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + asfr.d(this.a) + "] is error filename " + asfr.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + asfr.e(this.a) + "] is error filename " + asfr.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + asfr.a(this.a));
          ases.a(ases.a(this.a.a), asfr.b(this.a), asfr.b(this.a), asfr.b(this.a), asfr.a(this.a), 0, paramInt1, paramInt2, i, false, asfr.a(this.a), asfr.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfs
 * JD-Core Version:    0.7.0.1
 */