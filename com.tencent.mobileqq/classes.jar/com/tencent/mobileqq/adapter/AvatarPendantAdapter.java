package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig.EntryConfig;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarInPendantHeadportraitInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AvatarPendantAdapter
  extends BaseAdapter
{
  static LRULinkedHashMap<String, URLDrawable> i = new LRULinkedHashMap(15);
  SharedPreferences A;
  public boolean B = false;
  Context a;
  QQAppInterface b;
  int c;
  View.OnClickListener d;
  AdapterView.OnItemClickListener e;
  List<Object> f;
  long g;
  String h;
  final int j = 0;
  final int k = 1;
  final int l = 2;
  final int m = 3;
  final int n = 4;
  int o;
  int p;
  int q;
  int r;
  int s = 4;
  int t;
  int u;
  Drawable v;
  LinearLayout w;
  View x;
  int y;
  int z;
  
  public AvatarPendantAdapter(Context paramContext, View.OnClickListener paramOnClickListener, AdapterView.OnItemClickListener paramOnItemClickListener, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.a = paramContext;
    this.d = paramOnClickListener;
    this.e = paramOnItemClickListener;
    this.f = new ArrayList();
    this.c = paramInt1;
    this.b = paramQQAppInterface;
    this.h = paramString;
    this.o = paramInt2;
    this.r = DisplayUtil.a(this.a, 4.0F);
    paramInt1 = this.c;
    paramInt2 = this.r;
    int i1 = this.s;
    this.p = ((paramInt1 - paramInt2 * (i1 + 1)) / i1);
    paramInt1 = this.p;
    this.q = (paramInt1 * 176 / 150);
    this.t = (paramInt1 - DisplayUtil.a(this.a, 10.0F));
    this.u = (this.q - DisplayUtil.a(this.a, 10.0F));
    this.v = new ColorDrawable(0);
  }
  
  public void a()
  {
    i.clear();
  }
  
  public void a(List<AvatarPendantShopSeriesInfo> paramList, List<AvatarInPendantHeadportraitInfo> paramList1, List<CmAvatarFaceInfo> paramList2)
  {
    this.f.clear();
    if ((paramList2 != null) && (paramList2.size() > 0)) {
      this.f.add(0, paramList2);
    }
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.f.add(paramList1);
    }
    this.f.addAll(paramList);
    paramList = ((FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.h);
    if (paramList != null)
    {
      this.g = paramList.pendantId;
      this.y = paramList.faceId;
    }
    super.notifyDataSetChanged();
  }
  
  public void a(List<AvatarPendantShopSeriesInfo> paramList, List<AvatarInPendantHeadportraitInfo> paramList1, List<CmAvatarFaceInfo> paramList2, int paramInt)
  {
    this.f.clear();
    if ((paramList2 != null) && (paramList2.size() > 0)) {
      this.f.add(0, paramList2);
    }
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.f.add(paramList1);
    }
    this.f.addAll(paramList);
    paramList = ((FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.h);
    if (paramList != null) {
      this.g = paramList.pendantId;
    }
    this.y = paramInt;
    super.notifyDataSetChanged();
  }
  
  public void b()
  {
    if (this.w != null)
    {
      if (this.x == null) {
        return;
      }
      List localList = PendantMarketConfig.a;
      if ((localList != null) && (!localList.isEmpty()))
      {
        this.w.removeAllViews();
        int i1 = 0;
        while (i1 < localList.size())
        {
          Object localObject1 = (PendantMarketConfig.EntryConfig)localList.get(i1);
          View localView = LayoutInflater.from(this.a).inflate(2131628291, null);
          Object localObject2 = (ImageView)localView.findViewById(2131429035);
          TextView localTextView1 = (TextView)localView.findViewById(2131432039);
          TextView localTextView2 = (TextView)localView.findViewById(2131432037);
          ImageView localImageView = (ImageView)localView.findViewById(2131446657);
          if (!TextUtils.isEmpty(((PendantMarketConfig.EntryConfig)localObject1).b)) {
            ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((PendantMarketConfig.EntryConfig)localObject1).b));
          }
          localTextView1.setText(((PendantMarketConfig.EntryConfig)localObject1).d);
          localTextView2.setText(((PendantMarketConfig.EntryConfig)localObject1).e);
          int i2 = ((PendantMarketConfig.EntryConfig)localObject1).f;
          if (i2 != 0)
          {
            if (i2 != 4)
            {
              if (i2 != 5)
              {
                if (i2 != 6)
                {
                  localImageView.setVisibility(8);
                }
                else
                {
                  localImageView.setImageResource(2130838589);
                  localImageView.setVisibility(0);
                }
              }
              else
              {
                localImageView.setImageResource(2130848949);
                localImageView.setVisibility(0);
              }
            }
            else
            {
              localImageView.setImageResource(2130848950);
              localImageView.setVisibility(0);
            }
          }
          else {
            localImageView.setVisibility(8);
          }
          if (localImageView.getVisibility() == 0)
          {
            localObject2 = localImageView.getDrawable();
            if (localObject2 != null) {
              localImageView.setLayoutParams(new LinearLayout.LayoutParams(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight()));
            }
          }
          localView.setOnClickListener(new AvatarPendantAdapter.1(this, (PendantMarketConfig.EntryConfig)localObject1, i1));
          localView.addOnLayoutChangeListener(new AvatarPendantAdapter.2(this));
          if (i1 != 0) {
            localView.findViewById(2131446260).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, AIOUtils.b(75.0F, this.a.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.w.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i1 += 1;
        }
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        return;
      }
      this.w.setVisibility(8);
      this.x.setVisibility(8);
    }
  }
  
  public int getCount()
  {
    return this.f.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
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
    if (paramInt == 0) {
      return 0;
    }
    Object localObject = this.f.get(paramInt - 1);
    if ((localObject instanceof List))
    {
      List localList = (List)localObject;
      if ((localList.size() > 0) && ((localList.get(0) instanceof CmAvatarFaceInfo))) {
        return 4;
      }
    }
    if ((localObject instanceof AvatarPendantShopSeriesInfo)) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    if ((paramInt < getCount()) && (paramInt >= 0))
    {
      int i1 = getItemViewType(paramInt);
      Object localObject1;
      Object localObject3;
      if (paramView == null)
      {
        localObject2 = new AvatarPendantAdapter.ViewHolder(this);
        if (i1 == 0)
        {
          paramView = LayoutInflater.from(this.a).inflate(2131628294, paramViewGroup, false);
          localObject1 = paramView.findViewById(2131449057);
          localObject3 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject3).height = this.o;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.w = ((LinearLayout)paramView.findViewById(2131432582));
          this.x = paramView.findViewById(2131449058);
          b();
          paramView.setTag(localObject2);
          localObject1 = localObject2;
        }
        else if (i1 == 1)
        {
          paramView = LayoutInflater.from(this.a).inflate(2131628293, paramViewGroup, false);
          ((AvatarPendantAdapter.ViewHolder)localObject2).a = ((RelativeLayout)paramView.findViewById(2131439949));
          ((AvatarPendantAdapter.ViewHolder)localObject2).b = ((ImageView)paramView.findViewById(2131439953));
          ((AvatarPendantAdapter.ViewHolder)localObject2).c = ((TextView)paramView.findViewById(2131439955));
          ((AvatarPendantAdapter.ViewHolder)localObject2).d = ((ImageView)paramView.findViewById(2131439954));
          ((AvatarPendantAdapter.ViewHolder)localObject2).e = ((GridView)paramView.findViewById(2131439942));
          ((AvatarPendantAdapter.ViewHolder)localObject2).f = ((TextView)paramView.findViewById(2131439947));
          ((AvatarPendantAdapter.ViewHolder)localObject2).g = ((ImageView)paramView.findViewById(2131439946));
          ((AvatarPendantAdapter.ViewHolder)localObject2).h = ((LinearLayout)paramView.findViewById(2131439933));
          ((AvatarPendantAdapter.ViewHolder)localObject2).i = ((TextView)paramView.findViewById(2131439935));
          ((AvatarPendantAdapter.ViewHolder)localObject2).j = ((TextView)paramView.findViewById(2131439934));
          ((AvatarPendantAdapter.ViewHolder)localObject2).k = paramView.findViewById(2131432025);
          localObject1 = new AvatarPendantAdapter.PendantGridAdapter(this);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setAdapter((ListAdapter)localObject1);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setNumColumns(this.s);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setColumnWidth(this.p);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setHorizontalSpacing(this.r);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setVerticalSpacing(this.r);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setSelector(new ColorDrawable(0));
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setClickable(true);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setOnItemClickListener(this.e);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setAddStatesFromChildren(true);
          ((AvatarPendantAdapter.ViewHolder)localObject2).f.setOnClickListener(this.d);
          ((AvatarPendantAdapter.ViewHolder)localObject2).g.setOnClickListener(this.d);
          paramView.setTag(localObject2);
          localObject1 = localObject2;
        }
        else if (i1 == 2)
        {
          paramView = LayoutInflater.from(this.a).inflate(2131628288, paramViewGroup, false);
          ((AvatarPendantAdapter.ViewHolder)localObject2).a = ((RelativeLayout)paramView.findViewById(2131432743));
          ((AvatarPendantAdapter.ViewHolder)localObject2).b = ((ImageView)paramView.findViewById(2131432761));
          ((AvatarPendantAdapter.ViewHolder)localObject2).c = ((TextView)paramView.findViewById(2131432763));
          ((AvatarPendantAdapter.ViewHolder)localObject2).d = ((ImageView)paramView.findViewById(2131432762));
          ((AvatarPendantAdapter.ViewHolder)localObject2).e = ((GridView)paramView.findViewById(2131442957));
          ((AvatarPendantAdapter.ViewHolder)localObject2).f = ((TextView)paramView.findViewById(2131432741));
          ((AvatarPendantAdapter.ViewHolder)localObject2).g = ((ImageView)paramView.findViewById(2131432740));
          ((AvatarPendantAdapter.ViewHolder)localObject2).h = ((LinearLayout)paramView.findViewById(2131432719));
          ((AvatarPendantAdapter.ViewHolder)localObject2).i = ((TextView)paramView.findViewById(2131432721));
          ((AvatarPendantAdapter.ViewHolder)localObject2).j = ((TextView)paramView.findViewById(2131432720));
          ((AvatarPendantAdapter.ViewHolder)localObject2).k = paramView.findViewById(2131432025);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setAdapter(new AvatarPendantAdapter.FaceGridAdapter(this));
          localObject1 = ((AvatarPendantAdapter.ViewHolder)localObject2).c;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(HardCodeUtil.a(2131899119));
          ((StringBuilder)localObject3).append(AvatarPendantManager.i);
          ((StringBuilder)localObject3).append(")");
          ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setNumColumns(this.s);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setColumnWidth(this.p);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setHorizontalSpacing(this.r);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setVerticalSpacing(this.r);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setSelector(new ColorDrawable(0));
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setClickable(true);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setOnItemClickListener(this.e);
          ((AvatarPendantAdapter.ViewHolder)localObject2).e.setAddStatesFromChildren(true);
          ((AvatarPendantAdapter.ViewHolder)localObject2).f.setOnClickListener(this.d);
          ((AvatarPendantAdapter.ViewHolder)localObject2).g.setOnClickListener(this.d);
          paramView.setTag(localObject2);
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
          if (i1 == 4)
          {
            paramView = LayoutInflater.from(this.a).inflate(2131628286, paramViewGroup, false);
            ((AvatarPendantAdapter.ViewHolder)localObject2).a = ((RelativeLayout)paramView.findViewById(2131430902));
            ((AvatarPendantAdapter.ViewHolder)localObject2).b = ((ImageView)paramView.findViewById(2131430905));
            ((AvatarPendantAdapter.ViewHolder)localObject2).c = ((TextView)paramView.findViewById(2131430907));
            ((AvatarPendantAdapter.ViewHolder)localObject2).d = ((ImageView)paramView.findViewById(2131430906));
            ((AvatarPendantAdapter.ViewHolder)localObject2).e = ((GridView)paramView.findViewById(2131430898));
            ((AvatarPendantAdapter.ViewHolder)localObject2).f = ((TextView)paramView.findViewById(2131430901));
            ((AvatarPendantAdapter.ViewHolder)localObject2).g = ((ImageView)paramView.findViewById(2131430899));
            ((AvatarPendantAdapter.ViewHolder)localObject2).h = ((LinearLayout)paramView.findViewById(2131430894));
            ((AvatarPendantAdapter.ViewHolder)localObject2).i = ((TextView)paramView.findViewById(2131430896));
            ((AvatarPendantAdapter.ViewHolder)localObject2).j = ((TextView)paramView.findViewById(2131430895));
            ((AvatarPendantAdapter.ViewHolder)localObject2).k = paramView.findViewById(2131432025);
            ((AvatarPendantAdapter.ViewHolder)localObject2).e.setAdapter(new CmshowFaceGridAdapter(this.a, this.p, this.q, this.y, this.z));
            localObject1 = ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).getCmshowAvatarTitle();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append("(");
            ((StringBuilder)localObject3).append(((AvatarPendantActivity)this.a).n());
            ((StringBuilder)localObject3).append(")");
            localObject1 = ((StringBuilder)localObject3).toString();
            ((AvatarPendantAdapter.ViewHolder)localObject2).c.setText((CharSequence)localObject1);
            ((AvatarPendantAdapter.ViewHolder)localObject2).e.setNumColumns(this.s);
            ((AvatarPendantAdapter.ViewHolder)localObject2).e.setColumnWidth(this.p);
            ((AvatarPendantAdapter.ViewHolder)localObject2).e.setHorizontalSpacing(this.r);
            ((AvatarPendantAdapter.ViewHolder)localObject2).e.setVerticalSpacing(this.r);
            ((AvatarPendantAdapter.ViewHolder)localObject2).e.setSelector(new ColorDrawable(0));
            ((AvatarPendantAdapter.ViewHolder)localObject2).e.setClickable(true);
            ((AvatarPendantAdapter.ViewHolder)localObject2).e.setOnItemClickListener(this.e);
            ((AvatarPendantAdapter.ViewHolder)localObject2).e.setAddStatesFromChildren(true);
            ((AvatarPendantAdapter.ViewHolder)localObject2).f.setOnClickListener(this.d);
            ((AvatarPendantAdapter.ViewHolder)localObject2).g.setOnClickListener(this.d);
            paramView.setTag(localObject2);
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject1 = (AvatarPendantAdapter.ViewHolder)paramView.getTag();
      }
      ((AvatarPendantAdapter.ViewHolder)localObject1).l = paramInt;
      if (i1 == 1)
      {
        AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo = (AvatarPendantShopSeriesInfo)getItem(paramInt);
        ((AvatarPendantAdapter.ViewHolder)localObject1).e.setTag(localAvatarPendantShopSeriesInfo);
        if (localAvatarPendantShopSeriesInfo.d != null) {
          if (localAvatarPendantShopSeriesInfo.d.equals("1"))
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).b.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).b.setImageDrawable(this.a.getResources().getDrawable(2130849338));
          }
          else if (localAvatarPendantShopSeriesInfo.d.equals("3"))
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).b.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).b.setImageDrawable(this.a.getResources().getDrawable(2130849337));
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).b.setVisibility(8);
          }
        }
        if (localAvatarPendantShopSeriesInfo.b != null)
        {
          localObject2 = ((AvatarPendantAdapter.ViewHolder)localObject1).c;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localAvatarPendantShopSeriesInfo.b);
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append(localAvatarPendantShopSeriesInfo.h.size());
          ((StringBuilder)localObject3).append(")");
          ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
          ((AvatarPendantAdapter.ViewHolder)localObject1).c.setContentDescription(localAvatarPendantShopSeriesInfo.b);
        }
        ((AvatarPendantAdapter.ViewHolder)localObject1).d.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.e));
        File localFile;
        switch (localAvatarPendantShopSeriesInfo.e)
        {
        default: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(8);
          break;
        case 7: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setImageDrawable(this.a.getResources().getDrawable(2130849344));
          break;
        case 6: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setImageDrawable(this.a.getResources().getDrawable(2130849345));
          break;
        case 5: 
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(AvatarPendantUtil.e);
          ((StringBuilder)localObject2).append("/rare.png");
          localFile = new File(((StringBuilder)localObject2).toString());
          if (localFile.exists())
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(0);
            localObject3 = (URLDrawable)i.get("key_rare.png");
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              localObject3 = this.v;
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
              localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
              localObject2 = localObject3;
              if (((URLDrawable)localObject3).getStatus() == 1)
              {
                i.put("key_rare.png", localObject3);
                localObject2 = localObject3;
              }
            }
            ((AvatarPendantAdapter.ViewHolder)localObject1).d.setImageDrawable((Drawable)localObject2);
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(8);
          }
          break;
        case 4: 
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(AvatarPendantUtil.e);
          ((StringBuilder)localObject2).append("/free.png");
          localFile = new File(((StringBuilder)localObject2).toString());
          if (localFile.exists())
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(0);
            localObject3 = (URLDrawable)i.get("key_free.png");
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              localObject3 = this.v;
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
              localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
              localObject2 = localObject3;
              if (((URLDrawable)localObject3).getStatus() == 1)
              {
                i.put("key_free.png", localObject3);
                localObject2 = localObject3;
              }
            }
            ((AvatarPendantAdapter.ViewHolder)localObject1).d.setImageDrawable((Drawable)localObject2);
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(8);
          }
          break;
        case 3: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setImageDrawable(this.a.getResources().getDrawable(2130849339));
          break;
        case 2: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setImageDrawable(this.a.getResources().getDrawable(2130848949));
          break;
        case 1: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).d.setImageDrawable(this.a.getResources().getDrawable(2130848950));
        }
        if ((localAvatarPendantShopSeriesInfo.g != null) && (localAvatarPendantShopSeriesInfo.g.equals("actLiTpl")))
        {
          if (localAvatarPendantShopSeriesInfo.b != null)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).i.setText(localAvatarPendantShopSeriesInfo.b);
            ((AvatarPendantAdapter.ViewHolder)localObject1).i.setContentDescription(localAvatarPendantShopSeriesInfo.b);
            ((AvatarPendantAdapter.ViewHolder)localObject1).i.setVisibility(0);
            i1 = 1;
          }
          else
          {
            i1 = 0;
          }
          if (localAvatarPendantShopSeriesInfo.c != null)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).j.setText(localAvatarPendantShopSeriesInfo.c);
            ((AvatarPendantAdapter.ViewHolder)localObject1).j.setVisibility(0);
            i1 = 1;
          }
          if (i1 != 0)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).h.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).k.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).a.setVisibility(8);
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).h.setVisibility(8);
            ((AvatarPendantAdapter.ViewHolder)localObject1).a.setVisibility(0);
          }
        }
        else
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).h.setVisibility(8);
          ((AvatarPendantAdapter.ViewHolder)localObject1).a.setVisibility(0);
        }
        ((AvatarPendantAdapter.PendantGridAdapter)((AvatarPendantAdapter.ViewHolder)localObject1).e.getAdapter()).a(localAvatarPendantShopSeriesInfo);
        ((AvatarPendantAdapter.ViewHolder)localObject1).f.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.a));
        ((AvatarPendantAdapter.ViewHolder)localObject1).g.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.a));
        if ((localAvatarPendantShopSeriesInfo.h.size() > 4) && ((localAvatarPendantShopSeriesInfo.g == null) || (localAvatarPendantShopSeriesInfo.g.equals(""))))
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).f.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).g.setVisibility(0);
          if (!localAvatarPendantShopSeriesInfo.i)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).f.setText(2131892850);
            ((AvatarPendantAdapter.ViewHolder)localObject1).g.setImageResource(2130851883);
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).f.setText(2131914351);
            ((AvatarPendantAdapter.ViewHolder)localObject1).g.setImageResource(2130851886);
          }
        }
        else
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).f.setVisibility(8);
          ((AvatarPendantAdapter.ViewHolder)localObject1).g.setVisibility(8);
        }
        if (paramInt == getCount() - 1)
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).k.setVisibility(8);
          localObject2 = paramView;
        }
        else
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).k.setVisibility(0);
          localObject2 = paramView;
        }
      }
      else if (i1 == 2)
      {
        localObject2 = (List)getItem(paramInt);
        ((AvatarPendantAdapter.FaceGridAdapter)((AvatarPendantAdapter.ViewHolder)localObject1).e.getAdapter()).a((List)localObject2);
        if (((List)localObject2).size() == 8)
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).f.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).g.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).f.setText(HardCodeUtil.a(2131899107));
          localObject2 = paramView;
        }
        else
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).f.setVisibility(8);
          ((AvatarPendantAdapter.ViewHolder)localObject1).g.setVisibility(8);
          localObject2 = paramView;
        }
      }
      else
      {
        localObject2 = paramView;
        if (i1 == 4)
        {
          localObject2 = (List)getItem(paramInt);
          ((CmshowFaceGridAdapter)((AvatarPendantAdapter.ViewHolder)localObject1).e.getAdapter()).a((List)localObject2);
          ((AvatarPendantAdapter.ViewHolder)localObject1).f.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).g.setVisibility(0);
          localObject2 = this.a;
          boolean bool;
          if ((localObject2 instanceof AvatarPendantActivity)) {
            bool = ((AvatarPendantActivity)localObject2).l();
          } else {
            bool = false;
          }
          if (bool)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).f.setText(HardCodeUtil.a(2131899107));
          }
          else
          {
            i1 = ((IApolloManagerService)this.b.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.b.getCurrentUin());
            ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "openmore", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.b)).f(i1).a());
            ((AvatarPendantAdapter.ViewHolder)localObject1).f.setText(HardCodeUtil.a(2131886698));
          }
          localObject2 = paramView.findViewById(2131430900);
          if (BaseApplicationImpl.getApplication().getSharedPreferences("facechoosedata", 0).getBoolean("cmshow_avatar_red_dot", false))
          {
            ((View)localObject2).setVisibility(0);
            i1 = AIOUtils.b(12, this.a.getResources());
            int i2 = AIOUtils.b(6, this.a.getResources());
            ((AvatarPendantAdapter.ViewHolder)localObject1).g.setPadding(i1, i2, 0, 0);
          }
          i1 = ((IApolloManagerService)this.b.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.b.getCurrentUin());
          ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "cmshowavatar", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.b)).f(i1).a());
          localObject2 = paramView;
        }
      }
    }
    else
    {
      localObject2 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter
 * JD-Core Version:    0.7.0.1
 */