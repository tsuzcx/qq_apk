import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;

public class avns
  implements avom
{
  private String jdField_a_of_type_JavaLangString;
  private List<avon> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public avns(aewb paramaewb, List<avon> paramList, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return ajjy.a(2131639557);
  }
  
  public List<avon> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    avwf.a(this.jdField_a_of_type_JavaLangString, 80, 0, paramView);
    new Intent().putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    long l1 = Double.valueOf(NetSearchEngine.a * 1000000.0D).longValue();
    long l2 = Double.valueOf(NetSearchEngine.b * 1000000.0D).longValue();
    Object localObject2 = "http://qqweb.qq.com/m/relativegroup/index.html?source=qun_recent_search&keyword=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString) + "&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=" + Long.valueOf(l2) + "&lat=" + Long.valueOf(l1);
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Boolean) {
      localObject1 = (String)localObject2 + "&show_tab=hot";
    }
    if (QLog.isColorLevel()) {
      QLog.d("search", 2, "lastKeywords = " + this.jdField_a_of_type_JavaLangString + " jump url is : " + (String)localObject1);
    }
    localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("uin", ((BaseActivity)paramView.getContext()).app.getCurrentAccountUin());
    ((Intent)localObject2).putExtra("portraitOnly", true);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    ((Intent)localObject2).putExtra("isShowAd", false);
    paramView.getContext().startActivity((Intent)localObject2);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avns
 * JD-Core Version:    0.7.0.1
 */