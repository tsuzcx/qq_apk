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

public abstract class apma
  implements apni
{
  apmt jdField_a_of_type_Apmt;
  apnj jdField_a_of_type_Apnj = null;
  public QQAppInterface a;
  public List<apxf> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  public boolean b;
  
  public apma(QQAppInterface paramQQAppInterface, apmt paramapmt)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Apmt = paramapmt;
    this.jdField_a_of_type_Apnj = new apnj(paramQQAppInterface);
  }
  
  public int a()
  {
    return 2131692076;
  }
  
  public View a(int paramInt, View paramView, apnb paramapnb, apuf paramapuf)
  {
    return paramView;
  }
  
  public apnj a()
  {
    return this.jdField_a_of_type_Apnj;
  }
  
  public String a(apuf paramapuf)
  {
    return null;
  }
  
  public List<apuf> a(List<apuf> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      apuf localapuf = (apuf)paramList.next();
      Object localObject;
      if ((localapuf instanceof aptr))
      {
        localObject = (aptr)localapuf;
        if ((!TextUtils.isEmpty(((aptr)localObject).h)) && (!((aptr)localObject).h.equals("needUpload"))) {
          localArrayList.add(localapuf);
        }
      }
      else if ((localapuf instanceof apxf))
      {
        localObject = (apxf)localapuf;
        if ((!TextUtils.isEmpty(((apxf)localObject).h)) && (!((apxf)localObject).h.equals("needUpload"))) {
          localArrayList.add(localapuf);
        }
      }
      else
      {
        localArrayList.add(localapuf);
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
    if (this.jdField_a_of_type_Apmt == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("com.tencent.mobileqq.action.refresh.emotiom".equals(paramContext))
        {
          this.jdField_a_of_type_Apmt.e();
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
  
  public void a(apmj paramapmj)
  {
    a().a(paramapmj);
  }
  
  public void a(GridView paramGridView, int paramInt, apxm paramapxm) {}
  
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
    if (this.jdField_a_of_type_Apmt == null) {
      return;
    }
    Object localObject = a(this.jdField_a_of_type_Apmt.jdField_a_of_type_JavaUtilList);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((((List)localObject).size() > 0) && (((apuf)((List)localObject).get(0)).f == 1)) {
        ((List)localObject).remove(0);
      }
      this.jdField_a_of_type_Apmt.d((List)localObject);
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Apmt == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Apmt.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      apuf localapuf;
      if (a())
      {
        if (((List)localObject).size() <= 0) {
          break label91;
        }
        if (((apuf)((List)localObject).get(0)).f != 1)
        {
          localapuf = new apuf();
          localapuf.f = 1;
          ((List)localObject).add(0, localapuf);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Apmt.d((List)localObject);
        return;
        label91:
        localapuf = new apuf();
        localapuf.f = 1;
        ((List)localObject).add(0, localapuf);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Apnj.onDestroy();
    this.jdField_a_of_type_Apmt = null;
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apma
 * JD-Core Version:    0.7.0.1
 */