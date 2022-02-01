import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdzs
  extends bdzt
  implements bdxz<bdzt>
{
  public List<bdxv> b = new ArrayList();
  
  public bdzs(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public <N extends bdxv> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      bdzt localbdzt = (bdzt)this.b.get(i);
      if (paramString.equals(localbdzt.jdField_a_of_type_JavaLangString)) {
        return localbdzt;
      }
      if ((localbdzt instanceof bdzs)) {
        return ((bdzs)localbdzt).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public List<bdxv> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((bdzt)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(bdzt parambdzt)
  {
    if (parambdzt.jdField_a_of_type_Bdxz == null)
    {
      this.b.add(parambdzt);
      parambdzt.jdField_a_of_type_Bdxz = this;
      parambdzt.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bdxv)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bdxv)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((bdzt)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzs
 * JD-Core Version:    0.7.0.1
 */