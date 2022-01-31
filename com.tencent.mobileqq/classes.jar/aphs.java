import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.CameraRoamingStrategy.3;
import com.tencent.mobileqq.emosm.CameraRoamingStrategy.5;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aphs
  extends aphr
{
  alku jdField_a_of_type_Alku = new aphv(this);
  private apjm jdField_a_of_type_Apjm;
  private List<appi> b = new ArrayList();
  private volatile boolean c;
  
  public aphs(QQAppInterface paramQQAppInterface, apik paramapik)
  {
    super(paramQQAppInterface, paramapik);
  }
  
  private List<? extends appw> a()
  {
    return this.b;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Apik.c.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Apik.b.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = aekt.a(16.0F, this.jdField_a_of_type_Apik.b.getContext().getResources());
  }
  
  private void j()
  {
    a(new apht(this));
  }
  
  public int a()
  {
    return 2131692050;
  }
  
  public aphz<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_Apjm == null) {
      this.jdField_a_of_type_Apjm = ((apjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    return this.jdField_a_of_type_Apjm;
  }
  
  public String a(appw paramappw)
  {
    if ((paramappw instanceof appi))
    {
      String str = ((appi)paramappw).jdField_a_of_type_JavaLangString;
      paramappw = str;
      if (TextUtils.isEmpty(str)) {
        paramappw = "";
      }
      return String.format(BaseApplicationImpl.getApplication().getString(2131692049), new Object[] { paramappw });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alku);
    this.jdField_a_of_type_Apik.a(2131692048);
    this.c = false;
    if (this.jdField_a_of_type_Apjm == null) {
      this.jdField_a_of_type_Apjm = ((apjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    i();
    j();
  }
  
  public void a(apia paramapia)
  {
    a().a(new aphu(this, paramapia));
  }
  
  public void a(GridView paramGridView, int paramInt, aptd paramaptd)
  {
    Object localObject = ((apjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
    int i = paramaptd.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == i)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((appi)paramaptd).h = "needUpload";
        if (this.jdField_a_of_type_Apik != null) {
          this.jdField_a_of_type_Apik.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void a(List<appw> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.b.clear();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      appw localappw = (appw)paramList.next();
      if ((localappw instanceof appi))
      {
        ((appi)localappw).jdField_a_of_type_Boolean = false;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          appi localappi = (appi)localIterator.next();
          if (((appi)localappw).g == localappi.g) {
            ((appi)localappw).jdField_a_of_type_Boolean = localappi.jdField_a_of_type_Boolean;
          }
        }
        localArrayList.add((appi)localappw);
      }
    }
    this.b = localArrayList;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alku);
    this.c = false;
  }
  
  public void e()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraRoamingStrategy", 2, "doSyncEmotion");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ThreadManager.excute(new CameraRoamingStrategy.5(this), 128, null, false);
  }
  
  public void h()
  {
    if (this.c)
    {
      QLog.e("CameraRoamingStrategy", 1, "doDelEmotion,  camera data deleting");
      return;
    }
    this.c = true;
    ArrayList localArrayList = new ArrayList();
    List localList = a().a();
    Object localObject1 = a();
    if (localList != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (appw)((Iterator)localObject1).next();
        if ((localObject2 instanceof appi))
        {
          localObject2 = (appi)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((appi)localObject2).g == localCameraEmotionData.emoId) && (((appi)localObject2).jdField_a_of_type_Boolean))
            {
              ((appi)localObject2).jdField_a_of_type_Boolean = false;
              localArrayList.add(localCameraEmotionData);
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.post(new CameraRoamingStrategy.3(this, localArrayList), 5, null, false);
      return;
    }
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphs
 * JD-Core Version:    0.7.0.1
 */