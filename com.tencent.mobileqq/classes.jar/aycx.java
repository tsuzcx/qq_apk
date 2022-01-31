import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aycx
  extends aycy
  implements aybe<aycy>
{
  public List<ayba> b = new ArrayList();
  
  public aycx(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public <N extends ayba> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      aycy localaycy = (aycy)this.b.get(i);
      if (paramString.equals(localaycy.jdField_a_of_type_JavaLangString)) {
        return localaycy;
      }
      if ((localaycy instanceof aycx)) {
        return ((aycx)localaycy).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public List<ayba> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((aycy)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(aycy paramaycy)
  {
    if (paramaycy.jdField_a_of_type_Aybe == null)
    {
      this.b.add(paramaycy);
      paramaycy.jdField_a_of_type_Aybe = this;
      paramaycy.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ayba)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ayba)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((aycy)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aycx
 * JD-Core Version:    0.7.0.1
 */