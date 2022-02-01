import mqq.util.WeakReference;

class apbp
  implements amqq
{
  WeakReference<apbm> a;
  
  public apbp(apbm paramapbm)
  {
    this.a = new WeakReference(paramapbm);
  }
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    apbm localapbm = (apbm)this.a.get();
    if (localapbm != null) {
      localapbm.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbp
 * JD-Core Version:    0.7.0.1
 */