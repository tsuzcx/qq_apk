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
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class anaw
  extends amzw
{
  ajhy jdField_a_of_type_Ajhy = new anaz(this);
  private ancg jdField_a_of_type_Ancg;
  ancp<CustomEmotionData> jdField_a_of_type_Ancp = new anba(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private List<String> b;
  
  public anaw(QQAppInterface paramQQAppInterface, anao paramanao)
  {
    super(paramQQAppInterface, paramanao);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(anht paramanht, String paramString)
  {
    if ((paramanht instanceof ankl)) {
      ((ankl)paramanht).g = paramString;
    }
    while (!(paramanht instanceof anla)) {
      return;
    }
    ((anla)paramanht).a = paramString;
  }
  
  private void h()
  {
    a(new anax(this));
  }
  
  public anae<CustomEmotionData> a()
  {
    if (this.jdField_a_of_type_Ancg == null) {
      this.jdField_a_of_type_Ancg = ((ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    return this.jdField_a_of_type_Ancg;
  }
  
  public String a(anht paramanht)
  {
    if (paramanht == null) {
      return null;
    }
    return anch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(paramanht.g));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_Anao.a();
    this.jdField_a_of_type_Anao.b(2131626434);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajhy);
    h();
    if (this.jdField_a_of_type_Ancg == null) {
      this.jdField_a_of_type_Ancg = ((ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    ((anch)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).a(this.jdField_a_of_type_Ancp);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    super.a(paramContext, paramIntent);
    if ("com.tencent.mobileqq.action.update.emotiom".equals(paramIntent.getAction())) {
      a(new anay(this));
    }
  }
  
  public void a(GridView paramGridView, int paramInt, ankr paramankr)
  {
    Object localObject = ((ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
    int i = paramankr.a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
      if (localCustomEmotionData.emoId == i)
      {
        QLog.d("FavRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCustomEmotionData.emoId) });
        if ((localCustomEmotionData.emoOriginalPath != null) && (!ancf.a(localCustomEmotionData.emoOriginalPath)))
        {
          ((ajhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72)).notifyUI(2, true, Integer.valueOf(1));
        }
        else
        {
          localCustomEmotionData.RomaingType = "needUpload";
          a((anht)paramankr, "needUpload");
          if (this.jdField_a_of_type_Anao != null)
          {
            this.jdField_a_of_type_Anao.a(paramankr.b(), "needUpload");
            this.jdField_a_of_type_Anao.a(paramGridView, paramInt);
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
          ankl localankl = new ankl();
          localankl.c = ((String)localArrayList1.get(i));
          localankl.d = ((String)localArrayList2.get(i));
          localankl.h = ((String)localArrayList3.get(i));
          this.jdField_a_of_type_JavaUtilList.add(localankl);
          i += 1;
        }
      }
      if (j > 0) {
        bbmy.a(paramActivity, j + "个下载失败", 0).a();
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
    ((anch)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).b(this.jdField_a_of_type_Ancp);
    if (this.jdField_a_of_type_Ajhy != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajhy);
    }
  }
  
  public void e()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AA", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AB", 0, 0, "", "", "", "");
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Anao == null) || (this.jdField_a_of_type_Anao.jdField_b_of_type_JavaUtilList == null)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Anao.jdField_b_of_type_JavaUtilList.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (anht)((Iterator)localObject1).next();
    } while ((!(localObject2 instanceof ankr)) || (!((ankr)localObject2).a()));
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject1 = (ajhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
        if (localObject1 != null)
        {
          ((ajhx)localObject1).a(this.jdField_b_of_type_JavaUtilList, false);
          if (QLog.isColorLevel()) {
            QLog.d("FavEmoRoamingHandler", 2, "-------start delfav---------delResid=" + this.jdField_b_of_type_JavaUtilList.toString());
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, this.jdField_b_of_type_JavaUtilList.size() + "", "", "", "");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A6D5", "0X800A6D5", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilList.size()), "", "", "");
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
        localObject1 = this.jdField_a_of_type_Anao.jdField_b_of_type_JavaUtilList;
        int k = ((List)localObject1).size();
        i = 0;
        localObject2 = new ArrayList();
        int j = 0;
        if (j < k)
        {
          anht localanht = (anht)((List)localObject1).get(j);
          if (!(localanht instanceof ankr)) {}
          for (;;)
          {
            j += 1;
            break;
            if (((ankr)localanht).a())
            {
              ((List)localObject2).add(localanht);
              i += 1;
            }
          }
        }
        ThreadManager.post(new FavRoamingStrategy.3(this, (List)localObject2), 5, null, true);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(i), "", "", "");
        this.jdField_a_of_type_Boolean = false;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
        }
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "趣图已添加至收藏面板", 0).a();
      }
      localObject1 = (andn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141);
      i = 0;
      if (i < this.jdField_a_of_type_Anao.jdField_b_of_type_JavaUtilList.size())
      {
        localObject2 = this.jdField_a_of_type_Anao.getItem(i);
        if ((localObject2 == null) || (!(localObject2 instanceof ankr))) {}
        while (!((ankr)localObject2).a())
        {
          i += 1;
          break;
        }
        ThreadManager.post(new FavRoamingStrategy.4(this, localObject2, (andn)localObject1, i), 5, null, false);
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
 * Qualified Name:     anaw
 * JD-Core Version:    0.7.0.1
 */