import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.tencent.qphone.base.util.QLog;

public class aorl
  extends Resources
{
  private aorp a;
  
  public aorl(aorp paramaorp)
  {
    super(paramaorp.b().getAssets(), paramaorp.b().getDisplayMetrics(), paramaorp.b().getConfiguration());
    this.a = paramaorp;
  }
  
  public CharSequence getText(int paramInt)
  {
    int i = this.a.a(paramInt);
    try
    {
      CharSequence localCharSequence = this.a.a().getText(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiLanguageEngine", 4, new Object[] { "getText delegate:", Integer.valueOf(paramInt), " ,langId:", Integer.valueOf(i), " ,content:" + localCharSequence });
      }
      return localCharSequence;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return this.a.b().getText(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aorl
 * JD-Core Version:    0.7.0.1
 */