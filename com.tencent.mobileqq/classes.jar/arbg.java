import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arbg
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private arbj jdField_a_of_type_Arbj;
  private ardn jdField_a_of_type_Ardn;
  protected ardo a;
  private arfz jdField_a_of_type_Arfz;
  private arhu jdField_a_of_type_Arhu;
  private arju jdField_a_of_type_Arju;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  
  public arbg(Activity paramActivity, ardn paramardn, arbj paramarbj)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Ardn = paramardn;
    this.jdField_a_of_type_Arbj = paramarbj;
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList)
  {
    if ((paramArrayOfArrayList != null) && (paramArrayOfArrayList.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfArrayList.length)
      {
        Object localObject = paramArrayOfArrayList[i];
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).action == 26) {
              azmj.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_Arfz != null)
    {
      int i = this.jdField_a_of_type_Arfz.a();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.jdField_a_of_type_Int + "] fileType[" + i + "]");
      }
      if (this.jdField_a_of_type_Int != i)
      {
        if (this.jdField_a_of_type_Arhu != null) {
          this.jdField_a_of_type_Arhu.i();
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_Arhu = new arin(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
        }
        for (;;)
        {
          this.jdField_a_of_type_Arhu.a(this.jdField_a_of_type_Ardn);
          this.jdField_a_of_type_Arhu.a(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_Arhu.a(this.jdField_a_of_type_Ardo);
          this.jdField_a_of_type_Arhu.a();
          this.jdField_a_of_type_Arju = this.jdField_a_of_type_Arhu.a();
          this.jdField_a_of_type_Int = i;
          return true;
          this.jdField_a_of_type_Arhu = new arhp(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Arhu = new arhz(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Arhu = new arif(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Arhu = new aris(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Arhu = new arjh(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Arhu = new arim(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Arhu = new arik(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Arhu = new arie(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Arhu = new arhr(this.jdField_a_of_type_Arfz, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      this.jdField_a_of_type_Arhu.a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Arfz != null) {
      return this.jdField_a_of_type_Arfz.e();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Arfz != null) {
      return this.jdField_a_of_type_Arfz.c();
    }
    return 0L;
  }
  
  public anxw a()
  {
    if (this.jdField_a_of_type_Arfz != null) {
      return this.jdField_a_of_type_Arfz.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Arhu != null) {
      return this.jdField_a_of_type_Arhu.a();
    }
    return "";
  }
  
  public void a()
  {
    List localList = null;
    ShareActionSheetV2.Param localParam;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localParam = new ShareActionSheetV2.Param();
      localParam.context = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(localParam);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new arbh(this));
    Object localObject = a();
    if (localObject != null) {
      if (localObject.length == 1) {
        localParam = localObject[0];
      }
    }
    for (;;)
    {
      if (((localParam != null) && (!localParam.isEmpty())) || ((localList != null) && (!localList.isEmpty())))
      {
        a((ArrayList[])localObject);
        localObject = a() + "(" + arof.a(a()) + ")";
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle((CharSequence)localObject);
        localObject = this.jdField_a_of_type_Arfz.a();
        String str = this.jdField_a_of_type_Arfz.a();
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", str);
        if ((localObject != null) && (!TextUtils.isEmpty(str))) {
          break label268;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localParam, localList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new arbi(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
        return;
        if (localObject.length != 2) {
          break label281;
        }
        localParam = localObject[0];
        localList = localObject[1];
        break;
        label268:
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject);
      }
      label281:
      localParam = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Arhu != null) {
      this.jdField_a_of_type_Arhu.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Arhu != null) {
      this.jdField_a_of_type_Arhu.a(paramConfiguration);
    }
  }
  
  public void a(ardo paramardo)
  {
    this.jdField_a_of_type_Ardo = paramardo;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Arfz.e();
    return (i == 3) || (i == 9) || (i == 7) || (i == 10) || (i == 6);
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = f();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_Arju.a(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (this.jdField_a_of_type_Arfz == null)
    {
      this.jdField_a_of_type_Arfz = this.jdField_a_of_type_Arbj.a();
      this.jdField_a_of_type_Arfz.a(this.jdField_a_of_type_Ardn);
      this.jdField_a_of_type_Arfz.e(paramInt);
      this.jdField_a_of_type_Arfz.a(paramBundle);
    }
    boolean bool2 = f();
    boolean bool1;
    if ((this.jdField_a_of_type_Arju == null) || (this.jdField_a_of_type_Arhu == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 2, "create file view error");
      }
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramViewGroup == null);
      bool1 = bool2;
    } while (paramLayoutParams == null);
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(this.jdField_a_of_type_Arju.a(), paramLayoutParams);
    return bool2;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if ((this.jdField_a_of_type_Arfz != null) && (this.jdField_a_of_type_Arfz.k())) {
      return this.jdField_a_of_type_Arfz.a();
    }
    return null;
  }
  
  public void b()
  {
    List localList = null;
    if ((this.jdField_a_of_type_Arhu != null) && ((this.jdField_a_of_type_Arhu instanceof aris))) {
      this.jdField_a_of_type_Arhu.p();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null) {
      return;
    }
    ArrayList[] arrayOfArrayList = a();
    ArrayList localArrayList;
    if (arrayOfArrayList != null) {
      if (arrayOfArrayList.length == 1) {
        localArrayList = arrayOfArrayList[0];
      }
    }
    for (;;)
    {
      if (((localArrayList != null) && (!localArrayList.isEmpty())) || ((localList != null) && (!localList.isEmpty()))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localArrayList, localList);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.refresh();
      return;
      if (arrayOfArrayList.length == 2)
      {
        localArrayList = arrayOfArrayList[0];
        localList = arrayOfArrayList[1];
      }
      else
      {
        localArrayList = null;
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Arhu != null) {
      return this.jdField_a_of_type_Arhu.b();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Arfz != null) {
      this.jdField_a_of_type_Arfz.l();
    }
    if (this.jdField_a_of_type_Arhu != null) {
      this.jdField_a_of_type_Arhu.l();
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Arhu != null) {
      return this.jdField_a_of_type_Arhu.a();
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Arfz != null) {
      this.jdField_a_of_type_Arfz.j();
    }
    if (this.jdField_a_of_type_Arhu != null) {
      this.jdField_a_of_type_Arhu.j();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Arfz != null) && (this.jdField_a_of_type_Arfz.j() != 0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Arfz != null) {
      this.jdField_a_of_type_Arfz.i();
    }
    if (this.jdField_a_of_type_Arhu != null) {
      this.jdField_a_of_type_Arhu.k();
    }
  }
  
  public boolean e()
  {
    Object localObject = null;
    ArrayList[] arrayOfArrayList = a();
    ArrayList localArrayList;
    if (arrayOfArrayList != null) {
      if (arrayOfArrayList.length == 1) {
        localArrayList = arrayOfArrayList[0];
      }
    }
    for (;;)
    {
      if (((localArrayList != null) && (!localArrayList.isEmpty())) || ((localObject != null) && (!localObject.isEmpty())))
      {
        return true;
        if (arrayOfArrayList.length == 2)
        {
          localArrayList = arrayOfArrayList[0];
          localObject = arrayOfArrayList[1];
        }
      }
      else
      {
        return false;
      }
      localArrayList = null;
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
    }
    if (this.jdField_a_of_type_Arfz != null)
    {
      this.jdField_a_of_type_Arfz.f_();
      this.jdField_a_of_type_Arfz = null;
    }
    if (this.jdField_a_of_type_Arhu != null)
    {
      this.jdField_a_of_type_Arhu.i();
      this.jdField_a_of_type_Arhu = null;
    }
    if (this.jdField_a_of_type_Arju != null) {
      this.jdField_a_of_type_Arju = null;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Arfz != null) && ((this.jdField_a_of_type_Arju instanceof SimpleFileViewer))) {
      ((SimpleFileViewer)this.jdField_a_of_type_Arju).g(this.jdField_a_of_type_Arfz.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbg
 * JD-Core Version:    0.7.0.1
 */