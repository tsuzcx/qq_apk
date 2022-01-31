import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class apky
  implements amgw
{
  public ColorNote getColorNote()
  {
    amhc localamhc = new amhc();
    localamhc.a(17039360);
    String str = apvk.b(-1, "");
    if (QLog.isColorLevel()) {
      QLog.i("DefaultFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localamhc.a(str);
    localamhc.b("default_file");
    localamhc.c("0MB");
    localamhc.d("resdrawable://2130843549");
    return localamhc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apky
 * JD-Core Version:    0.7.0.1
 */