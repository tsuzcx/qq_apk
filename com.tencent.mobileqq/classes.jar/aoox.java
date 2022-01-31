import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import java.io.IOException;
import java.util.List;

class aoox
  implements INetEngine.INetEngineListener
{
  aoox(aoow paramaoow) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + paramNetResp.c);
    }
    this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    if (this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      ZipUtils.a(new File(QIMPtvTemplateManager.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name), QIMPtvTemplateManager.jdField_a_of_type_JavaLangString);
      paramNetResp = this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
      if (paramNetResp.size() > 0)
      {
        i = ((Integer)paramNetResp.get(0)).intValue();
        localPtvTemplateInfo.type = i;
        localPtvTemplateInfo = this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
        i = j;
        if (paramNetResp.size() > 1) {
          i = ((Integer)paramNetResp.get(1)).intValue();
        }
        localPtvTemplateInfo.color = i;
        return;
      }
    }
    catch (IOException paramNetResp)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          paramNetResp.printStackTrace();
          continue;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoox
 * JD-Core Version:    0.7.0.1
 */