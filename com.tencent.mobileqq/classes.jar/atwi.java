import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class atwi
{
  public static String a;
  public Activity a;
  Context jdField_a_of_type_AndroidContentContext;
  public Bitmap a;
  public atwl a;
  bahv jdField_a_of_type_Bahv = null;
  public QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://ti.qq.com/specialtag/share.html?id=%s";
  }
  
  public atwi(Context paramContext, QQAppInterface paramQQAppInterface, Activity paramActivity, atwl paramatwl)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Atwl = paramatwl;
  }
  
  @Nullable
  private String a()
  {
    Object localObject = null;
    try
    {
      String str = "temp_qrcode_share_" + System.currentTimeMillis() + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ".png";
      str = vvp.a(this.jdField_a_of_type_AndroidAppActivity, str, this.jdField_a_of_type_AndroidGraphicsBitmap);
      localObject = str;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ShareHelper", 2, localOutOfMemoryError.getMessage());
    }
    return localObject;
    return null;
  }
  
  private List<bahx>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bahx localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630983);
    localbahx.jdField_b_of_type_Int = 2130838732;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 2;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630996);
    localbahx.jdField_b_of_type_Int = 2130838733;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131631003);
    localbahx.jdField_b_of_type_Int = 2130838736;
    localbahx.c = 9;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630986);
    localbahx.jdField_b_of_type_Int = 2130838730;
    localbahx.c = 10;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.jdField_a_of_type_Bahv == null)
    {
      atwj localatwj = new atwj(this);
      paramOnDismissListener = new atwk(this, paramOnDismissListener);
      this.jdField_a_of_type_Bahv = new bahv((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bahv.a(this.jdField_a_of_type_AndroidContentContext.getString(2131653614));
      this.jdField_a_of_type_Bahv.a(a(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_Bahv.a(localatwj);
      this.jdField_a_of_type_Bahv.a(paramOnDismissListener);
    }
    try
    {
      if (!this.jdField_a_of_type_Bahv.a().isShowing()) {
        this.jdField_a_of_type_Bahv.a();
      }
      return;
    }
    catch (Exception paramOnDismissListener)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramOnDismissListener);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwi
 * JD-Core Version:    0.7.0.1
 */