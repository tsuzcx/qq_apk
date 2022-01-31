import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bafd
  extends bafe
  implements badk<bafe>
{
  public List<badg> b = new ArrayList();
  
  public bafd(SpriteNativeView paramSpriteNativeView)
  {
    this.a = paramSpriteNativeView;
  }
  
  public <N extends badg> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      bafe localbafe = (bafe)this.b.get(i);
      if (paramString.equals(localbafe.jdField_a_of_type_JavaLangString)) {
        return localbafe;
      }
      if ((localbafe instanceof bafd)) {
        return ((bafd)localbafe).a(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  public List<badg> a()
  {
    return this.b;
  }
  
  public void a()
  {
    super.a();
    int i = 0;
    while (i < this.b.size())
    {
      ((bafe)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(bafe parambafe)
  {
    if (parambafe.jdField_a_of_type_Badk == null)
    {
      this.b.add(parambafe);
      parambafe.jdField_a_of_type_Badk = this;
      parambafe.d();
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((badg)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((badg)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    int i = 0;
    while (i < this.b.size())
    {
      bool |= ((bafe)this.b.get(i)).c();
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafd
 * JD-Core Version:    0.7.0.1
 */