import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;

class anei
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  anei(aneh paramaneh) {}
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if (paramInt == 0) {
      ReadInJoyArkViewController.a().a("0", this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anei
 * JD-Core Version:    0.7.0.1
 */