import com.tencent.mobileqq.data.ApolloActionData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anlu
{
  private List<WeakReference<anml>> a = new ArrayList();
  
  public void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public void a(anml paramanml)
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
      } while ((localWeakReference == null) || (localWeakReference.get() != paramanml));
    }
    return;
    this.a.add(new WeakReference(paramanml));
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
          anml localanml = (anml)((WeakReference)this.a.get(i)).get();
          if (localanml != null) {
            localanml.a(paramApolloActionData);
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
          anml localanml = (anml)((WeakReference)this.a.get(i)).get();
          if (localanml != null) {
            localanml.a(paramBoolean);
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
          anml localanml = (anml)((WeakReference)this.a.get(i)).get();
          if (localanml != null) {
            localanml.a();
          }
        }
        i += 1;
      }
    }
  }
  
  public void b(anml paramanml)
  {
    if (this.a != null) {
      this.a.remove(paramanml);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlu
 * JD-Core Version:    0.7.0.1
 */