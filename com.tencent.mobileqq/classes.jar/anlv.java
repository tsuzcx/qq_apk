import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class anlv
  implements ArkViewImplement.LoadCallback
{
  anlv(anlu paramanlu, anou paramanou, anoq paramanoq, int paramInt, afih paramafih) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Anou.a.setVisibility(0);
      anlu.a(this.jdField_a_of_type_Anlu, this.jdField_a_of_type_Anoq, this.jdField_a_of_type_Anou);
      this.jdField_a_of_type_Anou.b.setVisibility(0);
      this.jdField_a_of_type_Anoq.a(this.jdField_a_of_type_Anou, this.jdField_a_of_type_Anlu);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Anlu.a.appName, ", position=", Integer.valueOf(this.jdField_a_of_type_Int), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Anoq.a(this.jdField_a_of_type_Afih, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Anou.a.setVisibility(8);
      this.jdField_a_of_type_Anou.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlv
 * JD-Core Version:    0.7.0.1
 */