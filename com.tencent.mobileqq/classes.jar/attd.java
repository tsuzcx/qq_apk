import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class attd
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private attg jdField_a_of_type_Attg;
  private atuw jdField_a_of_type_Atuw;
  protected atux a;
  private atxa jdField_a_of_type_Atxa;
  private atzb jdField_a_of_type_Atzb;
  private auav jdField_a_of_type_Auav;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  
  public attd(Activity paramActivity, atuw paramatuw, attg paramattg)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Atuw = paramatuw;
    this.jdField_a_of_type_Attg = paramattg;
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
              bdla.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Atxa != null) {
      return this.jdField_a_of_type_Atxa.e();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Atxa != null) {
      return this.jdField_a_of_type_Atxa.c();
    }
    return 0L;
  }
  
  public aqoa a()
  {
    if (this.jdField_a_of_type_Atxa != null) {
      return this.jdField_a_of_type_Atxa.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Atzb != null) {
      return this.jdField_a_of_type_Atzb.a();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new atte(this));
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
        localObject = a() + "(" + FileUtil.filesizeToString(a()) + ")";
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle((CharSequence)localObject);
        localObject = this.jdField_a_of_type_Atxa.a();
        String str = this.jdField_a_of_type_Atxa.a();
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", str);
        if ((localObject != null) && (!TextUtils.isEmpty(str))) {
          break label268;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localParam, localList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new attf(this));
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
    if (this.jdField_a_of_type_Atzb != null) {
      this.jdField_a_of_type_Atzb.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Atzb != null) {
      this.jdField_a_of_type_Atzb.a(paramConfiguration);
    }
  }
  
  public void a(atux paramatux)
  {
    this.jdField_a_of_type_Atux = paramatux;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Atxa.e();
    return (i == 3) || (i == 9) || (i == 7) || (i == 10) || (i == 6);
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = e();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.jdField_a_of_type_Auav.a(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (this.jdField_a_of_type_Atxa == null)
    {
      this.jdField_a_of_type_Atxa = this.jdField_a_of_type_Attg.a();
      if (this.jdField_a_of_type_Atxa == null)
      {
        QLog.e("FileBrowserManager<FileAssistant>", 1, "create FileBrowser failed, mFileModel = null");
        return false;
      }
      this.jdField_a_of_type_Atxa.a(this.jdField_a_of_type_Atuw);
      this.jdField_a_of_type_Atxa.e(paramInt);
      this.jdField_a_of_type_Atxa.a(paramBundle);
    }
    boolean bool2 = e();
    boolean bool1;
    if ((this.jdField_a_of_type_Auav == null) || (this.jdField_a_of_type_Atzb == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 2, "create file view error");
      }
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramViewGroup != null)
      {
        bool1 = bool2;
        if (paramLayoutParams != null)
        {
          paramViewGroup.removeAllViews();
          paramViewGroup.addView(this.jdField_a_of_type_Auav.a(), paramLayoutParams);
          bool1 = bool2;
        }
      }
    }
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if ((this.jdField_a_of_type_Atxa != null) && (this.jdField_a_of_type_Atxa.l())) {
      return this.jdField_a_of_type_Atxa.a();
    }
    return null;
  }
  
  public void b()
  {
    List localList = null;
    if ((this.jdField_a_of_type_Atzb != null) && ((this.jdField_a_of_type_Atzb instanceof auaa))) {
      this.jdField_a_of_type_Atzb.p();
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
    if (this.jdField_a_of_type_Atzb != null) {
      return this.jdField_a_of_type_Atzb.b();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Atxa != null) {
      this.jdField_a_of_type_Atxa.l();
    }
    if (this.jdField_a_of_type_Atzb != null) {
      this.jdField_a_of_type_Atzb.l();
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Atzb != null) {
      return this.jdField_a_of_type_Atzb.a();
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Atxa != null) {
      this.jdField_a_of_type_Atxa.j();
    }
    if (this.jdField_a_of_type_Atzb != null) {
      this.jdField_a_of_type_Atzb.j();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Atxa != null) && (this.jdField_a_of_type_Atxa.j() != 0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Atxa != null) {
      this.jdField_a_of_type_Atxa.i();
    }
    if (this.jdField_a_of_type_Atzb != null) {
      this.jdField_a_of_type_Atzb.k();
    }
  }
  
  protected boolean e()
  {
    if (this.jdField_a_of_type_Atxa != null)
    {
      int j = this.jdField_a_of_type_Atxa.a();
      this.jdField_a_of_type_Atxa.d();
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 1, "refreshFileView. currentType[" + this.jdField_a_of_type_Int + "] fileType[" + j + "]");
      }
      if (this.jdField_a_of_type_Int != j)
      {
        if (this.jdField_a_of_type_Atzb != null) {
          this.jdField_a_of_type_Atzb.i();
        }
        String str = this.jdField_a_of_type_Atxa.d();
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
          this.jdField_a_of_type_Atzb = new atzu(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
        }
        for (;;)
        {
          this.jdField_a_of_type_Atzb.a(this.jdField_a_of_type_Atuw);
          this.jdField_a_of_type_Atzb.a(this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_Atzb.a(this.jdField_a_of_type_Atux);
          this.jdField_a_of_type_Atzb.a();
          this.jdField_a_of_type_Auav = this.jdField_a_of_type_Atzb.a();
          this.jdField_a_of_type_Int = i;
          return true;
          this.jdField_a_of_type_Atzb = new atyu(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Atzb = new atzg(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Atzb = new atzm(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Atzb = new auaa(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Atzb = new auai(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Atzb = new atzt(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Atzb = new atzr(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Atzb = new atzl(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Atzb = new atyy(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
          continue;
          this.jdField_a_of_type_Atzb = new atyq(this.jdField_a_of_type_Atxa, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      this.jdField_a_of_type_Atzb.a();
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
    if (this.jdField_a_of_type_Atxa != null)
    {
      this.jdField_a_of_type_Atxa.l_();
      this.jdField_a_of_type_Atxa = null;
    }
    if (this.jdField_a_of_type_Atzb != null)
    {
      this.jdField_a_of_type_Atzb.i();
      this.jdField_a_of_type_Atzb = null;
    }
    if (this.jdField_a_of_type_Auav != null) {
      this.jdField_a_of_type_Auav = null;
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
    if ((this.jdField_a_of_type_Atxa != null) && ((this.jdField_a_of_type_Auav instanceof SimpleFileViewer))) {
      ((SimpleFileViewer)this.jdField_a_of_type_Auav).h(this.jdField_a_of_type_Atxa.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attd
 * JD-Core Version:    0.7.0.1
 */