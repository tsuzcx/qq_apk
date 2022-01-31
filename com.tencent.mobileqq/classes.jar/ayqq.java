import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;

class ayqq
  extends ayvz
{
  ayqq(ayqp paramayqp) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    ayqm localayqm = (ayqm)paramMessage.obj;
    if ((i == 2002) || ((ayqp.a(this.a).equals(localayqm.p)) && (localayqm.b == 1) && (i != 2002)))
    {
      if ((localayqm.r == null) || (!localayqm.r.equals(ayqp.b(this.a)))) {
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
      ayqp.a(this.a);
      continue;
      if (bbdj.b(ayqp.c(this.a)))
      {
        ayqp.a(this.a).a().b(this);
        ayqp.b(this.a);
      }
      else
      {
        ayqp.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqq
 * JD-Core Version:    0.7.0.1
 */