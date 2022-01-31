import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;

public class ascv
{
  private static final short[] jdField_a_of_type_ArrayOfShort = { 0, 1, 2, 2, 3, 0 };
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer;
  private HashMap<String, ByteBuffer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private int jdField_e_of_type_Int;
  private byte[] jdField_e_of_type_ArrayOfByte;
  private int jdField_f_of_type_Int;
  private byte[] jdField_f_of_type_ArrayOfByte;
  private int g;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k;
  private int l;
  private int m;
  private int n = -1;
  private int o = -1;
  private int p = -1;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  
  public ascv()
  {
    b();
    a();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = IntBuffer.allocate(1);
    GLES20.glGenTextures(1, (IntBuffer)localObject);
    int i1 = ((IntBuffer)localObject).get();
    GLES20.glBindTexture(3553, i1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    localObject = (ByteBuffer)this.jdField_a_of_type_JavaUtilHashMap.get(paramArrayOfByte.length + "");
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        localObject = ByteBuffer.allocateDirect(paramArrayOfByte.length);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramArrayOfByte.length + "", localObject);
        ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
        ((ByteBuffer)localObject).put(paramArrayOfByte);
        ((ByteBuffer)localObject).position(0);
        GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, (Buffer)localObject);
        return i1;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -2015;
      }
    }
  }
  
  private void a(float paramFloat)
  {
    float f1 = 3.14159F * paramFloat / 180.0F;
    paramFloat = (float)Math.sin(f1);
    f1 = (float)Math.cos(f1);
    float[] arrayOfFloat = new float[16];
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = paramFloat;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (-paramFloat);
    arrayOfFloat[5] = f1;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 1.0F;
    Object localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(arrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    GLES20.glUniformMatrix4fv(this.g, 1, false, (FloatBuffer)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = this.u / this.s * this.t / this.v)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceGLDisplayer", 2, "func updateRenderParam, [yCord]=" + f1);
      }
      float f2 = (this.q - this.s) / this.q / 2.0F;
      float f3 = (this.r - this.t) / this.r / 2.0F;
      Object localObject = new float[12];
      localObject[0] = 1.0F;
      localObject[1] = (-f1);
      localObject[2] = 0.0F;
      localObject[3] = 1.0F;
      localObject[4] = f1;
      localObject[5] = 0.0F;
      localObject[6] = -1.0F;
      localObject[7] = f1;
      localObject[8] = 0.0F;
      localObject[9] = -1.0F;
      localObject[10] = (-f1);
      localObject[11] = 0.0F;
      float[] arrayOfFloat = new float[8];
      arrayOfFloat[0] = (1.0F - f2);
      arrayOfFloat[1] = (1.0F - f3);
      arrayOfFloat[2] = (1.0F - f2);
      arrayOfFloat[3] = f3;
      arrayOfFloat[4] = f2;
      arrayOfFloat[5] = f3;
      arrayOfFloat[6] = f2;
      arrayOfFloat[7] = (1.0F - f3);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(localObject.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
      this.jdField_a_of_type_JavaNioFloatBuffer.put((float[])localObject);
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.jdField_b_of_type_JavaNioFloatBuffer = ((ByteBuffer)localObject).asFloatBuffer();
      this.jdField_b_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
      this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
      return;
    }
  }
  
  private void b()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfShort.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
    this.jdField_a_of_type_JavaNioShortBuffer.put(jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = bfna.a("attribute vec4 position;\nattribute mediump vec2 textureCoordinate;\nvarying mediump vec2 coordinate;\nuniform mat4 transformMatrix;\nvoid main()\n{\n   gl_Position = position * transformMatrix; \n   coordinate = textureCoordinate; \n}\n", "precision highp float;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform sampler2D SamplerY_Alpha;\nuniform sampler2D SamplerU_Alpha;\nuniform sampler2D SamplerV_Alpha;\nvarying highp vec2 coordinate;\nvoid main()\n{\n    highp vec3 yuv;\n    highp vec3 rgb;    \n    yuv.x = texture2D(SamplerY, coordinate).r;    \n    yuv.y = texture2D(SamplerU, coordinate).r-0.5;    \n    yuv.z = texture2D(SamplerV, coordinate).r-0.5 ;    \n    rgb = mat3(      1,       1,      1,\n               \t\t0, \t\t-.34414, 1.772,\n               \t\t1.402, \t-.71414, 0) * yuv;    \n    highp vec3 yuv_Alpha;\n    highp vec3 rgb_Alpha;    \n    yuv_Alpha.x = texture2D(SamplerY_Alpha, coordinate).r;    \n    yuv_Alpha.y = texture2D(SamplerU_Alpha, coordinate).r-0.5;    \n    yuv_Alpha.z = texture2D(SamplerV_Alpha, coordinate).r-0.5 ;    \n    rgb_Alpha = mat3(      1,       1,      1,\n               \t\t0, \t\t-.34414, 1.772,\n               \t\t1.402, \t-.71414, 0) * yuv_Alpha;    \n         if(rgb_Alpha[0]  <= 0.196 ){   \n               rgb_Alpha[0] = 0.0;}   \n         else if(rgb_Alpha[0]  >= 0.922){     \n               rgb_Alpha[0] = 1.0;}  \n    gl_FragColor = vec4(rgb.r * rgb_Alpha.r ,rgb.g * rgb_Alpha.r ,rgb.b * rgb_Alpha.r, rgb_Alpha.r) ;\n}\n");
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "position");
    this.jdField_c_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "textureCoordinate");
    this.jdField_d_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerY");
    this.jdField_e_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerU");
    this.jdField_f_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerV");
    this.k = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerY_Alpha");
    this.l = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerU_Alpha");
    this.m = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerV_Alpha");
    this.g = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "transformMatrix");
    GLES20.glEnableVertexAttribArray(this.jdField_b_of_type_Int);
    GLES20.glEnableVertexAttribArray(this.jdField_c_of_type_Int);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLDisplayer", 2, "func draw begins, _srcwidth:" + paramInt1 + ",_srcheight:" + paramInt2 + ",_dstWidth:" + paramInt3 + ",_dstHeight:" + paramInt4 + ",isFull:" + paramBoolean);
    }
    if ((paramInt1 > 700) || (paramInt2 > 900)) {
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceGLDisplayer", 2, "func draw ends, video size is too big. something must be wrong");
      }
    }
    label284:
    label308:
    label332:
    label354:
    label378:
    do
    {
      return;
      GLES20.glClear(16640);
      this.u = paramInt3;
      this.v = paramInt4;
      this.q = paramInt1;
      this.r = paramInt2;
      this.s = paramInt1;
      this.t = paramInt2;
      if (this.jdField_a_of_type_Float == -1.0F)
      {
        this.jdField_a_of_type_Float = paramFloat;
        this.jdField_a_of_type_Boolean = paramBoolean;
        a(this.jdField_a_of_type_Boolean);
        a(this.jdField_a_of_type_Float);
      }
      if (this.jdField_a_of_type_Float != paramFloat)
      {
        this.jdField_a_of_type_Float = paramFloat;
        a(this.jdField_a_of_type_Float);
      }
      if (this.jdField_a_of_type_Boolean != paramBoolean)
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        a(this.jdField_a_of_type_Boolean);
      }
      if ((this.q != this.s) || (this.r != this.t)) {
        a(this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ArrayOfByte == null)
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[this.q * this.r];
        if (this.jdField_b_of_type_ArrayOfByte != null) {
          break label1144;
        }
        this.jdField_b_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
        if (this.jdField_c_of_type_ArrayOfByte != null) {
          break label1183;
        }
        this.jdField_c_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
        if (this.jdField_d_of_type_ArrayOfByte != null) {
          break label1222;
        }
        this.jdField_d_of_type_ArrayOfByte = new byte[this.q * this.r];
        if (this.jdField_e_of_type_ArrayOfByte != null) {
          break label1257;
        }
        this.jdField_e_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
        if (this.jdField_f_of_type_ArrayOfByte != null) {
          break label1296;
        }
        this.jdField_f_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
      }
      for (;;)
      {
        try
        {
          System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.q * this.r);
          System.arraycopy(paramArrayOfByte1, this.q * this.r, this.jdField_b_of_type_ArrayOfByte, 0, this.q * this.r / 4);
          System.arraycopy(paramArrayOfByte1, this.q * this.r * 5 / 4, this.jdField_c_of_type_ArrayOfByte, 0, this.q * this.r / 4);
          System.arraycopy(paramArrayOfByte2, 0, this.jdField_d_of_type_ArrayOfByte, 0, this.q * this.r);
          System.arraycopy(paramArrayOfByte2, this.q * this.r, this.jdField_e_of_type_ArrayOfByte, 0, this.q * this.r / 4);
          System.arraycopy(paramArrayOfByte2, this.q * this.r * 5 / 4, this.jdField_f_of_type_ArrayOfByte, 0, this.q * this.r / 4);
          if (this.h != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.h }, 0);
          }
          if (this.i != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.i }, 0);
          }
          if (this.j != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.j }, 0);
          }
          if (this.n != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.n }, 0);
          }
          if (this.o != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.o }, 0);
          }
          if (this.p != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.p }, 0);
          }
          this.h = a(this.jdField_a_of_type_ArrayOfByte, this.q, this.r);
          this.i = a(this.jdField_b_of_type_ArrayOfByte, this.q / 2, this.r / 2);
          this.j = a(this.jdField_c_of_type_ArrayOfByte, this.q / 2, this.r / 2);
          this.n = a(this.jdField_d_of_type_ArrayOfByte, this.q, this.r);
          this.o = a(this.jdField_e_of_type_ArrayOfByte, this.q / 2, this.r / 2);
          this.p = a(this.jdField_f_of_type_ArrayOfByte, this.q / 2, this.r / 2);
          if ((this.h == -2015) || (this.i == -2015) || (this.j == -2015) || (this.n == -2015) || (this.o == -2015) || (this.p == -2015)) {
            break;
          }
          GLES20.glVertexAttribPointer(this.jdField_b_of_type_Int, 3, 5126, false, 12, this.jdField_a_of_type_JavaNioFloatBuffer);
          GLES20.glVertexAttribPointer(this.jdField_c_of_type_Int, 2, 5126, false, 8, this.jdField_b_of_type_JavaNioFloatBuffer);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, this.n);
          GLES20.glUniform1i(this.k, 0);
          GLES20.glActiveTexture(33985);
          GLES20.glBindTexture(3553, this.o);
          GLES20.glUniform1i(this.l, 1);
          GLES20.glActiveTexture(33986);
          GLES20.glBindTexture(3553, this.p);
          GLES20.glUniform1i(this.m, 2);
          GLES20.glActiveTexture(33987);
          GLES20.glBindTexture(3553, this.h);
          GLES20.glUniform1i(this.jdField_d_of_type_Int, 3);
          GLES20.glActiveTexture(33988);
          GLES20.glBindTexture(3553, this.i);
          GLES20.glUniform1i(this.jdField_e_of_type_Int, 4);
          GLES20.glActiveTexture(33989);
          GLES20.glBindTexture(3553, this.j);
          GLES20.glUniform1i(this.jdField_f_of_type_Int, 5);
          GLES20.glDrawElements(4, jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MagicFaceGLDisplayer", 2, "func draw ends");
          return;
        }
        catch (OutOfMemoryError paramArrayOfByte1) {}
        if (this.jdField_a_of_type_ArrayOfByte.length == this.q * this.r) {
          break label284;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[this.q * this.r];
        break label284;
        if (this.jdField_b_of_type_ArrayOfByte.length == this.q * this.r / 4) {
          break label308;
        }
        this.jdField_b_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
        break label308;
        if (this.jdField_c_of_type_ArrayOfByte.length == this.q * this.r / 4) {
          break label332;
        }
        this.jdField_c_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
        break label332;
        if (this.jdField_d_of_type_ArrayOfByte.length == this.q * this.r) {
          break label354;
        }
        this.jdField_d_of_type_ArrayOfByte = new byte[this.q * this.r];
        break label354;
        if (this.jdField_e_of_type_ArrayOfByte.length == this.q * this.r / 4) {
          break label378;
        }
        this.jdField_e_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
        break label378;
        if (this.jdField_f_of_type_ArrayOfByte.length != this.q * this.r / 4) {
          this.jdField_f_of_type_ArrayOfByte = new byte[this.q * this.r / 4];
        }
      }
    } while (!QLog.isColorLevel());
    label1144:
    QLog.w("MagicFaceGLDisplayer", 2, "ooooom happens.");
    label1183:
    label1222:
    label1257:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ascv
 * JD-Core Version:    0.7.0.1
 */