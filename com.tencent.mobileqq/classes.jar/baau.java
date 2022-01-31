import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class baau
  extends baav
  implements azzb<baav>
{
  public List<azyx> b = new ArrayList();
  
  public baau(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public <N extends azyx> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      baav localbaav = (baav)this.b.get(i);
      if (paramString.equals(localbaav.jdField_a_of_type_JavaLangString)) {
        return localbaav;
      }
      if ((localbaav instanceof baau)) {
        return ((baau)localbaav).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public List<azyx> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((baav)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(baav parambaav)
  {
    if (parambaav.jdField_a_of_type_Azzb == null)
    {
      this.b.add(parambaav);
      parambaav.jdField_a_of_type_Azzb = this;
      parambaav.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((azyx)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((azyx)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((baav)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baau
 * JD-Core Version:    0.7.0.1
 */