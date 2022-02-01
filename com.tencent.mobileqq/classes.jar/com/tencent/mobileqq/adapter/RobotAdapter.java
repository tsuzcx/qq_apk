package com.tencent.mobileqq.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.troop.utils.TroopRobotInfo;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
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
  private int jdField_a_of_type_Int = 0;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View.OnClickListener a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new RobotAdapter.4(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new RobotAdapter.3(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<RobotAdapter.TroopRobotShowInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public View.OnClickListener b;
  private ArrayList<String> b;
  
  public RobotAdapter(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, ListView paramListView, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new RobotAdapter.1(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new RobotAdapter.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramQQAppInterface);
    paramListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561689, null);
      if (paramViewGroup != null)
      {
        localObject = (TextView)paramViewGroup.findViewById(2131370257);
        if (localObject != null)
        {
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131720357));
          ((TextView)localObject).setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131720357));
        }
        return paramViewGroup;
      }
      break;
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561688, null);
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561690, null);
      if (paramViewGroup != null)
      {
        localObject = new RobotAdapter.ViewHolder(this);
        ((RobotAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368281));
        ((RobotAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372115));
        ((RobotAdapter.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365699));
        Button localButton = (Button)paramViewGroup.findViewById(2131362177);
        ((RobotAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetButton = localButton;
        ((RobotAdapter.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131372220));
        paramViewGroup.setTag(localObject);
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      return paramViewGroup;
    }
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView)
  {
    switch (getItemViewType(paramInt))
    {
    }
    RobotAdapter.TroopRobotShowInfo localTroopRobotShowInfo;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getItem(paramInt);
        } while (!(localObject instanceof RobotAdapter.TroopRobotShowInfo));
        localTroopRobotShowInfo = (RobotAdapter.TroopRobotShowInfo)localObject;
      } while (paramView == null);
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof RobotAdapter.ViewHolder)));
    RobotAdapter.ViewHolder localViewHolder = (RobotAdapter.ViewHolder)paramView;
    String str = String.valueOf(localTroopRobotShowInfo.a.a());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, str);
    paramView = (View)localObject;
    if (localObject == null)
    {
      localObject = ImageUtil.c();
      paramView = (View)localObject;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(str, 1, false);
        paramView = (View)localObject;
      }
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopRobotShowInfo.a.a());
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localTroopRobotShowInfo.a.b());
    localViewHolder.jdField_a_of_type_JavaLangString = str;
    localViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(str);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(localTroopRobotShowInfo.a.a());
    localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(localTroopRobotShowInfo.a.b());
    paramView = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    if (paramView != null) {}
    for (boolean bool = paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_JavaLangString);; bool = false)
    {
      if (bool) {
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      while (this.jdField_b_of_type_JavaUtilArrayList.contains(str))
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        localViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693849));
        return;
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      localViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131689557));
      return;
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof RobotAdapter.ViewHolder)))
        {
          localObject = (RobotAdapter.ViewHolder)localObject;
          if ((paramString != null) && (TextUtils.equals(paramString, ((RobotAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString))) {
            ((RobotAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new RobotAdapter.5(this, paramString, paramBoolean, paramInt));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691536);
    switch (paramInt)
    {
    }
    for (;;)
    {
      QQToast.a(BaseApplication.getContext(), 0, str, 1).a();
      return;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692721);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692722);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691531);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692160);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    }
  }
  
  public void a(ArrayList<TroopRobotInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        RobotAdapter.TroopRobotShowInfo localTroopRobotShowInfo = new RobotAdapter.TroopRobotShowInfo(this, (TroopRobotInfo)paramArrayList.get(i));
        this.jdField_a_of_type_JavaUtilArrayList.add(localTroopRobotShowInfo);
        i += 1;
      }
      QLog.d("RobotAdapter", 2, "setData arrayList" + paramArrayList.size());
      super.notifyDataSetChanged();
      return;
    }
    QLog.e("RobotAdapter", 2, "setData null");
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return 2;
      }
      return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramInt >= 1)) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (paramInt != 0) {}
    }
    while (paramInt == 0)
    {
      return 0;
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = a(paramInt, paramViewGroup);
    }
    for (;;)
    {
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
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