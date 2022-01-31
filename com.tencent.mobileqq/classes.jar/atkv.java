import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class atkv
{
  private atku jdField_a_of_type_Atku;
  private atkw jdField_a_of_type_Atkw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<aozs> jdField_a_of_type_JavaUtilList;
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    alvp localalvp;
    do
    {
      return false;
      localalvp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    return localalvp.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Atku != null) {
      return this.jdField_a_of_type_Atku.a();
    }
    return -1;
  }
  
  public void a()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_Atku != null)
    {
      a(true);
      this.jdField_a_of_type_Atku.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt1 + "|" + paramBoolean + paramInt2);
    if (this.jdField_a_of_type_Atku != null) {
      this.jdField_a_of_type_Atku.a(paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(atkw paramatkw)
  {
    this.jdField_a_of_type_Atkw = paramatkw;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramatkw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramatkw.jdField_a_of_type_JavaUtilList;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + aozs.a(this.jdField_a_of_type_JavaUtilList));
    Object localObject;
    if (this.jdField_a_of_type_Atku == null)
    {
      boolean bool = a();
      if (bool)
      {
        localObject = new atlc();
        this.jdField_a_of_type_Atku = ((atku)localObject);
        QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atku.a(paramatkw);
      return;
      localObject = new atkz();
      break;
      a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Atku != null) {
      this.jdField_a_of_type_Atku.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Atku != null)
    {
      boolean bool1 = a();
      boolean bool2 = this.jdField_a_of_type_Atku instanceof atlc;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_Atku.d();
        if (!bool1) {
          break label100;
        }
      }
    }
    label100:
    for (Object localObject = new atlc();; localObject = new atkz())
    {
      this.jdField_a_of_type_Atku = ((atku)localObject);
      if (paramBoolean) {
        this.jdField_a_of_type_Atku.a(this.jdField_a_of_type_Atkw);
      }
      return;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Atku != null) {
      return this.jdField_a_of_type_Atku.b();
    }
    return 0;
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + aozs.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Atku != null) {
      this.jdField_a_of_type_Atku.c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_Atku != null) {
      this.jdField_a_of_type_Atku.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkv
 * JD-Core Version:    0.7.0.1
 */