import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bcst
  extends bcsu
  implements bcra<bcsu>
{
  public List<bcqw> b = new ArrayList();
  
  public bcst(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public <N extends bcqw> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      bcsu localbcsu = (bcsu)this.b.get(i);
      if (paramString.equals(localbcsu.jdField_a_of_type_JavaLangString)) {
        return localbcsu;
      }
      if ((localbcsu instanceof bcst)) {
        return ((bcst)localbcsu).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public List<bcqw> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((bcsu)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(bcsu parambcsu)
  {
    if (parambcsu.jdField_a_of_type_Bcra == null)
    {
      this.b.add(parambcsu);
      parambcsu.jdField_a_of_type_Bcra = this;
      parambcsu.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bcqw)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bcqw)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((bcsu)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcst
 * JD-Core Version:    0.7.0.1
 */