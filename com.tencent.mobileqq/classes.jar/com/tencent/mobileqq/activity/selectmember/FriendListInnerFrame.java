package com.tencent.mobileqq.activity.selectmember;

import aidg;
import aidh;
import aidi;
import ajuj;
import ajxn;
import ajyc;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aukm;
import bcmq;
import bcoe;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, bcmq, bcoe
{
  private int jdField_a_of_type_Int = -2147483648;
  private aidh jdField_a_of_type_Aidh;
  private Handler jdField_a_of_type_AndroidOsHandler = new aidg(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public RelativeLayout a;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  private String jdField_a_of_type_JavaLangString;
  public List<Friends> a;
  private int b;
  
  public FriendListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364059));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368074));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167087);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562361, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365764));
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363480)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    String str;
    if (localObject1 != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      Object localObject2 = ((ajxn)localObject1).a(String.valueOf(this.b));
      Object localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aukm)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            localObject3 = (Friends)localObject3;
            if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.p) || (!((Friends)localObject3).uin.equals(str))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d.contains(((Friends)localObject3).uin))) {
              this.jdField_a_of_type_JavaUtilList.add(localObject3);
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.p) && (this.b == 0))
      {
        localObject2 = ((ajxn)localObject1).e();
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break label339;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        do
        {
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = ((ajxn)localObject1).a(String.valueOf(((Groups)((Iterator)localObject2).next()).group_id));
            } while ((localObject3 == null) || (((List)localObject3).size() <= 0));
            localObject3 = ((List)localObject3).iterator();
          }
        } while (!((Friends)((Iterator)localObject3).next()).uin.equals(str));
      }
    }
    label339:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject1 = new Friends();
        ((Friends)localObject1).uin = str;
        ((Friends)localObject1).name = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        ((Friends)localObject1).mCompareSpell = ChnToSpell.a(ajuj.a((Friends)localObject1), 1);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
      }
      return;
    }
  }
  
  public ContactSearchFragment a()
  {
    return ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1)).a();
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562398);
    g();
    this.jdField_a_of_type_Aidh = new aidh(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Aidh);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Aidh.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Aidh.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.b = paramBundle.getInt("friend_team_id");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719221), this.jdField_a_of_type_JavaLangString);
    if (this.b != this.jdField_a_of_type_Int)
    {
      h();
      this.jdField_a_of_type_Aidh.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      this.jdField_a_of_type_Int = this.b;
    }
    while (this.jdField_a_of_type_Aidh == null) {
      return;
    }
    this.jdField_a_of_type_Aidh.notifyDataSetChanged();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aidh != null) {
      this.jdField_a_of_type_Aidh.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aidh.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    aidi localaidi = (aidi)paramView.getTag();
    if ((localaidi != null) && (localaidi.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localaidi.b != null) && (localaidi.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localaidi.jdField_a_of_type_JavaLangString, localaidi.b.getText().toString(), 0, "-1");
      localaidi.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (AppSetting.d)
      {
        if (!localaidi.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label127;
        }
        paramView.setContentDescription(localaidi.b.getText().toString() + ajyc.a(2131704871));
      }
    }
    return;
    label127:
    paramView.setContentDescription(localaidi.b.getText().toString() + ajyc.a(2131704874));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame
 * JD-Core Version:    0.7.0.1
 */