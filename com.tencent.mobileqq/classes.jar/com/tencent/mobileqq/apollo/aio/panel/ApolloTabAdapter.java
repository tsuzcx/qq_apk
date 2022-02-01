package com.tencent.mobileqq.apollo.aio.panel;

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
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.utils.ApolloPanelRedDotUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qphone.base.util.QLog;
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
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(2131165618);
  }
  
  private boolean a(ApolloActionPackage paramApolloActionPackage)
  {
    return ((paramApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= paramApolloActionPackage.redStartTime)) || ((paramApolloActionPackage.packageId == 8) && (!paramApolloActionPackage.isRecommendTabClick));
  }
  
  public Drawable a(ApolloActionPackage paramApolloActionPackage)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    boolean bool = TextUtils.isEmpty(paramApolloActionPackage.mIconSelectedUrl);
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (!bool)
    {
      localObject1 = (IApolloUtil)QRoute.api(IApolloUtil.class);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramApolloActionPackage.mIconSelectedUrl.hashCode());
      localObject3 = ((IApolloUtil)localObject1).getDrawable(((StringBuilder)localObject3).toString(), null, paramApolloActionPackage.mIconSelectedUrl, true);
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        ((URLDrawable)localObject3).startDownload();
        localObject1 = localObject3;
      }
    }
    else
    {
      localObject1 = null;
    }
    if (!TextUtils.isEmpty(paramApolloActionPackage.mIconUnselectedUrl))
    {
      localObject2 = (IApolloUtil)QRoute.api(IApolloUtil.class);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramApolloActionPackage.mIconSelectedUrl.hashCode());
      paramApolloActionPackage = ((IApolloUtil)localObject2).getDrawable(((StringBuilder)localObject3).toString(), null, paramApolloActionPackage.mIconSelectedUrl, true);
      localObject2 = paramApolloActionPackage;
      if (paramApolloActionPackage != null)
      {
        paramApolloActionPackage.startDownload();
        localObject2 = paramApolloActionPackage;
      }
    }
    if (localObject1 != null) {
      localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject1);
    }
    if (localObject2 != null) {
      localStateListDrawable.addState(new int[] { -16842913 }, (Drawable)localObject2);
    }
    return localStateListDrawable;
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return null;
    }
    return (ApolloActionPackage)localList.get(paramInt);
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @TargetApi(14)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558630, paramViewGroup, false);
      paramViewGroup = new ApolloTabAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378211));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setActivated(true);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setEnabled(true);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378207);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378209));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ApolloTabAdapter.ViewHolder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    ApolloActionPackage localApolloActionPackage = a(paramInt);
    if (localApolloActionPackage != null)
    {
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(a(localApolloActionPackage));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(localApolloActionPackage.name);
      boolean bool = ApolloPanelRedDotUtil.a(localApolloActionPackage.packageId);
      if ((bool) || (a(localApolloActionPackage)))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (bool) {
          try
          {
            paramViewGroup = (IRedTouchManager)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IRedTouchManager.class, "");
            String str = ApolloPanelRedDotUtil.a(localApolloActionPackage.packageId);
            if (str != null)
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("level", 1);
              paramViewGroup.onRedTouchItemExposure(paramViewGroup.getAppInfoByPath(str), localJSONObject.toString());
              paramViewGroup = new StringBuilder();
              paramViewGroup.append("onRedTouchItemExposure ");
              paramViewGroup.append(localApolloActionPackage.packageId);
              QLog.d("ApolloPanelRedDotUtil", 1, paramViewGroup.toString());
            }
          }
          catch (Throwable paramViewGroup)
          {
            QLog.e("[cmshow]ApolloPanel", 1, "Throwable : ", paramViewGroup);
          }
        }
      }
    }
    if (paramInt == this.b)
    {
      paramView.setSelected(true);
      return paramView;
    }
    paramView.setSelected(false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloTabAdapter
 * JD-Core Version:    0.7.0.1
 */