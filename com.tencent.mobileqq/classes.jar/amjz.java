import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.adapter.TroopListAdapter2.2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.5;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class amjz
  extends amgy
  implements CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 0;
  ajfa jdField_a_of_type_Ajfa;
  amke jdField_a_of_type_Amke;
  Context jdField_a_of_type_AndroidContentContext;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected antp a;
  protected aofu a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopManager a;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  protected HashMap<String, Switch> a;
  public List<amkg> a;
  protected boolean a;
  public int b;
  protected View.OnClickListener b;
  protected List<Entity> b;
  protected boolean b;
  public int c;
  public boolean c;
  public int d;
  protected boolean d;
  public int e;
  public int f;
  public int g;
  
  public amjz(Context paramContext, QQAppInterface paramQQAppInterface, amke paramamke, XListView paramXListView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ajfa paramajfa)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new amkb(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new amkc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amke = paramamke;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Ajfa = paramajfa;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_Antp = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof TroopActivity)))
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_Aofu = new amka(this, (TroopActivity)this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  private List<amkg> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    this.jdField_b_of_type_JavaUtilList = ((TroopManager)localObject1).a();
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      return localArrayList;
    }
    Object localObject5 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).a();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new amkd());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject5).add(((TroopManager)localObject1).b(((CommonlyUsedTroop)((Iterator)localObject2).next()).troopUin));
      }
      this.e = ((List)localObject5).size();
    }
    Object localObject4 = new ArrayList();
    Object localObject3 = new ArrayList();
    localObject2 = new ArrayList();
    Object localObject6 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject7 = this.jdField_b_of_type_JavaUtilList.iterator();
    label396:
    while (((Iterator)localObject7).hasNext())
    {
      localObject8 = (TroopInfo)((Iterator)localObject7).next();
      int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(((TroopInfo)localObject8).troopuin));
      if (((TroopInfo)localObject8).isQidianPrivateTroop())
      {
        ((List)localObject1).add(new amkh(i, (Entity)localObject8));
      }
      else
      {
        if ((((TroopInfo)localObject8).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new amkh(i, (Entity)localObject8));
        }
        for (;;)
        {
          if (((TroopInfo)localObject8).hasSetTroopName()) {
            break label396;
          }
          ((List)localObject6).add(new amkh(i, (Entity)localObject8));
          break;
          if ((((TroopInfo)localObject8).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject3).add(new amkh(i, (Entity)localObject8));
          } else {
            ((List)localObject2).add(new amkh(i, (Entity)localObject8));
          }
        }
      }
    }
    localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    Object localObject8 = ((antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
    if (this.jdField_d_of_type_Boolean)
    {
      localObject8 = ((List)localObject8).iterator();
      label598:
      while (((Iterator)localObject8).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject8).next();
        RecentUser localRecentUser = (RecentUser)((aoxz)localObject7).findRecentUserByUin(localDiscussionInfo.uin, 3000);
        localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
        if (localRecentUser.showUpTime != 0L) {
          ((List)localObject5).add(localDiscussionInfo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(localDiscussionInfo.ownerUin)) {
          ((List)localObject4).add(new amkh(1, localDiscussionInfo));
        }
        for (;;)
        {
          if (localDiscussionInfo.hasRenamed()) {
            break label598;
          }
          ((List)localObject6).add(new amkh(1, localDiscussionInfo));
          break;
          ((List)localObject2).add(new amkh(1, localDiscussionInfo));
        }
      }
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      ((List)localObject5).clear();
      ((List)localObject2).clear();
      ((List)localObject6).clear();
      ((List)localObject1).clear();
    }
    this.e = ((List)localObject5).size();
    this.jdField_b_of_type_Int = ((List)localObject4).size();
    this.jdField_d_of_type_Int = ((List)localObject2).size();
    this.f = ((List)localObject6).size();
    localObject7 = new amkf();
    Collections.sort((List)localObject4, (Comparator)localObject7);
    Collections.sort((List)localObject3, (Comparator)localObject7);
    Collections.sort((List)localObject2, (Comparator)localObject7);
    Collections.sort((List)localObject6, (Comparator)localObject7);
    Collections.sort((List)localObject1, (Comparator)localObject7);
    if (this.e > 0)
    {
      localArrayList.add(new amkg(0, null));
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject5).next();
        if ((localObject7 instanceof TroopInfo))
        {
          localArrayList.add(new amkg(1, (Entity)localObject7));
        }
        else if ((localObject7 instanceof DiscussionInfo))
        {
          localObject7 = (DiscussionInfo)localObject7;
          localArrayList.add(new amkg(1, (DiscussionInfo)localObject7, this.jdField_a_of_type_Antp.a(((DiscussionInfo)localObject7).uin)));
        }
      }
    }
    if (this.f > 0)
    {
      localArrayList.add(new amkg(8, null));
      localObject5 = ((List)localObject6).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (amkh)((Iterator)localObject5).next();
        if ((((amkh)localObject6).a instanceof TroopInfo))
        {
          localArrayList.add(new amkg(9, ((amkh)localObject6).a));
        }
        else if ((((amkh)localObject6).a instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)((amkh)localObject6).a;
          localArrayList.add(new amkg(9, (DiscussionInfo)localObject6, this.jdField_a_of_type_Antp.a(((DiscussionInfo)localObject6).uin)));
        }
      }
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      localArrayList.add(new amkg(4, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (amkh)((Iterator)localObject4).next();
        if ((((amkh)localObject5).a instanceof TroopInfo))
        {
          localArrayList.add(new amkg(5, ((amkh)localObject5).a));
        }
        else if ((((amkh)localObject5).a instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((amkh)localObject5).a;
          localArrayList.add(new amkg(5, (DiscussionInfo)localObject5, this.jdField_a_of_type_Antp.a(((DiscussionInfo)localObject5).uin)));
        }
      }
    }
    this.jdField_c_of_type_Int = ((List)localObject3).size();
    if (this.jdField_c_of_type_Int > 0)
    {
      localArrayList.add(new amkg(6, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(new amkg(7, ((amkh)((Iterator)localObject3).next()).a));
      }
    }
    if (this.jdField_d_of_type_Int > 0)
    {
      localArrayList.add(new amkg(2, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (amkh)((Iterator)localObject2).next();
        if ((((amkh)localObject3).a instanceof TroopInfo))
        {
          localArrayList.add(new amkg(3, ((amkh)localObject3).a));
        }
        else if ((((amkh)localObject3).a instanceof DiscussionInfo))
        {
          localObject3 = (DiscussionInfo)((amkh)localObject3).a;
          localArrayList.add(new amkg(3, (DiscussionInfo)localObject3, this.jdField_a_of_type_Antp.a(((DiscussionInfo)localObject3).uin)));
        }
      }
    }
    this.g = ((List)localObject1).size();
    if (this.g > 0)
    {
      localArrayList.add(new amkg(10, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(new amkg(11, ((amkh)((Iterator)localObject1).next()).a));
      }
    }
    return localArrayList;
  }
  
  private void a(amkg paramamkg, String paramString, boolean paramBoolean)
  {
    ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramString, paramamkg.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramBoolean, false);
    if (paramBoolean) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramamkg.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ajfa != null) {
        this.jdField_a_of_type_Ajfa.a(paramamkg.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramBoolean);
      }
      return;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramamkg.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((amkg)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    }
    return null;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_Boolean = true;
    Object localObject1 = (amkg)getItem(paramInt);
    amki localamki;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559937, paramViewGroup, false);
      localamki = new amki(paramView);
      paramView.setTag(localamki);
      ((Button)paramView.findViewById(2131379430)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_Boolean) {
        localamki.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      localamki.jdField_a_of_type_Amkg = ((amkg)localObject1);
      if ((this.jdField_a_of_type_Boolean) && (localamki.jdField_a_of_type_Amkg.jdField_a_of_type_Int != 0) && (localamki.jdField_a_of_type_Amkg.jdField_a_of_type_Int != 4) && (localamki.jdField_a_of_type_Amkg.jdField_a_of_type_Int != 6) && (localamki.jdField_a_of_type_Amkg.jdField_a_of_type_Int != 8) && (localamki.jdField_a_of_type_Amkg.jdField_a_of_type_Int != 2))
      {
        localamki.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
        localamki.jdField_a_of_type_ComTencentWidgetSwitch.setTag(localamki.jdField_a_of_type_Amkg);
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) || (localamki.jdField_a_of_type_Amkg.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(((amkg)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {
          break label380;
        }
        localamki.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        label255:
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (((amkg)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(((amkg)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, localamki.jdField_a_of_type_ComTencentWidgetSwitch);
        }
      }
      if (((amkg)localObject1).jdField_a_of_type_Int != 0) {
        break label392;
      }
      localamki.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localamki.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localamki.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131714840));
      localamki.e.setText(String.valueOf(this.e));
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localamki = (amki)paramView.getTag();
      break;
      label380:
      localamki.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      break label255;
      label392:
      if (((amkg)localObject1).jdField_a_of_type_Int == 2)
      {
        localamki.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamki.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamki.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131715179));
        localamki.e.setText(String.valueOf(this.jdField_d_of_type_Int));
      }
      else if (((amkg)localObject1).jdField_a_of_type_Int == 4)
      {
        localamki.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamki.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamki.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131715183));
        localamki.e.setText(String.valueOf(this.jdField_b_of_type_Int));
      }
      else if (((amkg)localObject1).jdField_a_of_type_Int == 6)
      {
        localamki.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamki.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamki.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131715186));
        localamki.e.setText(String.valueOf(this.jdField_c_of_type_Int));
      }
      else if (((amkg)localObject1).jdField_a_of_type_Int == 8)
      {
        localamki.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamki.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamki.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131715184));
        localamki.e.setText(String.valueOf(this.f));
      }
      else if (((amkg)localObject1).jdField_a_of_type_Int == 10)
      {
        localamki.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamki.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamki.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131702064));
        localamki.e.setText(String.valueOf(this.g));
      }
      else
      {
        Object localObject2;
        if (((amkg)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          localamki.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localamki.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localObject2 = ((amkg)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          localamki.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(((TroopInfo)localObject2).troopuin) != 3)
          {
            localamki.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            label764:
            TextView localTextView = localamki.jdField_a_of_type_AndroidWidgetTextView;
            if (TextUtils.isEmpty(((TroopInfo)localObject2).getTroopName())) {
              break label981;
            }
            localObject1 = ((TroopInfo)localObject2).getTroopName();
            label789:
            localTextView.setText((CharSequence)localObject1);
            localamki.c.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
            if ((((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
              break label991;
            }
            localamki.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localamki.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
            label868:
            if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
              break label1050;
            }
            if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
              break label1004;
            }
            localamki.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
            localamki.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843910);
          }
          label1050:
          for (;;)
          {
            if (((TroopInfo)localObject2).troopCreditLevel != 2L) {
              break label1063;
            }
            localamki.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localamki.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localamki.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850476);
            break;
            localamki.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localamki.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850473);
            break label764;
            label981:
            localObject1 = ((TroopInfo)localObject2).troopuin;
            break label789;
            label991:
            localamki.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            break label868;
            label1004:
            if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
            {
              localamki.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
              localamki.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843910);
            }
            else
            {
              localamki.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              continue;
              localamki.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          label1063:
          if (((TroopInfo)localObject2).troopCreditLevel == 1L)
          {
            localamki.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localamki.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localamki.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850474);
          }
          else
          {
            localamki.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          }
        }
        else if (((amkg)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
        {
          localamki.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localamki.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localObject2 = ((amkg)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
          localamki.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject2).uin;
          localamki.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localamki.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.getDiscussionName(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject2));
          if (!((DiscussionInfo)localObject2).hasRenamed())
          {
            localamki.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localamki.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((amkg)localObject1).jdField_b_of_type_Int) }));
          }
          localamki.c.setImageBitmap(a(101, ((DiscussionInfo)localObject2).uin));
        }
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    ThreadManager.post(new TroopListAdapter2.2(this), 8, null, true);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      Object localObject = paramCompoundButton.getTag();
      if ((localObject instanceof amkg))
      {
        localObject = (amkg)localObject;
        if (((amkg)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
          }
          String str1 = ((amkg)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
          String str2 = ((amkg)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
          TroopManager localTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
          if (TextUtils.isEmpty(str1)) {
            ThreadManager.post(new TroopListAdapter2.5(this, localTroopManager, str2, (amkg)localObject, paramBoolean), 8, null, true);
          } else {
            a((amkg)localObject, str1, paramBoolean);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjz
 * JD-Core Version:    0.7.0.1
 */