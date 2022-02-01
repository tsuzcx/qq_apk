import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aojq
  extends aojs
{
  public aojq(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void d()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = blen.a(1);
    }
    ShoppingFragment.a(this.jdField_a_of_type_AndroidContentContext, str1);
  }
  
  private void e()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rtmp");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("retain");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("closejump");
    if (TextUtils.isEmpty(str1)) {
      str1 = "scheme";
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str5)) {
          continue;
        }
        int i = Integer.parseInt(str5);
        if (i != 1) {
          continue;
        }
        bool = true;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        boolean bool = false;
        continue;
        bool = false;
        continue;
      }
      bleu.a(new blej(this.jdField_a_of_type_AndroidContentContext, str1, str2, str3, bool, null, str4));
      return;
      bool = false;
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    try
    {
      if ("watch".equals(this.c))
      {
        e();
        return true;
      }
      if ("mqqapi://vaslive/myshopping".equals(this.c))
      {
        d();
        return true;
      }
    }
    catch (Exception localException)
    {
      QLog.e("IliveJumpAction", 1, "doAction error: " + localException.getMessage());
      a("IliveJumpAction");
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojq
 * JD-Core Version:    0.7.0.1
 */