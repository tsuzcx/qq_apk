import android.opengl.GLES20;

public class bblt
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public bblt(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.b = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.b);
    a();
  }
  
  public void a()
  {
    GLES20.glBindFramebuffer(36160, 0);
    bblu.a(0);
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0)
    {
      ykq.d("AvEditor.FrameBuffer", "invalid textureId " + paramInt);
      return;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = bblu.a(1)[0];
    }
    GLES20.glActiveTexture(33984);
    bblu.a(i);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexImage2D(3553, 0, 6408, this.c, this.d, 0, 6408, 5121, null);
    GLES20.glViewport(0, 0, this.c, this.d);
    GLES20.glBindFramebuffer(36160, this.b);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
    GLES20.glClear(16384);
    this.a = i;
  }
  
  public void b()
  {
    GLES20.glDeleteFramebuffers(1, new int[] { this.b }, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblt
 * JD-Core Version:    0.7.0.1
 */