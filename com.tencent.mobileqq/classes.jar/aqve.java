import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aqve
  extends yuh
{
  aqve(aqvd paramaqvd) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aqvd.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aqvd.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aqvd.a(this.a));
      aqvd.a(this.a).a(aque.a(aqvd.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aqvd.a(this.a));
      aqvd.a(this.a).a(aque.a(aqvd.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aqvd.a(this.a));
      aqvd.a(this.a).a(aque.a(aqvd.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aqvd.a(this.a) + "] filename " + aqvd.a(this.a));
    aqvd.a(this.a, paramString1);
    aqvd.a(this.a).putString("_m_ForwardUuid", aqvd.b(this.a));
    if (aqvd.a(this.a) != 102)
    {
      aqvd.a(this.a).a(aqvd.b(this.a), aqvd.a(this.a));
      return;
    }
    aqvd.a(this.a, paramInt2);
    aqvd.a(this.a).putString("_m_ForwardBusType", String.valueOf(aqvd.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aqvd.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aqvd.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aqvd.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aqvd.d(this.a));
        j = 0;
        i = j;
        if (aqvd.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aqvd.e(this.a));
            if (aque.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aqvd.a(this.a));
            aqvd.a(this.a).a(aque.a(aqvd.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aqvd.c(this.a) + "] is error filename " + aqvd.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aqvd.d(this.a) + "] is error filename " + aqvd.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aqvd.e(this.a) + "] is error filename " + aqvd.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aqvd.a(this.a));
          aque.a(aque.a(this.a.a), aqvd.b(this.a), aqvd.b(this.a), aqvd.b(this.a), aqvd.a(this.a), 0, paramInt1, paramInt2, i, false, aqvd.a(this.a), aqvd.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqve
 * JD-Core Version:    0.7.0.1
 */