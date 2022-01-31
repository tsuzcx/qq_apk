import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import java.util.ArrayList;
import java.util.List;

public class blbv
  extends BaseFilter
{
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private List<Frame> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public blbv()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public Frame a()
  {
    float f1 = 2.0F / this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      float f2 = -1.0F + i * f1;
      float f3 = f2 + f1;
      setPositions(new float[] { f2, -1.0F, f2, 1.0F, f3, 1.0F, f3, -1.0F });
      Frame localFrame = (Frame)this.jdField_a_of_type_JavaUtilList.get(i);
      RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, this.jdField_a_of_type_JavaUtilList.size() * 64, 64, -1, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      i += 1;
    }
    return this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  }
  
  public void a(List<Frame> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbv
 * JD-Core Version:    0.7.0.1
 */