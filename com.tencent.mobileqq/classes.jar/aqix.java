import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.c2s.imax.IMaxService.RspBody;

public class aqix
  extends mmk
{
  int jdField_a_of_type_Int = 0;
  mxu jdField_a_of_type_Mxu;
  WeakReference<QQAppInterface> c;
  
  public aqix(aqiw paramaqiw, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aqix(aqiw paramaqiw, mxu parammxu, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Mxu = parammxu;
    this.c = new WeakReference(paramQQAppInterface);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new IMaxService.RspBody();
    if (QLog.isColorLevel()) {
      QLog.i("ImaxAdNetPresenter", 2, "errorCode == " + paramInt);
    }
    if (paramInt == 0)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ImaxAdNetPresenter", 2, "request service success");
        }
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((!paramBundle.has()) || (paramBundle.int32_ret.get() != 0)) {
          return;
        }
        paramInt = paramBundle.int32_type.get();
        if ((paramInt == 2) && (this.jdField_a_of_type_Int == 3))
        {
          Toast.makeText(BaseApplication.getContext(), ajjy.a(2131639952), 0).show();
          return;
        }
        if (paramInt != 1) {
          return;
        }
        if (paramBundle.int32_exposure_flag.get() != 1) {
          break label264;
        }
        paramArrayOfByte = (QQAppInterface)this.c.get();
        if (paramArrayOfByte == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ImaxAdNetPresenter", 2, "request EXPOSURE succ ,but app == null");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      myd.a().a(paramArrayOfByte, 1, this.jdField_a_of_type_Mxu);
      this.jdField_a_of_type_Mxu.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdNetPresenter", 2, "do exposure Report");
      }
      this.jdField_a_of_type_Aqiw.a(this.jdField_a_of_type_Mxu);
      awqx.a(paramArrayOfByte, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.a, "0X8009129", "0X8009129", 0, 0, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.c, "", myn.a(), this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.b);
      return;
      label264:
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdNetPresenter", 2, "exposure already limited");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("ImaxAdNetPresenter", 2, "request service fail");
      }
      if (this.jdField_a_of_type_Int == 3) {
        Toast.makeText(BaseApplication.getContext(), ajjy.a(2131639951), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqix
 * JD-Core Version:    0.7.0.1
 */