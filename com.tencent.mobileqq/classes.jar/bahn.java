import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class bahn
  extends blkh
{
  public int a(Context paramContext, long paramLong)
  {
    this.b = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (!this.a) {
      switch (this.b)
      {
      default: 
        this.c = 4096;
      }
    }
    for (;;)
    {
      if (paramLong < 102400L) {
        this.c *= 4;
      }
      if (paramLong - this.c <= this.c / 2) {
        this.c = ((int)paramLong);
      }
      return this.c;
      this.c = 32768;
      continue;
      this.c = 32768;
      continue;
      this.c = 16384;
      continue;
      this.c = 8192;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahn
 * JD-Core Version:    0.7.0.1
 */