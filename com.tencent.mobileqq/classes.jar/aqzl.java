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
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class aqzl
  extends aqyi
{
  amrn jdField_a_of_type_Amrn = new aqzo(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private arba jdField_a_of_type_Arba;
  arbj<CustomEmotionData> jdField_a_of_type_Arbj = new aqzp(this);
  private List<String> b;
  
  public aqzl(QQAppInterface paramQQAppInterface, aqzb paramaqzb)
  {
    super(paramQQAppInterface, paramaqzb);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(arce paramarce, int paramInt, Object paramObject)
  {
    ThreadManager.post(new FavRoamingStrategy.4(this, paramObject, paramarce, paramInt), 5, null, false);
  }
  
  private void a(EmoticonInfo paramEmoticonInfo, String paramString)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo)) {
      ((FavoriteEmoticonInfo)paramEmoticonInfo).roamingType = paramString;
    }
    while (!(paramEmoticonInfo instanceof PicEmoticonInfo)) {
      return;
    }
    ((PicEmoticonInfo)paramEmoticonInfo).roamingType = paramString;
  }
  
  private void i()
  {
    a(new aqzm(this));
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Object localObject = this.jdField_a_of_type_Aqzb.jdField_b_of_type_JavaUtilList;
      int k = ((List)localObject).size();
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i = 0;
      if (j < k)
      {
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)((List)localObject).get(j);
        if (!(localEmoticonInfo instanceof ICustomEmotionInfo)) {}
        for (;;)
        {
          j += 1;
          break;
          if (((ICustomEmotionInfo)localEmoticonInfo).isChecked())
          {
            localArrayList.add(localEmoticonInfo);
            i += 1;
          }
        }
      }
      ThreadManager.post(new FavRoamingStrategy.3(this, localArrayList), 5, null, true);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(i), "", "", "");
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
    return 2131691763;
  }
  
  public aqyq<CustomEmotionData> a()
  {
    if (this.jdField_a_of_type_Arba == null) {
      this.jdField_a_of_type_Arba = ((arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    return this.jdField_a_of_type_Arba;
  }
  
  public String a(EmoticonInfo paramEmoticonInfo)
  {
    if (paramEmoticonInfo == null) {
      return null;
    }
    return arbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(paramEmoticonInfo.emoId));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_Aqzb.a();
    this.jdField_a_of_type_Aqzb.b(2131691777);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amrn);
    i();
    if (this.jdField_a_of_type_Arba == null) {
      this.jdField_a_of_type_Arba = ((arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149));
    }
    ((arbb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).a(this.jdField_a_of_type_Arbj);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    super.a(paramContext, paramIntent);
    if ("com.tencent.mobileqq.action.update.emotiom".equals(paramIntent.getAction())) {
      a(new aqzn(this));
    }
  }
  
  public void a(GridView paramGridView, int paramInt, ICustomEmotionInfo paramICustomEmotionInfo)
  {
    Object localObject = ((arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
    int i = paramICustomEmotionInfo.getEmoId();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
      if (localCustomEmotionData.emoId == i)
      {
        QLog.d("FavRoamingStrategy", 1, new Object[] { "resend, emoId:", Integer.valueOf(localCustomEmotionData.emoId) });
        if ((localCustomEmotionData.emoOriginalPath != null) && (!araz.a(localCustomEmotionData.emoOriginalPath)))
        {
          ((amrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(72)).notifyUI(2, true, Integer.valueOf(1));
        }
        else
        {
          localCustomEmotionData.RomaingType = "needUpload";
          a((EmoticonInfo)paramICustomEmotionInfo, "needUpload");
          if (this.jdField_a_of_type_Aqzb != null)
          {
            this.jdField_a_of_type_Aqzb.a(paramICustomEmotionInfo.getPath(), "needUpload");
            this.jdField_a_of_type_Aqzb.a(paramGridView, paramInt);
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
          FavoriteEmoticonInfo localFavoriteEmoticonInfo = new FavoriteEmoticonInfo();
          localFavoriteEmoticonInfo.eId = ((String)localArrayList1.get(i));
          localFavoriteEmoticonInfo.path = ((String)localArrayList2.get(i));
          localFavoriteEmoticonInfo.action = ((String)localArrayList3.get(i));
          this.jdField_a_of_type_JavaUtilList.add(localFavoriteEmoticonInfo);
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
    ((arbb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).b(this.jdField_a_of_type_Arbj);
    if (this.jdField_a_of_type_Amrn != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amrn);
    }
  }
  
  public void e()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AA", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A6AB", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_Aqzb == null) || (this.jdField_a_of_type_Aqzb.jdField_b_of_type_JavaUtilList == null)) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Aqzb.jdField_b_of_type_JavaUtilList.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (EmoticonInfo)((Iterator)localObject1).next();
    } while ((!(localObject2 instanceof ICustomEmotionInfo)) || (!((ICustomEmotionInfo)localObject2).isChecked()));
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject1 = (amrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(72);
        if (localObject1 != null)
        {
          ((amrm)localObject1).a(this.jdField_b_of_type_JavaUtilList, false);
          if (QLog.isColorLevel()) {
            QLog.d("FavEmoRoamingHandler", 2, "-------start delfav---------delResid=" + this.jdField_b_of_type_JavaUtilList.toString());
          }
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, this.jdField_b_of_type_JavaUtilList.size() + "", "", "", "");
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A6D5", "0X800A6D5", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilList.size()), "", "", "");
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
      localObject1 = (arce)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141);
      i = j;
      if (i < this.jdField_a_of_type_Aqzb.jdField_b_of_type_JavaUtilList.size())
      {
        localObject2 = this.jdField_a_of_type_Aqzb.getItem(i);
        if ((localObject2 == null) || (!(localObject2 instanceof ICustomEmotionInfo))) {}
        while (!((ICustomEmotionInfo)localObject2).isChecked())
        {
          i += 1;
          break;
        }
        a((arce)localObject1, i, localObject2);
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
 * Qualified Name:     aqzl
 * JD-Core Version:    0.7.0.1
 */