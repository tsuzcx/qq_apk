import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.Validator.1;
import java.util.Iterator;
import java.util.List;

public class bixm
{
  private ShareActionSheetV2 jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2;
  private boolean jdField_a_of_type_Boolean = false;
  
  public bixm(ShareActionSheetV2 paramShareActionSheetV2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2 = paramShareActionSheetV2;
  }
  
  private void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new Validator.1(this, paramString));
  }
  
  private boolean b()
  {
    List[] arrayOfList = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.getActionSheetItems();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((ShareActionSheetBuilder.ActionSheetItem)localIterator.next()).isValidCreate()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean c()
  {
    List[] arrayOfList = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.getActionSheetItems();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((ShareActionSheetBuilder.ActionSheetItem)localIterator.next()).isValidLabel()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean d()
  {
    List[] arrayOfList = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.getActionSheetItems();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((ShareActionSheetBuilder.ActionSheetItem)localIterator.next()).isValidIcon()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.mOutAct;
    if ((localObject instanceof Activity))
    {
      localObject = ((Activity)localObject).getIntent();
      if (!TextUtils.isEmpty(((Intent)localObject).getStringExtra("big_brother_source_key"))) {
        return true;
      }
      if (!TextUtils.isEmpty(((Intent)localObject).getStringExtra("url"))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  public boolean a()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    if (!e())
    {
      a("share component no biz id");
      bool1 = false;
    }
    if (!d())
    {
      a("share component icon invalid");
      bool1 = false;
    }
    if (!c())
    {
      a("share component label invalid");
      bool1 = false;
    }
    if (!b())
    {
      a("share component item invalid");
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixm
 * JD-Core Version:    0.7.0.1
 */