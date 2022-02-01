import com.tencent.ttpic.openapi.listener.MaterialLoadFinishListener;

class bnba
  implements MaterialLoadFinishListener
{
  bnba(bnaz parambnaz) {}
  
  public void onFiltersReady()
  {
    if (bnaz.a(this.a) != null) {
      bnaz.a(this.a).onFilterReady();
    }
  }
  
  public void onLoadFinish(long paramLong)
  {
    bnqm.a().a(bnaz.a(this.a), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnba
 * JD-Core Version:    0.7.0.1
 */