import android.opengl.GLES20;

public class apdn
  extends apdt
{
  public int a;
  public int b;
  
  public apdn(int paramInt)
  {
    super(paramInt);
    this.e = "uniform float uA;\nuniform float uD;\n";
    this.j = "    if(abs(gl_FragColor[0]-u_screenColor[0]) < uD && abs(gl_FragColor[1]-u_screenColor[1]) < uD  && abs(gl_FragColor[2]-u_screenColor[2]) < uD ){\n        gl_FragColor[3] = uA;\n        if(uA < 0.01){\n            gl_FragColor[0] = 0.0;\n            gl_FragColor[1] = 0.0;\n            gl_FragColor[2] = 0.0;\n        }\n    }\n";
  }
  
  protected void a()
  {
    this.a = GLES20.glGetUniformLocation(this.d, "uA");
    apdx.a("glGetAttribLocation uA");
    this.b = GLES20.glGetUniformLocation(this.d, "uD");
    apdx.a("glGetAttribLocation uD");
  }
  
  protected void a(apdw paramapdw)
  {
    if (paramapdw == null) {
      return;
    }
    GLES20.glUniform1f(this.a, paramapdw.d);
    GLES20.glUniform1f(this.b, paramapdw.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdn
 * JD-Core Version:    0.7.0.1
 */