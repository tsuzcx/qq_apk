import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class atmx
  implements aqck
{
  public ColorNote getColorNote()
  {
    aqcs localaqcs = new aqcs();
    localaqcs.a(17039360);
    String str = atwt.b(-1, "");
    if (QLog.isColorLevel()) {
      QLog.i("DefaultFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaqcs.a(str);
    localaqcs.b("default_file");
    localaqcs.c("0MB");
    localaqcs.d("resdrawable://2130844375");
    return localaqcs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmx
 * JD-Core Version:    0.7.0.1
 */