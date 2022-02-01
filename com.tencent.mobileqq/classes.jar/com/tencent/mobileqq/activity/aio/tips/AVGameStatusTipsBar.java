package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.api.impl.AvGameManagerImpl;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameRoomListFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AVGameStatusTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private final int jdField_a_of_type_Int = 3;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString;
  private List<RoomInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  
  public AVGameStatusTipsBar(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, TipsManager paramTipsManager, Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVGameStatusTipsBar.");
    localStringBuilder.append(paramBaseSessionInfo.jdField_a_of_type_Int);
    localStringBuilder.append(".");
    localStringBuilder.append(paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private String a()
  {
    ArrayList localArrayList = AvGameConfigUtil.a().a();
    if ((localArrayList != null) && (localArrayList.size() != 0)) {
      return (String)localArrayList.get(new Random().nextInt(localArrayList.size()));
    }
    return null;
  }
  
  private List<Player> a(List<RoomInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      RoomInfo localRoomInfo = (RoomInfo)paramList.get(i);
      int j = 3 - localArrayList.size();
      if (localRoomInfo.players.size() >= j)
      {
        localArrayList.addAll(localRoomInfo.getPlayers().subList(0, j));
        return localArrayList;
      }
      localArrayList.addAll(localRoomInfo.players);
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(LinearLayout paramLinearLayout, List<Player> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramLinearLayout.removeAllViews();
      int i = 0;
      while ((i < paramList.size()) && (i < 3))
      {
        Object localObject1 = (Player)paramList.get(i);
        Object localObject2 = ImageUtil.f();
        localObject1 = FaceDrawable.getFaceDrawableFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((Player)localObject1).uin, 3, (Drawable)localObject2, (Drawable)localObject2, 4);
        localObject2 = new ThemeImageView(this.jdField_a_of_type_AndroidAppActivity);
        int j = this.jdField_b_of_type_Int;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        if (i == 0) {
          j = 0;
        } else {
          j = this.jdField_c_of_type_Int;
        }
        localLayoutParams.leftMargin = j;
        ((ThemeImageView)localObject2).setLayoutParams(localLayoutParams);
        ((ThemeImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ThemeImageView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        paramLinearLayout.addView((View)localObject2);
        i += 1;
      }
    }
  }
  
  private void a(String paramString)
  {
    Object localObject1 = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAvGameManager.class, "");
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilList;
      if (localObject2 != null)
      {
        if (((List)localObject2).size() == 0) {
          return;
        }
        boolean bool = ((IAvGameManager)localObject1).isAvGameRoomExist();
        int j = 2;
        int i;
        if (bool) {
          i = 1;
        } else {
          i = 2;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
          j = 1;
        }
        localObject1 = this.jdField_b_of_type_JavaLangString;
        if (localObject1 == null) {
          localObject1 = "";
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(j);
        ReportController.b(null, "dc00898", "", "", paramString, paramString, i, 0, ((StringBuilder)localObject2).toString(), "", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296622);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296621);
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131558654, null);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363320));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AVGameStatusTipsBar.1(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363319));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new AVGameStatusTipsBar.2(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363321));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363317));
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isAdmin()))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(0, 2131363320);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131690508);
      return;
    }
    this.jdField_b_of_type_JavaLangString = a();
  }
  
  private void b(List<RoomInfo> paramList, int paramInt)
  {
    Object localObject1 = this.jdField_b_of_type_JavaLangString;
    String str;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      str = this.jdField_b_of_type_JavaLangString;
    } else {
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131690508);
    }
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131690509);
    localObject1 = localObject2;
    if (paramList != null)
    {
      localObject1 = localObject2;
      if (paramList.size() > 0) {
        if (paramList.size() > 1)
        {
          if (paramInt <= paramList.size()) {
            paramInt = paramList.size();
          }
          localObject1 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131690511), new Object[] { Integer.valueOf(paramInt) });
        }
        else
        {
          localObject1 = (RoomInfo)paramList.get(0);
          localObject1 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131690510), new Object[] { Integer.valueOf(((RoomInfo)localObject1).players.size()) });
        }
      }
    }
    localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(str);
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363318);
    if (paramList != null) {
      paramList = a(paramList);
    } else {
      paramList = null;
    }
    a((LinearLayout)localObject1, paramList);
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839468);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839458));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14737633);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839459));
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() == 1))
    {
      localObject = (RoomInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      IAvGameManager localIAvGameManager = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAvGameManager.class, "");
      if (localIAvGameManager != null) {
        localIAvGameManager.joinAvGameRoom(this.jdField_a_of_type_AndroidAppActivity, 3, String.valueOf(((RoomInfo)localObject).id), this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      QPublicFragmentActivity.start(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, AVGameRoomListFragment.class);
    }
  }
  
  private void d()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131690506)).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131690515), new AVGameStatusTipsBar.4(this)).setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131690401), new AVGameStatusTipsBar.3(this));
    localQQCustomDialog.show();
  }
  
  public int a()
  {
    return 61;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() == this) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(List<RoomInfo> paramList, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      b();
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    b(paramList, paramInt);
    paramList = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    boolean bool = false;
    if (paramList != this) {
      bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
    }
    if ((bool) && (!this.jdField_a_of_type_Boolean))
    {
      AvGameManagerImpl.asyncPreloadAVGameProcess(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (bool) {
      a("0X800B354");
    }
  }
  
  public int[] a()
  {
    return new int[2];
  }
  
  public int b()
  {
    return 2002;
  }
  
  public void onClick(View paramView)
  {
    c();
    a("0X800B01A");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar
 * JD-Core Version:    0.7.0.1
 */