import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

public class beyf
  extends Handler
{
  private ArrayList<Class<?>> filterList = new ArrayList();
  
  public beyf()
  {
    this.filterList.clear();
  }
  
  public beyf(Looper paramLooper)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyf
 * JD-Core Version:    0.7.0.1
 */