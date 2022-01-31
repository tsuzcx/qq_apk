import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;

class bfbn
  implements AVCallback
{
  bfbn(bfbi parambfbi) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      QLog.e("AVEngineWalper", 1, "AVCallback make connection successfully!!!");
      bfbi.a(this.a, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfbn
 * JD-Core Version:    0.7.0.1
 */