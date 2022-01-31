import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class anhm
  implements ArkViewImplement.LoadCallback
{
  anhm(anhl paramanhl, ankl paramankl, ankh paramankh, int paramInt, afds paramafds) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Ankl.a.setVisibility(0);
      anhl.a(this.jdField_a_of_type_Anhl, this.jdField_a_of_type_Ankh, this.jdField_a_of_type_Ankl);
      this.jdField_a_of_type_Ankl.b.setVisibility(0);
      this.jdField_a_of_type_Ankh.a(this.jdField_a_of_type_Ankl, this.jdField_a_of_type_Anhl);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Anhl.a.appName, ", position=", Integer.valueOf(this.jdField_a_of_type_Int), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Ankh.a(this.jdField_a_of_type_Afds, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Ankl.a.setVisibility(8);
      this.jdField_a_of_type_Ankl.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhm
 * JD-Core Version:    0.7.0.1
 */