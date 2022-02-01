package com.tencent.avgame.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class AVGameRoomListFragment$AVGameRoomListAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  private final int jdField_a_of_type_Int = 8;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AVGameRoomListFragment.AVGameRoomListAdapter.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<RoomInfo> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public AVGameRoomListFragment$AVGameRoomListAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView, String paramString)
  {
    super(paramActivity, paramQQAppInterface, paramSwipListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296637);
    this.c = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296636);
    e();
    a(this);
  }
  
  private void a(LinearLayout paramLinearLayout, List<Player> paramList)
  {
    if (paramLinearLayout == null) {
      return;
    }
    paramLinearLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0))
    {
      paramLinearLayout.setVisibility(8);
      return;
    }
    int i = 0;
    if ((i < paramList.size()) && (i < 8))
    {
      Object localObject1 = (Player)paramList.get(i);
      Object localObject2 = ImageUtil.d();
      localObject1 = FaceDrawable.getFaceDrawableFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((Player)localObject1).uin, 3, (Drawable)localObject2, (Drawable)localObject2, 4);
      localObject2 = new ThemeImageView(this.jdField_a_of_type_AndroidAppActivity);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.b, this.b);
      if (i == 0) {}
      for (int j = 0;; j = this.c)
      {
        localLayoutParams.leftMargin = j;
        ((ThemeImageView)localObject2).setLayoutParams(localLayoutParams);
        ((ThemeImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ThemeImageView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        paramLinearLayout.addView((View)localObject2);
        i += 1;
        break;
      }
    }
    paramLinearLayout.setVisibility(0);
  }
  
  private void a(List<RoomInfo> paramList1, List<RoomInfo> paramList2)
  {
    int i = 0;
    while (i < paramList2.size())
    {
      RoomInfo localRoomInfo = (RoomInfo)paramList2.get(i);
      if (!paramList1.contains(localRoomInfo)) {
        paramList1.add(localRoomInfo);
      }
      i += 1;
    }
  }
  
  private void e()
  {
    this.d = 0;
    this.e = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean) {}
    AvGameManager localAvGameManager;
    do
    {
      return;
      localAvGameManager = (AvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    } while (localAvGameManager == null);
    this.d = this.e;
    this.jdField_a_of_type_Boolean = true;
    localAvGameManager.a(this.jdField_a_of_type_JavaLangString, this.d, 2);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameRoomListFragment", 2, "adapter onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameRoomListFragment", 2, "adapter onPause");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
    super.c();
  }
  
  public void d()
  {
    e();
    AvGameManager localAvGameManager = (AvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localAvGameManager != null) {
      localAvGameManager.a(this.jdField_a_of_type_JavaLangString, 0, 2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558800, null);
      paramView = new AVGameRoomListFragment.AVGameRoomListAdapter.AVGameRoomListItemViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363374));
      paramView.b = ((TextView)localView.findViewById(2131363375));
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363373));
      localView.setTag(paramView);
      localView.setOnClickListener(this);
      localView.setOnTouchListener(new AVGameRoomListFragment.AVGameRoomListAdapter.2(this));
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(ViewUtils.a(5.0F));
      ((GradientDrawable)localObject1).setColor(-7510273);
      ((GradientDrawable)localObject1).setShape(0);
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(ViewUtils.a(5.0F));
      ((GradientDrawable)localObject2).setColor(-7510273);
      ((GradientDrawable)localObject2).setShape(0);
      localView.setBackgroundDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/avgames/avgame_room_list_item_bg.png", (Drawable)localObject1, (Drawable)localObject2));
      localObject1 = getItem(paramInt);
      if (!(localObject1 instanceof RoomInfo)) {
        break label420;
      }
    }
    label420:
    for (Object localObject1 = (RoomInfo)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder(AVGameUtils.a(((RoomInfo)localObject1).id));
        if (((StringBuilder)localObject2).length() == 9)
        {
          ((StringBuilder)localObject2).insert(6, "-");
          ((StringBuilder)localObject2).insert(3, "-");
        }
        localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131690529) + " " + ((StringBuilder)localObject2).toString();
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        localObject2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131690528), new Object[] { Integer.valueOf(((RoomInfo)localObject1).players.size()) });
        paramView.b.setText((CharSequence)localObject2);
        paramView.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = ((RoomInfo)localObject1);
        a(paramView.jdField_a_of_type_AndroidWidgetLinearLayout, ((RoomInfo)localObject1).players);
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.a(80.0F)));
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (AVGameRoomListFragment.AVGameRoomListAdapter.AVGameRoomListItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    switch (paramView.getId())
    {
    }
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    } while (!(localObject instanceof AVGameRoomListFragment.AVGameRoomListAdapter.AVGameRoomListItemViewHolder));
    localObject = ((AVGameRoomListFragment.AVGameRoomListAdapter.AVGameRoomListItemViewHolder)localObject).jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
    AvGameManager localAvGameManager = (AvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localAvGameManager != null) {
      localAvGameManager.a(this.jdField_a_of_type_AndroidAppActivity, 5, String.valueOf(((RoomInfo)localObject).id), this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (localObject = this.jdField_a_of_type_JavaLangString;; localObject = "")
    {
      ReportController.b(null, "dc00898", "", "", "0X800B01C", "0X800B01C", 0, 0, "", "", (String)localObject, "");
      break;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.f == getCount() - 1)) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter
 * JD-Core Version:    0.7.0.1
 */