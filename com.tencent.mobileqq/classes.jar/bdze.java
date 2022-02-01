import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdze
  extends bdzf
  implements bdxz<bdzf>, bdzg
{
  public List<bdxv> b = new ArrayList();
  
  public bdze(SpriteGLView paramSpriteGLView)
  {
    this.a = paramSpriteGLView;
  }
  
  public <N extends bdxv> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      bdzf localbdzf = (bdzf)this.b.get(i);
      if (paramString.equals(localbdzf.jdField_a_of_type_JavaLangString)) {
        return localbdzf;
      }
      if ((localbdzf instanceof bdze)) {
        return ((bdze)localbdzf).a(paramString);
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
      ((bdzf)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(bdzf parambdzf)
  {
    if (parambdzf.jdField_a_of_type_Bdxz == null)
    {
      this.b.add(parambdzf);
      parambdzf.jdField_a_of_type_Bdxz = this;
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
      if (((arrayOfObject[i] instanceof bdzg)) && (((bdzg)arrayOfObject[i]).a(paramMotionEvent, paramInt1, paramInt2))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  protected void aA_()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      bdxv localbdxv = (bdxv)localIterator.next();
      if ((localbdxv instanceof bdzh)) {
        ((bdzh)localbdxv).aA_();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.b.size())
    {
      ((bdzf)this.b.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdze
 * JD-Core Version:    0.7.0.1
 */