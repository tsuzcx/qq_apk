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

public class asfn
  extends asek
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  anxe jdField_a_of_type_Anxe = new asfq(this);
  private ashc jdField_a_of_type_Ashc;
  ashl<CustomEmotionData> jdField_a_of_type_Ashl = new asfr(this);
  private List<String> b;
  
  public asfn(QQAppInterface paramQQAppInterface, asfd paramasfd)
  {
    super(paramQQAppInterface, paramasfd);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(asig paramasig, int paramInt, Object paramObject)
  {
    ThreadManager.post(new FavRoamingStrategy.4(this, paramObject, paramasig, paramInt), 5, null, false);
  }
  
  private void a(asmu paramasmu, String paramString)
  {
    if ((paramasmu instanceof asqn)) {
      ((asqn)paramasmu).h = paramString;
    }
    while (!(paramasmu instanceof asre)) {
      return;
    }
    ((asre)paramasmu).a = paramString;
  }
  
  private void i()
  {
    a(new asfo(this));
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Object localObject = this.jdField_a_of_type_Asfd.jdField_b_of_type_JavaUtilList;
      int k = ((List)localObject).size();
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i = 0;
      if (j < k)
      {
        asmu localasmu = (asmu)((List)localObject).get(j);
        if (!(localasmu instanceof asqv)) {}
        for (;;)
        {
          j += 1;
          break;
          if (((asqv)localasmu).a())
          {
            localArrayList.add(localasmu);
            i += 1;
          }
        }
      }
      ThreadManager.post(new FavRoamingStrategy.3(this, localArrayList), 5, null, true);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(i), "", "", "");
      this.jdField_a_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "趣图已添加至收藏面板", 0).a();
    }
  }
  
  public int a()
  {
    return 2131691717;
  }
  
  public ases<CustomEmotionData> a()
  {
    if (this.jdField_a_of_type_Ashc == null) {
      this.jdField_a_of_type_Ashc = ((ashc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    return this.jdField_a_of_type_Ashc;
  }
  
  public String a(asmu paramasmu)
  {
    if (paramasmu == null) {
      return null;
    }
    return ashd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(paramasmu.g));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_Asfd.a();
    this.jdField_a_of_type_Asfd.b(2131691731);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxe);
    i();
    if (this.jdField_a_of_type_Ashc == null) {
      this.jdField_a_of_type_Ashc = ((ashc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    ((ashd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).a(this.jdField_a_of_type_Ashl);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    super.a(paramContext, paramIntent);
    if ("com.tencent.mobileqq.action.update.emotiom".equals(paramIntent.getAction())) {
      a(new asfp(this));
    }
  }
  
  public void a(GridView paramGridView, int paramInt, asqv paramasqv)
  {
    Object localObject = ((ashc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
    int i = paramasqv.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
      if (localCustomEmotionData.emoId == i)
      {
        QLog.d("FavRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCustomEmotionData.emoId) });
        if ((localCustomEmotionData.emoOriginalPath != null) && (!ashb.a(localCustomEmotionData.emoOriginalPath)))
        {
          ((anxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72)).notifyUI(2, true, Integer.valueOf(1));
        }
        else
        {
          localCustomEmotionData.RomaingType = "needUpload";
          a((asmu)paramasqv, "needUpload");
          if (this.jdField_a_of_type_Asfd != null)
          {
            this.jdField_a_of_type_Asfd.a(paramasqv.b(), "needUpload");
            this.jdField_a_of_type_Asfd.a(paramGridView, paramInt);
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
          asqn localasqn = new asqn();
          localasqn.d = ((String)localArrayList1.get(i));
          localasqn.e = ((String)localArrayList2.get(i));
          localasqn.i = ((String)localArrayList3.get(i));
          this.jdField_a_of_type_JavaUtilList.add(localasqn);
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
    ((ashd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).b(this.jdField_a_of_type_Ashl);
    if (this.jdField_a_of_type_Anxe != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxe);
    }
  }
  
  public void e()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AA", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AB", 0, 0, "", "", "", "");
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
    int j = 0;
    if ((this.jdField_a_of_type_Asfd == null) || (this.jdField_a_of_type_Asfd.jdField_b_of_type_JavaUtilList == null)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Asfd.jdField_b_of_type_JavaUtilList.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (asmu)((Iterator)localObject1).next();
    } while ((!(localObject2 instanceof asqv)) || (!((asqv)localObject2).a()));
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject1 = (anxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
        if (localObject1 != null)
        {
          ((anxd)localObject1).a(this.jdField_b_of_type_JavaUtilList, false);
          if (QLog.isColorLevel()) {
            QLog.d("FavEmoRoamingHandler", 2, "-------start delfav---------delResid=" + this.jdField_b_of_type_JavaUtilList.toString());
          }
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, this.jdField_b_of_type_JavaUtilList.size() + "", "", "", "");
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A6D5", "0X800A6D5", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilList.size()), "", "", "");
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
      j();
      localObject1 = (asig)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141);
      i = j;
      if (i < this.jdField_a_of_type_Asfd.jdField_b_of_type_JavaUtilList.size())
      {
        localObject2 = this.jdField_a_of_type_Asfd.getItem(i);
        if ((localObject2 == null) || (!(localObject2 instanceof asqv))) {}
        while (!((asqv)localObject2).a())
        {
          i += 1;
          break;
        }
        a((asig)localObject1, i, localObject2);
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
 * Qualified Name:     asfn
 * JD-Core Version:    0.7.0.1
 */