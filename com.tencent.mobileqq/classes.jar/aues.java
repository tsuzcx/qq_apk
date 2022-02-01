import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class aues
  implements aqrn
{
  public ColorNote getColorNote()
  {
    aqrv localaqrv = new aqrv();
    localaqrv.a(17039360);
    String str = auoo.b(-1, "");
    if (QLog.isColorLevel()) {
      QLog.i("DefaultFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaqrv.a(str);
    localaqrv.b("default_file");
    localaqrv.c("0MB");
    localaqrv.d("resdrawable://2130844389");
    return localaqrv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aues
 * JD-Core Version:    0.7.0.1
 */