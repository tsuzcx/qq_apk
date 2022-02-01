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

public class asel
  extends asek
{
  anul jdField_a_of_type_Anul = new aseo(this);
  private asgf jdField_a_of_type_Asgf;
  private List<asmg> b = new ArrayList();
  private volatile boolean c;
  
  public asel(QQAppInterface paramQQAppInterface, asfd paramasfd)
  {
    super(paramQQAppInterface, paramasfd);
  }
  
  private List<? extends asmu> a()
  {
    return this.b;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Asfd.c.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Asfd.b.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = agej.a(16.0F, this.jdField_a_of_type_Asfd.b.getContext().getResources());
  }
  
  private void j()
  {
    a(new asem(this));
  }
  
  public int a()
  {
    return 2131691709;
  }
  
  public ases<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_Asgf == null) {
      this.jdField_a_of_type_Asgf = ((asgf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    return this.jdField_a_of_type_Asgf;
  }
  
  public String a(asmu paramasmu)
  {
    if ((paramasmu instanceof asmg))
    {
      String str = ((asmg)paramasmu).jdField_a_of_type_JavaLangString;
      paramasmu = str;
      if (TextUtils.isEmpty(str)) {
        paramasmu = "";
      }
      return String.format(BaseApplicationImpl.getApplication().getString(2131691708), new Object[] { paramasmu });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anul);
    this.jdField_a_of_type_Asfd.b(2131691707);
    this.c = false;
    if (this.jdField_a_of_type_Asgf == null) {
      this.jdField_a_of_type_Asgf = ((asgf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    i();
    j();
  }
  
  public void a(aset paramaset)
  {
    a().a(new asen(this, paramaset));
  }
  
  public void a(GridView paramGridView, int paramInt, asqv paramasqv)
  {
    Object localObject = ((asgf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
    int i = paramasqv.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == i)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((asmg)paramasqv).h = "needUpload";
        if (this.jdField_a_of_type_Asfd != null) {
          this.jdField_a_of_type_Asfd.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void a(List<asmu> paramList)
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
      asmu localasmu = (asmu)paramList.next();
      if ((localasmu instanceof asmg))
      {
        ((asmg)localasmu).jdField_a_of_type_Boolean = false;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          asmg localasmg = (asmg)localIterator.next();
          if (((asmg)localasmu).g == localasmg.g) {
            ((asmg)localasmu).jdField_a_of_type_Boolean = localasmg.jdField_a_of_type_Boolean;
          }
        }
        localArrayList.add((asmg)localasmu);
      }
    }
    this.b = localArrayList;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anul);
    this.c = false;
  }
  
  public void e()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
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
        Object localObject2 = (asmu)((Iterator)localObject1).next();
        if ((localObject2 instanceof asmg))
        {
          localObject2 = (asmg)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((asmg)localObject2).g == localCameraEmotionData.emoId) && (((asmg)localObject2).jdField_a_of_type_Boolean))
            {
              ((asmg)localObject2).jdField_a_of_type_Boolean = false;
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
 * Qualified Name:     asel
 * JD-Core Version:    0.7.0.1
 */