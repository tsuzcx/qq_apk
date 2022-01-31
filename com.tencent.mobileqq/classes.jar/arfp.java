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

public class arfp
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private arfs jdField_a_of_type_Arfs;
  private arhw jdField_a_of_type_Arhw;
  protected arhx a;
  private arki jdField_a_of_type_Arki;
  private armd jdField_a_of_type_Armd;
  private arod jdField_a_of_type_Arod;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  
  public arfp(Activity paramActivity, arhw paramarhw, arfs paramarfs)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Arhw = paramarhw;
    this.jdField_a_of_type_Arfs = paramarfs;
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
              azqs.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_Arki != null)
    {
      int i = this.jdField_a_of_type_Arki.a();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.jdField_a_of_type_Int + "] fileType[" + i + "]");
      }
      if (this.jdField_a_of_type_Int != i)
      {
        if (this.jdField_a_of_type_Armd != null) {
          this.jdField_a_of_type_Armd.i();
        }
        switch (i)
        {
        default: 
          this.jdField_a_of_type_Armd = new armw(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
        }
        for (;;)
        {
          this.jdField_a_of_type_Armd.a(this.jdField_a_of_type_Arhw);
          this.jdField_a_of_type_Armd.a(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_Armd.a(this.jdField_a_of_type_Arhx);
          this.jdField_a_of_type_Armd.a();
          this.jdField_a_of_type_Arod = this.jdField_a_of_type_Armd.a();
          this.jdField_a_of_type_Int = i;
          return true;
          this.jdField_a_of_type_Armd = new arly(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Armd = new armi(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Armd = new armo(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Armd = new arnb(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Armd = new arnq(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Armd = new armv(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Armd = new armt(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Armd = new armn(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Armd = new arma(this.jdField_a_of_type_Arki, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      this.jdField_a_of_type_Armd.a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Arki != null) {
      return this.jdField_a_of_type_Arki.e();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Arki != null) {
      return this.jdField_a_of_type_Arki.c();
    }
    return 0L;
  }
  
  public aocf a()
  {
    if (this.jdField_a_of_type_Arki != null) {
      return this.jdField_a_of_type_Arki.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Armd != null) {
      return this.jdField_a_of_type_Armd.a();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new arfq(this));
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
        localObject = a() + "(" + arso.a(a()) + ")";
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle((CharSequence)localObject);
        localObject = this.jdField_a_of_type_Arki.a();
        String str = this.jdField_a_of_type_Arki.a();
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", str);
        if ((localObject != null) && (!TextUtils.isEmpty(str))) {
          break label268;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localParam, localList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new arfr(this));
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
    if (this.jdField_a_of_type_Armd != null) {
      this.jdField_a_of_type_Armd.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Armd != null) {
      this.jdField_a_of_type_Armd.a(paramConfiguration);
    }
  }
  
  public void a(arhx paramarhx)
  {
    this.jdField_a_of_type_Arhx = paramarhx;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Arki.e();
    return (i == 3) || (i == 9) || (i == 7) || (i == 10) || (i == 6);
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = f();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_Arod.a(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (this.jdField_a_of_type_Arki == null)
    {
      this.jdField_a_of_type_Arki = this.jdField_a_of_type_Arfs.a();
      this.jdField_a_of_type_Arki.a(this.jdField_a_of_type_Arhw);
      this.jdField_a_of_type_Arki.e(paramInt);
      this.jdField_a_of_type_Arki.a(paramBundle);
    }
    boolean bool2 = f();
    boolean bool1;
    if ((this.jdField_a_of_type_Arod == null) || (this.jdField_a_of_type_Armd == null))
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
    paramViewGroup.addView(this.jdField_a_of_type_Arod.a(), paramLayoutParams);
    return bool2;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if ((this.jdField_a_of_type_Arki != null) && (this.jdField_a_of_type_Arki.k())) {
      return this.jdField_a_of_type_Arki.a();
    }
    return null;
  }
  
  public void b()
  {
    List localList = null;
    if ((this.jdField_a_of_type_Armd != null) && ((this.jdField_a_of_type_Armd instanceof arnb))) {
      this.jdField_a_of_type_Armd.p();
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
    if (this.jdField_a_of_type_Armd != null) {
      return this.jdField_a_of_type_Armd.b();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Arki != null) {
      this.jdField_a_of_type_Arki.l();
    }
    if (this.jdField_a_of_type_Armd != null) {
      this.jdField_a_of_type_Armd.l();
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Armd != null) {
      return this.jdField_a_of_type_Armd.a();
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Arki != null) {
      this.jdField_a_of_type_Arki.j();
    }
    if (this.jdField_a_of_type_Armd != null) {
      this.jdField_a_of_type_Armd.j();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Arki != null) && (this.jdField_a_of_type_Arki.j() != 0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Arki != null) {
      this.jdField_a_of_type_Arki.i();
    }
    if (this.jdField_a_of_type_Armd != null) {
      this.jdField_a_of_type_Armd.k();
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
    if (this.jdField_a_of_type_Arki != null)
    {
      this.jdField_a_of_type_Arki.f_();
      this.jdField_a_of_type_Arki = null;
    }
    if (this.jdField_a_of_type_Armd != null)
    {
      this.jdField_a_of_type_Armd.i();
      this.jdField_a_of_type_Armd = null;
    }
    if (this.jdField_a_of_type_Arod != null) {
      this.jdField_a_of_type_Arod = null;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Arki != null) && ((this.jdField_a_of_type_Arod instanceof SimpleFileViewer))) {
      ((SimpleFileViewer)this.jdField_a_of_type_Arod).g(this.jdField_a_of_type_Arki.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfp
 * JD-Core Version:    0.7.0.1
 */