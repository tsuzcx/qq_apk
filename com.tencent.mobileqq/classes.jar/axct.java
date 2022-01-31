import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axct
  extends axcu
  implements axba<axcu>
{
  public List<axaw> b = new ArrayList();
  
  public axct(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public <N extends axaw> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      axcu localaxcu = (axcu)this.b.get(i);
      if (paramString.equals(localaxcu.jdField_a_of_type_JavaLangString)) {
        return localaxcu;
      }
      if ((localaxcu instanceof axct)) {
        return ((axct)localaxcu).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public List<axaw> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((axcu)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(axcu paramaxcu)
  {
    if (paramaxcu.jdField_a_of_type_Axba == null)
    {
      this.b.add(paramaxcu);
      paramaxcu.jdField_a_of_type_Axba = this;
      paramaxcu.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((axaw)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((axaw)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((axcu)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axct
 * JD-Core Version:    0.7.0.1
 */