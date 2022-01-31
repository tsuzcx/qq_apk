import android.content.Intent;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import mqq.app.QQPermissionCallback;

class ayct
  implements QQPermissionCallback
{
  ayct(aycs paramaycs) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    babr.a(this.a.a, paramArrayOfString, paramArrayOfInt);
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
      azho.a(this.a.a.o, this.a.a.p, "Clk_record", this.a.a.q, this.a.a.b, "", "");
    }
    abju.a(this.a.a.a, paramArrayOfString, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayct
 * JD-Core Version:    0.7.0.1
 */