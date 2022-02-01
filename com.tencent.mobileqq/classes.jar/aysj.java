import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.ocr.OCRResultActivity.9.1;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class aysj
  extends ayri
{
  public aysj(OCRResultActivity paramOCRResultActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult)
  {
    if (OCRResultActivity.a(this.a)) {
      return;
    }
    this.a.runOnUiThread(new OCRResultActivity.9.1(this, paramBoolean, paramInt, paramTranslateResult));
    HashMap localHashMap = new HashMap();
    if (paramTranslateResult != null) {}
    for (int i = paramTranslateResult.b;; i = 2000)
    {
      localHashMap.put("errCode", String.valueOf(i));
      localHashMap.put("type", String.valueOf(paramInt));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "SCAN_TRANSLATE_RESULT", paramBoolean, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysj
 * JD-Core Version:    0.7.0.1
 */