import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.FavRoamingStrategy.3;
import com.tencent.mobileqq.emosm.FavRoamingStrategy.4;
import com.tencent.mobileqq.emosm.FavRoamingStrategy.7;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class apnd
  extends apma
{
  alsc jdField_a_of_type_Alsc = new apng(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private apon jdField_a_of_type_Apon;
  apow<CustomEmotionData> jdField_a_of_type_Apow = new apnh(this);
  private List<String> b;
  
  public apnd(QQAppInterface paramQQAppInterface, apmt paramapmt)
  {
    super(paramQQAppInterface, paramapmt);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(apuf paramapuf, String paramString)
  {
    if ((paramapuf instanceof apxf)) {
      ((apxf)paramapuf).h = paramString;
    }
    while (!(paramapuf instanceof apxv)) {
      return;
    }
    ((apxv)paramapuf).a = paramString;
  }
  
  private void i()
  {
    a(new apne(this));
  }
  
  public int a()
  {
    return 2131692060;
  }
  
  public apmi<CustomEmotionData> a()
  {
    if (this.jdField_a_of_type_Apon == null) {
      this.jdField_a_of_type_Apon = ((apon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    return this.jdField_a_of_type_Apon;
  }
  
  public String a(apuf paramapuf)
  {
    if (paramapuf == null) {
      return null;
    }
    return apoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(paramapuf.g));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_Apmt.a();
    this.jdField_a_of_type_Apmt.a(2131692076);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsc);
    i();
    if (this.jdField_a_of_type_Apon == null) {
      this.jdField_a_of_type_Apon = ((apon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    ((apoo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).a(this.jdField_a_of_type_Apow);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    super.a(paramContext, paramIntent);
    if ("com.tencent.mobileqq.action.update.emotiom".equals(paramIntent.getAction())) {
      a(new apnf(this));
    }
  }
  
  public void a(GridView paramGridView, int paramInt, apxm paramapxm)
  {
    Object localObject = ((apon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
    int i = paramapxm.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
      if (localCustomEmotionData.emoId == i)
      {
        QLog.d("FavRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCustomEmotionData.emoId) });
        if ((localCustomEmotionData.emoOriginalPath != null) && (!apom.a(localCustomEmotionData.emoOriginalPath)))
        {
          ((alsb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72)).notifyUI(2, true, Integer.valueOf(1));
        }
        else
        {
          localCustomEmotionData.RomaingType = "needUpload";
          a((apuf)paramapxm, "needUpload");
          if (this.jdField_a_of_type_Apmt != null)
          {
            this.jdField_a_of_type_Apmt.a(paramapxm.b(), "needUpload");
            this.jdField_a_of_type_Apmt.a(paramGridView, paramInt);
          }
          com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.jdField_b_of_type_Boolean = false;
          ThreadManager.excute(new FavEmoSingleSend(localCustomEmotionData, true), 64, null, false);
        }
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Activity paramActivity)
  {
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra_key_from_web", false);
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_Boolean = bool;
    if (this.jdField_a_of_type_Boolean)
    {
      ArrayList localArrayList1 = paramActivity.getIntent().getStringArrayListExtra("extra_key_pkgids");
      ArrayList localArrayList2 = paramActivity.getIntent().getStringArrayListExtra("extra_key_paths");
      ArrayList localArrayList3 = paramActivity.getIntent().getStringArrayListExtra("extra_key_md5s");
      int j = paramActivity.getIntent().getIntExtra("extra_key_faile_count", 0);
      if ((localArrayList1 != null) && (localArrayList2 != null) && (localArrayList3 != null))
      {
        int i = Math.min(localArrayList1.size(), localArrayList2.size());
        int k = Math.min(localArrayList3.size(), i);
        i = 0;
        while (i < k)
        {
          apxf localapxf = new apxf();
          localapxf.d = ((String)localArrayList1.get(i));
          localapxf.e = ((String)localArrayList2.get(i));
          localapxf.i = ((String)localArrayList3.get(i));
          this.jdField_a_of_type_JavaUtilList.add(localapxf);
          i += 1;
        }
      }
      if (j > 0) {
        QQToast.a(paramActivity, j + "个下载失败", 0).a();
      }
    }
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    ((apoo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).b(this.jdField_a_of_type_Apow);
    if (this.jdField_a_of_type_Alsc != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsc);
    }
  }
  
  public void e()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AA", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AB", 0, 0, "", "", "", "");
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavRoamingStrategy", 2, "fav doSyncEmotion");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ThreadManager.excute(new FavRoamingStrategy.7(this), 128, null, false);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Apmt == null) || (this.jdField_a_of_type_Apmt.jdField_b_of_type_JavaUtilList == null)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Apmt.jdField_b_of_type_JavaUtilList.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (apuf)((Iterator)localObject1).next();
    } while ((!(localObject2 instanceof apxm)) || (!((apxm)localObject2).a()));
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject1 = (alsb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
        if (localObject1 != null)
        {
          ((alsb)localObject1).a(this.jdField_b_of_type_JavaUtilList, false);
          if (QLog.isColorLevel()) {
            QLog.d("FavEmoRoamingHandler", 2, "-------start delfav---------delResid=" + this.jdField_b_of_type_JavaUtilList.toString());
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, this.jdField_b_of_type_JavaUtilList.size() + "", "", "", "");
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A6D5", "0X800A6D5", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilList.size()), "", "", "");
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 == null) {
          break;
        }
        ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
        return;
      }
      if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject1 = this.jdField_a_of_type_Apmt.jdField_b_of_type_JavaUtilList;
        int k = ((List)localObject1).size();
        i = 0;
        localObject2 = new ArrayList();
        int j = 0;
        if (j < k)
        {
          apuf localapuf = (apuf)((List)localObject1).get(j);
          if (!(localapuf instanceof apxm)) {}
          for (;;)
          {
            j += 1;
            break;
            if (((apxm)localapuf).a())
            {
              ((List)localObject2).add(localapuf);
              i += 1;
            }
          }
        }
        ThreadManager.post(new FavRoamingStrategy.3(this, (List)localObject2), 5, null, true);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(i), "", "", "");
        this.jdField_a_of_type_Boolean = false;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "趣图已添加至收藏面板", 0).a();
      }
      localObject1 = (appr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141);
      i = 0;
      if (i < this.jdField_a_of_type_Apmt.jdField_b_of_type_JavaUtilList.size())
      {
        localObject2 = this.jdField_a_of_type_Apmt.getItem(i);
        if ((localObject2 == null) || (!(localObject2 instanceof apxm))) {}
        while (!((apxm)localObject2).a())
        {
          i += 1;
          break;
        }
        ThreadManager.post(new FavRoamingStrategy.4(this, localObject2, (appr)localObject1, i), 5, null, false);
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localObject1 == null) {
        break;
      }
      ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnd
 * JD-Core Version:    0.7.0.1
 */