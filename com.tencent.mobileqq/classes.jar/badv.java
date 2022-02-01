import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.widget.PullToZoomHeaderListView;

public class badv
  extends badc<FrameLayout>
{
  private long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bade jdField_a_of_type_Bade;
  private badl jdField_a_of_type_Badl;
  private bjaz jdField_a_of_type_Bjaz;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private long b;
  
  public badv(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bade != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "destroyHeaderComponent");
      }
      b(this.jdField_a_of_type_Bade);
      this.jdField_a_of_type_Bade.h();
      this.jdField_a_of_type_Bade = null;
      this.jdField_a_of_type_Long = 0L;
      this.b = 0L;
    }
  }
  
  private void a(azxr paramazxr)
  {
    if (this.jdField_a_of_type_Bade == null)
    {
      bade localbade = (bade)baeg.a(1002, this.jdField_a_of_type_Baei, paramazxr);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, String.format("initHeaderComponent headerComponent=%s", new Object[] { localbade }));
      }
      if ((localbade instanceof badm)) {
        ((badm)localbade).a(this.jdField_a_of_type_Bjaz, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
      }
      localbade.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Bade = localbade;
      this.jdField_a_of_type_Bade.a(this.jdField_a_of_type_Badl);
      this.jdField_a_of_type_Bade.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Bade.g();
      a(this.jdField_a_of_type_Bade);
      this.jdField_a_of_type_Long = paramazxr.jdField_a_of_type_Long;
      this.b = paramazxr.b;
    }
  }
  
  private void b(azxr paramazxr)
  {
    if (paramazxr.jdField_a_of_type_Long != azxy.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileHeaderContainer", 0, "resetHeaderComponent");
      }
      paramazxr.jdField_a_of_type_Long = azxy.jdField_a_of_type_Long;
      paramazxr.b = 0L;
      paramazxr.jdField_a_of_type_Azxy = null;
      a(paramazxr);
    }
  }
  
  private boolean b(azxr paramazxr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramazxr != null) {
      if ((this.jdField_a_of_type_Bade != null) && (this.jdField_a_of_type_Long == paramazxr.jdField_a_of_type_Long))
      {
        bool1 = bool2;
        if (this.b == paramazxr.b) {}
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
  
  public bade a()
  {
    return this.jdField_a_of_type_Bade;
  }
  
  public String a()
  {
    return "ProfileHeaderContainer";
  }
  
  public void a(badl parambadl)
  {
    this.jdField_a_of_type_Badl = parambadl;
  }
  
  public void a(bjaz parambjaz, PullToZoomHeaderListView paramPullToZoomHeaderListView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Bjaz = parambjaz;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public boolean a(azxr paramazxr)
  {
    int i = 1;
    if (b(paramazxr)) {
      a();
    }
    for (;;)
    {
      try
      {
        a(paramazxr);
        return i | super.a(paramazxr);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileHeaderContainer", 1, "onDataUpdate init header component fail, reset to default.", localException);
        a();
        b(paramazxr);
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
 * Qualified Name:     badv
 * JD-Core Version:    0.7.0.1
 */