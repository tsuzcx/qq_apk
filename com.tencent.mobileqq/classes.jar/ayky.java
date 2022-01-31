import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.1;
import com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.2;
import com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper.3;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ayky
{
  private int jdField_a_of_type_Int = -1;
  public ayku a;
  private ayla jdField_a_of_type_Ayla;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public PinnedFooterExpandableListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<atmo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<atmo> b = new ArrayList();
  
  public ayky(QQAppInterface paramQQAppInterface, PinnedFooterExpandableListView paramPinnedFooterExpandableListView, ayla paramayla)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = paramPinnedFooterExpandableListView;
    this.jdField_a_of_type_Ayla = paramayla;
    this.jdField_a_of_type_Ayku = new ayku(paramQQAppInterface);
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (this.jdField_a_of_type_Int == 2) {
      return 2;
    }
    if (this.jdField_a_of_type_Int == 1) {
      return 1;
    }
    if (this.jdField_a_of_type_Int == 4) {
      return 4;
    }
    return 0;
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationFriends");
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new RelationFriendsTroopViewHelper.3(this, paramString));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationTroops");
    }
    aynk localaynk = (aynk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (localaynk != null)
    {
      ArrayList localArrayList1 = this.jdField_a_of_type_Ayla.a();
      if (localArrayList1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationTroops records size:" + localArrayList1.size());
        }
        ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
        localArrayList2.addAll(localArrayList1);
        localaynk.a(localArrayList2, new aykz(this));
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, RelationTroopEntity paramRelationTroopEntity)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131494570, paramViewGroup, false);
      paramViewGroup = new aykc();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131302061));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131304981));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131298635));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131312503);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131312394).setVisibility(8);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_JavaLangObject = paramRelationTroopEntity;
      paramViewGroup.jdField_a_of_type_JavaLangString = paramRelationTroopEntity.troopInfo.troopuin;
      if (!paramRelationTroopEntity.troopInfo.hasSetTroopHead()) {
        break label246;
      }
    }
    label246:
    for (paramInt1 = 4;; paramInt1 = 113)
    {
      paramContext = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramRelationTroopEntity.troopInfo.troopuin, 3, azwp.a(4, 3), azwp.a(4, 3));
      paramViewGroup.c.setImageDrawable(paramContext);
      paramContext = paramRelationTroopEntity.troopInfo.getTroopName();
      paramViewGroup.d.setText(paramContext);
      return paramView;
      paramViewGroup = (aykc)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
    }
  }
  
  public Long a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "getRelationTroopChildId troopUin empty");
    }
    return Long.valueOf(-1L);
  }
  
  public void a()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "friendlist_exp", a(), 0, "", "", "", "");
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    this.jdField_a_of_type_Int = 1;
    if (paramResultRecord != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult:,currentRelationUin:" + this.jdField_a_of_type_JavaLangString + ",lastrecordUIN:" + paramResultRecord.jdField_a_of_type_JavaLangString);
      }
      if (!this.jdField_a_of_type_JavaLangString.equals(paramResultRecord.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = paramResultRecord.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_JavaLangString);
          e();
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult lastRecord null");
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.post(new RelationFriendsTroopViewHelper.2(this));
  }
  
  public void a(ResultRecord paramResultRecord, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult:,param_entrance:" + paramInt);
    }
    if ((paramInt == 38) || (paramInt == 29) || (paramInt == 39))
    {
      if (paramInt != 38) {
        break label170;
      }
      this.jdField_a_of_type_Int = 3;
    }
    while (paramResultRecord != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult:,currentRelationUin:" + this.jdField_a_of_type_JavaLangString + ",lastrecordUIN:" + paramResultRecord.jdField_a_of_type_JavaLangString);
      }
      if (!this.jdField_a_of_type_JavaLangString.equals(paramResultRecord.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = paramResultRecord.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_JavaLangString);
          if ((paramInt == 29) || (paramInt == 39)) {
            e();
          }
        }
      }
      return;
      label170:
      if (paramInt == 39) {
        this.jdField_a_of_type_Int = 4;
      } else {
        this.jdField_a_of_type_Int = 2;
      }
    }
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.post(new RelationFriendsTroopViewHelper.1(this));
  }
  
  public void a(ArrayList<Groups> paramArrayList, SparseArray<ArrayList<atmo>> paramSparseArray)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "loadData");
    }
    Object localObject1;
    int i;
    Object localObject2;
    if (!this.b.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "loadData relationtroop");
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.b.size())
      {
        localObject2 = (RelationTroopEntity)this.b.get(i);
        ((ArrayList)localObject1).add(localObject2);
        this.jdField_a_of_type_JavaUtilHashMap.put(((RelationTroopEntity)localObject2).troopInfo.troopuin, Long.valueOf(i + 1L));
        i += 1;
      }
      localObject2 = new Groups();
      ((Groups)localObject2).group_id = 1008;
      ((Groups)localObject2).group_name = ajjy.a(2131652864);
      ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
      ((Groups)localObject2).seqid = 0;
      paramArrayList.add(localObject2);
      paramSparseArray.put(((Groups)localObject2).group_id, localObject1);
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "loadData relationfriends");
      }
      localObject1 = new Groups();
      localObject2 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((ArrayList)localObject2).add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      ((Groups)localObject1).group_id = 1007;
      ((Groups)localObject1).group_name = ajjy.a(2131652863);
      ((Groups)localObject1).group_friend_count = ((ArrayList)localObject2).size();
      ((Groups)localObject1).seqid = 0;
      paramArrayList.add(localObject1);
      paramSparseArray.put(((Groups)localObject1).group_id, localObject2);
    }
  }
  
  public View b(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, RelationTroopEntity paramRelationTroopEntity)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131494570, paramViewGroup, false);
      paramViewGroup = new ahsj();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131302061));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131304981));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131298635));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131312503);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131312394).setVisibility(8);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_JavaLangObject = paramRelationTroopEntity;
      paramViewGroup.jdField_a_of_type_JavaLangString = paramRelationTroopEntity.troopInfo.troopuin;
      if (!paramRelationTroopEntity.troopInfo.hasSetTroopHead()) {
        break label246;
      }
    }
    label246:
    for (paramInt1 = 4;; paramInt1 = 113)
    {
      paramContext = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramRelationTroopEntity.troopInfo.troopuin, 3, azwp.a(4, 3), azwp.a(4, 3));
      paramViewGroup.c.setImageDrawable(paramContext);
      paramContext = paramRelationTroopEntity.troopInfo.getTroopName();
      paramViewGroup.d.setText(paramContext);
      return paramView;
      paramViewGroup = (ahsj)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
    }
  }
  
  public void b()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "friendlist_clk", a(), 0, "", "", "", "");
  }
  
  public void c()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "grplist_exp", a(), 0, "", "", "", "");
  }
  
  public void d()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "grplist_clk", a(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayky
 * JD-Core Version:    0.7.0.1
 */