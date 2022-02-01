import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.lang.ref.WeakReference;

public class bpue
{
  private static bpue jdField_a_of_type_Bpue;
  private WeakReference<DoodleLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<DoodleLayout> b;
  
  public static bpue a()
  {
    if (jdField_a_of_type_Bpue == null) {
      jdField_a_of_type_Bpue = new bpue();
    }
    return jdField_a_of_type_Bpue;
  }
  
  public DoodleLayout a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          localObject1 = (DoodleLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        }
      }
    }
    for (;;)
    {
      if ((localObject1 == null) && (QLog.isColorLevel())) {
        QLog.e("DoodleLayoutConnector", 2, "getDoodleLayout null, not init yet");
      }
      return localObject1;
      localObject1 = localObject2;
      if (this.b != null)
      {
        localObject1 = localObject2;
        if (this.b.get() != null) {
          localObject1 = (DoodleLayout)this.b.get();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayoutConnector", 2, "unbind " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.b = null;
  }
  
  public void a(int paramInt, DoodleLayout paramDoodleLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayoutConnector", 2, "bind " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDoodleLayout);
      return;
    }
    this.b = new WeakReference(paramDoodleLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpue
 * JD-Core Version:    0.7.0.1
 */