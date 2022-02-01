import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class axmy
  implements aofv
{
  public axmy(TranslateController.ImageTranslateTask paramImageTranslateTask, aohl paramaohl) {}
  
  public void a(int paramInt, String paramString, aohg paramaohg)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramaohg != null)
      {
        localObject = paramaohg.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramaohg == null) || (paramaohg.a == null)) {
        break label241;
      }
      paramString = paramaohg.a;
      i = 1;
      paramaohg = this.jdField_a_of_type_Aohl.a.b;
      localObject = this.jdField_a_of_type_Aohl.a.a;
      paramString.c = paramaohg;
      if ((FileUtil.isFileExists((String)localObject)) && (!((String)localObject).equals(paramaohg))) {
        FileUtil.deleteFile((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramaohg, paramString);
      paramaohg = new HashMap();
      paramaohg.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Aohl.c));
      paramaohg.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramaohg.put("hasResult", paramString);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramaohg, "", false);
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
 * Qualified Name:     axmy
 * JD-Core Version:    0.7.0.1
 */