import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class aote
  implements ArkViewImplement.LoadCallback
{
  aote(aotd paramaotd, aowb paramaowb, aovx paramaovx, int paramInt, afvh paramafvh) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Aowb.a.setVisibility(0);
      aotd.a(this.jdField_a_of_type_Aotd, this.jdField_a_of_type_Aovx, this.jdField_a_of_type_Aowb);
      this.jdField_a_of_type_Aowb.b.setVisibility(0);
      this.jdField_a_of_type_Aovx.a(this.jdField_a_of_type_Aowb, this.jdField_a_of_type_Aotd);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Aotd.a.appName, ", position=", Integer.valueOf(this.jdField_a_of_type_Int), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Aovx.a(this.jdField_a_of_type_Afvh, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Aowb.a.setVisibility(8);
      this.jdField_a_of_type_Aowb.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aote
 * JD-Core Version:    0.7.0.1
 */