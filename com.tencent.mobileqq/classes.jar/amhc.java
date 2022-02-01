import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.1;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class amhc
  extends amgy
{
  private amhf jdField_a_of_type_Amhf;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new amhd(this);
  anri jdField_a_of_type_Anri;
  private antp jdField_a_of_type_Antp;
  private anvk jdField_a_of_type_Anvk;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private List<amhe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public amhc(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<RecentUser> paramList, amhf paramamhf)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, false);
    a(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Amhf = paramamhf;
    a(paramList);
  }
  
  private ArrayList<amhe> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = 0;
    RecentUser localRecentUser;
    String str;
    int i;
    Object localObject2;
    if (j < paramList.size())
    {
      localRecentUser = (RecentUser)paramList.get(j);
      amhe localamhe = new amhe();
      str = localRecentUser.uin;
      i = localRecentUser.getType();
      switch (localRecentUser.getType())
      {
      default: 
        i = 1;
        localObject1 = null;
      case 6002: 
        for (;;)
        {
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = str;
          }
          localamhe.jdField_a_of_type_JavaLangString = ((String)localObject2);
          localamhe.jdField_a_of_type_Int = i;
          localamhe.b = str;
          localamhe.jdField_a_of_type_ComTencentMobileqqDataRecentUser = localRecentUser;
          localArrayList.add(localamhe);
          j += 1;
          break;
          localObject1 = localRecentUser.displayName;
          i = 104;
        }
      case 1008: 
        label308:
        localObject1 = ((aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(str);
        if (localObject1 == null) {
          break;
        }
      }
    }
    for (Object localObject1 = ((PublicAccountInfo)localObject1).name;; localObject1 = null)
    {
      i = 1;
      break;
      localObject1 = ContactUtils.getUinByPhoneNum(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      localObject2 = ((awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c(str);
      if (localObject2 != null) {
        localObject1 = ((PhoneContact)localObject2).name;
      }
      for (;;)
      {
        i = 11;
        break;
        if (localObject1 != null) {
          localObject1 = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        } else {
          localObject1 = str;
        }
      }
      localObject1 = this.jdField_a_of_type_Anvk.e(str);
      if ((localObject1 != null) && (((Friends)localObject1).uin != null) && (((Friends)localObject1).uin.length() > 0)) {}
      for (localObject1 = ContactUtils.getFriendName((Friends)localObject1);; localObject1 = null)
      {
        if ((i == 1000) || (i == 1020))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localRecentUser.troopUin);
          localObject1 = ContactUtils.getTroopNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (String)localObject1, localRecentUser.troopUin, true, null);
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (!"".equals(localObject1)) {}
          }
          else
          {
            localObject2 = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
          }
          localObject1 = localObject2;
          i = 1;
          break;
          if (i == 1004) {
            localObject1 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.troopUin, str);
          }
        }
        if ((0 == 0) || ("".equals(null))) {}
        for (localObject1 = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);; localObject1 = null)
        {
          i = 1;
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(str);
          int k = 4;
          if (localObject1 != null) {}
          for (localObject2 = ((TroopInfo)localObject1).getTroopName();; localObject2 = localRecentUser.displayName)
          {
            if (localObject2 != null)
            {
              i = k;
              localObject1 = localObject2;
              if (!((String)localObject2).trim().equals("")) {
                break;
              }
            }
            localObject1 = str;
            i = k;
            break;
          }
          localObject1 = this.jdField_a_of_type_Antp.a(str);
          if ((localObject1 == null) || (((DiscussionInfo)localObject1).isHidden())) {
            break label308;
          }
          if (TextUtils.isEmpty(((DiscussionInfo)localObject1).discussionName)) {}
          for (localObject1 = localRecentUser.displayName;; localObject1 = ((DiscussionInfo)localObject1).discussionName)
          {
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691722);
            }
            localObject1 = localObject2;
            i = 101;
            break;
          }
          return localArrayList;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anri = ((anri)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.jdField_a_of_type_Anvk = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_Antp = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
  }
  
  public void a(List<RecentUser> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new ForwardRecentListAdapter.1(this, paramList));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ForwardRecentItemView localForwardRecentItemView;
    Object localObject1;
    amhe localamhe;
    BitmapDrawable localBitmapDrawable;
    boolean bool3;
    Object localObject2;
    if (paramView == null)
    {
      localForwardRecentItemView = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      localObject1 = new amgz();
      localForwardRecentItemView.setTag(localObject1);
      localamhe = (amhe)getItem(paramInt);
      ((amgz)localObject1).jdField_a_of_type_JavaLangString = localamhe.b;
      ((amgz)localObject1).jdField_c_of_type_Int = localamhe.jdField_a_of_type_Int;
      ((amgz)localObject1).jdField_c_of_type_AndroidWidgetImageView = localForwardRecentItemView.jdField_a_of_type_AndroidWidgetImageView;
      localBitmapDrawable = new BitmapDrawable(a(localamhe.jdField_a_of_type_Int, localamhe.b));
      bool3 = this.jdField_a_of_type_Amhf.a(localamhe.b, localamhe.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType());
      localObject2 = localForwardRecentItemView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ResultRecord();
      }
      ((ResultRecord)localObject1).init(localamhe.b, localamhe.jdField_a_of_type_JavaLangString, localamhe.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), localamhe.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, "");
      if (localamhe.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType() != 3000) {
        break label323;
      }
      localObject2 = this.jdField_a_of_type_Antp.a(localamhe.b);
      if ((localObject2 == null) || (((DiscussionInfo)localObject2).hasRenamed())) {
        break label299;
      }
      localForwardRecentItemView.a(localamhe.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Antp.a(localamhe.b)), localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool3);
    }
    for (;;)
    {
      localForwardRecentItemView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localForwardRecentItemView;
      localForwardRecentItemView = (ForwardRecentItemView)paramView;
      localObject1 = (amgz)localForwardRecentItemView.getTag();
      break;
      label299:
      localForwardRecentItemView.a(localamhe.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool3);
      continue;
      label323:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localamhe.b);
      if ((localObject2 != null) && (!((TroopInfo)localObject2).hasSetTroopName()) && (((TroopInfo)localObject2).wMemberNumClient > 0))
      {
        localForwardRecentItemView.a(localamhe.jdField_a_of_type_JavaLangString, String.valueOf(((TroopInfo)localObject2).wMemberNumClient), localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool3);
      }
      else
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject2 == null)
        {
          bool1 = bool2;
          if (bghs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localamhe.b)) {
            bool1 = true;
          }
        }
        localForwardRecentItemView.a(localamhe.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool3, bool1);
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardRecentListAdapter", 2, "notifyDataSetChanged() called");
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhc
 * JD-Core Version:    0.7.0.1
 */