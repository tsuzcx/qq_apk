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

public class bisb
{
  private bisd jdField_a_of_type_Bisd;
  private bisv jdField_a_of_type_Bisv = new bisv();
  private bisw jdField_a_of_type_Bisw = new bisw();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private List<Frame> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private Bitmap a()
  {
    this.jdField_a_of_type_Bisv.a(this.jdField_a_of_type_JavaUtilList);
    return RendererUtils.saveTexture(this.jdField_a_of_type_Bisv.a());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_Bisw.apply();
    this.jdField_a_of_type_Bisv.apply();
  }
  
  public void a(int paramInt1, List<PointF> paramList, int paramInt2, int paramInt3)
  {
    paramList = this.jdField_a_of_type_Bisw.a(paramInt1, paramList, paramInt2, paramInt3);
    paramList = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramList.getTextureId(), 64, 64);
    this.jdField_a_of_type_JavaUtilList.add(paramList);
  }
  
  public void a(bisd parambisd)
  {
    this.jdField_a_of_type_Bisd = parambisd;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      AppInterface localAppInterface = QQStoryContext.a();
      biqw localbiqw = (biqw)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new bisc(this, localAppInterface));
      localbiqw.a(a());
      return;
    }
    this.jdField_a_of_type_Bisd.a(new bist());
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
    this.jdField_a_of_type_Bisw.clearGLSLSelf();
    this.jdField_a_of_type_Bisv.clearGLSLSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bisb
 * JD-Core Version:    0.7.0.1
 */