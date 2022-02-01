import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.widget.PullToZoomHeaderListView;

public class azxg
  extends azwn<FrameLayout>
{
  private long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private azwp jdField_a_of_type_Azwp;
  private azww jdField_a_of_type_Azww;
  private birs jdField_a_of_type_Birs;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private long b;
  
  public azxg(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Azwp != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "destroyHeaderComponent");
      }
      b(this.jdField_a_of_type_Azwp);
      this.jdField_a_of_type_Azwp.h();
      this.jdField_a_of_type_Azwp = null;
      this.jdField_a_of_type_Long = 0L;
      this.b = 0L;
    }
  }
  
  private void a(azrb paramazrb)
  {
    if (this.jdField_a_of_type_Azwp == null)
    {
      azwp localazwp = (azwp)azxr.a(1002, this.jdField_a_of_type_Azxt, paramazrb);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, String.format("initHeaderComponent headerComponent=%s", new Object[] { localazwp }));
      }
      if ((localazwp instanceof azwx)) {
        ((azwx)localazwp).a(this.jdField_a_of_type_Birs, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
      }
      localazwp.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Azwp = localazwp;
      this.jdField_a_of_type_Azwp.a(this.jdField_a_of_type_Azww);
      this.jdField_a_of_type_Azwp.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Azwp.g();
      a(this.jdField_a_of_type_Azwp);
      this.jdField_a_of_type_Long = paramazrb.jdField_a_of_type_Long;
      this.b = paramazrb.b;
    }
  }
  
  private void b(azrb paramazrb)
  {
    if (paramazrb.jdField_a_of_type_Long != azri.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "resetHeaderComponent");
      }
      paramazrb.jdField_a_of_type_Long = azri.jdField_a_of_type_Long;
      paramazrb.b = 0L;
      paramazrb.jdField_a_of_type_Azri = null;
      a(paramazrb);
    }
  }
  
  private boolean b(azrb paramazrb)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramazrb != null) {
      if ((this.jdField_a_of_type_Azwp != null) && (this.jdField_a_of_type_Long == paramazrb.jdField_a_of_type_Long))
      {
        bool1 = bool2;
        if (this.b == paramazrb.b) {}
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
  
  public azwp a()
  {
    return this.jdField_a_of_type_Azwp;
  }
  
  public String a()
  {
    return "ProfileHeaderContainer";
  }
  
  public void a(azww paramazww)
  {
    this.jdField_a_of_type_Azww = paramazww;
  }
  
  public void a(birs parambirs, PullToZoomHeaderListView paramPullToZoomHeaderListView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Birs = parambirs;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public boolean a(azrb paramazrb)
  {
    int i = 1;
    if (b(paramazrb)) {
      a();
    }
    for (;;)
    {
      try
      {
        a(paramazrb);
        return i | super.a(paramazrb);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileHeaderContainer", 1, "onDataUpdate init header component fail, reset to default.", localException);
        a();
        b(paramazrb);
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
 * Qualified Name:     azxg
 * JD-Core Version:    0.7.0.1
 */