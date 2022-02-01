import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.List;

public class amfr
  extends amgf
  implements bllm
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public amfr(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new amfs(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new amft(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private void a(ajuk paramajuk)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {}
    for (int i = 0; this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i); i = paramajuk.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a(ajuk paramajuk, int paramInt, boolean paramBoolean)
  {
    String str;
    int i;
    StringBuilder localStringBuilder;
    if (paramajuk != null)
    {
      str = "";
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
      switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
      {
      case 1: 
      case 3: 
      case 5: 
      case 7: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      default: 
        i = 0;
        localStringBuilder = paramajuk.jdField_a_of_type_JavaLangStringBuilder;
        if (AppSetting.c)
        {
          if (localStringBuilder != null) {
            break label356;
          }
          localStringBuilder = new StringBuilder(24);
        }
        break;
      }
    }
    for (;;)
    {
      localStringBuilder.append(str + " 分组");
      paramajuk.jdField_a_of_type_Int = paramInt;
      paramajuk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str);
      paramajuk.b.setVisibility(8);
      paramajuk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramajuk.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText(String.valueOf(i));
      paramajuk.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramajuk.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      return;
      str = anzj.a(2131714072);
      i = this.jdField_b_of_type_JavaUtilList.size();
      break;
      str = anzj.a(2131714076);
      i = this.jdField_c_of_type_JavaUtilList.size();
      break;
      str = anzj.a(2131714073);
      i = this.d.size();
      break;
      str = anzj.a(2131714074);
      i = this.e.size();
      break;
      str = anzj.a(2131714075);
      i = this.f.size();
      break;
      str = anzj.a(2131714077);
      i = this.g.size();
      break;
      label356:
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof ajuk))
    {
      localObject = new ajuk();
      ((ajuk)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369210));
      ((ajuk)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367726));
      ((ajuk)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((ajuk)localObject).b = ((SingleLineTextView)paramView.findViewById(2131380041));
      ((ajuk)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131364983));
      ((ajuk)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      ((ajuk)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369324));
      paramView.setTag(localObject);
      paramView = (View)localObject;
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break label172;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramView, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      return;
      paramView = (ajuk)paramView.getTag();
      break;
      label172:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167074);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor((ColorStateList)localObject);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof ajuk)) {
      a((ajuk)paramExpandableListView);
    }
    return true;
  }
  
  public int c_()
  {
    return 2131558948;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    amgh localamgh;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (amfu)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localamgh = a(paramInt1, paramInt2);
      if ((localamgh == null) || (localamgh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity == null)) {
        break label573;
      }
      if (!(localamgh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof TroopInfo)) {
        break label363;
      }
      localTroopInfo = (TroopInfo)localamgh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramView.jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
      paramView.jdField_c_of_type_Int = 4;
      if (TextUtils.isEmpty(localTroopInfo.getTroopName())) {
        break label340;
      }
      localObject = localTroopInfo.getTroopName();
      paramView.jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
      paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = null;
      paramView.jdField_a_of_type_Int = localamgh.jdField_a_of_type_Int;
      if ((localTroopInfo.hasSetTroopName()) || (localTroopInfo.wMemberNumClient <= 0)) {
        break label350;
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
      a(paramView, null);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    label340:
    label350:
    label363:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          TroopInfo localTroopInfo;
          return paramViewGroup;
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562908, this.jdField_a_of_type_ComTencentWidgetExpandableListView, false);
          paramView = new amfu(this);
          paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366213));
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366240));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379490));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379476));
          paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362954));
          paramViewGroup.setTag(paramView);
          break;
          localObject = localTroopInfo.troopuin;
          continue;
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((localamgh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof DiscussionInfo))
        {
          localObject = (DiscussionInfo)localamgh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
          paramView.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
          paramView.jdField_c_of_type_Int = 101;
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(bhlg.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject));
          if (!((DiscussionInfo)localObject).hasRenamed())
          {
            paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Anws.a(((DiscussionInfo)localObject).uin)) }));
          }
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          a(paramView, null);
          paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject);
          paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = null;
          paramView.jdField_a_of_type_Int = localamgh.jdField_a_of_type_Int;
          return paramViewGroup;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView data:" + localamgh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
      return paramViewGroup;
    }
    label573:
    QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView itemInfo data null" + paramInt1 + " childPosition:" + paramInt2);
    return paramViewGroup;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558948, paramViewGroup, false);
      paramViewGroup = new ajuk();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367726));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369210));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131364983));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369324));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131380041));
      paramView.setTag(paramViewGroup);
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
      paramViewGroup = (ajuk)paramView.getTag();
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      return paramView;
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167074);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(localColorStateList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfr
 * JD-Core Version:    0.7.0.1
 */