import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class avro
  implements avrq
{
  avro(avrn paramavrn) {}
  
  public void a(int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.a.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.a.a.get(paramInt);
      if (!localPtvTemplateInfo.advertisement) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CapturePtvTemplateManager", 2, "info.advertisement is ture onItemClicked name: " + localPtvTemplateInfo.name);
      }
    } while (avrn.a(this.a) == null);
    avrn.a(this.a).a(localPtvTemplateInfo);
    return;
    this.a.a(paramInt);
    avtd.jdField_b_of_type_JavaLangString = avrn.a(this.a).a + "";
    avtd.c = localPtvTemplateInfo.id;
    avtd.a = localPtvTemplateInfo.hasGesture();
    boolean bool;
    if (localPtvTemplateInfo.kind == 3)
    {
      bool = true;
      avtd.jdField_b_of_type_Boolean = bool;
      if (axhr.a().a != 1) {
        break label228;
      }
    }
    label228:
    for (paramInt = i;; paramInt = 2)
    {
      avtd.f(paramInt);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avro
 * JD-Core Version:    0.7.0.1
 */