import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bnaj
  extends bnar
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<bnam> jdField_a_of_type_JavaUtilList;
  
  public bnaj(Context paramContext, String paramString1, String paramString2, int paramInt, @NonNull List<bnam> paramList, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramString1, paramString2, paramInt);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bnan a(int paramInt)
  {
    int i = c();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IllegalStateException("getViewType Exception, innerPos:" + paramInt + ",LineCount:" + i);
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new bnan(null);
      ((bnan)localObject1).jdField_a_of_type_Int = 1;
      return localObject1;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (bnam)((Iterator)localObject2).next();
      i += 1;
      if (i == paramInt)
      {
        localObject2 = new bnan(null);
        ((bnan)localObject2).jdField_a_of_type_Int = 2;
        ((bnan)localObject2).jdField_a_of_type_Bnam = ((bnam)localObject1);
        return localObject2;
      }
      if (!bnam.a((bnam)localObject1)) {
        break label253;
      }
      if (paramInt <= ((bnam)localObject1).a().size() + i)
      {
        localObject2 = (bnal)((bnam)localObject1).a().get(paramInt - i - 1);
        bnan localbnan = new bnan(null);
        localbnan.jdField_a_of_type_Int = 3;
        localbnan.jdField_a_of_type_Bnam = ((bnam)localObject1);
        localbnan.jdField_a_of_type_Bnal = ((bnal)localObject2);
        return localbnan;
      }
      i = ((bnam)localObject1).a().size() + i;
    }
    label253:
    for (;;)
    {
      break;
      throw new IllegalStateException("can not find item with innerPos:" + paramInt);
    }
  }
  
  private void a(View paramView)
  {
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131364024);
    Object localObject = (ImageView)paramView.findViewById(2131364034);
    TextView localTextView = (TextView)paramView.findViewById(2131364031);
    paramView = paramView.findViewById(2131364025);
    localTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      ((ImageView)localObject).setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (!this.b) {
        break label138;
      }
      localCheckBox.setChecked(true);
    }
    for (((RelativeLayout.LayoutParams)localObject).leftMargin = xsm.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);; ((RelativeLayout.LayoutParams)localObject).leftMargin = 0)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = -2170912;
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        i = -16444373;
      }
      paramView.setBackgroundColor(i);
      return;
      ((ImageView)localObject).setVisibility(4);
      break;
      label138:
      localCheckBox.setChecked(false);
    }
  }
  
  private void a(View paramView, bnam parambnam)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131367351);
    TextView localTextView2 = (TextView)paramView.findViewById(2131367353);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131367324);
    paramView = (CheckBox)paramView.findViewById(2131367326);
    localTextView1.setText(parambnam.a.group_name);
    localTextView2.setText(String.format("(%s/%s)", new Object[] { Integer.valueOf(parambnam.a()), Integer.valueOf(parambnam.b()) }));
    if (parambnam.b() == 0)
    {
      paramView.setVisibility(4);
      if (!parambnam.a()) {
        break label146;
      }
      paramView.setChecked(true);
      label111:
      if (!bnam.a(parambnam)) {
        break label154;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramView.setOnClickListener(new bnak(this, parambnam));
      return;
      paramView.setVisibility(0);
      break;
      label146:
      paramView.setChecked(false);
      break label111;
      label154:
      localCheckBox.setChecked(false);
    }
  }
  
  private void a(View paramView, bnam parambnam, bnal parambnal)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131366914);
    Object localObject1 = (TextView)paramView.findViewById(2131366934);
    Object localObject2 = (CheckBox)paramView.findViewById(2131366897);
    paramView = paramView.findViewById(2131366896);
    ((TextView)localObject1).setText(parambnal.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
    if (parambnal.jdField_a_of_type_Boolean)
    {
      ((CheckBox)localObject2).setChecked(true);
      localObject1 = bdhj.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label226;
      }
      localObject2 = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, parambnal.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label207;
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      paramView.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilList.indexOf(parambnam) == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        parambnam = parambnam.a();
        if (parambnam.indexOf(parambnal) == parambnam.size() - 1)
        {
          int i = -2170912;
          QQStoryContext.a();
          if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
            i = -16444373;
          }
          paramView.setBackgroundColor(i);
          paramView.setVisibility(0);
        }
      }
      return;
      ((CheckBox)localObject2).setChecked(false);
      break;
      label207:
      wxe.e("Q.qqstory.publish.edit.ComplexPart", "FaceDrawable is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
      continue;
      label226:
      wxe.e("Q.qqstory.publish.edit.ComplexPart", "QQAppInterface is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void a(bnan parambnan)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean) {
      if (!this.b) {
        bool = true;
      }
    }
    for (this.b = bool;; this.b = true)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      bool = false;
      break;
    }
  }
  
  private void b(bnan parambnan)
  {
    parambnan.jdField_a_of_type_Bnam.a();
  }
  
  private int c()
  {
    if (!this.b) {
      return 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      bnam localbnam = (bnam)localIterator.next();
      List localList = localbnam.a();
      i += 1;
      if (!bnam.a(localbnam)) {
        break label72;
      }
      i = localList.size() + i;
    }
    label72:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void c(bnan parambnan)
  {
    parambnan.jdField_a_of_type_Bnam.a(parambnan.jdField_a_of_type_Bnal);
  }
  
  public int a()
  {
    return c();
  }
  
  public int a(int paramInt)
  {
    return a(paramInt).jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt).jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 1: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561521, null);
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561523, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561522, null);
  }
  
  @NonNull
  public List<bnal> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((bnam)localIterator.next()).b());
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    bnan localbnan = a(paramInt);
    switch (localbnan.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(localbnan);
      return;
    case 2: 
      b(localbnan);
      return;
    }
    c(localbnan);
  }
  
  public void a(int paramInt, View paramView)
  {
    bnan localbnan = a(paramInt);
    switch (localbnan.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 2: 
      a(paramView, localbnan.jdField_a_of_type_Bnam);
      return;
    }
    a(paramView, localbnan.jdField_a_of_type_Bnam, localbnan.jdField_a_of_type_Bnal);
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      bnam localbnam = (bnam)localIterator1.next();
      Iterator localIterator2 = localbnam.a().iterator();
      while (localIterator2.hasNext())
      {
        bnal localbnal = (bnal)localIterator2.next();
        if (paramList.contains(localbnal.a())) {
          localbnam.b(localbnal);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnaj
 * JD-Core Version:    0.7.0.1
 */