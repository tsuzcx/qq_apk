package com.tencent.mobileqq.activity.aio.intimate.view;

import agll;
import agmh;
import agmi;
import ajdy;
import ajfl;
import ajhu;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
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
import arau;
import arav;
import bdla;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import java.util.ArrayList;
import java.util.List;

public class IntimateContentItemCommonTroopView
  extends IntimateContentItemBaseView
{
  protected ajfl a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public List<ajdy> a;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = 1;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
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
    this.jdField_a_of_type_Ajfl = new ajfl();
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_Agll.a());
    TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_Agll.a(), 2);
  }
  
  protected void a()
  {
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559313, this, true);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131365017);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365016));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365015));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365014));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365019));
    this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131376292);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131376290));
    this.e = ((TextView)((View)localObject).findViewById(2131376291));
    this.f = ((TextView)((View)localObject).findViewById(2131376293));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this);
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    AIOUtils.expandViewTouchDelegate(this.jdField_c_of_type_AndroidWidgetTextView, (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F));
    AIOUtils.expandViewTouchDelegate(this.jdField_d_of_type_AndroidWidgetTextView, (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(10.0F * f1 + 0.5F), (int)(f1 * 10.0F + 0.5F));
    localObject = new agmh(this);
    agmi localagmi = new agmi(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(localagmi);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject);
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131365017: 
    case 2131376292: 
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList != null))
        {
          CommonTroopListActivity.a(this.jdField_a_of_type_Agll.a(), (ArrayList)this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList, this.jdField_c_of_type_Int);
          bdla.b(null, "dc00898", "", "", "0X8009F4E", "0X8009F4E", this.jdField_c_of_type_Int, 0, "", "", "", "");
          return;
        }
        m();
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo == null));
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.recentChatTroopInfo;
      Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_Agll.a(), SplashActivity.class), null);
      localIntent.putExtra("uin", paramView.troopCode);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", paramView.troopName);
      this.jdField_a_of_type_Agll.a().startActivity(localIntent);
      bdla.b(null, "dc00898", "", "", "0X8009F4F", "0X8009F4F", this.jdField_c_of_type_Int, 0, "", "", "", "");
      return;
    }
    m();
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
    {
      paramInt = 1;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label393;
      }
    }
    String str;
    label393:
    for (int i = 1;; i = 0)
    {
      int j = 0;
      str = this.jdField_a_of_type_Agll.a().getResources().getString(2131693308);
      if (i != 0) {
        j = ajhu.a(this.jdField_a_of_type_Agll.a(), this.jdField_a_of_type_Agll.a());
      }
      if (j == 2) {
        str = this.jdField_a_of_type_Agll.a().getResources().getString(2131693307);
      }
      if (paramInt == 0) {
        break label398;
      }
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
          paramIntimateInfo = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_Agll.a(), 4, localCommonTroopInfo.troopCode);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramIntimateInfo);
        }
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (i != 0)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
        bdla.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
      }
      if (this.jdField_d_of_type_Boolean) {
        bdla.b(null, "dc00898", "", "", "0X8009F51", "0X8009F51", this.jdField_c_of_type_Int, 0, "", "", "", "");
      }
      return;
      paramInt = 0;
      break;
    }
    label398:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Agll.a().getResources().getString(2131693310));
    paramIntimateInfo = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    paramIntimateInfo.leftMargin = 0;
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramIntimateInfo);
    paramIntimateInfo = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramIntimateInfo.topMargin = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_Agll.a().getResources());
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramIntimateInfo);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    bdla.b(null, "dc00898", "", "", "0X800AD21", "0X800AD21", 0, 0, "0", "0", "", "");
  }
  
  protected boolean a()
  {
    boolean bool = arav.a().c;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList.size() > 0))
    {
      i = 1;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label74;
      }
    }
    label74:
    for (int j = 1;; j = 0)
    {
      if ((!bool) || ((i == 0) && (j == 0))) {
        break label79;
      }
      return true;
      i = 0;
      break;
    }
    label79:
    return false;
  }
  
  public void setNeedReportPage(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setReportType(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemCommonTroopView
 * JD-Core Version:    0.7.0.1
 */