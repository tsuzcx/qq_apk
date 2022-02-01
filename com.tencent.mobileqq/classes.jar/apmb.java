import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class apmb
  implements ArkViewImplement.LoadCallback
{
  apmb(apma paramapma, appa paramappa, apow paramapow, int paramInt, agpp paramagpp) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Appa.a.setVisibility(0);
      apma.a(this.jdField_a_of_type_Apma, this.jdField_a_of_type_Apow, this.jdField_a_of_type_Appa);
      this.jdField_a_of_type_Appa.b.setVisibility(0);
      this.jdField_a_of_type_Apow.a(this.jdField_a_of_type_Appa, this.jdField_a_of_type_Apma);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Apma.a.appName, ", position=", Integer.valueOf(this.jdField_a_of_type_Int), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Apow.a(this.jdField_a_of_type_Agpp, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Appa.a.setVisibility(8);
      this.jdField_a_of_type_Appa.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmb
 * JD-Core Version:    0.7.0.1
 */