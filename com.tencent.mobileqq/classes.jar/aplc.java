import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class aplc
  implements amgv
{
  public ColorNote getColorNote()
  {
    amhb localamhb = new amhb();
    localamhb.a(17039360);
    String str = apvm.b(-1, "");
    if (QLog.isColorLevel()) {
      QLog.i("DefaultFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localamhb.a(str);
    localamhb.b("default_file");
    localamhb.c("0MB");
    localamhb.d("resdrawable://2130843550");
    return localamhb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplc
 * JD-Core Version:    0.7.0.1
 */