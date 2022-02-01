package com.tencent.mobileqq.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureManager.SigCommentInfo;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mqq.os.MqqHandler;

public class SigCommentSessionListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private SigCommentListActivity jdField_a_of_type_ComTencentMobileqqActivitySigCommentListActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SignatureManager jdField_a_of_type_ComTencentMobileqqAppSignatureManager = null;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList<SignatureManager.SigCommentInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public SigCommentSessionListAdapter(SigCommentListActivity paramSigCommentListActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivitySigCommentListActivity = paramSigCommentListActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramSigCommentListActivity);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SIGNATURE_MANAGER));
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SIGNATURE_MANAGER);
    if (localObject != null)
    {
      paramString = ((SignatureManager)localObject).a(paramString);
      if (paramString != null)
      {
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramString.actionText))
        {
          ((StringBuilder)localObject).append(paramString.actionText);
          if (!TextUtils.isEmpty(paramString.dataText)) {
            ((StringBuilder)localObject).append(paramString.dataText);
          }
          ((StringBuilder)localObject).append(' ');
        }
        if (!TextUtils.isEmpty(paramString.getPlainText())) {
          ((StringBuilder)localObject).append(paramString.getPlainText());
        }
        paramTextView.setText(((StringBuilder)localObject).toString());
      }
    }
  }
  
  public SignatureManager.SigCommentInfo a(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return (SignatureManager.SigCommentInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public List<SignatureManager.SigCommentInfo> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      return null;
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
  }
  
  public void a(int paramInt)
  {
    View localView = this.b;
    if (localView != null) {
      ((SigCommentSessionListAdapter.MoreViewHolder)localView.getTag()).jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    }
  }
  
  public void a(List<SignatureManager.SigCommentInfo> paramList, boolean paramBoolean)
  {
    if (paramList != this.jdField_a_of_type_JavaUtilArrayList) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramList);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    if (i == 0) {
      return 1;
    }
    return i + (true ^ this.jdField_a_of_type_Boolean);
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
      if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentWidgetXListView.getHeight()));
      localObject1 = this.jdField_a_of_type_AndroidViewView;
    }
    else if (1 == i)
    {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562858, this.jdField_a_of_type_ComTencentWidgetXListView, false);
        localObject1 = new SigCommentSessionListAdapter.ViewHolder();
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377585));
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377586));
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377583));
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377584));
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).c = ((TextView)paramView.findViewById(2131377587));
        paramView.setTag(localObject1);
      }
      else
      {
        localObject1 = (SigCommentSessionListAdapter.ViewHolder)paramView.getTag();
      }
      SignatureManager.SigCommentInfo localSigCommentInfo = a(paramInt);
      Object localObject2 = String.valueOf(localSigCommentInfo.uin);
      Object localObject3 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject2);
      if (localObject3 != null) {
        ((SigCommentSessionListAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
      }
      localObject2 = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
      ((SigCommentSessionListAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      ((SigCommentSessionListAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850370);
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(localSigCommentInfo.time * 1000L);
      i = ((Calendar)localObject2).get(9);
      localObject2 = new SimpleDateFormat("hh:mm").format(new Date(localSigCommentInfo.time * 1000L));
      if (i == 0)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131713983));
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject2 = ((StringBuilder)localObject3).toString();
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131713980));
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject2 = ((StringBuilder)localObject3).toString();
      }
      ((SigCommentSessionListAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      a(localSigCommentInfo.feedsid, ((SigCommentSessionListAdapter.ViewHolder)localObject1).c);
      localObject1 = paramView;
    }
    else
    {
      localObject1 = paramView;
      if (2 == i)
      {
        if (paramView == null)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562047, this.jdField_a_of_type_ComTencentWidgetXListView, false);
          paramView.setOnClickListener(this);
          localObject1 = new SigCommentSessionListAdapter.MoreViewHolder();
          paramView.setTag(localObject1);
          paramView.findViewById(2131370354).setVisibility(8);
          ((SigCommentSessionListAdapter.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371517));
          this.b = paramView;
        }
        else
        {
          paramView = (SigCommentSessionListAdapter.MoreViewHolder)paramView.getTag();
        }
        localObject1 = this.b;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    if (this.b == paramView)
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SigCommentListActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(0, 1, 0), 200L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SigCommentSessionListAdapter
 * JD-Core Version:    0.7.0.1
 */