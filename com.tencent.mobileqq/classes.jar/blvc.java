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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.share.IliveShareHelper;

public class blvc
  implements agin, agjc
{
  private long jdField_a_of_type_Long;
  private blva jdField_a_of_type_Blva = new blvd(this);
  private blvb jdField_a_of_type_Blvb;
  private blve jdField_a_of_type_Blve;
  private blvg jdField_a_of_type_Blvg;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private boolean jdField_a_of_type_Boolean;
  
  public blvc(agih paramagih, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_Blvb = new blvb(paramTroopChatPie, paramTroopChatPie.app, paramTroopChatPie.mActivity);
    this.jdField_a_of_type_Blve = new blve(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp());
    paramagih.a(this);
  }
  
  private blvb a()
  {
    if (this.jdField_a_of_type_Blvb == null)
    {
      this.jdField_a_of_type_Blvb = new blvb(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a(this.jdField_a_of_type_Blvb);
      }
    }
    return this.jdField_a_of_type_Blvb;
  }
  
  private void a(blvf paramblvf)
  {
    paramblvf.a(this.jdField_a_of_type_Blva);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo == null)) {
      return;
    }
    QLog.i("IliveGroupTipsBarHelper", 1, "helper saveGroupInfo isLive = " + paramBoolean);
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp().getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin)).setIsTroopLive(paramBoolean);
  }
  
  private void b(blvf paramblvf)
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
      paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mContext.getResources().getDrawable(2130843949);
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
  
  private void c(blvf paramblvf)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
    localObject = ((TroopManager)localObject).b(str);
    if ((localObject != null) && (((TroopInfo)localObject).isTroopIlive())) {
      paramblvf.a(str, blvf.a);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.v();
  }
  
  private void d(blvf paramblvf)
  {
    e();
    paramblvf.b(this.jdField_a_of_type_Blva);
    this.jdField_a_of_type_Blvg = null;
  }
  
  private void e()
  {
    QLog.i("IliveGroupTipsBarHelper", 1, "removeGetGroupData");
    if (this.jdField_a_of_type_Blve != null) {
      this.jdField_a_of_type_Blve.removeCallbacksAndMessages(null);
    }
  }
  
  private void f()
  {
    if ((blvf.a()) && (this.jdField_a_of_type_Blvg != null) && (this.jdField_a_of_type_Blvg.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Blvg.jdField_a_of_type_Int >= 5))
    {
      QLog.i("IliveGroupTipsBarHelper", 1, "start delayGetGroupData time = " + this.jdField_a_of_type_Blvg.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Blve.hasMessages(1)) {
        this.jdField_a_of_type_Blve.removeMessages(1);
      }
      this.jdField_a_of_type_Blvg.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
      Message localMessage = Message.obtain();
      localMessage.obj = this.jdField_a_of_type_Blvg;
      localMessage.what = 1;
      this.jdField_a_of_type_Blve.sendMessageDelayed(localMessage, this.jdField_a_of_type_Blvg.jdField_a_of_type_Int * 1000);
    }
  }
  
  public String a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity.getResources().getString(2131689918);
    if (paramBoolean) {
      str = anvx.a(2131693576);
    }
    return str;
  }
  
  public void a()
  {
    a();
    this.jdField_a_of_type_Blvb.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
  }
  
  public void a(int paramInt)
  {
    QLog.e("IliveGroupTipsBarHelper", 1, "onMoveToState state = " + paramInt);
    blvf localblvf = (blvf)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getApp().getManager(QQManagerFactory.ILIVE_GROUP_TIPS_MANAGER);
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return;
    case 4: 
      a(localblvf);
      return;
    case 9: 
      a();
      return;
    case 6: 
      c(localblvf);
      return;
    case 10: 
      b(localblvf);
      return;
    }
    d(localblvf);
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
  
  public void a(ailp paramailp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "onOtherTipsHide tip=" + paramailp);
    }
    if ((this.jdField_a_of_type_Blvb != null) && (this.jdField_a_of_type_Blvb != paramailp))
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
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a() != this.jdField_a_of_type_Blvb) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "curTip is liveGroupTips");
    }
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 4, 9, 10, 6, 14 };
  }
  
  public void b()
  {
    boolean bool1 = ((awio)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(33)).c();
    boolean bool2 = ((agkk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(43)).c();
    boolean bool3 = ((ailk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getHelper(75)).d();
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
      ailp localailp = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
      if ((localailp == null) || (localailp == this.jdField_a_of_type_Blvb)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IliveGroupTipsBarHelper", 2, "currTip is other");
    return false;
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a(this.jdField_a_of_type_Blvb, new Object[0]);
    this.jdField_a_of_type_Blvb.a(this.jdField_a_of_type_Blvg);
    d();
    f();
    return true;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "dismiss liveGroupTips");
    }
    if ((this.jdField_a_of_type_Blvb == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null or liveGroupTips is null");
      }
    }
    ailp localailp;
    do
    {
      return false;
      localailp = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getTipManager().a();
    } while ((localailp == null) || (localailp != this.jdField_a_of_type_Blvb));
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
    return (this.jdField_a_of_type_Blvg != null) && (this.jdField_a_of_type_Blvg.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvc
 * JD-Core Version:    0.7.0.1
 */