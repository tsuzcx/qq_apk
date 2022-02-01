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

public abstract class arow
  implements arqe
{
  arpp jdField_a_of_type_Arpp;
  arqf jdField_a_of_type_Arqf = null;
  public QQAppInterface a;
  public List<asaz> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  public boolean b;
  
  public arow(QQAppInterface paramQQAppInterface, arpp paramarpp)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Arpp = paramarpp;
    this.jdField_a_of_type_Arqf = new arqf(paramQQAppInterface);
  }
  
  public int a()
  {
    return 2131691728;
  }
  
  public View a(int paramInt, View paramView, arpx paramarpx, arxg paramarxg)
  {
    return paramView;
  }
  
  public arqf a()
  {
    return this.jdField_a_of_type_Arqf;
  }
  
  public String a(arxg paramarxg)
  {
    return null;
  }
  
  public List<arxg> a(List<arxg> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      arxg localarxg = (arxg)paramList.next();
      Object localObject;
      if ((localarxg instanceof arws))
      {
        localObject = (arws)localarxg;
        if ((!TextUtils.isEmpty(((arws)localObject).h)) && (!((arws)localObject).h.equals("needUpload"))) {
          localArrayList.add(localarxg);
        }
      }
      else if ((localarxg instanceof asaz))
      {
        localObject = (asaz)localarxg;
        if ((!TextUtils.isEmpty(((asaz)localObject).h)) && (!((asaz)localObject).h.equals("needUpload"))) {
          localArrayList.add(localarxg);
        }
      }
      else
      {
        localArrayList.add(localarxg);
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
    if (this.jdField_a_of_type_Arpp == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("com.tencent.mobileqq.action.refresh.emotiom".equals(paramContext))
        {
          this.jdField_a_of_type_Arpp.e();
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
  
  public void a(arpf paramarpf)
  {
    a().a(paramarpf);
  }
  
  public void a(GridView paramGridView, int paramInt, asbh paramasbh) {}
  
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
    if (this.jdField_a_of_type_Arpp == null) {
      return;
    }
    Object localObject = a(this.jdField_a_of_type_Arpp.jdField_a_of_type_JavaUtilList);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((((List)localObject).size() > 0) && (((arxg)((List)localObject).get(0)).f == 1)) {
        ((List)localObject).remove(0);
      }
      this.jdField_a_of_type_Arpp.d((List)localObject);
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Arpp == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Arpp.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      arxg localarxg;
      if (a())
      {
        if (((List)localObject).size() <= 0) {
          break label91;
        }
        if (((arxg)((List)localObject).get(0)).f != 1)
        {
          localarxg = new arxg();
          localarxg.f = 1;
          ((List)localObject).add(0, localarxg);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Arpp.d((List)localObject);
        return;
        label91:
        localarxg = new arxg();
        localarxg.f = 1;
        ((List)localObject).add(0, localarxg);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Arqf.onDestroy();
    this.jdField_a_of_type_Arpp = null;
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arow
 * JD-Core Version:    0.7.0.1
 */