import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class bisu
  extends BaseFilter
{
  public bisu()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\n  float ty = textureCoordinate.y * 0.5;\n  float ny = ty + 0.5;\n  vec2 newCoord1 = vec2(textureCoordinate.x,ty);\n  vec2 newCoord2 = vec2(textureCoordinate.x,ny);\n  vec3 color = texture2D(inputImageTexture,newCoord1).xyz;\n  float alpha = 1.0-texture2D(inputImageTexture,newCoord2).r;\n  float newAlpha = step(0.5,alpha);\n\n  gl_FragColor = vec4(color,newAlpha);\n}");
  }
  
  public void a(Frame paramFrame1, int paramInt1, int paramInt2, Frame paramFrame2)
  {
    RenderProcess(paramFrame1.getTextureId(), paramInt1, paramInt2, -1, 0.0D, paramFrame2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bisu
 * JD-Core Version:    0.7.0.1
 */