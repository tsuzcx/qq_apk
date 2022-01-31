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

public abstract class anqe
  implements anrm
{
  anqx jdField_a_of_type_Anqx;
  anrn jdField_a_of_type_Anrn = null;
  public QQAppInterface a;
  public List<aoau> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  public boolean b;
  
  public anqe(QQAppInterface paramQQAppInterface, anqx paramanqx)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anqx = paramanqx;
    this.jdField_a_of_type_Anrn = new anrn(paramQQAppInterface);
  }
  
  public int a()
  {
    return 2131692020;
  }
  
  public View a(int paramInt, View paramView, anrf paramanrf, anyc paramanyc)
  {
    return paramView;
  }
  
  public anrn a()
  {
    return this.jdField_a_of_type_Anrn;
  }
  
  public String a(anyc paramanyc)
  {
    return null;
  }
  
  public List<anyc> a(List<anyc> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      anyc localanyc = (anyc)paramList.next();
      Object localObject;
      if ((localanyc instanceof anxq))
      {
        localObject = (anxq)localanyc;
        if ((!TextUtils.isEmpty(((anxq)localObject).g)) && (!((anxq)localObject).g.equals("needUpload"))) {
          localArrayList.add(localanyc);
        }
      }
      else if ((localanyc instanceof aoau))
      {
        localObject = (aoau)localanyc;
        if ((!TextUtils.isEmpty(((aoau)localObject).g)) && (!((aoau)localObject).g.equals("needUpload"))) {
          localArrayList.add(localanyc);
        }
      }
      else
      {
        localArrayList.add(localanyc);
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
    if (this.jdField_a_of_type_Anqx == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("com.tencent.mobileqq.action.refresh.emotiom".equals(paramContext))
        {
          this.jdField_a_of_type_Anqx.e();
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
  
  public void a(anqn paramanqn)
  {
    a().a(paramanqn);
  }
  
  public void a(GridView paramGridView, int paramInt, aobb paramaobb) {}
  
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
    if (this.jdField_a_of_type_Anqx == null) {
      return;
    }
    Object localObject = a(this.jdField_a_of_type_Anqx.jdField_a_of_type_JavaUtilList);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((((List)localObject).size() > 0) && (((anyc)((List)localObject).get(0)).f == 1)) {
        ((List)localObject).remove(0);
      }
      this.jdField_a_of_type_Anqx.d((List)localObject);
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Anqx == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Anqx.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      anyc localanyc;
      if (a())
      {
        if (((List)localObject).size() <= 0) {
          break label91;
        }
        if (((anyc)((List)localObject).get(0)).f != 1)
        {
          localanyc = new anyc();
          localanyc.f = 1;
          ((List)localObject).add(0, localanyc);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Anqx.d((List)localObject);
        return;
        label91:
        localanyc = new anyc();
        localanyc.f = 1;
        ((List)localObject).add(0, localanyc);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Anrn.onDestroy();
    this.jdField_a_of_type_Anqx = null;
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anqe
 * JD-Core Version:    0.7.0.1
 */