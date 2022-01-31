import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.ArrayList;

public class anzh
{
  public int a;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  public String a;
  public ArrayList a;
  public int b = 0;
  
  public anzh(ShortVideoResourceManager paramShortVideoResourceManager, HttpNetReq paramHttpNetReq)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
    this.b = 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "HttpEngineTask[start]: " + this);
    }
    this.b = 1;
    ShortVideoResourceManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoShortVideoResourceManager).getNetEngine(0).a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzh
 * JD-Core Version:    0.7.0.1
 */