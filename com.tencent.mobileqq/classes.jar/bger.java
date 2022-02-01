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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bger
  extends BaseAdapter
  implements View.OnClickListener
{
  public ArrayList<String> a;
  public boolean a;
  
  public bger(BulkSendMessageFragment paramBulkSendMessageFragment)
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
    bges localbges;
    TextView localTextView;
    ImageView localImageView;
    Object localObject3;
    String str;
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity()).inflate(2131558902, null);
      localbges = new bges(localView);
      localbges.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368381));
      localbges.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371803));
      localView.setTag(localbges);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = localbges.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localbges.jdField_a_of_type_AndroidWidgetImageView;
      localObject3 = (anvk)this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label431;
      }
      localImageView.setImageResource(2130844919);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getResources().getColor(2131167120));
      str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) + "";
      localbges.jdField_a_of_type_JavaLangString = str;
      localObject2 = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaLangString, str);
      if (!TextUtils.isEmpty(str)) {
        break label311;
      }
      if (localObject2 != null) {
        break label304;
      }
      localObject1 = "";
      label225:
      localTextView.setText((CharSequence)localObject1);
      localImageView.setImageDrawable(bheg.b());
      label240:
      localbges.jdField_a_of_type_AndroidViewView.setTag(2131378453, null);
      localbges.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    }
    for (;;)
    {
      if (AppSetting.c) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localbges = (bges)paramView.getTag();
      localView = paramView;
      break;
      label304:
      localObject1 = localObject2;
      break label225;
      label311:
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((anvk)localObject3).e(str);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((Friends)localObject3).isFriend()) {
              localObject1 = ContactUtils.getFriendNick(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
            }
          }
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = anvx.a(2131700731);
      }
      localTextView.setText((CharSequence)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.a(localbges, null, true);
      localImageView.setTag(2131378479, str);
      localImageView.setTag(null);
      break label240;
      label431:
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getString(2131689550));
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getResources().getColorStateList(2131166487));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839242);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(0));
      localbges.jdField_a_of_type_AndroidViewView.setTag(2131378453, Integer.valueOf(0));
      localbges.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (Integer)paramView.getTag(2131378453);
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((Integer)localObject).intValue() == 0)
      {
        localObject = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_JavaLangString, 20);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((Intent)localObject).putStringArrayListExtra("param_pick_selected_list", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_Bger.jdField_a_of_type_JavaUtilArrayList);
        ((Intent)localObject).putStringArrayListExtra("param_hide_filter_member_list", localArrayList);
        ((Intent)localObject).putExtra("param_pick_max_num", this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.jdField_a_of_type_Int);
        ((Intent)localObject).putExtra("param_pick_max_num_exceeds_wording", 2131697328);
        ((Intent)localObject).putExtra("param_pick_title_string", anvx.a(2131700724));
        this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.startActivityForResult((Intent)localObject, 1);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroop_appsEntryUiBulkSendMessageFragment.getActivity().overridePendingTransition(2130772299, 2130771990);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bger
 * JD-Core Version:    0.7.0.1
 */