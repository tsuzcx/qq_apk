import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import java.util.List;

public class arps
{
  private arpr jdField_a_of_type_Arpr;
  private arpt jdField_a_of_type_Arpt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<anec> jdField_a_of_type_JavaUtilList;
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    ajzm localajzm;
    do
    {
      return false;
      localajzm = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    return localajzm.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Arpr != null) {
      return this.jdField_a_of_type_Arpr.a();
    }
    return -1;
  }
  
  public void a()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_Arpr != null)
    {
      a(true);
      this.jdField_a_of_type_Arpr.a();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt);
    if (this.jdField_a_of_type_Arpr != null) {
      this.jdField_a_of_type_Arpr.a(paramInt);
    }
  }
  
  public void a(arpt paramarpt)
  {
    this.jdField_a_of_type_Arpt = paramarpt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramarpt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramarpt.jdField_a_of_type_JavaUtilList;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + anec.a(this.jdField_a_of_type_JavaUtilList));
    Object localObject;
    if (this.jdField_a_of_type_Arpr == null)
    {
      boolean bool = a();
      if (bool)
      {
        localObject = new arpz();
        this.jdField_a_of_type_Arpr = ((arpr)localObject);
        QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arpr.a(paramarpt);
      return;
      localObject = new arpw();
      break;
      a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Arpr != null) {
      this.jdField_a_of_type_Arpr.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Arpr != null)
    {
      boolean bool1 = a();
      boolean bool2 = this.jdField_a_of_type_Arpr instanceof arpz;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_Arpr.d();
        if (!bool1) {
          break label100;
        }
      }
    }
    label100:
    for (Object localObject = new arpz();; localObject = new arpw())
    {
      this.jdField_a_of_type_Arpr = ((arpr)localObject);
      if (paramBoolean) {
        this.jdField_a_of_type_Arpr.a(this.jdField_a_of_type_Arpt);
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + anec.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_Arpr != null) {
      this.jdField_a_of_type_Arpr.c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_Arpr != null) {
      this.jdField_a_of_type_Arpr.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arps
 * JD-Core Version:    0.7.0.1
 */