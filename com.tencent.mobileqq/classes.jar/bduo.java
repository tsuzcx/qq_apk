import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;

class bduo
  extends bdzm
{
  bduo(bdun parambdun) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    bduk localbduk = (bduk)paramMessage.obj;
    if ((i == 2002) || ((bdun.a(this.a).equals(localbduk.p)) && (localbduk.b == 1) && (i != 2002)))
    {
      if ((localbduk.r == null) || (!localbduk.r.equals(bdun.b(this.a)))) {
        return;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      bdun.a(this.a);
      continue;
      if (bgmg.b(bdun.c(this.a)))
      {
        bdun.a(this.a).a().b(this);
        bdun.b(this.a);
      }
      else
      {
        bdun.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduo
 * JD-Core Version:    0.7.0.1
 */