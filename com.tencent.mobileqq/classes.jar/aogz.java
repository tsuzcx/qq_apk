import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aogz
  extends wlz
{
  aogz(aogy paramaogy) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aogy.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aogy.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aogy.a(this.a));
      aogy.a(this.a).a(aofz.a(aogy.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aogy.a(this.a));
      aogy.a(this.a).a(aofz.a(aogy.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aogy.a(this.a));
      aogy.a(this.a).a(aofz.a(aogy.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aogy.a(this.a) + "] filename " + aogy.a(this.a));
    aogy.a(this.a, paramString1);
    aogy.a(this.a).putString("_m_ForwardUuid", aogy.b(this.a));
    if (aogy.a(this.a) != 102)
    {
      aogy.a(this.a).a(aogy.b(this.a), aogy.a(this.a));
      return;
    }
    aogy.a(this.a, paramInt2);
    aogy.a(this.a).putString("_m_ForwardBusType", String.valueOf(aogy.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aogy.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aogy.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aogy.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aogy.d(this.a));
        j = 0;
        i = j;
        if (aogy.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aogy.e(this.a));
            if (aofz.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aogy.a(this.a));
            aogy.a(this.a).a(aofz.a(aogy.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aogy.c(this.a) + "] is error filename " + aogy.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aogy.d(this.a) + "] is error filename " + aogy.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aogy.e(this.a) + "] is error filename " + aogy.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aogy.a(this.a));
          aofz.a(aofz.a(this.a.a), aogy.b(this.a), aogy.b(this.a), aogy.b(this.a), aogy.a(this.a), 0, paramInt1, paramInt2, i, false, aogy.a(this.a), aogy.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aogz
 * JD-Core Version:    0.7.0.1
 */