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

public class bboi
{
  private int jdField_a_of_type_Int = -1;
  public bboe a;
  private bbok jdField_a_of_type_Bbok;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public PinnedFooterExpandableListView a;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<awge> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<awge> b = new ArrayList();
  
  public bboi(QQAppInterface paramQQAppInterface, PinnedFooterExpandableListView paramPinnedFooterExpandableListView, bbok parambbok)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = paramPinnedFooterExpandableListView;
    this.jdField_a_of_type_Bbok = parambbok;
    this.jdField_a_of_type_Bboe = new bboe(paramQQAppInterface);
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
    bbqu localbbqu = (bbqu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (localbbqu != null)
    {
      ArrayList localArrayList1 = this.jdField_a_of_type_Bbok.a();
      if (localArrayList1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationTroops records size:" + localArrayList1.size());
        }
        ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
        localArrayList2.addAll(localArrayList1);
        localbbqu.a(localArrayList2, new bboj(this));
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, RelationTroopEntity paramRelationTroopEntity)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131560249, paramViewGroup, false);
      paramViewGroup = new bbnm();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131367819));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131370977));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364256));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378980);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131378845).setVisibility(8);
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
      paramContext = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramRelationTroopEntity.troopInfo.troopuin, 3, bdbk.a(4, 3), bdbk.a(4, 3));
      paramViewGroup.c.setImageDrawable(paramContext);
      paramContext = paramRelationTroopEntity.troopInfo.getTroopName();
      paramViewGroup.d.setText(paramContext);
      return paramView;
      paramViewGroup = (bbnm)paramView.getTag();
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
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "friendlist_exp", a(), 0, "", "", "", "");
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
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult lastRecord null");
      }
      this.jdField_a_of_type_JavaLangString = "";
    } while (this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView == null);
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
      if (paramResultRecord == null) {
        break label192;
      }
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
    }
    label170:
    label192:
    while (this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView == null)
    {
      return;
      if (paramInt == 39)
      {
        this.jdField_a_of_type_Int = 4;
        break;
      }
      this.jdField_a_of_type_Int = 2;
      break;
    }
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.post(new RelationFriendsTroopViewHelper.1(this));
  }
  
  public void a(ArrayList<Groups> paramArrayList, SparseArray<ArrayList<awge>> paramSparseArray)
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
      ((Groups)localObject2).group_name = alud.a(2131719185);
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
      ((Groups)localObject1).group_name = alud.a(2131719184);
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
      paramView = LayoutInflater.from(paramContext).inflate(2131560249, paramViewGroup, false);
      paramViewGroup = new akay();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131367819));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131370977));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364256));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378980);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131378845).setVisibility(8);
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
      paramContext = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramRelationTroopEntity.troopInfo.troopuin, 3, bdbk.a(4, 3), bdbk.a(4, 3));
      paramViewGroup.c.setImageDrawable(paramContext);
      paramContext = paramRelationTroopEntity.troopInfo.getTroopName();
      paramViewGroup.d.setText(paramContext);
      return paramView;
      paramViewGroup = (akay)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
    }
  }
  
  public void b()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "friendlist_clk", a(), 0, "", "", "", "");
  }
  
  public void c()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "grplist_exp", a(), 0, "", "", "", "");
  }
  
  public void d()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create", "", "grptab", "grplist_clk", a(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboi
 * JD-Core Version:    0.7.0.1
 */