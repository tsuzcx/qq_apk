import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aygx
  implements aoys
{
  public aygx(TranslateController.ImageTranslateTask paramImageTranslateTask, apai paramapai) {}
  
  public void a(int paramInt, String paramString, apad paramapad)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramapad != null)
      {
        localObject = paramapad.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramapad == null) || (paramapad.a == null)) {
        break label241;
      }
      paramString = paramapad.a;
      i = 1;
      paramapad = this.jdField_a_of_type_Apai.a.b;
      localObject = this.jdField_a_of_type_Apai.a.a;
      paramString.c = paramapad;
      if ((atwl.a((String)localObject)) && (!((String)localObject).equals(paramapad))) {
        atwl.c((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramapad, paramString);
      paramapad = new HashMap();
      paramapad.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Apai.c));
      paramapad.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramapad.put("hasResult", paramString);
      bctj.a(BaseApplicationImpl.getContext()).a("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramapad, "", false);
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
 * Qualified Name:     aygx
 * JD-Core Version:    0.7.0.1
 */