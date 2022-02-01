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

public class aucn
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private aucq jdField_a_of_type_Aucq;
  private auef jdField_a_of_type_Auef;
  protected aueg a;
  private augj jdField_a_of_type_Augj;
  private auik jdField_a_of_type_Auik;
  private auke jdField_a_of_type_Auke;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  
  public aucn(Activity paramActivity, auef paramauef, aucq paramaucq)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Auef = paramauef;
    this.jdField_a_of_type_Aucq = paramaucq;
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
              bdll.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Augj != null) {
      return this.jdField_a_of_type_Augj.e();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Augj != null) {
      return this.jdField_a_of_type_Augj.c();
    }
    return 0L;
  }
  
  public aqrn a()
  {
    if (this.jdField_a_of_type_Augj != null) {
      return this.jdField_a_of_type_Augj.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Auik != null) {
      return this.jdField_a_of_type_Auik.a();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new auco(this));
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
        localObject = a() + "(" + auog.a(a()) + ")";
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle((CharSequence)localObject);
        localObject = this.jdField_a_of_type_Augj.a();
        String str = this.jdField_a_of_type_Augj.a();
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", str);
        if ((localObject != null) && (!TextUtils.isEmpty(str))) {
          break label268;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localParam, localList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new aucp(this));
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
    if (this.jdField_a_of_type_Auik != null) {
      this.jdField_a_of_type_Auik.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Auik != null) {
      this.jdField_a_of_type_Auik.a(paramConfiguration);
    }
  }
  
  public void a(aueg paramaueg)
  {
    this.jdField_a_of_type_Aueg = paramaueg;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Augj.e();
    return (i == 3) || (i == 9) || (i == 7) || (i == 10) || (i == 6);
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = e();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_Auke.a(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (this.jdField_a_of_type_Augj == null)
    {
      this.jdField_a_of_type_Augj = this.jdField_a_of_type_Aucq.a();
      this.jdField_a_of_type_Augj.a(this.jdField_a_of_type_Auef);
      this.jdField_a_of_type_Augj.e(paramInt);
      this.jdField_a_of_type_Augj.a(paramBundle);
    }
    boolean bool2 = e();
    boolean bool1;
    if ((this.jdField_a_of_type_Auke == null) || (this.jdField_a_of_type_Auik == null))
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
    paramViewGroup.addView(this.jdField_a_of_type_Auke.a(), paramLayoutParams);
    return bool2;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if ((this.jdField_a_of_type_Augj != null) && (this.jdField_a_of_type_Augj.l())) {
      return this.jdField_a_of_type_Augj.a();
    }
    return null;
  }
  
  public void b()
  {
    List localList = null;
    if ((this.jdField_a_of_type_Auik != null) && ((this.jdField_a_of_type_Auik instanceof aujj))) {
      this.jdField_a_of_type_Auik.p();
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
    if (this.jdField_a_of_type_Auik != null) {
      return this.jdField_a_of_type_Auik.b();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Augj != null) {
      this.jdField_a_of_type_Augj.l();
    }
    if (this.jdField_a_of_type_Auik != null) {
      this.jdField_a_of_type_Auik.l();
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Auik != null) {
      return this.jdField_a_of_type_Auik.a();
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Augj != null) {
      this.jdField_a_of_type_Augj.j();
    }
    if (this.jdField_a_of_type_Auik != null) {
      this.jdField_a_of_type_Auik.j();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Augj != null) && (this.jdField_a_of_type_Augj.j() != 0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Augj != null) {
      this.jdField_a_of_type_Augj.i();
    }
    if (this.jdField_a_of_type_Auik != null) {
      this.jdField_a_of_type_Auik.k();
    }
  }
  
  protected boolean e()
  {
    if (this.jdField_a_of_type_Augj != null)
    {
      int j = this.jdField_a_of_type_Augj.a();
      this.jdField_a_of_type_Augj.d();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.jdField_a_of_type_Int + "] fileType[" + j + "]");
      }
      if (this.jdField_a_of_type_Int != j)
      {
        if (this.jdField_a_of_type_Auik != null) {
          this.jdField_a_of_type_Auik.i();
        }
        String str = this.jdField_a_of_type_Augj.d();
        int i = j;
        if (str != null)
        {
          i = j;
          if (str.contains("/chatpic/chatimg/")) {
            i = 6;
          }
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_Auik = new aujd(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
        }
        for (;;)
        {
          this.jdField_a_of_type_Auik.a(this.jdField_a_of_type_Auef);
          this.jdField_a_of_type_Auik.a(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_Auik.a(this.jdField_a_of_type_Aueg);
          this.jdField_a_of_type_Auik.a();
          this.jdField_a_of_type_Auke = this.jdField_a_of_type_Auik.a();
          this.jdField_a_of_type_Int = i;
          return true;
          this.jdField_a_of_type_Auik = new auid(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Auik = new auip(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Auik = new auiv(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Auik = new aujj(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Auik = new aujr(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Auik = new aujc(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Auik = new auja(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Auik = new auiu(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Auik = new auih(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Auik = new auhz(this.jdField_a_of_type_Augj, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      this.jdField_a_of_type_Auik.a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
    }
    if (this.jdField_a_of_type_Augj != null)
    {
      this.jdField_a_of_type_Augj.j_();
      this.jdField_a_of_type_Augj = null;
    }
    if (this.jdField_a_of_type_Auik != null)
    {
      this.jdField_a_of_type_Auik.i();
      this.jdField_a_of_type_Auik = null;
    }
    if (this.jdField_a_of_type_Auke != null) {
      this.jdField_a_of_type_Auke = null;
    }
  }
  
  public boolean f()
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
  
  public void g()
  {
    if ((this.jdField_a_of_type_Augj != null) && ((this.jdField_a_of_type_Auke instanceof SimpleFileViewer))) {
      ((SimpleFileViewer)this.jdField_a_of_type_Auke).h(this.jdField_a_of_type_Augj.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucn
 * JD-Core Version:    0.7.0.1
 */