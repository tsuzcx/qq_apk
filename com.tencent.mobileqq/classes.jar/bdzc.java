import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdzc
  extends bdzd
  implements bdxj<bdzd>
{
  public List<bdxf> b = new ArrayList();
  
  public bdzc(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public <N extends bdxf> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      bdzd localbdzd = (bdzd)this.b.get(i);
      if (paramString.equals(localbdzd.jdField_a_of_type_JavaLangString)) {
        return localbdzd;
      }
      if ((localbdzd instanceof bdzc)) {
        return ((bdzc)localbdzd).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public List<bdxf> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((bdzd)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(bdzd parambdzd)
  {
    if (parambdzd.jdField_a_of_type_Bdxj == null)
    {
      this.b.add(parambdzd);
      parambdzd.jdField_a_of_type_Bdxj = this;
      parambdzd.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bdxf)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bdxf)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((bdzd)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzc
 * JD-Core Version:    0.7.0.1
 */