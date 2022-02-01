import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class azqm
{
  public static String a;
  public Activity a;
  Context jdField_a_of_type_AndroidContentContext;
  public Bitmap a;
  public azqp a;
  public QQAppInterface a;
  ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://ti.qq.com/specialtag/share.html?id=%s";
  }
  
  public azqm(Context paramContext, QQAppInterface paramQQAppInterface, Activity paramActivity, azqp paramazqp)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Azqp = paramazqp;
  }
  
  @Nullable
  private String a()
  {
    Object localObject = null;
    try
    {
      String str = "temp_qrcode_share_" + System.currentTimeMillis() + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ".png";
      str = znl.a(this.jdField_a_of_type_AndroidAppActivity, str, this.jdField_a_of_type_AndroidGraphicsBitmap);
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
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696130);
    localActionSheetItem.icon = 2130839146;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696143);
    localActionSheetItem.icon = 2130839147;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696150);
    localActionSheetItem.icon = 2130839150;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696133);
    localActionSheetItem.icon = 2130839144;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      azqn localazqn = new azqn(this);
      paramOnDismissListener = new azqo(this, paramOnDismissListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder((Activity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131718786));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(localazqn);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(paramOnDismissListener);
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.getActionSheet().isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
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
 * Qualified Name:     azqm
 * JD-Core Version:    0.7.0.1
 */