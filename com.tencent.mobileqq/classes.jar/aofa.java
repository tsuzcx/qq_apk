import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aofa
  extends wlz
{
  aofa(aoez paramaoez) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aoez.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aoez.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aoez.a(this.a));
      aoez.a(this.a).a(aoea.a(aoez.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aoez.a(this.a));
      aoez.a(this.a).a(aoea.a(aoez.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aoez.a(this.a));
      aoez.a(this.a).a(aoea.a(aoez.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aoez.a(this.a) + "] filename " + aoez.a(this.a));
    aoez.a(this.a, paramString1);
    aoez.a(this.a).putString("_m_ForwardUuid", aoez.b(this.a));
    if (aoez.a(this.a) != 102)
    {
      aoez.a(this.a).a(aoez.b(this.a), aoez.a(this.a));
      return;
    }
    aoez.a(this.a, paramInt2);
    aoez.a(this.a).putString("_m_ForwardBusType", String.valueOf(aoez.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aoez.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aoez.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aoez.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aoez.d(this.a));
        j = 0;
        i = j;
        if (aoez.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aoez.e(this.a));
            if (aoea.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aoez.a(this.a));
            aoez.a(this.a).a(aoea.a(aoez.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aoez.c(this.a) + "] is error filename " + aoez.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aoez.d(this.a) + "] is error filename " + aoez.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aoez.e(this.a) + "] is error filename " + aoez.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aoez.a(this.a));
          aoea.a(aoea.a(this.a.a), aoez.b(this.a), aoez.b(this.a), aoez.b(this.a), aoez.a(this.a), 0, paramInt1, paramInt2, i, false, aoez.a(this.a), aoez.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aofa
 * JD-Core Version:    0.7.0.1
 */