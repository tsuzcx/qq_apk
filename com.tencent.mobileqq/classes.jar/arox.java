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

public class arox
  extends arow
{
  anio jdField_a_of_type_Anio = new arpa(this);
  private arqr jdField_a_of_type_Arqr;
  private List<arws> b = new ArrayList();
  private volatile boolean c;
  
  public arox(QQAppInterface paramQQAppInterface, arpp paramarpp)
  {
    super(paramQQAppInterface, paramarpp);
  }
  
  private List<? extends arxg> a()
  {
    return this.b;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Arpp.c.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Arpp.b.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = afur.a(16.0F, this.jdField_a_of_type_Arpp.b.getContext().getResources());
  }
  
  private void j()
  {
    a(new aroy(this));
  }
  
  public int a()
  {
    return 2131691706;
  }
  
  public arpe<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_Arqr == null) {
      this.jdField_a_of_type_Arqr = ((arqr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    return this.jdField_a_of_type_Arqr;
  }
  
  public String a(arxg paramarxg)
  {
    if ((paramarxg instanceof arws))
    {
      String str = ((arws)paramarxg).jdField_a_of_type_JavaLangString;
      paramarxg = str;
      if (TextUtils.isEmpty(str)) {
        paramarxg = "";
      }
      return String.format(BaseApplicationImpl.getApplication().getString(2131691705), new Object[] { paramarxg });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anio);
    this.jdField_a_of_type_Arpp.b(2131691704);
    this.c = false;
    if (this.jdField_a_of_type_Arqr == null) {
      this.jdField_a_of_type_Arqr = ((arqr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    i();
    j();
  }
  
  public void a(arpf paramarpf)
  {
    a().a(new aroz(this, paramarpf));
  }
  
  public void a(GridView paramGridView, int paramInt, asbh paramasbh)
  {
    Object localObject = ((arqr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
    int i = paramasbh.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == i)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((arws)paramasbh).h = "needUpload";
        if (this.jdField_a_of_type_Arpp != null) {
          this.jdField_a_of_type_Arpp.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void a(List<arxg> paramList)
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
      arxg localarxg = (arxg)paramList.next();
      if ((localarxg instanceof arws))
      {
        ((arws)localarxg).jdField_a_of_type_Boolean = false;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          arws localarws = (arws)localIterator.next();
          if (((arws)localarxg).g == localarws.g) {
            ((arws)localarxg).jdField_a_of_type_Boolean = localarws.jdField_a_of_type_Boolean;
          }
        }
        localArrayList.add((arws)localarxg);
      }
    }
    this.b = localArrayList;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anio);
    this.c = false;
  }
  
  public void e()
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
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
        Object localObject2 = (arxg)((Iterator)localObject1).next();
        if ((localObject2 instanceof arws))
        {
          localObject2 = (arws)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((arws)localObject2).g == localCameraEmotionData.emoId) && (((arws)localObject2).jdField_a_of_type_Boolean))
            {
              ((arws)localObject2).jdField_a_of_type_Boolean = false;
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
 * Qualified Name:     arox
 * JD-Core Version:    0.7.0.1
 */