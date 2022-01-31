import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class atgm
{
  private atgl jdField_a_of_type_Atgl;
  private atgn jdField_a_of_type_Atgn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<aovj> jdField_a_of_type_JavaUtilList;
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    alra localalra;
    do
    {
      return false;
      localalra = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    return localalra.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Atgl != null) {
      return this.jdField_a_of_type_Atgl.a();
    }
    return -1;
  }
  
  public void a()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_Atgl != null)
    {
      a(true);
      this.jdField_a_of_type_Atgl.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt1 + "|" + paramBoolean + paramInt2);
    if (this.jdField_a_of_type_Atgl != null) {
      this.jdField_a_of_type_Atgl.a(paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(atgn paramatgn)
  {
    this.jdField_a_of_type_Atgn = paramatgn;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramatgn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramatgn.jdField_a_of_type_JavaUtilList;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + aovj.a(this.jdField_a_of_type_JavaUtilList));
    Object localObject;
    if (this.jdField_a_of_type_Atgl == null)
    {
      boolean bool = a();
      if (bool)
      {
        localObject = new atgt();
        this.jdField_a_of_type_Atgl = ((atgl)localObject);
        QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atgl.a(paramatgn);
      return;
      localObject = new atgq();
      break;
      a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Atgl != null) {
      this.jdField_a_of_type_Atgl.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Atgl != null)
    {
      boolean bool1 = a();
      boolean bool2 = this.jdField_a_of_type_Atgl instanceof atgt;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_Atgl.d();
        if (!bool1) {
          break label100;
        }
      }
    }
    label100:
    for (Object localObject = new atgt();; localObject = new atgq())
    {
      this.jdField_a_of_type_Atgl = ((atgl)localObject);
      if (paramBoolean) {
        this.jdField_a_of_type_Atgl.a(this.jdField_a_of_type_Atgn);
      }
      return;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Atgl != null) {
      return this.jdField_a_of_type_Atgl.b();
    }
    return 0;
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + aovj.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Atgl != null) {
      this.jdField_a_of_type_Atgl.c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_Atgl != null) {
      this.jdField_a_of_type_Atgl.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgm
 * JD-Core Version:    0.7.0.1
 */