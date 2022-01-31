import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;

class ayqs
  extends aywb
{
  ayqs(ayqr paramayqr) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    ayqo localayqo = (ayqo)paramMessage.obj;
    if ((i == 2002) || ((ayqr.a(this.a).equals(localayqo.p)) && (localayqo.b == 1) && (i != 2002)))
    {
      if ((localayqo.r == null) || (!localayqo.r.equals(ayqr.b(this.a)))) {
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
      ayqr.a(this.a);
      continue;
      if (bbdx.b(ayqr.c(this.a)))
      {
        ayqr.a(this.a).a().b(this);
        ayqr.b(this.a);
      }
      else
      {
        ayqr.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqs
 * JD-Core Version:    0.7.0.1
 */