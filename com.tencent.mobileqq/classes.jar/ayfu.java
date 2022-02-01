import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluspanel.PlusPanelViewModel.1;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

public class ayfu
  extends ViewModel
{
  int jdField_a_of_type_Int = 0;
  private MutableLiveData<Boolean> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private ayfr jdField_a_of_type_Ayfr;
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private MutableLiveData<ArrayList<ayfo>> jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  
  public ayfu()
  {
    this.jdField_b_of_type_Int = -1;
  }
  
  private PlusPanelAppInfo a(int paramInt)
  {
    return this.jdField_a_of_type_Ayfr.a(paramInt);
  }
  
  private void a(int paramInt, ayfo paramayfo, azvi paramazvi)
  {
    paramayfo = paramazvi.a(10, paramayfo.c, paramayfo.f);
    if (paramayfo != null)
    {
      if (paramInt == 1) {
        paramazvi.a(paramayfo.uiAppId.get(), 30);
      }
    }
    else {
      return;
    }
    paramazvi.b(paramayfo, "");
  }
  
  private void a(SessionInfo paramSessionInfo, PlusPanelAppInfo paramPlusPanelAppInfo, QQAppInterface paramQQAppInterface)
  {
    if (!((HotChatManager)paramQQAppInterface.getManager(60)).b(paramSessionInfo.curFriendUin))
    {
      bfaa localbfaa = (bfaa)paramQQAppInterface.getManager(109);
      if (paramPlusPanelAppInfo.redPoint)
      {
        bduw.a(paramQQAppInterface).a(paramPlusPanelAppInfo.getAppID());
        ThreadManager.excute(new PlusPanelViewModel.1(this, localbfaa, paramPlusPanelAppInfo), 128, null, false);
      }
      boolean bool = paramPlusPanelAppInfo.canRemove;
      a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramPlusPanelAppInfo.getAppID(), bool);
      if (localbfaa != null) {
        localbfaa.a(paramPlusPanelAppInfo.getAppID(), false, paramSessionInfo.curFriendUin);
      }
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    azvi localazvi;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (paramInt > 0)
    {
      localazvi = (azvi)paramBaseChatPie.app.getManager(36);
      localAppInfo = localazvi.a(10, String.valueOf(paramInt), paramBaseChatPie.sessionInfo.troopUin);
      if (localAppInfo != null)
      {
        if (paramBaseChatPie.sessionInfo.curType != 1) {
          break label67;
        }
        localazvi.a(localAppInfo.uiAppId.get(), 31);
      }
    }
    return;
    label67:
    localazvi.a(localAppInfo, "");
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_Ayfr.a(paramInt);
    if (!TextUtils.isEmpty(str)) {
      bcef.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, paramString, str, "", "");
    }
    if ((paramBoolean) && (paramInt != 0)) {
      bcef.b(paramQQAppInterface, "P_CliOper", "Grp_open", "", "my_app", "open_app", 0, 0, paramString, String.valueOf(paramInt), "", "");
    }
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.sessionInfo.curType != 1) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)paramBaseChatPie.app.getManager(52);
    if (localTroopManager.h(paramBaseChatPie.sessionInfo.troopUin))
    {
      localTroopManager.j(paramBaseChatPie.sessionInfo.troopUin);
      return true;
    }
    return false;
  }
  
  private void b(BaseChatPie paramBaseChatPie, ayfo paramayfo)
  {
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin, paramayfo);
  }
  
  private void c(BaseChatPie paramBaseChatPie, ayfo paramayfo)
  {
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo, paramayfo);
  }
  
  private void d(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curFriendUin);
  }
  
  private void e(BaseChatPie paramBaseChatPie)
  {
    if ((a(1106865772) != null) && (!TextUtils.isEmpty("https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio")))
    {
      String str = "https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio".replace("$GCODE$", awkh.a(paramBaseChatPie.sessionInfo.curFriendUin));
      Intent localIntent = paramBaseChatPie.getActivity().getIntent();
      localIntent.putExtra("url", str);
      localIntent.putExtra("confess_half_screen_web", true);
      if ((paramBaseChatPie instanceof TroopChatPie)) {
        this.jdField_c_of_type_Boolean = apsz.a(paramBaseChatPie);
      }
      a(paramBaseChatPie.app, 1106865772, paramBaseChatPie.sessionInfo.curFriendUin);
    }
  }
  
  public MutableLiveData<ArrayList<ayfo>> a()
  {
    return this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_Ayfr.a().observe(paramLifecycleOwner, new ayfv(this));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (this.jdField_a_of_type_Ayfr == null) {
      this.jdField_a_of_type_Ayfr = new ayfr();
    }
    this.jdField_a_of_type_Ayfr.a(paramBaseChatPie, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Ayfr.a(paramBaseChatPie.getClass());
  }
  
  public void a(BaseChatPie paramBaseChatPie, ayfo paramayfo)
  {
    if (a(paramBaseChatPie)) {}
    label166:
    label173:
    label193:
    for (;;)
    {
      return;
      SessionInfo localSessionInfo = paramBaseChatPie.sessionInfo;
      PlusPanelAppInfo localPlusPanelAppInfo = a(paramayfo.jdField_b_of_type_Int);
      if (localPlusPanelAppInfo != null)
      {
        int i;
        QQAppInterface localQQAppInterface;
        if (localSessionInfo.curType == 1)
        {
          i = 1;
          a(paramBaseChatPie, localPlusPanelAppInfo.getRedDotID());
          c(paramBaseChatPie, paramayfo);
          paramBaseChatPie.disableZhitu();
          localPlusPanelAppInfo.handlePanelClick(this, paramBaseChatPie, localSessionInfo);
          localQQAppInterface = paramBaseChatPie.app;
          if ((localSessionInfo.curType != 1001) && (localSessionInfo.curType != 10002)) {
            break label173;
          }
          if (localSessionInfo.curType != 1001) {
            break label166;
          }
          paramayfo = "0";
          label113:
          bcef.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_plus", 0, 0, paramayfo, this.jdField_a_of_type_Ayfr.b(localPlusPanelAppInfo.getAppID()), "", "");
        }
        for (;;)
        {
          if (i == 0) {
            break label193;
          }
          b(paramBaseChatPie);
          return;
          i = 0;
          break;
          paramayfo = "1";
          break label113;
          if (localSessionInfo.curType == 1) {
            a(localSessionInfo, localPlusPanelAppInfo, localQQAppInterface);
          }
        }
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<ayfo> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanelViewModel", 2, new Object[] { "onPlusPanelPageExpose", "Page ", Integer.valueOf(paramInt), " Stack: ", ypg.a(5) });
    }
    if ((paramList != null) && (paramList.size() == 0) && (this.jdField_c_of_type_Int == -1)) {
      this.jdField_c_of_type_Int = 1;
    }
    String str = paramBaseChatPie.sessionInfo.curFriendUin;
    paramList = paramList.iterator();
    label282:
    while (paramList.hasNext())
    {
      ayfo localayfo = (ayfo)paramList.next();
      b(paramBaseChatPie, localayfo);
      switch (localayfo.jdField_b_of_type_Int)
      {
      }
      for (;;)
      {
        if (localayfo.jdField_b_of_type_Int != 209) {
          break label282;
        }
        bcef.b(null, "dc00898", "", "", "0X800A11F", "0X800A11F", 0, 0, "", "", "", "");
        break;
        bftc.a(paramBaseChatPie.app, str, "Grp_chain", "ChainEntry_Show");
        continue;
        bftc.a(paramBaseChatPie.app, str, "MassMessage", "grpapp_Show");
        continue;
        d(paramBaseChatPie);
        bcef.b(paramBaseChatPie.app, "dc00898", "", paramBaseChatPie.sessionInfo.curFriendUin, "0X8009FCC", "0X8009FCC", 0, 0, "", "", "", "");
      }
    }
    if (paramInt == this.jdField_b_of_type_Int) {
      TroopGiftPanel.a(paramInt, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, Function0<Pair<List<ayfo>, Integer>> paramFunction0)
  {
    if (this.jdField_c_of_type_Int != 1) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Int = 0;
      try
      {
        paramFunction0 = (Pair)paramFunction0.invoke();
        List localList = (List)paramFunction0.first;
        int i = ((Integer)paramFunction0.second).intValue();
        if ((paramBaseChatPie == null) || (paramBaseChatPie.sessionInfo.curType != 1)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PlusPanelViewModel", 2, new Object[] { "onRedpointExpose", "Page ", Integer.valueOf(i), " Stack: ", ypg.a(5) });
        }
        paramFunction0 = localList.iterator();
        while (paramFunction0.hasNext()) {
          b(paramBaseChatPie, (ayfo)paramFunction0.next());
        }
        return;
      }
      catch (Exception paramBaseChatPie)
      {
        QLog.e("PlusPanelViewModel", 1, paramBaseChatPie, new Object[0]);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      c(paramBaseChatPie);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == 2) {
      bcef.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_exp", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 6)
      {
        bcef.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_exp", 0, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_Int != 7);
    bcef.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_exp", 0, 0, "", "", "", "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 1106717414) {
      bftc.a(paramQQAppInterface, paramString, "Grp_chain", "ChainEntry_Clk");
    }
    while (paramInt != 1106729451) {
      return;
    }
    bftc.a(paramQQAppInterface, paramString, "MassMessage", "grpapp_Clk");
  }
  
  void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ayfo paramayfo)
  {
    azvi localazvi = (azvi)paramQQAppInterface.getManager(36);
    if (!TextUtils.isEmpty(paramayfo.c)) {
      a(paramInt, paramayfo, localazvi);
    }
    int j;
    label102:
    int k;
    label110:
    boolean bool;
    if ((paramayfo.jdField_b_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramayfo.jdField_b_of_type_Int))))
    {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramayfo.jdField_b_of_type_Int));
      if ((paramInt != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramString))) {
        break label174;
      }
      i = 1;
      if (paramInt != 3000) {
        break label180;
      }
      j = 1;
      if (paramInt != 1) {
        break label186;
      }
      k = 1;
      bool = a(paramInt);
      if (i == 0) {
        break label192;
      }
      paramInt = 1;
      label124:
      j = paramayfo.jdField_b_of_type_Int;
      if (!paramayfo.jdField_a_of_type_Boolean) {
        break label227;
      }
    }
    label174:
    label180:
    label186:
    label192:
    label227:
    for (int i = 1;; i = 0)
    {
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800A46B", "0X800A46B", j, i, String.valueOf(paramInt), "", "", "");
      return;
      i = 0;
      break;
      j = 0;
      break label102;
      k = 0;
      break label110;
      if (j != 0)
      {
        paramInt = 2;
        break label124;
      }
      if (k != 0)
      {
        paramInt = 3;
        break label124;
      }
      if (bool)
      {
        paramInt = 4;
        break label124;
      }
      paramInt = 5;
      break label124;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ayfo paramayfo)
  {
    int k = 0;
    int i;
    int j;
    label44:
    boolean bool;
    if (paramayfo.jdField_b_of_type_Int > 0)
    {
      if ((paramSessionInfo.curType != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.curFriendUin))) {
        break label115;
      }
      i = 1;
      if (paramSessionInfo.curType != 3000) {
        break label121;
      }
      j = 1;
      bool = a(paramSessionInfo.curType);
      if (i == 0) {
        break label127;
      }
      i = 1;
    }
    for (;;)
    {
      int m = paramayfo.jdField_b_of_type_Int;
      j = k;
      if (paramayfo.jdField_a_of_type_Boolean) {
        j = 1;
      }
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800A46C", "0X800A46C", m, j, String.valueOf(i), "", "", "");
      return;
      label115:
      i = 0;
      break;
      label121:
      j = 0;
      break label44;
      label127:
      if (j != 0) {
        i = 2;
      } else if (paramSessionInfo.curType == 1) {
        i = 3;
      } else if (bool) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    if (localObject != null) {}
    for (localObject = ((TroopManager)localObject).b(paramString);; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = "" + ((TroopInfo)localObject).dwGroupClassExt;; localObject = "")
      {
        bcef.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009E24", "0X8009E24", 0, 0, "", "", "" + (String)localObject, "");
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Ayfr.a(paramString1, paramString2);
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = this.jdField_a_of_type_Ayfr.a();
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void b(LifecycleOwner paramLifecycleOwner)
  {
    if (this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData != null) {
      this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    if (this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData != null) {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    MutableLiveData localMutableLiveData = this.jdField_a_of_type_Ayfr.a();
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObservers(paramLifecycleOwner);
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = this.jdField_a_of_type_Ayfr.a(paramBaseChatPie);
    if ((paramBaseChatPie != null) && (!paramBaseChatPie.isEmpty())) {
      this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(paramBaseChatPie);
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        ((TroopChatPie)paramBaseChatPie).p();
      }
    }
    else
    {
      if (!this.jdField_c_of_type_Boolean) {
        break label32;
      }
      if (!QLog.isColorLevel()) {}
    }
    return;
    label32:
    this.jdField_b_of_type_Boolean = false;
    String str = paramBaseChatPie.sessionInfo.curFriendUin;
    if ((((TroopManager)paramBaseChatPie.app.getManager(52)).c(str).dwGroupFlagExt3 & 0x2000) == 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      QQToast.a(paramBaseChatPie.getActivity(), apsz.a, 0).a();
      return;
    }
    e(paramBaseChatPie);
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie);
    b(paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfu
 * JD-Core Version:    0.7.0.1
 */