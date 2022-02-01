import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Arrays;

class auye
  extends bemu
{
  auye(auxu paramauxu, boolean[] paramArrayOfBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt, int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    super.a(paramInt, paramBoolean, paramArrayOfObject);
    auxu.e(this.jdField_a_of_type_Auxu);
    if (!paramBoolean)
    {
      Log.d("onSentMessage", "onSentMessage() called with: type = [" + paramInt + "], result = [" + paramArrayOfObject[1] + "], index: " + 0 + " isExpiredMessage: " + Arrays.toString(auxu.a(this.jdField_a_of_type_Auxu)) + " padId: " + Arrays.toString((Object[])paramArrayOfObject[0]));
      if (((Integer)paramArrayOfObject[1]).intValue() == 505)
      {
        paramArrayOfObject = (String[])paramArrayOfObject[0];
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_ArrayOfBoolean.length)
        {
          if ((this.jdField_a_of_type_ArrayOfJavaLangString[paramInt].equals(paramArrayOfObject[0])) && (this.b[paramInt].equals(paramArrayOfObject[1])) && (this.jdField_a_of_type_ArrayOfInt[paramInt] == Integer.parseInt(paramArrayOfObject[2]))) {
            auxu.a(this.jdField_a_of_type_Auxu)[paramInt] = 1;
          }
          paramInt += 1;
        }
      }
      QQToast.a(this.jdField_a_of_type_Auxu.jdField_a_of_type_AndroidAppActivity, "发送失败，请稍候重试。", 0).a();
      this.jdField_a_of_type_Auxu.d = 0;
    }
    do
    {
      return;
      this.jdField_a_of_type_Auxu.jdField_a_of_type_AndroidAppActivity.setResult(15);
      paramArrayOfObject = this.jdField_a_of_type_Auxu;
      paramInt = paramArrayOfObject.d + 1;
      paramArrayOfObject.d = paramInt;
    } while (paramInt != this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Auxu.jdField_a_of_type_AndroidOsBundle.putBooleanArray("forward_write_together_is_expired", auxu.a(this.jdField_a_of_type_Auxu));
    if (this.jdField_a_of_type_Auxu.g())
    {
      auxu.a(this.jdField_a_of_type_Auxu);
      return;
    }
    this.jdField_a_of_type_Auxu.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auye
 * JD-Core Version:    0.7.0.1
 */