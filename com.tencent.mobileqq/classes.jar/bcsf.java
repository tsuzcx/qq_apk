import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bcsf
  extends bcsg
  implements bcra<bcsg>, bcsh
{
  public List<bcqw> b = new ArrayList();
  
  public bcsf(SpriteGLView paramSpriteGLView)
  {
    this.a = paramSpriteGLView;
  }
  
  public <N extends bcqw> N a(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      bcsg localbcsg = (bcsg)this.b.get(i);
      if (paramString.equals(localbcsg.jdField_a_of_type_JavaLangString)) {
        return localbcsg;
      }
      if ((localbcsg instanceof bcsf)) {
        return ((bcsf)localbcsg).a(paramString);
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
      ((bcsg)this.b.get(i)).a();
      i += 1;
    }
    this.b.clear();
  }
  
  public void a(bcsg parambcsg)
  {
    if (parambcsg.jdField_a_of_type_Bcra == null)
    {
      this.b.add(parambcsg);
      parambcsg.jdField_a_of_type_Bcra = this;
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
      if (((arrayOfObject[i] instanceof bcsh)) && (((bcsh)arrayOfObject[i]).a(paramMotionEvent, paramInt1, paramInt2))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  protected void ay_()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      bcqw localbcqw = (bcqw)localIterator.next();
      if ((localbcqw instanceof bcsi)) {
        ((bcsi)localbcqw).ay_();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    int i = 0;
    while (i < this.b.size())
    {
      ((bcsg)this.b.get(i)).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsf
 * JD-Core Version:    0.7.0.1
 */