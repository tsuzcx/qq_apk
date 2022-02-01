import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.share.IliveShareHelper;

public class bkjp
  implements afrc, afrr
{
  private long jdField_a_of_type_Long;
  private bkjn jdField_a_of_type_Bkjn = new bkjq(this);
  private bkjo jdField_a_of_type_Bkjo;
  private bkjr jdField_a_of_type_Bkjr;
  private bkjt jdField_a_of_type_Bkjt;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private boolean jdField_a_of_type_Boolean;
  
  public bkjp(afqw paramafqw, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_Bkjo = new bkjo(paramTroopChatPie, paramTroopChatPie.app, paramTroopChatPie.mActivity);
    this.jdField_a_of_type_Bkjr = new bkjr(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp());
    paramafqw.a(this);
  }
  
  private bkjo a()
  {
    if (this.jdField_a_of_type_Bkjo == null)
    {
      this.jdField_a_of_type_Bkjo = new bkjo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a(this.jdField_a_of_type_Bkjo);
      }
    }
    return this.jdField_a_of_type_Bkjo;
  }
  
  private void a(bkjs parambkjs)
  {
    parambkjs.a(this.jdField_a_of_type_Bkjn);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo == null)) {
      return;
    }
    QLog.i("IliveGroupTipsBarHelper", 1, "helper saveGroupInfo isLive = " + paramBoolean);
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp().getManager(52)).b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin)).setIsTroopLive(paramBoolean);
  }
  
  private void b(bkjs parambkjs)
  {
    e();
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject[0] == null) || (!(paramArrayOfObject[0] instanceof Integer))) {}
    do
    {
      do
      {
        return;
      } while (6 != ((Integer)paramArrayOfObject[0]).intValue());
      paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mContext.getResources().getDrawable(2130843909);
      paramArrayOfObject.setBounds(0, 0, UIUtils.dip2px(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mContext, 10.0F), UIUtils.dip2px(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mContext, 10.0F));
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().setImageDrawable(paramArrayOfObject);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "expose report");
      }
      IliveShareHelper.reportAction("qq_live", "live_group_page", "live_group", "group_bar", "4", 101, IliveShareHelper.getFollowInfo("", "", "", "", ""));
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void c(bkjs parambkjs)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(52);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
    localObject = ((TroopManager)localObject).b(str);
    if ((localObject != null) && (((TroopInfo)localObject).isTroopIlive())) {
      parambkjs.a(str, bkjs.a);
    }
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject[0] == null) || (!(paramArrayOfObject[0] instanceof Integer))) {}
    do
    {
      do
      {
        return;
      } while (6 != ((Integer)paramArrayOfObject[0]).intValue());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b() == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b().setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.s();
  }
  
  private void d(bkjs parambkjs)
  {
    e();
    parambkjs.b(this.jdField_a_of_type_Bkjn);
    this.jdField_a_of_type_Bkjt = null;
  }
  
  private void e()
  {
    QLog.i("IliveGroupTipsBarHelper", 1, "removeGetGroupData");
    if (this.jdField_a_of_type_Bkjr != null) {
      this.jdField_a_of_type_Bkjr.removeCallbacksAndMessages(null);
    }
  }
  
  private void f()
  {
    if ((bkjs.a()) && (this.jdField_a_of_type_Bkjt != null) && (this.jdField_a_of_type_Bkjt.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bkjt.jdField_a_of_type_Int >= 5))
    {
      QLog.i("IliveGroupTipsBarHelper", 1, "start delayGetGroupData time = " + this.jdField_a_of_type_Bkjt.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Bkjr.hasMessages(1)) {
        this.jdField_a_of_type_Bkjr.removeMessages(1);
      }
      this.jdField_a_of_type_Bkjt.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
      Message localMessage = Message.obtain();
      localMessage.obj = this.jdField_a_of_type_Bkjt;
      localMessage.what = 1;
      this.jdField_a_of_type_Bkjr.sendMessageDelayed(localMessage, this.jdField_a_of_type_Bkjt.jdField_a_of_type_Int * 1000);
    }
  }
  
  public String a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity.getResources().getString(2131689889);
    if (paramBoolean) {
      str = amtj.a(2131693395);
    }
    return str;
  }
  
  public void a()
  {
    a();
    this.jdField_a_of_type_Bkjo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
  }
  
  public void a(int paramInt)
  {
    QLog.e("IliveGroupTipsBarHelper", 1, "onMoveToState state = " + paramInt);
    bkjs localbkjs = (bkjs)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp().getManager(386);
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 7: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return;
    case 3: 
      a(localbkjs);
      return;
    case 8: 
      a();
      return;
    case 5: 
      c(localbkjs);
      return;
    case 9: 
      b(localbkjs);
      return;
    }
    d(localbkjs);
  }
  
  public void a(int paramInt, Object[] paramArrayOfObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramArrayOfObject);
      return;
    case 2: 
      c(paramArrayOfObject);
      return;
    }
    b(paramArrayOfObject);
  }
  
  public void a(ahqq paramahqq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "onOtherTipsHide tip=" + paramahqq);
    }
    if ((this.jdField_a_of_type_Bkjo != null) && (this.jdField_a_of_type_Bkjo != paramahqq))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "onOtherTipsHide tip not equal IliveGroupTipsBar");
      }
      b();
      d();
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject[0] == null) || (!(paramArrayOfObject[0] instanceof Integer))) {}
    while ((6 != ((Integer)paramArrayOfObject[0]).intValue()) || (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L)) {
      return;
    }
    if (a()) {
      c();
    }
    for (;;)
    {
      d();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      b();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a() != this.jdField_a_of_type_Bkjo) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "curTip is liveGroupTips");
    }
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 3, 8, 9, 5, 13 };
  }
  
  public void b()
  {
    boolean bool1 = ((avcl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(33)).c();
    boolean bool2 = ((afsw)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(43)).c();
    boolean bool3 = ((ahql)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(75)).d();
    boolean bool4 = d();
    QLog.i("IliveGroup", 1, "isListenTogetherTime = " + bool1 + " isTogetherTime = " + bool2 + " showStudyRoomTime = " + bool3 + " isLiveTime = " + bool4);
    if ((bool4) && ((bool1) || (bool2) || (bool3))) {
      c();
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "showTip");
    }
    if (!d()) {}
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null");
      return false;
      ahqq localahqq = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
      if ((localahqq == null) || (localahqq == this.jdField_a_of_type_Bkjo)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IliveGroupTipsBarHelper", 2, "currTip is other");
    return false;
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a(this.jdField_a_of_type_Bkjo, new Object[0]);
    this.jdField_a_of_type_Bkjo.a(this.jdField_a_of_type_Bkjt);
    d();
    f();
    return true;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "dismiss liveGroupTips");
    }
    if ((this.jdField_a_of_type_Bkjo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null or liveGroupTips is null");
      }
    }
    ahqq localahqq;
    do
    {
      return false;
      localahqq = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
    } while ((localahqq == null) || (localahqq != this.jdField_a_of_type_Bkjo));
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "currTip is liveGroupTips");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
    d();
    e();
    return true;
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bkjt != null) && (this.jdField_a_of_type_Bkjt.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjp
 * JD-Core Version:    0.7.0.1
 */