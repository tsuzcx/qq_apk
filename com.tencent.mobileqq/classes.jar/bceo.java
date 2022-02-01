import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;

public class bceo
  extends bcgz
{
  public long a;
  String a;
  public List<bcfr> a;
  public boolean a;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  public List<String> b;
  public boolean b;
  String c;
  public boolean c;
  public String d;
  public String e;
  private String f;
  
  public bceo() {}
  
  public bceo(String paramString1, long paramLong1, String paramString2, List<bcfr> paramList, long paramLong2, String paramString3, String paramString4, List<String> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString5, String paramString6)
  {
    this.f = paramString1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "GroupBaseNetSearchModel ,moreUrl = " + paramString3);
    }
    this.jdField_c_of_type_JavaLangString = paramString4;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.e = paramString6;
    this.d = paramString5;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<bcfr> a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "getResultList." + this.jdField_a_of_type_JavaUtilList);
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Long == 1002L) && (!this.jdField_b_of_type_JavaLangString.isEmpty())) {
      this.jdField_b_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + "&sourceext=" + paramInt);
    }
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "onMoreAction. searchKey=" + this.f + " groupName=" + this.jdField_a_of_type_JavaLangString + " groupMask=" + this.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_Long == 1002L) {
      bcnd.a(this.jdField_a_of_type_JavaUtilList, this.f);
    }
    if (this.jdField_a_of_type_Long == 1701L)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("search_keyword", this.f);
      ((Intent)localObject).putExtra("key_refer", 1005);
      PublicFragmentActivity.a(paramView.getContext(), (Intent)localObject, MiniAppSearchFragment.class);
    }
    do
    {
      return;
      ActiveEntitySearchActivity.jdField_b_of_type_Boolean = true;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      localObject = bhni.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.jdField_b_of_type_JavaLangString);
      if (localObject != null)
      {
        ((bhmr)localObject).a();
        return;
      }
    } while ((!this.jdField_b_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_b_of_type_JavaLangString.startsWith("https://")));
    long l1 = Double.valueOf(NetSearchEngine.a * 1000000.0D).longValue();
    long l2 = Double.valueOf(NetSearchEngine.b * 1000000.0D).longValue();
    Object localObject = this.jdField_b_of_type_JavaLangString + "&keyword=" + URLEncoder.encode(this.f) + "&gpstype=1&lon=" + Long.valueOf(l2) + "&lat=" + Long.valueOf(l1);
    if (QLog.isColorLevel()) {}
    try
    {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "onMoreAction,moreUrl = " + this.jdField_b_of_type_JavaLangString + ",dstUrl = " + avqg.a((String)localObject));
      paramView = paramView.getContext();
      Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      paramView.startActivity(localIntent);
      return;
    }
    catch (XorCipherException localXorCipherException)
    {
      for (;;)
      {
        localXorCipherException.printStackTrace();
      }
    }
    ActiveEntitySearchActivity.a(paramView.getContext(), this.f, this.jdField_a_of_type_JavaLangString, new long[] { this.jdField_a_of_type_Long });
  }
  
  public int b()
  {
    return (int)this.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "getKeyword." + this.f);
    }
    return this.f;
  }
  
  public String c()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {
      return anzj.a(2131704240);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String d()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      return "";
    }
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bceo
 * JD-Core Version:    0.7.0.1
 */