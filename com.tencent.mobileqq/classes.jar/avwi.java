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

public class avwi
  implements avwl
{
  private static String jdField_a_of_type_JavaLangString = "PeakAudioTransHandler ConnManager";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private avwj jdField_a_of_type_Avwj;
  private avwk jdField_a_of_type_Avwk;
  private awbi jdField_a_of_type_Awbi;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<avwj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected ConcurrentLinkedQueue<byte[]> a;
  
  public avwi(AppInterface paramAppInterface, awbi paramawbi)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Awbi = paramawbi;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.4(this, paramLong));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Avwk != null)
    {
      if (!this.jdField_a_of_type_Awbi.d()) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeConnection : TCP not opened  mTCPstate =" + this.jdField_a_of_type_Awbi.b());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Awbi.b(13);
    this.jdField_a_of_type_Avwk.b();
    this.jdField_a_of_type_Avwk = null;
  }
  
  public void a(long paramLong, avwk paramavwk)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onDisConnect connId = " + paramLong + ",sendDataQueue size =" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() + " mTCPstate =" + this.jdField_a_of_type_Awbi.b());
    }
    this.jdField_a_of_type_Awbi.b(10);
    this.jdField_a_of_type_Avwj = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Awbi.a())
    {
      ((awbj)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0)).a(String.valueOf(paramLong), "TransInfo.ExitSession", null, 0, 0, false);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onDisConnect : session not open need not sso exit");
  }
  
  public void a(avwj paramavwj, long paramLong)
  {
    if (paramavwj == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is null");
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramavwj.jdField_a_of_type_JavaLangString)) || (paramavwj.jdField_a_of_type_Int == 0))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is illegal");
        return;
      }
      if (!this.jdField_a_of_type_Awbi.a())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : Session not Open");
        return;
      }
      if (!this.jdField_a_of_type_Awbi.f())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : TCP not Close mTCPstate =" + this.jdField_a_of_type_Awbi.b());
        return;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "openNewConnection : host:" + paramavwj.jdField_a_of_type_JavaLangString + ",port=" + paramavwj.jdField_a_of_type_Int);
      this.jdField_a_of_type_Avwj = paramavwj;
      if (this.jdField_a_of_type_Avwk != null) {
        this.jdField_a_of_type_Avwk.b();
      }
      this.jdField_a_of_type_Avwk = new LiteTcpConnection(this, paramLong, paramavwj, 3000, 10000);
    } while (this.jdField_a_of_type_Avwk == null);
    this.jdField_a_of_type_Avwk.a(this);
    this.jdField_a_of_type_Avwk.a();
    this.jdField_a_of_type_Awbi.b(11);
  }
  
  public void a(ArrayList<avwj> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public void a(boolean paramBoolean, long paramLong, avwk paramavwk, avwj paramavwj, int paramInt)
  {
    int j = 0;
    paramavwk = (awbj)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0);
    if (paramavwj == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect failed ep = null return");
      b(paramLong);
    }
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.1(this, paramavwk, paramLong, paramavwj));
        return;
      }
      paramavwk = paramavwj.jdField_a_of_type_JavaLangString;
      int i = paramavwj.jdField_a_of_type_Int;
      if ((this.jdField_a_of_type_Avwj == null) || (!paramavwk.equals(this.jdField_a_of_type_Avwj.jdField_a_of_type_JavaLangString)) || (i != this.jdField_a_of_type_Avwj.jdField_a_of_type_Int))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect ip or port changed ");
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Awbi.h())
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect reConnect state legal lSessionID = " + paramLong);
        }
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Awbi.e())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "onConnect : TCP not in Opening state = " + this.jdField_a_of_type_Awbi.b());
        a(paramLong);
        return;
      }
      if (this.jdField_a_of_type_Avwj.c >= 1)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "reConnect > 1 return");
        paramInt = 0;
        for (;;)
        {
          i = j;
          if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramavwk = (avwj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((paramavwk != this.jdField_a_of_type_Avwj) && (paramavwk.c == 0))
            {
              this.jdField_a_of_type_Avwj = paramavwk;
              i = 1;
            }
          }
          else
          {
            if (i == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed change ip new ip = " + this.jdField_a_of_type_Avwj.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_Avwj.jdField_a_of_type_Int);
            }
            a(this.jdField_a_of_type_Avwj, paramLong);
            return;
          }
          paramInt += 1;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect  not ip notify  connect failed ");
        b(paramLong);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed reconnect ip = " + this.jdField_a_of_type_Avwj.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_Avwj.jdField_a_of_type_Int);
      }
      if (paramInt == 3) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ConnManager.2(this, paramLong), 2000L);
      }
      while (this.jdField_a_of_type_Avwj != null)
      {
        paramavwk = this.jdField_a_of_type_Avwj;
        paramavwk.c += 1;
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
    if (this.jdField_a_of_type_Avwk != null) {
      this.jdField_a_of_type_Avwk.c();
    }
  }
  
  public boolean a()
  {
    return bbfj.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
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
 * Qualified Name:     avwi
 * JD-Core Version:    0.7.0.1
 */