import com.tencent.qqmini.sdk.runtime.core.page.PageWebview;

class bhbn
  implements bhay
{
  bhbn(bhbi parambhbi) {}
  
  public void onStateChanged()
  {
    PageWebview localPageWebview;
    if (bhbi.a(this.a) != null)
    {
      localPageWebview = bhbi.a(this.a);
      if (this.a.getCurrState() != bhbi.b(this.a)) {
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
 * Qualified Name:     bhbn
 * JD-Core Version:    0.7.0.1
 */