import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.conn.ConnManager.1;
import com.tencent.mobileqq.richmedia.conn.ConnManager.2;
import com.tencent.mobileqq.richmedia.conn.ConnManager.3;
import com.tencent.mobileqq.richmedia.conn.ConnManager.4;
import com.tencent.mobileqq.richmedia.conn.LiteTcpConnection;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class axsq
  implements axst
{
  private static String jdField_a_of_type_JavaLangString = "PeakAudioTransHandler ConnManager";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private axsr jdField_a_of_type_Axsr;
  private axss jdField_a_of_type_Axss;
  private axxq jdField_a_of_type_Axxq;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<axsr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected ConcurrentLinkedQueue<byte[]> a;
  
  public axsq(AppInterface paramAppInterface, axxq paramaxxq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Axxq = paramaxxq;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.4(this, paramLong));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Axss != null)
    {
      if (!this.jdField_a_of_type_Axxq.d()) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeConnection : TCP not opened  mTCPstate =" + this.jdField_a_of_type_Axxq.b());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Axxq.b(13);
    this.jdField_a_of_type_Axss.b();
    this.jdField_a_of_type_Axss = null;
  }
  
  public void a(long paramLong, axss paramaxss)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onDisConnect connId = " + paramLong + ",sendDataQueue size =" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() + " mTCPstate =" + this.jdField_a_of_type_Axxq.b());
    }
    this.jdField_a_of_type_Axxq.b(10);
    this.jdField_a_of_type_Axsr = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Axxq.a())
    {
      ((axxr)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0)).a(String.valueOf(paramLong), "TransInfo.ExitSession", null, 0, 0, false);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onDisConnect : session not open need not sso exit");
  }
  
  public void a(axsr paramaxsr, long paramLong)
  {
    if (paramaxsr == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is null");
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramaxsr.jdField_a_of_type_JavaLangString)) || (paramaxsr.jdField_a_of_type_Int == 0))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is illegal");
        return;
      }
      if (!this.jdField_a_of_type_Axxq.a())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : Session not Open");
        return;
      }
      if (!this.jdField_a_of_type_Axxq.f())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : TCP not Close mTCPstate =" + this.jdField_a_of_type_Axxq.b());
        return;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "openNewConnection : host:" + paramaxsr.jdField_a_of_type_JavaLangString + ",port=" + paramaxsr.jdField_a_of_type_Int);
      this.jdField_a_of_type_Axsr = paramaxsr;
      if (this.jdField_a_of_type_Axss != null) {
        this.jdField_a_of_type_Axss.b();
      }
      this.jdField_a_of_type_Axss = new LiteTcpConnection(this, paramLong, paramaxsr, 3000, 10000);
    } while (this.jdField_a_of_type_Axss == null);
    this.jdField_a_of_type_Axss.a(this);
    this.jdField_a_of_type_Axss.a();
    this.jdField_a_of_type_Axxq.b(11);
  }
  
  public void a(ArrayList<axsr> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public void a(boolean paramBoolean, long paramLong, axss paramaxss, axsr paramaxsr, int paramInt)
  {
    int j = 0;
    paramaxss = (axxr)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0);
    if (paramaxsr == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect failed ep = null return");
      b(paramLong);
    }
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.1(this, paramaxss, paramLong, paramaxsr));
        return;
      }
      paramaxss = paramaxsr.jdField_a_of_type_JavaLangString;
      int i = paramaxsr.jdField_a_of_type_Int;
      if ((this.jdField_a_of_type_Axsr == null) || (!paramaxss.equals(this.jdField_a_of_type_Axsr.jdField_a_of_type_JavaLangString)) || (i != this.jdField_a_of_type_Axsr.jdField_a_of_type_Int))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect ip or port changed ");
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Axxq.h())
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect reConnect state legal lSessionID = " + paramLong);
        }
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Axxq.e())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "onConnect : TCP not in Opening state = " + this.jdField_a_of_type_Axxq.b());
        a(paramLong);
        return;
      }
      if (this.jdField_a_of_type_Axsr.c >= 1)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "reConnect > 1 return");
        paramInt = 0;
        for (;;)
        {
          i = j;
          if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramaxss = (axsr)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((paramaxss != this.jdField_a_of_type_Axsr) && (paramaxss.c == 0))
            {
              this.jdField_a_of_type_Axsr = paramaxss;
              i = 1;
            }
          }
          else
          {
            if (i == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed change ip new ip = " + this.jdField_a_of_type_Axsr.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_Axsr.jdField_a_of_type_Int);
            }
            a(this.jdField_a_of_type_Axsr, paramLong);
            return;
          }
          paramInt += 1;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect  not ip notify  connect failed ");
        b(paramLong);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed reconnect ip = " + this.jdField_a_of_type_Axsr.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_Axsr.jdField_a_of_type_Int);
      }
      if (paramInt == 3) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ConnManager.2(this, paramLong), 2000L);
      }
      while (this.jdField_a_of_type_Axsr != null)
      {
        paramaxss = this.jdField_a_of_type_Axsr;
        paramaxss.c += 1;
        return;
        this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.3(this, paramLong));
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramArrayOfByte);
    }
    if (this.jdField_a_of_type_Axss != null) {
      this.jdField_a_of_type_Axss.c();
    }
  }
  
  public boolean a()
  {
    return bdin.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
  }
  
  public byte[] a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      return (byte[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axsq
 * JD-Core Version:    0.7.0.1
 */