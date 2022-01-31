import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OcrControl.5.1;
import com.tencent.mobileqq.ocr.OcrControl.5.2;
import com.tencent.mobileqq.ocr.OcrControl.5.3;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

public class aubn
  implements alex
{
  aubn(aubm paramaubm) {}
  
  public void a(int paramInt, String paramString, algo paramalgo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "retCode:" + paramInt + ",sessionId:" + paramString + ",recogResult:" + paramalgo);
    }
    paramString = aubm.a(this.a, paramString);
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
        if ((paramInt != 0) || (paramalgo == null) || (paramalgo.a == null)) {
          break label282;
        }
        paramalgo = paramalgo.a;
        OcrRecogResult localOcrRecogResult = paramalgo.a();
        if (aubm.a(this.a) != null) {
          aubm.a(this.a).a(0, localOcrRecogResult, paramString.a.b, l);
        }
        if ((localOcrRecogResult != null) && ((this.a.a == 1) || (this.a.a == 2))) {
          ThreadManager.postImmediately(new OcrControl.5.1(this, localOcrRecogResult, paramString), null, false);
        }
        if (paramalgo.a == null) {
          break label334;
        }
        i = paramalgo.a.a;
        j = paramalgo.a.b;
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
        if (aubm.a(this.a) != null)
        {
          aubm.a(this.a).a(3, null, paramString.a.b, l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubn
 * JD-Core Version:    0.7.0.1
 */