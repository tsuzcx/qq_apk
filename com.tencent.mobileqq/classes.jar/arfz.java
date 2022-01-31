import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.3;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.4;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public abstract class arfz
{
  protected int a;
  private amzy a;
  public Activity a;
  public Bundle a;
  protected aqho a;
  protected aqsu a;
  public ardn a;
  protected areg a;
  protected arei a;
  protected arej a;
  public arge a;
  public argf a;
  protected argg a;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> a;
  protected HashMap<String, ArrayList<ShareActionSheetBuilder.ActionSheetItem>> a;
  public int b;
  protected String f;
  
  public arfz(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = 0;
  }
  
  public abstract float a();
  
  public int a()
  {
    int i = 3;
    int j = e();
    if ((d() == 3) && (arni.c(d())) && (b() != 16))
    {
      switch (j)
      {
      case 3: 
      default: 
        i = 1;
      case 5: 
        return i;
      case 1: 
        return 4;
      case 2: 
        return 2;
      case 0: 
        return 6;
      }
      if (h()) {
        return 5;
      }
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "getCreateFileType error : this is a local file, but is invalid, may be can not find file path");
    }
    return 0;
  }
  
  public Intent a()
  {
    return null;
  }
  
  public anxw a()
  {
    return new area();
  }
  
  public abstract areg a();
  
  public abstract arei a();
  
  public abstract arej a();
  
  public arek a()
  {
    return null;
  }
  
  public abstract TeamWorkFileImportInfo a();
  
  public String a()
  {
    return "";
  }
  
  public abstract List<argc> a();
  
  protected abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, argc paramargc);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(ardn paramardn)
  {
    this.jdField_a_of_type_Ardn = paramardn;
  }
  
  public abstract void a(argd paramargd);
  
  public void a(arge paramarge)
  {
    this.jdField_a_of_type_Arge = paramarge;
  }
  
  public void a(argf paramargf)
  {
    this.jdField_a_of_type_Argf = paramargf;
  }
  
  public void a(argg paramargg)
  {
    this.jdField_a_of_type_Argg = paramargg;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
  public void a(String paramString)
  {
    if (bdcs.b(paramString)) {
      aroo.a(this.jdField_a_of_type_AndroidAppActivity, paramString, new argb(this));
    }
  }
  
  public void a(String paramString, Bundle paramBundle) {}
  
  public void a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    if (paramList == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        localObject = e();
      } while (!bdcs.b((String)localObject));
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
        break;
      }
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
    paramList.addAll((Collection)localObject);
    return;
    aroo.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, new arga(this, (String)localObject));
  }
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a(argd paramargd)
  {
    if (paramargd != null) {
      paramargd.aI_();
    }
    return false;
  }
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a();
  
  public abstract int b();
  
  public abstract long b();
  
  public abstract String b();
  
  protected abstract void b();
  
  public abstract void b(int paramInt);
  
  public void b(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      paramList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public abstract boolean b();
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b();
  
  public int c()
  {
    if (this.jdField_a_of_type_Int < 0) {
      return 0;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public abstract long c();
  
  public abstract String c();
  
  public abstract void c(int paramInt);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract long d();
  
  public abstract String d();
  
  protected abstract void d();
  
  public abstract void d(int paramInt);
  
  public abstract boolean d();
  
  public abstract int e();
  
  public String e()
  {
    return "";
  }
  
  public abstract void e();
  
  public void e(int paramInt)
  {
    this.b = paramInt;
  }
  
  public abstract boolean e();
  
  public abstract int f();
  
  public abstract String f();
  
  public abstract void f();
  
  protected void f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 118: 
      azmj.b(null, "dc00898", "", "", "0X800ADBC", "0X800ADBC", 0, 0, "", "", "", "");
      return;
    case 52: 
      azmj.b(null, "dc00898", "", "", "0X800ADBD", "0X800ADBD", 0, 0, "", "", "", "");
      return;
    case 55: 
      azmj.b(null, "dc00898", "", "", "0X800ADBE", "0X800ADBE", 0, 0, "", "", "", "");
      return;
    }
    azmj.b(null, "dc00898", "", "", "0X800ADBF", "0X800ADBF", 0, 0, "", "", "", "");
  }
  
  public abstract boolean f();
  
  public void f_()
  {
    b();
    if (this.jdField_a_of_type_Argf != null) {
      this.jdField_a_of_type_Argf = null;
    }
    if (this.jdField_a_of_type_Arge != null) {
      this.jdField_a_of_type_Arge = null;
    }
    if (this.jdField_a_of_type_Argg != null) {
      this.jdField_a_of_type_Argg = null;
    }
    n();
  }
  
  public abstract int g();
  
  public abstract String g();
  
  public abstract void g();
  
  public abstract boolean g();
  
  public abstract int h();
  
  public abstract String h();
  
  public abstract boolean h();
  
  public abstract int i();
  
  public String i()
  {
    return null;
  }
  
  public void i()
  {
    a();
    m();
  }
  
  public abstract boolean i();
  
  public int j()
  {
    return 0;
  }
  
  public String j()
  {
    return "";
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Argf != null) {
      this.jdField_a_of_type_Argf = null;
    }
    if (this.jdField_a_of_type_Arge != null) {
      this.jdField_a_of_type_Arge = null;
    }
    if (this.jdField_a_of_type_Argg != null) {
      this.jdField_a_of_type_Argg = null;
    }
  }
  
  public abstract boolean j();
  
  public int k()
  {
    return this.b;
  }
  
  public String k()
  {
    return null;
  }
  
  public boolean k()
  {
    return this.b != 12;
  }
  
  public int l()
  {
    if (this.jdField_a_of_type_Ardn != null) {
      return this.jdField_a_of_type_Ardn.a();
    }
    return 0;
  }
  
  public void l() {}
  
  protected void m()
  {
    if (this.jdField_a_of_type_Amzy != null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.3(this));
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_Amzy == null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfz
 * JD-Core Version:    0.7.0.1
 */