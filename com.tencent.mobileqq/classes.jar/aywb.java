import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

public class aywb
  extends Handler
{
  private ArrayList<Class<?>> filterList = new ArrayList();
  
  public aywb()
  {
    this.filterList.clear();
  }
  
  public aywb(Looper paramLooper)
  {
    super(paramLooper);
    this.filterList.clear();
  }
  
  public void addFilter(Class<?>... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.filterList.add(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public ArrayList<Class<?>> getFilter()
  {
    return this.filterList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aywb
 * JD-Core Version:    0.7.0.1
 */