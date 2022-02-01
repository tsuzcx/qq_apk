import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.view.ProviderContainerView;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditPicMeiHua.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bnco
  extends bnec
  implements bmyw
{
  private static List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ProviderContainerView jdField_a_of_type_DovComQqImCaptureViewProviderContainerView;
  
  public bnco(@NonNull bnee parambnee)
  {
    super(parambnee);
  }
  
  public static void a(int paramInt)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilList.isEmpty())
      {
        if (bnee.a(paramInt, 8)) {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(101));
        }
        if ((bnee.a(paramInt, 64)) && (Build.VERSION.SDK_INT >= 21)) {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(100));
        }
        if (bnee.a(paramInt, 2048)) {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(102));
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(int paramInt)
  {
    a(paramInt);
    return (bnee.a(paramInt, 131072)) && (!jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Bnee.b()) {
      return 3;
    }
    return 1;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView = ((ProviderContainerView)a(2131373067));
    if (jdField_a_of_type_JavaUtilList.isEmpty()) {
      a(this.jdField_a_of_type_Bnee.a.c);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.a(a(), jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.setProviderContainViewListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.setEditActivityEntrance(this.jdField_a_of_type_Bnee.a.c());
  }
  
  public void a(int paramInt, @NonNull bnot parambnot)
  {
    super.a(paramInt, parambnot);
    if ((QIMFilterProviderView)this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.a(QIMFilterProviderView.class) != null) {
      if (bnub.a().b(a()) == null) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      parambnot.c = bool;
      if ((parambnot.c) && (this.jdField_a_of_type_Bnee.a()))
      {
        parambnot = parambnot.a;
        parambnot.a += 1;
      }
      return;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.setVisibility(4);
    case 22: 
    case 21: 
      do
      {
        return;
        this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.setVisibility(0);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.a(0);
      } while (!this.jdField_a_of_type_Bnee.a());
      bbpr.a("0X800B3CB", this.jdField_a_of_type_Bnee.a.c());
      bbpr.a("0X800B3CC", this.jdField_a_of_type_Bnee.a.c());
      this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.b(101);
      return;
    }
    ThreadManager.getUIHandler().post(new EditPicMeiHua.1(this));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bnee.a(10, Boolean.valueOf(true));
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnco
 * JD-Core Version:    0.7.0.1
 */