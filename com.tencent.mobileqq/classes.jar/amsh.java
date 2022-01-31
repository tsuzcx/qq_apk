import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

public class amsh
  implements ArkViewImplement.LoadCallback
{
  public amsh(MessageForArkApp paramMessageForArkApp, alff paramalff, adai paramadai, alfb paramalfb, int paramInt) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean) {}
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForArkApp", 2, new Object[] { "ArkFold.attachArkView onLoadFinish MessageForArkApp state=", Integer.valueOf(paramInt), ",app=", this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName });
    }
    this.jdField_a_of_type_Alff.b.setVisibility(8);
    if (paramInt == 1)
    {
      Object localObject = this.jdField_a_of_type_Adai.getContainerRect();
      float f = alem.a();
      paramInt = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
      int i = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
      this.jdField_a_of_type_Alfb.a(this.jdField_a_of_type_Alff, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
      if (alem.a)
      {
        localObject = this.jdField_a_of_type_Alff.a.getLayoutParams();
        QLog.d("MessageForArkApp", 2, new Object[] { "ArkFold.attachArkView.onLoadFinish arkContainer rect(", Integer.valueOf(paramInt), ",", Integer.valueOf(i), "), arkView rect(", Integer.valueOf(((ViewGroup.LayoutParams)localObject).width), ",", Integer.valueOf(((ViewGroup.LayoutParams)localObject).height), "),app=", this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName });
      }
    }
    this.jdField_a_of_type_Alfb.a(this.jdField_a_of_type_Adai, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amsh
 * JD-Core Version:    0.7.0.1
 */