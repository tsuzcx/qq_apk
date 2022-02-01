import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class atjy
  extends aahl
{
  atjy(atjx paramatjx) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (atjx.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + atjx.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + atjx.a(this.a));
      atjx.a(this.a).a(atiy.a(atjx.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + atjx.a(this.a));
      atjx.a(this.a).a(atiy.a(atjx.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + atjx.a(this.a));
      atjx.a(this.a).a(atiy.a(atjx.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + atjx.a(this.a) + "] filename " + atjx.a(this.a));
    atjx.a(this.a, paramString1);
    atjx.a(this.a).putString("_m_ForwardUuid", atjx.b(this.a));
    if (atjx.a(this.a) != 102)
    {
      atjx.a(this.a).a(atjx.b(this.a), atjx.a(this.a));
      return;
    }
    atjx.a(this.a, paramInt2);
    atjx.a(this.a).putString("_m_ForwardBusType", String.valueOf(atjx.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!atjx.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(atjx.c(this.a));
      i = 0;
      paramInt2 = i;
      if (atjx.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(atjx.d(this.a));
        j = 0;
        i = j;
        if (atjx.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(atjx.e(this.a));
            if (atiy.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + atjx.a(this.a));
            atjx.a(this.a).a(atiy.a(atjx.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + atjx.c(this.a) + "] is error filename " + atjx.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + atjx.d(this.a) + "] is error filename " + atjx.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + atjx.e(this.a) + "] is error filename " + atjx.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + atjx.a(this.a));
          atiy.a(atiy.a(this.a.a), atjx.b(this.a), atjx.b(this.a), atjx.b(this.a), atjx.a(this.a), 0, paramInt1, paramInt2, i, false, atjx.a(this.a), atjx.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjy
 * JD-Core Version:    0.7.0.1
 */