package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import wks;
import wkt;
import wkv;
import wkw;

public class RecommendTroopView
  extends BaseTroopView
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, Observer
{
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new wks(this);
  protected SosoInterface.OnLocationListener a;
  public RecommendTroopAdapter a;
  protected FaceDecoder a;
  public SwipListView a;
  protected final String a;
  public int b;
  public RelativeLayout b;
  public int c;
  public boolean c;
  protected boolean d = true;
  public View e;
  protected boolean e;
  public View f;
  
  public RecommendTroopView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "RecommendTroopView";
  }
  
  protected int a()
  {
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    int i = RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.S, 9000, 0 - i);
      localRecommendTroopManagerImp.a();
      n();
    }
    if ((localRecommendTroopManagerImp != null) && (!this.jdField_b_of_type_Boolean) && (i > 0)) {
      return 1;
    }
    return 0;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopView", 4, "onChecked........");
    }
    if (this.d)
    {
      this.d = false;
      m();
      i();
    }
    int i = a();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Clk_grp_recom", 0, 0, "", i + "", "", "");
    k();
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(RecommendTroopView.class, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      m();
      a();
      continue;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setEmptyView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      continue;
      int i = paramMessage.arg1;
      if (!a().isFinishing()) {
        if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter.getCount() != 0))
        {
          paramMessage = (String)paramMessage.obj;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
          this.f.setVisibility(0);
          this.f.setPadding(0, (int)DisplayUtils.a(getContext(), 10.0F), 0, 0);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "recom", "exp_nearby", 0, 0, "", "", "", "");
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          SharedPreferences localSharedPreferences = a().getSharedPreferences("nearby_troop_count", 0);
          localSharedPreferences.edit().putString("troop_wording", paramMessage);
          localSharedPreferences.edit().putInt("troop_num", i);
          localSharedPreferences.edit().commit();
        }
        else
        {
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.f.setPadding(0, 0, 0, 0);
        }
      }
    }
  }
  
  protected boolean c()
  {
    a(2130969716);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367579));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367582));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131367580));
    this.f = LayoutInflater.from(a()).inflate(2130969947, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.f.findViewById(2131368534));
    this.jdField_e_of_type_AndroidViewView = this.f.findViewById(2131368533);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.f);
    if (a().getSharedPreferences("nearby_troop_count", 0).getInt("troop_num", 0) != 0)
    {
      String str = a().getSharedPreferences("nearby_troop_count", 0).getString("troop_wording", "");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367581));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setTranscriptMode(0);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367584));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter = new RecommendTroopAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext, a());
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return true;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.f.setPadding(0, 0, 0, 0);
    }
  }
  
  protected void d()
  {
    super.d();
    m();
  }
  
  protected void f()
  {
    super.f();
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localRecommendTroopManagerImp != null) {
      localRecommendTroopManagerImp.a();
    }
  }
  
  protected void g()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    GroupCatalogTool.a(a()).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
  }
  
  protected void i()
  {
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localRecommendTroopManagerImp != null) {}
    for (List localList = localRecommendTroopManagerImp.b(); ((localList == null) || (localList.size() == 0)) && (localRecommendTroopManagerImp != null) && (localRecommendTroopManagerImp.a() != 1); localList = null)
    {
      localRecommendTroopManagerImp.a(0L, 1);
      return;
    }
    j();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new wkt(this, 3, true, false, 1800000L, false, false, "RecommendTroopView");
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  public void k()
  {
    if ((this.c) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter.a()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("RecommendTroopView", 4, "reportPv");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
    }
  }
  
  protected void l()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      m();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(new wkv(this));
  }
  
  public void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopView", 4, "refreshRecommendTroopList");
    }
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopView", 4, "refreshRecommendTroopList start ");
    }
    this.jdField_e_of_type_Boolean = true;
    Object localObject = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localObject != null) {}
    for (localObject = ((RecommendTroopManagerImp)localObject).b();; localObject = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(new wkw(this, (List)localObject));
      this.jdField_e_of_type_Boolean = false;
      return;
    }
  }
  
  public void n()
  {
    if (((RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21) != null) && (!this.jdField_b_of_type_Boolean) && (RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
    {
      a(1, true);
      return;
    }
    a(1, false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367584: 
      NearbyTroops.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ReportController.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_nearby", 0, 0, "", "", "", "");
      return;
    }
    NearbyTroops.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "recom", "Clk_nearby", 0, 0, "", "", "", "");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (TextUtils.isEmpty(paramString))) {}
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = String.valueOf(AppConstants.S);
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      if ((paramObservable.equals(paramObject.frienduin)) && ((paramObject.msgtype == -1039) || (paramObject.msgtype == -1040))) {
        l();
      }
    }
    while ((!(paramObject instanceof RecentUser)) || (!paramObservable.equals(((RecentUser)paramObject).uin))) {
      return;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.RecommendTroopView
 * JD-Core Version:    0.7.0.1
 */