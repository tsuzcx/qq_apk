import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aubq
  implements alex
{
  public aubq(TranslateController.ImageTranslateTask paramImageTranslateTask, algt paramalgt) {}
  
  public void a(int paramInt, String paramString, algo paramalgo)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramalgo != null)
      {
        localObject = paramalgo.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramalgo == null) || (paramalgo.a == null)) {
        break label241;
      }
      paramString = paramalgo.a;
      i = 1;
      paramalgo = this.jdField_a_of_type_Algt.a.b;
      localObject = this.jdField_a_of_type_Algt.a.a;
      paramString.c = paramalgo;
      if ((apvb.a((String)localObject)) && (!((String)localObject).equals(paramalgo))) {
        apvb.c((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramalgo, paramString);
      paramalgo = new HashMap();
      paramalgo.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Algt.c));
      paramalgo.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramalgo.put("hasResult", paramString);
      axrl.a(BaseApplicationImpl.getContext()).a("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramalgo, "", false);
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
 * Qualified Name:     aubq
 * JD-Core Version:    0.7.0.1
 */