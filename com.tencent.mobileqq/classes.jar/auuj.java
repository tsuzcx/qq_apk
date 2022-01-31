import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class auuj
{
  public static String a;
  public Activity a;
  Context jdField_a_of_type_AndroidContentContext;
  public Bitmap a;
  public auum a;
  bbjq jdField_a_of_type_Bbjq = null;
  public QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://ti.qq.com/specialtag/share.html?id=%s";
  }
  
  public auuj(Context paramContext, QQAppInterface paramQQAppInterface, Activity paramActivity, auum paramauum)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Auum = paramauum;
  }
  
  @Nullable
  private String a()
  {
    Object localObject = null;
    try
    {
      String str = "temp_qrcode_share_" + System.currentTimeMillis() + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ".png";
      str = wij.a(this.jdField_a_of_type_AndroidAppActivity, str, this.jdField_a_of_type_AndroidGraphicsBitmap);
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
  
  private List<bbjs>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bbjs localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131696696);
    localbbjs.jdField_b_of_type_Int = 2130838754;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.c = 2;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131696709);
    localbbjs.jdField_b_of_type_Int = 2130838755;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.c = 3;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131696716);
    localbbjs.jdField_b_of_type_Int = 2130838758;
    localbbjs.c = 9;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = paramContext.getString(2131696699);
    localbbjs.jdField_b_of_type_Int = 2130838752;
    localbbjs.c = 10;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.jdField_a_of_type_Bbjq == null)
    {
      auuk localauuk = new auuk(this);
      paramOnDismissListener = new auul(this, paramOnDismissListener);
      this.jdField_a_of_type_Bbjq = new bbjq((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Bbjq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719508));
      this.jdField_a_of_type_Bbjq.a(a(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_Bbjq.a(localauuk);
      this.jdField_a_of_type_Bbjq.a(paramOnDismissListener);
    }
    try
    {
      if (!this.jdField_a_of_type_Bbjq.a().isShowing()) {
        this.jdField_a_of_type_Bbjq.a();
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
 * Qualified Name:     auuj
 * JD-Core Version:    0.7.0.1
 */