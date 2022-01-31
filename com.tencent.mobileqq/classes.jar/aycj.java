import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aycj
  extends ayck
  implements aybe<ayck>, aycl
{
  public List<ayba> b = new ArrayList();
  
  public aycj(SpriteGLView paramSpriteGLView)
  {
    this.a = paramSpriteGLView;
  }
  
  public <N extends ayba> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      ayck localayck = (ayck)this.b.get(i);
      if (paramString.equals(localayck.jdField_a_of_type_JavaLangString)) {
        return localayck;
      }
      if ((localayck instanceof aycj)) {
        return ((aycj)localayck).a(paramString);
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
      ((ayck)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(ayck paramayck)
  {
    if (paramayck.jdField_a_of_type_Aybe == null)
    {
      this.b.add(paramayck);
      paramayck.jdField_a_of_type_Aybe = this;
      return;
    }
    new RuntimeException("the node had another parent");
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = this.b.toArray();
    int i = arrayOfObject.length - 1;
    while (i >= 0)
    {
      if (((arrayOfObject[i] instanceof aycl)) && (((aycl)arrayOfObject[i]).a(paramMotionEvent, paramInt1, paramInt2))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  protected void aO_()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ayba localayba = (ayba)localIterator.next();
      if ((localayba instanceof aycm)) {
        ((aycm)localayba).aO_();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.b.size())
    {
      ((ayck)this.b.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aycj
 * JD-Core Version:    0.7.0.1
 */