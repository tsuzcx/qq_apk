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

public class auwp
  implements auws
{
  private static String jdField_a_of_type_JavaLangString = "PeakAudioTransHandler ConnManager";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private auwq jdField_a_of_type_Auwq;
  private auwr jdField_a_of_type_Auwr;
  private avbn jdField_a_of_type_Avbn;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<auwq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected ConcurrentLinkedQueue<byte[]> a;
  
  public auwp(AppInterface paramAppInterface, avbn paramavbn)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Avbn = paramavbn;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.4(this, paramLong));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Auwr != null)
    {
      if (!this.jdField_a_of_type_Avbn.d()) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeConnection : TCP not opened  mTCPstate =" + this.jdField_a_of_type_Avbn.b());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Avbn.b(13);
    this.jdField_a_of_type_Auwr.b();
    this.jdField_a_of_type_Auwr = null;
  }
  
  public void a(long paramLong, auwr paramauwr)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onDisConnect connId = " + paramLong + ",sendDataQueue size =" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() + " mTCPstate =" + this.jdField_a_of_type_Avbn.b());
    }
    this.jdField_a_of_type_Avbn.b(10);
    this.jdField_a_of_type_Auwq = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Avbn.a())
    {
      ((avbo)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0)).a(String.valueOf(paramLong), "TransInfo.ExitSession", null, 0, 0, false);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onDisConnect : session not open need not sso exit");
  }
  
  public void a(auwq paramauwq, long paramLong)
  {
    if (paramauwq == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is null");
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramauwq.jdField_a_of_type_JavaLangString)) || (paramauwq.jdField_a_of_type_Int == 0))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is illegal");
        return;
      }
      if (!this.jdField_a_of_type_Avbn.a())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : Session not Open");
        return;
      }
      if (!this.jdField_a_of_type_Avbn.f())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : TCP not Close mTCPstate =" + this.jdField_a_of_type_Avbn.b());
        return;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "openNewConnection : host:" + paramauwq.jdField_a_of_type_JavaLangString + ",port=" + paramauwq.jdField_a_of_type_Int);
      this.jdField_a_of_type_Auwq = paramauwq;
      if (this.jdField_a_of_type_Auwr != null) {
        this.jdField_a_of_type_Auwr.b();
      }
      this.jdField_a_of_type_Auwr = new LiteTcpConnection(this, paramLong, paramauwq, 3000, 10000);
    } while (this.jdField_a_of_type_Auwr == null);
    this.jdField_a_of_type_Auwr.a(this);
    this.jdField_a_of_type_Auwr.a();
    this.jdField_a_of_type_Avbn.b(11);
  }
  
  public void a(ArrayList<auwq> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public void a(boolean paramBoolean, long paramLong, auwr paramauwr, auwq paramauwq, int paramInt)
  {
    int j = 0;
    paramauwr = (avbo)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0);
    if (paramauwq == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect failed ep = null return");
      b(paramLong);
    }
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.1(this, paramauwr, paramLong, paramauwq));
        return;
      }
      paramauwr = paramauwq.jdField_a_of_type_JavaLangString;
      int i = paramauwq.jdField_a_of_type_Int;
      if ((this.jdField_a_of_type_Auwq == null) || (!paramauwr.equals(this.jdField_a_of_type_Auwq.jdField_a_of_type_JavaLangString)) || (i != this.jdField_a_of_type_Auwq.jdField_a_of_type_Int))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect ip or port changed ");
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Avbn.h())
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect reConnect state legal lSessionID = " + paramLong);
        }
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Avbn.e())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "onConnect : TCP not in Opening state = " + this.jdField_a_of_type_Avbn.b());
        a(paramLong);
        return;
      }
      if (this.jdField_a_of_type_Auwq.c >= 1)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "reConnect > 1 return");
        paramInt = 0;
        for (;;)
        {
          i = j;
          if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramauwr = (auwq)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((paramauwr != this.jdField_a_of_type_Auwq) && (paramauwr.c == 0))
            {
              this.jdField_a_of_type_Auwq = paramauwr;
              i = 1;
            }
          }
          else
          {
            if (i == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed change ip new ip = " + this.jdField_a_of_type_Auwq.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_Auwq.jdField_a_of_type_Int);
            }
            a(this.jdField_a_of_type_Auwq, paramLong);
            return;
          }
          paramInt += 1;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect  not ip notify  connect failed ");
        b(paramLong);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed reconnect ip = " + this.jdField_a_of_type_Auwq.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_Auwq.jdField_a_of_type_Int);
      }
      if (paramInt == 3) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ConnManager.2(this, paramLong), 2000L);
      }
      while (this.jdField_a_of_type_Auwq != null)
      {
        paramauwr = this.jdField_a_of_type_Auwq;
        paramauwr.c += 1;
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
    if (this.jdField_a_of_type_Auwr != null) {
      this.jdField_a_of_type_Auwr.c();
    }
  }
  
  public boolean a()
  {
    return badq.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
  }
  
  public byte[] a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      return (byte[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auwp
 * JD-Core Version:    0.7.0.1
 */