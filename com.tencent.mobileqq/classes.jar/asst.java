import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.3;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.4;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public abstract class asst
{
  protected int a;
  public Activity a;
  protected Bundle a;
  private aokb a;
  protected aruk a;
  protected ashp a;
  public asqp a;
  protected asri a;
  protected asrk a;
  protected asrl a;
  protected assw a;
  public assy a;
  public assz a;
  protected asta a;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> a;
  protected HashMap<String, ArrayList<ShareActionSheetBuilder.ActionSheetItem>> a;
  protected int b;
  protected String f;
  
  public asst(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = 0;
  }
  
  public abstract float a();
  
  public int a()
  {
    int i = 3;
    int j = e();
    if ((d() == 3) && (aszt.c(d())) && (b() != 16))
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
  
  public apkw a()
  {
    return new asrc();
  }
  
  public abstract asri a();
  
  public abstract asrk a();
  
  public abstract asrl a();
  
  public asrm a()
  {
    return null;
  }
  
  public abstract TeamWorkFileImportInfo a();
  
  public String a()
  {
    return "";
  }
  
  public abstract List<assv> a();
  
  protected abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, assv paramassv);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(asqp paramasqp)
  {
    this.jdField_a_of_type_Asqp = paramasqp;
  }
  
  public void a(assw paramassw)
  {
    this.jdField_a_of_type_Assw = paramassw;
  }
  
  public abstract void a(assx paramassx);
  
  public void a(assy paramassy)
  {
    this.jdField_a_of_type_Assy = paramassy;
  }
  
  public void a(assz paramassz)
  {
    this.jdField_a_of_type_Assz = paramassz;
  }
  
  public void a(asta paramasta)
  {
    this.jdField_a_of_type_Asta = paramasta;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
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
      } while (!FileUtils.fileExistsAndNotEmpty((String)localObject));
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
        break;
      }
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
    paramList.addAll((Collection)localObject);
    return;
    ataw.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, new assu(this, (String)localObject));
  }
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(assx paramassx)
  {
    if (paramassx != null) {
      paramassx.as_();
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
      bcef.b(null, "dc00898", "", "", "0X800ADBC", "0X800ADBC", 0, 0, "", "", "", "");
      return;
    case 52: 
      bcef.b(null, "dc00898", "", "", "0X800ADBD", "0X800ADBD", 0, 0, "", "", "", "");
      return;
    case 55: 
      bcef.b(null, "dc00898", "", "", "0X800ADBE", "0X800ADBE", 0, 0, "", "", "", "");
      return;
    }
    bcef.b(null, "dc00898", "", "", "0X800ADBF", "0X800ADBF", 0, 0, "", "", "", "");
  }
  
  public abstract boolean f();
  
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
    if (this.jdField_a_of_type_Assz != null) {
      this.jdField_a_of_type_Assz = null;
    }
    if (this.jdField_a_of_type_Assy != null) {
      this.jdField_a_of_type_Assy = null;
    }
    if (this.jdField_a_of_type_Asta != null) {
      this.jdField_a_of_type_Asta = null;
    }
  }
  
  public abstract boolean j();
  
  public void j_()
  {
    b();
    if (this.jdField_a_of_type_Assz != null) {
      this.jdField_a_of_type_Assz = null;
    }
    if (this.jdField_a_of_type_Assy != null) {
      this.jdField_a_of_type_Assy = null;
    }
    if (this.jdField_a_of_type_Asta != null) {
      this.jdField_a_of_type_Asta = null;
    }
    n();
  }
  
  public int k()
  {
    return 0;
  }
  
  public String k()
  {
    return "";
  }
  
  public int l()
  {
    return this.b;
  }
  
  public String l()
  {
    return "";
  }
  
  public void l() {}
  
  public boolean l()
  {
    return this.b != 12;
  }
  
  public int m()
  {
    if (this.jdField_a_of_type_Asqp != null) {
      return this.jdField_a_of_type_Asqp.a();
    }
    return 0;
  }
  
  public String m()
  {
    return "";
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_Aokb != null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.3(this));
  }
  
  public String n()
  {
    return null;
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_Aokb == null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.4(this));
  }
  
  public String o()
  {
    return "";
  }
  
  public String p()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asst
 * JD-Core Version:    0.7.0.1
 */