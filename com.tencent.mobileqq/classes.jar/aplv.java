import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

class aplv
  extends mmn
{
  aplv(apln paramapln) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.a.j)) {}
    do
    {
      return;
      this.a.x();
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (paramInt == 16)
      {
        this.a.L();
        return;
      }
    } while (!apln.a(this.a));
    this.a.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", aphf.e.intValue());
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplv
 * JD-Core Version:    0.7.0.1
 */