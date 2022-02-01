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
  private SimpleArrayMap<Integer, ConnectionsExplorationClidFragment> jdField_a_of_type_AndroidSupportV4UtilSimpleArrayMap = new SimpleArrayMap(10);
  protected QQAppInterface a;
  private ArrayList<ConnectionsTabInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ConnectionsViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, ArrayList<ConnectionsTabInfo> paramArrayList)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  private ConnectionsTabInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (ConnectionsTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ConnectionsExplorationClidFragment a(int paramInt)
  {
    ConnectionsTabInfo localConnectionsTabInfo = a(paramInt);
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
    this.jdField_a_of_type_AndroidSupportV4UtilSimpleArrayMap.put(Integer.valueOf(paramInt), localConnectionsExplorationClidFragment);
    return localConnectionsExplorationClidFragment;
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
    return a(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsViewPagerAdapter", 2, "doOnDestroy  mFragmentsCache.size() = ");
    }
  }
  
  public void a(int paramInt)
  {
    if ((ConnectionsExplorationClidFragment)this.jdField_a_of_type_AndroidSupportV4UtilSimpleArrayMap.get(Integer.valueOf(paramInt)) != null) {
      ((ConnectionsExplorationClidFragment)this.jdField_a_of_type_AndroidSupportV4UtilSimpleArrayMap.get(Integer.valueOf(paramInt))).a();
    }
  }
  
  public void a(ArrayList<ConnectionsTabInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("tabDatasUpdated. size:");
      paramArrayList.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("ConnectionsViewPagerAdapter", 2, paramArrayList.toString());
    }
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    this.jdField_a_of_type_AndroidSupportV4UtilSimpleArrayMap.remove(Integer.valueOf(paramInt));
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCount. size:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("ConnectionsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */