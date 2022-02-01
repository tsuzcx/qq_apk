import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.extendfriend.pulltorefresh.LoadingLayoutBase;
import java.util.HashSet;
import java.util.Iterator;

public class aslr
  implements aslq
{
  private final HashSet<LoadingLayoutBase> a = new HashSet();
  
  public void a(LoadingLayoutBase paramLoadingLayoutBase)
  {
    if (paramLoadingLayoutBase != null) {
      this.a.add(paramLoadingLayoutBase);
    }
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setLastUpdatedLabel(paramCharSequence);
    }
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setLoadingDrawable(paramDrawable);
    }
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setPullLabel(paramCharSequence);
    }
  }
  
  public void setRefreshResultLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setRefreshResultLabel(paramCharSequence);
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setRefreshingLabel(paramCharSequence);
    }
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setReleaseLabel(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslr
 * JD-Core Version:    0.7.0.1
 */