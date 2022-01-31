import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.3;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bbiv
  extends akcy
  implements View.OnClickListener, View.OnLongClickListener, aubn
{
  private static final bbjb jdField_a_of_type_Bbjb = new bbjb(null);
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<ArrayList<awbv>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bbiw(this);
  bbjz jdField_a_of_type_Bbjz;
  private bhpo jdField_a_of_type_Bhpo;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected NewTroopContactView a;
  private final ArrayList<Groups> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new bbix(this);
  private ExpandableListView jdField_b_of_type_ComTencentWidgetExpandableListView;
  
  public bbiv(NewTroopContactView paramNewTroopContactView, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean)
  {
    super(paramNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView = paramNewTroopContactView;
    this.jdField_a_of_type_AndroidContentContext = paramNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    paramExpandableListView.post(new ContactListAdapter.3(this));
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1002) {
      return 1;
    }
    if (((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1008) {
      return 2;
    }
    return 0;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560250, paramViewGroup, false);
      paramViewGroup = new bbjd();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367808));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131370958));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364254));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378922);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      paramView.findViewById(2131378790).setVisibility(8);
      paramView.setTag(paramViewGroup);
      localObject = getChild(paramInt1, paramInt2);
      Friends localFriends = (Friends)localObject;
      paramViewGroup.jdField_a_of_type_Long = getGroupId(paramInt1);
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = localFriends.uin;
      a(paramViewGroup, null);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null)
      {
        if (!bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_JavaLangString)) {
          break label375;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label204:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      localObject = bdbt.a(localFriends);
      paramViewGroup.d.setText((CharSequence)localObject);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(paramViewGroup.jdField_a_of_type_JavaLangString)) {
        break label388;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label254:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_JavaUtilArrayList == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_JavaUtilArrayList.contains(localFriends.uin))) {
        break label400;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    }
    for (;;)
    {
      if ((AppSetting.c) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label412;
        }
        paramView.setContentDescription((String)localObject + alpo.a(2131702882));
      }
      return paramView;
      paramViewGroup = (bbjd)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label375:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label204;
      label388:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label254;
      label400:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    }
    label412:
    paramView.setContentDescription((String)localObject + alpo.a(2131702868));
    return paramView;
  }
  
  private void a(List<bbiz> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Bbjb);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("createNewTroop.ContactListAdapter", 2, "", paramList);
    }
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    PhoneContact localPhoneContact;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560250, paramViewGroup, false);
      paramViewGroup = new bbjd();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367808));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131370958));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364254));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378922);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      paramView.setTag(paramViewGroup);
      Object localObject = getChild(paramInt1, paramInt2);
      localPhoneContact = (PhoneContact)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
      a(paramViewGroup, null);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramViewGroup.d.setText(localPhoneContact.name);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(paramViewGroup.jdField_a_of_type_JavaLangString)) {
        break label353;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label214:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_JavaUtilArrayList == null) || ("0".equals(localPhoneContact.uin)) || (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_JavaUtilArrayList.contains(localPhoneContact.uin))) {
        break label365;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    }
    for (;;)
    {
      if ((AppSetting.c) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label377;
        }
        paramView.setContentDescription(localPhoneContact.name + alpo.a(2131702876));
      }
      return paramView;
      paramViewGroup = (bbjd)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label353:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label214;
      label365:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    }
    label377:
    paramView.setContentDescription(localPhoneContact.name + alpo.a(2131702881));
    return paramView;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || ((paramView.getTag() instanceof bbjd)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559490, paramViewGroup, false);
      paramViewGroup = new bbjc();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367808));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366461));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131377553));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372419));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372402));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131372429));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131377555));
      paramView.setTag(paramViewGroup);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener == null) {
        break label483;
      }
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    label483:
    for (;;)
    {
      Object localObject = getChild(paramInt1, paramInt2);
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(localPublicAccountInfo.uin);
      paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166901));
      if (PublicAccountInfo.isLooker(localPublicAccountInfo))
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.e.setVisibility(8);
        if (AppSetting.c) {
          paramView.setContentDescription(paramViewGroup.d.getText());
        }
        return paramView;
        paramViewGroup = (bbjc)paramView.getTag();
        paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      else
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.d.setText(localPublicAccountInfo.name);
        if (localPublicAccountInfo.certifiedGrade > 0L)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841431);
        }
        for (;;)
        {
          paramViewGroup.e.setText(localPublicAccountInfo.summary);
          a(paramViewGroup, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.b.setVisibility(8);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localObject1 != null)
    {
      Object localObject3 = ((amjk)localObject1).a(true);
      if (localObject3 != null)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (RecentUser)((Iterator)localObject3).next();
          if (localObject4 != null) {
            try
            {
              if ((((RecentUser)localObject4).getType() == 0) && (Long.parseLong(((RecentUser)localObject4).uin) >= 10000L) && (!((RecentUser)localObject4).uin.equals(localObject2)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.b.contains(((RecentUser)localObject4).uin)) && (!bdal.b(((RecentUser)localObject4).uin)) && (!bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin)))
              {
                localObject4 = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(((RecentUser)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (!bfua.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject4).uin))) {
                  ((ArrayList)localObject1).add(localObject4);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131719111);
          ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject2).group_id, localObject1);
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Bbjz.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidUtilSparseArray);
    c();
    aloz localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (localaloz != null)
    {
      localObject1 = localaloz.b();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label610;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("group list is ");
        if (localObject1 != null) {
          break label288;
        }
        localObject2 = "null";
        label104:
        QLog.d("createNewTroop.ContactListAdapter", 2, (String)localObject2);
      }
      if (localObject1 != null) {
        break label610;
      }
      localObject1 = new ArrayList();
    }
    label288:
    label607:
    label610:
    for (;;)
    {
      localObject3 = ((List)localObject1).iterator();
      Groups localGroups;
      Object localObject4;
      Object localObject5;
      int i;
      if (((Iterator)localObject3).hasNext())
      {
        localGroups = (Groups)((Iterator)localObject3).next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
        localObject2 = localaloz.a(String.valueOf(localGroups.group_id));
        if (localObject2 == null) {}
        for (localObject2 = new ArrayList();; localObject2 = new ArrayList((Collection)localObject2))
        {
          localObject4 = new ArrayList();
          localObject5 = ((List)localObject2).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((ArrayList)localObject4).add(new bbiz((Friends)((Iterator)localObject5).next(), -1));
          }
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("createNewTroop.ContactListAdapter", 2, "FriendManager is null");
          localObject1 = localObject2;
          break;
          localObject2 = "empty";
          break label104;
        }
        a((List)localObject4);
        ((List)localObject2).clear();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((List)localObject2).add(((bbiz)((Iterator)localObject4).next()).a);
        }
        localObject4 = ((List)localObject2).iterator();
        i = 0;
        label375:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Friends)((Iterator)localObject4).next();
          int j = bdbt.a(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
          if ((j == 0) || (j == 6)) {
            break label607;
          }
          i += 1;
        }
      }
      for (;;)
      {
        break label375;
        localObject4 = new ArrayList();
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject5 = (Friends)((List)localObject2).get(i);
          if ((!((Friends)localObject5).uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.b.contains(((Friends)localObject5).uin)) && (!bdal.b(((Friends)localObject5).uin)) && (!bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject5).uin)) && (!bfua.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject5).uin))) {
            ((ArrayList)localObject4).add(((List)localObject2).get(i));
          }
          i += 1;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject4);
        break;
        if ((!((List)localObject1).isEmpty()) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_b_of_type_ComTencentWidgetExpandableListView.a(0);
        }
        return;
      }
    }
  }
  
  public int a()
  {
    return 2131558878;
  }
  
  public Groups a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localGroups.group_id == paramLong) {
        return localGroups;
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    notifyDataSetChanged();
  }
  
  public void a(long paramLong) {}
  
  public void a(View paramView, int paramInt)
  {
    bbja localbbja = (bbja)paramView.getTag();
    if (localbbja == null)
    {
      localbbja = new bbja();
      paramView.findViewById(2131368762).setVisibility(0);
      localbbja.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367341));
      paramView.setTag(localbbja);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      localbbja.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
      ((CheckBox)paramView.findViewById(2131368762)).setChecked(this.jdField_b_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      return;
    }
  }
  
  public void a(bbjz parambbjz)
  {
    this.jdField_a_of_type_Bbjz = parambbjz;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("createNewTroop.ContactListAdapter", 2, "onRecommendCountChanged count=" + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("createNewTroop.ContactListAdapter", 2, "onUpdateContactList, " + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id)).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    if ((localObject instanceof Friends))
    {
      localObject = (Friends)localObject;
      try
      {
        long l = Long.parseLong(((Friends)localObject).uin);
        return l;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.i("createNewTroop.ContactListAdapter", 2, QLog.getStackTraceString(localThrowable));
        }
      }
    }
    do
    {
      return 0L;
      if ((localThrowable instanceof PublicAccountInfo)) {
        return ((PublicAccountInfo)localThrowable).uin;
      }
    } while (!(localThrowable instanceof RelationTroopEntity));
    RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)localThrowable;
    return this.jdField_a_of_type_Bbjz.a(localRelationTroopEntity.troopInfo.troopuin).longValue();
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }
  
  public int getChildTypeCount()
  {
    return 3;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    bhxr.a("getChildView");
    if (a(paramInt1, paramInt2) == 0) {
      paramView = a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    }
    for (;;)
    {
      bhxr.a();
      return paramView;
      if (a(paramInt1, paramInt2) == 1)
      {
        paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      }
      else if (a(paramInt1, paramInt2) == 2)
      {
        RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)getChild(paramInt1, paramInt2);
        paramView = this.jdField_a_of_type_Bbjz.a(paramInt1, paramInt2, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidViewView$OnClickListener, localRelationTroopEntity);
      }
      else
      {
        paramView = c(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((localGroups == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(localGroups.group_id) == null)) {
      return 0;
    }
    return ((ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).group_id)).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return ((Groups)getGroup(paramInt)).group_id;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (bbja)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = (Groups)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject).group_name);
      if (AppSetting.c)
      {
        if (!paramBoolean) {
          break;
        }
        paramViewGroup.setContentDescription(((Groups)localObject).group_name + alpo.a(2131702870));
      }
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560249, paramViewGroup, false);
      paramView = new bbja();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367341));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
    }
    paramViewGroup.setContentDescription(((Groups)localObject).group_name + alpo.a(2131702887));
    return paramViewGroup;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    d();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (bbja)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(paramView.jdField_a_of_type_Int);
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(paramView.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public boolean onLongClick(View paramView)
  {
    bdkz localbdkz = new bdkz();
    localbdkz.a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693327));
    bdbk.a(paramView, localbdkz, this.jdField_a_of_type_AndroidViewView$OnClickListener, new bbiy(this));
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbiv
 * JD-Core Version:    0.7.0.1
 */