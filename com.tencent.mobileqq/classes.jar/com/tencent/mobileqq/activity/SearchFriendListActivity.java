package com.tencent.mobileqq.activity;

import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.taf.jce.JceInputStream;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import tod;
import toe;
import tof;

public class SearchFriendListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tod(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private toe jdField_a_of_type_Toe;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public void a(View paramView, int paramInt)
  {
    SearchInfo localSearchInfo = (SearchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    tof localtof = (tof)paramView.getTag();
    if (!TextUtils.isEmpty(localSearchInfo.strNick))
    {
      localtof.jdField_a_of_type_AndroidWidgetTextView.setText(localSearchInfo.strNick);
      if (localSearchInfo.eSource != 1) {
        break label187;
      }
      localtof.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.app, String.valueOf(localSearchInfo.lUIN), (byte)3));
      localtof.b.setText("QQ号码: " + localSearchInfo.lUIN);
    }
    for (;;)
    {
      localtof.jdField_a_of_type_Int = paramInt;
      paramView.setContentDescription(localtof.jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      TextView localTextView = localtof.jdField_a_of_type_AndroidWidgetTextView;
      if (localSearchInfo.eSource == 1) {}
      for (String str = localSearchInfo.lUIN + "";; str = localSearchInfo.strMobile)
      {
        localTextView.setText(str);
        break;
      }
      label187:
      localtof.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.b(this.app, localSearchInfo.strMobile, (byte)3));
      localtof.b.setText("手机号码: " + localSearchInfo.strMobile);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130971474);
    setContentBackgroundResource(2130838210);
    setTitle("搜索结果");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131374824));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838210);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    paramBundle = new JceInputStream(getIntent().getByteArrayExtra("param_search_resp"));
    RespSearch localRespSearch = new RespSearch();
    localRespSearch.readFrom(paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList = localRespSearch.vRecords;
    this.jdField_a_of_type_ArrayOfByte = localRespSearch.vSecureSig;
    this.jdField_a_of_type_Toe = new toe(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Toe);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      if (!(localObject instanceof SearchInfo)) {
        break label123;
      }
      paramView = (SearchInfo)localObject;
      if (paramView.eSource != 1) {
        break label78;
      }
      paramView = AddFriendLogicActivity.a(this, 1, paramView.lUIN + "", null, 3001, 3999, paramView.strNick, null, null, null, null);
      startActivity(paramView);
    }
    label78:
    label123:
    while (!(localObject instanceof tof))
    {
      return;
      if (paramView.bInContact == 1) {}
      for (int i = 3006;; i = 3014)
      {
        paramView = AddFriendLogicActivity.a(this, 2, paramView.strMobile, null, i, 3999, paramView.strNick, null, null, null, null);
        break;
      }
    }
    paramView = (tof)paramView.getTag();
    localObject = (SearchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramView.jdField_a_of_type_Int);
    if (((SearchInfo)localObject).bIsEnterpriseQQ == 0)
    {
      AddFriendActivity.a(this, (SearchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramView.jdField_a_of_type_Int), this.app.getCurrentAccountUin(), this.jdField_a_of_type_ArrayOfByte, false, 0);
      return;
    }
    CrmUtils.a(this, null, String.valueOf(((SearchInfo)localObject).lUIN), false, -1, true, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity
 * JD-Core Version:    0.7.0.1
 */