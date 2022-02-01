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
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
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
  private final int a = 8;
  private int b;
  private int c;
  private AppInterface d;
  private Activity e;
  private View f;
  private String g;
  private List<RoomInfo> h = new ArrayList(0);
  private int j;
  private int k;
  private boolean l;
  private int m;
  private AvGameRoomListObserver n = new AVGameRoomListFragment.AVGameRoomListAdapter.1(this);
  
  public AVGameRoomListFragment$AVGameRoomListAdapter(Activity paramActivity, AppInterface paramAppInterface, SwipListView paramSwipListView, View paramView, String paramString)
  {
    super(paramActivity, paramAppInterface, paramSwipListView, 1, true);
    this.d = paramAppInterface;
    this.e = paramActivity;
    this.f = paramView;
    this.g = paramString;
    this.b = this.e.getResources().getDimensionPixelSize(2131296918);
    this.c = this.e.getResources().getDimensionPixelSize(2131296917);
    e();
    a(this);
  }
  
  private void a(LinearLayout paramLinearLayout, List<Player> paramList)
  {
    if (paramLinearLayout == null) {
      return;
    }
    paramLinearLayout.removeAllViews();
    if ((paramList != null) && (paramList.size() != 0))
    {
      int i = 0;
      while ((i < paramList.size()) && (i < 8))
      {
        Object localObject1 = (Player)paramList.get(i);
        Object localObject2 = ImageUtil.m();
        localObject1 = FaceDrawable.getFaceDrawableFrom(this.d, 1, ((Player)localObject1).uin, 3, (Drawable)localObject2, (Drawable)localObject2, 4);
        localObject2 = new ThemeImageView(this.e);
        int i1 = this.b;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i1, i1);
        if (i == 0) {
          i1 = 0;
        } else {
          i1 = this.c;
        }
        localLayoutParams.leftMargin = i1;
        ((ThemeImageView)localObject2).setLayoutParams(localLayoutParams);
        ((ThemeImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ThemeImageView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        paramLinearLayout.addView((View)localObject2);
        i += 1;
      }
      paramLinearLayout.setVisibility(0);
      return;
    }
    paramLinearLayout.setVisibility(8);
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
    this.j = 0;
    this.k = 0;
    this.l = true;
  }
  
  private void f()
  {
    if (this.l) {
      return;
    }
    IAvGameManager localIAvGameManager = (IAvGameManager)this.d.getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager != null)
    {
      this.j = this.k;
      this.l = true;
      localIAvGameManager.requestGameRoomListForGroup(this.g, this.j, 2);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameRoomListFragment", 2, "adapter onResume");
    }
    this.d.addObserver(this.n);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameRoomListFragment", 2, "adapter onPause");
    }
    this.d.removeObserver(this.n);
  }
  
  public void c()
  {
    this.d.removeObserver(this.n);
    super.c();
  }
  
  public void d()
  {
    e();
    IAvGameManager localIAvGameManager = (IAvGameManager)this.d.getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager != null) {
      localIAvGameManager.requestGameRoomListForGroup(this.g, 0, 2);
    }
  }
  
  public int getCount()
  {
    List localList = this.h;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.h;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.h.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RoomInfo localRoomInfo = null;
    View localView;
    Object localObject2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.e).inflate(2131624317, null);
      paramView = new AVGameRoomListFragment.AVGameRoomListAdapter.AVGameRoomListItemViewHolder();
      paramView.a = ((TextView)localView.findViewById(2131429180));
      paramView.b = ((TextView)localView.findViewById(2131429181));
      paramView.c = ((LinearLayout)localView.findViewById(2131429179));
      localView.setTag(paramView);
      localView.setOnClickListener(this);
      localView.setOnTouchListener(new AVGameRoomListFragment.AVGameRoomListAdapter.2(this));
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(ViewUtils.dip2px(5.0F));
      ((GradientDrawable)localObject1).setColor(-7510273);
      ((GradientDrawable)localObject1).setShape(0);
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(ViewUtils.dip2px(5.0F));
      ((GradientDrawable)localObject2).setColor(-7510273);
      ((GradientDrawable)localObject2).setShape(0);
      localView.setBackgroundDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/avgames/avgame_room_list_item_bg.png", (Drawable)localObject1, (Drawable)localObject2));
    }
    else
    {
      localObject1 = (AVGameRoomListFragment.AVGameRoomListAdapter.AVGameRoomListItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = getItem(paramInt);
    if ((localObject1 instanceof RoomInfo)) {
      localRoomInfo = (RoomInfo)localObject1;
    }
    if (localRoomInfo != null)
    {
      localObject1 = new StringBuilder(AVGameUtil.a(localRoomInfo.id));
      if (((StringBuilder)localObject1).length() == 9)
      {
        ((StringBuilder)localObject1).insert(6, "-");
        ((StringBuilder)localObject1).insert(3, "-");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.e.getString(2131887365));
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      localObject1 = ((StringBuilder)localObject2).toString();
      paramView.a.setText((CharSequence)localObject1);
      localObject1 = String.format(this.e.getString(2131887364), new Object[] { Integer.valueOf(localRoomInfo.players.size()) });
      paramView.b.setText((CharSequence)localObject1);
      paramView.d = localRoomInfo;
      a(paramView.c, localRoomInfo.players);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.dip2px(80.0F)));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((paramView.getId() == 2131429168) && ((localObject instanceof AVGameRoomListFragment.AVGameRoomListAdapter.AVGameRoomListItemViewHolder)))
    {
      localObject = ((AVGameRoomListFragment.AVGameRoomListAdapter.AVGameRoomListItemViewHolder)localObject).d;
      IAvGameManager localIAvGameManager = (IAvGameManager)this.d.getRuntimeService(IAvGameManager.class, "");
      if (localIAvGameManager != null) {
        localIAvGameManager.joinAvGameRoom(this.e, 5, String.valueOf(((RoomInfo)localObject).id), this.g);
      }
      localObject = this.g;
      if (localObject == null) {
        localObject = "";
      }
      ReportController.b(null, "dc00898", "", "", "0X800B01C", "0X800B01C", 0, 0, "", "", (String)localObject, "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.m = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.m == getCount() - 1)) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter
 * JD-Core Version:    0.7.0.1
 */