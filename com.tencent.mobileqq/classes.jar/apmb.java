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

public class apmb
  extends apma
{
  alpj jdField_a_of_type_Alpj = new apme(this);
  private apnv jdField_a_of_type_Apnv;
  private List<aptr> b = new ArrayList();
  private volatile boolean c;
  
  public apmb(QQAppInterface paramQQAppInterface, apmt paramapmt)
  {
    super(paramQQAppInterface, paramapmt);
  }
  
  private List<? extends apuf> a()
  {
    return this.b;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Apmt.c.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Apmt.b.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = aepi.a(16.0F, this.jdField_a_of_type_Apmt.b.getContext().getResources());
  }
  
  private void j()
  {
    a(new apmc(this));
  }
  
  public int a()
  {
    return 2131692051;
  }
  
  public apmi<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_Apnv == null) {
      this.jdField_a_of_type_Apnv = ((apnv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    return this.jdField_a_of_type_Apnv;
  }
  
  public String a(apuf paramapuf)
  {
    if ((paramapuf instanceof aptr))
    {
      String str = ((aptr)paramapuf).jdField_a_of_type_JavaLangString;
      paramapuf = str;
      if (TextUtils.isEmpty(str)) {
        paramapuf = "";
      }
      return String.format(BaseApplicationImpl.getApplication().getString(2131692050), new Object[] { paramapuf });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alpj);
    this.jdField_a_of_type_Apmt.a(2131692049);
    this.c = false;
    if (this.jdField_a_of_type_Apnv == null) {
      this.jdField_a_of_type_Apnv = ((apnv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    i();
    j();
  }
  
  public void a(apmj paramapmj)
  {
    a().a(new apmd(this, paramapmj));
  }
  
  public void a(GridView paramGridView, int paramInt, apxm paramapxm)
  {
    Object localObject = ((apnv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
    int i = paramapxm.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == i)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((aptr)paramapxm).h = "needUpload";
        if (this.jdField_a_of_type_Apmt != null) {
          this.jdField_a_of_type_Apmt.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void a(List<apuf> paramList)
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
      apuf localapuf = (apuf)paramList.next();
      if ((localapuf instanceof aptr))
      {
        ((aptr)localapuf).jdField_a_of_type_Boolean = false;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          aptr localaptr = (aptr)localIterator.next();
          if (((aptr)localapuf).g == localaptr.g) {
            ((aptr)localapuf).jdField_a_of_type_Boolean = localaptr.jdField_a_of_type_Boolean;
          }
        }
        localArrayList.add((aptr)localapuf);
      }
    }
    this.b = localArrayList;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpj);
    this.c = false;
  }
  
  public void e()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
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
        Object localObject2 = (apuf)((Iterator)localObject1).next();
        if ((localObject2 instanceof aptr))
        {
          localObject2 = (aptr)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((aptr)localObject2).g == localCameraEmotionData.emoId) && (((aptr)localObject2).jdField_a_of_type_Boolean))
            {
              ((aptr)localObject2).jdField_a_of_type_Boolean = false;
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
 * Qualified Name:     apmb
 * JD-Core Version:    0.7.0.1
 */