package com.tencent.mobileqq.apollo.view.pannel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.ApolloPanelRedDotUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloTabAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<ApolloActionPackage> jdField_a_of_type_JavaUtilList;
  private int b = -1;
  
  public ApolloTabAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(2131165637);
  }
  
  private boolean a(ApolloActionPackage paramApolloActionPackage)
  {
    return ((paramApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= paramApolloActionPackage.redStartTime)) || ((paramApolloActionPackage.packageId == 8) && (!paramApolloActionPackage.isRecommendTabClick));
  }
  
  public Drawable a(ApolloActionPackage paramApolloActionPackage)
  {
    ApolloActionPackage localApolloActionPackage = null;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    URLDrawable localURLDrawable;
    if (!TextUtils.isEmpty(paramApolloActionPackage.mIconSelectedUrl))
    {
      localURLDrawable = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("" + paramApolloActionPackage.mIconSelectedUrl.hashCode(), null, paramApolloActionPackage.mIconSelectedUrl, true);
      if (localURLDrawable != null) {
        localURLDrawable.startDownload();
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramApolloActionPackage.mIconUnselectedUrl))
      {
        paramApolloActionPackage = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("" + paramApolloActionPackage.mIconSelectedUrl.hashCode(), null, paramApolloActionPackage.mIconSelectedUrl, true);
        localApolloActionPackage = paramApolloActionPackage;
        if (paramApolloActionPackage != null)
        {
          paramApolloActionPackage.startDownload();
          localApolloActionPackage = paramApolloActionPackage;
        }
      }
      if (localURLDrawable != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, localURLDrawable);
      }
      if (localApolloActionPackage != null) {
        localStateListDrawable.addState(new int[] { -16842913 }, localApolloActionPackage);
      }
      return localStateListDrawable;
      localURLDrawable = null;
    }
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (ApolloActionPackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<ApolloActionPackage> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(List<ApolloActionPackage> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @TargetApi(14)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558732, paramViewGroup, false);
      localObject = new ApolloTabAdapter.ViewHolder();
      ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378822));
      ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setActivated(true);
      ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
      ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setEnabled(true);
      ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378819);
      ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378820));
      paramView.setTag(localObject);
    }
    for (;;)
    {
      ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ApolloActionPackage localApolloActionPackage = a(paramInt);
      if (localApolloActionPackage != null)
      {
        ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(a(localApolloActionPackage));
        ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(localApolloActionPackage.name);
        boolean bool = ApolloPanelRedDotUtil.a(localApolloActionPackage.packageId);
        if ((bool) || (a(localApolloActionPackage)))
        {
          ((ApolloTabAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (!bool) {}
        }
      }
      try
      {
        localObject = (IRedTouchManager)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IRedTouchManager.class, "");
        String str = ApolloPanelRedDotUtil.a(localApolloActionPackage.packageId);
        if (str != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("level", 1);
          ((IRedTouchManager)localObject).onRedTouchItemExposure(((IRedTouchManager)localObject).getAppInfoByPath(str), localJSONObject.toString());
          QLog.d("ApolloPanelRedDotUtil", 1, "onRedTouchItemExposure " + localApolloActionPackage.packageId);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("ApolloPanel", 1, "Throwable : ", localThrowable);
          continue;
          paramView.setSelected(false);
        }
      }
      if (paramInt != this.b) {
        break;
      }
      paramView.setSelected(true);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (ApolloTabAdapter.ViewHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloTabAdapter
 * JD-Core Version:    0.7.0.1
 */