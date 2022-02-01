import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.conn.ConnManager.1;
import com.tencent.mobileqq.richmedia.conn.ConnManager.2;
import com.tencent.mobileqq.richmedia.conn.ConnManager.3;
import com.tencent.mobileqq.richmedia.conn.ConnManager.4;
import com.tencent.mobileqq.richmedia.conn.LiteTcpConnection;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bbju
  implements bbjx
{
  private static String jdField_a_of_type_JavaLangString = "PeakAudioTransHandler ConnManager";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bbjv jdField_a_of_type_Bbjv;
  private bbjw jdField_a_of_type_Bbjw;
  private bbou jdField_a_of_type_Bbou;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<bbjv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected ConcurrentLinkedQueue<byte[]> a;
  
  public bbju(AppInterface paramAppInterface, bbou parambbou)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bbou = parambbou;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.4(this, paramLong));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bbjw != null)
    {
      if (!this.jdField_a_of_type_Bbou.d()) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "closeConnection : TCP not opened  mTCPstate =" + this.jdField_a_of_type_Bbou.b());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bbou.b(13);
    this.jdField_a_of_type_Bbjw.b();
    this.jdField_a_of_type_Bbjw = null;
  }
  
  public void a(long paramLong, bbjw parambbjw)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onDisConnect connId = " + paramLong + ",sendDataQueue size =" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() + " mTCPstate =" + this.jdField_a_of_type_Bbou.b());
    }
    this.jdField_a_of_type_Bbou.b(10);
    this.jdField_a_of_type_Bbjv = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Bbou.a())
    {
      ((bbov)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0)).a(String.valueOf(paramLong), "TransInfo.ExitSession", null, 0, 0, false);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onDisConnect : session not open need not sso exit");
  }
  
  public void a(bbjv parambbjv, long paramLong)
  {
    if (parambbjv == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is null");
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(parambbjv.jdField_a_of_type_JavaLangString)) || (parambbjv.jdField_a_of_type_Int == 0))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : endPoint is illegal");
        return;
      }
      if (!this.jdField_a_of_type_Bbou.a())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : Session not Open");
        return;
      }
      if (!this.jdField_a_of_type_Bbou.f())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openNewConnection : TCP not Close mTCPstate =" + this.jdField_a_of_type_Bbou.b());
        return;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "openNewConnection : host:" + parambbjv.jdField_a_of_type_JavaLangString + ",port=" + parambbjv.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bbjv = parambbjv;
      if (this.jdField_a_of_type_Bbjw != null) {
        this.jdField_a_of_type_Bbjw.b();
      }
      this.jdField_a_of_type_Bbjw = new LiteTcpConnection(this, paramLong, parambbjv, 3000, 10000);
    } while (this.jdField_a_of_type_Bbjw == null);
    this.jdField_a_of_type_Bbjw.a(this);
    this.jdField_a_of_type_Bbjw.a();
    this.jdField_a_of_type_Bbou.b(11);
  }
  
  public void a(ArrayList<bbjv> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public void a(boolean paramBoolean, long paramLong, bbjw parambbjw, bbjv parambbjv, int paramInt)
  {
    int j = 0;
    parambbjw = (bbov)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0);
    if (parambbjv == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect failed ep = null return");
      b(paramLong);
    }
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.1(this, parambbjw, paramLong, parambbjv));
        return;
      }
      parambbjw = parambbjv.jdField_a_of_type_JavaLangString;
      int i = parambbjv.jdField_a_of_type_Int;
      if ((this.jdField_a_of_type_Bbjv == null) || (!parambbjw.equals(this.jdField_a_of_type_Bbjv.jdField_a_of_type_JavaLangString)) || (i != this.jdField_a_of_type_Bbjv.jdField_a_of_type_Int))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect ip or port changed ");
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Bbou.g())
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect reConnect state legal lSessionID = " + paramLong);
        }
        b(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Bbou.e())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "onConnect : TCP not in Opening state = " + this.jdField_a_of_type_Bbou.b());
        a(paramLong);
        return;
      }
      if (this.jdField_a_of_type_Bbjv.c >= 1)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "reConnect > 1 return");
        paramInt = 0;
        for (;;)
        {
          i = j;
          if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            parambbjw = (bbjv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            if ((parambbjw != this.jdField_a_of_type_Bbjv) && (parambbjw.c == 0))
            {
              this.jdField_a_of_type_Bbjv = parambbjw;
              i = 1;
            }
          }
          else
          {
            if (i == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed change ip new ip = " + this.jdField_a_of_type_Bbjv.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_Bbjv.jdField_a_of_type_Int);
            }
            a(this.jdField_a_of_type_Bbjv, paramLong);
            return;
          }
          paramInt += 1;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onConnect  not ip notify  connect failed ");
        b(paramLong);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnect failed reconnect ip = " + this.jdField_a_of_type_Bbjv.jdField_a_of_type_JavaLangString + ", port =" + this.jdField_a_of_type_Bbjv.jdField_a_of_type_Int);
      }
      if (paramInt == 3) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ConnManager.2(this, paramLong), 2000L);
      }
      while (this.jdField_a_of_type_Bbjv != null)
      {
        parambbjw = this.jdField_a_of_type_Bbjv;
        parambbjw.c += 1;
        return;
        this.jdField_a_of_type_AndroidOsHandler.post(new ConnManager.3(this, paramLong));
      }
    }
  }
  
  public boolean a()
  {
    return NetworkUtil.isNetSupportHw(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
  }
  
  public byte[] a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      return (byte[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbju
 * JD-Core Version:    0.7.0.1
 */