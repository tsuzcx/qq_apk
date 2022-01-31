import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import java.util.List;

public class arpq
{
  private arpp jdField_a_of_type_Arpp;
  private arpr jdField_a_of_type_Arpr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<andx> jdField_a_of_type_JavaUtilList;
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    ajzo localajzo;
    do
    {
      return false;
      localajzo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    return localajzo.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Arpp != null) {
      return this.jdField_a_of_type_Arpp.a();
    }
    return -1;
  }
  
  public void a()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_Arpp != null)
    {
      a(true);
      this.jdField_a_of_type_Arpp.a();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt);
    if (this.jdField_a_of_type_Arpp != null) {
      this.jdField_a_of_type_Arpp.a(paramInt);
    }
  }
  
  public void a(arpr paramarpr)
  {
    this.jdField_a_of_type_Arpr = paramarpr;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramarpr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramarpr.jdField_a_of_type_JavaUtilList;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + andx.a(this.jdField_a_of_type_JavaUtilList));
    Object localObject;
    if (this.jdField_a_of_type_Arpp == null)
    {
      boolean bool = a();
      if (bool)
      {
        localObject = new arpx();
        this.jdField_a_of_type_Arpp = ((arpp)localObject);
        QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arpp.a(paramarpr);
      return;
      localObject = new arpu();
      break;
      a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Arpp != null) {
      this.jdField_a_of_type_Arpp.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Arpp != null)
    {
      boolean bool1 = a();
      boolean bool2 = this.jdField_a_of_type_Arpp instanceof arpx;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_Arpp.d();
        if (!bool1) {
          break label100;
        }
      }
    }
    label100:
    for (Object localObject = new arpx();; localObject = new arpu())
    {
      this.jdField_a_of_type_Arpp = ((arpp)localObject);
      if (paramBoolean) {
        this.jdField_a_of_type_Arpp.a(this.jdField_a_of_type_Arpr);
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + andx.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Arpp != null) {
      this.jdField_a_of_type_Arpp.c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_Arpp != null) {
      this.jdField_a_of_type_Arpp.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arpq
 * JD-Core Version:    0.7.0.1
 */