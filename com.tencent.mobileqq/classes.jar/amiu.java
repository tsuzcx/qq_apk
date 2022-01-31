import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.tencent.qphone.base.util.QLog;

public class amiu
  extends Resources
{
  private amiy a;
  
  public amiu(amiy paramamiy)
  {
    super(paramamiy.b().getAssets(), paramamiy.b().getDisplayMetrics(), paramamiy.b().getConfiguration());
    this.a = paramamiy;
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
 * Qualified Name:     amiu
 * JD-Core Version:    0.7.0.1
 */