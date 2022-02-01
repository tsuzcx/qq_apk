import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.widget.PullToZoomHeaderListView;

public class aysk
  extends ayrr<FrameLayout>
{
  private long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ayrt jdField_a_of_type_Ayrt;
  private aysa jdField_a_of_type_Aysa;
  private bhha jdField_a_of_type_Bhha;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private long b;
  
  public aysk(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Ayrt != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "destroyHeaderComponent");
      }
      b(this.jdField_a_of_type_Ayrt);
      this.jdField_a_of_type_Ayrt.h();
      this.jdField_a_of_type_Ayrt = null;
      this.jdField_a_of_type_Long = 0L;
      this.b = 0L;
    }
  }
  
  private void a(aymg paramaymg)
  {
    if (this.jdField_a_of_type_Ayrt == null)
    {
      ayrt localayrt = (ayrt)aysv.a(1002, this.jdField_a_of_type_Aysx, paramaymg);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, String.format("initHeaderComponent headerComponent=%s", new Object[] { localayrt }));
      }
      if ((localayrt instanceof aysb)) {
        ((aysb)localayrt).a(this.jdField_a_of_type_Bhha, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
      }
      localayrt.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Ayrt = localayrt;
      this.jdField_a_of_type_Ayrt.a(this.jdField_a_of_type_Aysa);
      this.jdField_a_of_type_Ayrt.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Ayrt.g();
      a(this.jdField_a_of_type_Ayrt);
      this.jdField_a_of_type_Long = paramaymg.jdField_a_of_type_Long;
      this.b = paramaymg.b;
    }
  }
  
  private void b(aymg paramaymg)
  {
    if (paramaymg.jdField_a_of_type_Long != aymn.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "resetHeaderComponent");
      }
      paramaymg.jdField_a_of_type_Long = aymn.jdField_a_of_type_Long;
      paramaymg.b = 0L;
      paramaymg.jdField_a_of_type_Aymn = null;
      a(paramaymg);
    }
  }
  
  private boolean b(aymg paramaymg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramaymg != null) {
      if ((this.jdField_a_of_type_Ayrt != null) && (this.jdField_a_of_type_Long == paramaymg.jdField_a_of_type_Long))
      {
        bool1 = bool2;
        if (this.b == paramaymg.b) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int a()
  {
    return 102;
  }
  
  public ayrt a()
  {
    return this.jdField_a_of_type_Ayrt;
  }
  
  public String a()
  {
    return "ProfileHeaderContainer";
  }
  
  public void a(aysa paramaysa)
  {
    this.jdField_a_of_type_Aysa = paramaysa;
  }
  
  public void a(bhha parambhha, PullToZoomHeaderListView paramPullToZoomHeaderListView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Bhha = parambhha;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public boolean a(aymg paramaymg)
  {
    int i = 1;
    if (b(paramaymg)) {
      a();
    }
    for (;;)
    {
      try
      {
        a(paramaymg);
        return i | super.a(paramaymg);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileHeaderContainer", 1, "onDataUpdate init header component fail, reset to default.", localException);
        a();
        b(paramaymg);
        continue;
      }
      i = 0;
    }
  }
  
  public void f()
  {
    a();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysk
 * JD-Core Version:    0.7.0.1
 */