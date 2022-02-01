import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView;
import java.util.ArrayList;
import java.util.List;

public class befe
  extends bedr
{
  private Context b;
  
  public befe(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString1)) {
      paramString1 = anzj.a(2131713571);
    }
    String str;
    do
    {
      return paramString1;
      str = bhlg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
      if ((str != null) && (!str.equals(paramString1))) {
        break;
      }
      paramString1 = paramString2;
    } while (!TextUtils.isEmpty(paramString2));
    return str;
  }
  
  public List<beey> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(c);
    localArrayList.add(jdField_b_of_type_Beey);
    return localArrayList;
  }
  
  public List<beey> a(beex parambeex)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    int i;
    if ((parambeex instanceof GPadInfo))
    {
      parambeex = (GPadInfo)parambeex;
      if ((this.jdField_b_of_type_AndroidContentContext == null) || (!(this.jdField_b_of_type_AndroidContentContext instanceof GroupTeamWorkListActivity))) {
        break label142;
      }
      bool = bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((GroupTeamWorkListActivity)this.jdField_b_of_type_AndroidContentContext).a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (parambeex.creatorUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break label137;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean("TIMDocLimitSettingFlag", false))) {}
      localArrayList.add(c);
      if ((i != 0) || (bool)) {
        localArrayList.add(jdField_b_of_type_Beey);
      }
      return localArrayList;
      label137:
      i = 0;
      continue;
      label142:
      i = 0;
      bool = false;
    }
  }
  
  public View b(int paramInt1, beex parambeex, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    View localView;
    PadInfo localPadInfo;
    label151:
    long l;
    label271:
    label295:
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562990, paramViewGroup, false);
      paramViewGroup = new befg(this, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364612));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetSingleLineHotwordTextView = ((SingleLineHotwordTextView)localView.findViewById(2131364614));
      paramViewGroup.c = ((TextView)localView.findViewById(2131364615));
      paramViewGroup.b = ((TextView)localView.findViewById(2131364631));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364632));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView.findViewById(2131364616);
      localView.setTag(paramViewGroup);
      localPadInfo = (PadInfo)parambeex;
      if (localPadInfo.type != 1) {
        break label494;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850541);
      if (((localPadInfo instanceof GPadInfo)) && (((GPadInfo)localPadInfo).searchKeyWordList.size() > 0))
      {
        paramView = (ArrayList)((GPadInfo)localPadInfo).searchKeyWordList;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetSingleLineHotwordTextView.setHotwords(paramView);
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetSingleLineHotwordTextView.setText(localPadInfo.title);
      paramInt2 = localPadInfo.type_list;
      if ((paramInt2 != 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals("" + localPadInfo.creatorUin))) {
        break label531;
      }
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718592);
      paramViewGroup.c.setText(paramView);
      if (!(localPadInfo instanceof GPadInfo)) {
        break label659;
      }
      l = localPadInfo.lastEditTime;
      localObject = null;
      paramView = localObject;
      if (l > 0L)
      {
        if (l != localPadInfo.lastEditTime) {
          break label677;
        }
        paramView = a("" + localPadInfo.lastEditorUin, localPadInfo.lastEditorNick);
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718633), new Object[] { paramView });
      }
      label376:
      if (paramView == null) {
        break label768;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.b.setText(paramView);
      paramView = becb.a(l);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      label413:
      if (this.jdField_b_of_type_Int != 1) {
        break label842;
      }
      if (localPadInfo.type_list != 4) {
        break label812;
      }
      if (!localPadInfo.pinInAllList) {
        break label801;
      }
      localView.setBackgroundResource(2130839510);
    }
    for (;;)
    {
      localView.setOnClickListener(paramOnClickListener);
      localView.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.jdField_a_of_type_Beex = parambeex;
      localView.setTag(-1, Integer.valueOf(paramInt1));
      return localView;
      paramViewGroup = (befg)paramView.getTag();
      localView = paramView;
      break;
      label494:
      if (localPadInfo.type == 3)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850542);
        break label151;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850549);
      break label151;
      label531:
      if (paramInt2 == 3)
      {
        paramView = a("" + localPadInfo.creatorUin, localPadInfo.shardNick);
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718634), new Object[] { paramView });
        break label271;
      }
      paramView = a("" + localPadInfo.creatorUin, localPadInfo.creatorNick);
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718632), new Object[] { paramView });
      break label271;
      label659:
      l = Math.max(localPadInfo.lastEditTime, localPadInfo.currentUserBrowseTime);
      break label295;
      label677:
      if (l == 0L)
      {
        paramView = anzj.a(2131713576);
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718631), new Object[] { paramView });
        break label376;
      }
      paramView = localObject;
      if (l != localPadInfo.currentUserBrowseTime) {
        break label376;
      }
      paramView = anzj.a(2131713555);
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718635), new Object[] { paramView });
      break label376;
      label768:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.b.setText("");
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
      break label413;
      label801:
      localView.setBackgroundResource(2130839509);
      continue;
      label812:
      if (localPadInfo.pinedFlag)
      {
        localView.setBackgroundResource(2130839510);
      }
      else
      {
        localView.setBackgroundResource(2130839509);
        continue;
        label842:
        localView.setBackgroundResource(2130839509);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befe
 * JD-Core Version:    0.7.0.1
 */