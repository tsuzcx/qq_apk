import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class bfix
  implements BusinessObserver
{
  public bfix(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.c(false);
    this.a.rightViewText.setEnabled(true);
    TroopBarPublishActivity localTroopBarPublishActivity = this.a;
    this.a.getString(2131695614);
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label748;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt == 0) {
          break label209;
        }
        localObject = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = this.a.getString(2131695615, new Object[] { Integer.valueOf(paramInt) });
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Object localObject;
          label167:
          label209:
          StringBuffer localStringBuffer;
          paramBundle = this.a.getString(2131695615, new Object[] { Integer.valueOf(9992) });
          continue;
          localStringBuffer.append("7");
          continue;
          localStringBuffer.append("8");
          continue;
          paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.c;
          continue;
          paramBundle = this.a.u;
        }
      }
      QQToast.a(localTroopBarPublishActivity, 1, paramBundle, 0).b(this.a.getTitleBarHeight());
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label800;
      }
      paramBundle = "0";
      bgqv.a("pub_page", "fail", paramBundle, "4", TroopBarPublishActivity.b(this.a), "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
      return;
      localObject = paramBundle.getJSONObject("result");
      localStringBuffer = new StringBuffer();
      if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localStringBuffer.append("0");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        localStringBuffer.append("1");
      }
      if (!TextUtils.isEmpty(bgqv.a(this.a.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText))) {
        localStringBuffer.append("2");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        localStringBuffer.append("5");
      }
      if (this.a.h) {
        if (!TextUtils.isEmpty(bgqv.a(this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText)))
        {
          localStringBuffer.append("6");
          if (!TextUtils.isEmpty(this.a.u)) {
            break label713;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
            break label699;
          }
          paramBundle = "0";
          if ((this.a.jdField_b_of_type_AndroidWidgetTextView == null) || (this.a.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
            break label820;
          }
        }
      }
    }
    label800:
    label820:
    for (paramInt = 2;; paramInt = 1)
    {
      bdll.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "suc", paramInt, 0, paramBundle, this.a.jdField_b_of_type_JavaLangString, localStringBuffer.toString(), "");
      this.a.e = true;
      ((JSONObject)localObject).optString("pid");
      paramBundle = ((JSONObject)localObject).optString("bid");
      if ((this.a.d) && (this.a.jdField_a_of_type_OrgJsonJSONObject != null))
      {
        this.a.getIntent().getStringExtra("pkg_name");
        this.a.jdField_a_of_type_OrgJsonJSONObject.optString("share_app_name");
        this.a.jdField_a_of_type_OrgJsonJSONObject.optLong("share_app_id");
        if (TextUtils.isEmpty(paramBundle)) {
          break label724;
        }
      }
      for (;;)
      {
        bhtc.a(this.a.app, "share_suc", paramBundle);
        if (this.a.jdField_a_of_type_Bfcs != null) {
          this.a.u();
        }
        if ((this.a.jdField_a_of_type_Bfex != null) && (!TroopBarPublishActivity.a(this.a).equals("###...^_^###"))) {
          bdll.b(null, "dc00899", "Grp_tribe", "", "pub_page", "sus_prefixpub", 0, 0, this.a.q, "", "", "");
        }
        paramBundle = new Intent();
        paramBundle.putExtra("result", ((JSONObject)localObject).toString());
        this.a.setResult(-1, paramBundle);
        this.a.finish();
        return;
        label699:
        label713:
        label724:
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
        {
          paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.c;
          continue;
          label748:
          paramBundle = this.a.getString(2131695615, new Object[] { Integer.valueOf(9991) });
          break;
          paramBundle = this.a.getString(2131695615, new Object[] { Integer.valueOf(9992) });
          break;
          paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.c;
          break label167;
        }
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfix
 * JD-Core Version:    0.7.0.1
 */