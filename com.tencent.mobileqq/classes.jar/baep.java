import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class baep
  extends baeq
  implements badk<baeq>, baer
{
  public List<badg> b = new ArrayList();
  
  public baep(SpriteGLView paramSpriteGLView)
  {
    this.a = paramSpriteGLView;
  }
  
  public <N extends badg> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      baeq localbaeq = (baeq)this.b.get(i);
      if (paramString.equals(localbaeq.jdField_a_of_type_JavaLangString)) {
        return localbaeq;
      }
      if ((localbaeq instanceof baep)) {
        return ((baep)localbaeq).a(paramString);
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
      ((baeq)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(baeq parambaeq)
  {
    if (parambaeq.jdField_a_of_type_Badk == null)
    {
      this.b.add(parambaeq);
      parambaeq.jdField_a_of_type_Badk = this;
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
      if (((arrayOfObject[i] instanceof baer)) && (((baer)arrayOfObject[i]).a(paramMotionEvent, paramInt1, paramInt2))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  protected void aM_()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      badg localbadg = (badg)localIterator.next();
      if ((localbadg instanceof baes)) {
        ((baes)localbadg).aM_();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.b.size())
    {
      ((baeq)this.b.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baep
 * JD-Core Version:    0.7.0.1
 */