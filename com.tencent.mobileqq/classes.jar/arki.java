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

public abstract class arki
{
  protected int a;
  public Activity a;
  public Bundle a;
  private aneh a;
  protected aqlx a;
  protected aqxd a;
  public arhw a;
  protected arip a;
  protected arir a;
  protected aris a;
  public arkn a;
  public arko a;
  protected arkp a;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> a;
  protected HashMap<String, ArrayList<ShareActionSheetBuilder.ActionSheetItem>> a;
  public int b;
  protected String f;
  
  public arki(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = 0;
  }
  
  public abstract float a();
  
  public int a()
  {
    int i = 3;
    int j = e();
    if ((d() == 3) && (arrr.c(d())) && (b() != 16))
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
  
  public aocf a()
  {
    return new arij();
  }
  
  public abstract arip a();
  
  public abstract arir a();
  
  public abstract aris a();
  
  public arit a()
  {
    return null;
  }
  
  public abstract TeamWorkFileImportInfo a();
  
  public String a()
  {
    return "";
  }
  
  public abstract List<arkl> a();
  
  protected abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, arkl paramarkl);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(arhw paramarhw)
  {
    this.jdField_a_of_type_Arhw = paramarhw;
  }
  
  public abstract void a(arkm paramarkm);
  
  public void a(arkn paramarkn)
  {
    this.jdField_a_of_type_Arkn = paramarkn;
  }
  
  public void a(arko paramarko)
  {
    this.jdField_a_of_type_Arko = paramarko;
  }
  
  public void a(arkp paramarkp)
  {
    this.jdField_a_of_type_Arkp = paramarkp;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
  public void a(String paramString)
  {
    if (bdhb.b(paramString)) {
      arsx.a(this.jdField_a_of_type_AndroidAppActivity, paramString, new arkk(this));
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
      } while (!bdhb.b((String)localObject));
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
        break;
      }
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
    paramList.addAll((Collection)localObject);
    return;
    arsx.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, new arkj(this, (String)localObject));
  }
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a(arkm paramarkm)
  {
    if (paramarkm != null) {
      paramarkm.aF_();
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
      azqs.b(null, "dc00898", "", "", "0X800ADBC", "0X800ADBC", 0, 0, "", "", "", "");
      return;
    case 52: 
      azqs.b(null, "dc00898", "", "", "0X800ADBD", "0X800ADBD", 0, 0, "", "", "", "");
      return;
    case 55: 
      azqs.b(null, "dc00898", "", "", "0X800ADBE", "0X800ADBE", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "dc00898", "", "", "0X800ADBF", "0X800ADBF", 0, 0, "", "", "", "");
  }
  
  public abstract boolean f();
  
  public void f_()
  {
    b();
    if (this.jdField_a_of_type_Arko != null) {
      this.jdField_a_of_type_Arko = null;
    }
    if (this.jdField_a_of_type_Arkn != null) {
      this.jdField_a_of_type_Arkn = null;
    }
    if (this.jdField_a_of_type_Arkp != null) {
      this.jdField_a_of_type_Arkp = null;
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
    if (this.jdField_a_of_type_Arko != null) {
      this.jdField_a_of_type_Arko = null;
    }
    if (this.jdField_a_of_type_Arkn != null) {
      this.jdField_a_of_type_Arkn = null;
    }
    if (this.jdField_a_of_type_Arkp != null) {
      this.jdField_a_of_type_Arkp = null;
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
    if (this.jdField_a_of_type_Arhw != null) {
      return this.jdField_a_of_type_Arhw.a();
    }
    return 0;
  }
  
  public void l() {}
  
  protected void m()
  {
    if (this.jdField_a_of_type_Aneh != null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.3(this));
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_Aneh == null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arki
 * JD-Core Version:    0.7.0.1
 */