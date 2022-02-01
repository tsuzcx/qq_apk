import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class amkj
  extends BaseExpandableListAdapter
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<List<TroopInfo>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private bhhi jdField_a_of_type_Bhhi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<Entity> jdField_a_of_type_JavaUtilList;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private int b;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = UUID.randomUUID().toString();
  }
  
  public amkj(Context paramContext, QQAppInterface paramQQAppInterface, List<Entity> paramList, Map<String, Integer> paramMap)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296780);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296777);
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296776);
    this.d = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296777);
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
    this.jdField_a_of_type_Bhhi = ((bhhi)paramQQAppInterface.getManager(QQManagerFactory.MGR_TROOP_FILTER));
    paramContext = paramList;
    if (paramList == null) {
      paramContext = new ArrayList();
    }
    paramQQAppInterface = paramMap;
    if (paramMap == null) {
      paramQQAppInterface = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilList = paramContext;
    this.jdField_a_of_type_JavaUtilMap = paramQQAppInterface;
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMessageSettingAdapter", 2, "setItemBackground() childPos = " + paramInt1 + ", listSize = " + paramInt2);
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130839496);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130839512);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130839503);
      return;
    }
    paramView.setBackgroundResource(2130839506);
  }
  
  private void a(List<Entity> paramList)
  {
    int i = 0;
    Object localObject1;
    if (i < paramList.size())
    {
      if (paramList.get(i) == null) {
        break label147;
      }
      localObject1 = (TroopInfo)paramList.get(i);
      if (localObject1 != null) {}
    }
    else
    {
      paramList = new amkm();
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((Integer)((Iterator)localObject1).next()).intValue();
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null)
        {
          localObject2 = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
          Collections.sort((List)localObject2, paramList);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject2);
        }
      }
    }
    Object localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((TroopInfo)localObject1).troopuin);
    if (localObject2 == null) {}
    for (;;)
    {
      label147:
      i += 1;
      break;
      int j = ((Integer)localObject2).intValue();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(j, new ArrayList());
      }
      ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).add(localObject1);
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopuin = jdField_a_of_type_JavaLangString;
        ((TroopInfo)localObject1).troopname = this.jdField_a_of_type_AndroidContentContext.getString(2131719561);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, new ArrayList());
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).add(localObject1);
      }
    }
  }
  
  public TroopInfo a(int paramInt1, int paramInt2)
  {
    return (TroopInfo)((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(a(paramInt1).intValue())).get(paramInt2);
  }
  
  public Integer a(int paramInt)
  {
    return (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(Map<String, Integer> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  @TargetApi(8)
  public int getChildType(int paramInt1, int paramInt2)
  {
    TroopInfo localTroopInfo = a(paramInt1, paramInt2);
    if ((localTroopInfo != null) && (jdField_a_of_type_JavaLangString.equals(localTroopInfo.troopuin))) {
      return 1;
    }
    return 0;
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TroopInfo localTroopInfo = a(paramInt1, paramInt2);
    int i = getChildType(paramInt1, paramInt2);
    Object localObject;
    if (TextUtils.isEmpty(localTroopInfo.getTroopName()))
    {
      paramViewGroup = localTroopInfo.troopuin;
      if (i != 1) {
        break label136;
      }
      if (paramView == null) {
        break label84;
      }
      localObject = (amkl)paramView.getTag();
      label55:
      ((amkl)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
    }
    for (;;)
    {
      paramView.setFocusable(true);
      return paramView;
      paramViewGroup = localTroopInfo.getTroopName();
      break;
      label84:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562868, null);
      localObject = new amkl(this);
      ((amkl)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367915));
      paramView.setTag(localObject);
      break label55;
      label136:
      if (paramView != null) {
        localObject = (amkk)paramView.getTag();
      }
      for (;;)
      {
        FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localTroopInfo.troopuin);
        ((amkk)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
        ((amkk)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
        ((amkk)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        a(paramView, paramInt2, getChildrenCount(paramInt1));
        paramViewGroup = (Boolean)this.jdField_a_of_type_Bhhi.c.get(localTroopInfo.troopuin);
        if ((paramViewGroup == null) || (!paramViewGroup.booleanValue())) {
          break label352;
        }
        ((amkk)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562867, null);
        localObject = new amkk(this);
        ((amkk)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367868));
        ((amkk)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367915));
        ((amkk)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367883));
        ((amkk)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376575));
        paramView.setTag(localObject);
      }
      label352:
      ((amkk)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(a(paramInt).intValue());
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public int getGroupType(int paramInt)
  {
    return paramInt;
  }
  
  public int getGroupTypeCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (int i = ((Integer)paramView.getTag()).intValue();; i = -1)
    {
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (i != -1)
        {
          localView = paramView;
          if (i == a(paramInt).intValue()) {}
        }
      }
      else
      {
        i = 0;
        switch (a(paramInt).intValue())
        {
        }
      }
      for (;;)
      {
        localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(i, null);
        localView.setFocusable(true);
        localView.setTag(a(paramInt));
        return localView;
        i = 2131562969;
        continue;
        i = 2131562972;
        continue;
        i = 2131562970;
        continue;
        i = 2131562971;
      }
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    a(this.jdField_a_of_type_JavaUtilList);
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkj
 * JD-Core Version:    0.7.0.1
 */