import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy.1;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class aphr
  implements apiz
{
  apik jdField_a_of_type_Apik;
  apja jdField_a_of_type_Apja = null;
  public QQAppInterface a;
  public List<apsw> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  public boolean b;
  
  public aphr(QQAppInterface paramQQAppInterface, apik paramapik)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Apik = paramapik;
    this.jdField_a_of_type_Apja = new apja(paramQQAppInterface);
  }
  
  public int a()
  {
    return 2131692075;
  }
  
  public View a(int paramInt, View paramView, apis paramapis, appw paramappw)
  {
    return paramView;
  }
  
  public apja a()
  {
    return this.jdField_a_of_type_Apja;
  }
  
  public String a(appw paramappw)
  {
    return null;
  }
  
  public List<appw> a(List<appw> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      appw localappw = (appw)paramList.next();
      Object localObject;
      if ((localappw instanceof appi))
      {
        localObject = (appi)localappw;
        if ((!TextUtils.isEmpty(((appi)localObject).h)) && (!((appi)localObject).h.equals("needUpload"))) {
          localArrayList.add(localappw);
        }
      }
      else if ((localappw instanceof apsw))
      {
        localObject = (apsw)localappw;
        if ((!TextUtils.isEmpty(((apsw)localObject).h)) && (!((apsw)localObject).h.equals("needUpload"))) {
          localArrayList.add(localappw);
        }
      }
      else
      {
        localArrayList.add(localappw);
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
    if (this.jdField_a_of_type_Apik == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("com.tencent.mobileqq.action.refresh.emotiom".equals(paramContext))
        {
          this.jdField_a_of_type_Apik.e();
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
  
  public void a(apia paramapia)
  {
    a().a(paramapia);
  }
  
  public void a(GridView paramGridView, int paramInt, aptd paramaptd) {}
  
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
    if (this.jdField_a_of_type_Apik == null) {
      return;
    }
    Object localObject = a(this.jdField_a_of_type_Apik.jdField_a_of_type_JavaUtilList);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((((List)localObject).size() > 0) && (((appw)((List)localObject).get(0)).f == 1)) {
        ((List)localObject).remove(0);
      }
      this.jdField_a_of_type_Apik.d((List)localObject);
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Apik == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Apik.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      appw localappw;
      if (a())
      {
        if (((List)localObject).size() <= 0) {
          break label91;
        }
        if (((appw)((List)localObject).get(0)).f != 1)
        {
          localappw = new appw();
          localappw.f = 1;
          ((List)localObject).add(0, localappw);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Apik.d((List)localObject);
        return;
        label91:
        localappw = new appw();
        localappw.f = 1;
        ((List)localObject).add(0, localappw);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Apja.onDestroy();
    this.jdField_a_of_type_Apik = null;
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphr
 * JD-Core Version:    0.7.0.1
 */