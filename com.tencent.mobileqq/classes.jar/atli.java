import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Arrays;

class atli
  extends bdgm
{
  atli(atky paramatky, boolean[] paramArrayOfBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt, int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    super.a(paramInt, paramBoolean, paramArrayOfObject);
    atky.e(this.jdField_a_of_type_Atky);
    if (!paramBoolean)
    {
      Log.d("onSentMessage", "onSentMessage() called with: type = [" + paramInt + "], result = [" + paramArrayOfObject[1] + "], isExpiredMessage: " + Arrays.toString(atky.a(this.jdField_a_of_type_Atky)) + " padId: " + Arrays.toString((Object[])paramArrayOfObject[0]));
      if (((Integer)paramArrayOfObject[1]).intValue() == 505)
      {
        paramArrayOfObject = (String[])paramArrayOfObject[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_ArrayOfBoolean.length)
        {
          if ((this.jdField_a_of_type_ArrayOfJavaLangString[paramInt].equals(paramArrayOfObject[0])) && (this.b[paramInt].equals(paramArrayOfObject[1])) && (this.jdField_a_of_type_ArrayOfInt[paramInt] == Integer.parseInt(paramArrayOfObject[2]))) {
            atky.a(this.jdField_a_of_type_Atky)[paramInt] = 1;
          }
          paramInt += 1;
        }
      }
      QQToast.a(this.jdField_a_of_type_Atky.jdField_a_of_type_AndroidAppActivity, "发送失败，请稍后重试。", 0).a();
      this.jdField_a_of_type_Atky.d = 0;
      this.jdField_a_of_type_Atky.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    }
    do
    {
      return;
      this.jdField_a_of_type_Atky.jdField_a_of_type_AndroidAppActivity.setResult(15);
      paramArrayOfObject = this.jdField_a_of_type_Atky;
      paramInt = paramArrayOfObject.d + 1;
      paramArrayOfObject.d = paramInt;
    } while (paramInt != this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Atky.jdField_a_of_type_AndroidOsBundle.putBooleanArray("forward_write_together_is_expired", atky.a(this.jdField_a_of_type_Atky));
    this.jdField_a_of_type_Atky.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    if (this.jdField_a_of_type_Atky.i())
    {
      atky.a(this.jdField_a_of_type_Atky);
      return;
    }
    this.jdField_a_of_type_Atky.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atli
 * JD-Core Version:    0.7.0.1
 */