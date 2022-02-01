import android.opengl.GLES20;

public class aprd
  extends aprj
{
  public int a;
  public int b;
  
  public aprd(int paramInt)
  {
    super(paramInt);
    this.e = "uniform float uA;\nuniform float uD;\n";
    this.j = "    if(abs(gl_FragColor[0]-u_screenColor[0]) < uD && abs(gl_FragColor[1]-u_screenColor[1]) < uD  && abs(gl_FragColor[2]-u_screenColor[2]) < uD ){\n        gl_FragColor[3] = uA;\n        if(uA < 0.01){\n            gl_FragColor[0] = 0.0;\n            gl_FragColor[1] = 0.0;\n            gl_FragColor[2] = 0.0;\n        }\n    }\n";
  }
  
  protected void a()
  {
    this.a = GLES20.glGetUniformLocation(this.d, "uA");
    aprn.a("glGetAttribLocation uA");
    this.b = GLES20.glGetUniformLocation(this.d, "uD");
    aprn.a("glGetAttribLocation uD");
  }
  
  protected void a(aprm paramaprm)
  {
    if (paramaprm == null) {
      return;
    }
    GLES20.glUniform1f(this.a, paramaprm.d);
    GLES20.glUniform1f(this.b, paramaprm.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprd
 * JD-Core Version:    0.7.0.1
 */