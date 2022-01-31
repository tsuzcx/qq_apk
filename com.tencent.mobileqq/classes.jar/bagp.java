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

public class bagp
  extends BaseAdapter
  implements View.OnClickListener
{
  public ArrayList<String> a;
  public boolean a;
  
  public bagp(BulkSendMessageFragment paramBulkSendMessageFragment)
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
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity()).inflate(2131558761, null);
      paramViewGroup = new bagq(localView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367679));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370647));
      localView.setTag(paramViewGroup);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      localObject2 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label395;
      }
      localImageView.setImageResource(2130844139);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getResources().getColor(2131166941));
      str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) + "";
      paramViewGroup.jdField_a_of_type_JavaLangString = str;
      localObject1 = bbcl.h(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaLangString, str);
      if (!TextUtils.isEmpty(str)) {
        break label283;
      }
      if (localObject1 != null) {
        break label277;
      }
      paramView = "";
      label216:
      localTextView.setText(paramView);
      localImageView.setImageDrawable(bbdr.b());
      label230:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(2131376842, null);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    }
    for (;;)
    {
      if (AppSetting.d) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      return localView;
      paramViewGroup = (bagq)paramView.getTag();
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
          localObject2 = ((ajxn)localObject2).e(str);
          paramView = (View)localObject1;
          if (localObject2 != null)
          {
            paramView = (View)localObject1;
            if (((Friends)localObject2).isFriend()) {
              paramView = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
            }
          }
        }
      }
      localObject1 = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject1 = ajyc.a(2131701222);
      }
      localTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.a(paramViewGroup, null, true);
      localImageView.setTag(2131376868, str);
      localImageView.setTag(null);
      break label230;
      label395:
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getString(2131689628));
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getResources().getColorStateList(2131166328));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130838933);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(0));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(2131376842, Integer.valueOf(0));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (Integer)paramView.getTag(2131376842);
    if (paramView == null) {}
    while (paramView.intValue() != 0) {
      return;
    }
    paramView = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaLangString, 20);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramView.putStringArrayListExtra("param_pick_selected_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_Bagp.jdField_a_of_type_JavaUtilArrayList);
    paramView.putStringArrayListExtra("param_hide_filter_member_list", localArrayList);
    paramView.putExtra("param_pick_max_num", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_Int);
    paramView.putExtra("param_pick_max_num_exceeds_wording", 2131697825);
    paramView.putExtra("param_pick_title_string", ajyc.a(2131701215));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.startActivityForResult(paramView, 1);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity().overridePendingTransition(2130772278, 2130771990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bagp
 * JD-Core Version:    0.7.0.1
 */