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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
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

public class amfk
  extends amck
  implements CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 0;
  ajef jdField_a_of_type_Ajef;
  amfp jdField_a_of_type_Amfp;
  Context jdField_a_of_type_AndroidContentContext;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected ankw a;
  protected anxg a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopManager a;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  protected HashMap<String, Switch> a;
  public List<amfr> a;
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
  
  public amfk(Context paramContext, QQAppInterface paramQQAppInterface, amfp paramamfp, XListView paramXListView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ajef paramajef)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new amfm(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new amfn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amfp = paramamfp;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Ajef = paramajef;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(52));
    this.jdField_a_of_type_Ankw = ((ankw)paramQQAppInterface.getManager(53));
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof TroopActivity)))
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_Anxg = new amfl(this, (TroopActivity)this.jdField_a_of_type_AndroidContentContext);
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
  
  private List<amfr> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
      Collections.sort((List)localObject2, new amfo());
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
    label395:
    while (((Iterator)localObject7).hasNext())
    {
      localObject8 = (TroopInfo)((Iterator)localObject7).next();
      int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject8).troopuin));
      if (((TroopInfo)localObject8).isQidianPrivateTroop())
      {
        ((List)localObject1).add(new amfs(i, (Entity)localObject8));
      }
      else
      {
        if ((((TroopInfo)localObject8).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new amfs(i, (Entity)localObject8));
        }
        for (;;)
        {
          if (((TroopInfo)localObject8).hasSetTroopName()) {
            break label395;
          }
          ((List)localObject6).add(new amfs(i, (Entity)localObject8));
          break;
          if ((((TroopInfo)localObject8).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject3).add(new amfs(i, (Entity)localObject8));
          } else {
            ((List)localObject2).add(new amfs(i, (Entity)localObject8));
          }
        }
      }
    }
    localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    Object localObject8 = ((ankw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a();
    if (this.jdField_d_of_type_Boolean)
    {
      localObject8 = ((List)localObject8).iterator();
      label596:
      while (((Iterator)localObject8).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject8).next();
        RecentUser localRecentUser = (RecentUser)((aong)localObject7).findRecentUserByUin(localDiscussionInfo.uin, 3000);
        localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
        if (localRecentUser.showUpTime != 0L) {
          ((List)localObject5).add(localDiscussionInfo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(localDiscussionInfo.ownerUin)) {
          ((List)localObject4).add(new amfs(1, localDiscussionInfo));
        }
        for (;;)
        {
          if (localDiscussionInfo.hasRenamed()) {
            break label596;
          }
          ((List)localObject6).add(new amfs(1, localDiscussionInfo));
          break;
          ((List)localObject2).add(new amfs(1, localDiscussionInfo));
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
    localObject7 = new amfq();
    Collections.sort((List)localObject4, (Comparator)localObject7);
    Collections.sort((List)localObject3, (Comparator)localObject7);
    Collections.sort((List)localObject2, (Comparator)localObject7);
    Collections.sort((List)localObject6, (Comparator)localObject7);
    Collections.sort((List)localObject1, (Comparator)localObject7);
    if (this.e > 0)
    {
      localArrayList.add(new amfr(0, null));
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject5).next();
        if ((localObject7 instanceof TroopInfo))
        {
          localArrayList.add(new amfr(1, (Entity)localObject7));
        }
        else if ((localObject7 instanceof DiscussionInfo))
        {
          localObject7 = (DiscussionInfo)localObject7;
          localArrayList.add(new amfr(1, (DiscussionInfo)localObject7, this.jdField_a_of_type_Ankw.a(((DiscussionInfo)localObject7).uin)));
        }
      }
    }
    if (this.f > 0)
    {
      localArrayList.add(new amfr(8, null));
      localObject5 = ((List)localObject6).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (amfs)((Iterator)localObject5).next();
        if ((((amfs)localObject6).a instanceof TroopInfo))
        {
          localArrayList.add(new amfr(9, ((amfs)localObject6).a));
        }
        else if ((((amfs)localObject6).a instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)((amfs)localObject6).a;
          localArrayList.add(new amfr(9, (DiscussionInfo)localObject6, this.jdField_a_of_type_Ankw.a(((DiscussionInfo)localObject6).uin)));
        }
      }
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      localArrayList.add(new amfr(4, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (amfs)((Iterator)localObject4).next();
        if ((((amfs)localObject5).a instanceof TroopInfo))
        {
          localArrayList.add(new amfr(5, ((amfs)localObject5).a));
        }
        else if ((((amfs)localObject5).a instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((amfs)localObject5).a;
          localArrayList.add(new amfr(5, (DiscussionInfo)localObject5, this.jdField_a_of_type_Ankw.a(((DiscussionInfo)localObject5).uin)));
        }
      }
    }
    this.jdField_c_of_type_Int = ((List)localObject3).size();
    if (this.jdField_c_of_type_Int > 0)
    {
      localArrayList.add(new amfr(6, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(new amfr(7, ((amfs)((Iterator)localObject3).next()).a));
      }
    }
    if (this.jdField_d_of_type_Int > 0)
    {
      localArrayList.add(new amfr(2, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (amfs)((Iterator)localObject2).next();
        if ((((amfs)localObject3).a instanceof TroopInfo))
        {
          localArrayList.add(new amfr(3, ((amfs)localObject3).a));
        }
        else if ((((amfs)localObject3).a instanceof DiscussionInfo))
        {
          localObject3 = (DiscussionInfo)((amfs)localObject3).a;
          localArrayList.add(new amfr(3, (DiscussionInfo)localObject3, this.jdField_a_of_type_Ankw.a(((DiscussionInfo)localObject3).uin)));
        }
      }
    }
    this.g = ((List)localObject1).size();
    if (this.g > 0)
    {
      localArrayList.add(new amfr(10, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(new amfr(11, ((amfs)((Iterator)localObject1).next()).a));
      }
    }
    return localArrayList;
  }
  
  private void a(amfr paramamfr, String paramString, boolean paramBoolean)
  {
    ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramString, paramamfr.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramBoolean, false);
    if (paramBoolean) {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramamfr.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ajef != null) {
        this.jdField_a_of_type_Ajef.a(paramamfr.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramBoolean);
      }
      return;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramamfr.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((amfr)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
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
    Object localObject1 = (amfr)getItem(paramInt);
    amft localamft;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559885, paramViewGroup, false);
      localamft = new amft(paramView);
      paramView.setTag(localamft);
      ((Button)paramView.findViewById(2131379200)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_Boolean) {
        localamft.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      localamft.jdField_a_of_type_Amfr = ((amfr)localObject1);
      if ((this.jdField_a_of_type_Boolean) && (localamft.jdField_a_of_type_Amfr.jdField_a_of_type_Int != 0) && (localamft.jdField_a_of_type_Amfr.jdField_a_of_type_Int != 4) && (localamft.jdField_a_of_type_Amfr.jdField_a_of_type_Int != 6) && (localamft.jdField_a_of_type_Amfr.jdField_a_of_type_Int != 8) && (localamft.jdField_a_of_type_Amfr.jdField_a_of_type_Int != 2))
      {
        localamft.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
        localamft.jdField_a_of_type_ComTencentWidgetSwitch.setTag(localamft.jdField_a_of_type_Amfr);
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) || (localamft.jdField_a_of_type_Amfr.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(((amfr)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
          break label379;
        }
        localamft.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        label254:
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (((amfr)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(((amfr)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, localamft.jdField_a_of_type_ComTencentWidgetSwitch);
        }
      }
      if (((amfr)localObject1).jdField_a_of_type_Int != 0) {
        break label391;
      }
      localamft.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localamft.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localamft.jdField_d_of_type_AndroidWidgetTextView.setText(anni.a(2131714152));
      localamft.e.setText(String.valueOf(this.e));
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localamft = (amft)paramView.getTag();
      break;
      label379:
      localamft.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      break label254;
      label391:
      if (((amfr)localObject1).jdField_a_of_type_Int == 2)
      {
        localamft.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamft.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamft.jdField_d_of_type_AndroidWidgetTextView.setText(anni.a(2131714490));
        localamft.e.setText(String.valueOf(this.jdField_d_of_type_Int));
      }
      else if (((amfr)localObject1).jdField_a_of_type_Int == 4)
      {
        localamft.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamft.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamft.jdField_d_of_type_AndroidWidgetTextView.setText(anni.a(2131714494));
        localamft.e.setText(String.valueOf(this.jdField_b_of_type_Int));
      }
      else if (((amfr)localObject1).jdField_a_of_type_Int == 6)
      {
        localamft.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamft.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamft.jdField_d_of_type_AndroidWidgetTextView.setText(anni.a(2131714497));
        localamft.e.setText(String.valueOf(this.jdField_c_of_type_Int));
      }
      else if (((amfr)localObject1).jdField_a_of_type_Int == 8)
      {
        localamft.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamft.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamft.jdField_d_of_type_AndroidWidgetTextView.setText(anni.a(2131714495));
        localamft.e.setText(String.valueOf(this.f));
      }
      else if (((amfr)localObject1).jdField_a_of_type_Int == 10)
      {
        localamft.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localamft.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localamft.jdField_d_of_type_AndroidWidgetTextView.setText(anni.a(2131701371));
        localamft.e.setText(String.valueOf(this.g));
      }
      else
      {
        Object localObject2;
        if (((amfr)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
        {
          localamft.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localamft.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localObject2 = ((amfr)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
          localamft.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject2).troopuin) != 3)
          {
            localamft.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            label763:
            TextView localTextView = localamft.jdField_a_of_type_AndroidWidgetTextView;
            if (TextUtils.isEmpty(((TroopInfo)localObject2).getTroopName())) {
              break label980;
            }
            localObject1 = ((TroopInfo)localObject2).getTroopName();
            label788:
            localTextView.setText((CharSequence)localObject1);
            localamft.c.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
            if ((((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
              break label990;
            }
            localamft.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localamft.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
            label867:
            if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
              break label1049;
            }
            if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
              break label1003;
            }
            localamft.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
            localamft.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843791);
          }
          label1049:
          for (;;)
          {
            if (((TroopInfo)localObject2).troopCreditLevel != 2L) {
              break label1062;
            }
            localamft.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localamft.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localamft.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850432);
            break;
            localamft.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localamft.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850429);
            break label763;
            label980:
            localObject1 = ((TroopInfo)localObject2).troopuin;
            break label788;
            label990:
            localamft.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            break label867;
            label1003:
            if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
            {
              localamft.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
              localamft.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843791);
            }
            else
            {
              localamft.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              continue;
              localamft.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          label1062:
          if (((TroopInfo)localObject2).troopCreditLevel == 1L)
          {
            localamft.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localamft.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localamft.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850430);
          }
          else
          {
            localamft.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          }
        }
        else if (((amfr)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
        {
          localamft.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localamft.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localObject2 = ((amfr)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
          localamft.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject2).uin;
          localamft.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localamft.jdField_a_of_type_AndroidWidgetTextView.setText(bglf.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject2));
          if (!((DiscussionInfo)localObject2).hasRenamed())
          {
            localamft.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localamft.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((amfr)localObject1).jdField_b_of_type_Int) }));
          }
          localamft.c.setImageBitmap(a(101, ((DiscussionInfo)localObject2).uin));
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
      if ((localObject instanceof amfr))
      {
        localObject = (amfr)localObject;
        if (((amfr)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
          }
          String str1 = ((amfr)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
          String str2 = ((amfr)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
          TroopManager localTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
          if (TextUtils.isEmpty(str1)) {
            ThreadManager.post(new TroopListAdapter2.5(this, localTroopManager, str2, (amfr)localObject, paramBoolean), 8, null, true);
          } else {
            a((amfr)localObject, str1, paramBoolean);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfk
 * JD-Core Version:    0.7.0.1
 */