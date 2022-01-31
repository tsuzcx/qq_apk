import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OcrControl.5.1;
import com.tencent.mobileqq.ocr.OcrControl.5.2;
import com.tencent.mobileqq.ocr.OcrControl.5.3;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

public class avst
  implements amvm
{
  avst(avss paramavss) {}
  
  public void a(int paramInt, String paramString, amxd paramamxd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "retCode:" + paramInt + ",sessionId:" + paramString + ",recogResult:" + paramamxd);
    }
    paramString = avss.a(this.a, paramString);
    long l = 0L;
    if (paramString != null) {
      l = System.currentTimeMillis() - paramString.c;
    }
    int k = -1;
    int m = -1;
    int i = m;
    int j = k;
    if (paramString != null)
    {
      i = m;
      j = k;
      if (paramString.a != null)
      {
        if ((paramInt != 0) || (paramamxd == null) || (paramamxd.a == null)) {
          break label282;
        }
        paramamxd = paramamxd.a;
        OcrRecogResult localOcrRecogResult = paramamxd.a();
        if (avss.a(this.a) != null) {
          avss.a(this.a).a(0, localOcrRecogResult, paramString.a.b, l);
        }
        if ((localOcrRecogResult != null) && ((this.a.a == 1) || (this.a.a == 2))) {
          ThreadManager.postImmediately(new OcrControl.5.1(this, localOcrRecogResult, paramString), null, false);
        }
        if (paramamxd.a == null) {
          break label334;
        }
        i = paramamxd.a.a;
        j = paramamxd.a.b;
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      for (;;)
      {
        ThreadManager.postImmediately(new OcrControl.5.2(this, paramString), null, false);
        ThreadManager.post(new OcrControl.5.3(this, j, i, paramInt), 5, null, false);
        return;
        label282:
        i = m;
        j = k;
        if (avss.a(this.a) != null)
        {
          avss.a(this.a).a(3, null, paramString.a.b, l);
          i = m;
          j = k;
        }
      }
      label334:
      j = -1;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avst
 * JD-Core Version:    0.7.0.1
 */