import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.BaseFilter;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bnlk
{
  private bnlm jdField_a_of_type_Bnlm;
  private bnmg jdField_a_of_type_Bnmg = new bnmg();
  private bnmh jdField_a_of_type_Bnmh = new bnmh();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private List<Frame> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private Bitmap a()
  {
    this.jdField_a_of_type_Bnmg.a(this.jdField_a_of_type_JavaUtilList);
    return RendererUtils.saveTexture(this.jdField_a_of_type_Bnmg.a());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_Bnmh.apply();
    this.jdField_a_of_type_Bnmg.apply();
  }
  
  public void a(int paramInt1, List<PointF> paramList, int paramInt2, int paramInt3)
  {
    paramList = this.jdField_a_of_type_Bnmh.a(paramInt1, paramList, paramInt2, paramInt3);
    paramList = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramList.getTextureId(), 64, 64);
    this.jdField_a_of_type_JavaUtilList.add(paramList);
  }
  
  public void a(bnlm parambnlm)
  {
    this.jdField_a_of_type_Bnlm = parambnlm;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      AppInterface localAppInterface = QQStoryContext.a();
      bnjs localbnjs = (bnjs)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new bnll(this, localAppInterface));
      localbnjs.a(a());
      return;
    }
    this.jdField_a_of_type_Bnlm.a(new bnme());
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).unlock();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).clear();
    }
    this.jdField_a_of_type_ComTencentFilterBaseFilter.clearGLSLSelf();
    this.jdField_a_of_type_Bnmh.clearGLSLSelf();
    this.jdField_a_of_type_Bnmg.clearGLSLSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlk
 * JD-Core Version:    0.7.0.1
 */