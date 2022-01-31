import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class baag
  extends baah
  implements azzb<baah>, baai
{
  public List<azyx> b = new ArrayList();
  
  public baag(SpriteGLView paramSpriteGLView)
  {
    this.a = paramSpriteGLView;
  }
  
  public <N extends azyx> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      baah localbaah = (baah)this.b.get(i);
      if (paramString.equals(localbaah.jdField_a_of_type_JavaLangString)) {
        return localbaah;
      }
      if ((localbaah instanceof baag)) {
        return ((baag)localbaah).a(paramString);
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
      ((baah)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(baah parambaah)
  {
    if (parambaah.jdField_a_of_type_Azzb == null)
    {
      this.b.add(parambaah);
      parambaah.jdField_a_of_type_Azzb = this;
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
      if (((arrayOfObject[i] instanceof baai)) && (((baai)arrayOfObject[i]).a(paramMotionEvent, paramInt1, paramInt2))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  protected void aP_()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      azyx localazyx = (azyx)localIterator.next();
      if ((localazyx instanceof baaj)) {
        ((baaj)localazyx).aP_();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.b.size())
    {
      ((baah)this.b.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baag
 * JD-Core Version:    0.7.0.1
 */