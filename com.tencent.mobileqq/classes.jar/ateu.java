import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ateu
  implements akql
{
  public ateu(TranslateController.ImageTranslateTask paramImageTranslateTask, aksh paramaksh) {}
  
  public void a(int paramInt, String paramString, aksc paramaksc)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramaksc != null)
      {
        localObject = paramaksc.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramaksc == null) || (paramaksc.a == null)) {
        break label241;
      }
      paramString = paramaksc.a;
      i = 1;
      paramaksc = this.jdField_a_of_type_Aksh.a.b;
      localObject = this.jdField_a_of_type_Aksh.a.a;
      paramString.c = paramaksc;
      if ((apdh.a((String)localObject)) && (!((String)localObject).equals(paramaksc))) {
        apdh.c((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramaksc, paramString);
      paramaksc = new HashMap();
      paramaksc.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Aksh.c));
      paramaksc.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramaksc.put("hasResult", paramString);
      awrn.a(BaseApplicationImpl.getContext()).a("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramaksc, "", false);
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
 * Qualified Name:     ateu
 * JD-Core Version:    0.7.0.1
 */