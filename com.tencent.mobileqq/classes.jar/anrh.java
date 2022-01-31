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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class anrh
  extends anqe
{
  ajwb jdField_a_of_type_Ajwb = new anrk(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ansr jdField_a_of_type_Ansr;
  anta<CustomEmotionData> jdField_a_of_type_Anta = new anrl(this);
  private List<String> b;
  
  public anrh(QQAppInterface paramQQAppInterface, anqx paramanqx)
  {
    super(paramQQAppInterface, paramanqx);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(anyc paramanyc, String paramString)
  {
    if ((paramanyc instanceof aoau)) {
      ((aoau)paramanyc).g = paramString;
    }
    while (!(paramanyc instanceof aobk)) {
      return;
    }
    ((aobk)paramanyc).a = paramString;
  }
  
  private void i()
  {
    a(new anri(this));
  }
  
  public int a()
  {
    return 2131692004;
  }
  
  public anqm<CustomEmotionData> a()
  {
    if (this.jdField_a_of_type_Ansr == null) {
      this.jdField_a_of_type_Ansr = ((ansr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    return this.jdField_a_of_type_Ansr;
  }
  
  public String a(anyc paramanyc)
  {
    if (paramanyc == null) {
      return null;
    }
    return anss.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(paramanyc.g));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_Anqx.a();
    this.jdField_a_of_type_Anqx.b(2131692020);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajwb);
    i();
    if (this.jdField_a_of_type_Ansr == null) {
      this.jdField_a_of_type_Ansr = ((ansr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    ((anss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).a(this.jdField_a_of_type_Anta);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    super.a(paramContext, paramIntent);
    if ("com.tencent.mobileqq.action.update.emotiom".equals(paramIntent.getAction())) {
      a(new anrj(this));
    }
  }
  
  public void a(GridView paramGridView, int paramInt, aobb paramaobb)
  {
    Object localObject = ((ansr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
    int i = paramaobb.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
      if (localCustomEmotionData.emoId == i)
      {
        QLog.d("FavRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCustomEmotionData.emoId) });
        if ((localCustomEmotionData.emoOriginalPath != null) && (!ansq.a(localCustomEmotionData.emoOriginalPath)))
        {
          ((ajwa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72)).notifyUI(2, true, Integer.valueOf(1));
        }
        else
        {
          localCustomEmotionData.RomaingType = "needUpload";
          a((anyc)paramaobb, "needUpload");
          if (this.jdField_a_of_type_Anqx != null)
          {
            this.jdField_a_of_type_Anqx.a(paramaobb.b(), "needUpload");
            this.jdField_a_of_type_Anqx.a(paramGridView, paramInt);
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
          aoau localaoau = new aoau();
          localaoau.c = ((String)localArrayList1.get(i));
          localaoau.d = ((String)localArrayList2.get(i));
          localaoau.h = ((String)localArrayList3.get(i));
          this.jdField_a_of_type_JavaUtilList.add(localaoau);
          i += 1;
        }
      }
      if (j > 0) {
        bcpw.a(paramActivity, j + "个下载失败", 0).a();
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
    ((anss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).b(this.jdField_a_of_type_Anta);
    if (this.jdField_a_of_type_Ajwb != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajwb);
    }
  }
  
  public void e()
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AA", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AB", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_Anqx == null) || (this.jdField_a_of_type_Anqx.jdField_b_of_type_JavaUtilList == null)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Anqx.jdField_b_of_type_JavaUtilList.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (anyc)((Iterator)localObject1).next();
    } while ((!(localObject2 instanceof aobb)) || (!((aobb)localObject2).a()));
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject1 = (ajwa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
        if (localObject1 != null)
        {
          ((ajwa)localObject1).a(this.jdField_b_of_type_JavaUtilList, false);
          if (QLog.isColorLevel()) {
            QLog.d("FavEmoRoamingHandler", 2, "-------start delfav---------delResid=" + this.jdField_b_of_type_JavaUtilList.toString());
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, this.jdField_b_of_type_JavaUtilList.size() + "", "", "", "");
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A6D5", "0X800A6D5", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilList.size()), "", "", "");
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
        localObject1 = this.jdField_a_of_type_Anqx.jdField_b_of_type_JavaUtilList;
        int k = ((List)localObject1).size();
        i = 0;
        localObject2 = new ArrayList();
        int j = 0;
        if (j < k)
        {
          anyc localanyc = (anyc)((List)localObject1).get(j);
          if (!(localanyc instanceof aobb)) {}
          for (;;)
          {
            j += 1;
            break;
            if (((aobb)localanyc).a())
            {
              ((List)localObject2).add(localanyc);
              i += 1;
            }
          }
        }
        ThreadManager.post(new FavRoamingStrategy.3(this, (List)localObject2), 5, null, true);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(i), "", "", "");
        this.jdField_a_of_type_Boolean = false;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
        }
        bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "趣图已添加至收藏面板", 0).a();
      }
      localObject1 = (antv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141);
      i = 0;
      if (i < this.jdField_a_of_type_Anqx.jdField_b_of_type_JavaUtilList.size())
      {
        localObject2 = this.jdField_a_of_type_Anqx.getItem(i);
        if ((localObject2 == null) || (!(localObject2 instanceof aobb))) {}
        while (!((aobb)localObject2).a())
        {
          i += 1;
          break;
        }
        ThreadManager.post(new FavRoamingStrategy.4(this, localObject2, (antv)localObject1, i), 5, null, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anrh
 * JD-Core Version:    0.7.0.1
 */