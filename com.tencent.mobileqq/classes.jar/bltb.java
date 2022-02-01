import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;

class bltb
  implements AVCallback
{
  bltb(blsw paramblsw) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      QLog.e("AVEngineWalper", 1, "AVCallback make connection successfully!!!");
      blsw.a(this.a, true);
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.a(paramInt, paramString);
      }
      return;
      QLog.e("AVEngineWalper", 1, "AVCallback result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltb
 * JD-Core Version:    0.7.0.1
 */