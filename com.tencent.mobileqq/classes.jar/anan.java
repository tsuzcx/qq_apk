import android.opengl.GLES20;

public class anan
  extends anat
{
  public int a;
  public int b;
  
  public anan(int paramInt)
  {
    super(paramInt);
    this.e = "uniform float uA;\nuniform float uD;\n";
    this.j = "    if(abs(gl_FragColor[0]-u_screenColor[0]) < uD && abs(gl_FragColor[1]-u_screenColor[1]) < uD  && abs(gl_FragColor[2]-u_screenColor[2]) < uD ){\n        gl_FragColor[3] = uA;\n        if(uA < 0.01){\n            gl_FragColor[0] = 0.0;\n            gl_FragColor[1] = 0.0;\n            gl_FragColor[2] = 0.0;\n        }\n    }\n";
  }
  
  protected void a()
  {
    this.a = GLES20.glGetUniformLocation(this.d, "uA");
    anax.a("glGetAttribLocation uA");
    this.b = GLES20.glGetUniformLocation(this.d, "uD");
    anax.a("glGetAttribLocation uD");
  }
  
  protected void a(anaw paramanaw)
  {
    if (paramanaw == null) {
      return;
    }
    GLES20.glUniform1f(this.a, paramanaw.d);
    GLES20.glUniform1f(this.b, paramanaw.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anan
 * JD-Core Version:    0.7.0.1
 */