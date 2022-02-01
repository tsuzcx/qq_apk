package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class ContactsSearchResultAdapter
  extends BaseSearchResultAdapter
  implements SearchAdapterInterface, AbsListView.OnScrollListener
{
  private LayoutInflater c;
  private boolean d;
  private View.OnClickListener e;
  private View.OnClickListener f;
  private Context g;
  private Drawable h;
  
  public ContactsSearchResultAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List<IContactSearchable> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    this.g = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.e = paramOnClickListener1;
    this.f = paramOnClickListener2;
    this.d = paramBoolean;
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.h == null)
      {
        this.h = paramTextView.getContext().getResources().getDrawable(2130842755);
        this.h.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
      }
      ThemeUtil.setThemeFilter(this.h, ThemeUtil.curThemeId);
      paramTextView.setCompoundDrawables(null, null, this.h, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void a()
  {
    super.a();
  }
  
  protected boolean a(BaseSearchResultAdapter.ViewHolder paramViewHolder)
  {
    boolean bool2 = super.a(paramViewHolder);
    boolean bool1 = bool2;
    if ((paramViewHolder instanceof ContactsSearchResultAdapter.ViewTag))
    {
      paramViewHolder = (ContactsSearchResultAdapter.ViewTag)paramViewHolder;
      if ((bool2) && (!paramViewHolder.m)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void c()
  {
    super.b();
  }
  
  public int getCount()
  {
    int j = super.getCount();
    int i = j;
    if (j > 5) {
      i = 5;
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      localView = this.c.inflate(2131624559, paramViewGroup, false);
      paramView = new ContactsSearchResultAdapter.ViewTag();
      paramView.c = ((ImageView)localView.findViewById(2131436420));
      paramView.d = ((ImageView)localView.findViewById(2131436590));
      paramView.f = ((ImageView)localView.findViewById(2131436452));
      paramView.e = ((ImageView)localView.findViewById(2131436381));
      paramView.g = ((TextView)localView.findViewById(2131448598));
      paramView.h = ((TextView)localView.findViewById(2131448768));
      paramView.l = localView.findViewById(2131444937);
      paramView.l.setContentDescription(HardCodeUtil.a(2131900716));
      SearchUtil.a(paramView.g);
      paramView.i = ((TextView)localView.findViewById(2131448579));
      paramView.j = ((TextView)localView.findViewById(2131448844));
      paramView.k = ((TextView)localView.findViewById(2131436422));
      paramView.n = localView.findViewById(2131448716);
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (ContactsSearchResultAdapter.ViewTag)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    IContactSearchable localIContactSearchable = (IContactSearchable)getItem(paramInt);
    if (localIContactSearchable == null)
    {
      QLog.w("ContactsSearchResultAdapter", 1, "getView entity is null.");
    }
    else
    {
      localObject1 = localIContactSearchable.c();
      paramView.g.setText((CharSequence)localObject1);
      boolean bool = String.valueOf(9954L).equals(localIContactSearchable.j());
      a(paramView.g, bool);
      paramView.i.setText(localIContactSearchable.b());
      paramView.d.setImageResource(localIContactSearchable.g());
      if (localIContactSearchable.k() == 4) {
        TroopBlockUtils.a(paramView, localIContactSearchable.j());
      }
      Object localObject2 = localIContactSearchable.d();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramView.h.setText((CharSequence)localObject2);
        paramView.h.setVisibility(0);
      }
      else
      {
        paramView.h.setVisibility(8);
      }
      paramView.j.setText(localIContactSearchable.a());
      paramView.a = localIContactSearchable.j();
      paramView.b = localIContactSearchable.k();
      if ((localIContactSearchable instanceof ContactSearchableSearchHistory))
      {
        localObject2 = ((ContactSearchableSearchHistory)localIContactSearchable).e();
        if ((((SearchHistory)localObject2).type == 56938) || (((SearchHistory)localObject2).type == 56942))
        {
          bool = true;
          break label449;
        }
      }
      bool = false;
      label449:
      paramView.m = bool;
      if (paramView.m)
      {
        paramView.c.setImageResource(2130843087);
        paramView.k.setVisibility(0);
        paramView.k.setText(ContactUtils.b((String)localObject1));
      }
      else if (paramView.b == 119)
      {
        localObject2 = BaseApplicationImpl.sApplication.getRuntime();
        localObject1 = null;
        if ((localObject2 instanceof AppInterface)) {
          localObject1 = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameMsgAvatarDrawable((AppInterface)localObject2, paramView.a);
        }
        if (localObject1 == null) {
          paramView.c.setImageBitmap(a(paramView.a, paramView.b));
        } else {
          paramView.c.setImageDrawable((Drawable)localObject1);
        }
        paramView.k.setVisibility(8);
      }
      else
      {
        paramView.c.setImageBitmap(a(paramView.a, paramView.b));
        paramView.k.setVisibility(8);
      }
      localObject1 = localIContactSearchable.i();
      if (localObject1 == null)
      {
        paramView.e.setVisibility(8);
      }
      else
      {
        paramView.e.setVisibility(0);
        paramView.e.setImageDrawable((Drawable)localObject1);
      }
      if (this.e != null)
      {
        localView.setTag(-1, Integer.valueOf(paramInt));
        localView.setOnClickListener(this.e);
      }
      if (this.f != null)
      {
        paramView.l.setTag(-1, Long.valueOf(((SearchHistory)localIContactSearchable.l()).getId()));
        paramView.l.setOnClickListener(this.f);
      }
      localObject1 = localView.findViewById(2131432033);
      if (paramInt == getCount() - 1) {
        ((View)localObject1).setVisibility(8);
      } else {
        ((View)localObject1).setVisibility(0);
      }
      if (paramView.n != null) {
        if (SearchUtil.a(paramView.a)) {
          paramView.n.setVisibility(0);
        } else {
          paramView.n.setVisibility(8);
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactsSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */