import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aoxx
  extends xaz
{
  aoxx(aoxw paramaoxw) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aoxw.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aoxw.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aoxw.a(this.a));
      aoxw.a(this.a).a(aowx.a(aoxw.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aoxw.a(this.a));
      aoxw.a(this.a).a(aowx.a(aoxw.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aoxw.a(this.a));
      aoxw.a(this.a).a(aowx.a(aoxw.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aoxw.a(this.a) + "] filename " + aoxw.a(this.a));
    aoxw.a(this.a, paramString1);
    aoxw.a(this.a).putString("_m_ForwardUuid", aoxw.b(this.a));
    if (aoxw.a(this.a) != 102)
    {
      aoxw.a(this.a).a(aoxw.b(this.a), aoxw.a(this.a));
      return;
    }
    aoxw.a(this.a, paramInt2);
    aoxw.a(this.a).putString("_m_ForwardBusType", String.valueOf(aoxw.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aoxw.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aoxw.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aoxw.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aoxw.d(this.a));
        j = 0;
        i = j;
        if (aoxw.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aoxw.e(this.a));
            if (aowx.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aoxw.a(this.a));
            aoxw.a(this.a).a(aowx.a(aoxw.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aoxw.c(this.a) + "] is error filename " + aoxw.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aoxw.d(this.a) + "] is error filename " + aoxw.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aoxw.e(this.a) + "] is error filename " + aoxw.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aoxw.a(this.a));
          aowx.a(aowx.a(this.a.a), aoxw.b(this.a), aoxw.b(this.a), aoxw.b(this.a), aoxw.a(this.a), 0, paramInt1, paramInt2, i, false, aoxw.a(this.a), aoxw.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxx
 * JD-Core Version:    0.7.0.1
 */