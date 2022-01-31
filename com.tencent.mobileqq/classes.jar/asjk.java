import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.util.Log;
import java.nio.ByteBuffer;

public class asjk
{
  @TargetApi(18)
  public static int a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    GLES31.glGenTextures(1, arrayOfInt, 0);
    GLES31.glBindTexture(3553, arrayOfInt[0]);
    GLES31.glTexStorage2D(3553, 1, 32856, paramInt1, paramInt2);
    GLES31.glTexParameteri(3553, 10242, 33071);
    GLES31.glTexParameteri(3553, 10243, 33071);
    GLES31.glTexParameteri(3553, 10241, 9728);
    GLES31.glTexParameteri(3553, 10240, 9728);
    a("glTexParameter");
    return arrayOfInt[0];
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = a(paramInt1, paramInt2, paramInt3);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(localByteBuffer);
    return localBitmap;
  }
  
  private static ByteBuffer a(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = new int[1];
    GLES20.glGetIntegerv(36006, arrayOfInt2, 0);
    GLES20.glGenFramebuffers(1, arrayOfInt1, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    GLES20.glFinish();
    GLES20.glBindFramebuffer(36160, arrayOfInt2[0]);
    GLES20.glDeleteFramebuffers(1, arrayOfInt1, 0);
    return localByteBuffer;
  }
  
  public static void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      Log.e("GlUtil", paramString + ": glError 0x" + Integer.toHexString(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asjk
 * JD-Core Version:    0.7.0.1
 */