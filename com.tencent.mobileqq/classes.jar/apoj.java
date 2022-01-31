import mqq.os.MqqHandler;

class apoj
  implements arbi
{
  public MqqHandler a;
  
  public apoj(MqqHandler paramMqqHandler)
  {
    this.a = paramMqqHandler;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.a != null) {
      this.a.sendMessageDelayed(this.a.obtainMessage(101, paramInt, 0, paramString), 1500L);
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.a != null) {
      this.a.sendEmptyMessageDelayed(100, 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apoj
 * JD-Core Version:    0.7.0.1
 */