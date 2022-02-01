import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class apwi
  implements ArkViewImplement.LoadCallback
{
  apwi(apwh paramapwh, apzf paramapzf, apzb paramapzb, int paramInt, agnw paramagnw) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Apzf.a.setVisibility(0);
      apwh.a(this.jdField_a_of_type_Apwh, this.jdField_a_of_type_Apzb, this.jdField_a_of_type_Apzf);
      this.jdField_a_of_type_Apzf.b.setVisibility(0);
      this.jdField_a_of_type_Apzb.a(this.jdField_a_of_type_Apzf, this.jdField_a_of_type_Apwh);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Apwh.a.appName, ", position=", Integer.valueOf(this.jdField_a_of_type_Int), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Apzb.a(this.jdField_a_of_type_Agnw, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Apzf.a.setVisibility(8);
      this.jdField_a_of_type_Apzf.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwi
 * JD-Core Version:    0.7.0.1
 */