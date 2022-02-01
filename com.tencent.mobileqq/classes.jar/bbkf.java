import com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultFragment;
import com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultFragment.3.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

public class bbkf
  implements ValueCallback<String>
{
  public bbkf(KDSearchResultFragment paramKDSearchResultFragment) {}
  
  public void a(String paramString)
  {
    QLog.d("KDSearchResultFragment", 2, "onReceiveValue: " + paramString);
    if (!KDSearchResultFragment.a(this.a, paramString)) {
      bkgk.a(new KDSearchResultFragment.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkf
 * JD-Core Version:    0.7.0.1
 */