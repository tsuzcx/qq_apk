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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.mobileqq.utils.ContactUtils;
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
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramTextView.getContext().getResources().getDrawable(2130841947);
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
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
  
  public void c()
  {
    super.b();
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 5) {
      return 5;
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    ContactsSearchResultAdapter.ViewTag localViewTag;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559035, paramViewGroup, false);
      localViewTag = new ContactsSearchResultAdapter.ViewTag();
      localViewTag.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369690));
      localViewTag.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369822));
      localViewTag.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369718));
      localViewTag.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369661));
      localViewTag.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380475));
      localViewTag.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380617));
      localViewTag.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377211);
      localViewTag.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131702594));
      SearchUtil.a(localViewTag.jdField_a_of_type_AndroidWidgetTextView);
      localViewTag.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380457));
      localViewTag.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380682));
      localViewTag.e = ((TextView)paramView.findViewById(2131369692));
      localViewTag.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380575);
      paramView.setTag(localViewTag);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (IContactSearchable)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      QLog.w("ContactsSearchResultAdapter", 1, "getView entity is null.");
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localViewTag = (ContactsSearchResultAdapter.ViewTag)paramView.getTag();
    }
    Object localObject2 = ((IContactSearchable)localObject1).c();
    localViewTag.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    if (String.valueOf(9954L).equals(((IContactSearchable)localObject1).e())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(localViewTag.jdField_a_of_type_AndroidWidgetTextView, bool1);
      localViewTag.jdField_c_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject1).b());
      localViewTag.jdField_b_of_type_AndroidWidgetImageView.setImageResource(((IContactSearchable)localObject1).b());
      if (((IContactSearchable)localObject1).c() == 4) {
        TroopBlockUtils.a(localViewTag, ((IContactSearchable)localObject1).e());
      }
      Object localObject3 = ((IContactSearchable)localObject1).d();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localViewTag.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        localViewTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        label381:
        localViewTag.jdField_d_of_type_AndroidWidgetTextView.setText(((IContactSearchable)localObject1).a());
        localViewTag.jdField_a_of_type_JavaLangString = ((IContactSearchable)localObject1).e();
        localViewTag.jdField_a_of_type_Int = ((IContactSearchable)localObject1).c();
        if (!(localObject1 instanceof ContactSearchableSearchHistory)) {
          break label753;
        }
        localObject3 = ((ContactSearchableSearchHistory)localObject1).a();
        bool1 = bool2;
        if (((SearchHistory)localObject3).type != 56938)
        {
          if (((SearchHistory)localObject3).type != 56942) {
            break label668;
          }
          bool1 = bool2;
        }
      }
      for (;;)
      {
        label462:
        localViewTag.jdField_a_of_type_Boolean = bool1;
        if (localViewTag.jdField_a_of_type_Boolean)
        {
          localViewTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842261);
          localViewTag.e.setVisibility(0);
          localViewTag.e.setText(ContactUtils.a((String)localObject2));
          label510:
          localObject2 = ((IContactSearchable)localObject1).a();
          if (localObject2 != null) {
            break label709;
          }
          localViewTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          label532:
          if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
          {
            paramView.setTag(-1, Integer.valueOf(paramInt));
            paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null)
          {
            localViewTag.jdField_a_of_type_AndroidViewView.setTag(-1, Long.valueOf(((SearchHistory)((IContactSearchable)localObject1).a()).getId()));
            localViewTag.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          }
          localObject1 = paramView.findViewById(2131365939);
          if (paramInt != getCount() - 1) {
            break label731;
          }
          ((View)localObject1).setVisibility(8);
          label624:
          if (localViewTag.jdField_b_of_type_AndroidViewView != null)
          {
            if (!SearchUtil.a(localViewTag.jdField_a_of_type_JavaLangString)) {
              break label740;
            }
            localViewTag.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
        }
        for (;;)
        {
          break;
          localViewTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label381;
          label668:
          bool1 = false;
          break label462;
          localViewTag.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(localViewTag.jdField_a_of_type_JavaLangString, localViewTag.jdField_a_of_type_Int));
          localViewTag.e.setVisibility(8);
          break label510;
          label709:
          localViewTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localViewTag.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          break label532;
          label731:
          ((View)localObject1).setVisibility(0);
          break label624;
          label740:
          localViewTag.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        label753:
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactsSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */