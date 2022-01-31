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

public class anqf
  extends anqe
{
  ajtj jdField_a_of_type_Ajtj = new anqi(this);
  private anrz jdField_a_of_type_Anrz;
  private List<anxq> b = new ArrayList();
  private volatile boolean c;
  
  public anqf(QQAppInterface paramQQAppInterface, anqx paramanqx)
  {
    super(paramQQAppInterface, paramanqx);
  }
  
  private List<? extends anyc> a()
  {
    return this.b;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Anqx.c.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Anqx.b.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = actn.a(16.0F, this.jdField_a_of_type_Anqx.b.getContext().getResources());
  }
  
  private void j()
  {
    a(new anqg(this));
  }
  
  public int a()
  {
    return 2131691995;
  }
  
  public anqm<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_Anrz == null) {
      this.jdField_a_of_type_Anrz = ((anrz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    return this.jdField_a_of_type_Anrz;
  }
  
  public String a(anyc paramanyc)
  {
    if ((paramanyc instanceof anxq))
    {
      String str = ((anxq)paramanyc).jdField_a_of_type_JavaLangString;
      paramanyc = str;
      if (TextUtils.isEmpty(str)) {
        paramanyc = "";
      }
      return String.format(BaseApplicationImpl.getApplication().getString(2131691994), new Object[] { paramanyc });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajtj);
    this.jdField_a_of_type_Anqx.b(2131691993);
    this.c = false;
    if (this.jdField_a_of_type_Anrz == null) {
      this.jdField_a_of_type_Anrz = ((anrz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    i();
    j();
  }
  
  public void a(anqn paramanqn)
  {
    a().a(new anqh(this, paramanqn));
  }
  
  public void a(GridView paramGridView, int paramInt, aobb paramaobb)
  {
    Object localObject = ((anrz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
    int i = paramaobb.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == i)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((anxq)paramaobb).jdField_g_of_type_JavaLangString = "needUpload";
        if (this.jdField_a_of_type_Anqx != null) {
          this.jdField_a_of_type_Anqx.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void a(List<anyc> paramList)
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
      anyc localanyc = (anyc)paramList.next();
      if ((localanyc instanceof anxq))
      {
        ((anxq)localanyc).jdField_a_of_type_Boolean = false;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          anxq localanxq = (anxq)localIterator.next();
          if (((anxq)localanyc).jdField_g_of_type_Int == localanxq.jdField_g_of_type_Int) {
            ((anxq)localanyc).jdField_a_of_type_Boolean = localanxq.jdField_a_of_type_Boolean;
          }
        }
        localArrayList.add((anxq)localanyc);
      }
    }
    this.b = localArrayList;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajtj);
    this.c = false;
  }
  
  public void e()
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
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
        Object localObject2 = (anyc)((Iterator)localObject1).next();
        if ((localObject2 instanceof anxq))
        {
          localObject2 = (anxq)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((anxq)localObject2).jdField_g_of_type_Int == localCameraEmotionData.emoId) && (((anxq)localObject2).jdField_a_of_type_Boolean))
            {
              ((anxq)localObject2).jdField_a_of_type_Boolean = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anqf
 * JD-Core Version:    0.7.0.1
 */