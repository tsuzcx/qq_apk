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

public class bhsc
{
  private bhrw jdField_a_of_type_Bhrw = new bhrw();
  private bhrx jdField_a_of_type_Bhrx = new bhrx();
  private bhse jdField_a_of_type_Bhse;
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private List<Frame> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private Bitmap a()
  {
    this.jdField_a_of_type_Bhrw.a(this.jdField_a_of_type_JavaUtilList);
    return RendererUtils.saveTexture(this.jdField_a_of_type_Bhrw.a());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_Bhrx.apply();
    this.jdField_a_of_type_Bhrw.apply();
  }
  
  public void a(int paramInt1, List<PointF> paramList, int paramInt2, int paramInt3)
  {
    paramList = this.jdField_a_of_type_Bhrx.a(paramInt1, paramList, paramInt2, paramInt3);
    paramList = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(paramList.getTextureId(), 64, 64);
    this.jdField_a_of_type_JavaUtilList.add(paramList);
  }
  
  public void a(bhse parambhse)
  {
    this.jdField_a_of_type_Bhse = parambhse;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      AppInterface localAppInterface = QQStoryContext.a();
      avzm localavzm = (avzm)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new bhsd(this, localAppInterface));
      localavzm.a(a());
      return;
    }
    this.jdField_a_of_type_Bhse.a(new bhso());
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
    this.jdField_a_of_type_Bhrx.clearGLSLSelf();
    this.jdField_a_of_type_Bhrw.clearGLSLSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhsc
 * JD-Core Version:    0.7.0.1
 */