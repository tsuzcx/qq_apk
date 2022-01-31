import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aycv
  extends aycw
  implements aybc<aycw>
{
  public List<ayay> b = new ArrayList();
  
  public aycv(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public <N extends ayay> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      aycw localaycw = (aycw)this.b.get(i);
      if (paramString.equals(localaycw.jdField_a_of_type_JavaLangString)) {
        return localaycw;
      }
      if ((localaycw instanceof aycv)) {
        return ((aycv)localaycw).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public List<ayay> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((aycw)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(aycw paramaycw)
  {
    if (paramaycw.jdField_a_of_type_Aybc == null)
    {
      this.b.add(paramaycw);
      paramaycw.jdField_a_of_type_Aybc = this;
      paramaycw.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ayay)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ayay)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((aycw)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aycv
 * JD-Core Version:    0.7.0.1
 */