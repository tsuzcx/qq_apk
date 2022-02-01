package com.tencent.mobileqq.apollo.aio.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloTabAdapter
  extends BaseAdapter
{
  int a;
  private List<ApolloActionPackage> b;
  private Context c;
  private LayoutInflater d;
  private int e = -1;
  
  public ApolloTabAdapter(Context paramContext)
  {
    this.c = paramContext;
    this.d = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.a = paramContext.getResources().getColor(2131166013);
  }
  
  private Drawable b()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localObject = ViewUtils.getShapeDrawable(this.c.getResources().getColor(2131166584), ViewUtils.dip2px(13.5F));
      localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
      localObject = new ColorDrawable(0);
      localStateListDrawable.addState(new int[0], (Drawable)localObject);
      return localStateListDrawable;
    }
    Object localObject = ViewUtils.getShapeDrawable(this.c.getResources().getColor(2131165475), ViewUtils.dip2px(13.5F));
    localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
    localObject = new ColorDrawable(0);
    localStateListDrawable.addState(new int[0], (Drawable)localObject);
    return localStateListDrawable;
  }
  
  private boolean b(ApolloActionPackage paramApolloActionPackage)
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
    List localList = this.b;
    if (localList == null) {
      return null;
    }
    return (ApolloActionPackage)localList.get(paramInt);
  }
  
  public List<ApolloActionPackage> a()
  {
    return this.b;
  }
  
  public void a(List<ApolloActionPackage> paramList)
  {
    this.b = paramList;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int getCount()
  {
    List localList = this.b;
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
      paramView = this.d.inflate(2131624195, paramViewGroup, false);
      paramViewGroup = new ApolloTabAdapter.ViewHolder();
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131446729));
      paramViewGroup.a.setActivated(true);
      paramViewGroup.a.setFocusable(true);
      paramViewGroup.a.setEnabled(true);
      paramViewGroup.b = paramView.findViewById(2131446725);
      paramViewGroup.b.setBackgroundColor(this.a);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131446727));
      paramViewGroup.d = paramView.findViewById(2131428490);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ApolloTabAdapter.ViewHolder)paramView.getTag();
    }
    paramViewGroup.c.setVisibility(8);
    paramViewGroup.d.setBackgroundDrawable(b());
    ApolloActionPackage localApolloActionPackage = a(paramInt);
    if (localApolloActionPackage != null)
    {
      paramViewGroup.a.setImageDrawable(a(localApolloActionPackage));
      paramViewGroup.a.setContentDescription(localApolloActionPackage.name);
      boolean bool = ApolloPanelRedDotUtil.b(localApolloActionPackage.packageId);
      if ((bool) || (b(localApolloActionPackage)))
      {
        paramViewGroup.c.setVisibility(0);
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
    if (paramInt == this.e)
    {
      paramView.setSelected(true);
      return paramView;
    }
    paramView.setSelected(false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloTabAdapter
 * JD-Core Version:    0.7.0.1
 */