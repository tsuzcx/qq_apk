import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class apzr
  implements ArkViewImplement.LoadCallback
{
  apzr(apzq paramapzq, aqcq paramaqcq, aqcm paramaqcm, int paramInt, agyv paramagyv) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Aqcq.a.setVisibility(0);
      apzq.a(this.jdField_a_of_type_Apzq, this.jdField_a_of_type_Aqcm, this.jdField_a_of_type_Aqcq);
      this.jdField_a_of_type_Aqcq.b.setVisibility(0);
      this.jdField_a_of_type_Aqcm.a(this.jdField_a_of_type_Aqcq, this.jdField_a_of_type_Apzq);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Apzq.a.appName, ", position=", Integer.valueOf(this.jdField_a_of_type_Int), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Aqcm.a(this.jdField_a_of_type_Agyv, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Aqcq.a.setVisibility(8);
      this.jdField_a_of_type_Aqcq.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzr
 * JD-Core Version:    0.7.0.1
 */