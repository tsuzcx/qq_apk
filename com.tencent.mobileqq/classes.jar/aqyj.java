import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.CameraRoamingStrategy.3;
import com.tencent.mobileqq.emosm.CameraRoamingStrategy.5;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqyj
  extends aqyi
{
  amou jdField_a_of_type_Amou = new aqym(this);
  private arad jdField_a_of_type_Arad;
  private List<CameraEmoticonInfo> b = new ArrayList();
  private volatile boolean c;
  
  public aqyj(QQAppInterface paramQQAppInterface, aqzb paramaqzb)
  {
    super(paramQQAppInterface, paramaqzb);
  }
  
  private List<? extends EmoticonInfo> a()
  {
    return this.b;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Aqzb.c.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Aqzb.b.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_Aqzb.b.getContext().getResources());
  }
  
  private void j()
  {
    a(new aqyk(this));
  }
  
  public int a()
  {
    return 2131691755;
  }
  
  public aqyq<CameraEmotionData> a()
  {
    if (this.jdField_a_of_type_Arad == null) {
      this.jdField_a_of_type_Arad = ((arad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    return this.jdField_a_of_type_Arad;
  }
  
  public String a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof CameraEmoticonInfo))
    {
      String str = ((CameraEmoticonInfo)paramEmoticonInfo).contextKey;
      paramEmoticonInfo = str;
      if (TextUtils.isEmpty(str)) {
        paramEmoticonInfo = "";
      }
      return String.format(BaseApplicationImpl.getApplication().getString(2131691754), new Object[] { paramEmoticonInfo });
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amou);
    this.jdField_a_of_type_Aqzb.b(2131691753);
    this.c = false;
    if (this.jdField_a_of_type_Arad == null) {
      this.jdField_a_of_type_Arad = ((arad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333));
    }
    i();
    j();
  }
  
  public void a(aqyr paramaqyr)
  {
    a().a(new aqyl(this, paramaqyr));
  }
  
  public void a(GridView paramGridView, int paramInt, ICustomEmotionInfo paramICustomEmotionInfo)
  {
    Object localObject = ((arad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      int i = paramICustomEmotionInfo.getEmoId();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (localCameraEmotionData.emoId == i)
        {
          QLog.d("CameraRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCameraEmotionData.emoId) });
          localCameraEmotionData.RomaingType = "needUpload";
          ((CameraEmoticonInfo)paramICustomEmotionInfo).roamingType = "needUpload";
          if (this.jdField_a_of_type_Aqzb != null) {
            this.jdField_a_of_type_Aqzb.a(paramGridView, paramInt);
          }
          com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
          ThreadManager.excute(new CameraEmoSingleSend(localCameraEmotionData, true), 64, null, false);
        }
      }
    }
  }
  
  public void a(List<EmoticonInfo> paramList)
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
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)paramList.next();
      if ((localEmoticonInfo instanceof CameraEmoticonInfo))
      {
        ((CameraEmoticonInfo)localEmoticonInfo).isChecked = false;
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          CameraEmoticonInfo localCameraEmoticonInfo = (CameraEmoticonInfo)localIterator.next();
          if (((CameraEmoticonInfo)localEmoticonInfo).emoId == localCameraEmoticonInfo.emoId) {
            ((CameraEmoticonInfo)localEmoticonInfo).isChecked = localCameraEmoticonInfo.isChecked;
          }
        }
        localArrayList.add((CameraEmoticonInfo)localEmoticonInfo);
      }
    }
    this.b = localArrayList;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amou);
    this.c = false;
  }
  
  public void e()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
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
        Object localObject2 = (EmoticonInfo)((Iterator)localObject1).next();
        if ((localObject2 instanceof CameraEmoticonInfo))
        {
          localObject2 = (CameraEmoticonInfo)localObject2;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)localIterator.next();
            if ((localCameraEmotionData != null) && (((CameraEmoticonInfo)localObject2).emoId == localCameraEmotionData.emoId) && (((CameraEmoticonInfo)localObject2).isChecked))
            {
              ((CameraEmoticonInfo)localObject2).isChecked = false;
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
 * Qualified Name:     aqyj
 * JD-Core Version:    0.7.0.1
 */