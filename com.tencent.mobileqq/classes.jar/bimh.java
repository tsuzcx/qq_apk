import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class bimh
  implements bimn
{
  bimh(bimm parambimm) {}
  
  public void a(boolean paramBoolean, Context paramContext, bimp parambimp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      bimg.d(paramContext, parambimp);
    }
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimh
 * JD-Core Version:    0.7.0.1
 */