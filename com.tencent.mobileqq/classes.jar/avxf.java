import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class avxf
  implements anab
{
  public avxf(TranslateController.ImageTranslateTask paramImageTranslateTask, anbr paramanbr) {}
  
  public void a(int paramInt, String paramString, anbm paramanbm)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramanbm != null)
      {
        localObject = paramanbm.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramanbm == null) || (paramanbm.a == null)) {
        break label241;
      }
      paramString = paramanbm.a;
      i = 1;
      paramanbm = this.jdField_a_of_type_Anbr.a.b;
      localObject = this.jdField_a_of_type_Anbr.a.a;
      paramString.c = paramanbm;
      if ((arso.a((String)localObject)) && (!((String)localObject).equals(paramanbm))) {
        arso.c((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramanbm, paramString);
      paramanbm = new HashMap();
      paramanbm.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Anbr.c));
      paramanbm.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramanbm.put("hasResult", paramString);
      azri.a(BaseApplicationImpl.getContext()).a("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramanbm, "", false);
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
 * Qualified Name:     avxf
 * JD-Core Version:    0.7.0.1
 */