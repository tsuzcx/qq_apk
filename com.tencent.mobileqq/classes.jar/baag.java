import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class baag
  implements INetEngine.INetEngineListener
{
  baae jdField_a_of_type_Baae;
  baaf jdField_a_of_type_Baaf;
  
  baag(azzx paramazzx, baaf parambaaf, baae parambaae)
  {
    this.jdField_a_of_type_Baaf = parambaaf;
    this.jdField_a_of_type_Baae = parambaae;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_Baae.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Baae.c }));
    }
    paramNetResp = (baae)paramNetResp.mReq.getUserData();
    if (paramNetResp == null) {}
    label269:
    label286:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramNetResp.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Baae.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (azzx.b(paramNetResp.jdField_a_of_type_JavaLangString, paramNetResp.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            npo.a(new File(azzx.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Baae.jdField_a_of_type_JavaLangString), azzx.jdField_a_of_type_JavaLangString);
            if (paramNetResp.jdField_b_of_type_Boolean) {
              break label269;
            }
            paramNetResp = (baab)this.jdField_a_of_type_Azzx.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Baaf.a));
            if (paramNetResp != null)
            {
              paramNetResp = paramNetResp.b.iterator();
              while (paramNetResp.hasNext())
              {
                baaf localbaaf = (baaf)paramNetResp.next();
                if (azzx.a(this.jdField_a_of_type_Azzx, localbaaf, this.jdField_a_of_type_Baae)) {
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
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Baaf.a + " mItem.mName=" + this.jdField_a_of_type_Baae.jdField_a_of_type_JavaLangString);
      return;
      azzx.a(this.jdField_a_of_type_Azzx, this.jdField_a_of_type_Baaf, this.jdField_a_of_type_Baae);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Baae.jdField_a_of_type_JavaLangString + " callback=" + paramNetResp.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (baae)paramNetReq.getUserData();
    if (paramNetReq == null) {}
    label134:
    label187:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramNetReq.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Baae.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (baab)this.jdField_a_of_type_Azzx.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Baaf.a));
          if (localObject == null) {
            break label134;
          }
          if (paramNetReq.jdField_b_of_type_Boolean) {
            break;
          }
          paramNetReq = ((baab)localObject).b.iterator();
          while (paramNetReq.hasNext())
          {
            localObject = (baaf)paramNetReq.next();
            azzx.a(this.jdField_a_of_type_Azzx, (baaf)localObject, this.jdField_a_of_type_Baae, paramLong1, paramLong2);
          }
        }
        azzx.a(this.jdField_a_of_type_Azzx, this.jdField_a_of_type_Baaf, this.jdField_a_of_type_Baae, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Baaf.a + " mItem.mName=" + this.jdField_a_of_type_Baae.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Baae.jdField_a_of_type_JavaLangString + " callback=" + paramNetReq.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baag
 * JD-Core Version:    0.7.0.1
 */