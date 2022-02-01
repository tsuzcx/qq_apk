import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class bgos
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 0L;
  protected Context a;
  protected Drawable a;
  protected bfhz a;
  protected bfxw a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected HashMap<Integer, bgoy> a;
  protected Drawable b;
  protected Drawable c;
  
  public bgos(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, bfhz parambfhz, bfxw parambfxw)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bfhz = parambfhz;
    this.jdField_a_of_type_Bfxw = parambfxw;
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    }
    return 0;
  }
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2)) != null) {
      return null;
    }
    int i = a(paramTroopFeedItem.type);
    bgoy localbgoy2 = (bgoy)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    bgoy localbgoy1 = localbgoy2;
    if (localbgoy2 == null)
    {
      localbgoy1 = a(i);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localbgoy1);
    }
    if (localbgoy1 != null) {
      return localbgoy1.a(paramTroopFeedItem, paramInt, paramBoolean);
    }
    return null;
  }
  
  protected bgoy a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new bgov(this);
    case 0: 
      return new bgov(this);
    }
    return new bgoz(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(2));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof bgou)) {
      this.jdField_a_of_type_Bfxw.b(true);
    }
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < this.jdField_a_of_type_Int)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i;
    if ((localTroopInfo != null) && (str != null)) {
      if (str.equals(localTroopInfo.troopowneruin)) {
        i = 0;
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("url", String.format("https://web.qun.qq.com/qqweb/m/qun/notification/index.html?gc=%s&role=%d&_bid=2223&_wv=1031", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, Integer.valueOf(i) }));
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      localObject = paramView.getTag();
      if (!(localObject instanceof bgox)) {
        break;
      }
      localObject = ((bgox)localObject).a;
      if ((localObject == null) || (!((TroopFeedItem)localObject).isStoryType())) {
        break;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_story_pgc", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
      break;
      if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(str))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgos
 * JD-Core Version:    0.7.0.1
 */