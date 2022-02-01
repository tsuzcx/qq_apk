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
  private int jdField_a_of_type_Int = 0;
  public View.OnClickListener a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  TroopRobotObserver jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver = new RobotAdapter.4(this);
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new RobotAdapter.3(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<RobotAdapter.TroopRobotShowInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public View.OnClickListener b;
  private ArrayList<String> b;
  
  public RobotAdapter(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ListView paramListView, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new RobotAdapter.1(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new RobotAdapter.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramQQAppInterface);
    paramListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver);
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
        return LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561530, null);
      }
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561532, null);
      paramViewGroup = localView;
      if (localView != null)
      {
        paramViewGroup = new RobotAdapter.ViewHolder(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368033));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371697));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365536));
        localObject = (Button)localView.findViewById(2131362203);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)localObject);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131371804));
        localView.setTag(paramViewGroup);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((Button)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        return localView;
      }
    }
    else
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561531, null);
      paramViewGroup = localView;
      if (localView != null)
      {
        localObject = (TextView)localView.findViewById(2131369925);
        paramViewGroup = localView;
        if (localObject != null)
        {
          ((TextView)localObject).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getText(2131720096));
          ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getText(2131720096));
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
          String str = String.valueOf(localTroopRobotShowInfo.a.a());
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, str);
          paramView = (View)localObject;
          if (localObject == null)
          {
            localObject = ImageUtil.f();
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
          paramView = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
          boolean bool;
          if (paramView != null) {
            bool = paramView.isRobotUinNeedShowRed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_JavaLangString);
          } else {
            bool = false;
          }
          if (bool) {
            localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          } else {
            localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          if (this.jdField_b_of_type_JavaUtilArrayList.contains(str))
          {
            localViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            localViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693803));
            return;
          }
          localViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          localViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131689589));
        }
      }
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof RobotAdapter.ViewHolder)))
      {
        localObject = (RobotAdapter.ViewHolder)localObject;
        if ((paramString != null) && (TextUtils.equals(paramString, ((RobotAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString)))
        {
          ((RobotAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          return;
        }
      }
      i += 1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.runOnUiThread(new RobotAdapter.5(this, paramString, paramBoolean, paramInt));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localObject == null) {
      return;
    }
    localObject = ((BaseActivity)localObject).getResources().getString(2131691457);
    switch (paramInt)
    {
    default: 
      break;
    case 10025: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692080);
      break;
    case 10024: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131691453);
      break;
    case 10023: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692679);
      break;
    case 10022: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692678);
    }
    QQToast.a(BaseApplication.getContext(), 0, (CharSequence)localObject, 1).a();
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
        localObject = new RobotAdapter.TroopRobotShowInfo(this, (TroopRobotInfo)paramArrayList.get(i));
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        i += 1;
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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return 2;
      }
      return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0) && (paramInt >= 1)) {
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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter
 * JD-Core Version:    0.7.0.1
 */