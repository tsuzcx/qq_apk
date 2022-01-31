import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aovy
  extends xaz
{
  aovy(aovx paramaovx) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (aovx.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + aovx.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aovx.a(this.a));
      aovx.a(this.a).a(aouy.a(aovx.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + aovx.a(this.a));
      aovx.a(this.a).a(aouy.a(aovx.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + aovx.a(this.a));
      aovx.a(this.a).a(aouy.a(aovx.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + aovx.a(this.a) + "] filename " + aovx.a(this.a));
    aovx.a(this.a, paramString1);
    aovx.a(this.a).putString("_m_ForwardUuid", aovx.b(this.a));
    if (aovx.a(this.a) != 102)
    {
      aovx.a(this.a).a(aovx.b(this.a), aovx.a(this.a));
      return;
    }
    aovx.a(this.a, paramInt2);
    aovx.a(this.a).putString("_m_ForwardBusType", String.valueOf(aovx.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!aovx.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(aovx.c(this.a));
      i = 0;
      paramInt2 = i;
      if (aovx.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(aovx.d(this.a));
        j = 0;
        i = j;
        if (aovx.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(aovx.e(this.a));
            if (aouy.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + aovx.a(this.a));
            aovx.a(this.a).a(aouy.a(aovx.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + aovx.c(this.a) + "] is error filename " + aovx.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + aovx.d(this.a) + "] is error filename " + aovx.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + aovx.e(this.a) + "] is error filename " + aovx.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + aovx.a(this.a));
          aouy.a(aouy.a(this.a.a), aovx.b(this.a), aovx.b(this.a), aovx.b(this.a), aovx.a(this.a), 0, paramInt1, paramInt2, i, false, aovx.a(this.a), aovx.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovy
 * JD-Core Version:    0.7.0.1
 */