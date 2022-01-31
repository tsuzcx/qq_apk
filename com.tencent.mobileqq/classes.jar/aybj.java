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
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class aybj
  implements BusinessObserver
{
  aybj(aybi paramaybi, aybq paramaybq, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TribeVideoListPlayerFragment", 2, "type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], bundle = [" + paramBundle + "]");
    }
    Object localObject1 = this.jdField_a_of_type_Aybi.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity();
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
            bbmy.a((Context)localObject1, 1, "" + paramBundle, 1).a();
            return;
          }
          bbmy.a((Context)localObject1, 1, ajjy.a(2131649332), 1).a();
          return;
        }
        catch (Exception paramBundle)
        {
          bbmy.a((Context)localObject1, 1, ajjy.a(2131649318), 1).a();
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
        paramBundle = this.jdField_a_of_type_Aybq;
        if (this.jdField_a_of_type_Aybq.jdField_c_of_type_Boolean) {
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
      paramBundle = this.jdField_a_of_type_Aybi.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (aybn)paramBundle.next();
        if (((localObject2 instanceof aybq)) && (((aybq)localObject2).jdField_c_of_type_Long == this.jdField_a_of_type_Aybq.jdField_c_of_type_Long)) {
          ((aybq)localObject2).jdField_c_of_type_Boolean = this.jdField_a_of_type_Aybq.jdField_c_of_type_Boolean;
        }
      }
      if (this.jdField_a_of_type_Aybq.jdField_c_of_type_Boolean) {}
      for (paramBundle = ajjy.a(2131649333);; paramBundle = ajjy.a(2131649331))
      {
        bbmy.a((Context)localObject1, 2, paramBundle, 1).a();
        if ((this.jdField_a_of_type_Aybi.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Aybi.jdField_a_of_type_Int) == this.jdField_a_of_type_Aybq) && (this.jdField_a_of_type_Aybq.jdField_c_of_type_Boolean) && (TribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRefWeakReference != null) && (TribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          ((TribeVideoPlugin)TribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Aybq.jdField_c_of_type_Long);
        }
        awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "follow_suc", 0, 0, this.jdField_a_of_type_Aybq.d, this.jdField_a_of_type_Aybq.b + "", "", this.jdField_a_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_Aybi.l.clearAnimation();
      this.jdField_a_of_type_Aybi.k.clearAnimation();
      this.jdField_a_of_type_Aybi.f.clearAnimation();
      bbmy.a((Context)localObject1, 1, ajjy.a(2131649330), 1).a();
      return;
      this.jdField_a_of_type_Aybi.l.clearAnimation();
      this.jdField_a_of_type_Aybi.k.clearAnimation();
      this.jdField_a_of_type_Aybi.f.clearAnimation();
      bbmy.a((Context)localObject1, 1, ajjy.a(2131649315), 1).a();
      return;
      break;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aybj
 * JD-Core Version:    0.7.0.1
 */