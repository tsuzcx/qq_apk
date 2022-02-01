package com.tencent.mobileqq.activity.aio.coreui.pluspanel;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class PlusPanelAppListAdapter
  extends RecyclerView.Adapter<PlusPanelAppListAdapter.ViewHolder>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<PluginData> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public PlusPanelAppListAdapter(QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  private BusinessInfoCheckUpdate.AppInfo a(PluginData paramPluginData)
  {
    return ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoFilterByID(10, String.valueOf(paramPluginData.c), paramPluginData.f);
  }
  
  private void a(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, PluginData paramPluginData)
  {
    View localView = paramViewHolder.itemView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPluginData.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(HardCodeUtil.a(2131707875));
    localView.setContentDescription(localStringBuilder.toString());
    paramViewHolder.itemView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramViewHolder.itemView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    paramViewHolder.itemView.setEnabled(true);
    paramViewHolder.itemView.setTag(paramPluginData);
    AccessibilityUtil.a(paramViewHolder.itemView, true);
  }
  
  private void b(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    int j = XPanelContainer.a;
    int k = XPanelContainer.b;
    if (paramInt <= 3) {
      i = 3;
    } else {
      i = 6;
    }
    int i = (j - k) / i;
    paramViewHolder.itemView.setPadding(0, i, 0, 0);
    QLog.d("PlusPanelAppListAdapter", 1, new Object[] { "handleItemPadding -> position : ", Integer.valueOf(paramInt), ", XPanelContainer.mExternalPanelheight : ", Integer.valueOf(XPanelContainer.a), ", XPanelContainer.mDefaultExternalPanelheight : ", Integer.valueOf(XPanelContainer.b), ", topPadding : ", Integer.valueOf(i), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d) });
  }
  
  private void b(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, PluginData paramPluginData)
  {
    PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
    PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder).setBackgroundDrawable(paramPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    if ((paramPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
    {
      paramViewHolder = (URLDrawable)paramPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (paramViewHolder.getStatus() == 2) {
        paramViewHolder.restartDownload();
      }
    }
  }
  
  private void c(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, PluginData paramPluginData)
  {
    RedTouch localRedTouch = PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder);
    int i = 0;
    localRedTouch.setVisibility(0);
    PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder).d();
    if (!TextUtils.isEmpty(paramPluginData.c))
    {
      PlusPanelAppListAdapter.ViewHolder.b(paramViewHolder).setVisibility(8);
      paramPluginData = a(paramPluginData);
      if (paramPluginData != null) {
        PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder).a(paramPluginData);
      }
    }
    else
    {
      paramViewHolder = PlusPanelAppListAdapter.ViewHolder.b(paramViewHolder);
      if (!paramPluginData.jdField_a_of_type_Boolean) {
        i = 8;
      }
      paramViewHolder.setVisibility(i);
    }
  }
  
  @NonNull
  public PlusPanelAppListAdapter.ViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558842, null);
    paramInt = ViewUtils.b(15.0F);
    int i = (XPanelContainer.b - paramInt) / 2;
    int j = XPanelContainer.a - XPanelContainer.b;
    int k = j / 2 + i;
    QLog.d("PlusPanelAppListAdapter", 1, new Object[] { "onCreateViewHolder -> radioBtnHeight: ", Integer.valueOf(paramInt), ", perHeight : ", Integer.valueOf(i), ", addedHeight : ", Integer.valueOf(j), ", actualHeight: ", Integer.valueOf(k), ", XPanelContainer.mDefaultExternalPanelheight: ", Integer.valueOf(XPanelContainer.b), ", XPanelContainer.mExternalPanelheight: ", Integer.valueOf(XPanelContainer.a), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d) });
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, k));
    return new PlusPanelAppListAdapter.ViewHolder(paramViewGroup);
  }
  
  public void a(@NonNull PlusPanelAppListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    PluginData localPluginData = (PluginData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    b(paramViewHolder, paramInt);
    b(paramViewHolder, localPluginData);
    c(paramViewHolder, localPluginData);
    PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder).setText(localPluginData.jdField_a_of_type_JavaLangString);
    AccessibilityUtil.a(PlusPanelAppListAdapter.ViewHolder.a(paramViewHolder), false);
    a(paramViewHolder, localPluginData);
  }
  
  public void a(List<PluginData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanelAppListAdapter
 * JD-Core Version:    0.7.0.1
 */