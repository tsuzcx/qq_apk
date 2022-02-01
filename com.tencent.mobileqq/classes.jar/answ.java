import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

class answ
  extends anyz
{
  answ(ansr paramansr) {}
  
  protected void onSelfIpadOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.b()))
    {
      this.a.b(true);
      ansr.b(this.a, bcrg.a());
      this.a.app.getMessageFacade().getDatalineMessageManager(1).b();
    }
  }
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.a()))
    {
      this.a.a(true);
      ansr.a(this.a, bcrg.a());
      this.a.app.getMessageFacade().getDatalineMessageManager(0).b();
    }
    this.a.a.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     answ
 * JD-Core Version:    0.7.0.1
 */