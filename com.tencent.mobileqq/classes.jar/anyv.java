import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class anyv
  implements INetEngine.INetEngineListener
{
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public anyv(QIMPtvTemplateManager paramQIMPtvTemplateManager, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (PtvTemplateManager.PtvTemplateInfo)paramNetReq.a();
    if ((this.jdField_a_of_type_JavaLangString.equals(paramNetReq.dgStageName)) || (this.jdField_a_of_type_JavaLangString.equals(paramNetReq.dgModelName))) {
      paramNetReq = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.b.iterator();
    }
    while (paramNetReq.hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramNetReq.next();
      QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, localPtvTemplateInfo, this.jdField_a_of_type_JavaLangString, paramLong1, paramLong2);
      continue;
      QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, paramNetReq, this.jdField_a_of_type_JavaLangString, paramLong1, paramLong2);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("DGHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramNetResp.c), this.jdField_a_of_type_JavaLangString, this.b }));
    }
    paramNetResp = (PtvTemplateManager.PtvTemplateInfo)paramNetResp.a.a();
    if (QIMPtvTemplateManager.a(this.jdField_a_of_type_JavaLangString, this.c, false)) {}
    try
    {
      ZipUtils.a(new File(QIMPtvTemplateManager.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaLangString), QIMPtvTemplateManager.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaLangString.equals(paramNetResp.dgStageName)) || (this.jdField_a_of_type_JavaLangString.equals(paramNetResp.dgModelName)))
      {
        paramNetResp = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.b.iterator();
        while (paramNetResp.hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramNetResp.next();
          QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, localPtvTemplateInfo, this.jdField_a_of_type_JavaLangString);
          if (QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, localPtvTemplateInfo)) {
            paramNetResp.remove();
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
      QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, paramNetResp, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyv
 * JD-Core Version:    0.7.0.1
 */