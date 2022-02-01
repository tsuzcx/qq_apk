import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ayth
  implements apix
{
  public ayth(TranslateController.ImageTranslateTask paramImageTranslateTask, apkn paramapkn) {}
  
  public void a(int paramInt, String paramString, apki paramapki)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramapki != null)
      {
        localObject = paramapki.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramapki == null) || (paramapki.a == null)) {
        break label241;
      }
      paramString = paramapki.a;
      i = 1;
      paramapki = this.jdField_a_of_type_Apkn.a.b;
      localObject = this.jdField_a_of_type_Apkn.a.a;
      paramString.c = paramapki;
      if ((FileUtil.isFileExists((String)localObject)) && (!((String)localObject).equals(paramapki))) {
        FileUtil.deleteFile((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramapki, paramString);
      paramapki = new HashMap();
      paramapki.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Apkn.c));
      paramapki.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramapki.put("hasResult", paramString);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramapki, "", false);
      return;
      localObject = null;
      break;
      label241:
      paramString = new TranslateResult(2);
      paramString.b = 1002;
      break label82;
      bool = false;
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayth
 * JD-Core Version:    0.7.0.1
 */