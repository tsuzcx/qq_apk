import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class amxh
  extends anvi
{
  amxh(amxg paramamxg) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qwe", 2, "onUpdateFriendInfo:" + paramString);
    }
    if ((amxg.a(this.a) != null) && (amxg.a(this.a).get(paramString + "nick") != null))
    {
      int i = ((Integer)amxg.a(this.a).remove(paramString + "nick")).intValue();
      this.a.a(i, paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxh
 * JD-Core Version:    0.7.0.1
 */