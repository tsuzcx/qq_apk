import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aoxe
  extends aoxg
{
  public aoxe(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void d()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = bmfq.a(1);
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
    for (;;)
    {
      try
      {
        str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (str6 != null) {
          continue;
        }
        i = 99;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        String str6;
        localNumberFormatException.printStackTrace();
        QLog.e("IliveJumpAction", 1, "print exception: " + localNumberFormatException.getMessage());
        int i = 99;
        continue;
        bool = false;
        continue;
        continue;
      }
      QLog.d("IliveJumpAction", 1, "scheme parsed from:" + i);
      if (!TextUtils.isEmpty(str1)) {
        continue;
      }
      str1 = "scheme";
      try
      {
        if (TextUtils.isEmpty(str5)) {
          continue;
        }
        int j = Integer.parseInt(str5);
        if (j != 1) {
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
      bmfx.a(new bmfm(this.jdField_a_of_type_AndroidContentContext, str1, str2, str3, bool, null, str4, i));
      return;
      i = Integer.parseInt(str6);
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
 * Qualified Name:     aoxe
 * JD-Core Version:    0.7.0.1
 */