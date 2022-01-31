import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class avsw
  implements amvm
{
  public avsw(TranslateController.ImageTranslateTask paramImageTranslateTask, amxi paramamxi) {}
  
  public void a(int paramInt, String paramString, amxd paramamxd)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramamxd != null)
      {
        localObject = paramamxd.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramamxd == null) || (paramamxd.a == null)) {
        break label241;
      }
      paramString = paramamxd.a;
      i = 1;
      paramamxd = this.jdField_a_of_type_Amxi.a.b;
      localObject = this.jdField_a_of_type_Amxi.a.a;
      paramString.c = paramamxd;
      if ((arof.a((String)localObject)) && (!((String)localObject).equals(paramamxd))) {
        arof.c((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramamxd, paramString);
      paramamxd = new HashMap();
      paramamxd.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Amxi.c));
      paramamxd.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramamxd.put("hasResult", paramString);
      azmz.a(BaseApplicationImpl.getContext()).a("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramamxd, "", false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avsw
 * JD-Core Version:    0.7.0.1
 */