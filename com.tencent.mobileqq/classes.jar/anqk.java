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

public class anqk
  extends anqj
{
  ajth jdField_a_of_type_Ajth = new anqn(this);
  private anse jdField_a_of_type_Anse;
  private List<anxv> b = new ArrayList();
  private volatile boolean c;
  
  public anqk(QQAppInterface paramQQAppInterface, anrc paramanrc)
  {
    super(paramQQAppInterface, paramanrc);
  }
  
  private List<? extends anyh> a()
  {
    return this.b;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Anrc.c.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Anrc.b.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = actj.a(16.0F, this.jdField_a_of_type_Anrc.b.getContext().getResources());
  }
  
  private void j()
  {
    a(new anql(this));
  }
  
  public int a()
  {
    return 2131691995;
  }
  
  public anqr<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_Anse == null) {
      this.jdField_a_of_type_Anse = ((anse)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    return this.jdField_a_of_type_Anse;
  }
  
  public String a(anyh paramanyh)
  {
    if ((paramanyh instanceof anxv))
    {
      String str = ((anxv)paramanyh).jdField_a_of_type_JavaLangString;
      paramanyh = str;
      if (TextUtils.isEmpty(str)) {
        paramanyh = "";
      }
      return String.format(BaseApplicationImpl.getApplication().getString(2131691994), new Object[] { paramanyh });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajth);
    this.jdField_a_of_type_Anrc.b(2131691993);
    this.c = false;
    if (this.jdField_a_of_type_Anse == null) {
      this.jdField_a_of_type_Anse = ((anse)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    i();
    j();
  }
  
  public void a(anqs paramanqs)
  {
    a().a(new anqm(this, paramanqs));
  }
  
  public void a(GridView paramGridView, int paramInt, aobg paramaobg)
  {
    Object localObject = ((anse)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
    int i = paramaobg.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == i)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((anxv)paramaobg).jdField_g_of_type_JavaLangString = "needUpload";
        if (this.jdField_a_of_type_Anrc != null) {
          this.jdField_a_of_type_Anrc.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void a(List<anyh> paramList)
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
      anyh localanyh = (anyh)paramList.next();
      if ((localanyh instanceof anxv))
      {
        ((anxv)localanyh).jdField_a_of_type_Boolean = false;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          anxv localanxv = (anxv)localIterator.next();
          if (((anxv)localanyh).jdField_g_of_type_Int == localanxv.jdField_g_of_type_Int) {
            ((anxv)localanyh).jdField_a_of_type_Boolean = localanxv.jdField_a_of_type_Boolean;
          }
        }
        localArrayList.add((anxv)localanyh);
      }
    }
    this.b = localArrayList;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajth);
    this.c = false;
  }
  
  public void e()
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
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
        Object localObject2 = (anyh)((Iterator)localObject1).next();
        if ((localObject2 instanceof anxv))
        {
          localObject2 = (anxv)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((anxv)localObject2).jdField_g_of_type_Int == localCameraEmotionData.emoId) && (((anxv)localObject2).jdField_a_of_type_Boolean))
            {
              ((anxv)localObject2).jdField_a_of_type_Boolean = false;
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
 * Qualified Name:     anqk
 * JD-Core Version:    0.7.0.1
 */