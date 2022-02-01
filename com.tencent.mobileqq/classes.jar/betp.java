import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class betp
  implements BusinessObserver
{
  betp(beto parambeto, betx parambetx, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TribeVideoListPlayerFragment", 2, "type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
    Object localObject1 = this.jdField_a_of_type_Beto.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity();
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = BaseApplicationImpl.getContext();
      if (paramBoolean)
      {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            break label540;
          }
          localObject2 = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject2).mergeFrom(paramBundle);
          paramInt = ((WebSsoBody.WebSsoResponseBody)localObject2).ret.get();
          paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject2).data.get());
          if (QLog.isColorLevel()) {
            QLog.i("TribeVideoListPlayerFragment", 2, "retCode = [" + paramInt + "]");
          }
          if (paramInt == 0) {
            break label267;
          }
          paramBundle = paramBundle.optString("msg");
          if (!TextUtils.isEmpty(paramBundle))
          {
            QQToast.a((Context)localObject1, 1, "" + paramBundle, 1).a();
            return;
          }
          QQToast.a((Context)localObject1, 1, anvx.a(2131714485), 1).a();
          return;
        }
        catch (Exception paramBundle)
        {
          QQToast.a((Context)localObject1, 1, anvx.a(2131714471), 1).a();
          if (!QLog.isColorLevel()) {
            break label637;
          }
        }
        QLog.e("TribeVideoListPlayerFragment", 2, "未知异常，请稍后重试", paramBundle);
        return;
        label267:
        if (paramBundle.optInt("retcode") != 0) {
          break label637;
        }
        paramBundle = this.jdField_a_of_type_Betx;
        if (this.jdField_a_of_type_Betx.jdField_c_of_type_Boolean) {
          break label638;
        }
      }
    }
    label540:
    label637:
    label638:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramBundle.jdField_c_of_type_Boolean = paramBoolean;
      paramBundle = this.jdField_a_of_type_Beto.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (betu)paramBundle.next();
        if (((localObject2 instanceof betx)) && (((betx)localObject2).jdField_c_of_type_Long == this.jdField_a_of_type_Betx.jdField_c_of_type_Long)) {
          ((betx)localObject2).jdField_c_of_type_Boolean = this.jdField_a_of_type_Betx.jdField_c_of_type_Boolean;
        }
      }
      if (this.jdField_a_of_type_Betx.jdField_c_of_type_Boolean) {}
      for (paramBundle = anvx.a(2131714486);; paramBundle = anvx.a(2131714484))
      {
        QQToast.a((Context)localObject1, 2, paramBundle, 1).a();
        if ((this.jdField_a_of_type_Beto.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Beto.jdField_a_of_type_Int) == this.jdField_a_of_type_Betx) && (this.jdField_a_of_type_Betx.jdField_c_of_type_Boolean) && (TribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRefWeakReference != null) && (TribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          ((TribeVideoPlugin)TribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Betx.jdField_c_of_type_Long);
        }
        bdla.b(null, "dc00899", "Grp_tribe", "", "video_player", "follow_suc", 0, 0, this.jdField_a_of_type_Betx.d, this.jdField_a_of_type_Betx.b + "", "", this.jdField_a_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_Beto.l.clearAnimation();
      this.jdField_a_of_type_Beto.k.clearAnimation();
      this.jdField_a_of_type_Beto.f.clearAnimation();
      QQToast.a((Context)localObject1, 1, anvx.a(2131714483), 1).a();
      return;
      this.jdField_a_of_type_Beto.l.clearAnimation();
      this.jdField_a_of_type_Beto.k.clearAnimation();
      this.jdField_a_of_type_Beto.f.clearAnimation();
      QQToast.a((Context)localObject1, 1, anvx.a(2131714468), 1).a();
      return;
      break;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betp
 * JD-Core Version:    0.7.0.1
 */