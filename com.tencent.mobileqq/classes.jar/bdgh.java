import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdgh
  extends bdgi
  implements bdeo<bdgi>
{
  public List<bdek> b = new ArrayList();
  
  public bdgh(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public <N extends bdek> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      bdgi localbdgi = (bdgi)this.b.get(i);
      if (paramString.equals(localbdgi.jdField_a_of_type_JavaLangString)) {
        return localbdgi;
      }
      if ((localbdgi instanceof bdgh)) {
        return ((bdgh)localbdgi).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public List<bdek> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((bdgi)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(bdgi parambdgi)
  {
    if (parambdgi.jdField_a_of_type_Bdeo == null)
    {
      this.b.add(parambdgi);
      parambdgi.jdField_a_of_type_Bdeo = this;
      parambdgi.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bdek)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bdek)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((bdgi)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgh
 * JD-Core Version:    0.7.0.1
 */