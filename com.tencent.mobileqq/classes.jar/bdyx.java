import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class bdyx
  extends bdzh
{
  private long jdField_a_of_type_Long;
  public bdyy a;
  private LinkedList<bdzk> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private bdzk[] jdField_a_of_type_ArrayOfBdzk;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  public int g;
  private int h = 10;
  private int i = -1;
  
  public bdyx(SpriteGLView paramSpriteGLView, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ArrayOfBdzk = new bdzk[paramArrayOfString.length];
    e(10);
  }
  
  private bdzk a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(this.jdField_a_of_type_ArrayOfBdzk[paramInt]);
        bdzk localbdzk = this.jdField_a_of_type_ArrayOfBdzk[paramInt];
        return localbdzk;
      }
      return null;
    }
    finally {}
  }
  
  private void a(int paramInt, bdzk parambdzk)
  {
    if ((this.jdField_a_of_type_ArrayOfBdzk != null) && (this.jdField_a_of_type_ArrayOfBdzk.length > paramInt)) {
      this.jdField_a_of_type_ArrayOfBdzk[paramInt] = parambdzk;
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
          ((bdzk)this.jdField_a_of_type_JavaUtilLinkedList.get(j)).c();
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
      if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_ArrayOfBdzk != null) && (this.jdField_a_of_type_ArrayOfBdzk.length > paramInt) && (this.jdField_a_of_type_ArrayOfBdzk[paramInt] != null))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(this.jdField_a_of_type_ArrayOfBdzk[paramInt]);
        this.jdField_a_of_type_ArrayOfBdzk[paramInt].a();
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfBdzk != null)
    {
      int j = 0;
      while (j < this.jdField_a_of_type_ArrayOfBdzk.length)
      {
        if (this.jdField_a_of_type_ArrayOfBdzk[j] != null)
        {
          this.jdField_a_of_type_ArrayOfBdzk[j].c();
          this.jdField_a_of_type_ArrayOfBdzk[j] = null;
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
      this.jdField_a_of_type_ArrayOfBdzk = null;
      this.e = true;
      this.jdField_a_of_type_Bdyy = null;
      super.a();
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    int j;
    if ((this.c) && (this.jdField_a_of_type_ArrayOfBdzk != null))
    {
      j = (int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / (1000.0F / this.h));
      if (j <= this.i) {
        break label370;
      }
      if (j <= this.i + 1) {
        break label220;
      }
      this.i += 1;
      if (this.i >= this.jdField_a_of_type_ArrayOfBdzk.length) {
        break label268;
      }
      if ((this.jdField_a_of_type_ArrayOfBdzk[this.i] == null) || (!this.jdField_a_of_type_ArrayOfBdzk[this.i].a)) {
        break label229;
      }
      if (this.jdField_a_of_type_Bdzk != null) {
        this.jdField_a_of_type_Bdzk.c();
      }
      this.jdField_a_of_type_Bdzk = a(this.i);
      if (QLog.isColorLevel()) {
        QLog.d("FrameSprite", 2, "FrameSprite: mTexture = " + this.jdField_a_of_type_Bdzk);
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
        while (this.jdField_a_of_type_Bdyy != null)
        {
          this.jdField_a_of_type_Bdyy.a();
          this.jdField_a_of_type_Bdyy = null;
          return;
          this.c = false;
          if (this.jdField_a_of_type_Bdzk != null) {
            this.jdField_a_of_type_Bdzk.c();
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
  
  public void az_()
  {
    this.c = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.c)
    {
      int j = (int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / (1000.0F / this.h));
      if (j >= this.jdField_a_of_type_ArrayOfBdzk.length) {
        break label67;
      }
      this.jdField_a_of_type_Bdzk = this.jdField_a_of_type_ArrayOfBdzk[j];
    }
    for (;;)
    {
      super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
      return;
      label67:
      if (this.b)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Bdzk = this.jdField_a_of_type_ArrayOfBdzk[0];
      }
      else if (this.d)
      {
        this.jdField_a_of_type_Bdzk = this.jdField_a_of_type_ArrayOfBdzk[(this.jdField_a_of_type_ArrayOfBdzk.length - 1)];
      }
      else
      {
        this.jdField_a_of_type_Bdzk = null;
        if (this.jdField_a_of_type_Bdyy != null)
        {
          this.jdField_a_of_type_Bdyy.a();
          this.jdField_a_of_type_Bdyy = null;
        }
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null) {
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    }
    while (this.jdField_a_of_type_ArrayOfBdzk == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyx
 * JD-Core Version:    0.7.0.1
 */