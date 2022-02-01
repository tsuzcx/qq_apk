package com.tencent.mobileqq.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class RobotAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  public View.OnClickListener a = new RobotAdapter.1(this);
  public View.OnClickListener b = new RobotAdapter.2(this);
  TroopRobotObserver c = new RobotAdapter.4(this);
  private QQAppInterface d;
  private BaseActivity e;
  private ArrayList<RobotAdapter.TroopRobotShowInfo> f = new ArrayList();
  private ArrayList<String> g = new ArrayList();
  private IFaceDecoder h;
  private ListView i;
  private int j = 0;
  private String k;
  private boolean l;
  private AbsListView.OnScrollListener m = new RobotAdapter.3(this);
  
  public RobotAdapter(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ListView paramListView, String paramString, boolean paramBoolean)
  {
    this.d = paramQQAppInterface;
    this.e = paramBaseActivity;
    this.i = paramListView;
    this.k = paramString;
    this.l = paramBoolean;
    a(paramQQAppInterface);
    paramListView.setOnScrollListener(this.m);
    this.d.addObserver(this.c);
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramInt = getItemViewType(paramInt);
    View localView;
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return LayoutInflater.from(this.e).inflate(2131627891, null);
      }
      localView = LayoutInflater.from(this.e).inflate(2131627893, null);
      paramViewGroup = localView;
      if (localView != null)
      {
        paramViewGroup = new RobotAdapter.ViewHolder(this);
        paramViewGroup.b = ((ImageView)localView.findViewById(2131434878));
        paramViewGroup.c = ((TextView)localView.findViewById(2131439121));
        paramViewGroup.d = ((TextView)localView.findViewById(2131431757));
        localObject = (Button)localView.findViewById(2131427784);
        paramViewGroup.e = ((Button)localObject);
        paramViewGroup.f = ((ImageView)localView.findViewById(2131439239));
        localView.setTag(paramViewGroup);
        localView.setOnClickListener(this.a);
        ((Button)localObject).setOnClickListener(this.b);
        return localView;
      }
    }
    else
    {
      localView = LayoutInflater.from(this.e).inflate(2131627892, null);
      paramViewGroup = localView;
      if (localView != null)
      {
        localObject = (TextView)localView.findViewById(2131437066);
        paramViewGroup = localView;
        if (localObject != null)
        {
          ((TextView)localObject).setText(this.e.getResources().getText(2131917721));
          ((TextView)localObject).setContentDescription(this.e.getResources().getText(2131917721));
          paramViewGroup = localView;
        }
      }
    }
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView)
  {
    if (getItemViewType(paramInt) != 1) {
      return;
    }
    Object localObject = getItem(paramInt);
    if ((localObject instanceof RobotAdapter.TroopRobotShowInfo))
    {
      RobotAdapter.TroopRobotShowInfo localTroopRobotShowInfo = (RobotAdapter.TroopRobotShowInfo)localObject;
      if (paramView != null)
      {
        paramView = paramView.getTag();
        if ((paramView != null) && ((paramView instanceof RobotAdapter.ViewHolder)))
        {
          RobotAdapter.ViewHolder localViewHolder = (RobotAdapter.ViewHolder)paramView;
          String str = String.valueOf(localTroopRobotShowInfo.b.a());
          localObject = this.h.getBitmapFromCache(1, str);
          paramView = (View)localObject;
          if (localObject == null)
          {
            localObject = ImageUtil.k();
            paramView = (View)localObject;
            if (!this.h.isPausing())
            {
              this.h.requestDecodeFace(str, 1, false);
              paramView = (View)localObject;
            }
          }
          localViewHolder.b.setImageBitmap(paramView);
          localViewHolder.c.setText(localTroopRobotShowInfo.b.b());
          localViewHolder.d.setText(localTroopRobotShowInfo.b.c());
          localViewHolder.a = str;
          localViewHolder.e.setTag(str);
          localViewHolder.b.setContentDescription(localTroopRobotShowInfo.b.b());
          localViewHolder.d.setContentDescription(localTroopRobotShowInfo.b.c());
          paramView = (ITroopRobotService)this.d.getRuntimeService(ITroopRobotService.class, "all");
          boolean bool;
          if (paramView != null) {
            bool = paramView.isRobotUinNeedShowRed(this.d, str, this.k);
          } else {
            bool = false;
          }
          if (bool) {
            localViewHolder.f.setVisibility(0);
          } else {
            localViewHolder.f.setVisibility(8);
          }
          if (this.g.contains(str))
          {
            localViewHolder.e.setEnabled(false);
            localViewHolder.e.setContentDescription(this.e.getResources().getString(2131891379));
            return;
          }
          localViewHolder.e.setEnabled(true);
          localViewHolder.e.setContentDescription(this.e.getResources().getString(2131886199));
        }
      }
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int i1 = this.i.getChildCount();
    int n = 0;
    while (n < i1)
    {
      Object localObject = this.i.getChildAt(n).getTag();
      if ((localObject != null) && ((localObject instanceof RobotAdapter.ViewHolder)))
      {
        localObject = (RobotAdapter.ViewHolder)localObject;
        if ((paramString != null) && (TextUtils.equals(paramString, ((RobotAdapter.ViewHolder)localObject).a)))
        {
          ((RobotAdapter.ViewHolder)localObject).b.setImageBitmap(paramBitmap);
          return;
        }
      }
      n += 1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    BaseActivity localBaseActivity = this.e;
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.runOnUiThread(new RobotAdapter.5(this, paramString, paramBoolean, paramInt));
  }
  
  public void a()
  {
    this.h.destory();
    this.d.removeObserver(this.c);
    this.e = null;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = ((BaseActivity)localObject).getResources().getString(2131888415);
    switch (paramInt)
    {
    default: 
      break;
    case 10025: 
      localObject = this.e.getResources().getString(2131889052);
      break;
    case 10024: 
      localObject = this.e.getResources().getString(2131888408);
      break;
    case 10023: 
      localObject = this.e.getResources().getString(2131889750);
      break;
    case 10022: 
      localObject = this.e.getResources().getString(2131889748);
    }
    QQToast.makeText(BaseApplication.getContext(), 0, (CharSequence)localObject, 1).show();
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.h == null)
    {
      this.h = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
      this.h.setDecodeTaskCompletionListener(this);
    }
  }
  
  public void a(ArrayList<TroopRobotInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.f.clear();
      int n = 0;
      while (n < paramArrayList.size())
      {
        localObject = new RobotAdapter.TroopRobotShowInfo(this, (TroopRobotInfo)paramArrayList.get(n));
        this.f.add(localObject);
        n += 1;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setData arrayList");
      ((StringBuilder)localObject).append(paramArrayList.size());
      QLog.d("RobotAdapter", 2, ((StringBuilder)localObject).toString());
      super.notifyDataSetChanged();
      return;
    }
    QLog.e("RobotAdapter", 2, "setData null");
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.f;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return 2;
      }
      return this.f.size() + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.f;
    if ((localArrayList != null) && (localArrayList.size() > 0) && (paramInt >= 1)) {
      return this.f.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    ArrayList localArrayList = this.f;
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      if (paramInt == 0) {
        return 0;
      }
      return 1;
    }
    if (paramInt == 0) {
      return 0;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    a(paramInt, localView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    a(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter
 * JD-Core Version:    0.7.0.1
 */