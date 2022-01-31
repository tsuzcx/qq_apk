package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
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
  
  public ContactsSearchResultAdapter(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean)
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
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramTextView.getContext().getResources().getDrawable(2130839766);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
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
    if (i > 3) {
      return 3;
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
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968824, paramViewGroup, false);
      paramViewGroup = new ContactsSearchResultAdapter.ViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363404));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363956));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363958));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363568));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363961);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setContentDescription("删除搜索历史");
      SearchUtil.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363960));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363959));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131363955));
      paramView.setTag(paramViewGroup);
    }
    IContactSearchable localIContactSearchable;
    for (;;)
    {
      localIContactSearchable = (IContactSearchable)getItem(paramInt);
      if (localIContactSearchable != null) {
        break;
      }
      QLog.w("ContactsSearchResultAdapter", 1, "getView entity is null.");
      return paramView;
      paramViewGroup = (ContactsSearchResultAdapter.ViewTag)paramView.getTag();
    }
    Object localObject1 = localIContactSearchable.c();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    if (String.valueOf(9954L).equals(localIContactSearchable.d())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, bool1);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localIContactSearchable.b());
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(localIContactSearchable.b());
      Object localObject2;
      String str;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof PhoneContactSelectActivity))
      {
        localObject2 = (PhoneContactSelectActivity)this.jdField_a_of_type_AndroidContentContext;
        str = localIContactSearchable.d();
        Object localObject3 = ((PhoneContactSelectActivity)localObject2).a;
        if (localObject3 == null) {
          break label771;
        }
        localObject3 = ((ArrayList)localObject3).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (!PhoneContactSelectActivity.a((String)((Iterator)localObject3).next(), str));
      }
      label771:
      for (int i = 1;; i = 0)
      {
        if (((((PhoneContactSelectActivity)localObject2).f != null) && (((PhoneContactSelectActivity)localObject2).f.contains(str))) || (i != 0))
        {
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131434024);
          paramViewGroup.jdField_a_of_type_JavaLangString = localIContactSearchable.d();
          paramViewGroup.jdField_a_of_type_Int = localIContactSearchable.c();
          if (!(localIContactSearchable instanceof ContactSearchableSearchHistory)) {
            break label765;
          }
          localObject2 = ((ContactSearchableSearchHistory)localIContactSearchable).a();
          bool1 = bool2;
          if (((SearchHistory)localObject2).type != 56938)
          {
            if (((SearchHistory)localObject2).type != 56942) {
              break label674;
            }
            bool1 = bool2;
          }
        }
        for (;;)
        {
          label431:
          paramViewGroup.jdField_a_of_type_Boolean = bool1;
          if (paramViewGroup.jdField_a_of_type_Boolean)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840204);
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.d.setText(ContactUtils.a((String)localObject1));
            label474:
            localObject1 = localIContactSearchable.a();
            if (localObject1 != null) {
              break label711;
            }
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            label495:
            if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
            {
              paramView.setTag(-1, Integer.valueOf(paramInt));
              paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            }
            if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null)
            {
              paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(-1, Long.valueOf(((SearchHistory)localIContactSearchable.a()).getId()));
              paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            }
            paramViewGroup = paramView.findViewById(2131363953);
            if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
              break label731;
            }
            paramView.setBackgroundResource(2130838586);
            paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492950));
          }
          for (;;)
          {
            if (paramInt != getCount() - 1) {
              break label758;
            }
            paramViewGroup.setVisibility(8);
            return paramView;
            if (((PhoneContactSelectActivity)localObject2).a(str))
            {
              paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(2131434025);
              break;
            }
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localIContactSearchable.a());
            break;
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localIContactSearchable.a());
            break;
            label674:
            bool1 = false;
            break label431;
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramViewGroup.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_Int));
            paramViewGroup.d.setVisibility(8);
            break label474;
            label711:
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
            break label495;
            label731:
            paramView.setBackgroundResource(2130838585);
            paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492949));
          }
          label758:
          paramViewGroup.setVisibility(0);
          return paramView;
          label765:
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ContactsSearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */