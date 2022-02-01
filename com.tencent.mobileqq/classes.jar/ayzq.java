import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ayzq
  implements apmi
{
  public ayzq(TranslateController.ImageTranslateTask paramImageTranslateTask, apny paramapny) {}
  
  public void a(int paramInt, String paramString, apnt paramapnt)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramapnt != null)
      {
        localObject = paramapnt.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramapnt == null) || (paramapnt.a == null)) {
        break label241;
      }
      paramString = paramapnt.a;
      i = 1;
      paramapnt = this.jdField_a_of_type_Apny.a.b;
      localObject = this.jdField_a_of_type_Apny.a.a;
      paramString.c = paramapnt;
      if ((auog.a((String)localObject)) && (!((String)localObject).equals(paramapnt))) {
        auog.c((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramapnt, paramString);
      paramapnt = new HashMap();
      paramapnt.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Apny.c));
      paramapnt.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramapnt.put("hasResult", paramString);
      bdmc.a(BaseApplicationImpl.getContext()).a("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramapnt, "", false);
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
 * Qualified Name:     ayzq
 * JD-Core Version:    0.7.0.1
 */