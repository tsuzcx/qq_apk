import android.text.TextUtils;
import com.tencent.aekit.openrender.util.AEProfilerBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.List;

public class biwt
  extends AEProfilerBase
  implements biwx
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "none";
  private List<Float> jdField_a_of_type_JavaUtilList = new ArrayList();
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public biwt()
  {
    jdField_a_of_type_Boolean = false;
    this.mEnableBase = true;
  }
  
  private float a()
  {
    a("getAverageFps: fps list size=" + this.jdField_a_of_type_JavaUtilList.size());
    float f = 0.0F;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      f += ((Float)this.jdField_a_of_type_JavaUtilList.get(i)).floatValue();
      i += 1;
    }
    return f / this.jdField_a_of_type_JavaUtilList.size();
  }
  
  private void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {
      QLog.i("AEFpsManager", 2, "report fps: " + paramString);
    }
  }
  
  private void i()
  {
    a("startMonitor");
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void j()
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.c)) {}
    do
    {
      do
      {
        return;
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 5000L);
      if (this.jdField_a_of_type_Int >= 30)
      {
        if (this.jdField_b_of_type_Long > 0L)
        {
          float f = this.jdField_a_of_type_Int * 1000.0F / (float)this.jdField_b_of_type_Long;
          if (this.jdField_a_of_type_JavaUtilList.size() >= 500) {
            this.jdField_a_of_type_JavaUtilList.remove(0);
          }
          this.jdField_a_of_type_JavaUtilList.add(Float.valueOf(f));
        }
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Long = 0L;
        return;
      }
    } while (this.mOneFrameCost == 0L);
    this.jdField_b_of_type_Long += this.mOneFrameCost;
    this.jdField_a_of_type_Int += 1;
  }
  
  private void k()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    float f = a();
    bizt localbizt = bizt.a();
    String str = this.jdField_a_of_type_JavaLangString;
    if (ahty.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      localbizt.a(str, bool, f, 0.0D, 0.0D, "");
      a("fps=" + f);
      return;
      bool = false;
    }
  }
  
  public void a()
  {
    a("stopMonitor");
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    a("onMaterialSelected, useMaterial=" + paramVideoMaterial);
    if ((paramVideoMaterial == null) || (TextUtils.isEmpty(paramVideoMaterial.getId()))) {}
    for (this.jdField_a_of_type_JavaLangString = "none";; this.jdField_a_of_type_JavaLangString = paramVideoMaterial.getId())
    {
      a();
      i();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a("onCameraSwitch");
    k();
    a();
    i();
  }
  
  public void b()
  {
    a("onCameraOpened");
  }
  
  public void b(boolean paramBoolean)
  {
    a("onModeChangedToGif");
    this.c = paramBoolean;
    if (paramBoolean) {
      a();
    }
  }
  
  public void c()
  {
    a("onFirstFrame");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    i();
  }
  
  public void d()
  {
    j();
  }
  
  public void e()
  {
    a("onCapturePicture");
    k();
    a();
  }
  
  public void f()
  {
    a("onCaptureVideo");
    k();
    a();
  }
  
  public void g()
  {
    a("onEnterActivity");
  }
  
  public void h()
  {
    a("onExitActivity");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwt
 * JD-Core Version:    0.7.0.1
 */