import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdyo
  extends bdyp
  implements bdxj<bdyp>, bdyq
{
  public List<bdxf> b = new ArrayList();
  
  public bdyo(SpriteGLView paramSpriteGLView)
  {
    this.a = paramSpriteGLView;
  }
  
  public <N extends bdxf> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      bdyp localbdyp = (bdyp)this.b.get(i);
      if (paramString.equals(localbdyp.jdField_a_of_type_JavaLangString)) {
        return localbdyp;
      }
      if ((localbdyp instanceof bdyo)) {
        return ((bdyo)localbdyp).a(paramString);
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
      ((bdyp)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(bdyp parambdyp)
  {
    if (parambdyp.jdField_a_of_type_Bdxj == null)
    {
      this.b.add(parambdyp);
      parambdyp.jdField_a_of_type_Bdxj = this;
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
      if (((arrayOfObject[i] instanceof bdyq)) && (((bdyq)arrayOfObject[i]).a(paramMotionEvent, paramInt1, paramInt2))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  protected void aK_()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      bdxf localbdxf = (bdxf)localIterator.next();
      if ((localbdxf instanceof bdyr)) {
        ((bdyr)localbdxf).aK_();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.b.size())
    {
      ((bdyp)this.b.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyo
 * JD-Core Version:    0.7.0.1
 */