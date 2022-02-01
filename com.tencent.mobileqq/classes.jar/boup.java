import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity.1.1;

public class boup
  implements EncodeVideoTask.ResultListener
{
  public boup(EditWebVideoActivity paramEditWebVideoActivity) {}
  
  public void onEncodeSuccess(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = ((bouq)this.a.a).c;
    EditWebVideoActivity.a(this.a, paramString1);
    EditWebVideoActivity.a(this.a, paramArrayOfByte1);
    EditWebVideoActivity.b(this.a, HexUtil.bytes2HexStr(EditWebVideoActivity.a(this.a)));
    paramString1 = this.a;
    if (i <= 0) {}
    for (;;)
    {
      EditWebVideoActivity.a(paramString1, paramInt3);
      EditWebVideoActivity.c(this.a, paramString2);
      EditWebVideoActivity.b(this.a, paramArrayOfByte2);
      EditWebVideoActivity.b(this.a, paramInt1);
      EditWebVideoActivity.c(this.a, paramInt2);
      EditWebVideoActivity.a(this.a).sendEmptyMessage(1002);
      return;
      paramInt3 = i;
    }
  }
  
  public void onError(int paramInt)
  {
    this.a.runOnUiThread(new EditWebVideoActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boup
 * JD-Core Version:    0.7.0.1
 */