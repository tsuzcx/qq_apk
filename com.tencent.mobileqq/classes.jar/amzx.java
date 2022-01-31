import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.CameraRoamingStrategy.3;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amzx
  extends amzw
{
  ajfh jdField_a_of_type_Ajfh = new anaa(this);
  private anbo jdField_a_of_type_Anbo;
  private List<anhh> b = new ArrayList();
  private volatile boolean c;
  
  public amzx(QQAppInterface paramQQAppInterface, anao paramanao)
  {
    super(paramQQAppInterface, paramanao);
  }
  
  private List<? extends anht> a()
  {
    return this.b;
  }
  
  private void h()
  {
    this.jdField_a_of_type_Anao.c.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Anao.b.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = aciy.a(16.0F, this.jdField_a_of_type_Anao.b.getContext().getResources());
  }
  
  private void i()
  {
    a(new amzy(this));
  }
  
  public anae<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_Anbo == null) {
      this.jdField_a_of_type_Anbo = ((anbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    return this.jdField_a_of_type_Anbo;
  }
  
  public String a(anht paramanht)
  {
    if ((paramanht instanceof anhh))
    {
      String str = ((anhh)paramanht).jdField_a_of_type_JavaLangString;
      paramanht = str;
      if (TextUtils.isEmpty(str)) {
        paramanht = "";
      }
      return String.format(BaseApplicationImpl.getApplication().getString(2131626410), new Object[] { paramanht });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajfh);
    this.jdField_a_of_type_Anao.b(2131626409);
    this.c = false;
    if (this.jdField_a_of_type_Anbo == null) {
      this.jdField_a_of_type_Anbo = ((anbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    h();
    i();
  }
  
  public void a(anaf paramanaf)
  {
    a().a(new amzz(this, paramanaf));
  }
  
  public void a(GridView paramGridView, int paramInt, ankr paramankr)
  {
    Object localObject = ((anbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
    int i = paramankr.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
      if (localCameraEmotionData.emoId == i)
      {
        QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
        localCameraEmotionData.RomaingType = "needUpload";
        ((anhh)paramankr).jdField_g_of_type_JavaLangString = "needUpload";
        if (this.jdField_a_of_type_Anao != null) {
          this.jdField_a_of_type_Anao.a(paramGridView, paramInt);
        }
        com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
        ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
      }
    }
  }
  
  public void a(List<anht> paramList)
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
      anht localanht = (anht)paramList.next();
      if ((localanht instanceof anhh))
      {
        ((anhh)localanht).jdField_a_of_type_Boolean = false;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          anhh localanhh = (anhh)localIterator.next();
          if (((anhh)localanht).jdField_g_of_type_Int == localanhh.jdField_g_of_type_Int) {
            ((anhh)localanht).jdField_a_of_type_Boolean = localanhh.jdField_a_of_type_Boolean;
          }
        }
        localArrayList.add((anhh)localanht);
      }
    }
    this.b = localArrayList;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajfh);
    this.c = false;
  }
  
  public void e()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
  }
  
  public void g()
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
        Object localObject2 = (anht)((Iterator)localObject1).next();
        if ((localObject2 instanceof anhh))
        {
          localObject2 = (anhh)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((anhh)localObject2).jdField_g_of_type_Int == localCameraEmotionData.emoId) && (((anhh)localObject2).jdField_a_of_type_Boolean))
            {
              ((anhh)localObject2).jdField_a_of_type_Boolean = false;
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
 * Qualified Name:     amzx
 * JD-Core Version:    0.7.0.1
 */