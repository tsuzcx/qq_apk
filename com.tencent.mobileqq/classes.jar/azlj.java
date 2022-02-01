import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.widget.PullToZoomHeaderListView;

public class azlj
  extends azkq<FrameLayout>
{
  private long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private azks jdField_a_of_type_Azks;
  private azkz jdField_a_of_type_Azkz;
  private biab jdField_a_of_type_Biab;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private long b;
  
  public azlj(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Azks != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "destroyHeaderComponent");
      }
      b(this.jdField_a_of_type_Azks);
      this.jdField_a_of_type_Azks.h();
      this.jdField_a_of_type_Azks = null;
      this.jdField_a_of_type_Long = 0L;
      this.b = 0L;
    }
  }
  
  private void a(azfe paramazfe)
  {
    if (this.jdField_a_of_type_Azks == null)
    {
      azks localazks = (azks)azlu.a(1002, this.jdField_a_of_type_Azlw, paramazfe);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, String.format("initHeaderComponent headerComponent=%s", new Object[] { localazks }));
      }
      if ((localazks instanceof azla)) {
        ((azla)localazks).a(this.jdField_a_of_type_Biab, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
      }
      localazks.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Azks = localazks;
      this.jdField_a_of_type_Azks.a(this.jdField_a_of_type_Azkz);
      this.jdField_a_of_type_Azks.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Azks.g();
      a(this.jdField_a_of_type_Azks);
      this.jdField_a_of_type_Long = paramazfe.jdField_a_of_type_Long;
      this.b = paramazfe.b;
    }
  }
  
  private void b(azfe paramazfe)
  {
    if (paramazfe.jdField_a_of_type_Long != azfl.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "resetHeaderComponent");
      }
      paramazfe.jdField_a_of_type_Long = azfl.jdField_a_of_type_Long;
      paramazfe.b = 0L;
      paramazfe.jdField_a_of_type_Azfl = null;
      a(paramazfe);
    }
  }
  
  private boolean b(azfe paramazfe)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramazfe != null) {
      if ((this.jdField_a_of_type_Azks != null) && (this.jdField_a_of_type_Long == paramazfe.jdField_a_of_type_Long))
      {
        bool1 = bool2;
        if (this.b == paramazfe.b) {}
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
  
  public azks a()
  {
    return this.jdField_a_of_type_Azks;
  }
  
  public String a()
  {
    return "ProfileHeaderContainer";
  }
  
  public void a(azkz paramazkz)
  {
    this.jdField_a_of_type_Azkz = paramazkz;
  }
  
  public void a(biab parambiab, PullToZoomHeaderListView paramPullToZoomHeaderListView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Biab = parambiab;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public boolean a(azfe paramazfe)
  {
    int i = 1;
    if (b(paramazfe)) {
      a();
    }
    for (;;)
    {
      try
      {
        a(paramazfe);
        return i | super.a(paramazfe);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileHeaderContainer", 1, "onDataUpdate init header component fail, reset to default.", localException);
        a();
        b(paramazfe);
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
 * Qualified Name:     azlj
 * JD-Core Version:    0.7.0.1
 */