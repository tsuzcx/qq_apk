import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class axby
  extends axci
{
  private long jdField_a_of_type_Long;
  public axbz a;
  private LinkedList<axcl> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private axcl[] jdField_a_of_type_ArrayOfAxcl;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  public int g;
  private int h = 10;
  private int i = -1;
  
  public axby(SpriteGLView paramSpriteGLView, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ArrayOfAxcl = new axcl[paramArrayOfString.length];
    e(10);
  }
  
  private axcl a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(this.jdField_a_of_type_ArrayOfAxcl[paramInt]);
        axcl localaxcl = this.jdField_a_of_type_ArrayOfAxcl[paramInt];
        return localaxcl;
      }
      return null;
    }
    finally {}
  }
  
  private void a(int paramInt, axcl paramaxcl)
  {
    if ((this.jdField_a_of_type_ArrayOfAxcl != null) && (this.jdField_a_of_type_ArrayOfAxcl.length > paramInt)) {
      this.jdField_a_of_type_ArrayOfAxcl[paramInt] = paramaxcl;
    }
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        int j = 0;
        while (j < this.jdField_a_of_type_JavaUtilLinkedList.size())
        {
          ((axcl)this.jdField_a_of_type_JavaUtilLinkedList.get(j)).c();
          j += 1;
        }
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
      }
      return;
    }
    finally {}
  }
  
  private void f(int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_ArrayOfAxcl != null) && (this.jdField_a_of_type_ArrayOfAxcl.length > paramInt) && (this.jdField_a_of_type_ArrayOfAxcl[paramInt] != null))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(this.jdField_a_of_type_ArrayOfAxcl[paramInt]);
        this.jdField_a_of_type_ArrayOfAxcl[paramInt].a();
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfAxcl != null)
    {
      int j = 0;
      while (j < this.jdField_a_of_type_ArrayOfAxcl.length)
      {
        if (this.jdField_a_of_type_ArrayOfAxcl[j] != null)
        {
          this.jdField_a_of_type_ArrayOfAxcl[j].c();
          this.jdField_a_of_type_ArrayOfAxcl[j] = null;
        }
        j += 1;
      }
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.clear();
      }
      this.jdField_a_of_type_JavaUtilLinkedList = null;
      this.jdField_a_of_type_ArrayOfAxcl = null;
      this.e = true;
      this.jdField_a_of_type_Axbz = null;
      super.a();
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    int j;
    if ((this.c) && (this.jdField_a_of_type_ArrayOfAxcl != null))
    {
      j = (int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / (1000.0F / this.h));
      if (j <= this.i) {
        break label370;
      }
      if (j <= this.i + 1) {
        break label220;
      }
      this.i += 1;
      if (this.i >= this.jdField_a_of_type_ArrayOfAxcl.length) {
        break label268;
      }
      if ((this.jdField_a_of_type_ArrayOfAxcl[this.i] == null) || (!this.jdField_a_of_type_ArrayOfAxcl[this.i].a)) {
        break label229;
      }
      if (this.jdField_a_of_type_Axcl != null) {
        this.jdField_a_of_type_Axcl.c();
      }
      this.jdField_a_of_type_Axcl = a(this.i);
      if (QLog.isColorLevel()) {
        QLog.d("FrameSprite", 2, "FrameSprite: mTexture = " + this.jdField_a_of_type_Axcl);
      }
      g();
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      if (QLog.isColorLevel()) {
        QLog.d("FrameSprite", 2, "FrameSprite: draw1:" + this.i);
      }
    }
    label220:
    label229:
    label370:
    do
    {
      for (;;)
      {
        return;
        this.i = j;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: mTexture = null:" + this.i);
        }
        e();
        return;
        if (this.d)
        {
          super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
          if (QLog.isColorLevel()) {
            QLog.d("FrameSprite", 2, "FrameSprite: draw3:" + this.i);
          }
        }
        while (this.jdField_a_of_type_Axbz != null)
        {
          this.jdField_a_of_type_Axbz.a();
          this.jdField_a_of_type_Axbz = null;
          return;
          this.c = false;
          if (this.jdField_a_of_type_Axcl != null) {
            this.jdField_a_of_type_Axcl.c();
          }
        }
      }
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    } while (!QLog.isColorLevel());
    label268:
    QLog.d("FrameSprite", 2, "FrameSprite: draw2:" + this.i);
  }
  
  public void a(Context paramContext, SpriteGLView paramSpriteGLView)
  {
    ThreadManager.post(new FrameSprite.1(this, paramContext, paramSpriteGLView), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void aQ_()
  {
    this.c = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.c)
    {
      int j = (int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / (1000.0F / this.h));
      if (j >= this.jdField_a_of_type_ArrayOfAxcl.length) {
        break label67;
      }
      this.jdField_a_of_type_Axcl = this.jdField_a_of_type_ArrayOfAxcl[j];
    }
    for (;;)
    {
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      return;
      label67:
      if (this.b)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Axcl = this.jdField_a_of_type_ArrayOfAxcl[0];
      }
      else if (this.d)
      {
        this.jdField_a_of_type_Axcl = this.jdField_a_of_type_ArrayOfAxcl[(this.jdField_a_of_type_ArrayOfAxcl.length - 1)];
      }
      else
      {
        this.jdField_a_of_type_Axcl = null;
        if (this.jdField_a_of_type_Axbz != null)
        {
          this.jdField_a_of_type_Axbz.a();
          this.jdField_a_of_type_Axbz = null;
        }
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null) {
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    }
    while (this.jdField_a_of_type_ArrayOfAxcl == null) {
      return;
    }
    b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
  }
  
  public void e(int paramInt)
  {
    this.h = paramInt;
    this.g = ((int)(this.h * 0.8D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axby
 * JD-Core Version:    0.7.0.1
 */