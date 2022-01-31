import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.io.File;
import java.io.IOException;

class aooq
  implements INetEngine.INetEngineListener
{
  aooq(aoop paramaoop) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "onResp url: " + this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + paramNetResp.c);
    }
    this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    if (this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      ZipUtils.a(new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name), PtvTemplateManager.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (IOException paramNetResp)
    {
      while (!QLog.isColorLevel()) {}
      paramNetResp.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aooq
 * JD-Core Version:    0.7.0.1
 */