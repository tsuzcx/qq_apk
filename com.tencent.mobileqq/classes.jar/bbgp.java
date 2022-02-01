import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class bbgp
  implements INetEngine.INetEngineListener
{
  bbgn jdField_a_of_type_Bbgn;
  bbgo jdField_a_of_type_Bbgo;
  
  bbgp(bbgg parambbgg, bbgo parambbgo, bbgn parambbgn)
  {
    this.jdField_a_of_type_Bbgo = parambbgo;
    this.jdField_a_of_type_Bbgn = parambbgn;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_Bbgn.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bbgn.c }));
    }
    paramNetResp = (bbgn)paramNetResp.mReq.getUserData();
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
          if (!paramNetResp.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bbgn.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (bbgg.b(paramNetResp.jdField_a_of_type_JavaLangString, paramNetResp.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            nwp.a(new File(bbgg.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Bbgn.jdField_a_of_type_JavaLangString), bbgg.jdField_a_of_type_JavaLangString);
            if (paramNetResp.jdField_b_of_type_Boolean) {
              break label269;
            }
            paramNetResp = (bbgk)this.jdField_a_of_type_Bbgg.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Bbgo.a));
            if (paramNetResp != null)
            {
              paramNetResp = paramNetResp.b.iterator();
              while (paramNetResp.hasNext())
              {
                bbgo localbbgo = (bbgo)paramNetResp.next();
                if (bbgg.a(this.jdField_a_of_type_Bbgg, localbbgo, this.jdField_a_of_type_Bbgn)) {
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
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Bbgo.a + " mItem.mName=" + this.jdField_a_of_type_Bbgn.jdField_a_of_type_JavaLangString);
      return;
      bbgg.a(this.jdField_a_of_type_Bbgg, this.jdField_a_of_type_Bbgo, this.jdField_a_of_type_Bbgn);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Bbgn.jdField_a_of_type_JavaLangString + " callback=" + paramNetResp.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (bbgn)paramNetReq.getUserData();
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
          if (!paramNetReq.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Bbgn.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (bbgk)this.jdField_a_of_type_Bbgg.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Bbgo.a));
          if (localObject == null) {
            break label134;
          }
          if (paramNetReq.jdField_b_of_type_Boolean) {
            break;
          }
          paramNetReq = ((bbgk)localObject).b.iterator();
          while (paramNetReq.hasNext())
          {
            localObject = (bbgo)paramNetReq.next();
            bbgg.a(this.jdField_a_of_type_Bbgg, (bbgo)localObject, this.jdField_a_of_type_Bbgn, paramLong1, paramLong2);
          }
        }
        bbgg.a(this.jdField_a_of_type_Bbgg, this.jdField_a_of_type_Bbgo, this.jdField_a_of_type_Bbgn, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Bbgo.a + " mItem.mName=" + this.jdField_a_of_type_Bbgn.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Bbgn.jdField_a_of_type_JavaLangString + " callback=" + paramNetReq.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgp
 * JD-Core Version:    0.7.0.1
 */