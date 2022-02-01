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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class axtr
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private axua jdField_a_of_type_Axua;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<AutoReplyText> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public axtr(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable)
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131558424, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131365073);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
    if (getItemViewType(paramInt) == 0)
    {
      localMarginLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298440);
      localMarginLayoutParams.bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298437);
      paramViewGroup.setText(2131690214);
      paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131690214));
    }
    for (;;)
    {
      paramViewGroup.setLayoutParams(localMarginLayoutParams);
      return paramLayoutInflater;
      localMarginLayoutParams.bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298440);
      localMarginLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298437);
      paramViewGroup.setText(2131690216);
      paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131690216));
    }
  }
  
  private axub a(LayoutInflater paramLayoutInflater, int paramInt, View paramView, ViewGroup paramViewGroup, AutoReplyText paramAutoReplyText)
  {
    if ((paramView == null) || (paramView.getTag() == null) || (paramView.getVisibility() == 8))
    {
      paramView = paramLayoutInflater.inflate(2131558420, paramViewGroup, false);
      paramLayoutInflater = paramView.findViewById(2131365660);
      if (ThemeUtil.isDefaultTheme())
      {
        paramInt = 0;
        paramLayoutInflater.setVisibility(paramInt);
        if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))) {
          paramView.findViewById(2131376285).setBackgroundResource(2130839485);
        }
        paramView.findViewById(2131369842).setPadding(0, 0, 0, 0);
        paramView.findViewById(2131376469).setVisibility(8);
        paramViewGroup = (TextView)paramView.findViewById(2131369869);
        paramViewGroup.setEditableFactory(new axtt(this, paramViewGroup));
        paramLayoutInflater = new axub(null);
        paramLayoutInflater.jdField_a_of_type_AndroidViewView = paramView;
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376441));
        paramLayoutInflater.b = paramView.findViewById(2131365797);
        paramLayoutInflater.c = paramView.findViewById(2131365798);
        paramLayoutInflater.d = paramView.findViewById(2131378397);
        paramLayoutInflater.jdField_a_of_type_AndroidViewView.setTag(paramLayoutInflater);
        label200:
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new axtu(this, paramAutoReplyText));
        paramLayoutInflater.b.setOnClickListener(new axtv(this, paramAutoReplyText));
        boolean bool = paramAutoReplyText.getExtra().getBoolean("AutoReplyAdapter:in_use", false);
        if (paramAutoReplyText.getTextId() != 2147483647) {
          break label558;
        }
        paramInt = 1;
        label259:
        paramView = AutoReplyText.trimRawString(paramAutoReplyText.getRawText(), true);
        int i = (int)(paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.getTextSize() / paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.getPaint().density);
        paramView = TextUtils.subQQTextString(paramView, paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 3, i, ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(67.0F), true);
        if (QLog.isColorLevel()) {
          QLog.d("AutoReplyAdapter", 2, "Truncate subText: " + paramView);
        }
        paramViewGroup = new QQText(paramView, 3, i);
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramViewGroup);
        paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(new QQText(amtj.a(2131700008) + paramView, 3, i));
        paramLayoutInflater.c.setOnClickListener(new axtw(this, paramAutoReplyText, bool));
        paramLayoutInflater.jdField_a_of_type_AndroidViewView.findViewById(2131376285).setOnClickListener(new axtx(this, paramAutoReplyText));
        paramViewGroup = paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView;
        if (!bool) {
          break label563;
        }
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        label476:
        paramViewGroup.setImageDrawable(paramView);
        paramView = paramLayoutInflater.jdField_a_of_type_AndroidViewView;
        if (paramInt == 0) {
          break label568;
        }
      }
    }
    label558:
    label563:
    label568:
    for (paramInt = 0;; paramInt = ScreenUtil.dip2px(200.0F))
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
      paramLayoutInflater = (axub)paramView.getTag();
      paramLayoutInflater.jdField_a_of_type_AndroidViewView = paramView;
      break label200;
      paramInt = 0;
      break label259;
      paramView = null;
      break label476;
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
    while ((paramView == null) || (!a())) {
      return;
    }
    axty localaxty = new axty(this, paramView, paramView.getMeasuredHeight());
    localaxty.setAnimationListener(new axtz(this, paramInt));
    localaxty.setDuration(150L);
    paramView.startAnimation(localaxty);
  }
  
  private View b(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558418, paramViewGroup, false);
    paramLayoutInflater.setOnClickListener(new axts(this));
    return paramLayoutInflater;
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 2147483647) {
      break label6;
    }
    label6:
    while (!a()) {
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
        if (this.jdField_a_of_type_Axua != null)
        {
          axua localaxua = this.jdField_a_of_type_Axua;
          if (localAutoReplyText.getTextId() == 2147483647)
          {
            bool = true;
            localaxua.a(localAutoReplyText, bool);
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
  
  public ArrayList<AutoReplyText> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (a())
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
      if (this.jdField_a_of_type_Axua != null) {
        this.jdField_a_of_type_Axua.a(localObject2, localObject1);
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(@Nullable axua paramaxua)
  {
    this.jdField_a_of_type_Axua = paramaxua;
  }
  
  public void a(@Nullable AutoReplyText paramAutoReplyText)
  {
    if ((!a()) || (paramAutoReplyText == null) || (paramAutoReplyText.getTextId() == 2147483647)) {
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
      if (this.jdField_a_of_type_Axua != null) {
        this.jdField_a_of_type_Axua.a(paramAutoReplyText);
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
    if (a())
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
    if (a())
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public boolean a()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public boolean b()
  {
    return this.b;
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
    if ((getItemViewType(paramInt) == 0) || (getItemViewType(paramInt) == 4)) {
      paramView = a(localLayoutInflater, paramInt, paramViewGroup);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (getItemViewType(paramInt) == 3)
      {
        paramView = b(localLayoutInflater, paramInt, paramViewGroup);
      }
      else
      {
        AutoReplyText localAutoReplyText = (AutoReplyText)getItem(paramInt);
        if (localAutoReplyText != null) {
          paramView = a(localLayoutInflater, paramInt, paramView, paramViewGroup, localAutoReplyText).jdField_a_of_type_AndroidViewView;
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return (paramInt != 0) && (paramInt != getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtr
 * JD-Core Version:    0.7.0.1
 */