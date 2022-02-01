import com.tencent.mobileqq.data.ApolloActionData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class andu
{
  private List<WeakReference<aned>> a = new ArrayList();
  
  public void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public void a(aned paramaned)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() != paramaned));
    }
    return;
    this.a.add(new WeakReference(paramaned));
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (this.a.get(i) != null)
        {
          aned localaned = (aned)((WeakReference)this.a.get(i)).get();
          if (localaned != null) {
            localaned.a(paramApolloActionData);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (this.a.get(i) != null)
        {
          aned localaned = (aned)((WeakReference)this.a.get(i)).get();
          if (localaned != null) {
            localaned.a(paramBoolean);
          }
        }
        i += 1;
      }
    }
  }
  
  public void b()
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (this.a.get(i) != null)
        {
          aned localaned = (aned)((WeakReference)this.a.get(i)).get();
          if (localaned != null) {
            localaned.a();
          }
        }
        i += 1;
      }
    }
  }
  
  public void b(aned paramaned)
  {
    if (this.a != null) {
      this.a.remove(paramaned);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andu
 * JD-Core Version:    0.7.0.1
 */