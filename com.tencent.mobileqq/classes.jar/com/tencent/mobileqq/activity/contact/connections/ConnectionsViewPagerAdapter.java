package com.tencent.mobileqq.activity.contact.connections;

import android.support.v4.util.SimpleArrayMap;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ConnectionsViewPagerAdapter
  extends FragmentStatePagerAdapter
{
  protected QQAppInterface a;
  private ArrayList<ConnectionsTabInfo> b = new ArrayList();
  private SimpleArrayMap<Integer, ConnectionsExplorationClidFragment> c = new SimpleArrayMap(10);
  
  public ConnectionsViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, ArrayList<ConnectionsTabInfo> paramArrayList)
  {
    super(paramFragmentManager);
    this.a = paramQQAppInterface;
    if (paramArrayList != null) {
      this.b.addAll(paramArrayList);
    }
  }
  
  private ConnectionsTabInfo d(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (ConnectionsTabInfo)this.b.get(paramInt);
    }
    return null;
  }
  
  public BaseFragment a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItem:");
      localStringBuilder.append(paramInt);
      QLog.d("ConnectionsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return b(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsViewPagerAdapter", 2, "doOnDestroy  mFragmentsCache.size() = ");
    }
  }
  
  public void a(ArrayList<ConnectionsTabInfo> paramArrayList)
  {
    this.b.clear();
    this.b.addAll(paramArrayList);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("tabDatasUpdated. size:");
      paramArrayList.append(this.b.size());
      QLog.i("ConnectionsViewPagerAdapter", 2, paramArrayList.toString());
    }
    notifyDataSetChanged();
  }
  
  public ConnectionsExplorationClidFragment b(int paramInt)
  {
    ConnectionsTabInfo localConnectionsTabInfo = d(paramInt);
    ConnectionsExplorationClidFragment localConnectionsExplorationClidFragment = new ConnectionsExplorationClidFragment();
    if (localConnectionsTabInfo != null)
    {
      localConnectionsExplorationClidFragment.a(localConnectionsTabInfo.a);
      localConnectionsExplorationClidFragment.b(paramInt);
      boolean bool;
      if (localConnectionsTabInfo.a == 23) {
        bool = true;
      } else {
        bool = false;
      }
      localConnectionsExplorationClidFragment.a(bool);
    }
    this.c.put(Integer.valueOf(paramInt), localConnectionsExplorationClidFragment);
    return localConnectionsExplorationClidFragment;
  }
  
  public void c(int paramInt)
  {
    if ((ConnectionsExplorationClidFragment)this.c.get(Integer.valueOf(paramInt)) != null) {
      ((ConnectionsExplorationClidFragment)this.c.get(Integer.valueOf(paramInt))).a();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    this.c.remove(Integer.valueOf(paramInt));
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCount. size:");
      localStringBuilder.append(this.b.size());
      QLog.i("ConnectionsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */