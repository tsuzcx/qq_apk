import android.widget.TextView;

class blod
  implements blfn
{
  blod(blnz paramblnz) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      blpu.a("ReaderSplashImpl", "jumpToPlugin: openPlugin: failed");
      if (blnz.a(this.a) != null) {
        blnz.a(this.a).setText("跳转失败，请返回重试");
      }
      return;
    }
    blpu.d("ReaderSplashImpl", "jumpToPlugin: openPlugin: succeed");
    blnz.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blod
 * JD-Core Version:    0.7.0.1
 */