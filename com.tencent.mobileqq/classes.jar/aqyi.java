import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy.1;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy.2;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class aqyi
  implements aqzq
{
  aqzb jdField_a_of_type_Aqzb;
  aqzr jdField_a_of_type_Aqzr = null;
  public QQAppInterface a;
  public List<FavoriteEmoticonInfo> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  public boolean b;
  
  public aqyi(QQAppInterface paramQQAppInterface, aqzb paramaqzb)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aqzb = paramaqzb;
    this.jdField_a_of_type_Aqzr = new aqzr(paramQQAppInterface);
  }
  
  public int a()
  {
    return 2131691777;
  }
  
  public View a(int paramInt, View paramView, aqzj paramaqzj, EmoticonInfo paramEmoticonInfo)
  {
    return paramView;
  }
  
  public aqzr a()
  {
    return this.jdField_a_of_type_Aqzr;
  }
  
  public String a(EmoticonInfo paramEmoticonInfo)
  {
    return null;
  }
  
  public List<EmoticonInfo> a(List<EmoticonInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)paramList.next();
      Object localObject;
      if ((localEmoticonInfo instanceof CameraEmoticonInfo))
      {
        localObject = (CameraEmoticonInfo)localEmoticonInfo;
        if ((!TextUtils.isEmpty(((CameraEmoticonInfo)localObject).roamingType)) && (!((CameraEmoticonInfo)localObject).roamingType.equals("needUpload"))) {
          localArrayList.add(localEmoticonInfo);
        }
      }
      else if ((localEmoticonInfo instanceof FavoriteEmoticonInfo))
      {
        localObject = (FavoriteEmoticonInfo)localEmoticonInfo;
        if ((!TextUtils.isEmpty(((FavoriteEmoticonInfo)localObject).roamingType)) && (!((FavoriteEmoticonInfo)localObject).roamingType.equals("needUpload"))) {
          localArrayList.add(localEmoticonInfo);
        }
      }
      else
      {
        localArrayList.add(localEmoticonInfo);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BaseEmosmStrategy", 2, "onActivityResult, PeakConstants.REQUEST_CODE_FOR_PHOTO_PREVIEW");
      }
      if (paramIntent == null) {
        break;
      }
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramIntent != null)
      {
        ThreadManager.excute(new BaseEmosmStrategy.2(this, paramIntent), 64, null, false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BaseEmosmStrategy", 2, "onActivityResult, selected is empty");
    return;
    QLog.e("BaseEmosmStrategy", 1, "onActivityResult, PeakConstants.REQUEST_CODE_FOR_PHOTO_PREVIEW, data is null");
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aqzb == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("com.tencent.mobileqq.action.refresh.emotiom".equals(paramContext))
        {
          this.jdField_a_of_type_Aqzb.e();
          return;
        }
      } while (!"com.tencent.mobileqq.action.upload.emotiom".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d("BaseEmosmStrategy", 2, "onReceive ACTION_UPLOAD_EMOTION");
      }
      paramContext = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramContext != null)
      {
        ThreadManager.excute(new BaseEmosmStrategy.1(this, paramContext), 64, null, false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BaseEmosmStrategy", 2, "onReceive selected is empty");
  }
  
  public void a(aqyr paramaqyr)
  {
    a().a(paramaqyr);
  }
  
  public void a(GridView paramGridView, int paramInt, ICustomEmotionInfo paramICustomEmotionInfo) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqzb == null) {
      return;
    }
    Object localObject = a(this.jdField_a_of_type_Aqzb.jdField_a_of_type_JavaUtilList);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((((List)localObject).size() > 0) && (((EmoticonInfo)((List)localObject).get(0)).operateType == 1)) {
        ((List)localObject).remove(0);
      }
      this.jdField_a_of_type_Aqzb.d((List)localObject);
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aqzb == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Aqzb.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      EmoticonInfo localEmoticonInfo;
      if (a())
      {
        if (((List)localObject).size() <= 0) {
          break label91;
        }
        if (((EmoticonInfo)((List)localObject).get(0)).operateType != 1)
        {
          localEmoticonInfo = new EmoticonInfo();
          localEmoticonInfo.operateType = 1;
          ((List)localObject).add(0, localEmoticonInfo);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Aqzb.d((List)localObject);
        return;
        label91:
        localEmoticonInfo = new EmoticonInfo();
        localEmoticonInfo.operateType = 1;
        ((List)localObject).add(0, localEmoticonInfo);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aqzr.onDestroy();
    this.jdField_a_of_type_Aqzb = null;
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyi
 * JD-Core Version:    0.7.0.1
 */