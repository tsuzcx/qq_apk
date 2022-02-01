import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;
import org.json.JSONObject;

class bfod
  implements bfpo
{
  bfoo jdField_a_of_type_Bfoo;
  private WeakReference<bfoc> jdField_a_of_type_MqqUtilWeakReference;
  
  bfod(bfoc parambfoc, bfoo parambfoo)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambfoc);
    this.jdField_a_of_type_Bfoo = parambfoo;
  }
  
  private void a()
  {
    Object localObject = (bfoq)((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(357);
    if (localObject != null)
    {
      ArrayList localArrayList = ((bfoq)localObject).a(((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Long);
      if ((localArrayList != null) && (!localArrayList.contains(this.jdField_a_of_type_Bfoo)))
      {
        localArrayList.add(this.jdField_a_of_type_Bfoo);
        ((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.e();
      }
      localObject = ((bfoq)localObject).b(((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Long);
      if (localObject != null)
      {
        int i = ((ArrayList)localObject).indexOf(this.jdField_a_of_type_Bfoo);
        if ((i >= 0) && (i < ((ArrayList)localObject).size()))
        {
          ((bfoo)((ArrayList)localObject).get(i)).a = true;
          ((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.f();
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    QLog.e("AppsRecommendViewBuilder", 1, new Object[] { "add appid retCode: ", Integer.valueOf(paramInt) });
    if (paramInt == 41005)
    {
      paramInt = ((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
      if (paramInt > 0)
      {
        String str = ((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidContentContext.getString(2131698426).replace("$COUNT", String.valueOf(paramInt));
        QQToast.a(((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, str, 0).a();
        return;
      }
      QQToast.a(((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, ((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidContentContext.getString(2131698425), 0).a();
      return;
    }
    QQToast.a(((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, ((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidContentContext.getString(2131698424), 0).a();
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
    QQToast.a(((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, ((bfoc)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidContentContext.getString(2131698424), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfod
 * JD-Core Version:    0.7.0.1
 */