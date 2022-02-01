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

public abstract class asek
  implements asfs
{
  asfd jdField_a_of_type_Asfd;
  asft jdField_a_of_type_Asft = null;
  public QQAppInterface a;
  public List<asqn> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  public boolean b;
  
  public asek(QQAppInterface paramQQAppInterface, asfd paramasfd)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Asfd = paramasfd;
    this.jdField_a_of_type_Asft = new asft(paramQQAppInterface);
  }
  
  public int a()
  {
    return 2131691731;
  }
  
  public View a(int paramInt, View paramView, asfl paramasfl, asmu paramasmu)
  {
    return paramView;
  }
  
  public asft a()
  {
    return this.jdField_a_of_type_Asft;
  }
  
  public String a(asmu paramasmu)
  {
    return null;
  }
  
  public List<asmu> a(List<asmu> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      asmu localasmu = (asmu)paramList.next();
      Object localObject;
      if ((localasmu instanceof asmg))
      {
        localObject = (asmg)localasmu;
        if ((!TextUtils.isEmpty(((asmg)localObject).h)) && (!((asmg)localObject).h.equals("needUpload"))) {
          localArrayList.add(localasmu);
        }
      }
      else if ((localasmu instanceof asqn))
      {
        localObject = (asqn)localasmu;
        if ((!TextUtils.isEmpty(((asqn)localObject).h)) && (!((asqn)localObject).h.equals("needUpload"))) {
          localArrayList.add(localasmu);
        }
      }
      else
      {
        localArrayList.add(localasmu);
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
    if (this.jdField_a_of_type_Asfd == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("com.tencent.mobileqq.action.refresh.emotiom".equals(paramContext))
        {
          this.jdField_a_of_type_Asfd.e();
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
  
  public void a(aset paramaset)
  {
    a().a(paramaset);
  }
  
  public void a(GridView paramGridView, int paramInt, asqv paramasqv) {}
  
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
    if (this.jdField_a_of_type_Asfd == null) {
      return;
    }
    Object localObject = a(this.jdField_a_of_type_Asfd.jdField_a_of_type_JavaUtilList);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((((List)localObject).size() > 0) && (((asmu)((List)localObject).get(0)).f == 1)) {
        ((List)localObject).remove(0);
      }
      this.jdField_a_of_type_Asfd.d((List)localObject);
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Asfd == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Asfd.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      asmu localasmu;
      if (a())
      {
        if (((List)localObject).size() <= 0) {
          break label91;
        }
        if (((asmu)((List)localObject).get(0)).f != 1)
        {
          localasmu = new asmu();
          localasmu.f = 1;
          ((List)localObject).add(0, localasmu);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Asfd.d((List)localObject);
        return;
        label91:
        localasmu = new asmu();
        localasmu.f = 1;
        ((List)localObject).add(0, localasmu);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Asft.onDestroy();
    this.jdField_a_of_type_Asfd = null;
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asek
 * JD-Core Version:    0.7.0.1
 */