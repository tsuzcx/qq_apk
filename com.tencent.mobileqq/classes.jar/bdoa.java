import android.content.Intent;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import mqq.app.QQPermissionCallback;

class bdoa
  implements QQPermissionCallback
{
  bdoa(bdnz parambdnz) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("audio_max_length", this.a.a.h);
    if (this.a.a.q != null)
    {
      paramArrayOfString.putExtra("from", "publish");
      paramArrayOfString.putExtra("bid", this.a.a.q);
      paramArrayOfString.putExtra("fromflag", this.a.a.b);
      bfaj.a(this.a.a.o, this.a.a.p, "Clk_record", this.a.a.q, this.a.a.b, "", "");
    }
    adxr.a(this.a.a.a, paramArrayOfString, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoa
 * JD-Core Version:    0.7.0.1
 */