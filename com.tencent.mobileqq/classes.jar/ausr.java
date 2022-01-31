import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils.1;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class ausr
  implements BusinessObserver
{
  public ausr(NearbyUtils.1 param1) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
          localWebSsoResponseBody.mergeFrom(paramBundle);
          paramInt = localWebSsoResponseBody.ret.get();
          paramBundle = new JSONObject(localWebSsoResponseBody.data.get());
          if (paramInt != 0)
          {
            paramBundle = paramBundle.optString("msg");
            if (!TextUtils.isEmpty(paramBundle)) {
              QLog.d("NearbyUtilsQ.nearby.nearby_sig", 2, "get nearby_sig,targetUin:" + this.a.jdField_a_of_type_JavaLangString + ", errMsg:" + paramBundle);
            }
          }
          else
          {
            paramBundle = paramBundle.optString("signature");
            if (QLog.isColorLevel()) {
              QLog.d("NearbyUtilsQ.nearby.nearby_sig", 2, "get nearby_sig,targetUin:" + this.a.jdField_a_of_type_JavaLangString + "signature:" + paramBundle);
            }
            try
            {
              if (TextUtils.isEmpty(paramBundle)) {
                return;
              }
              if (this.a.jdField_a_of_type_Int != 0) {
                break label283;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h(this.a.jdField_a_of_type_JavaLangString, bdbi.decode(paramBundle, 0));
              return;
            }
            catch (Exception paramBundle)
            {
              if (!QLog.isColorLevel()) {
                return;
              }
            }
            QLog.e("NearbyUtilsQ.nearby.nearby_sig", 2, "get nearby_sig Exception:" + paramBundle.toString());
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("NearbyUtilsQ.nearby.nearby_sig", 2, "get nearby_sig Exception" + paramBundle.toString());
          return;
          label283:
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().i(this.a.jdField_a_of_type_JavaLangString, bdbi.decode(paramBundle, 0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausr
 * JD-Core Version:    0.7.0.1
 */