import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.Validator.1;
import java.util.Iterator;
import java.util.List;

public class bcvh
{
  private ShareActionSheetV2 jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2;
  private boolean jdField_a_of_type_Boolean;
  
  public bcvh(ShareActionSheetV2 paramShareActionSheetV2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2 = paramShareActionSheetV2;
  }
  
  private void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new Validator.1(this, paramString));
  }
  
  private boolean b()
  {
    List[] arrayOfList = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.a();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((bbje)localIterator.next()).c()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean c()
  {
    List[] arrayOfList = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.a();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((bbje)localIterator.next()).b()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean d()
  {
    List[] arrayOfList = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.a();
    int i = 0;
    while (i < arrayOfList.length)
    {
      Iterator localIterator = arrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        if (!((bbje)localIterator.next()).a()) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean e()
  {
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheetV2.a;
    if ((localContext instanceof Activity)) {
      return !TextUtils.isEmpty(((Activity)localContext).getIntent().getStringExtra("big_brother_source_key"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcvh
 * JD-Core Version:    0.7.0.1
 */