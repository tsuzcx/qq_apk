package com.tencent.av.random;

import android.os.AsyncTask;
import com.tencent.av.utils.HttpUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

class RandomWebProtocol$RandomReportTask
  extends AsyncTask<Void, Void, Void>
{
  RandomWebProtocol.RequestMultiReport jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$RequestMultiReport;
  String jdField_a_of_type_JavaLangString;
  
  protected Void a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = HttpUtil.a(this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$RequestMultiReport.c, this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$RequestMultiReport.a(), this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("RandomWebProtocol", 2, "RandomReportTask rsp = " + paramVarArgs);
      }
      return null;
    }
    catch (ClientProtocolException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
    catch (IOException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    RandomWebProtocol.a(this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.RandomReportTask
 * JD-Core Version:    0.7.0.1
 */