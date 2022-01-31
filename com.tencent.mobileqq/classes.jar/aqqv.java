import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aqqv
  extends yps
{
  aqqv(aqqu paramaqqu) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aqqu.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aqqu.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aqqu.a(this.a));
      aqqu.a(this.a).a(aqpv.a(aqqu.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aqqu.a(this.a));
      aqqu.a(this.a).a(aqpv.a(aqqu.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aqqu.a(this.a));
      aqqu.a(this.a).a(aqpv.a(aqqu.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aqqu.a(this.a) + "] filename " + aqqu.a(this.a));
    aqqu.a(this.a, paramString1);
    aqqu.a(this.a).putString("_m_ForwardUuid", aqqu.b(this.a));
    if (aqqu.a(this.a) != 102)
    {
      aqqu.a(this.a).a(aqqu.b(this.a), aqqu.a(this.a));
      return;
    }
    aqqu.a(this.a, paramInt2);
    aqqu.a(this.a).putString("_m_ForwardBusType", String.valueOf(aqqu.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aqqu.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aqqu.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aqqu.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aqqu.d(this.a));
        j = 0;
        i = j;
        if (aqqu.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aqqu.e(this.a));
            if (aqpv.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aqqu.a(this.a));
            aqqu.a(this.a).a(aqpv.a(aqqu.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aqqu.c(this.a) + "] is error filename " + aqqu.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aqqu.d(this.a) + "] is error filename " + aqqu.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aqqu.e(this.a) + "] is error filename " + aqqu.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aqqu.a(this.a));
          aqpv.a(aqpv.a(this.a.a), aqqu.b(this.a), aqqu.b(this.a), aqqu.b(this.a), aqqu.a(this.a), 0, paramInt1, paramInt2, i, false, aqqu.a(this.a), aqqu.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqv
 * JD-Core Version:    0.7.0.1
 */