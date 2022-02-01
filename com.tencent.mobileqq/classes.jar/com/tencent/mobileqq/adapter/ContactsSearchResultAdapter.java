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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
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
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_b_of_type_Boolean;
  
  public ContactsSearchResultAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List<IContactSearchable> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramTextView.getContext().getResources().getDrawable(2130841838);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
      }
      ThemeUtil.setThemeFilter(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
      paramTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
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
      if ((bool2) && (!paramViewHolder.jdField_a_of_type_Boolean)) {
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
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558929, paramViewGroup, false);
      paramView = new ContactsSearchResultAdapter.ViewTag();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369387));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369506));
      paramView.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369416));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369362));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379778));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379894));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131376671);
      paramView.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131702726));
      SearchUtil.a(paramView.jdField_a_of_type_AndroidWidgetTextView);
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379769));
      paramView.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379956));
      paramView.e = ((TextView)localView.findViewById(2131369389));
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131379859);
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (ContactsSearchResultAdapter.ViewTag)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = (IContactSearchable)getItem(paramInt);
    if (localObject1 == null)
    {
      QLog.w("ContactsSearchResultAdapter", 1, "getView entity is null.");
    }
    else
    {
      Object localObject2 = ((IContactSearchable)localObject1).c();
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      boolean bool = String.valueOf(9954L).equals(((IContactSearchable)localObject1).e());
      a(paramView.jdField_a_of_type_AndroidWidgetTextView, bool);
      paramView.jdField_c_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject1).b());
      paramView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(((IContactSearchable)localObject1).b());
      if (((IContactSearchable)localObject1).c() == 4) {
        TroopBlockUtils.a(paramView, ((IContactSearchable)localObject1).e());
      }
      Object localObject3 = ((IContactSearchable)localObject1).d();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      paramView.jdField_d_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject1).a());
      paramView.jdField_a_of_type_JavaLangString = ((IContactSearchable)localObject1).e();
      paramView.jdField_a_of_type_Int = ((IContactSearchable)localObject1).c();
      if ((localObject1 instanceof ContactSearchableSearchHistory))
      {
        localObject3 = ((ContactSearchableSearchHistory)localObject1).a();
        if ((((SearchHistory)localObject3).type == 56938) || (((SearchHistory)localObject3).type == 56942))
        {
          bool = true;
          break label449;
        }
      }
      bool = false;
      label449:
      paramView.jdField_a_of_type_Boolean = bool;
      if (paramView.jdField_a_of_type_Boolean)
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842159);
        paramView.e.setVisibility(0);
        paramView.e.setText(ContactUtils.a((String)localObject2));
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int));
        paramView.e.setVisibility(8);
      }
      localObject2 = ((IContactSearchable)localObject1).a();
      if (localObject2 == null)
      {
        paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
      {
        localView.setTag(-1, Integer.valueOf(paramInt));
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null)
      {
        paramView.jdField_a_of_type_AndroidViewView.setTag(-1, Long.valueOf(((SearchHistory)((IContactSearchable)localObject1).a()).getId()));
        paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      localObject1 = localView.findViewById(2131365776);
      if (paramInt == getCount() - 1) {
        ((View)localObject1).setVisibility(8);
      } else {
        ((View)localObject1).setVisibility(0);
      }
      if (paramView.jdField_b_of_type_AndroidViewView != null) {
        if (SearchUtil.a(paramView.jdField_a_of_type_JavaLangString)) {
          paramView.jdField_b_of_type_AndroidViewView.setVisibility(0);
        } else {
          paramView.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactsSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */