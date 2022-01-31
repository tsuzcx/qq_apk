import android.opengl.GLSurfaceView.Renderer;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class atuu
  implements GLSurfaceView.Renderer
{
  private attx jdField_a_of_type_Attx;
  private atuv jdField_a_of_type_Atuv;
  private atuv b;
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLRender", 2, "func copyFrame2Render begins, datas:" + paramArrayOfByte1);
    }
    if (this.b == null) {
      this.b = new atuv(this);
    }
    if (this.b.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, paramBoolean)) {}
    try
    {
      this.jdField_a_of_type_Atuv = null;
      this.jdField_a_of_type_Atuv = this.b;
      if (QLog.isColorLevel()) {
        QLog.d("GLRender", 2, "func copyFrame2Render ends, mCurData:" + this.jdField_a_of_type_Atuv);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 24
    //   10: iconst_2
    //   11: new 26	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   18: ldc 64
    //   20: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   37: ifnull +10 -> 47
    //   40: aload_0
    //   41: getfield 66	atuu:jdField_a_of_type_Attx	Lattx;
    //   44: ifnonnull +52 -> 96
    //   47: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +43 -> 93
    //   53: ldc 24
    //   55: iconst_2
    //   56: new 26	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   63: ldc 68
    //   65: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   72: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: ldc 70
    //   77: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 66	atuu:jdField_a_of_type_Attx	Lattx;
    //   84: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: getfield 66	atuu:jdField_a_of_type_Attx	Lattx;
    //   100: aload_0
    //   101: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   104: getfield 73	atuv:jdField_a_of_type_ArrayOfByte	[B
    //   107: aload_0
    //   108: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   111: getfield 75	atuv:jdField_b_of_type_ArrayOfByte	[B
    //   114: aload_0
    //   115: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   118: getfield 79	atuv:c	I
    //   121: aload_0
    //   122: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   125: getfield 81	atuv:d	I
    //   128: aload_0
    //   129: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   132: getfield 83	atuv:jdField_a_of_type_Int	I
    //   135: aload_0
    //   136: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   139: getfield 85	atuv:jdField_b_of_type_Int	I
    //   142: aload_0
    //   143: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   146: getfield 88	atuv:jdField_a_of_type_Float	F
    //   149: aload_0
    //   150: getfield 56	atuu:jdField_a_of_type_Atuv	Latuv;
    //   153: getfield 91	atuv:jdField_a_of_type_Boolean	Z
    //   156: invokevirtual 95	attx:a	([B[BIIIIFZ)V
    //   159: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq -69 -> 93
    //   165: ldc 24
    //   167: iconst_2
    //   168: ldc 97
    //   170: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: goto -80 -> 93
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 100	java/lang/Throwable:printStackTrace	()V
    //   186: goto -27 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	atuu
    //   0	189	1	paramGL10	GL10
    // Exception table:
    //   from	to	target	type
    //   2	33	176	finally
    //   33	47	176	finally
    //   47	93	176	finally
    //   96	159	176	finally
    //   159	173	176	finally
    //   182	186	176	finally
    //   96	159	181	java/lang/Throwable
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLRender", 2, "func onSurfaceCreated begins");
    }
    try
    {
      this.jdField_a_of_type_Attx = new attx();
      this.jdField_a_of_type_Atuv = null;
      paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      if (QLog.isColorLevel()) {
        QLog.d("GLRender", 2, "func onSurfaceCreated ends");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atuu
 * JD-Core Version:    0.7.0.1
 */