import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import java.util.ArrayList;

public class bcfp
  extends BaseAdapter
  implements View.OnClickListener
{
  public ArrayList<String> a;
  public boolean a;
  
  public bcfp(BulkSendMessageFragment paramBulkSendMessageFragment)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    TextView localTextView;
    ImageView localImageView;
    Object localObject2;
    String str;
    Object localObject1;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity()).inflate(2131558797, null);
      paramViewGroup = new bcfq(localView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367808));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370958));
      localView.setTag(paramViewGroup);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      localObject2 = (aloz)this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label395;
      }
      localImageView.setImageResource(2130844483);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getResources().getColor(2131166989));
      str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) + "";
      paramViewGroup.jdField_a_of_type_JavaLangString = str;
      localObject1 = bdbt.h(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaLangString, str);
      if (!TextUtils.isEmpty(str)) {
        break label283;
      }
      if (localObject1 != null) {
        break label277;
      }
      paramView = "";
      label216:
      localTextView.setText(paramView);
      localImageView.setImageDrawable(bdda.b());
      label230:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(2131377358, null);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    }
    for (;;)
    {
      if (AppSetting.c) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      return localView;
      paramViewGroup = (bcfq)paramView.getTag();
      localView = paramView;
      break;
      label277:
      paramView = (View)localObject1;
      break label216;
      label283:
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((aloz)localObject2).e(str);
          paramView = (View)localObject1;
          if (localObject2 != null)
          {
            paramView = (View)localObject1;
            if (((Friends)localObject2).isFriend()) {
              paramView = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
            }
          }
        }
      }
      localObject1 = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject1 = alpo.a(2131701602);
      }
      localTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.a(paramViewGroup, null, true);
      localImageView.setTag(2131377384, str);
      localImageView.setTag(null);
      break label230;
      label395:
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getString(2131689628));
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getResources().getColorStateList(2131166375));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839011);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(0));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(2131377358, Integer.valueOf(0));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (Integer)paramView.getTag(2131377358);
    if (paramView == null) {}
    while (paramView.intValue() != 0) {
      return;
    }
    paramView = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaLangString, 20);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramView.putStringArrayListExtra("param_pick_selected_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_Bcfp.jdField_a_of_type_JavaUtilArrayList);
    paramView.putStringArrayListExtra("param_hide_filter_member_list", localArrayList);
    paramView.putExtra("param_pick_max_num", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_Int);
    paramView.putExtra("param_pick_max_num_exceeds_wording", 2131698012);
    paramView.putExtra("param_pick_title_string", alpo.a(2131701595));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.startActivityForResult(paramView, 1);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity().overridePendingTransition(2130772292, 2130771990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfp
 * JD-Core Version:    0.7.0.1
 */