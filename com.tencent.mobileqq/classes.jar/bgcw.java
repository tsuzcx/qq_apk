import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class bgcw
  extends aofu
{
  bgcw(bgcu parambgcu) {}
  
  protected void onTroopAppHasNew(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (!paramString.equals(bgcu.a(this.a))) || (bgcu.a(this.a) == null) || (bgcu.a(this.a).hasDestory)) {
      return;
    }
    if (this.a.a != null)
    {
      this.a.a.a(4);
      this.a.a.c(75);
      this.a.a.a();
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcw
 * JD-Core Version:    0.7.0.1
 */