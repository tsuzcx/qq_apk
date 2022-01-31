import com.tencent.qqmini.sdk.runtime.core.page.PageWebview;

class bhfu
  implements bhff
{
  bhfu(bhfp parambhfp) {}
  
  public void onStateChanged()
  {
    PageWebview localPageWebview;
    if (bhfp.a(this.a) != null)
    {
      localPageWebview = bhfp.a(this.a);
      if (this.a.getCurrState() != bhfp.b(this.a)) {
        break label43;
      }
    }
    label43:
    for (boolean bool = true;; bool = false)
    {
      localPageWebview.setPageJsLoadSucc(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfu
 * JD-Core Version:    0.7.0.1
 */