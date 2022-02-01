package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.contact.troop.CommonTroopData;
import com.tencent.mobileqq.activity.contact.troop.TroopList;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

public class IntimateContentItemCommonTroopView
  extends IntimateContentItemBaseView
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected TroopList a;
  protected List<CommonTroopData> a;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected int c;
  private TextView c;
  private int jdField_d_of_type_Int = 1;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private TextView e;
  private TextView f;
  
  public IntimateContentItemCommonTroopView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemCommonTroopView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemCommonTroopView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopList = new TroopList();
    this.jdField_c_of_type_Int = 0;
  }
  
  private void m()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
      TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), 2);
    }
  }
  
  protected void a()
  {
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559253, this, true);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131365032);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365031));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365030));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365029));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365034));
    this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131376191);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131376189));
    this.e = ((TextView)((View)localObject).findViewById(2131376190));
    this.f = ((TextView)((View)localObject).findViewById(2131376192));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this);
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    int i = (int)(f1 * 10.0F + 0.5F);
    AIOUtils.a((View)localObject, i, i, i, i);
    AIOUtils.a(this.jdField_d_of_type_AndroidWidgetTextView, i, i, i, i);
    localObject = new IntimateContentItemCommonTroopView.1(this);
    IntimateContentItemCommonTroopView.2 local2 = new IntimateContentItemCommonTroopView.2(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(local2);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131376191: 
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo != null))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
        Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), SplashActivity.class), null);
        localIntent.putExtra("uin", paramView.troopCode);
        localIntent.putExtra("uintype", 1);
        localIntent.putExtra("uinname", paramView.troopName);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().startActivity(localIntent);
        ReportController.b(null, "dc00898", "", "", "0X8009F4F", "0X8009F4F", this.jdField_d_of_type_Int, 0, "", "", "", "");
        return;
      }
      break;
    case 2131365032: 
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList != null))
      {
        CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.jdField_d_of_type_Int);
        ReportController.b(null, "dc00898", "", "", "0X8009F4E", "0X8009F4E", this.jdField_d_of_type_Int, 0, "", "", "", "");
        return;
      }
      m();
      return;
    case 2131365029: 
    case 2131365034: 
      m();
    }
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    Object localObject = paramIntimateInfo.commonTroopInfoList;
    int i = 1;
    if ((localObject != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      i = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getResources().getString(2131693415);
    int j;
    if (i != 0) {
      j = TroopWithCommonFriendsHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
    } else {
      j = 0;
    }
    if (j == 2) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getResources().getString(2131693414);
    }
    if (paramInt != 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
      {
        paramInt = paramIntimateInfo.commonTroopInfoList.size();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
        IntimateInfo.CommonTroopInfo localCommonTroopInfo = paramIntimateInfo.recentChatTroopInfo;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        if ((localCommonTroopInfo != null) && (!TextUtils.isEmpty(localCommonTroopInfo.troopUin)))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.e.setVisibility(0);
          this.f.setVisibility(0);
          this.e.setText(localCommonTroopInfo.troopName);
          this.f.setText(paramIntimateInfo.commonTroopTips);
          paramIntimateInfo = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), 4, localCommonTroopInfo.troopCode);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramIntimateInfo);
        }
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (i != 0)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        ReportController.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
      }
      if (this.jdField_d_of_type_Boolean) {
        ReportController.b(null, "dc00898", "", "", "0X8009F51", "0X8009F51", this.jdField_d_of_type_Int, 0, "", "", "", "");
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getResources().getString(2131693417));
      paramIntimateInfo = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramIntimateInfo.leftMargin = 0;
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramIntimateInfo);
      paramIntimateInfo = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramIntimateInfo.topMargin = AIOUtils.b(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getResources());
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramIntimateInfo);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      ReportController.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = FriendIntimateRelationshipConfProcessor.a().c;
    List localList = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList;
    boolean bool1 = true;
    int i;
    if ((localList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    localList = this.jdField_a_of_type_JavaUtilList;
    int j;
    if ((localList != null) && (localList.size() > 0)) {
      j = 1;
    } else {
      j = 0;
    }
    if (bool2)
    {
      if (i != 0) {
        return bool1;
      }
      if (j != 0) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public void setNeedReportPage(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setReportType(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemCommonTroopView
 * JD-Core Version:    0.7.0.1
 */