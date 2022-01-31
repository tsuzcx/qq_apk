import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteActivity.27.1;
import com.dataline.activities.LiteActivity.27.10;
import com.dataline.activities.LiteActivity.27.2;
import com.dataline.activities.LiteActivity.27.3;
import com.dataline.activities.LiteActivity.27.4;
import com.dataline.activities.LiteActivity.27.5;
import com.dataline.activities.LiteActivity.27.6;
import com.dataline.activities.LiteActivity.27.7;
import com.dataline.activities.LiteActivity.27.8;
import com.dataline.activities.LiteActivity.27.9;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class cl
  extends ajut
{
  public cl(LiteActivity paramLiteActivity) {}
  
  protected void a()
  {
    this.a.runOnUiThread(new LiteActivity.27.10(this));
  }
  
  @TargetApi(11)
  protected void a(int paramInt, String paramString, long paramLong)
  {
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (Build.VERSION.SDK_INT < 11)
    {
      this.a.runOnUiThread(new LiteActivity.27.7(this, paramString, paramInt));
      return;
    }
    this.a.runOnUiThread(new LiteActivity.27.8(this, paramString, paramInt));
  }
  
  protected void a(long paramLong)
  {
    this.a.runOnUiThread(new LiteActivity.27.9(this));
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new LiteActivity.27.3(this, paramLong, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
    this.a.runOnUiThread(new LiteActivity.27.4(this, paramInt, paramLong1));
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    super.a(paramBoolean, paramLong);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.a.runOnUiThread(new LiteActivity.27.2(this, paramBoolean, i, paramLong, paramString));
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong.longValue());
    this.a.runOnUiThread(new LiteActivity.27.6(this, i));
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
    this.a.runOnUiThread(new LiteActivity.27.5(this, paramInt, paramLong1));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.a.runOnUiThread(new LiteActivity.27.1(this, i, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     cl
 * JD-Core Version:    0.7.0.1
 */