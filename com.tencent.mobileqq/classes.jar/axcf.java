import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axcf
  extends axcg
  implements axba<axcg>, axch
{
  public List<axaw> b = new ArrayList();
  
  public axcf(SpriteGLView paramSpriteGLView)
  {
    this.a = paramSpriteGLView;
  }
  
  public <N extends axaw> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      axcg localaxcg = (axcg)this.b.get(i);
      if (paramString.equals(localaxcg.jdField_a_of_type_JavaLangString)) {
        return localaxcg;
      }
      if ((localaxcg instanceof axcf)) {
        return ((axcf)localaxcg).a(paramString);
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
      ((axcg)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(axcg paramaxcg)
  {
    if (paramaxcg.jdField_a_of_type_Axba == null)
    {
      this.b.add(paramaxcg);
      paramaxcg.jdField_a_of_type_Axba = this;
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
      if (((arrayOfObject[i] instanceof axch)) && (((axch)arrayOfObject[i]).a(paramMotionEvent, paramInt1, paramInt2))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  protected void aR_()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      axaw localaxaw = (axaw)localIterator.next();
      if ((localaxaw instanceof axci)) {
        ((axci)localaxaw).aR_();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.b.size())
    {
      ((axcg)this.b.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axcf
 * JD-Core Version:    0.7.0.1
 */