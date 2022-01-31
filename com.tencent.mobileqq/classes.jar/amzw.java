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

public abstract class amzw
  implements anbb
{
  anao jdField_a_of_type_Anao;
  anbc jdField_a_of_type_Anbc = null;
  public QQAppInterface a;
  public List<ankl> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  public boolean b;
  
  public amzw(QQAppInterface paramQQAppInterface, anao paramanao)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anao = paramanao;
    this.jdField_a_of_type_Anbc = new anbc(paramQQAppInterface);
  }
  
  public anbc a()
  {
    return this.jdField_a_of_type_Anbc;
  }
  
  public View a(int paramInt, View paramView, anau paramanau, anht paramanht)
  {
    return paramView;
  }
  
  public String a(anht paramanht)
  {
    return null;
  }
  
  public List<anht> a(List<anht> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      anht localanht = (anht)paramList.next();
      Object localObject;
      if ((localanht instanceof anhh))
      {
        localObject = (anhh)localanht;
        if ((!TextUtils.isEmpty(((anhh)localObject).g)) && (!((anhh)localObject).g.equals("needUpload"))) {
          localArrayList.add(localanht);
        }
      }
      else if ((localanht instanceof ankl))
      {
        localObject = (ankl)localanht;
        if ((!TextUtils.isEmpty(((ankl)localObject).g)) && (!((ankl)localObject).g.equals("needUpload"))) {
          localArrayList.add(localanht);
        }
      }
      else
      {
        localArrayList.add(localanht);
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
  
  public void a(anaf paramanaf)
  {
    a().a(paramanaf);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Anao == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("com.tencent.mobileqq.action.refresh.emotiom".equals(paramContext))
        {
          this.jdField_a_of_type_Anao.e();
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
  
  public void a(GridView paramGridView, int paramInt, ankr paramankr) {}
  
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
    if (this.jdField_a_of_type_Anao == null) {
      return;
    }
    Object localObject = a(this.jdField_a_of_type_Anao.jdField_a_of_type_JavaUtilList);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((((List)localObject).size() > 0) && (((anht)((List)localObject).get(0)).f == 1)) {
        ((List)localObject).remove(0);
      }
      this.jdField_a_of_type_Anao.d((List)localObject);
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Anao == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Anao.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      anht localanht;
      if (a())
      {
        if (((List)localObject).size() <= 0) {
          break label91;
        }
        if (((anht)((List)localObject).get(0)).f != 1)
        {
          localanht = new anht();
          localanht.f = 1;
          ((List)localObject).add(0, localanht);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Anao.d((List)localObject);
        return;
        label91:
        localanht = new anht();
        localanht.f = 1;
        ((List)localObject).add(0, localanht);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Anbc.onDestroy();
    this.jdField_a_of_type_Anao = null;
  }
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amzw
 * JD-Core Version:    0.7.0.1
 */