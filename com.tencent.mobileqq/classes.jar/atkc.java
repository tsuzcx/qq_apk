import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class atkc
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private atkl jdField_a_of_type_Atkl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<AutoReplyText> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public atkc(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
  }
  
  private View a(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131492885, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131299132);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
    if (getItemViewType(paramInt) == 0)
    {
      localMarginLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167163);
      localMarginLayoutParams.bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167160);
      paramViewGroup.setText(2131624739);
      paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131624739));
    }
    for (;;)
    {
      paramViewGroup.setLayoutParams(localMarginLayoutParams);
      return paramLayoutInflater;
      localMarginLayoutParams.bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167163);
      localMarginLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167160);
      paramViewGroup.setText(2131624745);
      paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131624745));
    }
  }
  
  private atkm a(LayoutInflater paramLayoutInflater, int paramInt, View paramView, ViewGroup paramViewGroup, AutoReplyText paramAutoReplyText)
  {
    if ((paramView == null) || (paramView.getTag() == null) || (paramView.getVisibility() == 8))
    {
      paramView = paramLayoutInflater.inflate(2131492882, paramViewGroup, false);
      paramLayoutInflater = paramView.findViewById(2131299696);
      if (ThemeUtil.isDefaultTheme())
      {
        paramInt = 0;
        paramLayoutInflater.setVisibility(paramInt);
        if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))) {
          paramView.findViewById(2131309382).setBackgroundResource(2130839154);
        }
        paramView.findViewById(2131303445).setPadding(0, 0, 0, 0);
        paramView.findViewById(2131309552).setVisibility(8);
        paramViewGroup = (TextView)paramView.findViewById(2131303466);
        paramViewGroup.setEditableFactory(new atke(this, paramViewGroup));
        paramLayoutInflater = new atkm(null);
        paramLayoutInflater.jdField_a_of_type_AndroidViewView = paramView;
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131309529));
        paramLayoutInflater.b = paramView.findViewById(2131299821);
        paramLayoutInflater.c = paramView.findViewById(2131299822);
        paramLayoutInflater.d = paramView.findViewById(2131311249);
        paramLayoutInflater.jdField_a_of_type_AndroidViewView.setTag(paramLayoutInflater);
        label200:
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new atkf(this, paramAutoReplyText));
        paramLayoutInflater.b.setOnClickListener(new atkg(this, paramAutoReplyText));
        boolean bool = paramAutoReplyText.getExtra().getBoolean("AutoReplyAdapter:in_use", false);
        if (paramAutoReplyText.getTextId() != 2147483647) {
          break label557;
        }
        paramInt = 1;
        label259:
        paramView = AutoReplyText.trimRawString(paramAutoReplyText.getRawText(), true);
        int i = (int)(paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.getTextSize() / paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.getPaint().density);
        paramView = axku.a(paramView, paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 3, i, awmc.a - awmc.a(67.0F), true);
        if (QLog.isColorLevel()) {
          QLog.d("AutoReplyAdapter", 2, "Truncate subText: " + paramView);
        }
        paramViewGroup = new axkd(paramView, 3, i);
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramViewGroup);
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(new axkd(ajjy.a(2131635065) + paramView, 3, i));
        paramLayoutInflater.c.setOnClickListener(new atkh(this, paramAutoReplyText, bool));
        paramLayoutInflater.jdField_a_of_type_AndroidViewView.findViewById(2131309382).setOnClickListener(new atki(this, paramAutoReplyText));
        paramViewGroup = paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView;
        if (!bool) {
          break label562;
        }
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        label475:
        paramViewGroup.setImageDrawable(paramView);
        paramView = paramLayoutInflater.jdField_a_of_type_AndroidViewView;
        if (paramInt == 0) {
          break label567;
        }
      }
    }
    label557:
    label562:
    label567:
    for (paramInt = 0;; paramInt = awmc.a(200.0F))
    {
      paramView.setTag(-3, Integer.valueOf(paramInt));
      paramView = (RelativeLayout.LayoutParams)paramLayoutInflater.d.getLayoutParams();
      if (paramView.leftMargin > 0)
      {
        paramView.leftMargin = 0;
        paramLayoutInflater.d.setLayoutParams(paramView);
      }
      return paramLayoutInflater;
      paramInt = 8;
      break;
      paramLayoutInflater = (atkm)paramView.getTag();
      paramLayoutInflater.jdField_a_of_type_AndroidViewView = paramView;
      break label200;
      paramInt = 0;
      break label259;
      paramView = null;
      break label475;
    }
  }
  
  private void a()
  {
    HashSet localHashSet = new HashSet(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localHashSet);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramInt == 2147483647) {}
    while ((paramView == null) || (!b())) {
      return;
    }
    atkj localatkj = new atkj(this, paramView, paramView.getMeasuredHeight());
    localatkj.setAnimationListener(new atkk(this, paramInt));
    localatkj.setDuration(150L);
    paramView.startAnimation(localatkj);
  }
  
  private View b(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131492880, paramViewGroup, false);
    paramLayoutInflater.setOnClickListener(new atkd(this));
    return paramLayoutInflater;
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 2147483647) {
      break label6;
    }
    label6:
    while (!b()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int j = 0;
    int k = 0;
    int i = 0;
    label30:
    AutoReplyText localAutoReplyText;
    boolean bool;
    label110:
    int m;
    if (((Iterator)localObject).hasNext())
    {
      localAutoReplyText = (AutoReplyText)((Iterator)localObject).next();
      if (localAutoReplyText.getTextId() == paramInt)
      {
        if (localAutoReplyText.getExtra().getBoolean("AutoReplyAdapter:in_use", false)) {
          i = 1;
        }
        ((Iterator)localObject).remove();
        if (this.jdField_a_of_type_Atkl != null)
        {
          atkl localatkl = this.jdField_a_of_type_Atkl;
          if (localAutoReplyText.getTextId() == 2147483647)
          {
            bool = true;
            localatkl.a(localAutoReplyText, bool);
          }
        }
        else
        {
          m = j;
          j = 1;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      m = k;
      k = j;
      j = i;
      i = m;
      break label30;
      bool = false;
      break label110;
      if (localAutoReplyText.mTextId != 2147483647)
      {
        localAutoReplyText.mTextId = j;
        m = j + 1;
        j = k;
        k = i;
        i = m;
        continue;
        if ((i != 0) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
        {
          localObject = (AutoReplyText)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localObject != null) {
            a(((AutoReplyText)localObject).getTextId());
          }
        }
        if (k == 0) {
          break;
        }
        this.b = true;
        notifyDataSetChanged();
        return;
      }
      m = i;
      i = j;
      j = k;
      k = m;
    }
  }
  
  private boolean b()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public ArrayList<AutoReplyText> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (b())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      localObject1 = null;
      if (localIterator.hasNext())
      {
        AutoReplyText localAutoReplyText = (AutoReplyText)localIterator.next();
        Object localObject3 = localObject1;
        Bundle localBundle;
        if (localAutoReplyText != null)
        {
          localBundle = localAutoReplyText.getExtra();
          bool = localBundle.getBoolean("AutoReplyAdapter:in_use", false);
          if (bool) {
            localObject1 = localAutoReplyText;
          }
          if (localAutoReplyText.getTextId() == paramInt)
          {
            localObject3 = localObject1;
            if (bool) {
              break label128;
            }
            localBundle.putBoolean("AutoReplyAdapter:in_use", true);
            localObject2 = localObject1;
            localObject1 = localAutoReplyText;
          }
        }
        for (;;)
        {
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          localBundle.putBoolean("AutoReplyAdapter:in_use", false);
          localObject3 = localObject1;
          label128:
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      if (localObject2 != null) {
        if (localObject1 == null) {
          break label178;
        }
      }
    }
    label178:
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      if (this.jdField_a_of_type_Atkl != null) {
        this.jdField_a_of_type_Atkl.a(localObject2, localObject1);
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(@Nullable atkl paramatkl)
  {
    this.jdField_a_of_type_Atkl = paramatkl;
  }
  
  public void a(@Nullable AutoReplyText paramAutoReplyText)
  {
    if ((!b()) || (paramAutoReplyText == null) || (paramAutoReplyText.getTextId() == 2147483647)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject = null;
    if (localIterator.hasNext())
    {
      AutoReplyText localAutoReplyText = (AutoReplyText)localIterator.next();
      if ((localAutoReplyText == null) || (localAutoReplyText.getTextId() != paramAutoReplyText.getTextId())) {
        break label157;
      }
      localIterator.remove();
      localObject = localAutoReplyText;
    }
    label157:
    for (;;)
    {
      break;
      paramAutoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", false);
      if ((localObject != null) && (localObject.getExtra().getBoolean("AutoReplyAdapter:in_use", false))) {
        paramAutoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", true);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAutoReplyText);
      if (this.jdField_a_of_type_Atkl != null) {
        this.jdField_a_of_type_Atkl.a(paramAutoReplyText);
      }
      a();
      this.b = true;
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(List<AutoReplyText> paramList)
  {
    int i;
    if (b())
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((paramList == null) || (paramList.isEmpty())) {
        break label108;
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramList = paramList.iterator();
      i = 0;
      while (paramList.hasNext())
      {
        AutoReplyText localAutoReplyText = (AutoReplyText)paramList.next();
        if (localAutoReplyText.isChecked()) {
          i = localAutoReplyText.mTextId;
        }
        localAutoReplyText.getExtra().putBoolean("AutoReplyAdapter:in_use", false);
      }
      a();
    }
    for (;;)
    {
      notifyDataSetChanged();
      a(i);
      this.b = false;
      return;
      label108:
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (b())
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilArrayList.size() + 1 + 1 + 1;
    }
    return 0;
  }
  
  @Nullable
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = 1;
    int i;
    if ((paramInt >= 0) && (paramInt < 1)) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() + 1) {
          return 3;
        }
        if (paramInt < 1) {
          break;
        }
        i = j;
      } while (paramInt <= this.jdField_a_of_type_JavaUtilArrayList.size());
      i = j;
    } while (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size() + 1 + 1);
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    View localView;
    if ((getItemViewType(paramInt) == 0) || (getItemViewType(paramInt) == 4)) {
      localView = a(localLayoutInflater, paramInt, paramViewGroup);
    }
    AutoReplyText localAutoReplyText;
    do
    {
      return localView;
      if (getItemViewType(paramInt) == 3) {
        return b(localLayoutInflater, paramInt, paramViewGroup);
      }
      localAutoReplyText = (AutoReplyText)getItem(paramInt);
      localView = paramView;
    } while (localAutoReplyText == null);
    return a(localLayoutInflater, paramInt, paramView, paramViewGroup, localAutoReplyText).jdField_a_of_type_AndroidViewView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return (paramInt != 0) && (paramInt != getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atkc
 * JD-Core Version:    0.7.0.1
 */