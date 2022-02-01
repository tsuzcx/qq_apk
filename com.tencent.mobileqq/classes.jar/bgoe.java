import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;
import org.json.JSONObject;

class bgoe
  implements bgpp
{
  bgop jdField_a_of_type_Bgop;
  private WeakReference<bgod> jdField_a_of_type_MqqUtilWeakReference;
  
  bgoe(bgod parambgod, bgop parambgop)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambgod);
    this.jdField_a_of_type_Bgop = parambgop;
  }
  
  private void a()
  {
    Object localObject = (bgor)((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
    if (localObject != null)
    {
      ArrayList localArrayList = ((bgor)localObject).a(((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Long);
      if ((localArrayList != null) && (!localArrayList.contains(this.jdField_a_of_type_Bgop)))
      {
        localArrayList.add(this.jdField_a_of_type_Bgop);
        ((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.e();
      }
      localObject = ((bgor)localObject).b(((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Long);
      if (localObject != null)
      {
        int i = ((ArrayList)localObject).indexOf(this.jdField_a_of_type_Bgop);
        if ((i >= 0) && (i < ((ArrayList)localObject).size()))
        {
          ((bgop)((ArrayList)localObject).get(i)).a = true;
          ((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.f();
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    QLog.e("AppsRecommendViewBuilder", 1, new Object[] { "add appid retCode: ", Integer.valueOf(paramInt) });
    if (paramInt == 41005)
    {
      paramInt = ((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
      if (paramInt > 0)
      {
        String str = ((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidContentContext.getString(2131698530).replace("$COUNT", String.valueOf(paramInt));
        QQToast.a(((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, str, 0).a();
        return;
      }
      QQToast.a(((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, ((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidContentContext.getString(2131698529), 0).a();
      return;
    }
    QQToast.a(((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, ((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidContentContext.getString(2131698528), 0).a();
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      if ((paramJSONObject == null) || (!paramJSONObject.has("ec"))) {
        break label73;
      }
      paramInt = paramJSONObject.optInt("ec");
      if (QLog.isColorLevel()) {
        QLog.d("AppsRecommendViewBuilder", 2, new Object[] { "retCode:", Integer.valueOf(paramInt) });
      }
      if (paramInt == 0) {
        a();
      }
    }
    else
    {
      return;
    }
    a(paramInt);
    return;
    label73:
    QLog.e("AppsRecommendViewBuilder", 1, "add appid get result err");
    QQToast.a(((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, ((bgod)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidContentContext.getString(2131698528), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgoe
 * JD-Core Version:    0.7.0.1
 */